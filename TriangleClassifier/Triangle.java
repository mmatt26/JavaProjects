package triangledemo;

import java.awt.geom.Point2D;
import java.lang.Math;

/**
 * Describes a triangle
 * @author Melva Matthews
 * @since Spring2015
 */
public class Triangle 
{
    /**
     * A vertex of the triangle.
     */
    private Point2D.Double vertexA;
    /**
     * A vertex of the triangle;
     */
    private Point2D.Double vertexB;
    /**
     * A vertex of the triangle.
     */
    private Point2D.Double vertexC;
    
    /**
     * Error/Tolerance value
     */
    private static double EPSILON = 1E-5;
    
    /**
     * Creates a triangle with vertices (0,0),
     * (1,0) and (0,1).
     */
    public Triangle()
    {
        vertexA = new Point2D.Double(0, 0);
        vertexB = new Point2D.Double(1, 0);
        vertexC = new Point2D.Double(0, 1);
    }
    
    /**
     * Create a triangle with the specified vertices.
     * @param v1 a vertex of the triangle
     * @param v2 a vertex of the triangle
     * @param v3 a vertex of the triangle
     */
    public Triangle(Point2D.Double v1, Point2D.Double v2, Point2D.Double v3)
    {
        if(Math.abs(((v1.y-v2.y)*(v2.x-v3.x)) - ((v2.y-v3.y)*(v1.x-v2.x)))<=EPSILON)
            throw new IllegalArgumentException("(" + v1.x + ", " + v1.y + "), (" + v2.x + ", " + v2.y + ") and (" + v3.x + ", " + v3.y + ") are collinear");
        vertexA = v1;
        vertexB = v2;
        vertexC = v3;
    }
    
    /**
     * Computes the distance between the specified points.
     * @param p1 a point
     * @param p2 a point
     * @return the Euclidean distance between two points
     */
    public static double distance(Point2D.Double p1, Point2D.Double p2)
    {
        double distance = Math.sqrt(Math.pow((p1.x-p2.x), 2) + Math.pow((p1.y-p2.y), 2));
        return distance;
    }
    
    /**
     * Determines whether this triangle is equilateral.
     * @return true if this triangle is equilateral; otherwise, false.
     */
    public boolean isEquilateral()
    {
        if(Math.abs(distance(vertexA, vertexB)-distance(vertexB, vertexC))<= EPSILON && Math.abs(distance(vertexA, vertexB)-distance(vertexA, vertexC)) <= EPSILON)
            return true;
        else
            return false;
    }
    
    /**
     * Determines whether this triangle is scalene.
     * @return true if this triangle is scalene; otherwise, false.
     */
    public boolean isScalene()
    {
        if(isIsosceles() == true)
            return false;
        else
            return true;
    }
    
    /**
     * Determines whether this triangle is isosceles.
     * @return true if this triangle is isosceles; otherwise, false.
     */
    public boolean isIsosceles()
    {
        if(isEquilateral() == true)
            return true;
        else if(Math.abs(distance(vertexA, vertexB)-distance(vertexB, vertexC))<=EPSILON || Math.abs(distance(vertexA, vertexC)-distance (vertexA, vertexB))<=EPSILON || Math.abs(distance(vertexB, vertexC)-distance(vertexA, vertexC))<=EPSILON)
            return true;
        else
            return false;
    }
    
    /**
     * Determines whether this triangle is acute.
     * @return true if this triangle is acute; otherwise, false.
     */
    public boolean isAcute()
    {
        double max = Math.max(Math.max(distance(vertexA, vertexB), distance(vertexA, vertexC)), distance(vertexB, vertexC));
        if(distance(vertexA, vertexB) == max && (max*max - (Math.pow(distance(vertexB, vertexC), 2) + Math.pow(distance(vertexA, vertexC), 2))) < -EPSILON)
            return true;
        else if(distance(vertexB, vertexC) == max && (max*max - (Math.pow(distance(vertexA, vertexB), 2) + Math.pow(distance(vertexA, vertexC), 2))) < -EPSILON)
            return true;

        else if(distance(vertexA, vertexC) == max && (max*max - (Math.pow(distance(vertexB, vertexC), 2) + Math.pow(distance(vertexA, vertexB), 2))) < -EPSILON)
            return true;
        else
            return false;
    }

    /**
     * Determines whether this triangle is obtuse.
     * @return true if this triangle is obtuse; otherwise, false.
     */
    public boolean isObtuse()
    {
        if(isAcute() == true)
            return false;
        else
        {
            double max = Math.max(Math.max(distance(vertexA, vertexB), distance(vertexA, vertexC)), distance(vertexB, vertexC));
            if(distance(vertexA, vertexB) == max && (max*max - (Math.pow(distance(vertexB, vertexC), 2) + Math.pow(distance(vertexA, vertexC), 2))) > EPSILON)
                return true;
            else if(distance(vertexB, vertexC) == max && (max*max - (Math.pow(distance(vertexA, vertexB), 2) + Math.pow(distance(vertexA, vertexC), 2))) > EPSILON)
                return true;

            else if(distance(vertexA, vertexC) == max && (max*max - (Math.pow(distance(vertexB, vertexC), 2) + Math.pow(distance(vertexA, vertexB), 2))) > EPSILON)
                return true;
            else
                return false;
        }
    }    
    
    /**
     * Determines whether this triangle is right.
     * @return true if this triangle is right; otherwise, false
     */
    public boolean isRight()
    {
        if(isAcute()==true)
            return false;
        if(isObtuse() == true)
            return false;
        else
            return true;
    }
    
    /**
     * Calculates the perimeter of a triangle.
     * @return the perimeter of this triangle.
     */
    public double perimeter()
    {
        return distance(vertexA, vertexB)+distance(vertexB, vertexC)+distance(vertexA, vertexC);
    }
    
    /**
     * Calculates the area of this triangle.
     * @return the area of a triangle.
     */
    public double area()
    {
        double s = perimeter()/2;
        return Math.sqrt(s*(s-distance(vertexA, vertexB))*(s-distance(vertexB, vertexC))*(s-distance(vertexA, vertexC)));
    }

    /**
     * Gives a string representing this triangle in the format
     * {(x1, y1), (x2, y2), (x3, y3)}.
     * @return a string representing this triangle as a set of three
     * points in the format{(x1, y1), (x2, y2), (x3, y3)}.
     */
    public String toString()
    {
        return ("{(" + vertexA.x + ", " + vertexA.y + "), (" + vertexB.x + ", " + vertexB.y +"), ("+vertexC.x + ", " + vertexC.y+")}");
    }

    /**
     * Gives the first vertex of this triangle.
     * @return a vertex of this triangle.
     */
    public Point2D.Double getVertexA() 
    {
        return vertexA;
    }

    /**
     * Gives the second vertex of this triangle.
     * @return the second vertex of this triangle
     */
    public Point2D.Double getVertexB() 
    {
        return vertexB;
    }

    /**
     * Gives the third vertex of this triangle.
     * @return the third vertex of this triangle
     */
    public Point2D.Double getVertexC() 
    {
        return vertexC;
    }
}
