import java.util.ArrayList;
import java.util.List;

public class MultiExecutor {

    List<Runnable> runnables = new ArrayList<Runnable>();

    /*
     * @param tasks to executed concurrently
     */
    public MultiExecutor(List<Runnable> tasks) {
        this.runnables = tasks;
    }

    /**
     * Starts and executes all the tasks concurrently
     */
    public void executeAll() {
        this.runnables.forEach(Runnable::run);
    }
}
