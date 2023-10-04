package com.epam.quiz.service;

import com.epam.quiz.dao.SectionDao;
import com.epam.quiz.model.SectionTag;
import com.epam.quiz.service.SectionValidationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SectionValidationServiceImplTest {

    @Mock
    SectionDao sectionDao;

    @InjectMocks
    SectionValidationServiceImpl sectionValidationService;

    private List<SectionTag> sectionList;

    @BeforeEach
    void setUpObject() {
        SectionTag sectionTag1 = new SectionTag("CORE_JAVA");
        SectionTag sectionTag2 = new SectionTag("JAVA_EIGHT");
        SectionTag sectionTag3 = new SectionTag("ADVANCE_JAVA");
        sectionList = Arrays.asList(sectionTag1, sectionTag2, sectionTag3);
    }

    /**
     * checking for method addSectionTag
     * TO-DO LIST
     * 1) check for new tag
     * 2) check for existing tag
     */

    @Test
    @DisplayName("Entering new section tag to list")
    void addSectionTagTest() {
        String sectionName = "Functional_Interface";
        when(sectionDao.getSectionNameList()).thenReturn(sectionList);
        assertFalse(sectionValidationService.isSectionTagExistChecker(sectionName));

        // now verify actual call
        sectionDao.addNewSectionTagToDB(sectionName);
        verify(sectionDao).addNewSectionTagToDB(sectionName);
        verify(sectionDao, times(1)).addNewSectionTagToDB(sectionName);
    }

    @Test
    @DisplayName("Checking weather section name is updating or not")
    void updateSectionTest() {
        String oldSectionName = "Functional_Interface";
        String newSectionName = "DateandTimeApi";

        when(sectionDao.getSectionNameList()).thenReturn(sectionList);
        assertFalse(sectionValidationService.isSectionTagExistChecker(newSectionName));

        sectionDao.updateSectionTagFromDB(oldSectionName, newSectionName);
        verify(sectionDao).updateSectionTagFromDB(oldSectionName, newSectionName);
        verify(sectionDao, times(1)).updateSectionTagFromDB(oldSectionName, newSectionName);
    }

    /**
     * checking for method isSectionTagExist
     * TO-DO LIST
     * 1) check for valid tag
     * 2) check for invalid tag
     */

    @Test
    @DisplayName("Checking for valid section tag")
    void isValidSectionTagExistTest() {
        String sectionName = "Core_java";
        when(sectionDao.getSectionNameList()).thenReturn(sectionList);
        assertTrue(sectionValidationService.isSectionTagExistChecker(sectionName));
    }

    @Test
    @DisplayName("Checking for invalid section tag")
    void isInValidSectionTagExistTest() {
        String sectionName = "Corejava";
        when(sectionDao.getSectionNameList()).thenReturn(sectionList);
        assertFalse(sectionValidationService.isSectionTagExistChecker(sectionName));
    }
}
