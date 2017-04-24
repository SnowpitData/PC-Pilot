package avscience.ppc;

import java.util.*;
import java.io.*;
import avscience.wba.DensityProfile;
import avscience.wba.TempProfile;
import org.jdom.*;
import org.jdom.output.*;

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
            
	    Document doc = getDocumentFromPit(pit);
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
            Element e = new Element("PitObs");
            Iterator en = pit.keys();
  
            while ( en.hasNext())
            {
                try
                {
                    Object o = pit.get(en.next().toString());
                    if ( o instanceof String )
                    {
                        String s = o.toString();
                        String att = pit.getString(s);
                        Attribute a = new Attribute(s, att);
                        e.setAttribute(a);
                        
                    }
                }
                catch(Exception ex)
                {
                    System.out.println(ex.toString());
                }
            }
            
            Location l = pit.getLocation();
            Element eloc =  getElementFromObject(l);
            e.addContent(eloc);
            
            User u = pit.getUser();
            Element eu = getElementFromObject(u);
            e.addContent(eu);
            
            Enumeration layers = pit.getLayers();
            
            while (layers.hasMoreElements())
            {
                Layer layer = (Layer) layers.nextElement();
                Element elayer = getElementFromObject(layer);
                e.addContent(elayer);
            }
            
            Enumeration tests = pit.getShearTests();
            
            while (tests.hasMoreElements())
            {
                ShearTestResult test = (ShearTestResult) layers.nextElement();
                Element etest = getElementFromObject(test);
                e.addContent(etest);
            }
            
            Element rhoPro = new Element("DensityProfile");
            
            DensityProfile rhop = pit.getDensityProfile();
            rhop.writeAttributes();
            Attribute rhou = new Attribute("densityUnits", rhop.getDensityUnits());
            rhoPro.setAttribute(rhou);
            Attribute du = new Attribute("depthUnits", rhop.getDepthUnits());
            rhoPro.setAttribute(du);
            try
            {
                Attribute pdata = new Attribute("profile_data", (String) rhop.get("profile_data"));
                rhoPro.setAttribute(pdata);
            }
            catch(Exception ee)
            {
                System.out.println(ee.toString());
            }
            e.addContent(rhoPro);
            
            /////////////
            
            Element tPro = new Element("TempProfile");
            
            TempProfile tp = pit.getTempProfile();
            tp.writeAttributes();
            Attribute tu = new Attribute("tempUnits", tp.getTempUnits());
            tPro.setAttribute(tu);
            Attribute tdu = new Attribute("depthUnits", tp.getDepthUnits());
            tPro.setAttribute(tdu);
            try
            {
                Attribute pdata = new Attribute("profile_data", (String) tp.get("profile_data"));
                tPro.setAttribute(pdata);
            }
            catch(Exception ee)
            {
                System.out.println(ee.toString());
            }
            e.addContent(tPro);
            
            Document doc = new Document(e);
            return doc;
        }
  	
  	public Element getElementFromObject(avscience.ppc.AvScienceDataObject oo)
	{
		System.out.println("getElementFromObject");
		oo.writeAttributes();
		Element e = new Element(oo.getClass().getName());
                
		Iterator en = oo.keys();
		while ( en.hasNext())
		{
                    try
                    {
                        String att = en.next().toString();
                        System.out.println("att: "+att);
                        Attribute a = new Attribute(att, oo.getString(att));
                        e.setAttribute(a);
                    }
                    catch(Exception ex)
                    {
                        System.out.println(ex.toString());
                    }
			
		}
		return e;
	}
}