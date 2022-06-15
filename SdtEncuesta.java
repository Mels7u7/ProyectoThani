package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtEncuesta extends GxSilentTrnSdt implements Cloneable, java.io.Serializable
{
   public SdtEncuesta( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtEncuesta.class));
   }

   public SdtEncuesta( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle, context, "SdtEncuesta");
      initialize( remoteHandle) ;
   }

   public SdtEncuesta( int remoteHandle ,
                       StructSdtEncuesta struct )
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

   public void Load( short AV37EncuestaId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Short.valueOf(AV37EncuestaId)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"EncuestaId", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Encuesta");
      metadata.set("BT", "Encuesta");
      metadata.set("PK", "[ \"EncuestaId\" ]");
      metadata.set("PKAssigned", "[ \"EncuestaId\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CitaId\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "EncuestaId") )
            {
               gxTv_SdtEncuesta_Encuestaid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaId") )
            {
               gxTv_SdtEncuesta_Citaid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadProfesionalId") )
            {
               gxTv_SdtEncuesta_Sgcitadisponibilidadprofesionalid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadProFullName") )
            {
               gxTv_SdtEncuesta_Sgcitadisponibilidadprofullname = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadEspecialidadId") )
            {
               gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadEspecialidadNombre") )
            {
               gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadnombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadId") )
            {
               gxTv_SdtEncuesta_Sgcitadisponibilidadid = (int)(getnumericvalue(oReader.getValue())) ;
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
                  gxTv_SdtEncuesta_Sgcitadisponibilidadfecha = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtEncuesta_Sgcitadisponibilidadfecha = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteId") )
            {
               gxTv_SdtEncuesta_Pacienteid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteApellidoPaterno") )
            {
               gxTv_SdtEncuesta_Pacienteapellidopaterno = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteApellidoMaterno") )
            {
               gxTv_SdtEncuesta_Pacienteapellidomaterno = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteNombres") )
            {
               gxTv_SdtEncuesta_Pacientenombres = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadClinicaId") )
            {
               gxTv_SdtEncuesta_Sgcitadisponibilidadclinicaid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadClinicaNombre") )
            {
               gxTv_SdtEncuesta_Sgcitadisponibilidadclinicanombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EncuestaAtencion") )
            {
               gxTv_SdtEncuesta_Encuestaatencion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EncuestaAtendido") )
            {
               gxTv_SdtEncuesta_Encuestaatendido = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EncuestaHoraAtencion") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtEncuesta_Encuestahoraatencion = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtEncuesta_Encuestahoraatencion = GXutil.resetDate(localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EncuestaComentarios") )
            {
               gxTv_SdtEncuesta_Encuestacomentarios = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EncuestaRecomendacion") )
            {
               gxTv_SdtEncuesta_Encuestarecomendacion = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EncuestaEstado") )
            {
               gxTv_SdtEncuesta_Encuestaestado = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtEncuesta_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtEncuesta_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EncuestaId_Z") )
            {
               gxTv_SdtEncuesta_Encuestaid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaId_Z") )
            {
               gxTv_SdtEncuesta_Citaid_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadProfesionalId_Z") )
            {
               gxTv_SdtEncuesta_Sgcitadisponibilidadprofesionalid_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadProFullName_Z") )
            {
               gxTv_SdtEncuesta_Sgcitadisponibilidadprofullname_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadEspecialidadId_Z") )
            {
               gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadEspecialidadNombre_Z") )
            {
               gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadnombre_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadId_Z") )
            {
               gxTv_SdtEncuesta_Sgcitadisponibilidadid_Z = (int)(getnumericvalue(oReader.getValue())) ;
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
                  gxTv_SdtEncuesta_Sgcitadisponibilidadfecha_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtEncuesta_Sgcitadisponibilidadfecha_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteId_Z") )
            {
               gxTv_SdtEncuesta_Pacienteid_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteApellidoPaterno_Z") )
            {
               gxTv_SdtEncuesta_Pacienteapellidopaterno_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteApellidoMaterno_Z") )
            {
               gxTv_SdtEncuesta_Pacienteapellidomaterno_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteNombres_Z") )
            {
               gxTv_SdtEncuesta_Pacientenombres_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadClinicaId_Z") )
            {
               gxTv_SdtEncuesta_Sgcitadisponibilidadclinicaid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadClinicaNombre_Z") )
            {
               gxTv_SdtEncuesta_Sgcitadisponibilidadclinicanombre_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EncuestaAtencion_Z") )
            {
               gxTv_SdtEncuesta_Encuestaatencion_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EncuestaAtendido_Z") )
            {
               gxTv_SdtEncuesta_Encuestaatendido_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EncuestaHoraAtencion_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtEncuesta_Encuestahoraatencion_Z = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtEncuesta_Encuestahoraatencion_Z = GXutil.resetDate(localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EncuestaRecomendacion_Z") )
            {
               gxTv_SdtEncuesta_Encuestarecomendacion_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EncuestaEstado_Z") )
            {
               gxTv_SdtEncuesta_Encuestaestado_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadFecha_N") )
            {
               gxTv_SdtEncuesta_Sgcitadisponibilidadfecha_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EncuestaAtencion_N") )
            {
               gxTv_SdtEncuesta_Encuestaatencion_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EncuestaAtendido_N") )
            {
               gxTv_SdtEncuesta_Encuestaatendido_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EncuestaHoraAtencion_N") )
            {
               gxTv_SdtEncuesta_Encuestahoraatencion_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EncuestaComentarios_N") )
            {
               gxTv_SdtEncuesta_Encuestacomentarios_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EncuestaEstado_N") )
            {
               gxTv_SdtEncuesta_Encuestaestado_N = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "Encuesta" ;
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
      oWriter.writeElement("EncuestaId", GXutil.trim( GXutil.str( gxTv_SdtEncuesta_Encuestaid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaId", GXutil.trim( GXutil.str( gxTv_SdtEncuesta_Citaid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGCitaDisponibilidadProfesionalId", GXutil.trim( GXutil.str( gxTv_SdtEncuesta_Sgcitadisponibilidadprofesionalid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGCitaDisponibilidadProFullName", GXutil.rtrim( gxTv_SdtEncuesta_Sgcitadisponibilidadprofullname));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGCitaDisponibilidadEspecialidadId", GXutil.trim( GXutil.str( gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGCitaDisponibilidadEspecialidadNombre", GXutil.rtrim( gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadnombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGCitaDisponibilidadId", GXutil.trim( GXutil.str( gxTv_SdtEncuesta_Sgcitadisponibilidadid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtEncuesta_Sgcitadisponibilidadfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtEncuesta_Sgcitadisponibilidadfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtEncuesta_Sgcitadisponibilidadfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("SGCitaDisponibilidadFecha", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteId", GXutil.trim( GXutil.str( gxTv_SdtEncuesta_Pacienteid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteApellidoPaterno", GXutil.rtrim( gxTv_SdtEncuesta_Pacienteapellidopaterno));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteApellidoMaterno", GXutil.rtrim( gxTv_SdtEncuesta_Pacienteapellidomaterno));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteNombres", GXutil.rtrim( gxTv_SdtEncuesta_Pacientenombres));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGCitaDisponibilidadClinicaId", GXutil.trim( GXutil.str( gxTv_SdtEncuesta_Sgcitadisponibilidadclinicaid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGCitaDisponibilidadClinicaNombre", GXutil.rtrim( gxTv_SdtEncuesta_Sgcitadisponibilidadclinicanombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("EncuestaAtencion", GXutil.rtrim( gxTv_SdtEncuesta_Encuestaatencion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("EncuestaAtendido", GXutil.rtrim( gxTv_SdtEncuesta_Encuestaatendido));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtEncuesta_Encuestahoraatencion), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtEncuesta_Encuestahoraatencion), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtEncuesta_Encuestahoraatencion), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtEncuesta_Encuestahoraatencion), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtEncuesta_Encuestahoraatencion), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtEncuesta_Encuestahoraatencion), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("EncuestaHoraAtencion", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("EncuestaComentarios", GXutil.rtrim( gxTv_SdtEncuesta_Encuestacomentarios));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("EncuestaRecomendacion", GXutil.trim( GXutil.str( gxTv_SdtEncuesta_Encuestarecomendacion, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("EncuestaEstado", GXutil.rtrim( gxTv_SdtEncuesta_Encuestaestado));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", GXutil.rtrim( gxTv_SdtEncuesta_Mode));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtEncuesta_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("EncuestaId_Z", GXutil.trim( GXutil.str( gxTv_SdtEncuesta_Encuestaid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaId_Z", GXutil.trim( GXutil.str( gxTv_SdtEncuesta_Citaid_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SGCitaDisponibilidadProfesionalId_Z", GXutil.trim( GXutil.str( gxTv_SdtEncuesta_Sgcitadisponibilidadprofesionalid_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SGCitaDisponibilidadProFullName_Z", GXutil.rtrim( gxTv_SdtEncuesta_Sgcitadisponibilidadprofullname_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SGCitaDisponibilidadEspecialidadId_Z", GXutil.trim( GXutil.str( gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SGCitaDisponibilidadEspecialidadNombre_Z", GXutil.rtrim( gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadnombre_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SGCitaDisponibilidadId_Z", GXutil.trim( GXutil.str( gxTv_SdtEncuesta_Sgcitadisponibilidadid_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtEncuesta_Sgcitadisponibilidadfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtEncuesta_Sgcitadisponibilidadfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtEncuesta_Sgcitadisponibilidadfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("SGCitaDisponibilidadFecha_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PacienteId_Z", GXutil.trim( GXutil.str( gxTv_SdtEncuesta_Pacienteid_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PacienteApellidoPaterno_Z", GXutil.rtrim( gxTv_SdtEncuesta_Pacienteapellidopaterno_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PacienteApellidoMaterno_Z", GXutil.rtrim( gxTv_SdtEncuesta_Pacienteapellidomaterno_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PacienteNombres_Z", GXutil.rtrim( gxTv_SdtEncuesta_Pacientenombres_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SGCitaDisponibilidadClinicaId_Z", GXutil.trim( GXutil.str( gxTv_SdtEncuesta_Sgcitadisponibilidadclinicaid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SGCitaDisponibilidadClinicaNombre_Z", GXutil.rtrim( gxTv_SdtEncuesta_Sgcitadisponibilidadclinicanombre_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("EncuestaAtencion_Z", GXutil.rtrim( gxTv_SdtEncuesta_Encuestaatencion_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("EncuestaAtendido_Z", GXutil.rtrim( gxTv_SdtEncuesta_Encuestaatendido_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtEncuesta_Encuestahoraatencion_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtEncuesta_Encuestahoraatencion_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtEncuesta_Encuestahoraatencion_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtEncuesta_Encuestahoraatencion_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtEncuesta_Encuestahoraatencion_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtEncuesta_Encuestahoraatencion_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("EncuestaHoraAtencion_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("EncuestaRecomendacion_Z", GXutil.trim( GXutil.str( gxTv_SdtEncuesta_Encuestarecomendacion_Z, 2, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("EncuestaEstado_Z", GXutil.rtrim( gxTv_SdtEncuesta_Encuestaestado_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SGCitaDisponibilidadFecha_N", GXutil.trim( GXutil.str( gxTv_SdtEncuesta_Sgcitadisponibilidadfecha_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("EncuestaAtencion_N", GXutil.trim( GXutil.str( gxTv_SdtEncuesta_Encuestaatencion_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("EncuestaAtendido_N", GXutil.trim( GXutil.str( gxTv_SdtEncuesta_Encuestaatendido_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("EncuestaHoraAtencion_N", GXutil.trim( GXutil.str( gxTv_SdtEncuesta_Encuestahoraatencion_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("EncuestaComentarios_N", GXutil.trim( GXutil.str( gxTv_SdtEncuesta_Encuestacomentarios_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("EncuestaEstado_N", GXutil.trim( GXutil.str( gxTv_SdtEncuesta_Encuestaestado_N, 1, 0)));
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
      AddObjectProperty("EncuestaId", gxTv_SdtEncuesta_Encuestaid, false, includeNonInitialized);
      AddObjectProperty("CitaId", gxTv_SdtEncuesta_Citaid, false, includeNonInitialized);
      AddObjectProperty("SGCitaDisponibilidadProfesionalId", gxTv_SdtEncuesta_Sgcitadisponibilidadprofesionalid, false, includeNonInitialized);
      AddObjectProperty("SGCitaDisponibilidadProFullName", gxTv_SdtEncuesta_Sgcitadisponibilidadprofullname, false, includeNonInitialized);
      AddObjectProperty("SGCitaDisponibilidadEspecialidadId", gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadid, false, includeNonInitialized);
      AddObjectProperty("SGCitaDisponibilidadEspecialidadNombre", gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadnombre, false, includeNonInitialized);
      AddObjectProperty("SGCitaDisponibilidadId", gxTv_SdtEncuesta_Sgcitadisponibilidadid, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtEncuesta_Sgcitadisponibilidadfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtEncuesta_Sgcitadisponibilidadfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtEncuesta_Sgcitadisponibilidadfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("SGCitaDisponibilidadFecha", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("SGCitaDisponibilidadFecha_N", gxTv_SdtEncuesta_Sgcitadisponibilidadfecha_N, false, includeNonInitialized);
      AddObjectProperty("PacienteId", gxTv_SdtEncuesta_Pacienteid, false, includeNonInitialized);
      AddObjectProperty("PacienteApellidoPaterno", gxTv_SdtEncuesta_Pacienteapellidopaterno, false, includeNonInitialized);
      AddObjectProperty("PacienteApellidoMaterno", gxTv_SdtEncuesta_Pacienteapellidomaterno, false, includeNonInitialized);
      AddObjectProperty("PacienteNombres", gxTv_SdtEncuesta_Pacientenombres, false, includeNonInitialized);
      AddObjectProperty("SGCitaDisponibilidadClinicaId", gxTv_SdtEncuesta_Sgcitadisponibilidadclinicaid, false, includeNonInitialized);
      AddObjectProperty("SGCitaDisponibilidadClinicaNombre", gxTv_SdtEncuesta_Sgcitadisponibilidadclinicanombre, false, includeNonInitialized);
      AddObjectProperty("EncuestaAtencion", gxTv_SdtEncuesta_Encuestaatencion, false, includeNonInitialized);
      AddObjectProperty("EncuestaAtencion_N", gxTv_SdtEncuesta_Encuestaatencion_N, false, includeNonInitialized);
      AddObjectProperty("EncuestaAtendido", gxTv_SdtEncuesta_Encuestaatendido, false, includeNonInitialized);
      AddObjectProperty("EncuestaAtendido_N", gxTv_SdtEncuesta_Encuestaatendido_N, false, includeNonInitialized);
      datetime_STZ = gxTv_SdtEncuesta_Encuestahoraatencion ;
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
      AddObjectProperty("EncuestaHoraAtencion", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("EncuestaHoraAtencion_N", gxTv_SdtEncuesta_Encuestahoraatencion_N, false, includeNonInitialized);
      AddObjectProperty("EncuestaComentarios", gxTv_SdtEncuesta_Encuestacomentarios, false, includeNonInitialized);
      AddObjectProperty("EncuestaComentarios_N", gxTv_SdtEncuesta_Encuestacomentarios_N, false, includeNonInitialized);
      AddObjectProperty("EncuestaRecomendacion", gxTv_SdtEncuesta_Encuestarecomendacion, false, includeNonInitialized);
      AddObjectProperty("EncuestaEstado", gxTv_SdtEncuesta_Encuestaestado, false, includeNonInitialized);
      AddObjectProperty("EncuestaEstado_N", gxTv_SdtEncuesta_Encuestaestado_N, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtEncuesta_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtEncuesta_Initialized, false, includeNonInitialized);
         AddObjectProperty("EncuestaId_Z", gxTv_SdtEncuesta_Encuestaid_Z, false, includeNonInitialized);
         AddObjectProperty("CitaId_Z", gxTv_SdtEncuesta_Citaid_Z, false, includeNonInitialized);
         AddObjectProperty("SGCitaDisponibilidadProfesionalId_Z", gxTv_SdtEncuesta_Sgcitadisponibilidadprofesionalid_Z, false, includeNonInitialized);
         AddObjectProperty("SGCitaDisponibilidadProFullName_Z", gxTv_SdtEncuesta_Sgcitadisponibilidadprofullname_Z, false, includeNonInitialized);
         AddObjectProperty("SGCitaDisponibilidadEspecialidadId_Z", gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadid_Z, false, includeNonInitialized);
         AddObjectProperty("SGCitaDisponibilidadEspecialidadNombre_Z", gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadnombre_Z, false, includeNonInitialized);
         AddObjectProperty("SGCitaDisponibilidadId_Z", gxTv_SdtEncuesta_Sgcitadisponibilidadid_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtEncuesta_Sgcitadisponibilidadfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtEncuesta_Sgcitadisponibilidadfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtEncuesta_Sgcitadisponibilidadfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("SGCitaDisponibilidadFecha_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("PacienteId_Z", gxTv_SdtEncuesta_Pacienteid_Z, false, includeNonInitialized);
         AddObjectProperty("PacienteApellidoPaterno_Z", gxTv_SdtEncuesta_Pacienteapellidopaterno_Z, false, includeNonInitialized);
         AddObjectProperty("PacienteApellidoMaterno_Z", gxTv_SdtEncuesta_Pacienteapellidomaterno_Z, false, includeNonInitialized);
         AddObjectProperty("PacienteNombres_Z", gxTv_SdtEncuesta_Pacientenombres_Z, false, includeNonInitialized);
         AddObjectProperty("SGCitaDisponibilidadClinicaId_Z", gxTv_SdtEncuesta_Sgcitadisponibilidadclinicaid_Z, false, includeNonInitialized);
         AddObjectProperty("SGCitaDisponibilidadClinicaNombre_Z", gxTv_SdtEncuesta_Sgcitadisponibilidadclinicanombre_Z, false, includeNonInitialized);
         AddObjectProperty("EncuestaAtencion_Z", gxTv_SdtEncuesta_Encuestaatencion_Z, false, includeNonInitialized);
         AddObjectProperty("EncuestaAtendido_Z", gxTv_SdtEncuesta_Encuestaatendido_Z, false, includeNonInitialized);
         datetime_STZ = gxTv_SdtEncuesta_Encuestahoraatencion_Z ;
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
         AddObjectProperty("EncuestaHoraAtencion_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("EncuestaRecomendacion_Z", gxTv_SdtEncuesta_Encuestarecomendacion_Z, false, includeNonInitialized);
         AddObjectProperty("EncuestaEstado_Z", gxTv_SdtEncuesta_Encuestaestado_Z, false, includeNonInitialized);
         AddObjectProperty("SGCitaDisponibilidadFecha_N", gxTv_SdtEncuesta_Sgcitadisponibilidadfecha_N, false, includeNonInitialized);
         AddObjectProperty("EncuestaAtencion_N", gxTv_SdtEncuesta_Encuestaatencion_N, false, includeNonInitialized);
         AddObjectProperty("EncuestaAtendido_N", gxTv_SdtEncuesta_Encuestaatendido_N, false, includeNonInitialized);
         AddObjectProperty("EncuestaHoraAtencion_N", gxTv_SdtEncuesta_Encuestahoraatencion_N, false, includeNonInitialized);
         AddObjectProperty("EncuestaComentarios_N", gxTv_SdtEncuesta_Encuestacomentarios_N, false, includeNonInitialized);
         AddObjectProperty("EncuestaEstado_N", gxTv_SdtEncuesta_Encuestaestado_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.projectthani.SdtEncuesta sdt )
   {
      if ( sdt.IsDirty("EncuestaId") )
      {
         gxTv_SdtEncuesta_N = (byte)(0) ;
         gxTv_SdtEncuesta_Encuestaid = sdt.getgxTv_SdtEncuesta_Encuestaid() ;
      }
      if ( sdt.IsDirty("CitaId") )
      {
         gxTv_SdtEncuesta_N = (byte)(0) ;
         gxTv_SdtEncuesta_Citaid = sdt.getgxTv_SdtEncuesta_Citaid() ;
      }
      if ( sdt.IsDirty("SGCitaDisponibilidadProfesionalId") )
      {
         gxTv_SdtEncuesta_N = (byte)(0) ;
         gxTv_SdtEncuesta_Sgcitadisponibilidadprofesionalid = sdt.getgxTv_SdtEncuesta_Sgcitadisponibilidadprofesionalid() ;
      }
      if ( sdt.IsDirty("SGCitaDisponibilidadProFullName") )
      {
         gxTv_SdtEncuesta_N = (byte)(0) ;
         gxTv_SdtEncuesta_Sgcitadisponibilidadprofullname = sdt.getgxTv_SdtEncuesta_Sgcitadisponibilidadprofullname() ;
      }
      if ( sdt.IsDirty("SGCitaDisponibilidadEspecialidadId") )
      {
         gxTv_SdtEncuesta_N = (byte)(0) ;
         gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadid = sdt.getgxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadid() ;
      }
      if ( sdt.IsDirty("SGCitaDisponibilidadEspecialidadNombre") )
      {
         gxTv_SdtEncuesta_N = (byte)(0) ;
         gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadnombre = sdt.getgxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadnombre() ;
      }
      if ( sdt.IsDirty("SGCitaDisponibilidadId") )
      {
         gxTv_SdtEncuesta_N = (byte)(0) ;
         gxTv_SdtEncuesta_Sgcitadisponibilidadid = sdt.getgxTv_SdtEncuesta_Sgcitadisponibilidadid() ;
      }
      if ( sdt.IsDirty("SGCitaDisponibilidadFecha") )
      {
         gxTv_SdtEncuesta_Sgcitadisponibilidadfecha_N = (byte)(0) ;
         gxTv_SdtEncuesta_N = (byte)(0) ;
         gxTv_SdtEncuesta_Sgcitadisponibilidadfecha = sdt.getgxTv_SdtEncuesta_Sgcitadisponibilidadfecha() ;
      }
      if ( sdt.IsDirty("PacienteId") )
      {
         gxTv_SdtEncuesta_N = (byte)(0) ;
         gxTv_SdtEncuesta_Pacienteid = sdt.getgxTv_SdtEncuesta_Pacienteid() ;
      }
      if ( sdt.IsDirty("PacienteApellidoPaterno") )
      {
         gxTv_SdtEncuesta_N = (byte)(0) ;
         gxTv_SdtEncuesta_Pacienteapellidopaterno = sdt.getgxTv_SdtEncuesta_Pacienteapellidopaterno() ;
      }
      if ( sdt.IsDirty("PacienteApellidoMaterno") )
      {
         gxTv_SdtEncuesta_N = (byte)(0) ;
         gxTv_SdtEncuesta_Pacienteapellidomaterno = sdt.getgxTv_SdtEncuesta_Pacienteapellidomaterno() ;
      }
      if ( sdt.IsDirty("PacienteNombres") )
      {
         gxTv_SdtEncuesta_N = (byte)(0) ;
         gxTv_SdtEncuesta_Pacientenombres = sdt.getgxTv_SdtEncuesta_Pacientenombres() ;
      }
      if ( sdt.IsDirty("SGCitaDisponibilidadClinicaId") )
      {
         gxTv_SdtEncuesta_N = (byte)(0) ;
         gxTv_SdtEncuesta_Sgcitadisponibilidadclinicaid = sdt.getgxTv_SdtEncuesta_Sgcitadisponibilidadclinicaid() ;
      }
      if ( sdt.IsDirty("SGCitaDisponibilidadClinicaNombre") )
      {
         gxTv_SdtEncuesta_N = (byte)(0) ;
         gxTv_SdtEncuesta_Sgcitadisponibilidadclinicanombre = sdt.getgxTv_SdtEncuesta_Sgcitadisponibilidadclinicanombre() ;
      }
      if ( sdt.IsDirty("EncuestaAtencion") )
      {
         gxTv_SdtEncuesta_Encuestaatencion_N = (byte)(0) ;
         gxTv_SdtEncuesta_N = (byte)(0) ;
         gxTv_SdtEncuesta_Encuestaatencion = sdt.getgxTv_SdtEncuesta_Encuestaatencion() ;
      }
      if ( sdt.IsDirty("EncuestaAtendido") )
      {
         gxTv_SdtEncuesta_Encuestaatendido_N = (byte)(0) ;
         gxTv_SdtEncuesta_N = (byte)(0) ;
         gxTv_SdtEncuesta_Encuestaatendido = sdt.getgxTv_SdtEncuesta_Encuestaatendido() ;
      }
      if ( sdt.IsDirty("EncuestaHoraAtencion") )
      {
         gxTv_SdtEncuesta_Encuestahoraatencion_N = (byte)(0) ;
         gxTv_SdtEncuesta_N = (byte)(0) ;
         gxTv_SdtEncuesta_Encuestahoraatencion = sdt.getgxTv_SdtEncuesta_Encuestahoraatencion() ;
      }
      if ( sdt.IsDirty("EncuestaComentarios") )
      {
         gxTv_SdtEncuesta_Encuestacomentarios_N = (byte)(0) ;
         gxTv_SdtEncuesta_N = (byte)(0) ;
         gxTv_SdtEncuesta_Encuestacomentarios = sdt.getgxTv_SdtEncuesta_Encuestacomentarios() ;
      }
      if ( sdt.IsDirty("EncuestaRecomendacion") )
      {
         gxTv_SdtEncuesta_N = (byte)(0) ;
         gxTv_SdtEncuesta_Encuestarecomendacion = sdt.getgxTv_SdtEncuesta_Encuestarecomendacion() ;
      }
      if ( sdt.IsDirty("EncuestaEstado") )
      {
         gxTv_SdtEncuesta_Encuestaestado_N = (byte)(0) ;
         gxTv_SdtEncuesta_N = (byte)(0) ;
         gxTv_SdtEncuesta_Encuestaestado = sdt.getgxTv_SdtEncuesta_Encuestaestado() ;
      }
   }

   public short getgxTv_SdtEncuesta_Encuestaid( )
   {
      return gxTv_SdtEncuesta_Encuestaid ;
   }

   public void setgxTv_SdtEncuesta_Encuestaid( short value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      if ( gxTv_SdtEncuesta_Encuestaid != value )
      {
         gxTv_SdtEncuesta_Mode = "INS" ;
         this.setgxTv_SdtEncuesta_Encuestaid_Z_SetNull( );
         this.setgxTv_SdtEncuesta_Citaid_Z_SetNull( );
         this.setgxTv_SdtEncuesta_Sgcitadisponibilidadprofesionalid_Z_SetNull( );
         this.setgxTv_SdtEncuesta_Sgcitadisponibilidadprofullname_Z_SetNull( );
         this.setgxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadid_Z_SetNull( );
         this.setgxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadnombre_Z_SetNull( );
         this.setgxTv_SdtEncuesta_Sgcitadisponibilidadid_Z_SetNull( );
         this.setgxTv_SdtEncuesta_Sgcitadisponibilidadfecha_Z_SetNull( );
         this.setgxTv_SdtEncuesta_Pacienteid_Z_SetNull( );
         this.setgxTv_SdtEncuesta_Pacienteapellidopaterno_Z_SetNull( );
         this.setgxTv_SdtEncuesta_Pacienteapellidomaterno_Z_SetNull( );
         this.setgxTv_SdtEncuesta_Pacientenombres_Z_SetNull( );
         this.setgxTv_SdtEncuesta_Sgcitadisponibilidadclinicaid_Z_SetNull( );
         this.setgxTv_SdtEncuesta_Sgcitadisponibilidadclinicanombre_Z_SetNull( );
         this.setgxTv_SdtEncuesta_Encuestaatencion_Z_SetNull( );
         this.setgxTv_SdtEncuesta_Encuestaatendido_Z_SetNull( );
         this.setgxTv_SdtEncuesta_Encuestahoraatencion_Z_SetNull( );
         this.setgxTv_SdtEncuesta_Encuestarecomendacion_Z_SetNull( );
         this.setgxTv_SdtEncuesta_Encuestaestado_Z_SetNull( );
      }
      SetDirty("Encuestaid");
      gxTv_SdtEncuesta_Encuestaid = value ;
   }

   public int getgxTv_SdtEncuesta_Citaid( )
   {
      return gxTv_SdtEncuesta_Citaid ;
   }

   public void setgxTv_SdtEncuesta_Citaid( int value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Citaid");
      gxTv_SdtEncuesta_Citaid = value ;
   }

   public int getgxTv_SdtEncuesta_Sgcitadisponibilidadprofesionalid( )
   {
      return gxTv_SdtEncuesta_Sgcitadisponibilidadprofesionalid ;
   }

   public void setgxTv_SdtEncuesta_Sgcitadisponibilidadprofesionalid( int value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadprofesionalid");
      gxTv_SdtEncuesta_Sgcitadisponibilidadprofesionalid = value ;
   }

   public String getgxTv_SdtEncuesta_Sgcitadisponibilidadprofullname( )
   {
      return gxTv_SdtEncuesta_Sgcitadisponibilidadprofullname ;
   }

   public void setgxTv_SdtEncuesta_Sgcitadisponibilidadprofullname( String value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadprofullname");
      gxTv_SdtEncuesta_Sgcitadisponibilidadprofullname = value ;
   }

   public void setgxTv_SdtEncuesta_Sgcitadisponibilidadprofullname_SetNull( )
   {
      gxTv_SdtEncuesta_Sgcitadisponibilidadprofullname = "" ;
   }

   public boolean getgxTv_SdtEncuesta_Sgcitadisponibilidadprofullname_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadid( )
   {
      return gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadid ;
   }

   public void setgxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadid( short value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadespecialidadid");
      gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadid = value ;
   }

   public String getgxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadnombre( )
   {
      return gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadnombre ;
   }

   public void setgxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadnombre( String value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadespecialidadnombre");
      gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadnombre = value ;
   }

   public int getgxTv_SdtEncuesta_Sgcitadisponibilidadid( )
   {
      return gxTv_SdtEncuesta_Sgcitadisponibilidadid ;
   }

   public void setgxTv_SdtEncuesta_Sgcitadisponibilidadid( int value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadid");
      gxTv_SdtEncuesta_Sgcitadisponibilidadid = value ;
   }

   public java.util.Date getgxTv_SdtEncuesta_Sgcitadisponibilidadfecha( )
   {
      return gxTv_SdtEncuesta_Sgcitadisponibilidadfecha ;
   }

   public void setgxTv_SdtEncuesta_Sgcitadisponibilidadfecha( java.util.Date value )
   {
      gxTv_SdtEncuesta_Sgcitadisponibilidadfecha_N = (byte)(0) ;
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadfecha");
      gxTv_SdtEncuesta_Sgcitadisponibilidadfecha = value ;
   }

   public void setgxTv_SdtEncuesta_Sgcitadisponibilidadfecha_SetNull( )
   {
      gxTv_SdtEncuesta_Sgcitadisponibilidadfecha_N = (byte)(1) ;
      gxTv_SdtEncuesta_Sgcitadisponibilidadfecha = GXutil.nullDate() ;
   }

   public boolean getgxTv_SdtEncuesta_Sgcitadisponibilidadfecha_IsNull( )
   {
      return (gxTv_SdtEncuesta_Sgcitadisponibilidadfecha_N==1) ;
   }

   public int getgxTv_SdtEncuesta_Pacienteid( )
   {
      return gxTv_SdtEncuesta_Pacienteid ;
   }

   public void setgxTv_SdtEncuesta_Pacienteid( int value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Pacienteid");
      gxTv_SdtEncuesta_Pacienteid = value ;
   }

   public String getgxTv_SdtEncuesta_Pacienteapellidopaterno( )
   {
      return gxTv_SdtEncuesta_Pacienteapellidopaterno ;
   }

   public void setgxTv_SdtEncuesta_Pacienteapellidopaterno( String value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Pacienteapellidopaterno");
      gxTv_SdtEncuesta_Pacienteapellidopaterno = value ;
   }

   public String getgxTv_SdtEncuesta_Pacienteapellidomaterno( )
   {
      return gxTv_SdtEncuesta_Pacienteapellidomaterno ;
   }

   public void setgxTv_SdtEncuesta_Pacienteapellidomaterno( String value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Pacienteapellidomaterno");
      gxTv_SdtEncuesta_Pacienteapellidomaterno = value ;
   }

   public String getgxTv_SdtEncuesta_Pacientenombres( )
   {
      return gxTv_SdtEncuesta_Pacientenombres ;
   }

   public void setgxTv_SdtEncuesta_Pacientenombres( String value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Pacientenombres");
      gxTv_SdtEncuesta_Pacientenombres = value ;
   }

   public short getgxTv_SdtEncuesta_Sgcitadisponibilidadclinicaid( )
   {
      return gxTv_SdtEncuesta_Sgcitadisponibilidadclinicaid ;
   }

   public void setgxTv_SdtEncuesta_Sgcitadisponibilidadclinicaid( short value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadclinicaid");
      gxTv_SdtEncuesta_Sgcitadisponibilidadclinicaid = value ;
   }

   public String getgxTv_SdtEncuesta_Sgcitadisponibilidadclinicanombre( )
   {
      return gxTv_SdtEncuesta_Sgcitadisponibilidadclinicanombre ;
   }

   public void setgxTv_SdtEncuesta_Sgcitadisponibilidadclinicanombre( String value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadclinicanombre");
      gxTv_SdtEncuesta_Sgcitadisponibilidadclinicanombre = value ;
   }

   public String getgxTv_SdtEncuesta_Encuestaatencion( )
   {
      return gxTv_SdtEncuesta_Encuestaatencion ;
   }

   public void setgxTv_SdtEncuesta_Encuestaatencion( String value )
   {
      gxTv_SdtEncuesta_Encuestaatencion_N = (byte)(0) ;
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Encuestaatencion");
      gxTv_SdtEncuesta_Encuestaatencion = value ;
   }

   public void setgxTv_SdtEncuesta_Encuestaatencion_SetNull( )
   {
      gxTv_SdtEncuesta_Encuestaatencion_N = (byte)(1) ;
      gxTv_SdtEncuesta_Encuestaatencion = "" ;
   }

   public boolean getgxTv_SdtEncuesta_Encuestaatencion_IsNull( )
   {
      return (gxTv_SdtEncuesta_Encuestaatencion_N==1) ;
   }

   public String getgxTv_SdtEncuesta_Encuestaatendido( )
   {
      return gxTv_SdtEncuesta_Encuestaatendido ;
   }

   public void setgxTv_SdtEncuesta_Encuestaatendido( String value )
   {
      gxTv_SdtEncuesta_Encuestaatendido_N = (byte)(0) ;
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Encuestaatendido");
      gxTv_SdtEncuesta_Encuestaatendido = value ;
   }

   public void setgxTv_SdtEncuesta_Encuestaatendido_SetNull( )
   {
      gxTv_SdtEncuesta_Encuestaatendido_N = (byte)(1) ;
      gxTv_SdtEncuesta_Encuestaatendido = "" ;
   }

   public boolean getgxTv_SdtEncuesta_Encuestaatendido_IsNull( )
   {
      return (gxTv_SdtEncuesta_Encuestaatendido_N==1) ;
   }

   public java.util.Date getgxTv_SdtEncuesta_Encuestahoraatencion( )
   {
      return gxTv_SdtEncuesta_Encuestahoraatencion ;
   }

   public void setgxTv_SdtEncuesta_Encuestahoraatencion( java.util.Date value )
   {
      gxTv_SdtEncuesta_Encuestahoraatencion_N = (byte)(0) ;
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Encuestahoraatencion");
      gxTv_SdtEncuesta_Encuestahoraatencion = value ;
   }

   public void setgxTv_SdtEncuesta_Encuestahoraatencion_SetNull( )
   {
      gxTv_SdtEncuesta_Encuestahoraatencion_N = (byte)(1) ;
      gxTv_SdtEncuesta_Encuestahoraatencion = GXutil.resetTime( GXutil.nullDate() );
   }

   public boolean getgxTv_SdtEncuesta_Encuestahoraatencion_IsNull( )
   {
      return (gxTv_SdtEncuesta_Encuestahoraatencion_N==1) ;
   }

   public String getgxTv_SdtEncuesta_Encuestacomentarios( )
   {
      return gxTv_SdtEncuesta_Encuestacomentarios ;
   }

   public void setgxTv_SdtEncuesta_Encuestacomentarios( String value )
   {
      gxTv_SdtEncuesta_Encuestacomentarios_N = (byte)(0) ;
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Encuestacomentarios");
      gxTv_SdtEncuesta_Encuestacomentarios = value ;
   }

   public void setgxTv_SdtEncuesta_Encuestacomentarios_SetNull( )
   {
      gxTv_SdtEncuesta_Encuestacomentarios_N = (byte)(1) ;
      gxTv_SdtEncuesta_Encuestacomentarios = "" ;
   }

   public boolean getgxTv_SdtEncuesta_Encuestacomentarios_IsNull( )
   {
      return (gxTv_SdtEncuesta_Encuestacomentarios_N==1) ;
   }

   public byte getgxTv_SdtEncuesta_Encuestarecomendacion( )
   {
      return gxTv_SdtEncuesta_Encuestarecomendacion ;
   }

   public void setgxTv_SdtEncuesta_Encuestarecomendacion( byte value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Encuestarecomendacion");
      gxTv_SdtEncuesta_Encuestarecomendacion = value ;
   }

   public String getgxTv_SdtEncuesta_Encuestaestado( )
   {
      return gxTv_SdtEncuesta_Encuestaestado ;
   }

   public void setgxTv_SdtEncuesta_Encuestaestado( String value )
   {
      gxTv_SdtEncuesta_Encuestaestado_N = (byte)(0) ;
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Encuestaestado");
      gxTv_SdtEncuesta_Encuestaestado = value ;
   }

   public void setgxTv_SdtEncuesta_Encuestaestado_SetNull( )
   {
      gxTv_SdtEncuesta_Encuestaestado_N = (byte)(1) ;
      gxTv_SdtEncuesta_Encuestaestado = "" ;
   }

   public boolean getgxTv_SdtEncuesta_Encuestaestado_IsNull( )
   {
      return (gxTv_SdtEncuesta_Encuestaestado_N==1) ;
   }

   public String getgxTv_SdtEncuesta_Mode( )
   {
      return gxTv_SdtEncuesta_Mode ;
   }

   public void setgxTv_SdtEncuesta_Mode( String value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtEncuesta_Mode = value ;
   }

   public void setgxTv_SdtEncuesta_Mode_SetNull( )
   {
      gxTv_SdtEncuesta_Mode = "" ;
   }

   public boolean getgxTv_SdtEncuesta_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEncuesta_Initialized( )
   {
      return gxTv_SdtEncuesta_Initialized ;
   }

   public void setgxTv_SdtEncuesta_Initialized( short value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtEncuesta_Initialized = value ;
   }

   public void setgxTv_SdtEncuesta_Initialized_SetNull( )
   {
      gxTv_SdtEncuesta_Initialized = (short)(0) ;
   }

   public boolean getgxTv_SdtEncuesta_Initialized_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEncuesta_Encuestaid_Z( )
   {
      return gxTv_SdtEncuesta_Encuestaid_Z ;
   }

   public void setgxTv_SdtEncuesta_Encuestaid_Z( short value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Encuestaid_Z");
      gxTv_SdtEncuesta_Encuestaid_Z = value ;
   }

   public void setgxTv_SdtEncuesta_Encuestaid_Z_SetNull( )
   {
      gxTv_SdtEncuesta_Encuestaid_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtEncuesta_Encuestaid_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtEncuesta_Citaid_Z( )
   {
      return gxTv_SdtEncuesta_Citaid_Z ;
   }

   public void setgxTv_SdtEncuesta_Citaid_Z( int value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Citaid_Z");
      gxTv_SdtEncuesta_Citaid_Z = value ;
   }

   public void setgxTv_SdtEncuesta_Citaid_Z_SetNull( )
   {
      gxTv_SdtEncuesta_Citaid_Z = 0 ;
   }

   public boolean getgxTv_SdtEncuesta_Citaid_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtEncuesta_Sgcitadisponibilidadprofesionalid_Z( )
   {
      return gxTv_SdtEncuesta_Sgcitadisponibilidadprofesionalid_Z ;
   }

   public void setgxTv_SdtEncuesta_Sgcitadisponibilidadprofesionalid_Z( int value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadprofesionalid_Z");
      gxTv_SdtEncuesta_Sgcitadisponibilidadprofesionalid_Z = value ;
   }

   public void setgxTv_SdtEncuesta_Sgcitadisponibilidadprofesionalid_Z_SetNull( )
   {
      gxTv_SdtEncuesta_Sgcitadisponibilidadprofesionalid_Z = 0 ;
   }

   public boolean getgxTv_SdtEncuesta_Sgcitadisponibilidadprofesionalid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEncuesta_Sgcitadisponibilidadprofullname_Z( )
   {
      return gxTv_SdtEncuesta_Sgcitadisponibilidadprofullname_Z ;
   }

   public void setgxTv_SdtEncuesta_Sgcitadisponibilidadprofullname_Z( String value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadprofullname_Z");
      gxTv_SdtEncuesta_Sgcitadisponibilidadprofullname_Z = value ;
   }

   public void setgxTv_SdtEncuesta_Sgcitadisponibilidadprofullname_Z_SetNull( )
   {
      gxTv_SdtEncuesta_Sgcitadisponibilidadprofullname_Z = "" ;
   }

   public boolean getgxTv_SdtEncuesta_Sgcitadisponibilidadprofullname_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadid_Z( )
   {
      return gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadid_Z ;
   }

   public void setgxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadid_Z( short value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadespecialidadid_Z");
      gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadid_Z = value ;
   }

   public void setgxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadid_Z_SetNull( )
   {
      gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadid_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadnombre_Z( )
   {
      return gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadnombre_Z ;
   }

   public void setgxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadnombre_Z( String value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadespecialidadnombre_Z");
      gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadnombre_Z = value ;
   }

   public void setgxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadnombre_Z_SetNull( )
   {
      gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadnombre_Z = "" ;
   }

   public boolean getgxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadnombre_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtEncuesta_Sgcitadisponibilidadid_Z( )
   {
      return gxTv_SdtEncuesta_Sgcitadisponibilidadid_Z ;
   }

   public void setgxTv_SdtEncuesta_Sgcitadisponibilidadid_Z( int value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadid_Z");
      gxTv_SdtEncuesta_Sgcitadisponibilidadid_Z = value ;
   }

   public void setgxTv_SdtEncuesta_Sgcitadisponibilidadid_Z_SetNull( )
   {
      gxTv_SdtEncuesta_Sgcitadisponibilidadid_Z = 0 ;
   }

   public boolean getgxTv_SdtEncuesta_Sgcitadisponibilidadid_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtEncuesta_Sgcitadisponibilidadfecha_Z( )
   {
      return gxTv_SdtEncuesta_Sgcitadisponibilidadfecha_Z ;
   }

   public void setgxTv_SdtEncuesta_Sgcitadisponibilidadfecha_Z( java.util.Date value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadfecha_Z");
      gxTv_SdtEncuesta_Sgcitadisponibilidadfecha_Z = value ;
   }

   public void setgxTv_SdtEncuesta_Sgcitadisponibilidadfecha_Z_SetNull( )
   {
      gxTv_SdtEncuesta_Sgcitadisponibilidadfecha_Z = GXutil.nullDate() ;
   }

   public boolean getgxTv_SdtEncuesta_Sgcitadisponibilidadfecha_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtEncuesta_Pacienteid_Z( )
   {
      return gxTv_SdtEncuesta_Pacienteid_Z ;
   }

   public void setgxTv_SdtEncuesta_Pacienteid_Z( int value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Pacienteid_Z");
      gxTv_SdtEncuesta_Pacienteid_Z = value ;
   }

   public void setgxTv_SdtEncuesta_Pacienteid_Z_SetNull( )
   {
      gxTv_SdtEncuesta_Pacienteid_Z = 0 ;
   }

   public boolean getgxTv_SdtEncuesta_Pacienteid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEncuesta_Pacienteapellidopaterno_Z( )
   {
      return gxTv_SdtEncuesta_Pacienteapellidopaterno_Z ;
   }

   public void setgxTv_SdtEncuesta_Pacienteapellidopaterno_Z( String value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Pacienteapellidopaterno_Z");
      gxTv_SdtEncuesta_Pacienteapellidopaterno_Z = value ;
   }

   public void setgxTv_SdtEncuesta_Pacienteapellidopaterno_Z_SetNull( )
   {
      gxTv_SdtEncuesta_Pacienteapellidopaterno_Z = "" ;
   }

   public boolean getgxTv_SdtEncuesta_Pacienteapellidopaterno_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEncuesta_Pacienteapellidomaterno_Z( )
   {
      return gxTv_SdtEncuesta_Pacienteapellidomaterno_Z ;
   }

   public void setgxTv_SdtEncuesta_Pacienteapellidomaterno_Z( String value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Pacienteapellidomaterno_Z");
      gxTv_SdtEncuesta_Pacienteapellidomaterno_Z = value ;
   }

   public void setgxTv_SdtEncuesta_Pacienteapellidomaterno_Z_SetNull( )
   {
      gxTv_SdtEncuesta_Pacienteapellidomaterno_Z = "" ;
   }

   public boolean getgxTv_SdtEncuesta_Pacienteapellidomaterno_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEncuesta_Pacientenombres_Z( )
   {
      return gxTv_SdtEncuesta_Pacientenombres_Z ;
   }

   public void setgxTv_SdtEncuesta_Pacientenombres_Z( String value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Pacientenombres_Z");
      gxTv_SdtEncuesta_Pacientenombres_Z = value ;
   }

   public void setgxTv_SdtEncuesta_Pacientenombres_Z_SetNull( )
   {
      gxTv_SdtEncuesta_Pacientenombres_Z = "" ;
   }

   public boolean getgxTv_SdtEncuesta_Pacientenombres_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEncuesta_Sgcitadisponibilidadclinicaid_Z( )
   {
      return gxTv_SdtEncuesta_Sgcitadisponibilidadclinicaid_Z ;
   }

   public void setgxTv_SdtEncuesta_Sgcitadisponibilidadclinicaid_Z( short value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadclinicaid_Z");
      gxTv_SdtEncuesta_Sgcitadisponibilidadclinicaid_Z = value ;
   }

   public void setgxTv_SdtEncuesta_Sgcitadisponibilidadclinicaid_Z_SetNull( )
   {
      gxTv_SdtEncuesta_Sgcitadisponibilidadclinicaid_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtEncuesta_Sgcitadisponibilidadclinicaid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEncuesta_Sgcitadisponibilidadclinicanombre_Z( )
   {
      return gxTv_SdtEncuesta_Sgcitadisponibilidadclinicanombre_Z ;
   }

   public void setgxTv_SdtEncuesta_Sgcitadisponibilidadclinicanombre_Z( String value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadclinicanombre_Z");
      gxTv_SdtEncuesta_Sgcitadisponibilidadclinicanombre_Z = value ;
   }

   public void setgxTv_SdtEncuesta_Sgcitadisponibilidadclinicanombre_Z_SetNull( )
   {
      gxTv_SdtEncuesta_Sgcitadisponibilidadclinicanombre_Z = "" ;
   }

   public boolean getgxTv_SdtEncuesta_Sgcitadisponibilidadclinicanombre_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEncuesta_Encuestaatencion_Z( )
   {
      return gxTv_SdtEncuesta_Encuestaatencion_Z ;
   }

   public void setgxTv_SdtEncuesta_Encuestaatencion_Z( String value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Encuestaatencion_Z");
      gxTv_SdtEncuesta_Encuestaatencion_Z = value ;
   }

   public void setgxTv_SdtEncuesta_Encuestaatencion_Z_SetNull( )
   {
      gxTv_SdtEncuesta_Encuestaatencion_Z = "" ;
   }

   public boolean getgxTv_SdtEncuesta_Encuestaatencion_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEncuesta_Encuestaatendido_Z( )
   {
      return gxTv_SdtEncuesta_Encuestaatendido_Z ;
   }

   public void setgxTv_SdtEncuesta_Encuestaatendido_Z( String value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Encuestaatendido_Z");
      gxTv_SdtEncuesta_Encuestaatendido_Z = value ;
   }

   public void setgxTv_SdtEncuesta_Encuestaatendido_Z_SetNull( )
   {
      gxTv_SdtEncuesta_Encuestaatendido_Z = "" ;
   }

   public boolean getgxTv_SdtEncuesta_Encuestaatendido_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtEncuesta_Encuestahoraatencion_Z( )
   {
      return gxTv_SdtEncuesta_Encuestahoraatencion_Z ;
   }

   public void setgxTv_SdtEncuesta_Encuestahoraatencion_Z( java.util.Date value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Encuestahoraatencion_Z");
      gxTv_SdtEncuesta_Encuestahoraatencion_Z = value ;
   }

   public void setgxTv_SdtEncuesta_Encuestahoraatencion_Z_SetNull( )
   {
      gxTv_SdtEncuesta_Encuestahoraatencion_Z = GXutil.resetTime( GXutil.nullDate() );
   }

   public boolean getgxTv_SdtEncuesta_Encuestahoraatencion_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEncuesta_Encuestarecomendacion_Z( )
   {
      return gxTv_SdtEncuesta_Encuestarecomendacion_Z ;
   }

   public void setgxTv_SdtEncuesta_Encuestarecomendacion_Z( byte value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Encuestarecomendacion_Z");
      gxTv_SdtEncuesta_Encuestarecomendacion_Z = value ;
   }

   public void setgxTv_SdtEncuesta_Encuestarecomendacion_Z_SetNull( )
   {
      gxTv_SdtEncuesta_Encuestarecomendacion_Z = (byte)(0) ;
   }

   public boolean getgxTv_SdtEncuesta_Encuestarecomendacion_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEncuesta_Encuestaestado_Z( )
   {
      return gxTv_SdtEncuesta_Encuestaestado_Z ;
   }

   public void setgxTv_SdtEncuesta_Encuestaestado_Z( String value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Encuestaestado_Z");
      gxTv_SdtEncuesta_Encuestaestado_Z = value ;
   }

   public void setgxTv_SdtEncuesta_Encuestaestado_Z_SetNull( )
   {
      gxTv_SdtEncuesta_Encuestaestado_Z = "" ;
   }

   public boolean getgxTv_SdtEncuesta_Encuestaestado_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEncuesta_Sgcitadisponibilidadfecha_N( )
   {
      return gxTv_SdtEncuesta_Sgcitadisponibilidadfecha_N ;
   }

   public void setgxTv_SdtEncuesta_Sgcitadisponibilidadfecha_N( byte value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadfecha_N");
      gxTv_SdtEncuesta_Sgcitadisponibilidadfecha_N = value ;
   }

   public void setgxTv_SdtEncuesta_Sgcitadisponibilidadfecha_N_SetNull( )
   {
      gxTv_SdtEncuesta_Sgcitadisponibilidadfecha_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtEncuesta_Sgcitadisponibilidadfecha_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEncuesta_Encuestaatencion_N( )
   {
      return gxTv_SdtEncuesta_Encuestaatencion_N ;
   }

   public void setgxTv_SdtEncuesta_Encuestaatencion_N( byte value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Encuestaatencion_N");
      gxTv_SdtEncuesta_Encuestaatencion_N = value ;
   }

   public void setgxTv_SdtEncuesta_Encuestaatencion_N_SetNull( )
   {
      gxTv_SdtEncuesta_Encuestaatencion_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtEncuesta_Encuestaatencion_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEncuesta_Encuestaatendido_N( )
   {
      return gxTv_SdtEncuesta_Encuestaatendido_N ;
   }

   public void setgxTv_SdtEncuesta_Encuestaatendido_N( byte value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Encuestaatendido_N");
      gxTv_SdtEncuesta_Encuestaatendido_N = value ;
   }

   public void setgxTv_SdtEncuesta_Encuestaatendido_N_SetNull( )
   {
      gxTv_SdtEncuesta_Encuestaatendido_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtEncuesta_Encuestaatendido_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEncuesta_Encuestahoraatencion_N( )
   {
      return gxTv_SdtEncuesta_Encuestahoraatencion_N ;
   }

   public void setgxTv_SdtEncuesta_Encuestahoraatencion_N( byte value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Encuestahoraatencion_N");
      gxTv_SdtEncuesta_Encuestahoraatencion_N = value ;
   }

   public void setgxTv_SdtEncuesta_Encuestahoraatencion_N_SetNull( )
   {
      gxTv_SdtEncuesta_Encuestahoraatencion_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtEncuesta_Encuestahoraatencion_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEncuesta_Encuestacomentarios_N( )
   {
      return gxTv_SdtEncuesta_Encuestacomentarios_N ;
   }

   public void setgxTv_SdtEncuesta_Encuestacomentarios_N( byte value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Encuestacomentarios_N");
      gxTv_SdtEncuesta_Encuestacomentarios_N = value ;
   }

   public void setgxTv_SdtEncuesta_Encuestacomentarios_N_SetNull( )
   {
      gxTv_SdtEncuesta_Encuestacomentarios_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtEncuesta_Encuestacomentarios_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEncuesta_Encuestaestado_N( )
   {
      return gxTv_SdtEncuesta_Encuestaestado_N ;
   }

   public void setgxTv_SdtEncuesta_Encuestaestado_N( byte value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      SetDirty("Encuestaestado_N");
      gxTv_SdtEncuesta_Encuestaestado_N = value ;
   }

   public void setgxTv_SdtEncuesta_Encuestaestado_N_SetNull( )
   {
      gxTv_SdtEncuesta_Encuestaestado_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtEncuesta_Encuestaestado_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.projectthani.encuesta_bc obj;
      obj = new com.projectthani.encuesta_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtEncuesta_N = (byte)(1) ;
      gxTv_SdtEncuesta_Sgcitadisponibilidadprofullname = "" ;
      gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadnombre = "" ;
      gxTv_SdtEncuesta_Sgcitadisponibilidadfecha = GXutil.nullDate() ;
      gxTv_SdtEncuesta_Pacienteapellidopaterno = "" ;
      gxTv_SdtEncuesta_Pacienteapellidomaterno = "" ;
      gxTv_SdtEncuesta_Pacientenombres = "" ;
      gxTv_SdtEncuesta_Sgcitadisponibilidadclinicanombre = "" ;
      gxTv_SdtEncuesta_Encuestaatencion = "" ;
      gxTv_SdtEncuesta_Encuestaatendido = "" ;
      gxTv_SdtEncuesta_Encuestahoraatencion = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtEncuesta_Encuestacomentarios = "" ;
      gxTv_SdtEncuesta_Encuestaestado = "" ;
      gxTv_SdtEncuesta_Mode = "" ;
      gxTv_SdtEncuesta_Sgcitadisponibilidadprofullname_Z = "" ;
      gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadnombre_Z = "" ;
      gxTv_SdtEncuesta_Sgcitadisponibilidadfecha_Z = GXutil.nullDate() ;
      gxTv_SdtEncuesta_Pacienteapellidopaterno_Z = "" ;
      gxTv_SdtEncuesta_Pacienteapellidomaterno_Z = "" ;
      gxTv_SdtEncuesta_Pacientenombres_Z = "" ;
      gxTv_SdtEncuesta_Sgcitadisponibilidadclinicanombre_Z = "" ;
      gxTv_SdtEncuesta_Encuestaatencion_Z = "" ;
      gxTv_SdtEncuesta_Encuestaatendido_Z = "" ;
      gxTv_SdtEncuesta_Encuestahoraatencion_Z = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtEncuesta_Encuestaestado_Z = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
      datetime_STZ = GXutil.resetTime( GXutil.nullDate() );
   }

   public byte isNull( )
   {
      return gxTv_SdtEncuesta_N ;
   }

   public com.projectthani.SdtEncuesta Clone( )
   {
      com.projectthani.SdtEncuesta sdt;
      com.projectthani.encuesta_bc obj;
      sdt = (com.projectthani.SdtEncuesta)(clone()) ;
      obj = (com.projectthani.encuesta_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.projectthani.StructSdtEncuesta struct )
   {
      setgxTv_SdtEncuesta_Encuestaid(struct.getEncuestaid());
      setgxTv_SdtEncuesta_Citaid(struct.getCitaid());
      setgxTv_SdtEncuesta_Sgcitadisponibilidadprofesionalid(struct.getSgcitadisponibilidadprofesionalid());
      setgxTv_SdtEncuesta_Sgcitadisponibilidadprofullname(struct.getSgcitadisponibilidadprofullname());
      setgxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadid(struct.getSgcitadisponibilidadespecialidadid());
      setgxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadnombre(struct.getSgcitadisponibilidadespecialidadnombre());
      setgxTv_SdtEncuesta_Sgcitadisponibilidadid(struct.getSgcitadisponibilidadid());
      setgxTv_SdtEncuesta_Sgcitadisponibilidadfecha(struct.getSgcitadisponibilidadfecha());
      setgxTv_SdtEncuesta_Pacienteid(struct.getPacienteid());
      setgxTv_SdtEncuesta_Pacienteapellidopaterno(struct.getPacienteapellidopaterno());
      setgxTv_SdtEncuesta_Pacienteapellidomaterno(struct.getPacienteapellidomaterno());
      setgxTv_SdtEncuesta_Pacientenombres(struct.getPacientenombres());
      setgxTv_SdtEncuesta_Sgcitadisponibilidadclinicaid(struct.getSgcitadisponibilidadclinicaid());
      setgxTv_SdtEncuesta_Sgcitadisponibilidadclinicanombre(struct.getSgcitadisponibilidadclinicanombre());
      setgxTv_SdtEncuesta_Encuestaatencion(struct.getEncuestaatencion());
      setgxTv_SdtEncuesta_Encuestaatendido(struct.getEncuestaatendido());
      setgxTv_SdtEncuesta_Encuestahoraatencion(struct.getEncuestahoraatencion());
      setgxTv_SdtEncuesta_Encuestacomentarios(struct.getEncuestacomentarios());
      setgxTv_SdtEncuesta_Encuestarecomendacion(struct.getEncuestarecomendacion());
      setgxTv_SdtEncuesta_Encuestaestado(struct.getEncuestaestado());
      setgxTv_SdtEncuesta_Mode(struct.getMode());
      setgxTv_SdtEncuesta_Initialized(struct.getInitialized());
      setgxTv_SdtEncuesta_Encuestaid_Z(struct.getEncuestaid_Z());
      setgxTv_SdtEncuesta_Citaid_Z(struct.getCitaid_Z());
      setgxTv_SdtEncuesta_Sgcitadisponibilidadprofesionalid_Z(struct.getSgcitadisponibilidadprofesionalid_Z());
      setgxTv_SdtEncuesta_Sgcitadisponibilidadprofullname_Z(struct.getSgcitadisponibilidadprofullname_Z());
      setgxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadid_Z(struct.getSgcitadisponibilidadespecialidadid_Z());
      setgxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadnombre_Z(struct.getSgcitadisponibilidadespecialidadnombre_Z());
      setgxTv_SdtEncuesta_Sgcitadisponibilidadid_Z(struct.getSgcitadisponibilidadid_Z());
      setgxTv_SdtEncuesta_Sgcitadisponibilidadfecha_Z(struct.getSgcitadisponibilidadfecha_Z());
      setgxTv_SdtEncuesta_Pacienteid_Z(struct.getPacienteid_Z());
      setgxTv_SdtEncuesta_Pacienteapellidopaterno_Z(struct.getPacienteapellidopaterno_Z());
      setgxTv_SdtEncuesta_Pacienteapellidomaterno_Z(struct.getPacienteapellidomaterno_Z());
      setgxTv_SdtEncuesta_Pacientenombres_Z(struct.getPacientenombres_Z());
      setgxTv_SdtEncuesta_Sgcitadisponibilidadclinicaid_Z(struct.getSgcitadisponibilidadclinicaid_Z());
      setgxTv_SdtEncuesta_Sgcitadisponibilidadclinicanombre_Z(struct.getSgcitadisponibilidadclinicanombre_Z());
      setgxTv_SdtEncuesta_Encuestaatencion_Z(struct.getEncuestaatencion_Z());
      setgxTv_SdtEncuesta_Encuestaatendido_Z(struct.getEncuestaatendido_Z());
      setgxTv_SdtEncuesta_Encuestahoraatencion_Z(struct.getEncuestahoraatencion_Z());
      setgxTv_SdtEncuesta_Encuestarecomendacion_Z(struct.getEncuestarecomendacion_Z());
      setgxTv_SdtEncuesta_Encuestaestado_Z(struct.getEncuestaestado_Z());
      setgxTv_SdtEncuesta_Sgcitadisponibilidadfecha_N(struct.getSgcitadisponibilidadfecha_N());
      setgxTv_SdtEncuesta_Encuestaatencion_N(struct.getEncuestaatencion_N());
      setgxTv_SdtEncuesta_Encuestaatendido_N(struct.getEncuestaatendido_N());
      setgxTv_SdtEncuesta_Encuestahoraatencion_N(struct.getEncuestahoraatencion_N());
      setgxTv_SdtEncuesta_Encuestacomentarios_N(struct.getEncuestacomentarios_N());
      setgxTv_SdtEncuesta_Encuestaestado_N(struct.getEncuestaestado_N());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtEncuesta getStruct( )
   {
      com.projectthani.StructSdtEncuesta struct = new com.projectthani.StructSdtEncuesta ();
      struct.setEncuestaid(getgxTv_SdtEncuesta_Encuestaid());
      struct.setCitaid(getgxTv_SdtEncuesta_Citaid());
      struct.setSgcitadisponibilidadprofesionalid(getgxTv_SdtEncuesta_Sgcitadisponibilidadprofesionalid());
      struct.setSgcitadisponibilidadprofullname(getgxTv_SdtEncuesta_Sgcitadisponibilidadprofullname());
      struct.setSgcitadisponibilidadespecialidadid(getgxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadid());
      struct.setSgcitadisponibilidadespecialidadnombre(getgxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadnombre());
      struct.setSgcitadisponibilidadid(getgxTv_SdtEncuesta_Sgcitadisponibilidadid());
      struct.setSgcitadisponibilidadfecha(getgxTv_SdtEncuesta_Sgcitadisponibilidadfecha());
      struct.setPacienteid(getgxTv_SdtEncuesta_Pacienteid());
      struct.setPacienteapellidopaterno(getgxTv_SdtEncuesta_Pacienteapellidopaterno());
      struct.setPacienteapellidomaterno(getgxTv_SdtEncuesta_Pacienteapellidomaterno());
      struct.setPacientenombres(getgxTv_SdtEncuesta_Pacientenombres());
      struct.setSgcitadisponibilidadclinicaid(getgxTv_SdtEncuesta_Sgcitadisponibilidadclinicaid());
      struct.setSgcitadisponibilidadclinicanombre(getgxTv_SdtEncuesta_Sgcitadisponibilidadclinicanombre());
      struct.setEncuestaatencion(getgxTv_SdtEncuesta_Encuestaatencion());
      struct.setEncuestaatendido(getgxTv_SdtEncuesta_Encuestaatendido());
      struct.setEncuestahoraatencion(getgxTv_SdtEncuesta_Encuestahoraatencion());
      struct.setEncuestacomentarios(getgxTv_SdtEncuesta_Encuestacomentarios());
      struct.setEncuestarecomendacion(getgxTv_SdtEncuesta_Encuestarecomendacion());
      struct.setEncuestaestado(getgxTv_SdtEncuesta_Encuestaestado());
      struct.setMode(getgxTv_SdtEncuesta_Mode());
      struct.setInitialized(getgxTv_SdtEncuesta_Initialized());
      struct.setEncuestaid_Z(getgxTv_SdtEncuesta_Encuestaid_Z());
      struct.setCitaid_Z(getgxTv_SdtEncuesta_Citaid_Z());
      struct.setSgcitadisponibilidadprofesionalid_Z(getgxTv_SdtEncuesta_Sgcitadisponibilidadprofesionalid_Z());
      struct.setSgcitadisponibilidadprofullname_Z(getgxTv_SdtEncuesta_Sgcitadisponibilidadprofullname_Z());
      struct.setSgcitadisponibilidadespecialidadid_Z(getgxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadid_Z());
      struct.setSgcitadisponibilidadespecialidadnombre_Z(getgxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadnombre_Z());
      struct.setSgcitadisponibilidadid_Z(getgxTv_SdtEncuesta_Sgcitadisponibilidadid_Z());
      struct.setSgcitadisponibilidadfecha_Z(getgxTv_SdtEncuesta_Sgcitadisponibilidadfecha_Z());
      struct.setPacienteid_Z(getgxTv_SdtEncuesta_Pacienteid_Z());
      struct.setPacienteapellidopaterno_Z(getgxTv_SdtEncuesta_Pacienteapellidopaterno_Z());
      struct.setPacienteapellidomaterno_Z(getgxTv_SdtEncuesta_Pacienteapellidomaterno_Z());
      struct.setPacientenombres_Z(getgxTv_SdtEncuesta_Pacientenombres_Z());
      struct.setSgcitadisponibilidadclinicaid_Z(getgxTv_SdtEncuesta_Sgcitadisponibilidadclinicaid_Z());
      struct.setSgcitadisponibilidadclinicanombre_Z(getgxTv_SdtEncuesta_Sgcitadisponibilidadclinicanombre_Z());
      struct.setEncuestaatencion_Z(getgxTv_SdtEncuesta_Encuestaatencion_Z());
      struct.setEncuestaatendido_Z(getgxTv_SdtEncuesta_Encuestaatendido_Z());
      struct.setEncuestahoraatencion_Z(getgxTv_SdtEncuesta_Encuestahoraatencion_Z());
      struct.setEncuestarecomendacion_Z(getgxTv_SdtEncuesta_Encuestarecomendacion_Z());
      struct.setEncuestaestado_Z(getgxTv_SdtEncuesta_Encuestaestado_Z());
      struct.setSgcitadisponibilidadfecha_N(getgxTv_SdtEncuesta_Sgcitadisponibilidadfecha_N());
      struct.setEncuestaatencion_N(getgxTv_SdtEncuesta_Encuestaatencion_N());
      struct.setEncuestaatendido_N(getgxTv_SdtEncuesta_Encuestaatendido_N());
      struct.setEncuestahoraatencion_N(getgxTv_SdtEncuesta_Encuestahoraatencion_N());
      struct.setEncuestacomentarios_N(getgxTv_SdtEncuesta_Encuestacomentarios_N());
      struct.setEncuestaestado_N(getgxTv_SdtEncuesta_Encuestaestado_N());
      return struct ;
   }

   private byte gxTv_SdtEncuesta_N ;
   private byte gxTv_SdtEncuesta_Encuestarecomendacion ;
   private byte gxTv_SdtEncuesta_Encuestarecomendacion_Z ;
   private byte gxTv_SdtEncuesta_Sgcitadisponibilidadfecha_N ;
   private byte gxTv_SdtEncuesta_Encuestaatencion_N ;
   private byte gxTv_SdtEncuesta_Encuestaatendido_N ;
   private byte gxTv_SdtEncuesta_Encuestahoraatencion_N ;
   private byte gxTv_SdtEncuesta_Encuestacomentarios_N ;
   private byte gxTv_SdtEncuesta_Encuestaestado_N ;
   private short gxTv_SdtEncuesta_Encuestaid ;
   private short gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadid ;
   private short gxTv_SdtEncuesta_Sgcitadisponibilidadclinicaid ;
   private short gxTv_SdtEncuesta_Initialized ;
   private short gxTv_SdtEncuesta_Encuestaid_Z ;
   private short gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadid_Z ;
   private short gxTv_SdtEncuesta_Sgcitadisponibilidadclinicaid_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtEncuesta_Citaid ;
   private int gxTv_SdtEncuesta_Sgcitadisponibilidadprofesionalid ;
   private int gxTv_SdtEncuesta_Sgcitadisponibilidadid ;
   private int gxTv_SdtEncuesta_Pacienteid ;
   private int gxTv_SdtEncuesta_Citaid_Z ;
   private int gxTv_SdtEncuesta_Sgcitadisponibilidadprofesionalid_Z ;
   private int gxTv_SdtEncuesta_Sgcitadisponibilidadid_Z ;
   private int gxTv_SdtEncuesta_Pacienteid_Z ;
   private String gxTv_SdtEncuesta_Encuestaatencion ;
   private String gxTv_SdtEncuesta_Encuestaatendido ;
   private String gxTv_SdtEncuesta_Encuestaestado ;
   private String gxTv_SdtEncuesta_Mode ;
   private String gxTv_SdtEncuesta_Encuestaatencion_Z ;
   private String gxTv_SdtEncuesta_Encuestaatendido_Z ;
   private String gxTv_SdtEncuesta_Encuestaestado_Z ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_SdtEncuesta_Encuestahoraatencion ;
   private java.util.Date gxTv_SdtEncuesta_Encuestahoraatencion_Z ;
   private java.util.Date datetime_STZ ;
   private java.util.Date gxTv_SdtEncuesta_Sgcitadisponibilidadfecha ;
   private java.util.Date gxTv_SdtEncuesta_Sgcitadisponibilidadfecha_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtEncuesta_Encuestacomentarios ;
   private String gxTv_SdtEncuesta_Sgcitadisponibilidadprofullname ;
   private String gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadnombre ;
   private String gxTv_SdtEncuesta_Pacienteapellidopaterno ;
   private String gxTv_SdtEncuesta_Pacienteapellidomaterno ;
   private String gxTv_SdtEncuesta_Pacientenombres ;
   private String gxTv_SdtEncuesta_Sgcitadisponibilidadclinicanombre ;
   private String gxTv_SdtEncuesta_Sgcitadisponibilidadprofullname_Z ;
   private String gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadnombre_Z ;
   private String gxTv_SdtEncuesta_Pacienteapellidopaterno_Z ;
   private String gxTv_SdtEncuesta_Pacienteapellidomaterno_Z ;
   private String gxTv_SdtEncuesta_Pacientenombres_Z ;
   private String gxTv_SdtEncuesta_Sgcitadisponibilidadclinicanombre_Z ;
}

