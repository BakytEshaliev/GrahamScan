package com.company;

import com.company.Dot;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Figure {
    ArrayList<Dot> dots;

    public Figure(){
        dots = new ArrayList<>();
    }

    public void addDot(char name, double x, double y){
        Dot dot = new Dot(name,x,y);
        dots.add(dot);
    }

    public void graham(){

        Dot startDot = findStartDot();

        dots.forEach(d -> d.setEdge(startDot.x, startDot.y));

        Collections.sort(dots);

        Dot prevDot=null;
        for (Dot dot:dots){
            if (prevDot==null)
                prevDot=dot;
            else {
                if (prevDot.edge==dot.edge){
                    if (prevDot.x>dot.x||prevDot.y>dot.y){
                        dots.remove(dot);
                    }
                    else {
                        dots.remove(prevDot);
                        prevDot = dot;
                    }
                }
                else
                    prevDot = dot;
            }
        }

        DecimalFormat df = new DecimalFormat("#.##");

        for (Dot dot:dots){
            System.out.println(dot.name+" edge:"+df.format(dot.edge) + " x,y:"+dot.x+","+dot.y);
        }

        StackX stackX = new StackX();
        stackX.push(dots.get(dots.size()-1));
        stackX.push(dots.get(0));
        stackX.push(dots.get(1));

        System.out.println(dots.size());

        for (int i=2;i<dots.size();i++){
            while (left(stackX.peek2(),stackX.peek(),dots.get(i))) {
                System.out.println("poping "+stackX.peek().name);
                stackX.pop();
            }
            System.out.println("pushing " +dots.get(i).name);
            stackX.push(dots.get(i));
        }

        while (!stackX.isEmpty()){
            System.out.println(stackX.pop().name);
        }
    }

    public boolean left(Dot d0, Dot d1, Dot d2){
        double result = (d1.x-d0.x)*(d2.y-d0.y) - (d2.x-d0.x)*(d1.y-d0.y);
        System.out.println("result of "+d0.name+d1.name+d2.name+" is "+(result<0));
        return result < 0;
    }

    public Dot findStartDot(){
        Dot result=null;
        for (Dot dot:dots){
            if (result==null)
                result=dot;
            else if (result.y>dot.y)
                result = dot;
            else if (result.y==dot.y && dot.x<result.x){
                result=dot;
            }
        }
        return result;
    }
}
