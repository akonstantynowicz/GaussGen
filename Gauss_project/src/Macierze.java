//Marcin Szczepaniak, gr. 3
//Anna Konstantynowicz gr. 3

import java.util.Random;

public class Macierze {

    public int N;

    public Float[][] macierzF;
    public Double[][] macierzD;
    public Ulamek[][] macierzU;

    public float[] wektorXF;
    public double[] wektorXD;
    public Ulamek[] wektorXU;

    public Float[] wektorF;
    public Double[] wektorD;
    public Ulamek[] wektorU;

    public Macierze(int N) {
        this.N = N;
        macierzF = new Float[N][N];
        macierzD = new Double[N][N];
        macierzU = new Ulamek[N][N];

        wektorXF = new float[N];
        wektorXD = new double[N];
        wektorXU = new Ulamek[N];

        wektorF = new Float[N];
        wektorD = new Double[N];
        wektorU = new Ulamek[N];

        losujMacierz();
        losujWektorX();
        obliczWektor();
    }

    static int losujR(){
        Random ran = new Random();
        int r = ran.nextInt(131071)-65536;
        return r;
    }

    public void losujMacierz() {
        int r;
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                r = losujR();
                macierzF[i][
                        j] = (float) r/65536;
                macierzD[i][j] = (double) r/65536;
                macierzU[i][j] = new Ulamek((double) r/65536);
            }
        }
    }

    public void losujWektorX() {
        int r;
        for (int i=0;i<N;i++){
            r = losujR();
            wektorXF[i]= (float) r/65536;
            wektorXD[i]= (double) r/65536;
            wektorXU[i]= new Ulamek((double) r/65536);
        }
    }

    public void obliczWektor(){
        zerujWektor();
        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++){
                wektorF[i] = wektorF[i] + macierzF[i][j]*wektorXF[j];
                wektorD[i] = wektorD[i] + macierzD[i][j]*wektorXD[j];
                wektorU[i] = wektorU[i].add(macierzU[i][j].multiply(wektorXU[j]));
            }
        }
    }

    public void zerujWektor(){
        for (int i=0;i<N;i++) {
            wektorF[i]= Float.valueOf(0);
            wektorD[i]= Double.valueOf(0);
            wektorU[i]=new Ulamek((double) 0);
        }
    }

    public void kopiujMacierz(Macierze m) {
        for (int i=0;i<N;i++) {
            for (int j = 0; j < N; j++) {
                this.macierzF[i][j] = m.macierzF[i][j];
                this.macierzD[i][j] = m.macierzD[i][j];
                this.macierzU[i][j] = m.macierzU[i][j];

                this.wektorXF[i] = m.wektorXF[i];
                this.wektorXD[i] = m.wektorXD[i];
                this.wektorXU[i] = m.wektorXU[i];

                this.wektorF[i] = m.wektorF[i];
                this.wektorD[i] = m.wektorD[i];
                this.wektorU[i] = m.wektorU[i];
            }
        }
    }
}
