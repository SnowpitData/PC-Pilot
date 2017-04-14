package avscience.ppc;

import java.util.*;
import java.io.*;
import avscience.wba.DensityProfile;
import avscience.wba.TempProfile;
import org.jdom.*;
import org.jdom.output.*;
import avscience.pc.Sorter;

public class XMLWriter 
{
    File file = new File("PitObs.xml");
    public XMLWriter(){}
    public XMLWriter(File file) 
    {
    	this.file = file;
    }
    
    public String getXMLString(avscience.ppc.AvScienceDataObject obj)
    {
        if ( obj instanceof PitObs )
        {
            PitObs pit = (PitObs) obj;
            Sorter.sortPit(pit);
        }
	Element e = getElementFromObject(obj);
	Document doc = new Document(e);
        XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
	try
	{
            return outputter.outputString(doc);
	}
	catch(Exception ex)
	{
            System.out.println(ex.toString());
	}
        return null;
    }
    
    public void writeToXML(avscience.ppc.AvScienceDataObject obj)
  	{
                if ( obj instanceof PitObs )
                {
                    PitObs pit = (PitObs) obj;
                    Sorter.sortPit(pit);
                }
		Element e = getElementFromObject(obj);
		Document doc = new Document(e);
		XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
		try
		{
                    outputter.output(doc, new FileOutputStream(file));
		}
		catch(Exception ex)
		{
                    System.out.println(ex.toString());
		}
  	}
    
        public char[] getXML(avscience.ppc.PitObs pit)
        {
            CharArrayWriter cwriter = new CharArrayWriter(8400);
            
            Sorter.sortPit(pit);
  		
            System.out.println("writePitToXML");
	    Element e = getElementFromObject(pit);
	    Document doc = new Document(e);
	    XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
		try
		{
			outputter.output(doc, cwriter);
                        return cwriter.toCharArray();
		}
		catch(Exception ex)
		{
			System.out.println(ex.toString());
		}
                return null;
        }
  	
  	Element addProfileFromTable(Hashtable table, Element el)
  	{
  		Enumeration e = table.keys();
  		StringBuffer buffer = new StringBuffer();
  		while (e.hasMoreElements())
  		{
  			Object o = e.nextElement();
  			buffer.append(o);
  			buffer.append("_");
  			Object oo = table.get(o);
  			buffer.append(oo);
  			buffer.append(";");
  			
  		}
  		String s = buffer.toString();
  		String ss = s.substring(0, s.length()-1);
  		Attribute a = new Attribute("profile", ss);
  		el.setAttribute(a);
  		return el;
  	}
        
        public Document getDocumentFromPit(PitObs pit)
        {
            Sorter.sortPit(pit);
            Element e = getElementFromObject(pit);
            Document doc = new Document(e);
            return doc;
        }
  	
  	public Element getElementFromObject(avscience.ppc.AvScienceDataObject oo)
	{
		System.out.println("getElementFromObject");
		oo.writeAttributes();
		Element e = null;
		if ( oo instanceof PitObs )
		{
                        e = new Element("PitObs");
			PitObs pit = (PitObs) oo;
			Attribute a = new Attribute("activities", pit.getActivitiesString());
			e.setAttribute(a);
		}
		
		if ( oo instanceof TempProfile )
		{
                        e = new Element("TempProfile");
			TempProfile tp = (TempProfile) oo;
			if (tp.hasPoints())
			{
				Attribute a = new Attribute("tempUnits", tp.getTempUnits());
				e.setAttribute(a);
				Attribute aa = new Attribute("depthUnits", tp.getDepthUnits());
				e.setAttribute(aa);
				Hashtable table = tp.getProfile();
				addProfileFromTable(table, e);
			}
			return e;
		}
		////////////
		if ( oo instanceof DensityProfile )
		{
                        e = new Element("DensityProfile");
			DensityProfile dp = (DensityProfile) oo;
			if (dp.hasPoints())
			{
				Attribute a = new Attribute("rhoUnits", dp.getDensityUnits());
				e.setAttribute(a);
				Attribute aa = new Attribute("depthUnits", dp.getDepthUnits());
				e.setAttribute(aa);
				addProfileFromTable(dp.getProfile(), e);
			}
			return e;
		}
		
		Iterator<String> en = oo.keys();
		while ( en.hasNext())
		{
			String att = en.next();
			System.out.println("att: "+att);
                        Object o = null;
                        
                        try
                        {
                            o = oo.get(att);
                        }
                        catch(Exception ee)
                        {
                            System.out.println(ee.toString());
                        }
			
			
			if (o instanceof String)
			{
				Attribute a = new Attribute(att.toString(), o.toString());
				e.setAttribute(a);
			}
			
			if  (o instanceof avscience.ppc.AvScienceDataObject)
			{
				Element ell = getElementFromObject((avscience.ppc.AvScienceDataObject)o);
				e.addContent(ell);
			}
			
			if ( o instanceof java.util.Vector )
			{
				java.util.Vector v = (java.util.Vector) o;
				Iterator it = v.iterator();
				while (it.hasNext())
				{
					avscience.ppc.AvScienceDataObject ooo = (avscience.ppc.AvScienceDataObject) it.next();
					{
						Element elll = getElementFromObject(ooo);
						e.addContent(elll);
					}
				}
				
			}
			
				
		}
		return e;
	}
	

  	
}