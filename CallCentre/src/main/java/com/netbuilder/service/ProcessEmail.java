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
	private PDRectangle rectangle = page1.getMediaBox();
	private static PDFont defaultFont = PDType1Font.HELVETICA;
	PDPageContentStream content;
	
	public ProcessEmail()
	{
		
	}
	
	public void createEmailForm() throws IOException
	{
		
		document.addPage(page1);
		
		
		content = new PDPageContentStream(document, page1);
		
		//Draws Image on the top of the document
		try {
			BufferedImage awtImage = ImageIO.read(new File("C:/Users/David/workspace/BlueGardens/CallCentre/src/main/java/com/netbuilder/service/logo.png"));
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
			content.setFont(defaultFont, 12);
			//estimated position below
			content.moveTextPositionByAmount(50, 700);
			//Write text
			content.drawString("Title");
			//end that stream
			content.endText();
			//move position to draw line (may not work)
			content.moveTo(30, 10);
			//Draw line (Estimated position and length)
			content.setLineWidth(1);
			content.addLine(100, 700, 300, 700);
			content.closeAndStroke();
			
			content.beginText();
			content.setFont(defaultFont, 12);
			content.moveTextPositionByAmount(50, 680);
			content.drawString("First Name");
			content.endText();
			content.setLineWidth(1);
			content.addLine(120, 680, 300, 680);
			content.closeAndStroke();
			
			content.beginText();
			content.setFont(defaultFont, 12);
			content.moveTextPositionByAmount(50, 660);
			content.drawString("Surname");
			content.endText();
			content.setLineWidth(1);
			content.addLine(110, 660, 300, 660);
			content.closeAndStroke();
			
			content.beginText();
			content.setFont(defaultFont, 12);
			content.moveTextPositionByAmount(50, 640);
			content.drawString("Telephone");
			content.endText();
			content.setLineWidth(1);
			content.addLine(110, 640, 300, 640);
			content.closeAndStroke();
			
			content.beginText();
			content.setFont(defaultFont, 12);
			content.moveTextPositionByAmount(50, 620);
			content.drawString("Mobile");
			content.endText();
			content.setLineWidth(1);
			content.addLine(100, 620, 300, 620);
			content.closeAndStroke();
			
			content.beginText();
			content.setFont(defaultFont, 12);
			content.moveTextPositionByAmount(50, 600);
			content.drawString("Email");
			content.endText();
			content.setLineWidth(1);
			content.addLine(100, 600, 300, 600);
			content.closeAndStroke();
			
			content.beginText();
			content.setFont(defaultFont, 12);
			content.moveTextPositionByAmount(320, 700);
			content.drawString("Address");
			content.endText();
			content.setLineWidth(1);
			content.addLine(375, 700, 520, 700);
			content.addLine(320, 680, 520, 680);
			content.addLine(320, 660, 520, 660);
			content.closeAndStroke();
			
			content.beginText();
			content.setFont(defaultFont, 12);
			content.moveTextPositionByAmount(320, 640);
			content.drawString("Postcode");
			content.endText();
			content.setLineWidth(1);
			content.addLine(380, 640, 520, 640);
			content.closeAndStroke();
			

			content.close();
			
			//Save PDF
			try {
				document.save("OrderForm.pdf");
			} catch (COSVisitorException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void drawTable(PDPage page, PDPageContentStream contentStream, float y,
			float margin, String[][] content) throws IOException 
	{
		final int rows = 10;
		final int columns = 4;
		final float rowHeight = 20f;
		final float tableWidth = page.findMediaBox().getWidth()-(2*margin);
		final float tableHeight = rowHeight * rows;
		final float columnWidth = tableHeight/(float)columns;
		final float cellMargin = 5f;
		
		//Draw Rows
		float nextY = y;
		for(int i = 0; i<= rows; ++i)
		{
			try {
				contentStream.drawLine(margin, nextY, margin+tableWidth, nextY);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			nextY-=rowHeight;
		}
		
		//Draw columns
		float nextX = margin;
		for(int i = 0; i<= columns; ++i)
		{
			try {
				contentStream.drawLine(nextX, y, nextX, y-tableHeight);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			nextX+=columnWidth;
		}
		
		//Fun bit
	/*	try {
			contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
		
		float textX = margin + cellMargin;
		float textY = y-15;
		for(int i = 0; i < content.length; ++i)
		{
			for(int j = 0; j < content[i].length; ++j)
			{
				String text = content[i][j];
				contentStream.beginText();
				contentStream.moveTextPositionByAmount(textX, textY);
				contentStream.drawString(text);
				contentStream.endText();
				textX += columnWidth;
			}
			textY -= rowHeight;
			textX = margin + cellMargin;
		}
		
		
	
	}
	
	
	
	public static void main(String[] args)
	{
		ProcessEmail PE = new ProcessEmail();
		try {
			PE.createEmailForm();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Call table function 
				String[][] contents = {{"Qty","Product ID","Product Name", "Price"}};
				try {
					drawTable(PE.page1, PE.content, 500, 100, contents);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

}
