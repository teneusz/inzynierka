package pl.teneusz.dzienniksnow.userservice.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import pl.teneusz.dzienniksnow.userservice.user.entity.UserEntity;

import java.sql.Date;
import java.util.List;

/**
 * Created by Tenek on 17.07.2017.
 */
@RepositoryRestResource(path = "/user", excerptProjection = UserProjection.class, collectionResourceRel = "users")
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @RestResource(path = "/by-date")
    List<UserEntity> findUserEntitiesByBirthDateBetween(Date startDate, Date endDate);

    @RestResource(path = "/by-all")
    List<UserEntity> findUserEntitiesByBirthDateBetweenAndGender(Date startDate, Date endDate, UserEntity.Gender gender);

    List<UserEntity> findUserEntitiesByBirthDateBefore(Date date);

    List<UserEntity> findUserEntitiesByBirthDateBeforeAndGender(Date date, UserEntity.Gender gender);

    List<UserEntity> findUserEntitiesByBirthDateAfter(Date date);

    List<UserEntity> findUserEntitiesByBirthDateAfterAndGender(Date date, UserEntity.Gender gender);

    List<UserEntity> findUserEntitiesByGender(UserEntity.Gender gender);

}
