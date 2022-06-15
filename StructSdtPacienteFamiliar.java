package com.projectthani ;
import com.genexus.*;

public final  class StructSdtPacienteFamiliar implements Cloneable, java.io.Serializable
{
   public StructSdtPacienteFamiliar( )
   {
      this( -1, new ModelContext( StructSdtPacienteFamiliar.class ));
   }

   public StructSdtPacienteFamiliar( int remoteHandle ,
                                     ModelContext context )
   {
      gxTv_SdtPacienteFamiliar_Sgpacientehijonombres = "" ;
      gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidopaterno = "" ;
      gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidomaterno = "" ;
      gxTv_SdtPacienteFamiliar_Pacientefamiliarparentesco = "" ;
      gxTv_SdtPacienteFamiliar_Pacientefamiliarestado = "" ;
      gxTv_SdtPacienteFamiliar_Mode = "" ;
      gxTv_SdtPacienteFamiliar_Sgpacientehijonombres_Z = "" ;
      gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidopaterno_Z = "" ;
      gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidomaterno_Z = "" ;
      gxTv_SdtPacienteFamiliar_Pacientefamiliarparentesco_Z = "" ;
      gxTv_SdtPacienteFamiliar_Pacientefamiliarestado_Z = "" ;
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
      return gxTv_SdtPacienteFamiliar_Pacientefamiliarid ;
   }

   public void setPacientefamiliarid( int value )
   {
      gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
      gxTv_SdtPacienteFamiliar_Pacientefamiliarid = value ;
   }

   public int getPacienteid( )
   {
      return gxTv_SdtPacienteFamiliar_Pacienteid ;
   }

   public void setPacienteid( int value )
   {
      gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
      gxTv_SdtPacienteFamiliar_Pacienteid = value ;
   }

   public int getSgpacientehijopacienteid( )
   {
      return gxTv_SdtPacienteFamiliar_Sgpacientehijopacienteid ;
   }

   public void setSgpacientehijopacienteid( int value )
   {
      gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
      gxTv_SdtPacienteFamiliar_Sgpacientehijopacienteid = value ;
   }

   public String getSgpacientehijonombres( )
   {
      return gxTv_SdtPacienteFamiliar_Sgpacientehijonombres ;
   }

   public void setSgpacientehijonombres( String value )
   {
      gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
      gxTv_SdtPacienteFamiliar_Sgpacientehijonombres = value ;
   }

   public String getSgpacientehijoapellidopaterno( )
   {
      return gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidopaterno ;
   }

   public void setSgpacientehijoapellidopaterno( String value )
   {
      gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
      gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidopaterno = value ;
   }

   public String getSgpacientehijoapellidomaterno( )
   {
      return gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidomaterno ;
   }

   public void setSgpacientehijoapellidomaterno( String value )
   {
      gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
      gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidomaterno = value ;
   }

   public String getPacientefamiliarparentesco( )
   {
      return gxTv_SdtPacienteFamiliar_Pacientefamiliarparentesco ;
   }

   public void setPacientefamiliarparentesco( String value )
   {
      gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
      gxTv_SdtPacienteFamiliar_Pacientefamiliarparentesco = value ;
   }

   public String getPacientefamiliarestado( )
   {
      return gxTv_SdtPacienteFamiliar_Pacientefamiliarestado ;
   }

   public void setPacientefamiliarestado( String value )
   {
      gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
      gxTv_SdtPacienteFamiliar_Pacientefamiliarestado = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtPacienteFamiliar_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
      gxTv_SdtPacienteFamiliar_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtPacienteFamiliar_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
      gxTv_SdtPacienteFamiliar_Initialized = value ;
   }

   public int getPacientefamiliarid_Z( )
   {
      return gxTv_SdtPacienteFamiliar_Pacientefamiliarid_Z ;
   }

   public void setPacientefamiliarid_Z( int value )
   {
      gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
      gxTv_SdtPacienteFamiliar_Pacientefamiliarid_Z = value ;
   }

   public int getPacienteid_Z( )
   {
      return gxTv_SdtPacienteFamiliar_Pacienteid_Z ;
   }

   public void setPacienteid_Z( int value )
   {
      gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
      gxTv_SdtPacienteFamiliar_Pacienteid_Z = value ;
   }

   public int getSgpacientehijopacienteid_Z( )
   {
      return gxTv_SdtPacienteFamiliar_Sgpacientehijopacienteid_Z ;
   }

   public void setSgpacientehijopacienteid_Z( int value )
   {
      gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
      gxTv_SdtPacienteFamiliar_Sgpacientehijopacienteid_Z = value ;
   }

   public String getSgpacientehijonombres_Z( )
   {
      return gxTv_SdtPacienteFamiliar_Sgpacientehijonombres_Z ;
   }

   public void setSgpacientehijonombres_Z( String value )
   {
      gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
      gxTv_SdtPacienteFamiliar_Sgpacientehijonombres_Z = value ;
   }

   public String getSgpacientehijoapellidopaterno_Z( )
   {
      return gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidopaterno_Z ;
   }

   public void setSgpacientehijoapellidopaterno_Z( String value )
   {
      gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
      gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidopaterno_Z = value ;
   }

   public String getSgpacientehijoapellidomaterno_Z( )
   {
      return gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidomaterno_Z ;
   }

   public void setSgpacientehijoapellidomaterno_Z( String value )
   {
      gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
      gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidomaterno_Z = value ;
   }

   public String getPacientefamiliarparentesco_Z( )
   {
      return gxTv_SdtPacienteFamiliar_Pacientefamiliarparentesco_Z ;
   }

   public void setPacientefamiliarparentesco_Z( String value )
   {
      gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
      gxTv_SdtPacienteFamiliar_Pacientefamiliarparentesco_Z = value ;
   }

   public String getPacientefamiliarestado_Z( )
   {
      return gxTv_SdtPacienteFamiliar_Pacientefamiliarestado_Z ;
   }

   public void setPacientefamiliarestado_Z( String value )
   {
      gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
      gxTv_SdtPacienteFamiliar_Pacientefamiliarestado_Z = value ;
   }

   private byte gxTv_SdtPacienteFamiliar_N ;
   protected short gxTv_SdtPacienteFamiliar_Initialized ;
   protected int gxTv_SdtPacienteFamiliar_Pacientefamiliarid ;
   protected int gxTv_SdtPacienteFamiliar_Pacienteid ;
   protected int gxTv_SdtPacienteFamiliar_Sgpacientehijopacienteid ;
   protected int gxTv_SdtPacienteFamiliar_Pacientefamiliarid_Z ;
   protected int gxTv_SdtPacienteFamiliar_Pacienteid_Z ;
   protected int gxTv_SdtPacienteFamiliar_Sgpacientehijopacienteid_Z ;
   protected String gxTv_SdtPacienteFamiliar_Pacientefamiliarparentesco ;
   protected String gxTv_SdtPacienteFamiliar_Pacientefamiliarestado ;
   protected String gxTv_SdtPacienteFamiliar_Mode ;
   protected String gxTv_SdtPacienteFamiliar_Pacientefamiliarparentesco_Z ;
   protected String gxTv_SdtPacienteFamiliar_Pacientefamiliarestado_Z ;
   protected String gxTv_SdtPacienteFamiliar_Sgpacientehijonombres ;
   protected String gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidopaterno ;
   protected String gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidomaterno ;
   protected String gxTv_SdtPacienteFamiliar_Sgpacientehijonombres_Z ;
   protected String gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidopaterno_Z ;
   protected String gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidomaterno_Z ;
}

