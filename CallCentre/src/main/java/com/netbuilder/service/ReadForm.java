package com.netbuilder.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.pdfbox.PDFReader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import net.sourceforge.tess4j.*;
import net.sourceforge.tess4j.ITessAPI.TessBaseAPI;
import net.sourceforge.tess4j.util.LoadLibs;

public class ReadForm {
	
	public static void main(String[] args) throws IOException {
		ReadForm rf = new ReadForm();
		rf.createImage();
		rf.readText();
		
    }
    
	public void createImage() throws IOException
	{
		PDDocument doc = PDDocument.load(new File("OrderForm2.pdf"));
		List<PDPage>pages =  doc.getDocumentCatalog().getAllPages();
		PDPage page = pages.get(0);
		BufferedImage image =page.convertToImage();
		File outputfile = new File("OrderForm.png");
		ImageIO.write(image, "png", outputfile);
		doc.close();
	}
	
	public void readText()
	{
		System.setProperty("jna.library.path", "32".equals(System.getProperty("sun.arch.data.model")) ? "lib/win32-x86" : "lib/win32-x86-64");

        File imageFile = new File("OrderForm.png");
        Tesseract1 instance = new Tesseract1(); // JNA Direct Mapping
        File tessDataFolder = LoadLibs.extractTessResources("tessdata"); // Maven build bundles English data
        instance.setDatapath(tessDataFolder.getAbsolutePath());

        try {
            String result = instance.doOCR(imageFile);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
	}
}
