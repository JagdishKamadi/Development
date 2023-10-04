package com.epam.quiz.utility.cls;

import com.epam.quiz.utility.enm.DifficultyTag;
import com.epam.quiz.utility.enm.SectionTag;
import com.epam.quiz.utility.enm.TopicTag;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DisplayTag {

    public List<String> getSectionList()
    {
        List<String> lst = new ArrayList<>();
        for (SectionTag sectionTag : SectionTag.values()) {
            lst.add(sectionTag.toString());
        }

        return lst;
    }
    public List<String> getTopicList()
    {
        List<String> lst = new ArrayList<>();
        for (TopicTag topicTag : TopicTag.values()) {
            lst.add(topicTag.toString());
        }

        return lst;
    }

    public List<String> getDifficultyList()
    {
        List<String> lst = new ArrayList<>();
        for (DifficultyTag difficultyTag : DifficultyTag.values()) {
            lst.add(difficultyTag.toString());
        }
        return lst;
    }

}
