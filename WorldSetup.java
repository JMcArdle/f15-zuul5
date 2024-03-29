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
        NPC barkeep = new NPC("barkeep", "Looks like the posterboy of a generic barkeep.", null, null, null, "You keep that up, you'll get more than just a free drink.", null, null, null, null);
        inn.addNPC(barkeep);
        //all barkeep lines here
        barkeep.addTalk("I used to be a taxi driver, but I didn't think I was going anywhere.");
        barkeep.addTalk("My friend's bakery burned down the other day. Now his business is toast.");
        barkeep.addTalk("I used to be a banker, but then I lost interest.");
        barkeep.addTalk("Back when I was a taxi driver, some people had trouble figuring out how the seatbelt worked, but... then it clicked.");
        barkeep.addTalk("What does a father buffalo say to his son when he leaves for college? Bison.");
        barkeep.addTalk("If I throw too many bird puns at you, remember, tucan play at that game.");
        barkeep.addTalk("It socks to be lonely.");
        barkeep.addTalk("I used to put on a theatrical performance about puns, but it was really just a play on words.");
        barkeep.addTalk("I'd tell you a chemistry joke, but I'm afraid I wouldn't get a reaction.");
        barkeep.addTalk("What did the grape say when it got stepped on? Nothing, it just let out a little whine.");
        barkeep.addTalk("I used to have a fear of hurdles, but then I got over it.");
        barkeep.addTalk("What ancient sock was a great philosopher? Sockratese.");
        
        NPC king = new NPC("king", "He looks just like a king should, regal and proud and incredibly thirsty.", null, "He tastes sweet, like raspberries.", null, null, null, null, null, null);
        castle.addNPC(king);
        king.addTalk("You approach the king, he says, \"Hello good sir. You took your sweet fucking time getting here. Now that you're done liesurely meandering through town, you can get started doing you\'re fucking job. Listen, we don\'t know what\'s going on, but shit has gotten real and we don\'t know what to make of it. Everything isn\'t acting as it should and we need you to get to the bottom of it. I suggest you start at the watermill. It\'s in the northeast section of town. Don\'t you dare fuck this up, I\'m in a very iritable mood right now, my royal slippers have gone missing.|-phase1");
        
        NPC gnomeKing = new NPC("Gnome King", "He looks rather large for a gnome. Even though he\'s three feet tall, he\'s very intimidating.", "You rush the king hoping to catch him off guard.  You reach him, but then his beard quickly engulfs you.  The mass of his beard keeps expanding and growing.  There is no way for you to get out.  You slowly suffocate under the awesome might of his beard.\n\nGame over.|-gameover", null, "Tastes like my cat.", null, null, null, null, null);
        gnomeKing.addTalk("Why are you here tall one?  You have already ruined all the fun we were having with your town.  I don\'t really care that you were able to free all the forces that we bottled, because we got what we originally wanted anyway.\"  He then holds up a bottled containing what looks like a pair of socks.  \"That\'s right!  It was us who stole all the socks from your town.  Do you have any idea what it\'s like to live underground without any socks?  Our feet are cold as shit.  And when we asked the humans to make some socks for us, they laughed in our faces!  We gnomes can'\t figure out how to make socks for ourselves.  So if we can\'t have any, then NO ONE CAN!\" He then leaps off of his throne, landing in front of you, ready to fight.  As he stands before you, you notice his beard start to grow and move.  “You stand before Billiam Wosbie, the Gnome king!  None have ever been able to stand up to the might of my beard.  Its power is unrivaled throughout the land.\"  You can feel an insanely powerful energy emanating from the king\'s beard.  Anything but your strongest attack won\'t be able to stand up against him.");
        
        
    }
    
    /**
     * create all the items
     */
    public void createItems()
    {
        secrettunnel.addItem(new Item("key", "Looks like a key to something important.", null, null, null, null, null, null, null, null, null, false));
        dungeonroom17.addItem(new Item("door", "Upon further inspection, there seems to be a small lock attached to it.", null, null, null, null, null, null, null, null, null, false));
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
       
       castlegates = new Room("castlegates", "You are at the castle gates, the entrance to the castle.  There seem to be many more guards at the front gate than usual." , "Some of the guards are talking amongst each other.  You over hear them say that they think the king is being overly cautious and that he should stop making them work so hard. You aslo overhear one guard complaining about how he can't find his socks.");
        
       outsidethesoldierbarracks = new Room("outsidethesoldierbarracks", "You are outside the solider barracks.  This is where the soldiers on duty eat and rest." , "You over hear the guards complaining about the king overworking them.");
        
       insidethesoldierbarracks = new Room ("insidethesoldierbarracks", "You are inside the soldier barracks.  All of the soldiers inside are standing around, looking at a big hole in the ceiling." , "While most of the soldiers are standing under the hole in the ceiling, trying to figure out what happened, one of the soldiers is standing off to the side, looking rather nervous.  He seems to recognize you and decides to approach you. He tells you \"You’re the guy that the king hired, right?  The one who’s supposed to get to the bottom of all this insanity?  Listen, I didn’t mean to for this to happen.  This morning I found this bottle outside.\" He pulls a small bottle out of his pocket, containing what looks like a tiny storm cloud.  \"I thought it looked cool, or at least was worth something, so I didn’t tell anybody.  Just a little while ago, I decided to try uncorking it, just to see what would happen, you know. As soon as I did, a freaking lightning bolt shot straight out and up, tearing through the ceiling.  I managed to get the cork back on before something else happened.  This thing is too destructive, so please take it.  I hope with it you can fix everything that’s been going wrong.\"  He hands you the bottle.|-getstorm");
       
       hollowedouttree = new Room("hallowedouttree", "You are inside the hollowed out tree. There are two small cots inside, it seems like the two gnomes were hiding out here. The second gnome is in the corner clutching the bottle.", "The gnome seems understandably scared, it doesn't look like he wants to fight.");
       
       secrettunnel = new Room("secrettunnel", "You are in a secret path in the castle. You do not know where this leads, but after following the path north, the path turns to the east.", "There is not much to look at in here. It is a dark and boring path. You do however, notice a small key attatched to a chain, hanging on the wall. You decide to take it, as the key should prove useful later on.|-ainb key");
        
       dungeonentrance = new Room("dungeonentrance", "You are inside the dungeon entrance.|-moditem fire use null" , "As soon as you enter, you realize that the door behind you suddenly locks, trapping you inside. Looks like it’s a one way journey from here on out. You can go North.");
        
       dungeonmainroom = new Room("dungeonmainroom", "You are inside the main room." , "You walk in only to realize that the entire room is pitch black. You can’t make any sense of where you are going and in which direction.|-moditem fire use An immense fire escapes from the bottle, lighting up the room and allowing you to see the paths ahead. You can go North, East or West.");
       
       dungeonroom3 = new Room("dungeonroom3", "You are inside a passageway.|-moditem fire use null" , "You can go East or West");
       
       dungeonroom4 = new Room("dungeonroom4", "You are inside a small hall." , "You can go West or North");
       
       dungeonroom5 = new Room("dungeonroom5", "You are inside a room with a crater." , "You can go North or South");
        
       dungeonroom6 = new Room("dungeonroom6", "You are inside a room filled with water." , "You can go East or South");
       
       dungeonroom7 = new Room("dungeonroom7", "You are inside a room with holes.|-mod item wind use null" , "You can go East or West");
       
       dungeonroom8 = new Room("dungeonroom8", "You are inside a tunnel." , "You see that the entire room is deep in fog.  It\'s so dense that you cannot find your way through.|-moditem wind use A gust of wind releases from the bottle, blowing away all the fog surrounding the area. You are able to see the path ahead of you splits West and South.");
       
       dungeonroom9 = new Room("dungeonroom9", "You are inside a large tunnel.|-mod item wind use null" , "You can go North or South");
       
       dungeonroom10 = new Room("dungeonroom10", "You are inside a narrow corridor.|-mod item life use null" , "You can go West or East");
        
       dungeonroom11 = new Room("dungeonroom11", "You are inside a large room.|-makelifework" , "As you enter, you approach a giant statue covering the exit. Pushing it seems impossible, it barely moves an inch.|-moditem life use ");
       
       dungeonroom12 = new Room("dungeonroom12", "You enter the gnome king\'s lair. The room almost looks like an underground throne room.  Dozens of brightly light torches adorn the walls.  As you enter the room, you notice hundreds of gnomes gathered in the hall off to the side.  They all turn to stare at you expectantly.  At the end of the room is a rather small looking throne made of what looks like obsidian.  Sitting atop is a very large gnome, about 3 feet tall.  He has rough facial features, and sported a very impressive beard.  He too, was staring at you as you entered the room.|-setupfinalbattle" , "As you look around the room, you wonder as to why all of the gnomes haven’t attacked you yet.  It seems as if they are letting their king handle you.");
        
       dungeonroom13 = new Room("dungeonroom13", "You are inside a small den.|-moditem fire use null" , "You can go East or North");
        
       dungeonroom14 = new Room("dungeonroom14", "You are inside a room with glowing diamonds." , "You can go South or East");
       
       dungeonroom15 = new Room("dungeonroom15", "You are inside a room with catacombs.|-moditem fire use null" , "You can go North or South");
       
       dungeonroom16 = new Room("dungeonroom16", "You are inside a large chamber.|-mod item key use null" , "You can go North or South");
        
       dungeonroom17 = new Room("dungeonroom17", "As you enter, you notice a strange looking door at the other end of the room.|-makekeywork", "Upon further inspection, there seems to be a small lock attached to it.");
        
       dungeonroom18 = new Room("dungeonroom18", "You are inside a room with staircases.|-mod item key use null" , "You can go South or East");
        
       dungeonroom19 = new Room("dungeonroom19", "You are inside a passageway.|-mod item life use null" , "You can go West or South");
        
       dungeonroom20 = new Room("dungeonroom20", "You are at a dead end.|-mod item key use null" , "You can go East");
        
       dungeonroom21 = new Room("dungeonroom21", "You are at another dead end.|-mod item key use null" , "You can go West");
        
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
        guardtower.addExit("tower",topoftheguardtower);
        guardtower.addExit("guard tower", topoftheguardtower);
        
        forest.addExit("south", cropfields);
        
        castle.addExit("east", castlegates);
        
        castlegarden.addExit("north", dungeonentrance);
        castlegarden.addExit("east", outsidethewatermill);
        castlegarden.addExit("south", castlegates);
        
        castlegates.addExit("north", castlegarden);
        castlegates.addExit("west", castle);
        castlegates.addExit("east", guardtower);
        castlegates.addExit("south", outsidethesoldierbarracks);
        
        outsidethesoldierbarracks.addExit("north", castlegates);
        outsidethesoldierbarracks.addExit("east", residential1);
        
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
        allRooms = new ArrayList<Room>();
        
        allRooms.add(inn);
        allRooms.add(market1);
        allRooms.add(market2);
        allRooms.add(residential1);
        allRooms.add(residential2);
        allRooms.add(citygate);
        allRooms.add(cropfields);
        allRooms.add(insidethewatermill);
        allRooms.add(outsidethewatermill);
        allRooms.add(topoftheguardtower);
        allRooms.add(guardtower);
        allRooms.add(forest);
        allRooms.add(castle);
        allRooms.add(castlegarden);
        allRooms.add(castlegates);
        allRooms.add(outsidethesoldierbarracks);
        allRooms.add(insidethesoldierbarracks);
        allRooms.add(hollowedouttree);
        allRooms.add(secrettunnel);
        allRooms.add(dungeonentrance);
        allRooms.add(dungeonmainroom);
        allRooms.add(dungeonroom3);
        allRooms.add(dungeonroom4);
        allRooms.add(dungeonroom5);
        allRooms.add(dungeonroom6);
        allRooms.add(dungeonroom7);
        allRooms.add(dungeonroom8);
        allRooms.add(dungeonroom9);
        allRooms.add(dungeonroom10);
        allRooms.add(dungeonroom11);
        allRooms.add(dungeonroom12);
        allRooms.add(dungeonroom13);
        allRooms.add(dungeonroom14);
        allRooms.add(dungeonroom15);
        allRooms.add(dungeonroom16);
        allRooms.add(dungeonroom17);
        allRooms.add(dungeonroom18);
        allRooms.add(dungeonroom19);
        allRooms.add(dungeonroom20);
        allRooms.add(dungeonroom21);
        allRooms.add(dungeonroom22);
        
  
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
