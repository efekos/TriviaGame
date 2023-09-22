package dev.efekos.question;

import java.util.Arrays;
import java.util.List;

public class Question {
    private final String explanation;
    private final String questionText;
    private final String answer;

    public Question(String questionText, String answer, String explanation,String... wrongAnswers) {
        this.explanation = explanation;
        this.questionText = questionText;
        this.answer = answer;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getAnswer() {
        return answer;
    }
}
