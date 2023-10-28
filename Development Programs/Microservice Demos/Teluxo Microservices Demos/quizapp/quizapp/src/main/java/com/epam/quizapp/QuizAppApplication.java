package com.epam.quizapp;

import com.epam.quizapp.repository.QuestionRepository;
import com.epam.quizapp.utility.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuizAppApplication /*implements CommandLineRunner */ {

    @Autowired
    private QuestionRepository questionRepository;

    public static void main(String[] args) {
        var context = SpringApplication.run(QuizAppApplication.class, args);
        GreetingService greetingService = context.getBean("greeting", GreetingService.class);
        greetingService.welcomeUser();
    }

/**
 * Interface
 * CommandLineRunner
 * <p>
 * Description
 * Spring Boot will automatically call the run method of
 * all beans implementing this interface after the application context has been loaded.
 *
 * @param args
 * @throws Exception
 */
    /*@Override
    public void run(String... args) throws Exception {
        List<Question> questionList = new ArrayList<>();

        Question question1 = new Question();
        question1.setQuestionTitle("Who invented Java Programming?");
        question1.setOption1("Guido van Rossum");
        question1.setOption2("James Gosling");
        question1.setOption3("Dennis Ritchie");
        question1.setOption4("Bjarne Stroustrup");
        question1.setAnswer("James Gosling");
        question1.setLevel(Level.EASY.getLevel());
        question1.setCategory(Category.JAVA.getCategory());
        questionList.add(question1);

        Question question2 = new Question();
        question2.setQuestionTitle("Which of these cannot be used for a variable name in Java?");
        question2.setOption1("identifier & keyword");
        question2.setOption2("identifier");
        question2.setOption3("keyword");
        question2.setOption4("none of the mentioned");
        question2.setAnswer("keyword");
        question2.setLevel(Level.MEDIUM.getLevel());
        question2.setCategory(Category.JAVA.getCategory());
        questionList.add(question2);

        Question question3 = new Question();
        question3.setQuestionTitle("Who developed Python Programming Language?");
        question3.setOption1("Guido van Rossum");
        question3.setOption2("James Gosling");
        question3.setOption3("Dennis Ritchie");
        question3.setOption4("Bjarne Stroustrup");
        question3.setAnswer("Guido van Rossum");
        question3.setLevel(Level.EASY.getLevel());
        question3.setCategory(Category.PYTHON.getCategory());
        questionList.add(question3);

        Question question4 = new Question();
        question4.setQuestionTitle("Is Python code compiled or interpreted?");
        question4.setOption1("Python code is both compiled and interpreted");
        question4.setOption2("Python code is neither compiled nor interpreted");
        question4.setOption3("Python code is only compiled");
        question4.setOption4("Python code is only interpreted");
        question4.setAnswer("Python code is both compiled and interpreted");
        question4.setLevel(Level.MEDIUM.getLevel());
        question4.setCategory(Category.PYTHON.getCategory());
        questionList.add(question4);

        Question question5 = new Question();
        question5.setQuestionTitle("Which of the following is correct about JavaScript?");
        question5.setOption1("JavaScript is an Object-Based language");
        question5.setOption2("JavaScript is Assembly-language");
        question5.setOption3("JavaScript is an Object-Oriented language");
        question5.setOption4("JavaScript is a High-level language");
        question5.setAnswer("JavaScript is an Object-Based language");
        question5.setLevel(Level.EASY.getLevel());
        question5.setCategory(Category.JAVASCRIPT.getCategory());
        questionList.add(question5);

        Question question6 = new Question();
        question6.setQuestionTitle("Arrays in JavaScript are defined by which of the following statements?");
        question6.setOption1("It is an ordered list of objects");
        question6.setOption2("It is an ordered list of values");
        question6.setOption3("It is an ordered list of string");
        question6.setOption4("It is an ordered list of functions");
        question6.setAnswer("It is an ordered list of values");
        question6.setLevel(Level.MEDIUM.getLevel());
        question6.setCategory(Category.JAVASCRIPT.getCategory());
        questionList.add(question6);

        questionRepository.saveAll(questionList);
    }
*/
}
