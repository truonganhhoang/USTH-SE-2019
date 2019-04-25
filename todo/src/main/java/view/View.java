package view;
import model.Task;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;

public class View extends JFrame {
    private JFrame myFrame;
    private JPanel northPanel;
    private JPanel centerPanel;
    private JScrollPane scrollPanel;
    private JPanel southPanel;
    private JLabel statusLabel;
    private TaskPanel taskPanel;
    private JLabel ToDoLabel;

    public View() {
        taskPanel = new TaskPanel(new Task("hello world"));
        this.setTitle("Todo List");
        myFrame = this;
        ToDoLabel = new JLabel("Todo List");
        northPanel = new JPanel();
        southPanel = new JPanel();
        centerPanel = new JPanel();

        statusLabel = new JLabel("Hi there!");

        //frame setting
        this.setSize(300, 400);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        //panel setting
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.LINE_AXIS));

        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.PAGE_AXIS));
        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        southPanel.add(statusLabel);

        // TodoLabel setting
        ToDoLabel.setFont(new Font("Cooper Black", Font.BOLD, 30));

        //add components to frame
        centerPanel.add(taskPanel);
        scrollPanel = new JScrollPane(centerPanel);
        scrollPanel.setBorder(null);
        this.add(scrollPanel);
        this.add(southPanel, BorderLayout.SOUTH);
        this.add(northPanel, BorderLayout.NORTH);

        this.setVisible(true);
    }
}