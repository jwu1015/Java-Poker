public class OnePair extends Score{
    @Override
    public int calculateScore(Poker game, Hand playerHand) {
        int[] ScoreAndHighCard = new int[2];
        int HighCard=0;
        Hand temp = mergedHandCommunityCards(game,playerHand);
        int count=0;
        for(int i=0;i<temp.getCardCount();i++)
        {
            for(int k=i+1;k<temp.getCardCount();k++)
            {
                if(temp.getCard(i).getValue()==temp.getCard(k).getValue())
                {
                    count++;
                    HighCard=temp.getCard(i).getValue();
                }
            }
        }
        if(count==1){
            return 1;
        } else{
            return 0;
        }

    }
}
