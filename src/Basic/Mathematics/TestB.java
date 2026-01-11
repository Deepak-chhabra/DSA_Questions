package Basic.Mathematics;

 /*
   GCD of two numbers
   LCM of two numbers
   Divisors of a number
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
        Number1 num = new Number1(4,16);
        System.out.println(num);
    }
}
