package pl.teneusz.dzienniksnow.userservice.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tenek on 17.07.2017.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "client")
@SequenceGenerator(name = "clientSeq", sequenceName = "client_seq")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientSeq")
    @Column(name = "client_id")
    private Long id;


    @Column(name = "client_nickname", nullable = false, unique = true)
    private String nickname;

    @Column(name = "client_password", nullable = false, length = 128)
    private String password;

    @Column(name = "client_birthdate")
    private Date birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "client_gender")
    private Gender gender;

    public enum Gender {
        FEMALE("f"), MALE("m");

        private final String value;
        private static Map<String, Gender> VALUES_MAP = new HashMap<>();

        static {
            for (Gender gender : Gender.values()) {
                VALUES_MAP.put(gender.value, gender);
            }
        }

        Gender(String value) {
            this.value = value;
        }

        public static Gender valueOfEnum(String value) {
            return VALUES_MAP.get(value);
        }
    }
}