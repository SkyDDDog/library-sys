package com.lear.recommendation;

public class Ticker extends Thread {
	private final int retrainMinutes;
	protected Ticker(final int retrainMinutes){
		this.retrainMinutes = retrainMinutes;
	}
}
