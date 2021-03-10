package com.example;

import static java.lang.StrictMath.sqrt;

public class Bok {
    double tabE_bok[];
    double tabN_bok[];
    double N_bok[][];

    double Wezel1_x;
    double Wezel1_y;
    double Wezel2_x;
    double Wezel2_y;
    double wagi[];

    int BC_boku = 0;
    double detJ;

    public Bok(int id_boku, int ilu_punktowy_uklad) {

        N_bok = new double[ilu_punktowy_uklad][4];
        if (ilu_punktowy_uklad == 2) {
            wagi = new double[]{1,1};
            if (id_boku == 0) {
                tabE_bok = new double[]{(-1.0 / sqrt(3.0)), (1.0 / sqrt(3.0))};
                tabN_bok = new double[]{(-1.0), (-1.0)};
                for (int i = 0; i < 2; i++) {
                    N_bok[i][0] = 0.25 * (1 - tabE_bok[i]) * (1 - tabN_bok[i]);
                    N_bok[i][1] = 0.25 * (1 + tabE_bok[i]) * (1 - tabN_bok[i]);
                    N_bok[i][2] = 0.25 * (1 + tabE_bok[i]) * (1 + tabN_bok[i]);
                    N_bok[i][3] = 0.25 * (1 - tabE_bok[i]) * (1 + tabN_bok[i]);

                }

            }
            if (id_boku == 1) {
                tabE_bok = new double[]{(1.0), (1.0)};
                tabN_bok = new double[]{(-1.0 / sqrt(3.0)), (1.0 / sqrt(3.0))};
                for (int i = 0; i < 2; i++) {
                    N_bok[i][0] = 0.25 * (1 - tabE_bok[i]) * (1 - tabN_bok[i]);
                    N_bok[i][1] = 0.25 * (1 + tabE_bok[i]) * (1 - tabN_bok[i]);
                    N_bok[i][2] = 0.25 * (1 + tabE_bok[i]) * (1 + tabN_bok[i]);
                    N_bok[i][3] = 0.25 * (1 - tabE_bok[i]) * (1 + tabN_bok[i]);

                }
            }
            if (id_boku == 2) {
                tabE_bok = new double[]{(1.0 / sqrt(3.0)), (-1.0 / sqrt(3.0))};
                tabN_bok = new double[]{(1.0), (1.0)};
                for (int i = 0; i < 2; i++) {
                    N_bok[i][0] = 0.25 * (1 - tabE_bok[i]) * (1 - tabN_bok[i]);
                    N_bok[i][1] = 0.25 * (1 + tabE_bok[i]) * (1 - tabN_bok[i]);
                    N_bok[i][2] = 0.25 * (1 + tabE_bok[i]) * (1 + tabN_bok[i]);
                    N_bok[i][3] = 0.25 * (1 - tabE_bok[i]) * (1 + tabN_bok[i]);

                }
            }
            if (id_boku == 3) {
                tabE_bok = new double[]{(-1.0), (-1.0)};
                tabN_bok = new double[]{(1.0 / sqrt(3.0)), (-1.0 / sqrt(3.0))};

                for (int i = 0; i < 2; i++) {
                    N_bok[i][0] = 0.25 * (1 - tabE_bok[i]) * (1 - tabN_bok[i]);
                    N_bok[i][1] = 0.25 * (1 + tabE_bok[i]) * (1 - tabN_bok[i]);
                    N_bok[i][2] = 0.25 * (1 + tabE_bok[i]) * (1 + tabN_bok[i]);
                    N_bok[i][3] = 0.25 * (1 - tabE_bok[i]) * (1 + tabN_bok[i]);

                }
            }

        }
        if (ilu_punktowy_uklad == 3) {
            wagi = new double[]{5.0/9.0, 8.0/9.0, 5.0/9.0};
            if (id_boku == 0) {
                tabE_bok = new double[]{-Math.sqrt(3.0 / 5.0), 0, Math.sqrt(3.0 / 5.0)};
                tabN_bok = new double[]{-1, -1, -1};
                for (int i = 0; i < 3; i++) {
                    N_bok[i][0] = 0.25 * (1 - tabE_bok[i]) * (1 - tabN_bok[i]);
                    N_bok[i][1] = 0.25 * (1 + tabE_bok[i]) * (1 - tabN_bok[i]);
                    N_bok[i][2] = 0.25 * (1 + tabE_bok[i]) * (1 + tabN_bok[i]);
                    N_bok[i][3] = 0.25 * (1 - tabE_bok[i]) * (1 + tabN_bok[i]);

                }

            }
            if (id_boku == 1) {
                tabE_bok = new double[]{1, 1, 1};
                tabN_bok = new double[]{-Math.sqrt(3.0 / 5.0), 0, Math.sqrt(3.0 / 5.0)};
                for (int i = 0; i < 3; i++) {
                    N_bok[i][0] = 0.25 * (1 - tabE_bok[i]) * (1 - tabN_bok[i]);
                    N_bok[i][1] = 0.25 * (1 + tabE_bok[i]) * (1 - tabN_bok[i]);
                    N_bok[i][2] = 0.25 * (1 + tabE_bok[i]) * (1 + tabN_bok[i]);
                    N_bok[i][3] = 0.25 * (1 - tabE_bok[i]) * (1 + tabN_bok[i]);

                }
            }
            if (id_boku == 2) {
                tabE_bok = new double[]{Math.sqrt(3.0 / 5.0), 0, -Math.sqrt(3.0 / 5.0)};
                tabN_bok = new double[]{1, 1, 1};
                for (int i = 0; i < 3; i++) {
                    N_bok[i][0] = 0.25 * (1 - tabE_bok[i]) * (1 - tabN_bok[i]);
                    N_bok[i][1] = 0.25 * (1 + tabE_bok[i]) * (1 - tabN_bok[i]);
                    N_bok[i][2] = 0.25 * (1 + tabE_bok[i]) * (1 + tabN_bok[i]);
                    N_bok[i][3] = 0.25 * (1 - tabE_bok[i]) * (1 + tabN_bok[i]);

                }
            }
            if (id_boku == 3) {
                tabE_bok = new double[]{-1, -1, -1};
                tabN_bok = new double[]{Math.sqrt(3.0 / 5.0), 0, -Math.sqrt(3.0 / 5.0)};

                for (int i = 0; i < 3; i++) {
                    N_bok[i][0] = 0.25 * (1 - tabE_bok[i]) * (1 - tabN_bok[i]);
                    N_bok[i][1] = 0.25 * (1 + tabE_bok[i]) * (1 - tabN_bok[i]);
                    N_bok[i][2] = 0.25 * (1 + tabE_bok[i]) * (1 + tabN_bok[i]);
                    N_bok[i][3] = 0.25 * (1 - tabE_bok[i]) * (1 + tabN_bok[i]);

                }
            }
        }

        if (ilu_punktowy_uklad == 4) {
            wagi = new double[]{((18-Math.sqrt(30))/36), (18+ Math.sqrt(30))/36 , (18+ Math.sqrt(30))/36,((18-Math.sqrt(30))/36) };
            double w1 = -1*Math.sqrt((3.0/7.0)+((2.0/7.0)*Math.sqrt(6.0/5.0)));
            double w2 = -1*Math.sqrt((3.0/7.0)-((2.0/7.0)*Math.sqrt(6.0/5.0)));
            double w3 = Math.sqrt((3.0/7.0)-((2.0/7.0)*Math.sqrt(6.0/5.0)));
            double w4 = Math.sqrt((3.0/7.0)+((2.0/7.0)*Math.sqrt(6.0/5.0)));
            if (id_boku == 0) {
                tabE_bok = new double[]{w1,w2,w3,w4};
                tabN_bok = new double[]{-1, -1, -1,-1};
                for (int i = 0; i < 4; i++) {
                    N_bok[i][0] = 0.25 * (1 - tabE_bok[i]) * (1 - tabN_bok[i]);
                    N_bok[i][1] = 0.25 * (1 + tabE_bok[i]) * (1 - tabN_bok[i]);
                    N_bok[i][2] = 0.25 * (1 + tabE_bok[i]) * (1 + tabN_bok[i]);
                    N_bok[i][3] = 0.25 * (1 - tabE_bok[i]) * (1 + tabN_bok[i]);

                }

            }
            if (id_boku == 1) {
                tabE_bok = new double[]{1, 1, 1,1};
                tabN_bok = new double[]{w1,w2,w3,w4};
                for (int i = 0; i < 4; i++) {
                    N_bok[i][0] = 0.25 * (1 - tabE_bok[i]) * (1 - tabN_bok[i]);
                    N_bok[i][1] = 0.25 * (1 + tabE_bok[i]) * (1 - tabN_bok[i]);
                    N_bok[i][2] = 0.25 * (1 + tabE_bok[i]) * (1 + tabN_bok[i]);
                    N_bok[i][3] = 0.25 * (1 - tabE_bok[i]) * (1 + tabN_bok[i]);

                }
            }
            if (id_boku == 2) {
                tabE_bok = new double[]{w4,w3,w2,w1};
                tabN_bok = new double[]{1, 1, 1, 1};
                for (int i = 0; i < 4; i++) {
                    N_bok[i][0] = 0.25 * (1 - tabE_bok[i]) * (1 - tabN_bok[i]);
                    N_bok[i][1] = 0.25 * (1 + tabE_bok[i]) * (1 - tabN_bok[i]);
                    N_bok[i][2] = 0.25 * (1 + tabE_bok[i]) * (1 + tabN_bok[i]);
                    N_bok[i][3] = 0.25 * (1 - tabE_bok[i]) * (1 + tabN_bok[i]);

                }
            }
            if (id_boku == 3) {
                tabE_bok = new double[]{-1, -1, -1, -1};
                tabN_bok = new double[]{w4,w3,w2,w1};

                for (int i = 0; i < 4; i++) {
                    N_bok[i][0] = 0.25 * (1 - tabE_bok[i]) * (1 - tabN_bok[i]);
                    N_bok[i][1] = 0.25 * (1 + tabE_bok[i]) * (1 - tabN_bok[i]);
                    N_bok[i][2] = 0.25 * (1 + tabE_bok[i]) * (1 + tabN_bok[i]);
                    N_bok[i][3] = 0.25 * (1 - tabE_bok[i]) * (1 + tabN_bok[i]);

                }
            }
        }
    }
}
