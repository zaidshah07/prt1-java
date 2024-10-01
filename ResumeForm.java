import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResumeForm extends JFrame implements ActionListener {

    private JTextField nameField, ageField, educationField, experienceField;
    private JTextArea addressField;
    private JRadioButton undergradRadioButton, gradRadioButton;
    private JRadioButton maleRadio, femaleRadio, otherRadio;
    private ButtonGroup genderGroup;
    private JCheckBox javaCheckBox, pythonCheckBox, javascriptCheckBox;
    private JButton submitButton, clearButton, uploadButton;
    private JFileChooser fileChooser;
    private JComboBox<String> experienceComboBox;
    private ButtonGroup educationLevelGroup;
    private JLabel resumeLabel;

    public ResumeForm() {

        setTitle("Enhanced Student Resume Form");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new GridLayout(11, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Age:"));
        ageField = new JTextField();
        panel.add(ageField);

        panel.add(new JLabel("Gender:"));
        maleRadio = new JRadioButton("Male");
        femaleRadio = new JRadioButton("Female");
        otherRadio = new JRadioButton("Other");
        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        genderGroup.add(otherRadio);
        JPanel genderPanel = new JPanel();
        genderPanel.add(maleRadio);
        genderPanel.add(femaleRadio);
        genderPanel.add(otherRadio);
        panel.add(genderPanel);

        panel.add(new JLabel("Address:"));
        addressField = new JTextArea(3, 20);
        panel.add(new JScrollPane(addressField));

        panel.add(new JLabel("Education Level:"));
        JPanel educationPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        undergradRadioButton = new JRadioButton("Undergraduate");
        gradRadioButton = new JRadioButton("Graduate");
        educationLevelGroup = new ButtonGroup();
        educationLevelGroup.add(undergradRadioButton);
        educationLevelGroup.add(gradRadioButton);
        educationPanel.add(undergradRadioButton);
        educationPanel.add(gradRadioButton);
        panel.add(educationPanel);

        panel.add(new JLabel("Skills:"));
        JPanel skillsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        javaCheckBox = new JCheckBox("Java");
        pythonCheckBox = new JCheckBox("Python");
        javascriptCheckBox = new JCheckBox("JavaScript");
        skillsPanel.add(javaCheckBox);
        skillsPanel.add(pythonCheckBox);
        skillsPanel.add(javascriptCheckBox);
        panel.add(skillsPanel);

        panel.add(new JLabel("Education:"));
        educationField = new JTextField();
        panel.add(educationField);

        panel.add(new JLabel("Experience (Years):"));
        String[] experienceOptions = {"0-1", "1-3", "3-5", "5+"};
        experienceComboBox = new JComboBox<>(experienceOptions);
        panel.add(experienceComboBox);

        panel.add(new JLabel("Upload Resume:"));
        uploadButton = new JButton("Choose File");
        uploadButton.addActionListener(this);
        panel.add(uploadButton);
        resumeLabel = new JLabel("No file chosen");
        panel.add(resumeLabel);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        panel.add(submitButton);

        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        panel.add(clearButton);
        
        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String resumeDetails = "Name: " + nameField.getText() +
                    "\nAge: " + ageField.getText() +
                    "\nGender: " + (maleRadio.isSelected() ? "Male" : femaleRadio.isSelected() ? "Female" : "Other") +
                    "\nAddress: " + addressField.getText() +
                    "\nEducation Level: " + (undergradRadioButton.isSelected() ? "Undergraduate" : "Graduate") +
                    "\nSkills: " + (javaCheckBox.isSelected() ? "Java " : "") +
                    (pythonCheckBox.isSelected() ? "Python " : "") +
                    (javascriptCheckBox.isSelected() ? "JavaScript " : "") +
                    "\nEducation: " + educationField.getText() +
                    "\nExperience: " + experienceComboBox.getSelectedItem();
            JOptionPane.showMessageDialog(this, resumeDetails, "Resume Submitted", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == clearButton) {
            nameField.setText("");
            ageField.setText("");
            genderGroup.clearSelection();
 	    experienceComboBox.setSelectedIndex(0);
            addressField.setText("");
            educationLevelGroup.clearSelection();
            javaCheckBox.setSelected(false);
            pythonCheckBox.setSelected(false);
            javascriptCheckBox.setSelected(false);
            educationField.setText("");
            resumeLabel.setText("No file chosen");
        } else if (e.getSource() == uploadButton) {
            fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                resumeLabel.setText(fileChooser.getSelectedFile().getName());
            } else {
                resumeLabel.setText("No file chosen");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ResumeForm().setVisible(true);
        });
    }
}
