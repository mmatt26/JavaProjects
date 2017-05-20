package car;

public class Car implements java.lang.Comparable<Car>
{

    private int year;
    private String make;
    private String model;

    public Car(int yr, String mk, String md) 
    {
        yr = this.year;
        mk = this.make;
        md = this.model;
    }

    Car() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getYear() 
    {
        return this.year;
    }

    public String getMake() 
    {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    @Override
    public int compareTo(Car c) {
        if (this.getMake().compareTo(c.getMake()) > 0) 
        {
            return 1;
        } else if (this.getMake().compareTo(c.getMake()) < 0) 
        {
            return -1;
        } else {
            if (this.getModel().compareTo(c.getModel()) > 0) 
            {
                return 1;
            } else if (this.getMake().compareTo(c.getModel()) < 0) 
            {
                return -1;
            } else {
                if (this.getYear() > c.year) 
                {
                    return 1;
                } else if (this.getYear() < c.year) 
                {
                    return -1;
                } else 
                {
                    return 0;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "[" + getMake() + ", " + getModel() + ", " + getYear() + "]";
    }

}
