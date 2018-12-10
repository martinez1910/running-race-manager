package gui;

import gui.tablemodel.RunnerTableModel;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.swing.JOptionPane;
import javax.swing.table.TableRowSorter;
import logic.obj.Runner;
import logic.persistance.RepositoryImp;

/**
 * Window that shows the existing runners and allows the user to add, modify or
 * eliminate them.
 * @author Alejandro Martínez Remis
 */
public class RunnerManager extends javax.swing.JFrame {
    private static RunnerManager instance = null;

    private RunnerManager() {
        initComponents();
        myInitComponents();
    }
    
    public static RunnerManager getInstance(){
        if(instance == null)
            instance = new RunnerManager();
        return instance;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrpn_table = new javax.swing.JScrollPane();
        tb_runners = new javax.swing.JTable();
        pn_buttons = new javax.swing.JPanel();
        btn_add = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_remove = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();
        mn_bar = new javax.swing.JMenuBar();
        mn_program = new javax.swing.JMenu();
        mntm_exit = new javax.swing.JMenuItem();
        mn_help = new javax.swing.JMenu();
        mntm_help = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mntm_about = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(RunnerManager.class, "MainWindow.btn_runner.text")); // NOI18N
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/gui/img/runner_woman_x64.png")).getImage());
        setMinimumSize(new java.awt.Dimension(600, 300));

        scrpn_table.setPreferredSize(new java.awt.Dimension(350, 175));

        tb_runners.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tb_runners.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrpn_table.setViewportView(tb_runners);

        pn_buttons.setLayout(new java.awt.GridLayout(1, 4, 18, 0));

        btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/img/add_x12.png"))); // NOI18N
        btn_add.setMnemonic('a');
        btn_add.setText(org.openide.util.NbBundle.getMessage(RunnerManager.class, "RunnerManager.btn_add.text")); // NOI18N
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        pn_buttons.add(btn_add);

        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/img/edit_x12.png"))); // NOI18N
        btn_edit.setMnemonic('d');
        btn_edit.setText(org.openide.util.NbBundle.getMessage(RunnerManager.class, "RunnerManager.btn_edit.text")); // NOI18N
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });
        pn_buttons.add(btn_edit);

        btn_remove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/img/remove_x12.png"))); // NOI18N
        btn_remove.setMnemonic('e');
        btn_remove.setText(org.openide.util.NbBundle.getMessage(RunnerManager.class, "RunnerManager.btn_remove.text")); // NOI18N
        btn_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removeActionPerformed(evt);
            }
        });
        pn_buttons.add(btn_remove);

        jButton4.setText(org.openide.util.NbBundle.getMessage(RunnerManager.class, "RunnerManager.jButton4.text")); // NOI18N
        pn_buttons.add(jButton4);

        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/img/back_x12.png"))); // NOI18N
        btn_back.setMnemonic('v');
        btn_back.setText(org.openide.util.NbBundle.getMessage(RunnerManager.class, "RunnerManager.btn_back.text")); // NOI18N
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        pn_buttons.add(btn_back);

        mn_program.setMnemonic('t');
        mn_program.setText(org.openide.util.NbBundle.getMessage(RunnerManager.class, "RunnerManager.mn_program.text")); // NOI18N
        mn_program.setToolTipText(org.openide.util.NbBundle.getMessage(RunnerManager.class, "RunnerManager.mn_program.toolTipText")); // NOI18N

        mntm_exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        mntm_exit.setMnemonic('c');
        mntm_exit.setText(org.openide.util.NbBundle.getMessage(RunnerManager.class, "RunnerManager.mntm_exit.text")); // NOI18N
        mntm_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mntm_exitActionPerformed(evt);
            }
        });
        mn_program.add(mntm_exit);

        mn_bar.add(mn_program);

        mn_help.setMnemonic('y');
        mn_help.setText(org.openide.util.NbBundle.getMessage(RunnerManager.class, "RunnerManager.mn_help.text")); // NOI18N

        mntm_help.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        mntm_help.setMnemonic('m');
        mntm_help.setText(org.openide.util.NbBundle.getMessage(RunnerManager.class, "RunnerManager.mntm_help.text")); // NOI18N
        mn_help.add(mntm_help);
        mn_help.add(jSeparator2);

        mntm_about.setMnemonic('a');
        mntm_about.setText(org.openide.util.NbBundle.getMessage(RunnerManager.class, "RunnerManager.mntm_about.text")); // NOI18N
        mntm_about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mntm_aboutActionPerformed(evt);
            }
        });
        mn_help.add(mntm_about);

        mn_bar.add(mn_help);

        setJMenuBar(mn_bar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_buttons, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
                    .addComponent(scrpn_table, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrpn_table, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(pn_buttons, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        Utils.allignAndShowWindow(new RunnerForm(this, null), this);
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        int selectedRow = tb_runners.getSelectedRow();
        if(selectedRow == -1){
            Utils.messageInformationSelectRunner(this);
            return;
        }
        Runner runner = RepositoryImp.getInstance().getNonRemovedRunner(tb_runners.convertRowIndexToModel(selectedRow));
        Utils.allignAndShowWindow(new RunnerForm(this, runner), this);
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removeActionPerformed
        int selectedRow = tb_runners.getSelectedRow();
        if(selectedRow == -1){
            Utils.messageInformationSelectRunner(this);
            return;
        }
        if(Utils.messageConfirmationRemoveRunner(this) == JOptionPane.YES_OPTION){
            Runner runner = RepositoryImp.getInstance().getNonRemovedRunners().get(tb_runners.convertRowIndexToModel(selectedRow));
            RepositoryImp.getInstance().removeRunner(runner);
            updateTable();
        }
    }//GEN-LAST:event_btn_removeActionPerformed

    private void mntm_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mntm_exitActionPerformed
        this.dispose();
    }//GEN-LAST:event_mntm_exitActionPerformed

    private void mntm_aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mntm_aboutActionPerformed
        Utils.messageAbout(this);
    }//GEN-LAST:event_mntm_aboutActionPerformed

    private void myInitComponents() {  
        jButton4.setVisible(false);
        updateTable();
        loadHelpDocs();
    }

    /**
     * Loads data into the JTable
     */
    protected void updateTable(){
        Utils.lockCursor(this);
        RunnerTableModel runnerTableModel = new RunnerTableModel(RepositoryImp.getInstance().getNonRemovedRunners());
        tb_runners.setModel(runnerTableModel);
        TableRowSorter<RunnerTableModel> sorter = new TableRowSorter<>(runnerTableModel);
        tb_runners.setRowSorter(sorter);
        /*
        ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
        */
        Utils.unlockCursor(this);
    }
    
    /**
     * Loads JavaHelp documentation and associates components.
     */
    private void loadHelpDocs(){
        try{
            File file = new File("help" +File.separator +"help_set.hs");
            URL url = file.toURI().toURL();

            HelpSet hs = new HelpSet(getClass().getClassLoader(), url);
            HelpBroker hb = hs.createHelpBroker();
            
            hb.enableHelpKey(getRootPane(), "runner_manager", hs);
            hb.enableHelpOnButton(mntm_help, "runner_manager", hs);
        }catch(IllegalArgumentException | MalformedURLException | HelpSetException e){
            e.printStackTrace();
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_remove;
    private javax.swing.JButton jButton4;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuBar mn_bar;
    private javax.swing.JMenu mn_help;
    private javax.swing.JMenu mn_program;
    private javax.swing.JMenuItem mntm_about;
    private javax.swing.JMenuItem mntm_exit;
    private javax.swing.JMenuItem mntm_help;
    private javax.swing.JPanel pn_buttons;
    private javax.swing.JScrollPane scrpn_table;
    private javax.swing.JTable tb_runners;
    // End of variables declaration//GEN-END:variables
}
