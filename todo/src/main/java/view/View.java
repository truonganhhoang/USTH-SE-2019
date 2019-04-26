package view;

import controller.Controller;
import model.Task;
import model.List;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class View extends JFrame {
    private JFrame myFrame;
    private JPanel northPanel;
    private JPanel centerPanel;
    private JScrollPane scrollPanel;
    private JPanel southPanel;
    private JLabel statusLabel;
    private ArrayList<TaskPanel> taskPanel;
    private JLabel ToDoLabel;
    private JButton addButton;
    private JButton trashButton;
    private Box myBox;

    public View(ArrayList<Task> myList) {
        taskPanel = new ArrayList<TaskPanel>();
        this.setTitle("Todo List");
        myFrame = this;
        ToDoLabel = new JLabel("Todo List");
        northPanel = new JPanel();
        southPanel = new JPanel();
        centerPanel = new JPanel();

        statusLabel = new JLabel("Hi there!");
        trashButton = new JButton(new ImageIcon("icons/TrashButton.png"));

        // add button setting
        addButton = new JButton(new ImageIcon("icons/AddButton.png"));
        addButton.setActionCommand("Add Task");
        addButton.setBorder(BorderFactory.createEmptyBorder());
        addButton.setContentAreaFilled(false);
        addButton.setFocusPainted(false);

        //trashButton setting
        trashButton.setActionCommand("Delete All");
        trashButton.setBorder(BorderFactory.createEmptyBorder());
        trashButton.setContentAreaFilled(false);
        trashButton.setFocusPainted(false);

        // myBox setting
        myBox = Box.createVerticalBox();
        myBox.setAlignmentX(Component.LEFT_ALIGNMENT);

        //frame setting
        this.setSize(300, 400);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        //panel setting
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.LINE_AXIS));
        northPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        northPanel.add(addButton);
        northPanel.add(Box.createHorizontalGlue());
        northPanel.add(ToDoLabel);
        northPanel.add(Box.createHorizontalGlue());
        northPanel.add(trashButton);
        northPanel.add(Box.createRigidArea(new Dimension(10, 50)));



        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.PAGE_AXIS));
        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        southPanel.add(statusLabel);

        // TodoLabel setting
        ToDoLabel.setFont(new Font("Cooper Black", Font.BOLD, 30));

        //add components to frame
        centerPanel.add(myBox);
        scrollPanel = new JScrollPane(centerPanel);
        scrollPanel.setBorder(null);
        this.add(scrollPanel);
        this.add(southPanel, BorderLayout.SOUTH);
        this.add(northPanel, BorderLayout.NORTH);
        this.setVisible(true);
    }

    public void addTask(TaskPanel myTaskPanel) {
        taskPanel.add(myTaskPanel);
        myTaskPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        myBox.add(myTaskPanel);
        this.setVisible(true);
    }

    public String getInputFromDialog() {
        return JOptionPane.showInputDialog("Enter your plan: ");
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getTrashButton() {
        return trashButton;
    }

    public Box getBox() {
        return myBox;
    }

    public JFrame getFrame() {
        return myFrame;
    }

    public ArrayList<TaskPanel> getTaskPanels() {
        return taskPanel;
    }

    public void DeleteConfirmDialog(Controller me, List model) {
        int response = JOptionPane.showConfirmDialog(null, "Are you sure to delete all tasks?", "Warning",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.NO_OPTION) {
            System.out.println("No button clicked");
        } else if (response == JOptionPane.YES_OPTION) {
            System.out.println("Yes button clicked");
            model.clear();
            me.updateView(true);
        } else if (response == JOptionPane.CLOSED_OPTION) {
            System.out.println("JOptionPane closed");
        }
    }

}