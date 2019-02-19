package com.dius.tennis;


public class Game {

	private Player player1;
	private Player player2;
	private boolean deuce;

	public Game(String player1, String player2) {
		
		this.player1 = new Player(player1);
		this.player2 = new Player(player2);
	}

	public void pointWonBy(String name) {
		
		Player player = getPlayerByName(name);

		if (player.getScore().isMax()) {

			if (isOnePointToVictory(player)) {
				player.setWinner(true);
			} else {
				manageAdvantage(player);
			}
		} else {
			player.addPoint();
		}
		this.deuce = isDeuce();
	}

	
	public String getScore() {

		if (player1.isWinner()) {
			return player1.getName() + " won";
		}

		if (player2.isWinner()) {
			return player2.getName() + " won";
		}

		if (player1.hasAdvantage()) {
			return "Advantage: " + player1.getName();
		}

		if (player2.hasAdvantage()) {
			return "Advantage: " + player2.getName();
		}

		if (deuce) {
			return "Deuce";
		}
		return player1.getScore() + "--" + player2.getScore();
	}

	private void manageAdvantage(Player player) {
		
		Player opponent = getOpponent(player);
		
		if (opponent.hasAdvantage()) {

			opponent.setAdvantage(false);

		} else {

			player.setAdvantage(true);

		}
	}


	private boolean isOnePointToWin(Player player) {

		int pointDiff = player.getScore().getPointDifference(getOpponent(player).getScore());

		return pointDiff >= 2 || player.hasAdvantage();
	}

	
	private boolean isDeuce() {

		return player1.getScore() == Score.FORTY
				&& player2.getScore() == Score.FORTY;
	}

	private Player getPlayerByName(String name) {
		
		if (name.equalsIgnoreCase(player1.getName())) {
			return player1;
		}

		if (name.equalsIgnoreCase(player2.getName())) {
			return player2;
		}
		throw new IllegalArgumentException("No Known Player: " + name);
	}

	private Player getOpponent(Player player) {
		
		if (player.equals(player1)) {
			return player2;
		}

		if (player.equals(player2)) {
			return player1;
		}

		throw new IllegalArgumentException("No Known Player: " + player);
	}
}