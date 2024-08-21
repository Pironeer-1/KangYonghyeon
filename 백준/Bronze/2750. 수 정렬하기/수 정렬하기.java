import java.util.Scanner;

public class Main {

  public static int [] merge_sort(int[] arr,int left, int right){
    //기저 조건 완전히 한개씩 분리 될때 까지
    if (left<right){
      int mid=(left+right)/2;
      //왼쪽 정렬
      merge_sort(arr, left, mid);
      //오른쪽 정렬
      merge_sort(arr, mid+1, right);
      //두개의 정렬 합치기
      merge(arr,left,mid,right);
    }
    return arr;
  }
  public static int [] merge(int [] arr, int left, int mid, int right){
    //시작 인덱스
    int leftArea= left;
    int rightArea=mid+1;

    //임시 배열
    int [] tempArr=new int[right+1];
    int tempArrIndex= left;
    while (leftArea<=mid&&rightArea<=right) {
      if (arr[leftArea]<=arr[rightArea]){
        tempArr[tempArrIndex]=arr[leftArea];
        leftArea++;
      }else{
        tempArr[tempArrIndex]=arr[rightArea];
        rightArea++;
      }
      tempArrIndex++;
  }
  if(leftArea>mid){
    for (int i=rightArea;i<=right ;i++){
      tempArr[tempArrIndex++]=arr[i];
    }
  }else{
    for(int i=leftArea;i<=mid;i++){
      tempArr[tempArrIndex++]=arr[i];
    }
  }
    //데이터 옯기기
    for (int i=left; i<=right;i++){
      arr[i]=tempArr[i];
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
    merge_sort(arr, 0, arr.length-1);

     //정렬 완료
    for (int i=0; i< arr.length; i++){
      System.out.println(arr[i]);
    }
  }
}
