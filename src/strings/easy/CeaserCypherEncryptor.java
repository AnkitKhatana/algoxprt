package strings.easy;

public class CeaserCypherEncryptor {
    public static String caesarCypherEncryptor(String str, int key) {
        // Write your code here.
        StringBuilder sb = new StringBuilder();
        int lowestLowerCaseLetterAscii = 'a';
        int totalLetters = 26;
        for(int i=0; i<str.length(); i++){
            char current = str.charAt(i);
            int encryptedCharAscii = (current + key - lowestLowerCaseLetterAscii) % totalLetters ;

            sb.append((char)(encryptedCharAscii + lowestLowerCaseLetterAscii));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(caesarCypherEncryptor("xyz",2));
    }
}
