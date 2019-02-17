package DZ2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        try (FileInputStream in = new FileInputStream("Files/dz2Text.txt")) {
            byte[] arr = new byte[(int)in.getChannel().size()];
            int x;

            System.out.println(in.getChannel().size());

            while ((x = in.read(arr)) != -1) {
                System.out.println(Arrays.toString(arr));
                System.out.print(new String(arr, 0, x));
            }
        }
    }
}
