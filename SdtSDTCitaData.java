package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTCitaData extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTCitaData( )
   {
      this(  new ModelContext(SdtSDTCitaData.class));
   }

   public SdtSDTCitaData( ModelContext context )
   {
      super( context, "SdtSDTCitaData");
   }

   public SdtSDTCitaData( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTCitaData");
   }

   public SdtSDTCitaData( StructSdtSDTCitaData struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaId") )
            {
               gxTv_SdtSDTCitaData_Citaid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaCode") )
            {
               gxTv_SdtSDTCitaData_Citacode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteId") )
            {
               gxTv_SdtSDTCitaData_Pacienteid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteApellidoPaterno") )
            {
               gxTv_SdtSDTCitaData_Pacienteapellidopaterno = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteApellidoMaterno") )
            {
               gxTv_SdtSDTCitaData_Pacienteapellidomaterno = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteNombres") )
            {
               gxTv_SdtSDTCitaData_Pacientenombres = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteNroDocumento") )
            {
               gxTv_SdtSDTCitaData_Pacientenrodocumento = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DiagnosticoId") )
            {
               gxTv_SdtSDTCitaData_Diagnosticoid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DiagnosticoCodigo") )
            {
               gxTv_SdtSDTCitaData_Diagnosticocodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DiagnosticoDescripcion") )
            {
               gxTv_SdtSDTCitaData_Diagnosticodescripcion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaTipoDiagnostico") )
            {
               gxTv_SdtSDTCitaData_Citatipodiagnostico = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadId") )
            {
               gxTv_SdtSDTCitaData_Sgcitadisponibilidadid = (int)(getnumericvalue(oReader.getValue())) ;
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
                  gxTv_SdtSDTCitaData_Sgcitadisponibilidadfecha = GXutil.nullDate() ;
                  gxTv_SdtSDTCitaData_Sgcitadisponibilidadfecha_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtSDTCitaData_Sgcitadisponibilidadfecha_N = (byte)(0) ;
                  gxTv_SdtSDTCitaData_Sgcitadisponibilidadfecha = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadHoraInicio") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorainicio = GXutil.resetTime( GXutil.nullDate() );
                  gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorainicio_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorainicio_N = (byte)(0) ;
                  gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorainicio = GXutil.resetDate(localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadHoraFin") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorafin = GXutil.resetTime( GXutil.nullDate() );
                  gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorafin_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorafin_N = (byte)(0) ;
                  gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorafin = GXutil.resetDate(localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadEspecialidadId") )
            {
               gxTv_SdtSDTCitaData_Sgcitadisponibilidadespecialidadid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadEspecialidadNombre") )
            {
               gxTv_SdtSDTCitaData_Sgcitadisponibilidadespecialidadnombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadSedeId") )
            {
               gxTv_SdtSDTCitaData_Sgcitadisponibilidadsedeid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadSedeNombre") )
            {
               gxTv_SdtSDTCitaData_Sgcitadisponibilidadsedenombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadClinicaId") )
            {
               gxTv_SdtSDTCitaData_Sgcitadisponibilidadclinicaid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadClinicaNombre") )
            {
               gxTv_SdtSDTCitaData_Sgcitadisponibilidadclinicanombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadProfesionalId") )
            {
               gxTv_SdtSDTCitaData_Sgcitadisponibilidadprofesionalid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadProFullName") )
            {
               gxTv_SdtSDTCitaData_Sgcitadisponibilidadprofullname = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadProCOP") )
            {
               gxTv_SdtSDTCitaData_Sgcitadisponibilidadprocop = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaEstadoCita") )
            {
               gxTv_SdtSDTCitaData_Citaestadocita = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaInforme") )
            {
               gxTv_SdtSDTCitaData_Citainforme = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaAntecedentes") )
            {
               gxTv_SdtSDTCitaData_Citaantecedentes = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaLink") )
            {
               gxTv_SdtSDTCitaData_Citalink = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaFechaReserva") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtSDTCitaData_Citafechareserva = GXutil.resetTime( GXutil.nullDate() );
                  gxTv_SdtSDTCitaData_Citafechareserva_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtSDTCitaData_Citafechareserva_N = (byte)(0) ;
                  gxTv_SdtSDTCitaData_Citafechareserva = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaLog") )
            {
               gxTv_SdtSDTCitaData_Citalog = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaEmailGenLink") )
            {
               gxTv_SdtSDTCitaData_Citaemailgenlink = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaEstado") )
            {
               gxTv_SdtSDTCitaData_Citaestado = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaMotivoConsulta") )
            {
               gxTv_SdtSDTCitaData_Citamotivoconsulta = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaArchivoNombre") )
            {
               gxTv_SdtSDTCitaData_Citaarchivonombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaArchivo") )
            {
               gxTv_SdtSDTCitaData_Citaarchivo=GXutil.blobFromBase64( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaConsentimiento") )
            {
               gxTv_SdtSDTCitaData_Citaconsentimiento = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaGestante") )
            {
               gxTv_SdtSDTCitaData_Citagestante = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaEstadoPago") )
            {
               gxTv_SdtSDTCitaData_Citaestadopago = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaPeso") )
            {
               gxTv_SdtSDTCitaData_Citapeso = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaEstatura") )
            {
               gxTv_SdtSDTCitaData_Citaestatura = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaPesoDescripcion") )
            {
               gxTv_SdtSDTCitaData_Citapesodescripcion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaEstaturaDescripcion") )
            {
               gxTv_SdtSDTCitaData_Citaestaturadescripcion = oReader.getValue() ;
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
         sName = "SDTCitaData" ;
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
      oWriter.writeElement("CitaId", GXutil.trim( GXutil.str( gxTv_SdtSDTCitaData_Citaid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaCode", GXutil.rtrim( gxTv_SdtSDTCitaData_Citacode));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteId", GXutil.trim( GXutil.str( gxTv_SdtSDTCitaData_Pacienteid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteApellidoPaterno", GXutil.rtrim( gxTv_SdtSDTCitaData_Pacienteapellidopaterno));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteApellidoMaterno", GXutil.rtrim( gxTv_SdtSDTCitaData_Pacienteapellidomaterno));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteNombres", GXutil.rtrim( gxTv_SdtSDTCitaData_Pacientenombres));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteNroDocumento", GXutil.rtrim( gxTv_SdtSDTCitaData_Pacientenrodocumento));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("DiagnosticoId", GXutil.trim( GXutil.str( gxTv_SdtSDTCitaData_Diagnosticoid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("DiagnosticoCodigo", GXutil.rtrim( gxTv_SdtSDTCitaData_Diagnosticocodigo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("DiagnosticoDescripcion", GXutil.rtrim( gxTv_SdtSDTCitaData_Diagnosticodescripcion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaTipoDiagnostico", GXutil.rtrim( gxTv_SdtSDTCitaData_Citatipodiagnostico));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGCitaDisponibilidadId", GXutil.trim( GXutil.str( gxTv_SdtSDTCitaData_Sgcitadisponibilidadid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_SdtSDTCitaData_Sgcitadisponibilidadfecha)) && ( gxTv_SdtSDTCitaData_Sgcitadisponibilidadfecha_N == 1 ) )
      {
         oWriter.writeElement("SGCitaDisponibilidadFecha", "");
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTCitaData_Sgcitadisponibilidadfecha), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTCitaData_Sgcitadisponibilidadfecha), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTCitaData_Sgcitadisponibilidadfecha), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("SGCitaDisponibilidadFecha", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      if ( GXutil.dateCompare(GXutil.nullDate(), gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorainicio) && ( gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorainicio_N == 1 ) )
      {
         oWriter.writeElement("SGCitaDisponibilidadHoraInicio", "");
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorainicio), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorainicio), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorainicio), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorainicio), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorainicio), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorainicio), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("SGCitaDisponibilidadHoraInicio", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      if ( GXutil.dateCompare(GXutil.nullDate(), gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorafin) && ( gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorafin_N == 1 ) )
      {
         oWriter.writeElement("SGCitaDisponibilidadHoraFin", "");
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorafin), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorafin), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorafin), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorafin), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorafin), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorafin), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("SGCitaDisponibilidadHoraFin", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      oWriter.writeElement("SGCitaDisponibilidadEspecialidadId", GXutil.trim( GXutil.str( gxTv_SdtSDTCitaData_Sgcitadisponibilidadespecialidadid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGCitaDisponibilidadEspecialidadNombre", GXutil.rtrim( gxTv_SdtSDTCitaData_Sgcitadisponibilidadespecialidadnombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGCitaDisponibilidadSedeId", GXutil.trim( GXutil.str( gxTv_SdtSDTCitaData_Sgcitadisponibilidadsedeid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGCitaDisponibilidadSedeNombre", GXutil.rtrim( gxTv_SdtSDTCitaData_Sgcitadisponibilidadsedenombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGCitaDisponibilidadClinicaId", GXutil.trim( GXutil.str( gxTv_SdtSDTCitaData_Sgcitadisponibilidadclinicaid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGCitaDisponibilidadClinicaNombre", GXutil.rtrim( gxTv_SdtSDTCitaData_Sgcitadisponibilidadclinicanombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGCitaDisponibilidadProfesionalId", GXutil.trim( GXutil.str( gxTv_SdtSDTCitaData_Sgcitadisponibilidadprofesionalid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGCitaDisponibilidadProFullName", GXutil.rtrim( gxTv_SdtSDTCitaData_Sgcitadisponibilidadprofullname));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGCitaDisponibilidadProCOP", GXutil.rtrim( gxTv_SdtSDTCitaData_Sgcitadisponibilidadprocop));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaEstadoCita", GXutil.rtrim( gxTv_SdtSDTCitaData_Citaestadocita));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaInforme", GXutil.rtrim( gxTv_SdtSDTCitaData_Citainforme));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaAntecedentes", GXutil.rtrim( gxTv_SdtSDTCitaData_Citaantecedentes));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaLink", GXutil.rtrim( gxTv_SdtSDTCitaData_Citalink));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( GXutil.dateCompare(GXutil.nullDate(), gxTv_SdtSDTCitaData_Citafechareserva) && ( gxTv_SdtSDTCitaData_Citafechareserva_N == 1 ) )
      {
         oWriter.writeElement("CitaFechaReserva", "");
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTCitaData_Citafechareserva), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTCitaData_Citafechareserva), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTCitaData_Citafechareserva), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtSDTCitaData_Citafechareserva), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtSDTCitaData_Citafechareserva), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtSDTCitaData_Citafechareserva), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("CitaFechaReserva", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      oWriter.writeElement("CitaLog", GXutil.rtrim( gxTv_SdtSDTCitaData_Citalog));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaEmailGenLink", GXutil.rtrim( gxTv_SdtSDTCitaData_Citaemailgenlink));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaEstado", GXutil.rtrim( gxTv_SdtSDTCitaData_Citaestado));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaMotivoConsulta", GXutil.rtrim( gxTv_SdtSDTCitaData_Citamotivoconsulta));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaArchivoNombre", GXutil.rtrim( gxTv_SdtSDTCitaData_Citaarchivonombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaArchivo", GXutil.blobToBase64( gxTv_SdtSDTCitaData_Citaarchivo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaConsentimiento", GXutil.rtrim( GXutil.booltostr( gxTv_SdtSDTCitaData_Citaconsentimiento)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaGestante", GXutil.rtrim( GXutil.booltostr( gxTv_SdtSDTCitaData_Citagestante)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaEstadoPago", GXutil.rtrim( gxTv_SdtSDTCitaData_Citaestadopago));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaPeso", GXutil.trim( GXutil.strNoRound( gxTv_SdtSDTCitaData_Citapeso, 6, 2)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaEstatura", GXutil.trim( GXutil.strNoRound( gxTv_SdtSDTCitaData_Citaestatura, 4, 2)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaPesoDescripcion", GXutil.rtrim( gxTv_SdtSDTCitaData_Citapesodescripcion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaEstaturaDescripcion", GXutil.rtrim( gxTv_SdtSDTCitaData_Citaestaturadescripcion));
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
      AddObjectProperty("CitaId", gxTv_SdtSDTCitaData_Citaid, false, false);
      AddObjectProperty("CitaCode", gxTv_SdtSDTCitaData_Citacode, false, false);
      AddObjectProperty("PacienteId", gxTv_SdtSDTCitaData_Pacienteid, false, false);
      AddObjectProperty("PacienteApellidoPaterno", gxTv_SdtSDTCitaData_Pacienteapellidopaterno, false, false);
      AddObjectProperty("PacienteApellidoMaterno", gxTv_SdtSDTCitaData_Pacienteapellidomaterno, false, false);
      AddObjectProperty("PacienteNombres", gxTv_SdtSDTCitaData_Pacientenombres, false, false);
      AddObjectProperty("PacienteNroDocumento", gxTv_SdtSDTCitaData_Pacientenrodocumento, false, false);
      AddObjectProperty("DiagnosticoId", gxTv_SdtSDTCitaData_Diagnosticoid, false, false);
      AddObjectProperty("DiagnosticoCodigo", gxTv_SdtSDTCitaData_Diagnosticocodigo, false, false);
      AddObjectProperty("DiagnosticoDescripcion", gxTv_SdtSDTCitaData_Diagnosticodescripcion, false, false);
      AddObjectProperty("CitaTipoDiagnostico", gxTv_SdtSDTCitaData_Citatipodiagnostico, false, false);
      AddObjectProperty("SGCitaDisponibilidadId", gxTv_SdtSDTCitaData_Sgcitadisponibilidadid, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTCitaData_Sgcitadisponibilidadfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTCitaData_Sgcitadisponibilidadfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTCitaData_Sgcitadisponibilidadfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("SGCitaDisponibilidadFecha", sDateCnv, false, false);
      datetime_STZ = gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorainicio ;
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("SGCitaDisponibilidadHoraInicio", sDateCnv, false, false);
      datetime_STZ = gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorafin ;
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("SGCitaDisponibilidadHoraFin", sDateCnv, false, false);
      AddObjectProperty("SGCitaDisponibilidadEspecialidadId", gxTv_SdtSDTCitaData_Sgcitadisponibilidadespecialidadid, false, false);
      AddObjectProperty("SGCitaDisponibilidadEspecialidadNombre", gxTv_SdtSDTCitaData_Sgcitadisponibilidadespecialidadnombre, false, false);
      AddObjectProperty("SGCitaDisponibilidadSedeId", gxTv_SdtSDTCitaData_Sgcitadisponibilidadsedeid, false, false);
      AddObjectProperty("SGCitaDisponibilidadSedeNombre", gxTv_SdtSDTCitaData_Sgcitadisponibilidadsedenombre, false, false);
      AddObjectProperty("SGCitaDisponibilidadClinicaId", gxTv_SdtSDTCitaData_Sgcitadisponibilidadclinicaid, false, false);
      AddObjectProperty("SGCitaDisponibilidadClinicaNombre", gxTv_SdtSDTCitaData_Sgcitadisponibilidadclinicanombre, false, false);
      AddObjectProperty("SGCitaDisponibilidadProfesionalId", gxTv_SdtSDTCitaData_Sgcitadisponibilidadprofesionalid, false, false);
      AddObjectProperty("SGCitaDisponibilidadProFullName", gxTv_SdtSDTCitaData_Sgcitadisponibilidadprofullname, false, false);
      AddObjectProperty("SGCitaDisponibilidadProCOP", gxTv_SdtSDTCitaData_Sgcitadisponibilidadprocop, false, false);
      AddObjectProperty("CitaEstadoCita", gxTv_SdtSDTCitaData_Citaestadocita, false, false);
      AddObjectProperty("CitaInforme", gxTv_SdtSDTCitaData_Citainforme, false, false);
      AddObjectProperty("CitaAntecedentes", gxTv_SdtSDTCitaData_Citaantecedentes, false, false);
      AddObjectProperty("CitaLink", gxTv_SdtSDTCitaData_Citalink, false, false);
      datetime_STZ = gxTv_SdtSDTCitaData_Citafechareserva ;
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("CitaFechaReserva", sDateCnv, false, false);
      AddObjectProperty("CitaLog", gxTv_SdtSDTCitaData_Citalog, false, false);
      AddObjectProperty("CitaEmailGenLink", gxTv_SdtSDTCitaData_Citaemailgenlink, false, false);
      AddObjectProperty("CitaEstado", gxTv_SdtSDTCitaData_Citaestado, false, false);
      AddObjectProperty("CitaMotivoConsulta", gxTv_SdtSDTCitaData_Citamotivoconsulta, false, false);
      AddObjectProperty("CitaArchivoNombre", gxTv_SdtSDTCitaData_Citaarchivonombre, false, false);
      AddObjectProperty("CitaArchivo", gxTv_SdtSDTCitaData_Citaarchivo, false, false);
      AddObjectProperty("CitaConsentimiento", gxTv_SdtSDTCitaData_Citaconsentimiento, false, false);
      AddObjectProperty("CitaGestante", gxTv_SdtSDTCitaData_Citagestante, false, false);
      AddObjectProperty("CitaEstadoPago", gxTv_SdtSDTCitaData_Citaestadopago, false, false);
      AddObjectProperty("CitaPeso", gxTv_SdtSDTCitaData_Citapeso, false, false);
      AddObjectProperty("CitaEstatura", gxTv_SdtSDTCitaData_Citaestatura, false, false);
      AddObjectProperty("CitaPesoDescripcion", gxTv_SdtSDTCitaData_Citapesodescripcion, false, false);
      AddObjectProperty("CitaEstaturaDescripcion", gxTv_SdtSDTCitaData_Citaestaturadescripcion, false, false);
   }

   public int getgxTv_SdtSDTCitaData_Citaid( )
   {
      return gxTv_SdtSDTCitaData_Citaid ;
   }

   public void setgxTv_SdtSDTCitaData_Citaid( int value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Citaid = value ;
   }

   public String getgxTv_SdtSDTCitaData_Citacode( )
   {
      return gxTv_SdtSDTCitaData_Citacode ;
   }

   public void setgxTv_SdtSDTCitaData_Citacode( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Citacode = value ;
   }

   public int getgxTv_SdtSDTCitaData_Pacienteid( )
   {
      return gxTv_SdtSDTCitaData_Pacienteid ;
   }

   public void setgxTv_SdtSDTCitaData_Pacienteid( int value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Pacienteid = value ;
   }

   public String getgxTv_SdtSDTCitaData_Pacienteapellidopaterno( )
   {
      return gxTv_SdtSDTCitaData_Pacienteapellidopaterno ;
   }

   public void setgxTv_SdtSDTCitaData_Pacienteapellidopaterno( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Pacienteapellidopaterno = value ;
   }

   public String getgxTv_SdtSDTCitaData_Pacienteapellidomaterno( )
   {
      return gxTv_SdtSDTCitaData_Pacienteapellidomaterno ;
   }

   public void setgxTv_SdtSDTCitaData_Pacienteapellidomaterno( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Pacienteapellidomaterno = value ;
   }

   public String getgxTv_SdtSDTCitaData_Pacientenombres( )
   {
      return gxTv_SdtSDTCitaData_Pacientenombres ;
   }

   public void setgxTv_SdtSDTCitaData_Pacientenombres( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Pacientenombres = value ;
   }

   public String getgxTv_SdtSDTCitaData_Pacientenrodocumento( )
   {
      return gxTv_SdtSDTCitaData_Pacientenrodocumento ;
   }

   public void setgxTv_SdtSDTCitaData_Pacientenrodocumento( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Pacientenrodocumento = value ;
   }

   public int getgxTv_SdtSDTCitaData_Diagnosticoid( )
   {
      return gxTv_SdtSDTCitaData_Diagnosticoid ;
   }

   public void setgxTv_SdtSDTCitaData_Diagnosticoid( int value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Diagnosticoid = value ;
   }

   public String getgxTv_SdtSDTCitaData_Diagnosticocodigo( )
   {
      return gxTv_SdtSDTCitaData_Diagnosticocodigo ;
   }

   public void setgxTv_SdtSDTCitaData_Diagnosticocodigo( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Diagnosticocodigo = value ;
   }

   public String getgxTv_SdtSDTCitaData_Diagnosticodescripcion( )
   {
      return gxTv_SdtSDTCitaData_Diagnosticodescripcion ;
   }

   public void setgxTv_SdtSDTCitaData_Diagnosticodescripcion( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Diagnosticodescripcion = value ;
   }

   public String getgxTv_SdtSDTCitaData_Citatipodiagnostico( )
   {
      return gxTv_SdtSDTCitaData_Citatipodiagnostico ;
   }

   public void setgxTv_SdtSDTCitaData_Citatipodiagnostico( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Citatipodiagnostico = value ;
   }

   public int getgxTv_SdtSDTCitaData_Sgcitadisponibilidadid( )
   {
      return gxTv_SdtSDTCitaData_Sgcitadisponibilidadid ;
   }

   public void setgxTv_SdtSDTCitaData_Sgcitadisponibilidadid( int value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadid = value ;
   }

   public java.util.Date getgxTv_SdtSDTCitaData_Sgcitadisponibilidadfecha( )
   {
      return gxTv_SdtSDTCitaData_Sgcitadisponibilidadfecha ;
   }

   public void setgxTv_SdtSDTCitaData_Sgcitadisponibilidadfecha( java.util.Date value )
   {
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadfecha_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadfecha = value ;
   }

   public java.util.Date getgxTv_SdtSDTCitaData_Sgcitadisponibilidadhorainicio( )
   {
      return gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorainicio ;
   }

   public void setgxTv_SdtSDTCitaData_Sgcitadisponibilidadhorainicio( java.util.Date value )
   {
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorainicio_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorainicio = value ;
   }

   public java.util.Date getgxTv_SdtSDTCitaData_Sgcitadisponibilidadhorafin( )
   {
      return gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorafin ;
   }

   public void setgxTv_SdtSDTCitaData_Sgcitadisponibilidadhorafin( java.util.Date value )
   {
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorafin_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorafin = value ;
   }

   public short getgxTv_SdtSDTCitaData_Sgcitadisponibilidadespecialidadid( )
   {
      return gxTv_SdtSDTCitaData_Sgcitadisponibilidadespecialidadid ;
   }

   public void setgxTv_SdtSDTCitaData_Sgcitadisponibilidadespecialidadid( short value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadespecialidadid = value ;
   }

   public String getgxTv_SdtSDTCitaData_Sgcitadisponibilidadespecialidadnombre( )
   {
      return gxTv_SdtSDTCitaData_Sgcitadisponibilidadespecialidadnombre ;
   }

   public void setgxTv_SdtSDTCitaData_Sgcitadisponibilidadespecialidadnombre( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadespecialidadnombre = value ;
   }

   public short getgxTv_SdtSDTCitaData_Sgcitadisponibilidadsedeid( )
   {
      return gxTv_SdtSDTCitaData_Sgcitadisponibilidadsedeid ;
   }

   public void setgxTv_SdtSDTCitaData_Sgcitadisponibilidadsedeid( short value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadsedeid = value ;
   }

   public String getgxTv_SdtSDTCitaData_Sgcitadisponibilidadsedenombre( )
   {
      return gxTv_SdtSDTCitaData_Sgcitadisponibilidadsedenombre ;
   }

   public void setgxTv_SdtSDTCitaData_Sgcitadisponibilidadsedenombre( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadsedenombre = value ;
   }

   public short getgxTv_SdtSDTCitaData_Sgcitadisponibilidadclinicaid( )
   {
      return gxTv_SdtSDTCitaData_Sgcitadisponibilidadclinicaid ;
   }

   public void setgxTv_SdtSDTCitaData_Sgcitadisponibilidadclinicaid( short value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadclinicaid = value ;
   }

   public String getgxTv_SdtSDTCitaData_Sgcitadisponibilidadclinicanombre( )
   {
      return gxTv_SdtSDTCitaData_Sgcitadisponibilidadclinicanombre ;
   }

   public void setgxTv_SdtSDTCitaData_Sgcitadisponibilidadclinicanombre( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadclinicanombre = value ;
   }

   public int getgxTv_SdtSDTCitaData_Sgcitadisponibilidadprofesionalid( )
   {
      return gxTv_SdtSDTCitaData_Sgcitadisponibilidadprofesionalid ;
   }

   public void setgxTv_SdtSDTCitaData_Sgcitadisponibilidadprofesionalid( int value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadprofesionalid = value ;
   }

   public String getgxTv_SdtSDTCitaData_Sgcitadisponibilidadprofullname( )
   {
      return gxTv_SdtSDTCitaData_Sgcitadisponibilidadprofullname ;
   }

   public void setgxTv_SdtSDTCitaData_Sgcitadisponibilidadprofullname( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadprofullname = value ;
   }

   public String getgxTv_SdtSDTCitaData_Sgcitadisponibilidadprocop( )
   {
      return gxTv_SdtSDTCitaData_Sgcitadisponibilidadprocop ;
   }

   public void setgxTv_SdtSDTCitaData_Sgcitadisponibilidadprocop( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadprocop = value ;
   }

   public String getgxTv_SdtSDTCitaData_Citaestadocita( )
   {
      return gxTv_SdtSDTCitaData_Citaestadocita ;
   }

   public void setgxTv_SdtSDTCitaData_Citaestadocita( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Citaestadocita = value ;
   }

   public String getgxTv_SdtSDTCitaData_Citainforme( )
   {
      return gxTv_SdtSDTCitaData_Citainforme ;
   }

   public void setgxTv_SdtSDTCitaData_Citainforme( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Citainforme = value ;
   }

   public String getgxTv_SdtSDTCitaData_Citaantecedentes( )
   {
      return gxTv_SdtSDTCitaData_Citaantecedentes ;
   }

   public void setgxTv_SdtSDTCitaData_Citaantecedentes( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Citaantecedentes = value ;
   }

   public String getgxTv_SdtSDTCitaData_Citalink( )
   {
      return gxTv_SdtSDTCitaData_Citalink ;
   }

   public void setgxTv_SdtSDTCitaData_Citalink( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Citalink = value ;
   }

   public java.util.Date getgxTv_SdtSDTCitaData_Citafechareserva( )
   {
      return gxTv_SdtSDTCitaData_Citafechareserva ;
   }

   public void setgxTv_SdtSDTCitaData_Citafechareserva( java.util.Date value )
   {
      gxTv_SdtSDTCitaData_Citafechareserva_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Citafechareserva = value ;
   }

   public String getgxTv_SdtSDTCitaData_Citalog( )
   {
      return gxTv_SdtSDTCitaData_Citalog ;
   }

   public void setgxTv_SdtSDTCitaData_Citalog( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Citalog = value ;
   }

   public String getgxTv_SdtSDTCitaData_Citaemailgenlink( )
   {
      return gxTv_SdtSDTCitaData_Citaemailgenlink ;
   }

   public void setgxTv_SdtSDTCitaData_Citaemailgenlink( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Citaemailgenlink = value ;
   }

   public String getgxTv_SdtSDTCitaData_Citaestado( )
   {
      return gxTv_SdtSDTCitaData_Citaestado ;
   }

   public void setgxTv_SdtSDTCitaData_Citaestado( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Citaestado = value ;
   }

   public String getgxTv_SdtSDTCitaData_Citamotivoconsulta( )
   {
      return gxTv_SdtSDTCitaData_Citamotivoconsulta ;
   }

   public void setgxTv_SdtSDTCitaData_Citamotivoconsulta( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Citamotivoconsulta = value ;
   }

   public String getgxTv_SdtSDTCitaData_Citaarchivonombre( )
   {
      return gxTv_SdtSDTCitaData_Citaarchivonombre ;
   }

   public void setgxTv_SdtSDTCitaData_Citaarchivonombre( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Citaarchivonombre = value ;
   }

   @GxUpload
   public String getgxTv_SdtSDTCitaData_Citaarchivo( )
   {
      return gxTv_SdtSDTCitaData_Citaarchivo ;
   }

   public void setgxTv_SdtSDTCitaData_Citaarchivo( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Citaarchivo = value ;
   }

   public boolean getgxTv_SdtSDTCitaData_Citaconsentimiento( )
   {
      return gxTv_SdtSDTCitaData_Citaconsentimiento ;
   }

   public void setgxTv_SdtSDTCitaData_Citaconsentimiento( boolean value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Citaconsentimiento = value ;
   }

   public boolean getgxTv_SdtSDTCitaData_Citagestante( )
   {
      return gxTv_SdtSDTCitaData_Citagestante ;
   }

   public void setgxTv_SdtSDTCitaData_Citagestante( boolean value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Citagestante = value ;
   }

   public String getgxTv_SdtSDTCitaData_Citaestadopago( )
   {
      return gxTv_SdtSDTCitaData_Citaestadopago ;
   }

   public void setgxTv_SdtSDTCitaData_Citaestadopago( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Citaestadopago = value ;
   }

   public java.math.BigDecimal getgxTv_SdtSDTCitaData_Citapeso( )
   {
      return gxTv_SdtSDTCitaData_Citapeso ;
   }

   public void setgxTv_SdtSDTCitaData_Citapeso( java.math.BigDecimal value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Citapeso = value ;
   }

   public java.math.BigDecimal getgxTv_SdtSDTCitaData_Citaestatura( )
   {
      return gxTv_SdtSDTCitaData_Citaestatura ;
   }

   public void setgxTv_SdtSDTCitaData_Citaestatura( java.math.BigDecimal value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Citaestatura = value ;
   }

   public String getgxTv_SdtSDTCitaData_Citapesodescripcion( )
   {
      return gxTv_SdtSDTCitaData_Citapesodescripcion ;
   }

   public void setgxTv_SdtSDTCitaData_Citapesodescripcion( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Citapesodescripcion = value ;
   }

   public String getgxTv_SdtSDTCitaData_Citaestaturadescripcion( )
   {
      return gxTv_SdtSDTCitaData_Citaestaturadescripcion ;
   }

   public void setgxTv_SdtSDTCitaData_Citaestaturadescripcion( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Citaestaturadescripcion = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTCitaData_N = (byte)(1) ;
      gxTv_SdtSDTCitaData_Citacode = "" ;
      gxTv_SdtSDTCitaData_Pacienteapellidopaterno = "" ;
      gxTv_SdtSDTCitaData_Pacienteapellidomaterno = "" ;
      gxTv_SdtSDTCitaData_Pacientenombres = "" ;
      gxTv_SdtSDTCitaData_Pacientenrodocumento = "" ;
      gxTv_SdtSDTCitaData_Diagnosticocodigo = "" ;
      gxTv_SdtSDTCitaData_Diagnosticodescripcion = "" ;
      gxTv_SdtSDTCitaData_Citatipodiagnostico = "" ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadfecha = GXutil.nullDate() ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadfecha_N = (byte)(1) ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorainicio = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorainicio_N = (byte)(1) ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorafin = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorafin_N = (byte)(1) ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadespecialidadnombre = "" ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadsedenombre = "" ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadclinicanombre = "" ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadprofullname = "" ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadprocop = "" ;
      gxTv_SdtSDTCitaData_Citaestadocita = "" ;
      gxTv_SdtSDTCitaData_Citainforme = "" ;
      gxTv_SdtSDTCitaData_Citaantecedentes = "" ;
      gxTv_SdtSDTCitaData_Citalink = "" ;
      gxTv_SdtSDTCitaData_Citafechareserva = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtSDTCitaData_Citafechareserva_N = (byte)(1) ;
      gxTv_SdtSDTCitaData_Citalog = "" ;
      gxTv_SdtSDTCitaData_Citaemailgenlink = "" ;
      gxTv_SdtSDTCitaData_Citaestado = "" ;
      gxTv_SdtSDTCitaData_Citamotivoconsulta = "" ;
      gxTv_SdtSDTCitaData_Citaarchivonombre = "" ;
      gxTv_SdtSDTCitaData_Citaarchivo = "" ;
      gxTv_SdtSDTCitaData_Citaestadopago = "" ;
      gxTv_SdtSDTCitaData_Citapeso = DecimalUtil.ZERO ;
      gxTv_SdtSDTCitaData_Citaestatura = DecimalUtil.ZERO ;
      gxTv_SdtSDTCitaData_Citapesodescripcion = "" ;
      gxTv_SdtSDTCitaData_Citaestaturadescripcion = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
      datetime_STZ = GXutil.resetTime( GXutil.nullDate() );
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTCitaData_N ;
   }

   public com.projectthani.SdtSDTCitaData Clone( )
   {
      return (com.projectthani.SdtSDTCitaData)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTCitaData struct )
   {
      setgxTv_SdtSDTCitaData_Citaid(struct.getCitaid());
      setgxTv_SdtSDTCitaData_Citacode(struct.getCitacode());
      setgxTv_SdtSDTCitaData_Pacienteid(struct.getPacienteid());
      setgxTv_SdtSDTCitaData_Pacienteapellidopaterno(struct.getPacienteapellidopaterno());
      setgxTv_SdtSDTCitaData_Pacienteapellidomaterno(struct.getPacienteapellidomaterno());
      setgxTv_SdtSDTCitaData_Pacientenombres(struct.getPacientenombres());
      setgxTv_SdtSDTCitaData_Pacientenrodocumento(struct.getPacientenrodocumento());
      setgxTv_SdtSDTCitaData_Diagnosticoid(struct.getDiagnosticoid());
      setgxTv_SdtSDTCitaData_Diagnosticocodigo(struct.getDiagnosticocodigo());
      setgxTv_SdtSDTCitaData_Diagnosticodescripcion(struct.getDiagnosticodescripcion());
      setgxTv_SdtSDTCitaData_Citatipodiagnostico(struct.getCitatipodiagnostico());
      setgxTv_SdtSDTCitaData_Sgcitadisponibilidadid(struct.getSgcitadisponibilidadid());
      if ( struct.gxTv_SdtSDTCitaData_Sgcitadisponibilidadfecha_N == 0 )
      {
         setgxTv_SdtSDTCitaData_Sgcitadisponibilidadfecha(struct.getSgcitadisponibilidadfecha());
      }
      if ( struct.gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorainicio_N == 0 )
      {
         setgxTv_SdtSDTCitaData_Sgcitadisponibilidadhorainicio(struct.getSgcitadisponibilidadhorainicio());
      }
      if ( struct.gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorafin_N == 0 )
      {
         setgxTv_SdtSDTCitaData_Sgcitadisponibilidadhorafin(struct.getSgcitadisponibilidadhorafin());
      }
      setgxTv_SdtSDTCitaData_Sgcitadisponibilidadespecialidadid(struct.getSgcitadisponibilidadespecialidadid());
      setgxTv_SdtSDTCitaData_Sgcitadisponibilidadespecialidadnombre(struct.getSgcitadisponibilidadespecialidadnombre());
      setgxTv_SdtSDTCitaData_Sgcitadisponibilidadsedeid(struct.getSgcitadisponibilidadsedeid());
      setgxTv_SdtSDTCitaData_Sgcitadisponibilidadsedenombre(struct.getSgcitadisponibilidadsedenombre());
      setgxTv_SdtSDTCitaData_Sgcitadisponibilidadclinicaid(struct.getSgcitadisponibilidadclinicaid());
      setgxTv_SdtSDTCitaData_Sgcitadisponibilidadclinicanombre(struct.getSgcitadisponibilidadclinicanombre());
      setgxTv_SdtSDTCitaData_Sgcitadisponibilidadprofesionalid(struct.getSgcitadisponibilidadprofesionalid());
      setgxTv_SdtSDTCitaData_Sgcitadisponibilidadprofullname(struct.getSgcitadisponibilidadprofullname());
      setgxTv_SdtSDTCitaData_Sgcitadisponibilidadprocop(struct.getSgcitadisponibilidadprocop());
      setgxTv_SdtSDTCitaData_Citaestadocita(struct.getCitaestadocita());
      setgxTv_SdtSDTCitaData_Citainforme(struct.getCitainforme());
      setgxTv_SdtSDTCitaData_Citaantecedentes(struct.getCitaantecedentes());
      setgxTv_SdtSDTCitaData_Citalink(struct.getCitalink());
      if ( struct.gxTv_SdtSDTCitaData_Citafechareserva_N == 0 )
      {
         setgxTv_SdtSDTCitaData_Citafechareserva(struct.getCitafechareserva());
      }
      setgxTv_SdtSDTCitaData_Citalog(struct.getCitalog());
      setgxTv_SdtSDTCitaData_Citaemailgenlink(struct.getCitaemailgenlink());
      setgxTv_SdtSDTCitaData_Citaestado(struct.getCitaestado());
      setgxTv_SdtSDTCitaData_Citamotivoconsulta(struct.getCitamotivoconsulta());
      setgxTv_SdtSDTCitaData_Citaarchivonombre(struct.getCitaarchivonombre());
      setgxTv_SdtSDTCitaData_Citaarchivo(struct.getCitaarchivo());
      setgxTv_SdtSDTCitaData_Citaconsentimiento(struct.getCitaconsentimiento());
      setgxTv_SdtSDTCitaData_Citagestante(struct.getCitagestante());
      setgxTv_SdtSDTCitaData_Citaestadopago(struct.getCitaestadopago());
      setgxTv_SdtSDTCitaData_Citapeso(struct.getCitapeso());
      setgxTv_SdtSDTCitaData_Citaestatura(struct.getCitaestatura());
      setgxTv_SdtSDTCitaData_Citapesodescripcion(struct.getCitapesodescripcion());
      setgxTv_SdtSDTCitaData_Citaestaturadescripcion(struct.getCitaestaturadescripcion());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTCitaData getStruct( )
   {
      com.projectthani.StructSdtSDTCitaData struct = new com.projectthani.StructSdtSDTCitaData ();
      struct.setCitaid(getgxTv_SdtSDTCitaData_Citaid());
      struct.setCitacode(getgxTv_SdtSDTCitaData_Citacode());
      struct.setPacienteid(getgxTv_SdtSDTCitaData_Pacienteid());
      struct.setPacienteapellidopaterno(getgxTv_SdtSDTCitaData_Pacienteapellidopaterno());
      struct.setPacienteapellidomaterno(getgxTv_SdtSDTCitaData_Pacienteapellidomaterno());
      struct.setPacientenombres(getgxTv_SdtSDTCitaData_Pacientenombres());
      struct.setPacientenrodocumento(getgxTv_SdtSDTCitaData_Pacientenrodocumento());
      struct.setDiagnosticoid(getgxTv_SdtSDTCitaData_Diagnosticoid());
      struct.setDiagnosticocodigo(getgxTv_SdtSDTCitaData_Diagnosticocodigo());
      struct.setDiagnosticodescripcion(getgxTv_SdtSDTCitaData_Diagnosticodescripcion());
      struct.setCitatipodiagnostico(getgxTv_SdtSDTCitaData_Citatipodiagnostico());
      struct.setSgcitadisponibilidadid(getgxTv_SdtSDTCitaData_Sgcitadisponibilidadid());
      if ( gxTv_SdtSDTCitaData_Sgcitadisponibilidadfecha_N == 0 )
      {
         struct.setSgcitadisponibilidadfecha(getgxTv_SdtSDTCitaData_Sgcitadisponibilidadfecha());
      }
      if ( gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorainicio_N == 0 )
      {
         struct.setSgcitadisponibilidadhorainicio(getgxTv_SdtSDTCitaData_Sgcitadisponibilidadhorainicio());
      }
      if ( gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorafin_N == 0 )
      {
         struct.setSgcitadisponibilidadhorafin(getgxTv_SdtSDTCitaData_Sgcitadisponibilidadhorafin());
      }
      struct.setSgcitadisponibilidadespecialidadid(getgxTv_SdtSDTCitaData_Sgcitadisponibilidadespecialidadid());
      struct.setSgcitadisponibilidadespecialidadnombre(getgxTv_SdtSDTCitaData_Sgcitadisponibilidadespecialidadnombre());
      struct.setSgcitadisponibilidadsedeid(getgxTv_SdtSDTCitaData_Sgcitadisponibilidadsedeid());
      struct.setSgcitadisponibilidadsedenombre(getgxTv_SdtSDTCitaData_Sgcitadisponibilidadsedenombre());
      struct.setSgcitadisponibilidadclinicaid(getgxTv_SdtSDTCitaData_Sgcitadisponibilidadclinicaid());
      struct.setSgcitadisponibilidadclinicanombre(getgxTv_SdtSDTCitaData_Sgcitadisponibilidadclinicanombre());
      struct.setSgcitadisponibilidadprofesionalid(getgxTv_SdtSDTCitaData_Sgcitadisponibilidadprofesionalid());
      struct.setSgcitadisponibilidadprofullname(getgxTv_SdtSDTCitaData_Sgcitadisponibilidadprofullname());
      struct.setSgcitadisponibilidadprocop(getgxTv_SdtSDTCitaData_Sgcitadisponibilidadprocop());
      struct.setCitaestadocita(getgxTv_SdtSDTCitaData_Citaestadocita());
      struct.setCitainforme(getgxTv_SdtSDTCitaData_Citainforme());
      struct.setCitaantecedentes(getgxTv_SdtSDTCitaData_Citaantecedentes());
      struct.setCitalink(getgxTv_SdtSDTCitaData_Citalink());
      if ( gxTv_SdtSDTCitaData_Citafechareserva_N == 0 )
      {
         struct.setCitafechareserva(getgxTv_SdtSDTCitaData_Citafechareserva());
      }
      struct.setCitalog(getgxTv_SdtSDTCitaData_Citalog());
      struct.setCitaemailgenlink(getgxTv_SdtSDTCitaData_Citaemailgenlink());
      struct.setCitaestado(getgxTv_SdtSDTCitaData_Citaestado());
      struct.setCitamotivoconsulta(getgxTv_SdtSDTCitaData_Citamotivoconsulta());
      struct.setCitaarchivonombre(getgxTv_SdtSDTCitaData_Citaarchivonombre());
      struct.setCitaarchivo(getgxTv_SdtSDTCitaData_Citaarchivo());
      struct.setCitaconsentimiento(getgxTv_SdtSDTCitaData_Citaconsentimiento());
      struct.setCitagestante(getgxTv_SdtSDTCitaData_Citagestante());
      struct.setCitaestadopago(getgxTv_SdtSDTCitaData_Citaestadopago());
      struct.setCitapeso(getgxTv_SdtSDTCitaData_Citapeso());
      struct.setCitaestatura(getgxTv_SdtSDTCitaData_Citaestatura());
      struct.setCitapesodescripcion(getgxTv_SdtSDTCitaData_Citapesodescripcion());
      struct.setCitaestaturadescripcion(getgxTv_SdtSDTCitaData_Citaestaturadescripcion());
      return struct ;
   }

   protected byte gxTv_SdtSDTCitaData_N ;
   protected byte gxTv_SdtSDTCitaData_Sgcitadisponibilidadfecha_N ;
   protected byte gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorainicio_N ;
   protected byte gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorafin_N ;
   protected byte gxTv_SdtSDTCitaData_Citafechareserva_N ;
   protected short gxTv_SdtSDTCitaData_Sgcitadisponibilidadespecialidadid ;
   protected short gxTv_SdtSDTCitaData_Sgcitadisponibilidadsedeid ;
   protected short gxTv_SdtSDTCitaData_Sgcitadisponibilidadclinicaid ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_SdtSDTCitaData_Citaid ;
   protected int gxTv_SdtSDTCitaData_Pacienteid ;
   protected int gxTv_SdtSDTCitaData_Diagnosticoid ;
   protected int gxTv_SdtSDTCitaData_Sgcitadisponibilidadid ;
   protected int gxTv_SdtSDTCitaData_Sgcitadisponibilidadprofesionalid ;
   protected java.math.BigDecimal gxTv_SdtSDTCitaData_Citapeso ;
   protected java.math.BigDecimal gxTv_SdtSDTCitaData_Citaestatura ;
   protected String gxTv_SdtSDTCitaData_Citaestadocita ;
   protected String gxTv_SdtSDTCitaData_Citaestado ;
   protected String gxTv_SdtSDTCitaData_Citaestadopago ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorainicio ;
   protected java.util.Date gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorafin ;
   protected java.util.Date gxTv_SdtSDTCitaData_Citafechareserva ;
   protected java.util.Date datetime_STZ ;
   protected java.util.Date gxTv_SdtSDTCitaData_Sgcitadisponibilidadfecha ;
   protected boolean gxTv_SdtSDTCitaData_Citaconsentimiento ;
   protected boolean gxTv_SdtSDTCitaData_Citagestante ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTCitaData_Citainforme ;
   protected String gxTv_SdtSDTCitaData_Citaantecedentes ;
   protected String gxTv_SdtSDTCitaData_Citamotivoconsulta ;
   protected String gxTv_SdtSDTCitaData_Citaarchivo ;
   protected String gxTv_SdtSDTCitaData_Citacode ;
   protected String gxTv_SdtSDTCitaData_Pacienteapellidopaterno ;
   protected String gxTv_SdtSDTCitaData_Pacienteapellidomaterno ;
   protected String gxTv_SdtSDTCitaData_Pacientenombres ;
   protected String gxTv_SdtSDTCitaData_Pacientenrodocumento ;
   protected String gxTv_SdtSDTCitaData_Diagnosticocodigo ;
   protected String gxTv_SdtSDTCitaData_Diagnosticodescripcion ;
   protected String gxTv_SdtSDTCitaData_Citatipodiagnostico ;
   protected String gxTv_SdtSDTCitaData_Sgcitadisponibilidadespecialidadnombre ;
   protected String gxTv_SdtSDTCitaData_Sgcitadisponibilidadsedenombre ;
   protected String gxTv_SdtSDTCitaData_Sgcitadisponibilidadclinicanombre ;
   protected String gxTv_SdtSDTCitaData_Sgcitadisponibilidadprofullname ;
   protected String gxTv_SdtSDTCitaData_Sgcitadisponibilidadprocop ;
   protected String gxTv_SdtSDTCitaData_Citalink ;
   protected String gxTv_SdtSDTCitaData_Citalog ;
   protected String gxTv_SdtSDTCitaData_Citaemailgenlink ;
   protected String gxTv_SdtSDTCitaData_Citaarchivonombre ;
   protected String gxTv_SdtSDTCitaData_Citapesodescripcion ;
   protected String gxTv_SdtSDTCitaData_Citaestaturadescripcion ;
}

