

package ru.anton.tester.backend.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import ru.anton.tester.TesterApplication;
import ru.anton.tester.backend.entity.Question;
import ru.anton.tester.backend.repository.QuestionRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

@Service
public class DataLoaderQuestions implements CommandLineRunner {

    //private final AnswerRepository answerRepository;

    private final QuestionRepository questionRepository;

    public DataLoaderQuestions(/*AnswerRepository answerRepository,*/ QuestionRepository questionRepository) {
        //this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        TesterApplication obj = new TesterApplication();


        InputStream stringReaderAllTest = obj.getClass()
                .getClassLoader()
                .getResourceAsStream("static/Thermal_power_plants.txt");


//        InputStream strReaderCorrectAnswer = obj.getClass()
//                .getClassLoader()
//                .getResourceAsStream("static/Answer.txt");


        String[] splitAllTest = getStrings(stringReaderAllTest);

        String[] resultAllTest = Arrays.copyOfRange(splitAllTest, 1, splitAllTest.length);

        for (String s : resultAllTest) {
            String[] strings = s.split("\\n");
            questionRepository.save(new Question(strings[1], Arrays.asList(Arrays.copyOfRange(strings, 2, strings.length))));
        }

//
//        String[] correctAnswers = getStrings(strReaderCorrectAnswer);
//
//        String[] resultCorrectAnswer = Arrays.copyOfRange(correctAnswers, 1, correctAnswers.length);
//
//        for (String s : resultCorrectAnswer) {
//            String[] split = s.split("\\n");
//
//            answerRepository.save(new CorrectAnswer(split[2]));
        }

    private String[] getStrings(InputStream stringReaderAllTest) throws IOException {
        StringBuilder fileContent;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(stringReaderAllTest))) {

            fileContent = new StringBuilder();
            String st;
            while ((st = br.readLine()) != null) {
                if (st.contains("Правила по охране труда при эксплуатации тепловых энергоустановок"))
                    continue;
                if (st.contains("Мероприятия по оказани первой помощи (Приказ Минздрава России от 04.05.2012 № 477н)"))
                    continue;
                fileContent.append(st)
                        .append("\n");
            }
        }


        return fileContent.toString()
                .split("Вопрос \\d+");
    }
}
