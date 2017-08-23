package spittr.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HttpServletBean;
import spittr.retrofit.User;

/**
 * Created by zhaosy-c on 2017/7/28.
 */
@Controller
@RequestMapping("/users")
public class MyController implements EnvironmentAware{

    private final Log logger = LogFactory.getLog(MyController.class);

    @RequestMapping("/123")
    @ResponseBody
    public String returnstring(){
        logger.info("this is a good boy");
        System.out.println("this is a good boy");
        return "upload";
    }

    @RequestMapping(value = "/form", produces ={"application/json;charset=UTF-8"})
    public User test_02(@RequestParam String name, @RequestParam int age){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }

    private Environment environment;
    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
