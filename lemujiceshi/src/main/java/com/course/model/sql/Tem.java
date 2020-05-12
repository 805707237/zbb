package com.course.model.sql;

import java.io.Serializable;

public class Tem implements Serializable {
    private Integer id;
    private String card;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Tem{" +
                "id=" + id +
                ", card='" + card + '\'' +
                '}';
    }
}
