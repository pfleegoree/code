import java.util.List;
import java.util.Stack;

public class WarAppApplication {

    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();


        List<String> list = List.of("AceH", "2H", "3H", "4H", "5H", "6H",
                                                "AceD", "2D", "3D", "4D", "5D", "6D",
                                                "AceC", "2C", "3C", "4C", "5C", "6C",
                                                "AceS", "2S", "3S", "4S", "5S", "6S");

        System.out.println("Stack: " +  stack.pop());




        System.out.println("Stack: " + stack);
    }
}
