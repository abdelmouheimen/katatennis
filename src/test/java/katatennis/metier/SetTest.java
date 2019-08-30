package katatennis.metier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import katatennis.model.Player;

public class SetTest {

	Player player1;
	Player player2;
	Game   game;
	Set    set;

	@Before
	public void initializePlayers() {
		this.player1 = new Player("player1");
		this.player2 = new Player("player2");
		this.game = new Game(player1, player2);
		this.set = new Set(game);
	}
	
	@Test
	public void initializePlayersTest() {
		set.playSet();
		assertNotNull(set.getScore());
		assertEquals(0, player1.getNbrGameWon());
		assertEquals(0, player2.getNbrGameWon());
	}


}
