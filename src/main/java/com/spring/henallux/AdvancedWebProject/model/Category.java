package com.spring.henallux.AdvancedWebProject.model;

import java.util.Collection;

public class Category {

    private String label;
    private Collection<BoardGame> boardGames;

    public Category() {}

    public void setLabel(String label) {
        this.label = label;
    }
    public void setBoardGames(Collection<BoardGame> boardGames) {
        this.boardGames = boardGames;
    }

    public String getLabel() {
        return label;
    }
    public Collection<BoardGame> getBoardGames() {
        return boardGames;
    }

}