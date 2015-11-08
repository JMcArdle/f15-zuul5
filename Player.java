import java.util.ArrayList;
/**
 * This class is part of _____, a text based adventure game created
 *  by modifying the "World of Zuul" game.
 * 
 * This is the player object that holds their item and equipment
 * 
 * @author Scott Taylor
 * @version 11/4/2015
 */
public class Player
{
    //fields
    private ArrayList<Item> inventory;
    private Item equipped;
    
    
    ///constructor///
    public Player()
    {
        inventory = new ArrayList<Item>();
        equipped = null;
    }
    
    ///methods///
    
    //setters//
    public void addToInventory(Item item)
    {
        inventory.add(item);
    }
    
    public boolean removeFromInventory(Item item)
    {
        if (has(item) == 1)
        {
            inventory.remove(item);
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * makes the player hold the item
     * 
     * @param item what item they want to hold
     * @return boolean whether they could equip it or not
     */
     public boolean equip(Item item)
    {
        if(has(item) == 2)
        {
            System.out.println("You're already holding that.");
            return false;
        }
        else if(has(item) == 1)
        {
            if(item.isEquipable())
            {
                if(equipped != null)
                {
                    addToInventory(equipped);
                }
                equipped = takeFromInventory(item);
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
        
    
    /**
     * takes item away from player
     * 
     * @param item to take away
     * @return boolean whether it was successful or not
     * 
     */
    public boolean takeAwayItem(Item item)
    {
        if(has(item)==2)
        {
            equipped = null;
            return true;
        }
        else if(has(item)==1)
        {
            removeFromInventory(item);
            return true;
        }
        else
        {
            return false;
        }
    }
    
    //getters//
    
    /**
     * finds if the player has the item
     * 
     * @param item the item to search for
     * @return int a value indicating whether the item is missing,
     * in the player's inventory, or equipped
     */
    public int has(Item item)
    {
        if(equipped == item)
            return 2;
        if(inventory.contains(item))
            return 1;
        else
            return 0;
    }
    
    
    /**
     * removes an item from the player's inventory
     * and returns the item removed
     * 
     * @param item the item to take
     * @return Item the item removed
     */
    public Item takeFromInventory(Item item)
    {
        if (has(item) == 1)
        {
            inventory.remove(item);
            return item;
        }
        else
        {
            return null;
        }
    }
    
    /**
     * returns player's equipped item
     * 
     * @return Item player's equipped item
     */
    public Item getEquipped()
    {
        return equipped;
    }
    
    /**
     * Uses an item
     * 
     * @param toUse the item to use
     */
    public String use(Item toUse)
    {
        String response = null;
        if(has(toUse) > 0)
        {
            response = toUse.getUse();
        }
        return response;
    }
    
    /**
     * returns the players's inventory
     * @return an ArrayList containing the player's inventory
     */
    public ArrayList<Item> getInventory()
    {
        return inventory;
    }
    
    
    
    
   
}
