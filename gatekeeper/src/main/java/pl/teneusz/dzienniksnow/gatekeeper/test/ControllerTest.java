package pl.teneusz.dzienniksnow.gatekeeper.test;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Controller(value = "/")
public class ControllerTest {
//    @Autowired
//    RestTemplate restTemplate;


    @RequestMapping(method = RequestMethod.GET,path = "/test")
    public User[] test(){
        return new RestTemplate().getForObject("http://user-service/user",User[].class);
    }

    public User[] testDefault()
    {
        return new User[]{new User(-1l,"MALE","test")};
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    class User{
        Long id;
        String gender;
        String nickname;
    }
}
