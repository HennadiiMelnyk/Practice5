package ua.nure.melnyk.Practice5;

import java.io.*;
import java.util.Random;

public class Part4 {

    private File file;

    public void createMatrix() throws IOException {
        file = new File("part4.txt");
        FileWriter fw = new FileWriter(file);
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 20; j++) {
                fw.write(Integer.toString(random.nextInt(1000)) + " ");
            }
            fw.write(System.lineSeparator());
        }
        fw.flush();
        fw.close();
    }

    public int maxValue(int[][] array) throws IOException, InterruptedException {
        int[] maxValues = new int[4];
        for (int i = 0; i < 4; i++) {
            int finalI = i;
            Thread thread = new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < 4; j++) {
                        maxValues[j] = maxLine(finalI, array);
                    }
                }
            };
            thread.start();
            thread.join();
        }
        int result = 0;
        for (int i : maxValues) {
            if (result < i) {
                result = i;
            }
        }
        return result;
    }

    public int maxLine(int i, int[][] arr) {
        int result = 0;
        for (int j = 0; j<20; j++) {
            if (result < arr[i][j]) {
                result = arr[i][j];
            }
        }
        return result;
    }

    public int[][] readFile(File file) throws IOException {
        FileReader fr=new FileReader(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        int[][] arr = new int[4][20];
        for (int i = 0; i < 4; i++) {
            String[] buff = reader.readLine().split(" ");
            for (int j = 0; j < 20; j++) {
                arr[i][j] = Integer.parseInt(buff[j]);
            }
        }
        return arr;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Part4 part4 = new Part4();
        part4.createMatrix();
        System.out.println(part4.maxValue(part4.readFile(new File("part4.txt"))));
        System.out.println();
    }
}
