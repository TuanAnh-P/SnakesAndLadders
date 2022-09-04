// -----------------------------------------------------
// Tuan Anh Pham
// COMP249
// Assignment #1
// February 7, 2022
// -----------------------------------------------------

/**
 * LadderAndSnake class.
 * @author Tuan Anh Pham
 */
public class LadderAndSnake {

    /**
     * Declaring a board of type Integer.
     */
    private int[] board;
    /**
     * Declaring a player of type Player.
     */
    public Player player;
    /**
     * Initializing the last position of the board.
     */
    private final int winPoint=100;


    /**
     * Default constructor that set the position of the snakes and ladders on the board.
     * It initializes the board with a size of 100
     * The value between the bracket is the entry of the ladders/snakes and the actual value of the element is the exit of the ladders/snakes
     * It initializes the player
     */
    public LadderAndSnake(){
        board=new int[100];
        // positions of the ladders
        board[1]=38;
        board[4]=14;
        board[9]=31;
        board[21]=42;
        board[28]=84;
        board[36]=44;
        board[51]=67;
        board[71]=91;
        board[80]=100;
        // positions of the snakes
        board[16]=6;
        board[48]=30;
        board[64]=60;
        board[79]=19;
        board[93]=68;
        board[95]=24;
        board[97]=76;
        board[98]=78;
        player=new Player();
    }

    /**
     * Constructor that initialize the name of the player.
     * @param name of the player
     */
    public LadderAndSnake(String name){
        this();
        player.setName(name);
    }

    /**
     * Method that simulate a dice rolling.
     * @return a random integer between 1 and 6
     */
    public int flipDice(){
        return (int)(Math.random()*6+1);
    }

    /**
     * Method that move a player based on the result of his dice rolling.
     * It also prevents the playing of exceeding the position 100 on the board by moving the player backward if the dice rolling exceeds the maximum possible move
     * @return the displacement of the player which is also the result of his dice rolling
     */
    public int movePlayer(){
        int displacement=flipDice();
        if (player.getPosition()+displacement>100){
            int temp=(player.getPosition()+displacement)-100;
            player.setPosition(100-temp);
        }
        else player.move(displacement);
        return displacement;
    }

    /**
     * Method that set the player at the exit of the snake if he ever lands on its entry.
     * @return a boolean on where if the player land on a position of the board that has an entry of a snake
     */
    public boolean isLadder(){
        boolean isLadder=false;
        switch (player.getPosition()){
            case 1:
                player.setPosition(board[1]);
                isLadder=true;
                break;
            case 4:
                player.setPosition(board[4]);
                isLadder=true;
                break;
            case 9:
                player.setPosition(board[9]);
                isLadder=true;
                break;
            case 21:
                player.setPosition(board[21]);
                isLadder=true;
                break;
            case 28:
                player.setPosition(board[28]);
                isLadder=true;
                break;
            case 36:
                player.setPosition(board[36]);
                isLadder=true;
                break;
            case 51:
                player.setPosition(board[51]);
                isLadder=true;
                break;
            case 71:
                player.setPosition(board[71]);
                isLadder=true;
                break;
            case 80:
                player.setPosition(board[80]);
                isLadder=true;
                break;

        }
        return isLadder;
    }

    /**
     * Method that set the player at the exit of the ladder if he ever lands on its entry.
     * @return a boolean on if the player land on a position of the board that has an entry of a ladder
     */
    public boolean isSnake(){
        boolean isSnake=false;
        switch (player.getPosition()){
            case 16:
                player.setPosition(board[16]);
                isSnake=true;
                break;
            case 48:
                player.setPosition(board[48]);
                isSnake=true;
                break;
            case 64:
                player.setPosition(board[64]);
                isSnake=true;
                break;
            case 79:
                player.setPosition(board[79]);
                isSnake=true;
                break;
            case 93:
                player.setPosition(board[93]);
                isSnake=true;
                break;
            case 95:
                player.setPosition(board[95]);
                isSnake=true;
                break;
            case 97:
                player.setPosition(board[97]);
                isSnake=true;
                break;
            case 98:
                player.setPosition(board[98]);
                isSnake=true;
                break;
        }
        return isSnake;
    }

    /**
     * Method that let know if a player is on the position 100 on the board which means he has won the game.
     * @return a boolean on if the player has won the game or not
     */
    public boolean isWin(){
        if(player.getPosition()==winPoint)return true;
        else return false;
    }

    /**
     * Method that start the game for ONE PLAYER.
     * It prints the name of the player, his dice rolling result and update his position
     * It also prints if the player land on a snake or a ladder
     * If yes, it then updates his position
     */
    public void play(){
        System.out.println(player.getName()+" got a dice value of "+movePlayer()+", now in square "+player.getPosition());
        if(isLadder()){
            System.out.println(player.getName()+" finds a ladder that bring him to square "+player.getPosition());
        }
        else if(isSnake()){
            System.out.println(player.getName()+" falls on a snake that bring him to square "+player.getPosition());
        }
    }

}
