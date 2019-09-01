package katatennis.metier;


import java.util.Random;

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
		this. initializeGameScore();
		player.setNbrGameWon(player.getNbrGameWon() + 1);
	}

	public void winTieBreakGame(Player player) {
		this.isTieBreakEnded = true;
		initializeGameScore();
		player.setNbrGameWon(player.getNbrGameWon() + 1);
	}
	

	public void initializeNbrGameWon() {
		player1.setNbrGameWon(0);
		player2.setNbrGameWon(0);
	}

	public void initializeGameScore() {
		player1.setGameScore(0);
		player2.setGameScore(0);
	}

	public void whoIsThePlayerWinPoint() {
		int num = 0;
		/************* the user set a game result ********/
//		while(num!=1 && num!=2) {
//			System.out.println("Who win a point Player 1 or Player 2 (1 for player 1 and 2 for player 2)");
//			Scanner in = new Scanner(System.in);
//			num = in.nextInt();
//		}
		Random random = new Random();
		num = random.nextInt(2) + 1;
		switch (num) {
		case 1:
			this.player1.winPoint();
			break;
		case 2:
			this.player2.winPoint();
			break;
		}
	}

	public void WhoIsThePlayerWinTieBreak() {
		int num = 0;
		/************* the user set a game result ********/
//		while(num!=1 && num!=2) {
//			System.out.println("Who win a point Player 1 or Player 2 (1 for player 1 and 2 for player 2)");
//			Scanner in = new Scanner(System.in);
//			num = in.nextInt();
//		}
		Random random = new Random();
		num = random.nextInt(2) + 1;
		switch (num) {
		case 1:
			this.player1.winTieBreakPoint();
			break;
		case 2:
			this.player2.winTieBreakPoint();
			break;
		}
	}
	
	public void playGame() {
		while (!this.isGameEnded) {
			whoIsThePlayerWinPoint();
			logger.info(getScore());
		}
		this.setGameEnded(false);
	}

	public void playTieBreakGame() {
		while (!this.isTieBreakEnded) {
			WhoIsThePlayerWinTieBreak();
			logger.info(getTieBreakScore());
		}
		this.setTieBreakEnded(false);
	}

	//get Score for a tie break game
		public String getTieBreakScore() {
			if(player1.getTieBreakPoint()>=7 && player2.getTieBreakPoint()<=player1.getTieBreakPoint()-2) {
				winTieBreakGame(player1);
				return "_________________" + player1.getName() + " won the Tie Break game" + "_________________ \n\n\n";
			}else if(player2.getTieBreakPoint()>=7 && player1.getTieBreakPoint()<=player2.getTieBreakPoint()-2) {
				winTieBreakGame(player2);
				return "_________________" + player2.getName() + " won the Tie Break game" + "_________________ \n\n\n";
			}
			return player1.getTieBreakPoint() + " - " + player2.getTieBreakPoint();
		}

		//get Score for a normal game
		public String getScore() {
			// Equality
			if (player1.getGameScore() == player2.getGameScore())
				switch (player1.getGameScore()) {
				case 0:
					return "0 - 0";
				case 1:
					return "15 - 15";
				case 2:
					return "30 - 30";
				case 3:
					return "40 - 40";
				case 4:
					updateScoreAfterDeuce();
					return "40 - 40";

				}
			// Deuce
			if (player1.getGameScore() >= 3 && player2.getGameScore() >= 3) {
				// Avantage to player1
				if (player1.getGameScore() == 4 && player2.getGameScore() == 3)
					return "AVANTAGE " + player1.getName();
				// Avantage to player2
				if (player1.getGameScore() == 3 && player2.getGameScore() == 4)
					return "AVANTAGE " + player2.getName();
				// Point + Avantage Player1
				if (player1.getGameScore() == 5 && player2.getGameScore() == 3) {
					winGame(player1);
					return "_________________" + player1.getName() + " won the game" + "_________________ \n\n\n";
				}
				// Point + Avantage Player2
				if (player1.getGameScore() == 3 && player2.getGameScore() == 5) {
					winGame(player2);
					return "_________________" + player2.getName() + " won the game" + "_________________ \n\n\n";
				}
			} else {
				if (player1.getGameScore() == 4) {
					winGame(player1);
					return "_________________" + player1.getName() + " won the game" + "_________________ \n\n\n";
				}
				if (player2.getGameScore() == 4) {
					winGame(player2);
					return "_________________" + player2.getName() + " won the game" + "_________________ \n\n\n";
				}
			}
			return player1.getRealScore() + " - " + player2.getRealScore();
		}

		public void updateScoreAfterDeuce() {
			player1.setGameScore(3);
			player2.setGameScore(3);
		}

}
