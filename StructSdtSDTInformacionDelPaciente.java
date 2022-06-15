package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTInformacionDelPaciente implements Cloneable, java.io.Serializable
{
   public StructSdtSDTInformacionDelPaciente( )
   {
      this( -1, new ModelContext( StructSdtSDTInformacionDelPaciente.class ));
   }

   public StructSdtSDTInformacionDelPaciente( int remoteHandle ,
                                              ModelContext context )
   {
      gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientenombres = "" ;
      gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteapellidos = "" ;
      gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientetipodocumento = "" ;
      gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientenrodocumento = "" ;
      gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientefechanacimiento = "" ;
      gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientesexo = "" ;
      gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientepeso = new java.math.BigDecimal(0) ;
      gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteestatura = new java.math.BigDecimal(0) ;
      gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteemail = "" ;
      gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientemotivoconsulta = "" ;
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

   public int getSdtinformaciondelpacienteid( )
   {
      return gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteid ;
   }

   public void setSdtinformaciondelpacienteid( int value )
   {
      gxTv_SdtSDTInformacionDelPaciente_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteid = value ;
   }

   public String getSdtinformaciondelpacientenombres( )
   {
      return gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientenombres ;
   }

   public void setSdtinformaciondelpacientenombres( String value )
   {
      gxTv_SdtSDTInformacionDelPaciente_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientenombres = value ;
   }

   public String getSdtinformaciondelpacienteapellidos( )
   {
      return gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteapellidos ;
   }

   public void setSdtinformaciondelpacienteapellidos( String value )
   {
      gxTv_SdtSDTInformacionDelPaciente_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteapellidos = value ;
   }

   public String getSdtinformaciondelpacientetipodocumento( )
   {
      return gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientetipodocumento ;
   }

   public void setSdtinformaciondelpacientetipodocumento( String value )
   {
      gxTv_SdtSDTInformacionDelPaciente_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientetipodocumento = value ;
   }

   public String getSdtinformaciondelpacientenrodocumento( )
   {
      return gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientenrodocumento ;
   }

   public void setSdtinformaciondelpacientenrodocumento( String value )
   {
      gxTv_SdtSDTInformacionDelPaciente_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientenrodocumento = value ;
   }

   public String getSdtinformaciondelpacientefechanacimiento( )
   {
      return gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientefechanacimiento ;
   }

   public void setSdtinformaciondelpacientefechanacimiento( String value )
   {
      gxTv_SdtSDTInformacionDelPaciente_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientefechanacimiento = value ;
   }

   public String getSdtinformaciondelpacientesexo( )
   {
      return gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientesexo ;
   }

   public void setSdtinformaciondelpacientesexo( String value )
   {
      gxTv_SdtSDTInformacionDelPaciente_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientesexo = value ;
   }

   public java.math.BigDecimal getSdtinformaciondelpacientepeso( )
   {
      return gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientepeso ;
   }

   public void setSdtinformaciondelpacientepeso( java.math.BigDecimal value )
   {
      gxTv_SdtSDTInformacionDelPaciente_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientepeso = value ;
   }

   public java.math.BigDecimal getSdtinformaciondelpacienteestatura( )
   {
      return gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteestatura ;
   }

   public void setSdtinformaciondelpacienteestatura( java.math.BigDecimal value )
   {
      gxTv_SdtSDTInformacionDelPaciente_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteestatura = value ;
   }

   public String getSdtinformaciondelpacienteemail( )
   {
      return gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteemail ;
   }

   public void setSdtinformaciondelpacienteemail( String value )
   {
      gxTv_SdtSDTInformacionDelPaciente_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteemail = value ;
   }

   public String getSdtinformaciondelpacientemotivoconsulta( )
   {
      return gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientemotivoconsulta ;
   }

   public void setSdtinformaciondelpacientemotivoconsulta( String value )
   {
      gxTv_SdtSDTInformacionDelPaciente_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientemotivoconsulta = value ;
   }

   protected byte gxTv_SdtSDTInformacionDelPaciente_N ;
   protected int gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteid ;
   protected String gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientenombres ;
   protected String gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteapellidos ;
   protected String gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientetipodocumento ;
   protected String gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientenrodocumento ;
   protected String gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientefechanacimiento ;
   protected String gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientesexo ;
   protected String gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteemail ;
   protected String gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientemotivoconsulta ;
   protected java.math.BigDecimal gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientepeso ;
   protected java.math.BigDecimal gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteestatura ;
}

