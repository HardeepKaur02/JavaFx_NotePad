package TextEditor;

import javax.swing.JFrame;

public class TextEditor {
    public static void main(String args[]){
        textEditorGui obj=new textEditorGui();
        obj.setBounds(0,0,700,700);
        obj.setTitle("My_NotePad");
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
                
    }
    
}
