package com.netbuilder.gui;

import com.netbuilder.controller.twitterMessageController;

public class callCentreGUI {
	
	public static void main(String[] args) {
		System.out.println("Starting");
		twitterMessageController tmc = new twitterMessageController();
		tmc.postTweet("Test Tweet");
		//tmc.searchTweets();
		System.out.println("Ending");
	}
	
}
