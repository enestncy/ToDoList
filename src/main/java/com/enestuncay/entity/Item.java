package com.enestuncay.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long list_id;

    private Long user_id;

    private String name;

    private Date date = new Date();

    private boolean state;




    //Gettet and Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getList_id() {
        return list_id;
    }

    public void setList_id(Long list_id) {
        this.list_id = list_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }


//toString

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", list_id=" + list_id +
                ", user_id=" + user_id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", state=" + state +
                '}';
    }
}
