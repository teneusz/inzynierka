package pl.teneusz.dzienniksnow.userservice.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
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

    @RestResource(path = "/by-dates")
    List<UserEntity> findUserEntitiesByBirthDateBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @RestResource(path = "/by-all")
    List<UserEntity> findUserEntitiesByBirthDateBetweenAndGender(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("gender") UserEntity.Gender gender);

    @RestResource(path="/by-gender")
    List<UserEntity> findUserEntitiesByGender(@Param("gender") UserEntity.Gender gender);

}
