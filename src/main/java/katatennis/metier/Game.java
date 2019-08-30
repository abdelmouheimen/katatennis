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

}
