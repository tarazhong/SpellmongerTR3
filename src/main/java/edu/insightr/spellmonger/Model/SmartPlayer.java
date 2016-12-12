package edu.insightr.spellmonger.Model;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by sibel on 10/10/2016.
 * Define the Levels of the IA for the application
 */
class SmartPlayer extends Player {

    private final int level;
    private final ArrayList<PlayCard> cardToPlay;
    private int round;

    /**
     * @param level of the game
     */
    SmartPlayer(String name, int lifePoints, int level) {
        super(name, lifePoints);
        this.level = level;
        this.cardToPlay = new ArrayList<>();
        this.round = 1;
    }

    SmartPlayer(String name, int lifePoints) {
        super(name, lifePoints);
        this.cardToPlay = new ArrayList<>();
        this.level = 1;
        this.round = 1;
    }

    /**
     * @return a random number that will be the position of the card in the hand of a player
     */
    int level0() {
        if (this.cardsInHand.isEmpty())
            return 0;

        int size = this.cardsInHand.size();
        return new Random().nextInt(size);
    }

    /**
     * @return the number of the card the player'll play in function of the value of his deck
     */
    int level1() {
        if (this.round != 1) {
            this.cardToPlay.clear();
        }

        ++round;
        if (!this.cardsInHand.isEmpty()) {
            int avg = getDeckPower() / this.cardsInHand.size();  //avg of the game is 2.1

            if (avg > 2.3) {
                getStrongCardList();

            } else if (avg < 1.9) {
                getAverageCardList();
            } else {
                getBadCardList();
            }
        }
        return chooseCard();

    }

    /**
     * @return the Destruction power of a deck
     */
    private int getDeckPower() {
        int count = 0;

        for (PlayCard e : this.cardsInHand) {
            count += e.getCardValue();
        }

        return count;
    }

    /**
     * @return the number of the card to choose
     */
    private int chooseCard() {
        if (this.cardToPlay.isEmpty())
            return 0;

        int size = this.cardToPlay.size();
        return new Random().nextInt(size);
    }

    /**
     * The list the player can play is with his strongest cards
     */
    void getStrongCardList() {


        this.cardToPlay.addAll(this.cardsInHand.stream().filter(card -> card.getCardValue() >= 2).collect(Collectors.toList()));
    }


    /**
     * The list the player can play is with his average cards
     */
    void getAverageCardList() {


        this.cardToPlay.addAll(this.cardsInHand.stream().filter(card -> card.getCardValue() == 2).collect(Collectors.toList()));

        if (this.cardToPlay.isEmpty()) {
            getStrongCardList();
        }

    }

    /**
     * The list the player can play is with his lowest cards
     */
    void getBadCardList() {
        this.cardToPlay.addAll(this.cardsInHand.stream().filter(card -> card.getCardValue() <= 2).collect(Collectors.toList()));
    }

    /**
     * Override the play of a card from PlayCard, with the IA
     *
     * @param game the app
     */
    @Deprecated
    public PlayCard playACard() {
        int playCardNumber;

        switch (level) {
            case 0:
                playCardNumber = level0();
                break;
            case 1:
                playCardNumber = level1();
                break;
            default:
                playCardNumber = level1();
                break;
        }

        // if (this.cardsInHand.isEmpty())

        PlayCard card = this.cardsInHand.get(playCardNumber);
        this.cardsInHand.remove(playCardNumber);
        return card;
    }
}
