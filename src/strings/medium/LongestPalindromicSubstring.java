package strings.medium;

public class LongestPalindromicSubstring {

    public static boolean isPalindrome(int start , int end, String str){
        while(start < end) {
            if(str.charAt(start) == str.charAt(end)){
                start++;
                end--;
            }
            else
                return false;
        }
        return true;
    }
    public static String longestPalindromicSubstring(String str) {
        // Write your code here.
        if(str.length()<2)
            return str;
        int palindromeSubstringStart = 0;
        int palindromeSubstringEnd = 0;

        for(int i=0; i<str.length(); i++){
            for(int j=str.length()-1; palindromeSubstringEnd-palindromeSubstringStart < j-i ;j--){
                if(isPalindrome(i,j,str) ){
                    palindromeSubstringEnd=j;
                    palindromeSubstringStart=i;
                }
            }
        }
        return str.substring(palindromeSubstringStart,palindromeSubstringEnd+1);
    }

    public static void main(String[] args) {
        String input1 = "abaxyzzyxf";
        String input2 = "aa";
        String input = "abcdefghfedcbaa";
        //System.out.println(longestPalindromicSubstring(input));

        System.out.println(new Approach2().longestPalindromicSubstring(input));
    }

    public static class Approach2{
        public String longestPalindromicSubstring(String str) {
            PalindromeSubstring longestPalindromeSubstring=null;
            for(int i=0;i<str.length();i++){
                PalindromeSubstring palindromeSubstring = longestPalindrome(i-1,i+1,str);
                if(null == longestPalindromeSubstring || palindromeSubstring.length > longestPalindromeSubstring.length)
                    longestPalindromeSubstring=palindromeSubstring;
                palindromeSubstring = longestPalindrome(i,i+1,str);
                if(null == longestPalindromeSubstring || palindromeSubstring.length > longestPalindromeSubstring.length)
                    longestPalindromeSubstring=palindromeSubstring;
            }
            return str.substring(longestPalindromeSubstring.start,longestPalindromeSubstring.end+1);
        }

        public PalindromeSubstring longestPalindrome(int left, int right , String str){
            PalindromeSubstring ps = new PalindromeSubstring();
            while(left>=0 && right<str.length()){
                if(str.charAt(left) != str.charAt(right)){
                    break;
                }
                left--;
                right++;
            }
            ps.start=left+1;
            ps.end=right-1;
            ps.length=ps.end - ps.start;
           return ps;
        }
    }

    public static class PalindromeSubstring{
        int start;
        int end;
        int length;
    }
}
