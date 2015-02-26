package com.ilyakharlamov.pockerhands.core.handrank;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ilyakharlamov.pockerhands.core.Hand;

public class HandRankStraightTest {

	@Test
	public void testIsApplicable() {
		assertEquals(HandRank.fromHand(new Hand("2D3H4H5D6D")).getClass(),HandRankStraight.class);
		assertTrue(HandRank.fromHand(new Hand("2D3H4H5D6D")) instanceof HandRankStraight);
	}

}
