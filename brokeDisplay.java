/*
 January 1st. Display appropriate message based on total
 */
//package expensehandler;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * 
 */
public class brokeDisplay extends JFrame implements ActionListener {
     
    private final Color BACKGROUND_COLOR = new Color(220,194,134);
    private JButton backButton;
    private JLabel pictureLabel;
     
    
            
    public brokeDisplay (JLabel resultLabel)
            
    {
        this.setBounds(200,200,1000,400);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(BACKGROUND_COLOR);
        this.add(resultLabel, BorderLayout.CENTER);
        this.setVisible(true);
        this.setResizable(false);
        
        backButton = new JButton("Back"); 
        backButton.addActionListener(this);
    
        //this.add(pictureLabel);
        this.add(backButton,BorderLayout.SOUTH);
       
        
       
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonCommand = e.getActionCommand();
        if (buttonCommand.equals("Back"))
        {
            this.dispose();
        }
 
   
    } 
}


