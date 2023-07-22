

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordGeneratorGUI {
    private JFrame frame;
    private JTextField lengthField;
    private JCheckBox uppercaseCheckbox;
    private JCheckBox lowercaseCheckbox;
    private JCheckBox numbersCheckbox;
    private JCheckBox specialCharactersCheckbox;
    private JButton generateButton;
    private JTextArea resultArea;

    public PasswordGeneratorGUI() {
        frame = new JFrame("Random Password Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JPanel optionsPanel = createOptionsPanel();
        JPanel generatePanel = createGeneratePanel();

        frame.add(optionsPanel, BorderLayout.CENTER);
        frame.add(generatePanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private JPanel createOptionsPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        JLabel lengthLabel = new JLabel("Password Length:");
        lengthField = new JTextField(10);
        lengthField.setText("12");

        JLabel uppercaseLabel = new JLabel("Include Uppercase Letters:");
        uppercaseCheckbox = new JCheckBox();

        JLabel lowercaseLabel = new JLabel("Include Lowercase Letters:");
        lowercaseCheckbox = new JCheckBox();

        JLabel numbersLabel = new JLabel("Include Numbers:");
        numbersCheckbox = new JCheckBox();

        JLabel specialCharactersLabel = new JLabel("Include Special Characters:");
        specialCharactersCheckbox = new JCheckBox();

        panel.add(lengthLabel);
        panel.add(lengthField);
        panel.add(uppercaseLabel);
        panel.add(uppercaseCheckbox);
        panel.add(lowercaseLabel);
        panel.add(lowercaseCheckbox);
        panel.add(numbersLabel);
        panel.add(numbersCheckbox);
        panel.add(specialCharactersLabel);
        panel.add(specialCharactersCheckbox);

        return panel;
    }

    private JPanel createGeneratePanel() {
        JPanel panel = new JPanel(new FlowLayout());

        generateButton = new JButton("Generate Password");
        resultArea = new JTextArea(5, 20);
        resultArea.setEditable(false);

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int passwordLength = Integer.parseInt(lengthField.getText());
                boolean includeUpperCase = uppercaseCheckbox.isSelected();
                boolean includeLowerCase = lowercaseCheckbox.isSelected();
                boolean includeNumbers = numbersCheckbox.isSelected();
                boolean includeSpecialCharacters = specialCharactersCheckbox.isSelected();

                String password = PasswordGenerator.generateRandomPassword(
                        passwordLength, includeUpperCase, includeLowerCase, includeNumbers, includeSpecialCharacters
                );

                resultArea.setText(password);
            }
        });

        panel.add(generateButton);
        panel.add(resultArea);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PasswordGeneratorGUI();
            }
        });
    }
}
