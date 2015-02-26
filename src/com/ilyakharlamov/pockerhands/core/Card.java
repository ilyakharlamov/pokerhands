package com.ilyakharlamov.pockerhands.core;

import java.util.HashMap;
import java.util.Map;

public class Card implements Comparable<Card> {
	private final Rank rank;
    private final Suit suit;
    private static Map<String, Rank> rankMap=null;//for parse
    private static Map<String, Suit> suitMap=null;//for parse
    public Card (Rank rank, Suit suit) {
    	this.rank = rank;
    	this.suit=suit;
    }
    public static Card fromString (String str) {
    	if (str==null||str.length() < 2) throw new IllegalArgumentException("constructor string must be at least 2:"+str+"("+str.length()+")");
    	if (rankMap==null) {
    		rankMap = new HashMap<String, Card.Rank>();
    		for(Rank rank : Rank.values()) {
    			rankMap.put(Rank.labels[rank.ordinal()], rank);
    		}
    	}
    	if (suitMap==null) {
    		suitMap = new HashMap<String, Card.Suit>();
    		for(Suit rank : Suit.values()) {
    			suitMap.put(Suit.labels[rank.ordinal()], rank);
    		}
    	}
    	Rank rank = rankMap.get(str.substring(0,1));
    	if (rank==null) new IllegalArgumentException("Cannot find rank:"+str.substring(0,1)); 
    	Suit suit = suitMap.get(str.substring(1,2));
    	if (suit==null) new IllegalArgumentException("Cannot find suit:"+str.substring(1,2));
		return new Card(rank,suit);
    }
	public enum Suit {
        CLUBS, DIAMONDS, HEARTS, SPADES;
        public static final String[] labels = {"C","D","H","S"};

        public String toString() {
            return labels[this.ordinal()];
        }
    }

	public enum Rank {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;

        private static final String[] labels = {"2", "3", "4", "5", "6", "7", "8", "9", "0", "J", "Q", "K", "A"};

        public String toString() {
            return labels[this.ordinal()];
        }
    }
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Card)) return false;
		Card card = (Card) obj;
		return card.rank.equals(rank) && card.suit.equals(suit);
	}
	@Override
	public int hashCode() {
		return this.rank.ordinal()*this.suit.ordinal();
	}
	public Suit getSuit() {
        return suit;
    }
	public Rank getRank() {
        return rank;
    }
	@Override
	public int compareTo(Card o) {
		return Integer.signum(rank.compareTo(o.getRank()));
	}
	public String toString() {
		return ""+rank+suit;
	}

}
