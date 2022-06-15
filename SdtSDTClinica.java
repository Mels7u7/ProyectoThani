package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTClinica extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTClinica( )
   {
      this(  new ModelContext(SdtSDTClinica.class));
   }

   public SdtSDTClinica( ModelContext context )
   {
      super( context, "SdtSDTClinica");
   }

   public SdtSDTClinica( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTClinica");
   }

   public SdtSDTClinica( StructSdtSDTClinica struct )
   {
      this();
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
               gxTv_SdtSDTClinica_Clinicaid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaRUC") )
            {
               gxTv_SdtSDTClinica_Clinicaruc = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaNombreComercial") )
            {
               gxTv_SdtSDTClinica_Clinicanombrecomercial = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaNombreAbreviado") )
            {
               gxTv_SdtSDTClinica_Clinicanombreabreviado = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaDireccionComercial") )
            {
               gxTv_SdtSDTClinica_Clinicadireccioncomercial = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaCorreo") )
            {
               gxTv_SdtSDTClinica_Clinicacorreo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaMoneda") )
            {
               gxTv_SdtSDTClinica_Clinicamoneda = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaLogo") )
            {
               gxTv_SdtSDTClinica_Clinicalogo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaLogo_GXI") )
            {
               gxTv_SdtSDTClinica_Clinicalogo_gxi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaLogoHeader") )
            {
               gxTv_SdtSDTClinica_Clinicalogoheader = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaLogoHeader_GXI") )
            {
               gxTv_SdtSDTClinica_Clinicalogoheader_gxi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaLogoFactura") )
            {
               gxTv_SdtSDTClinica_Clinicalogofactura = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaLogoFactura_GXI") )
            {
               gxTv_SdtSDTClinica_Clinicalogofactura_gxi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaLogoBoleta") )
            {
               gxTv_SdtSDTClinica_Clinicalogoboleta = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaLogoBoleta_GXI") )
            {
               gxTv_SdtSDTClinica_Clinicalogoboleta_gxi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaLogoPago") )
            {
               gxTv_SdtSDTClinica_Clinicalogopago = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaLogoPago_GXI") )
            {
               gxTv_SdtSDTClinica_Clinicalogopago_gxi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaTelefono") )
            {
               gxTv_SdtSDTClinica_Clinicatelefono = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaWhatsApp") )
            {
               gxTv_SdtSDTClinica_Clinicawhatsapp = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaFacebook") )
            {
               gxTv_SdtSDTClinica_Clinicafacebook = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaTwiter") )
            {
               gxTv_SdtSDTClinica_Clinicatwiter = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaInstagram") )
            {
               gxTv_SdtSDTClinica_Clinicainstagram = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaLinkedin") )
            {
               gxTv_SdtSDTClinica_Clinicalinkedin = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaTiempoDeCita") )
            {
               gxTv_SdtSDTClinica_Clinicatiempodecita = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaEstado") )
            {
               gxTv_SdtSDTClinica_Clinicaestado = oReader.getValue() ;
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
         sName = "SDTClinica" ;
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
      oWriter.writeElement("ClinicaId", GXutil.trim( GXutil.str( gxTv_SdtSDTClinica_Clinicaid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaRUC", GXutil.trim( GXutil.str( gxTv_SdtSDTClinica_Clinicaruc, 11, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaNombreComercial", GXutil.rtrim( gxTv_SdtSDTClinica_Clinicanombrecomercial));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaNombreAbreviado", GXutil.rtrim( gxTv_SdtSDTClinica_Clinicanombreabreviado));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaDireccionComercial", GXutil.rtrim( gxTv_SdtSDTClinica_Clinicadireccioncomercial));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaCorreo", GXutil.rtrim( gxTv_SdtSDTClinica_Clinicacorreo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaMoneda", GXutil.trim( GXutil.str( gxTv_SdtSDTClinica_Clinicamoneda, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaLogo", GXutil.rtrim( gxTv_SdtSDTClinica_Clinicalogo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaLogo_GXI", GXutil.rtrim( gxTv_SdtSDTClinica_Clinicalogo_gxi));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaLogoHeader", GXutil.rtrim( gxTv_SdtSDTClinica_Clinicalogoheader));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaLogoHeader_GXI", GXutil.rtrim( gxTv_SdtSDTClinica_Clinicalogoheader_gxi));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaLogoFactura", GXutil.rtrim( gxTv_SdtSDTClinica_Clinicalogofactura));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaLogoFactura_GXI", GXutil.rtrim( gxTv_SdtSDTClinica_Clinicalogofactura_gxi));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaLogoBoleta", GXutil.rtrim( gxTv_SdtSDTClinica_Clinicalogoboleta));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaLogoBoleta_GXI", GXutil.rtrim( gxTv_SdtSDTClinica_Clinicalogoboleta_gxi));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaLogoPago", GXutil.rtrim( gxTv_SdtSDTClinica_Clinicalogopago));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaLogoPago_GXI", GXutil.rtrim( gxTv_SdtSDTClinica_Clinicalogopago_gxi));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaTelefono", GXutil.rtrim( gxTv_SdtSDTClinica_Clinicatelefono));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaWhatsApp", GXutil.rtrim( gxTv_SdtSDTClinica_Clinicawhatsapp));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaFacebook", GXutil.rtrim( gxTv_SdtSDTClinica_Clinicafacebook));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaTwiter", GXutil.rtrim( gxTv_SdtSDTClinica_Clinicatwiter));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaInstagram", GXutil.rtrim( gxTv_SdtSDTClinica_Clinicainstagram));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaLinkedin", GXutil.rtrim( gxTv_SdtSDTClinica_Clinicalinkedin));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaTiempoDeCita", GXutil.trim( GXutil.str( gxTv_SdtSDTClinica_Clinicatiempodecita, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaEstado", GXutil.rtrim( gxTv_SdtSDTClinica_Clinicaestado));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
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
      AddObjectProperty("ClinicaId", gxTv_SdtSDTClinica_Clinicaid, false, false);
      AddObjectProperty("ClinicaRUC", gxTv_SdtSDTClinica_Clinicaruc, false, false);
      AddObjectProperty("ClinicaNombreComercial", gxTv_SdtSDTClinica_Clinicanombrecomercial, false, false);
      AddObjectProperty("ClinicaNombreAbreviado", gxTv_SdtSDTClinica_Clinicanombreabreviado, false, false);
      AddObjectProperty("ClinicaDireccionComercial", gxTv_SdtSDTClinica_Clinicadireccioncomercial, false, false);
      AddObjectProperty("ClinicaCorreo", gxTv_SdtSDTClinica_Clinicacorreo, false, false);
      AddObjectProperty("ClinicaMoneda", gxTv_SdtSDTClinica_Clinicamoneda, false, false);
      AddObjectProperty("ClinicaLogo", gxTv_SdtSDTClinica_Clinicalogo, false, false);
      AddObjectProperty("ClinicaLogo_GXI", gxTv_SdtSDTClinica_Clinicalogo_gxi, false, false);
      AddObjectProperty("ClinicaLogoHeader", gxTv_SdtSDTClinica_Clinicalogoheader, false, false);
      AddObjectProperty("ClinicaLogoHeader_GXI", gxTv_SdtSDTClinica_Clinicalogoheader_gxi, false, false);
      AddObjectProperty("ClinicaLogoFactura", gxTv_SdtSDTClinica_Clinicalogofactura, false, false);
      AddObjectProperty("ClinicaLogoFactura_GXI", gxTv_SdtSDTClinica_Clinicalogofactura_gxi, false, false);
      AddObjectProperty("ClinicaLogoBoleta", gxTv_SdtSDTClinica_Clinicalogoboleta, false, false);
      AddObjectProperty("ClinicaLogoBoleta_GXI", gxTv_SdtSDTClinica_Clinicalogoboleta_gxi, false, false);
      AddObjectProperty("ClinicaLogoPago", gxTv_SdtSDTClinica_Clinicalogopago, false, false);
      AddObjectProperty("ClinicaLogoPago_GXI", gxTv_SdtSDTClinica_Clinicalogopago_gxi, false, false);
      AddObjectProperty("ClinicaTelefono", gxTv_SdtSDTClinica_Clinicatelefono, false, false);
      AddObjectProperty("ClinicaWhatsApp", gxTv_SdtSDTClinica_Clinicawhatsapp, false, false);
      AddObjectProperty("ClinicaFacebook", gxTv_SdtSDTClinica_Clinicafacebook, false, false);
      AddObjectProperty("ClinicaTwiter", gxTv_SdtSDTClinica_Clinicatwiter, false, false);
      AddObjectProperty("ClinicaInstagram", gxTv_SdtSDTClinica_Clinicainstagram, false, false);
      AddObjectProperty("ClinicaLinkedin", gxTv_SdtSDTClinica_Clinicalinkedin, false, false);
      AddObjectProperty("ClinicaTiempoDeCita", gxTv_SdtSDTClinica_Clinicatiempodecita, false, false);
      AddObjectProperty("ClinicaEstado", gxTv_SdtSDTClinica_Clinicaestado, false, false);
   }

   public short getgxTv_SdtSDTClinica_Clinicaid( )
   {
      return gxTv_SdtSDTClinica_Clinicaid ;
   }

   public void setgxTv_SdtSDTClinica_Clinicaid( short value )
   {
      gxTv_SdtSDTClinica_N = (byte)(0) ;
      gxTv_SdtSDTClinica_Clinicaid = value ;
   }

   public long getgxTv_SdtSDTClinica_Clinicaruc( )
   {
      return gxTv_SdtSDTClinica_Clinicaruc ;
   }

   public void setgxTv_SdtSDTClinica_Clinicaruc( long value )
   {
      gxTv_SdtSDTClinica_N = (byte)(0) ;
      gxTv_SdtSDTClinica_Clinicaruc = value ;
   }

   public String getgxTv_SdtSDTClinica_Clinicanombrecomercial( )
   {
      return gxTv_SdtSDTClinica_Clinicanombrecomercial ;
   }

   public void setgxTv_SdtSDTClinica_Clinicanombrecomercial( String value )
   {
      gxTv_SdtSDTClinica_N = (byte)(0) ;
      gxTv_SdtSDTClinica_Clinicanombrecomercial = value ;
   }

   public String getgxTv_SdtSDTClinica_Clinicanombreabreviado( )
   {
      return gxTv_SdtSDTClinica_Clinicanombreabreviado ;
   }

   public void setgxTv_SdtSDTClinica_Clinicanombreabreviado( String value )
   {
      gxTv_SdtSDTClinica_N = (byte)(0) ;
      gxTv_SdtSDTClinica_Clinicanombreabreviado = value ;
   }

   public String getgxTv_SdtSDTClinica_Clinicadireccioncomercial( )
   {
      return gxTv_SdtSDTClinica_Clinicadireccioncomercial ;
   }

   public void setgxTv_SdtSDTClinica_Clinicadireccioncomercial( String value )
   {
      gxTv_SdtSDTClinica_N = (byte)(0) ;
      gxTv_SdtSDTClinica_Clinicadireccioncomercial = value ;
   }

   public String getgxTv_SdtSDTClinica_Clinicacorreo( )
   {
      return gxTv_SdtSDTClinica_Clinicacorreo ;
   }

   public void setgxTv_SdtSDTClinica_Clinicacorreo( String value )
   {
      gxTv_SdtSDTClinica_N = (byte)(0) ;
      gxTv_SdtSDTClinica_Clinicacorreo = value ;
   }

   public short getgxTv_SdtSDTClinica_Clinicamoneda( )
   {
      return gxTv_SdtSDTClinica_Clinicamoneda ;
   }

   public void setgxTv_SdtSDTClinica_Clinicamoneda( short value )
   {
      gxTv_SdtSDTClinica_N = (byte)(0) ;
      gxTv_SdtSDTClinica_Clinicamoneda = value ;
   }

   @GxUpload
   public String getgxTv_SdtSDTClinica_Clinicalogo( )
   {
      return gxTv_SdtSDTClinica_Clinicalogo ;
   }

   public void setgxTv_SdtSDTClinica_Clinicalogo( String value )
   {
      gxTv_SdtSDTClinica_N = (byte)(0) ;
      gxTv_SdtSDTClinica_Clinicalogo = value ;
   }

   public String getgxTv_SdtSDTClinica_Clinicalogo_gxi( )
   {
      return gxTv_SdtSDTClinica_Clinicalogo_gxi ;
   }

   public void setgxTv_SdtSDTClinica_Clinicalogo_gxi( String value )
   {
      gxTv_SdtSDTClinica_N = (byte)(0) ;
      gxTv_SdtSDTClinica_Clinicalogo_gxi = value ;
   }

   @GxUpload
   public String getgxTv_SdtSDTClinica_Clinicalogoheader( )
   {
      return gxTv_SdtSDTClinica_Clinicalogoheader ;
   }

   public void setgxTv_SdtSDTClinica_Clinicalogoheader( String value )
   {
      gxTv_SdtSDTClinica_N = (byte)(0) ;
      gxTv_SdtSDTClinica_Clinicalogoheader = value ;
   }

   public String getgxTv_SdtSDTClinica_Clinicalogoheader_gxi( )
   {
      return gxTv_SdtSDTClinica_Clinicalogoheader_gxi ;
   }

   public void setgxTv_SdtSDTClinica_Clinicalogoheader_gxi( String value )
   {
      gxTv_SdtSDTClinica_N = (byte)(0) ;
      gxTv_SdtSDTClinica_Clinicalogoheader_gxi = value ;
   }

   @GxUpload
   public String getgxTv_SdtSDTClinica_Clinicalogofactura( )
   {
      return gxTv_SdtSDTClinica_Clinicalogofactura ;
   }

   public void setgxTv_SdtSDTClinica_Clinicalogofactura( String value )
   {
      gxTv_SdtSDTClinica_N = (byte)(0) ;
      gxTv_SdtSDTClinica_Clinicalogofactura = value ;
   }

   public String getgxTv_SdtSDTClinica_Clinicalogofactura_gxi( )
   {
      return gxTv_SdtSDTClinica_Clinicalogofactura_gxi ;
   }

   public void setgxTv_SdtSDTClinica_Clinicalogofactura_gxi( String value )
   {
      gxTv_SdtSDTClinica_N = (byte)(0) ;
      gxTv_SdtSDTClinica_Clinicalogofactura_gxi = value ;
   }

   @GxUpload
   public String getgxTv_SdtSDTClinica_Clinicalogoboleta( )
   {
      return gxTv_SdtSDTClinica_Clinicalogoboleta ;
   }

   public void setgxTv_SdtSDTClinica_Clinicalogoboleta( String value )
   {
      gxTv_SdtSDTClinica_N = (byte)(0) ;
      gxTv_SdtSDTClinica_Clinicalogoboleta = value ;
   }

   public String getgxTv_SdtSDTClinica_Clinicalogoboleta_gxi( )
   {
      return gxTv_SdtSDTClinica_Clinicalogoboleta_gxi ;
   }

   public void setgxTv_SdtSDTClinica_Clinicalogoboleta_gxi( String value )
   {
      gxTv_SdtSDTClinica_N = (byte)(0) ;
      gxTv_SdtSDTClinica_Clinicalogoboleta_gxi = value ;
   }

   @GxUpload
   public String getgxTv_SdtSDTClinica_Clinicalogopago( )
   {
      return gxTv_SdtSDTClinica_Clinicalogopago ;
   }

   public void setgxTv_SdtSDTClinica_Clinicalogopago( String value )
   {
      gxTv_SdtSDTClinica_N = (byte)(0) ;
      gxTv_SdtSDTClinica_Clinicalogopago = value ;
   }

   public String getgxTv_SdtSDTClinica_Clinicalogopago_gxi( )
   {
      return gxTv_SdtSDTClinica_Clinicalogopago_gxi ;
   }

   public void setgxTv_SdtSDTClinica_Clinicalogopago_gxi( String value )
   {
      gxTv_SdtSDTClinica_N = (byte)(0) ;
      gxTv_SdtSDTClinica_Clinicalogopago_gxi = value ;
   }

   public String getgxTv_SdtSDTClinica_Clinicatelefono( )
   {
      return gxTv_SdtSDTClinica_Clinicatelefono ;
   }

   public void setgxTv_SdtSDTClinica_Clinicatelefono( String value )
   {
      gxTv_SdtSDTClinica_N = (byte)(0) ;
      gxTv_SdtSDTClinica_Clinicatelefono = value ;
   }

   public String getgxTv_SdtSDTClinica_Clinicawhatsapp( )
   {
      return gxTv_SdtSDTClinica_Clinicawhatsapp ;
   }

   public void setgxTv_SdtSDTClinica_Clinicawhatsapp( String value )
   {
      gxTv_SdtSDTClinica_N = (byte)(0) ;
      gxTv_SdtSDTClinica_Clinicawhatsapp = value ;
   }

   public String getgxTv_SdtSDTClinica_Clinicafacebook( )
   {
      return gxTv_SdtSDTClinica_Clinicafacebook ;
   }

   public void setgxTv_SdtSDTClinica_Clinicafacebook( String value )
   {
      gxTv_SdtSDTClinica_N = (byte)(0) ;
      gxTv_SdtSDTClinica_Clinicafacebook = value ;
   }

   public String getgxTv_SdtSDTClinica_Clinicatwiter( )
   {
      return gxTv_SdtSDTClinica_Clinicatwiter ;
   }

   public void setgxTv_SdtSDTClinica_Clinicatwiter( String value )
   {
      gxTv_SdtSDTClinica_N = (byte)(0) ;
      gxTv_SdtSDTClinica_Clinicatwiter = value ;
   }

   public String getgxTv_SdtSDTClinica_Clinicainstagram( )
   {
      return gxTv_SdtSDTClinica_Clinicainstagram ;
   }

   public void setgxTv_SdtSDTClinica_Clinicainstagram( String value )
   {
      gxTv_SdtSDTClinica_N = (byte)(0) ;
      gxTv_SdtSDTClinica_Clinicainstagram = value ;
   }

   public String getgxTv_SdtSDTClinica_Clinicalinkedin( )
   {
      return gxTv_SdtSDTClinica_Clinicalinkedin ;
   }

   public void setgxTv_SdtSDTClinica_Clinicalinkedin( String value )
   {
      gxTv_SdtSDTClinica_N = (byte)(0) ;
      gxTv_SdtSDTClinica_Clinicalinkedin = value ;
   }

   public byte getgxTv_SdtSDTClinica_Clinicatiempodecita( )
   {
      return gxTv_SdtSDTClinica_Clinicatiempodecita ;
   }

   public void setgxTv_SdtSDTClinica_Clinicatiempodecita( byte value )
   {
      gxTv_SdtSDTClinica_N = (byte)(0) ;
      gxTv_SdtSDTClinica_Clinicatiempodecita = value ;
   }

   public String getgxTv_SdtSDTClinica_Clinicaestado( )
   {
      return gxTv_SdtSDTClinica_Clinicaestado ;
   }

   public void setgxTv_SdtSDTClinica_Clinicaestado( String value )
   {
      gxTv_SdtSDTClinica_N = (byte)(0) ;
      gxTv_SdtSDTClinica_Clinicaestado = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTClinica_N = (byte)(1) ;
      gxTv_SdtSDTClinica_Clinicanombrecomercial = "" ;
      gxTv_SdtSDTClinica_Clinicanombreabreviado = "" ;
      gxTv_SdtSDTClinica_Clinicadireccioncomercial = "" ;
      gxTv_SdtSDTClinica_Clinicacorreo = "" ;
      gxTv_SdtSDTClinica_Clinicalogo = "" ;
      gxTv_SdtSDTClinica_Clinicalogo_gxi = "" ;
      gxTv_SdtSDTClinica_Clinicalogoheader = "" ;
      gxTv_SdtSDTClinica_Clinicalogoheader_gxi = "" ;
      gxTv_SdtSDTClinica_Clinicalogofactura = "" ;
      gxTv_SdtSDTClinica_Clinicalogofactura_gxi = "" ;
      gxTv_SdtSDTClinica_Clinicalogoboleta = "" ;
      gxTv_SdtSDTClinica_Clinicalogoboleta_gxi = "" ;
      gxTv_SdtSDTClinica_Clinicalogopago = "" ;
      gxTv_SdtSDTClinica_Clinicalogopago_gxi = "" ;
      gxTv_SdtSDTClinica_Clinicatelefono = "" ;
      gxTv_SdtSDTClinica_Clinicawhatsapp = "" ;
      gxTv_SdtSDTClinica_Clinicafacebook = "" ;
      gxTv_SdtSDTClinica_Clinicatwiter = "" ;
      gxTv_SdtSDTClinica_Clinicainstagram = "" ;
      gxTv_SdtSDTClinica_Clinicalinkedin = "" ;
      gxTv_SdtSDTClinica_Clinicaestado = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTClinica_N ;
   }

   public com.projectthani.SdtSDTClinica Clone( )
   {
      return (com.projectthani.SdtSDTClinica)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTClinica struct )
   {
      setgxTv_SdtSDTClinica_Clinicaid(struct.getClinicaid());
      setgxTv_SdtSDTClinica_Clinicaruc(struct.getClinicaruc());
      setgxTv_SdtSDTClinica_Clinicanombrecomercial(struct.getClinicanombrecomercial());
      setgxTv_SdtSDTClinica_Clinicanombreabreviado(struct.getClinicanombreabreviado());
      setgxTv_SdtSDTClinica_Clinicadireccioncomercial(struct.getClinicadireccioncomercial());
      setgxTv_SdtSDTClinica_Clinicacorreo(struct.getClinicacorreo());
      setgxTv_SdtSDTClinica_Clinicamoneda(struct.getClinicamoneda());
      setgxTv_SdtSDTClinica_Clinicalogo(struct.getClinicalogo());
      setgxTv_SdtSDTClinica_Clinicalogo_gxi(struct.getClinicalogo_gxi());
      setgxTv_SdtSDTClinica_Clinicalogoheader(struct.getClinicalogoheader());
      setgxTv_SdtSDTClinica_Clinicalogoheader_gxi(struct.getClinicalogoheader_gxi());
      setgxTv_SdtSDTClinica_Clinicalogofactura(struct.getClinicalogofactura());
      setgxTv_SdtSDTClinica_Clinicalogofactura_gxi(struct.getClinicalogofactura_gxi());
      setgxTv_SdtSDTClinica_Clinicalogoboleta(struct.getClinicalogoboleta());
      setgxTv_SdtSDTClinica_Clinicalogoboleta_gxi(struct.getClinicalogoboleta_gxi());
      setgxTv_SdtSDTClinica_Clinicalogopago(struct.getClinicalogopago());
      setgxTv_SdtSDTClinica_Clinicalogopago_gxi(struct.getClinicalogopago_gxi());
      setgxTv_SdtSDTClinica_Clinicatelefono(struct.getClinicatelefono());
      setgxTv_SdtSDTClinica_Clinicawhatsapp(struct.getClinicawhatsapp());
      setgxTv_SdtSDTClinica_Clinicafacebook(struct.getClinicafacebook());
      setgxTv_SdtSDTClinica_Clinicatwiter(struct.getClinicatwiter());
      setgxTv_SdtSDTClinica_Clinicainstagram(struct.getClinicainstagram());
      setgxTv_SdtSDTClinica_Clinicalinkedin(struct.getClinicalinkedin());
      setgxTv_SdtSDTClinica_Clinicatiempodecita(struct.getClinicatiempodecita());
      setgxTv_SdtSDTClinica_Clinicaestado(struct.getClinicaestado());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTClinica getStruct( )
   {
      com.projectthani.StructSdtSDTClinica struct = new com.projectthani.StructSdtSDTClinica ();
      struct.setClinicaid(getgxTv_SdtSDTClinica_Clinicaid());
      struct.setClinicaruc(getgxTv_SdtSDTClinica_Clinicaruc());
      struct.setClinicanombrecomercial(getgxTv_SdtSDTClinica_Clinicanombrecomercial());
      struct.setClinicanombreabreviado(getgxTv_SdtSDTClinica_Clinicanombreabreviado());
      struct.setClinicadireccioncomercial(getgxTv_SdtSDTClinica_Clinicadireccioncomercial());
      struct.setClinicacorreo(getgxTv_SdtSDTClinica_Clinicacorreo());
      struct.setClinicamoneda(getgxTv_SdtSDTClinica_Clinicamoneda());
      struct.setClinicalogo(getgxTv_SdtSDTClinica_Clinicalogo());
      struct.setClinicalogo_gxi(getgxTv_SdtSDTClinica_Clinicalogo_gxi());
      struct.setClinicalogoheader(getgxTv_SdtSDTClinica_Clinicalogoheader());
      struct.setClinicalogoheader_gxi(getgxTv_SdtSDTClinica_Clinicalogoheader_gxi());
      struct.setClinicalogofactura(getgxTv_SdtSDTClinica_Clinicalogofactura());
      struct.setClinicalogofactura_gxi(getgxTv_SdtSDTClinica_Clinicalogofactura_gxi());
      struct.setClinicalogoboleta(getgxTv_SdtSDTClinica_Clinicalogoboleta());
      struct.setClinicalogoboleta_gxi(getgxTv_SdtSDTClinica_Clinicalogoboleta_gxi());
      struct.setClinicalogopago(getgxTv_SdtSDTClinica_Clinicalogopago());
      struct.setClinicalogopago_gxi(getgxTv_SdtSDTClinica_Clinicalogopago_gxi());
      struct.setClinicatelefono(getgxTv_SdtSDTClinica_Clinicatelefono());
      struct.setClinicawhatsapp(getgxTv_SdtSDTClinica_Clinicawhatsapp());
      struct.setClinicafacebook(getgxTv_SdtSDTClinica_Clinicafacebook());
      struct.setClinicatwiter(getgxTv_SdtSDTClinica_Clinicatwiter());
      struct.setClinicainstagram(getgxTv_SdtSDTClinica_Clinicainstagram());
      struct.setClinicalinkedin(getgxTv_SdtSDTClinica_Clinicalinkedin());
      struct.setClinicatiempodecita(getgxTv_SdtSDTClinica_Clinicatiempodecita());
      struct.setClinicaestado(getgxTv_SdtSDTClinica_Clinicaestado());
      return struct ;
   }

   protected byte gxTv_SdtSDTClinica_N ;
   protected byte gxTv_SdtSDTClinica_Clinicatiempodecita ;
   protected short gxTv_SdtSDTClinica_Clinicaid ;
   protected short gxTv_SdtSDTClinica_Clinicamoneda ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected long gxTv_SdtSDTClinica_Clinicaruc ;
   protected String gxTv_SdtSDTClinica_Clinicatelefono ;
   protected String gxTv_SdtSDTClinica_Clinicawhatsapp ;
   protected String gxTv_SdtSDTClinica_Clinicaestado ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTClinica_Clinicanombrecomercial ;
   protected String gxTv_SdtSDTClinica_Clinicanombreabreviado ;
   protected String gxTv_SdtSDTClinica_Clinicadireccioncomercial ;
   protected String gxTv_SdtSDTClinica_Clinicacorreo ;
   protected String gxTv_SdtSDTClinica_Clinicalogo_gxi ;
   protected String gxTv_SdtSDTClinica_Clinicalogoheader_gxi ;
   protected String gxTv_SdtSDTClinica_Clinicalogofactura_gxi ;
   protected String gxTv_SdtSDTClinica_Clinicalogoboleta_gxi ;
   protected String gxTv_SdtSDTClinica_Clinicalogopago_gxi ;
   protected String gxTv_SdtSDTClinica_Clinicafacebook ;
   protected String gxTv_SdtSDTClinica_Clinicatwiter ;
   protected String gxTv_SdtSDTClinica_Clinicainstagram ;
   protected String gxTv_SdtSDTClinica_Clinicalinkedin ;
   protected String gxTv_SdtSDTClinica_Clinicalogo ;
   protected String gxTv_SdtSDTClinica_Clinicalogoheader ;
   protected String gxTv_SdtSDTClinica_Clinicalogofactura ;
   protected String gxTv_SdtSDTClinica_Clinicalogoboleta ;
   protected String gxTv_SdtSDTClinica_Clinicalogopago ;
}

