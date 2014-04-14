package avscience.pc;

import java.awt.*;
import avscience.wba.StringNumConvertor;

public class ProfileDisplay extends Canvas
{
    int type=-1;
    int w = 24;
    int h = 46;
    public ProfileDisplay(int type)
    {
        this.type= type;
        setSize(w, h);
    }
    
    public void setType(String type)
    {
        int i = StringNumConvertor.getInstance().getNumFromDisplayString(type);
        this.type = i;
    }
    
    public void setType(int type)
    {
        this.type = type;
    }
    public int getType(){return type;}
    public String toString()
    {
        return (new Integer(type)).toString();
    }
    
    public void paint(Graphics g)
    { 
        SnowProfiles profiles = new SnowProfiles(g);
        profiles.drawProfile(type);
        
    }
    
    
}
