package pl.teneusz.dzienniksnow.userservice.user;

import org.springframework.data.rest.core.config.Projection;
import pl.teneusz.dzienniksnow.userservice.user.entity.UserEntity;

@Projection(name = "user", types = UserEntity.class)
public interface UserProjection {

    Long getId();

    String getNickname();

    UserEntity.Gender getGender();


}
