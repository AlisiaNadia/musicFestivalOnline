package com.festivalmusic.festival.model;

import javax.persistence.*;

@Entity
@Table(name = "FESTIVAL_EDITION")
public class FestivalEdition {

    @Id
    @GeneratedValue
    @Column(name = "festival_edition_id")
    private Long festivalEditionId;

    @OneToOne(cascade = CascadeType.MERGE, targetEntity = Festival.class)
    @JoinColumn(name = "festival_id")
    private Festival festivalId;

    @OneToOne(cascade = CascadeType.MERGE, targetEntity = Stage.class)
    @JoinColumn(name = "stage_id")
    private Stage stageId;

    public FestivalEdition(Stage stage, Festival festival) {
        this.stageId = stage;
        this.festivalId = festival;
    }

    public FestivalEdition() {

    }


    public Long getFestivalEditionId() {
        return festivalEditionId;
    }

    public void setFestivalEditionId(Long festivalEditionId) {
        this.festivalEditionId = festivalEditionId;
    }

    public Festival getFestivalId() {
        return festivalId;
    }

    public void setFestivalId(Festival festivalId) {
        this.festivalId = festivalId;
    }

    public Stage getStageId() {
        return stageId;
    }

    public void setStageId(Stage stageId) {
        this.stageId = stageId;
    }

    @Override
    public String toString() {
        return "FestivalEditionStages{" +
                "festivalEditionId=" + festivalEditionId +
                ", festivalId=" + festivalId +
                ", stageId=" + stageId +
                '}';
    }
}
