### Requirements:

Write code for design of Battleship Game: https://en.wikipedia.org/wiki/Battleship_(game)

#### Rules of the Game
1. There are 2 players in the game.
1. Each Person has two boards, one where he places his own ships, one where he tracks
   the missiles he has fired. Each board is of size 10x10.
1. Each person can place 5 ships on his board
    1. Carrier of length 5
    1. Battleship of length 4
    1. Cruiser of length 3
    1. Submarine of length 3
    1. Destroyer of length 2
1. Players take a turn to fire missiles at the opposing player. If the missile hits a ship, then
   the opposing player informs the initial mover of a hit, else he says it’s a miss. If all the
   spots on a ship are hit, then ship is sunk.
1. The first player to sink all 5 ships of the opposing player wins the game.

This is the view of one player
1. Left-hand side is the ships as placed by the player. Red spots represent where the
   enemy successfully struck the player’s ships.
2. White/Green spots are where the enemy player missed.
3. The right-hand side is where the player has launched missiles against the enemy.
4. The player has sunk 3 of the enemy ship.

######  Bonus Requirement:
You don’t need to code this up, but explain how will you extend your design to
allow people to play over the network (p2p without having a central server).

# Reference:

Practiced learning this problem from https://github.com/anomaly2104/battleship-game-low-level-design