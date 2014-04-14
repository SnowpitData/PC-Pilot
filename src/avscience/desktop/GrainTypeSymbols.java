 package avscience.desktop;
 
 import java.awt.Color;
 import java.awt.Graphics;
 import java.awt.Graphics2D;
 import java.awt.Font;
 import java.awt.RenderingHints;
 import java.io.*;
 
 public class GrainTypeSymbols
 {
   private static final int size = 18;
   private float fsize = (float)size+6;
   private int mid = 9;
   private static final int height = 18;
   private int base = 16;
   private int startx;
   private int starty;
   private static final int inc = 2;
   private static final int bigInc = 3;
   private static Graphics2D g;
   Font ff;
   
   private static final GrainTypeSymbols instance  = new GrainTypeSymbols();
   
   private GrainTypeSymbols()
   { 
		ff=loadFont();
		if ( ff==null ) System.out.println("Could not load font.");
	    else 
	    {
	    	System.out.println("Snow Symbol Font loaded! ");
	    }
   }
   
   public static GrainTypeSymbols getInstance(Graphics paramGraphics)
   {
     g = ((Graphics2D)paramGraphics);
     g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
     return instance;
    	
   }
   
   Font loadFont()
   {
   		try
   		{
            InputStream in = getClass().getResourceAsStream("SnowSymbolsIACS.ttf");
            if ( in!=null )
            {
            	Font f = Font.createFont(Font.TRUETYPE_FONT, in);
            	if (f!=null) return f.deriveFont(fsize);
            }
            else System.out.println("Could not open font file!!!!!!!!!!!!");
   		}
   		catch(Exception e)
   		{
   			System.out.println(e.toString());
   		}
   		return null;
   }
 
   public void scaleForPrint()
   {
     this.base = 24;
  }
 
  public void unscale()
   {
   }
 
   public void drawSymbol(int paramInt1, int paramInt2, String paramString)
   {
     if (paramString == null) paramString = "";
     paramString = paramString.trim();
     this.startx = paramInt1;
     this.starty = paramInt2;
     
     Font f = this.g.getFont();
     this.g.setFont(ff);
 	
     if (paramString.equals("Graupel")) draw1();
     else if (paramString.equals("Highly broken particles")) draw2();
     else if (paramString.equals("Mixed forms - rounded")) draw26();
     else if (paramString.equals("small faceted particles")) draw4();
     else if (paramString.equals("mixed forms faceted")) draw29();
     else if (paramString.equals("depth hoar")) draw6();
     else if (paramString.equals("clustered rounded grains")) draw7();
     else if (paramString.equals("slush")) draw8();
     else if (paramString.equals("rounded poly-crystals")) draw9();
     else if (paramString.equals("surface hoar")) draw10();
     else if (paramString.equals("ice")) draw11();
     else if (paramString.equals("wind crust")) draw12();
     else if (paramString.equals("melt-freeze crust")) draw13();
 
     else if (paramString.equals("Precipitation Particles")) draw14();
     else if (paramString.equals("Decomposing fragmenting particles")) draw15();
     else if (paramString.equals("Decomposing & fragmented precip. particles")) draw15();
     else if (paramString.equals("Rounded Grains")) draw16();
     else if (paramString.equals("Faceted Crystals")) draw17();
     else if (paramString.equals("Cup-shaped Crystals")) draw18();
     else if (paramString.equals("Wet Grains")) draw37();
     else if (paramString.equals("Feathery Crystals")) draw20();
     else if (paramString.equals("Rime")) draw21();
 
     else if (paramString.equals("Precipitation particles")) draw14();
     else if (paramString.equals("Decomposing fragmented particles")) draw15();
 
     else if (paramString.equals("Rounded grains")) draw16();
     else if (paramString.equals("Mixed forms rounded")) draw26();
     else if (paramString.equals("Faceted crystals")) draw17();
     else if (paramString.equals("Small faceted cystals")) draw4();
     else if (paramString.equals("Mixed forms faceted")) draw29();
     else if (paramString.equals("Cup-shaped crystals/depth hoar")) draw18();
     else if (paramString.equals("Columns of depth hoar")) draw6();
     else if (paramString.equals("Clustered rounded grains")) draw7();
     else if (paramString.equals("Rounded poly-crystals")) draw9();
     else if (paramString.equals("Slush")) draw8();
     else if (paramString.equals("Surface hoar")) draw10();
     else if (paramString.equals("Ice layer")) draw11();

     else if (paramString.equals("Wind crust")) draw12();
     else if (paramString.equals("Melt-freeze crust")) draw13();
 
     else if (paramString.equals("Sun crust")) draw22();
     else if (paramString.equals("Rain crust")) draw23();
     else if (paramString.equals("Surface deposits and crusts")) draw35();
     else if (paramString.equals("Wind packed")) draw25();
     else if (paramString.equals("Faceted rounded particles")) draw26();
     
     else if (paramString.equals("Solid faceted particles")) draw27();
     else if (paramString.equals("Near surface faceted particles")) draw28();
     else if (paramString.equals("Rounding faceted particles")) draw29();
     
     else if (paramString.equals("Depth hoar")) draw30();
     else if (paramString.equals("Hollow cups")) draw31();
     else if (paramString.equals("Chains of depth hoar")) draw32();
     else if (paramString.equals("Large striated crystals")) draw33();
     else if (paramString.equals("Rounding depth hoar")) draw34();
     else if (paramString.equals("Surface hoar")) draw35();
     else if (paramString.equals("Surface hoar crystals")) draw36();
     else if (paramString.equals("Melt forms")) draw37();
     else if (paramString.equals("Clustered rounded grains")) draw38();
     else if (paramString.equals("Rounded polycrystals")) draw39();
     else if (paramString.equals("Slush")) draw40();
     else if (paramString.equals("Ice formations")) draw41();
     else if (paramString.equals("Ice layer")) draw42();
     else if (paramString.equals("Rain crust")) draw43();
     else if (paramString.equals("Sun crust")) draw44();
     else if (paramString.equals("Columns")) draw45();
     else if (paramString.equals("Needles")) draw46();
     else if (paramString.equals("Plates")) draw47();
     else if (paramString.equals("Stellars, Dendrites")) draw48();
     else if (paramString.equals("Irregular crystals")) draw49();
     else if (paramString.equals("Hail")) draw50();
     else if (paramString.equals("Ice pellets")) draw51();
     else if (paramString.equals("Small rounded particles")) draw52();
     else if (paramString.equals("Large rounded particles")) draw53();
     
     else if (paramString.equals("Depth Hoar")) draw6();
     else if (paramString.equals("Hollow prisms")) draw54();
     else if (paramString.equals("Cavity or crevasse hoar")) draw55();
     else if (paramString.equals("Rounding surface hoar")) draw56();
     
     else if (paramString.equals("Ice column")) draw57();
     else if (paramString.equals("Basal ice")) draw58();
     
     else if (paramString.equals("Partly decomposed precipitation particles")) draw59();
     else if (paramString.equals("Wind-broken precipitation particles")) draw60();
     
     else if (paramString.equals("Round polycrystalline particles")) draw61();
     else if (paramString.equals("Crushed ice particles")) draw62();
     else if (paramString.equals("Machine made snow")) draw61();
     else;
     
    // this.g.scale(1.0D, 1.0D);
     this.g.setFont(f);
   }
 
   private void draw1()
   {
     this.g.drawString("\uE00E", this.startx, this.starty+this.base+2);
   }

   private void draw2()
   {
    	this.g.drawString("\uE015", this.startx, this.starty+this.base);
   }
 

 
   private void draw4()
   {
   		this.startx += 2;
        this.starty += 2;
    	this.g.drawString("\uE01B", this.startx, this.starty+this.base);
   }
 
 
 
  private void draw6()
  {
  	 this.g.drawString("\uE01F", this.startx, this.starty+this.base);
  }
 
   private void draw7()
   {
   	  this.g.drawString("\uE025", this.startx, this.starty+this.base);
   }
 
   private void draw8()
   {
   		this.g.drawString("\uE027", this.startx, this.starty+this.base);
   }
 
   private void draw9()
   {
   	   this.g.drawString("\uE026", this.startx, this.starty+this.base);
   }
 
   private void draw10()
   {
   		this.g.drawString("\uE006", this.startx, this.starty+this.base);
   }
 
   private void draw11()
   {
   		this.g.drawString("\uE008", this.startx, this.starty+this.base);
   }
 
   private void draw12()
   {
   	   this.g.drawString("\uE018", this.startx, this.starty+this.base);
   }
 
   private void draw13()
   {
   	  Font temp = ff.deriveFont(fsize-12);
   	  this.g.setFont(temp);
   	  this.g.drawString("\uE028", this.startx+1, this.starty+this.base-4);
   	  this.g.drawString("\uE007", this.startx+10, this.starty+this.base-4);
   	  this.g.setFont(ff);
    
   }
 
  void draw14()
  {
	   this.g.drawString("\uE000", this.startx, this.starty+this.base-2);
   }
 
   void draw15()
   {
	 this.g.drawString("\uE002", this.startx, this.starty+this.base-2);
   }
 
   void draw16()
   {
   		this.g.drawString("\uE003", this.startx, this.starty+this.base);
   }
   
  void draw17()
  {
  	   this.g.drawString("\uE004", this.startx, this.starty+this.base);
   }

   void draw18()
   {
   		this.g.drawString("\uE01D", this.startx, this.starty+this.base);
    
   }

   void draw20()
	{
		this.starty += 1;
	    this.g.drawLine(this.startx + 2, this.starty, this.startx + this.mid, this.starty + 18);
	    this.g.drawLine(this.startx + this.mid, this.starty + 18, this.startx + this.base, this.starty);
   }

   void draw21()
   {
   		this.g.drawString("\uE011", this.startx, this.starty+this.base);
   }
 
   void draw22()
   {
   		this.g.drawString("\uE02D", this.startx, this.starty+this.base);
   }
 
   void draw23()
   {
   		this.g.drawString("\uE02C", this.startx, this.starty+this.base);
    }
 


   public int getBase()
   {
       return this.base;
   }
   
   void draw25()
   {
   	// RGwp
   		this.g.drawString("\uE018", this.startx, this.starty+this.base);
   }
   
   void draw26()
   {
   	// RGxf
   		this.g.drawString("\uE019", this.startx, this.starty+this.base);
   }
   
   
   
   void draw27()
   {
   	// FCso
   		this.g.drawString("\uE01A", this.startx, this.starty+this.base);
   }
   
   void draw28()
   {
   	// FCsf
   		this.g.drawString("\uE01B", this.startx, this.starty+this.base);
   }
   
   void draw29()
   {
   	// FCxr
   		this.g.drawString("\uE01C", this.startx, this.starty+this.base);
   }
   
   void draw30()
   {
   	// DH
   		this.g.drawString("\uE005", this.startx, this.starty+this.base);
   }
   
   void draw31()
   {
   	// DHcp
   		this.g.drawString("\uE01D", this.startx, this.starty+this.base);
   }
   
   void draw32()
   {
   	// DHch
   		this.g.drawString("\uE01F", this.startx, this.starty+this.base);
   }
   
   void draw33()
   {
   	// DHla
   		this.g.drawString("\uE020", this.startx, this.starty+this.base);
   }
   
   void draw34()
   {
   	// DHxr
   		this.g.drawString("\uE021", this.startx, this.starty+this.base);
   }
   
   void draw35()
   {
   	// SH
   		this.g.drawString("\uE006", this.startx, this.starty+this.base);
   }
   
   void draw36()
   {
   	// SHsu
   		this.g.drawString("\uE022", this.startx, this.starty+this.base);
   }
   
   void draw37()
   {
   	// MF
   		this.g.drawString("\uE007", this.startx, this.starty+this.base);
   }
   
   void draw38()
   {
   	// MFcl
   		this.g.drawString("\uE025", this.startx, this.starty+this.base);
   }
   
   void draw39()
   {
   	// MFpc
   		this.g.drawString("\uE026", this.startx, this.starty+this.base);
   }
   
   void draw40()
   {
   	// MFsl
   		this.g.drawString("\uE027", this.startx, this.starty+this.base);
   }
   
   void draw41()
   {
   	// IF
   		this.g.drawString("\uE008", this.startx, this.starty+this.base);
   }
   
   void draw42()
   {
   	// IFil
   		this.g.drawString("\uE029", this.startx, this.starty+this.base);
   }
   
   void draw43()
   {
   	// IFrc
   		this.g.drawString("\uE02C", this.startx, this.starty+this.base);
   }
   
   void draw44()
   {
   	// IFsc
   		this.g.drawString("\uE02D", this.startx, this.starty+this.base);
   }
   
   void draw45()
   {
   	// PPco Columns
   		this.g.drawString("\uE009", this.startx, this.starty+this.base);
   }
   
   
   void draw46()
   {
   	// PPnd Needles
   		this.g.drawString("\uE00A", this.startx, this.starty+this.base);
   }
   
   void draw47()
   {
   	// PPpl Plates
   		this.g.drawString("\uE00B", this.startx, this.starty+this.base);
   }
   
   void draw48()
   {
   	// PPsd Stellars, Dendrites
   		this.g.drawString("\uE00C", this.startx, this.starty+this.base);
   }
   
   void draw49()
   {
   	// PPir Irregular crystals
   		this.g.drawString("\uE00D", this.startx, this.starty+this.base);
   }
   
   void draw50()
   {
   	// PPhl Hail
   		this.g.drawString("\uE00F", this.startx, this.starty+this.base);
   }
   
   void draw51()
   {
   	// PPip Ice pellets
   		this.g.drawString("\uE010", this.startx, this.starty+this.base);
   }
   
   void draw52()
   {
   	// RGsr Small rounded particles
   		this.g.drawString("\uE016", this.startx, this.starty+this.base);
   }
   
   void draw53()
   {
   	// RGlr large rounded particles
   		this.g.drawString("\uE017", this.startx, this.starty+this.base);
   }
   
   void draw54()
   {
   	// DHpr large rounded particles
   		this.g.drawString("\uE01E", this.startx, this.starty+this.base);
   }
   
   void draw55()
   {
   	// SHcv Cavity or crevasse hoar
   		this.g.drawString("\uE023", this.startx, this.starty+this.base);
   }
   
   void draw56()
   {
   	// SHxr Rounding surface hoar
   		this.g.drawString("\uE024", this.startx, this.starty+this.base);
   }
   
   void draw57()
   {
   	// IFic Ice column
   		this.g.drawString("\uE02A", this.startx, this.starty+this.base);
   }
   
   void draw58()
   {
   	// IFbi Basal ice
   		this.g.drawString("\uE02B", this.startx, this.starty+this.base);
   }
   
   void draw59()
   {
   	// DFdc Partly decomposed precipitation particles
   		this.g.drawString("\uE014", this.startx, this.starty+this.base);
   }
   
   void draw60()
   {
   	// DFbk Wind-broken precipitation particles
   		this.g.drawString("\uE015", this.startx, this.starty+this.base);
   }
   
   void draw61()
   {
   	// MMrp Machine Made, Round polycrystalline particles.
   		this.g.drawString("\uE012", this.startx, this.starty+this.base);
   }
   
   void draw62()
   {
   	// MMci Machine Made, Crushed Ice particles,
   		this.g.drawString("\uE013", this.startx, this.starty+this.base);
   }
 
 
   public int getHeight()
   {
     return 18;
  }
 }

