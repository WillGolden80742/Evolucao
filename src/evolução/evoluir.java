/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package evolução;

import com.formdev.flatlaf.FlatDarkLaf;
import java.util.Random;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author will
 */
public class evoluir extends javax.swing.JFrame {

    /**
     * Creates new form Vigene
     */
    public evoluir() {
        initComponents();
        setLocation(200, 200);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        evoluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        input = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        output = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Evolução");

        evoluir.setText("Evoluir");
        evoluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                evoluirActionPerformed(evt);
            }
        });

        input.setColumns(20);
        input.setRows(5);
        jScrollPane1.setViewportView(input);

        jLabel1.setText("Resultado");

        output.setColumns(20);
        output.setRows(5);
        jScrollPane2.setViewportView(output);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
            .addComponent(evoluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(evoluir, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void evoluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_evoluirActionPerformed
        new Thread(evoluirR).start();
        output.setText("");
    }//GEN-LAST:event_evoluirActionPerformed

    private final Runnable evoluirR = new Runnable() {
        @Override
        public void run() {
            int sizeChar = input.getText().length(), randomChar = 0, equal = 0, cont = 0;
            String charsS = input.getText();
            char[] chars = new char[sizeChar], randomChars = new char[sizeChar];

            Random random = new Random();

            for (int i = 0; i < sizeChar; i++) {
                chars[i] = charsS.charAt(i);
            }

            for (int i = 0; i < sizeChar; i++) {
                randomChars[i] = (char) random.nextInt(256);
            }

            do {
                cont++;
                output.append(cont+" tentativa : \n");
                equal = 0;
                for (int i = 0; i < sizeChar; i++) {
                    if (chars[i] != randomChars[i]) {
                        randomChar = (char) random.nextInt(256);
                        randomChars[i] = (char) randomChar;
                    } else {
                        equal++;
                    }
                    output.append(String.valueOf(randomChars[i]));
                }
                output.append("\n");
            } while (equal != sizeChar);
        }
    };

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("Failed to initialize LaF");
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new evoluir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton evoluir;
    private javax.swing.JTextArea input;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea output;
    // End of variables declaration//GEN-END:variables
}
