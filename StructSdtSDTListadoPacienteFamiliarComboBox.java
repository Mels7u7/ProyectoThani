package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTListadoPacienteFamiliarComboBox implements Cloneable, java.io.Serializable
{
   public StructSdtSDTListadoPacienteFamiliarComboBox( )
   {
      this( -1, new ModelContext( StructSdtSDTListadoPacienteFamiliarComboBox.class ));
   }

   public StructSdtSDTListadoPacienteFamiliarComboBox( int remoteHandle ,
                                                       ModelContext context )
   {
      gxTv_SdtSDTListadoPacienteFamiliarComboBox_Nombresapellidos = "" ;
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

   public int getPacientefamiliarid( )
   {
      return gxTv_SdtSDTListadoPacienteFamiliarComboBox_Pacientefamiliarid ;
   }

   public void setPacientefamiliarid( int value )
   {
      gxTv_SdtSDTListadoPacienteFamiliarComboBox_N = (byte)(0) ;
      gxTv_SdtSDTListadoPacienteFamiliarComboBox_Pacientefamiliarid = value ;
   }

   public String getNombresapellidos( )
   {
      return gxTv_SdtSDTListadoPacienteFamiliarComboBox_Nombresapellidos ;
   }

   public void setNombresapellidos( String value )
   {
      gxTv_SdtSDTListadoPacienteFamiliarComboBox_N = (byte)(0) ;
      gxTv_SdtSDTListadoPacienteFamiliarComboBox_Nombresapellidos = value ;
   }

   protected byte gxTv_SdtSDTListadoPacienteFamiliarComboBox_N ;
   protected int gxTv_SdtSDTListadoPacienteFamiliarComboBox_Pacientefamiliarid ;
   protected String gxTv_SdtSDTListadoPacienteFamiliarComboBox_Nombresapellidos ;
}

