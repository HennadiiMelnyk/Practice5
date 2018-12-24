package ua.nure.melnyk.Practice5;

public class Part3 {

    static class C {
        int x;
        int y;
    }

    public static void main(String[] args) {

        C c = new C();

        for (int i = 0; i < 10; i++) {
            new Thread() {
                public void run() {
                    System.out.println("unsynchronized");
                    System.out.println(c.x == c.y);
                    c.x++;
                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    c.y++;
                }

            }.start();
        }


        synchronized ("2-block") {
            C c2 = new C();
            for (int i = 0; i < 10; i++) {
                new Thread() {
                    public void run() {
                        System.out.println("Synchronized");
                        System.out.println(c2.x == c2.y);
                        c2.x++;
                        try {
                            sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        c2.y++;
                    }
                }.start();
            }
        }


    }
}




