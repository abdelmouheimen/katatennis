package katatennis.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {

	private String name;
	private int gameScore;
	private int nbrGameWon;
	private int nbrSetWon;
	private int tieBreakPoint;

	public Player() {
		super();
	}

	public Player(String name) {
		super();
		this.name = name;
		this.gameScore = 0;
		this.nbrGameWon = 0;
	}
	
	public void winPoint(){
		this.gameScore++;
	}
	
	public void winTieBreakPoint() {
		this.tieBreakPoint++;
	}

	public int getRealScore() {
		switch (this.gameScore) {
		case 0:
			return 0;
		case 1:
			return 15;
		case 2:
			return 30;
		default:
			return 40;
		}
	}
	
	@Override
	public String toString() {
		return "Player [name= " + name + ", number of won Sets=" + nbrSetWon + "]";
	}
}
