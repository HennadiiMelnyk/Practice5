package ua.nure.melnyk.Practice5;

import java.io.IOException;
import java.util.Scanner;


public class Spam extends Thread {


    private String[] message;
    private int[] time;

    public Spam(int[] time, String[] message) {
        this.time = time;
        this.message = message;

    }

    public Thread process() {

        Thread child = new Thread() {
            public void run() {
                byte[] buffer = new byte[10];
                int count;
                while (!isInterrupted()) {
                    try {
                        do {
                            while ((count = System.in.read(buffer)) == -1) {
                                for (int i = 0; i < time.length; i++) {
                                    try {
                                        System.out.println(message[i]);
                                        Thread.sleep(time[i]);
                                    } catch (InterruptedException ex) {
                                        this.interrupt();
                                        break;
                                    }
                                }
                            }
                        } while (!System.lineSeparator().equals(
                                new String(buffer, 0, count)));
                    } catch (IOException ex) {
                        System.err.println(ex);
                    }
                    this.interrupt();
                }
            }
        };
        child.start();
        return child;
    }
}





