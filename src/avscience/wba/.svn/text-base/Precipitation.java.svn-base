/*    */ package avscience.wba;

		 import java.util.Hashtable;
/*    */ 
/*    */ public final class Precipitation
/*    */   implements DataTable
/*    */ {
/*  6 */   private static final Precipitation instance = new Precipitation();
/*    */   private String[] codes;
/*    */   private String[] descriptions;
/*  9 */   private int size = 13;
		   private Hashtable codesDesc = new Hashtable(size);
/*    */ 
/*    */   public static Precipitation getInstance()
/*    */   {
/* 17 */     return instance;
/*    */   }
/*    */ 
/*    */   private Precipitation()
/*    */   {
/* 22 */     init();
/*    */   }
/*    */ 
/*    */   private void init()
/*    */   {
/* 27 */     this.codes = new String[this.size];
/* 28 */     this.descriptions = new String[this.size];
/*    */ 
/* 30 */     this.codes[0] = " ";
/* 31 */     this.descriptions[0] = " ";
             codesDesc.put(codes[0], descriptions[0]);
/*    */ 
/* 33 */     this.codes[1] = "NIL";
/* 34 */     this.descriptions[1] = "None";
			 codesDesc.put(codes[1], descriptions[1]);
/*    */ 
/* 36 */     this.codes[2] = "S-1";
/* 37 */     this.descriptions[2] = "Snow < 0.5 cm/hr";
			 codesDesc.put(codes[2], descriptions[2]);
/*    */ 
/* 39 */     this.codes[3] = "S1";
/* 40 */     this.descriptions[3] = "Snow - 1 cm/hr";
             codesDesc.put(codes[3], descriptions[3]);
/*    */ 
/* 42 */     this.codes[4] = "S2";
/* 43 */     this.descriptions[4] = "Snow - 2 cm/hr";
			 codesDesc.put(codes[4], descriptions[4]);
/*    */ 
/* 45 */     this.codes[5] = "S5";
/* 46 */     this.descriptions[5] = "Snow - 5 cm/hr";
			 codesDesc.put(codes[5], descriptions[5]);
/*    */ 
/* 48 */     this.codes[6] = "S10";
/* 49 */     this.descriptions[6] = "Snow - 10 cm/hr";
			 codesDesc.put(codes[6], descriptions[6]);
/*    */ 
/* 51 */     this.codes[7] = "G";
/* 52 */     this.descriptions[7] = "Graupel or hail";
             codesDesc.put(codes[7], descriptions[7]);
/*    */ 
/* 54 */     this.codes[8] = "RS";
/* 55 */     this.descriptions[8] = "Mixed rain and snow";
             codesDesc.put(codes[8], descriptions[8]);
/*    */ 
/* 57 */     this.codes[9] = "RV";
/* 58 */     this.descriptions[9] = "Very light rain - mist";
             codesDesc.put(codes[9], descriptions[9]);
/*    */ 
/* 60 */     this.codes[10] = "RL";
/* 61 */     this.descriptions[10] = "Light Rain < 2.5mm/hr";
			 codesDesc.put(codes[10], descriptions[10]);
/*    */ 
/* 63 */     this.codes[11] = "RM";
/* 64 */     this.descriptions[11] = "Moderate rain < 7.5mm/hr";
			 codesDesc.put(codes[11], descriptions[11]);
/*    */ 
/* 66 */     this.codes[12] = "RH";
/* 67 */     this.descriptions[12] = "Heavy Rain > 7.5mm/hr";
			 codesDesc.put(codes[12], descriptions[12]);
/*    */   }
/*    */ 
/*    */   public String[] getCodes()
/*    */   {
/* 73 */     return this.codes;
/*    */   }
/*    */ 
/*    */   public String[] getDescriptions()
/*    */   {
/* 78 */     return this.descriptions;
/*    */   }

		   public String getDescription(String code )
		   {
		   		code = code.trim();
		   		Object o = codesDesc.get(code);
		   		if (o!=null) return o.toString();
		   		else return null;
		   }
/*    */ }

/* Location:           C:\PC-Pilot-build\
 * Qualified Name:     avscience.wba.Precipitation
 * JD-Core Version:    0.5.3
 */