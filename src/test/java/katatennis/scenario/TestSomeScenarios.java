package katatennis.scenario;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import katatennis.metier.Game;
import katatennis.model.Player;

public class TestSomeScenarios {

	Player player1;
	Player player2;
	Game   game;

	@Before
	public void initializePlayers() {
		this.player1 = new Player("player1");
		this.player2 = new Player("player2");
		this.game = new Game(player1, player2);
	}

	@Test
	public void testNormalScoreInGameForPlayer1() {
		this.player1.winPoint();
		assertEquals("15 - 0", "15 - 0", game.getScore());
	}

	@Test
	public void testDeuceScoreInGame() {
		this.player1.winPoint();
		this.player2.winPoint();
		this.player1.winPoint();
		this.player2.winPoint();
		this.player1.winPoint();
		this.player2.winPoint();
		assertEquals("Deuce: ", "40 - 40", game.getScore());
	}

	@Test
	public void testAvantageInGameForPlayer1() {
		this.player1.winPoint();
		this.player2.winPoint();
		this.player1.winPoint();
		this.player2.winPoint();
		this.player1.winPoint();
		this.player2.winPoint();
		this.player1.winPoint();
		assertEquals("Avantage: ", "AVANTAGE " + this.player1.getName(),
				game.getScore());
	}
	
	@Test
	public void testDeuceScoreInGameAfterAvantagePlayer1() {
		this.player1.winPoint();
		this.player2.winPoint();
		this.player1.winPoint();
		this.player2.winPoint();
		this.player1.winPoint();
		this.player2.winPoint();
		this.player1.winPoint();
		this.player2.winPoint();
		assertEquals("Deuce: ", "40 - 40", game.getScore());
	}
	
	@Test
	public void testWonInGameForPlayer1() {
		this.player1.winPoint();
		this.player1.winPoint();
		this.player1.winPoint();
		this.player1.winPoint();
		assertEquals("Won: " ,player1.getName() + " won the game", game.getScore().replaceAll("_", "").trim());
	}

	@Test
	public void testNormalScoreInTieBreakForPlayer1() {
		this.player1.winTieBreakPoint();
		assertEquals("Normal: " ,"1 - 0" , game.getTieBreakScore());
	}
	
	@Test
	public void testWonScoreInTieBreakForPlayer1() {
		this.player1.winTieBreakPoint();
		this.player1.winTieBreakPoint();
		this.player1.winTieBreakPoint();
		this.player1.winTieBreakPoint();
		this.player1.winTieBreakPoint();
		this.player1.winTieBreakPoint();
		this.player1.winTieBreakPoint();
		assertEquals("won Tie Break: " ,player1.getName() + " won the Tie Break game", game.getTieBreakScore().replaceAll("_", "").trim());
	}
	
	@Test
	public void testNotWonScoreInTieBreakForPlayer1AfterSevenPoints() {
		this.player1.winTieBreakPoint();
		this.player2.winTieBreakPoint();
		this.player1.winTieBreakPoint();
		this.player2.winTieBreakPoint();
		this.player1.winTieBreakPoint();
		this.player2.winTieBreakPoint();
		this.player1.winTieBreakPoint();
		this.player2.winTieBreakPoint();
		this.player1.winTieBreakPoint();
		this.player2.winTieBreakPoint();
		this.player1.winTieBreakPoint();
		this.player2.winTieBreakPoint();
		this.player1.winTieBreakPoint();
		assertEquals("Normal: " ,"7 - 6" , game.getTieBreakScore());
	}

	@Test
	public void testWonScoreInTieBreakForPlayer1AfterSevenPoints() {
		this.player1.winTieBreakPoint();
		this.player2.winTieBreakPoint();
		this.player1.winTieBreakPoint();
		this.player2.winTieBreakPoint();
		this.player1.winTieBreakPoint();
		this.player2.winTieBreakPoint();
		this.player1.winTieBreakPoint();
		this.player2.winTieBreakPoint();
		this.player1.winTieBreakPoint();
		this.player2.winTieBreakPoint();
		this.player1.winTieBreakPoint();
		this.player2.winTieBreakPoint();
		this.player1.winTieBreakPoint();
		this.player1.winTieBreakPoint();
		assertEquals("won Tie Break: " ,player1.getName() + " won the Tie Break game", game.getTieBreakScore().replaceAll("_", "").trim());
	}

}
