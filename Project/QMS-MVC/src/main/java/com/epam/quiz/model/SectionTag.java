package com.epam.quiz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SectionTag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sectionTagId;
    private String sectionName;

    public SectionTag()
    {

    }

    public SectionTag(String sectionName) {
        this.sectionName = sectionName;
    }

    public int getSectionTagId() {
        return sectionTagId;
    }

    public void setSectionTagId(int sectionTagId) {
        this.sectionTagId = sectionTagId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    @Override
    public String toString() {
        return "SectionTag{" +
                "sectionTagId=" + sectionTagId +
                ", sectionName='" + sectionName + '\'' +
                '}';
    }
}
