package com.festivalmusic.festival.model;

import javax.validation.constraints.NotNull;

public class SingerRegistration {

    @NotNull
    private User user;

    @NotNull
    private Schedule schedule;

    @NotNull
    private Stage stage;

    public SingerRegistration(User user, Schedule schedule, Stage stage) {
        this.user = user;
        this.schedule = schedule;
        this.stage = stage;
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

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public String toString() {
        return "SingerRegistration{" +
                "user=" + user +
                ", schedule=" + schedule +
                ", stage=" + stage +
                '}';
    }
}
