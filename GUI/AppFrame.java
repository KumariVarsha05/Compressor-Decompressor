package GUI;

import compressordecompressor.Compressor;
import compressordecompressor.Decompressor;
import java.io.File;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppFrame extends JFrame implements ActionListener {

    JButton compressButton;
    JButton decompressButton;

    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        compressButton = new JButton("Select file to compress");
        compressButton.addActionListener(this);
        compressButton.setBounds(40,100,200,30);

        decompressButton = new JButton("Select file to decompress");
        decompressButton.addActionListener(this);
        decompressButton.setBounds(250,100,200,30);

        this.add(compressButton);
        this.add(decompressButton);
        this.setSize(500,250);
        this.getContentPane().setBackground(Color.black);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==compressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);

            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    Compressor.method(file);

                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null, excp.toString());

                }
            }
        }
        if(e.getSource()==decompressButton){
            JFileChooser fileChooser=new JFileChooser();
            int response = fileChooser.showSaveDialog(null);

            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    Decompressor.method(file);

                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null, excp.toString());

                }
            }

        }
    }

}
