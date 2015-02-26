package com.ilyakharlamov.pockerhands.core.handrank;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ilyakharlamov.pockerhands.core.Hand;

public class HandRankThreeOfAKindTest {

	@Test
	public void test() {
		assertTrue(HandRank.fromHand(new Hand("2C2D2HAS3S")) instanceof HandRankThreeOfAKind);
	}

}
