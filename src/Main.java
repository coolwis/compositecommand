import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        CommandTask root = new CommandTask("Root", LocalDateTime.now());
        root.addTask("sub1", LocalDateTime.now());  //CompositeTask
        root.addTask("sub2", LocalDateTime.now());

        Renderer renderer1 = new Renderer(()->new JsonVisitor());
//        Renderer renderer1 = new Renderer(()->new ConsoleVisitor());
        renderer1.render(root.getReport(CompositeSortType.TITLE_ASC));

        root.undo();
        renderer1.render(root.getReport(CompositeSortType.TITLE_ASC));

        root.undo();
        renderer1.render(root.getReport(CompositeSortType.TITLE_ASC));
        System.out.println("\n================================");
        root.redo();
        renderer1.render(root.getReport(CompositeSortType.TITLE_ASC));


        //root-> CompositeTask 2개

//        TaskReport report = root.getReport(CompositeSortType.TITLE_ASC); //report 2개 갖고 있는 report
//        List<TaskReport> list = report.getList();//2개 report
//        CompositeTask sub1 = list.get(0).getTask(); //sub1
//        Compos    ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,                             iteTask sub2 = list.get(1).getTask(); //sub2
//        sub1.addTask("sub1_1", LocalDateTime.now()); //하위에 2개 compositeTask
//        sub1.addTask("sub1_2", LocalDateTime.now());
//
//        sub2.addTask("sub2_1", LocalDateTime.now());
//        sub2.addTask("sub2_2", LocalDateTime.now());

//        Renderer renderer1 = new Renderer(()->new ConsoleVisitor());
//        renderer1.render(root.getReport(CompositeSortType.TITLE_ASC));

//        Renderer renderer2 = new Renderer(()->new JsonVisitor());
//        renderer2.render(root.getReport(CompositeSortType.TITLE_ASC));
    }
}