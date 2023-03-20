import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args){
        ArrayList<String> fileData = new ArrayList<>();
        ArrayList<String> myMoves = new ArrayList<>();
        ArrayList<String> elfMoves = new ArrayList<>();

        int count = 0;
        int score = 0;
        int scoreB = 0;

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

        for(String pair : fileData){
            String[] splitPair = pair.split(" ");
            elfMoves.add(splitPair[0]);
            myMoves.add(splitPair[1]);
            count++;
        }  

        //System.out.println("Elf moves: " + elfMoves);
        //System.out.println("My moves: " + myMoves);
        
        for(int i = 0; i < count; i++){
            if(elfMoves.get(i).equals("A")){
                if(myMoves.get(i).equals("X")){
                    score += 4;
                }
                else if(myMoves.get(i).equals("Y")){
                    score += 8;
                }
                else{
                    score += 3;
                }
            }

            if(elfMoves.get(i).equals("B")){
                if(myMoves.get(i).equals("X")){
                    score += 1;
                }
                else if(myMoves.get(i).equals("Y")){
                    score += 5;
                }
                else{
                    score += 9;
                }
            }

            if(elfMoves.get(i).equals("C")){
                if(myMoves.get(i).equals("X")){
                    score += 7;
                }
                else if(myMoves.get(i).equals("Y")){
                    score += 2;
                }
                else{
                    score += 6;
                }
            }
        }
        System.out.println("Score: " + score);

        for(int i =0; i < count; i++){
            if(elfMoves.get(i).equals("A")){
                if(myMoves.get(i).equals("X")){
                    scoreB += 3;
                }
                if(myMoves.get(i).equals("Y")){
                    scoreB += 4;
                }
                if(myMoves.get(i).equals("Z")){
                    scoreB += 8;
                }
            }
            if(elfMoves.get(i).equals("B")){
                if(myMoves.get(i).equals("X")){
                    scoreB += 1;
                }
                if(myMoves.get(i).equals("Y")){
                    scoreB += 5;
                }
                if(myMoves.get(i).equals("Z")){
                    scoreB += 9;
                }
            }
            if(elfMoves.get(i).equals("C")){
                if(myMoves.get(i).equals("X")){
                    scoreB += 2;
                }
                if(myMoves.get(i).equals("Y")){
                    scoreB += 6;
                }
                if(myMoves.get(i).equals("Z")){
                    scoreB += 7;
                }
            }
        }
        System.out.println("Score B: "+ scoreB);
    }

}
