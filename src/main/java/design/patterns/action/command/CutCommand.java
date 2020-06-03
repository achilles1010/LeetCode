package design.patterns.action.command;

/**
 * The type Command.
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -06-03 3:18 下午 周三
 */
public class CutCommand extends Command{


    /**
     * Instantiates a new Command.
     *
     * @param editor the editor
     */
    CutCommand(Editor editor) {
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

    private String cutString(String source) {
        String start = source.substring(0, editor.textField.getSelectionStart());
        String end = source.substring(editor.textField.getSelectionEnd());
        return start + end;
    }
}
