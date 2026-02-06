package com.zeta;

class patterns{
    int n;int m;

    public patterns(int n, int m) {
        this.n=n;
        this.m=m;
    }

    void print(){
        for(int i=0;i<n;i++){
            for(int j=m;j>=i;j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
public class Main{
    public static void main(String[] args){
        patterns p = new patterns(8,7);
        p.print();
    }
}