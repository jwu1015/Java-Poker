public class StraightFlush extends Score{
    Straight findStraight = new Straight();
    Flush findFlush = new Flush();
    @Override
    public int calculateScore(Poker game, Hand playerHand) {
        if(findStraight.calculateScore(game, playerHand)==5&&findFlush.calculateScore(game, playerHand)==6){
            return 8;
        } else{
            return 0;
        }
    }
}
