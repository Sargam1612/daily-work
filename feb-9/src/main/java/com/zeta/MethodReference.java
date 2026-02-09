package com.zeta;

import java.util.function.BiFunction;
import java.util.function.Function;

class Util{
    int square(int x) {
        return x*x;
    }
    int sum(int x,int y){
        return x*y;
    }

}
public class MethodReference {
    public static void main(String[] args){
        Util util = new Util();
        Function<Integer,Integer> reference = util::square;;
        System.out.println(reference.apply(2));

        BiFunction<Integer,Integer,Integer> referenceSum = util::sum;
        System.out.println(referenceSum.apply(3,5));
    }
}
