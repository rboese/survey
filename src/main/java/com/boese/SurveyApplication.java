package com.boese;

import com.boese.models.Option;
import com.boese.models.Survey;
import com.boese.views.*;

import javax.swing.*;
import java.awt.*;

public class SurveyApplication {
    public static void main(String... args) {
        enableHighResolutionHandling();
        if(args.length < 1) {
            System.out.println("Needs question as parameter");
            return;
        }

        Survey survey = new Survey(args[0]);
        for(int i = 1; i < args.length; i++) {
            survey.addOption(new Option(args[i]));
        }

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Survey");
            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            frame.setSize(new Dimension(1600, 600));

            JPanel topPanel = new JPanel();
            topPanel.setLayout(new GridLayout(0, 2));
            topPanel.add(new QuestionView(survey));
            topPanel.add(new AddOptionView(survey));
            frame.add(topPanel, BorderLayout.NORTH);

            JPanel centerPanel = new JPanel();
            centerPanel.setLayout(new GridLayout(0, 2));
            centerPanel.add(new LabelView(survey));
            centerPanel.add(new TextView(survey));
            centerPanel.add(new PieChartView(survey));
            centerPanel.add(new BarChartView(survey));
            frame.add(centerPanel, BorderLayout.CENTER);

            frame.setVisible(true);
            frame.revalidate();
            frame.repaint();
        });
    }

    private static void enableHighResolutionHandling()
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (UnsupportedLookAndFeelException e)
        {
            e.printStackTrace();
        }
    }
}
