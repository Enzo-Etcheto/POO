package TP8_grupo13;

class RunnableThread implements Runnable {
	private String nombre;

    public RunnableThread(String nombre) {
        this.nombre = nombre;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i + " " + nombre);
            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {}
        }
        System.out.println("¡HECHO! " + nombre);
    }
}
