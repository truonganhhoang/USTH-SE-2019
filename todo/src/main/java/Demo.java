import controller.Controller;
import view.View;
import model.List;

public class Demo {
    public static void main(String[] args) {
        List myList = new List();
        myList.showList();
        View view = new View(myList);
        Controller controller = new Controller(myList, view);
        controller.setListener();
        controller.updateView(true);
    }
}


