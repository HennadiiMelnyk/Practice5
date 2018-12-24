package ua.nure.melnyk.Practice5;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Part2 {
    public static void main(String[] args) throws InterruptedException {
        int[] time = {1500, 1400,2500};
        String[] message = {"First", "Second","Thrid"};
        Thread t = new Spam(time, message).process();
        InputStream stdIn = System.in;
        ByteArrayInputStream bais = new ByteArrayInputStream(System.lineSeparator().getBytes());
        bais.skip(System.lineSeparator().length());
        System.setIn(bais);
        Thread.sleep(3000);
        System.out.println("send enter to standard input");
        bais.reset();
        t.join();
        System.setIn(stdIn);
    }
}




