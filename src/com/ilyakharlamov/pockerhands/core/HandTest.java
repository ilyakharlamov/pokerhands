package com.ilyakharlamov.pockerhands.core;

import static org.junit.Assert.*;

import org.junit.Test;

public class HandTest {

	@Test
	public void testIfHandWorks() {
		Hand hand = new Hand();
		assertEquals("empty hand", hand.getCards().size(), 0);
		hand.addCard(new Card(Card.Rank.TWO,Card.Suit.CLUBS));
		assertEquals("hand add one", hand.getCards().size(), 1);
	}

}
