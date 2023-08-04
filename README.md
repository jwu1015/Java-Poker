In spring of 2023, I created a multiplayer poker game, with graphics integrated with java-swing.a part of my highschool AP computer science class semester 1 final project. The goal of the project was to create a simple board/card game in java. I decided to learn and implemeent java swing.

The final product was free of bugs and a very accessible user interface, and ended up getting a 100% score based on both the teacher's careful examination, as well as extensive testing from other students in the class.

This is a variation of Texas-hold'em poker.
https://www.partypoker.com/en/how-to-play/texas-holdem

In a round of betting players can either:

Raise - to make a bet or to add onto an existing bet. For example, to raise 20 when there is no bet means to make a bet of 20.
To raise 20 when there is a current bet of 20, when you haven't made a bet yet means to put in 40. You can also go all in, which means that you put all your money in the pot. If your opponent decides
to call, then the remaining cards are dealt without betting rounds.

Check - To do nothing and move onto the next player's turn. You can only check when there is no active bet.

Call - To match the active bet. If you cannot match the active bet, you may go all in to match it. If your opponent decides
to call, then the remaining cards are dealt without betting rounds. If your opponent goes all in and you do not have enough
to call, you may go all in. 

Fold - To give up and reset the round.

When the active bet is matched, the betting round ends. All raises and calls
are added to a pot. If a player folds, the money in the pot goes to the other player and the round resets. The betting round
does not end until the active bet is matched or a player folds.
At the end of a round, the amount in the pot will be added to the winner of the round.

The hand rankings are as follows(important to note that Aces can be the biggest and smallest card):
1. Royal flush
   A, K, Q, J, 10, all the same suit.
   A K Q J T

2. Straight flush
   Five cards in a sequence, all in the same suit.
   8 7 6 5 4
3. Four of a kind
   All four cards of the same rank.
   J J J J 7

4. Full house
   Three of a kind with a pair.
   T T T 9 9

5. Flush
   Any five cards of the same suit, but not in a sequence.
   4 J 8 2 9

6. Straight
   Five cards in a sequence, but not of the same suit.
   9 8 7 6 5

7. Three of a kind
   Three cards of the same rank.
   7 7 7 K 3

8. Two pair
   Two different pairs.
   4 4 3 3 Q

9. Pair
   Two cards of the same rank.
   A A 8 4 7

10. High Card
    When you haven't made any of the hands above, the highest card plays.
    In the example below, the jack plays as the highest card.
    3 J 8 4 2
    
If there is a tie, it is first checked which player has the highest card in their five card hand. For example,
a 2 pair of 8s and 2s would beat a 2 pairs of 7s and 4s. If there is a tie between the two highest cards, the next 
highest card would be checked. For example, a 2 pair of 8s and 4s would beat a 2 pair of 8s and 3s. If there is another tie
here, the kicker card, or the card that does not take part in the ranking is compared. If there is another tie here,
the pot is split between the two players. The game continues until a player has 0 at the start of a round.

