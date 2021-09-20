package com.festivalmusic.festival.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "SCHEDULES")
public class Schedule {

    @Id
    @GeneratedValue
    @Column(name = "schedule_id")
    private Long scheduleId;

    @Column(name = "date")
    @NotNull
    private Date scheduleDate;

    @Column(name = "time")
    @NotNull
    private String time;

    @OneToMany(mappedBy = "scheduleId")
    private List<Singer> singer;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Stage.class)
    @JoinColumn(name = "stage_id")
    @NotNull
    private Stage stageId;

    public Schedule(Date scheduleDate, String time, Stage stageId) {

        this.scheduleDate = scheduleDate;
        this.time = time;
        this.stageId = stageId;
    }

    public Schedule() {

    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public List<Singer> getSinger() {
        return singer;
    }

    public void setSinger(List<Singer> singer) {
        this.singer = singer;
    }

    public Stage getStageId() {
        return stageId;
    }

    public void setStageId(Stage stageId) {
        this.stageId = stageId;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleId=" + scheduleId +
                ", date=" + scheduleDate +
                ", time='" + time + '\'' +
                '}';
    }
}
