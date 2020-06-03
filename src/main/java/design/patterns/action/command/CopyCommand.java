package design.patterns.action.command;

/**
 * The type Command.
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -06-03 3:18 下午 周三
 */
public class CopyCommand extends Command{


    /**
     * Instantiates a new Command.
     *
     * @param editor the editor
     */
    CopyCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        editor.clipboard = editor.textField.getSelectedText();
        return false;
    }
}
