package TP8_grupo13;

class ThreadSimple extends Thread {
    public ThreadSimple(String str) {
        super(str);
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i + " " + getName());
            try {
                sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
            }
        }
        System.out.println("HECHO! " + getName());
    }
}
