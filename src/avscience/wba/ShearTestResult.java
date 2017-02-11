package avscience.wba;
import waba.util.Date;
import waba.sys.Time;

public class ShearTestResult extends AvScienceDataObject
{
    private String code;
    private String score = "";
    private String quality = "";
    private String sdepth = "";
    private String depthUnits= "";
    private String comments = " ";
    private String dateString = "";
    private String ctScore = "";
    private String ecScore = "";
    private String dtScore = "";
    private String s;
    
    public ShearTestResult(String data)
    {
    	this();
    	popFromString(data);
    	setAttributes();
    }
    
    
    
    public void setComments(String comments)
    {
    	this.comments=comments;
    }
    
    public ShearTestResult() {super();}
    
    public ShearTestResult(String code, String score, String quality, String sdepth, String depthUnits, String comments, String ctScore, String dtScore,String ecScore)
    {
        this.code = score.substring(0, 2);
        this.score = score;
        this.quality = quality;
        this.sdepth = sdepth;
        this.depthUnits = depthUnits;
        this.comments = comments;
        this.ctScore = ctScore;
        this.dtScore = dtScore;
        this.ecScore = ecScore;
        Date date = new Date();
        Time time = new Time();
        int hour = time.hour;
        int min = time.minute;
        int sec = time.second;
        int yr = date.getYear();
        int mnth = date.getMonth();
        int day = date.getDay();
       	dateString = mnth+"/"+day+"/"+yr;
        s = score + " " + quality + " " + sdepth + " " + dateString + "." + hour + ":" + min+ ":"+sec;
    }
    
    public String getComments()
    {
        if ( comments != null ) return comments;
        else return " ";
    }
    
    public String getDepth()
    {
        return sdepth;
    }
    
    public int getDepthValue()
    {
        int v = 0;
        v = StringNumConvertor.getInstance().getNumFromDisplayString(sdepth);
        return v;
    }
    
    public String getDepthUnits()
    {
        return depthUnits;
    }
    
    public String getQuality()
    {
        return quality;
    }
    
    public String getScore()
    {
        return score;
    }
    
    public String toString()
    {
    	return s;
    }
    
    public String getCode()
    {
        return code;
    }
    
    public String getCTScore()
    {
    	return ctScore;
    }
    
    public String getDTScore()
    {
    	return dtScore;
    }
    
    public String getECScore()
    {
    	return ecScore;
    }
    
    public void setAttributes()
    {
    	attributes.put("s", s);
    	attributes.put("code", code);
    	attributes.put("score", score);
    	attributes.put("ctScore", ctScore);
        attributes.put("dtScore", dtScore);
    	attributes.put("ecScore", ecScore);
    	attributes.put("quality", quality);
    	attributes.put("sdepth", sdepth);
    	attributes.put("depthUnits", depthUnits);
    	attributes.put("comments", comments);
    	attributes.put("dateString", dateString);
    }
    
    public void getAttributes()
    { 
    	s = (String) attributes.get("s");
    	code = (String) attributes.get("code");
    	score = (String) attributes.get("score");
    	ctScore = (String) attributes.get("ctScore");
    	ecScore = (String) attributes.get("ecScore");
        dtScore = (String) attributes.get("dtScore");
    	quality = (String) attributes.get("quality");
    	sdepth = (String) attributes.get("sdepth");
    	depthUnits = (String) attributes.get("depthUnits");
    	comments = (String) attributes.get("comments");
    	dateString = (String) attributes.get("dateString");
    }
    
    public String getKey()
    {
        return new String("6");
    }
    
    
}