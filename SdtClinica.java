package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtClinica extends GxSilentTrnSdt implements Cloneable, java.io.Serializable
{
   public SdtClinica( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtClinica.class));
   }

   public SdtClinica( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle, context, "SdtClinica");
      initialize( remoteHandle) ;
   }

   public SdtClinica( int remoteHandle ,
                      StructSdtClinica struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public void Load( short AV28ClinicaId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Short.valueOf(AV28ClinicaId)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"ClinicaId", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Clinica");
      metadata.set("BT", "Clinica");
      metadata.set("PK", "[ \"ClinicaId\" ]");
      metadata.set("PKAssigned", "[ \"ClinicaId\" ]");
      metadata.set("AllowInsert", "True");
      metadata.set("AllowUpdate", "True");
      metadata.set("AllowDelete", "True");
      return metadata ;
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaId") )
            {
               gxTv_SdtClinica_Clinicaid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaRUC") )
            {
               gxTv_SdtClinica_Clinicaruc = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaNombreComercial") )
            {
               gxTv_SdtClinica_Clinicanombrecomercial = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaNombreAbreviado") )
            {
               gxTv_SdtClinica_Clinicanombreabreviado = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaDireccionComercial") )
            {
               gxTv_SdtClinica_Clinicadireccioncomercial = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaCorreo") )
            {
               gxTv_SdtClinica_Clinicacorreo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaMoneda") )
            {
               gxTv_SdtClinica_Clinicamoneda = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaLogo") )
            {
               gxTv_SdtClinica_Clinicalogo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaLogo_GXI") )
            {
               gxTv_SdtClinica_Clinicalogo_gxi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaLogoHeader") )
            {
               gxTv_SdtClinica_Clinicalogoheader = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaLogoHeader_GXI") )
            {
               gxTv_SdtClinica_Clinicalogoheader_gxi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaLogoFactura") )
            {
               gxTv_SdtClinica_Clinicalogofactura = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaLogoFactura_GXI") )
            {
               gxTv_SdtClinica_Clinicalogofactura_gxi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaLogoBoleta") )
            {
               gxTv_SdtClinica_Clinicalogoboleta = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaLogoBoleta_GXI") )
            {
               gxTv_SdtClinica_Clinicalogoboleta_gxi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaLogoPago") )
            {
               gxTv_SdtClinica_Clinicalogopago = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaLogoPago_GXI") )
            {
               gxTv_SdtClinica_Clinicalogopago_gxi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaTelefono") )
            {
               gxTv_SdtClinica_Clinicatelefono = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaWhatsApp") )
            {
               gxTv_SdtClinica_Clinicawhatsapp = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaFacebook") )
            {
               gxTv_SdtClinica_Clinicafacebook = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaTwiter") )
            {
               gxTv_SdtClinica_Clinicatwiter = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaInstagram") )
            {
               gxTv_SdtClinica_Clinicainstagram = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaLinkedin") )
            {
               gxTv_SdtClinica_Clinicalinkedin = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaTiempoDeCita") )
            {
               gxTv_SdtClinica_Clinicatiempodecita = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaEstado") )
            {
               gxTv_SdtClinica_Clinicaestado = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtClinica_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtClinica_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaId_Z") )
            {
               gxTv_SdtClinica_Clinicaid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaRUC_Z") )
            {
               gxTv_SdtClinica_Clinicaruc_Z = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaNombreComercial_Z") )
            {
               gxTv_SdtClinica_Clinicanombrecomercial_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaNombreAbreviado_Z") )
            {
               gxTv_SdtClinica_Clinicanombreabreviado_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaDireccionComercial_Z") )
            {
               gxTv_SdtClinica_Clinicadireccioncomercial_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaCorreo_Z") )
            {
               gxTv_SdtClinica_Clinicacorreo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaMoneda_Z") )
            {
               gxTv_SdtClinica_Clinicamoneda_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaTelefono_Z") )
            {
               gxTv_SdtClinica_Clinicatelefono_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaWhatsApp_Z") )
            {
               gxTv_SdtClinica_Clinicawhatsapp_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaFacebook_Z") )
            {
               gxTv_SdtClinica_Clinicafacebook_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaTwiter_Z") )
            {
               gxTv_SdtClinica_Clinicatwiter_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaInstagram_Z") )
            {
               gxTv_SdtClinica_Clinicainstagram_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaLinkedin_Z") )
            {
               gxTv_SdtClinica_Clinicalinkedin_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaTiempoDeCita_Z") )
            {
               gxTv_SdtClinica_Clinicatiempodecita_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaEstado_Z") )
            {
               gxTv_SdtClinica_Clinicaestado_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaLogo_GXI_Z") )
            {
               gxTv_SdtClinica_Clinicalogo_gxi_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaLogoHeader_GXI_Z") )
            {
               gxTv_SdtClinica_Clinicalogoheader_gxi_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaLogoFactura_GXI_Z") )
            {
               gxTv_SdtClinica_Clinicalogofactura_gxi_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaLogoBoleta_GXI_Z") )
            {
               gxTv_SdtClinica_Clinicalogoboleta_gxi_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaLogoPago_GXI_Z") )
            {
               gxTv_SdtClinica_Clinicalogopago_gxi_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaLogoHeader_N") )
            {
               gxTv_SdtClinica_Clinicalogoheader_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaLogoFactura_N") )
            {
               gxTv_SdtClinica_Clinicalogofactura_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaLogoBoleta_N") )
            {
               gxTv_SdtClinica_Clinicalogoboleta_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaLogoPago_N") )
            {
               gxTv_SdtClinica_Clinicalogopago_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaLogoHeader_GXI_N") )
            {
               gxTv_SdtClinica_Clinicalogoheader_gxi_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaLogoFactura_GXI_N") )
            {
               gxTv_SdtClinica_Clinicalogofactura_gxi_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaLogoBoleta_GXI_N") )
            {
               gxTv_SdtClinica_Clinicalogoboleta_gxi_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaLogoPago_GXI_N") )
            {
               gxTv_SdtClinica_Clinicalogopago_gxi_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "Clinica" ;
      }
      if ( (GXutil.strcmp("", sNameSpace)==0) )
      {
         sNameSpace = "ProjectThani" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      oWriter.writeElement("ClinicaId", GXutil.trim( GXutil.str( gxTv_SdtClinica_Clinicaid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaRUC", GXutil.trim( GXutil.str( gxTv_SdtClinica_Clinicaruc, 11, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaNombreComercial", GXutil.rtrim( gxTv_SdtClinica_Clinicanombrecomercial));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaNombreAbreviado", GXutil.rtrim( gxTv_SdtClinica_Clinicanombreabreviado));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaDireccionComercial", GXutil.rtrim( gxTv_SdtClinica_Clinicadireccioncomercial));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaCorreo", GXutil.rtrim( gxTv_SdtClinica_Clinicacorreo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaMoneda", GXutil.trim( GXutil.str( gxTv_SdtClinica_Clinicamoneda, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaLogo", GXutil.rtrim( gxTv_SdtClinica_Clinicalogo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaLogoHeader", GXutil.rtrim( gxTv_SdtClinica_Clinicalogoheader));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaLogoFactura", GXutil.rtrim( gxTv_SdtClinica_Clinicalogofactura));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaLogoBoleta", GXutil.rtrim( gxTv_SdtClinica_Clinicalogoboleta));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaLogoPago", GXutil.rtrim( gxTv_SdtClinica_Clinicalogopago));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaTelefono", GXutil.rtrim( gxTv_SdtClinica_Clinicatelefono));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaWhatsApp", GXutil.rtrim( gxTv_SdtClinica_Clinicawhatsapp));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaFacebook", GXutil.rtrim( gxTv_SdtClinica_Clinicafacebook));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaTwiter", GXutil.rtrim( gxTv_SdtClinica_Clinicatwiter));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaInstagram", GXutil.rtrim( gxTv_SdtClinica_Clinicainstagram));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaLinkedin", GXutil.rtrim( gxTv_SdtClinica_Clinicalinkedin));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaTiempoDeCita", GXutil.trim( GXutil.str( gxTv_SdtClinica_Clinicatiempodecita, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaEstado", GXutil.rtrim( gxTv_SdtClinica_Clinicaestado));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("ClinicaLogo_GXI", GXutil.rtrim( gxTv_SdtClinica_Clinicalogo_gxi));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ClinicaLogoHeader_GXI", GXutil.rtrim( gxTv_SdtClinica_Clinicalogoheader_gxi));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ClinicaLogoFactura_GXI", GXutil.rtrim( gxTv_SdtClinica_Clinicalogofactura_gxi));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ClinicaLogoBoleta_GXI", GXutil.rtrim( gxTv_SdtClinica_Clinicalogoboleta_gxi));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ClinicaLogoPago_GXI", GXutil.rtrim( gxTv_SdtClinica_Clinicalogopago_gxi));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Mode", GXutil.rtrim( gxTv_SdtClinica_Mode));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtClinica_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ClinicaId_Z", GXutil.trim( GXutil.str( gxTv_SdtClinica_Clinicaid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ClinicaRUC_Z", GXutil.trim( GXutil.str( gxTv_SdtClinica_Clinicaruc_Z, 11, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ClinicaNombreComercial_Z", GXutil.rtrim( gxTv_SdtClinica_Clinicanombrecomercial_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ClinicaNombreAbreviado_Z", GXutil.rtrim( gxTv_SdtClinica_Clinicanombreabreviado_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ClinicaDireccionComercial_Z", GXutil.rtrim( gxTv_SdtClinica_Clinicadireccioncomercial_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ClinicaCorreo_Z", GXutil.rtrim( gxTv_SdtClinica_Clinicacorreo_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ClinicaMoneda_Z", GXutil.trim( GXutil.str( gxTv_SdtClinica_Clinicamoneda_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ClinicaTelefono_Z", GXutil.rtrim( gxTv_SdtClinica_Clinicatelefono_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ClinicaWhatsApp_Z", GXutil.rtrim( gxTv_SdtClinica_Clinicawhatsapp_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ClinicaFacebook_Z", GXutil.rtrim( gxTv_SdtClinica_Clinicafacebook_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ClinicaTwiter_Z", GXutil.rtrim( gxTv_SdtClinica_Clinicatwiter_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ClinicaInstagram_Z", GXutil.rtrim( gxTv_SdtClinica_Clinicainstagram_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ClinicaLinkedin_Z", GXutil.rtrim( gxTv_SdtClinica_Clinicalinkedin_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ClinicaTiempoDeCita_Z", GXutil.trim( GXutil.str( gxTv_SdtClinica_Clinicatiempodecita_Z, 2, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ClinicaEstado_Z", GXutil.rtrim( gxTv_SdtClinica_Clinicaestado_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ClinicaLogo_GXI_Z", GXutil.rtrim( gxTv_SdtClinica_Clinicalogo_gxi_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ClinicaLogoHeader_GXI_Z", GXutil.rtrim( gxTv_SdtClinica_Clinicalogoheader_gxi_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ClinicaLogoFactura_GXI_Z", GXutil.rtrim( gxTv_SdtClinica_Clinicalogofactura_gxi_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ClinicaLogoBoleta_GXI_Z", GXutil.rtrim( gxTv_SdtClinica_Clinicalogoboleta_gxi_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ClinicaLogoPago_GXI_Z", GXutil.rtrim( gxTv_SdtClinica_Clinicalogopago_gxi_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ClinicaLogoHeader_N", GXutil.trim( GXutil.str( gxTv_SdtClinica_Clinicalogoheader_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ClinicaLogoFactura_N", GXutil.trim( GXutil.str( gxTv_SdtClinica_Clinicalogofactura_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ClinicaLogoBoleta_N", GXutil.trim( GXutil.str( gxTv_SdtClinica_Clinicalogoboleta_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ClinicaLogoPago_N", GXutil.trim( GXutil.str( gxTv_SdtClinica_Clinicalogopago_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ClinicaLogoHeader_GXI_N", GXutil.trim( GXutil.str( gxTv_SdtClinica_Clinicalogoheader_gxi_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ClinicaLogoFactura_GXI_N", GXutil.trim( GXutil.str( gxTv_SdtClinica_Clinicalogofactura_gxi_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ClinicaLogoBoleta_GXI_N", GXutil.trim( GXutil.str( gxTv_SdtClinica_Clinicalogoboleta_gxi_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ClinicaLogoPago_GXI_N", GXutil.trim( GXutil.str( gxTv_SdtClinica_Clinicalogopago_gxi_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      oWriter.writeEndElement();
   }

   public long getnumericvalue( String value )
   {
      if ( GXutil.notNumeric( value) )
      {
         formatError = true ;
      }
      return GXutil.lval( value) ;
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      AddObjectProperty("ClinicaId", gxTv_SdtClinica_Clinicaid, false, includeNonInitialized);
      AddObjectProperty("ClinicaRUC", gxTv_SdtClinica_Clinicaruc, false, includeNonInitialized);
      AddObjectProperty("ClinicaNombreComercial", gxTv_SdtClinica_Clinicanombrecomercial, false, includeNonInitialized);
      AddObjectProperty("ClinicaNombreAbreviado", gxTv_SdtClinica_Clinicanombreabreviado, false, includeNonInitialized);
      AddObjectProperty("ClinicaDireccionComercial", gxTv_SdtClinica_Clinicadireccioncomercial, false, includeNonInitialized);
      AddObjectProperty("ClinicaCorreo", gxTv_SdtClinica_Clinicacorreo, false, includeNonInitialized);
      AddObjectProperty("ClinicaMoneda", gxTv_SdtClinica_Clinicamoneda, false, includeNonInitialized);
      AddObjectProperty("ClinicaLogo", gxTv_SdtClinica_Clinicalogo, false, includeNonInitialized);
      AddObjectProperty("ClinicaLogoHeader", gxTv_SdtClinica_Clinicalogoheader, false, includeNonInitialized);
      AddObjectProperty("ClinicaLogoHeader_N", gxTv_SdtClinica_Clinicalogoheader_N, false, includeNonInitialized);
      AddObjectProperty("ClinicaLogoFactura", gxTv_SdtClinica_Clinicalogofactura, false, includeNonInitialized);
      AddObjectProperty("ClinicaLogoFactura_N", gxTv_SdtClinica_Clinicalogofactura_N, false, includeNonInitialized);
      AddObjectProperty("ClinicaLogoBoleta", gxTv_SdtClinica_Clinicalogoboleta, false, includeNonInitialized);
      AddObjectProperty("ClinicaLogoBoleta_N", gxTv_SdtClinica_Clinicalogoboleta_N, false, includeNonInitialized);
      AddObjectProperty("ClinicaLogoPago", gxTv_SdtClinica_Clinicalogopago, false, includeNonInitialized);
      AddObjectProperty("ClinicaLogoPago_N", gxTv_SdtClinica_Clinicalogopago_N, false, includeNonInitialized);
      AddObjectProperty("ClinicaTelefono", gxTv_SdtClinica_Clinicatelefono, false, includeNonInitialized);
      AddObjectProperty("ClinicaWhatsApp", gxTv_SdtClinica_Clinicawhatsapp, false, includeNonInitialized);
      AddObjectProperty("ClinicaFacebook", gxTv_SdtClinica_Clinicafacebook, false, includeNonInitialized);
      AddObjectProperty("ClinicaTwiter", gxTv_SdtClinica_Clinicatwiter, false, includeNonInitialized);
      AddObjectProperty("ClinicaInstagram", gxTv_SdtClinica_Clinicainstagram, false, includeNonInitialized);
      AddObjectProperty("ClinicaLinkedin", gxTv_SdtClinica_Clinicalinkedin, false, includeNonInitialized);
      AddObjectProperty("ClinicaTiempoDeCita", gxTv_SdtClinica_Clinicatiempodecita, false, includeNonInitialized);
      AddObjectProperty("ClinicaEstado", gxTv_SdtClinica_Clinicaestado, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("ClinicaLogo_GXI", gxTv_SdtClinica_Clinicalogo_gxi, false, includeNonInitialized);
         AddObjectProperty("ClinicaLogoHeader_GXI", gxTv_SdtClinica_Clinicalogoheader_gxi, false, includeNonInitialized);
         AddObjectProperty("ClinicaLogoFactura_GXI", gxTv_SdtClinica_Clinicalogofactura_gxi, false, includeNonInitialized);
         AddObjectProperty("ClinicaLogoBoleta_GXI", gxTv_SdtClinica_Clinicalogoboleta_gxi, false, includeNonInitialized);
         AddObjectProperty("ClinicaLogoPago_GXI", gxTv_SdtClinica_Clinicalogopago_gxi, false, includeNonInitialized);
         AddObjectProperty("Mode", gxTv_SdtClinica_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtClinica_Initialized, false, includeNonInitialized);
         AddObjectProperty("ClinicaId_Z", gxTv_SdtClinica_Clinicaid_Z, false, includeNonInitialized);
         AddObjectProperty("ClinicaRUC_Z", gxTv_SdtClinica_Clinicaruc_Z, false, includeNonInitialized);
         AddObjectProperty("ClinicaNombreComercial_Z", gxTv_SdtClinica_Clinicanombrecomercial_Z, false, includeNonInitialized);
         AddObjectProperty("ClinicaNombreAbreviado_Z", gxTv_SdtClinica_Clinicanombreabreviado_Z, false, includeNonInitialized);
         AddObjectProperty("ClinicaDireccionComercial_Z", gxTv_SdtClinica_Clinicadireccioncomercial_Z, false, includeNonInitialized);
         AddObjectProperty("ClinicaCorreo_Z", gxTv_SdtClinica_Clinicacorreo_Z, false, includeNonInitialized);
         AddObjectProperty("ClinicaMoneda_Z", gxTv_SdtClinica_Clinicamoneda_Z, false, includeNonInitialized);
         AddObjectProperty("ClinicaTelefono_Z", gxTv_SdtClinica_Clinicatelefono_Z, false, includeNonInitialized);
         AddObjectProperty("ClinicaWhatsApp_Z", gxTv_SdtClinica_Clinicawhatsapp_Z, false, includeNonInitialized);
         AddObjectProperty("ClinicaFacebook_Z", gxTv_SdtClinica_Clinicafacebook_Z, false, includeNonInitialized);
         AddObjectProperty("ClinicaTwiter_Z", gxTv_SdtClinica_Clinicatwiter_Z, false, includeNonInitialized);
         AddObjectProperty("ClinicaInstagram_Z", gxTv_SdtClinica_Clinicainstagram_Z, false, includeNonInitialized);
         AddObjectProperty("ClinicaLinkedin_Z", gxTv_SdtClinica_Clinicalinkedin_Z, false, includeNonInitialized);
         AddObjectProperty("ClinicaTiempoDeCita_Z", gxTv_SdtClinica_Clinicatiempodecita_Z, false, includeNonInitialized);
         AddObjectProperty("ClinicaEstado_Z", gxTv_SdtClinica_Clinicaestado_Z, false, includeNonInitialized);
         AddObjectProperty("ClinicaLogo_GXI_Z", gxTv_SdtClinica_Clinicalogo_gxi_Z, false, includeNonInitialized);
         AddObjectProperty("ClinicaLogoHeader_GXI_Z", gxTv_SdtClinica_Clinicalogoheader_gxi_Z, false, includeNonInitialized);
         AddObjectProperty("ClinicaLogoFactura_GXI_Z", gxTv_SdtClinica_Clinicalogofactura_gxi_Z, false, includeNonInitialized);
         AddObjectProperty("ClinicaLogoBoleta_GXI_Z", gxTv_SdtClinica_Clinicalogoboleta_gxi_Z, false, includeNonInitialized);
         AddObjectProperty("ClinicaLogoPago_GXI_Z", gxTv_SdtClinica_Clinicalogopago_gxi_Z, false, includeNonInitialized);
         AddObjectProperty("ClinicaLogoHeader_N", gxTv_SdtClinica_Clinicalogoheader_N, false, includeNonInitialized);
         AddObjectProperty("ClinicaLogoFactura_N", gxTv_SdtClinica_Clinicalogofactura_N, false, includeNonInitialized);
         AddObjectProperty("ClinicaLogoBoleta_N", gxTv_SdtClinica_Clinicalogoboleta_N, false, includeNonInitialized);
         AddObjectProperty("ClinicaLogoPago_N", gxTv_SdtClinica_Clinicalogopago_N, false, includeNonInitialized);
         AddObjectProperty("ClinicaLogoHeader_GXI_N", gxTv_SdtClinica_Clinicalogoheader_gxi_N, false, includeNonInitialized);
         AddObjectProperty("ClinicaLogoFactura_GXI_N", gxTv_SdtClinica_Clinicalogofactura_gxi_N, false, includeNonInitialized);
         AddObjectProperty("ClinicaLogoBoleta_GXI_N", gxTv_SdtClinica_Clinicalogoboleta_gxi_N, false, includeNonInitialized);
         AddObjectProperty("ClinicaLogoPago_GXI_N", gxTv_SdtClinica_Clinicalogopago_gxi_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.projectthani.SdtClinica sdt )
   {
      if ( sdt.IsDirty("ClinicaId") )
      {
         gxTv_SdtClinica_N = (byte)(0) ;
         gxTv_SdtClinica_Clinicaid = sdt.getgxTv_SdtClinica_Clinicaid() ;
      }
      if ( sdt.IsDirty("ClinicaRUC") )
      {
         gxTv_SdtClinica_N = (byte)(0) ;
         gxTv_SdtClinica_Clinicaruc = sdt.getgxTv_SdtClinica_Clinicaruc() ;
      }
      if ( sdt.IsDirty("ClinicaNombreComercial") )
      {
         gxTv_SdtClinica_N = (byte)(0) ;
         gxTv_SdtClinica_Clinicanombrecomercial = sdt.getgxTv_SdtClinica_Clinicanombrecomercial() ;
      }
      if ( sdt.IsDirty("ClinicaNombreAbreviado") )
      {
         gxTv_SdtClinica_N = (byte)(0) ;
         gxTv_SdtClinica_Clinicanombreabreviado = sdt.getgxTv_SdtClinica_Clinicanombreabreviado() ;
      }
      if ( sdt.IsDirty("ClinicaDireccionComercial") )
      {
         gxTv_SdtClinica_N = (byte)(0) ;
         gxTv_SdtClinica_Clinicadireccioncomercial = sdt.getgxTv_SdtClinica_Clinicadireccioncomercial() ;
      }
      if ( sdt.IsDirty("ClinicaCorreo") )
      {
         gxTv_SdtClinica_N = (byte)(0) ;
         gxTv_SdtClinica_Clinicacorreo = sdt.getgxTv_SdtClinica_Clinicacorreo() ;
      }
      if ( sdt.IsDirty("ClinicaMoneda") )
      {
         gxTv_SdtClinica_N = (byte)(0) ;
         gxTv_SdtClinica_Clinicamoneda = sdt.getgxTv_SdtClinica_Clinicamoneda() ;
      }
      if ( sdt.IsDirty("ClinicaLogo") )
      {
         gxTv_SdtClinica_N = (byte)(0) ;
         gxTv_SdtClinica_Clinicalogo = sdt.getgxTv_SdtClinica_Clinicalogo() ;
      }
      if ( sdt.IsDirty("ClinicaLogo") )
      {
         gxTv_SdtClinica_N = (byte)(0) ;
         gxTv_SdtClinica_Clinicalogo_gxi = sdt.getgxTv_SdtClinica_Clinicalogo_gxi() ;
      }
      if ( sdt.IsDirty("ClinicaLogoHeader") )
      {
         gxTv_SdtClinica_Clinicalogoheader_N = (byte)(0) ;
         gxTv_SdtClinica_N = (byte)(0) ;
         gxTv_SdtClinica_Clinicalogoheader = sdt.getgxTv_SdtClinica_Clinicalogoheader() ;
      }
      if ( sdt.IsDirty("ClinicaLogoHeader") )
      {
         gxTv_SdtClinica_Clinicalogoheader_gxi_N = (byte)(0) ;
         gxTv_SdtClinica_N = (byte)(0) ;
         gxTv_SdtClinica_Clinicalogoheader_gxi = sdt.getgxTv_SdtClinica_Clinicalogoheader_gxi() ;
      }
      if ( sdt.IsDirty("ClinicaLogoFactura") )
      {
         gxTv_SdtClinica_Clinicalogofactura_N = (byte)(0) ;
         gxTv_SdtClinica_N = (byte)(0) ;
         gxTv_SdtClinica_Clinicalogofactura = sdt.getgxTv_SdtClinica_Clinicalogofactura() ;
      }
      if ( sdt.IsDirty("ClinicaLogoFactura") )
      {
         gxTv_SdtClinica_Clinicalogofactura_gxi_N = (byte)(0) ;
         gxTv_SdtClinica_N = (byte)(0) ;
         gxTv_SdtClinica_Clinicalogofactura_gxi = sdt.getgxTv_SdtClinica_Clinicalogofactura_gxi() ;
      }
      if ( sdt.IsDirty("ClinicaLogoBoleta") )
      {
         gxTv_SdtClinica_Clinicalogoboleta_N = (byte)(0) ;
         gxTv_SdtClinica_N = (byte)(0) ;
         gxTv_SdtClinica_Clinicalogoboleta = sdt.getgxTv_SdtClinica_Clinicalogoboleta() ;
      }
      if ( sdt.IsDirty("ClinicaLogoBoleta") )
      {
         gxTv_SdtClinica_Clinicalogoboleta_gxi_N = (byte)(0) ;
         gxTv_SdtClinica_N = (byte)(0) ;
         gxTv_SdtClinica_Clinicalogoboleta_gxi = sdt.getgxTv_SdtClinica_Clinicalogoboleta_gxi() ;
      }
      if ( sdt.IsDirty("ClinicaLogoPago") )
      {
         gxTv_SdtClinica_Clinicalogopago_N = (byte)(0) ;
         gxTv_SdtClinica_N = (byte)(0) ;
         gxTv_SdtClinica_Clinicalogopago = sdt.getgxTv_SdtClinica_Clinicalogopago() ;
      }
      if ( sdt.IsDirty("ClinicaLogoPago") )
      {
         gxTv_SdtClinica_Clinicalogopago_gxi_N = (byte)(0) ;
         gxTv_SdtClinica_N = (byte)(0) ;
         gxTv_SdtClinica_Clinicalogopago_gxi = sdt.getgxTv_SdtClinica_Clinicalogopago_gxi() ;
      }
      if ( sdt.IsDirty("ClinicaTelefono") )
      {
         gxTv_SdtClinica_N = (byte)(0) ;
         gxTv_SdtClinica_Clinicatelefono = sdt.getgxTv_SdtClinica_Clinicatelefono() ;
      }
      if ( sdt.IsDirty("ClinicaWhatsApp") )
      {
         gxTv_SdtClinica_N = (byte)(0) ;
         gxTv_SdtClinica_Clinicawhatsapp = sdt.getgxTv_SdtClinica_Clinicawhatsapp() ;
      }
      if ( sdt.IsDirty("ClinicaFacebook") )
      {
         gxTv_SdtClinica_N = (byte)(0) ;
         gxTv_SdtClinica_Clinicafacebook = sdt.getgxTv_SdtClinica_Clinicafacebook() ;
      }
      if ( sdt.IsDirty("ClinicaTwiter") )
      {
         gxTv_SdtClinica_N = (byte)(0) ;
         gxTv_SdtClinica_Clinicatwiter = sdt.getgxTv_SdtClinica_Clinicatwiter() ;
      }
      if ( sdt.IsDirty("ClinicaInstagram") )
      {
         gxTv_SdtClinica_N = (byte)(0) ;
         gxTv_SdtClinica_Clinicainstagram = sdt.getgxTv_SdtClinica_Clinicainstagram() ;
      }
      if ( sdt.IsDirty("ClinicaLinkedin") )
      {
         gxTv_SdtClinica_N = (byte)(0) ;
         gxTv_SdtClinica_Clinicalinkedin = sdt.getgxTv_SdtClinica_Clinicalinkedin() ;
      }
      if ( sdt.IsDirty("ClinicaTiempoDeCita") )
      {
         gxTv_SdtClinica_N = (byte)(0) ;
         gxTv_SdtClinica_Clinicatiempodecita = sdt.getgxTv_SdtClinica_Clinicatiempodecita() ;
      }
      if ( sdt.IsDirty("ClinicaEstado") )
      {
         gxTv_SdtClinica_N = (byte)(0) ;
         gxTv_SdtClinica_Clinicaestado = sdt.getgxTv_SdtClinica_Clinicaestado() ;
      }
   }

   public short getgxTv_SdtClinica_Clinicaid( )
   {
      return gxTv_SdtClinica_Clinicaid ;
   }

   public void setgxTv_SdtClinica_Clinicaid( short value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      if ( gxTv_SdtClinica_Clinicaid != value )
      {
         gxTv_SdtClinica_Mode = "INS" ;
         this.setgxTv_SdtClinica_Clinicaid_Z_SetNull( );
         this.setgxTv_SdtClinica_Clinicaruc_Z_SetNull( );
         this.setgxTv_SdtClinica_Clinicanombrecomercial_Z_SetNull( );
         this.setgxTv_SdtClinica_Clinicanombreabreviado_Z_SetNull( );
         this.setgxTv_SdtClinica_Clinicadireccioncomercial_Z_SetNull( );
         this.setgxTv_SdtClinica_Clinicacorreo_Z_SetNull( );
         this.setgxTv_SdtClinica_Clinicamoneda_Z_SetNull( );
         this.setgxTv_SdtClinica_Clinicatelefono_Z_SetNull( );
         this.setgxTv_SdtClinica_Clinicawhatsapp_Z_SetNull( );
         this.setgxTv_SdtClinica_Clinicafacebook_Z_SetNull( );
         this.setgxTv_SdtClinica_Clinicatwiter_Z_SetNull( );
         this.setgxTv_SdtClinica_Clinicainstagram_Z_SetNull( );
         this.setgxTv_SdtClinica_Clinicalinkedin_Z_SetNull( );
         this.setgxTv_SdtClinica_Clinicatiempodecita_Z_SetNull( );
         this.setgxTv_SdtClinica_Clinicaestado_Z_SetNull( );
         this.setgxTv_SdtClinica_Clinicalogo_gxi_Z_SetNull( );
         this.setgxTv_SdtClinica_Clinicalogoheader_gxi_Z_SetNull( );
         this.setgxTv_SdtClinica_Clinicalogofactura_gxi_Z_SetNull( );
         this.setgxTv_SdtClinica_Clinicalogoboleta_gxi_Z_SetNull( );
         this.setgxTv_SdtClinica_Clinicalogopago_gxi_Z_SetNull( );
      }
      SetDirty("Clinicaid");
      gxTv_SdtClinica_Clinicaid = value ;
   }

   public long getgxTv_SdtClinica_Clinicaruc( )
   {
      return gxTv_SdtClinica_Clinicaruc ;
   }

   public void setgxTv_SdtClinica_Clinicaruc( long value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicaruc");
      gxTv_SdtClinica_Clinicaruc = value ;
   }

   public String getgxTv_SdtClinica_Clinicanombrecomercial( )
   {
      return gxTv_SdtClinica_Clinicanombrecomercial ;
   }

   public void setgxTv_SdtClinica_Clinicanombrecomercial( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicanombrecomercial");
      gxTv_SdtClinica_Clinicanombrecomercial = value ;
   }

   public String getgxTv_SdtClinica_Clinicanombreabreviado( )
   {
      return gxTv_SdtClinica_Clinicanombreabreviado ;
   }

   public void setgxTv_SdtClinica_Clinicanombreabreviado( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicanombreabreviado");
      gxTv_SdtClinica_Clinicanombreabreviado = value ;
   }

   public String getgxTv_SdtClinica_Clinicadireccioncomercial( )
   {
      return gxTv_SdtClinica_Clinicadireccioncomercial ;
   }

   public void setgxTv_SdtClinica_Clinicadireccioncomercial( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicadireccioncomercial");
      gxTv_SdtClinica_Clinicadireccioncomercial = value ;
   }

   public String getgxTv_SdtClinica_Clinicacorreo( )
   {
      return gxTv_SdtClinica_Clinicacorreo ;
   }

   public void setgxTv_SdtClinica_Clinicacorreo( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicacorreo");
      gxTv_SdtClinica_Clinicacorreo = value ;
   }

   public short getgxTv_SdtClinica_Clinicamoneda( )
   {
      return gxTv_SdtClinica_Clinicamoneda ;
   }

   public void setgxTv_SdtClinica_Clinicamoneda( short value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicamoneda");
      gxTv_SdtClinica_Clinicamoneda = value ;
   }

   @GxUpload
   public String getgxTv_SdtClinica_Clinicalogo( )
   {
      return gxTv_SdtClinica_Clinicalogo ;
   }

   public void setgxTv_SdtClinica_Clinicalogo( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicalogo");
      gxTv_SdtClinica_Clinicalogo = value ;
   }

   public String getgxTv_SdtClinica_Clinicalogo_gxi( )
   {
      return gxTv_SdtClinica_Clinicalogo_gxi ;
   }

   public void setgxTv_SdtClinica_Clinicalogo_gxi( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicalogo_gxi");
      gxTv_SdtClinica_Clinicalogo_gxi = value ;
   }

   @GxUpload
   public String getgxTv_SdtClinica_Clinicalogoheader( )
   {
      return gxTv_SdtClinica_Clinicalogoheader ;
   }

   public void setgxTv_SdtClinica_Clinicalogoheader( String value )
   {
      gxTv_SdtClinica_Clinicalogoheader_N = (byte)(0) ;
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicalogoheader");
      gxTv_SdtClinica_Clinicalogoheader = value ;
   }

   public void setgxTv_SdtClinica_Clinicalogoheader_SetNull( )
   {
      gxTv_SdtClinica_Clinicalogoheader_N = (byte)(1) ;
      gxTv_SdtClinica_Clinicalogoheader = "" ;
   }

   public boolean getgxTv_SdtClinica_Clinicalogoheader_IsNull( )
   {
      return (gxTv_SdtClinica_Clinicalogoheader_N==1) ;
   }

   public String getgxTv_SdtClinica_Clinicalogoheader_gxi( )
   {
      return gxTv_SdtClinica_Clinicalogoheader_gxi ;
   }

   public void setgxTv_SdtClinica_Clinicalogoheader_gxi( String value )
   {
      gxTv_SdtClinica_Clinicalogoheader_gxi_N = (byte)(0) ;
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicalogoheader_gxi");
      gxTv_SdtClinica_Clinicalogoheader_gxi = value ;
   }

   public void setgxTv_SdtClinica_Clinicalogoheader_gxi_SetNull( )
   {
      gxTv_SdtClinica_Clinicalogoheader_gxi_N = (byte)(1) ;
      gxTv_SdtClinica_Clinicalogoheader_gxi = "" ;
   }

   public boolean getgxTv_SdtClinica_Clinicalogoheader_gxi_IsNull( )
   {
      return (gxTv_SdtClinica_Clinicalogoheader_gxi_N==1) ;
   }

   @GxUpload
   public String getgxTv_SdtClinica_Clinicalogofactura( )
   {
      return gxTv_SdtClinica_Clinicalogofactura ;
   }

   public void setgxTv_SdtClinica_Clinicalogofactura( String value )
   {
      gxTv_SdtClinica_Clinicalogofactura_N = (byte)(0) ;
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicalogofactura");
      gxTv_SdtClinica_Clinicalogofactura = value ;
   }

   public void setgxTv_SdtClinica_Clinicalogofactura_SetNull( )
   {
      gxTv_SdtClinica_Clinicalogofactura_N = (byte)(1) ;
      gxTv_SdtClinica_Clinicalogofactura = "" ;
   }

   public boolean getgxTv_SdtClinica_Clinicalogofactura_IsNull( )
   {
      return (gxTv_SdtClinica_Clinicalogofactura_N==1) ;
   }

   public String getgxTv_SdtClinica_Clinicalogofactura_gxi( )
   {
      return gxTv_SdtClinica_Clinicalogofactura_gxi ;
   }

   public void setgxTv_SdtClinica_Clinicalogofactura_gxi( String value )
   {
      gxTv_SdtClinica_Clinicalogofactura_gxi_N = (byte)(0) ;
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicalogofactura_gxi");
      gxTv_SdtClinica_Clinicalogofactura_gxi = value ;
   }

   public void setgxTv_SdtClinica_Clinicalogofactura_gxi_SetNull( )
   {
      gxTv_SdtClinica_Clinicalogofactura_gxi_N = (byte)(1) ;
      gxTv_SdtClinica_Clinicalogofactura_gxi = "" ;
   }

   public boolean getgxTv_SdtClinica_Clinicalogofactura_gxi_IsNull( )
   {
      return (gxTv_SdtClinica_Clinicalogofactura_gxi_N==1) ;
   }

   @GxUpload
   public String getgxTv_SdtClinica_Clinicalogoboleta( )
   {
      return gxTv_SdtClinica_Clinicalogoboleta ;
   }

   public void setgxTv_SdtClinica_Clinicalogoboleta( String value )
   {
      gxTv_SdtClinica_Clinicalogoboleta_N = (byte)(0) ;
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicalogoboleta");
      gxTv_SdtClinica_Clinicalogoboleta = value ;
   }

   public void setgxTv_SdtClinica_Clinicalogoboleta_SetNull( )
   {
      gxTv_SdtClinica_Clinicalogoboleta_N = (byte)(1) ;
      gxTv_SdtClinica_Clinicalogoboleta = "" ;
   }

   public boolean getgxTv_SdtClinica_Clinicalogoboleta_IsNull( )
   {
      return (gxTv_SdtClinica_Clinicalogoboleta_N==1) ;
   }

   public String getgxTv_SdtClinica_Clinicalogoboleta_gxi( )
   {
      return gxTv_SdtClinica_Clinicalogoboleta_gxi ;
   }

   public void setgxTv_SdtClinica_Clinicalogoboleta_gxi( String value )
   {
      gxTv_SdtClinica_Clinicalogoboleta_gxi_N = (byte)(0) ;
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicalogoboleta_gxi");
      gxTv_SdtClinica_Clinicalogoboleta_gxi = value ;
   }

   public void setgxTv_SdtClinica_Clinicalogoboleta_gxi_SetNull( )
   {
      gxTv_SdtClinica_Clinicalogoboleta_gxi_N = (byte)(1) ;
      gxTv_SdtClinica_Clinicalogoboleta_gxi = "" ;
   }

   public boolean getgxTv_SdtClinica_Clinicalogoboleta_gxi_IsNull( )
   {
      return (gxTv_SdtClinica_Clinicalogoboleta_gxi_N==1) ;
   }

   @GxUpload
   public String getgxTv_SdtClinica_Clinicalogopago( )
   {
      return gxTv_SdtClinica_Clinicalogopago ;
   }

   public void setgxTv_SdtClinica_Clinicalogopago( String value )
   {
      gxTv_SdtClinica_Clinicalogopago_N = (byte)(0) ;
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicalogopago");
      gxTv_SdtClinica_Clinicalogopago = value ;
   }

   public void setgxTv_SdtClinica_Clinicalogopago_SetNull( )
   {
      gxTv_SdtClinica_Clinicalogopago_N = (byte)(1) ;
      gxTv_SdtClinica_Clinicalogopago = "" ;
   }

   public boolean getgxTv_SdtClinica_Clinicalogopago_IsNull( )
   {
      return (gxTv_SdtClinica_Clinicalogopago_N==1) ;
   }

   public String getgxTv_SdtClinica_Clinicalogopago_gxi( )
   {
      return gxTv_SdtClinica_Clinicalogopago_gxi ;
   }

   public void setgxTv_SdtClinica_Clinicalogopago_gxi( String value )
   {
      gxTv_SdtClinica_Clinicalogopago_gxi_N = (byte)(0) ;
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicalogopago_gxi");
      gxTv_SdtClinica_Clinicalogopago_gxi = value ;
   }

   public void setgxTv_SdtClinica_Clinicalogopago_gxi_SetNull( )
   {
      gxTv_SdtClinica_Clinicalogopago_gxi_N = (byte)(1) ;
      gxTv_SdtClinica_Clinicalogopago_gxi = "" ;
   }

   public boolean getgxTv_SdtClinica_Clinicalogopago_gxi_IsNull( )
   {
      return (gxTv_SdtClinica_Clinicalogopago_gxi_N==1) ;
   }

   public String getgxTv_SdtClinica_Clinicatelefono( )
   {
      return gxTv_SdtClinica_Clinicatelefono ;
   }

   public void setgxTv_SdtClinica_Clinicatelefono( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicatelefono");
      gxTv_SdtClinica_Clinicatelefono = value ;
   }

   public String getgxTv_SdtClinica_Clinicawhatsapp( )
   {
      return gxTv_SdtClinica_Clinicawhatsapp ;
   }

   public void setgxTv_SdtClinica_Clinicawhatsapp( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicawhatsapp");
      gxTv_SdtClinica_Clinicawhatsapp = value ;
   }

   public String getgxTv_SdtClinica_Clinicafacebook( )
   {
      return gxTv_SdtClinica_Clinicafacebook ;
   }

   public void setgxTv_SdtClinica_Clinicafacebook( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicafacebook");
      gxTv_SdtClinica_Clinicafacebook = value ;
   }

   public String getgxTv_SdtClinica_Clinicatwiter( )
   {
      return gxTv_SdtClinica_Clinicatwiter ;
   }

   public void setgxTv_SdtClinica_Clinicatwiter( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicatwiter");
      gxTv_SdtClinica_Clinicatwiter = value ;
   }

   public String getgxTv_SdtClinica_Clinicainstagram( )
   {
      return gxTv_SdtClinica_Clinicainstagram ;
   }

   public void setgxTv_SdtClinica_Clinicainstagram( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicainstagram");
      gxTv_SdtClinica_Clinicainstagram = value ;
   }

   public String getgxTv_SdtClinica_Clinicalinkedin( )
   {
      return gxTv_SdtClinica_Clinicalinkedin ;
   }

   public void setgxTv_SdtClinica_Clinicalinkedin( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicalinkedin");
      gxTv_SdtClinica_Clinicalinkedin = value ;
   }

   public byte getgxTv_SdtClinica_Clinicatiempodecita( )
   {
      return gxTv_SdtClinica_Clinicatiempodecita ;
   }

   public void setgxTv_SdtClinica_Clinicatiempodecita( byte value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicatiempodecita");
      gxTv_SdtClinica_Clinicatiempodecita = value ;
   }

   public String getgxTv_SdtClinica_Clinicaestado( )
   {
      return gxTv_SdtClinica_Clinicaestado ;
   }

   public void setgxTv_SdtClinica_Clinicaestado( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicaestado");
      gxTv_SdtClinica_Clinicaestado = value ;
   }

   public String getgxTv_SdtClinica_Mode( )
   {
      return gxTv_SdtClinica_Mode ;
   }

   public void setgxTv_SdtClinica_Mode( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtClinica_Mode = value ;
   }

   public void setgxTv_SdtClinica_Mode_SetNull( )
   {
      gxTv_SdtClinica_Mode = "" ;
   }

   public boolean getgxTv_SdtClinica_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtClinica_Initialized( )
   {
      return gxTv_SdtClinica_Initialized ;
   }

   public void setgxTv_SdtClinica_Initialized( short value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtClinica_Initialized = value ;
   }

   public void setgxTv_SdtClinica_Initialized_SetNull( )
   {
      gxTv_SdtClinica_Initialized = (short)(0) ;
   }

   public boolean getgxTv_SdtClinica_Initialized_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtClinica_Clinicaid_Z( )
   {
      return gxTv_SdtClinica_Clinicaid_Z ;
   }

   public void setgxTv_SdtClinica_Clinicaid_Z( short value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicaid_Z");
      gxTv_SdtClinica_Clinicaid_Z = value ;
   }

   public void setgxTv_SdtClinica_Clinicaid_Z_SetNull( )
   {
      gxTv_SdtClinica_Clinicaid_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtClinica_Clinicaid_Z_IsNull( )
   {
      return false ;
   }

   public long getgxTv_SdtClinica_Clinicaruc_Z( )
   {
      return gxTv_SdtClinica_Clinicaruc_Z ;
   }

   public void setgxTv_SdtClinica_Clinicaruc_Z( long value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicaruc_Z");
      gxTv_SdtClinica_Clinicaruc_Z = value ;
   }

   public void setgxTv_SdtClinica_Clinicaruc_Z_SetNull( )
   {
      gxTv_SdtClinica_Clinicaruc_Z = 0 ;
   }

   public boolean getgxTv_SdtClinica_Clinicaruc_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtClinica_Clinicanombrecomercial_Z( )
   {
      return gxTv_SdtClinica_Clinicanombrecomercial_Z ;
   }

   public void setgxTv_SdtClinica_Clinicanombrecomercial_Z( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicanombrecomercial_Z");
      gxTv_SdtClinica_Clinicanombrecomercial_Z = value ;
   }

   public void setgxTv_SdtClinica_Clinicanombrecomercial_Z_SetNull( )
   {
      gxTv_SdtClinica_Clinicanombrecomercial_Z = "" ;
   }

   public boolean getgxTv_SdtClinica_Clinicanombrecomercial_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtClinica_Clinicanombreabreviado_Z( )
   {
      return gxTv_SdtClinica_Clinicanombreabreviado_Z ;
   }

   public void setgxTv_SdtClinica_Clinicanombreabreviado_Z( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicanombreabreviado_Z");
      gxTv_SdtClinica_Clinicanombreabreviado_Z = value ;
   }

   public void setgxTv_SdtClinica_Clinicanombreabreviado_Z_SetNull( )
   {
      gxTv_SdtClinica_Clinicanombreabreviado_Z = "" ;
   }

   public boolean getgxTv_SdtClinica_Clinicanombreabreviado_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtClinica_Clinicadireccioncomercial_Z( )
   {
      return gxTv_SdtClinica_Clinicadireccioncomercial_Z ;
   }

   public void setgxTv_SdtClinica_Clinicadireccioncomercial_Z( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicadireccioncomercial_Z");
      gxTv_SdtClinica_Clinicadireccioncomercial_Z = value ;
   }

   public void setgxTv_SdtClinica_Clinicadireccioncomercial_Z_SetNull( )
   {
      gxTv_SdtClinica_Clinicadireccioncomercial_Z = "" ;
   }

   public boolean getgxTv_SdtClinica_Clinicadireccioncomercial_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtClinica_Clinicacorreo_Z( )
   {
      return gxTv_SdtClinica_Clinicacorreo_Z ;
   }

   public void setgxTv_SdtClinica_Clinicacorreo_Z( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicacorreo_Z");
      gxTv_SdtClinica_Clinicacorreo_Z = value ;
   }

   public void setgxTv_SdtClinica_Clinicacorreo_Z_SetNull( )
   {
      gxTv_SdtClinica_Clinicacorreo_Z = "" ;
   }

   public boolean getgxTv_SdtClinica_Clinicacorreo_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtClinica_Clinicamoneda_Z( )
   {
      return gxTv_SdtClinica_Clinicamoneda_Z ;
   }

   public void setgxTv_SdtClinica_Clinicamoneda_Z( short value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicamoneda_Z");
      gxTv_SdtClinica_Clinicamoneda_Z = value ;
   }

   public void setgxTv_SdtClinica_Clinicamoneda_Z_SetNull( )
   {
      gxTv_SdtClinica_Clinicamoneda_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtClinica_Clinicamoneda_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtClinica_Clinicatelefono_Z( )
   {
      return gxTv_SdtClinica_Clinicatelefono_Z ;
   }

   public void setgxTv_SdtClinica_Clinicatelefono_Z( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicatelefono_Z");
      gxTv_SdtClinica_Clinicatelefono_Z = value ;
   }

   public void setgxTv_SdtClinica_Clinicatelefono_Z_SetNull( )
   {
      gxTv_SdtClinica_Clinicatelefono_Z = "" ;
   }

   public boolean getgxTv_SdtClinica_Clinicatelefono_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtClinica_Clinicawhatsapp_Z( )
   {
      return gxTv_SdtClinica_Clinicawhatsapp_Z ;
   }

   public void setgxTv_SdtClinica_Clinicawhatsapp_Z( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicawhatsapp_Z");
      gxTv_SdtClinica_Clinicawhatsapp_Z = value ;
   }

   public void setgxTv_SdtClinica_Clinicawhatsapp_Z_SetNull( )
   {
      gxTv_SdtClinica_Clinicawhatsapp_Z = "" ;
   }

   public boolean getgxTv_SdtClinica_Clinicawhatsapp_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtClinica_Clinicafacebook_Z( )
   {
      return gxTv_SdtClinica_Clinicafacebook_Z ;
   }

   public void setgxTv_SdtClinica_Clinicafacebook_Z( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicafacebook_Z");
      gxTv_SdtClinica_Clinicafacebook_Z = value ;
   }

   public void setgxTv_SdtClinica_Clinicafacebook_Z_SetNull( )
   {
      gxTv_SdtClinica_Clinicafacebook_Z = "" ;
   }

   public boolean getgxTv_SdtClinica_Clinicafacebook_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtClinica_Clinicatwiter_Z( )
   {
      return gxTv_SdtClinica_Clinicatwiter_Z ;
   }

   public void setgxTv_SdtClinica_Clinicatwiter_Z( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicatwiter_Z");
      gxTv_SdtClinica_Clinicatwiter_Z = value ;
   }

   public void setgxTv_SdtClinica_Clinicatwiter_Z_SetNull( )
   {
      gxTv_SdtClinica_Clinicatwiter_Z = "" ;
   }

   public boolean getgxTv_SdtClinica_Clinicatwiter_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtClinica_Clinicainstagram_Z( )
   {
      return gxTv_SdtClinica_Clinicainstagram_Z ;
   }

   public void setgxTv_SdtClinica_Clinicainstagram_Z( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicainstagram_Z");
      gxTv_SdtClinica_Clinicainstagram_Z = value ;
   }

   public void setgxTv_SdtClinica_Clinicainstagram_Z_SetNull( )
   {
      gxTv_SdtClinica_Clinicainstagram_Z = "" ;
   }

   public boolean getgxTv_SdtClinica_Clinicainstagram_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtClinica_Clinicalinkedin_Z( )
   {
      return gxTv_SdtClinica_Clinicalinkedin_Z ;
   }

   public void setgxTv_SdtClinica_Clinicalinkedin_Z( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicalinkedin_Z");
      gxTv_SdtClinica_Clinicalinkedin_Z = value ;
   }

   public void setgxTv_SdtClinica_Clinicalinkedin_Z_SetNull( )
   {
      gxTv_SdtClinica_Clinicalinkedin_Z = "" ;
   }

   public boolean getgxTv_SdtClinica_Clinicalinkedin_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtClinica_Clinicatiempodecita_Z( )
   {
      return gxTv_SdtClinica_Clinicatiempodecita_Z ;
   }

   public void setgxTv_SdtClinica_Clinicatiempodecita_Z( byte value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicatiempodecita_Z");
      gxTv_SdtClinica_Clinicatiempodecita_Z = value ;
   }

   public void setgxTv_SdtClinica_Clinicatiempodecita_Z_SetNull( )
   {
      gxTv_SdtClinica_Clinicatiempodecita_Z = (byte)(0) ;
   }

   public boolean getgxTv_SdtClinica_Clinicatiempodecita_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtClinica_Clinicaestado_Z( )
   {
      return gxTv_SdtClinica_Clinicaestado_Z ;
   }

   public void setgxTv_SdtClinica_Clinicaestado_Z( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicaestado_Z");
      gxTv_SdtClinica_Clinicaestado_Z = value ;
   }

   public void setgxTv_SdtClinica_Clinicaestado_Z_SetNull( )
   {
      gxTv_SdtClinica_Clinicaestado_Z = "" ;
   }

   public boolean getgxTv_SdtClinica_Clinicaestado_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtClinica_Clinicalogo_gxi_Z( )
   {
      return gxTv_SdtClinica_Clinicalogo_gxi_Z ;
   }

   public void setgxTv_SdtClinica_Clinicalogo_gxi_Z( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicalogo_gxi_Z");
      gxTv_SdtClinica_Clinicalogo_gxi_Z = value ;
   }

   public void setgxTv_SdtClinica_Clinicalogo_gxi_Z_SetNull( )
   {
      gxTv_SdtClinica_Clinicalogo_gxi_Z = "" ;
   }

   public boolean getgxTv_SdtClinica_Clinicalogo_gxi_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtClinica_Clinicalogoheader_gxi_Z( )
   {
      return gxTv_SdtClinica_Clinicalogoheader_gxi_Z ;
   }

   public void setgxTv_SdtClinica_Clinicalogoheader_gxi_Z( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicalogoheader_gxi_Z");
      gxTv_SdtClinica_Clinicalogoheader_gxi_Z = value ;
   }

   public void setgxTv_SdtClinica_Clinicalogoheader_gxi_Z_SetNull( )
   {
      gxTv_SdtClinica_Clinicalogoheader_gxi_Z = "" ;
   }

   public boolean getgxTv_SdtClinica_Clinicalogoheader_gxi_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtClinica_Clinicalogofactura_gxi_Z( )
   {
      return gxTv_SdtClinica_Clinicalogofactura_gxi_Z ;
   }

   public void setgxTv_SdtClinica_Clinicalogofactura_gxi_Z( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicalogofactura_gxi_Z");
      gxTv_SdtClinica_Clinicalogofactura_gxi_Z = value ;
   }

   public void setgxTv_SdtClinica_Clinicalogofactura_gxi_Z_SetNull( )
   {
      gxTv_SdtClinica_Clinicalogofactura_gxi_Z = "" ;
   }

   public boolean getgxTv_SdtClinica_Clinicalogofactura_gxi_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtClinica_Clinicalogoboleta_gxi_Z( )
   {
      return gxTv_SdtClinica_Clinicalogoboleta_gxi_Z ;
   }

   public void setgxTv_SdtClinica_Clinicalogoboleta_gxi_Z( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicalogoboleta_gxi_Z");
      gxTv_SdtClinica_Clinicalogoboleta_gxi_Z = value ;
   }

   public void setgxTv_SdtClinica_Clinicalogoboleta_gxi_Z_SetNull( )
   {
      gxTv_SdtClinica_Clinicalogoboleta_gxi_Z = "" ;
   }

   public boolean getgxTv_SdtClinica_Clinicalogoboleta_gxi_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtClinica_Clinicalogopago_gxi_Z( )
   {
      return gxTv_SdtClinica_Clinicalogopago_gxi_Z ;
   }

   public void setgxTv_SdtClinica_Clinicalogopago_gxi_Z( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicalogopago_gxi_Z");
      gxTv_SdtClinica_Clinicalogopago_gxi_Z = value ;
   }

   public void setgxTv_SdtClinica_Clinicalogopago_gxi_Z_SetNull( )
   {
      gxTv_SdtClinica_Clinicalogopago_gxi_Z = "" ;
   }

   public boolean getgxTv_SdtClinica_Clinicalogopago_gxi_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtClinica_Clinicalogoheader_N( )
   {
      return gxTv_SdtClinica_Clinicalogoheader_N ;
   }

   public void setgxTv_SdtClinica_Clinicalogoheader_N( byte value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicalogoheader_N");
      gxTv_SdtClinica_Clinicalogoheader_N = value ;
   }

   public void setgxTv_SdtClinica_Clinicalogoheader_N_SetNull( )
   {
      gxTv_SdtClinica_Clinicalogoheader_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtClinica_Clinicalogoheader_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtClinica_Clinicalogofactura_N( )
   {
      return gxTv_SdtClinica_Clinicalogofactura_N ;
   }

   public void setgxTv_SdtClinica_Clinicalogofactura_N( byte value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicalogofactura_N");
      gxTv_SdtClinica_Clinicalogofactura_N = value ;
   }

   public void setgxTv_SdtClinica_Clinicalogofactura_N_SetNull( )
   {
      gxTv_SdtClinica_Clinicalogofactura_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtClinica_Clinicalogofactura_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtClinica_Clinicalogoboleta_N( )
   {
      return gxTv_SdtClinica_Clinicalogoboleta_N ;
   }

   public void setgxTv_SdtClinica_Clinicalogoboleta_N( byte value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicalogoboleta_N");
      gxTv_SdtClinica_Clinicalogoboleta_N = value ;
   }

   public void setgxTv_SdtClinica_Clinicalogoboleta_N_SetNull( )
   {
      gxTv_SdtClinica_Clinicalogoboleta_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtClinica_Clinicalogoboleta_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtClinica_Clinicalogopago_N( )
   {
      return gxTv_SdtClinica_Clinicalogopago_N ;
   }

   public void setgxTv_SdtClinica_Clinicalogopago_N( byte value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicalogopago_N");
      gxTv_SdtClinica_Clinicalogopago_N = value ;
   }

   public void setgxTv_SdtClinica_Clinicalogopago_N_SetNull( )
   {
      gxTv_SdtClinica_Clinicalogopago_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtClinica_Clinicalogopago_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtClinica_Clinicalogoheader_gxi_N( )
   {
      return gxTv_SdtClinica_Clinicalogoheader_gxi_N ;
   }

   public void setgxTv_SdtClinica_Clinicalogoheader_gxi_N( byte value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicalogoheader_gxi_N");
      gxTv_SdtClinica_Clinicalogoheader_gxi_N = value ;
   }

   public void setgxTv_SdtClinica_Clinicalogoheader_gxi_N_SetNull( )
   {
      gxTv_SdtClinica_Clinicalogoheader_gxi_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtClinica_Clinicalogoheader_gxi_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtClinica_Clinicalogofactura_gxi_N( )
   {
      return gxTv_SdtClinica_Clinicalogofactura_gxi_N ;
   }

   public void setgxTv_SdtClinica_Clinicalogofactura_gxi_N( byte value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicalogofactura_gxi_N");
      gxTv_SdtClinica_Clinicalogofactura_gxi_N = value ;
   }

   public void setgxTv_SdtClinica_Clinicalogofactura_gxi_N_SetNull( )
   {
      gxTv_SdtClinica_Clinicalogofactura_gxi_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtClinica_Clinicalogofactura_gxi_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtClinica_Clinicalogoboleta_gxi_N( )
   {
      return gxTv_SdtClinica_Clinicalogoboleta_gxi_N ;
   }

   public void setgxTv_SdtClinica_Clinicalogoboleta_gxi_N( byte value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicalogoboleta_gxi_N");
      gxTv_SdtClinica_Clinicalogoboleta_gxi_N = value ;
   }

   public void setgxTv_SdtClinica_Clinicalogoboleta_gxi_N_SetNull( )
   {
      gxTv_SdtClinica_Clinicalogoboleta_gxi_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtClinica_Clinicalogoboleta_gxi_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtClinica_Clinicalogopago_gxi_N( )
   {
      return gxTv_SdtClinica_Clinicalogopago_gxi_N ;
   }

   public void setgxTv_SdtClinica_Clinicalogopago_gxi_N( byte value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      SetDirty("Clinicalogopago_gxi_N");
      gxTv_SdtClinica_Clinicalogopago_gxi_N = value ;
   }

   public void setgxTv_SdtClinica_Clinicalogopago_gxi_N_SetNull( )
   {
      gxTv_SdtClinica_Clinicalogopago_gxi_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtClinica_Clinicalogopago_gxi_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.projectthani.clinica_bc obj;
      obj = new com.projectthani.clinica_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtClinica_N = (byte)(1) ;
      gxTv_SdtClinica_Clinicanombrecomercial = "" ;
      gxTv_SdtClinica_Clinicanombreabreviado = "" ;
      gxTv_SdtClinica_Clinicadireccioncomercial = "" ;
      gxTv_SdtClinica_Clinicacorreo = "" ;
      gxTv_SdtClinica_Clinicalogo = "" ;
      gxTv_SdtClinica_Clinicalogo_gxi = "" ;
      gxTv_SdtClinica_Clinicalogoheader = "" ;
      gxTv_SdtClinica_Clinicalogoheader_gxi = "" ;
      gxTv_SdtClinica_Clinicalogofactura = "" ;
      gxTv_SdtClinica_Clinicalogofactura_gxi = "" ;
      gxTv_SdtClinica_Clinicalogoboleta = "" ;
      gxTv_SdtClinica_Clinicalogoboleta_gxi = "" ;
      gxTv_SdtClinica_Clinicalogopago = "" ;
      gxTv_SdtClinica_Clinicalogopago_gxi = "" ;
      gxTv_SdtClinica_Clinicatelefono = "" ;
      gxTv_SdtClinica_Clinicawhatsapp = "" ;
      gxTv_SdtClinica_Clinicafacebook = "" ;
      gxTv_SdtClinica_Clinicatwiter = "" ;
      gxTv_SdtClinica_Clinicainstagram = "" ;
      gxTv_SdtClinica_Clinicalinkedin = "" ;
      gxTv_SdtClinica_Clinicaestado = "" ;
      gxTv_SdtClinica_Mode = "" ;
      gxTv_SdtClinica_Clinicanombrecomercial_Z = "" ;
      gxTv_SdtClinica_Clinicanombreabreviado_Z = "" ;
      gxTv_SdtClinica_Clinicadireccioncomercial_Z = "" ;
      gxTv_SdtClinica_Clinicacorreo_Z = "" ;
      gxTv_SdtClinica_Clinicatelefono_Z = "" ;
      gxTv_SdtClinica_Clinicawhatsapp_Z = "" ;
      gxTv_SdtClinica_Clinicafacebook_Z = "" ;
      gxTv_SdtClinica_Clinicatwiter_Z = "" ;
      gxTv_SdtClinica_Clinicainstagram_Z = "" ;
      gxTv_SdtClinica_Clinicalinkedin_Z = "" ;
      gxTv_SdtClinica_Clinicaestado_Z = "" ;
      gxTv_SdtClinica_Clinicalogo_gxi_Z = "" ;
      gxTv_SdtClinica_Clinicalogoheader_gxi_Z = "" ;
      gxTv_SdtClinica_Clinicalogofactura_gxi_Z = "" ;
      gxTv_SdtClinica_Clinicalogoboleta_gxi_Z = "" ;
      gxTv_SdtClinica_Clinicalogopago_gxi_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtClinica_N ;
   }

   public com.projectthani.SdtClinica Clone( )
   {
      com.projectthani.SdtClinica sdt;
      com.projectthani.clinica_bc obj;
      sdt = (com.projectthani.SdtClinica)(clone()) ;
      obj = (com.projectthani.clinica_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.projectthani.StructSdtClinica struct )
   {
      setgxTv_SdtClinica_Clinicaid(struct.getClinicaid());
      setgxTv_SdtClinica_Clinicaruc(struct.getClinicaruc());
      setgxTv_SdtClinica_Clinicanombrecomercial(struct.getClinicanombrecomercial());
      setgxTv_SdtClinica_Clinicanombreabreviado(struct.getClinicanombreabreviado());
      setgxTv_SdtClinica_Clinicadireccioncomercial(struct.getClinicadireccioncomercial());
      setgxTv_SdtClinica_Clinicacorreo(struct.getClinicacorreo());
      setgxTv_SdtClinica_Clinicamoneda(struct.getClinicamoneda());
      setgxTv_SdtClinica_Clinicalogo(struct.getClinicalogo());
      setgxTv_SdtClinica_Clinicalogo_gxi(struct.getClinicalogo_gxi());
      setgxTv_SdtClinica_Clinicalogoheader(struct.getClinicalogoheader());
      setgxTv_SdtClinica_Clinicalogoheader_gxi(struct.getClinicalogoheader_gxi());
      setgxTv_SdtClinica_Clinicalogofactura(struct.getClinicalogofactura());
      setgxTv_SdtClinica_Clinicalogofactura_gxi(struct.getClinicalogofactura_gxi());
      setgxTv_SdtClinica_Clinicalogoboleta(struct.getClinicalogoboleta());
      setgxTv_SdtClinica_Clinicalogoboleta_gxi(struct.getClinicalogoboleta_gxi());
      setgxTv_SdtClinica_Clinicalogopago(struct.getClinicalogopago());
      setgxTv_SdtClinica_Clinicalogopago_gxi(struct.getClinicalogopago_gxi());
      setgxTv_SdtClinica_Clinicatelefono(struct.getClinicatelefono());
      setgxTv_SdtClinica_Clinicawhatsapp(struct.getClinicawhatsapp());
      setgxTv_SdtClinica_Clinicafacebook(struct.getClinicafacebook());
      setgxTv_SdtClinica_Clinicatwiter(struct.getClinicatwiter());
      setgxTv_SdtClinica_Clinicainstagram(struct.getClinicainstagram());
      setgxTv_SdtClinica_Clinicalinkedin(struct.getClinicalinkedin());
      setgxTv_SdtClinica_Clinicatiempodecita(struct.getClinicatiempodecita());
      setgxTv_SdtClinica_Clinicaestado(struct.getClinicaestado());
      setgxTv_SdtClinica_Mode(struct.getMode());
      setgxTv_SdtClinica_Initialized(struct.getInitialized());
      setgxTv_SdtClinica_Clinicaid_Z(struct.getClinicaid_Z());
      setgxTv_SdtClinica_Clinicaruc_Z(struct.getClinicaruc_Z());
      setgxTv_SdtClinica_Clinicanombrecomercial_Z(struct.getClinicanombrecomercial_Z());
      setgxTv_SdtClinica_Clinicanombreabreviado_Z(struct.getClinicanombreabreviado_Z());
      setgxTv_SdtClinica_Clinicadireccioncomercial_Z(struct.getClinicadireccioncomercial_Z());
      setgxTv_SdtClinica_Clinicacorreo_Z(struct.getClinicacorreo_Z());
      setgxTv_SdtClinica_Clinicamoneda_Z(struct.getClinicamoneda_Z());
      setgxTv_SdtClinica_Clinicatelefono_Z(struct.getClinicatelefono_Z());
      setgxTv_SdtClinica_Clinicawhatsapp_Z(struct.getClinicawhatsapp_Z());
      setgxTv_SdtClinica_Clinicafacebook_Z(struct.getClinicafacebook_Z());
      setgxTv_SdtClinica_Clinicatwiter_Z(struct.getClinicatwiter_Z());
      setgxTv_SdtClinica_Clinicainstagram_Z(struct.getClinicainstagram_Z());
      setgxTv_SdtClinica_Clinicalinkedin_Z(struct.getClinicalinkedin_Z());
      setgxTv_SdtClinica_Clinicatiempodecita_Z(struct.getClinicatiempodecita_Z());
      setgxTv_SdtClinica_Clinicaestado_Z(struct.getClinicaestado_Z());
      setgxTv_SdtClinica_Clinicalogo_gxi_Z(struct.getClinicalogo_gxi_Z());
      setgxTv_SdtClinica_Clinicalogoheader_gxi_Z(struct.getClinicalogoheader_gxi_Z());
      setgxTv_SdtClinica_Clinicalogofactura_gxi_Z(struct.getClinicalogofactura_gxi_Z());
      setgxTv_SdtClinica_Clinicalogoboleta_gxi_Z(struct.getClinicalogoboleta_gxi_Z());
      setgxTv_SdtClinica_Clinicalogopago_gxi_Z(struct.getClinicalogopago_gxi_Z());
      setgxTv_SdtClinica_Clinicalogoheader_N(struct.getClinicalogoheader_N());
      setgxTv_SdtClinica_Clinicalogofactura_N(struct.getClinicalogofactura_N());
      setgxTv_SdtClinica_Clinicalogoboleta_N(struct.getClinicalogoboleta_N());
      setgxTv_SdtClinica_Clinicalogopago_N(struct.getClinicalogopago_N());
      setgxTv_SdtClinica_Clinicalogoheader_gxi_N(struct.getClinicalogoheader_gxi_N());
      setgxTv_SdtClinica_Clinicalogofactura_gxi_N(struct.getClinicalogofactura_gxi_N());
      setgxTv_SdtClinica_Clinicalogoboleta_gxi_N(struct.getClinicalogoboleta_gxi_N());
      setgxTv_SdtClinica_Clinicalogopago_gxi_N(struct.getClinicalogopago_gxi_N());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtClinica getStruct( )
   {
      com.projectthani.StructSdtClinica struct = new com.projectthani.StructSdtClinica ();
      struct.setClinicaid(getgxTv_SdtClinica_Clinicaid());
      struct.setClinicaruc(getgxTv_SdtClinica_Clinicaruc());
      struct.setClinicanombrecomercial(getgxTv_SdtClinica_Clinicanombrecomercial());
      struct.setClinicanombreabreviado(getgxTv_SdtClinica_Clinicanombreabreviado());
      struct.setClinicadireccioncomercial(getgxTv_SdtClinica_Clinicadireccioncomercial());
      struct.setClinicacorreo(getgxTv_SdtClinica_Clinicacorreo());
      struct.setClinicamoneda(getgxTv_SdtClinica_Clinicamoneda());
      struct.setClinicalogo(getgxTv_SdtClinica_Clinicalogo());
      struct.setClinicalogo_gxi(getgxTv_SdtClinica_Clinicalogo_gxi());
      struct.setClinicalogoheader(getgxTv_SdtClinica_Clinicalogoheader());
      struct.setClinicalogoheader_gxi(getgxTv_SdtClinica_Clinicalogoheader_gxi());
      struct.setClinicalogofactura(getgxTv_SdtClinica_Clinicalogofactura());
      struct.setClinicalogofactura_gxi(getgxTv_SdtClinica_Clinicalogofactura_gxi());
      struct.setClinicalogoboleta(getgxTv_SdtClinica_Clinicalogoboleta());
      struct.setClinicalogoboleta_gxi(getgxTv_SdtClinica_Clinicalogoboleta_gxi());
      struct.setClinicalogopago(getgxTv_SdtClinica_Clinicalogopago());
      struct.setClinicalogopago_gxi(getgxTv_SdtClinica_Clinicalogopago_gxi());
      struct.setClinicatelefono(getgxTv_SdtClinica_Clinicatelefono());
      struct.setClinicawhatsapp(getgxTv_SdtClinica_Clinicawhatsapp());
      struct.setClinicafacebook(getgxTv_SdtClinica_Clinicafacebook());
      struct.setClinicatwiter(getgxTv_SdtClinica_Clinicatwiter());
      struct.setClinicainstagram(getgxTv_SdtClinica_Clinicainstagram());
      struct.setClinicalinkedin(getgxTv_SdtClinica_Clinicalinkedin());
      struct.setClinicatiempodecita(getgxTv_SdtClinica_Clinicatiempodecita());
      struct.setClinicaestado(getgxTv_SdtClinica_Clinicaestado());
      struct.setMode(getgxTv_SdtClinica_Mode());
      struct.setInitialized(getgxTv_SdtClinica_Initialized());
      struct.setClinicaid_Z(getgxTv_SdtClinica_Clinicaid_Z());
      struct.setClinicaruc_Z(getgxTv_SdtClinica_Clinicaruc_Z());
      struct.setClinicanombrecomercial_Z(getgxTv_SdtClinica_Clinicanombrecomercial_Z());
      struct.setClinicanombreabreviado_Z(getgxTv_SdtClinica_Clinicanombreabreviado_Z());
      struct.setClinicadireccioncomercial_Z(getgxTv_SdtClinica_Clinicadireccioncomercial_Z());
      struct.setClinicacorreo_Z(getgxTv_SdtClinica_Clinicacorreo_Z());
      struct.setClinicamoneda_Z(getgxTv_SdtClinica_Clinicamoneda_Z());
      struct.setClinicatelefono_Z(getgxTv_SdtClinica_Clinicatelefono_Z());
      struct.setClinicawhatsapp_Z(getgxTv_SdtClinica_Clinicawhatsapp_Z());
      struct.setClinicafacebook_Z(getgxTv_SdtClinica_Clinicafacebook_Z());
      struct.setClinicatwiter_Z(getgxTv_SdtClinica_Clinicatwiter_Z());
      struct.setClinicainstagram_Z(getgxTv_SdtClinica_Clinicainstagram_Z());
      struct.setClinicalinkedin_Z(getgxTv_SdtClinica_Clinicalinkedin_Z());
      struct.setClinicatiempodecita_Z(getgxTv_SdtClinica_Clinicatiempodecita_Z());
      struct.setClinicaestado_Z(getgxTv_SdtClinica_Clinicaestado_Z());
      struct.setClinicalogo_gxi_Z(getgxTv_SdtClinica_Clinicalogo_gxi_Z());
      struct.setClinicalogoheader_gxi_Z(getgxTv_SdtClinica_Clinicalogoheader_gxi_Z());
      struct.setClinicalogofactura_gxi_Z(getgxTv_SdtClinica_Clinicalogofactura_gxi_Z());
      struct.setClinicalogoboleta_gxi_Z(getgxTv_SdtClinica_Clinicalogoboleta_gxi_Z());
      struct.setClinicalogopago_gxi_Z(getgxTv_SdtClinica_Clinicalogopago_gxi_Z());
      struct.setClinicalogoheader_N(getgxTv_SdtClinica_Clinicalogoheader_N());
      struct.setClinicalogofactura_N(getgxTv_SdtClinica_Clinicalogofactura_N());
      struct.setClinicalogoboleta_N(getgxTv_SdtClinica_Clinicalogoboleta_N());
      struct.setClinicalogopago_N(getgxTv_SdtClinica_Clinicalogopago_N());
      struct.setClinicalogoheader_gxi_N(getgxTv_SdtClinica_Clinicalogoheader_gxi_N());
      struct.setClinicalogofactura_gxi_N(getgxTv_SdtClinica_Clinicalogofactura_gxi_N());
      struct.setClinicalogoboleta_gxi_N(getgxTv_SdtClinica_Clinicalogoboleta_gxi_N());
      struct.setClinicalogopago_gxi_N(getgxTv_SdtClinica_Clinicalogopago_gxi_N());
      return struct ;
   }

   private byte gxTv_SdtClinica_N ;
   private byte gxTv_SdtClinica_Clinicatiempodecita ;
   private byte gxTv_SdtClinica_Clinicatiempodecita_Z ;
   private byte gxTv_SdtClinica_Clinicalogoheader_N ;
   private byte gxTv_SdtClinica_Clinicalogofactura_N ;
   private byte gxTv_SdtClinica_Clinicalogoboleta_N ;
   private byte gxTv_SdtClinica_Clinicalogopago_N ;
   private byte gxTv_SdtClinica_Clinicalogoheader_gxi_N ;
   private byte gxTv_SdtClinica_Clinicalogofactura_gxi_N ;
   private byte gxTv_SdtClinica_Clinicalogoboleta_gxi_N ;
   private byte gxTv_SdtClinica_Clinicalogopago_gxi_N ;
   private short gxTv_SdtClinica_Clinicaid ;
   private short gxTv_SdtClinica_Clinicamoneda ;
   private short gxTv_SdtClinica_Initialized ;
   private short gxTv_SdtClinica_Clinicaid_Z ;
   private short gxTv_SdtClinica_Clinicamoneda_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private long gxTv_SdtClinica_Clinicaruc ;
   private long gxTv_SdtClinica_Clinicaruc_Z ;
   private String gxTv_SdtClinica_Clinicatelefono ;
   private String gxTv_SdtClinica_Clinicawhatsapp ;
   private String gxTv_SdtClinica_Clinicaestado ;
   private String gxTv_SdtClinica_Mode ;
   private String gxTv_SdtClinica_Clinicatelefono_Z ;
   private String gxTv_SdtClinica_Clinicawhatsapp_Z ;
   private String gxTv_SdtClinica_Clinicaestado_Z ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtClinica_Clinicanombrecomercial ;
   private String gxTv_SdtClinica_Clinicanombreabreviado ;
   private String gxTv_SdtClinica_Clinicadireccioncomercial ;
   private String gxTv_SdtClinica_Clinicacorreo ;
   private String gxTv_SdtClinica_Clinicalogo_gxi ;
   private String gxTv_SdtClinica_Clinicalogoheader_gxi ;
   private String gxTv_SdtClinica_Clinicalogofactura_gxi ;
   private String gxTv_SdtClinica_Clinicalogoboleta_gxi ;
   private String gxTv_SdtClinica_Clinicalogopago_gxi ;
   private String gxTv_SdtClinica_Clinicafacebook ;
   private String gxTv_SdtClinica_Clinicatwiter ;
   private String gxTv_SdtClinica_Clinicainstagram ;
   private String gxTv_SdtClinica_Clinicalinkedin ;
   private String gxTv_SdtClinica_Clinicanombrecomercial_Z ;
   private String gxTv_SdtClinica_Clinicanombreabreviado_Z ;
   private String gxTv_SdtClinica_Clinicadireccioncomercial_Z ;
   private String gxTv_SdtClinica_Clinicacorreo_Z ;
   private String gxTv_SdtClinica_Clinicafacebook_Z ;
   private String gxTv_SdtClinica_Clinicatwiter_Z ;
   private String gxTv_SdtClinica_Clinicainstagram_Z ;
   private String gxTv_SdtClinica_Clinicalinkedin_Z ;
   private String gxTv_SdtClinica_Clinicalogo_gxi_Z ;
   private String gxTv_SdtClinica_Clinicalogoheader_gxi_Z ;
   private String gxTv_SdtClinica_Clinicalogofactura_gxi_Z ;
   private String gxTv_SdtClinica_Clinicalogoboleta_gxi_Z ;
   private String gxTv_SdtClinica_Clinicalogopago_gxi_Z ;
   private String gxTv_SdtClinica_Clinicalogo ;
   private String gxTv_SdtClinica_Clinicalogoheader ;
   private String gxTv_SdtClinica_Clinicalogofactura ;
   private String gxTv_SdtClinica_Clinicalogoboleta ;
   private String gxTv_SdtClinica_Clinicalogopago ;
}

