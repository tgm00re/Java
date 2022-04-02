import java.util.Random;
import java.util.ArrayList;

public class PuzzleJava {
    Random randMachine = new Random();

    public ArrayList<Integer> getTenRolls(){
        ArrayList<Integer> rollArrList = new ArrayList<Integer>();
        for(int i = 0; i < 10; i++){
            int num = randMachine.nextInt(21-10) + 10;
            rollArrList.add(num);
        }
        return rollArrList;
    }


    public char getRandomLetter(){
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        return alphabet[randMachine.nextInt(26)];
    }

    public String generatePassword(){
        String password = "";
        for(int i = 0; i < 8; i++){
            password += getRandomLetter();
        }
        return password;
    }

    public String[] getNewPasswordSet(){
        String[] passwordSet = new String[6];
        for(int i = 0; i < 6; i++ ){
            passwordSet[i] = generatePassword();
        }
        return passwordSet;
    }

    public int[] shuffleArray(int[] arr){
        int[] newArr = arr;
        for(int i = 0; i < 10; i++){
            int indexOne = randMachine.nextInt(newArr.length);
            int indexTwo = randMachine.nextInt(newArr.length);
            
            int temp = newArr[indexTwo];
            newArr[indexTwo] = newArr[indexOne];
            newArr[indexOne] = temp;
        }
        return newArr;
    }
}
