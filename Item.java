
/**
 * This class is part of _____, a text based adventure game created
 *  by modifying the "World of Zuul" game.
 *  
 *  Contains all of the information of all items in the game.
 * 
 * @author Scott Taylor
 * @version (a version number or a date)
 */
public class Item
{
    //fields
    private String name;
    private String look;
    private String attack;
    private String lick;
    private String listen;
    private String dodge;
    private String grab;
    private boolean equipable;
    
    ///Constructor///
    /**
     * Constructor for creating each npc
     * Takes a string for each possible action to perform on the NPC
     * 
     * @param name their name
     * @param look when you look at them
     * @param attack when you attack them
     * @param when you lick them
     * @param when you listen to them
     * @param when you dodge them
     * @param when you grab them
     */
    public Item(String name, String look, String attack, String lick,
            String listen, String dodge, String grab, boolean equipable)
    {
        this.name = name;
        this.look = look;
        this.attack = attack;
        this.lick = lick;
        this.listen = listen;
        this.dodge = dodge;
        this.grab = grab;
        this.equipable = equipable;
    }
    
    
    ///Setters///
    
    /**
     * Sets their name
     * 
     * @param set attribute to set it to
     * 
     */
    public void setName(String set)
    {
        name = set;
    }
    
    
    /**
     * Sets their look reponse
     * 
     * @param set attribute to set it to
     * 
     */
    public void setLook(String set)
    {
        look = set;
    }
    
    /**
     * Sets their attack reponse
     * 
     * @param set attribute to set it to
     * 
     */
    public void setAttack(String set)
    {
         attack = set;
    }
    
    /**
     * Sets their lick reponse
     * 
     * @param set attribute to set it to
     * 
     */
    public void setLick(String set)
    {
        lick = set;
    }
    
    /**
     * Sets their listen reponse
     * 
     * @param set attribute to set it to
     * 
     */
    public void setListen(String set)
    {
        listen = set;
    }
    
    /**
     * Sets their dodge reponse
     * 
     * @param set attribute to set it to
     * 
     */
    public void setDodge(String set)
    {
        dodge = set;
    }
    
    /**
     * Sets their grab reponse
     * 
     * @param set attribute to set it to
     * 
     */
    public void setGrab(String set)
    {
        grab = set;
    }
    
    /**
     * if it can be equipped
     * 
     * @param set attribute to set it to
     * 
     */
    public void setEquipable(boolean set)
    {
        equipable = set;
    }
    
    ///Getters///
    
    
    /**
     * Gets their name
     * 
     * @return String the String to return
     * 
     */
    public String getName()
    {
        return name;
    }
    
    
    /**
     * Gets their look response
     * 
     * @return String the String to return
     * 
     */
    public String getLook()
    {
        return look;
    }
    
    /**
     * Gets their attack response
     * 
     * @return String the String to return
     * 
     */
    public String getAttack()
    {
        return attack;
    }
    
    /**
     * Gets their lick response
     * 
     * @return String the String to return
     * 
     */
    public String getLick()
    {
        return lick;
    }
    
    
    /**
     * Gets their listen response
     * 
     * @return String the String to return
     * 
     */
    public String getLiten()
    {
        return listen;
    }
    
    
    /**
     * Gets their dodge response
     * 
     * @return String the String to return
     * 
     */
    public String getDodge()
    {
        return dodge;
    }
    
    /**
     * Gets their grab response
     * 
     * @return String the String to return
     * 
     */
    public String getGrab()
    {
        return grab;
    }
    
    /**
     * Gets it can be equipped
     * 
     * @return boolean whether or not it can be equipp
     * 
     */
    public boolean isEquipable()
    {
        return equipable;
    }
    
    
    
    
    
}
