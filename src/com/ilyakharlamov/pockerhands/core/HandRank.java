package com.ilyakharlamov.pockerhands.core;

public class HandRank implements Comparable<HandRank>{
    private Rank rank = Rank.HIGH; // lowest by default
	private final Hand hand;
    public HandRank(Hand hand) {
    	this.hand=hand;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public enum Rank {
        HIGH, PAIR, TWOPAIR, THREEOFAKIND, STRAIGHT, FLUSH, FULLHOUSE, FOUROFAKIND, STRAIGHTFLUSH
    }


	@Override
	public int compareTo(HandRank handRank) {
		int compare = getRank().compareTo(handRank.getRank());
        if (compare != 0) {
            return compare;
        }
        List<Card> myHand = getHand();
        List<Card> theirHand = handRank.getHand();
        for (int i = 0; i < 5; i++) {
            if (myHand.size() > i) {
                compare = myHand.get(i).compareTo(theirHand.get(i));
                if (compare != 0) return compare;
            }
        }
        return 0;
	}
	private HandRank getRank() {
		// TODO Auto-generated method stub
		return rank;
	}

}
