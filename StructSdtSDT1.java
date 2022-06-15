package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDT1 implements Cloneable, java.io.Serializable
{
   public StructSdtSDT1( )
   {
      this( -1, new ModelContext( StructSdtSDT1.class ));
   }

   public StructSdtSDT1( int remoteHandle ,
                         ModelContext context )
   {
      gxTv_SdtSDT1_Link = "" ;
      gxTv_SdtSDT1_Descripcion = "" ;
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

   public String getLink( )
   {
      return gxTv_SdtSDT1_Link ;
   }

   public void setLink( String value )
   {
      gxTv_SdtSDT1_N = (byte)(0) ;
      gxTv_SdtSDT1_Link = value ;
   }

   public String getDescripcion( )
   {
      return gxTv_SdtSDT1_Descripcion ;
   }

   public void setDescripcion( String value )
   {
      gxTv_SdtSDT1_N = (byte)(0) ;
      gxTv_SdtSDT1_Descripcion = value ;
   }

   protected byte gxTv_SdtSDT1_N ;
   protected String gxTv_SdtSDT1_Link ;
   protected String gxTv_SdtSDT1_Descripcion ;
}

