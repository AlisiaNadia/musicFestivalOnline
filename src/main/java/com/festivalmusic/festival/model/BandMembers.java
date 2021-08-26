package com.festivalmusic.festival.model;

import javax.persistence.*;

@Entity
@Table(name = "BAND_MEMBERS")
public class BandMembers {

    @Id
    @GeneratedValue
    @Column(name = "band_member_id")
    private Long bandMemberId;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = Singer.class)
    @JoinColumn(name = "singer_id")
    private Singer singerId;


    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Band.class)
    @JoinColumn(name = "band_id")
    private Band bandId;

    public Singer getSingerId() {
        return singerId;
    }

    public void setSingerId(Singer singerId) {
        this.singerId = singerId;
    }

    public Band getBandId() {
        return bandId;
    }

    public void setBandId(Band bandId) {
        this.bandId = bandId;
    }

    @Override
    public String toString() {
        return "BandMembers{" +
                "bandMemberId=" + bandMemberId +
                ", singerId=" + singerId +
                ", bandId=" + bandId +
                '}';
    }
}
