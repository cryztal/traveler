package com.cryztal.traveler.domain.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cities")
public class CityEntity {

    public CityEntity() {
        cityName = new String();
        answerEntities = new ArrayList<>();

    }

    public CityEntity(String cityName) {
        this.cityName = cityName;
        answerEntities = new ArrayList<>();
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public List<AnswerEntity> getAnswers() {
        return answerEntities;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "city_name")
    private String cityName;

    @OneToMany(mappedBy = "cityEntity",
            fetch = FetchType.EAGER)
    private List<AnswerEntity> answerEntities;
}
