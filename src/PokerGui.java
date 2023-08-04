import javax.swing.*;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class PokerGui extends JFrame {
    private JLabel player1 = new JLabel();
    private JLabel player2 = new JLabel();
    private JLabel potAmount = new JLabel();
    private JLabel currentBet = new JLabel();
    private JLabel communityCard1 = new JLabel();
    private JLabel communityCard2 = new JLabel();
    private JLabel communityCard3 = new JLabel();
    private JLabel communityCard4 = new JLabel();
    private JLabel communityCard5 = new JLabel();
    private JLabel currentHand1 = new JLabel();
    private JLabel currentHand2 = new JLabel();
    private JPanel blankSpace=new JPanel();
    private JLabel currentTurn = new JLabel();
    private JPanel nums = new JPanel();
    private JPanel communityCardPanel = new JPanel();
    private JPanel hand = new JPanel();

    //cards
    private final ImageIcon TWO_OF_SPADES = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/2_of_spades.png");
    private final ImageIcon TWO_OF_HEARTS = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/2_of_hearts.png");
    private final ImageIcon TWO_OF_DIAMONDS = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/2_of_diamonds.png");
    private final ImageIcon TWO_OF_CLUBS = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/2_of_clubs.png");
    private final ImageIcon THREE_OF_SPADES = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/3_of_spades.png");
    private final ImageIcon THREE_OF_HEARTS = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/3_of_hearts.png");
    private final ImageIcon THREE_OF_DIAMONDS = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/3_of_diamonds.png");
    private final ImageIcon THREE_OF_CLUBS = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/3_of_clubs.png");
    private final ImageIcon FOUR_OF_SPADES = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/4_of_spades.png");
    private final ImageIcon FOUR_OF_HEARTS = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/4_of_hearts.png");
    private final ImageIcon FOUR_OF_DIAMONDS = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/4_of_diamonds.png");
    private final ImageIcon FOUR_OF_CLUBS = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/4_of_clubs.png");
    private final ImageIcon FIVE_OF_SPADES = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/5_of_spades.png");
    private final ImageIcon FIVE_OF_HEARTS = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/5_of_hearts.png");
    private final ImageIcon FIVE_OF_DIAMONDS = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/5_of_diamonds.png");
    private final ImageIcon FIVE_OF_CLUBS = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/5_of_clubs.png");
    private final ImageIcon SIX_OF_SPADES = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/6_of_spades.png");
    private final ImageIcon SIX_OF_HEARTS = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/6_of_hearts.png");
    private final ImageIcon SIX_OF_DIAMONDS = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/6_of_diamonds.png");
    private final ImageIcon SIX_OF_CLUBS = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/6_of_clubs.png");
    private final ImageIcon SEVEN_OF_SPADES = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/7_of_spades.png");
    private final ImageIcon SEVEN_OF_HEARTS = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/7_of_hearts.png");
    private final ImageIcon SEVEN_OF_DIAMONDS = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/7_of_diamonds.png");
    private final ImageIcon SEVEN_OF_CLUBS = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/7_of_clubs.png");
    private final ImageIcon EIGHT_OF_SPADES = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/8_of_spades.png");
    private final ImageIcon EIGHT_OF_HEARTS = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/8_of_hearts.png");
    private final ImageIcon EIGHT_OF_DIAMONDS = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/8_of_diamonds.png");
    private final ImageIcon EIGHT_OF_CLUBS = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/8_of_clubs.png");
    private final ImageIcon NINE_OF_SPADES = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/9_of_spades.png");
    private final ImageIcon NINE_OF_HEARTS = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/9_of_hearts.png");
    private final ImageIcon NINE_OF_DIAMONDS = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/9_of_diamonds.png");
    private final ImageIcon NINE_OF_CLUBS = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/9_of_clubs.png");
    private final ImageIcon TEN_OF_SPADES = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/10_of_spades.png");
    private final ImageIcon TEN_OF_HEARTS = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/10_of_hearts.png");
    private final ImageIcon TEN_OF_DIAMONDS = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/10_of_diamonds.png");
    private final ImageIcon TEN_OF_CLUBS = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/10_of_clubs.png");
    private final ImageIcon JACK_OF_SPADES = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/jack_of_spades2.png");
    private final ImageIcon JACK_OF_HEARTS = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/jack_of_hearts2.png");
    private final ImageIcon JACK_OF_DIAMONDS = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/jack_of_diamonds2.png");
    private final ImageIcon JACK_OF_CLUBS = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/jack_of_clubs2.png");
    private final ImageIcon QUEEN_OF_SPADES = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/queen_of_spades2.png");
    private final ImageIcon QUEEN_OF_HEARTS = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/queen_of_hearts2.png");
    private final ImageIcon QUEEN_OF_DIAMONDS = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/queen_of_diamonds2.png");
    private final ImageIcon QUEEN_OF_CLUBS = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/queen_of_clubs2.png");
    private final ImageIcon KING_OF_SPADES = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/king_of_spades2.png");
    private final ImageIcon KING_OF_HEARTS = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/king_of_hearts2.png");
    private final ImageIcon KING_OF_DIAMONDS = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/king_of_diamonds2.png");
    private final ImageIcon KING_OF_CLUBS = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/king_of_clubs2.png");
    private final ImageIcon ACE_OF_SPADES = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/ace_of_spades.png");
    private final ImageIcon ACE_OF_HEARTS = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/ace_of_hearts.png");
    private final ImageIcon ACE_OF_DIAMONDS = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/ace_of_diamonds.png");
    private final ImageIcon ACE_OF_CLUBS = new ImageIcon("/Users/danielwu/Downloads/CardGamePoker/resources/ace_of_clubs.png");

    public PokerGui(Poker game) {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setSize(1000, 700);
        this.setResizable(false);
        loadPanels();
    }

    //getters and setters
    public JPanel getHand() {
        return hand;
    }
    public void setHand(JPanel hand) {
        this.hand = hand;
    }
    public void setCurrentTurn(String text) {
        currentTurn.setText(text);
    }

    //methods
    public void loadPanels()
    {
        blankSpace.setPreferredSize(new Dimension(1000,20));
        add(blankSpace);
        nums.setPreferredSize(new Dimension(1000, 50));
        add(nums);
        loadNums();
        communityCardPanel.setPreferredSize(new Dimension(1000, 300));
        add(communityCardPanel);
        loadCommunityCards();
        hand.setPreferredSize(new Dimension(1000, 300));
        add(hand);
        loadHand();
    }

    public void updateNums(Poker game)
    {
        player1.setText("|| " + game.getPlayer1().getName() + ": " + game.getPlayer1().getPlayerAmount() + " ||");
        player1.setFont(new Font("Serif", Font.BOLD, 21));
        player2.setText(game.getPlayer2().getName() + ": " + game.getPlayer2().getPlayerAmount() + " ||");
        player2.setFont(new Font("Serif", Font.BOLD, 21));
        potAmount.setText("Pot: " + game.getPot() + " ||");
        potAmount.setFont(new Font("Serif", Font.BOLD, 21));
        currentBet.setText("Current Bet: " + game.getCurrentBet() + " ||");
        currentBet.setFont(new Font("Serif", Font.BOLD, 21));
        currentTurn.setFont(new Font("Serif", Font.BOLD, 21));
    }

    public void loadNums()
    {
        nums.add(player1);
        nums.add(player2);
        nums.add(potAmount);
        nums.add(currentBet);
        nums.add(currentTurn);
    }

    public void addToCommunityPanel(Card c, int index)
    {
        switch(index){
            case 0:
                communityCard1.setIcon(loadCard(c));
                break;
            case 1:
                communityCard2.setIcon(loadCard(c));
                break;
            case 2:
                communityCard3.setIcon(loadCard(c));
                break;
            case 3:
                communityCard4.setIcon(loadCard(c));
                break;
            case 4:
                communityCard5.setIcon(loadCard(c));
                break;
        }
    }

    public void loadCommunityCards()
    {
        communityCardPanel.add(communityCard1);
        communityCardPanel.add(communityCard2);
        communityCardPanel.add(communityCard3);
        communityCardPanel.add(communityCard4);
        communityCardPanel.add(communityCard5);
    }

    public void resetCommunityCards()
    {
        communityCard1.setIcon(null);
        communityCard2.setIcon(null);
        communityCard3.setIcon(null);
        communityCard4.setIcon(null);
        communityCard5.setIcon(null);
        communityCardPanel.revalidate();
        communityCardPanel.repaint();
    }

    public void loadHand()
    {
        hand.add(currentHand1);
        hand.add(currentHand2);
    }

    public void loadCurrentHand(Player player){
        currentHand1.setIcon(loadCard(player.getGameHand().getCard(0)));
        currentHand2.setIcon(loadCard(player.getGameHand().getCard(1)));
    }

    public void resetHand(){
        currentHand1.setIcon(null);
        currentHand2.setIcon(null);
        hand.revalidate();
        hand.repaint();
    }

    public ImageIcon loadCard(Card c)
    {
        if (c.getValue() == 2 && c.getSuit() == 0) {
            return TWO_OF_SPADES;
        } else if (c.getValue() == 2 && c.getSuit() == 1) {
            return TWO_OF_HEARTS;
        } else if (c.getValue() == 2 && c.getSuit() == 2) {
            return TWO_OF_DIAMONDS;
        } else if (c.getValue() == 2 && c.getSuit() == 3) {
            return TWO_OF_CLUBS;
        } else if (c.getValue() == 3 && c.getSuit() == 0) {
            return THREE_OF_SPADES;
        } else if (c.getValue() == 3 && c.getSuit() == 1) {
            return THREE_OF_HEARTS;
        } else if (c.getValue() == 3 && c.getSuit() == 2) {
            return THREE_OF_DIAMONDS;
        } else if (c.getValue() == 3 && c.getSuit() == 3) {
            return THREE_OF_CLUBS;
        } else if (c.getValue() == 4 && c.getSuit() == 0) {
            return FOUR_OF_SPADES;
        } else if (c.getValue() == 4 && c.getSuit() == 1) {
            return FOUR_OF_HEARTS;
        } else if (c.getValue() == 4 && c.getSuit() == 2) {
            return FOUR_OF_DIAMONDS;
        } else if (c.getValue() == 4 && c.getSuit() == 3) {
            return FOUR_OF_CLUBS;
        } else if (c.getValue() == 5 && c.getSuit() == 0) {
            return FIVE_OF_SPADES;
        } else if (c.getValue() == 5 && c.getSuit() == 1) {
            return FIVE_OF_HEARTS;
        } else if (c.getValue() == 5 && c.getSuit() == 2) {
            return FIVE_OF_DIAMONDS;
        } else if (c.getValue() == 5 && c.getSuit() == 3) {
            return FIVE_OF_CLUBS;
        } else if (c.getValue() == 6 && c.getSuit() == 0) {
            return SIX_OF_SPADES;
        } else if (c.getValue() == 6 && c.getSuit() == 1) {
            return SIX_OF_HEARTS;
        } else if (c.getValue() == 6 && c.getSuit() == 2) {
            return SIX_OF_DIAMONDS;
        } else if (c.getValue() == 6 && c.getSuit() == 3) {
            return SIX_OF_CLUBS;
        } else if (c.getValue() == 7 && c.getSuit() == 0) {
            return SEVEN_OF_SPADES;
        } else if (c.getValue() == 7 && c.getSuit() == 1) {
            return SEVEN_OF_HEARTS;
        } else if (c.getValue() == 7 && c.getSuit() == 2) {
            return SEVEN_OF_DIAMONDS;
        } else if (c.getValue() == 7 && c.getSuit() == 3) {
            return SEVEN_OF_CLUBS;
        } else if (c.getValue() == 8 && c.getSuit() == 0) {
            return EIGHT_OF_SPADES;
        } else if (c.getValue() == 8 && c.getSuit() == 1) {
            return EIGHT_OF_HEARTS;
        } else if (c.getValue() == 8 && c.getSuit() == 2) {
            return EIGHT_OF_DIAMONDS;
        } else if (c.getValue() == 8 && c.getSuit() == 3) {
            return EIGHT_OF_CLUBS;
        } else if (c.getValue() == 9 && c.getSuit() == 0) {
            return NINE_OF_SPADES;
        } else if (c.getValue() == 9 && c.getSuit() == 1) {
            return NINE_OF_HEARTS;
        } else if (c.getValue() == 9 && c.getSuit() == 2) {
            return NINE_OF_DIAMONDS;
        } else if (c.getValue() == 9 && c.getSuit() == 3) {
            return NINE_OF_CLUBS;
        } else if (c.getValue() == 10 && c.getSuit() == 0) {
            return TEN_OF_SPADES;
        } else if (c.getValue() == 10 && c.getSuit() == 1) {
            return TEN_OF_HEARTS;
        } else if (c.getValue() == 10 && c.getSuit() == 2) {
            return TEN_OF_DIAMONDS;
        } else if (c.getValue() == 10 && c.getSuit() == 3) {
            return TEN_OF_CLUBS;
        } else if (c.getValue() == 11 && c.getSuit() == 0) {
            return JACK_OF_SPADES;
        } else if (c.getValue() == 11 && c.getSuit() == 1) {
            return JACK_OF_HEARTS;
        } else if (c.getValue() == 11 && c.getSuit() == 2) {
            return JACK_OF_DIAMONDS;
        } else if (c.getValue() == 11 && c.getSuit() == 3) {
            return JACK_OF_CLUBS;
        } else if (c.getValue() == 12 && c.getSuit() == 0) {
            return QUEEN_OF_SPADES;
        } else if (c.getValue() == 12 && c.getSuit() == 1) {
            return QUEEN_OF_HEARTS;
        } else if (c.getValue() == 12 && c.getSuit() == 2) {
            return QUEEN_OF_DIAMONDS;
        } else if (c.getValue() == 12 && c.getSuit() == 3) {
            return QUEEN_OF_CLUBS;
        } else if (c.getValue() == 13 && c.getSuit() == 0) {
            return KING_OF_SPADES;
        } else if (c.getValue() == 13 && c.getSuit() == 1) {
            return KING_OF_HEARTS;
        } else if (c.getValue() == 13 && c.getSuit() == 2) {
            return KING_OF_DIAMONDS;
        } else if (c.getValue() == 13 && c.getSuit() == 3) {
            return KING_OF_CLUBS;
        } else if (c.getValue() == 1 && c.getSuit() == 0) {
            return ACE_OF_SPADES;
        } else if (c.getValue() == 1 && c.getSuit() == 1) {
            return ACE_OF_HEARTS;
        } else if (c.getValue() == 1 && c.getSuit() == 2) {
            return ACE_OF_DIAMONDS;
        } else if(c.getValue() == 1 && c.getSuit() == 3) {
            return ACE_OF_CLUBS;
        } else{
            return null;
        }
    }

}

