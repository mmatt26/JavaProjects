package quadraticsolver;

import java.util.Scanner;
import java.lang.Math;

/**
 * The purpose of this program is to get the coefficients for the quadratic term, linear term, and constant term from the user, compute the discriminant, the roots, axis of symmetry, the vertex, the x-intercepts, and the y-intercept
 * @version 2
 * Course: CSC 1350
 * PAWS ID: mmatt26
 * project #: 2 
 * Instructor: Dr. Duncan
 */
public class QuadraticSolver 
{
    public static void main(String[] args) 
    {
        Scanner cin = new Scanner(System.in);
        System.out.print("Enter the coefficient of the quadratic term -> ");
        double quadraticTerm = cin.nextDouble();            
        System.out.print("Enter the coefficient of the linear term -> ");
        double linearTerm = cin.nextDouble();
        System.out.print("Enter the constant term -> ");
        double constant = cin.nextDouble();
        System.out.println(); 

        if (quadraticTerm == 0)
            System.out.println("The quadratic term must be non-zero.");
        else 
        {
        if (quadraticTerm == 1)
            System.out.print("For the quadratic equation x^2");
        else if (quadraticTerm == -1)
            System.out.printf("For the quadratic equation -x^2");
        else
            System.out.printf("For the quadratic equation %.5fx^2", quadraticTerm);

        if (linearTerm == 1)
            System.out.print("+x");
        else if (linearTerm == -1)
            System.out.print("-x");
        else if (linearTerm == 0)
            System.out.print("");
        else
            System.out.printf("%+.5fx", linearTerm);
        
        if (constant == 0)
            System.out.printf("=0%n");
        else
            System.out.printf("%+.5f=0 %n", constant);
        
        double discrim = Math.pow(linearTerm, 2) - 4*quadraticTerm*constant;
        double ratPart = -linearTerm/(2*quadraticTerm);
        System.out.printf("%nDiscriminant: %.5f %n", discrim);
        double axisSym = (-linearTerm/(2*quadraticTerm));
        double numVertex = -Math.pow(linearTerm, 2)/(4*quadraticTerm) + constant;

        if (discrim == 0)
        {
            System.out.printf("Roots: x = {%.5f} %n", ratPart);
            System.out.printf("Axis of Symmetry: x = %.5f %n", axisSym );
            System.out.printf("Vertex: (%.5f %.5f) %n", axisSym, numVertex);
            System.out.printf("x-intercepts: (%.5f, 0.00000) %n", ratPart);
        }
        else
        {
            double radPart = Math.sqrt(Math.abs(discrim))/Math.abs(2*quadraticTerm);
            if (discrim > 0)
            {
                if (ratPart != 0)
                    System.out.printf("Roots: x = {%.5f, %.5f} %n", ratPart+radPart,  ratPart-radPart);
                else
                    System.out.printf("Roots: x = {-%.5f, %.5f} %n", radPart, radPart);
                System.out.printf("Axis of Symmetry: x = %.5f %n", axisSym );
                System.out.printf("Vertex: (%.5f %.5f) %n", axisSym, numVertex);
                System.out.printf("x-intercepts: (%.5f, 0.00000) and (%.5f, 0.00000) %n", ratPart-radPart, ratPart+radPart);
            }
            else
            {
                if (ratPart != 0)
                    System.out.printf("Roots: x = {%.5f+%.5fi, %.5f-%.5fi} %n", ratPart, radPart, ratPart, radPart);
                else
                    System.out.printf("Roots: x = {%.5fi, -%.5fi} %n", radPart, radPart);
                System.out.printf("Axis of Symmetry: x = %.5f %n", axisSym );
                System.out.printf("Vertex: (%.5f %.5f) %n", axisSym, numVertex);
                System.out.printf("x-intercepts: none %n");
            }
        }
        System.out.printf("y-intercept: (0.00000, %.5f)%n", constant);
        if (quadraticTerm > 0)
            System.out.printf("Shape: Concave upward %n");
        else
            System.out.printf("Shape: Cocave downward %n");
        }
    }       
}
