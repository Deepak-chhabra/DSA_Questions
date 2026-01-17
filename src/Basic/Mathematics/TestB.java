package Basic.Mathematics;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
   GCD of two numbers
   LCM of two numbers
   Divisors of a number

   You are given an integer n.
   You need to find all the divisors of n.
   Return all the divisors of n as an array or list in a sorted order.
   A number which completely divides another number is called it's divisor.
  */

class Number1{
    private int value1 ;
    private int value2 ;

    Number1(){
        this(0,0);
    }

    Number1(int value1 , int value2){
        this.value2 = value2 ;
        this.value1 = value1 ;
    }

    public int GCD(){
        int value1 = this.value1 ;
        int value2  = this.value2 ;
        while(value1  > 0 && value2 > 0 ){
            if(value1 > value2){
                value1 = value1 - value2 ;
            }
            else {
                value2 = value2 - value1 ;
            }
        }
        return value1 == 0 ? value2 : value1 ;
    }

    public int LCD(){

        return value1 * value2 / GCD();
    }

    public String toString(){
        return String.format("Numbers are :: %d and %d\n" +
                             "GCD is :: %d\n" +
                             "Lcd is :: %d\n" , value1 , value2 , GCD() , LCD());
    }
}
public class TestB {

    public static void main(String[] args) {
//        Number1 num = new Number1(4,16);
//        System.out.println(num);
        Set<Integer> ans = allDivisors(36);
        for(int ele  : ans){
            System.out.print(ele + "\t");
        }
        System.out.println();
    }

    public static  Set<Integer> allDivisors(int number ){

        Set<Integer> arr = new HashSet<>();

        for(int i = 1 ; i*i <= number ; i++ ){

            if(number%i == 0 ){
                arr.add(i);
                if(i != number/i){
                    arr.add(number/i);
                }
            }
        }
        return arr ;
    }
}
