package com.lear.recommendation;

import lombok.Getter;
public class RECResult {
	@Getter
	private final int recRating;
	@Getter
	private final String isbn;
	protected RECResult(final int recRating, final String isbn) {
		this.recRating = recRating;
		this.isbn = isbn;
	}
}
