/*    */ package avscience.pc;
/*    */ 
/*    */ import avscience.desktop.GrainTypeSymbols;
/*    */ import java.awt.Canvas;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class TypeDisplay extends Canvas
/*    */ {
/*    */   String type;
/*    */ 
/*    */   public TypeDisplay()
/*    */   {
/*  7 */     this.type = "";
/*    */ 
/* 13 */     setSize(30, 24);
/* 14 */     setVisible(true);
/*    */   }
/*    */ 
/*    */   public TypeDisplay(String paramString)
/*    */   {
/* 20 */     this.type = paramString;
/*    */ 
/* 23 */     setSize(24, 24);
/* 24 */     setVisible(true);
/*    */   }
/*    */ 
/*    */   public static void main(String[] paramArrayOfString)
/*    */   {
/* 29 */     new TypeDisplay().setVisible(true);
/*    */   }
/*    */ 
/*    */   public void paint(Graphics paramGraphics)
/*    */   {
/* 34 */     GrainTypeSymbols localGrainTypeSymbols = GrainTypeSymbols.getInstance(paramGraphics);
/* 35 */     localGrainTypeSymbols.drawSymbol(1, 1, this.type);
/*    */   }
/*    */ 
/*    */   public String getType()
/*    */   {
/* 40 */     return this.type;
/*    */   }
/*    */ 
/*    */   public void setType(String paramString)
/*    */   {
/* 45 */     this.type = paramString;
/*    */   }
/*    */ }

/* Location:           C:\PC-Pilot-build\
 * Qualified Name:     avscience.pc.TypeDisplay
 * JD-Core Version:    0.5.3
 */