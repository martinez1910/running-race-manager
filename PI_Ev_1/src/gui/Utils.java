package gui;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Window;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class Utils {
    
    /**
     * Sets the frame in the centre of the given Window (parent) and sets it visible.
     * Useful to use like <code>allignAndShowWindow(new JFrame(), this)</code>.
     * @param frame
     * @param parent
     */
    protected static void allignAndShowWindow(Window frame, Window parent){
        if(frame instanceof JDialog)
            frame.pack();
        frame.setLocationRelativeTo(parent);
        frame.setVisible(true);
    }
    
    protected static void messageInformationSelectRunner(Component parent){
        JOptionPane.showMessageDialog(parent, "Por favor, seleccione un/a corredor/a.", "Información",JOptionPane.INFORMATION_MESSAGE);
    }
    
    protected static void messageErrorAddRunner(Component parent){
        JOptionPane.showMessageDialog(parent, "El/La corredor/a que intenta añadir ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    protected static int messageConfirmationRemoveRunner(Component parent){
       return JOptionPane.showOptionDialog(parent, "¿Está seguro que desea eliminar este/a corredor/a?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
    }
    
    protected static void messageInformationSelectRace(Component parent){
        JOptionPane.showMessageDialog(parent, "Por favor, seleccione una carrera.", "Información",JOptionPane.INFORMATION_MESSAGE);
    }
    
    protected static void messageErrorAddRace(Component parent){
        JOptionPane.showMessageDialog(parent, "La carrera que intenta añadir ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    protected static int messageConfirmationRemoveRace(Component parent){
       return JOptionPane.showOptionDialog(parent, "¿Está seguro que desea eliminar esta carrera?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
    }
    
    protected static void messageErrorAddRunnerInRace(Component parent){
        JOptionPane.showMessageDialog(parent, "No puede añadir más participantes. Incremente el número máximo de participantes permitidos.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    protected static int messageConfirmationStartRace(Component parent){
       return JOptionPane.showOptionDialog(parent, "¿Está seguro que desea iniciar la carrera?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
    }
    
    protected static void messageErrorStartRace(Component parent){
        JOptionPane.showMessageDialog(parent, "No puede iniciar una carrera que tenga menos de 2 participantes.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    protected static int messageConfirmationFinishRace(Component parent){
       return JOptionPane.showOptionDialog(parent, "¿Está seguro que desea finalizar esta carrera?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
    }
    
    protected static int messageConfirmationCancelRace(Component parent){
       return JOptionPane.showOptionDialog(parent, "¿Está seguro que desea cancelar esta carrera? Se perderán todos los datos.", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
    }
    
    protected static void lockCursor(Component component){
        component.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    }
    
    protected static void unlockCursor(Component component){
        component.setCursor(Cursor.getDefaultCursor());
    }
}
