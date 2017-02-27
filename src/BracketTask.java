import java.util.Scanner;

/**
 * Created by User on 26.02.2017.
 */
public class BracketTask {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        String brackets = scanner.nextLine();
        if (bracketsInspection(brackets)) {
            System.out.println("Строка скобок правильна");
        } else {
            System.out.println("Строка скобок неправильна");
        }
    }
    private static boolean bracketsInspection(String brackets) {
        ArrayStack stack = new ArrayStack(100);
        for (int i = 0; i < brackets.length(); i++) {
            switch (brackets.charAt(i)) {
                case '(' : stack.push('('); break;
                case '{' : stack.push('{'); break;
                case '<' : stack.push('<'); break;
                case '[' : stack.push('['); break;

                case ')' :  if (((char)stack.pop()) != ('(')) {
                                return false;
                            }
                            break;
                case '}' :  if (((char)stack.pop()) != ('{')) {
                                return false;
                            }
                            break;
                case '>' :  if (((char)stack.pop()) != ('<')) {
                               return false;
                            }
                            break;
                case ']' :  if (((char)stack.pop()) != ('[')) {
                                return false;
                            }
                            break;
            }
        }
        if (stack.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
