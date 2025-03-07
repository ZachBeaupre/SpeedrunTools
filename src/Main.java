import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
//this is my first experiment with ui elements and stuff so take this program with a grain of salt

        public static void main(String args[]){
            JFrame frame = new JFrame("Speedrun tools");
            JPanel panel = new JPanel();
            JPanel panel2 = new JPanel();
            JPanel panel3 = new JPanel();
            JLabel label = new JLabel("+");
            JLabel output = new JLabel("0:00.0");
            JLabel output2 = new JLabel("0.0 seconds");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300,150);
            frame.setResizable(false);


            JTextField m1 = new JTextField(2);
            JTextField s1 = new JTextField(2);
            JTextField ms1 = new JTextField(2);
            JTextField m2 = new JTextField(2);
            JTextField s2 = new JTextField(2);
            JTextField ms2 = new JTextField(2);


            //JTextArea ta = new JTextArea();
            //JTextArea ta2 = new JTextArea();
            JButton button1 = new JButton("ADD");
            button1.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {


                    float result = getTimes(m1,s1,ms1,m2,s2,ms2,0); // kinda annoyed i had to make a funciton with a billion parameters just because I wasnt in the right scope to access the ui elements.
//                    System.out.printf("%.1f%n",result);
//                    System.out.printf("%s%n",timeSTR(result));
                    output.setText(timeSTR(result));
                    output2.setText(String.format("%.1f seconds",result));
                }
            });

            JButton button2 = new JButton("SUBTRACT");
            button2.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                   float result = getTimes(m1,s1,ms1,m2,s2,ms2,1);
//                    System.out.printf("%.1f%n",result);
//                    System.out.printf("%s%n",timeSTR(result));
                    output.setText(timeSTR(result));
                    output2.setText(String.format("%.1f seconds",result));

                }
            });

            //frame.getContentPane().setBackground(Color.RED); maybe add some bg colors later or something idk

            panel.add(m1);
            panel.add(new JLabel(":"));
            panel.add(s1);
            panel.add(new JLabel("."));
            panel.add(ms1);
            panel.add(label);
            panel.add(m2);
            panel.add(new JLabel(":"));
            panel.add(s2);
            panel.add(new JLabel("."));
            panel.add(ms2);


            panel2.add(button1);
            panel2.add(button2);

            panel2.add(output);
            panel3.add(output2);

            frame.setLayout(new FlowLayout());
            frame.getContentPane().add(panel);
            frame.getContentPane().add(panel2);
            frame.getContentPane().add(panel3);

            //frame.getContentPane().add(panel2, FlowLayout.LEFT);
            //frame.getContentPane().add(BorderLayout.CENTER, ta);
            //frame.getContentPane().add(BorderLayout.CENTER, ta2);


            frame.setVisible(true);

        }
        public static float time(int minutes, float seconds){

            return  (seconds) + (minutes * 60.0f);
        }//it didnt push lol
    public static float time(int minutes, int seconds,int milliseconds) {

        //Since this program is intended to be used for Jet Moto 2 Speedrunning, this if statement ensures that millisecond values are treated properly.
        //before if you were to enter : 100 in the milliseconds slot, it would divide by 10 and then still be above 1 so it would become 1 second
        if (milliseconds == 0) {
            return (float) (seconds) + (minutes * 60.0f);
        } else {
            return (float)((seconds) + (minutes * 60.0f) + (milliseconds / Math.pow(10.0f, (int)Math.log10(milliseconds))) / 10.0f);
        }

    }


    /**
     * timeSTR takes in a float value that represents seconds, and then converts and
     * prints out in this format
     * M = minutes
     * S = seconds
     * m = milliseconds
     *
     * MM:SS.m
     *
    * */
        public static String timeSTR(float seconds){
            seconds = Math.abs(seconds); //prevents the output from looking like this 0:0-1.0   its disgusting lol
            int minutes = (int)(seconds / 60.0);
            seconds -= minutes * 60;
            String numberD = String.format("%.1f",seconds);
            numberD = numberD.substring(numberD.indexOf(".")+1);
            int milliseconds = Integer.parseInt(numberD);




            return String.format("%d:" + (((int)seconds > 9) ? "":"0") + "%d.%d", minutes, (int)seconds, milliseconds);
        }
    public static float getTimes(JTextField m1, JTextField s1, JTextField ms1, JTextField m2, JTextField s2, JTextField ms2, int operator){

            //Function was added to make sure that I don't break the logic behind the time operations.
        //also now I can account for cases where the text field is blank or something, so yippee I guess...
        int T1_1, T1_2, T1_3;
        try{T1_1 = Integer.parseInt(m1.getText());} catch(NumberFormatException e){T1_1 = 0;}
        try{T1_2 = Integer.parseInt(s1.getText());} catch(NumberFormatException e){T1_2 = 0;}
        try{T1_3 = Integer.parseInt(ms1.getText());} catch(NumberFormatException e){T1_3 = 0;}
        //float T1 = time(T1_1, T1_2+(T1_3/10.0));
        float T1 = time(T1_1, T1_2,(T1_3));

        int T2_1, T2_2, T2_3;
        try{T2_1 = Integer.parseInt(m2.getText());} catch(NumberFormatException e){T2_1 = 0;}
        try{T2_2 = Integer.parseInt(s2.getText());} catch(NumberFormatException e){T2_2 = 0;}
        try{T2_3 = Integer.parseInt(ms2.getText());} catch(NumberFormatException e){T2_3 = 0;}
        float T2 = time(T2_1, T2_2, (T2_3));


if(operator == 0) {
    return T1 + T2;
}else{
    return T1 - T2;
}
    }
}





