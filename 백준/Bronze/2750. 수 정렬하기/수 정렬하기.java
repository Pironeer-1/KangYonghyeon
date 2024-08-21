import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    int N= sc.nextInt();
    int[] arr=new int[N];
    for (int i=0;i<N;i++){
      arr[i]=sc.nextInt();
    }
    //arr를 완성
    for (int i=0; i<arr.length-1;i++){
      int minIndex=i;//제일 처음 값을 minIndex로 잡고 
      for(int j=i+1; j<arr.length;j++){
        if(arr[j]<arr[minIndex]){
          minIndex=j;
        }
      }

      int temp= arr[i];
      arr[i]=arr[minIndex];
      arr[minIndex]=temp;
    }
      //정렬 완료
    for (int i=0; i< arr.length; i++){
      System.out.println(arr[i]);
    }
  }

}
