package com.course.model.sql;

public class Haha {
    Integer id;
    String hhh;

    @Override
    public String toString() {
        return "Haha{" +
                "id=" + id +
                ", hhh='" + hhh + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHhh() {
        return hhh;
    }

    public void setHhh(String hhh) {
        this.hhh = hhh;
    }
}
