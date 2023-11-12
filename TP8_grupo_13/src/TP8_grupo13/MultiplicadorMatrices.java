package TP8_grupo13;

class MultiplicadorMatrices extends Thread {
    private int[][] matrizA;
    private int[][] matrizB;
    private int[][] matrizResultado;
    private int filaInicio;
    private int filaFin;

    public MultiplicadorMatrices(int[][] matrizA, int[][] matrizB, int[][] matrizResultado, int filaInicio, int filaFin) {
        this.matrizA = matrizA;
        this.matrizB = matrizB;
        this.matrizResultado = matrizResultado;
        this.filaInicio = filaInicio;
        this.filaFin = filaFin;
    }

    public void run() {
        for (int i = filaInicio; i < filaFin; i++) {
            for (int j = 0; j < matrizB[0].length; j++) {
                for (int k = 0; k < matrizB.length; k++) {
                    matrizResultado[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }
    }
}

