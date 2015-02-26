package com.ilyakharlamov.pockerhands.core.handrank;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.ilyakharlamov.pockerhands.core.Card;
import com.ilyakharlamov.pockerhands.core.Hand;
public abstract class HandRank implements Comparable<HandRank> {
	public final Hand hand;
	public final int level;
	public HandRank(Hand hand, int level) {
		if (hand==null) throw new IllegalArgumentException("Hand must not be null");
		this.hand=hand;
		this.level=level;
	}
	public static HandRank fromHand(Hand hand) {
		if (HandRankStraightFlush.isApplicable(hand)) return new HandRankStraightFlush(hand);
		if (HandRankFourOfAKind.isApplicable(hand)) return new HandRankFourOfAKind(hand);
		if (HandRankFullHouse.isApplicable(hand)) return new HandRankFullHouse(hand);
		if (HandRankFlush.isApplicable(hand)) return new HandRankFlush(hand);
		if (HandRankStraight.isApplicable(hand)) return new HandRankStraight(hand);
		if (HandRankThreeOfAKind.isApplicable(hand)) return new HandRankThreeOfAKind(hand);
		if (HandRankTwoPairs.isApplicable(hand)) return new HandRankTwoPairs(hand);
		if (HandRankPair.isApplicable(hand)) return new HandRankPair(hand);
		return new HandRankHigh(hand);
	}
	
	public static Map<Card.Rank, Set<Card>> groupByRank(Card[] cards) {
		Map<Card.Rank, Set<Card>> groupByRank = new HashMap<Card.Rank, Set<Card>>();
		for(Card card: cards) {
			Set<Card> set = groupByRank.get(card.getRank());
			if (set==null) set= new HashSet<Card>();
			set.add(card);
			groupByRank.put(card.getRank(), set);
		}
		return groupByRank;
	}
	public static Set<Card> largestGroup(Map<Card.Rank, Set<Card>> map) {
		Set<Card> largestGroup=new HashSet<Card>();
		for(Set<Card> set: map.values()){
			if(largestGroup.size()<set.size()) largestGroup=set;
		}
		return largestGroup;
	}
	@Override
	public int compareTo(HandRank handrank) {
		//shallow comparison
		return new Integer(this.level).compareTo(handrank.level);
	}
	
	public Hand getHand() {
		return hand;
	}
	
    static boolean isApplicable (Hand hand) {
		return false;
    }
}