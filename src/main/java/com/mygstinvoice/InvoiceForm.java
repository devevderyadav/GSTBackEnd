package com.mygstinvoice;

                 
public class InvoiceForm
{
    private Sender sender;

    private Shipping shipping;

    private Receiver receiver;
    
    private GrandTotals grandTotals;

    private InvoiceItemList[] invoiceItemList;

    private String taxType;

    public Sender getSender ()
    {
        return sender;
    }

    public void setSender (Sender sender)
    {
        this.sender = sender;
    }

    public Shipping getShipping ()
    {
        return shipping;
    }

    public void setShipping (Shipping shipping)
    {
        this.shipping = shipping;
    }

    public Receiver getReceiver ()
    {
        return receiver;
    }

    public void setReceiver (Receiver receiver)
    {
        this.receiver = receiver;
    }

    public InvoiceItemList[] getInvoiceItemList ()
    {
        return invoiceItemList;
    }

    public void setInvoiceItemList (InvoiceItemList[] invoiceItemList)
    {
        this.invoiceItemList = invoiceItemList;
    }

    public String getTaxType ()
    {
        return taxType;
    }

    public void setTaxType (String taxType)
    {
        this.taxType = taxType;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [sender = "+sender+", shipping = "+shipping+", receiver = "+receiver+", invoiceItemList = "+invoiceItemList+", taxType = "+taxType+"]";
    }

	/**
	 * @return the grandTotals
	 */
	public GrandTotals getGrandTotals() {
		return grandTotals;
	}

	/**
	 * @param grandTotals the grandTotals to set
	 */
	public void setGrandTotals(GrandTotals grandTotals) {
		this.grandTotals = grandTotals;
	}
}
			
			