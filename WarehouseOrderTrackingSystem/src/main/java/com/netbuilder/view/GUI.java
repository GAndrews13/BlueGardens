package com.netbuilder.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.util.ArrayList;

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

import com.netbuilder.model.ActionWOTS;
import com.netbuilder.model.CustomerOrder;
import com.netbuilder.model.CustomerOrderLine;
import com.netbuilder.model.DummyData;
import com.netbuilder.model.LoginProducer;
import com.netbuilder.model.LoginResponseConsumer;
import com.netbuilder.model.Product;
import com.netbuilder.model.WarehouseLocation;
import com.netbuilder.model.WarehouseWorker;

public class GUI extends JFrame {
	private JFrame mainFrame;
	private JPanel controlPanel;
	private JLabel mainLabel;
	private JTextArea nextproduct;
	private JTextArea location;
	private int workerID;
	private boolean isLoggedIn = false;
	private String password;
	private static DummyData dummyData;
	String response;
	private JButton button = new JButton("Next order");
	private Font productfont = new Font("Verdana", Font.ITALIC, 22);
	private Font locationfont = new Font("Verdana", Font.ITALIC, 20);
	private Font labelfont = new Font("Verdana", Font.BOLD, 14);
	private Image productimage = null;
	private ArrayList<CustomerOrder> customerOrders = new ArrayList<CustomerOrder>();
	private ArrayList<CustomerOrderLine> currentOrderLines = new ArrayList<CustomerOrderLine>();;
	private CustomerOrder currentOrder;
	private int orderLineCount = 0;
	ActionWOTS action;

	public GUI() {
		dummyData = new DummyData();
		for(CustomerOrder c : dummyData.getCustomerOrders()){
			if(c.getIsAssigned() == false){
				customerOrders.add(c);
			}
		}
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

				for(int i = 0; i<dummyData.getWorkers().size(); i++){
					if(dummyData.getWorkers().get(i).getWorkerId() == workerID && dummyData.getWorkers().get(i).getPassword().equals(password)){
						isLoggedIn = true;
						mainLabel.setText("Welcome " + dummyData.getWorkers().get(i).getName() + ", you have no assigned orders");
					}
				}	
				
				
				/* SwingUtilities.invokeLater(new Runnable() {
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
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} */
				

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
			
			if(workerID > 0){
				
				if(customerOrders.isEmpty()){
					location.setText("No Location");
					nextproduct.setText("N/A");
					mainLabel.setText("There are no more unassigned customer orders");
				}else{
			
			String command = AE.getActionCommand();
			switch (command) {
			case "process":
				if (button.getText() == "Next Order") {

					button.setText("Next Product");
					
					break;
				}
			
			case "product":
				
				//----------------------------------------------------------------------------------------------
				
				if(orderLineCount == 0){
					customerOrders.get(0).setWorker(workerID);
					customerOrders.get(0).setIsAssigned(true);
					currentOrder = customerOrders.get(0);
					customerOrders.remove(0);
					
					for(CustomerOrderLine col : dummyData.getCustomerOrderLines()){
						if(currentOrder.getCustomerOrderID() == col.getCustomerOrderID()){
							currentOrderLines.add(col);
						}
					}
								
					location.setText("Warehouse Location: " + findByProduct(currentOrderLines.get(0).getProductId()).getLocationId());
					nextproduct.setText("Product ID: " + currentOrderLines.get(0).getProductId() + "\nProduct Name: "
					+ findByID(currentOrderLines.get(0).getProductId()).getProductName() +
							"\nQuantity: " + currentOrderLines.get(0).getQuantity());
					currentOrderLines.get(0).setIsPicked(true);
					
					button.setActionCommand("product");
					
					orderLineCount++;
				}
				
				//----------------------------------------------------------------------------------------------
				
				mainLabel.setText("Order has been assigned to you");
				button.setText("Next Product");
				
				if(currentOrderLines.size() > 0){
					location.setText("Warehouse Location: " + findByProduct(currentOrderLines.get(0).getProductId()).getLocationId());
					nextproduct.setText("Product ID: " + currentOrderLines.get(0).getProductId() + "\nProduct Name: "
					+ findByID(currentOrderLines.get(0).getProductId()).getProductName() +
							"\nQuantity: " + currentOrderLines.get(0).getQuantity());
					currentOrderLines.remove(0);
					button.setActionCommand("product");
				}else{
					button.setActionCommand("collected");
				}
				break;
				
			case "collected":
				
				mainLabel.setText("Order Collected");
				button.setText("Next Order");
				
				location.setText("No Location");
				nextproduct.setText("N/A");
				
				if(currentOrderLines.size() > 0){
					updateOrder(currentOrder.getCustomerOrderID());
					updateOrderLines(currentOrder.getCustomerOrderID());
				}
				
				orderLineCount = 0;
				
				button.setActionCommand("product");
				break;
				
				
				 default: 
					mainLabel.setText("No orders are assigned to you");

					button.setText("Next Order");
				

			}
				}
			
		}else if (workerID == 0){
			mainLabel.setText("Please log in");
		}
		
		}
	}

	
	public WarehouseLocation findByProduct(int productID){
		for(WarehouseLocation wl : dummyData.getLocations()){
			if(wl.getProductId() == productID){
				return wl;
			}
		}
		return null;
	}
	
	public Product findByID(int productID){
		for(Product p : dummyData.getProducts()){
			if(p.getProductID() == productID){
				return p;
			}
		}
		return null;
	}
	
	public void updateOrder (int customerOrderID){
		for(CustomerOrder co : dummyData.getCustomerOrders()){
			if(co.getCustomerOrderID() == customerOrderID){
				co.setIsAssigned(true);
			}
		}
	}
	
	public void updateOrderLines (int customerOrderID){
		for(CustomerOrderLine col : dummyData.getCustomerOrderLines()){
			if(col.getCustomerOrderID() == customerOrderID){
				col.setIsPicked(true);
			}
		}
	}

	/*private void setImage() {
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
	}*/
}