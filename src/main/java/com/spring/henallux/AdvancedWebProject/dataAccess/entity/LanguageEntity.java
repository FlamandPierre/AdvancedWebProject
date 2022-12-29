package com.spring.henallux.AdvancedWebProject.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "language")
public class LanguageEntity {

    @Id
    @Column(name = "code")
    private String code;

    public LanguageEntity() {}

    public void setCode(String code) { this.code = code; }

    public String getCode() { return code; }
}
