package com.ilyakharlamov.pockerhands.core.handrank;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ilyakharlamov.pockerhands.core.Hand;

public class HandRankStraightFlushTest {

	@Test
	public void test() {
		assertTrue(HandRank.fromHand(new Hand("2D3D4D5D6D")) instanceof HandRankStraightFlush);
		assertTrue(HandRank.fromHand(new Hand("3D4D5D6D7D")) instanceof HandRankStraightFlush);
		assertFalse(HandRank.fromHand(new Hand("2D3D6D7D8D")) instanceof HandRankStraightFlush);
		assertFalse(HandRank.fromHand(new Hand("2D3D4D5D")) instanceof HandRankStraightFlush);
		assertFalse(HandRank.fromHand(new Hand("2D")) instanceof HandRankStraightFlush);
	}
	@Test
	public void testDeep() {
		assertEquals(new Integer(2).compareTo(3), HandRank.fromHand(new Hand("2D3D4D5D6D")).compareTo(HandRank.fromHand(new Hand("3D4D5D6D7D"))));
	}

}
