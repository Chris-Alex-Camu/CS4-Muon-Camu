import java.util.Scanner;

public class Ex02MuonCamu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = 10;
        int min = 1;
        int guesses = 3;
        while (true) {
            System.out.println("\n\nWelcome to Higher or Lower! What will you do?\n"
                                + "-Start game\n"
                                + "-Change settings\n"
                                + "-End application\n");
            
            String option = sc.nextLine();
            int range = max - min;
            if (option.equalsIgnoreCase("Start Game")) {
                int noGuess = guesses;
                int random = (int)Math.floor(Math.random() * (double)range) + min;
                int guess = min - 1;
                while (noGuess > 0) {
                    if (noGuess == guesses) {
                        boolean firstGuess = true;
                        while (firstGuess == true){
                            System.out.println("\nYou have " + noGuess + " guess(es) left. What is your guess?");
                            String tempGuess = sc.nextLine();
                            guess = Integer.parseInt(tempGuess);
                            if (guess > max || guess < min) {
                                System.out.println("The number is between " + min + " and " + max + ". Guess a number that is in the range.");
                            }
                            else {
                                firstGuess = false;
                            }
                        }
                    } 
                    else if (guess > random && noGuess != 0) {
                        boolean lowerGuess = true;
                        while (lowerGuess == true){
                            System.out.println("Guess Lower! You have " + noGuess + " guess(es) left. What is your guess?");
                            String tempGuess = sc.nextLine();
                            guess = Integer.parseInt(tempGuess);
                            if (guess > max || guess < min) {
                                System.out.println("The number is between " + min + " and " + max + ". Guess a number that is in the range.");
                            }
                            else {
                                lowerGuess = false;
                            }
                        }
                    } 
                    else if (guess < random && noGuess != 0) {
                        boolean higherGuess = true;
                        while (higherGuess==true){
                            System.out.println("Guess Higher! You have " + noGuess + " guess(es) left. What is your guess?");
                            String tempGuess = sc.nextLine();
                            guess = Integer.parseInt(tempGuess);
                            if (guess > max || guess < min) {
                                System.out.println("The number is between " + min + " and " + max + ". Guess a number that is in the range.");
                            }
                            else {
                                higherGuess = false;
                            }
                        }
                    }
                    
                    noGuess--;
                    int total = guesses-noGuess;
                    if (guess==random){
                        if (total == 1){
                            System.out.println("You Won :>! The number was " + random + ". You got it in " + total + " try.");
                        }
                        else {
                            System.out.println("You Won :>! The number was " + random + ". You got it in " + total + " tries.");
                        }
                        break;
                        
                    }
                    else if (noGuess == 0){
                        System.out.println("You Lost :<! The number was " + random + ".");
                    }
                    
                    
                }
                
                boolean end = false;
                while (end==false){
                    System.out.println("\nPlay Again (y/n)?");
                    String playAgain = sc.nextLine();
                    if (playAgain.equalsIgnoreCase("n")){
                        System.out.println("\nThank you for playing!");
                        return;
                    }
                    else if (playAgain.equalsIgnoreCase("y")){
                        break;
                    }
                    else {
                        System.out.println("Please type \"y\" or \"n\" only.");
                    }
                }
            }
            else if (option.equalsIgnoreCase("Change Settings")) {
                System.out.println("\n\nWhat is the lower limit of the random number?");
                String lower = sc.nextLine();
                min = Integer.parseInt(lower);
                
                System.out.println("What is the upper limit of the random number?");
                String upper = sc.nextLine();
                max = Integer.parseInt(upper);
                
                System.out.println("How many guesses are allowed?");
                String guessChoice = sc.nextLine();
                guesses = Integer.parseInt(guessChoice);
                
                System.out.println("\n\nLower limit: " + min);
                System.out.println("Upper limit: " + max);
                System.out.println("Guesses: " + guesses);
            }
            else if (option.equalsIgnoreCase("End Application")) {
                System.out.println("\nThank you for playing!");
                return;
            }
            else {
            System.out.println("Only enter whats in the options.");
            }
        }
    }
}
