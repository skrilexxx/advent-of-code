//https://adventofcode.com/2022/day/4

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner; 

public class Main{

    public static void main(String[] args){
        ArrayList<String> fileData = new ArrayList<>();
        ArrayList<Integer> firstPairList = new ArrayList<>();
        ArrayList<Integer> secondPairList = new ArrayList<>();

        int count = 0;
        int score = 0;
        int scoreB = 0;


        try {
            File myObj = new File("input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] dataSplit = data.split(",");
                fileData.add(dataSplit[0]);
                fileData.add(dataSplit[1]);
                count++;         
            } 
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        //System.out.println(fileData);
        count = count*2;
        //Part 1
        for(int i = -1; i < (count-2); i+=2){
            String firstPair = fileData.get(i+1);
            String secondPair = fileData.get(i+2);
            //System.out.println(firstPair +" : "+ secondPair);


            String firstP[] = firstPair.split("-");
            String secondP[] = secondPair.split("-");
            
            //first Pair
            int ffP = Integer.parseInt(firstP[0]);
            int sfP = Integer.parseInt(firstP[1]);
            //second Pair
            int fsP = Integer.parseInt(secondP[0]);
            int ssP = Integer.parseInt(secondP[1]);
        

            int lenghtFirst = create_list(ffP, sfP, firstPairList);
            int lenghtSecond = create_list(fsP, ssP, secondPairList);

            if(isIn(lenghtFirst, lenghtSecond, firstPairList, secondPairList)){
                score++;
                //System.out.println("Score + 1");
            }

            //System.out.println(score);
            if(overlaps(lenghtFirst, lenghtSecond, firstPairList, secondPairList)){
                scoreB++;
            }
            firstPairList.clear();
            secondPairList.clear();
        }
        System.out.println("Score part 1: " + score);
        System.out.println("Score part 2: " + scoreB);



        

    }

    public static int create_list(int startIndex, int endIndex, ArrayList<Integer> place){
        int lenght = 0;
        if(startIndex == endIndex){
            place.add(startIndex);
        }
        else{ 
            for(int i = startIndex; i <= endIndex; i++){
                place.add(i);
                lenght++;
            }
            //System.out.println(place);   
        }
        return lenght;
    }

    public static boolean isIn(int lenght1, int lenght2, ArrayList<Integer> firstList, ArrayList<Integer> secondList){
        boolean result = false;
        if(lenght1 > lenght2){
            for(int number : secondList){
                if(firstList.contains(number) == false){
                    result = false;
                    break;
                }
                else{
                    result = true;
                }
            }
        }
        else if(lenght2 > lenght1){
            for(int number : firstList){
                if(secondList.contains(number) == false){
                    result = false;
                    break;
                }
                else{
                    result = true;
                }
            }
        }
        else if (lenght1 == lenght2){
            for(int number : firstList){
                if(secondList.contains(number) == false){
                    result = false;
                    break;
                }
                else{
                    result = true;
                }
            }
            for(int number: secondList){
                if(firstList.contains(number) == false){
                    result = false;
                    break;
                }
                else{
                    result = true;
                }
            }
        }
        return result;
    }
//part 2
    public static boolean overlaps(int lenght1, int lenght2, ArrayList<Integer> list1, ArrayList<Integer> list2){
        boolean result = false;
        if(lenght1 > lenght2){
            for(int number : list2){
                if(list1.contains(number)){
                    result = true;
                    break;
                }
                else{
                    result = false;
                }
            }
        }
        else if(lenght2 > lenght1){
            for(int number : list1){
                if(list2.contains(number)){
                    result = true;
                    break;
                }
                else{
                    result = false;
                }
            }
        }
        else if (lenght1 == lenght2){
            for(int number : list1){
                if(list2.contains(number)){
                    result = true;
                    break;
                }
                else{
                    result = false;
                }
            }
            for(int number: list2){
                if(list1.contains(number)){
                    result = true;
                    break;
                }
                else{
                    result = false;
                }
            }
        }
        return result;
    }

}