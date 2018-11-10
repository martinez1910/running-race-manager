package gui;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Window;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Utils {
    
    /**
     * Sets the frame in the centre of the given JFrame (parent) and sets it visible.
     * Useful to use like 'allignAndShowFrame(new JFrame(), this)'.
     * @param frame
     * @param parent
     */
    protected static void allignAndShowFrame(Window frame, Window parent){
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
    
    protected static void lockCursor(JFrame frame){
        frame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    }
    
    protected static void unlockCursor(JFrame frame){
        frame.setCursor(Cursor.getDefaultCursor());
    }
}