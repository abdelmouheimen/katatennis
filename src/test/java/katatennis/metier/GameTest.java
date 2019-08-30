package katatennis.metier;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import katatennis.model.Player;

public class GameTest {

	Player player1;
	Player player2;
	Game game;

	@Before
	public void initializePlayers() {
		this.player1 = new Player("player1");
		this.player2 = new Player("player2");
		this.game = new Game(player1, player2);
	}

	@Test
	public void winGameTest() {
		player1.setNbrGameWon(2);
		game.winGame(player1);
		assertEquals(true, game.isGameEnded());
		assertEquals(0, player2.getGameScore());
		assertEquals(0, player1.getGameScore());
		assertEquals(3, player1.getNbrGameWon());
	}

	@Test
	public void winTieBreakGameTest() {
		player1.setNbrGameWon(6);
		game.winTieBreakGame(player1);
		assertEquals(0, player2.getNbrSetWon());
		assertEquals(0, player1.getNbrSetWon());
		assertEquals(7, player1.getNbrGameWon());
	}

	@Test
	public void getScoreTest() {

		this.player1.setGameScore(2);
		this.player2.setGameScore(2);
		assertEquals("30 - 30", game.getScore());

		this.player1.setGameScore(4);
		this.player2.setGameScore(3);
		assertEquals("AVANTAGE " + player1.getName(), game.getScore());

		this.player1.setGameScore(3);
		this.player2.setGameScore(4);
		assertEquals("AVANTAGE " + player2.getName(), game.getScore());

		this.player1.setGameScore(5);
		this.player2.setGameScore(3);
		assertEquals("_________________" + player1.getName() + " won the game" + "_________________ \n\n\n",
				game.getScore());

		this.player1.setGameScore(3);
		this.player2.setGameScore(5);
		assertEquals("_________________" + player2.getName() + " won the game" + "_________________ \n\n\n",
				game.getScore());

		this.player1.setGameScore(4);
		assertEquals("_________________" + player1.getName() + " won the game" + "_________________ \n\n\n",
				game.getScore());

		this.player2.setGameScore(4);
		assertEquals("_________________" + player2.getName() + " won the game" + "_________________ \n\n\n",
				game.getScore());
	}
}
