package com.ilyakharlamov.pockerhands.core;

import static org.junit.Assert.*;

import org.junit.Test;

public class HandTest {

	@Test
	public void testIfHandWorks() {
		Hand hand = new Hand();
		assertTrue("empty hand", hand.isEmpty());
		assertTrue("get is empty", hand.getCards().length==0);
		hand.addCard(new Card(Card.Rank.TWO,Card.Suit.CLUBS));
		assertTrue("hand add one", hand.getCards()[0]!=null);
	}
	@Test
	public void testHandFromStr() {
		Hand hand = new Hand("2D3S");
		assertEquals(2,hand.getCards().length);
	}

}
