// 定义类
public class Main {

    public static void main(String[] args) {
        int [] arr= {34,12,56,90};
        String str = toString(arr);
        System.out.println(str);

    }
    public static String toString(int[] arr){
        String temp ="";
        for(int x =0; x<arr.length;x++){
            if(x!=arr.length-1){
                temp =temp +arr[x]+",";
            }else{
                temp =temp +arr[x];
            }
        }
        return temp;
    }
}