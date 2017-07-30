package pl.teneusz.dzienniksnow.userservice.user;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.teneusz.dzienniksnow.userservice.user.entity.UserEntity;


import java.sql.Date;
import java.util.List;

//@RestController
//@RequestMapping("/")
class UserController {

    private final UserRepository repository;

    @Autowired
    UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = {"", "/"})
    public List<UserEntity> getAll(@RequestParam(value = "startDate", required = false) Date startDate, @RequestParam(value = "endDate", required = false) Date endDate, @RequestParam(name = "gender", required = false) String gender) {

        List<UserEntity> result;
        boolean startDateNotNull = startDate != null;
        boolean endDateNotNull = endDate != null;
        boolean genderIsNotEmpty = StringUtils.isNotEmpty(gender);
        if (startDateNotNull && endDateNotNull && genderIsNotEmpty) {
            result = repository.findUserEntitiesByBirthDateBetweenAndGender(startDate, endDate, UserEntity.Gender.valueOfEnum(gender));
        } else if (startDateNotNull && endDateNotNull) {
            result = repository.findUserEntitiesByBirthDateBetween(startDate, endDate);
        } else if (startDateNotNull && genderIsNotEmpty) {
            result = repository.findUserEntitiesByBirthDateAfterAndGender(startDate, UserEntity.Gender.valueOfEnum(gender));
        } else if (startDateNotNull) {
            result = repository.findUserEntitiesByBirthDateAfter(startDate);
        } else if (!endDateNotNull && !genderIsNotEmpty) {
            result = repository.findAll();
        } else if (endDateNotNull && genderIsNotEmpty) {
            result = repository.findUserEntitiesByBirthDateBeforeAndGender(endDate, UserEntity.Gender.valueOfEnum(gender));
        } else if (endDateNotNull) {
            result = repository.findUserEntitiesByBirthDateBefore(endDate);
        } else {
            result = repository.findUserEntitiesByGender(UserEntity.Gender.valueOfEnum(gender));
        }
        return result;
    }

}
