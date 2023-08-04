public class Flush extends Score{
    @Override
    public int calculateScore(Poker game, Hand playerHand) {
        Hand temp = mergedHandCommunityCards(game,playerHand);
        int count=0;
        for(int i=0;i<temp.getCardCount();i++){
            for(int k=i+1;k<temp.getCardCount();k++)
            {
                if(temp.getCard(i).getSuit()==temp.getCard(k).getSuit())
                {
                    count++;
                }
            }
        }
        if(count>=5){
            return 5;
        } else{
            return 0;
        }
    }
}
