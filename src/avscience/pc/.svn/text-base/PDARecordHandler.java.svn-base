

package avscience.pc;
import java.io.*;
import java.util.*;
import avscience.pc.SPV5DataStore;
import avscience.desktop.Logger;
import avscience.wba.*;
public class PDARecordHandler
{
   File pitCat;
   String pitCatName = "PitCatalog.PDB";
   final static int maxDataLength=4500;
   long pitCatDate;
   
   File occCat;
   String occCatName = "OccCatalog.PDB";

   long occCatDate;
   
   File userCat;
   String userCatName = "UserCatalog.PDB";
   long userCatDate;
   
   File locCat;
   String locCatName = "LocCatalog.PDB";
   long locCatDate;
   avscience.pc.SPV5DataStore store;
   Logger logger = Logger.getInstance();
   
   public PDARecordHandler(avscience.pc.SPV5DataStore store)
   {
   		this.store=store;
   		init();
   }
 
   void init()
   {
   		
   		try
		{
        	getCurrentPitCat();
        }
        catch(Throwable t){logger.println(t.toString());}
        try
        {
        	getCurrentOccCat();
        }
        catch(Throwable t){logger.println(t.toString());}
        try
        {
        	getCurrentUserCat();
        }
        catch(Throwable t){logger.println(t.toString());}
        try
        {
        	getCurrentLocCat();
        }
        catch(Throwable t){logger.println(t.toString());}
        try
        {
			getRecords();
		}
		catch(Throwable t){logger.println(t.toString());}
		try
        {
        	logger.println("deleting pitcat");
			File cat = new File(pitCatName);
	        if (cat!=null) cat.delete();
	        logger.println("deleting occcat");
	        File ocCat = new File(occCatName);
	        if (ocCat!=null) ocCat.delete();
	        
	        File lCat = new File(locCatName);
	        if (lCat!=null) lCat.delete();
	        File uCat = new File(userCatName);
	        if (uCat!=null) uCat.delete();
	     }
	     catch(Throwable t){logger.println(t.toString());}
   }
   
    public String cleanString(String s)
	{
		if ( s.trim().length() < 2 ) return s; 
		
		logger.println("cleanString()");
		try
		{
			char[] chars = s.toCharArray();
			int l = chars.length;
			logger.println("String length: "+l);
	    	for ( int jj = 0; jj < l; jj++ )
	    	{
	    		int idx = jj;
	    		//logger.println("idx: "+idx);
	    		if (( idx < l) && (idx > 0 ))
	    		{
		    		char test =  chars[idx];
		    		if ( test <= 0 )chars[idx]=' ';
		    	}
	    		
	    	}
	    	String tmp="";
	    	tmp = new String(chars);
	    	if ((tmp!=null) && ( tmp.trim().length() > 5 )) s=tmp;
	    }
	    catch(Throwable e){logger.println("cleanString failed: "+e.toString());}
	    return s;
    	
	}
   
	void getRecords()
    {
    	logger.println("getRecords()");
        boolean read=false;
        if ( pitCat==null ) logger.println("pitCat is null.");
        if ( pitCat!=null)
        {
            logger.println("getRecords");
            avscience.pc.CatalogInterface catalog = avscience.pc.CatalogInterface.getInstance();
            String[] list = catalog.getPitList();
            logger.println("getPitList()");
            logger.println("# of pits:: "+list.length);
            if ( list!=null )
            {
	            for ( int i=0; i<list.length; i++ )
	            {
	            	if ( list[i] !=null )
	            	{
		                logger.println(" Pit list name: "+list[i]);
		               
		                StringSerializable ppit = catalog.getPit(list[i]);
		                String data = ppit.dataString();
		                //data = cleanString(data);
		               // logger.println("clean string complete.");
		                avscience.ppc.PitObs pit = new avscience.ppc.PitObs(data);
		                logger.println("pit contructed.");
		                String name = pit.getName();
		                logger.println(" Pit name: "+pit.getName());
		                if (( pit.getSerial() == null ) || ( pit.getSerial().trim().length() < 2))
		                {
			                pit.setSerial(store.getNewSerial());
			                pit.setArchName(name);
			            }
		                convertPit(pit);
		                avscience.ppc.PitObs storePit = store.getPit(list[i]);
		                if (!pit.getCrownObs())
		                {
			                if (storePit==null) 
			                {
			                	store.addPit(pit.dataString());
			                }
			               
			                if (storePit!=null) 
			                {
			                	if (!storePit.getEdited())  store.addPit(pit.dataString());
			                }
			            }	
		               
		                
		                read=true;
		             }
	            }
	         }
	       	
            if ( occCat==null ) logger.println("occCat is null.");
        	list = catalog.getOccList();
        	logger.println("getOccList()");
            logger.println("# of occs:: "+list.length);
        	if ( list!=null )
            {
	            for ( int i=0; i<list.length; i++ )
	            {
	            	if ( list[i] !=null )
	            	{
	            		logger.println("getting occ: "+list[i]);
	            		StringSerializable occ = (StringSerializable) catalog.getOccurence(list[i]);
	            		if ( occ==null ) logger.println("Occ is null.");
	            		else logger.println("OCC: "+occ.toString());
				      	String serial = null;
				    	String name ="";
				    	avscience.ppc.AvOccurence aocc = null;
				    	if ( occ!=null) aocc = new avscience.ppc.AvOccurence(occ.dataString());
				    	if ( aocc==null ) logger.println("Occ is null.");
	            		else logger.println("OCC: "+aocc.toString());
				    	if ( aocc!=null )
				    	{
				    		serial = aocc.getSerial();
				    		name = aocc.getPitName();
				    		logger.println("Serial "+serial+" name: "+name);
				    		if (( serial == null ) || ( serial.trim().length() < 2))
		                	{
		                		serial = store.getNewSerial();
				    			aocc.setSerial(serial);
				    			aocc.setArchName(name);
		                	}
				    	}
				    	
		                logger.println("Getting catalog pit");
		                StringSerializable catPit = catalog.getPit(serial);
		                if ( catPit==null ) logger.println("catpit null.");
		                avscience.ppc.PitObs ppit = null;
		                if ( catPit!=null )
		                {
		                	logger.println("catpit: "+catPit.toString());
				    	 	ppit = new avscience.ppc.PitObs(catPit.dataString());
				    	}
				 		if ( ppit==null ) logger.println("ppit null.");
				    	if ( ppit!=null )
				    	{
					    	if (( ppit.getSerial() == null ) || ( ppit.getSerial().trim().length() < 2))
			                {
			                	logger.println("PPit: "+ppit.toString());
			                	if ( serial == null ) serial = store.getNewSerial();
			                	ppit.setSerial(serial);
			                }
			            }
		               	logger.println("getting store occ.");
		               //avscience.ppc.AvOccurence storeOcc = null;
		                avscience.ppc.AvOccurence storeOcc = store.getOcc(list[i]);
		                if (storeOcc==null) 
		                {
		                	logger.println("store occ null.");
		                	if (ppit!=null)
					    	{
					    		convertPit(ppit);
					    		store.addOcc(occ.dataString());
					        	
					        	ppit.setCrownObs(true);
					        	store.addPit(ppit.dataString());
					        }
		                }
		                if ((storeOcc!=null ) && (!storeOcc.getEdited()) && (ppit!=null) )
		                {
		                	convertPit(ppit);
		                	store.addOcc(occ.dataString());
				     
				        	ppit.setCrownObs(true);
				        	store.addPit(ppit.dataString());
		                }
		               	if ( ppit==null ) logger.println("ppit is NULL.");
		                
		                read=true;
		            }
	            }
	         }
          
	        list = catalog.getUserList();
	        logger.println("getUserList()");
            logger.println("# of users:: "+list.length);
            if ( list!=null )
            {
	            for ( int i=0; i<list.length; i++ )
	            {
	            	if ( list[i]!=null )
	            	{
	            		logger.println(" User: "+list[i]);
		                avscience.wba.User u = catalog.getUser(list[i]);
		                store.removeUser(u.getName());
		                avscience.ppc.User pu = new avscience.ppc.User(u.dataString());
		                store.addUser(pu);
		                read=true;
		            }
	            }
	        }
	        
	        list = catalog.getLocList();
            if ( list!=null )
            {
	            for ( int i=0; i<list.length; i++ )
	            {
	            	if ( list[i]!=null )
	            	{
	            		logger.println(" Loc: "+list[i]);
		                avscience.wba.Location l = catalog.getLocation(list[i]);
		                store.removeLocation(l.getName());
		                store.addLocation(l.dataString());
		                read=true;
		            }
	            }
	        }
	        
            catalog.close();
            
            File cat = new File(pitCatName);
            if (cat!=null) cat.delete();
            File ocCat = new File(occCatName);
            if (ocCat!=null) ocCat.delete();
            
            File lCat = new File(locCatName);
            if (lCat!=null) lCat.delete();
            File uCat = new File(userCatName);
            if (uCat!=null) uCat.delete();
        }
        
        
    }
    
    public avscience.ppc.PitObs convertPit(avscience.ppc.PitObs pit)
  	{
  		logger.println("converPit: "+pit.getName());
  		java.util.Vector nt = new java.util.Vector();
  		java.util.Vector np = new java.util.Vector();
  		java.util.Enumeration e = pit.getShearTests();
  		while ( e.hasMoreElements())
  		{
	  		StringSerializable gtest = (StringSerializable) e.nextElement();
	  		logger.println("GTest: "+gtest.toString());
	  		avscience.ppc.ShearTestResult test = new avscience.ppc.ShearTestResult(gtest.dataString());
	  		nt.add(test);
	    	logger.println("Test: "+test.toString());
	    }
	    pit.shearTests=nt;
	    java.util.Enumeration ee = pit.getLayers();
	    
	    while ( ee.hasMoreElements())
  		{
	  		StringSerializable glayer = (StringSerializable) ee.nextElement();
	  		String ldat = glayer.dataString();
	  		logger.println("cleaning layer string for layer: "+glayer.toString());
	  		ldat = cleanString(ldat);
	  		avscience.ppc.Layer l = new avscience.ppc.Layer(ldat);
	    	np.add(l);
	    }
	    pit.layers=np;
	    StringSerializable genuser = (StringSerializable) pit.getUser();
	    avscience.ppc.User u = new avscience.ppc.User(genuser.dataString());
	    pit.setUser(u);
	    //long time = System.currentTimeMillis();
	    setTimestamp(pit);
	    
	    return pit;
  	}
  	
  	public void setTimestamp(avscience.ppc.PitObs pit)
  	{
  		long ts=0;
  		String dt = pit.getDate();
	    String time = pit.getTime();
	    if ( dt.trim().length()>7 )
	    {
	      	String yr="0";
	      	String mnth="0";
	      	String dy="0";
	      	String hr = "0";
	      	String min = "0";
	      	if (!(dt.trim().length()<8)) 
	      	{
	      		yr = dt.substring(0, 4);
	      		mnth = dt.substring(4, 6);
	      		dy = dt.substring(6, 8);
	      	}
	      	
	      	if ( !(time.trim().length()<4))
	      	{
	      		hr = time.substring(0, 2);
	      		min = time.substring(2, 4);
	      	}
	      	
	      	int y = new Integer(yr).intValue();
	      	int m = new Integer(mnth).intValue()-1;
	      	int d = new Integer(dy).intValue();
	      	int h = new Integer(hr).intValue();
	      	int mn = new Integer(min).intValue();
	      	java.util.Calendar cal = java.util.Calendar.getInstance();
	      	cal.set(y, m, d, h, mn);
	      	ts = cal.getTimeInMillis();
		}
		else ts = System.currentTimeMillis();
		pit.setTimestamp(ts);
  	}
    
    void getCurrentPitCat()
    {
        logger.println("getCurrentPitCat()");
        File working = new File("./");
        File[] files = working.listFiles();
        if (working.isDirectory()) findCurrentPitCat(working);
        for (int i=0; i<files.length; i++ )
        {
        	File f = files[i];
        	if ( f.isDirectory() ) findCurrentPitCat(f);
        }
        
        
        File cat = new File(pitCatName);
        if (( cat!=null)&&(pitCat!=null)) pitCat.renameTo(cat);
    }
    
    void getCurrentOccCat()
    {
    	logger.println("getCurrentOccCat()");
        File working = new File("./");
        File[] files = working.listFiles();
        if (working.isDirectory()) findCurrentOccCat(working);
        for (int i=0; i<files.length; i++ )
        {
        	File f = files[i];
        	if ( f.isDirectory() ) findCurrentOccCat(f);
        }
        
        File cat = new File(occCatName);
        if (( cat!=null)&&(occCat!=null)) occCat.renameTo(cat);
    }
    
    private void findCurrentPitCat(File dir)
    {
       logger.println("findCurrentPitCat");
       File[] files = dir.listFiles();
        
        for (int i=0; i<files.length; i++ )
        {
            File f = files[i];
            if (f.isFile())
            {
                if (f.getName().equals(pitCatName))
                {
                	logger.println("Found pit cat:");
                    if ( f.lastModified() > pitCatDate)
                    {
                    	logger.println("Most recent pit cat: " + f.getAbsolutePath());
                        pitCatDate = f.lastModified();
                        pitCat=f;
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
    	logger.println("getCurrentOccCat()");
        File working = new File("./");
        File[] files = working.listFiles();
        if (working.isDirectory()) findCurrentUserCat(working);
        for (int i=0; i<files.length; i++ )
        {
        	File f = files[i];
        	if ( f.isDirectory() ) findCurrentUserCat(f);
        }
        
        File cat = new File(userCatName);
        if (( cat!=null)&&(userCat!=null)) userCat.renameTo(cat);
    }
    
    void getCurrentLocCat()
    {
    	logger.println("getCurrentLocCat()");
        File working = new File("./");
        File[] files = working.listFiles();
        if (working.isDirectory()) findCurrentLocCat(working);
        for (int i=0; i<files.length; i++ )
        {
        	File f = files[i];
        	if ( f.isDirectory() ) findCurrentLocCat(f);
        }
        
        File cat = new File(locCatName);
        if (( cat!=null)&&(locCat!=null)) locCat.renameTo(cat);
    }
    
    private void findCurrentOccCat(File dir)
    {
       File[] files = dir.listFiles();
        
        for (int i=0; i<files.length; i++ )
        {
            File f = files[i];
            if (f.isFile())
            {
                if (f.getName().equals(occCatName))
                {
                	logger.println("Found occ cat:");
                    if ( f.lastModified() > occCatDate)
                    {
                    	logger.println("Most recent occ cat: " + f.getAbsolutePath());
                        occCatDate = f.lastModified();
                        occCat=f;
                    }
                }
            }
            if ( f.isDirectory() )
            {
                findCurrentOccCat(f);
            }
        } 
    }
    
    private void findCurrentUserCat(File dir)
    {
       logger.println("findCurrentUserCat");
       File[] files = dir.listFiles();
        
        for (int i=0; i<files.length; i++ )
        {
            File f = files[i];
            if (f.isFile())
            {
                if (f.getName().equals(userCatName))
                {
                	logger.println("Found occ cat:");
                    if ( f.lastModified() > userCatDate)
                    {
                    	logger.println("Most recent user cat: " + f.getAbsolutePath());
                        userCatDate = f.lastModified();
                        userCat=f;
                    }
                }
            }
            if ( f.isDirectory() )
            {
                findCurrentUserCat(f);
            }
        } 
    }
    
    private void findCurrentLocCat(File dir)
    {
       logger.println("findCurrentLocCat");
       File[] files = dir.listFiles();
        
        for (int i=0; i<files.length; i++ )
        {
            File f = files[i];
            if (f.isFile())
            {
                if (f.getName().equals(locCatName))
                {
                	logger.println("Found occ cat:");
                    if ( f.lastModified() > locCatDate)
                    {
                    	logger.println("Most recent user cat: " + f.getAbsolutePath());
                        locCatDate = f.lastModified();
                        locCat=f;
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