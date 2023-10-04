package com.epam.quiz.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.quiz.dao.SectionDaoImpl;
import com.epam.quiz.model.SectionTag;
import com.epam.quiz.utility.enm.QuestionDifficultyTag;
import com.epam.quiz.utility.enm.QuestionTopicTag;

@Component
public class SectionTagList{
	
	@Autowired
    private SectionDaoImpl sectionDaoImpl;
	
	  public List<String> getAvailableQuestionTopicTag() {
	        List<String> lst = new ArrayList<>();
	        for (QuestionTopicTag questionTopicTag : QuestionTopicTag.values()) {
	            lst.add(questionTopicTag.toString());
	        }
	        return lst;
	    }
	  
	  public List<String> getAvailableQuestionDifficultyTag() {
	        List<String> lst = new ArrayList<>();
	        for (QuestionDifficultyTag questionDifficultyTag : QuestionDifficultyTag.values()) {
	            lst.add(questionDifficultyTag.toString());
	        }
	        return lst;
	    }

	    public List<String> getAvailableQuestionSectionName() {

	        return sectionDaoImpl.getSectionNameList().stream().map(SectionTag::getSectionName).collect(Collectors.toList());
	    }

}
