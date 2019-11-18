import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Math.*;

public class Testy {
    public static void H1() throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("gaussWynikiH1_2.txt"));

        for (int i = 2; i <= 500; i++) {

            MojaMacierz.N = i;
            int N = MojaMacierz.N;

            Macierze m1 = new Macierze(N);
            Macierze m2 = new Macierze(N);
            Macierze m3 = new Macierze(N);

            m2.kopiujMacierz(m1);
            m3.kopiujMacierz(m1);

            System.out.println("N = " + N);
            String dataLine = N + " / ";

            //G F
            long start = System.nanoTime();
            MojaMacierz.G(m1.macierzF, m1.wektorF);
            long elapsedTime = System.nanoTime() - start;
            dataLine = dataLine + (double) elapsedTime / 1000000000 + " / ";
            System.out.println((double) elapsedTime / 1000000000);

            //G D
            start = System.nanoTime();
            MojaMacierz.G(m1.macierzD, m1.wektorD);
            elapsedTime = System.nanoTime() - start;
            dataLine = dataLine + (double) elapsedTime / 1000000000 + " / ";
            System.out.println((double) elapsedTime / 1000000000);

            //G U
//            start = System.nanoTime();
//            MojaMacierz.G(m1.macierzU, m1.wektorU);
//            elapsedTime = System.nanoTime() - start;
//            dataLine = dataLine + (double) elapsedTime / 1000000000 + " / ";
//            System.out.println((double) elapsedTime / 1000000000);

            //PG F
            start = System.nanoTime();
            MojaMacierz.PG(m2.macierzF, m2.wektorF);
            elapsedTime = System.nanoTime() - start;
            dataLine = dataLine + (double) elapsedTime / 1000000000 + " / ";
            System.out.println((double) elapsedTime / 1000000000);

            //PG D
            start = System.nanoTime();
            MojaMacierz.PG(m2.macierzD, m2.wektorD);
            elapsedTime = System.nanoTime() - start;
            dataLine = dataLine + (double) elapsedTime / 1000000000 + " / ";
            System.out.println((double) elapsedTime / 1000000000);

            //PG U
//            start = System.nanoTime();
//            MojaMacierz.PG(m2.macierzU, m2.wektorU);
//            elapsedTime = System.nanoTime() - start;
//            dataLine = dataLine + (double) elapsedTime / 1000000000 + " / ";
//            System.out.println((double) elapsedTime / 1000000000);

            //FG F
            start = System.nanoTime();
            MojaMacierz.FG(m3.macierzF, m3.wektorF);
            elapsedTime = System.nanoTime() - start;
            dataLine = dataLine + (double) elapsedTime / 1000000000 + " / ";
            System.out.println((double) elapsedTime / 1000000000);

            //FG D
            start = System.nanoTime();
            MojaMacierz.FG(m3.macierzD, m3.wektorD);
            elapsedTime = System.nanoTime() - start;
            dataLine = dataLine + (double) elapsedTime / 1000000000 + " / ";
            System.out.println((double) elapsedTime / 1000000000);

            //FG U
//            start = System.nanoTime();
//            MojaMacierz.FG(m3.macierzU, m3.wektorU);
//            elapsedTime = System.nanoTime() - start;
//            dataLine = dataLine + (double) elapsedTime / 1000000000;
//            System.out.println((double) elapsedTime / 1000000000);

            writer.write(dataLine);
            writer.write("\n");
        }


        writer.close();
    }

    public static void E1() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("gaussWynikiE1.txt"));

        MojaMacierz.N = 500;
        int N = MojaMacierz.N;

        for (int i = 0; i < 100; i++) {
            Macierze m1 = new Macierze(N);
            Macierze m2 = new Macierze(N);
            Macierze m3 = new Macierze(N);

            m2.kopiujMacierz(m1);
            m3.kopiujMacierz(m1);

            System.out.println("N = " + N);
            String dataLine = N + " / ";

            //G F
            long start = System.nanoTime();
            MojaMacierz.G(m1.macierzF, m1.wektorF);
            long elapsedTime = System.nanoTime() - start;
            dataLine = dataLine + (double) elapsedTime / 1000000000 + " / ";
            System.out.println((double) elapsedTime / 1000000000);

            //G D
            start = System.nanoTime();
            MojaMacierz.G(m1.macierzD, m1.wektorD);
            elapsedTime = System.nanoTime() - start;
            dataLine = dataLine + (double) elapsedTime / 1000000000 + " / ";
            System.out.println((double) elapsedTime / 1000000000);

            //G U
//        start = System.nanoTime();
//        MojaMacierz.G(m1.macierzU, m1.wektorU);
//        elapsedTime = System.nanoTime() - start;
//        dataLine = dataLine + (double) elapsedTime / 1000000000 + " / ";
//        System.out.println((double) elapsedTime / 1000000000);

            //PG F
            start = System.nanoTime();
            MojaMacierz.PG(m2.macierzF, m2.wektorF);
            elapsedTime = System.nanoTime() - start;
            dataLine = dataLine + (double) elapsedTime / 1000000000 + " / ";
            System.out.println((double) elapsedTime / 1000000000);

            //PG D
            start = System.nanoTime();
            MojaMacierz.PG(m2.macierzD, m2.wektorD);
            elapsedTime = System.nanoTime() - start;
            dataLine = dataLine + (double) elapsedTime / 1000000000 + " / ";
            System.out.println((double) elapsedTime / 1000000000);

            //PG U
//        start = System.nanoTime();
//        MojaMacierz.PG(m2.macierzU, m2.wektorU);
//        elapsedTime = System.nanoTime() - start;
//        dataLine = dataLine + (double) elapsedTime / 1000000000 + " / ";
//        System.out.println((double) elapsedTime / 1000000000);

            //FG F
            start = System.nanoTime();
            MojaMacierz.FG(m3.macierzF, m3.wektorF);
            elapsedTime = System.nanoTime() - start;
            dataLine = dataLine + (double) elapsedTime / 1000000000 + " / ";
            System.out.println((double) elapsedTime / 1000000000);

            //FG D
            start = System.nanoTime();
            MojaMacierz.FG(m3.macierzD, m3.wektorD);
            elapsedTime = System.nanoTime() - start;
            dataLine = dataLine + (double) elapsedTime / 1000000000 + " / ";
            System.out.println((double) elapsedTime / 1000000000);

            //FG U
//        start = System.nanoTime();
//        MojaMacierz.FG(m3.macierzU, m3.wektorU);
//        elapsedTime = System.nanoTime() - start;
//        dataLine = dataLine + (double) elapsedTime / 1000000000;
//        System.out.println((double) elapsedTime / 1000000000);

            writer.write(dataLine);
            writer.write("\n");
        }


        writer.close();
    }
    public static void H2() throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("gaussWynikiH2G.txt"));
        BufferedWriter writer1 = new BufferedWriter(new FileWriter("gaussWynikiH2PG.txt"));
        BufferedWriter writer2 = new BufferedWriter(new FileWriter("gaussWynikiH2FG.txt"));

        MojaMacierz.N = 20;
        int N = MojaMacierz.N;
        double dataLine;
        Macierze m1 = new Macierze(N);
        Macierze m2 = new Macierze(N);
        Macierze m3 = new Macierze(N);

        m2.kopiujMacierz(m1);
        m3.kopiujMacierz(m1);

        for (int i=0;i<100000;i++){
            dataLine = MojaMacierz.obliczNorme(MojaMacierz.odejmijWektory(MojaMacierz.G(m1.macierzD, m1.wektorD), m1.wektorXD));
            writer.write(String.valueOf(dataLine));
            writer.write("\n");
            dataLine = MojaMacierz.obliczNorme(MojaMacierz.odejmijWektory(MojaMacierz.PG(m2.macierzD, m2.wektorD), m2.wektorXD));
            writer1.write(String.valueOf(dataLine));
            writer1.write("\n");
            dataLine = MojaMacierz.obliczNorme(MojaMacierz.odejmijWektory(MojaMacierz.FG(m3.macierzD, m3.wektorD), m3.wektorXD));
            writer2.write(String.valueOf(dataLine));
            writer2.write("\n");

            m1.losujMacierz();
            m1.losujWektorX();
            m1.obliczWektor();
            m2.kopiujMacierz(m1);
            m3.kopiujMacierz(m1);
        }
        writer.close();
        writer1.close();
        writer2.close();
    }

    public static void H3() throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("gaussWynikiH3.txt"));

        String dataLine = "";

        for (int i = 3; i < 20; i++) {

            MojaMacierz.N = i;
            int N = MojaMacierz.N;

            System.out.println();
            System.out.println(N);

            for (int j=0; j < 100;j++) {
                System.out.print(".");

                Macierze m1 = new Macierze(N);
                Macierze m2 = new Macierze(N);
                Macierze m3 = new Macierze(N);

                m2.kopiujMacierz(m1);
                m3.kopiujMacierz(m1);

                MojaMacierz.G(m1.macierzU, m1.wektorU);
                MojaMacierz.PG(m2.macierzU, m2.wektorU);

                dataLine = dataLine + N + " / ";

                dataLine = dataLine + MojaMacierz.obliczNorme(m1.wektorXU).subtract(
                        MojaMacierz.obliczNorme(MojaMacierz.dajWynik(m1.macierzU, m1.wektorU))
                ).abs().divide(MojaMacierz.obliczNorme(m1.wektorXU)) + " / ";

                dataLine = dataLine + MojaMacierz.obliczNorme(m1.wektorXU).subtract(
                        MojaMacierz.obliczNorme(MojaMacierz.dajWynik(m2.macierzU, m2.wektorU))
                ).abs().divide(MojaMacierz.obliczNorme(m2.wektorXU)) + " / ";

                dataLine = dataLine + MojaMacierz.obliczNorme(m3.wektorXU).subtract(
                        MojaMacierz.obliczNorme(MojaMacierz.FG(m3.macierzU, m3.wektorU))
                ).abs().divide(MojaMacierz.obliczNorme(m3.wektorXU));

                dataLine = dataLine + "\n";
                writer.write(dataLine);
                dataLine = "";

            }

        }

    }
    public static void Q1() throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("gaussWynikiQ1G.txt"));
        BufferedWriter writer1 = new BufferedWriter(new FileWriter("gaussWynikiQ1FG.txt"));
        double sredniBladG, sredniBladFG;

        int N;
        for (int i=5; i<100; i++){
            MojaMacierz.N = i;
            N = MojaMacierz.N;
            Macierze m1 = new Macierze(N);
            Macierze m2 = new Macierze(N);
            m2.kopiujMacierz(m1);
            sredniBladG=0;
            sredniBladFG=0;
            for(int j=0;j<100;j++){

                sredniBladG = sredniBladG + MojaMacierz.obliczNorme(MojaMacierz.odejmijWektory(MojaMacierz.G(m1.macierzD, m1.wektorD), m1.wektorXD));
                sredniBladFG = sredniBladFG + MojaMacierz.obliczNorme(MojaMacierz.odejmijWektory(MojaMacierz.FG(m2.macierzD, m2.wektorD), m2.wektorXD));

                m1.losujMacierz();
                m1.losujWektorX();
                m1.obliczWektor();
                m2.kopiujMacierz(m1);
            }
            writer.write(i + " " + String.valueOf(sredniBladG/100));
            writer.write("\n");

            writer1.write(i + " " + String.valueOf(sredniBladFG/100));
            writer1.write("\n");
        }
        writer.close();
        writer1.close();
    }

    public static void Q2() throws IOException {
        BufferedWriter writer1 = new BufferedWriter(new FileWriter("gaussWynikiQ2TF.txt"));
        BufferedWriter writer2 = new BufferedWriter(new FileWriter("gaussWynikiQ2TD.txt"));
        BufferedWriter writer3 = new BufferedWriter(new FileWriter("gaussWynikiQ2TU.txt"));
        long start,elapsedTime;
        String dataLine;
        int N;
        for (int i=5; i<100; i++){
            MojaMacierz.N = i;
            N = MojaMacierz.N;
            Macierze m1 = new Macierze(N);

            start = System.nanoTime();
            MojaMacierz.PG(m1.macierzF, m1.wektorF);
            elapsedTime = System.nanoTime() - start;
            dataLine = String.valueOf((double) elapsedTime/1000000000);
            writer1.write(i + " " + dataLine);
            writer1.write("\n");

            start = System.nanoTime();
            MojaMacierz.PG(m1.macierzD, m1.wektorD);
            elapsedTime = System.nanoTime() - start;
            dataLine = String.valueOf((double) elapsedTime/1000000000);
            writer2.write(i + " " + dataLine);
            writer2.write("\n");

            if(i<36){
                start = System.nanoTime();
                MojaMacierz.PG(m1.macierzU, m1.wektorU);
                elapsedTime = System.nanoTime() - start;
                dataLine = String.valueOf((double) elapsedTime/1000000000);
                writer3.write(i + " " + dataLine);
                writer3.write("\n");
            }

        }
        writer1.close();
        writer2.close();
        writer3.close();

    }
}
