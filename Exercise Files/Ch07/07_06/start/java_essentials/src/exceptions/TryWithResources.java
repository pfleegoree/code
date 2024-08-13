package exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TryWithResources {

    public static void main(String[] args) {
        File inputFile = new File("files/numbers.txt");
        File outputFile = new File("files/output.txt");

        try{

            while(fileReader.hasNext()){
                System.out.println(fileReader.nextDouble());
            }
        }catch(FileNotFoundException | InputMismatchException e){
            e.printStackTrace();
        }
    }
}