package com.cryztal.traveler.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "city_answers")
public class AnswerEntity {

    public AnswerEntity() {
        this.answer = new String();
        this.cityEntity = new CityEntity();
    }

    public AnswerEntity(CityEntity cityEntity, String answer) {
        this.answer = answer;
        this.cityEntity = cityEntity;
    }

    public String getAnswer() {
        return answer;
    }

    public CityEntity getCity() {
        return cityEntity;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "answer")
    private String answer;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityEntity cityEntity;


}
