// -----------------------------------------------------
// Tuan Anh Pham
// COMP249
// Assignment #1
// February 7, 2022
// -----------------------------------------------------

import java.util.Scanner; //importing scanner class

public class PlayLadderAndSnake {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in); //initializing the scanner object

        System.out.println("Enter the # of players for your game – Number must be between 2 and 4 inclusively: "); //prompting the user for the number of players
        int nbPlayer;

        //it lets the user 4 attempts to input the desired answer
        int count = 0;
        boolean isExhaustedChance = false;
        do {
            nbPlayer = in.nextInt();
            if (nbPlayer < 2 || nbPlayer > 4) {
                count++;
                if (count <= 3)
                    System.out.println("Bad Attempt " + count + " - Invalid # of players. Please enter a # between 2 and 4 inclusively:");
                else {
                    System.out.println("Bad Attempt 4! You have exhausted all your chances. The program will terminate!");
                    isExhaustedChance = true;
                }
            } else break;
        } while (count < 4);
        //it lets the user 4 attempts to input the desired answer

        if (!isExhaustedChance) { //if the user exceeded the number of attempts to enter a correct value for the number of players, the program will exit and the game will not start. Else, the game will start.
            in.nextLine();
            LadderAndSnake[] players = new LadderAndSnake[nbPlayer];//creating an array of type LadderAndSnake with the size of the number of players

            System.out.println("Game is Played by " + nbPlayer + " players");

            for (int i = 0; i < players.length; i++) { //prompting the user to enter the name of the players
                System.out.print("Enter the name for Player " + (i + 1) + ": ");
                String name = in.nextLine();
                players[i] = new LadderAndSnake(name);
            }
            System.out.println();

            System.out.println("Now deciding which player will start playing"); //deciding the order of playing turns

            for (int i = 0; i < nbPlayer; i++) { //rolling dice for each player in the array
                players[i].player.rollDice();
            }

            LadderAndSnake temp; //sorting players array in descending order of dice values. Players with highest dice rolling value start first and so on
            for (int i = 0; i < nbPlayer; i++) {
                for (int j = i + 1; j < nbPlayer; j++) {
                    if (players[j].player.getDiceValue() > players[i].player.getDiceValue()) {
                        temp = players[j];
                        players[j] = players[i];
                        players[i] = temp;
                    }
                }
            }

            //Keeping track of players who have the same dice rolling value
            boolean isSameValue=false;
            int a=0;
            int b=0;

            //looping through the array to find if there is a tie between the dice rolling dice value of 2 players
            for (int i = 0; i < nbPlayer; i++) {
                for (int j = 0; j < i; j++) {
                    if (players[i].player.getDiceValue() == players[j].player.getDiceValue()) {
                        System.out.println("A tie was achieved between " + players[j].player.getName() + " and " + players[i].player.getName() + ". Attempting to break the tie");
                        a = i;
                        b = j;
                        isSameValue = true;
                        break;
                    }
                }
            }

            //the 2 players with the same rolling dice value will keep re-rolling their dice until they got different dice rolling value
            while (isSameValue == true) {
                players[a].player.rollDice();
                players[b].player.rollDice();
                if (players[a].player.getDiceValue() != players[b].player.getDiceValue()) {
                    isSameValue = false;
                    break;
                } else {
                    System.out.println("A tie was achieved between " + players[b].player.getName() + " and " + players[a].player.getName() + ". Attempting to break the tie");
                }
            }

            //updating the turn between the 2 players who got the same dice value in the arrays depending on who got the highest dice rolling value
            LadderAndSnake anotherTemp;
            if (players[b].player.getDiceValue()<players[a].player.getDiceValue()){
                anotherTemp = players[b];
                players[b] = players[a];
                players[a] = anotherTemp;
            }

            System.out.print("Reached final decision on order of playing: "); //printing players turns
            for (int i = 0; i < nbPlayer; i++) {
                System.out.print(players[i].player.getName() + ", ");
            }

            System.out.println("Press ENTER to continue");//prompting to press enter to continue
            in.nextLine();

            //keeping track of the winner
            boolean isThereAWinner = false;
            String Winner = "";

            do { //the game officially starts
                for (int i = 0; i < nbPlayer; i++) { //looping through the array so that each player plays
                    players[i].play();
                    if (players[i].isWin()) { //if there is a winner
                        isThereAWinner = true;
                        Winner = players[i].player.getName(); //declaring the winner
                        break;
                    }
                }
                if (isThereAWinner == false) { //letting the user know that the game will continue because there is no winner yet
                    System.out.println("Game not over, flipping again");
                    System.out.println("------------------------------");
                    System.out.println("Press ENTER to continue");
                    System.out.print("------------------------------");
                    in.nextLine();
                } else {
                    System.out.println("------------------------------");
                    System.out.println("Game over, " + Winner + " is the winner!"); //letting the user know that the game has ended because there is a winner. Proceeding to announce the winner
                    System.out.println("Congratulation "+Winner+"!");
                }
            } while (!isThereAWinner); //the game will keep going if there is no winner yet

            System.out.println();
            System.out.println("Thank you for playing the game"); //displaying a farewell message to the user

        }

        in.close(); //closing the scanner object

    }
}