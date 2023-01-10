package com.spring.henallux.AdvancedWebProject.model;

public class Reduction {
    private Integer id;
    private Integer nbPoint;

    public Reduction() {}

    public Reduction(Integer id, Integer nbPoint) {
        setId(id);
        setNbPoint(nbPoint);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNbPoint(Integer nbPoint) {
        this.nbPoint = nbPoint;
    }

    public Integer getId() {
        return id;
    }

    public Integer getNbPoint() {
        return nbPoint;
    }
}
