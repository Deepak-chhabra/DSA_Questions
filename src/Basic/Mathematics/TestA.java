package Basic.Mathematics;

   /*
Count all digits of a number
Count number of odd digits in a number
Reverse a number
Palindrome number
Return the largest digit in a number
Factorial of a given number
Check if the number if armstrong
Check for perfect number
Check for prime number
    */
class Number{
    private final int number ; // when no setter means final

    // Default constructor and Parameterized Constructor
    Number(){
        this(0);
    }

    Number(int number){
        if(number < 0 ){
            throw new IllegalArgumentException("Number should be more than or equal to zero");
        }
        this.number = number ;
    }

    public int getNumber(){
        return number ;
    }

    public int countDigit(){
        int count = 0 ;
        if(number == 0){
           return 1 ;
        }
        int temp = number ;
        while(temp > 0 ){
            count++;
            temp /= 10 ;
        }
        return count ;
    }

    public int  countOddDigit(){

        int temp = number ;

        if(number == 0 ){
           return 1 ;
        }
        int count = 0;
        while(temp > 0 ) {
            int digit = temp % 10;
            if (digit % 2 != 0) {
                count++;
            }
            temp /= 10 ;
        }
        return count;
    }

    public int reverse(){
        int temp = number ;

        if(number  == 0 ){
            return  0 ;
        }

        int reverseNum = 0 ;
        while(temp > 0 ){
            int lastDigit = temp %10 ;

            if(reverseNum > (Integer.MAX_VALUE - lastDigit)/10 ){
                throw new ArithmeticException("overflow error");
            }
            reverseNum = reverseNum *10 + lastDigit ;
            temp /= 10 ;
        }

        return reverseNum ;
    }
    public boolean isPalindrome(){

        try {
            return number == reverse();
        }catch(ArithmeticException e){
             return false ;
        }
    }

    public int largestDigit(){
        int temp = number ;
        if(number == 0 ) return 0 ;

        int maxDigit =  0 ;

        while( temp > 0 ){

            maxDigit = Math.max(maxDigit , temp%10 );
            temp /= 10 ;
        }
        return maxDigit ;
    }
    public int factorialNumber(int number ){

        if(number == 0 || number == 1 ) return 1 ;
         if(number > 20){
             throw new ArithmeticException(String.format("factorial of the number %d exceeds limit" , number));
         }
        return number *factorialNumber(number -1 );
    }

    public boolean armstrongNumber(){

        int temp = number ;
        int armstrongNum = 0 ;
        int numberOfDigit = countDigit();
        while(temp > 0 ){
            int lastDigit = temp %10 ;
            armstrongNum += (int)Math.pow(lastDigit, numberOfDigit);
            temp /= 10 ;
        }
        return armstrongNum == number ;
    }

    public boolean isPerfect(){
        /*
        A perfect number is a positive integer that equals the sum of its proper positive divisors
         (all divisors excluding the number itself), such as 6 (1+2+3=6) and 28 (1+2+4+7+14=28)
        */

        if(number == 0 || number == 1 ) return false ;
        int temp = number ;
        int divisors = 0 ;
        for(int i = 1 ; i*i < number ; i++){
            if(number%i == 0 ){
                divisors += i ;
                if(i  != number/i){
                    divisors += divisors/i;
                }
            }
        }
        return divisors == number ;
    }

    public boolean isPrime(){
        if(number < 2 ) return false ;
        if(number == 2 || number == 3 ) return true ;
        if(number % 2 == 0 || number % 3 == 0 ) return false ;

        for(int i = 5 ; i*i < number ; i++){
            if(number % i == 0 || number % (i+2) == 0 ) return false ;
        }
        return true ;
    }

    public String toString(){
        return String.format("Number is :: %d\n " +
                             "Number of digit in the %d :: %d \n" +
                             "Number of odd digit in the number :: %d\n" +
                             "Reverse of the Number :: %d\n" +
                             "isPalindrome :: %b\n" +
                             "Largest Digit in the number :: %d\n" +
                             "factorial of the Number :: %d\n" +
                             "is the number Armstrong :: %b\n" +
                             "is the number prefect :: %b\n" +
                             "is Number prime :: %b\n " ,
                              getNumber(), number , countDigit(),
                              countOddDigit(), reverse(), isPalindrome(),
                              largestDigit(), factorialNumber(number) ,
                              armstrongNumber(), isPerfect(), isPrime());
    }
   }

public class TestA {

    public static void main(String[] args) {
        System.out.println("Main");
        Number num = new Number(-56);
        System.out.println(num);


    }
}
