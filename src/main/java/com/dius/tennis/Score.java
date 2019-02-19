package com.dius.tennis;

public enum Score {

	ZERO("0"), 
	FIFTEEN("15"), 
	THIRTY("30"), 
	FORTY("40");

	private Score(String text) {
		this.text = text;
	}

	private String text;

	@Override
	public String toString() {
		return text;
	}

	
	public Score addPoint() {

		if (isMax()) {

			return this;
		} else {

			return values()[ordinal() + 1];
		}
	}

	
	public boolean isMax() {

		return ordinal() == values().length - 1;
	}

	
	public int getPointDifference(Score score) {

		return Math.abs(this.ordinal() - score.ordinal());
	}
}