public class Straight extends Score{
    @Override
    public int calculateScore(Poker game, Hand playerHand) {
        Hand temp =mergedHandCommunityCards(game,playerHand);
        temp.sortByValue();
        for(int i=0;i<temp.getCardCount()-1;i++){
            if(temp.getCard(i).getValue()==temp.getCard(i+1).getValue()){
                temp.removeCard(i);
            }
        }
        int count=0;
        for(int i=0;i<temp.getCardCount()-1;i++){
            if (temp.getCard(i).getValue()+(i+1)==temp.getCard(i+1).getValue()){
                count++;
            }
        }
        if(count>=4||(temp.containsCard(10)&&temp.containsCard(11)&&temp.containsCard(12)&&temp.containsCard(13)&&temp.containsCard(1))){
            return 4;
        } else{
            return 0;
        }
    }
}
