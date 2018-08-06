package com.badmans.hangman;

import java.util.Scanner;

public class Game {

	private Text text;
	private String letter;
	private Scanner keyboard;

	public Game() {
		text = new Text();
		keyboard = new Scanner(System.in);
	}

	public void chooseWord(String word) {
		text.setWord(word);
	}

	public String start() {
		text.promptPlayer();
		return "playing";
	}

	public String play() {
		this.letter = keyboard.next();
		return text.checkLetter(letter);
	}

	public void win() {
		text.win();
	}

	public void lose() {
		text.lose();
	}
}
