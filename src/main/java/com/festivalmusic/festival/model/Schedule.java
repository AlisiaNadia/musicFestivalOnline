package com.festivalmusic.festival.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

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

    @OneToOne(mappedBy = "scheduleId")
    private Singer singer;

    @OneToOne(mappedBy = "scheduleId")
    private Band band;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Stage.class)
    @JoinColumn(name = "stage_id")
    @NotNull
    private Stage stageId;

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

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public Band getBand() {
        return band;
    }

    public void setBand(Band band) {
        this.band = band;
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
                ", singer=" + singer +
                ", band=" + band +
                ", stageId=" + stageId +
                '}';
    }
}
