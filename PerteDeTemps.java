//Benjamin Maymir
//maymi001

import java.util.Random;
final class Card
{
//CARD. A playing card from a standard deck but not a joker. You can't extend
//this class because it's FINAL. You can't modify its instances.

//RANK NAME. Printable names of card ranks.

private static final String [] rankName =
{
"ace",       //   0
"two",       //   1
"three",     //   2
"four",      //   3
"five",      //   4
"six",       //   5
"seven",     //   6
"eight",     //   7
"nine",      //   8
"ten",       //   9
"jack",      //  10
"queen",     //  11
"king"       //  12
};

//SUIT NAME. Printable names of card suits.

private static final String [] suitName =
{
"clubs",     //  0
"diamonds",  //  1
"hearts",    //  2
"spades"     //  3
};

private int rank;  //  Rank of this CARD, between 0 and 12.
private int suit;  //  Suit of this CARD, between 0 and 3.

//CARD. Constructor. Make a new CARD, with a given RANK and SUIT.

public Card(int rank, int suit)
{
if (0 <= rank && rank <= 12 && 0 <= suit && suit <= 3)
{
  this.rank = rank;
  this.suit = suit;
}
else
{
  throw new IllegalArgumentException("Illegal rank or suit.");
}
}

//GET RANK. Return the RANK of this CARD.

public int getRank()
{
return rank;
}

//GET SUIT. Return the SUIT of this CARD.

public int getSuit()
{
return suit;
}

//TO STRING. Return a STRING that describes this CARD. For printing only!

public String toString()
{
return rankName[rank] + " (" + rank + ") of " + suitName[suit];
}
}
class PerteDeTemps {
	public static void main(String [] args) {
		Tableau t;
		t = new Tableau();
		t.play();
	}
}
class Deck{
	private Card[] deck;
	private int deckPosition;
	public Deck() {
		deck = new Card[52];
		for(int i=0;i<52;i++) {
			deck[i] = new Card(i%13,i/13);
		}
		deckPosition=0;
	}
	public Card deal(){
		if(deckPosition>=deck.length){
			throw new IllegalStateException("Can not draw from an empty deck");
		}
		return(deck[deckPosition++]);

	}
	public void shuffle(){
		if(deckPosition!=0){
			throw new IllegalStateException("Can not shuffle the deck after drawing");
		}
		Random r = new Random();
		Card temp;
		int i = 52;
		int j;
		while(i-->1){
			j=r.nextInt(i);
			temp=deck[i];
			deck[i]=deck[j];
			deck[j]=temp;
		}
	}
}
class Pile{
	private class Layer{
		private Card card;
		private Layer next;
		public Layer(Card card,Layer next){
			this.card=card;
			this.next=next;
		}

	}
	private int depth;
	private Layer top;
	public Pile(){
		depth=0;
		top=null;
	}
	public void add(Card card){
		top = new Layer(card,top);
		depth++;
	}
	public Card draw(){
		if(depth==0){
			throw new IllegalStateException("You can not draw from an empty pile");
		}
		Layer temp = top;
		top = top.next;
		depth--;
		return(temp.card);
	}
	public Boolean isEmpty(){
		return(depth==0);
	}
}
class Tableau{
	private int currentPile;
	Pile[] piles;
	Deck deck;
	public Tableau(){
		deck = new Deck();
		piles = new Pile[13];
		deck.shuffle();
		for(int i=0;i<13;i++){
			piles[i] = new Pile();
			for(int j=0;j<4;j++){
				piles[i].add(deck.deal());
			}
		}
		currentPile=0;
	}
	public void play(){
		Card c1,c2;
		c1 = piles[currentPile].draw();
		System.out.println("Got card " + c1 + " from pile " + currentPile);
		while(true){
			if(piles[currentPile].isEmpty()){
				boolean allEmpty=true;
				for(Pile p:piles){
					if(!p.isEmpty()){
						allEmpty=false;
						break;
					}
				}
				if(allEmpty){
					System.out.println("We won!");
				} else{
					System.out.println("Pile " + currentPile + " is empty. We lost!");
				}
				break;
			}
			c2 = piles[currentPile].draw();
			System.out.println("Got card " + c2 + " from pile " + currentPile);
			if(c1.getSuit()==c2.getSuit()){
				currentPile=c1.getRank();
			}else{
				currentPile=c2.getRank();
			}
			c1=c2;
		}
	}
}
// Output of loss

// Got card ten (9) of diamonds from pile 0
// Got card two (1) of hearts from pile 0
// Got card three (2) of hearts from pile 1
// Got card ace (0) of hearts from pile 1
// Got card ten (9) of spades from pile 2
// Got card queen (11) of diamonds from pile 9
// Got card five (4) of diamonds from pile 11
// Got card two (1) of diamonds from pile 11
// Got card six (5) of diamonds from pile 4
// Got card nine (8) of spades from pile 1
// Got card king (12) of clubs from pile 8
// Got card four (3) of hearts from pile 12
// Got card ace (0) of diamonds from pile 3
// Got card jack (10) of clubs from pile 0
// Got card eight (7) of hearts from pile 10
// Got card king (12) of spades from pile 7
// Got card nine (8) of clubs from pile 12
// Got card four (3) of clubs from pile 8
// Got card ace (0) of clubs from pile 8
// Got card queen (11) of clubs from pile 3
// Got card six (5) of clubs from pile 0
// Got card king (12) of diamonds from pile 11
// Got card four (3) of diamonds from pile 12
// Got card four (3) of spades from pile 12
// Got card three (2) of clubs from pile 3
// Got card three (2) of diamonds from pile 2
// Got card three (2) of spades from pile 2
// Got card nine (8) of hearts from pile 2
// Got card seven (6) of spades from pile 8
// Got card seven (6) of clubs from pile 6
// Got card nine (8) of diamonds from pile 6
// Pile 8 is empty. We lost!

// Output of win

// Got card three (2) of hearts from pile 0
// Got card four (3) of spades from pile 0
// Got card eight (7) of hearts from pile 3
// Got card ace (0) of hearts from pile 7
// Got card six (5) of clubs from pile 7
// Got card ten (9) of spades from pile 5
// Got card king (12) of clubs from pile 9
// Got card two (1) of diamonds from pile 12
// Got card seven (6) of clubs from pile 1
// Got card jack (10) of diamonds from pile 6
// Got card eight (7) of clubs from pile 10
// Got card ten (9) of hearts from pile 7
// Got card eight (7) of diamonds from pile 9
// Got card jack (10) of spades from pile 7
// Got card five (4) of diamonds from pile 10
// Got card jack (10) of hearts from pile 4
// Got card three (2) of clubs from pile 10
// Got card two (1) of clubs from pile 2
// Got card five (4) of spades from pile 2
// Got card four (3) of hearts from pile 4
// Got card king (12) of diamonds from pile 3
// Got card two (1) of hearts from pile 12
// Got card nine (8) of hearts from pile 1
// Got card five (4) of clubs from pile 1
// Got card queen (11) of diamonds from pile 4
// Got card seven (6) of diamonds from pile 11
// Got card five (4) of hearts from pile 11
// Got card six (5) of spades from pile 4
// Got card six (5) of hearts from pile 5
// Got card three (2) of diamonds from pile 5
// Got card four (3) of clubs from pile 2
// Got card seven (6) of hearts from pile 3
// Got card ace (0) of diamonds from pile 6
// Got card nine (8) of clubs from pile 0
// Got card queen (11) of clubs from pile 8
// Got card ten (9) of diamonds from pile 8
// Got card ace (0) of clubs from pile 9
// Got card seven (6) of spades from pile 0
// Got card queen (11) of spades from pile 6
// Got card two (1) of spades from pile 6
// Got card eight (7) of spades from pile 11
// Got card king (12) of hearts from pile 1
// Got card nine (8) of spades from pile 12
// Got card four (3) of diamonds from pile 8
// Got card jack (10) of clubs from pile 3
// Got card six (5) of diamonds from pile 10
// Got card king (12) of spades from pile 5
// Got card nine (8) of diamonds from pile 12
// Got card queen (11) of hearts from pile 8
// Got card ten (9) of clubs from pile 11
// Got card three (2) of spades from pile 9
// Got card ace (0) of spades from pile 2
// We won!

//Altered main class to demonstrate exceptions
// public static void main(String [] args) {
// 	try{
// 		Card fakecard = new Card(13,4);
// 	}catch(IllegalArgumentException e){
// 		System.out.println(e.getMessage());
// 	}
// 	Deck deck = new Deck();
// 	try{
// 		for(int i=0;i<53;i++){
// 			deck.deal();
// 		}
// 	}catch(IllegalStateException e){
// 		System.out.println(e.getMessage());
// 	}
// 	try{
// 		deck.shuffle();
// 	}catch(IllegalStateException e){
// 		System.out.println(e.getMessage());
// 	}
// 	Pile p = new Pile();
// 	try{
// 		p.draw();
// 	}catch(IllegalStateException e){
// 		System.out.println(e.getMessage());
// 	}
// }

// Output of altered main method

//Illegal rank or suit.
//Can not draw from an empty deck
//Can not shuffle the deck after drawing
//You can not draw from an empty pile