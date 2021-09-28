package com.festivalmusic.festival.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "FESTIVAL")
public class Festival {

    @Id
    @GeneratedValue
    @Column(name = "festival_id")
    private Long festivalId;

    @Column(name = "edition_name")
    private String editionName;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @OneToOne(mappedBy = "festivalId")
    private FestivalEdition festivalEdition;

    public String getEditionName() {
        return editionName;
    }

    public void setEditionName(String editionName) {
        this.editionName = editionName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Festival{" +
                "festivalId=" + festivalId +
                ", editionName='" + editionName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
