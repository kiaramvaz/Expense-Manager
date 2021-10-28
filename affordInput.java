/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Input Frame to check if user can afford something
//package expensehandler;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * 
 */
class affordInput extends JFrame implements ActionListener
{
    //declerations
    private JFrame gFrame;
    private JPanel buttonPanel;
    private JTextField nameInput;
    private JTextField amountInput;
    private JPanel inputPanel;
    private JLabel resultLabel;
    private JLabel nameLabel;
    private JLabel amountLabel;
    private JLabel timeLabel;
    private JButton closeButton;
    private JButton submitButton;
    private JButton homeButton;
    private final Color BACKGROUND_COLOR = new Color(237,230,173);
    private final Color DARKGREEN_COLOR = new Color(48,89,98);
    private final Color DULLYELLOW_COLOR = new Color(220,194,134);
    private final Font MAIN_FONT = new Font("Arial",Font.BOLD,40);

    
    public affordInput(JFrame pFrame)
    {
        gFrame = pFrame;
        this.setBounds(100, 100, 1200, 500);
        this.getContentPane().setBackground(BACKGROUND_COLOR);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //initialization
        nameLabel = new JLabel("Name:");
        amountLabel = new JLabel("Amount:");
        resultLabel = new JLabel("   ");

        nameInput = new JTextField(10);
        amountInput = new JTextField(10);

        closeButton = new JButton("Close");
        closeButton.setBackground(DULLYELLOW_COLOR);
        closeButton.setOpaque(true);
        closeButton.setBorderPainted(false);
        closeButton.addActionListener(this);
        
        submitButton = new JButton("Submit");
        submitButton.setBackground(DULLYELLOW_COLOR);
        submitButton.setOpaque(true);
        submitButton.setBorderPainted(false);
        submitButton.addActionListener(this);
        
        homeButton = new JButton("Home");
        homeButton.setBackground(DULLYELLOW_COLOR);
        homeButton.setOpaque(true);
        homeButton.setBorderPainted(false);
        homeButton.addActionListener(this);
        

        //panel 
        inputPanel = new JPanel(new FlowLayout());
        inputPanel.setBackground(DARKGREEN_COLOR);
        inputPanel.add(nameLabel);
        inputPanel.add(nameInput);
        inputPanel.add(amountLabel);
        inputPanel.add(amountInput);
        inputPanel.add(closeButton);
        inputPanel.add(submitButton);
        inputPanel.add(homeButton);

        this.add(inputPanel, BorderLayout.NORTH);
        this.add(resultLabel, BorderLayout.CENTER);
        this.setVisible(true);

    }
    
        public affordInput()
    {
        super();
        this.setBounds(100, 100, 1200, 500);
        this.getContentPane().setBackground(BACKGROUND_COLOR);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        nameLabel = new JLabel("Name:");
        amountLabel = new JLabel("Amount:");
        resultLabel = new JLabel("   ");

        nameInput = new JTextField(10);
        amountInput = new JTextField(10);

        closeButton = new JButton("Close");
        closeButton.setBackground(DULLYELLOW_COLOR);
        closeButton.setOpaque(true);
        closeButton.setBorderPainted(false);
        closeButton.addActionListener(this);
        
        submitButton = new JButton("Submit");
        submitButton.setBackground(DULLYELLOW_COLOR);
        submitButton.setOpaque(true);
        submitButton.setBorderPainted(false);
        submitButton.addActionListener(this);
        
        homeButton = new JButton("Home");
        homeButton.setBackground(DULLYELLOW_COLOR);
        homeButton.setOpaque(true);
        homeButton.setBorderPainted(false);
        homeButton.addActionListener(this);
        

        inputPanel = new JPanel(new FlowLayout());
        inputPanel.setBackground(DARKGREEN_COLOR);
        inputPanel.add(nameLabel);
        inputPanel.add(nameInput);
        inputPanel.add(amountLabel);
        inputPanel.add(amountInput);
        inputPanel.add(closeButton);
        inputPanel.add(submitButton);
        inputPanel.add(homeButton);

        this.add(inputPanel, BorderLayout.NORTH);
        this.add(resultLabel, BorderLayout.CENTER);
        this.setVisible(true);


    }
    
    public static void main(String[] args)
    {
        // TODO code application logic here

        affordInput objFrame2 = new affordInput();
    }

    //actionlistener
    @Override
    public void actionPerformed(ActionEvent e)
    {
        try{
        String buttonCommand = e.getActionCommand();
        if (buttonCommand.equals("Home"))
        {
            this.dispose();
            gFrame.setVisible(true);
        }
        else if(buttonCommand.equals("Close"))
        {
            this.dispose();
            
        }
        else if(buttonCommand.equals("Submit"))
        {
            
            String amtString = amountInput.getText();
            int amountInt = Integer.parseInt(amtString);
            
            amountInput.setText("");
            nameInput.setText("");
            
            //calls check method 
            calculationMethods objMethods = new calculationMethods();
            boolean boolCheck = objMethods.checkIfAfford(amountInt);
            
            //based on the output it changes display 
            if (boolCheck == true){
                resultLabel.setText("Yes you can afford the item!");
                //display output fram and send label
                AffordOutput objAffordOutput = new AffordOutput(resultLabel);
            }
            else{
                //display output fram and send label
                resultLabel.setText("No you cannot afford this item!");
                AffordOutput objAffordOutput = new AffordOutput(resultLabel);
            }
            
            //resultLabel.setText("Submit Button was pressed");
            //this.add(resultLabel,BorderLayout.CENTER);
            this.validate();
            this.repaint();
            
        }
    }
        //catches errors and displays error 
    catch (NullPointerException ne)
        {
            System.out.println("Null");
            ErrorFrame objErrorFrame = new ErrorFrame(this);
        }
        catch (IllegalArgumentException iae)
        {
            System.out.println("Null");
            ErrorFrame objErrorFrame = new ErrorFrame(this);
        }
}
    
}
