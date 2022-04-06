import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> cards;

    public Deck(){
        this.cards = new ArrayList<Card>();
    }

    public void addCard(Card cardToAdd){
        this.cards.add(cardToAdd);
    }

    public void createDeck(){
        for(int i = 0; i <= 3; i++){
            for(int j = 1; j <= 13; j++){
                if(i == 0){
                    this.cards.add(new Card("spade", j));
                } else if(i == 1){
                    this.cards.add(new Card("heart", j));
                } else if(i == 2){
                    this.cards.add(new Card("diamond", j));
                } else {
                    this.cards.add(new Card("clubs", j));
                }
            }
        }
        this.cards.add(new Card(14));
        this.cards.add(new Card(14));
    }

    public void shuffle(){
        for(int i = 0; i < this.cards.size(); i++){
            //This will find a random index 0 to (size of array - 1)
            int indexToSwitch = (int) (Math.random() * this.cards.size());

            //Swap arraylist(i) with arraylist(indexToSwitch)

            //let tempCard = cards[i]
            Card tempCard = this.cards.get(i); //now we have arraylist(i) stored
            //Array: cards
            //cards[i] = cards[indexToSwitch]
            this.cards.set(i, this.cards.get(indexToSwitch));

            //cards[indexToSwitch] = tempCard
            this.cards.set(indexToSwitch, tempCard);
        }
    }


    public void dealHand(){
        Card cardOne = this.cards.get(this.cards.size() - 1);
        Card cardTwo = this.cards.get(this.cards.size() - 2);
        this.cards.remove(this.cards.size() - 1);
        this.cards.remove(this.cards.size() - 2);
        printOneCard(cardOne);
        printOneCard(cardTwo);
    }

    public void printOneCard(Card card){
        System.out.println("Suit: " + card.getSuit() + " | Value: " + card.getValue());
    }


    public void printDeck(){
        // for(Card card : this.cards){
        //     System.out.println("Suit: " + card.getSuit() + " | Value: " + card.getValue() + " | Index: " + );
        // }
        for(int i = 0; i < this.cards.size(); i++){
            System.out.println("Suit: " + this.cards.get(i).getSuit() + " | Value: " + this.cards.get(i).getValue() + " | Index: " + i);
        }
    }

    public void removeCard(String suit, int value){
        for(int i = 0; i < this.cards.size(); i++){
            if(this.cards.get(i).getSuit().equals(suit) && this.cards.get(i).getValue() == value){
                this.cards.remove(i);
                return;
            }
            System.out.println("There was no matching card to remove");
        }
    }

    public void removeCardsByNumber(int value){
        for(int i = this.cards.size() - 1; i >= 0; i--){
            if(this.cards.get(i).getValue() == value){
                this.cards.remove(i);
            } 
        }
    }

    public void removeSuit(String suit){
        for(int i = this.cards.size() - 1; i >= 0; i--){
            if(this.cards.get(i).getSuit().equals(suit)){
                this.cards.remove(i);
            } 
        }
}

    public ArrayList<Card> getCards() {
        return cards;
    }
}
