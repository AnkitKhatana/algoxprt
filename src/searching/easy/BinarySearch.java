package searching.easy;

public class BinarySearch {
    public static int binarySearch(int[] array, int target) {
        // Write your code here.
        if(array.length<1)
            return -1;
        int left=0;
        int right=array.length-1;
        do{
            int middle=(left+right)/2;
            if(target == array[middle])
                return middle;
            else if(target < array[middle])
                right=middle-1;
            else
                left=middle+1;
        }while(left<=right);
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 21, 33, 45, 45, 61, 71, 72, 73};
        int target = 33;
        int expected = 3;
        System.out.println(BinarySearch.binarySearch(array,target));
    }
}
