package katatennis.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class PlayerTest {

	Player player;
	
	@Before
	public void initializePlayers() {
		this.player = new Player("player");
	}
	
	@Test	
	public void winPointTest() {
		player.setGameScore(2);
		player.winPoint();
		assertEquals(3, player.getGameScore());
	}
	
	@Test	
	public void winTieBreakPointTest() {
		player.setTieBreakPoint(4);
		player.winTieBreakPoint();
		assertEquals(5, player.getTieBreakPoint());
	}
	
	@Test	
	public void getRealScoreTest() {
		player.setGameScore(0);
		assertEquals(0, player.getRealScore());
		player.setGameScore(1);
		assertEquals(15, player.getRealScore());
		player.setGameScore(2);
		assertEquals(30, player.getRealScore());
		player.setGameScore(3);
		assertEquals(40, player.getRealScore());

	}
	
}
