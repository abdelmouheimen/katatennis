import org.apache.log4j.Logger;

import katatennis.metier.Game;
import katatennis.metier.Match;
import katatennis.metier.Set;
import katatennis.model.Player;

public class ExampleKataTennis {

	final static Logger logger = Logger.getLogger(ExampleKataTennis.class);

	public static void main(String[] args) {
		Player player1 = new Player("Player1");
		Player player2 = new Player("Player2");
		Game game = new Game(player1, player2);
		Set set = new Set(game);
		Match match = new Match(set);
		match.playMatch();
		logger.info(match.getSets().toString());
		logger.info("Winner: " + match.getWinner().toString());
	}

}
