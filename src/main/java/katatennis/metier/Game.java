package katatennis.metier;


import org.apache.log4j.Logger;

import katatennis.model.Player;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {
	final static Logger logger = Logger.getLogger(Game.class);
	private Player player1;
	private Player player2;
	private boolean isGameEnded;
	private boolean isTieBreakEnded;
	
	public Game(Player p1, Player p2) {
		this.player1 = p1;
		this.player2 = p2;
		this.isGameEnded = false;
		this.isTieBreakEnded = false;
	}

	public void winGame(Player player) {
		this.isGameEnded = true;
		player1.setGameScore(0);
		player2.setGameScore(0);
		player.setNbrGameWon(player.getNbrGameWon() + 1);
	}

	public void winTieBreakGame(Player player) {
		this.isTieBreakEnded = true;
		player1.setNbrSetWon(0);
		player2.setNbrSetWon(0);
		player.setNbrGameWon(player.getNbrGameWon() + 1);
	}

}
