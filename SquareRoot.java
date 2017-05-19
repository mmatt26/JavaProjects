package squarerootaproximatior;
import java.util.Scanner;
import java.lang.Math;

/**
 * This program calculates the square root based on a number input by the user and then 
 * @author MelvaM
 * @since March 15, 2015
 * Course: CSC 1350
 * PAWS ID: mmatt26
 * project #: 3 
 * Instructor: Dr. Duncan
 */
public class SquareRootAproximatior 
{
    public static void main(String[] args) 
    {
        Scanner cin = new Scanner(System.in);
        System.out.print("Enter a number to find its square root -> ");
        double numInput = cin.nextDouble();
       
        if (numInput >= 1)
        {
            double low = 1;
            double high = numInput;
            System.out.printf("[%f, %f] %n", low, high);
            double midPoint = (low + high)/2;
            double midPointSqr = midPoint*midPoint;
            final double EPSILON = .0000000001;
            while(Math.abs(midPointSqr - numInput) >= EPSILON)
            {
                if (midPointSqr > numInput)
                {
                  high = midPoint;
                  midPoint = (low+high)/2;
                  midPointSqr = midPoint*midPoint;
                  System.out.printf("[%f, %f] %n", low, high);
                }
                else
                {
                    low = midPoint;
                    midPoint = (low+high)/2;
                    midPointSqr = midPoint*midPoint;
                    System.out.printf("[%f, %f] %n", low, high);
                }
            }
            System.out.printf("The square root of %f is %f%n", numInput, midPoint);
        }
        else if (numInput < 1 && numInput > 0)
        {
            double low = 0;
            double high = 1;
            System.out.printf("[%f, %f] %n", low, high);
            double midPoint = (low + high)/2;
            double midPointSqr = midPoint*midPoint;
            final double EPSILON = .0000000001;
            while(Math.abs(midPointSqr - numInput) >= EPSILON)
            {
                if (midPointSqr > numInput)
                {
                  high = midPoint;
                  midPoint = (low+high)/2;
                  midPointSqr = midPoint*midPoint;
                  System.out.printf("[%f, %f] %n", low, high);
                }
                else
                {
                    low = midPoint;
                    midPoint = (low+high)/2;
                    midPointSqr = midPoint*midPoint;
                    System.out.printf("[%f, %f] %n", low, high);
                }
            }
            System.out.printf("The square root of %f is %f%n", numInput, midPoint);
        }
        else
            System.out.printf("The square root of %f is NaN%n", numInput);
    }
}
