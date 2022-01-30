package com.example.welcometo2

import kotlin.random.Random


/**
 * Deck class
 * @property cards Mutable List of Card
 * @constructor Populates Cards with all 52 cards in a regular deck
 */


class Deck(gameseed:Int) {

    var  cards:   MutableList<Card> = mutableListOf()
    var  posInDeck : Int  = 0


    init {

        cards.add(Card(1	,1))
        cards.add(Card(6	,1))
        cards.add(Card(9	,1))
        cards.add(Card(5	,1))
        cards.add(Card(8	,1))
        cards.add(Card(5	,1))
        cards.add(Card(8	,1))
        cards.add(Card(3	,1))
        cards.add(Card(7	,1))
        cards.add(Card(6	,1))
        cards.add(Card(2	,1))
        cards.add(Card(13,1))
        cards.add(Card(11,1))
        cards.add(Card(11,1))
        cards.add(Card(10,1))
        cards.add(Card(15,1))
        cards.add(Card(14,1))
        cards.add(Card(10,1))
        cards.add(Card(4	,2))
        cards.add(Card(2	,2))
        cards.add(Card(1	,2))
        cards.add(Card(7	,2))
        cards.add(Card(10,2))
        cards.add(Card(7	,2))
        cards.add(Card(9	,2))
        cards.add(Card(6	,2))
        cards.add(Card(9	,2))
        cards.add(Card(5	,2))
        cards.add(Card(8	,2))
        cards.add(Card(8	,2))
        cards.add(Card(5	,2))
        cards.add(Card(15,2))
        cards.add(Card(14,2))
        cards.add(Card(11,2))
        cards.add(Card(12,2))
        cards.add(Card(11,2))
        cards.add(Card(2	,6))
        cards.add(Card(1	,6))
        cards.add(Card(5	,6))
        cards.add(Card(5	,6))
        cards.add(Card(4	,6))
        cards.add(Card(8	,6))
        cards.add(Card(11,6))
        cards.add(Card(8	,6))
        cards.add(Card(11,6))
        cards.add(Card(7	,6))
        cards.add(Card(10,6))
        cards.add(Card(7	,6))
        cards.add(Card(9	,6))
        cards.add(Card(9	,6))
        cards.add(Card(6	,6))
        cards.add(Card(15,6))
        cards.add(Card(14,6))
        cards.add(Card(12,6))
        cards.add(Card(4	,5))
        cards.add(Card(10,5))
        cards.add(Card(3	,5))
        cards.add(Card(9	,5))
        cards.add(Card(8	,5))
        cards.add(Card(7	,5))
        cards.add(Card(6	,5))
        cards.add(Card(13,5))
        cards.add(Card(12,5))
        cards.add(Card(6	,4))
        cards.add(Card(12,4))
        cards.add(Card(4	,4))
        cards.add(Card(10,4))
        cards.add(Card(3	,4))
        cards.add(Card(9	,4))
        cards.add(Card(8	,4))
        cards.add(Card(7	,4))
        cards.add(Card(7	,3))
        cards.add(Card(13,3))
        cards.add(Card(6	,3))
        cards.add(Card(12,3))
        cards.add(Card(4	,3))
        cards.add(Card(10,3))
        cards.add(Card(3	,3))
        cards.add(Card(9	,3))
        cards.add(Card(8	,3))
        cards.add(Card(13,4))

        cards.shuffle(Random(gameseed))

    }

    /**
     * Shuffles the cards list
     */
    fun shuffle(gameseed: Int) {

        cards.shuffle(Random(gameseed))
        posInDeck = 0
    }
    fun shuffle() {
        cards.shuffle()
        posInDeck = 0
    }

    /**
     * Removes the first card form the cards list
     * @return Card if deck is not empty
     * @note use with ?. as the return type is nullable
     */
    fun draw() {
        if (posInDeck<cards.size-6) { posInDeck = posInDeck + 3}
    }

    fun back(){
        if (posInDeck>=3) { posInDeck = posInDeck - 3}
    }

    fun numberAt(i:Int): Int {
        return cards.elementAt(i+posInDeck).number
    }

    fun actionAt(i:Int): Int {
        return cards.elementAt(i+posInDeck).action
    }
    /**
     *@return Size of the deck
     */
    fun getSize(): Int = cards.size - posInDeck-3


}

