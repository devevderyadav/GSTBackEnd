package com.mygstinvoice.pdfcreation;
import java.io.File;
import java.io.IOException;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import com.itextpdf.kernel.geom.PageSize;
import com.mygstinvoice.InvoiceForm;
 
/**
 * Simple Hello World example.
 */

public class InvoicePdfCreater {
 
	   public Table listInvoiceItems;
       public Cell itemCell;
      
      
	
	
/*	public static final String DEST = "/home/krishna/Desktop/testitext/Invoice.pdf";*/
 
	public static final String DEST = "src/main/resources/results/Invoice.pdf";
    
 
   
    public void createPdf(InvoiceForm invoiceFormData) throws IOException {
    	
    	System.out.println("inside create Pdf Method ");
    
    	File file = new File(DEST);
        file.getParentFile().mkdirs();
        
    	
    	final String logo = "src/main/resources/images/logo.png";
    	
    	   PdfFont font = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
           PdfFont bold = PdfFontFactory.createFont(FontConstants.COURIER_BOLD);
       
        //Initialize PDF writer
        PdfWriter writer = new PdfWriter(DEST);
 
        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);
 
        // Initialize document
       /* Document document = new Document(pdf);*/
        
        Document document = new Document(pdf, new PageSize(PageSize.A3));
        
        Image logoImage = new Image(ImageDataFactory.create(logo));
        
        logoImage.scaleToFit(150, 150);
        logoImage.setMarginBottom(10);
        logoImage.setMarginLeft(5);
        //Add paragraph to the document
        
       
        Table header = new Table(2);
        
         Cell logoHeaderCell= new Cell(1,1);
         
         logoHeaderCell.setBorder(null);
         
         logoHeaderCell.add(logoImage);
         header.addCell(logoHeaderCell);
       
        
        
          Cell headerRHS= new Cell(1,1);
          headerRHS.setBorder(null);
          headerRHS.add(new Paragraph("INVOICE").setFont(font).setFontSize(20).setMargins(30, 10, 10, 240));
          headerRHS.add(new Paragraph("#"+invoiceFormData.getSender().getSerialNoOfInvoice()).setFont(font).setMargins(0, 10, 10, 240));
          header.addCell(headerRHS);
          document.add(header);
         
      
       
        
        @SuppressWarnings("deprecation")
		Table sender= new Table(2);
        sender.setMarginLeft(20);
        Cell senderAddress = new Cell();
        senderAddress.setBorder(null);
        senderAddress.add(new Paragraph(invoiceFormData.getSender().getSenderName()+ ":").setFont(bold).setFontSize(10));
        senderAddress.add(new Paragraph("GSTIN: "+ invoiceFormData.getSender().getSenderGSTIN()).setFont(bold).setFontSize(10));
        senderAddress.add(new Paragraph(""+invoiceFormData.getSender().getSenderStreet()+",").setFont(font).setFontSize(10));
        senderAddress.add(new Paragraph(String.format("%s-%s %s", invoiceFormData.getSender().getSenderCity(),invoiceFormData.getSender().getSenderState(),invoiceFormData.getSender().getSenderZip())).setFont(font).setFontSize(10));
       /* senderAddress.add(new Paragraph("Address line 2").setFont(font).setFontSize(10));*/
        senderAddress.add(new Paragraph("Email: info@starterscfo.in").setFont(font).setFontSize(10));
        
        
        sender.addCell(senderAddress);
       
         
         
         Cell senderRHS = new Cell();
          senderRHS.setBorder(null);
          
          senderRHS.setMargins(10, 20, 0, 150);
          senderRHS.add(new Paragraph("Date: "+invoiceFormData.getSender().getDateOfInvoice()).setFont(font).setFontSize(12));
          senderRHS.add(new Paragraph("Due Date:").setFont(font).setFontSize(12));
          senderRHS.add(new Paragraph("Balance Due:"+String.valueOf(Float.parseFloat(invoiceFormData.getGrandTotals().getGrandTotalWithTax()))).setFont(font).setTextAlignment(TextAlignment.CENTER).setBackgroundColor(Color.LIGHT_GRAY).setFontSize(14).setHeight(25).setPaddingTop(7).setWidth(200));
          sender.addCell(senderRHS);
          
          document.add(sender);
         
        @SuppressWarnings("deprecation")
		Table table = new Table(1);
        table.setMarginTop(10);
        table.setMarginBottom(10);
        // first row
        Cell cell = new Cell(1, 15).add(new Paragraph(""));
        cell.setTextAlignment(TextAlignment.CENTER);
        cell.setPadding(1);
        cell.setBackgroundColor(new DeviceRgb(140, 221, 8));
        table.addCell(cell);
        document.add(table);
        
        document.add(new Paragraph("Bill To").setFont(font).setFontSize(12).setMarginLeft(20));
        
        @SuppressWarnings("deprecation")
  		Table billTo  = new Table(2);
          billTo.setMarginLeft(20);
          Cell billTocell = new Cell();
          billTocell.setBorder(null);
          billTocell.add(new Paragraph(invoiceFormData.getReceiver().getReceiverName()).setFont(bold).setFontSize(10));
          billTocell.add(new Paragraph("GSTIN/Unique ID: "+invoiceFormData.getReceiver().getReceiverUniqueID()).setFont(font).setFontSize(10));
          billTocell.add(new Paragraph("State Code: " +invoiceFormData.getReceiver().getReceiverStateCode()).setFont(font).setFontSize(10));	
          billTocell.add(new Paragraph(invoiceFormData.getReceiver().getReceiverStreet()).setFont(font).setFontSize(10));
          billTocell.add(new Paragraph(String.format("%s-%s %s", invoiceFormData.getReceiver().getReceiverCity(), invoiceFormData.getReceiver().getReceiverState(), invoiceFormData.getReceiver().getReceiverZip())).setFont(font)).setFontSize(10);
          /* billTocell.add(new Paragraph("Address line 2").setFont(font).setFontSize(10));*/
          billTocell.add(new Paragraph("Email: info@starterscfo.in").setFont(font).setFontSize(10));
          
         
          billTo.addCell(billTocell);
          
           Cell taxType= new Cell();
           taxType.setBorder(null);
           taxType.add( new Paragraph("Tax Applicable: "+ invoiceFormData.getTaxType()).setFont(font).setFontSize(12).setMarginLeft(150) );
           
           
           billTo.addCell(taxType);
          
           document.add(billTo);
    
       
           document.add(table);// this is for under line 
       
        
           
           
           listInvoiceItems = new Table(10);
           
          
           itemTableHeader(font);
           
           System.out.println("Length of invoice List"+invoiceFormData.getInvoiceItemList().length);
           
           for(int i = 0; i < invoiceFormData.getInvoiceItemList().length; i++){
        	   
        	   System.out.println("Print Row No "+i);
        	   listInvoiceItems(i,invoiceFormData,font);
           }
        
           document.add(listInvoiceItems);
         
           
           
        /*   @SuppressWarnings("deprecation")
   		Table asLine = new Table(1);
           table.setMarginTop(10);
           table.setMarginBottom(10);
           // first row
           Cell lineCell = new Cell(1, 15).add(new Paragraph(""));
           cell.setTextAlignment(TextAlignment.CENTER);
           cell.setPadding(1);
           cell.setBackgroundColor(new DeviceRgb(140, 221, 8));
           table.addCell(cell);*/
           document.add(table);
           
                 
           document.add(totals(font, invoiceFormData));// Grand totalsta
           
           /*Note Starts*/
           document.add(new Paragraph("Note:").setFont(font).setMarginTop(40).setMarginBottom(10));
           document.add(new Paragraph(" HAre Krishna Hare Krishna Krishna Krishna Hare hare hare Ram hare ram ram ram hare hare ").setFont(font).setMarginTop(2).setBackgroundColor(Color.LIGHT_GRAY).setWidth(300));
           
           document.add(new Paragraph("Note 2:").setFont(font).setMarginTop(40).setMarginBottom(10));
           document.add(new Paragraph(" HAre Krishna Hare Krishna Krishna Krishna Hare hare hare Ram hare ram ram ram hare hare ").setFont(font).setMarginTop(2).setBackgroundColor(Color.LIGHT_GRAY).setWidth(300));
           
           
           /*Table note1 =new Table(1);
             Cell noteCell= new Cell();*/
           
           
           @SuppressWarnings("deprecation")
   		Table footertable = new Table(1);
          /* footertable.setMarginTop(10);*/
           footertable.setMarginTop(115);
           // first row
           Cell footerCell = new Cell(1, 15).add(new Paragraph(""));
           footerCell.setTextAlignment(TextAlignment.CENTER);
           footerCell.setPadding(2);
         
           footerCell.add("Free GST Invoice By StartersCFO "+" Powered by Itext7 under AGCL");
           
           footerCell.setBackgroundColor(new DeviceRgb(140, 221, 8));
           footertable.addCell(footerCell);
           document.add(footertable);
              
           
           
           
           document.close();
    }
    
    public Table totals(PdfFont font, InvoiceForm invoiceFormData){
    	
    	  Table listInvoiceItems= new Table(10);
    	  
    	
    	  itemCell = new Cell(0,1);
          itemCell.setBackgroundColor(Color.WHITE);
          itemCell.setBorder(null);         
        
          itemCell.add("").setFont(font).setFontSize(10).setTextAlignment(TextAlignment.CENTER).setFontColor(Color.WHITE);
          itemCell.setVerticalAlignment(VerticalAlignment.MIDDLE);
          itemCell.setHorizontalAlignment(HorizontalAlignment.CENTER);
          listInvoiceItems.addCell( itemCell);

          
          itemCell = new Cell(0,2);
          itemCell.setBackgroundColor(Color.WHITE);
          itemCell.setBorder(null);    
          itemCell.add("").setFont(font).setFontSize(10).setTextAlignment(TextAlignment.CENTER).setFontColor(Color.WHITE);
          itemCell.setVerticalAlignment(VerticalAlignment.MIDDLE);
          itemCell.setHorizontalAlignment(HorizontalAlignment.CENTER);
          listInvoiceItems.addCell( itemCell);
          

          itemCell = new Cell();
          itemCell.setBackgroundColor(Color.WHITE);
          itemCell.setBorder(null);
        
          itemCell.add("").setFont(font).setFontSize(10).setTextAlignment(TextAlignment.CENTER).setFontColor(Color.WHITE);
          itemCell.setVerticalAlignment(VerticalAlignment.MIDDLE);
          itemCell.setHorizontalAlignment(HorizontalAlignment.CENTER);
          listInvoiceItems.addCell( itemCell);
          
          itemCell = new Cell();
          itemCell.setBackgroundColor(Color.WHITE);
          itemCell.setBorder(null); 
          itemCell.setWidth(15);
          itemCell.add("").setFont(font).setFontSize(10).setTextAlignment(TextAlignment.CENTER).setFontColor(Color.WHITE);
          itemCell.setVerticalAlignment(VerticalAlignment.MIDDLE);
          itemCell.setHorizontalAlignment(HorizontalAlignment.CENTER);
          listInvoiceItems.addCell( itemCell);
          
          itemCell = new Cell();
          itemCell.setBackgroundColor(Color.GRAY);
          itemCell.setBorder(null);         
          itemCell.add("Grand Totals = ").setFont(font).setFontSize(10).setTextAlignment(TextAlignment.RIGHT).setFontColor(Color.WHITE);
          itemCell.setVerticalAlignment(VerticalAlignment.MIDDLE);
          itemCell.setHorizontalAlignment(HorizontalAlignment.CENTER);
          listInvoiceItems.addCell( itemCell);
          
          itemCell = new Cell();
         /* itemCell.setBackgroundColor(Color.GRAY);*/
          itemCell.setBorder(null);         
          itemCell.add(String.valueOf(Float.parseFloat(invoiceFormData.getGrandTotals().getGrandTotal()))).setFont(font).setFontSize(10).setTextAlignment(TextAlignment.CENTER).setFontColor(Color.BLACK);
          itemCell.setVerticalAlignment(VerticalAlignment.MIDDLE);
          itemCell.setHorizontalAlignment(HorizontalAlignment.CENTER);
          listInvoiceItems.addCell( itemCell);
          
          itemCell = new Cell();
         /* itemCell.setBackgroundColor(Color.DARK_GRAY);*/
          itemCell.setBorder(null);         
          itemCell.add(String.valueOf(Float.parseFloat(invoiceFormData.getGrandTotals().getDiscountTotal()))).setFont(font).setFontSize(10).setTextAlignment(TextAlignment.CENTER).setFontColor(Color.BLACK);
          itemCell.setVerticalAlignment(VerticalAlignment.MIDDLE);
          itemCell.setHorizontalAlignment(HorizontalAlignment.CENTER);
          listInvoiceItems.addCell( itemCell);
          
          itemCell = new Cell();
         /* itemCell.setBackgroundColor(Color.DARK_GRAY);*/
          itemCell.setBorder(null);         
          itemCell.add(String.valueOf(Float.parseFloat(invoiceFormData.getGrandTotals().getTotalTax()))).setFont(font).setFontSize(10).setTextAlignment(TextAlignment.CENTER).setFontColor(Color.BLACK);
          itemCell.setVerticalAlignment(VerticalAlignment.MIDDLE);
          itemCell.setHorizontalAlignment(HorizontalAlignment.CENTER);
          listInvoiceItems.addCell( itemCell);
          
          itemCell = new Cell();
          /*itemCell.setBackgroundColor(Color.DARK_GRAY);*/
          itemCell.setBorder(null);         
          itemCell.add(String.valueOf(Float.parseFloat(invoiceFormData.getGrandTotals().getGrandTotalWithTax()))).setFont(font).setFontSize(10).setTextAlignment(TextAlignment.CENTER).setFontColor(Color.BLACK);
          itemCell.setVerticalAlignment(VerticalAlignment.MIDDLE);
          itemCell.setHorizontalAlignment(HorizontalAlignment.CENTER);
          listInvoiceItems.addCell( itemCell);
          return listInvoiceItems;

    	
    	
    }
    
    
    public void itemTableHeader(PdfFont font){
    	
    	
    	  itemCell = new Cell(0,1);
          itemCell.setBackgroundColor(Color.DARK_GRAY);
          itemCell.setBorder(null);         
        
          itemCell.add("Sr No").setFont(font).setFontSize(10).setTextAlignment(TextAlignment.CENTER).setFontColor(Color.WHITE);
          itemCell.setVerticalAlignment(VerticalAlignment.MIDDLE);
          itemCell.setHorizontalAlignment(HorizontalAlignment.CENTER);
          listInvoiceItems.addCell( itemCell);

          
          itemCell = new Cell(0,2);
          itemCell.setBackgroundColor(Color.DARK_GRAY);
          itemCell.setBorder(null);    
          itemCell.add("Description of Item").setFont(font).setFontSize(10).setTextAlignment(TextAlignment.CENTER).setFontColor(Color.WHITE);
          itemCell.setVerticalAlignment(VerticalAlignment.MIDDLE);
          itemCell.setHorizontalAlignment(HorizontalAlignment.CENTER);
          listInvoiceItems.addCell( itemCell);
          

          itemCell = new Cell();
          itemCell.setBackgroundColor(Color.DARK_GRAY);
          itemCell.setBorder(null);
        
          itemCell.add("HSN").setFont(font).setFontSize(10).setTextAlignment(TextAlignment.CENTER).setFontColor(Color.WHITE);
          itemCell.setVerticalAlignment(VerticalAlignment.MIDDLE);
          itemCell.setHorizontalAlignment(HorizontalAlignment.CENTER);
          listInvoiceItems.addCell( itemCell);
          
          itemCell = new Cell();
          itemCell.setBackgroundColor(Color.DARK_GRAY);
          itemCell.setBorder(null); 
          itemCell.setWidth(15);
          itemCell.add("Quantity").setFont(font).setFontSize(10).setTextAlignment(TextAlignment.CENTER).setFontColor(Color.WHITE);
          itemCell.setVerticalAlignment(VerticalAlignment.MIDDLE);
          itemCell.setHorizontalAlignment(HorizontalAlignment.CENTER);
          listInvoiceItems.addCell( itemCell);
          
          itemCell = new Cell();
          itemCell.setBackgroundColor(Color.DARK_GRAY);
          itemCell.setBorder(null);         
          itemCell.add("Rate/Amount").setFont(font).setFontSize(10).setTextAlignment(TextAlignment.CENTER).setFontColor(Color.WHITE);
          itemCell.setVerticalAlignment(VerticalAlignment.MIDDLE);
          itemCell.setHorizontalAlignment(HorizontalAlignment.CENTER);
          listInvoiceItems.addCell( itemCell);
          
          itemCell = new Cell();
          itemCell.setBackgroundColor(Color.DARK_GRAY);
          itemCell.setBorder(null);         
          itemCell.add("Total").setFont(font).setFontSize(10).setTextAlignment(TextAlignment.CENTER).setFontColor(Color.WHITE);
          itemCell.setVerticalAlignment(VerticalAlignment.MIDDLE);
          itemCell.setHorizontalAlignment(HorizontalAlignment.CENTER);
          listInvoiceItems.addCell( itemCell);
          
          itemCell = new Cell();
          itemCell.setBackgroundColor(Color.DARK_GRAY);
          itemCell.setBorder(null);         
          itemCell.add("Discount").setFont(font).setFontSize(10).setTextAlignment(TextAlignment.CENTER).setFontColor(Color.WHITE);
          itemCell.setVerticalAlignment(VerticalAlignment.MIDDLE);
          itemCell.setHorizontalAlignment(HorizontalAlignment.CENTER);
          listInvoiceItems.addCell( itemCell);
          
          itemCell = new Cell();
          itemCell.setBackgroundColor(Color.DARK_GRAY);
          itemCell.setBorder(null);         
          itemCell.add("Tax %").setFont(font).setFontSize(10).setTextAlignment(TextAlignment.CENTER).setFontColor(Color.WHITE);
          itemCell.setVerticalAlignment(VerticalAlignment.MIDDLE);
          itemCell.setHorizontalAlignment(HorizontalAlignment.CENTER);
          listInvoiceItems.addCell( itemCell);
          
          itemCell = new Cell();
          itemCell.setBackgroundColor(Color.DARK_GRAY);
          itemCell.setBorder(null);         
          itemCell.add("Total After Tax").setFont(font).setFontSize(10).setTextAlignment(TextAlignment.CENTER).setFontColor(Color.WHITE);
          itemCell.setVerticalAlignment(VerticalAlignment.MIDDLE);
          itemCell.setHorizontalAlignment(HorizontalAlignment.CENTER);
          listInvoiceItems.addCell( itemCell);
    }
    
    public String isEmptyString(String value){
		
    	if(value==""){
    		
    		return "0";
    	} 
    	
    	return value;
    	
    	
    }
    
    public void listInvoiceItems(int i, InvoiceForm invoiceFormData, PdfFont font){
    	
   float  total=Float.parseFloat(isEmptyString(invoiceFormData.getInvoiceItemList()[i].getQuantity()))*Float.parseFloat(isEmptyString(invoiceFormData.getInvoiceItemList()[i].getRatePerItem()));
  
    float discount = Float.parseFloat(isEmptyString(invoiceFormData.getInvoiceItemList()[i].getDiscount()));
    float tax = total*Float.parseFloat(isEmptyString(invoiceFormData.getInvoiceItemList()[i].getTaxRate()))/100;
    float totalAfterTax= total-discount+tax;
    
   
    	  itemCell = new Cell();
          itemCell.setBackgroundColor(Color.WHITE);
          itemCell.setBorder(null);  
          itemCell.add("# "+invoiceFormData.getInvoiceItemList()[i].getSerialNo() ).setFont(font).setFontSize(10).setTextAlignment(TextAlignment.CENTER).setFontColor(Color.BLACK);
          itemCell.setVerticalAlignment(VerticalAlignment.MIDDLE);
          itemCell.setHorizontalAlignment(HorizontalAlignment.CENTER);
          listInvoiceItems.addCell( itemCell);

          
          itemCell = new Cell(1,2);
          itemCell.setBackgroundColor(Color.WHITE);
          itemCell.setBorder(null);    
          itemCell.add(invoiceFormData.getInvoiceItemList()[i].getDescriptionOfGood()).setFont(font).setFontSize(10).setTextAlignment(TextAlignment.CENTER).setFontColor(Color.BLACK);
          itemCell.setVerticalAlignment(VerticalAlignment.MIDDLE);
          itemCell.setHorizontalAlignment(HorizontalAlignment.CENTER);
          listInvoiceItems.addCell( itemCell);
          

          itemCell = new Cell();
          itemCell.setBackgroundColor(Color.WHITE);
          itemCell.setBorder(null);             
          itemCell.add(invoiceFormData.getInvoiceItemList()[i].getHsn()).setFont(font).setFontSize(10).setTextAlignment(TextAlignment.CENTER).setFontColor(Color.BLACK);
          itemCell.setVerticalAlignment(VerticalAlignment.MIDDLE);
          itemCell.setHorizontalAlignment(HorizontalAlignment.CENTER);
          listInvoiceItems.addCell( itemCell);
          
          itemCell = new Cell();
          itemCell.setBackgroundColor(Color.WHITE);
          itemCell.setBorder(null);
          
          itemCell.add(invoiceFormData.getInvoiceItemList()[i].getQuantity()).setFont(font).setFontSize(10).setTextAlignment(TextAlignment.CENTER).setFontColor(Color.BLACK);
          itemCell.setVerticalAlignment(VerticalAlignment.MIDDLE);
          itemCell.setHorizontalAlignment(HorizontalAlignment.CENTER);
          listInvoiceItems.addCell( itemCell);
          
          itemCell = new Cell();
          itemCell.setBackgroundColor(Color.WHITE);
          itemCell.setBorder(null);         
          itemCell.add(invoiceFormData.getInvoiceItemList()[i].getRatePerItem()).setFont(font).setFontSize(10).setTextAlignment(TextAlignment.CENTER).setFontColor(Color.BLACK);
          itemCell.setVerticalAlignment(VerticalAlignment.MIDDLE);
          itemCell.setHorizontalAlignment(HorizontalAlignment.CENTER);
          listInvoiceItems.addCell( itemCell);
          

          itemCell = new Cell();
          itemCell.setBackgroundColor(Color.WHITE);
          itemCell.setBorder(null);         
          itemCell.add(String.valueOf(total)).setFont(font).setFontSize(10).setTextAlignment(TextAlignment.CENTER).setFontColor(Color.BLACK);
          itemCell.setVerticalAlignment(VerticalAlignment.MIDDLE);
          itemCell.setHorizontalAlignment(HorizontalAlignment.CENTER);
          listInvoiceItems.addCell( itemCell);
          
          itemCell = new Cell();
          itemCell.setBackgroundColor(Color.WHITE);
          itemCell.setBorder(null);         
          itemCell.add(isEmptyString(invoiceFormData.getInvoiceItemList()[i].getDiscount())).setFont(font).setFontSize(10).setTextAlignment(TextAlignment.CENTER).setFontColor(Color.BLACK);
          itemCell.setVerticalAlignment(VerticalAlignment.MIDDLE);
          itemCell.setHorizontalAlignment(HorizontalAlignment.CENTER);
          listInvoiceItems.addCell( itemCell);
          
          itemCell = new Cell();
          itemCell.setBackgroundColor(Color.WHITE);
          itemCell.setBorder(null);         
          itemCell.add("("+invoiceFormData.getInvoiceItemList()[i].getTaxRate()+"%) \t"+ tax).setFont(font).setFontSize(10).setTextAlignment(TextAlignment.CENTER).setFontColor(Color.BLACK);
          itemCell.setVerticalAlignment(VerticalAlignment.MIDDLE);
          itemCell.setHorizontalAlignment(HorizontalAlignment.CENTER);
          listInvoiceItems.addCell( itemCell);
          
          itemCell = new Cell();
          itemCell.setBackgroundColor(Color.WHITE);
          itemCell.setBorder(null);         
          itemCell.add(String.valueOf(totalAfterTax)).setFont(font).setFontSize(10).setTextAlignment(TextAlignment.CENTER).setFontColor(Color.BLACK);
          itemCell.setVerticalAlignment(VerticalAlignment.MIDDLE);
          itemCell.setHorizontalAlignment(HorizontalAlignment.CENTER);
          listInvoiceItems.addCell( itemCell);
    	
    }
    
   
}