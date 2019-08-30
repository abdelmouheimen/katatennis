package katatennis.metier;

import org.apache.log4j.Logger;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Set {

	final static Logger logger = Logger.getLogger(Set.class);
	private String score;
	private Game game;

	public Set(Game game) {
		this.score = "0 - 0";
		this.game = game;
	}

	public void playSet() {
		// play set when the players won games is less then 6
		while (this.game.getPlayer1().getNbrGameWon() < 6 && this.game.getPlayer2().getNbrGameWon() < 6) {
			this.game.playGame();
		}
		// execute this if one of the players won 6 games in a set and no one won the
		// set
		thisGame: while (Math
				.abs(this.game.getPlayer1().getNbrGameWon() - this.game.getPlayer2().getNbrGameWon()) < 2) {
			// if the two players have both won 6 games play a tie break game
			if (this.game.getPlayer1().getNbrGameWon() == this.game.getPlayer2().getNbrGameWon()
					&& this.game.getPlayer2().getNbrGameWon() == 6) {
				this.game.playTieBreakGame();
				break thisGame;
			} else {
				this.game.playGame();
			}
		}

		if (this.getGame().getPlayer1().getNbrGameWon() > this.game.getPlayer2().getNbrGameWon())
			this.game.getPlayer1().setNbrSetWon(this.game.getPlayer1().getNbrSetWon() + 1);
		else
			this.game.getPlayer2().setNbrSetWon(this.game.getPlayer2().getNbrSetWon() + 1);

		this.score = String.valueOf(this.game.getPlayer1().getNbrGameWon()) + " - "
				+ String.valueOf(this.game.getPlayer2().getNbrGameWon());
		logger.info(this.score);
		this.game.initializeNbrGameWon();
	}
}
