public class JsonVisitor implements Visitor {
    private  String result = "";
    @Override
    public void drawTask(CompositeTask task, int depth) {
//        String padding = getPadding(depth);
//        System.out.println(padding + "{");
//        System.out.println(padding + "  title: \"" + task.getTitle() + "\",");
//        System.out.println(padding + "  date: \"" + task.getDate() + "\",");
//        System.out.println(padding + "  isComplete: " + task.isComplete() + ",");
//        System.out.println(padding + "  sub: [ ");
//
        result +="{";
        result +="  title: \"" + task.getTitle() + "\",";
        result +="  date: \"" + task.getDate() + "\",";
        result +="  isComplete: " + task.isComplete() + ",";
        result +="  sub: [ ";
    }

//    private String getPadding(int depth) {
//        String padding = "";
//        for (int i=0; i < depth; i++) {
//            padding += "  ";
//        }
//        return padding;
//    }

    @Override
    public void end(int depth, boolean isEnd) {

        result += "  ]";
        result += "}";
        if(!isEnd){
            result +=",";
        }
//        String padding = getPadding(depth);
//        System.out.println(padding + "  ]");
//        System.out.println(padding + "}");
//        if(!isEnd) {
//            System.out.println(",");
//        }

    }

    public String getJson() {
        return  result;
    }
}