# Arknoid
## Overview
In this project we were asked to create an Arkanoid game based on the GUI interface of Bar-Ilan University.  
This assignment was part of the assignments in the OOP course at Bar-Ilan University.

## Game Flow
There are 4 levels in the game, where the goal is to eliminate the blocks in every level.  
Every time the ball hits a block, the block gets eliminated. When there are no more blocks on the screen, the level is over and the user moves to the next level.  
To control the ball and prevent it from going out of the screen (and losing the ball), the user moves the paddle at the bottom of the screen with the keyboard's left and right arrows.  
To pause the game, use 'p'. To continue, use the SPACE key.
## Video
[Watch the demo here] (https://youtu.be/ZRs-i-LH3bg)
## Run
First, clone this repo.  
To compile the game, use `ant compile`.  
To run the game from level 1 to 4, use the command `ant run`.  
To run the game with a different order of the levels, use the command `ant run -Dargs="levels order"`.  
For example, to run level 2 and then 4, the command will be `ant run -Dargs="2 4"`.

## Requirements
* Java
* Ant
