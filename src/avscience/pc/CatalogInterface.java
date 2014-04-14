package avscience.pc;

import waba.io.*;
import java.util.*;
import avscience.wba.*;
import avscience.pc.PitObs;
import avscience.desktop.*;
import java.io.*;
import avscience.ppc.*;

public class CatalogInterface
{
    private Catalog userCat;
    private Catalog locCat;
    private Catalog pitCat;
    private Catalog occCat;
    private ResizeStream rs;
    private waba.io.DataStream ds; 
    private ResizeStream rsLoc;
    private waba.io.DataStream dsLoc; 
    private ResizeStream rsPit;
    private waba.io.DataStream dsPit; 
    private ResizeStream rsOcc;
    private waba.io.DataStream dsOcc; 
    private Hashtable userTable = new Hashtable();
    private Hashtable locTable = new Hashtable();
    private Hashtable pitTable = new Hashtable();
    private Hashtable occTable = new Hashtable();
    java.io.File pitCatFile;
    String pitCatName = "PitCatalog.PDB";
    long pitCatDate;
       
    java.io.File occCatFile;
    String occCatName = "OccCatalog.PDB";
    long occCatDate;
       
    java.io.File userCatFile;
    String userCatName = "UserCatalog.PDB";
    long userCatDate;
       
    java.io.File locCatFile;
    String locCatName = "LocCatalog.PDB";
    long locCatDate;
    
    private static final CatalogInterface instance  = new CatalogInterface();
    Logger logger = Logger.getInstance();
    public static CatalogInterface getInstance()
    {
        return instance;
    }

    private CatalogInterface()
    {
       init();
    }
    
    String id;
    
    public boolean hasUsers()
    {
        return ( userCat.getRecordCount() > 0 );
    }
    
    void init()
    {
    	logger.println("CatalogInterface: init()");
        id = "SNWP";
        userCat = new Catalog("UserCatalog." + id + ".DATA", Catalog.READ_ONLY);
        locCat = new Catalog("LocCatalog." + id + ".DATA", Catalog.READ_ONLY);
        pitCat = new Catalog("PitCatalog." + id + ".DATA", Catalog.READ_ONLY);
        occCat = new Catalog("OccCatalog." + id + ".DATA", Catalog.READ_ONLY);
        
        rs = new ResizeStream(userCat, 512); 
        ds = new waba.io.DataStream(rs);
        
        rsLoc = new ResizeStream(locCat, 512); 
        dsLoc = new waba.io.DataStream(rsLoc);
        
        rsPit = new ResizeStream(pitCat, 1024); 
        dsPit = new waba.io.DataStream(rsPit);
        
        rsOcc = new ResizeStream(occCat, 1024); 
        dsOcc = new waba.io.DataStream(rsOcc);
        logger.println("building tables: ");
        
        try
        {
        	buildUserTable();
        }
        catch(Exception e){logger.println(e.toString());}
        try
        {
        	buildLocTable();
    	}
    	catch(Exception e){logger.println(e.toString());}
    	try
    	{
        	buildPitTable();
        }
        catch(Exception e){logger.println(e.toString());}
        try
        {
        	buildOccTable();
    	}
    	catch(Exception e){logger.println(e.toString());}
    	
    }
    
    /*public void updatePitLayers(avscience.ppc.PitObs pit)
	{
		System.out.println("updatePitLayers()");
		if (pit==null)
		{
			System.out.println("Pit is null.");
			return;
		}
		avscience.ppc.User u = pit.getUser();
		boolean fromTop = false;
		if ( u.getMeasureFrom().equals("top")) fromTop = true;
		else fromTop = false;
		System.out.println("User fromtop : "+u.getMeasureFrom()+" bool fromTop: "+fromTop);
		java.util.Enumeration layers = pit.getLayers();
		while ( layers.hasMoreElements() )
		{
			Object o = layers.nextElement();
			if (o!=null)
			{
				String lstring = o.toString();
				if ( lstring!=null )
				{
					avscience.ppc.Layer l = pit.getLayer(lstring);
					if (l!=null)
					{
						l.setFromTop(true);
						pit.updateCurrentEditLayer(l);
					}
						
				}
			}
				
		}
	}*/
    
    
    public avscience.ppc.User getUser(String name)
    {
        avscience.ppc.User u = new avscience.ppc.User();
        Integer I = (Integer) userTable.get(name);
        if ( I!= null)
        {
            int i = I.intValue();
            if (userCat.setRecordPos(i))
            {
                String s = ds.readString();
                u = new avscience.ppc.User(s);
            }
        }
        return u;
    }
    
    public avscience.wba.Location getLocation(String name)
    {
        avscience.wba.Location l = new avscience.wba.Location();
        Integer I = (Integer) locTable.get(name);
        if ( I!= null)
        {
            int i = I.intValue();
            if (locCat.setRecordPos(i))
            {
                String s = dsLoc.readString();
                l = new avscience.wba.Location(s);
            }
        }
        return l;
    }
    
    public avscience.ppc.PitObs getPit(String serial)
    {
       return (avscience.ppc.PitObs) pitTable.get(serial);      
    }
    
    public avscience.ppc.AvOccurence getOccurence(String serial)
    {
       if (( serial!=null) && ( serial.trim().length()>0))
       {
       		return (avscience.ppc.AvOccurence) occTable.get(serial); 
       }
       else return null;
    }
    
    public String[] getUserList()
    {
        if ( userTable.size() < 1 ) return new String[0];
        String[] users = new String[userTable.size()];
        int i = 0;
        Enumeration e = userTable.keys();
        while ( e.hasMoreElements() )
        {
            String name = (String) e.nextElement();
            users[i] = name;
            i++;
        }
        return users;
    }
    
    public String[] getLocList()
    {
        String[] locs = new String[locTable.size()];
        int i = 0;
        Enumeration e = locTable.keys();
        while ( e.hasMoreElements() )
        {
            String name = (String) e.nextElement();
            locs[i] = name;
            i++;
        }
        return locs;
    }
    
    public String[] getPitList()
    {
        String[] pits = new String[pitTable.size()];
        int i = 0;
        Enumeration e = pitTable.keys();
        while ( e.hasMoreElements() )
        {
            String serial = (String) e.nextElement();
            pits[i] = serial;
            i++;
        }
        return pits;
    }
    
    public String[] getOccList()
    {
        String[] occs = new String[occTable.size()];
        int i = 0;
        Enumeration e = occTable.keys();
        while ( e.hasMoreElements() )
        {
            String serial = (String) e.nextElement();
            occs[i] = serial;
            i++;
        }
        return occs;
    }
    
    private void buildUserTable()
    {
    	logger.println("buildUserTable()");
        if ( (userCat!=null) && (userCat.isOpen()) )
        {
            
            for (int i = 0; i < userCat.getRecordCount(); i++)
            if (userCat.setRecordPos(i))
            {
                String s = ds.readString();
                avscience.ppc.User u = new avscience.ppc.User(s);
                Integer I = new Integer(i);
                String name = u.getName();
                userTable.put(name.trim(), I);
            }
        }
        else logger.println("Can't open usercat.");
    }
    
    private void buildLocTable()
    {
    	logger.println("buildLocTable()");
        if ( (locCat!=null) && (locCat.isOpen()) )
        {
            for (int i = 0; i < locCat.getRecordCount(); i++)
            if (locCat.setRecordPos(i))
            {
                String s = dsLoc.readString();
                Location l = new Location(s);
                Integer I = new Integer(i);
                String name = l.getName();
                locTable.put(name, I);
            }
        }
        else logger.println("Can't open loccation catalog.");
    }
    
    private void buildPitTable()
    {
    	logger.println("buildPitTable()");
    	if ( pitCat==null )logger.println("pitCat null.");
    	else if (!pitCat.isOpen()) logger.println("pitCat not open.");
        if ( (pitCat!=null) && (pitCat.isOpen()) )
        {
        	logger.println("pitCat is open:");
        	logger.println("# pit cat records: "+pitCat.getRecordCount());
            for (int i = 0; i < pitCat.getRecordCount(); i++)
            if (pitCat.setRecordPos(i))
            {
                String s = dsPit.readString();
                s = cleanString(s);
                avscience.ppc.PitObs ppit = new avscience.ppc.PitObs(s);
                if ( ppit==null ) logger.println("ppit is NULL.");
                else
                {
              ///  	updatePitLayers(ppit);
                    String name = ppit.getName();
                    String serial = ppit.getSerial();
                    logger.println("Pit::: "+name);
                	pitTable.put(serial, ppit);
                }
            }
        }
        else logger.println("Can't open pitcat.");
    }
    
    public  String cleanString(String s)
    {
    	java.util.Vector goodChars = new java.util.Vector();
    	char[] chars = s.toCharArray();
    	int els=0;
    	for ( int i = 0; i < chars.length; i++ )
    	{
    		int cc = (int) chars[i];
    		if ( cc >= 0 )
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
    //	System.out.println("Clean String: "+result);
    	return result;
    }
    
    private void buildOccTable()
    {
    	logger.println("buildOccTable()");
    	if ( occCat==null) logger.println("OccCat null.");
    	if ( occCat!=null )
    	{
    		if (!occCat.isOpen()) logger.println("Occ cat not open.");
    	}
        if ( (occCat!=null) && (occCat.isOpen()) )
        {
        	logger.println("# Occ records: "+occCat.getRecordCount());
            for (int i = 0; i < occCat.getRecordCount(); i++)
            if (occCat.setRecordPos(i))
            {
                String s = dsOcc.readString();
                avscience.ppc.AvOccurence occ = new avscience.ppc.AvOccurence(s);
               // occ = new CharacterCleaner().cleanStrings(occ);
                //Integer I = new Integer(i);
                String name = occ.getPitName();
                logger.println("Occ Name: "+name);
                String serial = occ.getSerial();
                logger.println("Occ serial: "+serial);
                occTable.put(serial, occ);
            }
        }
        else logger.println("Can't open occcat.");
    }
    
    public void close()
    {
    	pitCat.close();
        occCat.close();
        userCat.close();
        locCat.close();
        
    }
    
    void getCurrentPitCat()
    {
        logger.println("getCurrentPitCat()");
        java.io.File working = new java.io.File("./");
        java.io.File[] files = working.listFiles();
        if (working.isDirectory()) findCurrentPitCat(working);
        for (int i=0; i<files.length; i++ )
        {
        	java.io.File f = files[i];
        	if ( f.isDirectory() ) findCurrentPitCat(f);
        }
        
        
        java.io.File cat = new java.io.File(pitCatName);
        if (( cat!=null)&&(pitCat!=null)) pitCatFile.renameTo(cat);
    }
    
    void getCurrentOccCat()
    {
    	logger.println("getCurrentOccCat()");
        java.io.File working = new java.io.File("./");
        java.io.File[] files = working.listFiles();
        if (working.isDirectory()) findCurrentOccCat(working);
        for (int i=0; i<files.length; i++ )
        {
        	java.io.File f = files[i];
        	if ( f.isDirectory() ) findCurrentOccCat(f);
        }
        
        java.io.File cat = new java.io.File(occCatName);
        if (( cat!=null)&&(occCat!=null)) occCatFile.renameTo(cat);
    }
    
    private void findCurrentPitCat(java.io.File dir)
    {
       java.io.File[] files = dir.listFiles();
        
        for (int i=0; i<files.length; i++ )
        {
            java.io.File f = files[i];
            if (f.isFile())
            {
                if (f.getName().equals(pitCatName))
                {
                	logger.println("Found pit cat:");
                    if ( f.lastModified() > pitCatDate)
                    {
                    	logger.println("Most recent pit cat: " + f.getAbsolutePath());
                        pitCatDate = f.lastModified();
                        pitCatFile=f;
                    }
                }
            }
            if ( f.isDirectory() )
            {
                findCurrentPitCat(f);
            }
        } 
    }
    
    void getCurrentUserCat()
    {
        java.io.File working = new java.io.File("./");
        java.io.File[] files = working.listFiles();
        if (working.isDirectory()) findCurrentUserCat(working);
        for (int i=0; i<files.length; i++ )
        {
        	java.io.File f = files[i];
        	if ( f.isDirectory() ) findCurrentUserCat(f);
        }
        
        java.io.File cat = new java.io.File(userCatName);
        if (( cat!=null)&&(userCat!=null)) userCatFile.renameTo(cat);
    }
    
    void getCurrentLocCat()
    {
    	logger.println("getCurrentLocCat()");
        java.io.File working = new java.io.File("./");
        java.io.File[] files = working.listFiles();
        if (working.isDirectory()) findCurrentLocCat(working);
        for (int i=0; i<files.length; i++ )
        {
        	java.io.File f = files[i];
        	if ( f.isDirectory() ) findCurrentLocCat(f);
        }
        
        java.io.File cat = new java.io.File(locCatName);
        if (( cat!=null)&&(locCat!=null)) locCatFile.renameTo(cat);
    }
    
    private void findCurrentOccCat(java.io.File dir)
    {
       java.io.File[] files = dir.listFiles();
        
        for (int i=0; i<files.length; i++ )
        {
            java.io.File f = files[i];
            if (f.isFile())
            {
                if (f.getName().equals(occCatName))
                {
                	logger.println("Found occ cat:");
                    if ( f.lastModified() > occCatDate)
                    {
                    	logger.println("Most recent occ cat: " + f.getAbsolutePath());
                        occCatDate = f.lastModified();
                        occCatFile=f;
                    }
                }
            }
            if ( f.isDirectory() )
            {
                findCurrentOccCat(f);
            }
        } 
    }
    
    private void findCurrentUserCat(java.io.File dir)
    {
       java.io.File[] files = dir.listFiles();
        
        for (int i=0; i<files.length; i++ )
        {
            java.io.File f = files[i];
            if (f.isFile())
            {
                if (f.getName().equals(userCatName))
                {
                    if ( f.lastModified() > userCatDate)
                    {
                    	logger.println("Most recent user cat: " + f.getAbsolutePath());
                        userCatDate = f.lastModified();
                        userCatFile=f;
                    }
                }
            }
            if ( f.isDirectory() )
            {
                findCurrentUserCat(f);
            }
        } 
    }
    
    private void findCurrentLocCat(java.io.File dir)
    {
       java.io.File[] files = dir.listFiles();
        
        for (int i=0; i<files.length; i++ )
        {
            java.io.File f = files[i];
            if (f.isFile())
            {
                if (f.getName().equals(locCatName))
                {
                    if ( f.lastModified() > locCatDate)
                    {
                        locCatDate = f.lastModified();
                        locCatFile=f;
                    }
                }
            }
            if ( f.isDirectory() )
            {
                findCurrentLocCat(f);
            }
        } 
    }
  
}