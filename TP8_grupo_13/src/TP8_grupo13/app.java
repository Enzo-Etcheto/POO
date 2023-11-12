package TP8_grupo13;

class app {
    public static void main(String[] args) {
        int[][] matrizA = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] matrizB = { { 9, 8, 7 }, { 6, 5, 4 }, { 3, 2, 1 } };
        int[][] matrizResultado = new int[3][3];

        int hilos = 3;
        int filasPorHilo = matrizA.length / hilos;

        MultiplicadorMatrices[] multiplicadores = new MultiplicadorMatrices[hilos];
        Thread[] hilosArray = new Thread[hilos];

        for (int i = 0; i < hilos; i++) {
            int filaInicio = i * filasPorHilo;
            int filaFin = (i == hilos - 1) ? matrizA.length : (i + 1) * filasPorHilo;
            multiplicadores[i] = new MultiplicadorMatrices(matrizA, matrizB, matrizResultado, filaInicio, filaFin);
            hilosArray[i] = new Thread(multiplicadores[i]);
            hilosArray[i].start();
        }

        for (Thread hilo : hilosArray) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int[] fila : matrizResultado) {
            for (int num : fila) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

