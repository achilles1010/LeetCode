package learn.patterns.action.command;

import java.util.Stack;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-06-03 3:18 下午 周三
 */
public class CommandHistory {
    private Stack<Command> history = new Stack<>();

    public void push(Command c) {
        history.push(c);
    }

    public Command pop() {
        return history.pop();
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }
}
