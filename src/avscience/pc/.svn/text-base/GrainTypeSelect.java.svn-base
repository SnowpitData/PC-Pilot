package avscience.pc;

import avscience.desktop.GrainTypeSymbols;
import avscience.wba.GrainType;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

public class GrainTypeSelect extends Canvas
{
 
  int x=8;
  int y;
  int size=3;
  int vspace=26;
  int wdth=300;
  int ht = vspace+size*vspace;
  String [] types = new String[size];
  Rectangle[] rects = new Rectangle[size];
  Rectangle srect;
  Rectangle drect;
  Image drpdwn;
  boolean dropped=false;
  String selectedSymbol;
  GrainTypeSelectionFrame frame;
  String type="PP";
  java.awt.Color myBlue = new java.awt.Color(0f, 0f, 0.6f, 0.5f);
  public GrainTypeSelect(GrainTypeSelectionFrame frame, String type)
  {
    setSize(wdth+8, 30);
    setVisible(true);
    this.frame=frame;
    this.type=type;
    drpdwn=loadDropDown();
    
    if ( type.equals("PP"))
    {
    	size=11;
    	types = new String[size];
  		rects = new Rectangle[size];
  		types[0]=" ";
  		types[1]="Precipitation particles";
  		types[2]=" ";
  		types[3]="Columns";
  		types[4]="Needles";
  		types[5]="Stellars, Dendrites";
  		types[6]="Irregular crystals";
  		types[7]="Graupel";
  		types[8]="Hail";
  		types[9]="Ice pellets";
    	types[10]="Rime";
    }
    
    if ( type.equals("RG"))
    {
    	size=7;
    	types = new String[size];
  		rects = new Rectangle[size];
  		types[0]=" ";
  		types[1]="Rounded grains";
  		types[2]=" ";
  		types[3]="Small rounded particles";
  		types[4]="Large rounded particles";
  		types[5]="Wind packed";
    	types[6]="Faceted rounded particles";
    }
    
    if ( type.equals("FC"))
    {
    	size=6;
    	types = new String[size];
  		rects = new Rectangle[size];
  		types[0]=" ";
  		types[1]="Faceted Crystals";
  		types[2]=" ";
  		types[3]="Solid faceted particles";
    	types[4]="Near surface faceted particles";
    	types[5]="Rounding faceted particles";
    }
    
    if ( type.equals("DH"))
    {
    	size=8;
    	types = new String[size];
  		rects = new Rectangle[size];
  		types[0]=" ";
  		types[1]="Depth hoar";
  		types[2]=" ";
  		types[3]="Hollow cups";
  		types[4]="Hollow prisms";
    	types[5]="Chains of depth hoar";
    	types[6]="Large striated crystals";
    	types[7]="Rounding depth hoar";
    }
    
    if ( type.equals("SH"))
    {
    	size=6;
    	types = new String[size];
  		rects = new Rectangle[size];
  		types[0]=" ";
  		types[1]="Surface hoar";
  		types[2]=" ";
  		types[3]="Surface hoar crystals";
  		types[4]="Cavity or crevasse hoar";
  		types[5]="Rounding surface hoar";
    }
    
    if ( type.equals("MF"))
    {
    	size=7;
    	types = new String[size];
  		rects = new Rectangle[size];
  		types[0]=" ";
  		types[1]="Melt forms";
  		types[2]=" ";
  		types[3]="Clustered rounded grains";
    	types[4]="Rounded polycrystals";
    	types[5]="Slush";
    	types[6]="Melt-freeze crust";
    }
    
    if ( type.equals("IF"))
    {
    	size=8;
    	types = new String[size];
  		rects = new Rectangle[size];
  		types[0]=" ";
  		types[1]="Ice formations";
  		types[2]=" ";
  		types[3]="Ice layer";
  		types[4]="Ice column";
  		types[5]="Basal ice";
    	types[6]="Rain crust";
    	types[7]="Sun crust";
    }
    
    if ( type.equals("DF"))
    {
    	size=5;
    	types = new String[size];
  		rects = new Rectangle[size];
  		types[0]=" ";
  		types[1]="Decomposing & fragmented precip. particles";
  		types[2]=" ";
  		types[3]="Partly decomposed precipitation particles";
  		types[4]="Wind-broken precipitation particles";
    }
    
    if ( type.equals("MM"))
    {
    	size=3;
    	types = new String[size];
  		rects = new Rectangle[size];
  		types[0]=" ";
  		types[1]="Round polycrystalline particles";
  		types[2]="Crushed ice particles";
    }
    ht = vspace+size*vspace;
    drect = new Rectangle(0,0,wdth+8,vspace);
    y+=26;
    for (int i=0; i<size; i++ )
   	{
   		rects[i] = new Rectangle(x, y, wdth, vspace);
   		y+=vspace;
   	}
   	y=0;
   	addMouseMotionListener(new MListener());
   	addMouseListener(new MoListener());
   	
   	
  }
  
  public void reset()
  {
  	if (!dropped &(selectedSymbol==null)) return;
  	dropped=false;
  	selectedSymbol=null;
  	repaint();
  }
  
  Image loadDropDown()
  {
  	System.out.println("Loading drop dowm image.");
  	Image image=null;
  //	File file = new File("C:/dropdwn.png");
  	try
  	{
  		InputStream in = getClass().getResourceAsStream("dropdwn.png");
  		image = ImageIO.read(in);
  	}
  	catch(Exception e)
  	{
  		System.out.println(e.toString());
  	}
  	return image;
  }
  
	
   public void paint(Graphics g)
   {
   	System.out.println("paint");
   		x=8;
   		y=0;
   		g.drawImage(drpdwn, x, y, null);
   		GrainTypeSymbols gts = GrainTypeSymbols.getInstance(g);
   		if (selectedSymbol!=null)
   		{
   			gts.drawSymbol(24, 6, selectedSymbol);
   		}
   		if ( dropped )
   		{
   			setSize(wdth+8, ht+8);
   			System.out.println("Painting drop down.");
	   	    y+=26;
	   	    g.setColor(Color.BLACK);
	   	    g.drawRect(x+2,y,wdth-4,ht-vspace);
	   	    y+=4;
	   	    
	   	    if ( srect!=null )
	   		{
	   			g.setColor(myBlue);
	   			g.fillRect(srect.x+2, srect.y, srect.width-4, srect.height);
	   			g.setColor(Color.BLACK);
	   		}
	   		for (int i=0; i<types.length; i++ )
	   		{
	   			String type = types[i];
	   			gts.drawSymbol(24, y, type);
	   			g.drawString(type, 52, y+12);
	   			y+=vspace;
	   		}
   		}
   		else setSize(wdth+8, 30);
   }
   
   class MoListener implements MouseListener 
   {
   		public void mouseClicked(MouseEvent e)
   		{
   			int xx = e.getX();
   			int yy = e.getY();
   			if (!dropped)
   			{
   				if ( drect.contains(xx, yy))
	   			{
	   				dropped=true;
	   				repaint();
	   			}
	   			return;
   			}
   			else
   			{
   				for (int i=0; i<size; i++ )
	   			{
	   				if ( rects[i].contains(xx, yy))
	   				{
	   					frame.reset(GrainTypeSelect.this);
	   					selectedSymbol=types[i];
	   					frame.setType(selectedSymbol);
	   					dropped=false;
	   					repaint();
	   					return;
	   				}
	   			}
   			}
   			
   		}
   		
   		public void mousePressed(MouseEvent e){}
   		public void mouseReleased(MouseEvent e){}
   		public void mouseEntered(MouseEvent e){}
   		public void mouseExited(MouseEvent e){}
   }
   
   
   class MListener implements MouseMotionListener
   {
   		boolean[] hilites = new boolean[size];
   		public 	void mouseDragged(MouseEvent e){}
   		public void mouseMoved(MouseEvent e) 
   		{
   			System.out.println("Mouse moved...");
   			int xx = e.getX();
   			int yy = e.getY();
   			for (int i=0; i<size; i++ )
   			{
   				if ( rects[i].contains(xx, yy))
   				{
   					System.out.println("Selecting rect ."+i);
   					srect=rects[i];
   					
   					//invalidate();
   				//	repaint(srect.x, srect.y, srect.width, srect.height););
   					if (!hilites[i]) 
   					{
   						repaint();
   						hilites[i]=true;
   					}
   					break;
   				}
   				else hilites[i]=false;
   			}
   			
   		}
   }
 
}