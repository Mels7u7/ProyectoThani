package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTProfesional implements Cloneable, java.io.Serializable
{
   public StructSdtSDTProfesional( )
   {
      this( -1, new ModelContext( StructSdtSDTProfesional.class ));
   }

   public StructSdtSDTProfesional( int remoteHandle ,
                                   ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtSDTProfesional_Profesionaltipodocumento = "" ;
      gxTv_SdtSDTProfesional_Profesionalnrodocumento = "" ;
      gxTv_SdtSDTProfesional_Profesionalapellidopaterno = "" ;
      gxTv_SdtSDTProfesional_Profesionalapellidomaterno = "" ;
      gxTv_SdtSDTProfesional_Profesionalnombres = "" ;
      gxTv_SdtSDTProfesional_Profesionalfullname = "" ;
      gxTv_SdtSDTProfesional_Profesionalfechanacimiento = cal.getTime() ;
      gxTv_SdtSDTProfesional_Profesionalcorreo = "" ;
      gxTv_SdtSDTProfesional_Profesionalcop = "" ;
      gxTv_SdtSDTProfesional_Profesionalcolordisponible = "" ;
      gxTv_SdtSDTProfesional_Profesionalcolorcita = "" ;
      gxTv_SdtSDTProfesional_Profesionaltiempocita = (byte)(30) ;
      gxTv_SdtSDTProfesional_Profesionalestado = "" ;
      gxTv_SdtSDTProfesional_Profesionalfoto = "" ;
      gxTv_SdtSDTProfesional_Profesionalfoto_gxi = "" ;
      gxTv_SdtSDTProfesional_Profesionalfechanacimiento_N = (byte)(1) ;
      gxTv_SdtSDTProfesional_Especialidad_N = (byte)(1) ;
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

   public int getProfesionalid( )
   {
      return gxTv_SdtSDTProfesional_Profesionalid ;
   }

   public void setProfesionalid( int value )
   {
      gxTv_SdtSDTProfesional_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_Profesionalid = value ;
   }

   public String getProfesionaltipodocumento( )
   {
      return gxTv_SdtSDTProfesional_Profesionaltipodocumento ;
   }

   public void setProfesionaltipodocumento( String value )
   {
      gxTv_SdtSDTProfesional_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_Profesionaltipodocumento = value ;
   }

   public String getProfesionalnrodocumento( )
   {
      return gxTv_SdtSDTProfesional_Profesionalnrodocumento ;
   }

   public void setProfesionalnrodocumento( String value )
   {
      gxTv_SdtSDTProfesional_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_Profesionalnrodocumento = value ;
   }

   public String getProfesionalapellidopaterno( )
   {
      return gxTv_SdtSDTProfesional_Profesionalapellidopaterno ;
   }

   public void setProfesionalapellidopaterno( String value )
   {
      gxTv_SdtSDTProfesional_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_Profesionalapellidopaterno = value ;
   }

   public String getProfesionalapellidomaterno( )
   {
      return gxTv_SdtSDTProfesional_Profesionalapellidomaterno ;
   }

   public void setProfesionalapellidomaterno( String value )
   {
      gxTv_SdtSDTProfesional_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_Profesionalapellidomaterno = value ;
   }

   public String getProfesionalnombres( )
   {
      return gxTv_SdtSDTProfesional_Profesionalnombres ;
   }

   public void setProfesionalnombres( String value )
   {
      gxTv_SdtSDTProfesional_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_Profesionalnombres = value ;
   }

   public String getProfesionalfullname( )
   {
      return gxTv_SdtSDTProfesional_Profesionalfullname ;
   }

   public void setProfesionalfullname( String value )
   {
      gxTv_SdtSDTProfesional_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_Profesionalfullname = value ;
   }

   public java.util.Date getProfesionalfechanacimiento( )
   {
      return gxTv_SdtSDTProfesional_Profesionalfechanacimiento ;
   }

   public void setProfesionalfechanacimiento( java.util.Date value )
   {
      gxTv_SdtSDTProfesional_Profesionalfechanacimiento_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_Profesionalfechanacimiento = value ;
   }

   public String getProfesionalcorreo( )
   {
      return gxTv_SdtSDTProfesional_Profesionalcorreo ;
   }

   public void setProfesionalcorreo( String value )
   {
      gxTv_SdtSDTProfesional_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_Profesionalcorreo = value ;
   }

   public String getProfesionalcop( )
   {
      return gxTv_SdtSDTProfesional_Profesionalcop ;
   }

   public void setProfesionalcop( String value )
   {
      gxTv_SdtSDTProfesional_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_Profesionalcop = value ;
   }

   public String getProfesionalcolordisponible( )
   {
      return gxTv_SdtSDTProfesional_Profesionalcolordisponible ;
   }

   public void setProfesionalcolordisponible( String value )
   {
      gxTv_SdtSDTProfesional_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_Profesionalcolordisponible = value ;
   }

   public String getProfesionalcolorcita( )
   {
      return gxTv_SdtSDTProfesional_Profesionalcolorcita ;
   }

   public void setProfesionalcolorcita( String value )
   {
      gxTv_SdtSDTProfesional_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_Profesionalcolorcita = value ;
   }

   public byte getProfesionaltiempocita( )
   {
      return gxTv_SdtSDTProfesional_Profesionaltiempocita ;
   }

   public void setProfesionaltiempocita( byte value )
   {
      gxTv_SdtSDTProfesional_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_Profesionaltiempocita = value ;
   }

   public String getProfesionalestado( )
   {
      return gxTv_SdtSDTProfesional_Profesionalestado ;
   }

   public void setProfesionalestado( String value )
   {
      gxTv_SdtSDTProfesional_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_Profesionalestado = value ;
   }

   public String getProfesionalfoto( )
   {
      return gxTv_SdtSDTProfesional_Profesionalfoto ;
   }

   public void setProfesionalfoto( String value )
   {
      gxTv_SdtSDTProfesional_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_Profesionalfoto = value ;
   }

   public String getProfesionalfoto_gxi( )
   {
      return gxTv_SdtSDTProfesional_Profesionalfoto_gxi ;
   }

   public void setProfesionalfoto_gxi( String value )
   {
      gxTv_SdtSDTProfesional_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_Profesionalfoto_gxi = value ;
   }

   public java.util.Vector<com.projectthani.StructSdtSDTProfesional_EspecialidadItem> getEspecialidad( )
   {
      return gxTv_SdtSDTProfesional_Especialidad ;
   }

   public void setEspecialidad( java.util.Vector<com.projectthani.StructSdtSDTProfesional_EspecialidadItem> value )
   {
      gxTv_SdtSDTProfesional_Especialidad_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_Especialidad = value ;
   }

   protected byte gxTv_SdtSDTProfesional_Profesionaltiempocita ;
   protected byte gxTv_SdtSDTProfesional_Profesionalfechanacimiento_N ;
   protected byte gxTv_SdtSDTProfesional_Especialidad_N ;
   protected byte gxTv_SdtSDTProfesional_N ;
   protected int gxTv_SdtSDTProfesional_Profesionalid ;
   protected String gxTv_SdtSDTProfesional_Profesionaltipodocumento ;
   protected String gxTv_SdtSDTProfesional_Profesionalcolordisponible ;
   protected String gxTv_SdtSDTProfesional_Profesionalcolorcita ;
   protected String gxTv_SdtSDTProfesional_Profesionalestado ;
   protected String gxTv_SdtSDTProfesional_Profesionalnrodocumento ;
   protected String gxTv_SdtSDTProfesional_Profesionalapellidopaterno ;
   protected String gxTv_SdtSDTProfesional_Profesionalapellidomaterno ;
   protected String gxTv_SdtSDTProfesional_Profesionalnombres ;
   protected String gxTv_SdtSDTProfesional_Profesionalfullname ;
   protected String gxTv_SdtSDTProfesional_Profesionalcorreo ;
   protected String gxTv_SdtSDTProfesional_Profesionalcop ;
   protected String gxTv_SdtSDTProfesional_Profesionalfoto_gxi ;
   protected String gxTv_SdtSDTProfesional_Profesionalfoto ;
   protected java.util.Date gxTv_SdtSDTProfesional_Profesionalfechanacimiento ;
   protected java.util.Vector<com.projectthani.StructSdtSDTProfesional_EspecialidadItem> gxTv_SdtSDTProfesional_Especialidad=null ;
}

