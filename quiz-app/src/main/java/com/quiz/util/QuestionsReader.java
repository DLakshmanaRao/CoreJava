package com.quiz.util;

import com.quiz.domine.Question;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class QuestionsReader {

    public List<Question> qsnReader() {
        List<Question> questions = new ArrayList<>();

        Path filePath = Paths.get("quiz-app/src/main/resources/questions.txt");
        Charset charset = StandardCharsets.UTF_8;
        try {
            List<String> lines = Files.readAllLines(filePath, charset);

            for (int i= 0; i< lines.size();){
                List<String> newList = lines.subList(i,i+7);
                i=i+7;
                List<String> opt = new ArrayList<>();
                opt.add(newList.get(2));
                opt.add(newList.get(3));
                opt.add(newList.get(4));
                opt.add(newList.get(5));

                Question question = Question.builder()
                        .id(Integer.parseInt(newList.get(0).substring(1)))
                        .question(newList.get(1))
                        .options(opt)
                        .answer(Integer.parseInt(String.valueOf(newList.get(6).charAt(5))))
                        .build();
                questions.add(question);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return questions;
    }
}