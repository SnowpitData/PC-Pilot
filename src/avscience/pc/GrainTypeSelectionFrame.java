package avscience.pc;

import avscience.desktop.GrainTypeSymbols;
import avscience.wba.GrainType;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class GrainTypeSelectionFrame extends Frame
{
	  TypeDisplay selectedType;
	  Label selectedText;
	  
	  GrainTypeSelect precipPart;
	  GrainTypeSelect decompFragPart;
	  GrainTypeSelect roundedGrains;
	  GrainTypeSelect facetedCystals;
	  GrainTypeSelect depthHoar;
	  GrainTypeSelect surfaceHoar;
	  GrainTypeSelect meltForms;
	  GrainTypeSelect iceForms;
	  GrainTypeSelect machineMade;
	  int wdth=384;
	  int ht=550;
	  private float fsize = 24f;
	  Font font;
	  TypeDisplay display;
	  
	  public GrainTypeSelectionFrame(TypeDisplay display)
	  {
	  	this.display=display;
	  	SWindow aSWindow = new SWindow();
		addWindowListener(aSWindow);
	  	buildForm();
	  	if (display.getType()!=null) setType(display.getType());
	  }
	  
	  public GrainTypeSelectionFrame(TypeDisplay display, int x, int y)
	  {
	  	this.display=display;
	  	SWindow aSWindow = new SWindow();
		addWindowListener(aSWindow);
	  	buildForm();
	  	if (display.getType()!=null) setType(display.getType());
	  	setLocation(x, y);
	  }
	  
	  public void setType(String type)
	  {
	  	selectedText.setText(type);
	  	selectedType.setType(type);
	  	display.setType(type);
	  	display.repaint();
	  	selectedType.repaint();
	  }
	  
	  void buildForm()
	  {
	  	setTitle("Grain Type Select");
	  	setLayout(null);
	  	setSize(wdth, ht);
	  	setVisible(true);
	 	int ys=40;
    	int x=24;
    	int y=ys;
    	int vspace=34;
    	
    	selectedType = new TypeDisplay("Precipitation particles");
    	selectedType.setLocation(20, y);
    	add(selectedType);
    	
    	selectedText = new Label("Precipitation particles");
    	selectedText.setLocation(x+50, y);
    	selectedText.setSize(380, 22);
    	add(selectedText);
    	
    	y+=vspace;
    	
    	TypeDisplay df = new TypeDisplay("Decomposing & fragmented precip. particles");
    	df.setLocation(20, y);
    	add(df);
    	decompFragPart = new GrainTypeSelect(this, "DF");
    	decompFragPart.setLocation(x+50, y);
    	add(decompFragPart);
    	y+=vspace;
    	
    	TypeDisplay td = new TypeDisplay("Precipitation particles");
    	td.setLocation(20, y);
    	add(td);
    	precipPart = new GrainTypeSelect(this, "PP");
    	precipPart.setLocation(x+50, y);
    	add(precipPart);
    	y+=vspace;
    	
    	TypeDisplay rg = new TypeDisplay("Rounded Grains");
    	rg.setLocation(20, y);
    	add(rg);
    	roundedGrains = new GrainTypeSelect(this, "RG");
    	roundedGrains.setLocation(x+50, y);
    	add(roundedGrains);
    	y+=vspace;
    	
    	TypeDisplay fc = new TypeDisplay("Faceted crystals");
    	fc.setLocation(20, y);
    	add(fc);
    	facetedCystals = new GrainTypeSelect(this, "FC");
    	facetedCystals.setLocation(x+50, y);
    	add(facetedCystals);
    	y+=vspace;
    	
    	TypeDisplay dh = new TypeDisplay("Depth hoar");
    	dh.setLocation(20, y);
    	add(dh);
    	depthHoar = new GrainTypeSelect(this, "DH");
    	depthHoar.setLocation(x+50, y);
    	add(depthHoar);
    	y+=vspace;
    	
    	TypeDisplay sh = new TypeDisplay("Surface hoar");
    	sh.setLocation(20, y);
    	add(sh);
    	surfaceHoar = new GrainTypeSelect(this, "SH");
    	surfaceHoar.setLocation(x+50, y);
    	add(surfaceHoar);
    	y+=vspace;
    	
    	TypeDisplay mf = new TypeDisplay("Melt forms");
    	mf.setLocation(20, y);
    	add(mf);
    	meltForms = new GrainTypeSelect(this, "MF");
    	meltForms.setLocation(x+50, y);
    	add(meltForms);
    	y+=vspace;
    	
    	TypeDisplay ff = new TypeDisplay("Ice formations");
    	ff.setLocation(20, y);
    	add(ff);
    	iceForms = new GrainTypeSelect(this, "IF");
    	iceForms.setLocation(x+50, y);
    	add(iceForms);
    	y+=vspace;
    	
    	TypeDisplay mm = new TypeDisplay("Machine made snow");
    	mm.setLocation(20, y);
    	add(mm);
    	machineMade = new GrainTypeSelect(this, "MM");
    	machineMade.setLocation(x+50, y);
    	add(machineMade);
    	
    /*	SymbolLabel[] sla = new SymbolLabel[2];
    	sla[0]=new SymbolLabel("\uE001");
    	sla[1]=new SymbolLabel("\uE002");
    	precipPart = new SymbolChoice(sla);
    	precipPart.setSize(60, 32);
    	precipPart.setLocation(x+42, y);
    	precipPart.setFont(font);
    	precipPart.add("\uE001");
    	add(precipPart);*/
	  }
	  
	  public void reset(GrainTypeSelect origin)
	  {
	  	if ( origin!=precipPart) precipPart.reset();
	    if ( origin!=decompFragPart) decompFragPart.reset();
	    if ( origin!=roundedGrains) roundedGrains.reset();
	    if ( origin!=facetedCystals) facetedCystals.reset();
	    if ( origin!=depthHoar) depthHoar.reset();
	    if ( origin!=surfaceHoar) surfaceHoar.reset();
	    if ( origin!=meltForms) meltForms.reset();
	    if ( origin!=iceForms) iceForms.reset();
	    if ( origin!=machineMade) machineMade.reset();
	  }
	  
	  
	class SWindow extends java.awt.event.WindowAdapter
	{	
		public void windowClosing(java.awt.event.WindowEvent event)
		{
			Object object = event.getSource();
			if (object == GrainTypeSelectionFrame.this )
			{
				GrainTypeSelectionFrame.this.dispose();
			}
		}
	}
}