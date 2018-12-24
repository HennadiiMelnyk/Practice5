package ua.nure.melnyk.Practice5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class Part5 extends Thread {
    private RandomAccessFile raf;
    private int count;
    private static final int NUMBER_OF_THREADS = 10;

    public Part5() throws FileNotFoundException {
        raf = new RandomAccessFile("part5.txt", "rw");
    }

    public void run() {
        try {
            raf.seek((count++) * 10);
            for (int j = 0; j < 20; j++) {
                raf.write(count - 1);
                sleep(1);
            }
            raf.writeUTF(System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            threads.add(new Part5());
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        sleep(4000);


    }
}

