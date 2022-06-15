package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTCountPaciente implements Cloneable, java.io.Serializable
{
   public StructSdtSDTCountPaciente( )
   {
      this( -1, new ModelContext( StructSdtSDTCountPaciente.class ));
   }

   public StructSdtSDTCountPaciente( int remoteHandle ,
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
      return gxTv_SdtSDTCountPaciente_Id ;
   }

   public void setId( int value )
   {
      gxTv_SdtSDTCountPaciente_N = (byte)(0) ;
      gxTv_SdtSDTCountPaciente_Id = value ;
   }

   public short getIddis( )
   {
      return gxTv_SdtSDTCountPaciente_Iddis ;
   }

   public void setIddis( short value )
   {
      gxTv_SdtSDTCountPaciente_N = (byte)(0) ;
      gxTv_SdtSDTCountPaciente_Iddis = value ;
   }

   protected byte gxTv_SdtSDTCountPaciente_N ;
   protected short gxTv_SdtSDTCountPaciente_Iddis ;
   protected int gxTv_SdtSDTCountPaciente_Id ;
}

