package com.epam.quiz.utility.cls;

import com.epam.quiz.utility.enm.QuestionDifficultyTag;
import com.epam.quiz.utility.enm.QuestionTopicTag;

public class DisplayTag {

    public static void  showAvailableQuestionTopicTag()
    {
        System.out.print("\n[ ");
        for(QuestionTopicTag questionTopicTag : QuestionTopicTag.values())
        {
            System.out.print(questionTopicTag+" ");
        }
        System.out.println("]");
    }

    public static void  showAvailableQuestionDifficultyTag()
    {
        System.out.print("\n[ ");
        for(QuestionDifficultyTag questionDifficultyTag : QuestionDifficultyTag.values())
        {
            System.out.print(questionDifficultyTag+" ");
        }
        System.out.println("]");
    }

    public static boolean isQuestionTopicTagPresent(String questionTopicTag)
    {

        for(QuestionTopicTag topicTag : QuestionTopicTag.values())
        {
            if(topicTag.name().equalsIgnoreCase(questionTopicTag))
            {
                return true;
            }
        }
        return false;
    }

    public static boolean isQuestionDifficultyTagPresent(String questionDifficultyTag)
    {

        for(QuestionDifficultyTag difficultyTag : QuestionDifficultyTag.values())
        {
            if(difficultyTag.name().equalsIgnoreCase(questionDifficultyTag))
            {
                return true;
            }
        }
        return false;
    }

}
