import java.time.LocalDateTime;
import java.util.*;

public class CommandTask {
    private final CompositeTask task;
    List<Command> commands  =new ArrayList<>();

    private  int cursor = 0;

    private Map<String, String> saved = new HashMap<>();
    public void Save(String key) {
        JsonVisitor visitor = new JsonVisitor();

        Renderer renderer1 = new Renderer(()->visitor);
//        Renderer renderer1 = new Renderer(()->new ConsoleVisitor());
        renderer1.render(task.getReport(CompositeSortType.TITLE_ASC));

        saved.put(key, visitor.getJson());

    }

    public void load(String key) {
        String json = saved.get(key);
        //subtask 삭제 
        //json 순회하면서 복원
    }

    public  void undo() {
        if(cursor < 0) return;
        Command command = commands.get(cursor--);
        command.undo(task);
    }

    public  void redo() {
        if( cursor == commands.size() -1) return;
        commands.get(++cursor).execute(task); //다음것을 실행
    }

    public CommandTask(String title, LocalDateTime date) {
//        setTitle(title);
//        setDate(date);
        task = new CompositeTask(title, date);
    }

    private  void  addCommand(Command command) {
        for (int i = commands.size()-1 ; i >  cursor ; i--) {
            commands.remove(i);
        }
        commands.add(command);
        cursor = commands.size()-1;
        command.execute(task);
    }
    public void toggle() {
        addCommand(new Toggle());
//        Command cmd  = new Toggle();
//        cmd.execute(task);
    }

    public void setTitle(String title) {
//        this.title = title;
        addCommand(new Title(title));
    }

    public void setDate(LocalDateTime date) {

//        this.date = date;
        addCommand(new Date(date));
    }

    public String getTitle() {
        return task.getTitle();
    }

    public LocalDateTime getDate() {
        return task.getDate();
    }

//    public boolean isComplete() {
//        return isComplete;
//    }

    public void addTask(String title, LocalDateTime date) {

//        list.add(new CommandTask(title, date));
        addCommand(new Add(title, date));
    }

    public void removeTask(CompositeTask task) {
//        list.remove(task);
        addCommand(new Remove(task));
    }

    public TaskReport getReport(CompositeSortType type) {
        return task.getReport(type);
    }
}
