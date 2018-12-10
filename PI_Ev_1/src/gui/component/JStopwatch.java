package gui.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * Stopwatch button that starts the first time that is pressed and asks for
 * a runner number the following ones. Cannot be used if the race is longer
 * than 24 hours (it will start back from zero). It fires an event each time
 * the button is pressed after the first time that returns a {@link gui.component.RunnerTime RunnerTime}
 * @author Alejandro Martínez Remis
 */
public class JStopwatch extends JButton implements Serializable{
    private Date startDate;
    private final SimpleDateFormat format;
    private JStopwatchListener listener;
    
    public JStopwatch(){
        format = new SimpleDateFormat("HH:mm:ss.SSS");
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        setText("00:00:00.000");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClick();
            }
        });
    }
    
    /**
     * Method that controls the logic when the button is pressed.
     */
    private void onClick(){
        if(startDate == null){
            startDate = new Date();
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    long elapsedTime = new Date().getTime() - startDate.getTime();
                    setText(format.format(elapsedTime));
                }
            }, 0, 1);
        }else{
            askForRunner(new Date().getTime() - startDate.getTime());
        }        
    }
    
    /**
     * Shows a dialog to the user to introduce the runner's number.
     * @param elapsedTime The elapsed time in milliseconds
     */
    private void askForRunner(long elapsedTime){
        String str;
        int number = -1;
        boolean error;
        do{
            str = JOptionPane.showInputDialog(this, "Introduzca el dorsal del corredor", "Introduzca dorsal", JOptionPane.QUESTION_MESSAGE);
            try{
                number = Integer.parseInt(str);
                error = false;
            }catch(NumberFormatException e){
                error = true;
            }
        }while(error);
        
        if(listener != null)
            listener.runnerGiven(new RunnerTime(number, elapsedTime));
    }
    
    /**
     * Adds a listener to the component.
     * @param listener 
     */
    public void addJStopwatchListener(JStopwatchListener listener){
        this.listener = listener;
    }
}
