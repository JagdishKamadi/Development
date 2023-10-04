package com.epam.quiz.ui;

import com.epam.quiz.dao.SectionDaoImpl;
import com.epam.quiz.utility.enm.QuestionDifficultyTag;
import com.epam.quiz.utility.enm.QuestionTopicTag;
import org.springframework.stereotype.Component;

@Component
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
        SectionDaoImpl sectionOperationDaoImpl = new SectionDaoImpl();
        sectionName = sectionName.toUpperCase();

        String finalSectionName = sectionName;
        return sectionOperationDaoImpl.getSectionNameList().
                stream().
                anyMatch(sectionTag -> sectionTag.getSectionName().
                        equals(finalSectionName));
    }
}
