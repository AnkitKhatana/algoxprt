import java.util.ArrayDeque;
import java.util.Deque;

public class rough {

    public static void main(String[] args) {
        Deque<Integer> check = new ArrayDeque<>();
        check.addLast(3);
        check.addLast(2);
        System.out.println(check.size());
        System.out.println(check.removeFirst());
        System.out.println(check.size());
    }
}
