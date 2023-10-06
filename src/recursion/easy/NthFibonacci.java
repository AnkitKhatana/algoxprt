package recursion.easy;

public class NthFibonacci {

    public static int getNthFib(int n) {
        // Write your code here.
        if(n==1)
            return 0;
        if(n==2)
            return 1;
        return getNthFib(n-1) + getNthFib(n-2);
    }

    public static void main(String[] args) {
        int input=2;
        int input1=6;
        System.out.println(getNthFib(input));
        System.out.println(getNthFib(input1));
    }
}
