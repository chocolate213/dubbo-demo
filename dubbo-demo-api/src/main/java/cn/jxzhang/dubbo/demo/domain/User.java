package cn.jxzhang.dubbo.demo.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * User, 必须实现 Serializable 接口
 *
 * @author zhangjiaxing
 * @version 1.0
 */
public class User implements Serializable {

    private static final long serialVersionUID = 667128688468860387L;

    private Integer id;

    private String name;

    private Integer age;

    private Date birth;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String name, Integer age, Date birth) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birth = birth;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                '}';
    }
}
