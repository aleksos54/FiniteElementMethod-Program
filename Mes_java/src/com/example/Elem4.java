package com.example;

import java.util.ArrayList;
import java.util.List;

import static java.lang.StrictMath.sqrt;

public class Elem4 {
    double tabE[];
    double tabN[];
    double pkt_calkE[][];
    double pkt_calkN[][];

    double tabE_po_boku[];
    double tabN_po_boku[];
    double tab_fun_ksztaltu[][];
    double N_od_pc_bok[][];
    Bok boki[]= new Bok[4];

    double A1,A2;

    public Elem4(int ilu_punktowy_uklad){
        for(int i=0; i<4; i++){
            boki[i]= new Bok(i,ilu_punktowy_uklad);;
        }

        if(ilu_punktowy_uklad==2) {
             tabE = new double[]{-(sqrt(3) / 3), (sqrt(3) / 3), (sqrt(3) / 3), -(sqrt(3) / 3)};
             tabN = new double[]{-(sqrt(3) / 3), -(sqrt(3) / 3), (sqrt(3) / 3), (sqrt(3) / 3)};

             pkt_calkE = new double[][]{
                             {-0.25 * (1 - tabN[0]), 0.25 * (1 - tabN[0]), 0.25 * (1 + tabN[0]), -0.25 * (1 + tabN[0])},
                             {-0.25 * (1 - tabN[1]), 0.25 * (1 - tabN[1]), 0.25 * (1 + tabN[1]), -0.25 * (1 + tabN[1])},
                             {-0.25 * (1 - tabN[2]), 0.25 * (1 - tabN[2]), 0.25 * (1 + tabN[2]), -0.25 * (1 + tabN[2])},
                             {-0.25 * (1 - tabN[3]), 0.25 * (1 - tabN[3]), 0.25 * (1 + tabN[3]), -0.25 * (1 + tabN[3])}
                     }; // dN1/dE , dN2/dE , dN3/dE , dN4/dE

             pkt_calkN = new double[][]{
                             {-0.25 * (1 - tabE[0]), -0.25 * (1 + tabE[0]), 0.25 * (1 + tabE[0]), 0.25 * (1 - tabE[0])},
                             {-0.25 * (1 - tabE[1]), -0.25 * (1 + tabE[1]), 0.25 * (1 + tabE[1]), 0.25 * (1 - tabE[1])},
                             {-0.25 * (1 - tabE[2]), -0.25 * (1 + tabE[2]), 0.25 * (1 + tabE[2]), 0.25 * (1 - tabE[2])},
                             {-0.25 * (1 - tabE[3]), -0.25 * (1 + tabE[3]), 0.25 * (1 + tabE[3]), 0.25 * (1 - tabE[3])}
                     }; // dN1/dN , dN2/dN , dN3/dN , dN4/dN

            tab_fun_ksztaltu = new double[][]{
                    {0.25 * (1 - tabE[0])*(1 - tabN[0]), 0.25 *(1 + tabE[0])*(1 - tabN[0]), 0.25 * (1 + tabE[0])*(1 + tabN[0]), 0.25 * (1 - tabE[0])*(1 + tabN[0])},
                    {0.25 * (1 - tabE[1])*(1 - tabN[1]), 0.25 *(1 + tabE[1])*(1 - tabN[1]), 0.25 * (1 + tabE[1])*(1 + tabN[1]), 0.25 * (1 - tabE[1])*(1 + tabN[1])},
                    {0.25 * (1 - tabE[2])*(1 - tabN[2]), 0.25 *(1 + tabE[2])*(1 - tabN[2]), 0.25 * (1 + tabE[2])*(1 + tabN[2]), 0.25 * (1 - tabE[2])*(1 + tabN[2])},
                    {0.25 * (1 - tabE[3])*(1 - tabN[3]), 0.25 *(1 + tabE[3])*(1 - tabN[3]), 0.25 * (1 + tabE[3])*(1 + tabN[3]), 0.25 * (1 - tabE[3])*(1 + tabN[3])}
                    //N1, N2, N3, N4

            };

            A1 = 1;
            A2 = 1;
            //wagi

        }
            else if(ilu_punktowy_uklad==3){
             tabE = new double[]{-sqrt(0.6), 0., sqrt(0.6), -sqrt(0.6), 0., sqrt(0.6),-sqrt(0.6), 0., sqrt(0.6)};
             tabN = new double[]{-sqrt(0.6),-sqrt(0.6),-sqrt(0.6),0,0,0,sqrt(0.6),sqrt(0.6),sqrt(0.6)};

             pkt_calkE = new double[][]{
                             {-0.25 * (1 - tabN[0]), 0.25 * (1 - tabN[0]), 0.25 * (1 + tabN[0]), -0.25 * (1 + tabN[0])},
                             {-0.25 * (1 - tabN[1]), 0.25 * (1 - tabN[1]), 0.25 * (1 + tabN[1]), -0.25 * (1 + tabN[1])},
                             {-0.25 * (1 - tabN[2]), 0.25 * (1 - tabN[2]), 0.25 * (1 + tabN[2]), -0.25 * (1 + tabN[2])},
                             {-0.25 * (1 - tabN[3]), 0.25 * (1 - tabN[3]), 0.25 * (1 + tabN[3]), -0.25 * (1 + tabN[3])},
                             {-0.25 * (1 - tabN[4]), 0.25 * (1 - tabN[4]), 0.25 * (1 + tabN[4]), -0.25 * (1 + tabN[4])},
                             {-0.25 * (1 - tabN[5]), 0.25 * (1 - tabN[5]), 0.25 * (1 + tabN[5]), -0.25 * (1 + tabN[5])},
                             {-0.25 * (1 - tabN[6]), 0.25 * (1 - tabN[6]), 0.25 * (1 + tabN[6]), -0.25 * (1 + tabN[6])},
                             {-0.25 * (1 - tabN[7]), 0.25 * (1 - tabN[7]), 0.25 * (1 + tabN[7]), -0.25 * (1 + tabN[7])},
                             {-0.25 * (1 - tabN[8]), 0.25 * (1 - tabN[8]), 0.25 * (1 + tabN[8]), -0.25 * (1 + tabN[8])}

                     }; // dN1/dE , dN2/dE , dN3/dE , dN4/dE ...dN9/dE

             pkt_calkN = new double[][]{
                             {-0.25 * (1 - tabE[0]), -0.25 * (1 + tabE[0]), 0.25 * (1 + tabE[0]), 0.25 * (1 - tabE[0])},
                             {-0.25 * (1 - tabE[1]), -0.25 * (1 + tabE[1]), 0.25 * (1 + tabE[1]), 0.25 * (1 - tabE[1])},
                             {-0.25 * (1 - tabE[2]), -0.25 * (1 + tabE[2]), 0.25 * (1 + tabE[2]), 0.25 * (1 - tabE[2])},
                             {-0.25 * (1 - tabE[3]), -0.25 * (1 + tabE[3]), 0.25 * (1 + tabE[3]), 0.25 * (1 - tabE[3])},
                             {-0.25 * (1 - tabE[4]), -0.25 * (1 + tabE[4]), 0.25 * (1 + tabE[4]), 0.25 * (1 - tabE[4])},
                             {-0.25 * (1 - tabE[5]), -0.25 * (1 + tabE[5]), 0.25 * (1 + tabE[5]), 0.25 * (1 - tabE[5])},
                             {-0.25 * (1 - tabE[6]), -0.25 * (1 + tabE[6]), 0.25 * (1 + tabE[6]), 0.25 * (1 - tabE[6])},
                             {-0.25 * (1 - tabE[7]), -0.25 * (1 + tabE[7]), 0.25 * (1 + tabE[7]), 0.25 * (1 - tabE[7])},
                             {-0.25 * (1 - tabE[8]), -0.25 * (1 + tabE[8]), 0.25 * (1 + tabE[8]), 0.25 * (1 - tabE[8])}
                     }; // dN1/dN , dN2/dN , dN3/dN , dN4/dN ... dN9/dE

            tab_fun_ksztaltu = new double[][]{
                    {0.25 * (1 - tabE[0])*(1 - tabN[0]), 0.25 *(1 + tabE[0])*(1 - tabN[0]), 0.25 * (1 + tabE[0])*(1 + tabN[0]), 0.25 * (1 - tabE[0])*(1 + tabN[0])},
                    {0.25 * (1 - tabE[1])*(1 - tabN[1]), 0.25 *(1 + tabE[1])*(1 - tabN[1]), 0.25 * (1 + tabE[1])*(1 + tabN[1]), 0.25 * (1 - tabE[1])*(1 + tabN[1])},
                    {0.25 * (1 - tabE[2])*(1 - tabN[2]), 0.25 *(1 + tabE[2])*(1 - tabN[2]), 0.25 * (1 + tabE[2])*(1 + tabN[2]), 0.25 * (1 - tabE[2])*(1 + tabN[2])},
                    {0.25 * (1 - tabE[3])*(1 - tabN[3]), 0.25 *(1 + tabE[3])*(1 - tabN[3]), 0.25 * (1 + tabE[3])*(1 + tabN[3]), 0.25 * (1 - tabE[3])*(1 + tabN[3])},
                    {0.25 * (1 - tabE[4])*(1 - tabN[4]), 0.25 *(1 + tabE[4])*(1 - tabN[4]), 0.25 * (1 + tabE[4])*(1 + tabN[4]), 0.25 * (1 - tabE[4])*(1 + tabN[4])},
                    {0.25 * (1 - tabE[5])*(1 - tabN[5]), 0.25 *(1 + tabE[5])*(1 - tabN[5]), 0.25 * (1 + tabE[5])*(1 + tabN[5]), 0.25 * (1 - tabE[5])*(1 + tabN[5])},
                    {0.25 * (1 - tabE[6])*(1 - tabN[6]), 0.25 *(1 + tabE[6])*(1 - tabN[6]), 0.25 * (1 + tabE[6])*(1 + tabN[6]), 0.25 * (1 - tabE[6])*(1 + tabN[6])},
                    {0.25 * (1 - tabE[7])*(1 - tabN[7]), 0.25 *(1 + tabE[7])*(1 - tabN[7]), 0.25 * (1 + tabE[7])*(1 + tabN[7]), 0.25 * (1 - tabE[7])*(1 + tabN[7])},
                    {0.25 * (1 - tabE[8])*(1 - tabN[8]), 0.25 *(1 + tabE[8])*(1 - tabN[8]), 0.25 * (1 + tabE[8])*(1 + tabN[8]), 0.25 * (1 - tabE[8])*(1 + tabN[8])}


            };
            A1 = 5/9.0f;
            A2 = 8/9.0f;


            }
            else if(ilu_punktowy_uklad==4){
            double w1 = -1*Math.sqrt((3.0/7.0)+((2.0/7.0)*Math.sqrt(6.0/5.0)));
            double w2 = -1*Math.sqrt((3.0/7.0)-((2.0/7.0)*Math.sqrt(6.0/5.0)));
            double w3 = Math.sqrt((3.0/7.0)-((2.0/7.0)*Math.sqrt(6.0/5.0)));
            double w4 = Math.sqrt((3.0/7.0)+((2.0/7.0)*Math.sqrt(6.0/5.0)));
            tabE = new double[]{w1,w2,w3,w4,w1,w2,w3,w4,w1,w2,w3,w4,w1,w2,w3,w4};
            tabN = new double[]{w1,w1,w1,w1,w2,w2,w2,w2,w3,w3,w3,w3,w4,w4,w4,w4};

            pkt_calkN= new double[16][4];
            pkt_calkE= new double[16][4];
            tab_fun_ksztaltu= new double[16][4];

            for (int i = 0; i < 16; i++) {
                   pkt_calkE[i][0] = -0.25 * (1 - tabN[i]);
                   pkt_calkE[i][1] = 0.25 * (1 - tabN[i]);
                   pkt_calkE[i][2] = 0.25 * (1 + tabN[i]);
                   pkt_calkE[i][3] = -0.25 * (1 + tabN[i]);
            }

            for (int i = 0; i < 16; i++) {
                  pkt_calkN[i][0] = -0.25 * (1 - tabE[i]);
                  pkt_calkN[i][1] = -0.25 * (1 + tabE[i]);
                  pkt_calkN[i][2] = 0.25 * (1 + tabE[i]);
                  pkt_calkN[i][3] = 0.25 * (1 - tabE[i]);

            }

            for (int i = 0; i < 16; i++) {
                tab_fun_ksztaltu[i][0] = 0.25 * (1 - tabE[i])*(1 - tabN[i]);
                tab_fun_ksztaltu[i][1] = 0.25 * (1 + tabE[i])*(1 - tabN[i]);
                tab_fun_ksztaltu[i][2] = 0.25 * (1 + tabE[i])*(1 + tabN[i]);
                tab_fun_ksztaltu[i][3] = 0.25 * (1 - tabE[i])*(1 + tabN[i]);

            }

            A1 = (18.0-Math.sqrt(30.0))/36.0;
            A2 = (18.0+Math.sqrt(30.0))/36.0;
            }


    }







    public static  double[][] Jakobian(double x[], double y[], Elem4 Elem, int pkt_calkowania) {
        double[][] Jacobi = new double[2][2];


        //OBLICZANIE JACOBI

        Jacobi[0][0] = x[0] * Elem.pkt_calkE[pkt_calkowania][0] + x[1] * Elem.pkt_calkE[pkt_calkowania][1] + x[2] * Elem.pkt_calkE[pkt_calkowania][2] + x[3] * Elem.pkt_calkE[pkt_calkowania][3];
        Jacobi[0][1] = y[0] * Elem.pkt_calkE[pkt_calkowania][0] + y[1] * Elem.pkt_calkE[pkt_calkowania][1] + y[2] * Elem.pkt_calkE[pkt_calkowania][2] + y[3] * Elem.pkt_calkE[pkt_calkowania][3];
        Jacobi[1][0] = x[0] * Elem.pkt_calkN[pkt_calkowania][0] + x[1] * Elem.pkt_calkN[pkt_calkowania][1] + x[2] * Elem.pkt_calkN[pkt_calkowania][2] + x[3] * Elem.pkt_calkN[pkt_calkowania][3];
        Jacobi[1][1] = y[0] * Elem.pkt_calkN[pkt_calkowania][0] + y[1] * Elem.pkt_calkN[pkt_calkowania][1] + y[2] * Elem.pkt_calkN[pkt_calkowania][2] + y[3] * Elem.pkt_calkN[pkt_calkowania][3];


        return Jacobi;
    }

    public static double[][] odwrotny_jakobian(double Jacobi[][],double detJ){
        double[][] odwrotny_Jacobi = new double[2][2];


        odwrotny_Jacobi[0][0] = (1 / detJ)*Jacobi[1][1];
        odwrotny_Jacobi[0][1] = (1 / detJ)*(-1)*Jacobi[0][1];
        odwrotny_Jacobi[1][0] = (1 / detJ)*(-1)*Jacobi[1][0];
        odwrotny_Jacobi[1][1] = (1 / detJ)*Jacobi[0][0];
        return odwrotny_Jacobi;

    }

    public static double[][] calcH(List<Node> ND, List<Element> Elements, double k,int e, int p,int ilu_pkt_uklad_calk) {

        Elem4 Elem = new Elem4(ilu_pkt_uklad_calk);

        double[] x=new double[4];
        double[] y=new double[4];
        //double x[] = {0, 4, 4, 0};
        //double y[] = {0, 0, 6, 6};
        for(int i=0; i<4;i++){
            x[i]=ND.get(Elements.get(e).ID[i]-1).x;
            y[i]=ND.get(Elements.get(e).ID[i]-1).y;
        }

//        for(int i=0; i<4;i++){
//            System.out.print(x[i]+" "+y[i]);
//            System.out.println();
//
//        }


//        System.out.println();
//        System.out.println();
        double dN_po_dX[] = new double[4];
        double dN_po_dY[] = new double[4];
        double[][] HLPC = new double[4][4];

        double[][] Jakobian = Jakobian(x, y, Elem, p);

        double detJ = Jakobian[0][0] * Jakobian[1][1] - Jakobian[0][1] * Jakobian[1][0];

        double[][] odwrotny_Jacobi = odwrotny_jakobian(Jakobian, detJ);

        for (int i = 0; i < 4; i++) {
            dN_po_dX[i] = odwrotny_Jacobi[0][0] * Elem.pkt_calkE[p][i] + odwrotny_Jacobi[0][1] * Elem.pkt_calkN[p][i];
            dN_po_dY[i] = odwrotny_Jacobi[1][0] * Elem.pkt_calkE[p][i] + odwrotny_Jacobi[1][1] * Elem.pkt_calkN[p][i];
        }



        double[][] dNdX_razy_dNdXT = new double[4][4];
        double[][] dNdY_razy_dNdYT = new double[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                dNdX_razy_dNdXT[i][j] = dN_po_dX[i] * dN_po_dX[j];
                dNdY_razy_dNdYT[i][j] = dN_po_dY[i] * dN_po_dY[j];
            }
        }


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                HLPC[i][j] = (dNdX_razy_dNdXT[i][j] + dNdY_razy_dNdYT[i][j])*k*detJ;

            }
        }

        if(ilu_pkt_uklad_calk==4) {

            if (p == 0 ||p == 3 || p==12 || p==15) {
                for(int i=0;i<4;i++){
                    for(int j=0;j<4;j++){
                        HLPC[i][j] = HLPC[i][j] * Elem.A1 * Elem.A1;
                    }
                }


            } else if (p == 1 ||p==2|| p==4|| p == 7 ||p==8 || p==11 || p==13 || p==14) {
                for(int i=0;i<4;i++){
                    for(int j=0;j<4;j++){
                        HLPC[i][j] = HLPC[i][j] * Elem.A1 * Elem.A2;
                    }
                }

            } else { //p==4
                for(int i=0;i<4;i++){
                    for(int j=0;j<4;j++){
                        HLPC[i][j] = HLPC[i][j] * Elem.A2 * Elem.A2;
                    }
                }

            }

        }






        else if(ilu_pkt_uklad_calk==2){ //mnoze razy wagi 1

        }
        else if(ilu_pkt_uklad_calk==3) {
            if (p == 0 || p == 2 || p == 6 || p == 8){
                for(int i=0;i<4;i++){
                    for(int j=0;j<4;j++){
                        HLPC[i][j] = HLPC[i][j] * Elem.A1 * Elem.A1;
                    }
                }
            } else if (p == 1 || p == 3 || p == 5 || p == 7) {
                for(int i=0;i<4;i++){
                    for(int j=0;j<4;j++){
                        HLPC[i][j] = HLPC[i][j] * Elem.A1 * Elem.A2;
                    }
                }
            } else {
                for(int i=0;i<4;i++){
                    for(int j=0;j<4;j++){
                        HLPC[i][j] = HLPC[i][j] * Elem.A2 * Elem.A2;
                    }
                }
            }
        }
        return HLPC;
    }





    /////////////////////////////////////////////////////////////////////







    public static double[][] calcC(List<Node> ND, List<Element> Elements, double k,int e, int p,int ilu_pkt_uklad_calk,double cp, double ro) {

        Elem4 Elem = new Elem4(ilu_pkt_uklad_calk);

        double[] x=new double[4];
        double[] y=new double[4];

        for(int i=0; i<4;i++){
            x[i]=ND.get(Elements.get(e).ID[i]-1).x;
            y[i]=ND.get(Elements.get(e).ID[i]-1).y;
        }

        double[][] CL = new double[4][4];

        double[][] Jakobian = Jakobian(x, y, Elem, p);

        double detJ = Jakobian[0][0] * Jakobian[1][1] - Jakobian[0][1] * Jakobian[1][0];

        double[][] dN_razy_dNT = new double[4][4];


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                dN_razy_dNT[i][j] = Elem.tab_fun_ksztaltu[p][i] *Elem.tab_fun_ksztaltu[p][j];
            }
        }


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                CL[i][j] = (dN_razy_dNT[i][j]*cp*ro*detJ);

            }
        }

        if(ilu_pkt_uklad_calk==3) {

            if (p == 0 || p == 2 || p == 6 || p == 8) {
                for(int i=0;i<4;i++){
                    for(int j=0;j<4;j++){
                        CL[i][j] = CL[i][j] * Elem.A1 * Elem.A1;
                    }
                }


            } else if (p == 1 || p == 3 || p == 5 || p == 7) {
                for(int i=0;i<4;i++){
                    for(int j=0;j<4;j++){
                        CL[i][j] = CL[i][j] * Elem.A1 * Elem.A2;
                    }
                }

            } else { //p==4
                for(int i=0;i<4;i++){
                    for(int j=0;j<4;j++){
                        CL[i][j] = CL[i][j] * Elem.A2 * Elem.A2;
                    }
                }

            }

        }
        else if(ilu_pkt_uklad_calk==2){ //mnoze razy wagi 1

        }
        else if(ilu_pkt_uklad_calk==4) {

            if (p == 0 ||p == 3 || p==12 || p==15) {
                for(int i=0;i<4;i++){
                    for(int j=0;j<4;j++){
                        CL[i][j] = CL[i][j] * Elem.A1 * Elem.A1;
                    }
                }


            } else if (p == 1 ||p==2|| p==4|| p == 7 ||p==8 || p==11 || p==13 || p==14) {
                for(int i=0;i<4;i++){
                    for(int j=0;j<4;j++){
                        CL[i][j] = CL[i][j] * Elem.A1 * Elem.A2;
                    }
                }

            } else { //p==4
                for(int i=0;i<4;i++){
                    for(int j=0;j<4;j++){
                        CL[i][j] = CL[i][j] * Elem.A2 * Elem.A2;
                    }
                }

            }

        }

        return CL;
    }



    public static double[][] calcHBCandP(List<Node> ND, List<Element> Elements,int e,int ilu_pkt_uklad_calk, double alfa, double t_alfa){
        Elem4 Elem = new Elem4(ilu_pkt_uklad_calk);
        double Pl[] = {0,0,0,0};
        for(int i=0;i<4;i++){
            if(ND.get(Elements.get(e).ID[i]-1).BC==1 && ND.get(Elements.get(e).ID[(i+1)%4]-1).BC==1){
                Elem.boki[i].Wezel1_x=ND.get(Elements.get(e).ID[i]-1).x;
                Elem.boki[i].Wezel1_y=ND.get(Elements.get(e).ID[i]-1).y;
                Elem.boki[i].Wezel2_x=ND.get(Elements.get(e).ID[(i+1)%4]-1).x;
                Elem.boki[i].Wezel2_y=ND.get(Elements.get(e).ID[(i+1)%4]-1).y;
                Elem.boki[i].BC_boku=1;
            }
        }
        double HBC[][] = {{0,0,0,0}, {0,0,0,0}, {0,0,0,0}, {0,0,0,0}};

        for(int i=0;i<4;i++){

            if(Elem.boki[i].BC_boku==1){
                Elem.boki[i].detJ= Math.sqrt(Math.pow(Elem.boki[i].Wezel2_x - Elem.boki[i].Wezel1_x,2) + Math.pow(Elem.boki[i].Wezel2_y - Elem.boki[i].Wezel1_y,2))/2;
                for(int j=0;j<ilu_pkt_uklad_calk;j++) {
                if(i==3) {

                    HBC[0][0] += Elem.boki[i].N_bok[j][0] * Elem.boki[i].N_bok[j][0] * Elem.boki[i].wagi[j] * Elem.boki[i].detJ * alfa;
                    HBC[0][3] += Elem.boki[i].N_bok[j][0] * Elem.boki[i].N_bok[j][3] * Elem.boki[i].wagi[j] * Elem.boki[i].detJ * alfa;
                    HBC[3][0] += Elem.boki[i].N_bok[j][3] * Elem.boki[i].N_bok[j][0] * Elem.boki[i].wagi[j] * Elem.boki[i].detJ * alfa;
                    HBC[3][3] += Elem.boki[i].N_bok[j][3] * Elem.boki[i].N_bok[j][3] * Elem.boki[i].wagi[j] * Elem.boki[i].detJ * alfa;

                    Pl[0]+= Elem.boki[i].N_bok[j][0]* t_alfa * Elem.boki[i].detJ *Elem.boki[i].wagi[j]* (-alfa);
                    Pl[3]+= Elem.boki[i].N_bok[j][3]* t_alfa * Elem.boki[i].detJ *Elem.boki[i].wagi[j]* (-alfa);


                }
                else{

                        HBC[i][i] += Elem.boki[i].N_bok[j][i] * Elem.boki[i].N_bok[j][i] * Elem.boki[i].wagi[j] * Elem.boki[i].detJ * alfa;
                        HBC[i][i + 1] += Elem.boki[i].N_bok[j][i] * Elem.boki[i].N_bok[j][i+1] * Elem.boki[i].wagi[j] * Elem.boki[i].detJ * alfa;
                        HBC[i + 1][i] += Elem.boki[i].N_bok[j][i+1] * Elem.boki[i].N_bok[j][i] * Elem.boki[i].wagi[j] * Elem.boki[i].detJ * alfa;
                        HBC[i + 1][i + 1] += Elem.boki[i].N_bok[j][i+1] * Elem.boki[i].N_bok[j][i+1] * Elem.boki[i].wagi[j] * Elem.boki[i].detJ * alfa;

                        Pl[i]+= Elem.boki[i].N_bok[j][i]* t_alfa * Elem.boki[i].detJ *Elem.boki[i].wagi[j] * (-alfa);
                        Pl[i+1]+= Elem.boki[i].N_bok[j][i+1]* t_alfa * Elem.boki[i].detJ *Elem.boki[i].wagi[j]* (-alfa);
                    }


                }
            }


        }
        Elements.get(e).Pl=Pl;

        return HBC;
    }

}
