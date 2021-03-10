package com.example;
import static java.lang.StrictMath.sqrt;

public class KwadraturyGaussa {
    public double fun(double x, double y) {
        return (-5 * x*x*y) + 2 * x*y*y + 10;

        //((-2 * x*x*y) + 2 * x*y + 4);
        //(-5 * x*x*y) + 2 * x*y*y + 10;
        //(-5 * x*x*y) + 2 * x*y*y + 10;
        //((-2 * x*x*y) + 2 * x*y + 4);
    }
    public double dwu_wezlowy() {
        double A1 = 1;
        double A2 = 1;
        double x1 = -(sqrt(3) / 3);
        double x2 = (sqrt(3) / 3);
        double y1 = -(sqrt(3) / 3);
        double y2 = (sqrt(3) / 3);

        return fun(x1, y1)*A1*A1 + fun(x2, y1)*A2*A1 + fun(x2, y2)*A2*A2 + fun(x1, y2)*A1*A2;
    }
    public double trzy_wezlowy() {
        //double A1 = (5 / 9);
        double A1 = 0.555555;
        //double A2 = (8 / 9);
        double A2 = 0.8888889;
        //double x1 = -sqrt(0.6);
        double x1 = -0.77;
        double x2 = 0;
        //double x3 = sqrt(0.6);
        double x3 = 0.77;
        //double y1 = -sqrt(0.6);
        double y1 = -0.77;
        double y2 = 0;
        //double y3 = sqrt(0.6);
        double y3 = 0.77;

        return (fun(x1, y1)*A1*A1 + fun(x2, y1)*A2*A1 + fun(x3, y1)*A1*A1 + fun(x1, y2)*A1*A2 + fun(x2, y2)*A2*A2 + fun(x3, y2)*A1*A2 + fun(x1, y3)*A1*A1 + fun(x2, y3)*A2*A1 + fun(x3, y3)*A1*A1);



    }


}
