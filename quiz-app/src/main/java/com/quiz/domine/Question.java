package com.quiz.domine;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Builder

public class Question {
    private int id;
    private String question;
    private List<String> options;
    private int answer;

    public Question(int id, String question, List<String> options, int answer) {
        this.id = id;
        this.question = question;
        this.options = options;
        this.answer = answer;
    }
}
