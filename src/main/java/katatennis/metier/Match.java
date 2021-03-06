package katatennis.metier;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import katatennis.model.Player;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Match {
	final static Logger logger = Logger.getLogger(Match.class);
	private Map<String, String> sets;
	private Set set;
	
	public Match(Set set) {
		super();
		this.sets = new LinkedHashMap<String, String>();
		this.set = set;
	}

	public Player getWinner() {
		if (this.set.getGame().getPlayer1().getNbrSetWon()>this.set.getGame().getPlayer2().getNbrSetWon())
			return this.set.getGame().getPlayer1();
		else
			return this.set.getGame().getPlayer2();
	}
	
	public void playMatch() {
		int index=0;
		while (this.set.getGame().getPlayer1().getNbrSetWon() < 3 && this.set.getGame().getPlayer2().getNbrSetWon() < 3) {
			logger.info("********************* SET:" + String.valueOf(++index) + " *********************");
			this.set.playSet();
			sets.put("SET" + String.valueOf(index)+": ", this.set.getScore());
		}
	}
}
