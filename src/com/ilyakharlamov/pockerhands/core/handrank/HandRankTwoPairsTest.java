package com.ilyakharlamov.pockerhands.core.handrank;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ilyakharlamov.pockerhands.core.Hand;

public class HandRankTwoPairsTest {

	@Test
	public void test() {
		assertTrue(HandRank.fromHand(new Hand("2C2D3H5C5D")) instanceof HandRankTwoPairs);
	}
	@Test
	public void testDeep1() {
		HandRank low = HandRank.fromHand(new Hand("2C2D3H5C5D"));
		HandRank high = HandRank.fromHand(new Hand("ACAD3H5C5D"));
		assertEquals( new Integer(2).compareTo(5),low.compareTo(high));
	}
	@Test
	public void testDeep2() {
		HandRank low = HandRank.fromHand(new Hand("2C2D3H5C5D"));
		HandRank high = HandRank.fromHand(new Hand("2H2CAS5H5C"));
		assertEquals( new Integer(2).compareTo(5),low.compareTo(high));
	}

}
