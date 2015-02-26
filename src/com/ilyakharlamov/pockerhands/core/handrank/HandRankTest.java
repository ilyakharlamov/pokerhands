package com.ilyakharlamov.pockerhands.core.handrank;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.ilyakharlamov.pockerhands.core.Card;
import com.ilyakharlamov.pockerhands.core.Hand;

public class HandRankTest {
	@Test
	public void testEqualsRankOrder() {
		Hand hand = new Hand();
		hand.addCard(new Card(Card.Rank.TWO, Card.Suit.CLUBS));
		hand.addCard(new Card(Card.Rank.THREE, Card.Suit.CLUBS));
		HandRank handrank = HandRank.fromHand(hand);
		assertTrue("default abstract type is high", handrank instanceof HandRankHigh);
	}
	@Test
	public void testCompareRankOrders() {
		HandRank high = new HandRankHigh(new Hand("2D"));
		HandRank straight = new HandRankStraightFlush(new Hand("2D3D4D5D6D"));
		assertTrue("straight is better than high", straight.compareTo(high) == 1);
		assertTrue("high is worse than straight", high.compareTo(straight) == -1);
		assertEquals("they behave like integers",new Integer(8).compareTo(0), straight.compareTo(high));
	}
	@Test
	public void testSortCards(){
		Card[] cards1 = new Hand("2D3D").getCards();
		Arrays.sort(cards1);
		Card[] cards2 = new Hand("3D2D").getCards();
		Arrays.sort(cards2);
		assertEquals(cards1[0],cards1[0]);
	}
	@Test
	public void testGroupByRank(){
		Card[] cards = new Hand("2D2S2H3D3S").getCards();
		Map<Card.Rank, Set<Card>> groupByRank = HandRank.groupByRank(cards);
		assertEquals(3, groupByRank.get(Card.Rank.TWO).size());
		
	}
	

}
