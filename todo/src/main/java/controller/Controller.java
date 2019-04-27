package controller;

import model.List;
import model.Task;
import view.View;
import view.TaskPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class Controller {

    protected Controller me;
    protected View view;
    protected List model;
    protected DataConnector data;

    public Controller(List model, View view) {
        me = this;
        this.model = model;
        this.view = view;
        this.data = new DataConnector();
    }

    public View setListener() {
        view.getAddButton().addActionListener(new ClickButtonAction());
        view.getTrashButton().addActionListener(new ClickButtonAction());
        view.getFrame().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    data.writeData(model);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
        return view;
    }

    public void updateView(boolean isFirstTime) {
        if (isFirstTime == true) {
            view.getBox().removeAll();
            view.getTaskPanels().clear();
            for (Task task : model) {
                TaskPanel newTaskPanel = new TaskPanel(task);
                newTaskPanel.getRemoveMe().addActionListener(new ClickButtonAction());
                view.addTask(newTaskPanel);
            }
            view.getFrame().setVisible(true);
        } else {
            view.getFrame().setVisible(true);
        }
    }

    private class ClickButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("Add Task")) {
                String textBox = view.getInputFromDialog();
                if (textBox.length() != 0) {
                    Task myTask = new Task(textBox);
                    myTask.setState("not done");
                    model.add(myTask);
                    model.showList();
                    me.updateView(true);
                }
            }else if (command.equals("Delete All")) {
                view.DeleteConfirmDialog(me, model);
            } else if (command.equals("Remove Me")) {
                JButton source = (JButton) e.getSource();
                int id = view.getTaskPanels().indexOf(source.getParent());
                view.getTaskPanels().remove(source.getParent());
                model.remove(id);
                me.updateView(true);
                model.showList();
            }
        }
    }
}
