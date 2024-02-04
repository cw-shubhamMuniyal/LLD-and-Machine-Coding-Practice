using CricBuzz.Logic;
using CricBuzz.Logic.Interfaces;
using CricBuzz.Model;

namespace CricBuzz;

// Copied and conveted into C# for learning

class Program
{
    static void Main(string[] args)
    {
        Console.WriteLine("Hello, World!");
        Program ob = new Program();

        Team teamA = ob.AddTeam("India");
        Team teamB = ob.AddTeam("SriLanka");

        IMatchType matchType = new T20Match();
        Match match = new Match(teamA, teamB, new(), "SMS STADIUM", matchType);
        match.startMatch();
    }

    private Team AddTeam(string name)
    {
        Queue<PlayerDetails> playerDetails = new();

        PlayerDetails p1 = AddPlayer(name + "1", PlayerType.AllRounder);
        PlayerDetails p2 = AddPlayer(name + "2", PlayerType.AllRounder);
        PlayerDetails p3 = AddPlayer(name + "3", PlayerType.AllRounder);
        PlayerDetails p4 = AddPlayer(name + "4", PlayerType.AllRounder);
        PlayerDetails p5 = AddPlayer(name + "5", PlayerType.AllRounder);
        PlayerDetails p6 = AddPlayer(name + "6", PlayerType.AllRounder);
        PlayerDetails p7 = AddPlayer(name + "7", PlayerType.AllRounder);
        PlayerDetails p8 = AddPlayer(name + "8", PlayerType.AllRounder);
        PlayerDetails p9 = AddPlayer(name + "9", PlayerType.AllRounder);
        PlayerDetails p10 = AddPlayer(name + "10", PlayerType.AllRounder);
        PlayerDetails p11 = AddPlayer(name + "11", PlayerType.AllRounder);

        playerDetails.Enqueue(p1);
        playerDetails.Enqueue(p2);
        playerDetails.Enqueue(p3);
        playerDetails.Enqueue(p4);
        playerDetails.Enqueue(p5);
        playerDetails.Enqueue(p6);
        playerDetails.Enqueue(p7);
        playerDetails.Enqueue(p8);
        playerDetails.Enqueue(p9);
        playerDetails.Enqueue(p10);
        playerDetails.Enqueue(p11);

        List<PlayerDetails> bowlers = new();
        bowlers.Add(p8);
        bowlers.Add(p9);
        bowlers.Add(p10);
        bowlers.Add(p11);

        Team team = new Team(name, playerDetails, new(), bowlers);
        return team;

    }
    private PlayerDetails AddPlayer(string name, PlayerType playerType)
    {

        Person person = new Person();
        person.Name = name;
        PlayerDetails playerDetails = new PlayerDetails(person, playerType);
        return playerDetails;
    }
}
