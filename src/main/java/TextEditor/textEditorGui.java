package TextEditor;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.util.*;
import java.io.*;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
public class textEditorGui extends javax.swing.JFrame {
    String filename;
    Clipboard clipboard=getToolkit().getSystemClipboard();
    /**
     * Creates new form textEditorGui
     */
    public textEditorGui() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        searchButton = new javax.swing.JButton();
        searchTextArea = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        newFile = new javax.swing.JMenuItem();
        openFille = new javax.swing.JMenuItem();
        saveFile = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        cutText = new javax.swing.JMenuItem();
        copyText = new javax.swing.JMenuItem();
        pasteText = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        searchTextArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextAreaActionPerformed(evt);
            }
        });

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(searchTextArea)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchTextArea)
                    .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE))
        );

        jMenu1.setText("File");

        newFile.setText("New");
        newFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFileActionPerformed(evt);
            }
        });
        jMenu1.add(newFile);

        openFille.setText("Open");
        openFille.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFilleActionPerformed(evt);
            }
        });
        jMenu1.add(openFille);

        saveFile.setText("Save");
        saveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileActionPerformed(evt);
            }
        });
        jMenu1.add(saveFile);

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jMenu1.add(exit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        cutText.setText("Cut");
        cutText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutTextActionPerformed(evt);
            }
        });
        jMenu2.add(cutText);

        copyText.setText("Copy");
        copyText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyTextActionPerformed(evt);
            }
        });
        jMenu2.add(copyText);

        pasteText.setText("Paste");
        pasteText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteTextActionPerformed(evt);
            }
        });
        jMenu2.add(pasteText);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchTextAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextAreaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_searchTextAreaActionPerformed

    private void openFilleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFilleActionPerformed
        // TODO add your handling code here:
        FileDialog fileDialog = new FileDialog(textEditorGui.this,"Open File",FileDialog.LOAD);
        fileDialog.setVisible(true);
        if(fileDialog.getFile()!=null){
            filename = fileDialog.getDirectory()+fileDialog.getFile();
            setTitle(filename);
        }
        try{
            BufferedReader reader=new BufferedReader(new FileReader(filename));
            StringBuilder sb=new StringBuilder();
            
            String line=null;
            while((line=reader.readLine())!=null){
                sb.append(line+"\n");
                textArea.setText(sb.toString());
            }
            reader.close();
            
            
        } catch (IOException e){
            System.out.println("File Not Found");
            
        }
        
    }//GEN-LAST:event_openFilleActionPerformed

    private void pasteTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasteTextActionPerformed
        // TODO add your handling code here:
        try{
            Transferable pasteText=clipboard.getContents(textEditorGui.this);
            String pasteStr=(String)pasteText.getTransferData(DataFlavor.stringFlavor);
            textArea.replaceRange(pasteStr,textArea.getSelectionStart(),textArea.getSelectionEnd());
        }
        catch(Exception e){
            System.out.println("Didn't work");
        }
    }//GEN-LAST:event_pasteTextActionPerformed

    private void newFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFileActionPerformed
        //when new button is pressed
        textArea.setText("");
        filename="UnTitleD";
        setTitle(filename);
    }//GEN-LAST:event_newFileActionPerformed

    private void saveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFileActionPerformed
        // TODO add your handling code here:
        FileDialog fileDialog=new FileDialog(textEditorGui.this,"Save File",FileDialog.SAVE);
        fileDialog.setVisible(true);
        
        if(fileDialog.getFile()!=null){
            filename=fileDialog.getDirectory()+fileDialog.getFile();
            setTitle(filename);
        }
        try{
            FileWriter fileWriter=new FileWriter(filename);
            fileWriter.write(textArea.getText());
            setTitle(filename);
            fileWriter.close();
        }
        catch(IOException e){
            System.out.println("File Not Found");
        }
    }//GEN-LAST:event_saveFileActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void cutTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutTextActionPerformed
        // TODO add your handling code here:
        String cutString=textArea.getSelectedText();
        StringSelection cutSelection=new StringSelection(cutString);
        clipboard.setContents(cutSelection,cutSelection);
        textArea.replaceRange("",textArea.getSelectionStart(),textArea.getSelectionEnd());
    }//GEN-LAST:event_cutTextActionPerformed

    private void copyTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyTextActionPerformed
        // TODO add your handling code here:
        String copyText=textArea.getSelectedText();
        StringSelection copyselection=new StringSelection(copyText);
        clipboard.setContents(copyselection, copyselection);
        
    }//GEN-LAST:event_copyTextActionPerformed
    class MyHighlighter extends DefaultHighlighter.DefaultHighlightPainter{
        
        public MyHighlighter(Color c) {
            super(c);
        }    
    }
    DefaultHighlighter.DefaultHighlightPainter highlighter=new MyHighlighter(Color.pink); 
    public void removeHighlight(JTextComponent textComp){
        Highlighter removeHighlighter=textComp.getHighlighter();
        Highlighter.Highlight[] remove=removeHighlighter.getHighlights();
        for(int i=0;i<remove.length;i++){
            if(remove[i].getPainter() instanceof MyHighlighter){
                removeHighlighter.removeHighlight(remove[i]);
            }
        }
        
    }
    
    
    
    public void searchTextArea(JTextComponent textComp,String textString){
        removeHighlight(textComp);
        try{
            Highlighter hilight=textComp.getHighlighter();
            Document doc=textComp.getDocument();
            String text =doc.getText(0,doc.getLength());
            
            int pos=0;
            while((pos=text.toUpperCase().indexOf(textString.toUpperCase(),pos))>=0){
                hilight.addHighlight(pos,pos+textString.length(),highlighter);
                pos+=textString.length();
            }
        }
        catch(Exception e){
        }
    }
    
    
    
    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        searchTextArea(textArea,searchTextArea.getText());
    }//GEN-LAST:event_searchButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(textEditorGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(textEditorGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(textEditorGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(textEditorGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new textEditorGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem copyText;
    private javax.swing.JMenuItem cutText;
    private javax.swing.JMenuItem exit;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem newFile;
    private javax.swing.JMenuItem openFille;
    private javax.swing.JMenuItem pasteText;
    private javax.swing.JMenuItem saveFile;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchTextArea;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
