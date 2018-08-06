package com.badmans.hangman;

import java.util.ArrayList;

public class Text {

	private int count;
	private String blanks;
	private String letterRepo;
	private String gallows[] = new String[7];
	private String word;
	private Boolean win;
	private ArrayList<String> chosenLetters = new ArrayList<>();

	public Text() {
		gallows[0] = "";
		gallows[1] = "-------  ";
		gallows[2] = "|     |  ";
		gallows[3] = "|     o  ";
		gallows[4] = "|    / \\";
		gallows[5] = "|    / \\";
		gallows[6] = "|_______ ";
		count = 0;
		win = false;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public void promptPlayer() {
		System.out.println("The word is " + word.length() + " letters long");
		this.displayWord();
		System.out.println("Pick a letter: ");
	}

	public String checkLetter(String letter) {
		letter = letter.toLowerCase();
		char input = letter.charAt(0);
		if (Character.isDigit(input)) {
			System.out.println("Please do not enter a number!\n");
		} else if (letter.length() > 1) {
			System.out.println("Please enter a single lower case letter!\n");
		} else if (chosenLetters.contains(letter)) {
			System.out.println("You've already picked this letter!\n");
		} else {
			chosenLetters.add(letter);
			if (word.contains(letter)) {
				System.out.println("Correct!\n");
			} else {
				System.out.println("Incorrect...");
				count++;
				System.out.println("You have " + (6-count) + " chances left!");
				if (count == 6) {
					return "lose";
				}
			}
		}
		this.displayWord();
		if (win == true) {
			return "win";
		} else {
			System.out.println("Pick a letter: ");
			return "playing";
		}
	}

	public void displayWord() {
		blanks = "";
		letterRepo = "";
		for (int i = 0; i < word.length(); i++) {
			if (chosenLetters.contains(word.substring(i, i+1))) {
				blanks += word.charAt(i);
			} else {
				blanks += "_";
			}
		}
		if (blanks.equals(word)) {
			win = true;
		}
		this.drawMan();
		System.out.println("\n" + blanks + "\n");
		System.out.println("Chosen letters:\n");
		for (String temp : chosenLetters) {
			letterRepo += (temp + " ");
		}
		System.out.println(letterRepo + "\n");
		System.out.println("=====================================");
	}

	public void drawMan() {
		for (int i = 0; i <= count; i++) {
			System.out.println(gallows[i]);
		}
	}

	public void win() {
		System.out.println("Congratulations you have won!");
		this.end();
	}

	public void lose() {
		this.drawMan();
		System.out.println("\nWhoops, you lost!");
		this.end();
	}

	public void end() {
		System.out.println("\nThe word was '" + word + "'");
	}

}
