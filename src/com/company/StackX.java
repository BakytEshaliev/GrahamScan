package com.company;

public class StackX {
    private final  int SIZE = 20;
    private Dot[] st = new Dot[SIZE];
    private int top=-1;
    int size=0;

    public void push(Dot i){
        st[++top]=i;
        size++;
    }

    public Dot pop(){
        if(!isEmpty()) {
            size--;
            return this.st[top--];
        }
        return null;
    }

    public Dot peek(){
        if (!isEmpty())
            return st[top];
        return null;
    }

    public Dot peek2(){
        if (!isEmpty())
            return st[top-1];
        return null;
    }

    public boolean isEmpty(){
        return top==-1;
    }
}

