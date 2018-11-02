package test2;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

class LoginTestFrame extends JFrame
{
    // 默认大小
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 300;

    //north panel
    private final JPanel northPanel;
    private final JTextField textField = new JTextField();
    private final JPasswordField passwordField = new JPasswordField();

    //center panel
    private final HashMap<String, String> userInfo = new HashMap<>();
    private final JTextArea textArea = new JTextArea(8, 40);
    private final JScrollPane scrollPane;

    //south panel
    private final JPanel southPanel;
    private final JButton insertButton;
    private final JButton loginButton;

    //frame
    private FailDialog failDialog;
    private MainFrame mainFrame;

    public LoginTestFrame()
    {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        //north panel
        northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2, 2));
        northPanel.add(new JLabel("User name: ", SwingConstants.RIGHT));
        northPanel.add(textField);
        northPanel.add(new JLabel("Password: ", SwingConstants.RIGHT));
        northPanel.add(passwordField);
//************************************************************************************************
        //center panel
        scrollPane = new JScrollPane(textArea);
//************************************************************************************************
        //south panel
        southPanel = new JPanel();
        //initialize Button
        insertButton = new JButton("Register");
        loginButton = new JButton("Sign in");
        //associate actions with insertButton
        insertButton.addActionListener(event ->
        {
            textArea.append("User name: " + textField.getText() + "\n"
                    + "Password: " + new String(passwordField.getPassword()) + "\n\n");
            userInfo.put(textField.getText(), new String(passwordField.getPassword()));
        });

        loginButton.addActionListener(event ->
        {
            String tempUserName = textField.getText();
            String tempCorrectPass = userInfo.get(tempUserName);
            //incorrect user name
            //incorrect password
            if (tempCorrectPass == null)
            {
                loginFail();
            } else if (tempCorrectPass.equals(new String(passwordField.getPassword())))
            {
                loginSuccess();
            } else
            {
                loginFail();
            }

        });
        southPanel.add(insertButton);
        southPanel.add(loginButton);

        //add panel into frame
        add(northPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    private void loginSuccess()
    {
        if (mainFrame == null)
        {
            mainFrame = new MainFrame();
            mainFrame.setVisible(true);
            setVisible(false);
        }
    }

    private void loginFail()
    {
        if (failDialog == null)
        {
            failDialog = new FailDialog();
            failDialog.setVisible(true);
        }
    }
}
