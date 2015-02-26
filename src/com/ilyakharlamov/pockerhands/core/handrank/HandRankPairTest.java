package com.ilyakharlamov.pockerhands.core.handrank;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ilyakharlamov.pockerhands.core.Hand;

public class HandRankPairTest {

	@Test
	public void test() {
		assertTrue(HandRank.fromHand(new Hand("2H2D8D0DJH")) instanceof HandRankPair);
		assertFalse(HandRank.fromHand(new Hand("2H3D8D0DJH")) instanceof HandRankPair);
	}
	@Test
	public void testDeepPair() {
		HandRank low = HandRank.fromHand(new Hand("3H3D8D0DJH"));
		HandRank high = HandRank.fromHand(new Hand("AHAD8D0DJH"));
		assertEquals( new Integer(2).compareTo(5),low.compareTo(high));
	}
	@Test
	public void testDeepRemaining() {
		HandRank low = HandRank.fromHand(new Hand("3H3D8D0DJH"));
		HandRank high = HandRank.fromHand(new Hand("3S3D8DADJH"));
		assertEquals( new Integer(2).compareTo(5),low.compareTo(high));
	}

}
