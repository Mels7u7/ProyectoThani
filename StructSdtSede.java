package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSede implements Cloneable, java.io.Serializable
{
   public StructSdtSede( )
   {
      this( -1, new ModelContext( StructSdtSede.class ));
   }

   public StructSdtSede( int remoteHandle ,
                         ModelContext context )
   {
      gxTv_SdtSede_Sedenombre = "" ;
      gxTv_SdtSede_Clinicanombrecomercial = "" ;
      gxTv_SdtSede_Ubigeocode = "" ;
      gxTv_SdtSede_Ubigeonombre = "" ;
      gxTv_SdtSede_Sededireccion = "" ;
      gxTv_SdtSede_Sedecorreo = "" ;
      gxTv_SdtSede_Sedeestado = "" ;
      gxTv_SdtSede_Sedetipo = "" ;
      gxTv_SdtSede_Sedesector = "" ;
      gxTv_SdtSede_Mode = "" ;
      gxTv_SdtSede_Sedenombre_Z = "" ;
      gxTv_SdtSede_Clinicanombrecomercial_Z = "" ;
      gxTv_SdtSede_Ubigeocode_Z = "" ;
      gxTv_SdtSede_Ubigeonombre_Z = "" ;
      gxTv_SdtSede_Sededireccion_Z = "" ;
      gxTv_SdtSede_Sedecorreo_Z = "" ;
      gxTv_SdtSede_Sedeestado_Z = "" ;
      gxTv_SdtSede_Sedetipo_Z = "" ;
      gxTv_SdtSede_Sedesector_Z = "" ;
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

   public short getSedeid( )
   {
      return gxTv_SdtSede_Sedeid ;
   }

   public void setSedeid( short value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      gxTv_SdtSede_Sedeid = value ;
   }

   public String getSedenombre( )
   {
      return gxTv_SdtSede_Sedenombre ;
   }

   public void setSedenombre( String value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      gxTv_SdtSede_Sedenombre = value ;
   }

   public short getClinicaid( )
   {
      return gxTv_SdtSede_Clinicaid ;
   }

   public void setClinicaid( short value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      gxTv_SdtSede_Clinicaid = value ;
   }

   public long getClinicaruc( )
   {
      return gxTv_SdtSede_Clinicaruc ;
   }

   public void setClinicaruc( long value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      gxTv_SdtSede_Clinicaruc = value ;
   }

   public String getClinicanombrecomercial( )
   {
      return gxTv_SdtSede_Clinicanombrecomercial ;
   }

   public void setClinicanombrecomercial( String value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      gxTv_SdtSede_Clinicanombrecomercial = value ;
   }

   public String getUbigeocode( )
   {
      return gxTv_SdtSede_Ubigeocode ;
   }

   public void setUbigeocode( String value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      gxTv_SdtSede_Ubigeocode = value ;
   }

   public String getUbigeonombre( )
   {
      return gxTv_SdtSede_Ubigeonombre ;
   }

   public void setUbigeonombre( String value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      gxTv_SdtSede_Ubigeonombre = value ;
   }

   public String getSededireccion( )
   {
      return gxTv_SdtSede_Sededireccion ;
   }

   public void setSededireccion( String value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      gxTv_SdtSede_Sededireccion = value ;
   }

   public String getSedecorreo( )
   {
      return gxTv_SdtSede_Sedecorreo ;
   }

   public void setSedecorreo( String value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      gxTv_SdtSede_Sedecorreo = value ;
   }

   public String getSedeestado( )
   {
      return gxTv_SdtSede_Sedeestado ;
   }

   public void setSedeestado( String value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      gxTv_SdtSede_Sedeestado = value ;
   }

   public String getSedetipo( )
   {
      return gxTv_SdtSede_Sedetipo ;
   }

   public void setSedetipo( String value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      gxTv_SdtSede_Sedetipo = value ;
   }

   public String getSedesector( )
   {
      return gxTv_SdtSede_Sedesector ;
   }

   public void setSedesector( String value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      gxTv_SdtSede_Sedesector = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtSede_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      gxTv_SdtSede_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtSede_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      gxTv_SdtSede_Initialized = value ;
   }

   public short getSedeid_Z( )
   {
      return gxTv_SdtSede_Sedeid_Z ;
   }

   public void setSedeid_Z( short value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      gxTv_SdtSede_Sedeid_Z = value ;
   }

   public String getSedenombre_Z( )
   {
      return gxTv_SdtSede_Sedenombre_Z ;
   }

   public void setSedenombre_Z( String value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      gxTv_SdtSede_Sedenombre_Z = value ;
   }

   public short getClinicaid_Z( )
   {
      return gxTv_SdtSede_Clinicaid_Z ;
   }

   public void setClinicaid_Z( short value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      gxTv_SdtSede_Clinicaid_Z = value ;
   }

   public long getClinicaruc_Z( )
   {
      return gxTv_SdtSede_Clinicaruc_Z ;
   }

   public void setClinicaruc_Z( long value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      gxTv_SdtSede_Clinicaruc_Z = value ;
   }

   public String getClinicanombrecomercial_Z( )
   {
      return gxTv_SdtSede_Clinicanombrecomercial_Z ;
   }

   public void setClinicanombrecomercial_Z( String value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      gxTv_SdtSede_Clinicanombrecomercial_Z = value ;
   }

   public String getUbigeocode_Z( )
   {
      return gxTv_SdtSede_Ubigeocode_Z ;
   }

   public void setUbigeocode_Z( String value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      gxTv_SdtSede_Ubigeocode_Z = value ;
   }

   public String getUbigeonombre_Z( )
   {
      return gxTv_SdtSede_Ubigeonombre_Z ;
   }

   public void setUbigeonombre_Z( String value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      gxTv_SdtSede_Ubigeonombre_Z = value ;
   }

   public String getSededireccion_Z( )
   {
      return gxTv_SdtSede_Sededireccion_Z ;
   }

   public void setSededireccion_Z( String value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      gxTv_SdtSede_Sededireccion_Z = value ;
   }

   public String getSedecorreo_Z( )
   {
      return gxTv_SdtSede_Sedecorreo_Z ;
   }

   public void setSedecorreo_Z( String value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      gxTv_SdtSede_Sedecorreo_Z = value ;
   }

   public String getSedeestado_Z( )
   {
      return gxTv_SdtSede_Sedeestado_Z ;
   }

   public void setSedeestado_Z( String value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      gxTv_SdtSede_Sedeestado_Z = value ;
   }

   public String getSedetipo_Z( )
   {
      return gxTv_SdtSede_Sedetipo_Z ;
   }

   public void setSedetipo_Z( String value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      gxTv_SdtSede_Sedetipo_Z = value ;
   }

   public String getSedesector_Z( )
   {
      return gxTv_SdtSede_Sedesector_Z ;
   }

   public void setSedesector_Z( String value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      gxTv_SdtSede_Sedesector_Z = value ;
   }

   private byte gxTv_SdtSede_N ;
   protected short gxTv_SdtSede_Sedeid ;
   protected short gxTv_SdtSede_Clinicaid ;
   protected short gxTv_SdtSede_Initialized ;
   protected short gxTv_SdtSede_Sedeid_Z ;
   protected short gxTv_SdtSede_Clinicaid_Z ;
   protected long gxTv_SdtSede_Clinicaruc ;
   protected long gxTv_SdtSede_Clinicaruc_Z ;
   protected String gxTv_SdtSede_Ubigeocode ;
   protected String gxTv_SdtSede_Sedeestado ;
   protected String gxTv_SdtSede_Sedetipo ;
   protected String gxTv_SdtSede_Sedesector ;
   protected String gxTv_SdtSede_Mode ;
   protected String gxTv_SdtSede_Ubigeocode_Z ;
   protected String gxTv_SdtSede_Sedeestado_Z ;
   protected String gxTv_SdtSede_Sedetipo_Z ;
   protected String gxTv_SdtSede_Sedesector_Z ;
   protected String gxTv_SdtSede_Sedenombre ;
   protected String gxTv_SdtSede_Clinicanombrecomercial ;
   protected String gxTv_SdtSede_Ubigeonombre ;
   protected String gxTv_SdtSede_Sededireccion ;
   protected String gxTv_SdtSede_Sedecorreo ;
   protected String gxTv_SdtSede_Sedenombre_Z ;
   protected String gxTv_SdtSede_Clinicanombrecomercial_Z ;
   protected String gxTv_SdtSede_Ubigeonombre_Z ;
   protected String gxTv_SdtSede_Sededireccion_Z ;
   protected String gxTv_SdtSede_Sedecorreo_Z ;
}

