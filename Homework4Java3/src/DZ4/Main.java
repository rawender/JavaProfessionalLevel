package DZ4;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        long a = System.currentTimeMillis();
        final int PAGE_SIZE = 1800;
        Scanner sc = new Scanner(System.in);
        RandomAccessFile raf = new RandomAccessFile("Files/dz4Text.txt","r");
        System.out.println(System.currentTimeMillis() - a);
        while (true) {
            System.out.println("Введите страницу: ");
            long b = System.currentTimeMillis();
            int p = sc.nextInt() - 1;
            if (p < 0) {
                break;
            } else {
                raf.seek(p * PAGE_SIZE);
                byte[] page = new byte[PAGE_SIZE];
                raf.read(page);
                System.out.println(new String(page));
                System.out.println(System.currentTimeMillis() - b);
            }
        }
        raf.close();
    }
}
