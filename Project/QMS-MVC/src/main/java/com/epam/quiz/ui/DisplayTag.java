package com.epam.quiz.ui;

import com.epam.quiz.dao.SectionDaoImpl;
import com.epam.quiz.model.SectionTag;
import com.epam.quiz.utility.enm.QuestionDifficultyTag;
import com.epam.quiz.utility.enm.QuestionTopicTag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DisplayTag {
    private static final Logger logger = LogManager.getLogger(DisplayTag.class);

    @Autowired
    private SectionDaoImpl sectionOperationDaoImpl;

    public void showAvailableQuestionTopicTag() {
        List<String> lst = new ArrayList<>();
        for (QuestionTopicTag questionTopicTag : QuestionTopicTag.values()) {
            lst.add(questionTopicTag.toString());
        }
        logger.info(lst);
    }

    public void showAvailableQuestionDifficultyTag() {
        List<String> lst = new ArrayList<>();
        for (QuestionDifficultyTag questionDifficultyTag : QuestionDifficultyTag.values()) {
            lst.add(questionDifficultyTag.toString());
        }
        logger.info(lst);
    }

    public void showAvailableQuestionSectionName() {
        List<String> lst = sectionOperationDaoImpl.getSectionNameList().stream().map(SectionTag::getSectionName).collect(Collectors.toList());
        logger.info(lst);
    }
}
