package com.dius.tennis;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GameTest {

	private static final String PLAYER1 = "Roger Federer";
	private static final String PLAYER2 = "Andy Murray";

	@Test
	public void gameTest() {
		
		Game game = new Game(PLAYER1, PLAYER2);

		game.pointWonBy(PLAYER1);
		game.pointWonBy(PLAYER2);
		
		assertEquals("15-15", game.getScore());

		game.pointWonBy(PLAYER1);
		game.pointWonBy(PLAYER1);
		
		assertEquals("40-15", game.getScore());

		game.pointWonBy(PLAYER2);
		game.pointWonBy(PLAYER2);
		
		assertEquals("Deuce", game.getScore());

		game.pointWonBy(PLAYER1);
		
		assertEquals("Advantage " + PLAYER1, game.getScore());

		game.pointWonBy(PLAYER1);
		
		assertEquals(PLAYER1 + " wins", game.getScore());
	}

	@Test
	public void directWin() {

		Game game = new Game(PLAYER1, PLAYER2);

		game.pointWonBy(PLAYER1);
		assertEquals("15-0", game.getScore());

		game.pointWonBy(PLAYER2);
		assertEquals("15-15", game.getScore());

		game.pointWonBy(PLAYER1);
		assertEquals("30-15", game.getScore());

		game.pointWonBy(PLAYER1);
		assertEquals("40-15", game.getScore());

		game.pointWonBy(PLAYER1);
		assertEquals(PLAYER1 + " wins", game.getScore());
	}

	@Test
	public void tackleAdvantage() {

		Game game = new Game(PLAYER1, PLAYER2);

		game.pointWonBy(PLAYER1);
		game.pointWonBy(PLAYER2);
		assertEquals("15-15", game.getScore());

		game.pointWonBy(PLAYER1);
		game.pointWonBy(PLAYER2);
		assertEquals("30-30", game.getScore());

		game.pointWonBy(PLAYER1);
		game.pointWonBy(PLAYER2);
		assertEquals("Deuce", game.getScore());

		game.pointWonBy(PLAYER1);
		assertEquals("Advantage " + PLAYER1, game.getScore());

		game.pointWonBy(PLAYER2);
		assertEquals("Deuce", game.getScore());

		game.pointWonBy(PLAYER2);
		assertEquals("Advantage " + PLAYER2, game.getScore());

		game.pointWonBy(PLAYER1);
		assertEquals("Deuce", game.getScore());

		game.pointWonBy(PLAYER1);
		assertEquals("Advantage " + PLAYER1, game.getScore());

		game.pointWonBy(PLAYER1);
		assertEquals(PLAYER1 + " wins", game.getScore());
	}
}