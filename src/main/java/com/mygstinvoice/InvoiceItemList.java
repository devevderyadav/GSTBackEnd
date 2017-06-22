package com.mygstinvoice;

                 
public class InvoiceItemList
{
    private String serialNo;

    private String taxRate;

    private String descriptionOfGood;

    private String ratePerItem;

    private String quantity;

    private String hsn;

    private String discount;

    public String getSerialNo ()
    {
        return serialNo;
    }

    public void setSerialNo (String serialNo)
    {
        this.serialNo = serialNo;
    }

    public String getTaxRate ()
    {
        return taxRate;
    }

    public void setTaxRate (String taxRate)
    {
        this.taxRate = taxRate;
    }

    public String getDescriptionOfGood ()
    {
        return descriptionOfGood;
    }

    public void setDescriptionOfGood (String descriptionOfGood)
    {
        this.descriptionOfGood = descriptionOfGood;
    }

    public String getRatePerItem ()
    {
        return ratePerItem;
    }

    public void setRatePerItem (String ratePerItem)
    {
        this.ratePerItem = ratePerItem;
    }

    public String getQuantity ()
    {
        return quantity;
    }

    public void setQuantity (String quantity)
    {
        this.quantity = quantity;
    }

    public String getHsn ()
    {
        return hsn;
    }

    public void setHsn (String hsn)
    {
        this.hsn = hsn;
    }

    public String getDiscount ()
    {
        return discount;
    }

    public void setDiscount (String discount)
    {
        this.discount = discount;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [serialNo = "+serialNo+", taxRate = "+taxRate+", descriptionOfGood = "+descriptionOfGood+", ratePerItem = "+ratePerItem+", quantity = "+quantity+", hsn = "+hsn+", discount = "+discount+"]";
    }
}
			
			