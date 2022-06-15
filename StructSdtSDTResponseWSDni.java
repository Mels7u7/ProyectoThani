package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTResponseWSDni implements Cloneable, java.io.Serializable
{
   public StructSdtSDTResponseWSDni( )
   {
      this( -1, new ModelContext( StructSdtSDTResponseWSDni.class ));
   }

   public StructSdtSDTResponseWSDni( int remoteHandle ,
                                     ModelContext context )
   {
      gxTv_SdtSDTResponseWSDni_Data_N = (byte)(1) ;
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

   public boolean getSuccess( )
   {
      return gxTv_SdtSDTResponseWSDni_Success ;
   }

   public void setSuccess( boolean value )
   {
      gxTv_SdtSDTResponseWSDni_N = (byte)(0) ;
      gxTv_SdtSDTResponseWSDni_Success = value ;
   }

   public com.projectthani.StructSdtSDTResponseDni getData( )
   {
      return gxTv_SdtSDTResponseWSDni_Data ;
   }

   public void setData( com.projectthani.StructSdtSDTResponseDni value )
   {
      gxTv_SdtSDTResponseWSDni_Data_N = (byte)(0) ;
      gxTv_SdtSDTResponseWSDni_N = (byte)(0) ;
      gxTv_SdtSDTResponseWSDni_Data = value;
   }

   protected byte gxTv_SdtSDTResponseWSDni_Data_N ;
   protected byte gxTv_SdtSDTResponseWSDni_N ;
   protected boolean gxTv_SdtSDTResponseWSDni_Success ;
   protected com.projectthani.StructSdtSDTResponseDni gxTv_SdtSDTResponseWSDni_Data=null ;
}

