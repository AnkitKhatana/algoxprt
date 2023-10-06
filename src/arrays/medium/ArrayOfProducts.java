package arrays.medium;

import java.util.Arrays;

public class ArrayOfProducts {

    public static int[] arrayOfProducts(int[] array) {
        // Write your code here.
        int[] arrayOfProducts = new int[array.length];
        int[] leftElementsProduct = new int[array.length];
        int[] rightElementsProduct = new int[array.length];

        int index=0;
        int product=1;

        while(index<array.length){
            leftElementsProduct[index] = product;
            product *= array[index++];
        }

        product = 1;

        while(--index >=0){
            rightElementsProduct[index] = product;
            product *= array[index];
        }

        while(++index < array.length)
            arrayOfProducts[index]=leftElementsProduct[index]*rightElementsProduct[index];


        return arrayOfProducts;
    }

    public static void main(String[] args) {
        int[] array = new int[] {5 , 1 , 4 , 2};

        int[] arrayOfProducts = arrayOfProducts(array);

        System.out.println(Arrays.toString(arrayOfProducts));
    }
}
