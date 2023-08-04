public abstract class Score {
    public Hand mergedHandCommunityCards(Poker game, Hand playerHand){
        Hand temp = new Hand();
        temp.addCard(playerHand.getCard(0));
        temp.addCard(playerHand.getCard(1));
        for(int i=0;i<5;i++){
            temp.addCard(game.getCommunityCards()[i]);
        }
        return temp;
    }
    public abstract int calculateScore(Poker game, Hand playerHand);

}
