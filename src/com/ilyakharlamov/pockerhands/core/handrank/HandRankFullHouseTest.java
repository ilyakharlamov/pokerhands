package com.ilyakharlamov.pockerhands.core.handrank;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ilyakharlamov.pockerhands.core.Hand;

public class HandRankFullHouseTest {

	@Test
	public void testIsApplicable() {
		assertTrue(HandRank.fromHand(new Hand("2C2D2HASAD")) instanceof HandRankFullHouse);
		assertFalse(HandRank.fromHand(new Hand("2C2D2HASKS")) instanceof HandRankFourOfAKind);
	}

}
