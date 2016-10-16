package avscience.wba;
import avscience.util.*;
import avscience.pda.Integer;

public final class TempList
{
    private Hashtable Clist;
    private Hashtable ClistInv = new Hashtable();
    private Vector clist = new Vector();
    private Vector flist = new Vector();
    private Hashtable Flist;
    private Hashtable FlistInv = new Hashtable();
    
     // Make this a Singleton class
    private static final TempList instance  = new TempList();
    
    /** To use this class as a singleton class this method should be called.
    * @return An object variable reference to the singleton class.
    */

    public static   TempList getInstance()
	{
		return instance;
	}

    private TempList()
    {
        init();
    }
    
    private void init()
    {
        Clist = new Hashtable();
        Clist.put("0", new avscience.pda.Integer(0) );
        Clist.put("-0.1", new avscience.pda.Integer(-1) );
        Clist.put("-0.2", new avscience.pda.Integer(-2) );
        Clist.put("-0.3", new avscience.pda.Integer(-3) );
        Clist.put("-0.4", new avscience.pda.Integer(-4) );
        Clist.put("-0.5", new avscience.pda.Integer(-5) );
        Clist.put("-0.6", new avscience.pda.Integer(-6) );
        Clist.put("-0.7", new avscience.pda.Integer(-7) );
        Clist.put("-0.8", new avscience.pda.Integer(-8) );
        Clist.put("-0.9", new avscience.pda.Integer(-9) );
        
        Clist.put("-1.0", new avscience.pda.Integer(-10) );
        Clist.put("-1.1", new avscience.pda.Integer(-11) );
        Clist.put("-1.2", new avscience.pda.Integer(-12) );
        Clist.put("-1.3", new avscience.pda.Integer(-13) );
        Clist.put("-1.4", new avscience.pda.Integer(-14) );
        Clist.put("-1.5", new avscience.pda.Integer(-15) );
        Clist.put("-1.6", new avscience.pda.Integer(-16) );
        Clist.put("-1.7", new avscience.pda.Integer(-17) );
        Clist.put("-1.8", new avscience.pda.Integer(-18) );
        Clist.put("-1.9", new avscience.pda.Integer(-19) );
        
        Clist.put("-2.0", new avscience.pda.Integer(-20) );
        Clist.put("-2.1", new avscience.pda.Integer(-21) );
        Clist.put("-2.2", new avscience.pda.Integer(-22) );
        Clist.put("-2.3", new avscience.pda.Integer(-23) );
        Clist.put("-2.4", new avscience.pda.Integer(-24) );
        Clist.put("-2.5", new avscience.pda.Integer(-25) );
        Clist.put("-2.6", new avscience.pda.Integer(-26) );
        Clist.put("-2.7", new avscience.pda.Integer(-27));
        Clist.put("-2.8", new avscience.pda.Integer(-28));
        Clist.put("-2.9", new avscience.pda.Integer(-29));
        
        Clist.put("-3.0", new avscience.pda.Integer(-30));
        Clist.put("-3.1", new avscience.pda.Integer(-31));
        Clist.put("-3.2", new avscience.pda.Integer(-32));
        Clist.put("-3.3", new avscience.pda.Integer(-33));
        Clist.put("-3.4", new avscience.pda.Integer(-34));
        Clist.put("-3.5", new avscience.pda.Integer(-35) );
        Clist.put("-3.6", new avscience.pda.Integer(-36) );
        Clist.put("-3.7", new avscience.pda.Integer(-37));
        Clist.put("-3.8", new avscience.pda.Integer(-38));
        Clist.put("-3.9", new avscience.pda.Integer(-39));
        
        Clist.put("-4.0", new avscience.pda.Integer(-40) );
        Clist.put("-4.1", new avscience.pda.Integer(-41) );
        Clist.put("-4.2", new avscience.pda.Integer(-42) );
        Clist.put("-4.3", new avscience.pda.Integer(-43) );
        Clist.put("-4.4", new avscience.pda.Integer(-44) );
        Clist.put("-4.5", new avscience.pda.Integer(-45) );
        Clist.put("-4.6", new avscience.pda.Integer(-46) );
        Clist.put("-4.7", new avscience.pda.Integer(-47) );
        Clist.put("-4.8", new avscience.pda.Integer(-48) );
        Clist.put("-4.9", new avscience.pda.Integer(-49) );
        
        Clist.put("-5.0", new avscience.pda.Integer(-50) );
        Clist.put("-5.1", new avscience.pda.Integer(-51) );
        Clist.put("-5.2", new avscience.pda.Integer(-52) );
        Clist.put("-5.3", new avscience.pda.Integer(-53) );
        Clist.put("-5.4", new avscience.pda.Integer(-54) );
        Clist.put("-5.5", new avscience.pda.Integer(-55) );
        Clist.put("-5.6", new avscience.pda.Integer(-56) );
        Clist.put("-5.7", new avscience.pda.Integer(-57) );
        Clist.put("-5.8", new avscience.pda.Integer(-58) );
        Clist.put("-5.9", new avscience.pda.Integer(-59) );
        
        Clist.put("-6.0", new avscience.pda.Integer(-60) );
        Clist.put("-6.1", new avscience.pda.Integer(-61) );
        Clist.put("-6.2", new avscience.pda.Integer(-62) );
        Clist.put("-6.3", new avscience.pda.Integer(-63) );
        Clist.put("-6.4", new avscience.pda.Integer(-64) );
        Clist.put("-6.5", new avscience.pda.Integer(-65) );
        Clist.put("-6.6", new avscience.pda.Integer(-66) );
        Clist.put("-6.7", new avscience.pda.Integer(-67) );
        Clist.put("-6.8", new avscience.pda.Integer(-68) );
        Clist.put("-6.9", new avscience.pda.Integer(-69) );
        
       
        Clist.put("-7.0", new avscience.pda.Integer(-70) );
        Clist.put("-7.1", new avscience.pda.Integer(-71) );
        Clist.put("-7.2", new avscience.pda.Integer(-72) );
        Clist.put("-7.3", new avscience.pda.Integer(-73) );
        Clist.put("-7.4", new avscience.pda.Integer(-74) );
        Clist.put("-7.5", new avscience.pda.Integer(-75) );
        Clist.put("-7.6", new avscience.pda.Integer(-76) );
        Clist.put("-7.7", new avscience.pda.Integer(-77) );
        Clist.put("-7.8", new avscience.pda.Integer(-78) );
        Clist.put("-7.9", new avscience.pda.Integer(-79) );
        
        Clist.put("-8.0", new avscience.pda.Integer(-80) );
        Clist.put("-8.1", new avscience.pda.Integer(-81) );
        Clist.put("-8.2", new avscience.pda.Integer(-82) );
        Clist.put("-8.3", new avscience.pda.Integer(-83) );
        Clist.put("-8.4", new avscience.pda.Integer(-84) );
        Clist.put("-8.5", new avscience.pda.Integer(-85) );
        Clist.put("-8.6", new avscience.pda.Integer(-86) );
        Clist.put("-8.7", new avscience.pda.Integer(-87) );
        Clist.put("-8.8", new avscience.pda.Integer(-88) );
        Clist.put("-8.9", new avscience.pda.Integer(-89) );
        
        Clist.put("-9.0", new avscience.pda.Integer(-90) );
        Clist.put("-9.1", new avscience.pda.Integer(-91) );
        Clist.put("-9.2", new avscience.pda.Integer(-92) );
        Clist.put("-9.3", new avscience.pda.Integer(-93) );
        Clist.put("-9.4", new avscience.pda.Integer(-94) );
        Clist.put("-9.5", new avscience.pda.Integer(-95) );
        Clist.put("-9.6", new avscience.pda.Integer(-96) );
        Clist.put("-9.7", new avscience.pda.Integer(-97) );
        Clist.put("-9.8", new avscience.pda.Integer(-98) );
        Clist.put("-9.9", new avscience.pda.Integer(-99) );
        
        Clist.put("-10.0", new avscience.pda.Integer(-100) );
        Clist.put("-10.1", new avscience.pda.Integer(-101) );
        Clist.put("-10.2", new avscience.pda.Integer(-102) );
        Clist.put("-10.3", new avscience.pda.Integer(-103) );
        Clist.put("-10.4", new avscience.pda.Integer(-104) );
        Clist.put("-10.5", new avscience.pda.Integer(-105) );
        Clist.put("-10.6", new avscience.pda.Integer(-106) );
        Clist.put("-10.7", new avscience.pda.Integer(-107) );
        Clist.put("-10.8", new avscience.pda.Integer(-108) );
        Clist.put("-10.9", new avscience.pda.Integer(-109) );
        
        Clist.put("-11.0", new avscience.pda.Integer(-110) );
        Clist.put("-11.1", new avscience.pda.Integer(-111) );
        Clist.put("-11.2", new avscience.pda.Integer(-112) );
        Clist.put("-11.3", new avscience.pda.Integer(-113) );
        Clist.put("-11.4", new avscience.pda.Integer(-114) );
        Clist.put("-11.5", new avscience.pda.Integer(-115) );
        Clist.put("-11.6", new avscience.pda.Integer(-116) );
        Clist.put("-11.7", new avscience.pda.Integer(-117) );
        Clist.put("-11.8", new avscience.pda.Integer(-118) );
        Clist.put("-11.9", new avscience.pda.Integer(-119) );
        
        Clist.put("-12.0", new avscience.pda.Integer(-120) );
        Clist.put("-12.1", new avscience.pda.Integer(-121) );
        Clist.put("-12.2", new avscience.pda.Integer(-122) );
        Clist.put("-12.3", new avscience.pda.Integer(-123) );
        Clist.put("-12.4", new avscience.pda.Integer(-124) );
        Clist.put("-12.5", new avscience.pda.Integer(-125) );
        Clist.put("-12.6", new avscience.pda.Integer(-126) );
        Clist.put("-12.7", new avscience.pda.Integer(-127) );
        Clist.put("-12.8", new avscience.pda.Integer(-128) );
        Clist.put("-12.9", new avscience.pda.Integer(-129) );
        
        Clist.put("-13.0", new avscience.pda.Integer(-130) );
        Clist.put("-13.1", new avscience.pda.Integer(-131) );
        Clist.put("-13.2", new avscience.pda.Integer(-132) );
        Clist.put("-13.3", new avscience.pda.Integer(-133) );
        Clist.put("-13.4", new avscience.pda.Integer(-134) );
        Clist.put("-13.5", new avscience.pda.Integer(-135) );
        Clist.put("-13.6", new avscience.pda.Integer(-136) );
        Clist.put("-13.7", new avscience.pda.Integer(-137) );
        Clist.put("-13.8", new avscience.pda.Integer(-138) );
        Clist.put("-13.9", new avscience.pda.Integer(-139) );
        
        Clist.put("-14.0", new avscience.pda.Integer(-140) );
        Clist.put("-14.1", new avscience.pda.Integer(-141) );
        Clist.put("-14.2", new avscience.pda.Integer(-142) );
        Clist.put("-14.3", new avscience.pda.Integer(-143) );
        Clist.put("-14.4", new avscience.pda.Integer(-144) );
        Clist.put("-14.5", new avscience.pda.Integer(-145) );
        Clist.put("-14.6", new avscience.pda.Integer(-146) );
        Clist.put("-14.7", new avscience.pda.Integer(-147) );
        Clist.put("-14.8", new avscience.pda.Integer(-148) );
        Clist.put("-14.9", new avscience.pda.Integer(-149) );
        
        Clist.put("-15.0", new avscience.pda.Integer(-150) );
        Clist.put("-15.1", new avscience.pda.Integer(-151) );
        Clist.put("-15.2", new avscience.pda.Integer(-152) );
        Clist.put("-15.3", new avscience.pda.Integer(-153) );
        Clist.put("-15.4", new avscience.pda.Integer(-154) );
        Clist.put("-15.5", new avscience.pda.Integer(-155) );
        Clist.put("-15.6", new avscience.pda.Integer(-156) );
        Clist.put("-15.7", new avscience.pda.Integer(-157) );
        Clist.put("-15.8", new avscience.pda.Integer(-158) );
        Clist.put("-15.9", new avscience.pda.Integer(-159) );
        
        Clist.put("-16.0", new avscience.pda.Integer(-160) );
        Clist.put("-16.1", new avscience.pda.Integer(-161) );
        Clist.put("-16.2", new avscience.pda.Integer(-162) );
        Clist.put("-16.3", new avscience.pda.Integer(-163) );
        Clist.put("-16.4", new avscience.pda.Integer(-164) );
        Clist.put("-16.5", new avscience.pda.Integer(-165) );
        Clist.put("-16.6", new avscience.pda.Integer(-166) );
        Clist.put("-16.7", new avscience.pda.Integer(-167) );
        Clist.put("-16.8", new avscience.pda.Integer(-168) );
        Clist.put("-16.9", new avscience.pda.Integer(-169) );
        
        Clist.put("-17.0", new avscience.pda.Integer(-170) );
        Clist.put("-17.1", new avscience.pda.Integer(-171) );
        Clist.put("-17.2", new avscience.pda.Integer(-172) );
        Clist.put("-17.3", new avscience.pda.Integer(-173) );
        Clist.put("-17.4", new avscience.pda.Integer(-174) );
        Clist.put("-17.5", new avscience.pda.Integer(-175) );
        Clist.put("-17.6", new avscience.pda.Integer(-176) );
        Clist.put("-17.7", new avscience.pda.Integer(-177) );
        Clist.put("-17.8", new avscience.pda.Integer(-178) );
        Clist.put("-17.9", new avscience.pda.Integer(-179) );
        
        Clist.put("-18.0", new avscience.pda.Integer(-180) );
        Clist.put("-18.1", new avscience.pda.Integer(-181) );
        Clist.put("-18.2", new avscience.pda.Integer(-182) );
        Clist.put("-18.3", new avscience.pda.Integer(-183) );
        Clist.put("-18.4", new avscience.pda.Integer(-184) );
        Clist.put("-18.5", new avscience.pda.Integer(-185) );
        Clist.put("-18.6", new avscience.pda.Integer(-186) );
        Clist.put("-18.7", new avscience.pda.Integer(-187) );
        Clist.put("-18.8", new avscience.pda.Integer(-188) );
        Clist.put("-18.9", new avscience.pda.Integer(-189) );
        
        Clist.put("-19.0", new avscience.pda.Integer(-190) );
        Clist.put("-19.1", new avscience.pda.Integer(-191) );
        Clist.put("-19.2", new avscience.pda.Integer(-192) );
        Clist.put("-19.3", new avscience.pda.Integer(-193) );
        Clist.put("-19.4", new avscience.pda.Integer(-194) );
        Clist.put("-19.5", new avscience.pda.Integer(-195) );
        Clist.put("-19.6", new avscience.pda.Integer(-196) );
        Clist.put("-19.7", new avscience.pda.Integer(-197) );
        Clist.put("-19.8", new avscience.pda.Integer(-198) );
        Clist.put("-19.9", new avscience.pda.Integer(-199) );
        
        Clist.put("-20.0", new avscience.pda.Integer(-200) );
        Clist.put("-20.1", new avscience.pda.Integer(-201) );
        Clist.put("-20.2", new avscience.pda.Integer(-202) );
        Clist.put("-20.3", new avscience.pda.Integer(-203) );
        Clist.put("-20.4", new avscience.pda.Integer(-204) );
        Clist.put("-20.5", new avscience.pda.Integer(-205) );
        Clist.put("-20.6", new avscience.pda.Integer(-206) );
        Clist.put("-20.7", new avscience.pda.Integer(-207) );
        Clist.put("-20.8", new avscience.pda.Integer(-208) );
        Clist.put("-20.9", new avscience.pda.Integer(-209) );
        
        Clist.put("-21.0", new avscience.pda.Integer(-210) );
        Clist.put("-21.1", new avscience.pda.Integer(-211) );
        Clist.put("-21.2", new avscience.pda.Integer(-212) );
        Clist.put("-21.3", new avscience.pda.Integer(-213) );
        Clist.put("-21.4", new avscience.pda.Integer(-214) );
        Clist.put("-21.5", new avscience.pda.Integer(-215) );
        Clist.put("-21.6", new avscience.pda.Integer(-216) );
        Clist.put("-21.7", new avscience.pda.Integer(-217) );
        Clist.put("-21.8", new avscience.pda.Integer(-218) );
        Clist.put("-21.9", new avscience.pda.Integer(-219) );
        
        Clist.put("-22.0", new avscience.pda.Integer(-220) );
        Clist.put("-22.1", new avscience.pda.Integer(-221) );
        Clist.put("-22.2", new avscience.pda.Integer(-222) );
        Clist.put("-22.3", new avscience.pda.Integer(-223) );
        Clist.put("-22.4", new avscience.pda.Integer(-224) );
        Clist.put("-22.5", new avscience.pda.Integer(-225) );
        Clist.put("-22.6", new avscience.pda.Integer(-226) );
        Clist.put("-22.7", new avscience.pda.Integer(-227) );
        Clist.put("-22.8", new avscience.pda.Integer(-228) );
        Clist.put("-22.9", new avscience.pda.Integer(-229) );
        
        Clist.put("-23.0", new avscience.pda.Integer(-230) );
        Clist.put("-23.1", new avscience.pda.Integer(-231) );
        Clist.put("-23.2", new avscience.pda.Integer(-232) );
        Clist.put("-23.3", new avscience.pda.Integer(-233) );
        Clist.put("-23.4", new avscience.pda.Integer(-234) );
        Clist.put("-23.5", new avscience.pda.Integer(-235) );
        Clist.put("-23.6", new avscience.pda.Integer(-236) );
        Clist.put("-23.7", new avscience.pda.Integer(-237) );
        Clist.put("-23.8", new avscience.pda.Integer(-238) );
        Clist.put("-23.9", new avscience.pda.Integer(-239) );
        
        Clist.put("-24.0", new avscience.pda.Integer(-240) );
        Clist.put("-24.1", new avscience.pda.Integer(-241) );
        Clist.put("-24.2", new avscience.pda.Integer(-242) );
        Clist.put("-24.3", new avscience.pda.Integer(-243) );
        Clist.put("-24.4", new avscience.pda.Integer(-244) );
        Clist.put("-24.5", new avscience.pda.Integer(-245) );
        Clist.put("-24.6", new avscience.pda.Integer(-246) );
        Clist.put("-24.7", new avscience.pda.Integer(-247) );
        Clist.put("-24.8", new avscience.pda.Integer(-248) );
        Clist.put("-24.9", new avscience.pda.Integer(-249) );
        
        Clist.put("-25.0", new avscience.pda.Integer(-250) );
        
        clist.addElement("0.0");
        clist.addElement("-0.1");
        clist.addElement("-0.2");
        clist.addElement("-0.3");
        clist.addElement("-0.4");
        clist.addElement("-0.5");
        clist.addElement("-0.6");
        clist.addElement("-0.7");
        clist.addElement("-0.8");
        clist.addElement("-0.9");
        clist.addElement("-1.0");
        clist.addElement("-1.1");
        clist.addElement("-1.2");
        clist.addElement("-1.3");
        clist.addElement("-1.4");
        clist.addElement("-1.5");
        clist.addElement("-1.6");
        clist.addElement("-1.7");
        clist.addElement("-1.8");
        clist.addElement("-1.9");
        clist.addElement("-2.0");
        clist.addElement("-2.1");
        clist.addElement("-2.2");
        clist.addElement("-2.3");
        clist.addElement("-2.4");
        clist.addElement("-2.5");
        clist.addElement("-2.6");
        clist.addElement("-2.7");
        clist.addElement("-2.8");
        clist.addElement("-2.9");
        clist.addElement("-3.0");
        clist.addElement("-3.1");
        clist.addElement("-3.2");
        clist.addElement("-3.3");
        clist.addElement("-3.4");
        clist.addElement("-3.5");
        clist.addElement("-3.6");
        clist.addElement("-3.7");
        clist.addElement("-3.8");
        clist.addElement("-3.9");
        
        clist.addElement("-4.0");
        clist.addElement("-4.1");
        clist.addElement("-4.2");
        clist.addElement("-4.3");
        clist.addElement("-4.4");
        clist.addElement("-4.5");
        clist.addElement("-4.6");
        clist.addElement("-4.7");
        clist.addElement("-4.8");
        clist.addElement("-4.9");
        
        clist.addElement("-5.0");
        clist.addElement("-5.1");
        clist.addElement("-5.2");
        clist.addElement("-5.3");
        clist.addElement("-5.4");
        clist.addElement("-5.5");
        clist.addElement("-5.6");
        clist.addElement("-5.7");
        clist.addElement("-5.8");
        clist.addElement("-5.9");
        
        clist.addElement("-6.0");
        clist.addElement("-6.1");
        clist.addElement("-6.2");
        clist.addElement("-6.3");
        clist.addElement("-6.4");
        clist.addElement("-6.5");
        clist.addElement("-6.6");
        clist.addElement("-6.7");
        clist.addElement("-6.8");
        clist.addElement("-6.9");
        
        
        clist.addElement("-7.0");
        clist.addElement("-7.1");
        clist.addElement("-7.2");
        clist.addElement("-7.3");
        clist.addElement("-7.4");
        clist.addElement("-7.5");
        clist.addElement("-7.6");
        clist.addElement("-7.7");
        clist.addElement("-7.8");
        clist.addElement("-7.9");
        
        
        clist.addElement("-8.0");
        clist.addElement("-8.1");
        clist.addElement("-8.2");
        clist.addElement("-8.3");
        clist.addElement("-8.4");
        clist.addElement("-8.5");
        clist.addElement("-8.6");
        clist.addElement("-8.7");
        clist.addElement("-8.8");
        clist.addElement("-8.9");
       
        clist.addElement("-9.0");
        clist.addElement("-9.1");
        clist.addElement("-9.2");
        clist.addElement("-9.3");
        clist.addElement("-9.4");
        clist.addElement("-9.6");
        clist.addElement("-9.7");
        clist.addElement("-9.8");
        clist.addElement("-9.9");
        
        clist.addElement("-10.0");
        clist.addElement("-10.1");
        clist.addElement("-10.2");
        clist.addElement("-10.3");
        clist.addElement("-10.4");
        clist.addElement("-10.5");
        clist.addElement("-10.6");
        clist.addElement("-10.7");
        clist.addElement("-10.8");
        clist.addElement("-10.9");
        
        clist.addElement("-11.0");
        clist.addElement("-11.1");
        clist.addElement("-11.2");
        clist.addElement("-11.3");
        clist.addElement("-11.4");
        clist.addElement("-11.5");
        clist.addElement("-11.6");
        clist.addElement("-11.7");
        clist.addElement("-11.8");
        clist.addElement("-11.9");
        
        clist.addElement("-12.0");
        clist.addElement("-12.1");
        clist.addElement("-12.2");
        clist.addElement("-12.3");
        clist.addElement("-12.4");
        clist.addElement("-12.5");
        clist.addElement("-12.6");
        clist.addElement("-12.7");
        clist.addElement("-12.8");
        clist.addElement("-12.9");
        
        clist.addElement("-13.0");
        clist.addElement("-13.1");
        clist.addElement("-13.2");
        clist.addElement("-13.3");
        clist.addElement("-13.4");
        clist.addElement("-13.5");
        clist.addElement("-13.6");
        clist.addElement("-13.7");
        clist.addElement("-13.8");
        clist.addElement("-13.9");
        
        clist.addElement("-14.0");
        clist.addElement("-14.1");
        clist.addElement("-14.2");
        clist.addElement("-14.3");
        clist.addElement("-14.4");
        clist.addElement("-14.5");
        clist.addElement("-14.6");
        clist.addElement("-14.7");
        clist.addElement("-14.8");
        clist.addElement("-14.9");
        
        clist.addElement("-15.0");
        clist.addElement("-15.1");
        clist.addElement("-15.2");
        clist.addElement("-15.3");
        clist.addElement("-15.4");
        clist.addElement("-15.5");
        clist.addElement("-15.6");
        clist.addElement("-15.7");
        clist.addElement("-15.8");
        clist.addElement("-15.9");
        
        clist.addElement("-16.0");
        clist.addElement("-16.1");
        clist.addElement("-16.2");
        clist.addElement("-16.3");
        clist.addElement("-16.4");
        clist.addElement("-16.5");
        clist.addElement("-16.6");
        clist.addElement("-16.7");
        clist.addElement("-16.8");
        clist.addElement("-16.9");
        
        clist.addElement("-17.0");
        clist.addElement("-17.1");
        clist.addElement("-17.2");
        clist.addElement("-17.3");
        clist.addElement("-17.4");
        clist.addElement("-17.5");
        clist.addElement("-17.6");
        clist.addElement("-17.7");
        clist.addElement("-17.8");
        clist.addElement("-17.9");
        
        clist.addElement("-18.0");
        clist.addElement("-18.1");
        clist.addElement("-18.2");
        clist.addElement("-18.3");
        clist.addElement("-18.4");
        clist.addElement("-18.5");
        clist.addElement("-18.6");
        clist.addElement("-18.7");
        clist.addElement("-18.8");
        clist.addElement("-18.9");
        
        clist.addElement("-19.0");
        clist.addElement("-19.1");
        clist.addElement("-19.2");
        clist.addElement("-19.3");
        clist.addElement("-19.4");
        clist.addElement("-19.5");
        clist.addElement("-19.6");
        clist.addElement("-19.7");
        clist.addElement("-19.8");
        clist.addElement("-19.9");
        
        clist.addElement("-20.0");
        clist.addElement("-20.1");
        clist.addElement("-20.2");
        clist.addElement("-20.3");
        clist.addElement("-20.4");
        clist.addElement("-20.5");
        clist.addElement("-20.6");
        clist.addElement("-20.7");
        clist.addElement("-20.8");
        clist.addElement("-20.9");
        
        clist.addElement("-21.0");
        clist.addElement("-21.1");
        clist.addElement("-21.2");
        clist.addElement("-21.3");
        clist.addElement("-21.4");
        clist.addElement("-21.5");
        clist.addElement("-21.6");
        clist.addElement("-21.7");
        clist.addElement("-21.8");
        clist.addElement("-21.9");
        clist.addElement("-22.0");
        clist.addElement("-22.1");
        clist.addElement("-22.2");
        clist.addElement("-22.3");
        clist.addElement("-22.4");
        clist.addElement("-22.5");
        clist.addElement("-22.6");
        clist.addElement("-22.4");
        clist.addElement("-22.7");
        clist.addElement("-22.8");
        clist.addElement("-22.9");
        clist.addElement("-23.0");
        clist.addElement("-23.1");
        clist.addElement("-23.2");
        clist.addElement("-23.3");
        clist.addElement("-23.4");
        clist.addElement("-23.5");
        clist.addElement("-23.6");
        clist.addElement("-23.7");
        clist.addElement("-23.8");
        clist.addElement("-23.9");
        
        clist.addElement("-24.0");
        clist.addElement("-24.1");
        clist.addElement("-24.2");
        clist.addElement("-24.3");
        clist.addElement("-24.4");
        clist.addElement("-24.5");
        clist.addElement("-24.6");
        clist.addElement("-24.7");
        clist.addElement("-24.8");
        clist.addElement("-24.9");
        
        clist.addElement("-25.0");
        
        Flist = new Hashtable();
        Flist.put("32", new avscience.pda.Integer(32));
        Flist.put("31", new avscience.pda.Integer(31));
        Flist.put("30", new avscience.pda.Integer(30));
        Flist.put("29", new avscience.pda.Integer(29));
        Flist.put("28", new avscience.pda.Integer(28));
        Flist.put("27", new avscience.pda.Integer(27));
        Flist.put("26", new avscience.pda.Integer(26));
        Flist.put("25", new avscience.pda.Integer(25));
        Flist.put("24", new avscience.pda.Integer(24));
        Flist.put("23", new avscience.pda.Integer(23));
        Flist.put("22", new avscience.pda.Integer(22));
        Flist.put("21", new avscience.pda.Integer(21));
        Flist.put("20", new avscience.pda.Integer(20));
        Flist.put("19", new avscience.pda.Integer(19));
        Flist.put("18", new avscience.pda.Integer(18));
        Flist.put("17", new avscience.pda.Integer(17));
        Flist.put("16", new avscience.pda.Integer(16));
        Flist.put("15", new avscience.pda.Integer(15));
        Flist.put("14", new avscience.pda.Integer(14));
        Flist.put("13", new avscience.pda.Integer(13));
        Flist.put("12", new avscience.pda.Integer(12));
        Flist.put("11", new avscience.pda.Integer(11));
        Flist.put("10", new avscience.pda.Integer(10));
        Flist.put("9", new avscience.pda.Integer(9));
        Flist.put("8", new avscience.pda.Integer(8));
        Flist.put("7", new avscience.pda.Integer(7));
        Flist.put("6", new avscience.pda.Integer(6));
        Flist.put("5", new avscience.pda.Integer(5));
        Flist.put("4", new avscience.pda.Integer(4));
        Flist.put("3", new avscience.pda.Integer(3));
        Flist.put("2", new avscience.pda.Integer(2));
        Flist.put("1", new avscience.pda.Integer(1));
        Flist.put("0", new avscience.pda.Integer(0));
        Flist.put("-1", new avscience.pda.Integer(-1));
        Flist.put("-2", new avscience.pda.Integer(-2));
        Flist.put("-3", new avscience.pda.Integer(-3));
        Flist.put("-4", new avscience.pda.Integer(-4));
        Flist.put("-5", new avscience.pda.Integer(-5));
        Flist.put("-6", new avscience.pda.Integer(-6));
        Flist.put("-7", new avscience.pda.Integer(-7));
        Flist.put("-8", new avscience.pda.Integer(-8));
        Flist.put("-9", new avscience.pda.Integer(-9));
        Flist.put("-10", new avscience.pda.Integer(-10));
        Flist.put("-15", new avscience.pda.Integer(-15));
        
        
        flist.addElement("32");
        flist.addElement("31");
        flist.addElement("30");
        flist.addElement("29");
        flist.addElement("28");
        flist.addElement("27");
        flist.addElement("26");
        flist.addElement("25");
        flist.addElement("24");
        flist.addElement("23");
        flist.addElement("22");
        flist.addElement("21");
        flist.addElement("20");
        flist.addElement("19");
        flist.addElement("18");
        flist.addElement("17");
        flist.addElement("16");
        flist.addElement("15");
        flist.addElement("14");
        flist.addElement("13");
        flist.addElement("12");
        flist.addElement("11");
        flist.addElement("10");
        flist.addElement("9");
        flist.addElement("8");
        flist.addElement("7");
        flist.addElement("6");
        flist.addElement("5");
        flist.addElement("4");
        flist.addElement("3");
        flist.addElement("2");
        flist.addElement("1");
        flist.addElement("0");
        flist.addElement("-1");
        flist.addElement("-2");
        flist.addElement("-3");
        flist.addElement("-4");
        flist.addElement("-5");
        flist.addElement("-6");
        flist.addElement("-7");
        flist.addElement("-8");
        flist.addElement("-9");
        flist.addElement("-10");
        flist.addElement("-15");
        
        Enumeration strings = Clist.keys();
        Enumeration temps = Clist.elements();
        
        while ( strings.hasMoreElements() && temps.hasMoreElements() )
        {
            avscience.pda.Integer I = (avscience.pda.Integer) temps.nextElement();
            String s = (String) strings.nextElement();
            ClistInv.put(I, s);
        }
        
        strings = Flist.keys();
        temps = Flist.elements();
        
        while ( strings.hasMoreElements() && temps.hasMoreElements() )
        {
            avscience.pda.Integer I = (avscience.pda.Integer) temps.nextElement();
            String s = (String) strings.nextElement();
            FlistInv.put(I, s);
        }
     
    }
    
    public String getTempString(String units, int temp)
    {
        avscience.pda.Integer I = new avscience.pda.Integer(temp);
        Hashtable h = null;
        units = units.trim();
        if (units.equals("C") ) h = ClistInv;
        if (units.equals("F") ) h = FlistInv;
        
        String s = (String) h.get(I);
        return s;
        
    }
    
    public int getTemp(String units, String temp)
    {
        avscience.pda.Integer I = null;
        int i = -1;
        Hashtable h = null;
        units = units.trim();
        if (units.equals("C") ) h = Clist;
        if (units.equals("F") ) h = Flist;
        
        if (h != null) I = (avscience.pda.Integer) h.get(temp);
        if (I != null) i = I.intValue();
        return i;
    }
    
    public String[] getList(String units)
    {
        units = units.trim();
        Vector list = null;
        if ( units.equals("F") ) list = flist;
        else list = clist;
        String[] List = new String[list.size()];
        int i = 0;
        
        Enumeration temps = list.elements();
        while ( temps.hasMoreElements() )
        {
            List[i] = (String) temps.nextElement();
            i++;
        }
        return List;
    }
}