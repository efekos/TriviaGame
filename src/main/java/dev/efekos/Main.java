package dev.efekos;

import dev.efekos.question.Question;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.random;
import static java.lang.Math.round;

public class Main {

    // Made by efekos

    public static final List<Question> questions = Arrays.asList(
            new Question("Which version was the combat update?","1.9","Combat Update was the update added in 1.9."),
            new Question("What is full name of Notch?","markus_alexej_persson","Full name of Notch is 'Markus Alexej Persson'."),
            new Question("Which biome has a hot color set of terracotta blocks in its terrain?","badlands","Badlands is the only biome that contains terracotta in its terrain."),
            new Question("This block was designed a long time ago but added in 1.16. Which block is this?","crying_obsidian","Crying Obsidian was designed in Minecraft beta 1.3, but added in 1.16."),
            new Question("Which structure can appear in 5 types for 5 different biomes?","village","Villages can exists in 5 biomes, different types for each one."),
            new Question("Which kind of a villager can trade granite, andesite and diorite for emeralds?","mason","Masons can trade those blocks in their 'Journeyman' state."),
            new Question("What does villagers use as currency?","emerald","Villagers use emeralds as their currency."),
            new Question("Which stone block is one of the first 2 blocks added in Minecraft?","cobblestone","Cobblestone and Grass Block is the first 2 blocks added in Minecraft."),
            new Question("Which version was the first update brought to us by Microsoft?","1.13","1.13 Aquatic Update was the first update made by Microsoft."),
            new Question("Which structure is located at random coordinates within rings in all biomes?","stronghold","Strongholds are located at random coordinates within rings in all biomes, where each ring is a certain radius from the center of the world.")
    );


    public static void main(String[] args) {
        // showing main stuff
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Welcome to efekos' trivia game remake made for Assignment #3!");
        System.out.println("In this trivia game, you will have 5-10 questions about Minecraft.");
        System.out.println("You need to answer at least %50 of the questions to win!");
        System.out.println("You will have a score depending on your answers as well!");
        System.out.println("After seeing the results, you can play another round if you want.");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Because of the mess #nextLine makes, you will have to use '_' instead of spaces");
        System.out.println("Do not use any uppercase characters");
        System.out.println("-------------------------------------------------------------------");

        Scanner scanner = new Scanner(System.in);

        boolean stop = false;

        while (!stop){
            // defining correct and wrongs
            int corrects = 0;
            int wrongs = 0;

            int questionAmount = (int) round(random() * 5) + 5;


            List<Integer> seenBefore = new ArrayList<>();
            // asking questions
            for (int i = 0; i < questionAmount; i++) { // minimum 5, maximum 10 questions in one round.
                int id = (int) round(random()*9); // to select a random question.

                // with this while loop, we prevent the same question appearing twice in one round.
                while (seenBefore.contains(id)){
                    id = (int) round(random()*9);
                }
                seenBefore.add(id);

                if (Utilities.askQuestion(scanner,id,i+1,questionAmount)) corrects++; else wrongs++;
            }
            System.out.println("--------------------");
            System.out.println("Here is the results!");
            System.out.println("--------------------");

            // calculating score and percentage.
            double score = Utilities.calculateScore(corrects,wrongs);
            double percent = (double) corrects /questionAmount;

            System.out.println("You had "+questionAmount+" questions, answered "+corrects + " questions correct, and "+wrongs+" questions wrong.");
            System.out.println("Your score is "+round(score*1000)+".");
            System.out.println("You answered "+ NumberFormat.getPercentInstance().format(percent) + " of the questions correct.");

            if(percent>0.5){
                System.out.println("You won!");
            } else {
                System.out.println("You lost!");
            }

            System.out.println("---------------");

            // ending the round
            System.out.println("This was a round. Do you want to play another? (Y/N)");
            stop = Utilities.askForStop(scanner);
        }
    }
}