import java.util.Stack;

public class T20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if(s.length() == 0) {
            return true;
        }
        for(char nowCharacter : s.toCharArray()) {
            if(nowCharacter == '(' || nowCharacter == '[' || nowCharacter == '{') {
                stack.push(nowCharacter);
            } else {
                if(stack.empty()) {
                    return false;
                } else {
                    Character stackCharacter = stack.pop();
                    if(stackCharacter == '(' && nowCharacter == ')' ||
                            stackCharacter == '[' && nowCharacter == ']' ||
                            stackCharacter == '{' && nowCharacter == '}') {
                        continue;
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.empty();
    }
}
