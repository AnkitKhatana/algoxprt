package strings.medium;

public class OneEdit {

    public boolean checkForEqual(String stringOne , String stringTwo){
        int idx=0 , numberOfMismatch=0;
        while(idx<stringOne.length())
            if(stringOne.charAt(idx) != stringTwo.charAt(idx++))
                if(numberOfMismatch>0)
                    return false;
                else
                    numberOfMismatch++;
        return true;
    }

    public boolean checkForRemove(String larger , String smaller){
        int idx=0;
        while(idx<smaller.length())
            if(larger.charAt(idx) != smaller.charAt(idx))
                break;
            else
                idx++;
        while(idx<smaller.length())
            if(larger.charAt(idx+1) != smaller.charAt(idx++))
                return false;

        return true;
    }
    public boolean oneEdit(String stringOne, String stringTwo) {
        // Write your code here.
        int length1 = stringOne.length();
        int length2 = stringTwo.length();
        if(length1 == length2)
            return checkForEqual(stringOne,stringTwo);
        else if(length1+1 == length2)
            return checkForRemove(stringTwo,stringOne);
        else if(length1 == length2+1)
            return checkForRemove(stringOne,stringTwo);
        else
            return false;
    }

    public static void main(String[] args) {
        String stringOne1 = "hello";
        String stringTwo1 = "helo";
        String stringOne2 = "hello";
        String stringTwo2 = "hella";
        String stringOne = "hello";
        String stringTwo = "helia";
        System.out.println(new OneEdit().oneEdit(stringOne,stringTwo));
    }
}
