//https://adventofcode.com/2022/day/3

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Main{

    public static void main(String[] args){
        ArrayList<String> fileData = new ArrayList<>();
        int fileDataLenght = 0;
        HashMap<Integer, String> letters = new HashMap<>();
        boolean resultIn = false;
        Tables.putIn(letters);
        int score = 0;
        int scoreB = 0;
        String firstCompartment = "";
        String secondCompartment = "";

        try {
            File myObj = new File("input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                    fileData.add(data);
                        
            } 
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        //System.out.println(fileData);

        for(String compartments : fileData){
            fileDataLenght++;
            int lenghtOfCompartment = compartments.length()/2;
            firstCompartment = compartments.substring(0, lenghtOfCompartment);
            secondCompartment = compartments.substring(lenghtOfCompartment, compartments.length());
            
            //System.out.println(compartments);
            //System.out.println(firstCompartment);
            //System.out.println(secondCompartment);
            
            for(int i=1; i < 53; i++){
                resultIn = findChar(letters.get(i), firstCompartment, secondCompartment);
                if(resultIn){
                    score += i;
                }
            }
            resultIn = false;

        }
        System.out.println("Score part 1: " + score);

          //part2

        for(int i = -1; i < fileDataLenght-1; i += 3){
            int firstHelp = i+1;
            int secondHelp = i+2;
            int thirdHelp = i+3;
            System.out.println("prvni: " + firstHelp + " Druhy: " + secondHelp + " Treti: " + thirdHelp);
            String firstBag = fileData.get(firstHelp);
            String secondBag = fileData.get(secondHelp);
            String thirdBag = fileData.get(thirdHelp);
            
            for(int x=1; x < 53; x++){
                String letter = letters.get(x);
                boolean result1 = findChar(letter, firstBag, secondBag);
                boolean result2 = findChar(letter, secondBag, thirdBag);
                boolean result3 = findChar(letter, firstBag, thirdBag);
                if(result1 && result2 && result3){
                    scoreB += x;
                }
            }
        }
        System.out.println("Score part 2: " + scoreB);
    }
    
    public static boolean findChar(String character, String object1, String object2){
        boolean firstIn = false;
        boolean secondIn = false;
        boolean result = false;

        for(int i = 0; i < object1.length(); i++){
            //System.out.println("pismeno v 1: " + object1.substring(i, i+1));
            //System.out.println("pismeno v 2: " +object2.substring(i, i+1));

            if(object1.substring(i, i+1).equals(character)){
                firstIn = true;
                
            }
        }
        for(int y = 0; y < object2.length(); y++){    
            if(object2.substring(y, y+1).equals(character)){
                secondIn = true;
            }
        }
        if(firstIn && secondIn){
            result = true;
        }
        
        return result;
    }
    
}