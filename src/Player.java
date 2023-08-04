public class Player
{
    //instance vars
    private Hand gameHand=new Hand();
    private int playerAmount;
    private boolean notPlaying;
    private boolean hasChecked;
    private String name;

    //getters and setters
    public Hand getGameHand() {
        return gameHand;
    }
    public int getPlayerAmount() {
        return playerAmount;
    }
    public void setPlayerAmount(int playerAmount) {
        this.playerAmount = playerAmount;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isNotPlaying() {
        return notPlaying;
    }
    public void setNotPlaying(boolean notPlaying) {
        this.notPlaying = notPlaying;
    }
    public boolean isHasChecked() {
        return hasChecked;
    }
    public void setHasChecked(boolean hasChecked) {
        this.hasChecked = hasChecked;
    }
    //methods
    public void draw(Poker game){
        gameHand.addCard(game.getGameDeck().dealCard());
        gameHand.addCard(game.getGameDeck().dealCard());
    }
    public void buyIn(Poker game){
        game.addToPot(game.getMinimumBet());
        playerAmount=playerAmount-game.getMinimumBet();
    }
    public void raise(int amount,Poker game){
        if(playerAmount<amount+game.getCurrentBet()){
            System.out.println("You do not have enough to raise. Would you like to (1) fold, (2) check, (3) re-raise, or (4) go all in.");
            int choice = TextIO.getInt();
            if (choice!=1&&choice!=2&&choice!=3&&choice!=4)
            {
                do{
                    System.out.println("Please enter a valid option.");
                    choice=TextIO.getlnInt();
                }while(choice!=1&&choice!=2&&choice!=3);
            }
            if(choice==1){
                fold(game);

            } else if(choice==2)
            {
                check(game);
            } else if(choice==3){
                System.out.println("What amount would you like to raise by?");
                int raise = TextIO.getInt();
                if(playerAmount<raise+game.getCurrentBet()){
                    do{
                        System.out.println("Please enter a valid option.");
                        raise=TextIO.getlnInt();
                    }while(raise+game.getCurrentBet()>=playerAmount);
                }
                game.addToPot(raise + game.getCurrentBet());
                playerAmount = playerAmount - raise - game.getCurrentBet();
                game.setCurrentBet(raise);
            } else if(choice==4){
                game.addToPot(playerAmount);
                game.setCurrentBet(0);
                playerAmount=0;
            }
        }else
        {
            game.addToPot(amount + game.getCurrentBet());
            playerAmount = playerAmount - amount - game.getCurrentBet();
            game.setCurrentBet(amount);
        }
    }
    public void call(Poker game)
    {
        if(playerAmount<game.getCurrentBet())
        {
            System.out.println("You do not have enough to match. Would you like to go (1) all in or (2) fold.");
            int choice = TextIO.getInt();
            if (choice!=1&&choice!=2)
            {
                do{
                    System.out.println("Please enter a valid option.");
                    choice=TextIO.getlnInt();
                }while(choice!=1&&choice!=2);
            }
            if(choice==1)
            {
                game.addToPot(playerAmount);
                game.setCurrentBet(0);
                playerAmount=0;
            }else
            {
                fold(game);
            }
        }else
        {
            game.addToPot(game.getCurrentBet());
            playerAmount = playerAmount - game.getCurrentBet();
        }
    }
    public void check(Poker game)
    {
        game.addToPot(0);
        hasChecked=true;
    }
    public void fold(Poker game)
    {
        notPlaying =true;
    }



}