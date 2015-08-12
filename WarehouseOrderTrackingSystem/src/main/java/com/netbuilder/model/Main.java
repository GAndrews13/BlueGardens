package com.netbuilder.model;

import javax.swing.SwingUtilities;

import com.netbuilder.view.GUI;

public class Main {
	public static void main(String[] args) {
		GUI graphics = new GUI();
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	String args[] = {};
            	
            	try {
					LoginResponseConsumer.main(args);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	
            }
        });
	}
}