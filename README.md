# Can you beat the dealer at 21?

## Model the game
* create a single deck of playing cards
* two players (called Sam and the Dealer) who will play against each other
* each player is given two cards from the top of a shuffled deck of cards. Cards are given in the following order: [sam, dealer, sam, dealer]

## Rules to implement
* determine score of a hand[1]
* check if either player has Blackjack with their initial hand and wins the game. Blackjack is an initial score of 21 with two cards: A + [10, J, Q, K]
* sam wins when both players starts with Blackjack
* dealer wins when both players starts with 22 (A + A)
* if neither player has Blackjack then sam can start drawing cards from the top of the deck
* sam must stop drawing cards from the deck if their total reaches 17 or higher
* sam has lost the game if their total is higher than 21
* when sam has stopped drawing cards the dealer can start drawing cards from the top of the deck
* the dealer must stop drawing cards when their total is higher than sam.
* the dealer has lost the game if their total is higher than 21
* determine which player wins the game (highest score wins)

[1] Numbered cards are their point value. Jack, Queen and King count as 10 and Ace counts as 11.

### Input
The game should be able to read a file containing a deck of cards, taking the reference to the file as a command line argument, as a starting point. If no file is provided, a new shuffled deck of 52 unique cards should be initialized.

The list is in the following format:
```
CA, D4, H7, SJ,…, S5, S9, D10
```
### Suits
```
C: Clubs
D: Diamonds
H: Hearts
S: Spades
```
### Values
```
2: 2
3: 3
….
10: 10
J: Jack
Q: Queen
K: King
A: Ace
```
### Output
```
[sam|dealer]
sam: card1, card2,..., cardN
dealer: card1, card2,..., cardN
```

### Example
When supplied with the following cardlist:
CA, D5, H9, HQ, S8
The output should look like:

```
sam
sam: CA, H9
dealer: D5, HQ, S8
```
### Testing
The solution should include tests.
