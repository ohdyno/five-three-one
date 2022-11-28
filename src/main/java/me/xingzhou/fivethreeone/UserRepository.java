package me.xingzhou.fivethreeone;

import me.xingzhou.fivethreeone.entity.User;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User, Long> {
    User save(User user);
}
