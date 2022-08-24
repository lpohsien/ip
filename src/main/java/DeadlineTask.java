import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a time-sensitive task that has a deadline.
 */
public class DeadlineTask extends Task{

    /** The deadline for the task. */
    private LocalDateTime deadline = null;

    /**
     * Constructor for an deadline task.
     * @param description A description of the deadline
     * @param deadline The time at which the task will expire
     */
    public DeadlineTask(String description, LocalDateTime deadline) {
        super(description, TaskType.DEADLINE);
        this.deadline = deadline;
    }

    public DeadlineTask(String description, LocalDateTime deadline, boolean isMarked) {
        super(description, TaskType.DEADLINE, isMarked);
        this.deadline = deadline;
    }

    /**
     * Returns tthe string representation of the deadline.
     * @return String representation of the deadline
     */
    @Override
    public String toString() {
        return String.format("%s (by: %s)", 
                super.toString(), 
                this.deadline.format(DateTimeFormatter.ofPattern("d/MMM/yy HH:mm")));
    }

    /**
     * Encodes the deadline for storage.
     * Format of the deadline is TASK_TYPE|IS_MARKED|DESCRIPTION|TIME. Note, time is 
     * encoded in ISO compliant format.
     * @return String encoding of the deadline.
     */
    @Override
    public String encodeForStorage() {
        return String.format("%s|%s", super.encodeForStorage(), this.deadline.toString());
    }
}
