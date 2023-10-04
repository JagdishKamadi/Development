package com.epam.quiz.dao;

import com.epam.quiz.model.SectionTag;

import java.util.List;

public interface SectionDao {
    void addNewSectionTagToDB(String sectionName);
    void updateSectionTagFromDB(String oldSectionName, String newSectionName);
    List<SectionTag> getSectionNameList();
}
