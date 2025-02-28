//reversing array and finding max and min value
//import java.util.Arrays;
public class Reversearr {
    public static void main(String[] args){

        int [] array1= {10,3,5,15,11,20};
        System.out.println("Array Before Reverse: ");
        for(int x:array1){
        System.out.print(x+" ");
        }
        System.out.println();
        //REVERSE OF ARRAY
        System.out.println("Array After Reverse is: ");
        for(int i= array1.length-1; i>=0;i--){
            System.out.println(" "+array1[i]);
        }
        //MIN AND MAX FROM ARRAY
        int max=Integer.MIN_VALUE;
        int min= Integer.MAX_VALUE;
        for(int i=0;i<array1.length;i++){
            if(array1[i]<min){
                min=array1[i];
            }
            
        }
        System.out.println("Minimum value in array1 is: "+min);
        for(int j=0;j<array1.length;j++){
            if(array1[j]>max){
                max=array1[j];
            }
            
        }
        System.out.println("Maximum value in array1 is: "+max);






    }
    
}
