import java.util.Arrays;
public class EvenOddArr {
    public static void main(String[] args){
        int [] array1={1,2,3,4,5,6,7,8};
        int [] result= new int[array1.length];
        int i=0;
        for(int x: array1){
            if(x%2==0){
                result[i++]=x;
            }
        }
        for(int y:array1){
            if(y%2!=0){
                result[i++]=y;
            }
        }
        System.out.println("Even/odd Sorted Array is: "+ Arrays.toString(result));
       
       
    }
}
