package learn.patterns.action.command;

/**
 * The type Command.
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -06-03 3:18 下午 周三
 */
public class PasteCommand extends Command{


    /**
     * Instantiates a new Command.
     *
     * @param editor the editor
     */
    PasteCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        if (editor.clipboard == null || editor.clipboard.isEmpty()) {
            return false;
        }

        backup();

        editor.textField.insert(editor.clipboard, editor.textField.getCaretPosition());
        return true;
    }
}
