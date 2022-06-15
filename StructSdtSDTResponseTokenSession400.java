package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTResponseTokenSession400 implements Cloneable, java.io.Serializable
{
   public StructSdtSDTResponseTokenSession400( )
   {
      this( -1, new ModelContext( StructSdtSDTResponseTokenSession400.class ));
   }

   public StructSdtSDTResponseTokenSession400( int remoteHandle ,
                                               ModelContext context )
   {
      gxTv_SdtSDTResponseTokenSession400_Errormessage = "" ;
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

   public short getErrorcode( )
   {
      return gxTv_SdtSDTResponseTokenSession400_Errorcode ;
   }

   public void setErrorcode( short value )
   {
      gxTv_SdtSDTResponseTokenSession400_N = (byte)(0) ;
      gxTv_SdtSDTResponseTokenSession400_Errorcode = value ;
   }

   public String getErrormessage( )
   {
      return gxTv_SdtSDTResponseTokenSession400_Errormessage ;
   }

   public void setErrormessage( String value )
   {
      gxTv_SdtSDTResponseTokenSession400_N = (byte)(0) ;
      gxTv_SdtSDTResponseTokenSession400_Errormessage = value ;
   }

   protected byte gxTv_SdtSDTResponseTokenSession400_N ;
   protected short gxTv_SdtSDTResponseTokenSession400_Errorcode ;
   protected String gxTv_SdtSDTResponseTokenSession400_Errormessage ;
}

