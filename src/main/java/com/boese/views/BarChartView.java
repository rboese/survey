package com.boese.views;

import com.boese.models.Option;
import com.boese.models.Survey;

import javax.swing.*;
import java.awt.*;

public class BarChartView extends JPanel {
    Survey survey;

    public BarChartView(Survey survey) {
        this.survey = survey;
        generateUI();

        survey.registerListener((sender, value) -> {
            if(sender instanceof Survey && value instanceof Option) {
                add(new BarChartViewItem(survey, (Option) value));
                revalidate();
            }
        });
    }

    private void generateUI() {
        setBorder(BorderFactory.createTitledBorder("Balkendiagramm"));
        setLayout(new GridLayout(0, 1));
        survey.getOptions().forEach(o -> add(new BarChartViewItem(survey, o)));
        revalidate();
        repaint();
    }
}
