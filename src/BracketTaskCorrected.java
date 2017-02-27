import java.util.Scanner;

/**
 * Created by User on 27.02.2017.
 */
public class BracketTaskCorrected {
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
        ArrayStack stack = new ArrayStack(brackets.length());
        for (int i = 0; i < brackets.length(); i++) {
            openingBranch(brackets.charAt(i), stack);
            closingBranch(brackets.charAt(i), stack);
        }
        if (stack.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    private static void openingBranch(char sym, ArrayStack stack) {
        if (isOpenBranch(sym)) {
            stack.push(sym);
        }
    }

    private static boolean closingBranch(char sym, ArrayStack stack) {
        if (isCloseBranch(sym)) {
            if ((char)(stack.pop()) != sym) {
                return false;
            }
            return false;
        }
        return true;
    }

    private static boolean isOpenBranch(char sym) {
        if (sym == '(' || sym == '{' || sym == '[' || sym == '<') {
            return true;
        }
        return false;
    }
    private static boolean isCloseBranch(char sym) {
        if (sym == ')' || sym == '}' || sym == ']' || sym == '>') {
            return true;
        }
        return false;
    }
}
