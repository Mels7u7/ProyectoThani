package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTIdPacientes implements Cloneable, java.io.Serializable
{
   public StructSdtSDTIdPacientes( )
   {
      this( -1, new ModelContext( StructSdtSDTIdPacientes.class ));
   }

   public StructSdtSDTIdPacientes( int remoteHandle ,
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

   public int getPacienteid( )
   {
      return gxTv_SdtSDTIdPacientes_Pacienteid ;
   }

   public void setPacienteid( int value )
   {
      gxTv_SdtSDTIdPacientes_N = (byte)(0) ;
      gxTv_SdtSDTIdPacientes_Pacienteid = value ;
   }

   protected byte gxTv_SdtSDTIdPacientes_N ;
   protected int gxTv_SdtSDTIdPacientes_Pacienteid ;
}

