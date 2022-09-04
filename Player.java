// -----------------------------------------------------
// Tuan Anh Pham
// COMP249
// Assignment #1
// February 7, 2022
// -----------------------------------------------------

/**
 * Player class.
 * @author Tuan Anh Pham
 */
public class Player {

    /**
     * Declaring a String name to store player's name.
     */
    private String name;
    /**
     * Declaring an integer position to keep track of a player's position and an integer diceValue to keep track of a player's dice rolling value.
     */
    private int position, diceValue;

    /**
     * Default constructor that set the position of the player to 0.
     */
    public Player(){
        this.position=0;
    }

    /**
     * Constructor that set the name of the player.
     * @param name of the player
     */
    public Player(String name){
        this();
        this.name=name;
    }

    /**
     * Getter for the player's name.
     * @return the player's name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the player's name.
     * @param name of the player
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the player's position.
     * @return an integer which is the player's position
     */
    public int getPosition() {
        return position;
    }

    /**
     * Setter for the player's position.
     * @param position of the player
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * Method that move the player.
     * It adds a displacement obtained by the player rolling dice to its position
     * @param displacement of the playing by dice rolling
     */
    public void move(int displacement){
        this.position+=displacement;
    }

    /**
     * Method that simulate a dice rolling.
     * @return a random integer between 1 and 6
     */
    public int flipDice(){
        return (int)(Math.random()*6+1);
    }

    /**
     * Getter for the dice value of a player.
     * It's later use to determine the order of playing turns
     * @return a integer done by dice rolling
     */
    public int getDiceValue() { return diceValue; }

    /**
     * Setter for the dice value of a player.
     * It's later use to determine the order of playing turns
     * @param diceValue of a player
     */
    public void setDiceValue(int diceValue) { this.diceValue = diceValue; }

    /**
     * Method that flip Dice and store the result of the dice rolling of a player.
     * It's later use to determine the order of playing turns
     */
    public void rollDice() {
        diceValue=flipDice();
        System.out.println(getName()+" got a dice value of "+diceValue);
    }

}
