package com.ilyakharlamov.pockerhands.core.handrank;

import java.util.Arrays;

import com.ilyakharlamov.pockerhands.core.Card;
import com.ilyakharlamov.pockerhands.core.Hand;

public class HandRankStraight extends HandRank {
	public String toString () {
		return hand+"{Straight}";
	}
	public HandRankStraight(Hand hand) {
		super(hand, 4);
	}
	
	@Override
	public int compareTo(HandRank handrank) {
		int shallow = super.compareTo(handrank);
		if (shallow!=0) return shallow;
		Card[] mycards = hand.getCards();
		Arrays.sort(mycards);
		Card[] remotecards=handrank.hand.getCards();
		Arrays.sort(remotecards);
		return mycards[mycards.length-1].compareTo(remotecards[remotecards.length-1]);
	}
	
	static boolean isApplicable (Hand hand) {
		if (hand.isEmpty()) return false;
		Card[] cards = hand.getCards();
		if (cards.length!=5) return false;
		Arrays.sort(cards);
		Card.Rank prevrank = cards[0].getRank();
		for(int i=1;i<cards.length;i++) {
			Card card = cards[i];
			if (prevrank.ordinal()+1!=card.getRank().ordinal()) return false;
			prevrank = card.getRank();
		}
	    return true;
	}

}
