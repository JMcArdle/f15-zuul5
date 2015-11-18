import java.util.StringTokenizer;
import java.util.ArrayList;

/**
 * This class is part of _____, a text based adventure game created
 *  by modifying the "World of Zuul" game.
 * 
 * This class reads, interprets and executes the internal commands passed from object
 * descriptions when their various interactions are called by the player
 * 
 * @author Scott Taylor
 * @version 11/8/2015
 */
public class InternalCommandProcessor
{
    private StringTokenizer tokens;
    private StringTokenizer command;
    private Player player;
    private Room currentRoom;
    private ArrayList<Room> allRooms;
    private NameResolver resolver;
    private int bottles = 0;

    /**
     * Constructor
     * 
     * @param room the current room the player is in
     * @param player the player object
     * @param allRooms a list of all the rooms in the game
     */
    public InternalCommandProcessor(Room room, Player player, ArrayList<Room> allRooms)
    {
        this.currentRoom = room;
        this.player = player;
        this.allRooms = allRooms;
        resolver = new NameResolver(room, player, allRooms);
    }
        
        
    
    /**
     * This method is responsible for interpreting and executing any methods
     * called for by the descriptions of items when the player interacts with them.
     * 
     * It does this via a psudo-command line style of checking for arguments passed
     * as separate tokens after the printed description from the object.
     */
    public void execute(String exe)
    {
        tokens = new StringTokenizer(exe, "|");
        if (tokens.hasMoreTokens())
        {
            tokens.nextToken(); //remove the regular output before processing
        }
        while(tokens.hasMoreTokens())
        {
            command = new StringTokenizer(tokens.nextToken());
            if (command.hasMoreTokens())
            {
                switchCommands();
            }
        }
    }
    
    /**
     * Moves the player to another room
     */
    private void goMovePlayer()
    {
        if(command.hasMoreTokens())
        {
            String arg1 = command.nextToken();
            if(arg1.equalsIgnoreCase("to"))
            {
                if(command.hasMoreTokens())
                {
                    arg1 = command.nextToken();
                }
                else
                {
                    System.out.println("Debug: the move player command didn't specify where to move");
                }
            }
            Room destination = resolver.resolveRoom(arg1);
            if ( destination !=null)
            {
                currentRoom = destination;
            }
        }
        else
        {
            System.out.println("Debug: the move player command didn't specify where to move");
        }
    }
    
    /**
     * Moves an npc to another room
     */
    private void goMoveNPC()
    {
        if(command.countTokens() >= 3)
        {
            String arg1 = command.nextToken();
            String arg2 = command.nextToken();
            if (arg2.equalsIgnoreCase("to"))
            {
                if(command.hasMoreTokens())
                {
                    arg2 = command.nextToken();
                }
                else
                {
                    System.out.println("Debug: the move player command didn't specify where to move");
                }
            }
            NPC npcToMove = resolver.resolveNPCFromCurrentRoom(arg1);
            if(npcToMove == null)
            {
                npcToMove = resolver.resolveNPCFromGlobal(arg1);
            }
            if(npcToMove != null)
            {
                Room goTo = resolver.resolveRoom(arg2);
                if (goTo != null)
                {
                    resolver.findNPC(npcToMove).removeNPC(npcToMove);
                    goTo.addNPC(npcToMove);
                }
                else
                {
                    System.out.println("Debug: that room couldn't be found.");
                }
            }
            else
            {
                System.out.println("Debug: that npc couldn't be found.");
            }
        }
        else
        {
            System.out.println("Debug: the move npc command didn't have enough words, needs at least 3 (command npc room)");
        }
    }
    
    private void goMoveItem()
    {
        if(command.countTokens() >= 3)
        {
            String arg1 = command.nextToken();
            String arg2 = command.nextToken();
            if (arg2.equalsIgnoreCase("to"))
            {
                if(command.hasMoreTokens())
                {
                    arg2 = command.nextToken();
                }
                else
                {
                    System.out.println("Debug: the move player command didn't specify where to move");
                }
            }
            Item itemToMove = resolver.resolveItemFromCurrentRoom(arg1);
            if(itemToMove == null)
            {
                itemToMove = resolver.resolveItemFromGlobal(arg1);
            }
            if(itemToMove != null)
            {
                Room goTo = resolver.resolveRoom(arg2);
                if (goTo != null)
                {
                    resolver.findItem(itemToMove).removeItem(itemToMove);
                    goTo.addItem(itemToMove);
                }
                else
                {
                    System.out.println("Debug: that room couldn't be found.");
                }
            }
            else
            {
                System.out.println("Debug: that item couldn't be found.");
            }
        }
        else
        {
            System.out.println("Debug: the move item command didn't have enough words, needs at least 3 (command npc room)");
        }
    
    }
    
    private void goAddNPC()
    {
        if(command.countTokens() == 12)
        {
            String room = command.nextToken();
            String name = command.nextToken();
            String look = command.nextToken();
            String attack = command.nextToken();
            String leer = command.nextToken();
            String lick = command.nextToken();
            String torture = command.nextToken();
            String escape = command.nextToken();
            String listen = command.nextToken();
            String dodge = command.nextToken();
            String grab = command.nextToken();
            Room goTo = null;
            goTo = resolver.resolveRoom(room);
            
            if (look.equalsIgnoreCase("null"))
                look=null;
            if (attack.equalsIgnoreCase("null"))
                attack=null;
            if (leer.equalsIgnoreCase("null"))
                leer=null;
            if (lick.equalsIgnoreCase("null"))
                lick=null;
            if (torture.equalsIgnoreCase("null"))
                torture=null;
            if (escape.equalsIgnoreCase("null"))
                escape=null;
            if (listen.equalsIgnoreCase("null"))
                listen=null;
            if (dodge.equalsIgnoreCase("null"))
                dodge=null;
            if (grab.equalsIgnoreCase("null"))
                grab=null;     
            if (goTo != null)
            {
                goTo.addNPC(new NPC(name,look,attack,leer,lick,torture,escape,listen,dodge,grab));
            }
            else
            {
                System.out.println("Debug: the room you want to add an an npc to doesn't exist");
            }
        }
        else
        {
            System.out.println("Debug: addNPC internal command needs 12 words (command, 10 words for the signature, and the room name)");
        }
    }
    
    private void goRemoveNPC()
    {
        if(command.countTokens() >= 3)
        {
            String arg1 = command.nextToken();
            String arg2 = command.nextToken();
            if (arg2.equalsIgnoreCase("from"))
            {
                if(command.hasMoreTokens())
                {
                    arg2 = command.nextToken();
                }
                else
                {
                    System.out.println("Debug: the remove npc command didn't specify where to remove from");
                }
            }
            NPC npcToRemove = resolver.resolveNPCFromCurrentRoom(arg1);
            if(npcToRemove == null)
            {
                npcToRemove = resolver.resolveNPCFromGlobal(arg1);
            }
            if(npcToRemove != null)
            {
                Room goTo = resolver.resolveRoom(arg2);
                if (goTo != null)
                {
                    goTo.removeNPC(npcToRemove);
                }
                else
                {
                    System.out.println("Debug: that room couldn't be found.");
                }
            }
            else
            {
                System.out.println("Debug: that npc couldn't be found.");
            }
        }
        else
        {
            System.out.println("Debug: the remove npc command didn't have enough words, needs at least 3 (command npc room)");
        }
    }
    
    private void goAddNPCTalk()
    {
        if (command.countTokens() >= 3)
        {
            String arg1 = command.nextToken();
            String arg2 = command.nextToken();
            while (command.hasMoreTokens())
            {
                arg2 = arg2 + " " + command.nextToken();
            }
            NPC targetNPC = resolver.resolveNPCFromCurrentRoom(arg1);
            if(targetNPC == null)
            {
                targetNPC = resolver.resolveNPCFromGlobal(arg1);
            }
            if(targetNPC != null)
            {
                targetNPC.addTalk(arg1);
            }
            else
            {
                System.out.println("Debug: could not find the npc");
            }
        }
        else
        {
            System.out.println("Debug add npc talk needs 3 words (command npc words)");
        }
    }
    
    private void goRemoveNPCTalk()
    {
        if (command.countTokens() >= 3)
        {
            String arg1 = command.nextToken();
            String arg2 = command.nextToken();
            while (command.hasMoreTokens())
            {
                arg2 = arg2 + " " + command.nextToken();
            }
            NPC targetNPC = resolver.resolveNPCFromCurrentRoom(arg1);
            if(targetNPC == null)
            {
                targetNPC = resolver.resolveNPCFromGlobal(arg1);
            }
            if(targetNPC != null)
            {
                targetNPC.removeTalk(arg1);
            }
            else
            {
                System.out.println("Debug: could not find the npc");
            }
        }
        else
        {
            System.out.println("Debug remove npc talk needs 3 words (command npc words without quotes)");
        }
    }
    
    private void goAddItem()
    {
        if(command.countTokens() == 14)
        {
            String room = command.nextToken();
            String name = command.nextToken();
            String look = command.nextToken();
            String attack = command.nextToken();
            String lick = command.nextToken();
            String eat = command.nextToken();
            String drink = command.nextToken();
            String crawl = command.nextToken();
            String listen = command.nextToken();
            String dodge = command.nextToken();
            String grab = command.nextToken();
            String use = command.nextToken();
            String eq = command.nextToken();
            boolean equipable = false;
            Room goTo = null;
            
            if (look.equalsIgnoreCase("null"))
                look=null;
            if (attack.equalsIgnoreCase("null"))
                attack=null;
            if (lick.equalsIgnoreCase("null"))
                lick=null;
            if (eat.equalsIgnoreCase("null"))
                eat=null;
            if (drink.equalsIgnoreCase("null"))
                drink=null;
            if (crawl.equalsIgnoreCase("null"))
                crawl=null;
            if (listen.equalsIgnoreCase("null"))
                listen=null;
            if (dodge.equalsIgnoreCase("null"))
                dodge=null;
            if (grab.equalsIgnoreCase("null"))
                grab=null;
            if (use.equalsIgnoreCase("null"))
                use=null;
            if (eq.equalsIgnoreCase("1") || eq.equalsIgnoreCase("01") || eq.equalsIgnoreCase("yes") || eq.equalsIgnoreCase("true"))
            {
                equipable = true;
            }
            goTo = resolver.resolveRoom(room);
            if (goTo != null)
            {
                goTo.addItem(new Item(name,look,attack,lick,eat,drink,crawl,listen,dodge,grab, use, equipable));
            }
            else
            {
                System.out.println("Debug: the room you want to add an an item to doesn't exist");
            }
        }
        else
        {
            System.out.println("Debug: addItem internal command needs 9 words (command, 9 words for the signature, and the room name");
        }
    }
    
    private void goRemoveItem()
    {
        if(command.countTokens() >= 3)
        {
            String arg1 = command.nextToken();
            String arg2 = command.nextToken();
            if (arg2.equalsIgnoreCase("from"))
            {
                if(command.hasMoreTokens())
                {
                    arg2 = command.nextToken();
                }
                else
                {
                    System.out.println("Debug: the remove item command didn't specify where to remove it from");
                }
            }
            Item itemToRemove = resolver.resolveItemFromCurrentRoom(arg1);
            if(itemToRemove == null)
            {
                itemToRemove = resolver.resolveItemFromGlobal(arg1);
            }
            if(itemToRemove != null)
            {
                Room goTo = resolver.resolveRoom(arg2);
                if (goTo != null)
                {
                    goTo.removeItem(itemToRemove);
                }
                else
                {
                    System.out.println("Debug: that room couldn't be found.");
                }
            }
            else
            {
                System.out.println("Debug: that item couldn't be found.");
            }
        }
        else
        {
            System.out.println("Debug: the remove item command didn't have enough words, needs at least 3 (command item room)");
        }
    }
    
    private void goModifyNPC()
    {
        if(command.countTokens() >= 4)
        {
            String arg1 = command.nextToken();
            String arg2 = command.nextToken();
            String arg3 = command.nextToken();
            while (command.hasMoreTokens())
            {
                arg3 = arg3 + " " + command.nextToken();
            }
            NPC targetNPC = resolver.resolveNPCFromCurrentRoom(arg1);
            if(targetNPC == null)
            {
                targetNPC = resolver.resolveNPCFromGlobal(arg1);
            }
            if(targetNPC != null)
            {
                switch(arg2.trim().toLowerCase())
                {
                    case "name":
                        targetNPC.setName(arg3);
                        break;
                    case "look":
                        targetNPC.setLook(arg3);
                        break;
                    case "attack":
                        targetNPC.setAttack(arg3);
                        break;
                    case "leer":
                        targetNPC.setLeer(arg3);
                        break;
                    case "lick":
                        targetNPC.setLick(arg3);
                        break;
                    case "torture":
                        targetNPC.setTorture(arg3);
                        break;
                    case "escape":
                        targetNPC.setEscape(arg3);
                        break;
                    case "listen":
                        targetNPC.setListen(arg3);
                        break;
                    case "dodge":
                        targetNPC.setDodge(arg3);
                        break;
                    case "grab":
                        targetNPC.setGrab(arg3);
                        break;
                    default:
                        System.out.println("Debug: modify npc recieved a field to modify that isn't doesn't exist");
                        break;
                }
            }
            else
            {
                System.out.println("Debug: could not find the npc");
            }
        }
        else
        {
            System.out.println("Debug: the modifyNPC command didn't have enough words, needs at least 4 (command npc modify newValue)");
        }
    }
    
    private void goModifyItem()
    {
        if(command.countTokens() >= 4)
        {
            String arg1 = command.nextToken();
            String arg2 = command.nextToken();
            String arg3 = command.nextToken();
            if (arg3.equalsIgnoreCase("null"))
            {
                arg3 = null;
            }
            else
            {
                while(command.hasMoreTokens())
                {
                    arg3 = arg3 + " " + command.nextToken();
                }
                Item targetItem = resolver.resolveItemFromCurrentRoom(arg1);
                if(targetItem == null)
                {
                    targetItem = resolver.resolveItemFromGlobal(arg1);
                }
                if(targetItem != null)
                {
                    switch(arg2.trim().toLowerCase())
                    {
                        case "name":
                            targetItem.setName(arg3);
                            break;
                        case "look":
                            targetItem.setLook(arg3);
                            break;
                        case "attack":
                            targetItem.setAttack(arg3);
                            break;
                        case "lick":
                            targetItem.setLick(arg3);
                            break;
                        case "eat":
                            targetItem.setEat(arg3);
                            break;
                        case "drink":
                            targetItem.setDrink(arg3);
                            break;
                        case "listen":
                            targetItem.setListen(arg3);
                            break;
                        case "dodge":
                            targetItem.setDodge(arg3);
                            break;
                        case "grab":
                            targetItem.setGrab(arg3);
                            break;
                        default:
                            System.out.println("Debug: modify item recieved a field to modify that isn't doesn't exist");
                            break;
                    }
                }
                else
                {
                    //don't say anything
                }
            }
        }
        else
        {
            System.out.println("Debug: the modifyItem command didn't have enough words, needs at least 4 (command npc modify new value no quotes)");
        }
    }
    
    private void goAddInventory()
    {
        if(command.countTokens() >= 2)
        {
            String item = command.nextToken();
            Item itemToAdd = resolver.resolveItemFromCurrentRoom(item);
            if(itemToAdd == null)
            {
                itemToAdd = resolver.resolveItemFromGlobal(item);
            }
            if(itemToAdd != null)
            {
                Room from = null;
                from = resolver.findItem(item);
                if (from != null)
                {
                    player.addToInventory(itemToAdd);
                    from.removeItem(itemToAdd);
                }
                System.out.println("Debug: the item was found when the name was resolved, but then couldn't find the room it was in "+
                "somehow...\n\nI really hope this never prints out because it means I royally screwed something up.");
            }
            else
            {
                System.out.println("Debug: that item couldn't be found.");
            }
        }
        else
        {
            System.out.println("Debug: the add Inventory command didn't have enough words, needs at least 2 (command item)");
        }
    }
    
    private void goRemoveInventory()
    {
        if(command.countTokens() >= 2)
        {
            String item = command.nextToken();
            Item itemToRemove = resolver.resolveItemFromInventory(item);
            if(itemToRemove != null)
            {
                player.removeFromInventory(itemToRemove);
            }
            else
            {
                System.out.println("Couldn't find the item to remove from the player's inventory.");
            }
        }
        else
        {
            System.out.println("Debug: the remove Inventory command didn't have enough words, needs at least 2 (command item)");
        }
    }
    
    private void goEquip()
    {
        if(command.countTokens() >= 2)
        {
            String item = command.nextToken();
            Item itemToEquip = resolver.resolveItemFromInventory(item);
            if(itemToEquip != null)
            {
                player.equip(itemToEquip);
            }
            else
            {
                System.out.println("Debug: couldn't find the item to equip in the player's inventory.");
            }
        }
        else
        {
            System.out.println("Debug: the equip command didn't have enough words, needs at least 2 (command item)");
        }
    }
    
    private void goDrop()
    {
        if(command.countTokens() >= 2)
        {
            String item = command.nextToken();
            Item itemToDrop = resolver.resolveItemFromInventory(item);
            if(itemToDrop != null)
            {
                player.removeFromInventory(itemToDrop);
                currentRoom.addItem(itemToDrop);
            }
            else
            {
                System.out.println("Debug: couldn't find the item to drop in the player's inventory.");
            }
        }
        else
        {
            System.out.println("Debug: the remove Inventory command didn't have enough words, needs at least 2 (command item)");
        }
    }
    
    private void goGameOver()
    {
        System.out.println("GAME OVER\n\nPress the Enter button to exit.");
        try
        {
            System.in.read();
        }
        catch(Exception E)
        {
        }
        System.exit(0);
    }
    
    private void win()
    {
        System.out.println("YOU WIN. Press enter to close the game.");
        try
        {
            System.in.read();
        }
        catch(Exception E)
        {
        }
        System.exit(0);
    }
    
    private void goPhase1()
    {
        resolver.resolveRoom("citygate").setDescription("You are at the city gate.  There is a blood trail leading outside the city.");
        resolver.resolveRoom("citygate").setExtraDescription("The blood trail consists of tiny footprints.");
        resolver.resolveRoom("outsidethewatermill").setDescription("You are outside the water mill.  Even though the mill is shut down, the door is wide open.");
        resolver.resolveRoom("outsidethewatermill").setExtraDescription("Looking through the doorway, you can see a something lying on the floor.");
        resolver.resolveRoom("insidethewatermill").setDescription("You are inside the water mill.  There are 2 city guards lying on the floor.");
        resolver.resolveRoom("insidethewatermill").addItem(new Item("guards", "Upon further inspection, you confirm that both the guards are dead, the result of many tiny puncture wounds on their chest.  You also notice that their socks are missing.  There is a blood trailer leading out the door.  The blood trail has what looks like a child’s footprint inside it.", null, null, null, null, null, null, null, null, null, false));
        resolver.resolveRoom("insidethewatermill").setExtraDescription("There is nothing else except the bodies here.");
        resolver.resolveRoom("topoftheguardtower").setExtraDescription("It looks like there's some commotion at the city gates, northeast of here.");
        resolver.resolveRoom("cropfields").setExtraDescription("The blood trail is leading you north towards the forest.");
        resolver.resolveRoom("forest").setDescription("You are in the forest outside the city.  Following the blood trail, you find 2 gnomes attempting to crawl under a hollowed out tree.");
        resolver.resolveRoom("forest").setExtraDescription("The gnomes are both about a foot tall.  One of them is bleeding from his leg, from what looks like a knife wound. The other gnome is holding a small bottle in his hands filled with some kind of low pulsating blue light. They have noticed your presence and they both leap at you.");
        resolver.resolveRoom("forest").addNPC(new NPC("gnomes", "They're angry gnomes!", "You knock both gnomes our out of the air with two well timed punches.  Since they are so small your punches seem to have killed them. The second gnome drops the bottle onto the ground.|-aitem forest bottle look null null null null null null null grab null false|-rnpc gnomes forest", "They leer back.", "Yuck!", "More more, faster faster, it hurts so good!","You flee!|-mplayer cropfields", null, "You can't dodge both.", "You grab the first gnome out of the air and slam him into the ground, killing him.  The second gnome sails over your head and retreats into the hollowed out tree.  It looks like you should be able to crawl through to get inside.|-modnpc gnomes name gnome|-mnpc gnome to hollowedouttree"));
        resolver.resolveItemFromCurrentRoom("bottle").setGrab("You pick up the bottle off the ground.|-ainv bottle");
        resolver.resolveItemFromCurrentRoom("bottle").setLook("The energy or force inside this bottle is like nothing you’ve ever seen.  You can feel the power it contains just by looking at it.  The pulsating blue light has a rather calming feel to it.  You should take your findings to the king.");
        resolver.resolveRoom("forest").addItem(new Item("tree", "It has a hole in it. It looks like you could crawl through.", null, null, null, null, "You crawl into the inside the hollowed out tree. There are 2 small cots inside, it seems like the 2 gnomes were hiding out here. The second gnome is in the corner clutching the bottle.|-mplayer hollowedouttree |-hollowtree", null, null, null, null, false));
        resolver.resolveRoom("castle").setExtraDescription("As soon as you walk into the throne room, everyone, including the king eagerly looks to you.");
        resolver.resolveNPCFromCurrentRoom("king").removeAllTalk();
        resolver.resolveNPCFromCurrentRoom("king").addTalk("You show the king the bottle, and you tell him about the gnomes you found, and what happened at the water mill.  The king listens to what you say, then calmly rips the bottle out of your hand, and without a second thought uncorks it.  Energy explodes from inside the bottle, but this energy feels not harmful, but rather cool and soothing.  After a second, all of the energy has escaped the bottle.  The king then goes to a table, pours himself a glass of water, and slowly chugs it down.  After he is finished he explains what he thinks has happened.  That the gnomes have been stealing the properties of nature and putting them in bottles.  The force he just uncorked was water, and he hasn’t quenched his thirst for 2 days, which was why he really needed a drink.  He does not know why the gnomes are doing this, but he tasks you with finding the remaiming forces, to end all of this chaos.  He also tells you that he believes that there are 4 more bottled forces to find, and that when you find them, you should come back to the castle.|-rinv bottle|-phase2");
    }
    
    private void goPhase2()
    {
        resolver.resolveRoom("citygate").setDescription("You are at the entrance to the city.");
        resolver.resolveRoom("citygate").setExtraDescription("It looks like the blood trail has been cleaned up, and there are now guards posted at the gates.");
        resolver.resolveRoom("outsidethewatermill").setDescription("You are outside the water mill. The mill has started working again.");
        resolver.resolveRoom("outsidethewatermill").setExtraDescription("It seems that the king uncorking the force of water has restored the river’s ability to push the water wheel.");
        resolver.resolveRoom("insidethewatermill").setDescription("You are inside the water mill.  The bodies of the guards are gone.");
        resolver.resolveRoom("insidethewatermill").setExtraDescription("There is nothing of importance in here.");
        resolver.resolveRoom("insidethewatermill").removeItem(resolver.resolveItemFromGlobal("guards"));
        resolver.resolveRoom("topoftheguardtower").setExtraDescription("From up here can you feel strong bursts of wind coming from the residential district, south of here.");
        resolver.resolveRoom("market1").setExtraDescription("After looking around, you find a small hut with fire coming out of a chimney.  There is also a small shop set up outside the hut, with the owner standing next to it, trying to attract customers.  Upon further inspection, you notice on one of the shelves of the shop, a small bottle containing a bright dancing flame.");
        resolver.resolveRoom("market1").addNPC(new NPC("merchant", "He's old. He stands as if a strong breeze would knock him over.", null, null, "Yummy!", null, null, null, null, null));
        resolver.resolveNPCFromGlobal("merchant").addTalk("\"I told the last man this, and i'll tell you too.  we don't have any more socks for sale!!\"\nYou ask about the bottle of fire.\n\"Oh, you dont want any socks. I’m sorry good sir, but that is not for sale. I just put that there to attract customers.  it’s nothing special, really.\"");
        resolver.resolveRoom("market1").addItem(new Item("bottle", "The fire inside is brilliantly bright, and is in constant motion inside the bottle.", null, "IT BURNS", null, null, null, null, null, "You wait for the shopkeeper’s attention to go elsewhere, then you quickly grab the bottle and walk away.|-getfire|-ritem bottle from market1|-moditem fire grab null", null, false));
        resolver.resolveRoom("market1").addItem(new Item("fire", "The fire inside is brilliantly bright, and is in constant motion inside the bottle.", null, "IT BURNS", null, null, null, null, null, "You wait for the shopkeeper’s attention to go elsewhere, then you quickly grab the bottle and walk away.|-getfire|-ritem bottle from market1", null, false));
        resolver.resolveRoom("market2").addNPC(new NPC("merchant", "A middle aged man with a rough demeanor.", null, null, "Yummy yummy in my tummy!", null, null, null, null, null));
        resolver.resolveRoom("market2").setExtraDescription("Most of the vendors selling food are dangerously low on product. But surprisingly, there is one vendor who has a large stock of various produce.  There is a large crowd around his stand since he is the only one with anything to sell.");
        resolver.resolveNPCFromGlobal("vendor").addTalk("You inquire as to how he is able to have this much stock on food.  He tells you that one of the farms, north of the city gate, has been able to grow good quality food without difficulty.  The court mage told you that none of the farmers have been able to grow any crops.  Because of this, you should go investigate the crops fields.");
        resolver.resolveRoom("residential2").setExtraDescription("There is a group of children running around playing, but no adults to be seen. Upon further inspection of the children, you notice that one of them is clutching a small bottle in his hands, containing what looks like a strong gust of wind.");
        resolver.resolveNPCFromGlobal("children").addTalk("What do you want mister? My bottle?!  You can’t have it, it’s MINE!  We finally have something fun to play with, and we’re not letting you have it!");
        resolver.resolveNPCFromGlobal("children").setLeer("We’re not scared of you mister. What are you going to do? Tell our parents? You continue staring at them. They all start to look really nervous.  The kid holding the bottle glares at you defiantly, but then grudgingly hands you the bottle.|-kidbottle");
        resolver.resolveRoom("cropfields").setExtraDescription("After looking around, you notice a farm that is flourishing with growth.  All the other farms around are failing to grow anything, but this farm seems to be having no trouble.  You see the farmer walking out of his house.  You approach him.|-farmer");
        resolver.resolveRoom("castle").setExtraDescription("There is nothing of importance in here.");
    }
    
    private void goPhase3()
    {
        resolver.resolveRoom("topoftheguardtower").setExtraDescription("After looking around you notice a large hole in the ceiling of the soldier barracks, southwest of here.");
        resolver.resolveRoom("market1").setExtraDescription("There is nothing of importance here.");
        resolver.resolveRoom("market2").setExtraDescription("There is nothing of importance here.");
        resolver.resolveRoom("cropfields").setExtraDescription("There is nothing of importance here.");
        resolver.resolveRoom("residential2").setExtraDescription("There is nothing of importance here.");
        resolver.resolveRoom("outsidethesoldierbarracks").setExtraDescription("There is usually someone watching the entrance inside, but for some reason the door is wide open.  There looks like there is a commotion inside.");
        resolver.resolveRoom("outsidethesoldierbarracks").addExit("soldier barracks", resolver.resolveRoom("insidethesoldierbarracks"));
    }
    
    private void goPhase4()
    {
        resolver.resolveRoom("topoftheguardtower").setExtraDescription("You see nothing of importance from up here.");
        resolver.resolveRoom("outsidethesoldierbarracks").setExtraDescription("You see nothing of importance from up here.");
        resolver.resolveRoom("insidethesoldierbarracks").setExtraDescription("You see nothing of importance from up here.");
        resolver.resolveRoom("castle").setDescription("You are inside the castle, in the throne room.  The king is standing before you and wishes to speak with you.|-lightningincastle");
        resolver.resolveRoom("castle").setExtraDescription("After entering the throne room, you start to feel some movement inside of your bag.  After taking off your bag and looking inside, you find that the storm cloud is thrashing violently inside of its bottle.  The storm cloud almost appears to have a mind of its own, and right now, it clearly wants out of the bottle.");
        resolver.resolveNPCFromGlobal("king").removeAllTalk();
        resolver.resolveNPCFromGlobal("king").addTalk("You approach the king and inform him that you have collected all of the bottled forces.  He tells you that you should not release them yet before finding the gnomes and dealing with them first, otherwise the gnomes will just bottle them all up again.  He also tells you that in order for the gnomes to have accomplished what they did, they would have had to have a secret way to enter the city, and that finding that secret entrance is your key to finding the gnomes.  He suggests starting your search somewhere quiet and secluded.");
    }
    
    private void getFire()
    {
        player.addToInventory(resolver.resolveItemFromCurrentRoom("fire"));
        bottles += 1;
        phase3Check();
    }
    
    private void getStorm()
    {
        player.addToInventory(new Item("Lightning", "As you hold the bottle in your hand, you can feel the raw energy the storm cloud possesses.  The energy in this bottle feels far more powerful and destructive than all the other forces you’ve obtained thus far.  While fire is destructive, it is also warmth and light.  This lighting is only destruction, and on a scale far greater than that of the bottled fire.  You should keep it for now.  That kind of power can be useful.", null, "Shockingly delicious!", "Not a good idea.", null, null, null, null, null, null, false));
        bottles += 1;
        goPhase4();
    }
    
    private void hollowTree()
    {
        NPC gnome = resolver.resolveNPCFromCurrentRoom("gnome");
        gnome.setLook("The gnome seems understandably scared. It doesn\'t look like he wants to fight.");
        gnome.setAttack("You kick the gnome into the wall of the tree, killing it.  He drops the bottle onto the ground.|-aitem hollowedouttree bottle look null null null null null null null \\n|-bottleDrop null false) ");//Put in thing for attack
        gnome.setGrab("You pick the gnome up with the intention of throwing him into the wall but before you can he screams “Wait!”.  You could either kill him, or listen to what he has to say.");
        gnome.setListen("\"I don’t have time for your meddling, you stupid human.\" Before you have time to react, he pulls a dagger out of nowhere, and slits your throat.|-gameover");
    }
    
    private void bottleDrop()
    {
        resolver.resolveItemFromCurrentRoom("bottle").setLook("It looks like there is water inside.");
        resolver.resolveItemFromCurrentRoom("bottle").setGrab("The energy or force inside this bottle is like nothing you’ve ever seen.  You can feel the power it contains just by looking at it.  The pulsating blue light has a rather calming feel to it.  You should take your findings to the king.|-ainv bottle");
        bottles+=1;
        phase3Check();
    }
    
    private void kidBottle()
    {
        resolver.resolveRoom("residential2").addItem(new Item("wind", "The force of the wind is almost moving the bottle in your hands. The wind inside is constantly moving and changing directions. You should keep this for now, in case you need it later.", null, "Tastes like the winds.", null, null, null, null, null, null, null, false));
        player.addToInventory(resolver.resolveItemFromCurrentRoom("wind"));
        bottles+=1;
        phase3Check();
    }
    
    private void farmer()
    {
        resolver.resolveRoom("cropfields").addNPC(new NPC("farmer", "He looks like a dusty old fart.", null, "The dusty old fart leers back at you.", "He tastes like a dusty old fart.", "He moans like a dusty old fart.", "You can't escape a dusty old fart.", "Sounds like a dusty old fart.", "You can't dodge a dusty old fart.", null));
        resolver.resolveNPCFromCurrentRoom("farmer").addTalk("\"What’s that now? You want to know how my farm is able to grow anything?  Well I’m not really sure.  Even since I found this I haven’t had any trouble.\" He then pulls out a small bottle containing some sort of bright green energy.  You then tell him that the king has tasked you with finding the stolen forces of nature, and that what he found is one of them.  After hearing that he agrees to give you the bottle.|-getfarmerbottle");
    }
    
    private void getFarmerBottle()
    {
        player.addToInventory(new Item("life", "The energy inside this bottle is different from the others. It resonates with you in a way, as if you yourself are a part of this energy. You come to the conclusion this must be the very essence of life itself. You should keep this bottle in case you need it later.", null, "Tastes like life cereal!", null, null, null, null, null, null, null, false));
        bottles += 1;
    }
    
    private void phase3Check()
    {
        if(bottles == 4)
        {
            goPhase3();
        }
    }

    private void lightningInCastle()
    {
        resolver.resolveItemFromInventory("lightning").setUse("As soon as you uncork the bottle, lighting courses out and strikes the wall directly behind the throne.  You quickly recork the bottle, and then gaze at the wall that the lighting struck.  The wall begins to crumble to reveal a secret path.|-ulocksecretpath");
    }
    
    private void unlockSecretPath()
    {
        resolver.resolveRoom("castle").addExit("secret path", resolver.resolveRoom("secretpath"));
    }
    
    private void makeKeyWork()
    {
        resolver.resolveItemFromInventory("key").setUse("key use You use the key to unlock the door, allowing entrance to another room. You can go North, East, or West.|-usekey");
    }
    
    private void useKey()
    {
        resolver.resolveRoom("dungeonroom17").addExit("door", resolver.resolveRoom("dungeonroom18"));
        resolver.resolveRoom("dungeonroom17").addExit("north", resolver.resolveRoom("dungeonroom18"));
    }
    
    private void makeLifeWork()
    {
        resolver.resolveItemFromInventory("life").setUse("A green essence is released from the bottle and shrouds itself around the statue, causing it to shake and come to life. The statue takes one step to the right and sits down, revealing the exits. You can go West and East.|-uselife");
    }
    
    private void useLife()
    {
        resolver.resolveRoom("dungoenroom11").addExit("east", resolver.resolveRoom("dungeonroom12"));
    }
    
    
    private void setupFinalBattle()
    {
        resolver.resolveItemFromInventory("fire").setUse("You uncork the bottle and aim it at the king.  Energy explodes outward toward the gnome king.  The energy strikes his beard.  But his beard seems to absorb it.  His beard then surges forward and engulfs you. The mass of his beard keeps expanding and growing.  There is no way for you to get out.  You slowly suffocate under the awesome might of his beard.\n\nGame Over.|-gameover");
        resolver.resolveItemFromInventory("wind").setUse("You uncork the bottle and aim it at the king.  Energy explodes outward toward the gnome king.  The energy strikes his beard.  But his beard seems to absorb it.  His beard then surges forward and engulfs you. The mass of his beard keeps expanding and growing.  There is no way for you to get out.  You slowly suffocate under the awesome might of his beard.\n\nGame Over.|-gameover");
        resolver.resolveItemFromInventory("life").setUse("You uncork the bottle and aim it at the king.  Energy explodes outward toward the gnome king.  The energy strikes his beard.  But his beard seems to absorb it.  His beard then surges forward and engulfs you. The mass of his beard keeps expanding and growing.  There is no way for you to get out.  You slowly suffocate under the awesome might of his beard.\n\nGame Over.|-gameover");
        resolver.resolveItemFromInventory("lightning").setUse("You uncork the storm cloud bottle and aim it at the gnome king.  A lance of pure lighting rushes out of the bottle and\n"+
            "strikes the gnome king in his beard.  The gnome king staggers back, clearly affected by the powerful blast.\n"+
            "It tears a hole through the beard, but you can see it start to regenerate.  You see that the gnome king is still\n"+
            "recovering from the blast, so you run up to him, and crack the storm cloud bottle over his head.  Electrical energy\n"+
            "explodes out of the bottle.  Both you and the gnome king a thrown back from the impact.  You land on you back and look\n"+
            "up to see what happened.  The gnome king is suspended in midair, being torn to shreds by the storm of energy.  After a\n"+
            "couple of seconds, he falls.  You walk over to him, to find him clearly dead.  Most of his flesh has been burnt off, as\n"+
            "well as his beard.  No one would have been able to survive the amount of energy that he withstood.  You than pick up the\n"+
            "sock bottle, and then tell all the gnomes watching to scram.  After seeing what happened to their king, they all rush\n"+
            "out. It would seem that you have stopped the gnome threat, and saved the city.  No longer will anyone’s feet in the\n"+
            "kingdom go cold at night.\n\nCongratulations, you have won the game!|-wingame");
        }
    
        
        
    private void goCheckInventory()
    {
        if(command.countTokens() >= 4)
        {
            if(command.hasMoreTokens())
            {
                String item = command.nextToken();
                Item itemToCheck = resolver.resolveItemFromInventory(item);
                if(itemToCheck == null)
                {
                    itemToCheck = resolver.resolveItemFromEquip(item);
                }
                if(itemToCheck != null)
                {
                    if (command.hasMoreTokens())
                    {
                        removeReadTokens();
                        switchCommands();
                    }
                    else
                    {
                        System.out.println("Ran out of tokens when looking for the command to use");
                    }
                }
                else
                {
                    //didn't find item, don't do anything
                }
            }
            System.out.println("Ran out of tokens when looking for the item to look for");
        }
        else
        {
            System.out.println("Debug: the check Inventory command didn't have enough words, needs at least 4 (command item command xxx)");
        }
    }
    
    private void goCheckEquip()
    {
        if(command.countTokens() >= 4)
        {
            if(command.hasMoreTokens())
            {
                String item = command.nextToken();
                Item itemToCheck = resolver.resolveItemFromEquip(item);
                if(itemToCheck == null)
                {
                    itemToCheck = resolver.resolveItemFromEquip(item);
                }
                if(itemToCheck != null)
                {
                    if (command.hasMoreTokens())
                    {
                        removeReadTokens();
                        switchCommands();
                    }
                    else
                    {
                        System.out.println("Ran out of tokens when looking for the command to use");
                    }
                }
                else
                {
                    //didn't find item, don't do anything
                }
            }
            System.out.println("Ran out of tokens when looking for the item to look for");
        }
        else
        {
            System.out.println("Debug: the check equip command didn't have enough words, needs at least 4 (command item command xxx)");
        }
    }
    
    private void removeReadTokens()
    {
        String newCommand = null;
        while(command.hasMoreTokens())
        {
            newCommand = newCommand + " " + command.nextToken();
        }
        command = new StringTokenizer(newCommand);
    }
    
    private void switchCommands()
    {
        String check = command.nextToken().trim().toLowerCase();
        switch(check)
        {
            case "-mplayer":
                goMovePlayer();
                break;
            case "-mnpc":
                goMoveNPC();
                break;
            case "-mitem":
                goMoveItem();
                break;
            case "-anpc":
                goAddNPC();
                break;
            case "-rnpc":
                goRemoveNPC();
                break;
            case "-anpctalk":
                goAddNPCTalk();
                break;
            case "-rnpctalk":
                goRemoveNPCTalk();
            case "-aitem":
                goAddItem();
                break;
            case "-ritem":
                goRemoveItem();
                break;
            case "-modnpc":
                goModifyNPC();
                break;
            case "-moditem":
                goModifyItem();
                break;
            case "-ainv":
                goAddInventory();
                break;
            case "-rinv":
                goRemoveInventory();
                break;
            case "-equip":
                goEquip();
                break;
            case "-drop":
                goDrop();
                break;
            case "-gameover":
                goGameOver();
                break;
            case "-wingame":
                win();
                break;
            case "-phase1":
                goPhase1();
                break;
            case "-phase2":
                goPhase2();
                break;
            case "-phase3":
                goPhase3();
                break;
            case "-phase4":
                goPhase4();
                break;
            case "-getstorm":
                getStorm();
                break;
            case "-hollowtree":
                hollowTree();
                break;
            case "-bottledrop":
                bottleDrop();
                break;
            case "-kidbottle":
                kidBottle();
                break;
            case "-farmer":
                farmer();
                break;
            case "-lightningincastle":
                lightningInCastle();
                break;
            case "-unlocksecretpath":
                unlockSecretPath();
                break;
            case "-makekeywork":
                makeKeyWork();
                break;
            case "-useKey":
                useKey();
                break;
            case "-makelifework":
                makeLifeWork();
                break;
            case "-uselife":
                useLife();
                break;
            case "-setupfinalbattle":
                setupFinalBattle();
                break;

            case "-checkinv":
                goCheckInventory();
                break;
            case "-checkeq":
                goCheckEquip();
                break;
            default:
            System.out.println("Debug: you tried to call an internal command that isn't in "+
            "the list of available internal commands. Try checking your spelling.\n The command was: \""+check+"\"");
        }
    }
}
