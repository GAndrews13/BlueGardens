package com.netbuilder.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import com.netbuilder.model.LoginProducer;

public class GUI extends JFrame {
	private JFrame mainFrame;
	private JPanel controlPanel;
	private JLabel mainLabel;
	private JTextArea nextproduct;
	private JTextArea location;
	private int workerID;
	private String password;
	private JButton button = new JButton("Next order");
	private Font productfont = new Font("Verdana", Font.ITALIC, 72);
	private Font locationfont = new Font("Verdana", Font.ITALIC, 50);
	private Font labelfont = new Font("Verdana", Font.BOLD, 20);
	private Image productimage = null;

	public GUI() {
		prepareGUI();
	}

	/**
	 * @author Jake Prepare GUI - sets up the GUI components so that they can be
	 *         used and are visible
	 */
	private void prepareGUI() {
		mainFrame = new JFrame("Warehouse Order Tracking System");
		mainFrame.setSize(1024, 768);
		mainFrame.setLayout(null);

		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowevent) {
				System.exit(0);
			}
		});

		// New menu bar created using JMenuBar
		JMenuBar menu = new JMenuBar();
		menu.setBounds(0, 0, mainFrame.getWidth(), 30);

		// Setup menu items and add them to the menu categories
		// then add the categories to the menu-bar
		JMenu userMenu = new JMenu("User");
		menu.add(userMenu);

		JMenuItem loginItem = new JMenuItem("Login");
		userMenu.add(loginItem);

		/**
		 * @author Jake If add stock is selected it will bring up inputDialog
		 *         boxes to enter new product info This is then passed on to the
		 *         product class which will add it the system
		 */
		loginItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainLabel.setText("Please login");
				workerID = Integer.parseInt(JOptionPane.showInputDialog(
						mainFrame, "Please enter your worker ID", null));
				password = (JOptionPane.showInputDialog(mainFrame,
						"Enter your password", null));
				SwingUtilities.invokeLater(new Runnable() {
		            @Override
		            public void run() {
		            	LoginProducer lp = new LoginProducer();
		            	lp.setID(workerID);
		            	lp.setPassword(password);
		            	String args[] = {};
		            	try {
							LoginProducer.main(args);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		            }
		        });
				JOptionPane.showMessageDialog(mainFrame, "You have logged in");
				mainLabel.setText("Welcome, you have no assigned orders");

			}

		});

		nextproduct = new JTextArea("N/A");
		nextproduct.setFont(productfont);
		nextproduct.setEditable(false);
		nextproduct.setBounds(5, 440, 600, 200);

		location = new JTextArea("No Location");
		location.setFont(locationfont);
		location.setEditable(false);
		location.setBounds(620, 70, 350, 570);

		button.setBounds(450, 650, 100, 50);
		button.setActionCommand("process");
		button.addActionListener(new ButtonClickListener());
		mainFrame.setVisible(true);

		mainLabel = new JLabel("", JLabel.CENTER);
		mainLabel.setText("You have no orders assigned to you");
		mainLabel.setFont(labelfont);
		mainLabel.setBounds(250, 30, 500, 40);

		controlPanel = new JPanel();
		controlPanel.setLayout(new BorderLayout());
		getContentPane().add(controlPanel);
		// controlPanel.add(mainLabel);
		mainFrame.add(menu);
		mainFrame.add(button);
		mainFrame.add(controlPanel);
		mainFrame.add(mainLabel);
		mainFrame.add(nextproduct);
		mainFrame.add(location);
		mainFrame.setVisible(true);

	}

	// Button
	private class ButtonClickListener implements ActionListener {

		public void actionPerformed(ActionEvent AE) {
			String command = AE.getActionCommand();
			switch (command) {
			case "process":
				if (button.getText() == "Next Order") {
					mainLabel.setText("Order has been assigned to you");
					button.setText("Collected");

					setImage();
				} else {
					mainLabel.setText("No orders are assigned to you");

					button.setText("Next Order");
				}

			}
		}
	}

	private void setImage() {
		try {
			URL url = new URL(
					"http://www.personal.psu.edu/acr117/blogs/audrey/images/image-2.jpg");
			productimage = ImageIO.read(url);
		} catch (Exception e) {
			e.printStackTrace();
		}

		JLabel lblimage = new JLabel(new ImageIcon(productimage));
		lblimage.setBounds(5, 100, 200, 200);
		// mainFrame.add(lblimage);
		mainFrame.getContentPane().add(lblimage);
		mainFrame.setVisible(true);

		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(lblimage);
		// add more components here
		mainFrame.add(mainPanel);
		mainFrame.setVisible(true);
	}
}