package com.festivalmusic.festival.model;

import javax.persistence.*;

@Entity
@Table(name = "SINGERS")
public class Singer {

    @Id
    @GeneratedValue
    private Long singerId;

    @OneToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "user_info_id")
    private User userId;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Schedule.class)
    @JoinColumn(name = "schedule_id")
    private Schedule scheduleId;

    @OneToOne(mappedBy = "singerId")
    private BandMembers members;

    public Singer(User user, Schedule savedSchedule) {
        this.userId = user;
        this.scheduleId = savedSchedule;
    }

    public Singer() {

    }

    public Long getSingerId() {
        return singerId;
    }

    public void setSingerId(Long singerId) {
        this.singerId = singerId;
    }

    public Schedule getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Schedule scheduleId) {
        this.scheduleId = scheduleId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Singer{" +
                "singerId=" + singerId +
                '}';
    }
}
