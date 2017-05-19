package carsorter;

import java.util.Comparator;

public class CarComparator  implements Comparator<Car>
{
    
    @Override
    public int compare(Car c1, Car c2)
    {
        if (c1.getMake().compareTo(c2.getMake())<0)
            return -1;
        else if (c1.getMake().compareTo(c2.getMake())>0)
            return 1;
        else if (c1.getModel().compareTo(c2.getModel())<0)
            return -1;
        else if (c1.getModel().compareTo(c2.getModel())>0)
            return 1;
        if (c1.getYear()<c2.getYear())
            return -1;
        else if (c1.getYear()>c2.getYear())
            return 1;
        else
            return 0;
    }
}
