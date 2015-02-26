package com.ilyakharlamov.pockerhands.core.handrank;

import java.util.Map;
import java.util.Set;

import com.ilyakharlamov.pockerhands.core.Card;
import com.ilyakharlamov.pockerhands.core.Hand;

public class HandRankFourOfAKind extends HandRank {
	public String toString () {
		return hand+"{Four of a kind}";
	}
	public HandRankFourOfAKind(Hand hand) {
		super(hand, 7);
	}
	@Override
	public int compareTo(HandRank handrank) {
		int shallow = super.compareTo(handrank);
		if (shallow!=0) return shallow;
		Card[] mycards = hand.getCards();
		Map<Card.Rank, Set<Card>> mygroupByRank=HandRank.groupByRank(mycards);
		Set<Card> mylargestGroup=HandRank.largestGroup(mygroupByRank);
		Card[] remotecards=handrank.hand.getCards();
		Map<Card.Rank, Set<Card>> remotegroupByRank=HandRank.groupByRank(remotecards);
		Set<Card> remotelargestGroup=HandRank.largestGroup(remotegroupByRank);
		return mylargestGroup.iterator().next().compareTo(remotelargestGroup.iterator().next());
	}
	
	static boolean isApplicable (Hand hand) {
		if (hand.isEmpty()) return false;
		Card[] cards=hand.getCards();
		if (cards.length < 5) return false;
		Map<Card.Rank, Set<Card>> groupByRank=HandRank.groupByRank(cards);
		Set<Card> largestGroup=HandRank.largestGroup(groupByRank);
		if (largestGroup.size()<4) return false;
		return true;
	}

}
