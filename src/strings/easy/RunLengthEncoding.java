package strings.easy;

public class RunLengthEncoding {
    public String runLengthEncoding(String string) {
        // Write your code here.
        StringBuffer sb = new StringBuffer();
        int count=1;
        char prevChar=string.charAt(0);
        for(int i=1; i<string.length(); i++){
            if(count==9 || prevChar != string.charAt(i)){
                sb.append(count).append(prevChar);
                count=0;
                prevChar=string.charAt(i);
            }
            count++;
        }
        sb.append(count).append(prevChar);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new RunLengthEncoding().runLengthEncoding("AAAAAAAAA"));
    }
}
