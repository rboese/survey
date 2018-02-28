package com.boese.views;

import com.boese.models.Listener;
import com.boese.models.Option;
import com.boese.models.Survey;
import com.boese.models.ValueChangeable;

import javax.swing.*;
import java.awt.*;

public class LabelView extends JPanel implements Listener {
    private Survey survey;

    public LabelView(Survey survey) {
        super();
        this.survey = survey;
        generateUI();
        survey.registerListener(this);
    }

    private void generateUI() {
        setBorder(BorderFactory.createTitledBorder("Erhoehen"));
        setLayout(new GridLayout(0, 1));
        for(Option o : survey.getOptions()) {
            LabelViewItem lvi = new LabelViewItem(survey, o);
            add(lvi);
        }
        setVisible(true);
        revalidate();
        repaint();
    }


    @Override
    public synchronized void raiseEvent(ValueChangeable sender, Object value) {
        if(sender instanceof Survey && value instanceof Option) {
            LabelViewItem lvi = new LabelViewItem(survey, (Option)value);
            add(lvi);
            revalidate();
            repaint();
        }
    }
}
