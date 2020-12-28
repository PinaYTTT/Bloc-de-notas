package bloc;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author PinaYT
 */
public class Main extends javax.swing.JFrame implements KeyListener {

    Funciones funciones = new Funciones();
    JFileChooser seleccionar = new JFileChooser();
    File archivo;
    FileInputStream entrada;
    FileOutputStream salida;

    public Main() {
        initComponents();
        addKeyListener(this);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtarea = new javax.swing.JTextPane();
        canvas1 = new java.awt.Canvas();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bloc de notas");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);

        txtarea.setName("txtarea"); // NOI18N
        jScrollPane1.setViewportView(txtarea);

        jMenu4.setText("Archivo");

        jMenuItem2.setText("Save");
        jMenuItem2.setActionCommand("btnsave");
        jMenuItem2.setName("btnguardar"); // NOI18N
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsave(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenuItem4.setText("Open");
        jMenuItem4.setToolTipText("");
        jMenuItem4.setActionCommand("btnopen");
        jMenuItem4.setName("btnopen"); // NOI18N
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnopen(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuItem1.setText("Credits");
        jMenuItem1.setActionCommand("btncredits");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncredits(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuItem3.setText("Exit");
        jMenuItem3.setActionCommand("btnexit");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexit(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        jMenuBar3.add(jMenu4);

        setJMenuBar(jMenuBar3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsave(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsave
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Documento de texto (.txt, .docx)", "txt","docx");
        seleccionar.setFileFilter(filter);
        seleccionar.setDialogTitle("Guardar Documento");
        if (seleccionar.showDialog(null, "Guardar") == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionar.getSelectedFile();
            if (archivo.getName().endsWith("txt") || archivo.getName().endsWith("docx")) {
                this.setName(archivo.getName().replace("txt", " "));
                String Documento = txtarea.getText();
                String mensaje = funciones.FuncGuardar(archivo, Documento);
                if (mensaje != null) {
                    JOptionPane.showMessageDialog(null, mensaje);
                    this.setName(archivo.getName());
                } else {
                    JOptionPane.showMessageDialog(null, "Archivo no compatible");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Agrega .txt al final del nombre del archivo!!");
            }
        }
    }//GEN-LAST:event_btnsave

    private void btncredits(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncredits
        Credits c = new Credits();
        c.setVisible(true);
    }//GEN-LAST:event_btncredits

    private void btnopen(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnopen
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Documento de texto (.txt, .docx)", "txt","docx");
        seleccionar.setFileFilter(filter);
        seleccionar.setDialogTitle("Abrir documento");
        if (seleccionar.showDialog(null, "Abrir") == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionar.getSelectedFile();
            if (archivo.canRead()) {
                if (archivo.getName().endsWith("txt") || archivo.getName().endsWith("docx")) {
                    String documento = funciones.FuncAbrir(archivo);
                    txtarea.setText(documento);
                } else {
                    JOptionPane.showMessageDialog(null, "Archivo No Compatible");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error code 2");
            }
        }
    }//GEN-LAST:event_btnopen

    private void btnexit(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexit
        // TODO add your handling code here:
    }//GEN-LAST:event_btnexit

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Canvas canvas1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane txtarea;
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
//
