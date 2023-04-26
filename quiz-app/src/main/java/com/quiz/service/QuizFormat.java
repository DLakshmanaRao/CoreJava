package com.quiz.service;

import com.quiz.domine.Question;
import com.quiz.util.QuestionsReader;

import java.util.List;
import java.util.Scanner;

public class QuizFormat {

    private QuestionsReader questionsReader;

    public QuizFormat() {
        this.questionsReader = new QuestionsReader();
    }

    public String startQuiz(String name) {
        String retString = "You got 0 marks";
        Scanner sc = new Scanner(System.in);
        float marks = 0;
        for (Question qsn : questionsReader.qsnReader()) {
            System.out.println(qsn.getId() + ": " + qsn.getQuestion());
            System.out.printf("Do you want to skip the quest (yes: 1/ no: 2): ");
            int skipOpt = sc.nextInt();
            if (skipOpt == 1) {
                System.out.println("\n");
                continue;
            } else {
                for (String opt : qsn.getOptions()) {
                    System.out.println(opt);
                }
                System.out.println("Enter your answer (1/2/3/4): ");
                int ans = sc.nextInt();
                if (ans >0 && ans<=4){
                    if (ans == qsn.getAnswer()) {
                        marks += 1;
                    } else if (ans != qsn.getAnswer()) {
                        marks -= 0.25;
                    }
                }else {
                    System.out.println("Entered question is not included with options, enter correct option ");
                    ans = sc.nextInt();
                }
            }
        }
        retString = "Your final marks = " + marks;
        return retString;
    }
}
