package com.mygstinvoice;
             
public class Sender
{
    private String senderName;

    private String senderGSTIN;

    private String senderZip;

    private String senderCity;

    private String serialNoOfInvoice;

    private String dateOfInvoice;

    private String senderStreet;

    private String senderState;

    public String getSenderName ()
    {
        return senderName;
    }

    public void setSenderName (String senderName)
    {
        this.senderName = senderName;
    }

    public String getSenderGSTIN ()
    {
        return senderGSTIN;
    }

    public void setSenderGSTIN (String senderGSTIN)
    {
        this.senderGSTIN = senderGSTIN;
    }

    public String getSenderZip ()
    {
        return senderZip;
    }

    public void setSenderZip (String senderZip)
    {
        this.senderZip = senderZip;
    }

    public String getSenderCity ()
    {
        return senderCity;
    }

    public void setSenderCity (String senderCity)
    {
        this.senderCity = senderCity;
    }

    public String getSerialNoOfInvoice ()
    {
        return serialNoOfInvoice;
    }

    public void setSerialNoOfInvoice (String serialNoOfInvoice)
    {
        this.serialNoOfInvoice = serialNoOfInvoice;
    }

    public String getDateOfInvoice ()
    {
        return dateOfInvoice;
    }

    public void setDateOfInvoice (String dateOfInvoice)
    {
        this.dateOfInvoice = dateOfInvoice;
    }

    public String getSenderStreet ()
    {
        return senderStreet;
    }

    public void setSenderStreet (String senderStreet)
    {
        this.senderStreet = senderStreet;
    }

    public String getSenderState ()
    {
        return senderState;
    }

    public void setSenderState (String senderState)
    {
        this.senderState = senderState;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [senderName = "+senderName+", senderGSTIN = "+senderGSTIN+", senderZip = "+senderZip+", senderCity = "+senderCity+", serialNoOfInvoice = "+serialNoOfInvoice+", dateOfInvoice = "+dateOfInvoice+", senderStreet = "+senderStreet+", senderState = "+senderState+"]";
    }
}