import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Main extends JFrame implements ActionListener{

    private static final long serialVersionUID = 1L;
    public double fraction = 1;
    public double product = 0;
    public boolean start = false;
    public int addsub = 0;
    public boolean clicked = false;
    public JButton calculate = new JButton ("Calculate");
    public JButton stop = new JButton ("Stop");
    public JTextField field = new JTextField();
    public Timer timer = new Timer();

    public static void main(String[] args) {

        new Main().setVisible(true);
        System.out.println("test");
        System.out.println("test2");
        System.out.println("test3");
        System.out.println("test4");
        System.out.println("test5");

    }
    public Main() {
        super("Calculate Pi!");
        setSize (600,600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        //JButton calculate = new JButton ("Calculate");
        calculate.addActionListener(this);
        stop.addActionListener(this);

        //JTextField field = new JTextField();
        add(calculate);
        add(field);
        add(stop);
        field.setText("                                 ");


    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == calculate)
        {
            if (clicked == false) {
                product = (4/fraction);
                start = true;
                Math();
                field.setText(product+"");
                clicked = true;
            }

        }
        if (e.getSource() == stop)
        {

            timer.cancel();
            clicked = false;
        }


    }
    public void Math(){
        if (start);{

            timer.schedule( new TimerTask() {
                public void run() {
                    fraction = fraction + 2;
                    product = product - (4/fraction);
                    fraction = fraction + 2;
                    product = product + (4/fraction);
                    field.setText(product+"");
                }
            }, 0, 1);
        }
    }
}

