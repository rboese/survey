package com.boese.views;

import com.boese.models.Listener;
import com.boese.models.Option;
import com.boese.models.Survey;
import com.boese.models.ValueChangeable;

import javax.swing.*;
import java.awt.*;

public class TextView extends JPanel implements Listener {
    private Survey survey;

    public TextView(Survey survey) {
        super();
        this.survey = survey;
        generateUI();
        survey.registerListener(this);
    }

    private void generateUI() {
        setBorder(BorderFactory.createTitledBorder("Setzen"));
        setLayout(new GridLayout(0, 1));
        for(Option o : survey.getOptions()) {
            TextViewItem tvi = new TextViewItem(survey, o);
            add(tvi);
        }
        setVisible(true);
        revalidate();
        repaint();
    }

    @Override
    public void raiseEvent(ValueChangeable sender, Object value) {
        if(sender instanceof Survey && value instanceof Option) {
            TextViewItem tvi = new TextViewItem(survey, (Option)value);
            add(tvi);
            revalidate();
            repaint();
        }
    }
}
