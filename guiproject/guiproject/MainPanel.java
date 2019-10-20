package guiproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import project1.AceDataManager;
import project1.AceDataManagerADT;
import project1.Patient;
import project1.PatientADT;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class MainPanel extends JPanel {
	private final int WIDTH = 800, HEIGHT = 500;

	private int delay;

	private JPanel warning;

	private JButton showIcon;
	private JButton changeSpeed;
	private final Action action = new SwingAction();
	private JTextPane txtpnHello;
	private JButton btnSomething;
	private JButton btnStart;

	private final Action action_1 = new SwingAction_1();
	private JButton btnFindPatient;
	private final Action action_2 = new SwingAction_2();
	private JComboBox comboBox;
	private JList list;
	private final Action action_3 = new SwingAction_3();
	private JButton btnCreatePatient;
	private AceDataManager myData;
	private JTextPane test;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnCloseAceList;
	private JRadioButton rdbtnOpenAceList;
	private JScrollPane scrollPane;
	private JLabel label;
	private JButton btnNewButton;
	private JButton btnAddAce;
	private JButton btnRemoveAce;
	private JTextField searchID;
	private JLabel lblFindById;
	private JLabel lblFindBy;
	private JButton btnSearch;
	private JButton btnAddAce2;
	private JButton btnRemoveAce2;
	private JButton btnFinishsave2;
	private Patient ph2;

	// -----------------------------------------------------------------
	// Sets up the panel, including the timer for the animation.
	// -----------------------------------------------------------------
	public MainPanel() {
		super(new BorderLayout());
		myData = new AceDataManager("data.txt", "hello");

		Patient p1 = new Patient();
		p1.setId("1234");
		p1.setName("Grant Lazenby");
		myData.addPatient(p1);

		delay = 20;

		warning = new JPanel();
		warning.setPreferredSize(new Dimension(800, 600));
		warning.setBackground(Color.LIGHT_GRAY);

		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.white);
		add(warning, BorderLayout.EAST);
		warning.setLayout(null);

		btnStart = new JButton();
		btnStart.setAction(action);
		btnStart.setBounds(317, 218, 89, 23);
		warning.add(btnStart);

		btnSomething = new JButton("Add Patient");
		btnSomething.setAction(action_1);
		btnSomething.setBounds(43, 48, 112, 23);
		warning.add(btnSomething);

		txtpnHello = new JTextPane();
		txtpnHello.setEditable(false);
		txtpnHello.setText(myData.toString());
		txtpnHello.setBounds(663, 11, 101, 173);
		warning.add(txtpnHello);

		btnFindPatient = new JButton("Find Patient");
		btnFindPatient.setAction(action_2);
		btnFindPatient.setBounds(165, 48, 112, 23);
		warning.add(btnFindPatient);

		comboBox = new JComboBox();
		comboBox.setMaximumRowCount(100);
		comboBox.setBounds(165, 105, 112, 22);
		warning.add(comboBox);

		btnCreatePatient = new JButton("Create Patient");
		btnCreatePatient.setAction(action_3);
		btnCreatePatient.setBounds(43, 105, 125, 23);
		warning.add(btnCreatePatient);

		test = new JTextPane();
		test.setBounds(43, 313, 363, 69);
		warning.add(test);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(174, 161, 232, 127);
		warning.add(scrollPane);

		list = new JList(myData.getAceList());
		scrollPane.setViewportView(list);
		list.setVisible(false);

		rdbtnOpenAceList = new JRadioButton("Open ACE List");
		rdbtnOpenAceList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.setVisible(true);
				scrollPane.setVisible(true);
			}
		});
		buttonGroup.add(rdbtnOpenAceList);
		rdbtnOpenAceList.setBounds(46, 161, 122, 23);
		warning.add(rdbtnOpenAceList);

		rdbtnCloseAceList = new JRadioButton("Close ACE List");
		rdbtnCloseAceList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.setVisible(false);
				scrollPane.setVisible(false);
			}
		});
		buttonGroup.add(rdbtnCloseAceList);
		rdbtnCloseAceList.setBounds(46, 187, 122, 23);
		warning.add(rdbtnCloseAceList);

		label = new JLabel("Patient Manager");
		label.setBounds(10, 11, 158, 14);
		warning.add(label);

		btnNewButton = new JButton("Finish/Save");

		btnNewButton.setBounds(261, 288, 125, 23);
		warning.add(btnNewButton);

		btnAddAce = new JButton("Add ACE");

		btnAddAce.setBounds(43, 218, 125, 23);
		warning.add(btnAddAce);

		btnRemoveAce = new JButton("Remove ACE");
		btnRemoveAce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnRemoveAce.setBounds(43, 252, 125, 23);
		warning.add(btnRemoveAce);

		searchID = new JTextField();
		searchID.setBounds(287, 106, 96, 20);
		warning.add(searchID);
		searchID.setColumns(10);

		lblFindById = new JLabel("Search by ID");
		lblFindById.setBounds(287, 92, 96, 14);
		warning.add(lblFindById);

		lblFindBy = new JLabel(" Find by Dropdown");
		lblFindBy.setBounds(165, 92, 112, 14);
		warning.add(lblFindBy);

		btnSearch = new JButton("Search");

		btnSearch.setBounds(390, 105, 89, 23);
		warning.add(btnSearch);

		btnAddAce2 = new JButton("Add ACE");
		btnAddAce2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ph2.addACE((String) list.getSelectedValue());
				test.setText(ph2.toString());
			}
		});
		btnAddAce2.setBounds(43, 218, 125, 23);
		warning.add(btnAddAce2);

		btnRemoveAce2 = new JButton("Remove ACE");
		btnRemoveAce2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ph2.removeACE((String) list.getSelectedValue());
				test.setText(ph2.toString());
			}
		});
		btnRemoveAce2.setBounds(43, 252, 125, 23);
		warning.add(btnRemoveAce2);

		btnFinishsave2 = new JButton("Finish/Save");
		btnFinishsave2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				rdbtnCloseAceList.setVisible(false);
				rdbtnOpenAceList.setVisible(false);
				rdbtnCloseAceList.setVisible(false);
				rdbtnOpenAceList.setVisible(false);
				btnAddAce2.setVisible(false);
				btnRemoveAce2.setVisible(false);
				btnFinishsave2.setVisible(false);
				test.setVisible(false);
				list.setVisible(false);
				scrollPane.setVisible(false);
				comboBox.setVisible(false);
				lblFindById.setVisible(false);
				lblFindBy.setVisible(false);
				searchID.setVisible(false);
				btnSearch.setVisible(false);
				btnSomething.setVisible(true);
				btnFindPatient.setVisible(true);
			}
		});
		btnFinishsave2.setBounds(280, 288, 126, 23);
		warning.add(btnFinishsave2);

		scrollPane.setVisible(false);
		rdbtnCloseAceList.setVisible(false);
		rdbtnOpenAceList.setVisible(false);
		btnSomething.setVisible(false);
		comboBox.setVisible(false);
		btnCreatePatient.setVisible(false);
		btnFindPatient.setVisible(false);
		txtpnHello.setVisible(false);
		btnNewButton.setVisible(false);
		btnAddAce.setVisible(false);
		btnRemoveAce.setVisible(false);
		rdbtnCloseAceList.setVisible(false);
		rdbtnOpenAceList.setVisible(false);
		list.setVisible(false);
		scrollPane.setVisible(false);
		test.setVisible(false);
		lblFindById.setVisible(false);
		lblFindBy.setVisible(false);
		searchID.setVisible(false);
		btnSearch.setVisible(false);
		btnAddAce2.setVisible(false);
		btnRemoveAce2.setVisible(false);
		btnFinishsave2.setVisible(false);

	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Start");
			putValue(SHORT_DESCRIPTION, "Start The Program");
		}

		public void actionPerformed(ActionEvent e) {

			btnSomething.setVisible(true);
			btnStart.setVisible(false);
			btnFindPatient.setVisible(true);
		}
	}

	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Add Patient");
			putValue(SHORT_DESCRIPTION, "Add a Patient to the Clinic");
		}

		public void actionPerformed(ActionEvent e) {
			btnSomething.setVisible(false);
			btnFindPatient.setVisible(false);
			btnCreatePatient.setVisible(true);

		}
	}
	
	
	
	
	
	
	
	

	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Find Patient");
			putValue(SHORT_DESCRIPTION, "Find a Patient by ID");
		}

		public void actionPerformed(ActionEvent e) {
			
			btnSomething.setVisible(false);
			btnFindPatient.setVisible(false);
			comboBox.setVisible(true);
			lblFindById.setVisible(true);
			lblFindBy.setVisible(true);
			searchID.setVisible(true);
			btnSearch.setVisible(true);

			btnSearch.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					ph2 = new Patient();
					if (myData.getPatient(searchID.getText()) != null) {
						
						ph2 = (Patient) myData.getPatient(searchID.getText());
						test.setText(ph2.toString());
						rdbtnCloseAceList.setVisible(true);
						rdbtnOpenAceList.setVisible(true);
						rdbtnCloseAceList.setVisible(true);
						rdbtnOpenAceList.setVisible(true);
						btnAddAce2.setVisible(true);
						btnRemoveAce2.setVisible(true);
						btnFinishsave2.setVisible(true);
						test.setVisible(true);

					}

				}
				
			});
			
		}
	}

	
	
	
	
	
	
	
	
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "Create Patient");
			putValue(SHORT_DESCRIPTION, "Creates a patient");
		}

		public void actionPerformed(ActionEvent e) {

			Patient ph = new Patient();

			do {
				try {
					String delayStr = JOptionPane.showInputDialog("Enter Patient ID");
					ph.setId(delayStr);
				} catch (Exception e1) {
					ph.setId(null);
				}
			} while (ph.getId() == null || myData.getPatient(ph.getId()) != null);
			test.setText(ph.toString());
			do {
				try {
					String delayStr = JOptionPane.showInputDialog("Enter Patient Name");
					ph.setName(delayStr);
				} catch (Exception e1) {
					ph.setId(null);
				}
			} while (ph.getName() == null);
			test.setText(ph.toString());
			btnCreatePatient.setVisible(false);
			rdbtnCloseAceList.setVisible(true);
			rdbtnOpenAceList.setVisible(true);
			rdbtnCloseAceList.setVisible(true);
			rdbtnOpenAceList.setVisible(true);
			btnAddAce.setVisible(true);
			btnRemoveAce.setVisible(true);
			btnNewButton.setVisible(true);
			test.setVisible(true);

			btnAddAce.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					ph.addACE((String) list.getSelectedValue());
					test.setText(ph.toString());
				}
			});
			btnRemoveAce.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					ph.removeACE(((String) list.getSelectedValue()));
					test.setText(ph.toString());
				}
			});
			btnNewButton.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent e) {
					myData.addPatient(ph);
					test.setText(myData.toString());
					btnNewButton.setVisible(false);
					btnAddAce.setVisible(false);
					btnRemoveAce.setVisible(false);
					rdbtnCloseAceList.setVisible(false);
					rdbtnOpenAceList.setVisible(false);
					list.setVisible(false);
					scrollPane.setVisible(false);
					test.setVisible(false);
					btnSomething.setVisible(true);
					btnFindPatient.setVisible(true);

				}
			});

		}
	}

}
