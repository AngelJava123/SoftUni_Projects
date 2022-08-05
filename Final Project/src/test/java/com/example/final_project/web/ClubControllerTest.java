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
public class ClubControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testClubPageShown() throws Exception {
        mockMvc.perform(get("/clubs")).
                andExpect(status().isOk()).
                andExpect(view().name("/clubs"));
    }
}
