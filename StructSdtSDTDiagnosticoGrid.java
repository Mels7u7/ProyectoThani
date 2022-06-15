package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTDiagnosticoGrid implements Cloneable, java.io.Serializable
{
   public StructSdtSDTDiagnosticoGrid( )
   {
      this( -1, new ModelContext( StructSdtSDTDiagnosticoGrid.class ));
   }

   public StructSdtSDTDiagnosticoGrid( int remoteHandle ,
                                       ModelContext context )
   {
      gxTv_SdtSDTDiagnosticoGrid_Diagnosticodescripcion = "" ;
      gxTv_SdtSDTDiagnosticoGrid_Diagnosticocodigo = "" ;
      gxTv_SdtSDTDiagnosticoGrid_Diagnosticolongdesc = "" ;
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

   public int getDiagnosticoid( )
   {
      return gxTv_SdtSDTDiagnosticoGrid_Diagnosticoid ;
   }

   public void setDiagnosticoid( int value )
   {
      gxTv_SdtSDTDiagnosticoGrid_N = (byte)(0) ;
      gxTv_SdtSDTDiagnosticoGrid_Diagnosticoid = value ;
   }

   public String getDiagnosticodescripcion( )
   {
      return gxTv_SdtSDTDiagnosticoGrid_Diagnosticodescripcion ;
   }

   public void setDiagnosticodescripcion( String value )
   {
      gxTv_SdtSDTDiagnosticoGrid_N = (byte)(0) ;
      gxTv_SdtSDTDiagnosticoGrid_Diagnosticodescripcion = value ;
   }

   public String getDiagnosticocodigo( )
   {
      return gxTv_SdtSDTDiagnosticoGrid_Diagnosticocodigo ;
   }

   public void setDiagnosticocodigo( String value )
   {
      gxTv_SdtSDTDiagnosticoGrid_N = (byte)(0) ;
      gxTv_SdtSDTDiagnosticoGrid_Diagnosticocodigo = value ;
   }

   public String getDiagnosticolongdesc( )
   {
      return gxTv_SdtSDTDiagnosticoGrid_Diagnosticolongdesc ;
   }

   public void setDiagnosticolongdesc( String value )
   {
      gxTv_SdtSDTDiagnosticoGrid_N = (byte)(0) ;
      gxTv_SdtSDTDiagnosticoGrid_Diagnosticolongdesc = value ;
   }

   protected byte gxTv_SdtSDTDiagnosticoGrid_N ;
   protected int gxTv_SdtSDTDiagnosticoGrid_Diagnosticoid ;
   protected String gxTv_SdtSDTDiagnosticoGrid_Diagnosticodescripcion ;
   protected String gxTv_SdtSDTDiagnosticoGrid_Diagnosticocodigo ;
   protected String gxTv_SdtSDTDiagnosticoGrid_Diagnosticolongdesc ;
}

