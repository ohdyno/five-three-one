package me.xingzhou.fivethreeone;

import me.xingzhou.fivethreeone.entity.User;
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

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("See the session history of an user that exists.")
    void sessionHistory() throws Exception {
        final User user = userRepository.save(new User());
        mvc.perform(get("/users/" + user.getId() + "/sessions"))
                .andExpect(status().isOk());
    }

}
