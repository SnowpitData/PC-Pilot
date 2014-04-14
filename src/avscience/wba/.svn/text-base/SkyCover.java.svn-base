/*    */ package avscience.wba;

		 import java.util.Hashtable;
/*    */ 
/*    */ public final class SkyCover
/*    */   implements DataTable
/*    */ {
/*  6 */   private static final SkyCover instance = new SkyCover();
/*    */   private String[] codes;
/*    */   private String[] descriptions;
/*  9 */   private int size = 6;
		   private Hashtable codesDesc = new Hashtable(size);
/*    */ 
/*    */   public static SkyCover getInstance()
/*    */   {
/* 17 */     return instance;
/*    */   }
/*    */ 
/*    */   private SkyCover()
/*    */   {
/* 23 */     init();
/*    */   }
/*    */ 
/*    */   private void init()
/*    */   {
/* 28 */     this.codes = new String[this.size];
/* 29 */     this.descriptions = new String[this.size];
/*    */ 
/* 31 */     this.codes[0] = "Clear";
/* 32 */     this.descriptions[0] = "Clear";
			 codesDesc.put("CLR", this.descriptions[0]);
/*    */ 
/* 34 */     this.codes[1] = "Few";
/* 35 */     this.descriptions[1] = "sky < 2/8 covered";
			 codesDesc.put("FEW", this.descriptions[1]);
/*    */ 
/* 37 */     this.codes[2] = "Scattered";
/* 38 */     this.descriptions[2] = "sky 3/8 to 4/8 covered";
             codesDesc.put("SCT", this.descriptions[2]);
/*    */ 
/* 40 */     this.codes[3] = "Broken";
/* 41 */     this.descriptions[3] = "sky 4/8 to 8/8 covered";
			 codesDesc.put("BKN", this.descriptions[3]);
/*    */ 
/* 43 */     this.codes[4] = "Overcast";
/* 44 */     this.descriptions[4] = "sky 8/8 covered";
			 codesDesc.put("OVC", this.descriptions[4]);
/*    */ 
/* 46 */     this.codes[5] = "Obscured";
/* 47 */     this.descriptions[5] = "Fog";
             codesDesc.put("X", this.descriptions[5]);
/*    */   }
/*    */ 
/*    */   public String[] getCodes()
/*    */   {
/* 52 */     return this.codes;
/*    */   }
/*    */ 
/*    */   public String[] getDescriptions()
/*    */   {
/* 57 */     return this.descriptions;
/*    */   }
			
			public String getDescription(String code)
			{
				Object o = codesDesc.get(code);
				if (o!=null)return o.toString();
				else return null;
			}


/*    */ }
