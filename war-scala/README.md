# War (Scala Edition)
Congratulations! You have been selected to continue on to the technical phase of the interview process at Cloud Imperium Games.

## Description
This is a relatively bare project that you must populate with a runnable solution and any supporting work like documentation, tests, etc.

## Programming Challenge
Let's go back to basics with this simple card game: war!

Your goal is to write a program which finds out which player is the winner for a given card distribution of the "war" game.
Rules
War is a card game played between two players. Each player gets a variable number of cards of the beginning of the game: that's the player's deck. Cards are placed face down on top of each deck.

Step 1 : the fight
At each game round, in unison, each player reveals the top card of their deck – this is a "battle" – and the player with the higher card takes both the cards played and moves them to the bottom of their stack. The cards are ordered by value as follows, from weakest to strongest:
`2`, `3`, `4`, `5`, `6`, `7`, `8`, `9`, `10`, `J`, `Q`, `K`, `A`.

Step 2 : war
If the two cards played are of equal value, then there is a "war". First, both players place the three next cards of their pile face down. Then they go back to step 1 to decide who is going to win the war (several "wars" can be chained). As soon as a player wins a "war", the winner adds all the cards from the "war" to their deck.

Special cases:

- If a player runs out of cards during a "war" (when giving up the three cards or when doing the battle), then the game ends and both players are placed equally first.
- The test cases provided in this puzzle are built in such a way that a game always ends (you do not have to deal with infinite games)

Each card is represented by its value followed by its suit: `D`, `H`, `C`, `S`. For example: `4H`, `8C`, `AS`.

When a player wins a battle, they put back the cards at the bottom of their deck in a precise order. First the cards from the first player, then the one from the second player (for a "war", all the cards from the first player then all the cards from the second player).

For example, if the card distribution is the following:

Player 1 : `10D 9S 8D KH 7D 5H 6S`

Player 2 : `10H 7H 5C QC 2C 4H 6D`

Then after one game turn, it will be:

Player 1 : `5H 6S 10D 9S 8D KH 7D 10H 7H 5C QC 2C`

Player 2 : `4H 6D`

> Victory Conditions  
> A player wins when the other player no longer has cards in their deck.


## Game Input

### Input

Line 1: the number `N` of cards for player one.

`N` next lines: the cards of player one.

Next line: the number `M` of cards for player two.

`M` next lines: the cards of player two.

### Output

- If players are equally first: PAT
- Otherwise, the player number (1 or 2) followed by the number of game rounds separated by a space character. A war or a succession of wars count as one game round.

### Constraints
0 < `N`, `M` < 1000

## Example

### Input
> 3  
> AD  
> KC  
> QC  
> 3  
> KH  
> QS  
> JC

### Output

> 1 3

## Assignment Submission

When you have completed this challenge, we would like you to create an archive of the solution and email it back to the talent acquisition representative.
Once we verify that your solution has been received, we will review your work and determine if we should proceed with the interview process.

## Next Steps

If Cloud Imperium Games determines that they would like to proceed forward with the interview process, the talent acquisition representative will coordinate scheduling a technical interview.

### What to expect

The technical interview will involve you meeting with technical representatives of the team so they can learn more about what you can contribute.
This will include any of the following:
- Review your solution, ask questions, and provide feedback.
- Ask deeper questions about your past work experience from a technical perspective.
- Ask you to solve a micro coding problem together.
- Ask you to solve an architectural/design problem together.

In addition, there will be time for you to ask the technical representatives of the team technically oriented questions about the nature of the work they do to determine if this opportunity is right for you.