package com.example.battleships.service;

import com.example.battleships.model.Category;
import com.example.battleships.model.Ship;
import com.example.battleships.model.User;
import com.example.battleships.model.dto.CreateShipDTO;
import com.example.battleships.model.enums.ShipType;
import com.example.battleships.repository.CategoryRepository;
import com.example.battleships.repository.ShipRepository;
import com.example.battleships.repository.UserRepository;
import com.example.battleships.session.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShipService {

    private final ShipRepository shipRepository;
    private final CategoryRepository categoryRepository;
    private final LoggedUser loggedUser;
    private final UserRepository userRepository;

    public ShipService(ShipRepository shipRepository,
                       CategoryRepository categoryRepository,
                       LoggedUser loggedUser,
                       UserRepository userRepository) {
        this.shipRepository = shipRepository;
        this.categoryRepository = categoryRepository;
        this.loggedUser = loggedUser;
        this.userRepository = userRepository;
    }

    public boolean create(CreateShipDTO createShipDTO) {

        Optional<Ship> byName = this.shipRepository.findByName(createShipDTO.getName());

        if (byName.isPresent()) {
            return false;
        }

        ShipType type = switch (createShipDTO.getCategory()) {
            case 0 -> ShipType.BATTLE;
            case 1 -> ShipType.CARGO;
            case 2 -> ShipType.PATROL;
            default -> ShipType.BATTLE;
        };

        Category category = this.categoryRepository.findByName(type);
        Optional<User> owner = this.userRepository.findById(this.loggedUser.getId());


        Ship ship = new Ship();

        ship.setName(createShipDTO.getName());
        ship.setPower(createShipDTO.getPower());
        ship.setHealth(createShipDTO.getHealth());
        ship.setName(createShipDTO.getName());
        ship.setCreated(createShipDTO.getCreated());
        ship.setCategory(category);
        ship.setUser(owner.get());

        this.shipRepository.save(ship);

        return true;
    }

    public List<Ship> getAllShipsOwnedByCurrentUser() {

        Optional<User> owner = this.userRepository.findById(this.loggedUser.getId());

        return new ArrayList<>(owner.get().getShips());
    }

    public List<Ship> getAllShipsFromOtherUsers() {

        return this.shipRepository.findByUserIdNot(this.loggedUser.getId());
    }

    public List<String> getAllShips() {

        List<String> sorted = new ArrayList<>();

        List<Ship> all = this.shipRepository.findAll();

        for (Ship ship : all) {
            sorted.add(ship.toString());
        }

        return sorted;
    }
}
