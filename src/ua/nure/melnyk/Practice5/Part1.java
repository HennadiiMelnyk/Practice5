package ua.nure.melnyk.Practice5;

public class Part1 extends Thread implements Runnable {
    public Part1() {
        {

        }

    }

    public static void main(String[] argv) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    for (int i = 0; i < 6; i++) {

                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(500);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }


        }).start();

        new Thread() {
            public void run() {
                try {

                    for (int i = 0; i < 6; i++) {

                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(500);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }.start();
    }


}


