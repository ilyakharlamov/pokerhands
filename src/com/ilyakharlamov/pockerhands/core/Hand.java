package com.ilyakharlamov.pockerhands.core;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	private static final int SIZE=5;
	private final List<Card> cards;

    public Hand() {
        cards = new ArrayList<Card>(SIZE);
    }
    public Hand(String str) {
    	cards = new ArrayList<Card>();
    	if (str==null||str.length()%2==1) throw new IllegalArgumentException("Length of string should be even");
    	for (int i=0; i+1<str.length();i+=2){
    		this.addCard(Card.fromString(str.substring(i,i+2)));
    	}
    }
    public void addCard(Card card) {
        cards.add(card);
    }

    public Card[] getCards() {
        return cards.toArray(new Card[cards.size()]);
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : cards) {
            sb.append(card.toString());
        }
        return sb.toString();
    }
    public boolean isEmpty() {
    	return cards.size()==0;
    }

}
