package view;

import model.Task;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class TaskPanel extends JPanel {
    TaskPanel me;
    private JCheckBox myCheckBox;
    private JButton removeMe;
    private JTextArea textArea;

    public TaskPanel(Task task) {
        super();
        me = this;
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        // removeMe button setting
        removeMe = new JButton(new ImageIcon("icons/RemoveButton.png"));
        removeMe.setActionCommand("Remove Me");
        removeMe.setBorder(BorderFactory.createEmptyBorder());
        removeMe.setContentAreaFilled(false);
        removeMe.setAlignmentX(Component.RIGHT_ALIGNMENT);

        // Checkbox
        myCheckBox = new JCheckBox();
        myCheckBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        myCheckBox.setAlignmentY(Component.CENTER_ALIGNMENT);
        add(Box.createRigidArea(new Dimension(5, 0)));
        add(myCheckBox);

        // TextArea setting to contain task
        textArea = new JTextArea(task.getContent(), 1, 15);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setMargin(new Insets(10, 10, 10, 10));
        textArea.setOpaque(false);
        add(textArea);
        add(Box.createHorizontalGlue());
        add(removeMe);
        add(Box.createRigidArea(new Dimension(5, 0)));
    }

    public JButton getRemoveMe() {
        return removeMe;
    }

    public JCheckBox getMyCheckBox() {
        return myCheckBox;
    }
}
