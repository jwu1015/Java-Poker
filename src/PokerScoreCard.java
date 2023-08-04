import java.lang.Math;
public class PokerScoreCard {
    private final int NUMSCORES = 9;
    private Score[] testAll = new Score[NUMSCORES];
    private OnePair FindOnePair = new OnePair();
    private TwoPair FindTwoPair = new TwoPair();
    private ThreeOfAKind FindThreeOfAKind = new ThreeOfAKind();
    private Straight FindStraight = new Straight();
    private Flush FindFlush = new Flush();
    private FullHouse FindFullHouse=new FullHouse();
    private FourOfAKind FindFourOfAKind = new FourOfAKind();
    private StraightFlush FindStraightFlush = new StraightFlush();
    private RoyalFlush FindRoyalFlush = new RoyalFlush();

    public PokerScoreCard(){
        testAll[0]=FindOnePair;
        testAll[1]=FindTwoPair;
        testAll[2]=FindThreeOfAKind;
        testAll[3]=FindStraight;
        testAll[4]=FindFlush;
        testAll[5]=FindFullHouse;
        testAll[6]=FindFourOfAKind;
        testAll[7]=FindStraightFlush;
        testAll[8]=FindRoyalFlush;
    }

    public int findMatch(Poker game, Hand playerHand, int index) {
        for (int k = 0; k < 5; k++) {
            if (playerHand.getCard(index).getValue() == game.getCommunityCards()[k].getValue()) {
                return playerHand.getCard(index).getValue();
            }
        }
        return 0;
    }

    public int findRank(Player player, Poker game) {
        int tempRank = 0;
        for (int i = testAll.length - 1; i > 0; i--) {
            tempRank = testAll[i].calculateScore(game, player.getGameHand());
            if (tempRank != 0) {
                break;
            }
        }
        return tempRank;
    }

    public void returnWinner(Player player1, Player player2, Poker game) {
        int rank1 = findRank(player1, game);
        int rank2 = findRank(player2, game);
        if (rank1 > rank2) {
            player2.setNotPlaying(true);
        } else if (rank2 > rank1) {
            player1.setNotPlaying(true);
        } else {
            returnWinnerOfTie(game,rank1);
        }
    }

    public void returnWinnerOfTie(Poker game, int tempRank) {
        int HighCard1 = Math.max(game.getPlayer1().getGameHand().getCard(0).getValue(), game.getPlayer1().getGameHand().getCard(1).getValue());
        int HighCard2 = Math.max(game.getPlayer2().getGameHand().getCard(0).getValue(), game.getPlayer2().getGameHand().getCard(1).getValue());
        int RankCard1 = Math.max(findMatch(game, game.getPlayer1().getGameHand(), 0), findMatch(game, game.getPlayer1().getGameHand(), 1));
        int RankCard2 = Math.max(findMatch(game, game.getPlayer2().getGameHand(), 0), findMatch(game, game.getPlayer2().getGameHand(), 1));
        int KickerCardForPair1 = Math.min(findMatch(game, game.getPlayer1().getGameHand(), 0), findMatch(game, game.getPlayer1().getGameHand(), 1));
        int KickerCardForPair2 = Math.min(findMatch(game, game.getPlayer2().getGameHand(), 0), findMatch(game, game.getPlayer2().getGameHand(), 1));
        int KickerCard1 = Math.min(game.getPlayer1().getGameHand().getCard(0).getValue(), game.getPlayer1().getGameHand().getCard(1).getValue());
        int KickerCard2 = Math.min(game.getPlayer2().getGameHand().getCard(0).getValue(), game.getPlayer2().getGameHand().getCard(1).getValue());
        switch (tempRank) {
            case 0:
            case 4:
            case 5:
            case 7:
            case 8:
                if (HighCard1 > HighCard2) {
                    game.getPlayer2().setNotPlaying(true);
                } else if (HighCard2 > HighCard1) {
                    game.getPlayer1().setNotPlaying(true);
                }
                break;
            case 1:
            case 3:
                if (RankCard1 > RankCard2) {
                    game.getPlayer2().setNotPlaying(true);
                } else if (RankCard2 > RankCard1) {
                    game.getPlayer1().setNotPlaying(true);
                } else {
                    if (KickerCard1 > KickerCard2) {
                        game.getPlayer2().setNotPlaying(true);
                    } else if (KickerCard2 > KickerCard1) {
                        game.getPlayer1().setNotPlaying(true);
                    }
                }
                break;
            case 2:
                if (RankCard1 > RankCard2) {
                    game.getPlayer2().setNotPlaying(true);
                } else if (RankCard2 > RankCard1) {
                    game.getPlayer1().setNotPlaying(true);
                } else {
                    if (KickerCardForPair1 > KickerCardForPair2) {
                        game.getPlayer2().setNotPlaying(true);
                    } else if (KickerCardForPair2 > KickerCardForPair1) {
                        game.getPlayer1().setNotPlaying(true);
                    } else {
                        if (KickerCard1 > KickerCard2) {
                            game.getPlayer2().setNotPlaying(true);
                        } else if (KickerCard2 > KickerCard1) {
                            game.getPlayer1().setNotPlaying(true);
                        }
                    }
                }
                break;
            case 6:
                if (HighCard1 > HighCard2) {
                    game.getPlayer2().setNotPlaying(true);
                } else if (HighCard2 > HighCard1) {
                    game.getPlayer1().setNotPlaying(true);
                } else {
                    if (KickerCardForPair1 > KickerCardForPair1) {
                        game.getPlayer2().setNotPlaying(true);
                    } else if (KickerCardForPair2 > KickerCardForPair1) {
                        game.getPlayer1().setNotPlaying(true);
                    }
                }
                break;
            case 9:
                if (game.getPlayer1().getGameHand().getCard(0).getSuit() < game.getPlayer2().getGameHand().getCard(0).getSuit()) {
                    game.getPlayer2().setNotPlaying(true);
                } else if (game.getPlayer1().getGameHand().getCard(0).getSuit() > game.getPlayer2().getGameHand().getCard(0).getSuit()) {
                    game.getPlayer1().setNotPlaying(true);
                }
        }
    }
}