package pl.teneusz.dzienniksnow.userservice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import pl.teneusz.dzienniksnow.userservice.user.entity.UserEntity;

import java.util.List;

/**
 * Created by Tenek on 17.07.2017.
 */
@Component
class UserFacade {

    private final UserRepository repository;

    @Autowired
    UserFacade(UserRepository repository) {
        this.repository = repository;
    }

    List<UserEntity> findAll() {
        return repository.findAll();
    }
}
