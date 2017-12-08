package gui;

import java.awt.EventQueue;
import java.awt.LayoutManager;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import javax.swing.UIManager;

import buisinessdelegate.StationServiceDelegate;
import entity.SkiStation;
import javassist.runtime.Desc;

import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddStationGui {

	public JFrame frame;
	private JLabel Bkground;
	private JTextField LabelField;
	private JTextField LattitudeField;
	private JTextField LongitudeField;
	private JLabel LattitudeLabel;
	private JLabel LongitudeLabel;
	private JLabel DescripLabel;
	private JTextField descripField;
	private JTextField findField;
	private JTable table;
	private JButton button_1;
	private JButton button_2;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStationGui window = new AddStationGui();
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
	public AddStationGui() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
			
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().setLayout(new BorderLayout());
		 
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);	
		JButton AddButton = new JButton("Add");
		AddButton.setBounds(81, 507, 131, 35);
		AddButton.setForeground(SystemColor.desktop);
		AddButton.setBackground(Color.GRAY);
		AddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SkiStation station=new SkiStation();
				if (LabelField.getText()=="")
						{
					JOptionPane.showMessageDialog(null, "please fill this one!");
						}
				else 
				station.setLabel(LabelField.getText());	
				//
				try {
	        		  for (int i = 0; i < LattitudeField.getText().trim().length(); i++) {
	        			  if ((LattitudeField.getText()=="")||(LattitudeField.getText().trim().toUpperCase().charAt(i) > 57 )||(LattitudeField.getText().trim().toUpperCase().charAt(i) < 48))  {
	        				  throw new NumberFormatException();
	        			  }
	        		  }
	        		 }catch (NumberFormatException E) {
			    			
			    			JOptionPane.showMessageDialog(null,"Lattitude must be wriitten in numbers");
	        		 }
				station.setLatitude(Long.parseLong(LattitudeField.getText()));
				//
				try {
	        		  for (int i = 0; i < LongitudeField.getText().trim().length(); i++) {
	        			  if ((LongitudeField.getText()=="")||(LongitudeField.getText().trim().toUpperCase().charAt(i) > 57 )||(LongitudeField.getText().trim().toUpperCase().charAt(i) < 48))  {
	        				  throw new NumberFormatException();
	        			  }
	        		  }
	        		 }catch (NumberFormatException E) {
			    			
			    			JOptionPane.showMessageDialog(null,"Longitude must be wriitten in numbers");
	        		 }
				station.setLongitude(Long.parseLong(LongitudeField.getText()));
				if (descripField.getText()=="")
				{
			JOptionPane.showMessageDialog(null, "please fill this one!");
				}
		else 
				{station.setDescription(descripField.getText());}
				StationServiceDelegate.doAddStation(station);
				table.setModel(new StationAdapter());

			}
		});
		layeredPane.setLayout(null);
		layeredPane.add(AddButton);
		
		LabelField = new JTextField();
		LabelField.setBounds(163, 92, 196, 20);
		layeredPane.add(LabelField);
		LabelField.setColumns(10);
		
		LattitudeField = new JTextField();
		LattitudeField.setBounds(163, 123, 196, 20);
		layeredPane.add(LattitudeField);
		LattitudeField.setColumns(10);
		
		LongitudeField = new JTextField();
		LongitudeField.setBounds(163, 156, 196, 20);
		layeredPane.add(LongitudeField);
		LongitudeField.setColumns(10);
		
		JLabel LabelLabel = new JLabel("Label ski station:");
		LabelLabel.setBounds(30, 92, 144, 17);
		LabelLabel.setForeground(Color.BLACK);
		LabelLabel.setFont(new Font("Verdana", Font.BOLD, 13));
		LabelLabel.setBackground(Color.DARK_GRAY);
		layeredPane.add(LabelLabel);
		
		LattitudeLabel = new JLabel("Lattitude:");
		LattitudeLabel.setBounds(30, 131, 144, 14);
		LattitudeLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		layeredPane.add(LattitudeLabel);
		
		LongitudeLabel = new JLabel("Longitude:");
		LongitudeLabel.setBounds(30, 158, 123, 14);
		LongitudeLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		layeredPane.add(LongitudeLabel);
		
		DescripLabel = new JLabel("Description:");
		DescripLabel.setBounds(30, 187, 123, 16);
		DescripLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		layeredPane.add(DescripLabel);
		
		descripField = new JTextField();
		descripField.setBounds(163, 187, 196, 133);
		layeredPane.add(descripField);
		descripField.setColumns(10);
		
		JButton UpdateButton = new JButton("Update");
		UpdateButton.setBounds(222, 507, 131, 35);
		
		UpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			     String id = table.getValueAt(table.getSelectedRow(), 0).toString();

				SkiStation station=StationServiceDelegate.doFindStationById(Integer.parseInt(id));
			     
				if (LabelField.getText()=="")
				{
			JOptionPane.showMessageDialog(null, "please fill this one!");
				}
		else station.setLabel(LabelField.getText());
				
				try {
	        		  for (int i = 0; i < LongitudeField.getText().trim().length(); i++) {
	        			  if ((LongitudeField.getText()=="")||(LongitudeField.getText().trim().toUpperCase().charAt(i) > 57 )||(LongitudeField.getText().trim().toUpperCase().charAt(i) < 48))  {
	        				  throw new NumberFormatException();
	        			  }
	        		  }
	        		 }catch (NumberFormatException E) {
			    			
			    			JOptionPane.showMessageDialog(null,"Longitude must be wriitten in numbers");
	        		 }
				station.setLongitude(Long.parseLong(LongitudeField.getText()));
				
				
				try {
	        		  for (int i = 0; i < LattitudeField.getText().trim().length(); i++) {
	        			  if ((LattitudeField.getText()=="")||(LattitudeField.getText().trim().toUpperCase().charAt(i) > 57 )||(LattitudeField.getText().trim().toUpperCase().charAt(i) < 48))  {
	        				  throw new NumberFormatException();
	        			  }
	        		  }
	        		 }catch (NumberFormatException E) {
			    			
			    			JOptionPane.showMessageDialog(null,"Lattitude must be wriitten in numbers");
	        		 }
				station.setLatitude(Long.parseLong(LattitudeField.getText()));
				
				if (descripField.getText()=="")
				{
			JOptionPane.showMessageDialog(null, "please fill this one!");
				}
		else   
				station.setDescription(descripField.getText());
			      int rep = JOptionPane.showConfirmDialog(null, "Are you sure you want to modify?", "BECAREFUL", JOptionPane.YES_NO_OPTION);
		            if (rep == JOptionPane.YES_OPTION) {
					      StationServiceDelegate.doUpdateStation(station);
}
					table.setModel(new StationAdapter());

			}
		});
		layeredPane.add(UpdateButton);
		
		JButton DeleteButton = new JButton("Delete");
		DeleteButton.setBounds(363, 507, 132, 35);
		DeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			SkiStation station=new SkiStation();
		     String id = table.getValueAt(table.getSelectedRow(), 0).toString();
		     int rep = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "BECAREFUL", JOptionPane.YES_NO_OPTION);
	            if (rep == JOptionPane.YES_OPTION) {
	   		     StationServiceDelegate.doDeleteStationById(Integer.parseInt(id));
	   		  JOptionPane.showMessageDialog(null,"It is deleted");
				table.setModel(new StationAdapter());

	            }
	            else
    			JOptionPane.showMessageDialog(null,"Okay! won't be deleted");
				table.setModel(new StationAdapter());

			}
		});
		layeredPane.add(DeleteButton);
		
		findField = new JTextField();
		findField.setBounds(581, 74, 165, 35);
		findField.setFont(new Font("Verdana", Font.PLAIN, 10));
		findField.setText("label of the station...");
		layeredPane.add(findField);
		findField.setColumns(10);
		
		JButton SearchButton = new JButton("Search");
		SearchButton.setBounds(436, 74, 132, 35);
		SearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		 String labelstation=findField.getText();
			//try {
				List <SkiStation> stations=new ArrayList<>();
				stations=StationServiceDelegate.doFindStationByName(labelstation);
				for(SkiStation s: stations)
					{System.out.println(s);}
				table.setModel(new StationAdapter());

				JOptionPane.showMessageDialog(null, "there it is!");
				table.setModel(new StationAdapter());
		//	} catch (Exception e2) {
				// TODO: handle exception
			//	JOptionPane.showMessageDialog(null, "please fill with an existing staion's label!");
			//}
			table.setModel(new StationAdapter());

			}

		});
		layeredPane.add(SearchButton);
		
		JButton DisconnectButton = new JButton("Disconnect");
		DisconnectButton.setBounds(744, 533, 132, 35);
		layeredPane.add(DisconnectButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		scrollPane.setBounds(389, 131, 492, 365);
		layeredPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				                                     
			        // TODO add your handling code here:
			        String id = table.getValueAt(table.getSelectedRow(), 0).toString();
			        String label = table.getValueAt(table.getSelectedRow(), 1).toString();
			        String lattitude = table.getValueAt(table.getSelectedRow(), 2).toString();
			        String longitude =table.getValueAt(table.getSelectedRow(),3).toString();
			        String description= table.getValueAt(table.getSelectedRow(),4).toString();
			        
			        

			        LabelField.setText(label);
			        LattitudeField.setText(lattitude);
			       LongitudeField.setText(longitude);
			        descripField.setText(description);
			     
			}
		});
		table.setModel(new StationAdapter());

		scrollPane.setViewportView(table);
		
		button = new JButton("Competitions'Management");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CompetitionManagementGui ui=new CompetitionManagementGui();
				
				  JFrame frame = new JFrame();
				 
				  ui.frame.setVisible(true);
				  
				  AddStationGui window = new AddStationGui();
					window.frame.setVisible(false);
				  
			}
		});
		button.setBounds(259, 24, 181, 40);
		layeredPane.add(button);
		
		button_2 = new JButton("Statistics");
		button_2.setBounds(439, 24, 164, 40);
		layeredPane.add(button_2);
		
		button_1 = new JButton("SkiCompetitions'Management");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStationGui window = new AddStationGui();
				window.frame.setVisible(true);
				CompetitionManagementGui ui=new CompetitionManagementGui();
				
				  JFrame frame = new JFrame();
				 
				  ui.frame.setVisible(false);
			}
		});
		button_1.setBounds(75, 24, 186, 40);
		layeredPane.add(button_1);
		
		Bkground = new JLabel("");
		Bkground.setBounds(0, 0, 1366, 768);
		layeredPane.add(Bkground);
		Bkground.setBackground(Color.BLUE);
		Bkground.setIcon(new ImageIcon("C:\\Users\\Rym\\Desktop\\P_dev doc\\bkground.jpg"));
		//textfield test
		JTextField test=new JTextField("hello");
	}
	protected JLabel getLblNewLabel() {
		return Bkground;
	}
}
