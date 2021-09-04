//Generic package, to show this could be implemented in an existing package.
package main.java.com.company;

//Imports kept to a minimum.
import main.java.com.company.sentenceChecker.*;
import java.util.Scanner;

class main {
    public static void main(String[] args) {
        //Prompt user.
        System.out.println("Please enter a string:");

        //Open the scanner to read the users important.
        Scanner sc = new Scanner(System.in);

        //Read the next line, with some validation.
        if (sc.hasNextLine()) {
            System.out.println("Entered input is of string type.");
        }
        String userInput = sc.nextLine();

        //User input validation.
        if (userInput.length() > 1) {
            System.out.println("Entered input is valid.");
        } else {
            System.out.println("Entered input is invalid. The string is empty.");
        }

        //Create instance of sentenceChecker object, so it can be accessed.
        SentenceChecker sentenceChecker = new SentenceChecker();

        //Create checks, and make a call to the checkSentence function with the input as a parameter.
        if (sentenceChecker.checkSentence(userInput.toCharArray())){
            //Display success message.
                System.out.println("\"" + userInput + "\"" + " is correct.");
            }
        else {
            //Display fail message.
                System.out.println("\"" + userInput + "\"" + " is invalid grammar.");
            }

    }
}

