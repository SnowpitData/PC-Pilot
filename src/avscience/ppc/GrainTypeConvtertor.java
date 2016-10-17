
 
package avscience.ppc;

import java.util.*;

public class GrainTypeConvtertor 
{
	Hashtable<String, String> types = new Hashtable<String, String>();
	Hashtable<String, String> lwc = new Hashtable<String, String>();
        
    public GrainTypeConvtertor() 
    {
    	types.put("Precipitation particles", "PP");
        types.put("Graupel", "PPgp");
  	types.put("Columns", "PPco");
  	types.put("Needles", "PPnd");
  	types.put("Stellars, Dendrites", "PPsd");
  	types.put("Irregular crystals", "PPir");
  	types.put("Hail", "PPhl");
  	types.put("Ice pellets", "PPip`");
        types.put("Rime", "PPrm");
        
        
    	types.put("Decomposing fragmented particles","DFdc");
    	types.put("Highly broken particles", "DFbk");
        types.put("Decomposing & fragmented precip. particles", "DF");
  	types.put("Partly decomposed precipitation particles", "DFdc");
  	types.put("Wind-broken precipitation particles", "DFbk");
        
    	types.put("Rounded grains", "RG");
    	types.put("Mixed forms rounded","RGmx");
  	types.put("Small rounded particles", "RGsr" );
        types.put("Large rounded particles", "RGlr");
  	types.put("Wind packed", "RGwp");
    	types.put("Faceted rounded particles", "RGxf");
        
    	types.put("Faceted crystals", "FCfa");
        types.put("Faceted Crystals", "FCfa");
    	types.put("Small faceted cystals", "FCsf");
    	types.put("Mixed forms faceted", "FCmx");
        
  	types.put("Solid faceted particles", "FCso");
    	types.put("Near surface faceted particles","FCsf" );
    	types.put("Rounding faceted particles","FCxr" );
        
        
    	types.put("Cup-shaped crystals/depth hoar", "DHcp");
    	types.put("Columns of depth hoar", "DHdh");
        
        types.put("Depth hoar", "DH");
        types.put("Hollow cups", "DHcp");
  	types.put("Hollow prisms", "DHpr");
    	types.put("Chains of depth hoar", "DHch");
    	types.put("Large striated crystals", "DHla");
    	types.put("Rounding depth hoar", "DHxr");
        
    	types.put("Wet Grains", "WG");
    	types.put("Clustered rounded grains", "WGcl");
    	types.put("Rounded poly-crystals", "WGmf");
    	types.put("Slush", "WGsl");
        
    	types.put("Surface hoar", "SHsh");
        types.put("Surface hoar crystals", "SHsu");
  	types.put("Cavity or crevasse hoar", "SHcv");
  	types.put("Rounding surface hoar", "SHxr");
        
    	types.put("Ice layer", "IMil");
        
        types.put("Melt forms", "MF");
        types.put("Clustered rounded grains", "MFcl");
    	types.put("Rounded polycrystals", "MFpc");
    	types.put("Slush", "MFsl");
    	types.put("Melt-freeze crust", "MFcr");
        
        types.put("Ice formations", "IF");
        types.put("Ice layer", "IFil");
  	types.put("Ice column", "IFic");
  	types.put("Basal ice", "IFbi");
    	types.put("Rain crust", "IFrc");
    	types.put("Sun crust", "IFsc");
        
        
    	types.put("Surface deposits and crusts", "CR");
    	types.put("Rime", "CRrm");
    	types.put("Rain crust", "CRrc");
    	types.put("Sun crust", "CRsc");
    	types.put("Wind crust", "CRwc");
    	types.put("Melt-freeze crust", "CRmfc");
        
        types.put("Round polycrystalline particles", "MMrp");
        types.put("Crushed ice particles", "MMci");
    	
    	lwc.put("Dry", "D");
    	lwc.put("Moist", "M");
    	lwc.put("Wet", "W");
    	lwc.put("Very Wet", "U");
        
    }
    
    public String getCAAMLType(String grainType)
    {
    	grainType=grainType.trim();
    	return types.get(grainType);
    }
    
    public String getLWC(String splwc)
    {
    	String s = lwc.get(splwc);
    	if (s==null) s="unknown";
    	return s;
    }
}