package com.mygstinvoice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicLong;














import org.apache.catalina.connector.Response;
import org.json.simple.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mygstinvoice.pdfcreation.InvoicePdfCreater;

@RestController
public class InvoiceController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    private InvoicePdfCreater invoicePdfCreater= new InvoicePdfCreater();

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping( value="/greeting", produces="application/json")
    public  JSONObject greeting(@RequestParam(value="name", defaultValue="World") String name) {
        
    	JSONObject obj = new JSONObject();
    	
    	

	      obj.put("name", "foo");
	      obj.put("num", new Integer(100));
	      obj.put("balance", new Double(1000.21));
	      obj.put("is_vip", new Boolean(true));
    	return obj;
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.GET,value="/hello")
    		 public  JSONObject  greeting1(@RequestParam(value="name", defaultValue="World") String name) {
      
    	  JSONObject obj = new JSONObject();

	      obj.put("name", "foo");
	      obj.put("num", new Integer(100));
	      obj.put("balance", new Double(1000.21));
	      obj.put("is_vip", new Boolean(true));
    	
    	return obj;
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.POST,value="/submitInvoiceForm")
    		 public  JSONObject  formData( @RequestBody InvoiceForm invoiceForm) {
    	
    	      System.out.println("Inside Post methord"+invoiceForm.getInvoiceItemList().length); 
    	      
    	      System.out.println("Inside Post methord"+invoiceForm.getGrandTotals().getGrandTotal()); 
    	      
    	      
    	      try {
    	    	  invoicePdfCreater.createPdf(invoiceForm);
    	    	  System.out.println("After create Pdf Call");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	      	      
    	    /*  JSONObject jsonObj = new JSONObject( );
    	        System.out.println( jsonObj );*/
    	      
    	      JSONObject obj = new JSONObject();

    	      obj.put("Sender Name", invoiceForm.getSender().getSenderName());
    	      obj.put("TaxType", invoiceForm.getTaxType());
    	      obj.put("balance", new Double(1000.21));
    	      obj.put("is_vip", new Boolean(true));
    	
    	
    	  return obj;
				
    }
    
    
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="/downloadpdf", method=RequestMethod.GET)
    public ResponseEntity<byte[]> getPDF() throws IOException {
        // convert JSON to Employee 
       /* Employee emp = convertSomehow(json);*/

        // generate the file
    	Path pdfPath = Paths.get("src/main/resources/results/Invoice.pdf");
    	byte[] contents = Files.readAllBytes(pdfPath);
    	
    	 System.out.println("Pdf Path"+pdfPath);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        String filename = "Invoice.pdf";
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
        return response;
    }

    
}
