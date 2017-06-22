package com.mygstinvoice;


public class GrandTotals
{
private String grandTotalWithTax;

private String discountTotal;

private String grandTotal;

private String totalTax;

public String getGrandTotalWithTax ()
{
return grandTotalWithTax;
}

public void setGrandTotalWithTax (String grandTotalWithTax)
{
this.grandTotalWithTax = grandTotalWithTax;
}

public String getDiscountTotal ()
{
return discountTotal;
}

public void setDiscountTotal (String discountTotal)
{
this.discountTotal = discountTotal;
}

public String getGrandTotal ()
{
return grandTotal;
}

public void setGrandTotal (String grandTotal)
{
this.grandTotal = grandTotal;
}

public String getTotalTax ()
{
return totalTax;
}

public void setTotalTax (String totalTax)
{
this.totalTax = totalTax;
}

@Override
public String toString()
{
return "ClassPojo [grandTotalWithTax = "+grandTotalWithTax+", discountTotal = "+discountTotal+", grandTotal = "+grandTotal+", totalTax = "+totalTax+"]";
}
}
