package com.quiz;

import com.quiz.domine.Question;
import com.quiz.service.QuizFormat;
import com.quiz.util.QuestionsReader;

import java.util.List;
import java.util.Scanner;

public class QuizManager {
    public static void main(String[] args) {
        QuestionsReader questionsReader = new QuestionsReader();
//        List<Question> qsn = questionsReader.qsnReader();
//        for (Question q:qsn){
//            System.out.println(q.getId() +"\n"+q.getQuestion()+"");
//            System.out.println(q.getOptions());
//            System.out.println(q.getAnswer());
//            System.out.println("\n");
//        }

        QuizFormat quizFormat = new QuizFormat();
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter your name: ");
        String name = sc.nextLine();
        System.out.println(quizFormat.startQuiz(name));

    }
}
