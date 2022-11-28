package me.xingzhou.fivethreeone;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SessionAPITests {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("See the session history of an user.")
    void sessionHistory() throws Exception {
        String id = "someId";
        mvc.perform(get("/users/" + id + "/sessions"))
                .andExpect(status().isOk());
    }

}
