package com.ilyakharlamov.pockerhands.core.handrank;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ilyakharlamov.pockerhands.core.Hand;

public class HandRankFourOfAKindTest {
	@Test
	public void testDeepCompare() {
		assertEquals(new Integer(2).compareTo(3), HandRank.fromHand(new Hand("2C2D2H2S3S")).compareTo(HandRank.fromHand(new Hand("3C3D3H3S4S"))));
	}
	@Test
	public void testIsApplicable() {
		assertTrue(HandRank.fromHand(new Hand("2C2D2H2S3S")) instanceof HandRankFourOfAKind);
		assertFalse(HandRank.fromHand(new Hand("2C2D2H4S3S")) instanceof HandRankFourOfAKind);
	}

}
