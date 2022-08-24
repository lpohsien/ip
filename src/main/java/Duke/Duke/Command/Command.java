package Duke.Command;

import Duke.TaskList;
import Duke.Ui;
import Duke.FileStorage.Storage;

public abstract class Command {
    public boolean isExit() {
        return false;
    } 
    public abstract void execute(TaskList tasks, Ui ui, Storage storage);
}