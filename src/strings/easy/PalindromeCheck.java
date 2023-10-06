package strings.easy;

public class PalindromeCheck {
    public static boolean isPalindrome(String str) {
        // Write your code here.
        int left=0, right=str.length()-1;
        while(left<right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("abcdcba"));
        System.out.println(isPalindrome("abfdcba"));
        System.out.println(isPalindrome("a"));
        System.out.println(isPalindrome("ab"));

    }
}
