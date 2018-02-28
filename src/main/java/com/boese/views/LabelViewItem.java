package com.boese.views;

import com.boese.models.Listener;
import com.boese.models.Option;
import com.boese.models.Survey;
import com.boese.models.ValueChangeable;

import javax.swing.*;
import java.awt.*;

public class LabelViewItem extends JPanel implements Listener {
    private Survey survey;
    private Option option;
    private JLabel label = new JLabel();

    public LabelViewItem(Survey survey, Option option) {
        super();
        this.survey = survey;
        this.option = option;
        generateUI();
        option.registerListener(this);
        survey.registerListener(this);
    }

    private void generateUI() {
        JButton button = new JButton("Erhoehen");
        button.addActionListener((e) -> option.increaseCount());
        label.setText(generateLabelText());
        label.setHorizontalAlignment(JLabel.RIGHT);
        add(label);
        add(button);
        setLayout(new GridLayout(0, 2));
        setVisible(true);
        repaint();
    }

    private String generateLabelText() {
        int count = option.getCount();
        int total = survey.getTotalVotes();
        return String.format("%s: %d von %d (%d%%)", option.getText(),
                count,
                total,
                (total == 0) ? 0 : (count * 100 / total));
    }

    @Override
    public synchronized void raiseEvent(ValueChangeable sender, Object value) {
        if(sender instanceof Survey) {
            return;
        }
        label.setText(generateLabelText());
    }
}
