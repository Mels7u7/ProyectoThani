package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTComprobantesPagoPaciente extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTComprobantesPagoPaciente( )
   {
      this(  new ModelContext(SdtSDTComprobantesPagoPaciente.class));
   }

   public SdtSDTComprobantesPagoPaciente( ModelContext context )
   {
      super( context, "SdtSDTComprobantesPagoPaciente");
   }

   public SdtSDTComprobantesPagoPaciente( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTComprobantesPagoPaciente");
   }

   public SdtSDTComprobantesPagoPaciente( StructSdtSDTComprobantesPagoPaciente struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoId") )
            {
               gxTv_SdtSDTComprobantesPagoPaciente_Pagoid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoMonto") )
            {
               gxTv_SdtSDTComprobantesPagoPaciente_Pagomonto = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaId") )
            {
               gxTv_SdtSDTComprobantesPagoPaciente_Citaid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaCode") )
            {
               gxTv_SdtSDTComprobantesPagoPaciente_Citacode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoTipoDocumentoCliente") )
            {
               gxTv_SdtSDTComprobantesPagoPaciente_Pagotipodocumentocliente = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoClienteNroDocumento") )
            {
               gxTv_SdtSDTComprobantesPagoPaciente_Pagoclientenrodocumento = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoClienteDenominacion") )
            {
               gxTv_SdtSDTComprobantesPagoPaciente_Pagoclientedenominacion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoClienteDireccion") )
            {
               gxTv_SdtSDTComprobantesPagoPaciente_Pagoclientedireccion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoClienteEmail") )
            {
               gxTv_SdtSDTComprobantesPagoPaciente_Pagoclienteemail = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoTipoDocumento") )
            {
               gxTv_SdtSDTComprobantesPagoPaciente_Pagotipodocumento = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoNumero") )
            {
               gxTv_SdtSDTComprobantesPagoPaciente_Pagonumero = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoFechaEmision") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtSDTComprobantesPagoPaciente_Pagofechaemision = GXutil.nullDate() ;
                  gxTv_SdtSDTComprobantesPagoPaciente_Pagofechaemision_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtSDTComprobantesPagoPaciente_Pagofechaemision_N = (byte)(0) ;
                  gxTv_SdtSDTComprobantesPagoPaciente_Pagofechaemision = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoMoneda") )
            {
               gxTv_SdtSDTComprobantesPagoPaciente_Pagomoneda = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoNubefactRequest") )
            {
               gxTv_SdtSDTComprobantesPagoPaciente_Pagonubefactrequest = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoNubefactResponse") )
            {
               gxTv_SdtSDTComprobantesPagoPaciente_Pagonubefactresponse = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoRequest") )
            {
               gxTv_SdtSDTComprobantesPagoPaciente_Pagorequest = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoResponse") )
            {
               gxTv_SdtSDTComprobantesPagoPaciente_Pagoresponse = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DisponibilidadId") )
            {
               gxTv_SdtSDTComprobantesPagoPaciente_Disponibilidadid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoEstadoR") )
            {
               gxTv_SdtSDTComprobantesPagoPaciente_Pagoestador = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoEnlacePDF") )
            {
               gxTv_SdtSDTComprobantesPagoPaciente_Pagoenlacepdf = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoEnlaceXML") )
            {
               gxTv_SdtSDTComprobantesPagoPaciente_Pagoenlacexml = oReader.getValue() ;
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
         sName = "SDTComprobantesPagoPaciente" ;
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
      oWriter.writeElement("PagoId", GXutil.trim( GXutil.str( gxTv_SdtSDTComprobantesPagoPaciente_Pagoid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PagoMonto", GXutil.trim( GXutil.strNoRound( gxTv_SdtSDTComprobantesPagoPaciente_Pagomonto, 6, 2)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaId", GXutil.trim( GXutil.str( gxTv_SdtSDTComprobantesPagoPaciente_Citaid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaCode", GXutil.rtrim( gxTv_SdtSDTComprobantesPagoPaciente_Citacode));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PagoTipoDocumentoCliente", GXutil.rtrim( gxTv_SdtSDTComprobantesPagoPaciente_Pagotipodocumentocliente));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PagoClienteNroDocumento", GXutil.rtrim( gxTv_SdtSDTComprobantesPagoPaciente_Pagoclientenrodocumento));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PagoClienteDenominacion", GXutil.rtrim( gxTv_SdtSDTComprobantesPagoPaciente_Pagoclientedenominacion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PagoClienteDireccion", GXutil.rtrim( gxTv_SdtSDTComprobantesPagoPaciente_Pagoclientedireccion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PagoClienteEmail", GXutil.rtrim( gxTv_SdtSDTComprobantesPagoPaciente_Pagoclienteemail));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PagoTipoDocumento", GXutil.trim( GXutil.str( gxTv_SdtSDTComprobantesPagoPaciente_Pagotipodocumento, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PagoNumero", GXutil.trim( GXutil.str( gxTv_SdtSDTComprobantesPagoPaciente_Pagonumero, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_SdtSDTComprobantesPagoPaciente_Pagofechaemision)) && ( gxTv_SdtSDTComprobantesPagoPaciente_Pagofechaemision_N == 1 ) )
      {
         oWriter.writeElement("PagoFechaEmision", "");
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTComprobantesPagoPaciente_Pagofechaemision), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTComprobantesPagoPaciente_Pagofechaemision), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTComprobantesPagoPaciente_Pagofechaemision), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("PagoFechaEmision", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      oWriter.writeElement("PagoMoneda", GXutil.trim( GXutil.str( gxTv_SdtSDTComprobantesPagoPaciente_Pagomoneda, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PagoNubefactRequest", GXutil.rtrim( gxTv_SdtSDTComprobantesPagoPaciente_Pagonubefactrequest));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PagoNubefactResponse", GXutil.rtrim( gxTv_SdtSDTComprobantesPagoPaciente_Pagonubefactresponse));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PagoRequest", GXutil.rtrim( gxTv_SdtSDTComprobantesPagoPaciente_Pagorequest));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PagoResponse", GXutil.rtrim( gxTv_SdtSDTComprobantesPagoPaciente_Pagoresponse));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("DisponibilidadId", GXutil.trim( GXutil.str( gxTv_SdtSDTComprobantesPagoPaciente_Disponibilidadid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PagoEstadoR", GXutil.rtrim( gxTv_SdtSDTComprobantesPagoPaciente_Pagoestador));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PagoEnlacePDF", GXutil.rtrim( gxTv_SdtSDTComprobantesPagoPaciente_Pagoenlacepdf));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PagoEnlaceXML", GXutil.rtrim( gxTv_SdtSDTComprobantesPagoPaciente_Pagoenlacexml));
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
      AddObjectProperty("PagoId", gxTv_SdtSDTComprobantesPagoPaciente_Pagoid, false, false);
      AddObjectProperty("PagoMonto", gxTv_SdtSDTComprobantesPagoPaciente_Pagomonto, false, false);
      AddObjectProperty("CitaId", gxTv_SdtSDTComprobantesPagoPaciente_Citaid, false, false);
      AddObjectProperty("CitaCode", gxTv_SdtSDTComprobantesPagoPaciente_Citacode, false, false);
      AddObjectProperty("PagoTipoDocumentoCliente", gxTv_SdtSDTComprobantesPagoPaciente_Pagotipodocumentocliente, false, false);
      AddObjectProperty("PagoClienteNroDocumento", gxTv_SdtSDTComprobantesPagoPaciente_Pagoclientenrodocumento, false, false);
      AddObjectProperty("PagoClienteDenominacion", gxTv_SdtSDTComprobantesPagoPaciente_Pagoclientedenominacion, false, false);
      AddObjectProperty("PagoClienteDireccion", gxTv_SdtSDTComprobantesPagoPaciente_Pagoclientedireccion, false, false);
      AddObjectProperty("PagoClienteEmail", gxTv_SdtSDTComprobantesPagoPaciente_Pagoclienteemail, false, false);
      AddObjectProperty("PagoTipoDocumento", gxTv_SdtSDTComprobantesPagoPaciente_Pagotipodocumento, false, false);
      AddObjectProperty("PagoNumero", gxTv_SdtSDTComprobantesPagoPaciente_Pagonumero, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTComprobantesPagoPaciente_Pagofechaemision), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTComprobantesPagoPaciente_Pagofechaemision), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTComprobantesPagoPaciente_Pagofechaemision), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("PagoFechaEmision", sDateCnv, false, false);
      AddObjectProperty("PagoMoneda", gxTv_SdtSDTComprobantesPagoPaciente_Pagomoneda, false, false);
      AddObjectProperty("PagoNubefactRequest", gxTv_SdtSDTComprobantesPagoPaciente_Pagonubefactrequest, false, false);
      AddObjectProperty("PagoNubefactResponse", gxTv_SdtSDTComprobantesPagoPaciente_Pagonubefactresponse, false, false);
      AddObjectProperty("PagoRequest", gxTv_SdtSDTComprobantesPagoPaciente_Pagorequest, false, false);
      AddObjectProperty("PagoResponse", gxTv_SdtSDTComprobantesPagoPaciente_Pagoresponse, false, false);
      AddObjectProperty("DisponibilidadId", gxTv_SdtSDTComprobantesPagoPaciente_Disponibilidadid, false, false);
      AddObjectProperty("PagoEstadoR", gxTv_SdtSDTComprobantesPagoPaciente_Pagoestador, false, false);
      AddObjectProperty("PagoEnlacePDF", gxTv_SdtSDTComprobantesPagoPaciente_Pagoenlacepdf, false, false);
      AddObjectProperty("PagoEnlaceXML", gxTv_SdtSDTComprobantesPagoPaciente_Pagoenlacexml, false, false);
   }

   public int getgxTv_SdtSDTComprobantesPagoPaciente_Pagoid( )
   {
      return gxTv_SdtSDTComprobantesPagoPaciente_Pagoid ;
   }

   public void setgxTv_SdtSDTComprobantesPagoPaciente_Pagoid( int value )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagoid = value ;
   }

   public java.math.BigDecimal getgxTv_SdtSDTComprobantesPagoPaciente_Pagomonto( )
   {
      return gxTv_SdtSDTComprobantesPagoPaciente_Pagomonto ;
   }

   public void setgxTv_SdtSDTComprobantesPagoPaciente_Pagomonto( java.math.BigDecimal value )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagomonto = value ;
   }

   public int getgxTv_SdtSDTComprobantesPagoPaciente_Citaid( )
   {
      return gxTv_SdtSDTComprobantesPagoPaciente_Citaid ;
   }

   public void setgxTv_SdtSDTComprobantesPagoPaciente_Citaid( int value )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Citaid = value ;
   }

   public String getgxTv_SdtSDTComprobantesPagoPaciente_Citacode( )
   {
      return gxTv_SdtSDTComprobantesPagoPaciente_Citacode ;
   }

   public void setgxTv_SdtSDTComprobantesPagoPaciente_Citacode( String value )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Citacode = value ;
   }

   public String getgxTv_SdtSDTComprobantesPagoPaciente_Pagotipodocumentocliente( )
   {
      return gxTv_SdtSDTComprobantesPagoPaciente_Pagotipodocumentocliente ;
   }

   public void setgxTv_SdtSDTComprobantesPagoPaciente_Pagotipodocumentocliente( String value )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagotipodocumentocliente = value ;
   }

   public String getgxTv_SdtSDTComprobantesPagoPaciente_Pagoclientenrodocumento( )
   {
      return gxTv_SdtSDTComprobantesPagoPaciente_Pagoclientenrodocumento ;
   }

   public void setgxTv_SdtSDTComprobantesPagoPaciente_Pagoclientenrodocumento( String value )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagoclientenrodocumento = value ;
   }

   public String getgxTv_SdtSDTComprobantesPagoPaciente_Pagoclientedenominacion( )
   {
      return gxTv_SdtSDTComprobantesPagoPaciente_Pagoclientedenominacion ;
   }

   public void setgxTv_SdtSDTComprobantesPagoPaciente_Pagoclientedenominacion( String value )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagoclientedenominacion = value ;
   }

   public String getgxTv_SdtSDTComprobantesPagoPaciente_Pagoclientedireccion( )
   {
      return gxTv_SdtSDTComprobantesPagoPaciente_Pagoclientedireccion ;
   }

   public void setgxTv_SdtSDTComprobantesPagoPaciente_Pagoclientedireccion( String value )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagoclientedireccion = value ;
   }

   public String getgxTv_SdtSDTComprobantesPagoPaciente_Pagoclienteemail( )
   {
      return gxTv_SdtSDTComprobantesPagoPaciente_Pagoclienteemail ;
   }

   public void setgxTv_SdtSDTComprobantesPagoPaciente_Pagoclienteemail( String value )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagoclienteemail = value ;
   }

   public short getgxTv_SdtSDTComprobantesPagoPaciente_Pagotipodocumento( )
   {
      return gxTv_SdtSDTComprobantesPagoPaciente_Pagotipodocumento ;
   }

   public void setgxTv_SdtSDTComprobantesPagoPaciente_Pagotipodocumento( short value )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagotipodocumento = value ;
   }

   public int getgxTv_SdtSDTComprobantesPagoPaciente_Pagonumero( )
   {
      return gxTv_SdtSDTComprobantesPagoPaciente_Pagonumero ;
   }

   public void setgxTv_SdtSDTComprobantesPagoPaciente_Pagonumero( int value )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagonumero = value ;
   }

   public java.util.Date getgxTv_SdtSDTComprobantesPagoPaciente_Pagofechaemision( )
   {
      return gxTv_SdtSDTComprobantesPagoPaciente_Pagofechaemision ;
   }

   public void setgxTv_SdtSDTComprobantesPagoPaciente_Pagofechaemision( java.util.Date value )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_Pagofechaemision_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagofechaemision = value ;
   }

   public short getgxTv_SdtSDTComprobantesPagoPaciente_Pagomoneda( )
   {
      return gxTv_SdtSDTComprobantesPagoPaciente_Pagomoneda ;
   }

   public void setgxTv_SdtSDTComprobantesPagoPaciente_Pagomoneda( short value )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagomoneda = value ;
   }

   public String getgxTv_SdtSDTComprobantesPagoPaciente_Pagonubefactrequest( )
   {
      return gxTv_SdtSDTComprobantesPagoPaciente_Pagonubefactrequest ;
   }

   public void setgxTv_SdtSDTComprobantesPagoPaciente_Pagonubefactrequest( String value )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagonubefactrequest = value ;
   }

   public String getgxTv_SdtSDTComprobantesPagoPaciente_Pagonubefactresponse( )
   {
      return gxTv_SdtSDTComprobantesPagoPaciente_Pagonubefactresponse ;
   }

   public void setgxTv_SdtSDTComprobantesPagoPaciente_Pagonubefactresponse( String value )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagonubefactresponse = value ;
   }

   public String getgxTv_SdtSDTComprobantesPagoPaciente_Pagorequest( )
   {
      return gxTv_SdtSDTComprobantesPagoPaciente_Pagorequest ;
   }

   public void setgxTv_SdtSDTComprobantesPagoPaciente_Pagorequest( String value )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagorequest = value ;
   }

   public String getgxTv_SdtSDTComprobantesPagoPaciente_Pagoresponse( )
   {
      return gxTv_SdtSDTComprobantesPagoPaciente_Pagoresponse ;
   }

   public void setgxTv_SdtSDTComprobantesPagoPaciente_Pagoresponse( String value )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagoresponse = value ;
   }

   public int getgxTv_SdtSDTComprobantesPagoPaciente_Disponibilidadid( )
   {
      return gxTv_SdtSDTComprobantesPagoPaciente_Disponibilidadid ;
   }

   public void setgxTv_SdtSDTComprobantesPagoPaciente_Disponibilidadid( int value )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Disponibilidadid = value ;
   }

   public String getgxTv_SdtSDTComprobantesPagoPaciente_Pagoestador( )
   {
      return gxTv_SdtSDTComprobantesPagoPaciente_Pagoestador ;
   }

   public void setgxTv_SdtSDTComprobantesPagoPaciente_Pagoestador( String value )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagoestador = value ;
   }

   public String getgxTv_SdtSDTComprobantesPagoPaciente_Pagoenlacepdf( )
   {
      return gxTv_SdtSDTComprobantesPagoPaciente_Pagoenlacepdf ;
   }

   public void setgxTv_SdtSDTComprobantesPagoPaciente_Pagoenlacepdf( String value )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagoenlacepdf = value ;
   }

   public String getgxTv_SdtSDTComprobantesPagoPaciente_Pagoenlacexml( )
   {
      return gxTv_SdtSDTComprobantesPagoPaciente_Pagoenlacexml ;
   }

   public void setgxTv_SdtSDTComprobantesPagoPaciente_Pagoenlacexml( String value )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagoenlacexml = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(1) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagomonto = DecimalUtil.ZERO ;
      gxTv_SdtSDTComprobantesPagoPaciente_Citacode = "" ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagotipodocumentocliente = "" ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagoclientenrodocumento = "" ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagoclientedenominacion = "" ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagoclientedireccion = "" ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagoclienteemail = "" ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagofechaemision = GXutil.nullDate() ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagofechaemision_N = (byte)(1) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagonubefactrequest = "" ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagonubefactresponse = "" ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagorequest = "" ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagoresponse = "" ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagoestador = "" ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagoenlacepdf = "" ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagoenlacexml = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTComprobantesPagoPaciente_N ;
   }

   public com.projectthani.SdtSDTComprobantesPagoPaciente Clone( )
   {
      return (com.projectthani.SdtSDTComprobantesPagoPaciente)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTComprobantesPagoPaciente struct )
   {
      setgxTv_SdtSDTComprobantesPagoPaciente_Pagoid(struct.getPagoid());
      setgxTv_SdtSDTComprobantesPagoPaciente_Pagomonto(struct.getPagomonto());
      setgxTv_SdtSDTComprobantesPagoPaciente_Citaid(struct.getCitaid());
      setgxTv_SdtSDTComprobantesPagoPaciente_Citacode(struct.getCitacode());
      setgxTv_SdtSDTComprobantesPagoPaciente_Pagotipodocumentocliente(struct.getPagotipodocumentocliente());
      setgxTv_SdtSDTComprobantesPagoPaciente_Pagoclientenrodocumento(struct.getPagoclientenrodocumento());
      setgxTv_SdtSDTComprobantesPagoPaciente_Pagoclientedenominacion(struct.getPagoclientedenominacion());
      setgxTv_SdtSDTComprobantesPagoPaciente_Pagoclientedireccion(struct.getPagoclientedireccion());
      setgxTv_SdtSDTComprobantesPagoPaciente_Pagoclienteemail(struct.getPagoclienteemail());
      setgxTv_SdtSDTComprobantesPagoPaciente_Pagotipodocumento(struct.getPagotipodocumento());
      setgxTv_SdtSDTComprobantesPagoPaciente_Pagonumero(struct.getPagonumero());
      if ( struct.gxTv_SdtSDTComprobantesPagoPaciente_Pagofechaemision_N == 0 )
      {
         setgxTv_SdtSDTComprobantesPagoPaciente_Pagofechaemision(struct.getPagofechaemision());
      }
      setgxTv_SdtSDTComprobantesPagoPaciente_Pagomoneda(struct.getPagomoneda());
      setgxTv_SdtSDTComprobantesPagoPaciente_Pagonubefactrequest(struct.getPagonubefactrequest());
      setgxTv_SdtSDTComprobantesPagoPaciente_Pagonubefactresponse(struct.getPagonubefactresponse());
      setgxTv_SdtSDTComprobantesPagoPaciente_Pagorequest(struct.getPagorequest());
      setgxTv_SdtSDTComprobantesPagoPaciente_Pagoresponse(struct.getPagoresponse());
      setgxTv_SdtSDTComprobantesPagoPaciente_Disponibilidadid(struct.getDisponibilidadid());
      setgxTv_SdtSDTComprobantesPagoPaciente_Pagoestador(struct.getPagoestador());
      setgxTv_SdtSDTComprobantesPagoPaciente_Pagoenlacepdf(struct.getPagoenlacepdf());
      setgxTv_SdtSDTComprobantesPagoPaciente_Pagoenlacexml(struct.getPagoenlacexml());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTComprobantesPagoPaciente getStruct( )
   {
      com.projectthani.StructSdtSDTComprobantesPagoPaciente struct = new com.projectthani.StructSdtSDTComprobantesPagoPaciente ();
      struct.setPagoid(getgxTv_SdtSDTComprobantesPagoPaciente_Pagoid());
      struct.setPagomonto(getgxTv_SdtSDTComprobantesPagoPaciente_Pagomonto());
      struct.setCitaid(getgxTv_SdtSDTComprobantesPagoPaciente_Citaid());
      struct.setCitacode(getgxTv_SdtSDTComprobantesPagoPaciente_Citacode());
      struct.setPagotipodocumentocliente(getgxTv_SdtSDTComprobantesPagoPaciente_Pagotipodocumentocliente());
      struct.setPagoclientenrodocumento(getgxTv_SdtSDTComprobantesPagoPaciente_Pagoclientenrodocumento());
      struct.setPagoclientedenominacion(getgxTv_SdtSDTComprobantesPagoPaciente_Pagoclientedenominacion());
      struct.setPagoclientedireccion(getgxTv_SdtSDTComprobantesPagoPaciente_Pagoclientedireccion());
      struct.setPagoclienteemail(getgxTv_SdtSDTComprobantesPagoPaciente_Pagoclienteemail());
      struct.setPagotipodocumento(getgxTv_SdtSDTComprobantesPagoPaciente_Pagotipodocumento());
      struct.setPagonumero(getgxTv_SdtSDTComprobantesPagoPaciente_Pagonumero());
      if ( gxTv_SdtSDTComprobantesPagoPaciente_Pagofechaemision_N == 0 )
      {
         struct.setPagofechaemision(getgxTv_SdtSDTComprobantesPagoPaciente_Pagofechaemision());
      }
      struct.setPagomoneda(getgxTv_SdtSDTComprobantesPagoPaciente_Pagomoneda());
      struct.setPagonubefactrequest(getgxTv_SdtSDTComprobantesPagoPaciente_Pagonubefactrequest());
      struct.setPagonubefactresponse(getgxTv_SdtSDTComprobantesPagoPaciente_Pagonubefactresponse());
      struct.setPagorequest(getgxTv_SdtSDTComprobantesPagoPaciente_Pagorequest());
      struct.setPagoresponse(getgxTv_SdtSDTComprobantesPagoPaciente_Pagoresponse());
      struct.setDisponibilidadid(getgxTv_SdtSDTComprobantesPagoPaciente_Disponibilidadid());
      struct.setPagoestador(getgxTv_SdtSDTComprobantesPagoPaciente_Pagoestador());
      struct.setPagoenlacepdf(getgxTv_SdtSDTComprobantesPagoPaciente_Pagoenlacepdf());
      struct.setPagoenlacexml(getgxTv_SdtSDTComprobantesPagoPaciente_Pagoenlacexml());
      return struct ;
   }

   protected byte gxTv_SdtSDTComprobantesPagoPaciente_N ;
   protected byte gxTv_SdtSDTComprobantesPagoPaciente_Pagofechaemision_N ;
   protected short gxTv_SdtSDTComprobantesPagoPaciente_Pagotipodocumento ;
   protected short gxTv_SdtSDTComprobantesPagoPaciente_Pagomoneda ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_SdtSDTComprobantesPagoPaciente_Pagoid ;
   protected int gxTv_SdtSDTComprobantesPagoPaciente_Citaid ;
   protected int gxTv_SdtSDTComprobantesPagoPaciente_Pagonumero ;
   protected int gxTv_SdtSDTComprobantesPagoPaciente_Disponibilidadid ;
   protected java.math.BigDecimal gxTv_SdtSDTComprobantesPagoPaciente_Pagomonto ;
   protected String gxTv_SdtSDTComprobantesPagoPaciente_Pagotipodocumentocliente ;
   protected String gxTv_SdtSDTComprobantesPagoPaciente_Pagoestador ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_SdtSDTComprobantesPagoPaciente_Pagofechaemision ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTComprobantesPagoPaciente_Pagonubefactrequest ;
   protected String gxTv_SdtSDTComprobantesPagoPaciente_Pagonubefactresponse ;
   protected String gxTv_SdtSDTComprobantesPagoPaciente_Pagorequest ;
   protected String gxTv_SdtSDTComprobantesPagoPaciente_Pagoresponse ;
   protected String gxTv_SdtSDTComprobantesPagoPaciente_Citacode ;
   protected String gxTv_SdtSDTComprobantesPagoPaciente_Pagoclientenrodocumento ;
   protected String gxTv_SdtSDTComprobantesPagoPaciente_Pagoclientedenominacion ;
   protected String gxTv_SdtSDTComprobantesPagoPaciente_Pagoclientedireccion ;
   protected String gxTv_SdtSDTComprobantesPagoPaciente_Pagoclienteemail ;
   protected String gxTv_SdtSDTComprobantesPagoPaciente_Pagoenlacepdf ;
   protected String gxTv_SdtSDTComprobantesPagoPaciente_Pagoenlacexml ;
}

