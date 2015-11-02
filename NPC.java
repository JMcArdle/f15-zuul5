import java.util.ArrayList;

/**
 * Write a description of class NPC here.
 * 
 * @author Scott Taylor
 * @version 11/2/2015
 */
public class NPC
{
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
    
    public NPC(String talk, String look, String attack, String leer, String lick, String torture,
                String escape, String listen, String dodge, String grab)
    {
        this.talk = new ArrayList<String>();
        this.talk.add(talk);
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
    
    public void addTalk(String toAdd)
    {
        talk.add(toAdd);
    }
    
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
}
