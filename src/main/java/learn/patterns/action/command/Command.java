package learn.patterns.action.command;

/**
 * The type Command.
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -06-03 3:18 下午 周三
 */
public abstract class Command {
    /**
     * The Editor.
     */
    public Editor editor;
    private String backup;

    /**
     * Instantiates a new Command.
     *
     * @param editor the editor
     */
    Command(Editor editor) {
        this.editor = editor;
    }

    /**
     * Backup.
     */
    void backup() {
        backup = editor.textField.getText();
    }

    /**
     * Undo.
     */
    public void undo() {
        editor.textField.setText(backup);
    }

    /**
     * Execute boolean.
     *
     * @return the boolean
     */
    public abstract boolean execute();
}
