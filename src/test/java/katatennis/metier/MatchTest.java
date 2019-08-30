package katatennis.metier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import katatennis.model.Player;

public class MatchTest {
	
	Player player1;
	Player player2;
	Game   game;
	Set	   set;

	@Before
	public void initializePlayers() {
		this.player1 = new Player("player1");
		this.player2 = new Player("player2");
		this.game = new Game(player1, player2);
		this.set = new Set(game);
	}

	@Test
	public void getWinnerTest() {
		Match match = new Match(this.set);
		this.set.getGame().getPlayer1().setNbrSetWon(3);
		this.set.getGame().getPlayer2().setNbrSetWon(2);
		
		assertEquals(player1 , match.getWinner());
		
		this.set.getGame().getPlayer2().setNbrSetWon(3);
		this.set.getGame().getPlayer1().setNbrSetWon(2);
		assertEquals(player2 , match.getWinner());
	}
	
	@Test
	public void playMatchTest() {
		Match match = new Match(this.set);
		this.set.getGame().getPlayer1().setNbrSetWon(2);
		this.set.getGame().getPlayer2().setNbrSetWon(2);
		match.playMatch();
		assertNotEquals(0 , match.getSets().size());
	}
	

}
