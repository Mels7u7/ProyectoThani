package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtPago extends GxSilentTrnSdt implements Cloneable, java.io.Serializable
{
   public SdtPago( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtPago.class));
   }

   public SdtPago( int remoteHandle ,
                   ModelContext context )
   {
      super( remoteHandle, context, "SdtPago");
      initialize( remoteHandle) ;
   }

   public SdtPago( int remoteHandle ,
                   StructSdtPago struct )
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

   public void Load( int AV47PagoId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV47PagoId)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"PagoId", int.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Pago");
      metadata.set("BT", "Pago");
      metadata.set("PK", "[ \"PagoId\" ]");
      metadata.set("PKAssigned", "[ \"PagoId\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CitaId\" ],\"FKMap\":[  ] },{ \"FK\":[ \"DisponibilidadId\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoId") )
            {
               gxTv_SdtPago_Pagoid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaId") )
            {
               gxTv_SdtPago_Citaid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaCode") )
            {
               gxTv_SdtPago_Citacode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadFecha") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtPago_Sgcitadisponibilidadfecha = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtPago_Sgcitadisponibilidadfecha = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoMonto") )
            {
               gxTv_SdtPago_Pagomonto = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoToken") )
            {
               gxTv_SdtPago_Pagotoken = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoTipoDocumentoCliente") )
            {
               gxTv_SdtPago_Pagotipodocumentocliente = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoClienteNroDocumento") )
            {
               gxTv_SdtPago_Pagoclientenrodocumento = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoClienteDenominacion") )
            {
               gxTv_SdtPago_Pagoclientedenominacion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoClienteDireccion") )
            {
               gxTv_SdtPago_Pagoclientedireccion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoClienteEmail") )
            {
               gxTv_SdtPago_Pagoclienteemail = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoTipoDocumento") )
            {
               gxTv_SdtPago_Pagotipodocumento = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoNumero") )
            {
               gxTv_SdtPago_Pagonumero = (int)(getnumericvalue(oReader.getValue())) ;
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
                  gxTv_SdtPago_Pagofechaemision = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtPago_Pagofechaemision = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
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
               gxTv_SdtPago_Pagomoneda = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoNubefactRequest") )
            {
               gxTv_SdtPago_Pagonubefactrequest = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoNubefactResponse") )
            {
               gxTv_SdtPago_Pagonubefactresponse = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoRequest") )
            {
               gxTv_SdtPago_Pagorequest = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoResponse") )
            {
               gxTv_SdtPago_Pagoresponse = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoPasarelaId") )
            {
               gxTv_SdtPago_Pagopasarelaid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoStatusCode") )
            {
               gxTv_SdtPago_Pagostatuscode = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DisponibilidadId") )
            {
               gxTv_SdtPago_Disponibilidadid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoEnlacePDF") )
            {
               gxTv_SdtPago_Pagoenlacepdf = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoEnlaceXML") )
            {
               gxTv_SdtPago_Pagoenlacexml = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoEstadoR") )
            {
               gxTv_SdtPago_Pagoestador = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtPago_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtPago_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoId_Z") )
            {
               gxTv_SdtPago_Pagoid_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaId_Z") )
            {
               gxTv_SdtPago_Citaid_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaCode_Z") )
            {
               gxTv_SdtPago_Citacode_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadFecha_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtPago_Sgcitadisponibilidadfecha_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtPago_Sgcitadisponibilidadfecha_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoMonto_Z") )
            {
               gxTv_SdtPago_Pagomonto_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoToken_Z") )
            {
               gxTv_SdtPago_Pagotoken_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoTipoDocumentoCliente_Z") )
            {
               gxTv_SdtPago_Pagotipodocumentocliente_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoClienteNroDocumento_Z") )
            {
               gxTv_SdtPago_Pagoclientenrodocumento_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoClienteDenominacion_Z") )
            {
               gxTv_SdtPago_Pagoclientedenominacion_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoClienteDireccion_Z") )
            {
               gxTv_SdtPago_Pagoclientedireccion_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoClienteEmail_Z") )
            {
               gxTv_SdtPago_Pagoclienteemail_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoTipoDocumento_Z") )
            {
               gxTv_SdtPago_Pagotipodocumento_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoNumero_Z") )
            {
               gxTv_SdtPago_Pagonumero_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoFechaEmision_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtPago_Pagofechaemision_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtPago_Pagofechaemision_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoMoneda_Z") )
            {
               gxTv_SdtPago_Pagomoneda_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoPasarelaId_Z") )
            {
               gxTv_SdtPago_Pagopasarelaid_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoStatusCode_Z") )
            {
               gxTv_SdtPago_Pagostatuscode_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DisponibilidadId_Z") )
            {
               gxTv_SdtPago_Disponibilidadid_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoEnlacePDF_Z") )
            {
               gxTv_SdtPago_Pagoenlacepdf_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoEnlaceXML_Z") )
            {
               gxTv_SdtPago_Pagoenlacexml_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PagoEstadoR_Z") )
            {
               gxTv_SdtPago_Pagoestador_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaId_N") )
            {
               gxTv_SdtPago_Citaid_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadFecha_N") )
            {
               gxTv_SdtPago_Sgcitadisponibilidadfecha_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DisponibilidadId_N") )
            {
               gxTv_SdtPago_Disponibilidadid_N = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "Pago" ;
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
      oWriter.writeElement("PagoId", GXutil.trim( GXutil.str( gxTv_SdtPago_Pagoid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaId", GXutil.trim( GXutil.str( gxTv_SdtPago_Citaid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaCode", GXutil.rtrim( gxTv_SdtPago_Citacode));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtPago_Sgcitadisponibilidadfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtPago_Sgcitadisponibilidadfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtPago_Sgcitadisponibilidadfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("SGCitaDisponibilidadFecha", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PagoMonto", GXutil.trim( GXutil.strNoRound( gxTv_SdtPago_Pagomonto, 6, 2)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PagoToken", GXutil.rtrim( gxTv_SdtPago_Pagotoken));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PagoTipoDocumentoCliente", GXutil.rtrim( gxTv_SdtPago_Pagotipodocumentocliente));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PagoClienteNroDocumento", GXutil.rtrim( gxTv_SdtPago_Pagoclientenrodocumento));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PagoClienteDenominacion", GXutil.rtrim( gxTv_SdtPago_Pagoclientedenominacion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PagoClienteDireccion", GXutil.rtrim( gxTv_SdtPago_Pagoclientedireccion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PagoClienteEmail", GXutil.rtrim( gxTv_SdtPago_Pagoclienteemail));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PagoTipoDocumento", GXutil.trim( GXutil.str( gxTv_SdtPago_Pagotipodocumento, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PagoNumero", GXutil.trim( GXutil.str( gxTv_SdtPago_Pagonumero, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtPago_Pagofechaemision), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtPago_Pagofechaemision), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtPago_Pagofechaemision), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("PagoFechaEmision", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PagoMoneda", GXutil.trim( GXutil.str( gxTv_SdtPago_Pagomoneda, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PagoNubefactRequest", GXutil.rtrim( gxTv_SdtPago_Pagonubefactrequest));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PagoNubefactResponse", GXutil.rtrim( gxTv_SdtPago_Pagonubefactresponse));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PagoRequest", GXutil.rtrim( gxTv_SdtPago_Pagorequest));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PagoResponse", GXutil.rtrim( gxTv_SdtPago_Pagoresponse));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PagoPasarelaId", GXutil.rtrim( gxTv_SdtPago_Pagopasarelaid));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PagoStatusCode", GXutil.trim( GXutil.str( gxTv_SdtPago_Pagostatuscode, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("DisponibilidadId", GXutil.trim( GXutil.str( gxTv_SdtPago_Disponibilidadid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PagoEnlacePDF", GXutil.rtrim( gxTv_SdtPago_Pagoenlacepdf));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PagoEnlaceXML", GXutil.rtrim( gxTv_SdtPago_Pagoenlacexml));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PagoEstadoR", GXutil.rtrim( gxTv_SdtPago_Pagoestador));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", GXutil.rtrim( gxTv_SdtPago_Mode));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtPago_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PagoId_Z", GXutil.trim( GXutil.str( gxTv_SdtPago_Pagoid_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaId_Z", GXutil.trim( GXutil.str( gxTv_SdtPago_Citaid_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaCode_Z", GXutil.rtrim( gxTv_SdtPago_Citacode_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtPago_Sgcitadisponibilidadfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtPago_Sgcitadisponibilidadfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtPago_Sgcitadisponibilidadfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("SGCitaDisponibilidadFecha_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PagoMonto_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtPago_Pagomonto_Z, 6, 2)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PagoToken_Z", GXutil.rtrim( gxTv_SdtPago_Pagotoken_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PagoTipoDocumentoCliente_Z", GXutil.rtrim( gxTv_SdtPago_Pagotipodocumentocliente_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PagoClienteNroDocumento_Z", GXutil.rtrim( gxTv_SdtPago_Pagoclientenrodocumento_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PagoClienteDenominacion_Z", GXutil.rtrim( gxTv_SdtPago_Pagoclientedenominacion_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PagoClienteDireccion_Z", GXutil.rtrim( gxTv_SdtPago_Pagoclientedireccion_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PagoClienteEmail_Z", GXutil.rtrim( gxTv_SdtPago_Pagoclienteemail_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PagoTipoDocumento_Z", GXutil.trim( GXutil.str( gxTv_SdtPago_Pagotipodocumento_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PagoNumero_Z", GXutil.trim( GXutil.str( gxTv_SdtPago_Pagonumero_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtPago_Pagofechaemision_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtPago_Pagofechaemision_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtPago_Pagofechaemision_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("PagoFechaEmision_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PagoMoneda_Z", GXutil.trim( GXutil.str( gxTv_SdtPago_Pagomoneda_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PagoPasarelaId_Z", GXutil.rtrim( gxTv_SdtPago_Pagopasarelaid_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PagoStatusCode_Z", GXutil.trim( GXutil.str( gxTv_SdtPago_Pagostatuscode_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("DisponibilidadId_Z", GXutil.trim( GXutil.str( gxTv_SdtPago_Disponibilidadid_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PagoEnlacePDF_Z", GXutil.rtrim( gxTv_SdtPago_Pagoenlacepdf_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PagoEnlaceXML_Z", GXutil.rtrim( gxTv_SdtPago_Pagoenlacexml_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PagoEstadoR_Z", GXutil.rtrim( gxTv_SdtPago_Pagoestador_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaId_N", GXutil.trim( GXutil.str( gxTv_SdtPago_Citaid_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SGCitaDisponibilidadFecha_N", GXutil.trim( GXutil.str( gxTv_SdtPago_Sgcitadisponibilidadfecha_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("DisponibilidadId_N", GXutil.trim( GXutil.str( gxTv_SdtPago_Disponibilidadid_N, 1, 0)));
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
      AddObjectProperty("PagoId", gxTv_SdtPago_Pagoid, false, includeNonInitialized);
      AddObjectProperty("CitaId", gxTv_SdtPago_Citaid, false, includeNonInitialized);
      AddObjectProperty("CitaId_N", gxTv_SdtPago_Citaid_N, false, includeNonInitialized);
      AddObjectProperty("CitaCode", gxTv_SdtPago_Citacode, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtPago_Sgcitadisponibilidadfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtPago_Sgcitadisponibilidadfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtPago_Sgcitadisponibilidadfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("SGCitaDisponibilidadFecha", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("SGCitaDisponibilidadFecha_N", gxTv_SdtPago_Sgcitadisponibilidadfecha_N, false, includeNonInitialized);
      AddObjectProperty("PagoMonto", gxTv_SdtPago_Pagomonto, false, includeNonInitialized);
      AddObjectProperty("PagoToken", gxTv_SdtPago_Pagotoken, false, includeNonInitialized);
      AddObjectProperty("PagoTipoDocumentoCliente", gxTv_SdtPago_Pagotipodocumentocliente, false, includeNonInitialized);
      AddObjectProperty("PagoClienteNroDocumento", gxTv_SdtPago_Pagoclientenrodocumento, false, includeNonInitialized);
      AddObjectProperty("PagoClienteDenominacion", gxTv_SdtPago_Pagoclientedenominacion, false, includeNonInitialized);
      AddObjectProperty("PagoClienteDireccion", gxTv_SdtPago_Pagoclientedireccion, false, includeNonInitialized);
      AddObjectProperty("PagoClienteEmail", gxTv_SdtPago_Pagoclienteemail, false, includeNonInitialized);
      AddObjectProperty("PagoTipoDocumento", gxTv_SdtPago_Pagotipodocumento, false, includeNonInitialized);
      AddObjectProperty("PagoNumero", gxTv_SdtPago_Pagonumero, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtPago_Pagofechaemision), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtPago_Pagofechaemision), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtPago_Pagofechaemision), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("PagoFechaEmision", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("PagoMoneda", gxTv_SdtPago_Pagomoneda, false, includeNonInitialized);
      AddObjectProperty("PagoNubefactRequest", gxTv_SdtPago_Pagonubefactrequest, false, includeNonInitialized);
      AddObjectProperty("PagoNubefactResponse", gxTv_SdtPago_Pagonubefactresponse, false, includeNonInitialized);
      AddObjectProperty("PagoRequest", gxTv_SdtPago_Pagorequest, false, includeNonInitialized);
      AddObjectProperty("PagoResponse", gxTv_SdtPago_Pagoresponse, false, includeNonInitialized);
      AddObjectProperty("PagoPasarelaId", gxTv_SdtPago_Pagopasarelaid, false, includeNonInitialized);
      AddObjectProperty("PagoStatusCode", gxTv_SdtPago_Pagostatuscode, false, includeNonInitialized);
      AddObjectProperty("DisponibilidadId", gxTv_SdtPago_Disponibilidadid, false, includeNonInitialized);
      AddObjectProperty("DisponibilidadId_N", gxTv_SdtPago_Disponibilidadid_N, false, includeNonInitialized);
      AddObjectProperty("PagoEnlacePDF", gxTv_SdtPago_Pagoenlacepdf, false, includeNonInitialized);
      AddObjectProperty("PagoEnlaceXML", gxTv_SdtPago_Pagoenlacexml, false, includeNonInitialized);
      AddObjectProperty("PagoEstadoR", gxTv_SdtPago_Pagoestador, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtPago_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtPago_Initialized, false, includeNonInitialized);
         AddObjectProperty("PagoId_Z", gxTv_SdtPago_Pagoid_Z, false, includeNonInitialized);
         AddObjectProperty("CitaId_Z", gxTv_SdtPago_Citaid_Z, false, includeNonInitialized);
         AddObjectProperty("CitaCode_Z", gxTv_SdtPago_Citacode_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtPago_Sgcitadisponibilidadfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtPago_Sgcitadisponibilidadfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtPago_Sgcitadisponibilidadfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("SGCitaDisponibilidadFecha_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("PagoMonto_Z", gxTv_SdtPago_Pagomonto_Z, false, includeNonInitialized);
         AddObjectProperty("PagoToken_Z", gxTv_SdtPago_Pagotoken_Z, false, includeNonInitialized);
         AddObjectProperty("PagoTipoDocumentoCliente_Z", gxTv_SdtPago_Pagotipodocumentocliente_Z, false, includeNonInitialized);
         AddObjectProperty("PagoClienteNroDocumento_Z", gxTv_SdtPago_Pagoclientenrodocumento_Z, false, includeNonInitialized);
         AddObjectProperty("PagoClienteDenominacion_Z", gxTv_SdtPago_Pagoclientedenominacion_Z, false, includeNonInitialized);
         AddObjectProperty("PagoClienteDireccion_Z", gxTv_SdtPago_Pagoclientedireccion_Z, false, includeNonInitialized);
         AddObjectProperty("PagoClienteEmail_Z", gxTv_SdtPago_Pagoclienteemail_Z, false, includeNonInitialized);
         AddObjectProperty("PagoTipoDocumento_Z", gxTv_SdtPago_Pagotipodocumento_Z, false, includeNonInitialized);
         AddObjectProperty("PagoNumero_Z", gxTv_SdtPago_Pagonumero_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtPago_Pagofechaemision_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtPago_Pagofechaemision_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtPago_Pagofechaemision_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("PagoFechaEmision_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("PagoMoneda_Z", gxTv_SdtPago_Pagomoneda_Z, false, includeNonInitialized);
         AddObjectProperty("PagoPasarelaId_Z", gxTv_SdtPago_Pagopasarelaid_Z, false, includeNonInitialized);
         AddObjectProperty("PagoStatusCode_Z", gxTv_SdtPago_Pagostatuscode_Z, false, includeNonInitialized);
         AddObjectProperty("DisponibilidadId_Z", gxTv_SdtPago_Disponibilidadid_Z, false, includeNonInitialized);
         AddObjectProperty("PagoEnlacePDF_Z", gxTv_SdtPago_Pagoenlacepdf_Z, false, includeNonInitialized);
         AddObjectProperty("PagoEnlaceXML_Z", gxTv_SdtPago_Pagoenlacexml_Z, false, includeNonInitialized);
         AddObjectProperty("PagoEstadoR_Z", gxTv_SdtPago_Pagoestador_Z, false, includeNonInitialized);
         AddObjectProperty("CitaId_N", gxTv_SdtPago_Citaid_N, false, includeNonInitialized);
         AddObjectProperty("SGCitaDisponibilidadFecha_N", gxTv_SdtPago_Sgcitadisponibilidadfecha_N, false, includeNonInitialized);
         AddObjectProperty("DisponibilidadId_N", gxTv_SdtPago_Disponibilidadid_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.projectthani.SdtPago sdt )
   {
      if ( sdt.IsDirty("PagoId") )
      {
         gxTv_SdtPago_N = (byte)(0) ;
         gxTv_SdtPago_Pagoid = sdt.getgxTv_SdtPago_Pagoid() ;
      }
      if ( sdt.IsDirty("CitaId") )
      {
         gxTv_SdtPago_Citaid_N = (byte)(0) ;
         gxTv_SdtPago_N = (byte)(0) ;
         gxTv_SdtPago_Citaid = sdt.getgxTv_SdtPago_Citaid() ;
      }
      if ( sdt.IsDirty("CitaCode") )
      {
         gxTv_SdtPago_N = (byte)(0) ;
         gxTv_SdtPago_Citacode = sdt.getgxTv_SdtPago_Citacode() ;
      }
      if ( sdt.IsDirty("SGCitaDisponibilidadFecha") )
      {
         gxTv_SdtPago_Sgcitadisponibilidadfecha_N = (byte)(0) ;
         gxTv_SdtPago_N = (byte)(0) ;
         gxTv_SdtPago_Sgcitadisponibilidadfecha = sdt.getgxTv_SdtPago_Sgcitadisponibilidadfecha() ;
      }
      if ( sdt.IsDirty("PagoMonto") )
      {
         gxTv_SdtPago_N = (byte)(0) ;
         gxTv_SdtPago_Pagomonto = sdt.getgxTv_SdtPago_Pagomonto() ;
      }
      if ( sdt.IsDirty("PagoToken") )
      {
         gxTv_SdtPago_N = (byte)(0) ;
         gxTv_SdtPago_Pagotoken = sdt.getgxTv_SdtPago_Pagotoken() ;
      }
      if ( sdt.IsDirty("PagoTipoDocumentoCliente") )
      {
         gxTv_SdtPago_N = (byte)(0) ;
         gxTv_SdtPago_Pagotipodocumentocliente = sdt.getgxTv_SdtPago_Pagotipodocumentocliente() ;
      }
      if ( sdt.IsDirty("PagoClienteNroDocumento") )
      {
         gxTv_SdtPago_N = (byte)(0) ;
         gxTv_SdtPago_Pagoclientenrodocumento = sdt.getgxTv_SdtPago_Pagoclientenrodocumento() ;
      }
      if ( sdt.IsDirty("PagoClienteDenominacion") )
      {
         gxTv_SdtPago_N = (byte)(0) ;
         gxTv_SdtPago_Pagoclientedenominacion = sdt.getgxTv_SdtPago_Pagoclientedenominacion() ;
      }
      if ( sdt.IsDirty("PagoClienteDireccion") )
      {
         gxTv_SdtPago_N = (byte)(0) ;
         gxTv_SdtPago_Pagoclientedireccion = sdt.getgxTv_SdtPago_Pagoclientedireccion() ;
      }
      if ( sdt.IsDirty("PagoClienteEmail") )
      {
         gxTv_SdtPago_N = (byte)(0) ;
         gxTv_SdtPago_Pagoclienteemail = sdt.getgxTv_SdtPago_Pagoclienteemail() ;
      }
      if ( sdt.IsDirty("PagoTipoDocumento") )
      {
         gxTv_SdtPago_N = (byte)(0) ;
         gxTv_SdtPago_Pagotipodocumento = sdt.getgxTv_SdtPago_Pagotipodocumento() ;
      }
      if ( sdt.IsDirty("PagoNumero") )
      {
         gxTv_SdtPago_N = (byte)(0) ;
         gxTv_SdtPago_Pagonumero = sdt.getgxTv_SdtPago_Pagonumero() ;
      }
      if ( sdt.IsDirty("PagoFechaEmision") )
      {
         gxTv_SdtPago_N = (byte)(0) ;
         gxTv_SdtPago_Pagofechaemision = sdt.getgxTv_SdtPago_Pagofechaemision() ;
      }
      if ( sdt.IsDirty("PagoMoneda") )
      {
         gxTv_SdtPago_N = (byte)(0) ;
         gxTv_SdtPago_Pagomoneda = sdt.getgxTv_SdtPago_Pagomoneda() ;
      }
      if ( sdt.IsDirty("PagoNubefactRequest") )
      {
         gxTv_SdtPago_N = (byte)(0) ;
         gxTv_SdtPago_Pagonubefactrequest = sdt.getgxTv_SdtPago_Pagonubefactrequest() ;
      }
      if ( sdt.IsDirty("PagoNubefactResponse") )
      {
         gxTv_SdtPago_N = (byte)(0) ;
         gxTv_SdtPago_Pagonubefactresponse = sdt.getgxTv_SdtPago_Pagonubefactresponse() ;
      }
      if ( sdt.IsDirty("PagoRequest") )
      {
         gxTv_SdtPago_N = (byte)(0) ;
         gxTv_SdtPago_Pagorequest = sdt.getgxTv_SdtPago_Pagorequest() ;
      }
      if ( sdt.IsDirty("PagoResponse") )
      {
         gxTv_SdtPago_N = (byte)(0) ;
         gxTv_SdtPago_Pagoresponse = sdt.getgxTv_SdtPago_Pagoresponse() ;
      }
      if ( sdt.IsDirty("PagoPasarelaId") )
      {
         gxTv_SdtPago_N = (byte)(0) ;
         gxTv_SdtPago_Pagopasarelaid = sdt.getgxTv_SdtPago_Pagopasarelaid() ;
      }
      if ( sdt.IsDirty("PagoStatusCode") )
      {
         gxTv_SdtPago_N = (byte)(0) ;
         gxTv_SdtPago_Pagostatuscode = sdt.getgxTv_SdtPago_Pagostatuscode() ;
      }
      if ( sdt.IsDirty("DisponibilidadId") )
      {
         gxTv_SdtPago_Disponibilidadid_N = (byte)(0) ;
         gxTv_SdtPago_N = (byte)(0) ;
         gxTv_SdtPago_Disponibilidadid = sdt.getgxTv_SdtPago_Disponibilidadid() ;
      }
      if ( sdt.IsDirty("PagoEnlacePDF") )
      {
         gxTv_SdtPago_N = (byte)(0) ;
         gxTv_SdtPago_Pagoenlacepdf = sdt.getgxTv_SdtPago_Pagoenlacepdf() ;
      }
      if ( sdt.IsDirty("PagoEnlaceXML") )
      {
         gxTv_SdtPago_N = (byte)(0) ;
         gxTv_SdtPago_Pagoenlacexml = sdt.getgxTv_SdtPago_Pagoenlacexml() ;
      }
      if ( sdt.IsDirty("PagoEstadoR") )
      {
         gxTv_SdtPago_N = (byte)(0) ;
         gxTv_SdtPago_Pagoestador = sdt.getgxTv_SdtPago_Pagoestador() ;
      }
   }

   public int getgxTv_SdtPago_Pagoid( )
   {
      return gxTv_SdtPago_Pagoid ;
   }

   public void setgxTv_SdtPago_Pagoid( int value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      if ( gxTv_SdtPago_Pagoid != value )
      {
         gxTv_SdtPago_Mode = "INS" ;
         this.setgxTv_SdtPago_Pagoid_Z_SetNull( );
         this.setgxTv_SdtPago_Citaid_Z_SetNull( );
         this.setgxTv_SdtPago_Citacode_Z_SetNull( );
         this.setgxTv_SdtPago_Sgcitadisponibilidadfecha_Z_SetNull( );
         this.setgxTv_SdtPago_Pagomonto_Z_SetNull( );
         this.setgxTv_SdtPago_Pagotoken_Z_SetNull( );
         this.setgxTv_SdtPago_Pagotipodocumentocliente_Z_SetNull( );
         this.setgxTv_SdtPago_Pagoclientenrodocumento_Z_SetNull( );
         this.setgxTv_SdtPago_Pagoclientedenominacion_Z_SetNull( );
         this.setgxTv_SdtPago_Pagoclientedireccion_Z_SetNull( );
         this.setgxTv_SdtPago_Pagoclienteemail_Z_SetNull( );
         this.setgxTv_SdtPago_Pagotipodocumento_Z_SetNull( );
         this.setgxTv_SdtPago_Pagonumero_Z_SetNull( );
         this.setgxTv_SdtPago_Pagofechaemision_Z_SetNull( );
         this.setgxTv_SdtPago_Pagomoneda_Z_SetNull( );
         this.setgxTv_SdtPago_Pagopasarelaid_Z_SetNull( );
         this.setgxTv_SdtPago_Pagostatuscode_Z_SetNull( );
         this.setgxTv_SdtPago_Disponibilidadid_Z_SetNull( );
         this.setgxTv_SdtPago_Pagoenlacepdf_Z_SetNull( );
         this.setgxTv_SdtPago_Pagoenlacexml_Z_SetNull( );
         this.setgxTv_SdtPago_Pagoestador_Z_SetNull( );
      }
      SetDirty("Pagoid");
      gxTv_SdtPago_Pagoid = value ;
   }

   public int getgxTv_SdtPago_Citaid( )
   {
      return gxTv_SdtPago_Citaid ;
   }

   public void setgxTv_SdtPago_Citaid( int value )
   {
      gxTv_SdtPago_Citaid_N = (byte)(0) ;
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Citaid");
      gxTv_SdtPago_Citaid = value ;
   }

   public void setgxTv_SdtPago_Citaid_SetNull( )
   {
      gxTv_SdtPago_Citaid_N = (byte)(1) ;
      gxTv_SdtPago_Citaid = 0 ;
   }

   public boolean getgxTv_SdtPago_Citaid_IsNull( )
   {
      return (gxTv_SdtPago_Citaid_N==1) ;
   }

   public String getgxTv_SdtPago_Citacode( )
   {
      return gxTv_SdtPago_Citacode ;
   }

   public void setgxTv_SdtPago_Citacode( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Citacode");
      gxTv_SdtPago_Citacode = value ;
   }

   public java.util.Date getgxTv_SdtPago_Sgcitadisponibilidadfecha( )
   {
      return gxTv_SdtPago_Sgcitadisponibilidadfecha ;
   }

   public void setgxTv_SdtPago_Sgcitadisponibilidadfecha( java.util.Date value )
   {
      gxTv_SdtPago_Sgcitadisponibilidadfecha_N = (byte)(0) ;
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadfecha");
      gxTv_SdtPago_Sgcitadisponibilidadfecha = value ;
   }

   public void setgxTv_SdtPago_Sgcitadisponibilidadfecha_SetNull( )
   {
      gxTv_SdtPago_Sgcitadisponibilidadfecha_N = (byte)(1) ;
      gxTv_SdtPago_Sgcitadisponibilidadfecha = GXutil.nullDate() ;
   }

   public boolean getgxTv_SdtPago_Sgcitadisponibilidadfecha_IsNull( )
   {
      return (gxTv_SdtPago_Sgcitadisponibilidadfecha_N==1) ;
   }

   public java.math.BigDecimal getgxTv_SdtPago_Pagomonto( )
   {
      return gxTv_SdtPago_Pagomonto ;
   }

   public void setgxTv_SdtPago_Pagomonto( java.math.BigDecimal value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Pagomonto");
      gxTv_SdtPago_Pagomonto = value ;
   }

   public String getgxTv_SdtPago_Pagotoken( )
   {
      return gxTv_SdtPago_Pagotoken ;
   }

   public void setgxTv_SdtPago_Pagotoken( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Pagotoken");
      gxTv_SdtPago_Pagotoken = value ;
   }

   public String getgxTv_SdtPago_Pagotipodocumentocliente( )
   {
      return gxTv_SdtPago_Pagotipodocumentocliente ;
   }

   public void setgxTv_SdtPago_Pagotipodocumentocliente( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Pagotipodocumentocliente");
      gxTv_SdtPago_Pagotipodocumentocliente = value ;
   }

   public String getgxTv_SdtPago_Pagoclientenrodocumento( )
   {
      return gxTv_SdtPago_Pagoclientenrodocumento ;
   }

   public void setgxTv_SdtPago_Pagoclientenrodocumento( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Pagoclientenrodocumento");
      gxTv_SdtPago_Pagoclientenrodocumento = value ;
   }

   public String getgxTv_SdtPago_Pagoclientedenominacion( )
   {
      return gxTv_SdtPago_Pagoclientedenominacion ;
   }

   public void setgxTv_SdtPago_Pagoclientedenominacion( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Pagoclientedenominacion");
      gxTv_SdtPago_Pagoclientedenominacion = value ;
   }

   public String getgxTv_SdtPago_Pagoclientedireccion( )
   {
      return gxTv_SdtPago_Pagoclientedireccion ;
   }

   public void setgxTv_SdtPago_Pagoclientedireccion( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Pagoclientedireccion");
      gxTv_SdtPago_Pagoclientedireccion = value ;
   }

   public String getgxTv_SdtPago_Pagoclienteemail( )
   {
      return gxTv_SdtPago_Pagoclienteemail ;
   }

   public void setgxTv_SdtPago_Pagoclienteemail( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Pagoclienteemail");
      gxTv_SdtPago_Pagoclienteemail = value ;
   }

   public short getgxTv_SdtPago_Pagotipodocumento( )
   {
      return gxTv_SdtPago_Pagotipodocumento ;
   }

   public void setgxTv_SdtPago_Pagotipodocumento( short value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Pagotipodocumento");
      gxTv_SdtPago_Pagotipodocumento = value ;
   }

   public int getgxTv_SdtPago_Pagonumero( )
   {
      return gxTv_SdtPago_Pagonumero ;
   }

   public void setgxTv_SdtPago_Pagonumero( int value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Pagonumero");
      gxTv_SdtPago_Pagonumero = value ;
   }

   public java.util.Date getgxTv_SdtPago_Pagofechaemision( )
   {
      return gxTv_SdtPago_Pagofechaemision ;
   }

   public void setgxTv_SdtPago_Pagofechaemision( java.util.Date value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Pagofechaemision");
      gxTv_SdtPago_Pagofechaemision = value ;
   }

   public short getgxTv_SdtPago_Pagomoneda( )
   {
      return gxTv_SdtPago_Pagomoneda ;
   }

   public void setgxTv_SdtPago_Pagomoneda( short value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Pagomoneda");
      gxTv_SdtPago_Pagomoneda = value ;
   }

   public String getgxTv_SdtPago_Pagonubefactrequest( )
   {
      return gxTv_SdtPago_Pagonubefactrequest ;
   }

   public void setgxTv_SdtPago_Pagonubefactrequest( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Pagonubefactrequest");
      gxTv_SdtPago_Pagonubefactrequest = value ;
   }

   public String getgxTv_SdtPago_Pagonubefactresponse( )
   {
      return gxTv_SdtPago_Pagonubefactresponse ;
   }

   public void setgxTv_SdtPago_Pagonubefactresponse( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Pagonubefactresponse");
      gxTv_SdtPago_Pagonubefactresponse = value ;
   }

   public String getgxTv_SdtPago_Pagorequest( )
   {
      return gxTv_SdtPago_Pagorequest ;
   }

   public void setgxTv_SdtPago_Pagorequest( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Pagorequest");
      gxTv_SdtPago_Pagorequest = value ;
   }

   public String getgxTv_SdtPago_Pagoresponse( )
   {
      return gxTv_SdtPago_Pagoresponse ;
   }

   public void setgxTv_SdtPago_Pagoresponse( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Pagoresponse");
      gxTv_SdtPago_Pagoresponse = value ;
   }

   public String getgxTv_SdtPago_Pagopasarelaid( )
   {
      return gxTv_SdtPago_Pagopasarelaid ;
   }

   public void setgxTv_SdtPago_Pagopasarelaid( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Pagopasarelaid");
      gxTv_SdtPago_Pagopasarelaid = value ;
   }

   public int getgxTv_SdtPago_Pagostatuscode( )
   {
      return gxTv_SdtPago_Pagostatuscode ;
   }

   public void setgxTv_SdtPago_Pagostatuscode( int value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Pagostatuscode");
      gxTv_SdtPago_Pagostatuscode = value ;
   }

   public int getgxTv_SdtPago_Disponibilidadid( )
   {
      return gxTv_SdtPago_Disponibilidadid ;
   }

   public void setgxTv_SdtPago_Disponibilidadid( int value )
   {
      gxTv_SdtPago_Disponibilidadid_N = (byte)(0) ;
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Disponibilidadid");
      gxTv_SdtPago_Disponibilidadid = value ;
   }

   public void setgxTv_SdtPago_Disponibilidadid_SetNull( )
   {
      gxTv_SdtPago_Disponibilidadid_N = (byte)(1) ;
      gxTv_SdtPago_Disponibilidadid = 0 ;
   }

   public boolean getgxTv_SdtPago_Disponibilidadid_IsNull( )
   {
      return (gxTv_SdtPago_Disponibilidadid_N==1) ;
   }

   public String getgxTv_SdtPago_Pagoenlacepdf( )
   {
      return gxTv_SdtPago_Pagoenlacepdf ;
   }

   public void setgxTv_SdtPago_Pagoenlacepdf( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Pagoenlacepdf");
      gxTv_SdtPago_Pagoenlacepdf = value ;
   }

   public String getgxTv_SdtPago_Pagoenlacexml( )
   {
      return gxTv_SdtPago_Pagoenlacexml ;
   }

   public void setgxTv_SdtPago_Pagoenlacexml( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Pagoenlacexml");
      gxTv_SdtPago_Pagoenlacexml = value ;
   }

   public String getgxTv_SdtPago_Pagoestador( )
   {
      return gxTv_SdtPago_Pagoestador ;
   }

   public void setgxTv_SdtPago_Pagoestador( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Pagoestador");
      gxTv_SdtPago_Pagoestador = value ;
   }

   public String getgxTv_SdtPago_Mode( )
   {
      return gxTv_SdtPago_Mode ;
   }

   public void setgxTv_SdtPago_Mode( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtPago_Mode = value ;
   }

   public void setgxTv_SdtPago_Mode_SetNull( )
   {
      gxTv_SdtPago_Mode = "" ;
   }

   public boolean getgxTv_SdtPago_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtPago_Initialized( )
   {
      return gxTv_SdtPago_Initialized ;
   }

   public void setgxTv_SdtPago_Initialized( short value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtPago_Initialized = value ;
   }

   public void setgxTv_SdtPago_Initialized_SetNull( )
   {
      gxTv_SdtPago_Initialized = (short)(0) ;
   }

   public boolean getgxTv_SdtPago_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtPago_Pagoid_Z( )
   {
      return gxTv_SdtPago_Pagoid_Z ;
   }

   public void setgxTv_SdtPago_Pagoid_Z( int value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Pagoid_Z");
      gxTv_SdtPago_Pagoid_Z = value ;
   }

   public void setgxTv_SdtPago_Pagoid_Z_SetNull( )
   {
      gxTv_SdtPago_Pagoid_Z = 0 ;
   }

   public boolean getgxTv_SdtPago_Pagoid_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtPago_Citaid_Z( )
   {
      return gxTv_SdtPago_Citaid_Z ;
   }

   public void setgxTv_SdtPago_Citaid_Z( int value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Citaid_Z");
      gxTv_SdtPago_Citaid_Z = value ;
   }

   public void setgxTv_SdtPago_Citaid_Z_SetNull( )
   {
      gxTv_SdtPago_Citaid_Z = 0 ;
   }

   public boolean getgxTv_SdtPago_Citaid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPago_Citacode_Z( )
   {
      return gxTv_SdtPago_Citacode_Z ;
   }

   public void setgxTv_SdtPago_Citacode_Z( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Citacode_Z");
      gxTv_SdtPago_Citacode_Z = value ;
   }

   public void setgxTv_SdtPago_Citacode_Z_SetNull( )
   {
      gxTv_SdtPago_Citacode_Z = "" ;
   }

   public boolean getgxTv_SdtPago_Citacode_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtPago_Sgcitadisponibilidadfecha_Z( )
   {
      return gxTv_SdtPago_Sgcitadisponibilidadfecha_Z ;
   }

   public void setgxTv_SdtPago_Sgcitadisponibilidadfecha_Z( java.util.Date value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadfecha_Z");
      gxTv_SdtPago_Sgcitadisponibilidadfecha_Z = value ;
   }

   public void setgxTv_SdtPago_Sgcitadisponibilidadfecha_Z_SetNull( )
   {
      gxTv_SdtPago_Sgcitadisponibilidadfecha_Z = GXutil.nullDate() ;
   }

   public boolean getgxTv_SdtPago_Sgcitadisponibilidadfecha_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtPago_Pagomonto_Z( )
   {
      return gxTv_SdtPago_Pagomonto_Z ;
   }

   public void setgxTv_SdtPago_Pagomonto_Z( java.math.BigDecimal value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Pagomonto_Z");
      gxTv_SdtPago_Pagomonto_Z = value ;
   }

   public void setgxTv_SdtPago_Pagomonto_Z_SetNull( )
   {
      gxTv_SdtPago_Pagomonto_Z = DecimalUtil.ZERO ;
   }

   public boolean getgxTv_SdtPago_Pagomonto_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPago_Pagotoken_Z( )
   {
      return gxTv_SdtPago_Pagotoken_Z ;
   }

   public void setgxTv_SdtPago_Pagotoken_Z( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Pagotoken_Z");
      gxTv_SdtPago_Pagotoken_Z = value ;
   }

   public void setgxTv_SdtPago_Pagotoken_Z_SetNull( )
   {
      gxTv_SdtPago_Pagotoken_Z = "" ;
   }

   public boolean getgxTv_SdtPago_Pagotoken_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPago_Pagotipodocumentocliente_Z( )
   {
      return gxTv_SdtPago_Pagotipodocumentocliente_Z ;
   }

   public void setgxTv_SdtPago_Pagotipodocumentocliente_Z( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Pagotipodocumentocliente_Z");
      gxTv_SdtPago_Pagotipodocumentocliente_Z = value ;
   }

   public void setgxTv_SdtPago_Pagotipodocumentocliente_Z_SetNull( )
   {
      gxTv_SdtPago_Pagotipodocumentocliente_Z = "" ;
   }

   public boolean getgxTv_SdtPago_Pagotipodocumentocliente_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPago_Pagoclientenrodocumento_Z( )
   {
      return gxTv_SdtPago_Pagoclientenrodocumento_Z ;
   }

   public void setgxTv_SdtPago_Pagoclientenrodocumento_Z( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Pagoclientenrodocumento_Z");
      gxTv_SdtPago_Pagoclientenrodocumento_Z = value ;
   }

   public void setgxTv_SdtPago_Pagoclientenrodocumento_Z_SetNull( )
   {
      gxTv_SdtPago_Pagoclientenrodocumento_Z = "" ;
   }

   public boolean getgxTv_SdtPago_Pagoclientenrodocumento_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPago_Pagoclientedenominacion_Z( )
   {
      return gxTv_SdtPago_Pagoclientedenominacion_Z ;
   }

   public void setgxTv_SdtPago_Pagoclientedenominacion_Z( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Pagoclientedenominacion_Z");
      gxTv_SdtPago_Pagoclientedenominacion_Z = value ;
   }

   public void setgxTv_SdtPago_Pagoclientedenominacion_Z_SetNull( )
   {
      gxTv_SdtPago_Pagoclientedenominacion_Z = "" ;
   }

   public boolean getgxTv_SdtPago_Pagoclientedenominacion_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPago_Pagoclientedireccion_Z( )
   {
      return gxTv_SdtPago_Pagoclientedireccion_Z ;
   }

   public void setgxTv_SdtPago_Pagoclientedireccion_Z( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Pagoclientedireccion_Z");
      gxTv_SdtPago_Pagoclientedireccion_Z = value ;
   }

   public void setgxTv_SdtPago_Pagoclientedireccion_Z_SetNull( )
   {
      gxTv_SdtPago_Pagoclientedireccion_Z = "" ;
   }

   public boolean getgxTv_SdtPago_Pagoclientedireccion_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPago_Pagoclienteemail_Z( )
   {
      return gxTv_SdtPago_Pagoclienteemail_Z ;
   }

   public void setgxTv_SdtPago_Pagoclienteemail_Z( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Pagoclienteemail_Z");
      gxTv_SdtPago_Pagoclienteemail_Z = value ;
   }

   public void setgxTv_SdtPago_Pagoclienteemail_Z_SetNull( )
   {
      gxTv_SdtPago_Pagoclienteemail_Z = "" ;
   }

   public boolean getgxTv_SdtPago_Pagoclienteemail_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtPago_Pagotipodocumento_Z( )
   {
      return gxTv_SdtPago_Pagotipodocumento_Z ;
   }

   public void setgxTv_SdtPago_Pagotipodocumento_Z( short value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Pagotipodocumento_Z");
      gxTv_SdtPago_Pagotipodocumento_Z = value ;
   }

   public void setgxTv_SdtPago_Pagotipodocumento_Z_SetNull( )
   {
      gxTv_SdtPago_Pagotipodocumento_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtPago_Pagotipodocumento_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtPago_Pagonumero_Z( )
   {
      return gxTv_SdtPago_Pagonumero_Z ;
   }

   public void setgxTv_SdtPago_Pagonumero_Z( int value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Pagonumero_Z");
      gxTv_SdtPago_Pagonumero_Z = value ;
   }

   public void setgxTv_SdtPago_Pagonumero_Z_SetNull( )
   {
      gxTv_SdtPago_Pagonumero_Z = 0 ;
   }

   public boolean getgxTv_SdtPago_Pagonumero_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtPago_Pagofechaemision_Z( )
   {
      return gxTv_SdtPago_Pagofechaemision_Z ;
   }

   public void setgxTv_SdtPago_Pagofechaemision_Z( java.util.Date value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Pagofechaemision_Z");
      gxTv_SdtPago_Pagofechaemision_Z = value ;
   }

   public void setgxTv_SdtPago_Pagofechaemision_Z_SetNull( )
   {
      gxTv_SdtPago_Pagofechaemision_Z = GXutil.nullDate() ;
   }

   public boolean getgxTv_SdtPago_Pagofechaemision_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtPago_Pagomoneda_Z( )
   {
      return gxTv_SdtPago_Pagomoneda_Z ;
   }

   public void setgxTv_SdtPago_Pagomoneda_Z( short value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Pagomoneda_Z");
      gxTv_SdtPago_Pagomoneda_Z = value ;
   }

   public void setgxTv_SdtPago_Pagomoneda_Z_SetNull( )
   {
      gxTv_SdtPago_Pagomoneda_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtPago_Pagomoneda_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPago_Pagopasarelaid_Z( )
   {
      return gxTv_SdtPago_Pagopasarelaid_Z ;
   }

   public void setgxTv_SdtPago_Pagopasarelaid_Z( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Pagopasarelaid_Z");
      gxTv_SdtPago_Pagopasarelaid_Z = value ;
   }

   public void setgxTv_SdtPago_Pagopasarelaid_Z_SetNull( )
   {
      gxTv_SdtPago_Pagopasarelaid_Z = "" ;
   }

   public boolean getgxTv_SdtPago_Pagopasarelaid_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtPago_Pagostatuscode_Z( )
   {
      return gxTv_SdtPago_Pagostatuscode_Z ;
   }

   public void setgxTv_SdtPago_Pagostatuscode_Z( int value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Pagostatuscode_Z");
      gxTv_SdtPago_Pagostatuscode_Z = value ;
   }

   public void setgxTv_SdtPago_Pagostatuscode_Z_SetNull( )
   {
      gxTv_SdtPago_Pagostatuscode_Z = 0 ;
   }

   public boolean getgxTv_SdtPago_Pagostatuscode_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtPago_Disponibilidadid_Z( )
   {
      return gxTv_SdtPago_Disponibilidadid_Z ;
   }

   public void setgxTv_SdtPago_Disponibilidadid_Z( int value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Disponibilidadid_Z");
      gxTv_SdtPago_Disponibilidadid_Z = value ;
   }

   public void setgxTv_SdtPago_Disponibilidadid_Z_SetNull( )
   {
      gxTv_SdtPago_Disponibilidadid_Z = 0 ;
   }

   public boolean getgxTv_SdtPago_Disponibilidadid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPago_Pagoenlacepdf_Z( )
   {
      return gxTv_SdtPago_Pagoenlacepdf_Z ;
   }

   public void setgxTv_SdtPago_Pagoenlacepdf_Z( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Pagoenlacepdf_Z");
      gxTv_SdtPago_Pagoenlacepdf_Z = value ;
   }

   public void setgxTv_SdtPago_Pagoenlacepdf_Z_SetNull( )
   {
      gxTv_SdtPago_Pagoenlacepdf_Z = "" ;
   }

   public boolean getgxTv_SdtPago_Pagoenlacepdf_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPago_Pagoenlacexml_Z( )
   {
      return gxTv_SdtPago_Pagoenlacexml_Z ;
   }

   public void setgxTv_SdtPago_Pagoenlacexml_Z( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Pagoenlacexml_Z");
      gxTv_SdtPago_Pagoenlacexml_Z = value ;
   }

   public void setgxTv_SdtPago_Pagoenlacexml_Z_SetNull( )
   {
      gxTv_SdtPago_Pagoenlacexml_Z = "" ;
   }

   public boolean getgxTv_SdtPago_Pagoenlacexml_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPago_Pagoestador_Z( )
   {
      return gxTv_SdtPago_Pagoestador_Z ;
   }

   public void setgxTv_SdtPago_Pagoestador_Z( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Pagoestador_Z");
      gxTv_SdtPago_Pagoestador_Z = value ;
   }

   public void setgxTv_SdtPago_Pagoestador_Z_SetNull( )
   {
      gxTv_SdtPago_Pagoestador_Z = "" ;
   }

   public boolean getgxTv_SdtPago_Pagoestador_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtPago_Citaid_N( )
   {
      return gxTv_SdtPago_Citaid_N ;
   }

   public void setgxTv_SdtPago_Citaid_N( byte value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Citaid_N");
      gxTv_SdtPago_Citaid_N = value ;
   }

   public void setgxTv_SdtPago_Citaid_N_SetNull( )
   {
      gxTv_SdtPago_Citaid_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtPago_Citaid_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtPago_Sgcitadisponibilidadfecha_N( )
   {
      return gxTv_SdtPago_Sgcitadisponibilidadfecha_N ;
   }

   public void setgxTv_SdtPago_Sgcitadisponibilidadfecha_N( byte value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadfecha_N");
      gxTv_SdtPago_Sgcitadisponibilidadfecha_N = value ;
   }

   public void setgxTv_SdtPago_Sgcitadisponibilidadfecha_N_SetNull( )
   {
      gxTv_SdtPago_Sgcitadisponibilidadfecha_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtPago_Sgcitadisponibilidadfecha_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtPago_Disponibilidadid_N( )
   {
      return gxTv_SdtPago_Disponibilidadid_N ;
   }

   public void setgxTv_SdtPago_Disponibilidadid_N( byte value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      SetDirty("Disponibilidadid_N");
      gxTv_SdtPago_Disponibilidadid_N = value ;
   }

   public void setgxTv_SdtPago_Disponibilidadid_N_SetNull( )
   {
      gxTv_SdtPago_Disponibilidadid_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtPago_Disponibilidadid_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.projectthani.pago_bc obj;
      obj = new com.projectthani.pago_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtPago_N = (byte)(1) ;
      gxTv_SdtPago_Citacode = "" ;
      gxTv_SdtPago_Sgcitadisponibilidadfecha = GXutil.nullDate() ;
      gxTv_SdtPago_Pagomonto = DecimalUtil.ZERO ;
      gxTv_SdtPago_Pagotoken = "" ;
      gxTv_SdtPago_Pagotipodocumentocliente = "" ;
      gxTv_SdtPago_Pagoclientenrodocumento = "" ;
      gxTv_SdtPago_Pagoclientedenominacion = "" ;
      gxTv_SdtPago_Pagoclientedireccion = "" ;
      gxTv_SdtPago_Pagoclienteemail = "" ;
      gxTv_SdtPago_Pagofechaemision = GXutil.nullDate() ;
      gxTv_SdtPago_Pagonubefactrequest = "" ;
      gxTv_SdtPago_Pagonubefactresponse = "" ;
      gxTv_SdtPago_Pagorequest = "" ;
      gxTv_SdtPago_Pagoresponse = "" ;
      gxTv_SdtPago_Pagopasarelaid = "" ;
      gxTv_SdtPago_Pagoenlacepdf = "" ;
      gxTv_SdtPago_Pagoenlacexml = "" ;
      gxTv_SdtPago_Pagoestador = "" ;
      gxTv_SdtPago_Mode = "" ;
      gxTv_SdtPago_Citacode_Z = "" ;
      gxTv_SdtPago_Sgcitadisponibilidadfecha_Z = GXutil.nullDate() ;
      gxTv_SdtPago_Pagomonto_Z = DecimalUtil.ZERO ;
      gxTv_SdtPago_Pagotoken_Z = "" ;
      gxTv_SdtPago_Pagotipodocumentocliente_Z = "" ;
      gxTv_SdtPago_Pagoclientenrodocumento_Z = "" ;
      gxTv_SdtPago_Pagoclientedenominacion_Z = "" ;
      gxTv_SdtPago_Pagoclientedireccion_Z = "" ;
      gxTv_SdtPago_Pagoclienteemail_Z = "" ;
      gxTv_SdtPago_Pagofechaemision_Z = GXutil.nullDate() ;
      gxTv_SdtPago_Pagopasarelaid_Z = "" ;
      gxTv_SdtPago_Pagoenlacepdf_Z = "" ;
      gxTv_SdtPago_Pagoenlacexml_Z = "" ;
      gxTv_SdtPago_Pagoestador_Z = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtPago_N ;
   }

   public com.projectthani.SdtPago Clone( )
   {
      com.projectthani.SdtPago sdt;
      com.projectthani.pago_bc obj;
      sdt = (com.projectthani.SdtPago)(clone()) ;
      obj = (com.projectthani.pago_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.projectthani.StructSdtPago struct )
   {
      setgxTv_SdtPago_Pagoid(struct.getPagoid());
      setgxTv_SdtPago_Citaid(struct.getCitaid());
      setgxTv_SdtPago_Citacode(struct.getCitacode());
      setgxTv_SdtPago_Sgcitadisponibilidadfecha(struct.getSgcitadisponibilidadfecha());
      setgxTv_SdtPago_Pagomonto(struct.getPagomonto());
      setgxTv_SdtPago_Pagotoken(struct.getPagotoken());
      setgxTv_SdtPago_Pagotipodocumentocliente(struct.getPagotipodocumentocliente());
      setgxTv_SdtPago_Pagoclientenrodocumento(struct.getPagoclientenrodocumento());
      setgxTv_SdtPago_Pagoclientedenominacion(struct.getPagoclientedenominacion());
      setgxTv_SdtPago_Pagoclientedireccion(struct.getPagoclientedireccion());
      setgxTv_SdtPago_Pagoclienteemail(struct.getPagoclienteemail());
      setgxTv_SdtPago_Pagotipodocumento(struct.getPagotipodocumento());
      setgxTv_SdtPago_Pagonumero(struct.getPagonumero());
      setgxTv_SdtPago_Pagofechaemision(struct.getPagofechaemision());
      setgxTv_SdtPago_Pagomoneda(struct.getPagomoneda());
      setgxTv_SdtPago_Pagonubefactrequest(struct.getPagonubefactrequest());
      setgxTv_SdtPago_Pagonubefactresponse(struct.getPagonubefactresponse());
      setgxTv_SdtPago_Pagorequest(struct.getPagorequest());
      setgxTv_SdtPago_Pagoresponse(struct.getPagoresponse());
      setgxTv_SdtPago_Pagopasarelaid(struct.getPagopasarelaid());
      setgxTv_SdtPago_Pagostatuscode(struct.getPagostatuscode());
      setgxTv_SdtPago_Disponibilidadid(struct.getDisponibilidadid());
      setgxTv_SdtPago_Pagoenlacepdf(struct.getPagoenlacepdf());
      setgxTv_SdtPago_Pagoenlacexml(struct.getPagoenlacexml());
      setgxTv_SdtPago_Pagoestador(struct.getPagoestador());
      setgxTv_SdtPago_Mode(struct.getMode());
      setgxTv_SdtPago_Initialized(struct.getInitialized());
      setgxTv_SdtPago_Pagoid_Z(struct.getPagoid_Z());
      setgxTv_SdtPago_Citaid_Z(struct.getCitaid_Z());
      setgxTv_SdtPago_Citacode_Z(struct.getCitacode_Z());
      setgxTv_SdtPago_Sgcitadisponibilidadfecha_Z(struct.getSgcitadisponibilidadfecha_Z());
      setgxTv_SdtPago_Pagomonto_Z(struct.getPagomonto_Z());
      setgxTv_SdtPago_Pagotoken_Z(struct.getPagotoken_Z());
      setgxTv_SdtPago_Pagotipodocumentocliente_Z(struct.getPagotipodocumentocliente_Z());
      setgxTv_SdtPago_Pagoclientenrodocumento_Z(struct.getPagoclientenrodocumento_Z());
      setgxTv_SdtPago_Pagoclientedenominacion_Z(struct.getPagoclientedenominacion_Z());
      setgxTv_SdtPago_Pagoclientedireccion_Z(struct.getPagoclientedireccion_Z());
      setgxTv_SdtPago_Pagoclienteemail_Z(struct.getPagoclienteemail_Z());
      setgxTv_SdtPago_Pagotipodocumento_Z(struct.getPagotipodocumento_Z());
      setgxTv_SdtPago_Pagonumero_Z(struct.getPagonumero_Z());
      setgxTv_SdtPago_Pagofechaemision_Z(struct.getPagofechaemision_Z());
      setgxTv_SdtPago_Pagomoneda_Z(struct.getPagomoneda_Z());
      setgxTv_SdtPago_Pagopasarelaid_Z(struct.getPagopasarelaid_Z());
      setgxTv_SdtPago_Pagostatuscode_Z(struct.getPagostatuscode_Z());
      setgxTv_SdtPago_Disponibilidadid_Z(struct.getDisponibilidadid_Z());
      setgxTv_SdtPago_Pagoenlacepdf_Z(struct.getPagoenlacepdf_Z());
      setgxTv_SdtPago_Pagoenlacexml_Z(struct.getPagoenlacexml_Z());
      setgxTv_SdtPago_Pagoestador_Z(struct.getPagoestador_Z());
      setgxTv_SdtPago_Citaid_N(struct.getCitaid_N());
      setgxTv_SdtPago_Sgcitadisponibilidadfecha_N(struct.getSgcitadisponibilidadfecha_N());
      setgxTv_SdtPago_Disponibilidadid_N(struct.getDisponibilidadid_N());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtPago getStruct( )
   {
      com.projectthani.StructSdtPago struct = new com.projectthani.StructSdtPago ();
      struct.setPagoid(getgxTv_SdtPago_Pagoid());
      struct.setCitaid(getgxTv_SdtPago_Citaid());
      struct.setCitacode(getgxTv_SdtPago_Citacode());
      struct.setSgcitadisponibilidadfecha(getgxTv_SdtPago_Sgcitadisponibilidadfecha());
      struct.setPagomonto(getgxTv_SdtPago_Pagomonto());
      struct.setPagotoken(getgxTv_SdtPago_Pagotoken());
      struct.setPagotipodocumentocliente(getgxTv_SdtPago_Pagotipodocumentocliente());
      struct.setPagoclientenrodocumento(getgxTv_SdtPago_Pagoclientenrodocumento());
      struct.setPagoclientedenominacion(getgxTv_SdtPago_Pagoclientedenominacion());
      struct.setPagoclientedireccion(getgxTv_SdtPago_Pagoclientedireccion());
      struct.setPagoclienteemail(getgxTv_SdtPago_Pagoclienteemail());
      struct.setPagotipodocumento(getgxTv_SdtPago_Pagotipodocumento());
      struct.setPagonumero(getgxTv_SdtPago_Pagonumero());
      struct.setPagofechaemision(getgxTv_SdtPago_Pagofechaemision());
      struct.setPagomoneda(getgxTv_SdtPago_Pagomoneda());
      struct.setPagonubefactrequest(getgxTv_SdtPago_Pagonubefactrequest());
      struct.setPagonubefactresponse(getgxTv_SdtPago_Pagonubefactresponse());
      struct.setPagorequest(getgxTv_SdtPago_Pagorequest());
      struct.setPagoresponse(getgxTv_SdtPago_Pagoresponse());
      struct.setPagopasarelaid(getgxTv_SdtPago_Pagopasarelaid());
      struct.setPagostatuscode(getgxTv_SdtPago_Pagostatuscode());
      struct.setDisponibilidadid(getgxTv_SdtPago_Disponibilidadid());
      struct.setPagoenlacepdf(getgxTv_SdtPago_Pagoenlacepdf());
      struct.setPagoenlacexml(getgxTv_SdtPago_Pagoenlacexml());
      struct.setPagoestador(getgxTv_SdtPago_Pagoestador());
      struct.setMode(getgxTv_SdtPago_Mode());
      struct.setInitialized(getgxTv_SdtPago_Initialized());
      struct.setPagoid_Z(getgxTv_SdtPago_Pagoid_Z());
      struct.setCitaid_Z(getgxTv_SdtPago_Citaid_Z());
      struct.setCitacode_Z(getgxTv_SdtPago_Citacode_Z());
      struct.setSgcitadisponibilidadfecha_Z(getgxTv_SdtPago_Sgcitadisponibilidadfecha_Z());
      struct.setPagomonto_Z(getgxTv_SdtPago_Pagomonto_Z());
      struct.setPagotoken_Z(getgxTv_SdtPago_Pagotoken_Z());
      struct.setPagotipodocumentocliente_Z(getgxTv_SdtPago_Pagotipodocumentocliente_Z());
      struct.setPagoclientenrodocumento_Z(getgxTv_SdtPago_Pagoclientenrodocumento_Z());
      struct.setPagoclientedenominacion_Z(getgxTv_SdtPago_Pagoclientedenominacion_Z());
      struct.setPagoclientedireccion_Z(getgxTv_SdtPago_Pagoclientedireccion_Z());
      struct.setPagoclienteemail_Z(getgxTv_SdtPago_Pagoclienteemail_Z());
      struct.setPagotipodocumento_Z(getgxTv_SdtPago_Pagotipodocumento_Z());
      struct.setPagonumero_Z(getgxTv_SdtPago_Pagonumero_Z());
      struct.setPagofechaemision_Z(getgxTv_SdtPago_Pagofechaemision_Z());
      struct.setPagomoneda_Z(getgxTv_SdtPago_Pagomoneda_Z());
      struct.setPagopasarelaid_Z(getgxTv_SdtPago_Pagopasarelaid_Z());
      struct.setPagostatuscode_Z(getgxTv_SdtPago_Pagostatuscode_Z());
      struct.setDisponibilidadid_Z(getgxTv_SdtPago_Disponibilidadid_Z());
      struct.setPagoenlacepdf_Z(getgxTv_SdtPago_Pagoenlacepdf_Z());
      struct.setPagoenlacexml_Z(getgxTv_SdtPago_Pagoenlacexml_Z());
      struct.setPagoestador_Z(getgxTv_SdtPago_Pagoestador_Z());
      struct.setCitaid_N(getgxTv_SdtPago_Citaid_N());
      struct.setSgcitadisponibilidadfecha_N(getgxTv_SdtPago_Sgcitadisponibilidadfecha_N());
      struct.setDisponibilidadid_N(getgxTv_SdtPago_Disponibilidadid_N());
      return struct ;
   }

   private byte gxTv_SdtPago_N ;
   private byte gxTv_SdtPago_Citaid_N ;
   private byte gxTv_SdtPago_Sgcitadisponibilidadfecha_N ;
   private byte gxTv_SdtPago_Disponibilidadid_N ;
   private short gxTv_SdtPago_Pagotipodocumento ;
   private short gxTv_SdtPago_Pagomoneda ;
   private short gxTv_SdtPago_Initialized ;
   private short gxTv_SdtPago_Pagotipodocumento_Z ;
   private short gxTv_SdtPago_Pagomoneda_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtPago_Pagoid ;
   private int gxTv_SdtPago_Citaid ;
   private int gxTv_SdtPago_Pagonumero ;
   private int gxTv_SdtPago_Pagostatuscode ;
   private int gxTv_SdtPago_Disponibilidadid ;
   private int gxTv_SdtPago_Pagoid_Z ;
   private int gxTv_SdtPago_Citaid_Z ;
   private int gxTv_SdtPago_Pagonumero_Z ;
   private int gxTv_SdtPago_Pagostatuscode_Z ;
   private int gxTv_SdtPago_Disponibilidadid_Z ;
   private java.math.BigDecimal gxTv_SdtPago_Pagomonto ;
   private java.math.BigDecimal gxTv_SdtPago_Pagomonto_Z ;
   private String gxTv_SdtPago_Pagotipodocumentocliente ;
   private String gxTv_SdtPago_Pagoestador ;
   private String gxTv_SdtPago_Mode ;
   private String gxTv_SdtPago_Pagotipodocumentocliente_Z ;
   private String gxTv_SdtPago_Pagoestador_Z ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_SdtPago_Sgcitadisponibilidadfecha ;
   private java.util.Date gxTv_SdtPago_Pagofechaemision ;
   private java.util.Date gxTv_SdtPago_Sgcitadisponibilidadfecha_Z ;
   private java.util.Date gxTv_SdtPago_Pagofechaemision_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtPago_Pagonubefactrequest ;
   private String gxTv_SdtPago_Pagonubefactresponse ;
   private String gxTv_SdtPago_Pagorequest ;
   private String gxTv_SdtPago_Pagoresponse ;
   private String gxTv_SdtPago_Citacode ;
   private String gxTv_SdtPago_Pagotoken ;
   private String gxTv_SdtPago_Pagoclientenrodocumento ;
   private String gxTv_SdtPago_Pagoclientedenominacion ;
   private String gxTv_SdtPago_Pagoclientedireccion ;
   private String gxTv_SdtPago_Pagoclienteemail ;
   private String gxTv_SdtPago_Pagopasarelaid ;
   private String gxTv_SdtPago_Pagoenlacepdf ;
   private String gxTv_SdtPago_Pagoenlacexml ;
   private String gxTv_SdtPago_Citacode_Z ;
   private String gxTv_SdtPago_Pagotoken_Z ;
   private String gxTv_SdtPago_Pagoclientenrodocumento_Z ;
   private String gxTv_SdtPago_Pagoclientedenominacion_Z ;
   private String gxTv_SdtPago_Pagoclientedireccion_Z ;
   private String gxTv_SdtPago_Pagoclienteemail_Z ;
   private String gxTv_SdtPago_Pagopasarelaid_Z ;
   private String gxTv_SdtPago_Pagoenlacepdf_Z ;
   private String gxTv_SdtPago_Pagoenlacexml_Z ;
}

