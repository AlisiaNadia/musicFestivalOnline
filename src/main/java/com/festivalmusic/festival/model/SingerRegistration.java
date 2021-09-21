package com.festivalmusic.festival.model;

public class SingerRegistration {

    private User user;

    private Schedule schedule;

    public SingerRegistration(User user, Schedule schedule) {
        this.user = user;
        this.schedule = schedule;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }


    @Override
    public String toString() {
        return "SingerRegistration{" +
                "user=" + user +
                ", schedule=" + schedule +
                '}';
    }
}
