package com.ilyakharlamov.pockerhands.core;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardTest {
	@Test
	public void compareSameCard() {
		Card _5dv1 = new Card(Card.Rank.FIVE, Card.Suit.DIAMONDS);
		Card _5dv2 = new Card(Card.Rank.FIVE, Card.Suit.DIAMONDS);
		assertFalse("ref is different", _5dv1==_5dv2);
		assertFalse("comparison the same", _5dv1.equals(_5dv2));
	}
	@Test
	public void compareSameSuit() {
		Card _2d = new Card(Card.Rank.TWO, Card.Suit.DIAMONDS);
		Card _5d = new Card(Card.Rank.FIVE, Card.Suit.DIAMONDS);
		assertEquals("same suit", new Integer(2).compareTo(new Integer(5)), _2d.compareTo(_5d));
	}
	@Test
	public void compareDifferenSuit() {
		Card _5d = new Card(Card.Rank.FIVE, Card.Suit.DIAMONDS);
		Card _5s = new Card(Card.Rank.FIVE, Card.Suit.SPADES);
		assertEquals("diff suit same rank", new Integer(5).compareTo(new Integer(5)), _5d.compareTo(_5s));
	}

}
