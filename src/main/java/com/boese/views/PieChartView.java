package com.boese.views;

import com.boese.models.Option;
import com.boese.models.Survey;

import javax.swing.*;
import java.awt.*;

public class PieChartView extends JPanel {
    Survey survey;

    private static final Color[] colorArray = new Color[]{
            Color.BLACK,
            Color.BLUE,
            Color.GREEN,
            Color.RED,
            Color.ORANGE,
            Color.CYAN
    };

    public PieChartView(Survey survey) {
        this.survey = survey;

        survey.registerListener(((sender, value) -> repaint()));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        final int minOffsetX = 30;
        final int minOffsetY = 30;

        int startAngle = 0;

        int colorIndex = 0;

        int radius = Math.min((getWidth() - 2 * minOffsetX) / 2, (getHeight() - 2 * minOffsetY) / 2);

        int offsetX = getWidth() / 2 - radius;
        int offsetY = getHeight() / 2 - radius;


        for(Option o : survey.getOptions()) {
            g.setColor(colorArray[colorIndex]);
            g.fillArc(offsetX,
                    offsetY,
                    2 * radius,
                    2 * radius,
                    startAngle,
                    calculateAngle(o)
            );
            colorIndex++;
            if(colorIndex == colorArray.length) {
                colorIndex = 0;
            }

            startAngle += calculateAngle(o);
        }
    }

    private int calculateAngle(Option o) {
        int total = survey.getTotalVotes();

        if(total == 0) {
            return 360;
        }

        return 360 * o.getCount() / total;
    }
}
