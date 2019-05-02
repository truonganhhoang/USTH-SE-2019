import controller.Controller;
import controller.DataConnector;
import view.View;
import model.List;

import java.sql.SQLException;

public class Demo {
    public static void main(String[] args) {
        DataConnector data = new DataConnector();
        List myList = null;
        try {
            myList = data.readData();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        myList.showList();
        View view = new View(myList);
        Controller controller = new Controller(myList, view);
        controller.setListener();
        controller.updateView(true);
    }
}
