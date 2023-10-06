package recursion.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductSum {

    public static int recursiveProductSum(List<Object> array , int level) {
        int sum=0;
        for(Object element:array){
            if(element instanceof ArrayList)
                sum = sum + (level+1)*recursiveProductSum((List)element,level+1);
            else
                sum=sum+(Integer) element;
        }
        return sum;
    }
    public static int productSum(List<Object> array) {
        // Write your code here.
        return recursiveProductSum(array,1);
    }

    public static void main(String[] args) {
        List<Object> test =
                new ArrayList<Object>(
                        Arrays.asList(
                                5,
                                2,
                                new ArrayList<Object>(Arrays.asList(7, -1)),
                                3,
                                new ArrayList<Object>(
                                        Arrays.asList(6, new ArrayList<Object>(Arrays.asList(-13, 8)), 4))));
        System.out.println(productSum(test));
    }
}
