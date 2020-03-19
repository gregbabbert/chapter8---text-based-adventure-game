

/**
 * This class is part of the "World of Zuul" application.   
 * ItemType keeps the information about different types of stat so that 
 * appropriate stat can be used while assigning the points
 * 
 * @author Gobra team
 * @version March 17, 2020 
 */

public class ItemType {
	
     	private String description;	
    /**
    * This is the constructor of the ItemType class.
    */
    public ItemType(String descr) {	  
	  this.description = descr;
    }
    
    /**
    * This gets the description of the itemtype.
    */
    public String getDescription() {
	return this.description;
    }

    /**
    * This sets the description of the itemtype.
    */ 
    public void setDescription(String description) {
	this.description = description;
    }  
  
}
