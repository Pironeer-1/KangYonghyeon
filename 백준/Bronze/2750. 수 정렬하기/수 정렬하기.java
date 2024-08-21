import java.util.Scanner;

public class Main {
  public static int [] insertion_sort(int[] arr){
    //매개변수도 똑같이 타입 배열 변수명
    for (int i=1; i<arr.length;i++){
      int j;
      int insertingData=arr[i];
      for (j=i-1;j>=0;j--){
        if(arr[j]>insertingData){
          arr[j+1]=arr[j];
        }else{
          //삽입할 원소의 자리를 찾았어-> j+1이지
          break;
        }
      }
      arr[j+1]=insertingData;
      //여기서 j를 다시 사용하기 위해서 for 문밖에서 선언
    }
    return arr;
  }
  public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    //사이즈 선언하고 for문으로 데이터 받기
    int N= sc.nextInt();
    int[] arr=new int[N];
    for (int i=0;i<N;i++){
      arr[i]=sc.nextInt();
    }
    //arr를 완성
    //삽입 정렬
    insertion_sort(arr);

    //정렬 완료
    for (int i=0; i< arr.length; i++){
      System.out.println(arr[i]);
    }
    sc.close();
  }
}