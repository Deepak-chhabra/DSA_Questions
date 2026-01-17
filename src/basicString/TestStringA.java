package basicString;

class StringAnalyzer {
    private  final String text ;

    // parameterized constructor
    StringAnalyzer(String text ){
        if(text ==  null ){
             throw new IllegalArgumentException("String can not be null ");
        }
        this.text = text ;
    }
    // --------------------------------------------GETTERS-----------------------------------------
    public String getText(){
        return text ;
    }


    // -----------------------------------------BASIC OPERATIONS--------------------------------------

     /*
        the length of the string
        @return  length of text ;
      */
    public int length(){
        return text.length();
    }

    /*
      *Gets character at particular index with proper Validation
      * @param index at a particular character
      * @return Character at index
      * @throws IndexOutOfBoundException errors if index is invalid
     */

    public char getCharacter(int index ){
        if( index < 0 || index >= text.length()){
            throw new IndexOutOfBoundsException("index should be with in string length");
        }
        return text.charAt(index);
    }

    /*
      * check the String equal to another string
      * @param other string to compare
      * @return boolean value
     */

    public boolean equals(String text ){
        return this.text.equals(text);
    }

    /*
     * check the string equal to other string (ignoring the casing )
     * @param another string to compare
     * @return the boolean value
     */

    public boolean equalIgnoreCase(String text ){
        return this.text.equalsIgnoreCase(text);
    }

    /*
     * convert the string to upper case
     * @return the UpperCase case value of the string
     */

    public String toUpperCase(){
        return text.toUpperCase();
    }


    /*
     * convert the string to lower case
     * @return the Lower case of  the string
     */

    public String toLowerCase(){
        return text.toLowerCase();
    }

    /*
     * Remove the leading and trailing whiteSpaces of the string
     * @return trimmed string
     */

    public String trim(){
        return text.trim();
    }

     /*
       *check the string is empty or not
       * @return boolean value ( true -- empty else  false )
      */
    public boolean isEmpty(){
        return text.isEmpty();
    }

    /*
     *check the string is blank or not (whitespaces )
     * @return boolean value
     */
    public boolean isBlank(){
        return text.isBlank();
    }

    /*
      * count the valowels in the array
      * @return the count of the vowels
     */

    public int countVowels (){
        int count =  0 ;
        String vowels = "aeiouAEIOU";

        for(char ch : text.toCharArray()){
            if(vowels.indexOf(ch) != -1 ){
                count++;
            }
        }
        return count ;
    }

     /*
     * count the constants in the String
     * @return number of constants
      */

    public int countConsonants(){
        int count = 0 ;
        String vowels = "aeiouAEIOU";

        for(char ch : text.toCharArray()){
            if(Character.isLetter(ch) && vowels.indexOf(ch) == -1){
                count++;
            }

        }
        return count ;
    }

    /*
    * count the digits in the String
    * @return number of digit in the String
     */

    public int countDigit(){

        int count = 0 ;
        for(char ch : text.toCharArray()){
            if(Character.isDigit(ch)){
                count++;
            }

        }
        return count ;
    }

    /*
      * Count the blanks in the string
      * @return number of blanks
     */

    public int countBlanks(){
         if(text.isEmpty()) return 0 ;
         int count = 0 ;
         for(char ch : text.toCharArray()){
             if(Character.isWhitespace(ch)){
                 count++;
             }
         }
         return count ;
    }

    /*
     * count the words in the string
     * @return number of words
     */
      public int countWords(){
         if(text.isBlank()) return 0;
         return text.trim().split("\\s+").length ;
      }

      /*
        * Check for the palindrome
        * @return boolean
       */

      public boolean ispalindrome(){
        String cleaned = text.replace("\\s+", "").trim().toLowerCase();
        int left = 0 ;
        int right = cleaned.length()-1 ;

        while(left <= right ){
            if(cleaned.charAt(left) != cleaned.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true ;
      }
    public String toString(){
        return String.format("text :: %s\n" +
                             "length ::  %s\n" +
                             "UPPER CASE :: %s\n" +
                             "LOWER CASE  :: %s\n" +
                             "Trim :: %s\n" +
                             "VOWELS :: %d\n" +
                             "Consonants :: %d\n" +
                             "words :: %d\n",
                               getText() ,
                               length(),
                               toUpperCase(),
                               toLowerCase(),
                               trim(),
                               countVowels(),
                               countConsonants(),
                               countWords() );
    }

}
public class TestStringA {

    public static void main(String[] args) {
        StringAnalyzer str = new StringAnalyzer("This is the demo String");
        System.out.println(str);

    }

}
