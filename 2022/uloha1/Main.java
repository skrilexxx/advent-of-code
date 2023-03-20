import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;


public class Main{

    public static void main(String[] args){
        ArrayList<String> elves = new ArrayList<>();
        ArrayList<Integer> kcalSum = new ArrayList<>(); 

        int count = 0;
        int largest = 0;
        int largestElf = -1;
        int length = 0;

        try {
            File myObj = new File("input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                    elves.add(data);
                        
            } 
            myReader.close();
        } catch (FileNotFoundException e) {
            //System.out.println("An error occurred.");
            e.printStackTrace();
        }
        //System.out.println(elves);

        for(String numberStr : elves){
            if (numberStr.equals("")){
                kcalSum.add(count);
                count = 0;
            } 
            else {
                count += Integer.parseInt(numberStr);
            }
        }
        kcalSum.add(count);


        //System.out.println("kcalSum");
        //System.out.println(kcalSum);

        for(int i : kcalSum){
                length +=1;
            }
            //System.out.println(length);
        

        for(int i = 0; i < (length); i++){
            if(kcalSum.get(i) > largest){
                largest = kcalSum.get(i);
                largestElf = i+1;
            }
        }
        System.out.println(largest);
        //System.out.println(largestElf);

        kcalSum.sort(Comparator.reverseOrder());
        int sum = 0;
        for(int i = 0; i < 3; i++){
            sum += kcalSum.get(i);
        }
        System.out.println(sum);

    }
    
}