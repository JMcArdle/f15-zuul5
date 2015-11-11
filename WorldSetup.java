import java.util.ArrayList;

/**
 * This class is part of _____, a text based adventure game created
 *  by modifying the "World of Zuul" game.
 * 
 * This class creates and populates all of the rooms in the game.
 * 
 * @author Scott Taylor
 * @version 10/28/2015
 */
public class WorldSetup
{
    Room inn, market1, market2, residential1, residential2, citygate, cropfields, insidethewatermill, outsidethewatermill, topoftheguardtower, guardtower, forest, castle, 
        castlegarden, castlegates, outsidethesoldierbarracks, insidethesoldierbarracks, hollowedouttree, secrettunnel, dungeonentrance, dungeonmainroom, dungeonroom3,
        dungeonroom4, dungeonroom5, dungeonroom6, dungeonroom7, dungeonroom8, dungeonroom9, dungeonroom10, dungeonroom11, dungeonroom12, dungeonroom13, dungeonroom14,
        dungeonroom15, dungeonroom16, dungeonroom17, dungeonroom18, dungeonroom19, dungeonroom20, dungeonroom21, dungeonroom22;

    
    private ArrayList<Room> allRooms;

    /**
     * Constructor for objects of class RoomCreator
     */
    public WorldSetup()
    {
    }
    
    /**
     * creates all the npcs
     */
    public void createNPCS()
    {
        residential2.addNPC(new NPC("children", "They're running around.", null, "Gumdrops and ice cream.", null, null, null, null, null, null));
        inn.addNPC(new NPC("barkeep", "Looks like the posterboy of a generic barkeep.", null, null, null, "You keep that up, you'll get more than just a free drink.", null, null, null, null));
        //all barkeep lines here
        
        castle.addNPC(new NPC("king", "He looks just like a king should, regal and proud and incredibly thirsty.", null, "He tastes sweet, like raspberries.", null, null, null, null, null, null));
        
        
    }
    
    /**
     * create all the items
     */
    public void createItems()
    {
        secrettunnel.addItem(new Item("key", "Looks like a key to something important.", null, null, null, null, null, null, null, null, null, false));
    }

    /**
     * Creates all the rooms
     */
    public Room makeRooms()
    {
        //declare all the rooms on this line
        
       // create the rooms like this
       inn = new Room("inn", "You are in the city inn.  Since it’s the middle of the day, no one is inside besides the barkeep.", "The only person inside the inn is the barkeep.");
        
       market1 = new Room("market1", "You are in the west part of the market district.  This area is bustling with merchants and people purchasing various goods.  The vendors on the west side mostly sell various trinkets or objects of interest." , "Many of the items you see for sale are interesting and unique, but nothing that is going to help you. None of the merchants will speak to you right now.");
        
       market2 = new Room("market2", "You are in the east part of the market district.  The merchants on the east side mostly sell food, but due to the ongoing problem with growing crops, there seems to be a food shortage." , "Most of the merchants selling food are dangerously low on product. Because of this, many people in this district appear to be understandably upset and on edge.  None of the merchants will speak to you right now.");
        
       residential1 = new Room("residential1", "You are in the west side of the residential district. Since this side is closer to the city castle, the wealthier citizens tend to live here." , "There are not many people walking around outside.  Most of the residents are inside their homes, some nervously looking out their windows.");
        
       residential2 = new Room("residential2", "You are in the east side of the residential district.  This is where the lower class citizens tend to live." , "There is a group of children running around playing.  No adults are around to be seen.");
        
       citygate = new Room("citygate", "You are at the entrance to the city.  Due to all the odd problems going on it seems that no guards are stationed here." , "The city gate is the only entrance and exit to the city.  Because of this there are always guards posted here.  The fact that there are no guards means something strange is going on.");
        
       insidethewatermill = new Room("insidethewatermill", "You are inside the water mill.  Since the mill is shut down, no one is present." , "You find nothing of importance.");
        
       outsidethewatermill = new Room("outsidethewatermill", "You are outside the watermill.  The mill is currently shut down at the moment as the river isn’t pushing the mill wheel." , "The river which is usually pushing the water wheel is still flowing freely.  But for some reason the mill wheel isn’t moving.");
        
       topoftheguardtower = new Room("topoftheguardtower", "You are at the top of the guard tower." , "You can see the entire city up here, but nothing of importance right now.");
        
       guardtower = new Room("guardtower", "You are at the guard tower.  It resides in the center of the city.  If you climb up, you could get a good vantage point of the city." , "There is nothing to look at.");
        
       forest = new Room("forest", "You are in the forest outside the city.  Nobody seems to be around." , "You find nothing of importance.");
        
       castle = new Room("castle", "You are inside the castle, in the throne room.  The king is standing before you and wishes to speak with you." , "As you look around the throne room you can feel the tension in the room.  All eyes are on you.  You can feel that the current situation is making every one nervous, and that they all seem to hoping for you to resolve the situation.");
        
       castlegarden = new Room("castlegarden", "You are in the garden outside the castle.  Not many people come here, and because of this it is very quiet and peaceful here." , "As you look around the garden, you notice a large statue of what used to be a bust of a person, but is now indistinguishable.");
       
       castlegates = new Room("castlegates", "You are at the castle gates, the entrance to the castle.  There seem to be many more guards at the front gate than usual." , "Some of the guards are talking amongst each other.  You over hear them say that they think the king is being overly cautious and that he should stop making them work so hard.");
        
       outsidethesoldierbarracks = new Room("outsidethesoldierbarracks", "You are outside the solider barracks.  This is where the soldiers on duty eat and rest." , "You over hear the guards complaining about the king overworking them.");
        
       insidethesoldierbarracks = new Room ("insidethesoldierbarracks", "You are inside the soldier barracks.  All of the soldiers inside are standing around, looking a big hole in the ceiling." , "While most of the soldiers are standing under the hole in the ceiling, trying to figure out what happened, one of the soldiers is standing off to the side, looking rather nervous.  He seems to recognize you and decides to approach you. He tells you \"You’re the guy that the king hired right?  The one who’s supposed to get to the bottom of all this insanity?  Listen, I didn’t mean to for this to happen.  This morning I found this bottle outside.\" He pulls a small bottle out of his pocket, containing what looks like a tiny storm cloud.  \"I thought it looked cool, or at least was worth something, so I didn’t tell anybody.  Just a little while ago, I decided to try uncorking it, just to see what would happen right. As soon as I did, a freaking lightning bolt shot straight out and up, tearing through the ceiling.  I managed to get the cork back on before something else happened.  This thing is too destructive, so please take it.  I hope with it you can fix everything that’s been going wrong.\"  He hands you the bottle.|-getstorm");
       
       hollowedouttree = new Room("hallowedouttree", "You are inside the hollowed out tree. There are two small cots inside, it seems like the two gnomes were hiding out here. The second gnome is in the corner clutching the bottle.", "The gnome seems understandably scared, it doesn't look like he wants to fight.");
       
       secrettunnel = new Room("secrettunnel", "You are in a secret path in the castle. You do not know where this leads, but after following the path north, the path turns to the east.", "There is not much to look at in here. It is a dark and boring path. You do however, notice a small key attatched to a chain, hanging on the wall. You decide to take it, as the key should prove useful later on.|-ainb key");
        
       dungeonentrance = new Room("dungeonentrance", "You are inside the dungeon entrance." , "As soon as you enter, you realize that the door behind you suddenly locks, trapping you inside. Looks like it’s a one way journey from here on out. You can go North.");
        
       dungeonmainroom = new Room("dungeonmainroom", "You are inside the main room." , "You walk in only to realize that the entire room is pitch black. You can’t make any sense of where you are going and in which direction.|-moditem fire use An immense fire escapes from the bottle, lighting up the room and allowing you to see the paths ahead. You can go North, East or West.");
       
       dungeonroom3 = new Room("dungeonroom3", "You are inside a passageway." , "You can go East or West");
       
       dungeonroom4 = new Room("dungeonroom4", "You are inside a small hall." , "You can go West or North");
       
       dungeonroom5 = new Room("dungeonroom5", "You are inside a room with a crater." , "You can go North or South");
        
       dungeonroom6 = new Room("dungeonroom6", "You are inside a room filled with water." , "You can go East or South");
       
       dungeonroom7 = new Room("dungeonroom7", "You are inside a room with holes." , "You can go East or West");
       
       dungeonroom8 = new Room("dungeonroom8", "You are inside a tunnel." , "You see that the entire room is deep in fog.  Its so dense that you cannot find your way through.|-moditem wind use A gust of wind releases from the bottle, blowing away all the fog surrounding the area. You are able to see the path ahead of you. You can go West or South.");
       
       dungeonroom9 = new Room("dungeonroom9", "You are inside a large tunnel." , "You can go North or South");
       
       dungeonroom10 = new Room("dungeonroom10", "You are inside a narrow corridor." , "You can go West or East");
        
       dungeonroom11 = new Room("dungeonroom11", "You are inside a large room." , "As you enter, you approach a giant statue covering the exit. Pushing it seems impossible, it barely moves an inch.|-moditem life use A green essence is released from the bottle and shrouds itself around the statue, causing it to shake and come to life. The statue takes one step to the right and sits down, revealing the exits. You can go West and East.");
       
       dungeonroom12 = new Room("dungeonroom12", "You are in an unfamiliar place." , "You feel a foreboding presence in the room, although it is not yet known to you. Only hearty laughter can be heard as you make your way closer.");
        
       dungeonroom13 = new Room("dungeonroom13", "You are inside a small den." , "You can go East or North");
        
       dungeonroom14 = new Room("dungeonroom14", "You are inside a room with glowing diamonds." , "You can go South or East");
       
       dungeonroom15 = new Room("dungeonroom15", "You are inside a room with catacombs." , "You can go North or South");
       
       dungeonroom16 = new Room("dungeonroom16", "You are inside a large chamber." , "You can go North or South");
        
       dungeonroom17 = new Room("dungeonroom17", "You are inside a very large room." , "As you enter, you notice a strange looking door at the other end of the room. Upon further inspection, there seems to be a small lock attached to it.|-moditem key use You use the key to unlock the door, allowing entrance to another room. You can go North, East, or West.|-unlockdoor");
        
       dungeonroom18 = new Room("dungeonroom18", "You are inside a room with staircases." , "You can go South or East");
        
       dungeonroom19 = new Room("dungeonroom19", "You are inside a passageway." , "You can go West or South");
        
       dungeonroom20 = new Room("dungeonroom20", "You are at a dead end." , "You can go East");
        
       dungeonroom21 = new Room("dungeonroom21", "You are at another dead end." , "You can go West");
        
       dungeonroom22 = new Room("dungeonroom22", "You are at yet another dead end." , "You can go East");
        
        

        // initialise room exits like this
        inn.addExit("north", citygate);
        inn.addExit("west", guardtower);
        inn.addExit("south", market2);
        
        
        market1.addExit("north", guardtower);
        market1.addExit("east", inn);
        market1.addExit("south", residential1);
        
        market2.addExit("north", inn);
        market2.addExit("west", market1);
        market2.addExit("south", residential2);
        
        residential1.addExit("north", market1);
        residential1.addExit("west", outsidethesoldierbarracks);
        residential1.addExit("east", residential2);
        
        residential2.addExit("north", market2);
        residential2.addExit("west", residential1);
        
        citygate.addExit("north", cropfields);
        citygate.addExit("west", outsidethewatermill);
        citygate.addExit("south", inn);
        
        insidethewatermill.addExit("south", outsidethewatermill);
        
        outsidethewatermill.addExit("north", insidethewatermill);
        outsidethewatermill.addExit("west", castlegarden);
        outsidethewatermill.addExit("east", citygate);
        outsidethewatermill.addExit("south", guardtower);
        
        topoftheguardtower.addExit("guardtower", guardtower);
        
        guardtower.addExit("north", outsidethewatermill);
        guardtower.addExit("west", castlegates);
        guardtower.addExit("east", inn);
        guardtower.addExit("south", market1);
        
        forest.addExit("south", cropfields);
        
        castle.addExit("north", secrettunnel);
        castle.addExit("east", castlegates);
        
        castlegarden.addExit("north", dungeonentrance);
        castlegarden.addExit("west", secrettunnel);
        castlegarden.addExit("east", outsidethewatermill);
        castlegarden.addExit("south", castlegates);
        
        castlegates.addExit("north", castlegarden);
        castlegates.addExit("west", castle);
        castlegates.addExit("east", guardtower);
        castlegates.addExit("south", outsidethesoldierbarracks);
        
        outsidethesoldierbarracks.addExit("north", castlegates);
        outsidethesoldierbarracks.addExit("east", residential1);
        outsidethesoldierbarracks.addExit("south", insidethesoldierbarracks);
        
        insidethesoldierbarracks.addExit("north", outsidethesoldierbarracks);
        
        hollowedouttree.addExit("east", forest);
        
        secrettunnel.addExit("east", castlegarden);
        secrettunnel.addExit("south", castle);
        
        dungeonentrance.addExit("south", castlegarden);
        
        dungeonmainroom.addExit("north", dungeonroom15);
        dungeonmainroom.addExit("west", dungeonroom13);
        dungeonmainroom.addExit("east", dungeonroom3);
        dungeonmainroom.addExit("south", dungeonentrance);
        
        dungeonroom3.addExit("west", dungeonmainroom);
        dungeonroom3.addExit("east", dungeonroom4);
        
        dungeonroom4.addExit("west", dungeonroom3);
        dungeonroom4.addExit("north", dungeonroom5);
        
        dungeonroom5.addExit("north", dungeonroom6);
        dungeonroom5.addExit("south", dungeonroom4);
        
        dungeonroom6.addExit("east", dungeonroom7);
        dungeonroom6.addExit("south", dungeonroom5);
        
        dungeonroom7.addExit("west", dungeonroom6);
        dungeonroom7.addExit("east", dungeonroom8);

        dungeonroom8.addExit("west", dungeonroom7);
        dungeonroom8.addExit("south", dungeonroom9);
        
        dungeonroom9.addExit("north", dungeonroom8);
        dungeonroom9.addExit("south", dungeonroom10);
        
        dungeonroom10.addExit("north", dungeonroom9);
        dungeonroom10.addExit("west", dungeonroom22);
        dungeonroom10.addExit("east", dungeonroom11);
        
        dungeonroom11.addExit("north", dungeonroom19);
        dungeonroom11.addExit("west", dungeonroom10);
        dungeonroom11.addExit("east", dungeonroom12);
        
        dungeonroom12.addExit("west", dungeonroom11);
        
        
        dungeonroom13.addExit("north", dungeonroom14);
        dungeonroom13.addExit("east", dungeonmainroom); 
        
        dungeonroom14.addExit("east", dungeonroom15);
        dungeonroom14.addExit("south", dungeonroom13);
       
        
        dungeonroom15.addExit("north", dungeonroom16);
        dungeonroom15.addExit("west", dungeonroom14);
        dungeonroom15.addExit("south", dungeonmainroom);
        
        dungeonroom16.addExit("north", dungeonroom17);
        dungeonroom16.addExit("south", dungeonroom15);
        
        
        dungeonroom17.addExit("north", dungeonroom18);
        dungeonroom17.addExit("west", dungeonroom20);
        dungeonroom17.addExit("east", dungeonroom21);
        dungeonroom17.addExit("south", dungeonroom16);
        
        dungeonroom18.addExit("east", dungeonroom19);
        dungeonroom18.addExit("south", dungeonroom17);
        
        
        dungeonroom19.addExit("west", dungeonroom18);
        dungeonroom19.addExit("south", dungeonroom11);
        
        dungeonroom20.addExit("east", dungeonroom17);
        
        dungeonroom21.addExit("west", dungeonroom17);
        
        dungeonroom22.addExit("east", dungeonroom10);
        
        
        
        //then add the rooms to the master list of all the rooms
        allRooms.add(inn);
        
        
        
        //add all items to their rooms here
        //roomName.addItem(item);
        
        //all npcs to their rooms here
        //roomName.addNPC(npc);
        
        //return whatever room they start in
        return inn;
    }
    
    
    /**
     * passes back all the rooms created in a list
     * so they can be accessed by the command processor
     */
    public ArrayList<Room> getRoomList()
    {
        return allRooms;
    }
}
