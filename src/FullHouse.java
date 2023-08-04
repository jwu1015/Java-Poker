public class FullHouse extends Score{
    @Override
    public int calculateScore(Poker game, Hand playerHand) {
        Hand temp =mergedHandCommunityCards(game,playerHand);
        int count=0;
        int tempInt=0;
        for(int i=0;i<temp.getCardCount();i++)
        {
            if(count==2){
                tempInt=temp.getCard(i-1).getValue();
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
        for(int i=0;i<temp.getCardCount();i++)
        {
            if(count==3){
                break;
            }
            for(int k=i+1;k<temp.getCardCount();k++)
            {
                if(temp.getCard(i).getValue()!=tempInt&&temp.getCard(i).getValue()==temp.getCard(k).getValue())
                {
                    count++;
                }
            }
        }
        if(count==3){
            return 6;
        }else{
            return 0;
        }
    }
}
