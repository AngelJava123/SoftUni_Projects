package com.example.final_project.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
public class TrainingPlansControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testTrainingPlansPageShown() throws Exception {
        mockMvc.perform(get("/training-plans")).
                andExpect(status().isOk()).
                andExpect(view().name("/training-plans"));
    }
}
