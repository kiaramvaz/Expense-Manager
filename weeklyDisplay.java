/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//frame to display monthly bills
//package expensehandler;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

/**
 *
 * @author KiaraVaz
 */
class weeklyDisplay extends JFrame implements ActionListener
{

    private JFrame gFrame;
    private JPanel inputPanel;
    private JLabel nameLabel;
    private JButton closeButton;
    private JButton homeButton;
    private JLabel resultLabel;
    private final Color BACKGROUND_COLOR = new Color(237, 230, 173);
    private final Color DARKGREEN_COLOR = new Color(48, 89, 98);
    private final Color DULLYELLOW_COLOR = new Color(220, 194, 134);
    private final Font MAIN_FONT = new Font("Arial", Font.BOLD, 20);
    private JTable dataTable;

    public weeklyDisplay(JFrame pFrame)
    {
        gFrame = pFrame;
        this.setBounds(100, 100, 1200, 500);
        this.getContentPane().setBackground(BACKGROUND_COLOR);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);

        nameLabel = new JLabel("Weekly Bills");
        resultLabel = new JLabel("   ");

        closeButton = new JButton("Close");
        closeButton.setBackground(DULLYELLOW_COLOR);
        closeButton.setOpaque(true);
        closeButton.setBorderPainted(false);
        closeButton.addActionListener(this);

        homeButton = new JButton("Home");
        homeButton.setBackground(DULLYELLOW_COLOR);
        homeButton.setOpaque(true);
        homeButton.setBorderPainted(false);
        homeButton.addActionListener(this);

        inputPanel = new JPanel(new FlowLayout());
        inputPanel.setBackground(DARKGREEN_COLOR);
        inputPanel.add(nameLabel);
        inputPanel.add(homeButton);
        inputPanel.add(closeButton);

         //get data from db and put into JTable
        String[] columns =
        {
            "Name", "WBillingDate", "WeeklyBillAmount"
        };
        JavaDb Obj1 = new JavaDb("ExpenseDatabase");
        Connection myDbConn;
        myDbConn = Obj1.getdbConn();

        Object[][] data = Obj1.getdata("weeklyBillsTable", columns);

        for (int i = 0; i < data.length; i++)
        {
            for (int j = 0; j < data[i].length; j++)
            {
                System.out.println(data[i][j]);
            }
        }

        dataTable = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(dataTable);
        dataTable.setGridColor(DARKGREEN_COLOR);
        dataTable.setBackground(BACKGROUND_COLOR);
        dataTable.setFont(MAIN_FONT);

        JTableHeader header = dataTable.getTableHeader();
        header.setBackground(DULLYELLOW_COLOR);
        header.setBorder(BorderFactory.createLineBorder(DARKGREEN_COLOR));
        header.setFont(MAIN_FONT);

        TableColumn theColumn = new TableColumn();
        theColumn = dataTable.getColumnModel().getColumn(0);
        theColumn.setPreferredWidth(20);
        theColumn = dataTable.getColumnModel().getColumn(1);
        theColumn.setPreferredWidth(160);

        dataTable.setRowHeight(30);
        this.add(scrollPane, BorderLayout.SOUTH);

        System.out.println("2");
        this.add(inputPanel, BorderLayout.NORTH);
        this.add(resultLabel, BorderLayout.CENTER);
    }

    public weeklyDisplay()
    {
        super();
        this.setBounds(100, 100, 1200, 500);
        this.getContentPane().setBackground(BACKGROUND_COLOR);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);

        nameLabel = new JLabel("Weekly Bills");
        resultLabel = new JLabel("   ");

        closeButton = new JButton("Close");
        closeButton.setBackground(DULLYELLOW_COLOR);
        closeButton.setOpaque(true);
        closeButton.setBorderPainted(false);
        closeButton.addActionListener(this);

        homeButton = new JButton("Home");
        homeButton.setBackground(DULLYELLOW_COLOR);
        homeButton.setOpaque(true);
        homeButton.setBorderPainted(false);
        homeButton.addActionListener(this);

        inputPanel = new JPanel(new FlowLayout());
        inputPanel.setBackground(DARKGREEN_COLOR);
        inputPanel.add(nameLabel);
        inputPanel.add(homeButton);
        inputPanel.add(closeButton);

         //get data from db and put into JTable
        String[] columns =
        {
            "Name", "WBillingDate", "WeeklyBillAmount"
        };
        JavaDb Obj1 = new JavaDb("ExpenseDatabase");
        Connection myDbConn;
        myDbConn = Obj1.getdbConn();

        Object[][] data = Obj1.getdata("weeklyBillsTable", columns);

        for (int i = 0; i < data.length; i++)
        {
            for (int j = 0; j < data[i].length; j++)
            {
                System.out.println(data[i][j]);
            }
        }

        dataTable = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(dataTable);
        dataTable.setGridColor(DARKGREEN_COLOR);
        dataTable.setBackground(BACKGROUND_COLOR);
        dataTable.setFont(MAIN_FONT);

        JTableHeader header = dataTable.getTableHeader();
        header.setBackground(DULLYELLOW_COLOR);
        header.setBorder(BorderFactory.createLineBorder(DARKGREEN_COLOR));
        header.setFont(MAIN_FONT);

        TableColumn theColumn = new TableColumn();
        theColumn = dataTable.getColumnModel().getColumn(0);
        theColumn.setPreferredWidth(20);
        theColumn = dataTable.getColumnModel().getColumn(1);
        theColumn.setPreferredWidth(160);

        dataTable.setRowHeight(30);
        this.add(scrollPane, BorderLayout.SOUTH);

        System.out.println("2");
        this.add(inputPanel, BorderLayout.NORTH);
        this.add(resultLabel, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        // TODO code application logic here

        monthlyDisplay objFrame7 = new monthlyDisplay();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String buttonCommand = e.getActionCommand();
        if (buttonCommand.equals("Home"))
        {
            this.dispose();
            gFrame.setVisible(true);
        } else if (buttonCommand.equals("Close"))
        {
            this.dispose();
            System.exit(0);

        }
    }

}
