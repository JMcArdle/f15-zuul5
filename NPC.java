import java.util.ArrayList;
import java.util.Random;

/**
 * This class is part of _____, a text based adventure game created
 *  by modifying the "World of Zuul" game.
 *  
 *  This object contains all the information on the NPCs
 *  in the game and their reactions to all applicable commands
 * 
 * @author Scott Taylor
 * @version 11/2/2015
 */
public class NPC
{
    private String name;
    private ArrayList<String> talk;
    private String look;
    private String attack;
    private String leer;
    private String lick;
    private String torture;
    private String escape;
    private String listen;
    private String dodge;
    private String grab;
    
    /**
     * Constructor for creating each npc
     * Takes a string for each possible action to perform on the NPC
     * 
     * @param name their name
     * @param talk when you talk to them
     * @param look when you look at them
     * @param attack when you attack them
     * @param leer when you leer at them
     * @param when you lick them
     * @param when you torture them
     * @param when you escape them
     * @param when you listen to them
     * @param when you dodge them
     * @param when you grab them
     */
    public NPC(String name, String look, String attack, String leer, String lick, String torture,
                String escape, String listen, String dodge, String grab)
    {
        this.name = name;
        this.talk = new ArrayList<String>();
        this.look = look;
        this.attack = attack;
        this.leer = leer;
        this.lick = lick;
        this.torture = torture;
        this.escape = escape;
        this.listen = listen;
        this.dodge = dodge;
        this.grab = grab;
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
     * Method for adding a talking phrase to the npc
     * 
     * @param toAdd what phrase to add
     * 
     */
    public void addTalk(String toAdd)
    {
        talk.add(toAdd);
    }
    
    /**
     * Method for removing a phrase from an npc
     * 
     * @param toRemove what phrase to remove
     * @return boolean returns true if the method found the phrase to remove
     */
    public boolean removeTalk(String toRemove)
    {
        if (talk.contains(toRemove))
        {
            talk.remove(toRemove);
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Method for removing everything an npc will say
     * 
     */
    public void removeAllTalk()
    {
        for(String say : talk)
        {
            talk.remove(say);
        }
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
     * Sets their leer reponse
     * 
     * @param set attribute to set it to
     * 
     */
    public void setLeer(String set)
    {
        leer = set;
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
     * Sets their torture reponse
     * 
     * @param set attribute to set it to
     * 
     */
    public void setTorture(String set)
    {
        torture = set;
    }
    
    /**
     * Sets their escape reponse
     * 
     * @param set attribute to set it to
     * 
     */
    public void setEscape(String set)
    {
        escape = set;
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
     * Gets one of their talking responses
     * 
     * @return String the String to return
     * 
     */
    public String getTalk()
    {
        if(talk.isEmpty())
            return "They have nothing to say to you.";
        else
        {
            Random rng = new Random();
            int say = rng.nextInt(talk.size());
            return talk.get(say);
        }
    }
    
    /**
     * Gets one of their talking responses and
     * removes it if the remove flag is true
     * 
     * @return String the String to return
     * 
     */
    public String getTalk(boolean remove)
    {
        if(talk.isEmpty())
            return "They have nothing to say to you.";
        else
        {
            Random rng = new Random();
            int say = rng.nextInt(talk.size());
            String store = talk.get(say);
            if (remove == true)
                talk.remove(say);
            return store;
        }
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
     * Gets their leer response
     * 
     * @return String the String to return
     * 
     */
    public String getLeer()
    {
        return leer;
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
     * Gets their torture response
     * 
     * @return String the String to return
     * 
     */
    public String getTorture()
    {
        return torture;
    }
    
    /**
     * Gets their escape response
     * 
     * @return String the String to return
     * 
     */
    public String getEscape()
    {
        return escape;
    }
    
    /**
     * Gets their listen response
     * 
     * @return String the String to return
     * 
     */
    public String getListen()
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
    
}
