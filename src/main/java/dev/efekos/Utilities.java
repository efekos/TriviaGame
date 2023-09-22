package dev.efekos;

import dev.efekos.question.Question;

import java.util.Map;
import java.util.Scanner;

public class Utilities {
    public static boolean askForStop(Scanner scanner){
        if(scanner.next().equalsIgnoreCase("n")){
            System.out.println("Alright, see you later! Now go read a book.");
            return true;
        } else {
            System.out.println("Okay then.");
            return false;
        }
    }

    public static double calculateScore(int corrects,int wrongs){
        double questionAmount = corrects+wrongs;
        double base = corrects/questionAmount;
        double change = wrongs*0.3;
        return base-change;
    }

    public static boolean askQuestion(Scanner scanner,int questionId,int curQuestion,int maxQuestion){
        Question question = Main.questions.get(questionId);
        System.out.println("Question "+curQuestion+"/"+maxQuestion+" - "+question.getQuestionText());
        if(scanner.next().equals(question.getAnswer())){
            System.out.println("Correct!");
            return true;
        } else {
            System.out.println("Wrong! "+question.getExplanation());
            return false;
        }
    }
}
