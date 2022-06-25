package com.example.gira_project.service;

import com.example.gira_project.model.Classification;
import com.example.gira_project.model.Task;
import com.example.gira_project.model.User;
import com.example.gira_project.model.dto.TaskDTO;
import com.example.gira_project.model.enums.ClassificationNameEnum;
import com.example.gira_project.model.enums.ProgressNameEnum;
import com.example.gira_project.repository.ClassificationRepository;
import com.example.gira_project.repository.TaskRepository;
import com.example.gira_project.repository.UserRepository;
import com.example.gira_project.session.LoggedUser;
import com.example.gira_project.view.TaskViewModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final ClassificationRepository classificationRepository;
    private final LoggedUser loggedUser;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository,
                       ClassificationRepository classificationRepository,
                       LoggedUser loggedUser,
                       UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.classificationRepository = classificationRepository;
        this.loggedUser = loggedUser;
        this.userRepository = userRepository;
    }

    public boolean addTask(TaskDTO taskDTO) {

        Optional<Task> byName = this.taskRepository.findByName(taskDTO.getName());

        if (byName.isPresent()) {
            return false;
        }

        ClassificationNameEnum type = switch (taskDTO.getClassification()) {
            case "BUG" -> ClassificationNameEnum.BUG;
            case "FEATURE" -> ClassificationNameEnum.FEATURE;
            case "SUPPORT" -> ClassificationNameEnum.SUPPORT;
            case "OTHER" -> ClassificationNameEnum.OTHER;
            default -> ClassificationNameEnum.BUG;
        };

        Classification classification = this.classificationRepository.findByName(type);
        Optional<User> owner = this.userRepository.findById(this.loggedUser.getId());

        Task task = new Task();

        task.setName(taskDTO.getName());
        task.setDescription(taskDTO.getDescription());
        task.setClassification(classification);
        task.setDueDate(taskDTO.getDueDate());
        task.setProgress(ProgressNameEnum.OPEN);
        task.setUser(owner.get());

        this.taskRepository.save(task);

        return true;
    }

    public List<TaskViewModel> getAllTasks() {
        return taskRepository.findAll()
                .stream().map(task -> {
                    TaskViewModel taskViewModel = new TaskViewModel();
                    taskViewModel.setId(task.getId());
                    taskViewModel.setName(task.getName());
                    taskViewModel.setUser(task.getUser().getUsername());
                    taskViewModel.setClassification(task.getClassification().getName().name());
                    taskViewModel.setDueDate(task.getDueDate());
                    taskViewModel.setProgress(task.getProgress().name());

                    return taskViewModel;
                }).collect(Collectors.toList());

    }

    public void changeById(Long id) {

        Optional<Task> taskOptional = this.taskRepository.findById(id);

        Task task = taskOptional.get();

        ProgressNameEnum progressNameEnum = task.getProgress();

        if (progressNameEnum.name().equals("OPEN")) {
            task.setProgress(ProgressNameEnum.IN_PROGRESS);
            this.taskRepository.save(task);
        } else if (progressNameEnum.name().equals("IN_PROGRESS")) {
            task.setProgress(ProgressNameEnum.COMPLETED);
            this.taskRepository.save(task);
        } else if (progressNameEnum.name().equals("COMPLETED")) {
            this.taskRepository.delete(task);
        }
    }
}
