import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    Scanner input=new Scanner(System.in);
    while (true) {
      int male=input.nextInt();
      int female=input.nextInt();
      if (male ==0 && female==0) {
        break;
      }else{
        int friends=male+female;
        System.out.println(friends);
      }
    }
    input.close();//Sanner를 닫아야한다
  }
}
