package avscience.pc;
import java.io.Serializable;
import avscience.ppc.User;
import avscience.util.*;
import avscience.wba.*;
public class Location extends AvScienceDataObject implements java.io.Serializable
{
    private String name = "";
    private String state = "";
    private String range = "";
    private String lat = "";
    private String longitude = "";
    private String elv = "";
    private String ID = "";
    private String ew = "W";
    private String ns = "N";
    
    
    public void setAttributes()
    {
     	attributes.put("ew", ew);
     	attributes.put("ns", ns);
     	attributes.put("name", name);
     	attributes.put("state", state);
     	attributes.put("range", range);
     	attributes.put("lat", lat);
     	attributes.put("longitude", longitude);
     	attributes.put("elv", elv);
     	attributes.put("ID", ID);
     
    }
    
  /*  void cleanAtts()
    {
    	Enumeration e = attributes.elements();
    	while ( e.hasMoreElements())
    	{
    		Object o = e.nextElement();
    		if ( o instanceof String )
    		{
    			String s = (String) o;
    			s = cleanString(s);
    		}
    	}
    }
    
    public  String cleanString(String s)
    {
    	//System.out.println("cleanString");
    	java.util.Vector goodChars = new java.util.Vector();
    	char[] chars = s.toCharArray();
    	int els=0;
    	for ( int i = 0; i < chars.length; i++ )
    	{
    		int cc = (int) chars[i];
    		if (cc==0) System.out.println("removing char.");
    		if ( cc > 0 )
    		{
    			goodChars.add(els, new Character(chars[i]));
    			els++;
    		}
    	}
    	
    	char[] res = new char[els];
    	java.util.Enumeration e = goodChars.elements();
    	int idx=0;
    	while ( e.hasMoreElements() )
    	{
    		Character C = (Character) e.nextElement();
    		res[idx] = C.charValue();
    		idx++;
    	}
    	String result = new String(res);
    	return result;
    }*/
    
    public Location()
    {
    	super();
    	//cleanAtts();
    }
    
    public Location(User user)
    {
    	this();
        ew = user.getLongType();
        ns = user.getLatType();
    }
    
    public Location(String data)
    {
    	this();
    	popFromString(data);
    }
    
    public Location(User user, String name, String state, String range, String lat, String longitude, String elv, String id)
    {
         this.name = name;
         this.state = state;
         this.range = range;
         this.lat = lat;
         this.longitude = longitude;
         this.elv = elv;
         this.ID = id;
         ew = user.getLongType();
         ns = user.getLatType();
    }
    
    
    public void getAttributes()
    {
    	//cleanAtts();
    	ew = (String) attributes.get("ew");
    	ns = (String) attributes.get("ns");
    	name = (String) attributes.get("name");
    	state = (String) attributes.get("state");
    	lat = (String) attributes.get("lat");
    	longitude = (String) attributes.get("longitude");
    	elv = (String) attributes.get("elv");
    	range = (String) attributes.get("range");
    	ID = (String) attributes.get("ID");
    }
    
    public String getLocName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setElv(String elv)
    {
        this.elv=elv;
    }
    
    public void setRange(String range)
    {
        this.range = range;
    }
    
    public void setState(String state)
    {
        this.state = state;
    }
    
    public void setLat(String lat)
    {
        this.lat = lat;
    }
    
    public void setLongitude(String longitude)
    {
        this.longitude = longitude;
    }
    
    public void setID(String id)
    {
    	ID=id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getState()
    {
        return state;
    }
    
    public String getLat()
    {
        return lat;
    }
    
    public String getLongitude()
    {
        return longitude;
    }
    
    public String getElv()
    {
        return elv;
    }
    
    public String getRange()
    {
        return range;
    }
    
    public String getLongType()
    { 
    	return ew;
    }
    
    public String getLatType()
    { 
    	return ns;
    }
    
    public String getID()
    {
    	return ID;
    }
    
    public String toString()
    {
    	StringBuffer buffer = new StringBuffer();
    	buffer.append(name);
    	buffer.append(", State/Prov: " + state);
    	buffer.append(", Range: " + range);
    	buffer.append(", Lat N: " + lat);
    	buffer.append(", Long. W: " + longitude);
    	buffer.append(", Elevation: " + elv + " ");
    	return buffer.toString();
    }
    
    public String getKey()
    {
        return new String("4");
    }
}