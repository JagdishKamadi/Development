package com.epam.quiz.service;

import com.epam.quiz.dao.SectionOperationDao;

import java.util.List;

public class SectionValidationService {
    SectionOperationDao sectionOperationDao;
    public SectionValidationService()
    {
        sectionOperationDao = new SectionOperationDao();
    }

    public boolean addSectionTag(String sectionName) {

        sectionName = sectionName.toUpperCase();
        boolean result = isSectionTagExist(sectionName);
        if (!result) {
            sectionOperationDao.addNewSectionTagToDB(sectionName);
        }

        return !result;
    }

    public boolean updateSectionTag(String oldSectionName, String newSectionName) {
        newSectionName = newSectionName.toUpperCase();

        String finalSectionName = newSectionName;
        boolean result = sectionOperationDao.getSectionNameList().
                stream().
                anyMatch(sectionTag -> sectionTag.getSectionName().equals(finalSectionName));

        if (!result) {
            sectionOperationDao.updateSectionTagFromDB(oldSectionName, newSectionName);
        }

        return !result;
    }


    private int getSectionTagListSize() {
        return sectionOperationDao.getSectionNameList().size();
    }

    private boolean isSectionTagExist(String sectionName) {
        String finalSectionName = sectionName.toUpperCase();
        return sectionOperationDao.getSectionNameList().stream().anyMatch(sectionTag -> sectionTag.getSectionName().equals(finalSectionName));
    }


}
