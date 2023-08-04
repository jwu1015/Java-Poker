public class TwoPair extends Score{
    @Override
    public int calculateScore(Poker game, Hand playerHand) {
        Hand temp = mergedHandCommunityCards(game,playerHand);
        int count=0;
        for(int i=0;i<temp.getCardCount();i++)
        {
            for(int k=i+1;k<temp.getCardCount();k++)
            {
                if(temp.getCard(i).getValue()==temp.getCard(k).getValue())
                {
                    count++;
                }
            }
        }
        if(count==2){
            return 2;
        } else{
            return 0;
        }
    }
}
