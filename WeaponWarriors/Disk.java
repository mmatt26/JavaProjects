package weaponswarriors;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Disk implements DiskI{

    @Override
    public WarriorI loadWarrior(File f) throws IOException {
        FileReader fr = new FileReader(f);
        Scanner scan = new Scanner(fr);
        Warrior w = new Warrior();
        w.initFromString(scan.nextLine());
        return w;
    }

    @Override
    public File saveWarrior(WarriorI w) throws IOException {
        File file = new File("warrior" + w.getName() + ".txt");
        FileWriter fw = new FileWriter(file);    
        fw.write(w.toString() + "\n");
        fw.close();
        return file;
    }
}
