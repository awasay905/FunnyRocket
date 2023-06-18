package Main;

import Resource.Resources;
import Screens.Screens;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class SwingTimerEx extends JFrame {

    public SwingTimerEx() {
        initUI();
    }

    private void initUI() {

        add(new Board());
        setResizable(false);
        pack();

        setTitle("Graphic Main.Board");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Resources.initializeResources();
        Screens.initializeScreens();
        EventQueue.invokeLater(() -> {
            SwingTimerEx ex = new SwingTimerEx();
            ex.setVisible(true);
        });
    }
}