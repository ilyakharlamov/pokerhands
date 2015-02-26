package com.ilyakharlamov.pockerhands.core.handrank;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.ilyakharlamov.pockerhands.core.Card;
import com.ilyakharlamov.pockerhands.core.Hand;

public class HandRankFullHouse extends HandRank{
	public String toString () {
		return hand+"{Full House}";
	}
	public HandRankFullHouse(Hand hand) {
		super(hand, 6);
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
		if (largestGroup.size()<3) return false;
		Set<Card> remaining = new HashSet<Card>(Arrays.asList(cards));
		remaining.removeAll(largestGroup);
		Iterator<Card> iter = remaining.iterator();
		if(!iter.hasNext()) return false;
		Card pair1=iter.next();
		if(!iter.hasNext()) return false;
		Card pair2=iter.next();
		return pair1.getRank().equals(pair2.getRank());
	}
}
