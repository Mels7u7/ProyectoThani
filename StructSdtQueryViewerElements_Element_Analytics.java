package com.projectthani ;
import com.genexus.*;

public final  class StructSdtQueryViewerElements_Element_Analytics implements Cloneable, java.io.Serializable
{
   public StructSdtQueryViewerElements_Element_Analytics( )
   {
      this( -1, new ModelContext( StructSdtQueryViewerElements_Element_Analytics.class ));
   }

   public StructSdtQueryViewerElements_Element_Analytics( int remoteHandle ,
                                                          ModelContext context )
   {
      gxTv_SdtQueryViewerElements_Element_Analytics_Showvaluesas = "NoCalculation" ;
      gxTv_SdtQueryViewerElements_Element_Analytics_Rollingaveragetype = "Simple" ;
      gxTv_SdtQueryViewerElements_Element_Analytics_Differencefrom = "PreviousValue" ;
      gxTv_SdtQueryViewerElements_Element_Analytics_Showaspercentage = "No" ;
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

   public String getShowvaluesas( )
   {
      return gxTv_SdtQueryViewerElements_Element_Analytics_Showvaluesas ;
   }

   public void setShowvaluesas( String value )
   {
      gxTv_SdtQueryViewerElements_Element_Analytics_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Analytics_Showvaluesas = value ;
   }

   public String getRollingaveragetype( )
   {
      return gxTv_SdtQueryViewerElements_Element_Analytics_Rollingaveragetype ;
   }

   public void setRollingaveragetype( String value )
   {
      gxTv_SdtQueryViewerElements_Element_Analytics_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Analytics_Rollingaveragetype = value ;
   }

   public short getRollingaverageterms( )
   {
      return gxTv_SdtQueryViewerElements_Element_Analytics_Rollingaverageterms ;
   }

   public void setRollingaverageterms( short value )
   {
      gxTv_SdtQueryViewerElements_Element_Analytics_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Analytics_Rollingaverageterms = value ;
   }

   public String getDifferencefrom( )
   {
      return gxTv_SdtQueryViewerElements_Element_Analytics_Differencefrom ;
   }

   public void setDifferencefrom( String value )
   {
      gxTv_SdtQueryViewerElements_Element_Analytics_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Analytics_Differencefrom = value ;
   }

   public String getShowaspercentage( )
   {
      return gxTv_SdtQueryViewerElements_Element_Analytics_Showaspercentage ;
   }

   public void setShowaspercentage( String value )
   {
      gxTv_SdtQueryViewerElements_Element_Analytics_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Analytics_Showaspercentage = value ;
   }

   protected byte gxTv_SdtQueryViewerElements_Element_Analytics_N ;
   protected short gxTv_SdtQueryViewerElements_Element_Analytics_Rollingaverageterms ;
   protected String gxTv_SdtQueryViewerElements_Element_Analytics_Showvaluesas ;
   protected String gxTv_SdtQueryViewerElements_Element_Analytics_Rollingaveragetype ;
   protected String gxTv_SdtQueryViewerElements_Element_Analytics_Differencefrom ;
   protected String gxTv_SdtQueryViewerElements_Element_Analytics_Showaspercentage ;
}

