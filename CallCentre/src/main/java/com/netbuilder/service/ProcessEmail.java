package com.netbuilder.service;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDPixelMap;



public class ProcessEmail 
{
	private PDDocument document = new PDDocument();
	private PDPage page1 = new PDPage(PDPage.PAGE_SIZE_A4);
	private static PDFont defaultFont = PDType1Font.HELVETICA;
	private static PDFont headingFont = PDType1Font.HELVETICA_BOLD;
	PDPageContentStream content;
	
	public ProcessEmail()
	{
		//Add new c
		document.addPage(page1);
		try {
			content = new PDPageContentStream(document, page1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createEmailForm() throws IOException
	{	
		//Draws Image on the top of the document
		try {
			BufferedImage awtImage = ImageIO.read(new File("C:/Users/Jake/workspace/BlueGardens/CallCentre/src/main/java/com/netbuilder/service/logo.png"));
			PDPixelMap ximage = new PDPixelMap(document, awtImage);
			float scale = 1.0f;
			content.drawXObject(ximage, 50, 750, ximage.getWidth()*scale, ximage.getHeight()*scale);
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("Your file has not been found");
		}
		
		try {
			
			//Open text stream
			content.beginText();
			content.setFont(defaultFont, 14);
			//estimated position below
			content.moveTextPositionByAmount(40, 725);
			//Write text
			content.drawString("TITLE");
			//end that stream
			content.endText();
			//move position to draw line (may not work)
			content.moveTo(30, 10);
			//Draw line (Estimated position and length)
			content.setLineWidth(1);
			content.addLine(80, 725, 300, 725);
			content.closeAndStroke();
			
			content.beginText();
			content.setFont(defaultFont, 14);
			content.moveTextPositionByAmount(40, 700);
			content.drawString("FIRST NAME");
			content.endText();
			content.setLineWidth(1);
			content.addLine(125, 700, 300, 700);
			content.closeAndStroke();
			
			content.beginText();
			content.setFont(defaultFont, 14);
			content.moveTextPositionByAmount(40, 675);
			content.drawString("SURNAME");
			content.endText();
			content.setLineWidth(1);
			content.addLine(110, 675, 300, 675);
			content.closeAndStroke();
			
			content.beginText();
			content.setFont(defaultFont, 14);
			content.moveTextPositionByAmount(40, 650);
			content.drawString("TELEPHONE");
			content.endText();
			content.setLineWidth(1);
			content.addLine(125, 650, 300, 650);
			content.closeAndStroke();
			
			content.beginText();
			content.setFont(defaultFont, 14);
			content.moveTextPositionByAmount(40, 625);
			content.drawString("MOBILE");
			content.endText();
			content.setLineWidth(1);
			content.addLine(95, 625, 300, 625);
			content.closeAndStroke();
			
			content.beginText();
			content.setFont(defaultFont, 14);
			content.moveTextPositionByAmount(40, 600);
			content.drawString("EMAIL");
			content.endText();
			content.setLineWidth(1);
			content.addLine(85, 600, 300, 600);
			content.closeAndStroke();
			
			content.beginText();
			content.setFont(defaultFont, 14);
			content.moveTextPositionByAmount(320, 725);
			content.drawString("ADDRESS");
			content.endText();
			content.setLineWidth(1);
			content.addLine(390, 725, 555, 725);
			content.addLine(320, 700, 555, 700);
			content.addLine(320, 675, 555, 675);
			content.closeAndStroke();
			
			content.beginText();
			content.setFont(defaultFont, 14);
			content.moveTextPositionByAmount(320, 650);
			content.drawString("POSTCODE");
			content.endText();
			content.setLineWidth(1);
			content.addLine(400, 650, 555, 650);
			content.closeAndStroke();
			
			content.beginText();
			content.setFont(defaultFont, 14);
			content.moveTextPositionByAmount(50, 575);
			content.drawString("Please fill out the form in BLOCK CAPITALS");
			content.endText();
			
			content.beginText();
			content.setFont(headingFont, 14);
			content.moveTextPositionByAmount(55, 555);
			content.drawString("Qty.");
			content.endText();
			
			content.beginText();
			content.setFont(headingFont, 14);
			content.moveTextPositionByAmount(120, 555);
			content.drawString("Product ID");
			content.endText();
			
			content.beginText();
			content.setFont(headingFont, 14);
			content.moveTextPositionByAmount(310, 555);
			content.drawString("Product Name");
			content.endText();
			
			content.beginText();
			content.setFont(headingFont, 14);
			content.moveTextPositionByAmount(510, 555);
			content.drawString("Price");
			content.endText();
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void drawTable() throws IOException 
	{
		float margin = 40;
		float y = 550;
		final int rows = 15;
		final int columns = 6;
		final float rowHeight = 25;
		final float tableWidth = page1.findMediaBox().getWidth()-(2*margin);
		float boxWidth = 125;
		final float tableHeight = rowHeight * rows;
		final float columnWidth = boxWidth/(float)columns;
		final float cellMargin = 5;
		
		//Draw Rows
		float nextY = y;
		for(int i = 0; i<= rows; ++i)
		{
			try {
				if(i == 0)
				{
					content.setLineWidth(3);
					content.drawLine(margin, nextY, margin+tableWidth, nextY);
				}
				else
				{
					content.drawLine(margin, nextY, margin+tableWidth, nextY);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			nextY-=rowHeight;
			content.setLineWidth(1);
		}
		
		/*Draw columns
		content.drawLine(margin, y, margin, y-tableHeight);
		content.drawLine(margin+50, y, margin+50, y-tableHeight);
		content.drawLine(margin+175, y, margin+175, y-tableHeight);
		content.drawLine(margin+460, y, margin+460, y-tableHeight);
		content.drawLine(margin+515, y, margin+515, y-tableHeight);
		
		//draw the columns
	    float nextx = margin+50;
	    for (int i = 0; i <= columns; i++) {
	        content.drawLine(nextx, y, nextx, y-tableHeight);
	        nextx += columnWidth;
	    }
	    */
		
		try {
			content.setFont(PDType1Font.HELVETICA_BOLD, 12);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
	}
	
	public void closeDoc() throws IOException
	{
		content.close();
		//Save PDF
		try {
			document.save("OrderForm.pdf");
		} catch (COSVisitorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cardDetails() throws IOException
	{	
		//card number and boxes for entry
		content.beginText();
		content.setFont(PDType1Font.HELVETICA_BOLD, 12);
		content.moveTextPositionByAmount(50, 150);
		content.drawString("Card No:");
		content.endText();
		
		content.drawLine(110, 160, 320, 160);
		content.drawLine(110, 145, 320, 145);
		
		int x = 110;
		int yStart = 160;
		int yEnd = 145;
		for(int i = 0; i < 15; ++i)
		{
			content.drawLine(x, yStart, x, yEnd);
			x = x + 15;
		}
		
		//Expiry Date 
		content.beginText();
		content.setFont(PDType1Font.HELVETICA_BOLD, 12);
		content.moveTextPositionByAmount(50, 115);
		content.drawString("Expiry Date:___ / ___");
		content.endText();
		
		// Signature 
		content.beginText();
		content.setFont(PDType1Font.HELVETICA_BOLD, 12);
		content.moveTextPositionByAmount(370, 115);
		content.drawString("Signature:");
		content.endText();
		
		content.drawLine(370, 100, 550, 100);
		content.drawLine(370, 60, 550, 60);
		content.drawLine(370, 100, 370, 60);
		content.drawLine(550, 100, 550, 60);
	}
		
	
	public static void main(String[] args)
	{
		ProcessEmail pe = new ProcessEmail();
		try {
			pe.createEmailForm();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Call table function 
		try {
			pe.drawTable();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pe.cardDetails();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			pe.closeDoc();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
