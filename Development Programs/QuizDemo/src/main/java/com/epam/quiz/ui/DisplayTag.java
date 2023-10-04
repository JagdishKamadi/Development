package com.epam.quiz.ui;

import com.epam.quiz.dao.SectionOperationDao;
import com.epam.quiz.utility.enm.QuestionDifficultyTag;
import com.epam.quiz.utility.enm.QuestionTopicTag;

import java.util.ArrayList;
import java.util.List;

public class DisplayTag {

    public void showAvailableQuestionTopicTag() {
        List<String> lst = new ArrayList<>();
        for (QuestionTopicTag questionTopicTag : QuestionTopicTag.values()) {
            lst.add(questionTopicTag.toString());
        }
        System.out.println(lst);
    }

    public void showAvailableQuestionDifficultyTag() {
        List<String> lst = new ArrayList<>();
        for (QuestionDifficultyTag questionDifficultyTag : QuestionDifficultyTag.values()) {
            lst.add(questionDifficultyTag.toString());
        }
        System.out.println(lst);
    }

    public void showAvailableQuestionSectionName() {
        SectionOperationDao sectionOperationDao = new SectionOperationDao();
        List<String> lst = sectionOperationDao.getSectionNameList().stream().map(question->question.getSectionName()).toList();
        System.out.println(lst);
    }
}
