package com.epam.quiz.service;

import java.util.Map;

public interface SectionValidationService {

    public boolean addSectionTagChecker(String sectionName);
    public boolean updateSectionTagChecker(String oldSectionName, String newSectionName);
    boolean isSectionTagExistChecker(String sectionName);

    Map<Integer,String> getSectionList();

}
