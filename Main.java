import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;



public class Main {

    private static JTextArea files = new JTextArea(10, 30);

    public static void main(String[] args) {
        createWindow();
    }

    private static void createWindow() {
        JFrame frame = new JFrame("Recursive Lister");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createUI(frame);
        frame.setSize(1000, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void createUI(final JFrame frame){
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        LayoutManager layout = new FlowLayout();
        panel.setLayout(layout);
        JButton start = new JButton("Start");
        start.setFont(new Font("Arial", Font. BOLD, 25));
        files.setFont(new Font("Arial", Font. BOLD, 25));
        JButton quit = new JButton("Quit");
        quit.setFont(new Font("Arial", Font. BOLD, 25));
        final JLabel label = new JLabel();
        label.setFont(new Font("Arial", Font. BOLD, 25));
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int option = fileChooser.showOpenDialog(frame);
                if(option == JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getCurrentDirectory();
                    label.setText("Folder Selected: " + file.getName());
                }else{
                    label.setText("Open command canceled");
                }
            }
        });

        quit.addActionListener(((ActionEvent ae) -> quit()));


        panel.add(start);
        panel.add(quit);
        panel.add(label);
        panel2.add(files);

        frame.getContentPane().add(panel, BorderLayout.NORTH);
        frame.getContentPane().add(panel2, BorderLayout.CENTER);
    }

    static void quit(){
        System.exit(0);
    }
}


