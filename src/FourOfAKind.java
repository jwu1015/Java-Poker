public class FourOfAKind extends Score{
    @Override
    public int calculateScore(Poker game, Hand playerHand) {
        Hand temp = mergedHandCommunityCards(game,playerHand);
        int count=0;
        for(int i=0;i<temp.getCardCount();i++)
        {
            if(count>=3){
                break;
            }
            count=0;
            for(int k=0;k<temp.getCardCount();k++)
            {
                if(temp.getCard(i).getValue()==temp.getCard(k).getValue())
                {
                    count++;
                }
            }
        }
        if(count>=3){
            return 7;
        } else{
            return 0;
        }
    }
}
