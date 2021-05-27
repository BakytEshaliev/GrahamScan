package com.company;

public class Dot implements Comparable {
    double x;
    double y;
    double edge;
    char name;

    public Dot(char name,double x,double y){
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public void setEdge(double x1, double y1) {
        if (x1 - x == 0 && y1 - y == 0)
            edge=0;
        else
            edge = 180 * ((x1 - x) / (y1 - y)) / Math.PI;
    }

    @Override
    public int compareTo(Object o) {
        Dot dot = (Dot) o;
        return dot.edge > edge ? 1 : -1;
    }
}
