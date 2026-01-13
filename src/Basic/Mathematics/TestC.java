package Basic.Mathematics;

class Anamika{
      private int age ;
      private String name ;

      Anamika(){
          this(10," Anamika");
      }
      Anamika(int age , String  name ){
          this.age = age ;
          this.name = name  ;
      }

      public String toString(){
            return String.format("Name :: %s\n Age :: %d " , name , age );
      }
}
public class TestC {

    public static void main(String[] args) {
        Anamika nanu = new Anamika(10,"Deepak") ;
        System.out.println(nanu);
    }

}
