package test2;

import javax.swing.*;

class FailDialog extends JDialog
{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    public FailDialog()
    {
        setTitle("Incorrect username or password");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        add(new JLabel("Incorrect username or password"));
    }
}
