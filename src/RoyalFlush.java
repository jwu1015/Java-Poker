public class RoyalFlush extends Score{
    private StraightFlush findRoyalFlush = new StraightFlush();
    @Override
    public int calculateScore(Poker game, Hand playerHand) {
        Hand temp = mergedHandCommunityCards(game,playerHand);
        if(findRoyalFlush.calculateScore(game, playerHand)==9&&(temp.containsCard(10)&&temp.containsCard(11)&&temp.containsCard(12)&&temp.containsCard(13)&&temp.containsCard(1))){
            return 9;
        } else{
            return 0;
        }
    }
}
