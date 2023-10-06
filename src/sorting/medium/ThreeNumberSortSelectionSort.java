package sorting.medium;

import java.util.Arrays;

public class ThreeNumberSortSelectionSort {

    public void swap(int[] array,int first,int second){
        if(first==second)
            return;
        int temp=array[first];
        array[first]=array[second];
        array[second]=temp;
    }
    public int[] threeNumberSort(int[] array, int[] order) {
        // Write your code here.
        int boundary=0;
        for(int i=0;i<order.length-1; i++){
            int orderElement = order[i];
            boolean orderElementFound;
            do{
                int probeIndex=boundary;
                orderElementFound=false;
                while(probeIndex<array.length){
                    if(array[probeIndex++] == orderElement){
                        orderElementFound=true;
                        break;
                    }
                }
                if(orderElementFound){
                    swap(array,boundary++,probeIndex-1);
                }
                else
                    break;
            }while(orderElementFound);
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[] {1, 0, 0, -1, -1, 0, 1, 1};
        int[] order = new int[] {0, 1, -1};
        System.out.println(Arrays.toString(new ThreeNumberSortSelectionSort().threeNumberSort(array,order)));
    }

}
