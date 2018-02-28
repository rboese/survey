package com.boese.views;

import com.boese.models.Option;
import com.boese.models.Survey;

import javax.swing.*;
import java.awt.*;

public class AddOptionView extends JPanel {
    private Survey survey;

    public AddOptionView(Survey survey) {
        this.survey = survey;

        generateUI();
    }

    private void generateUI() {
        setBorder(BorderFactory.createTitledBorder("Neue Antwortmoeglichkeit hinzufuegen"));
        setLayout(new GridLayout(0, 2));
        add(new JLabel("Zusaetzliche Antwortmoeglichkeit: "));
        JTextField textField = new JTextField();
        textField.addActionListener(e -> {
            if(textField.getText().length() == 0) {
                return;
            }

            survey.addOption(new Option(textField.getText()));
            textField.setText("");
        });

        add(textField);
    }
}
