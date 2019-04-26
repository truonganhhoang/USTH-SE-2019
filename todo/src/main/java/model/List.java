package model;

import java.util.ArrayList;

public class List extends ArrayList<Task> {
    public void showList() {
        System.out.println("List Info:");
        for (int i = 0; i < this.size(); i++) {
            System.out.println(this.get(i).getContent() + "/" + this.get(i).getState());
        }
    }
}
