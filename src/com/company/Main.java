package com.company;

public class Main {

    public static void main(String[] args) {
	    Figure figure = new Figure();
	    figure.addDot('a',0,0);
        figure.addDot('b',13,2);
        figure.addDot('c',10,4);
        figure.addDot('d',5,3);
        figure.addDot('e',9,8);
        figure.addDot('f',6,9);
        figure.addDot('g',1,7);
        figure.graham();
    }
}
