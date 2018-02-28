package com.boese.views;

import com.boese.models.Survey;

import javax.swing.*;
import java.awt.*;

public class QuestionView extends JPanel {
    private Survey survey;

    public QuestionView(Survey survey) {
        super();
        this.survey = survey;

        SwingUtilities.invokeLater(() -> generateUI());
    }

    private void generateUI() {
        setBorder(BorderFactory.createTitledBorder("Frage"));
        JLabel label = new JLabel(survey.getQuestion());
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        add(label);
        setVisible(true);
    }
}
