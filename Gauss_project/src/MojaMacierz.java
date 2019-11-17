//Anna Konstantynowicz, gr. 3
//Marcin Szczepaniak, gr. 3


import static java.lang.Math.*;

import java.io.IOException;

public class MojaMacierz<T extends Number> {
    static int N = 4;
    static GenericMath gm = new GenericMath();

    static <T extends Number> void redukujMacierz(T[][] A, T[] B, int ii, int jj) {
        T wspolczynnik;
        for (int k = ii + 1; k < N; k++) {
            wspolczynnik = (T) gm.divide(A[k][jj], A[ii][jj]);
            for (int l = jj; l < N; l++) {
                T tmp = A[k][l];
                A[k][l] = (T) gm.subtract(tmp, gm.multiply(wspolczynnik, A[ii][l]));
            }
            B[k] = (T) gm.subtract(B[k], gm.multiply(wspolczynnik, B[ii]));
        }
    }

    static <T extends Number> T[] G(T[][] A, T[] B) {
        int j;
        for (int i = 0; i < N; i++) {
            j = i;
            redukujMacierz(A, B, i, j);
        }
        return dajWynik(A, B);
    }

    static <T extends Number> T[] PG(T[][] A, T[] B) {
        T max;
        int p, j;
        for (int i = 0; i < N; i++) {
            j = i;
            max = (T) gm.abs(A[i][j]);
            p = i;
            for (int k = i + 1; k < N; k++) {
                if (gm.isGreaterThan(gm.abs(A[k][j]), max)) {
                    max = (T) gm.abs(A[k][j]);
                    p = k;
                }
            }
            if (A[i][j] != max) {
                System.out.println("wiekszy");
                for (int l = 0; l < N; l++) {
                    T tmp = A[i][l];
                    A[i][l] = A[p][l];
                    A[p][l] = tmp;
                }
                T tmp = B[i];
                B[i] = B[p];
                B[p] = tmp;
            }
            redukujMacierz(A, B, i, j);
        }
        return dajWynik(A, B);
    }

    static <T extends Number> T[] FG(T[][] A, T[] B) {
        int[] Q = new int[N];
        for (int i = 0; i < N; i++) {
            Q[i] = i;
        }
        T max;
        int maxI, maxJ, j;
        for (int i = 0; i < N; i++) {
            j = i;
            max = (T) gm.abs((A[i][j]));
            maxI = i;
            maxJ = j;
            for (int k = i; k < N; k++) {
                for (int l = j; l < N; l++) {
                    if (gm.isGreaterThan(gm.abs(A[k][l]), max)) {
                        max = (T) gm.abs((A[k][l]));
                        maxI = k;
                        maxJ = l;
                    }
                }
            }
            if (i != maxI) {
                for (int l = 0; l < N; l++) {
                    T tmp = A[i][l];
                    A[i][l] = A[maxI][l];
                    A[maxI][l] = tmp;
                }
                T tmp = B[i];
                B[i] = B[maxI];
                B[maxI] = tmp;
            }
            if (j != maxJ) {
                int tmp = Q[j];
                Q[j] = Q[maxJ];
                Q[maxJ] = tmp;
                for (int l = 0; l < N; l++) {
                    T tmpr = A[l][j];
                    A[l][j] = A[l][maxJ];
                    A[l][maxJ] = tmpr;
                }
            }
            redukujMacierz(A, B, i, j);
        }
        return dajWynik(A, B, Q);
    }

    static <T> void drukujMacierz(T[][] A, T[] B) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.format("%20.16f", A[i][j]);
                System.out.print(" ");
            }
            System.out.print("| " + B[i]);
            System.out.println();
        }
        System.out.println();
    }

    static <T extends Number> T[] dajWynik(T[][] A, T[] B) {
        T[] wynik = (T[]) new Number[N];
        T[] tmp = (T[]) new Number[N - 1];
        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j > i; j--) {
                tmp[j - 1] = (T) gm.multiply(A[i][j], wynik[j]);
                B[i] = (T) gm.subtract(B[i], tmp[j - 1]);
            }
            wynik[i] = (T) gm.divide(B[i], A[i][i]);
        }
        return wynik;
    }

    static <T extends Number> T[] dajWynik(T[][] A, T[] B, int[] Q) {
        T[] wyniktmp = dajWynik(A, B);
        T[] wynik = (T[]) new Number[N];
        for (int i = 0; i < N; i++) {
            wynik[Q[i]] = wyniktmp[i];
        }
        return wynik;
    }

    static <T extends Number> T[] odejmijWektory(T[] w1, T[] w2) {
        T[] wektor = (T[]) new Number[N];
        for (int i = 0; i < N; i++) {
            wektor[i] = (T) gm.subtract(w1[i], w2[i]);
        }
        return wektor;
    }

    static <T extends Number> T obliczNorme(T[] wektor) {
        T norma = (T) gm.getZero(wektor);
        for (int i = 0; i < N; i++) {
            norma = (T) gm.add(norma, wektor[i]);
        }
        return (T) gm.abs(norma);
    }

    public static void main(String[] args) throws IOException {
        Macierze m1 = new Macierze(N);
        System.out.println(obliczNorme(odejmijWektory(FG(m1.macierzF, m1.wektorF), m1.wektorF)));
        System.out.println(obliczNorme(odejmijWektory(FG(m1.macierzD, m1.wektorD), m1.wektorD)));
        System.out.println(obliczNorme(odejmijWektory(FG(m1.macierzU, m1.wektorU), m1.wektorU)));
    }
}
