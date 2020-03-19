

/**
 * This class is part of the "World of Zuul" application.   
 * Player class represents player and some related information about player such as 
 * description players stat 
 * 
 * @author Gobra team
 * @version March 17, 2020 
 */

import java.util.Random;

public class Player {
	 	
	private String description;
	private String longDescription;
	private int playerHealth; 
	private int playerStrength;
	private int playerDefense;
	
	/**
        * This is the constructor for the Player class.
        */
	public Player(int min, int max, String description, String longDscr) {
		this.description = description;
		this.longDescription = longDscr;
		
		 // Initialize the health, strength, and defense statistics in random manner
		playerHealth = this.getMaxMinRandScore(min, max);
		playerStrength = this.getMaxMinRandScore(min, max);
		playerDefense = this.getMaxMinRandScore(min, max);   
	}
	
	  /**
          * This is is used to get the description.
          */	
	  public String getDescription() {
		return description;
	}
        
	/**
        * This is used to get the long description.
        */
	public String getLongDescription() {
		return longDescription;
	}
        
	/**
        * This is used to get the player's health stat.
        */
	public int getPlayerHealth() {
		return playerHealth;
	}
        
	/**
        * This is used to set the player's health stat.
        */
	public void setPlayerHealth(int playerHealth) {
		this.playerHealth = playerHealth;
	}
	/**
        * This is used to set the player's strength stat.
        */   
	public int getPlayerStrength() {
		return playerStrength;
	}
        
	/**
        * This is used to get the player's defense stat.
        */
	public int getPlayerDefense() {
		return playerDefense;
	}
     
     /**
     * This creates a random score between a min and a max.
     */
     private int getMaxMinRandScore (int min, int max ) {
	 Random random = new Random();
	 int randNum = random.nextInt(max-min +1) + min;
	 return randNum;
     }
}    
