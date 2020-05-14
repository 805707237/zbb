package com.course.model.sql;


import java.io.Serializable;
import java.util.List;


public class User implements Serializable  {
    private Integer id;
    private String name;
    private String age;
    private String max;
    private String password;
    private List<Tem> tems;

    public List<Tem> getTems() {
        return tems;
}

    public void setTems(List<Tem> tems) {
        this.tems = tems;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", max='" + max + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

