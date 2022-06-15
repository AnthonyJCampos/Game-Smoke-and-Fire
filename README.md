# Game-Smoke-and-Fire
First Software/Game. Smoke &amp; Fire is a Drinking Card Game 

Smoke & Fire is a Drinking Card Game that I was taught during my undergrad. I developed it during my 2nd course in Java during the spring of 2020. The goal was to bring a smile to my friends by developing a game that we played in our earlier 20s. The idea was to create something familiar that was a physical activity into software as we could no longer meet in person due to the pandemic.  Additionally, it was a tool to explore concepts, software design, and OOP.  Unfortunately, I was very new to programming and software design at the time as I was only in my 2nd course and was not knowledgeable on network implementation, so the game is currently only able to be played locally for 2-10 players.

Game Logic/Rules
2-10 players 
Players represented by a player object and text is entered in for each player name.
Error checking is present if user tries to enter more the designated player count. 
Option to exit program or return to main menu from player setup page.

Round 1:
Each player takes turns clicking either Smoke (red) or Fire (black). If the player guesses the correct color, they may give out 1 drink, if the player does not get the correct color, they must take 1 drink.

Round 2:
Each player takes turns guessing if the next card that is drawn form them will be higher or lower then their current card. If the player is correct, they give out 2 drinks, otherwise take 2.

Round 3:
Each player takes turns guessing if their next card will fall between their current numbers our outside the range of their current numbers. If the player is correct, they give out 3 drinks, otherwise take 3.

Round 4:
Each player takes turns guessing the suit their next card will be. If they are correct in guessing the suite, they will be instructed to give out 4 drinks, otherwise take 4.

Round 5:
There are three rows and a single end game card. 
The rows are: 
Give, a user gives a drink.
Take, a user takes a drink.
Share, a user shares a drink if they have that card in their hand. 
Each level increases the drink by one. 
If no players have the card that was flipped, then the user will be prompted to draw another card until a player has that card. If the deck runs out of cards, then the user will not be prompted to draw another card and the game will move forward. 
If a player gets the FU card, then they are asked to drink their beer or take a shot. 
At the end of the game the user has the option to replay, go to menu, or exit the program. 

