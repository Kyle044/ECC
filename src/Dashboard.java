
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import com.mysql.cj.conf.PropertyDefinitions.DatabaseTerm;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.JTextField;

public class Dashboard extends JFrame implements ActionListener {
	String Username;
	DBHelper db = new DBHelper();
	JButton Home = new JButton();
	JButton Settings = new JButton();
	JButton Employee = new JButton();
	JPanel panelRight = new JPanel();
	JPanel panelMiddle = new JPanel();
	JPanel panelLeft = new JPanel();
	JPanel panelHome = new JPanel();
	JPanel panelEmployee = new JPanel();
	JPanel panelSettings = new JPanel();
	JPanel panelEmp = new JPanel();
	JPanel panelSet = new JPanel();
	JPanel panelH = new JPanel();
	JLayeredPane layeredPane = new JLayeredPane();
	private final JButton StudentBtn = new JButton("Student");
	private final JPanel panelStud = new JPanel();

	private final JScrollPane scrollPaneForTableSchedule = new JScrollPane();
	private final JButton UPDATEBTN = new JButton("UPDATE GOAL");
	private final JButton DELETEBTN = new JButton("DELETE GOAL");
	private final JPanel WELCOMEPANEL = new JPanel();
	JLabel WELCOMELABEL = new JLabel("Welcome Back! User");
	private final JLabel LPROGRESS = new JLabel("On Progress");
	private final JLabel lblNewLabel = new JLabel("CURRENT GOALS");
	private JTable table;
	private final JLabel lblNewLabel_1 = new JLabel("Settings");
	private final JLabel lblNewLabel_2 = new JLabel("Student ID");
	private JTextField tfStudentID;
	private JTextField tfStudentCourse;
	private final JLabel lblNewLabel_2_1_1 = new JLabel("Student Section");
	private final JTextField tfStudentSection = new JTextField();
	private final JButton submitBtnForSearch = new JButton("Search");
	private final JPanel FormOfSearch = new JPanel();
	private final JButton addStudentBtn = new JButton("ADD STUDENT");
	private final JButton updateStudentBtn = new JButton("UPDATE STUDENT");
	private final JButton UpdateFileBtn = new JButton("UPDATE FILE");
	private final JButton DeleteStudBtn = new JButton("DELETE STUDENT");
	private final JTable tblStudent = new JTable(db.getData());
	private final JScrollPane scrollForStudent = new JScrollPane();

	Dashboard(String _Username) { // arguments
		this.Username = _Username;
		this.setTitle("ECC Dashboard");
		this.setSize(1000, 600);// sets the x-dimension, and y-dimension of this

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
		this.setResizable(false);// prevent the this to resize
		this.setLocationRelativeTo(null);// centers the dashboard on launch
		getContentPane().setLayout(new BorderLayout());

		// panel right
		panelRight.setBackground(Color.red);
		panelRight.setPreferredSize(new Dimension(150, 100));

		// panel middle
		panelMiddle.setPreferredSize(new Dimension(100, 100));
		panelMiddle.setLayout(new BorderLayout());
		panelMiddle.setBackground(Color.yellow);

		// Panel Left
		panelLeft.setPreferredSize(new Dimension(200, 100));
		panelLeft.setBorder(new EmptyBorder(10, 10, 10, 10));
		panelLeft.setLayout(null);
		panelEmployee.setBounds(10, 10, 0, 551);
		panelLeft.add(panelEmployee);
		panelSettings.setBounds(10, 10, 0, 551);
		panelLeft.add(panelSettings);
		panelEmployee.setLayout(new GridBagLayout());
		panelSettings.setLayout(new GridBagLayout());

		// adding a layeredPane for navigation
		panelMiddle.add(layeredPane);

		panelStud.setBackground(Color.WHITE);
		panelStud.setBounds(0, 0, 644, 571);
		panelStud.setLayout(null);
		FormOfSearch.setBounds(65, 325, 283, 235);
		FormOfSearch.setBorder(new EmptyBorder(13, 13, 13, 13));

		panelStud.add(FormOfSearch);
		FormOfSearch.setLayout(null);
		lblNewLabel_2.setBounds(10, 0, 106, 56);
		FormOfSearch.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Serif", Font.PLAIN, 15));

		tfStudentID = new JTextField();
		tfStudentID.setBounds(109, 11, 165, 38);
		FormOfSearch.add(tfStudentID);
		tfStudentID.setColumns(10);

		tfStudentCourse = new JTextField();
		tfStudentCourse.setBounds(109, 71, 165, 38);
		FormOfSearch.add(tfStudentCourse);
		tfStudentCourse.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("Student Course");
		lblNewLabel_2_1.setBounds(10, 60, 106, 56);
		FormOfSearch.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setFont(new Font("Serif", Font.PLAIN, 15));
		lblNewLabel_2_1_1.setBounds(10, 117, 106, 56);
		FormOfSearch.add(lblNewLabel_2_1_1);
		lblNewLabel_2_1_1.setFont(new Font("Serif", Font.PLAIN, 15));
		tfStudentSection.setBounds(109, 128, 165, 38);
		FormOfSearch.add(tfStudentSection);
		tfStudentSection.setColumns(10);
		submitBtnForSearch.setBounds(109, 179, 165, 45);
		FormOfSearch.add(submitBtnForSearch);
		addStudentBtn.setBounds(358, 325, 189, 40);
		addStudentBtn.setFont(new Font("Serif", Font.PLAIN, 15));

		panelStud.add(addStudentBtn);
		updateStudentBtn.setBounds(358, 376, 189, 40);
		updateStudentBtn.setFont(new Font("Serif", Font.PLAIN, 15));

		panelStud.add(updateStudentBtn);
		UpdateFileBtn.setBounds(358, 427, 189, 40);
		UpdateFileBtn.setFont(new Font("Serif", Font.PLAIN, 15));

		panelStud.add(UpdateFileBtn);
		DeleteStudBtn.setBounds(358, 478, 189, 40);
		DeleteStudBtn.setFont(new Font("Serif", Font.PLAIN, 15));

		panelStud.add(DeleteStudBtn);
		// TODO setting the layer
		layeredPane.add(panelH, Integer.valueOf(3));
		layeredPane.add(panelEmp, Integer.valueOf(2));
		layeredPane.add(panelStud, Integer.valueOf(1));
		layeredPane.add(panelSet, Integer.valueOf(0));
		scrollForStudent.setBounds(10, 11, 624, 303);

		panelStud.add(scrollForStudent);
		scrollForStudent.setViewportView(tblStudent);

		panelH.setLayout(null);
		// setting bounds for panelH
		panelH.setBounds(0, 0, 644, 571);
		// setting the background color blue for panel of Home
		panelH.setBackground(Color.WHITE);
		scrollPaneForTableSchedule.setBounds(10, 304, 624, 256);

		// setting width for the col1
//		col1.setPreferredWidth(100);
//		// setting width for the col2
//		col1.setPreferredWidth(150);
//		// creating a new instance or object of Center Table Cell Renderer which centers
//		// the data inside a cell
//	
//		// setting the tc column data inside center
//		tc.setCellRenderer(cr);
		panelH.add(scrollPaneForTableSchedule);
		JTable ScheduleTable = new JTable(db.getData());
		scrollPaneForTableSchedule.setViewportView(ScheduleTable);
		TableColumn tc = ScheduleTable.getColumn("Name");
		tc = ScheduleTable.getColumn("Deadline");
		tc = ScheduleTable.getColumn("Description");
		tc = ScheduleTable.getColumn("Date Published");
		JPanel PANELPROGRESS = new JPanel();
		PANELPROGRESS.setBounds(457, 156, 177, 137);
		panelH.add(PANELPROGRESS);
		PANELPROGRESS.setLayout(null);
		LPROGRESS.setHorizontalAlignment(SwingConstants.CENTER);
		LPROGRESS.setFont(new Font("Serif", Font.PLAIN, 14));
		LPROGRESS.setBounds(10, 11, 167, 112);

		PANELPROGRESS.add(LPROGRESS);

		JPanel PANELMILESTONE = new JPanel();
		PANELMILESTONE.setBounds(457, 11, 177, 134);
		panelH.add(PANELMILESTONE);
		PANELMILESTONE.setLayout(null);

		JLabel LMILESTONE = new JLabel("Milestones");
		LMILESTONE.setBounds(10, 11, 167, 112);
		PANELMILESTONE.add(LMILESTONE);
		LMILESTONE.setHorizontalAlignment(SwingConstants.CENTER);
		LMILESTONE.setFont(new Font("Serif", Font.PLAIN, 14));
		WELCOMEPANEL.setBounds(10, 11, 437, 216);

		panelH.add(WELCOMEPANEL);
		WELCOMEPANEL.setLayout(null);
		WELCOMELABEL.setBounds(10, 11, 394, 82);
		WELCOMEPANEL.add(WELCOMELABEL);
		WELCOMELABEL.setHorizontalAlignment(SwingConstants.CENTER);
		WELCOMELABEL.setFont(new Font("Serif", Font.PLAIN, 14));

		JButton ADDBTN = new JButton("ADD GOAL");
		ADDBTN.setBounds(10, 150, 129, 55);
		WELCOMEPANEL.add(ADDBTN);
		UPDATEBTN.setBounds(149, 150, 129, 55);
		WELCOMEPANEL.add(UPDATEBTN);
		DELETEBTN.setBounds(288, 150, 137, 55);
		WELCOMEPANEL.add(DELETEBTN);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 27));
		lblNewLabel.setBounds(10, 238, 437, 55);

		panelH.add(lblNewLabel);

		// Panel Settings
		panelSet.setBackground(Color.WHITE);
		panelSet.setBounds(0, 0, 644, 571);
		panelSet.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 624, 111);
		panelSet.add(panel);
		panel.setLayout(null);
		lblNewLabel_1.setFont(new Font("Serif", Font.PLAIN, 22));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 11, 604, 89);

		panel.add(lblNewLabel_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 167, 624, 393);
		panelSet.add(panel_1);
		panel_1.setLayout(null);

		JButton btnNewButton = new JButton("EDIT ACCOUNT");
		btnNewButton.setFont(new Font("Serif", Font.PLAIN, 15));
		btnNewButton.setBounds(191, 41, 201, 86);
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("DARK MODE");
		btnNewButton_1.setFont(new Font("Serif", Font.PLAIN, 15));
		btnNewButton_1.setBounds(191, 149, 201, 86);
		panel_1.add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("LOG-OUT");
		btnNewButton_1_1.setFont(new Font("Serif", Font.PLAIN, 15));
		btnNewButton_1_1.setBounds(191, 254, 201, 86);
		panel_1.add(btnNewButton_1_1);

		// instancing a button listener
		ButtonListener bl = new ButtonListener();
		CenterTableCellRenderer cr = new CenterTableCellRenderer();
		tc.setCellRenderer(cr);
		tc.setCellRenderer(cr);
		tc.setCellRenderer(cr);
		tc.setCellRenderer(cr);

		// Panel Employee
		panelEmp.setBackground(Color.white);
		panelEmp.setBounds(0, 0, 644, 571);
		panelEmp.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 624, 476);
		panelEmp.add(scrollPane);

		table = new JTable(db.getData());
		scrollPane.setViewportView(table);

		JButton ADD_EMPLOYEEBTN = new JButton("ADD EMPLOYEE");
		ADD_EMPLOYEEBTN.setBounds(10, 498, 172, 62);
		panelEmp.add(ADD_EMPLOYEEBTN);

		JButton UPDATE_EMPLOYEEBTN = new JButton("UPDATE EMPLOYEE");
		UPDATE_EMPLOYEEBTN.setBounds(192, 498, 172, 62);
		panelEmp.add(UPDATE_EMPLOYEEBTN);

		JButton DELETE_EMPLOYEEBTN = new JButton("DELETE EMPLOYEE");
		DELETE_EMPLOYEEBTN.setBounds(374, 498, 172, 62);
		panelEmp.add(DELETE_EMPLOYEEBTN);

		// adding panel
		getContentPane().add(panelLeft, BorderLayout.WEST);
		Employee.setBounds(20, 228, 153, 50);
		panelLeft.add(Employee);
		Employee.setText("Employee");
		Employee.setPreferredSize(new Dimension(160, 50));

		// NAVIGATION

		// Adding listener to the Employee button;
		Employee.addActionListener(bl);
		StudentBtn.setBounds(20, 289, 153, 50);
		panelLeft.add(StudentBtn);
		Home.setBounds(20, 167, 153, 50);
		panelLeft.add(Home);

		// Buttons
		Home.setText("Home");
		Home.setPreferredSize(new Dimension(160, 50));
		// Adding listener to the Home button;
		Home.addActionListener(bl);
		Settings.setBounds(20, 350, 153, 50);
		panelLeft.add(Settings);
		Settings.setText("Settings");
		Settings.setPreferredSize(new Dimension(160, 50));
		// Adding listener to the Settings button;
		Settings.addActionListener(bl);
		panelHome.setBounds(318, 10, 0, 551);
		panelLeft.add(panelHome);
		StudentBtn.addActionListener(bl);

		// add the button to panels
		// setting the button on the center
		panelHome.setLayout(new GridBagLayout());
		getContentPane().add(panelRight, BorderLayout.EAST);
		getContentPane().add(panelMiddle, BorderLayout.CENTER);

		this.setVisible(true);// make this visible

	}

//class of table Data Center
	public class CenterTableCellRenderer extends DefaultTableCellRenderer {

		public CenterTableCellRenderer() {
			setHorizontalAlignment(JLabel.CENTER);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
	// class of Button Listener

	public class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// Employee button has been clicked
			if (e.getSource() == Employee) {
				// setting the Employee on top of layer
				layeredPane.setLayer(panelEmp, 3);
				layeredPane.setLayer(panelSet, 2);
				layeredPane.setLayer(panelH, 1);
				layeredPane.setLayer(panelStud, 3);
			}
			// Home button has been clicked
			else if (e.getSource() == Home) {
				// setting the Home on top of layer
				layeredPane.setLayer(panelEmp, 2);
				layeredPane.setLayer(panelSet, 1);
				layeredPane.setLayer(panelH, 3);
				layeredPane.setLayer(panelStud, 0);
			}
			// Settings button has been clicked
			else if (e.getSource() == Settings) {
				// setting the Settings on top of layer
				layeredPane.setLayer(panelEmp, 2);
				layeredPane.setLayer(panelSet, 3);
				layeredPane.setLayer(panelH, 1);
				layeredPane.setLayer(panelStud, 0);
			} else if (e.getSource() == StudentBtn) {
				// setting the Settings on top of layer
				layeredPane.setLayer(panelEmp, 0);
				layeredPane.setLayer(panelSet, 2);
				layeredPane.setLayer(panelH, 1);
				layeredPane.setLayer(panelStud, 3);
				System.out.println("Student btn has been clicked");
			}
		}

	}
}
