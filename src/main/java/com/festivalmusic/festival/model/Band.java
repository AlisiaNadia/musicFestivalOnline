package com.festivalmusic.festival.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "BANDS")
public class Band {

    @Id
    @GeneratedValue
    @Column(name = "band_id")
    private Long bandId;

    @Column(name = "band_name")
    private String bandName;

    @OneToMany(mappedBy = "bandId")
    private List<BandMembers> members;

    public Band(String name) {

        this.bandName = name;
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
                '}';
    }
}
