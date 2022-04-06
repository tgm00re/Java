public class Card   {
    private String suit;
    private int value; //1 = Ace, 2-10, 11 = jack, 12 = queen, 13 = king, 14 = joker

    public Card(String suit, int value){
        this.suit = suit;
        this.value = value;
    }
    public Card( int value){
        this("joker" , value);
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public String getRealValue(){
        if(this.value == 1){
            return "ace";
        } else if(this.value == 10){
            return "jack";
        } else if(this.value == 11){
            return "queen";
        } else if(this.value == 12){
            return "king";
        } else if(this.value == 13){
            return "joker";
        }
        return Integer.toString(this.value);
    }
}