package strings.medium;


import java.util.ArrayList;

public class ValidIpAddresses {

    static boolean changedAfterLastValid=false;

    public static boolean nextCorrectArrangement(int[] dots, int dotToPermute){
        boolean isChanged = false;
        while(dots[dotToPermute+1] - dots[dotToPermute] > 3){
            dots[dotToPermute]++;
            isChanged=true;
            changedAfterLastValid=true;
        }
        if(isChanged==false && dots[dotToPermute] < dots[dotToPermute+1]-1 ){
            dots[dotToPermute]++;
            isChanged=true;
            changedAfterLastValid=true;
        }
        return isChanged;
    }

    public static String makeIpAddressFromDotsAndString(int[] dots,String str){
        StringBuffer ip = new StringBuffer();
        for(int i=1; i<dots.length; i++){
            ip.append(str.substring(dots[i-1],dots[i])).append(".");
        }
        ip.deleteCharAt(ip.length()-1);
        return new String(ip.toString());
    }

    public static boolean validateIpBlock(String str , int[] dots, int dotToPermute, ArrayList<String> validIpAddresses){
        String block=str.substring(dots[dotToPermute],dots[dotToPermute+1]);
        if((block.length()>1 && block.charAt(0)=='0') || Integer.parseInt(block) > 255)
            return false;
        if(dotToPermute==1 ){
            String block0=str.substring(dots[dotToPermute-1],dots[dotToPermute]);
            if(Integer.parseInt(block0)>255)
                return false;
            validIpAddresses.add(makeIpAddressFromDotsAndString(dots,str));
            changedAfterLastValid=false;
        }
        return true;
    }

    public static void recursiveMethod(String str , int[] dots, int dotToPermute , ArrayList<String> validIpAddresses){
        if(dotToPermute == 0)
            return ;
        while(true) {
            boolean isChanged = false;
            if(!changedAfterLastValid || (changedAfterLastValid && !validateIpBlock(str,dots,dotToPermute,validIpAddresses)))
                isChanged = nextCorrectArrangement(dots, dotToPermute);
            if (!isChanged)
                return;
            boolean isValid = validateIpBlock(str, dots, dotToPermute, validIpAddresses);
            if (isValid)
                recursiveMethod(str, dots, dotToPermute - 1, validIpAddresses);
        }
    }

    public ArrayList<String> validIPAddresses(String string) {
        // Write your code here.
        if(string.length() > 12 || string.length() < 4)
            return new ArrayList<String>();
        int[] dots = new int[] {0,0,0,0,string.length()};
        ArrayList<String> validIpAddresses = new ArrayList<>();
        recursiveMethod(string,dots,3,validIpAddresses);
        return new ArrayList<String>();
    }
    public static void main(String[] args) {
        String input1="1921680";
        String input2="192168255123";
        ArrayList<String> returnedValidIps = new ValidIpAddresses().validIPAddresses(input1);
        System.out.println(returnedValidIps.toString());
    }
}
