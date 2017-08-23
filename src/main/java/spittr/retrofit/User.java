package spittr.retrofit;

import org.springframework.stereotype.Component;

/**
 * Created by zhaosy-c on 2017/7/31.
 */

@Component
public class User {

    private String name;
    private String phone;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
