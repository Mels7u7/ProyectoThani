package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTInformacionDelPacienteFacturacionF implements Cloneable, java.io.Serializable
{
   public StructSdtSDTInformacionDelPacienteFacturacionF( )
   {
      this( -1, new ModelContext( StructSdtSDTInformacionDelPacienteFacturacionF.class ));
   }

   public StructSdtSDTInformacionDelPacienteFacturacionF( int remoteHandle ,
                                                          ModelContext context )
   {
      gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionftipodocumento = "" ;
      gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfnrodocumento = "" ;
      gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfrazonsocial = "" ;
      gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfdireccion = "" ;
      gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfemail = "" ;
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

   public String getSdtinformaciondelpacientefacturacionftipodocumento( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionftipodocumento ;
   }

   public void setSdtinformaciondelpacientefacturacionftipodocumento( String value )
   {
      gxTv_SdtSDTInformacionDelPacienteFacturacionF_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionftipodocumento = value ;
   }

   public String getSdtinformaciondelpacientefacturacionfnrodocumento( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfnrodocumento ;
   }

   public void setSdtinformaciondelpacientefacturacionfnrodocumento( String value )
   {
      gxTv_SdtSDTInformacionDelPacienteFacturacionF_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfnrodocumento = value ;
   }

   public String getSdtinformaciondelpacientefacturacionfrazonsocial( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfrazonsocial ;
   }

   public void setSdtinformaciondelpacientefacturacionfrazonsocial( String value )
   {
      gxTv_SdtSDTInformacionDelPacienteFacturacionF_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfrazonsocial = value ;
   }

   public String getSdtinformaciondelpacientefacturacionfdireccion( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfdireccion ;
   }

   public void setSdtinformaciondelpacientefacturacionfdireccion( String value )
   {
      gxTv_SdtSDTInformacionDelPacienteFacturacionF_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfdireccion = value ;
   }

   public String getSdtinformaciondelpacientefacturacionfemail( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfemail ;
   }

   public void setSdtinformaciondelpacientefacturacionfemail( String value )
   {
      gxTv_SdtSDTInformacionDelPacienteFacturacionF_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfemail = value ;
   }

   protected byte gxTv_SdtSDTInformacionDelPacienteFacturacionF_N ;
   protected String gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionftipodocumento ;
   protected String gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfnrodocumento ;
   protected String gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfrazonsocial ;
   protected String gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfdireccion ;
   protected String gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfemail ;
}

