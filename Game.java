
import java.util.ArrayList;
import java.util.Random;


/**
 *  "World of Zuul" is a game where a student goes around their campus to gather
    supplies to be able to defeat the dean. This is the game class, which is
    used to create all the functions necessary for the game.* 
 *
 * 
 * @author Gobra team
 * @version March 17, 2020
 * 
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Room lobby, hallway1,hallway2, hallway7, hallway3,hallway4, hallway5,hallway6, storeRm, scStoreRm;
    private Room library, constructionSite,recRm,pub,bathRm1, bathRm2,bathRm3, lectureRm1,lectureRm2; 
    private Room cafe,gym, menLockerRm, womenLockerRm, admin, barser, laboratory;
    private Room healthOffice, waitingRm, recordRm, windowCutout,deanOffice;     
    private Item bat, shield,beer,soda,book,goggles,coffee,helmet,laser,pad,tuitionbill,vitamin,steroid;
    private Item spray,sandwich,sanitizer,study,assignment,nap,record,tonic, gloves;
    private ItemType health, strength, defense;
    private Player dean;
    private int healthScore, strenghtScore, defenseScore;    
    private ArrayList<Room> roomTrack;
    private ArrayList<Item> usedItemTrack;
    private static int maxNumOfItems = 15;
    private static int constructionPenalty = 10;
    boolean finished;   
        
    /**
     * Create the game and initialize its internal map.
     */
    public Game() 
    {
        createRooms();
        createItems();
		createItemType();
		createPlayer();
		itemItemType();
		itemRoom();
        parser = new Parser();  
        this.usedItemTrack = new ArrayList<Item>();
        this.roomTrack = new ArrayList<Room>();       
        
        // Initialize the health, strength, and defense statistics in random manner
        healthScore = this.getMaxMinRandScore(15, 35);
        strenghtScore = this.getMaxMinRandScore(15, 35);
        defenseScore = this.getMaxMinRandScore(15, 35);           
    }
    
    /**
     * This mehtod creates the dean.
     */
    
     private void createPlayer() {
   	 this.dean = new Player(70,90,"Dean","University Dean");    	 
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {      
        // create the rooms
    	lobby = new Room("at the lobby of university");
        hallway1 = new Room("in hallway within university campus");
        hallway2 = new Room("in hallway within university campus");
        hallway7 = new Room("in hallway within university campus");
        hallway3 = new Room("in hallway within university campus");
        hallway4 = new Room("in hallway within university campus");
        hallway5 = new Room("in hallway within university campus");
        hallway6 = new Room("in hallway within university campus");        
        library = new Room("in the university library...it has item : book");       
        recRm = new Room("in the recreation center...it has items: soda,sandwich");
        pub = new Room("in the campus pub...it has item: beer");
        storeRm = new Room("in a university store room...it has items: bat, spray");
        bathRm1 = new Room ("in a bath room...it has item: sanitizer");
        bathRm2 = new Room ("in a bath room...it has item: shield");
        bathRm3 = new Room ("in a bath room...it has no item");
        lectureRm1 = new Room ("in a computer lecture room...it has item: study");
        lectureRm2 = new Room ("in a math lecture room...it has item: assignment");
        cafe = new Room ("in the campus cafeteria...it has item: coffee");
        gym = new Room ("in the campus gym...it has item: gloves");
        menLockerRm = new Room ("in the men's locker room...it has item: helmet");
        womenLockerRm = new Room ("in the women's locker room...it has items: tonic, pad");
        admin = new Room ("in the admin office");
        barser = new Room ("in the barser office...it has item: tuitionbill");
        laboratory = new Room ("in the computer lab class...it has item: laser");
        healthOffice = new Room ("in the university health center...it has items: vitamin, steroid");
        waitingRm = new Room ("in the waiting room to the dean...it has item: nap");
        recordRm = new Room ("in the university record room...it has item: record");
        scStoreRm = new Room ("in the university store room for students' materials...it has item: goggles");
        
        constructionSite = new Room("in the construction site, and the middle of danger zone");
        this.windowCutout = new Room("falling through the window cutout...you will be dead...");        
        deanOffice = new Room ("in the dean's office...the dean launches an attack");        
                
        // initialize room exits
        lobby.setExit("west", hallway7);
        lobby.setExit("east", hallway1);
        lobby.setExit("south", library);
        
        hallway7.setExit("west", constructionSite);
        hallway7.setExit("south", recRm);
        hallway7.setExit("east",lobby);
        
        recRm.setExit("north",hallway7);
        recRm.setExit("south",pub);
        recRm.setExit("west",storeRm);
        
        pub.setExit("west", bathRm2);
        pub.setExit("north", recRm);
        
        bathRm2.setExit("east", pub);
        this.bathRm2.setExit("west", windowCutout);
        
        storeRm.setExit("east", recRm);
        
        library.setExit("south", bathRm1);
        library.setExit("north", lobby);
        
        bathRm1.setExit("north", library);
        
        hallway1.setExit("north", lectureRm1);
        hallway1.setExit("south", scStoreRm);
        hallway1.setExit("west",lobby);
        hallway1.setExit("east",hallway2);
        
        lectureRm1.setExit("south",hallway1);
        
        scStoreRm.setExit("north",hallway1);
        
        hallway2.setExit("north", cafe);
        hallway2.setExit("south", lectureRm2);
        hallway2.setExit("west",hallway1);
        hallway2.setExit("east",hallway3);
        
        cafe.setExit("south", hallway2);
        
        lectureRm2.setExit("north", hallway2);
        lectureRm2.setExit("east", laboratory);
        
        laboratory.setExit("west", lectureRm2);
        
        hallway3.setExit("west",hallway2);
        hallway3.setExit("east",hallway4);        
              
        hallway4.setExit("east",hallway5);
        hallway4.setExit("north",gym);
        hallway4.setExit("west",hallway3);
        this.hallway4.setExit("south", windowCutout);        
        
        gym.setExit("south", hallway4);
        gym.setExit("north", womenLockerRm);
        gym.setExit("east", bathRm3);
        gym.setExit("west", menLockerRm);
        
        womenLockerRm.setExit("south", gym);
        
        menLockerRm.setExit("east", gym);        
        
        bathRm3.setExit("west", gym);
        bathRm3.setExit("south", hallway5);
        this.bathRm3.setExit("north", windowCutout);
        
        hallway5.setExit("west",hallway4);
        hallway5.setExit("east",hallway6);
        hallway5.setExit("north", bathRm3);
        hallway5.setExit("south", waitingRm);
        
        waitingRm.setExit("north",hallway5);
        waitingRm.setExit("east",deanOffice);
        waitingRm.setExit("south",recordRm);
        
        recordRm.setExit("north",waitingRm);
        
        hallway6.setExit("east",healthOffice);
        hallway6.setExit("north", barser);
        hallway6.setExit("west",hallway5);
        
        barser.setExit("south", hallway6);
        barser.setExit("north", admin);
        
        admin.setExit("south", barser);
        
        healthOffice.setExit("west", hallway6);        
              
        this.deanOffice.setExit("west", waitingRm);
        
        currentRoom = lobby;        
   }    
          
   /**
     * This method creates the different items.
     */
   
     private void createItems() {
    	 this.bat = new Item("bat", 5);
    	 this.shield = new Item("shield", 10);
    	 this.beer = new Item("beer", 10);
    	 this.soda = new Item("soda",10);
    	 this.book = new Item("book", 10);
    	 this.goggles = new Item("goggles", 5);
    	 this.coffee = new Item("coffee", 5);
    	 this.helmet = new Item("helmet", 10);
    	 this.laser = new Item("laser", 30);
    	 this.pad = new Item("pad", 20);
    	 this.tuitionbill = new Item("tuitionbill", -10);
    	 this.vitamin = new Item("vitamins", 30);
    	 this.steroid = new Item("steroids", 20); 
    	 this.spray = new Item("spray",15);
    	 this.sandwich = new Item("sandwich", 10);
    	 this.sanitizer = new Item("sanitizer", 10);
    	 this.study = new Item("study", -10);
    	 this.assignment = new Item("assignment", -15);
    	 this.nap = new Item("nap", -10);
    	 this.record = new Item("record", 5); 
    	 this.tonic = new Item("tonic",15);    
    	 this.gloves = new Item("gloves",10);
     } 	  	 
     
   /**
     * This method creates the different item types. Based on an item's you
     * either gain or lose health, strength, or defense.
     */
     
     private void createItemType() {
        this.health = new ItemType("Health");
        this.strength = new ItemType("Strength");
        this.defense = new ItemType("Defense");
     }     
         
   /**
     * This method puts items in different rooms.
     */
     
     private void itemRoom () {       	 
    	 this.storeRm.setItems(bat);
    	 this.scStoreRm.setItems(spray);
    	 this.recRm.setItems(soda);
    	 this.recRm.setItems(sandwich);
    	 this.bathRm2.setItems(shield);
    	 this.bathRm1.setItems(sanitizer);
    	 this.lectureRm1.setItems(study);
    	 this.lectureRm2.setItems(assignment);
    	 this.pub.setItems(beer);
    	 this.library.setItems(book);
    	 this.scStoreRm.setItems(goggles);
    	 this.cafe.setItems(coffee);
    	 this.menLockerRm.setItems(helmet);
    	 this.laboratory.setItems(laser);
    	 this.womenLockerRm.setItems(pad);
    	 this.womenLockerRm.setItems(tonic);
    	 this.barser.setItems(tuitionbill);
    	 this.waitingRm.setItems(nap);
    	 this.recordRm.setItems(record);
    	 this.healthOffice.setItems(vitamin);
    	 this.healthOffice.setItems(steroid); 
    	 this.gym.setItems(gloves);
     }
     
     /**
     * This method determines whether an item is type health, defense, or
     * strength.
     */
     
     private void itemItemType () {
    	 this.bat.setItemType(this.health);
    	 this.shield.setItemType(this.defense);
    	 this.beer.setItemType(this.health);
    	 this.coffee.setItemType(this.health);
    	 this.goggles.setItemType(this.defense);
    	 this.book.setItemType(this.strength);
    	 this.helmet.setItemType(this.defense);
    	 this.laser.setItemType(this.strength);
    	 this.vitamin.setItemType(this.health);
    	 this.steroid.setItemType(this.strength);
    	 this.pad.setItemType(this.defense);
    	 this.soda.setItemType(this.health);     	 
    	 this.tuitionbill.setItemType(this.health);
    	 this.assignment.setItemType(this.strength);
    	 this.study.setItemType(this.strength);
    	 this.sandwich.setItemType(this.health);
    	 this.sanitizer.setItemType(this.health);
    	 this.spray.setItemType(this.defense);
    	 this.nap.setItemType(this.health);
    	 this.record.setItemType(this.strength);
    	 this.tonic.setItemType(this.health);
    	 this.gloves.setItemType(this.defense);
     }
     
     /**
     * This method is used to show the room in the tracking array.
     */
    
     private void showTrackedRooms() {
     	roomTrack.forEach((n)-> System.out.println(n));
     }
     
     /**
     * This method is used to show the items picked up so far.
     */
     
     private void showPickupItems() {
    	 usedItemTrack.forEach((n) -> System.out.println(n.getDescription()));
     }
     
     /**
     * This method shows the player's current stat.
     */
     
     private void showCurrentStat() {
    	 System.out.println("your current stat:- Health " + this.healthScore + ", Strength "+ this.strenghtScore + ", Defense "+ this.defenseScore);
     }
     
     /**
     * This method is used for a random score generation with a min-max.
     */
     
     private int getMaxMinRandScore (int min, int max ) {
    	 Random random = new Random();
    	 int randNum = random.nextInt(max-min +1) + min;
    	 return randNum;
     }
     
     /**
     * This method is used for setting the finished condition.
     */
    
     private boolean setfinished () {    	 
    	 if (this.currentRoom == this.windowCutout) {
    		 return true;   	    	 
    	 }  else if (this.healthScore <= 0 || this.strenghtScore <= 0 || this.strenghtScore <= 0){
    		 		System.out.println("your health is crushed ...you are dead...");
    		 		return true;
    	         } else if (this.dean.getPlayerHealth() <= 0) {
    	        	        return true;
    	                 }
    		 return false;    	       	     	 
     };        
     
     /**
     * This method is used for the reduction of the player's health after
     * the dean attacks.
     */
    
     private void deanAttackPlayer() {
    	 if (this.dean.getPlayerStrength() > this.defenseScore) {
    		 this.healthScore = this.healthScore - (this.dean.getPlayerStrength() - this.defenseScore);          
    	 }    		 
     }
     
     /**
     * This method is used for the reduction of the dean's health after
     * the player attacks.
     */
    
     private void playerAttackDean() {
    	 if (this.strenghtScore > this.dean.getPlayerDefense()) {    		 
    	  this.dean.setPlayerHealth(this.dean.getPlayerHealth() - (this.strenghtScore - this.dean.getPlayerDefense()));
    	 }
     }
             	
    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.  
    	this.finished = false;    	
        while (finished == false) {         	     
        	Command command = parser.getCommand();        	
            this.finished = processCommand(command);             
            this.finished = this.setfinished(); 
        }
        System.out.println("Thank you for playing.  Good bye.");        
    }

    /**
     * Print out the opening message for the player.
     */
    public void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of New Zuul!");
        System.out.println("you are at the lobby of the university and are about enter and move aournd within the university campus");
        System.out.println("your objective is to win the contest against the dean who likes to attack the students");
        System.out.println("make sure you are ready before you meet the dean"); 
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
                
            case PICKUP:
            	pickItems(command);
            	break;
            	
            case BACK:
            	moveBack();
            	break;
            	
            case CHECK:
            	checkBag(command);
            	break;
            	
            case LOOK:
                look();
                break;
            	
            case DROP:
            	dropItem(command);
            	break;
            	
            case ATTACK:
            	attackDean(command);
            	break;
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {           
    	System.out.println("you are lost. you are alone. you wander");
    	System.out.println("this is mostly two-word text game, involving a command word and another one");
    	System.out.println("look for a clue for the second word");
    	System.out.println("remember the traps");
    	System.out.println("");
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new room, otherwise print an error message.
     * if the player hits the construction site, he will be ported back to the lobby and incur the penalty.
     * if the player falls through the window cut-out, the game will be over 
     * if the player enters into the dean's room, the dean will attack him and try to knock down the player's health
     * if any situation, any of the players stat reaches to zero or less, the game will be over
     * @param command
     */
    private void goRoom(Command command) 
    {    	
    	if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }       
        String direction = command.getSecondWord();               
        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);                    
        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            if (this.currentRoom.equals(this.constructionSite)) {
            	System.out.println(currentRoom.getLongDescrWithoutExit());
            	System.out.println("you see a flash of light...you find yourself back in the lobby in weaken health");
            	this.currentRoom = this.lobby;
            	this.healthScore = this.healthScore - constructionPenalty;
            	this.strenghtScore = this.strenghtScore - constructionPenalty;
            	this.defenseScore = this.defenseScore - constructionPenalty;
            	this.showCurrentStat();            	
            } else {
            		if(this.currentRoom.equals(this.windowCutout)) {
            			System.out.println(currentRoom.getLongDescrWithoutExit());
            			this.currentRoom = this.windowCutout;
            			         			
            		} else {
            			   if (this.currentRoom.equals(this.deanOffice)) {
            				   System.out.println(currentRoom.getLongDescrWithoutExit());
            				   this.deanAttackPlayer();
            			   	   System.out.println("attack dean and defect him to win the contest...");
            			   	   this.showCurrentStat();
	            			   } else {
						              System.out.println(currentRoom.getLongDescription());
						              this.roomTrack.add(currentRoom); 
	            			          }
            		}
             }
         }      
    }
  /**
   * Pick items for points. if the item does not match, let the player know. 
   * if the item matches, add the point to the right category of stat - health, strength, defense.
   * the items can have negative and positive points
   * Player can only pick up one item once in an entire game.
   * the restriction is on place as to numbers of items the player can pick
   * @param command
   */
	private void pickItems(Command command) {			
		if (command.hasSecondWord()) {				
			String pickupItem = command.getSecondWord();
			if(this.usedItemTrack.size() <= (this.maxNumOfItems -1)) {
				for (Item pkIt : this.currentRoom.getItems()) {
					if (pkIt.getDescription().equals(pickupItem)) {
						if(this.usedItemTrack.contains(pkIt)) {
							System.out.println("you have already picked up this item...");
						} else {
							String itemTy = pkIt.getItemType().getDescription();
							this.usedItemTrack.add(pkIt);
							System.out.println("you have successfully pickup the item: "+ pkIt.getDescription());
							switch (itemTy) {
							case "Health":
								healthScore = healthScore + pkIt.getPoint();
								break;
							case "Strength":
								strenghtScore = strenghtScore + pkIt.getPoint();
								break;
							case "Defense":
								defenseScore = defenseScore + pkIt.getPoint();
								break;
						    }
						    this.showCurrentStat();
						}  
					} else {
						System.out.println("pick up the wrong item...item does not match");					       
					}
				} 				
				} else {
					System.out.println("you have picked up maximun numbers of items: " + this.maxNumOfItems);
				}				
		} else {
			// if there is no second word, we do not know what items to pick...
			System.out.println("Pick what?");
			return;
		}
	}	
	/**
	 * "BACK" command will move back the player to the preceding rooms sequentially
	 */
	 private void moveBack() 
	    {    		   
		   if (this.currentRoom.equals(this.hallway7) || this.currentRoom.equals(this.hallway1) || this.currentRoom.equals(this.library)) {
			   this.currentRoom = this.lobby;
			   System.out.println(this.currentRoom.getBackLongDescription());
		   } else if (this.currentRoom.equals(this.lobby)) {
			   System.out.println(this.currentRoom.getBackLongDescription());
		   } else {
			    int currentPos = this.roomTrack.size();
                this.currentRoom= this.roomTrack.get(currentPos -2);
                System.out.println(this.currentRoom.getBackLongDescription());           
                  // remove current position from the tracking
                this.roomTrack.remove(currentPos - 1);
                return;
		   }
	    }
	 /** 
	     * check the list of picked up items and current statistics
	     * print the message if the player tries to anything besides the list of picked up items and stat
	     * print the message if nothing is written after the command
	     * @param command
	     */
	    private void checkBag(Command command) 
	    {    	
	    	if(command.hasSecondWord()) {	              
	             String instruction = command.getSecondWord();               
	                 if (instruction.contentEquals("bag")) {
             	 		System.out.println("here are items you have picked up so far"); 
             	 		this.showPickupItems();
             	 	    } else if (instruction.contentEquals("stat")) {
	                	 		this.showCurrentStat();
	                	 	    }  else if (!instruction.equals("bag") || instruction.equals("stat")) {
	                	 	    	          System.out.println("the game only checks pickup items in the bag or stat...what do you want bag or stat...");
	                	 	    	          }	                	 
	                } else {
	                	   System.out.println("check what?...");
	                	   return;
	                }
	     } 
	    
		 /** 
	     * check the list of picked up items and current statistics
	     * print the message if the player tries to anything besides the list of picked up items and stat
	     * print the message if nothing is written after the command
	     * @param command
	     */
	    private void dropItem(Command command) 
	    {    	
	    	if(command.hasSecondWord() && this.usedItemTrack.size() > -1) {	              
	             String dropIt = command.getSecondWord(); 
	             Item drItHolder = null;	           
	                 for (Item drIt:this.usedItemTrack) {	                	 
             	 		     if (drIt.getDescription().equals(dropIt)) 
	                	        drItHolder = drIt;
             	 	  }     
	                 		    if (drItHolder != null) {	                 		    	
			             	 		this.usedItemTrack.remove(drItHolder);
			             	 		String drItemTy = drItHolder.getItemType().getDescription(); 
			             	 		switch (drItemTy) {
			    					case "Health":
			    						healthScore = healthScore - drItHolder.getPoint();
			    						break; 
			    					case "Strength":
			    						strenghtScore = strenghtScore - drItHolder.getPoint();
			    						break;
			    					case "Defense":
			    						defenseScore = defenseScore - drItHolder.getPoint();
			    						break; 
			             	 		 }
	                       }  
	                 		    if (drItHolder != null) {
			                 		System.out.println("you have successfully dropped the item: " + drItHolder.getDescription()); 
			                 		this.showCurrentStat();
	                 		        }	else {
	                 		        	System.out.println("item is not in the bag...so can't be dropped...");
	            	                }			             	 		                 		  
	          }  else {
       	 		System.out.println("drop what?...");
	            return;
	          }	    	
	    }
	 
	    /** 
	     * check the list of picked up items and current statistics
	     * print the message if the player tries to anything besides the list of picked up items and stat
	     * print the message if nothing is written after the command
	     * @param command
	     */
	    private void attackDean(Command command) 
	    {    	
	    	if(command.hasSecondWord()) {	              
	             String nonPlayer = command.getSecondWord();               
	                 if (nonPlayer.contentEquals("dean")) {
	                	 // reduce dean's health and then player's health
	                	 this.playerAttackDean();
	                	 this.deanAttackPlayer();              	
	                	 this.showCurrentStat(); 
	                	 if (this.healthScore <= 0) {
	                		 System.out.println("you lost to the dean...");
	                	  } else if (this.dean.getPlayerHealth() <= 0) {
	                	    	 System.out.println("you defected the dean...congratulation..");
	                	         }
	                   }
	                                    
	         } else {
          	   System.out.println("check what?...");
          	   return;
	           }
	     }
	 /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @param command
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
    
    /** 
     * This method has the player look at what room they're in,
     * which then prints out the description of the room.
     */
    private void look() {
        System.out.println(currentRoom.getLongDescription());
    }
}

