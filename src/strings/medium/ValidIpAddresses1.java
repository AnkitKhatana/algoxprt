package strings.medium;

import java.util.ArrayList;

public class ValidIpAddresses1 {

    public boolean isValidBlock(String string, int start, int end){
        String block = string.substring(start,end);
        if((block.length()>1 && block.charAt(0)=='0') || Integer.parseInt(block) > 255)
            return false;
        return true;
    }
    public static String makeIpAddressFromDotsAndString(int[] dots,String str){
        StringBuffer ip = new StringBuffer();
        for(int i=1; i<dots.length; i++){
            ip.append(str.substring(dots[i-1],dots[i])).append(".");
        }
        ip.deleteCharAt(ip.length()-1);
        return new String(ip.toString());
    }
    public ArrayList<String> validIPAddresses(String string) {
        // Write your code here.
        if(string.length()<4 || string.length()>12)
            return new ArrayList<>();

        int length = string.length();
        ArrayList<String> validIps = new ArrayList<>();

        for(int thirdDot=length-3; thirdDot < length; thirdDot++)
            if(isValidBlock(string,thirdDot,length))
                for(int secondDot=thirdDot-3; secondDot < thirdDot; secondDot++)
                    if(secondDot>0 && isValidBlock(string,secondDot,thirdDot))
                        for(int firstDot=secondDot-3;firstDot < secondDot; firstDot++)
                            if(firstDot>0 && isValidBlock(string,firstDot,secondDot) && isValidBlock(string,0,firstDot))
                                validIps.add(makeIpAddressFromDotsAndString(new int[]{0,firstDot,secondDot,thirdDot,string.length()},string));

        return validIps;
    }

    public static void main(String[] args) {
        String input1="1921680";
        String input2="192168255123";
        String input="3700100";
        ArrayList<String> returnedValidIps = new ValidIpAddresses1().validIPAddresses(input);
        System.out.println(returnedValidIps.toString());
    }

}
