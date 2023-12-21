package com.epam.quiz.ui;

import com.epam.quiz.dao.SectionOperationDao;
import com.epam.quiz.utility.enm.QuestionDifficultyTag;
import com.epam.quiz.utility.enm.QuestionTopicTag;

public class ValidTag {
    public boolean isQuestionTopicTagPresent(String questionTopicTag) {
        boolean result = false;
        for (QuestionTopicTag topicTag : QuestionTopicTag.values()) {
            if (topicTag.name().equalsIgnoreCase(questionTopicTag)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean isQuestionDifficultyTagPresent(String questionDifficultyTag) {
        boolean result = false;
        for (QuestionDifficultyTag difficultyTag : QuestionDifficultyTag.values()) {
            if (difficultyTag.name().equalsIgnoreCase(questionDifficultyTag)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean isQuestionSectionNamePresent(String sectionName) {
        SectionOperationDao sectionOperationDao = new SectionOperationDao();
        sectionName = sectionName.toUpperCase();

        String finalSectionName = sectionName;
        return sectionOperationDao.getSectionNameList().
                stream().
                anyMatch(sectionTag -> sectionTag.getSectionName().
                        equals(finalSectionName));
    }
}
