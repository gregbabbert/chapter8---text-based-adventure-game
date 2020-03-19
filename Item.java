
/**
 * This class is part of the "World of Zuul" application.   
 * Item class represents item and some related information of item such as description,
 * types and points.
 * 
 * @author Gobra team
 * @version March 17, 2020 
 */

public class Item {
	
	private String description;
	private int point;	
	private ItemType itemType;
	
	/**
        * This is the Item class constructor.
        */
	public Item(String description,int point) 
	{		
		this.description = 	description;
		this.point = point;
	}
	
	/**
        * This puts item types with item.
        */
	public void setItemType (ItemType itype) {
		this.itemType = itype;
	}
     /**
     * This gets the item description.
     */
     public String getDescription() {
		return this.description;
	}

        /**
        * This gets the item points.
        */
	public int getPoint() {
		return this.point;
	}
        
	/**
        * This is gets the points to the items.
        */
	public void setPoint(int point) { 
		this.point = point;
	}
	
	/**
        * This gets teh itemType.
        */
	public ItemType getItemType() {
		return this.itemType;
	}

}

