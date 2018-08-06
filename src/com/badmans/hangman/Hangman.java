package com.badmans.hangman;

public class Hangman {

	public static void main(String[] args) {
		Game game = new Game();
		game.chooseWord("rhythm");
		String state = game.start();
		while (state == "playing") {
			state = game.play();
		}
		switch (state) {
		case "win":
			game.win();
			break;
		case "lose":
			game.lose();
			break;
		}
	}

}
