package com.spring.henallux.AdvancedWebProject.dataAccess.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="category")
public class CategoryEntity {

    @Id
    @Column(name = "label")
    private String label;

    @OneToMany(mappedBy="category")
    private Collection<BoardGameEntity> boardGames;


    public CategoryEntity() {}

    public void setLabel(String label) {
        this.label = label;
    }
    public void setBoardGames(Collection<BoardGameEntity> boardGames) {
        this.boardGames = boardGames;
    }

    public String getLabel() {
        return label;
    }
    public Collection<BoardGameEntity> getBoardGames() {
        return boardGames;
    }
}
