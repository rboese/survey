package com.boese.views;

import com.boese.models.Listener;
import com.boese.models.Option;
import com.boese.models.Survey;
import com.boese.models.ValueChangeable;

import javax.swing.*;
import java.awt.*;

public class TextViewItem extends JPanel implements Listener {
    private Survey survey;
    private Option option;
    JTextField textField;

    public TextViewItem(Survey survey, Option option) {
        super();

        this.survey = survey;
        this.option = option;

        generateUI();

        option.registerListener(this);
    }

    private void generateUI() {
        JLabel label = new JLabel(option.getText());
        label.setHorizontalAlignment(JLabel.RIGHT);
        add(label);

        textField  = new JTextField();
        textField.setText(String.format("%d", option.getCount()));
        textField.addActionListener(e -> {
            int number;
            try {
                number = Integer.parseInt(textField.getText());
                if (number >= 0) {
                    option.setCount(number);
                } else {
                    number = option.getCount();
                }
            } catch (NumberFormatException exeption) {
                number = option.getCount();
            }

            textField.setText(String.format("%d", number));
        });
        add(textField);

        setLayout(new GridLayout(0, 2));
        setVisible(true);
    }

    @Override
    public synchronized void raiseEvent(ValueChangeable sender, Object value) {
        if(sender instanceof Survey) {
            return;
        }
        textField.setText(String.format("%d", value));
    }
}
