import java.io.FileReader;
import java.util.Scanner;


public class Histogram {
    public static void main(String [] args){
        try{

            String name = getFileName();
            char[] word = new char[12];
            int[] wordcount = new int[12];
            read(word, wordcount, name);
            sort(word, wordcount);
            display(word, wordcount);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public static String getFileName(){
        try{
            Scanner word = new Scanner(System.in);
            System.out.print("Input filename : ");
            return word.nextLine();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return "";
    }

    public static void read(char[] letter, int[] letterCount, String filename){
        try{
            String arr;
            Scanner word = new Scanner(new FileReader(filename));

            char h = 'A';
            int i=0;
            while(i < 11)
            {
                letter[i] = h++;
                i++;
            }
            int a;
            while((word.hasNext()))
            {   //read lines from file
                arr= word.nextLine();
                a = arr.charAt(0) - 'A';
                letterCount[a]++;
            }
            //close scanner
            word.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }


    public static void sort(char[] letter, int[] letterCount){
        int num;
        int i = 0;
        char num2;
        while(i < 10)
        {
            int z = i +1;
            while(z < 11)
            {
                if(letterCount[i] == letterCount[z])
                {
                    if(letter[i] < letter[z])
                    {
                        num = letterCount[i];
                        letterCount[i] = letterCount[z];
                        letterCount[z] = num;
                        num2 = letter[i];
                        letter[i] = letter[z];
                        letter[z] = num2;
                    }
                }
                // Ok so I am getting duplicated code fragment error here but in class i have leaned that it will be fine.
                if(letterCount[i] < letterCount[z])
                {
                    num = letterCount[i];
                    letterCount[i] = letterCount[z];
                    letterCount[z] = num;
                    num2 = letter[i];
                    letter[i] = letter[z];
                    letter[z] = num2;
                }

                z++;
            }
            i++;
        }
    }


    public static void display(char[] letter, int[] letterCount){
        String sr;
        System.out.println("Char Occurrences");
        int r=10;
        while(r >= 0)
        {
            if(letterCount[r] != 0)
            {
                System.out.println("" + letter[r] + " " + letterCount[r]);
            }
            r--;
        }

        System.out.println("\n");
        System.out.println("=============================");

        int f;
        int arr;
        int i = 0;
        sr = "";

        while(i < 11 && letterCount[i] != 0)
        {
            f = letterCount[i];
            while(i < 11 && letterCount[i] == f)
            {
                sr = letter[i] + " " + sr;
                i++;
            }

            if(i == 11)
            {
                arr = 0;
            }
            else
                arr = letterCount[i];

            while(f > arr)
            {
                System.out.printf("|%5d|%21s%n", f, sr);
                f--;
            }
        }

        System.out.println("\n-----------------------------");
        System.out.println();

        sr = "";
        int b=0;
        while(b < 11)
        {

            sr = letter[b] + " " + sr;
            b++;
        }
        System.out.printf("%30s%n", sr);
    }
}
