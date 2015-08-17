package com.netbuilder.model;
import facebook4j.*;

public class facebookLike 
{
	private Facebook facebook = new FacebookFactory().getInstance();
	private ResponseList<Account> accounts;
	private ResponseList<Post> feed;
	public facebookLike()
	{
		//setup Facebook access to NB Gardens page
		try {
			facebook.getOAuthAppAccessToken();
			feed = facebook.getFeed("1451279795195170");
		} catch (FacebookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void displayPosts()
	{
		//get news feed
		 for (int i = 0; i < feed.size(); ++i) {
	            // Get that post
	            Post post = feed.get(i);
	            // retrieve message in post
	            String message = post.getMessage();
	            // Print out message.
	            System.out.println(message);
		 }
	}
}
	
	
