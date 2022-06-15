package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTGanancias implements Cloneable, java.io.Serializable
{
   public StructSdtSDTGanancias( )
   {
      this( -1, new ModelContext( StructSdtSDTGanancias.class ));
   }

   public StructSdtSDTGanancias( int remoteHandle ,
                                 ModelContext context )
   {
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

   public int getId( )
   {
      return gxTv_SdtSDTGanancias_Id ;
   }

   public void setId( int value )
   {
      gxTv_SdtSDTGanancias_N = (byte)(0) ;
      gxTv_SdtSDTGanancias_Id = value ;
   }

   protected byte gxTv_SdtSDTGanancias_N ;
   protected int gxTv_SdtSDTGanancias_Id ;
}

