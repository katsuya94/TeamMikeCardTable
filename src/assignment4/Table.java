/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment4;


import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author henrysmith
 */
public class Table extends JPanel {//Window

  Point point;
  MouseEvent clicked; 
  
  
  BufferedImage image;
  
  JPanel topPanel = new JPanel();
 
  Deckface deckui = new Deckface();
  JPanel dcardPanel = new JPanel();
  JPanel pcardPanel = new JPanel();
  
  JButton PlayGoFish = new JButton();
  JButton dealbutton = new JButton();
  JButton shuffle = new JButton();
  JButton playagainbutton = new JButton();
  JLabel dealerlabel = new JLabel();
  JLabel playerlabel = new JLabel();

  Card[] dealer = new Card[5];    //to hold the dealer's cards
  Card[] player = new Card[5];    //to hold the player's cards
  

  
  public Table () throws IOException 
  {
        //this.image = ImageIO.read(new File("/Users/henrysmith/Desktop/playing-card-back.jpg"));
    
    
    
    
    topPanel.setBackground(new Color(0, 122, 0));
    dcardPanel.setBackground(new Color(0, 122, 0));
    pcardPanel.setBackground(new Color(0, 122, 0));
    
    topPanel.setLayout(new FlowLayout());
    PlayGoFish.setText("Play Go Fish");
    PlayGoFish.addActionListener(new GoFish());
    //winlosebox.setFont(new java.awt.Font("Helvetica Bold", 1, 20));
    //dealbutton.setText("  Deal");
    //dealbutton.addActionListener(new dealbutton());
    //hitbutton.setText("  Hit");
    //hitbutton.addActionListener(new hitbutton());
    //hitbutton.setEnabled(false);
    shuffle.setText("  shuffle");
    shuffle.addActionListener(new shufflebutton());   
    //staybutton.setEnabled(false);
    //playagainbutton.setText("  Play Again");
    //playagainbutton.addActionListener(new playagainbutton());
    //playagainbutton.setEnabled(false); 
    
    //dealerlabel.setText("  Dealer:  ");
    //playerlabel.setText("  Player:  ");

    topPanel.add(PlayGoFish);
    //topPanel.add(dealbutton);
    //topPanel.add(hitbutton);
    topPanel.add(shuffle);
    //topPanel.add(playagainbutton);
    //pcardPanel.add(playerlabel);
    //dcardPanel.add(dealerlabel);
    
    for (int i=0;i <52; ++i)
    {
        this.add(deckui.cards[i]).setLocation(650,400);
        deckui.cards[i].addMouseListener(new clickedMouse(i));
        deckui.cards[i].addMouseMotionListener(new draggingMouse(i));
    }
    
     
   
   
    
    
    
    setLayout(new BorderLayout());
    add(topPanel,BorderLayout.NORTH);
    add(dcardPanel,BorderLayout.CENTER);
    add(pcardPanel,BorderLayout.SOUTH);
    
  
    
  
 }

class Cardface extends JPanel {//Represents each Card as UI
    
    JButton flip = new JButton();//Button to flip card
    JLabel label = new JLabel();//Label that displays card rank and suit
    String back= "";
    String front;
    CardBack backPic = new CardBack();//Image of back of card
    boolean hasBeenFlipped = false;
   
    
    
    
    Cardface(String cardLabel)
    {
        
        front = cardLabel;
        flip.addActionListener(new flipbutton(this));
        label.setText(back);
        this.add(backPic);
        
        this.add(flip);
        flip.setVisible(true);
        this.add(label);
       
        setSize(100,180);
        
     
    }
    
    
    
}
    
class Deckface extends JPanel {//Ui for deck
    Cardface cards[]=new Cardface[52];//52 card faces 
    DeckOfCards deck = new DeckOfCards();
    
    Deckface()
    {
        for(int i = 0; i<52; ++i)
        {
            cards[i]=new Cardface(String.format( "%s",deck.c[i]));
        }
        
    }
    
    public void shuffleUI()
    {
        deck.shuffle();
        for(int i = deck.CardsDealt; i<52; ++i)
        {
            cards[i].label.setText(cards[i].back);
            cards[i].front=String.format("%s",deck.c[i]);
        }
    }
}

class GoFish implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            JOptionPane.showMessageDialog(new JFrame(),"tits");
        }
    
}

class draggingMouse extends MouseMotionAdapter
{
    int j;
    draggingMouse(int i)
    {
        super();
        j = i;
        
    }
    @Override
        public void mouseDragged(MouseEvent e)
        {
            if (e.getSource()==deckui.cards[j])
            {
                point = deckui.cards[j].getLocation(point);
                int x = point.x - clicked.getX() + e.getX();
                int y = point.y - clicked.getY() + e.getY();
                 deckui.cards[j].setLocation(x,y);
                 
                
            }
        }
}

class clickedMouse extends MouseAdapter
{
    int j;
    clickedMouse(int i)
    {
        super();
        j = i;
    }
    @Override
        public void mousePressed(MouseEvent e)
        {
            if(e.getSource()==deckui.cards[j])
                clicked = e;
                
        }
    
}

class flipbutton implements ActionListener
{
        Cardface card;
    
        flipbutton(Cardface getsFlipped)
        {
            card = getsFlipped;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (card.label.getText().equals(""))
            {
                card.label.setText(card.front);
                card.remove(card.backPic);
                
                if (!card.hasBeenFlipped)
                deckui.deck.dealCard();
                
                card.hasBeenFlipped = true;
            } else
            {
                card.add(card.backPic);
                card.label.setText(card.back);
            }
        }
    
}

class CardBack extends JPanel
{
    Image img = new ImageIcon("/Users/henrysmith/Desktop/playing-card-back.jpg").getImage();
    
    CardBack()
    {
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }
    @Override
    public void paintComponent(Graphics g) {
    g.drawImage(img, 0, 0, null);
  }
    
}
class shufflebutton implements ActionListener
{

        @Override
        public void actionPerformed(ActionEvent e) {
            deckui.shuffleUI();
        }
    
}



}

    


 
