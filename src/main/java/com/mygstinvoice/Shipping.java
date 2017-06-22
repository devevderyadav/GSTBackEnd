package com.mygstinvoice;


public class Shipping
{
private String shippingZip;

private String shippingStreet;

private String shippingState;

private String shippingUniqueID;

private String shippingStateCode;

private String shippingCity;

private String shippingName;

public String getShippingZip ()
{
return shippingZip;
}

public void setShippingZip (String shippingZip)
{
this.shippingZip = shippingZip;
}

public String getShippingStreet ()
{
return shippingStreet;
}

public void setShippingStreet (String shippingStreet)
{
this.shippingStreet = shippingStreet;
}

public String getShippingState ()
{
return shippingState;
}

public void setShippingState (String shippingState)
{
this.shippingState = shippingState;
}

public String getShippingUniqueID ()
{
return shippingUniqueID;
}

public void setShippingUniqueID (String shippingUniqueID)
{
this.shippingUniqueID = shippingUniqueID;
}

public String getShippingStateCode ()
{
return shippingStateCode;
}

public void setShippingStateCode (String shippingStateCode)
{
this.shippingStateCode = shippingStateCode;
}

public String getShippingCity ()
{
return shippingCity;
}

public void setShippingCity (String shippingCity)
{
this.shippingCity = shippingCity;
}

public String getShippingName ()
{
return shippingName;
}

public void setShippingName (String shippingName)
{
this.shippingName = shippingName;
}

@Override
public String toString()
{
return "ClassPojo [shippingZip = "+shippingZip+", shippingStreet = "+shippingStreet+", shippingState = "+shippingState+", shippingUniqueID = "+shippingUniqueID+", shippingStateCode = "+shippingStateCode+", shippingCity = "+shippingCity+", shippingName = "+shippingName+"]";
}
}

