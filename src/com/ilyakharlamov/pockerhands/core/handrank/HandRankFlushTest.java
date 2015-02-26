package com.ilyakharlamov.pockerhands.core.handrank;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ilyakharlamov.pockerhands.core.Hand;

public class HandRankFlushTest {

	@Test
	public void testIsApplicable() {
		assertTrue(HandRank.fromHand(new Hand("2D5D7D9D0D")) instanceof HandRankFlush);
	}

}
