package com.boese.views;

import com.boese.models.Option;
import com.boese.models.Survey;

import javax.swing.*;
import java.awt.*;

public class Bar extends JPanel {
    Option option;
    Survey survey;

    public Bar(Survey survey, Option option) {
        this.survey = survey;
        this.option = option;

        survey.registerListener((sender, value) -> repaint());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);

        g.drawRect(10, 0, getWidth() - 20,getHeight() - 20);
        if(survey.getTotalVotes() > 0) {
            g.fillRect(10, 0, option.getCount() * (getWidth() - 20) / survey.getTotalVotes(), getHeight() - 20);
        }
    }
}
