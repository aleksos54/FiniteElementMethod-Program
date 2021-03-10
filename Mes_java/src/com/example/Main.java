package com.example;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        Global_Data global_data = new Global_Data();
        KwadraturyGaussa K = new KwadraturyGaussa();
        SOE soe = new SOE();

        List<Node> ND = new ArrayList<>();
        List<Element> Elements = new ArrayList<>();


        przypisanie_wezlow(global_data, ND);
        przypisanie_elementow(global_data, Elements);

        soe.HG=new double[global_data.nN][global_data.nN];
        soe.CG=new double[global_data.nN][global_data.nN];
        soe.PG=new double[global_data.nN];

        int nt= global_data.czas_symulacji/global_data.czas_kroku;

        for(int n=0; n<nt; n++) {
            System.out.println("Iteracja " +n);

            //ZEROWANIE TABLIC GLOBALNYCH
            for(int i = 0; i< global_data.nN; i++){
                for(int j = 0; j< global_data.nN; j++){
                    soe.HG[i][j] = 0;
                    soe.CG[i][j] = 0;
                    soe.PG[i] = 0;
                }
            }

            //ZEROWANIE TABLIC LOKALNYCH
            for (int elem = 0; elem < global_data.nE; elem++) {
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        Elements.get(elem).HBC[i][j] = 0;
                        Elements.get(elem).Hl[i][j] = 0;
                        Elements.get(elem).Cl[i][j] = 0;
                        Elements.get(elem).Pl[i] = 0;
                    }
                }
            }



            //OBLICZANIE HL

            double[][] tab;
            //System.out.println("Dla " + global_data.pkt_calk + " punktowego ukladu całkowania: ");
            for (int e = 0; e < global_data.nE; e++) {
                //System.out.println("Element: " + (e + 1));
                for (int i = 0; i < global_data.pkt_calk * global_data.pkt_calk; i++) {
                    tab = Elem4.calcH(ND, Elements, global_data.K, e, i, global_data.pkt_calk);
                    //wypisywanie_tablicy_NxN(tab);
                    for (int k = 0; k < 4; k++) {
                        for (int l = 0; l < 4; l++) {
                            Elements.get(e).Hl[k][l] += tab[k][l];
                        }
                    }
                }

                //System.out.println();
                //System.out.println("Macierz Hl: ");
                //wypisywanie_tablicy_NxN(Elements.get(e).Hl);
            }
            //System.out.println();



            //OBLICZANIE HBC

            //System.out.println("Dla " + global_data.pkt_calk + " punktowego ukladu całkowania: ");
            for (int e = 0; e < global_data.nE; e++) {
                //System.out.println("Element: " + (e + 1));
                Elements.get(e).HBC = Elem4.calcHBCandP(ND, Elements, e, global_data.pkt_calk, global_data.alfa, global_data.t_alfa);
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        Elements.get(e).Hl[i][j] += Elements.get(e).HBC[i][j];
                    }
                }

                //System.out.println();
                //System.out.println("Macierz HBC: ");
                //wypisywanie_tablicy_NxN(Elements.get(e).HBC);
//                System.out.println();
//                System.out.println("Wektor Pl: ");
//                wypisywanie_wektora(Elements.get(e).Pl);
            }
//            System.out.println();
//            System.out.println();


            //OBLICZANIE CL

            double[][] pom;
            //System.out.println("Dla " + global_data.pkt_calk + " punktowego ukladu całkowania: ");
            for (int e = 0; e < global_data.nE; e++) {
                //System.out.println("Element: " + (e + 1));
                for (int i = 0; i < global_data.pkt_calk * global_data.pkt_calk; i++) {
                    pom = Elem4.calcC(ND, Elements, global_data.K, e, i, global_data.pkt_calk, global_data.cp, global_data.ro);
                    //wypisywanie_tablicy_NxN(tab);
                    for (int k = 0; k < 4; k++) {
                        for (int l = 0; l < 4; l++) {
                            Elements.get(e).Cl[k][l] += pom[k][l];
                        }
                    }
                }
                //System.out.println();
                //System.out.println();
                //System.out.println("Macierz Cl: ");
                //wypisywanie_tablicy_NxN(Elements.get(e).Cl);
            }
            //System.out.println();
            //System.out.println();


            //OBLICZANIE HG


            for (int k = 0; k < global_data.nE; k++) {
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        soe.HG[Elements.get(k).ID[i] - 1][Elements.get(k).ID[j] - 1] += Elements.get(k).Hl[i][j];
                    }
                }
            }

            //System.out.println("Macierz HG: ");
            //wypisywanie_tablicy_NxN(soe.HG);


            //OBLICZANIE CG

            for (int k = 0; k < global_data.nE; k++) {
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        soe.CG[Elements.get(k).ID[i] - 1][Elements.get(k).ID[j] - 1] += Elements.get(k).Cl[i][j];
                    }
                }
            }
            //System.out.println("Macierz CG: ");
            //wypisywanie_tablicy_NxN(soe.CG);
            //System.out.println(Elem4.boki[1].tabE_bok[0]+ " " + Elem4.boki[1].tabE_bok[1]);

            //OBLICZANIE PG

            for (int e = 0; e < global_data.nE; e++) {
                for (int i = 0; i < 4; i++) {
                    soe.PG[Elements.get(e).ID[i] - 1] += Elements.get(e).Pl[i];
                }
            }

            //System.out.println();

            //DODAWANIE PIERWSZEGO NAWIASU WZORU

            for (int i = 0; i < global_data.nN; i++) {
                for (int j = 0; j < global_data.nN; j++) {
                    soe.HG[i][j] += (soe.CG[i][j] / global_data.czas_kroku);
                }
            }

            //wypisywanie_tablicy_NxN(soe.HG);


            //DODAWANIE DRUGIEGO NAWIASU WZORU

            for (int i = 0; i < global_data.nN; i++) {
                for (int j = 0; j < global_data.nN; j++) {
                    soe.PG[i] -= (soe.CG[i][j]/global_data.czas_kroku) * ND.get(j).t0;
                }
                soe.PG[i] = -1 * soe.PG[i];
            }

            //System.out.println("Wektor PG: ");
            //wypisywanie_wektora(soe.PG);


            double[] T_wynik = GaussElimination(soe.HG,soe.PG);

            for(int i=0; i<global_data.nN;i++){
                ND.get(i).t0 = T_wynik[i];
            }
            double min_temp=T_wynik[0];
            double max_temp=T_wynik[0];

            for(int i = 0; i< global_data.nN; i++ ){
                if(min_temp > T_wynik[i]){
                    min_temp = T_wynik[i];
                }

                if(max_temp < T_wynik[i]){
                    max_temp = T_wynik[i];
                }
            }

            System.out.println("Time =" + (n+1)*global_data.czas_kroku +"  MinTemp =" +min_temp+" MaxTemp =" +max_temp );
            System.out.println();

        }




    }


    static void wypisywanie_wektora(double tab[]){
        for(int i=0;i< tab.length;i++){
                System.out.print(tab[i]+" ");
            }
            System.out.println();
            System.out.println();
    }



    static void wypisywanie_tablicy_NxN(double tab[][]){
        for(int i=0;i< tab.length;i++){
            for(int j=0;j< tab.length;j++){
                System.out.print(tab[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void przypisanie_wezlow(Global_Data G, List<Node> ND) {

        for (int i = 0; i < G.nW; i++) {
            for (int j = 0; j < G.nH; j++) {
                double deltaY = j * (G.H / (G.nH - 1));// mnoze razy deltaY (przyrost w gore)
                double deltaX = i * (G.W / (G.nW - 1));// mnoze razy deltaX (przyrost w bok)
                Node N1 = new Node(deltaX, deltaY);
                ND.add(N1);
                if(N1.x==0 || N1.y==0 || N1.x== G.W || N1.y==G.H){
                    N1.BC=1;
                }
            }
        }
    }



    static void przypisanie_elementow(Global_Data G, List<Element> Elements) {
        for (int i = 1; i < G.nE + G.nW; i++) {

            if ((i % (G.nH) == 0)) {
                continue;
            }

            Element E1 = new Element();
            E1.ID[0] = i;
            E1.ID[1] = E1.ID[0] + G.nH;
            E1.ID[2] = E1.ID[1] + 1;
            E1.ID[3] = E1.ID[0] + 1;
            Elements.add(E1);
        }
    }

    static void wypisz_siatke(List<Node> ND, List<Element> Elements) {

        for (int i = 0; i < Elements.size(); i++) {
            System.out.println("Element: " + (i + 1) + " ma wezly :");
            for (int j = 0; j < 4; j++) {
                System.out.print("Wezel " + Elements.get(i).ID[j] + " : ");
                System.out.println("x= " + ND.get(Elements.get(i).ID[j] - 1).x + ", y: " + ND.get(Elements.get(i).ID[j] - 1).y);
            }
        }
        System.out.println();
        System.out.println();

    }

    static double[] GaussElimination(double[][] tab, double[] wektor){

            int N = tab.length;
            for(int i=0;i<N;i++){ //przejscie po wszystkich wierszach
                int max = i; //max
                for(int j=i+1;j<N;j++){
                    if(Math.abs(tab[j][i] )> Math.abs(tab[max][i]) ){
                        max = j;

                    }
                }

                double[] temp = tab[i];
                tab[i] = tab[max];
                tab[max] = temp;
                double v = wektor[i];
                wektor[i] = wektor[max];
                wektor[max]= v;

                if(Math.abs(tab[i][i])<= 0.00000001){ //jesli w maksymalnym wierszu wartosc wynosi zero to cala kolumna bedzie wynosic zero czyli macierz osobliwa, nie da sie rozwiwazac
                    throw new RuntimeException("Macierz osobliwa ...");
                }
                for(int k=i+1;k<N;k++){
                    double alpha = tab[k][i] / tab[i][i]; //tab[k][i] liczba ponizej w tablicy


                    wektor[k] -=alpha*wektor[i];
                    for(int j=i; j<N; j++){
                        tab[k][j] -= alpha*tab[i][j];
                    }

                }
            }

            double[] x = new double[N];

            for(int i= N-1; i>=0;i--){//zaczcynamy od konca aby obliczyc pierwsza zmienna
                double suma = 0.0;

                for(int j=i+1; j<N; j++){
                    suma += tab[i][j] * x[j];
                }
                x[i]= (wektor[i]-suma) / tab[i][i];
        }
            return x;

        }





}
