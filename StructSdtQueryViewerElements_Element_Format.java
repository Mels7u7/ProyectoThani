package com.projectthani ;
import com.genexus.*;

public final  class StructSdtQueryViewerElements_Element_Format implements Cloneable, java.io.Serializable
{
   public StructSdtQueryViewerElements_Element_Format( )
   {
      this( -1, new ModelContext( StructSdtQueryViewerElements_Element_Format.class ));
   }

   public StructSdtQueryViewerElements_Element_Format( int remoteHandle ,
                                                       ModelContext context )
   {
      gxTv_SdtQueryViewerElements_Element_Format_Picture = "" ;
      gxTv_SdtQueryViewerElements_Element_Format_Subtotals = "" ;
      gxTv_SdtQueryViewerElements_Element_Format_Candragtopages = true ;
      gxTv_SdtQueryViewerElements_Element_Format_Style = "" ;
      gxTv_SdtQueryViewerElements_Element_Format_Targetvalue = new java.math.BigDecimal(0) ;
      gxTv_SdtQueryViewerElements_Element_Format_Maximumvalue = new java.math.BigDecimal(0) ;
      gxTv_SdtQueryViewerElements_Element_Format_Valuesstyles_N = (byte)(1) ;
      gxTv_SdtQueryViewerElements_Element_Format_Conditionalstyles_N = (byte)(1) ;
   }

   public Object clone()
   {
      Object cloned = null;
      try
      {
         cloned = super.clone();
      }catch (CloneNotSupportedException e){ ; }
      return cloned;
   }

   public String getPicture( )
   {
      return gxTv_SdtQueryViewerElements_Element_Format_Picture ;
   }

   public void setPicture( String value )
   {
      gxTv_SdtQueryViewerElements_Element_Format_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Format_Picture = value ;
   }

   public String getSubtotals( )
   {
      return gxTv_SdtQueryViewerElements_Element_Format_Subtotals ;
   }

   public void setSubtotals( String value )
   {
      gxTv_SdtQueryViewerElements_Element_Format_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Format_Subtotals = value ;
   }

   public boolean getCandragtopages( )
   {
      return gxTv_SdtQueryViewerElements_Element_Format_Candragtopages ;
   }

   public void setCandragtopages( boolean value )
   {
      gxTv_SdtQueryViewerElements_Element_Format_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Format_Candragtopages = value ;
   }

   public String getStyle( )
   {
      return gxTv_SdtQueryViewerElements_Element_Format_Style ;
   }

   public void setStyle( String value )
   {
      gxTv_SdtQueryViewerElements_Element_Format_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Format_Style = value ;
   }

   public java.math.BigDecimal getTargetvalue( )
   {
      return gxTv_SdtQueryViewerElements_Element_Format_Targetvalue ;
   }

   public void setTargetvalue( java.math.BigDecimal value )
   {
      gxTv_SdtQueryViewerElements_Element_Format_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Format_Targetvalue = value ;
   }

   public java.math.BigDecimal getMaximumvalue( )
   {
      return gxTv_SdtQueryViewerElements_Element_Format_Maximumvalue ;
   }

   public void setMaximumvalue( java.math.BigDecimal value )
   {
      gxTv_SdtQueryViewerElements_Element_Format_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Format_Maximumvalue = value ;
   }

   public java.util.Vector<com.projectthani.StructSdtQueryViewerElements_Element_Format_ValueStyle> getValuesstyles( )
   {
      return gxTv_SdtQueryViewerElements_Element_Format_Valuesstyles ;
   }

   public void setValuesstyles( java.util.Vector<com.projectthani.StructSdtQueryViewerElements_Element_Format_ValueStyle> value )
   {
      gxTv_SdtQueryViewerElements_Element_Format_Valuesstyles_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Format_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Format_Valuesstyles = value ;
   }

   public java.util.Vector<com.projectthani.StructSdtQueryViewerElements_Element_Format_ConditionalStyle> getConditionalstyles( )
   {
      return gxTv_SdtQueryViewerElements_Element_Format_Conditionalstyles ;
   }

   public void setConditionalstyles( java.util.Vector<com.projectthani.StructSdtQueryViewerElements_Element_Format_ConditionalStyle> value )
   {
      gxTv_SdtQueryViewerElements_Element_Format_Conditionalstyles_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Format_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Format_Conditionalstyles = value ;
   }

   protected byte gxTv_SdtQueryViewerElements_Element_Format_Valuesstyles_N ;
   protected byte gxTv_SdtQueryViewerElements_Element_Format_Conditionalstyles_N ;
   protected byte gxTv_SdtQueryViewerElements_Element_Format_N ;
   protected String gxTv_SdtQueryViewerElements_Element_Format_Picture ;
   protected String gxTv_SdtQueryViewerElements_Element_Format_Subtotals ;
   protected String gxTv_SdtQueryViewerElements_Element_Format_Style ;
   protected boolean gxTv_SdtQueryViewerElements_Element_Format_Candragtopages ;
   protected java.math.BigDecimal gxTv_SdtQueryViewerElements_Element_Format_Targetvalue ;
   protected java.math.BigDecimal gxTv_SdtQueryViewerElements_Element_Format_Maximumvalue ;
   protected java.util.Vector<com.projectthani.StructSdtQueryViewerElements_Element_Format_ValueStyle> gxTv_SdtQueryViewerElements_Element_Format_Valuesstyles=null ;
   protected java.util.Vector<com.projectthani.StructSdtQueryViewerElements_Element_Format_ConditionalStyle> gxTv_SdtQueryViewerElements_Element_Format_Conditionalstyles=null ;
}

