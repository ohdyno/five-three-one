package me.xingzhou.fivethreeone;

import me.xingzhou.fivethreeone.entity.User;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SessionAPITests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("See the session history of an user that exists but without session history.")
    void emptySessionHistory() {
        final User user = userRepository.save(new User());
        final Long id = user.getId();
        final ResponseEntity<JSONObject> responseEntity = getUserSessions(id, JSONObject.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    private <T> ResponseEntity<T> getUserSessions(Long id, Class<T> responseType) {
        URI url = URI.create("/users/" + id + "/sessions");
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        final HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
        return restTemplate.exchange(url, HttpMethod.GET, requestEntity, responseType);
    }

    @Test
    @DisplayName("See the session history of an user that does not exist.")
    void sessionHistoryWithNonExistentUser() {
        Long id = 0L;
        final ResponseEntity<JSONObject> responseEntity = getUserSessions(id, JSONObject.class);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }
}
