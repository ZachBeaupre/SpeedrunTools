import javax.swing.*;
import java.awt.*;

public class gui{
    public static void main(String args[]){
        JFrame frame = new JFrame("My First GUI");
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        JLabel label = new JLabel("+  ");
        JLabel label2 = new JLabel("0:00.0");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,300);

        JButton button1 = new JButton("ADD");

        JTextField tf = new JTextField(20);
        JTextField tf2 = new JTextField(20); //TEAM FORTRESS 2 CONFIRMED!!?!?!?
        JTextArea ta = new JTextArea();
        JTextArea ta2 = new JTextArea();

        //frame.getContentPane().setBackground(Color.BLUE);
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel2.add(label); // Components Added using Flow Layout
        panel2.add(tf2);
        panel2.add(button1);
        panel2.add(label2);

        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(panel);
        frame.getContentPane().add(panel2);

        //frame.getContentPane().add(panel2, FlowLayout.LEFT);
        //frame.getContentPane().add(BorderLayout.CENTER, ta);
        //frame.getContentPane().add(BorderLayout.CENTER, ta2);
        //frame.getContentPane().add(button1);

        frame.setVisible(true);
    }
    public static double time(double minutes, double seconds){

        return  (seconds) + (int)(minutes * 60.0);
    }


    public static String timeSTR(double seconds){
        int minutes = (int)(seconds / 60.0);
        seconds -= minutes * 60;
        int milliseconds = (int)(seconds*10 % 10);




        return String.format("%d:" + ((seconds > 9) ? "":"0") + "%d.%d", minutes, (int)seconds, milliseconds);
    }
}

