package com.zeta;
import java.sql.SQLOutput;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;



public class LambdaBasics {
    static Predicate<Integer> lambda = (x) -> (x % 2) == 0;
    static Consumer<Integer> lambda1 = (Integer x)-> System.out.println("This is: "+ x);
    static Function<Integer,String> lambda2 = (Integer x)-> {if (x % 2 == 0) return "Even"; else return "Odd";};
    static Supplier<Integer> lambda3 =()-> 10;

    static Function<int[] ,int[]> increment = (int[] arr)->{
        for( int i=0;i<arr.length;i++) {
            arr[i]+=2;
        }
        return arr;
    };

    static Function<int[] ,int[]> incrementEven = (int[] arr)->{
        for( int i=0;i<arr.length;i++) {
            if(arr[i]%2==0) arr[i]+=2;
        }
        return arr;
    };


//     AddBy incrementVal = (arr,val)-> {
//        for(int i=0;i<arr.length;i++){
//            arr[i]+=val;
//        }
//    };

    public static void main(String[] args) {
        System.out.println(LambdaBasics.lambda.test(10));
        LambdaBasics.lambda1.accept(10);
        System.out.println(lambda2.apply(10));
        System.out.println(lambda3.get());

        Calculator calculator = (x,y)->x+y;
        System.out.println(calculator.add(2,3));


        int[] arr = {1,2,3,4,5};
        increment.apply(arr);
        for(int a:arr){
            System.out.print(a+" ");
        }
        System.out.println();
        incrementEven.apply(arr);
        for(int a:arr){
            System.out.print(a+" ");
        }


        AddBy incrementVal = (arr1,val)-> {
            for(int i=0;i<arr1.length;i++){
                arr1[i]+=val;
            }
        };


        incrementVal.addval(arr,3);
        System.out.println();
        for(int a:arr){
            System.out.print(a+" ");
        }

        Sumof3 sumof3 = (arr2)->{
            int sum =0;
            for(int i=0;i<arr2.length;i+=3){
                sum+=arr2[i];
            }
            return sum;
        };
        System.out.println("\n"+sumof3.sumof3(arr));

    }
}
