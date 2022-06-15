package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTProfesionalInformacionGeneral extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTProfesionalInformacionGeneral( )
   {
      this(  new ModelContext(SdtSDTProfesionalInformacionGeneral.class));
   }

   public SdtSDTProfesionalInformacionGeneral( ModelContext context )
   {
      super( context, "SdtSDTProfesionalInformacionGeneral");
   }

   public SdtSDTProfesionalInformacionGeneral( int remoteHandle ,
                                               ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTProfesionalInformacionGeneral");
   }

   public SdtSDTProfesionalInformacionGeneral( StructSdtSDTProfesionalInformacionGeneral struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalId") )
            {
               gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalTipoDocumento") )
            {
               gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltipodocumento = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalNroDocumento") )
            {
               gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalnrodocumento = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalApellidoPaterno") )
            {
               gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalapellidopaterno = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalApellidoMaterno") )
            {
               gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalapellidomaterno = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalNombres") )
            {
               gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalnombres = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalFechaNacimiento") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfechanacimiento = GXutil.nullDate() ;
                  gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfechanacimiento_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfechanacimiento_N = (byte)(0) ;
                  gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfechanacimiento = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalSexo") )
            {
               gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalsexo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalDescripcion") )
            {
               gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaldescripcion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalCorreo") )
            {
               gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalcorreo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalCOP") )
            {
               gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalcop = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalTiempoCita") )
            {
               gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltiempocita = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalDireccion") )
            {
               gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaldireccion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaisDescripcion") )
            {
               gxTv_SdtSDTProfesionalInformacionGeneral_Paisdescripcion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "UbigeoCode") )
            {
               gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeocode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "UbigeoNombre") )
            {
               gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeonombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalFoto") )
            {
               gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfoto = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalFoto_GXI") )
            {
               gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfoto_gxi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalTwitter") )
            {
               gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltwitter = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalFacebook") )
            {
               gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfacebook = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalInstagram") )
            {
               gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalinstagram = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalLinkedin") )
            {
               gxTv_SdtSDTProfesionalInformacionGeneral_Profesionallinkedin = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalTelefono") )
            {
               gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltelefono = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalFechaRegistro") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfecharegistro = GXutil.nullDate() ;
                  gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfecharegistro_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfecharegistro_N = (byte)(0) ;
                  gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfecharegistro = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalEstadoCuenta") )
            {
               gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalestadocuenta = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalEstado") )
            {
               gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalestado = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "UbigeoDepartamento") )
            {
               gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodepartamento = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "UbigeoDepartamentoCode") )
            {
               gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodepartamentocode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "UbigeoProvincia") )
            {
               gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeoprovincia = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "UbigeoProvinciaCode") )
            {
               gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeoprovinciacode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "UbigeoDistrito") )
            {
               gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodistrito = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "UbigeoDistritoCode") )
            {
               gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodistritocode = oReader.getValue() ;
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
         sName = "SDTProfesionalInformacionGeneral" ;
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
      oWriter.writeElement("ProfesionalId", GXutil.trim( GXutil.str( gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalTipoDocumento", GXutil.rtrim( gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltipodocumento));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalNroDocumento", GXutil.rtrim( gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalnrodocumento));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalApellidoPaterno", GXutil.rtrim( gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalapellidopaterno));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalApellidoMaterno", GXutil.rtrim( gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalapellidomaterno));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalNombres", GXutil.rtrim( gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalnombres));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfechanacimiento)) && ( gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfechanacimiento_N == 1 ) )
      {
         oWriter.writeElement("ProfesionalFechaNacimiento", "");
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfechanacimiento), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfechanacimiento), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfechanacimiento), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("ProfesionalFechaNacimiento", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      oWriter.writeElement("ProfesionalSexo", GXutil.rtrim( gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalsexo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalDescripcion", GXutil.rtrim( gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaldescripcion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalCorreo", GXutil.rtrim( gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalcorreo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalCOP", GXutil.rtrim( gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalcop));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalTiempoCita", GXutil.trim( GXutil.str( gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltiempocita, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalDireccion", GXutil.rtrim( gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaldireccion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PaisDescripcion", GXutil.rtrim( gxTv_SdtSDTProfesionalInformacionGeneral_Paisdescripcion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("UbigeoCode", GXutil.rtrim( gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeocode));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("UbigeoNombre", GXutil.rtrim( gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeonombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalFoto", GXutil.rtrim( gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfoto));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalFoto_GXI", GXutil.rtrim( gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfoto_gxi));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalTwitter", GXutil.rtrim( gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltwitter));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalFacebook", GXutil.rtrim( gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfacebook));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalInstagram", GXutil.rtrim( gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalinstagram));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalLinkedin", GXutil.rtrim( gxTv_SdtSDTProfesionalInformacionGeneral_Profesionallinkedin));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalTelefono", GXutil.rtrim( gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltelefono));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfecharegistro)) && ( gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfecharegistro_N == 1 ) )
      {
         oWriter.writeElement("ProfesionalFechaRegistro", "");
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfecharegistro), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfecharegistro), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfecharegistro), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("ProfesionalFechaRegistro", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      oWriter.writeElement("ProfesionalEstadoCuenta", GXutil.rtrim( gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalestadocuenta));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalEstado", GXutil.rtrim( gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalestado));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("UbigeoDepartamento", GXutil.rtrim( gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodepartamento));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("UbigeoDepartamentoCode", GXutil.rtrim( gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodepartamentocode));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("UbigeoProvincia", GXutil.rtrim( gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeoprovincia));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("UbigeoProvinciaCode", GXutil.rtrim( gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeoprovinciacode));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("UbigeoDistrito", GXutil.rtrim( gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodistrito));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("UbigeoDistritoCode", GXutil.rtrim( gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodistritocode));
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
      AddObjectProperty("ProfesionalId", gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalid, false, false);
      AddObjectProperty("ProfesionalTipoDocumento", gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltipodocumento, false, false);
      AddObjectProperty("ProfesionalNroDocumento", gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalnrodocumento, false, false);
      AddObjectProperty("ProfesionalApellidoPaterno", gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalapellidopaterno, false, false);
      AddObjectProperty("ProfesionalApellidoMaterno", gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalapellidomaterno, false, false);
      AddObjectProperty("ProfesionalNombres", gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalnombres, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfechanacimiento), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfechanacimiento), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfechanacimiento), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("ProfesionalFechaNacimiento", sDateCnv, false, false);
      AddObjectProperty("ProfesionalSexo", gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalsexo, false, false);
      AddObjectProperty("ProfesionalDescripcion", gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaldescripcion, false, false);
      AddObjectProperty("ProfesionalCorreo", gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalcorreo, false, false);
      AddObjectProperty("ProfesionalCOP", gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalcop, false, false);
      AddObjectProperty("ProfesionalTiempoCita", gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltiempocita, false, false);
      AddObjectProperty("ProfesionalDireccion", gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaldireccion, false, false);
      AddObjectProperty("PaisDescripcion", gxTv_SdtSDTProfesionalInformacionGeneral_Paisdescripcion, false, false);
      AddObjectProperty("UbigeoCode", gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeocode, false, false);
      AddObjectProperty("UbigeoNombre", gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeonombre, false, false);
      AddObjectProperty("ProfesionalFoto", gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfoto, false, false);
      AddObjectProperty("ProfesionalFoto_GXI", gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfoto_gxi, false, false);
      AddObjectProperty("ProfesionalTwitter", gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltwitter, false, false);
      AddObjectProperty("ProfesionalFacebook", gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfacebook, false, false);
      AddObjectProperty("ProfesionalInstagram", gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalinstagram, false, false);
      AddObjectProperty("ProfesionalLinkedin", gxTv_SdtSDTProfesionalInformacionGeneral_Profesionallinkedin, false, false);
      AddObjectProperty("ProfesionalTelefono", gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltelefono, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("ProfesionalFechaRegistro", sDateCnv, false, false);
      AddObjectProperty("ProfesionalEstadoCuenta", gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalestadocuenta, false, false);
      AddObjectProperty("ProfesionalEstado", gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalestado, false, false);
      AddObjectProperty("UbigeoDepartamento", gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodepartamento, false, false);
      AddObjectProperty("UbigeoDepartamentoCode", gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodepartamentocode, false, false);
      AddObjectProperty("UbigeoProvincia", gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeoprovincia, false, false);
      AddObjectProperty("UbigeoProvinciaCode", gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeoprovinciacode, false, false);
      AddObjectProperty("UbigeoDistrito", gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodistrito, false, false);
      AddObjectProperty("UbigeoDistritoCode", gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodistritocode, false, false);
   }

   public int getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalid( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalid ;
   }

   public void setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalid( int value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalid = value ;
   }

   public String getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltipodocumento( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltipodocumento ;
   }

   public void setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltipodocumento( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltipodocumento = value ;
   }

   public String getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalnrodocumento( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalnrodocumento ;
   }

   public void setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalnrodocumento( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalnrodocumento = value ;
   }

   public String getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalapellidopaterno( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalapellidopaterno ;
   }

   public void setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalapellidopaterno( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalapellidopaterno = value ;
   }

   public String getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalapellidomaterno( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalapellidomaterno ;
   }

   public void setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalapellidomaterno( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalapellidomaterno = value ;
   }

   public String getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalnombres( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalnombres ;
   }

   public void setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalnombres( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalnombres = value ;
   }

   public java.util.Date getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfechanacimiento( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfechanacimiento ;
   }

   public void setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfechanacimiento( java.util.Date value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfechanacimiento_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfechanacimiento = value ;
   }

   public String getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalsexo( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalsexo ;
   }

   public void setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalsexo( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalsexo = value ;
   }

   public String getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaldescripcion( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaldescripcion ;
   }

   public void setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaldescripcion( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaldescripcion = value ;
   }

   public String getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalcorreo( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalcorreo ;
   }

   public void setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalcorreo( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalcorreo = value ;
   }

   public String getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalcop( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalcop ;
   }

   public void setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalcop( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalcop = value ;
   }

   public byte getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltiempocita( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltiempocita ;
   }

   public void setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltiempocita( byte value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltiempocita = value ;
   }

   public String getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaldireccion( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaldireccion ;
   }

   public void setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaldireccion( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaldireccion = value ;
   }

   public String getgxTv_SdtSDTProfesionalInformacionGeneral_Paisdescripcion( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Paisdescripcion ;
   }

   public void setgxTv_SdtSDTProfesionalInformacionGeneral_Paisdescripcion( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Paisdescripcion = value ;
   }

   public String getgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeocode( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeocode ;
   }

   public void setgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeocode( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeocode = value ;
   }

   public String getgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeonombre( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeonombre ;
   }

   public void setgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeonombre( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeonombre = value ;
   }

   @GxUpload
   public String getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfoto( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfoto ;
   }

   public void setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfoto( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfoto = value ;
   }

   public String getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfoto_gxi( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfoto_gxi ;
   }

   public void setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfoto_gxi( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfoto_gxi = value ;
   }

   public String getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltwitter( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltwitter ;
   }

   public void setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltwitter( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltwitter = value ;
   }

   public String getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfacebook( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfacebook ;
   }

   public void setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfacebook( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfacebook = value ;
   }

   public String getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalinstagram( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalinstagram ;
   }

   public void setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalinstagram( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalinstagram = value ;
   }

   public String getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionallinkedin( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionallinkedin ;
   }

   public void setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionallinkedin( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionallinkedin = value ;
   }

   public String getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltelefono( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltelefono ;
   }

   public void setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltelefono( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltelefono = value ;
   }

   public java.util.Date getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfecharegistro( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfecharegistro ;
   }

   public void setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfecharegistro( java.util.Date value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfecharegistro_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfecharegistro = value ;
   }

   public String getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalestadocuenta( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalestadocuenta ;
   }

   public void setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalestadocuenta( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalestadocuenta = value ;
   }

   public String getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalestado( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalestado ;
   }

   public void setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalestado( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalestado = value ;
   }

   public String getgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodepartamento( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodepartamento ;
   }

   public void setgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodepartamento( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodepartamento = value ;
   }

   public String getgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodepartamentocode( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodepartamentocode ;
   }

   public void setgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodepartamentocode( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodepartamentocode = value ;
   }

   public String getgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeoprovincia( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeoprovincia ;
   }

   public void setgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeoprovincia( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeoprovincia = value ;
   }

   public String getgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeoprovinciacode( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeoprovinciacode ;
   }

   public void setgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeoprovinciacode( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeoprovinciacode = value ;
   }

   public String getgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodistrito( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodistrito ;
   }

   public void setgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodistrito( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodistrito = value ;
   }

   public String getgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodistritocode( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodistritocode ;
   }

   public void setgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodistritocode( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodistritocode = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(1) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltipodocumento = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalnrodocumento = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalapellidopaterno = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalapellidomaterno = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalnombres = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfechanacimiento = GXutil.nullDate() ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfechanacimiento_N = (byte)(1) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalsexo = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaldescripcion = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalcorreo = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalcop = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltiempocita = (byte)(30) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaldireccion = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Paisdescripcion = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeocode = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeonombre = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfoto = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfoto_gxi = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltwitter = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfacebook = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalinstagram = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionallinkedin = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltelefono = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfecharegistro = GXutil.nullDate() ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfecharegistro_N = (byte)(1) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalestadocuenta = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalestado = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodepartamento = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodepartamentocode = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeoprovincia = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeoprovinciacode = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodistrito = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodistritocode = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_N ;
   }

   public com.projectthani.SdtSDTProfesionalInformacionGeneral Clone( )
   {
      return (com.projectthani.SdtSDTProfesionalInformacionGeneral)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTProfesionalInformacionGeneral struct )
   {
      setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalid(struct.getProfesionalid());
      setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltipodocumento(struct.getProfesionaltipodocumento());
      setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalnrodocumento(struct.getProfesionalnrodocumento());
      setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalapellidopaterno(struct.getProfesionalapellidopaterno());
      setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalapellidomaterno(struct.getProfesionalapellidomaterno());
      setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalnombres(struct.getProfesionalnombres());
      if ( struct.gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfechanacimiento_N == 0 )
      {
         setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfechanacimiento(struct.getProfesionalfechanacimiento());
      }
      setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalsexo(struct.getProfesionalsexo());
      setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaldescripcion(struct.getProfesionaldescripcion());
      setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalcorreo(struct.getProfesionalcorreo());
      setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalcop(struct.getProfesionalcop());
      setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltiempocita(struct.getProfesionaltiempocita());
      setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaldireccion(struct.getProfesionaldireccion());
      setgxTv_SdtSDTProfesionalInformacionGeneral_Paisdescripcion(struct.getPaisdescripcion());
      setgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeocode(struct.getUbigeocode());
      setgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeonombre(struct.getUbigeonombre());
      setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfoto(struct.getProfesionalfoto());
      setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfoto_gxi(struct.getProfesionalfoto_gxi());
      setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltwitter(struct.getProfesionaltwitter());
      setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfacebook(struct.getProfesionalfacebook());
      setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalinstagram(struct.getProfesionalinstagram());
      setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionallinkedin(struct.getProfesionallinkedin());
      setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltelefono(struct.getProfesionaltelefono());
      if ( struct.gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfecharegistro_N == 0 )
      {
         setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfecharegistro(struct.getProfesionalfecharegistro());
      }
      setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalestadocuenta(struct.getProfesionalestadocuenta());
      setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalestado(struct.getProfesionalestado());
      setgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodepartamento(struct.getUbigeodepartamento());
      setgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodepartamentocode(struct.getUbigeodepartamentocode());
      setgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeoprovincia(struct.getUbigeoprovincia());
      setgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeoprovinciacode(struct.getUbigeoprovinciacode());
      setgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodistrito(struct.getUbigeodistrito());
      setgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodistritocode(struct.getUbigeodistritocode());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTProfesionalInformacionGeneral getStruct( )
   {
      com.projectthani.StructSdtSDTProfesionalInformacionGeneral struct = new com.projectthani.StructSdtSDTProfesionalInformacionGeneral ();
      struct.setProfesionalid(getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalid());
      struct.setProfesionaltipodocumento(getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltipodocumento());
      struct.setProfesionalnrodocumento(getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalnrodocumento());
      struct.setProfesionalapellidopaterno(getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalapellidopaterno());
      struct.setProfesionalapellidomaterno(getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalapellidomaterno());
      struct.setProfesionalnombres(getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalnombres());
      if ( gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfechanacimiento_N == 0 )
      {
         struct.setProfesionalfechanacimiento(getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfechanacimiento());
      }
      struct.setProfesionalsexo(getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalsexo());
      struct.setProfesionaldescripcion(getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaldescripcion());
      struct.setProfesionalcorreo(getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalcorreo());
      struct.setProfesionalcop(getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalcop());
      struct.setProfesionaltiempocita(getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltiempocita());
      struct.setProfesionaldireccion(getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaldireccion());
      struct.setPaisdescripcion(getgxTv_SdtSDTProfesionalInformacionGeneral_Paisdescripcion());
      struct.setUbigeocode(getgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeocode());
      struct.setUbigeonombre(getgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeonombre());
      struct.setProfesionalfoto(getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfoto());
      struct.setProfesionalfoto_gxi(getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfoto_gxi());
      struct.setProfesionaltwitter(getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltwitter());
      struct.setProfesionalfacebook(getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfacebook());
      struct.setProfesionalinstagram(getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalinstagram());
      struct.setProfesionallinkedin(getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionallinkedin());
      struct.setProfesionaltelefono(getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltelefono());
      if ( gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfecharegistro_N == 0 )
      {
         struct.setProfesionalfecharegistro(getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfecharegistro());
      }
      struct.setProfesionalestadocuenta(getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalestadocuenta());
      struct.setProfesionalestado(getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalestado());
      struct.setUbigeodepartamento(getgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodepartamento());
      struct.setUbigeodepartamentocode(getgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodepartamentocode());
      struct.setUbigeoprovincia(getgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeoprovincia());
      struct.setUbigeoprovinciacode(getgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeoprovinciacode());
      struct.setUbigeodistrito(getgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodistrito());
      struct.setUbigeodistritocode(getgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodistritocode());
      return struct ;
   }

   protected byte gxTv_SdtSDTProfesionalInformacionGeneral_N ;
   protected byte gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfechanacimiento_N ;
   protected byte gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltiempocita ;
   protected byte gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfecharegistro_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalid ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltipodocumento ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalsexo ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeocode ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltelefono ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalestadocuenta ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalestado ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfechanacimiento ;
   protected java.util.Date gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfecharegistro ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalnrodocumento ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalapellidopaterno ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalapellidomaterno ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalnombres ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaldescripcion ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalcorreo ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalcop ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaldireccion ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Paisdescripcion ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeonombre ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfoto_gxi ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltwitter ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfacebook ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalinstagram ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Profesionallinkedin ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodepartamento ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodepartamentocode ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeoprovincia ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeoprovinciacode ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodistrito ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodistritocode ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfoto ;
}

