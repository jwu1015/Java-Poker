public class Poker {
    //instance variables
    private int pot;
    private int currentBet;
    private int minimumBet;
    private Deck gameDeck=new Deck();
    private Card[] communityCards=new Card[5];
    private Player player1=new Player();
    private Player player2=new Player();
    private PokerScoreCard gameScore = new PokerScoreCard();
    private PokerGui gameTable= new PokerGui(this);
    //constructor
    public Poker()
    {
        player1.setPlayerAmount(1000);
        player2.setPlayerAmount(1000);
        minimumBet=20;
    }

    //getters and setters
    public int getCurrentBet()
    {
        return currentBet;
    }
    public void setCurrentBet(int currentBet)
    {
        this.currentBet = currentBet;
    }
    public int getMinimumBet() {
        return minimumBet;
    }
    public Card[] getCommunityCards() {
        return communityCards;
    }
    public Player getPlayer1() {
        return player1;
    }
    public Player getPlayer2() {
        return player2;
    }
    public int getPot() {
        return pot;
    }
    public Deck getGameDeck() {
        return gameDeck;
    }
    public void addToPot(int amount)
    {
        pot=pot+amount;
    }
    public void setPot(int pot){this.pot=pot;}
    //methods

    public void determineMove(int choice, Player player)
    {
        if (choice!=1&&choice!=2&&choice!=3&&choice!=4)
        {
            do
            {
                System.out.println("Please enter a valid option.");
                choice=TextIO.getlnInt();
            }while(choice!=1&&choice!=2&&choice!=3&&choice!=4);
        }
        if(choice==2&&currentBet==0)
        {
            do
            {
                System.out.println("There is no bet to match. Please re-enter a valid option.");
                choice=TextIO.getlnInt();
            }while(choice == 2);
        }
        if(currentBet!=0&&choice==3)
        {
            System.out.println("There is an active bet, please either (1) raise, (2) call, or (4) fold.");
            if(choice==3){
                do{
                    System.out.println("Please re-enter a valid option.");
                    choice=TextIO.getlnInt();
                }while(choice==3);
            }
        }
        switch(choice)
        {
            case 1:
                System.out.print("What amount would you like to raise by?");
                int raiseAmount = TextIO.getInt();
                player.raise(raiseAmount,this);
                if(player.isNotPlaying()){
                    currentBet=0;
                    player.fold(this);
                    player1.getGameHand().removeAllWhenFull();
                    player2.getGameHand().removeAllWhenFull();
                    scorePlayers();
                    break;
                }
                break;
            case 2:
                player.call(this);
                if(player.isNotPlaying()){
                    currentBet=0;
                    player.fold(this);
                    player1.getGameHand().removeAllWhenFull();
                    player2.getGameHand().removeAllWhenFull();
                    scorePlayers();
                    break;
                }
                currentBet=0;
                break;
            case 3:
                player.check(this);
                break;
            case 4:
                currentBet=0;
                player.fold(this);
                player1.getGameHand().removeAllWhenFull();
                player2.getGameHand().removeAllWhenFull();
                scorePlayers();
                break;
        }
    }

    public boolean checkLoss()
    {
        if(player1.getPlayerAmount()<minimumBet||player2.getPlayerAmount()<minimumBet)
        {
            return true;
        }
        return false;
    }

    public void scorePlayers()
    {
        if(player2.isNotPlaying())
        {
            player1.setPlayerAmount(player1.getPlayerAmount()+pot);
            gameTable.updateNums(this);
            gameTable.resetCommunityCards();
            gameTable.resetHand();
            return;
        } else if(player1.isNotPlaying())
        {
            player2.setPlayerAmount(player2.getPlayerAmount() + pot);
            gameTable.updateNums(this);
            gameTable.resetCommunityCards();
            gameTable.resetHand();
            return;
        }
        gameScore.returnWinner(player1,player2,this);
        if(player2.isNotPlaying())
        {
            player1.setPlayerAmount(player1.getPlayerAmount()+pot);
            System.out.println("The winner of this round was "+player1.getName()+".");
        } else if(player1.isNotPlaying())
        {
            player2.setPlayerAmount(player2.getPlayerAmount()+pot);
            System.out.println("The winner of this round was "+player2.getName()+".");
        } else
        {
            player1.setPlayerAmount(player1.getPlayerAmount()+(pot/2));
            player2.setPlayerAmount(player2.getPlayerAmount()+(pot/2));
            System.out.println("Both players tied, the pot was split.");
        }
        gameTable.updateNums(this);
        gameTable.resetCommunityCards();
        gameTable.resetHand();
    }


    public void playerRound(Player player)
    {
            if(player.getPlayerAmount()!=0) {
                gameTable.loadCurrentHand(player);
                gameTable.setCurrentTurn(player.getName() + "'s turn");
                System.out.println(player.getName() + "'s turn. What would you like to do: (1) to raise, (2) to call, (3) to check, (4) to fold?");
                int choice = TextIO.getInt();
                determineMove(choice, player);
                gameTable.updateNums(this);
            }
    }

    public void startRound()
    {
        gameDeck.shuffle();
        player1.setNotPlaying(false);
        player2.setNotPlaying(false);
        player1.draw(this);
        player2.draw(this);
        pot = 0;
        currentBet=0;
        gameTable.updateNums(this);
        gameTable.resetCommunityCards();
        gameTable.resetHand();
        System.out.println("Dealing cards....");
    }

    public void gameTurn()
    {
        do
        {
            playerRound(player1);
            if(player1.isNotPlaying()){
                break;
            }
            if(currentBet==0&&!player1.isHasChecked())
            {
                break;
            }
            player1.setHasChecked(false);
            playerRound(player2);
        } while(currentBet!=0);
    }

    public void gameRound()
    {
        startRound();
        gameTurn();
        if(player1.isNotPlaying()|| player2.isNotPlaying())
        {
            return;
        }
        dealCommunityCards(3,0,3);
        gameTurn();
        if(player1.isNotPlaying()|| player2.isNotPlaying())
        {
            return;
        }
        for(int i=3;i<5;i++)
        {
            currentBet=0;
            dealCommunityCards(1,i,i+1);
            gameTurn();
            if(player1.isNotPlaying()|| player2.isNotPlaying())
            {
                return;
            }
        }
        scorePlayers();
        player1.getGameHand().removeAllWhenFull();
        player2.getGameHand().removeAllWhenFull();
    }

    public void start(){
        System.out.println("What is your name Player 1?");
        String name1= TextIO.getlnString();
        player1.setName(name1);
        System.out.println("What is your name Player 2?");
        String name2= TextIO.getlnString();
        player2.setName(name2);
        gameTable.updateNums(this);
        do
        {
            gameRound();
        }while(!checkLoss());
        if(player1.getPlayerAmount()==0){
            System.out.println(player1.getName()+" ran out of money and has been kicked off the table.");
        } else if(player2.getPlayerAmount()==0){
            System.out.println(player2.getName()+" ran out of money and has been kicked off the table.");
        }
    }

    public void dealCommunityCards(int dealAmount, int dealIndex, int printIndex){

        for(int k=dealIndex;k<dealIndex+dealAmount;k++)
        {
            communityCards[k] = gameDeck.dealCard();
            gameTable.addToCommunityPanel(communityCards[k],k);
        }
        if(printIndex==3){
            System.out.println("Dealing flop cards....");
        } else if(printIndex==4){
            System.out.println("Dealing turn card....");
        } else{
            System.out.println("Dealing river card....");
        }
    }

}
