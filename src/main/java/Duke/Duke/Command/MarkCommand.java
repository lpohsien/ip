package Duke.Command;

import Duke.TaskList;
import Duke.Ui;
import Duke.FileStorage.Storage;
import Duke.Task.Task;

public class MarkCommand extends Command{

    private int taskID;
    private Task markedTask;

    public MarkCommand(int taskID) {
        this.taskID = taskID;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        this.markedTask = tasks.markTask(this.taskID);
        storage.writeListToFile(tasks);
        ui.showResponse(String.format("%s\nNow still you have %d tasks in the list.", 
                this.toString(), tasks.getNumOfTasks()));
    }

    @Override public String toString() {
        return String.format("Nice. I've marked this task:\n   %s", 
                this.markedTask.toString());
    }
}