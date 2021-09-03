package com.festivalmusic.festival.model;

import java.util.ArrayList;
import java.util.List;

public class BandRegistration {

    private List<User> users;

    private Schedule schedule;
    private String name;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BandRegistration{" +
                "users=" + users +
                ", schedule=" + schedule +
                ", name='" + name + '\'' +
                '}';
    }
}
