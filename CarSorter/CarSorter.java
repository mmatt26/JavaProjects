package car;

import java.io.*;
import java.io.PrintWriter;
import java.util.*;

public class CarSorter 
{

	public static void main(String args[])
        {
           try
        {
            
            Scanner keyBd = new Scanner(System.in);
            System.out.print("Enter the name of the input file -> ");
            Scanner file = new Scanner(new File(keyBd.next()));
            System.out.println();  
            ArrayList<Car> directory1 = new ArrayList<>();
                   while (file.hasNext())
                   {
                       directory1.add(new Car(keyBd.nextInt(), keyBd.next(), keyBd.nextLine()));
                   }  
            file.close();
            System.out.println("The Unsorted Array List of Cars");
            int i;
            for (i=0; i<directory1.size(); i++)
            {
                System.out.println(directory1.get(i));
            }
            System.out.println();
            Car[] directory2 = directory1.toArray(new Car[directory1.size()]);
            Arrays.sort(directory2);
            System.out.print("Enter the name of the first output file -> ");
            String outputFileName = keyBd.next();
            PrintWriter fileOut = new PrintWriter(new File(outputFileName));
            System.out.println("The Sorted Array List of Cars By Make-Model-Year");
            System.out.println("------------------------------------------------");
            for (i=0; i<directory1.size(); i++)
                System.out.println(directory1.get(i));
                    fileOut.println(directory1.get(i));
            System.out.println();
            Arrays.sort(directory2);
            System.out.print("Enter the name of the second output file -> ");
            outputFileName = keyBd.next();
            System.out.println("The Sorted Array List of Cars By Make-Model-Year");
            System.out.println("------------------------------------------------");
            for (i=0; i<directory2.length; i++)
                System.out.println(directory2[i]);
                    fileOut.println(directory2[i]);
            System.out.println();
            Arrays.sort(directory2);
            System.out.print("Enter the name of the third output file -> ");
            outputFileName = keyBd.next();
            System.out.println("The Sorted Array List of Cars By Year-Make-Model");
            System.out.println("------------------------------------------------");
            for (i=0; i<directory2.length; i++)
                System.out.println(directory2[i]);
                    fileOut.println(directory2[i]);
            System.out.println();
            Arrays.sort(directory2);
            System.out.print("Enter the name of the fourth output file -> ");
            outputFileName = keyBd.next();
            System.out.println("The Sorted Array List of Cars By Year-Make-Model");
            System.out.println("------------------------------------------------");
            for (i=0; i<directory1.size(); i++)
                System.out.println(directory2[i]);
                    fileOut.println(directory2[i]);
            System.out.println();
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e);
        }
    }
}
