package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Window;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JCalendar;
import com.toedter.components.JSpinField;

import buisinessdelegate.CompetitionServiceDelegate;
import buisinessdelegate.StationServiceDelegate;
import entity.Competition;
import entity.SkiStation;

import com.toedter.calendar.JSpinnerDateEditor;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.CardLayout;
import java.awt.Component;

import javax.swing.JFormattedTextField;
import com.lavantech.gui.comp.TimePanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import gui.AddStationGui;
public class CompetitionManagementGui {

	public JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompetitionManagementGui window = new CompetitionManagementGui();
					window.frame.setVisible(true);
					GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
					window.frame.setExtendedState( window.frame.MAXIMIZED_BOTH);
					
					window.frame.setDefaultCloseOperation(window.frame.EXIT_ON_CLOSE);
					window.frame.setBounds(100, 100, 1400, 725);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CompetitionManagementGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 907, 621);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Competition Management");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel.setBounds(305, 104, 238, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel TypeLabel = new JLabel("Type :");
		TypeLabel.setFont(new Font("Verdana", Font.BOLD, 13));
		TypeLabel.setBounds(10, 129, 84, 30);
		frame.getContentPane().add(TypeLabel);
		
		JLabel Date = new JLabel("Date of the Competition:");
		Date.setFont(new Font("Verdana", Font.BOLD, 13));
		Date.setBounds(10, 156, 185, 30);
		frame.getContentPane().add(Date);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Amateur", "Ski Pro Sport", "Extreme Games "}));
		comboBox.setBounds(106, 136, 109, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel Starting_Label = new JLabel("Starting Hour:");
		Starting_Label.setFont(new Font("Verdana", Font.BOLD, 13));
		Starting_Label.setBounds(10, 366, 119, 30);
		frame.getContentPane().add(Starting_Label);
		
		JLabel Finishing_Label = new JLabel("Finishing Hour:");
		Finishing_Label.setFont(new Font("Verdana", Font.BOLD, 13));
		Finishing_Label.setBounds(197, 361, 119, 40);
		frame.getContentPane().add(Finishing_Label);
		
		JCalendar calendar = new JCalendar();
		calendar.setMinSelectableDate(new java.util.Date());
		calendar.setBounds(41, 194, 260, 171);
		frame.getContentPane().add(calendar);
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch.setBounds(322, 135, 89, 23);
		frame.getContentPane().add(btnSearch);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Type", "Date ", "Type and Date"}));
		comboBox_1.setBounds(454, 136, 89, 20);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblCapacity = new JLabel("Capacity:");
		lblCapacity.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCapacity.setBounds(10, 547, 84, 30);
		frame.getContentPane().add(lblCapacity);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(122, 554, 29, 20);
		frame.getContentPane().add(spinner);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Competition competition =new Competition();
				competition.setType(comboBox.getSelectedItem().toString());
				competition.setDate(calendar.getDate());
				competition.setCapacity(Integer.parseInt(spinner.getValue().toString()));
				TimePanel timePanel = new TimePanel();
				timePanel.setBounds(10, 392, 141, 147);
				frame.getContentPane().add(timePanel);
				
				
				TimePanel timePanel_1 = new TimePanel();
				timePanel_1.setBounds(161, 392, 158, 150);
				frame.getContentPane().add(timePanel_1);
		competition.setFinishingHour(timePanel.getCalendar());
        competition.setStartingHour(timePanel_1.getCalendar());
        
		CompetitionServiceDelegate.doAddCompetition(competition);
		table.setModel(new CompetitionAdapter());
		/*if (calendar_1.getDate().compareTo(calendar.getDate()) < 0) {
            System.out.println("Date debut doit etre infereur a dae fin" + calendar.getDate().before(calendar_1.getDate()));
            JOptionPane.showMessageDialog(null, " Starting Date is less than the end date");


               
				}}*/
			}
				
			    
			    
		
		});
		btnAdd.setBounds(391, 519, 89, 23);
		frame.getContentPane().add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String id = table.getValueAt(table.getSelectedRow(), 0).toString();
				 Competition competition=new Competition();
 competition=CompetitionServiceDelegate.doFindCompetitionById(Integer.parseInt(id));
 competition.setCapacity(Integer.parseInt(spinner.getValue().toString()));
 competition.setDate(calendar.getDate());
	TimePanel timePanel = new TimePanel();
	timePanel.setBounds(10, 392, 141, 147);
	frame.getContentPane().add(timePanel);
	
	
	TimePanel timePanel_1 = new TimePanel();
	timePanel_1.setBounds(161, 392, 158, 150);
	frame.getContentPane().add(timePanel_1);

competition.setFinishingHour(timePanel.getCalendar());				
competition.setStartingHour(timePanel_1.getCalendar());
competition.setType(comboBox.getSelectedItem().toString());
int rep = JOptionPane.showConfirmDialog(null, "Are you sure you want to modify?", "BECAREFUL", JOptionPane.YES_NO_OPTION);
if (rep == JOptionPane.YES_OPTION) {
      CompetitionServiceDelegate.doUpdateCompetition(competition);
      
}
table.setModel(new CompetitionAdapter());

			}
		});
		btnUpdate.setBounds(490, 519, 89, 23);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Competition competition=new Competition();
			     String id = table.getValueAt(table.getSelectedRow(), 0).toString();
			     int rep = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "BECAREFUL", JOptionPane.YES_NO_OPTION);
		            if (rep == JOptionPane.YES_OPTION) {
		   		     CompetitionServiceDelegate.doDeleteCompetitionById(Integer.parseInt(id));
		   		  JOptionPane.showMessageDialog(null,"It is deleted");
					table.setModel(new CompetitionAdapter());

		            }
		            else
	    			JOptionPane.showMessageDialog(null,"Okay! won't be deleted");
					table.setModel(new CompetitionAdapter());
			}
		});
		btnDelete.setBounds(589, 519, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		JButton btnDisconnect = new JButton("Disconnect");
		btnDisconnect.setBounds(777, 547, 89, 23);
		frame.getContentPane().add(btnDisconnect);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 String id = table.getValueAt(table.getSelectedRow(), 0).toString();
			        String type = table.getValueAt(table.getSelectedRow(), 1).toString();
			        String dateInString = table.getValueAt(table.getSelectedRow(), 2).toString();
			        String finishingHourString= table.getValueAt(table.getSelectedRow(),3).toString();
			        String startingHourString= table.getValueAt(table.getSelectedRow(),4).toString();
			        String capacity= table.getValueAt(table.getSelectedRow(),5).toString();

			     //Formating a string into a date   
			       SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
			        java.util.Date date=null;
					try {
						date = sdf.parse(dateInString);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						System.out.println("it is converted");
					}
			        System.out.println("nope!"+date);
			      
			     /*   calendar.set(Calendar.YEAR, 2014);
			        calendar.set(Calendar.MONTH, 11);
			        calendar.set(Calendar.MINUTE, 33);*/
			     
			       comboBox.setSelectedItem(type);
			       spinner.setValue(capacity);
			       calendar.setDate(date);
			}
		});
		table.setModel(new CompetitionAdapter());
		table.setBounds(326, 166, 555, 342);
		frame.getContentPane().add(table);
		
		TimePanel timePanel = new TimePanel();
		timePanel.setBounds(10, 392, 141, 147);
		frame.getContentPane().add(timePanel);
		
		TimePanel timePanel_1 = new TimePanel();
		timePanel_1.setBounds(161, 392, 158, 150);
		frame.getContentPane().add(timePanel_1);
		
		JButton LienStation = new JButton("SkiStations' Management");
		LienStation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStationGui ui=new AddStationGui();
				
				  JFrame frame = new JFrame();
				 
				  ui.frame.setVisible(true);
			}
		});
		LienStation.setBounds(106, 53, 176, 40);
		frame.getContentPane().add(LienStation);
		
		JButton lienCompetition = new JButton("Competitions'Management");
		lienCompetition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CompetitionManagementGui window = new CompetitionManagementGui();
				window.frame.setVisible(true);
			}
		});
		lienCompetition.setBounds(281, 53, 149, 40);
		frame.getContentPane().add(lienCompetition);
		
		JButton lienStat = new JButton("Statistics");
		lienStat.setBounds(429, 53, 164, 40);
		frame.getContentPane().add(lienStat);
		
		JLabel Bkground = new JLabel("");
		Bkground.setBounds(0, 0, 1366, 768);
		frame.getContentPane().add(Bkground);
		Bkground.setIcon(new ImageIcon("C:\\Users\\Rym\\Desktop\\P_dev doc\\bkground.jpg"));
	}
}
