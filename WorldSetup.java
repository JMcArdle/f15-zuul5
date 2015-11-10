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
    }
    
    /**
     * create all the items
     */
    public void createItems()
    {
    }

    /**
     * Creates all the rooms
     */
    public Room makeRooms()
    {
        //declare all the rooms on this line
        Room inn, market1, market2, residential1, residential2, citygate, insidethewatermill, outsidethewatermill, topoftheguardtower, guardtower, forest, castle, 
        castlegarden, castlegates, outsidethesoldierbarracks, insidethesoldierbarracks, hollowedouttree, secrettunnel, dungeonentrance, dungeonmainroom, dungeonroom3,
        dungeonroom4, dungeonroom5, dungeonroom6, dungeonroom7, dungeonroom8, dungeonroom9, dungeonroom10, dungeonroom11, dungeonroom12, dungeonroom13, dungeonroom14,
        dungeonroom15, dungeonroom16, dungeonroom17, dungeonroom18, dungeonroom19, dungeonroom20, dungeonroom21, dungeonroom22;

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
        
       insidethesoldierbarracks = new Room ("insidethesoldierbarracks", "You are inside the soldier barracks.  All of the soldiers inside are standing around, looking a big hole in the ceiling." , "While most of the soldiers are standing under the hole in the ceiling, trying to figure out what happened, one of the soldiers is standing off to the side, looking rather nervous.  He seems to recognize you and decides to approach you. He tells you \“You’re the guy that the king hired right?  The one who’s supposed to get to the bottom of all this insanity?  Listen, I didn’t mean to for this to happen.  This morning I found this bottle outside.\” He pulls a small bottle out of his pocket, containing what looks like a tiny storm cloud.  \“I thought it looked cool, or at least was worth something, so I didn’t tell anybody.  Just a little while ago, I decided to try uncorking it, just to see what would happen right. As soon as I did, a freaking lightning bolt shot straight out and up, tearing through the ceiling.  I managed to get the cork back on before something else happened.  This thing is too destructive, so please take it.  I hope with it you can fix everything that’s been going wrong.\”  He hands you the bottle.|-getstorm");
       
       hallowedouttree = new Room("hallowedouttree", "You are in the city inn.  Since it’s the middle of the day, no one is inside besides the barkeep.", "The only person inside the inn is the barkeep.");
       
       secrettunnel = new Room("secrettunnel", "You are in the city inn.  Since it’s the middle of the day, no one is inside besides the barkeep.", "The only person inside the inn is the barkeep.");
        
       dungeonentrance = new Room("dungeonentrance", "You are inside the dungeon entrance." , "As soon as you enter, you realize that the door behind you suddenly locks, trapping you inside. Looks like it’s a one way journey from here on out.");
        
       dungeonmainroom = new Room("dungeonmainroom", "You are inside the main room." , "You walk in only to realize that the entire room is pitch black. You can’t make any sense of where you are going and in which direction.");
       
       dungeonroom3 = new Room("dungeonroom3", "You are inside a passageway." , "Go East, West");
       
       dungeonroom4 = new Room("dungeonroom4", "You are inside a small hall." , "Go West, North");
       
       dungeonroom5 = new Room("dungeonroom5", "You are inside a room with a crater." , "Go North, South");
        
       dungeonroom6 = new Room("dungeonroom6", "You are inside a room filled with water." , "Go East, South");
       
       dungeonroom7 = new Room("dungeonroom7", "You are inside a room with holes." , "Go East, West");
       
       dungeonroom8 = new Room("dungeonroom8", "You are inside a tunnel." , "You see that the entire room is deep in fog.  Its so dense that you cannot find your way through.");
       
       dungeonroom9 = new Room("dungeonroom9", "You are inside a large tunnel." , "Go North, South");
       
       dungeonroom10 = new Room("dungeonroom10", "You are inside a narrow corridor." , "Go West, East");
        
       dungeonroom11 = new Room("dungeonroom11", "You are inside a large room." , "As you enter, you approach a giant statue covering the exit. Pushing it seems impossible, it barely moves an inch.");
       
       dungeonroom12 = new Room("dungeonroom12", "You are in an unfamiliar place." , "You feel a foreboding presence in the room, although it is not yet known to you. Only hearty laughter can be heard as you make your way closer.");
        
       dungeonroom13 = new Room("dungeonroom13", "You are inside a small den." , "Go East, North");
        
       dungeonroom14 = new Room("dungeonroom14", "You are inside a room with glowing diamonds." , "Go South, East");
       
       dungeonroom15 = new Room("dungeonroom15", "You are inside a room with catacombs." , "Go North, South");
       
       dungeonroom16 = new Room("dungeonroom16", "You are inside a large chamber." , "Go North, South");
        
       dungeonroom17 = new Room("dungeonroom17", "You are inside a very large room." , "As you enter, you notice a strange looking door at the other end of the room. Upon further inspection, there seems to be a small lock attached to it. Go: North, East, West");
        
       dungeonroom18 = new Room("dungeonroom18", "You are inside a room with staircases." , "Go South, East");
        
       dungeonroom19 = new Room("dungeonroom19", "You are inside a passageway." , "Go West, South");
        
       dungeonroom20 = new Room("dungeonroom20", "You are at a dead end." , "Go East");
        
       dungeonroom21 = new Room("dungeonroom21", "You are at another dead end." , "Go West");
        
       dungeonroom22 = new Room("dungeonroom22", "You are at yet another dead end." , "Go East");
        
        

        // initialise room exits like this
        inn.addExit("east", room2);
        
        market1.addExit
        
        market2.addExit
        
        residential1.addExit
        
        residential2.addExit
        
        citygate.addExit
        
        insidethewatermill.addExit
        
        outsidethewatermill.addExit
        
        topoftheguardtower.addExit
        
        guardtower.addExit
        
        forest.addExit
        
        castle.addExit
        
        castlegarden.addExit
        
        castlegates.addExit
        
        outsidethesoldierbarracks.addExit
        
        insidethesoldierbarracks.addExit
        
        hallowedouttree.addExit
        
        secrettunnel.addExit
        
        dungeonentrance.addExit
        
        dungeonmainroom.addExit
        
        dungeonroom3.addExit
        
        dungeonroom4.addExit
        
        dungeonroom5.addExit
        
        dungeonroom6.addExit
        
        dungeonroom7.addExit

        dungeonroom8.addExit
        
        dungeonroom9.addExit
        
        dungeonroom10.addExit
        
        dungeonroom11.addExit
        
        dungeonroom12.addExit
        
        dungeonroom13.addExit
        
        dungeonroom14.addExit
        
        dungeonroom15.addExit
        
        dungeonroom16.addExit
        
        dungeonroom17.addExit
        
        dungeonroom18.addExit
        
        dungeonroom19.addExit
        
        dungeonroom20.addExit
        
        dungeonroom21.addExit
        
        dungeonroom22.addExit
        
        
        
        //then add the rooms to the master list of all the rooms
        allRooms.add(outside);
        allRooms.add(room2);
        
        currentRoom = inn;  // start game inside the inn
        
        //add all items to their rooms here
        //roomName.addItem(item);
        
        //all npcs to their rooms here
        //roomName.addNPC(npc);
        
        //return whatever room they start in
        return outside;
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
