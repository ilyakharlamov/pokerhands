package com.ilyakharlamov.pockerhands.core.handrank;

import java.util.Map;
import java.util.Set;

import com.ilyakharlamov.pockerhands.core.Card;
import com.ilyakharlamov.pockerhands.core.Hand;

public class HandRankTwoPairs extends HandRank {

	public String toString () {
		return hand+"{Two Pairs}";
	}
	public HandRankTwoPairs(Hand hand) {
		super(hand, 2);
	}
	@Override
	public int compareTo(HandRank handrank) {
		int shallow = super.compareTo(handrank);
		if (shallow!=0) return shallow;
		//my
		Card[] mycards = hand.getCards();
		final Map<Card.Rank, Set<Card>> groupByRank=HandRank.groupByRank(mycards);
		final Set<Card> mypair1=HandRank.largestGroup(groupByRank);
		groupByRank.remove(mypair1.iterator().next().getRank());
		final Set<Card> mypair2=HandRank.largestGroup(groupByRank);
		groupByRank.remove(mypair2.iterator().next().getRank());
		final int myPairOrd=Math.max(mypair1.iterator().next().getRank().ordinal(),mypair2.iterator().next().getRank().ordinal());
		//remote
		Card[] remotecards=handrank.hand.getCards();
		Map<Card.Rank, Set<Card>> remoteGroupByRank=HandRank.groupByRank(remotecards);
		Set<Card> remotepair1=HandRank.largestGroup(remoteGroupByRank);
		remoteGroupByRank.remove(remotepair1.iterator().next().getRank());
		Set<Card> remotepair2=HandRank.largestGroup(remoteGroupByRank);
		remoteGroupByRank.remove(remotepair2.iterator().next().getRank());
		final int remotePairOrd=Math.max(remotepair1.iterator().next().getRank().ordinal(),remotepair2.iterator().next().getRank().ordinal());
		if(myPairOrd!=remotePairOrd) return new Integer(myPairOrd).compareTo(remotePairOrd);
		return Integer.signum(groupByRank.keySet().iterator().next().compareTo(remoteGroupByRank.keySet().iterator().next()));
	}
	static boolean isApplicable (Hand hand) {
		if (hand.isEmpty()) return false;
		Card[] cards=hand.getCards();
		if (cards.length < 5) return false;
		Map<Card.Rank, Set<Card>> groupByRank=HandRank.groupByRank(cards);
		Set<Card> largestGroup1=HandRank.largestGroup(groupByRank);
		if(largestGroup1.size()<2) return false;
		groupByRank.remove(largestGroup1.iterator().next().getRank());//to find the second pair
		Set<Card> largestGroup2=HandRank.largestGroup(groupByRank);
		if(largestGroup2.size()<2) return false;
		return true;
	}

}
