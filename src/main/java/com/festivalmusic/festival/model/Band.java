package com.festivalmusic.festival.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "BANDS")
public class Band {

    @Id
    @GeneratedValue
    @Column(name = "band_id")
    private Long bandId;

    @Column(name = "band_name")
    @NotNull
    private String bandName;

    @OneToOne(fetch = FetchType.LAZY, targetEntity = Schedule.class)
    @JoinColumn(name = "schedule_id")
    private Schedule scheduleId;

    @OneToMany(mappedBy = "bandId")
    private List<BandMembers> members;

    public Band(String name, Schedule scheduleId) {

        this.bandName = name;
        this.scheduleId = scheduleId;

    }

    public Band() {

    }

    public Long getBandId() {
        return bandId;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public void setBandId(Long bandId) {
        this.bandId = bandId;
    }

    public Schedule getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Schedule scheduleId) {
        this.scheduleId = scheduleId;
    }

    public List<BandMembers> getMembers() {
        return members;
    }

    public void setMembers(List<BandMembers> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "Band{" +
                "bandId=" + bandId +
                ", bandName='" + bandName + '\'' +
                ", scheduleId=" + scheduleId +
                ", members=" + members +
                '}';
    }
}
