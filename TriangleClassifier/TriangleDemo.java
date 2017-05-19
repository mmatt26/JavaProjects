package triangledemo;

import java.awt.geom.Point2D;

/**
 * This program tests the Triangle class
 * CSC 1350 Programming Project # 5
 */
public class TriangleDemo
{
    public static void main(String[] args) 
    {
        Triangle triangle = new Triangle(new Point2D.Double(10.0 , 20.0),
                                 new Point2D.Double(10.0,45.0),
                                 new Point2D.Double(35.0, 20.0));
        System.out.printf("T = %s%n", triangle.toString());
        System.out.printf("|P1P2| =           %-12.5f%n", triangle.distance(triangle.getVertexA(), triangle.getVertexB()));
        System.out.printf("|P1P3| =           %-12.5f%n", triangle.distance(triangle.getVertexA(), triangle.getVertexC()));
        System.out.printf("|P2P3| =           %-12.5f%n", triangle.distance(triangle.getVertexB(), triangle.getVertexC()));
        System.out.printf("area:              %-12.5f%n", triangle.area());
        System.out.printf("preimeter:         %-12.5f%n%n", triangle.perimeter());
        
        System.out.println("Classification by the Length of the Sides:");
        System.out.println("Equilateral:      " + triangle.isEquilateral());
        System.out.println("Isosceles:        " + triangle.isIsosceles());
        System.out.println("Scalene:          " + triangle.isScalene());
     
        System.out.printf("%nClassification by the Interior Angles: %n");
        System.out.println("Acute:            " + triangle.isAcute());
        System.out.println("Obtuse:           " + triangle.isObtuse());
        System.out.println("Right:            " + triangle.isRight());
    }    
}
