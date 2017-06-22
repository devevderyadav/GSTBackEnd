package com.mygstinvoice;


public class Receiver
{
private String receiverCity;

private String receiverName;

private String receiverUniqueID;

private String receiverZip;

private String receiverStateCode;

private String receiverStreet;

private String receiverState;

public String getReceiverCity ()
{
return receiverCity;
}

public void setReceiverCity (String receiverCity)
{
this.receiverCity = receiverCity;
}

public String getReceiverName ()
{
return receiverName;
}

public void setReceiverName (String receiverName)
{
this.receiverName = receiverName;
}

public String getReceiverUniqueID ()
{
return receiverUniqueID;
}

public void setReceiverUniqueID (String receiverUniqueID)
{
this.receiverUniqueID = receiverUniqueID;
}

public String getReceiverZip ()
{
return receiverZip;
}

public void setReceiverZip (String receiverZip)
{
this.receiverZip = receiverZip;
}

public String getReceiverStateCode ()
{
return receiverStateCode;
}

public void setReceiverStateCode (String receiverStateCode)
{
this.receiverStateCode = receiverStateCode;
}

public String getReceiverStreet ()
{
return receiverStreet;
}

public void setReceiverStreet (String receiverStreet)
{
this.receiverStreet = receiverStreet;
}

public String getReceiverState ()
{
return receiverState;
}

public void setReceiverState (String receiverState)
{
this.receiverState = receiverState;
}

@Override
public String toString()
{
return "ClassPojo [receiverCity = "+receiverCity+", receiverName = "+receiverName+", receiverUniqueID = "+receiverUniqueID+", receiverZip = "+receiverZip+", receiverStateCode = "+receiverStateCode+", receiverStreet = "+receiverStreet+", receiverState = "+receiverState+"]";
}
}

