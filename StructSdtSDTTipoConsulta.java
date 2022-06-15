package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTTipoConsulta implements Cloneable, java.io.Serializable
{
   public StructSdtSDTTipoConsulta( )
   {
      this( -1, new ModelContext( StructSdtSDTTipoConsulta.class ));
   }

   public StructSdtSDTTipoConsulta( int remoteHandle ,
                                    ModelContext context )
   {
      gxTv_SdtSDTTipoConsulta_Sedetipoconsulta = "" ;
      gxTv_SdtSDTTipoConsulta_Sedetipoconsultadescripcion = "" ;
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

   public String getSedetipoconsulta( )
   {
      return gxTv_SdtSDTTipoConsulta_Sedetipoconsulta ;
   }

   public void setSedetipoconsulta( String value )
   {
      gxTv_SdtSDTTipoConsulta_N = (byte)(0) ;
      gxTv_SdtSDTTipoConsulta_Sedetipoconsulta = value ;
   }

   public String getSedetipoconsultadescripcion( )
   {
      return gxTv_SdtSDTTipoConsulta_Sedetipoconsultadescripcion ;
   }

   public void setSedetipoconsultadescripcion( String value )
   {
      gxTv_SdtSDTTipoConsulta_N = (byte)(0) ;
      gxTv_SdtSDTTipoConsulta_Sedetipoconsultadescripcion = value ;
   }

   protected byte gxTv_SdtSDTTipoConsulta_N ;
   protected String gxTv_SdtSDTTipoConsulta_Sedetipoconsulta ;
   protected String gxTv_SdtSDTTipoConsulta_Sedetipoconsultadescripcion ;
}

