package com.epam.quiz.service;

import com.epam.quiz.dao.SectionDao;
import com.epam.quiz.model.SectionTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SectionValidationServiceImpl implements SectionValidationService {
    @Autowired
    private SectionDao sectionDaoImpl;

    public boolean addSectionTagChecker(String sectionName) {
        sectionName = sectionName.toUpperCase();
        boolean result = isSectionTagExistChecker(sectionName);
        if (!result) {
            sectionDaoImpl.addNewSectionTagToDB(sectionName);
        }

        return !result;
    }

    public boolean updateSectionTagChecker(String oldSectionName, String newSectionName) {
        newSectionName = newSectionName.toUpperCase();

        boolean result = isSectionTagExistChecker(newSectionName);

        if (!result) {
            sectionDaoImpl.updateSectionTagFromDB(oldSectionName, newSectionName);
        }

        return !result;
    }


    public int getSectionTagListSize() {
        return sectionDaoImpl.getSectionNameList().size();
    }

    public boolean isSectionTagExistChecker(String sectionName) {

        String finalSectionName = sectionName.toUpperCase();
        return sectionDaoImpl.getSectionNameList().stream().anyMatch(sectionTag -> sectionTag.getSectionName().equals(finalSectionName));
    }

    @Override
    public Map<Integer, String> getSectionList() {
        int index = 0;
        Map<Integer, String> sectionMap = new HashMap<>();
        for (SectionTag sectionName : sectionDaoImpl.getSectionNameList())
            sectionMap.put(++index, sectionName.getSectionName());

        return sectionMap;
    }
}
