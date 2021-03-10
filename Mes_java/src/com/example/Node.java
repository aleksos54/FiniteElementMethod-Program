package com.example;

public class Node {
    Global_Data global_data = new Global_Data();
    public double x, y, t0;
    int BC=0;


    public Node(double x, double y){
        this.x = x;
        this.y = y;
        this.t0=global_data.t0;
    }


}
