package com.ilyakharlamov.pockerhands.core.handrank;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.ilyakharlamov.pockerhands.core.Card;
import com.ilyakharlamov.pockerhands.core.Hand;

public class HandRankPair extends HandRank {
	public String toString () {
		return hand+"{Pair}";
	}
	public HandRankPair(Hand hand) {
		super(hand, 1);
	}
	@Override
	public int compareTo(HandRank handrank) {
		int shallow = super.compareTo(handrank);
		if (shallow!=0) return shallow;
		//my
		Card[] mycards = hand.getCards();
		final Map<Card.Rank, Set<Card>> groupByRank=HandRank.groupByRank(mycards);
		final Set<Card> mypair=HandRank.largestGroup(groupByRank);
		//remote
		Card[] remotecards = handrank.hand.getCards();
		final Map<Card.Rank, Set<Card>> remoteGroupByRank=HandRank.groupByRank(remotecards);
		final Set<Card> remotepair=HandRank.largestGroup(remoteGroupByRank);
		//compare pair
		
		int comparepairs=mypair.iterator().next().compareTo(remotepair.iterator().next());
		if(comparepairs!=0) return comparepairs;
		//compare remaining
		TreeSet<Card> myremaining = new TreeSet<Card>(Arrays.asList(mycards));
		myremaining.removeAll(mypair);
		TreeSet<Card> remoteremaining = new TreeSet<Card>(Arrays.asList(remotecards));
		remoteremaining.removeAll(remotepair);
		return myremaining.last().compareTo(remoteremaining.last());
	}

	static boolean isApplicable (Hand hand) {
		if (hand.isEmpty()) return false;
		Card[] cards=hand.getCards();
		if (cards.length < 5) return false;
		Map<Card.Rank, Set<Card>> groupByRank=HandRank.groupByRank(cards);
		Set<Card> pair=HandRank.largestGroup(groupByRank);
		if(pair.size()<2) return false;
		return true;
	}
}
