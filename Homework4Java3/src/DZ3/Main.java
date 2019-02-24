package DZ3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList <InputStream> al = new ArrayList <>();
        al.add(new FileInputStream("Files/dz3Text1.txt"));
        al.add(new FileInputStream("Files/dz3Text2.txt"));
        al.add(new FileInputStream("Files/dz3Text3.txt"));
        al.add(new FileInputStream("Files/dz3Text4.txt"));
        al.add(new FileInputStream("Files/dz3Text5.txt"));
        SequenceInputStream in = new SequenceInputStream(Collections.enumeration(al));
        FileOutputStream out = new FileOutputStream("Files/merge.txt");
        int x;
        while ((x = in.read()) != -1) {
            out.write(x);
        }
        in.close();
        out.close();
    }
}
