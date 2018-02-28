package com.boese.views;

import com.boese.models.Option;
import com.boese.models.Survey;

import javax.swing.*;
import java.awt.*;

public class BarChartViewItem extends JPanel {

    Option option;
    Survey survey;
    public BarChartViewItem(Survey survey, Option option) {
        this.survey = survey;
        this.option = option;

        generateUI();
    }

    private void generateUI() {
        setLayout(new GridLayout(0, 2));
        add(new JLabel(option.getText()));
        add(new Bar(survey, option));
    }
}
