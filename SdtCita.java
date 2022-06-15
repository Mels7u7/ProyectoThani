package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtCita extends GxSilentTrnSdt implements Cloneable, java.io.Serializable
{
   public SdtCita( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtCita.class));
   }

   public SdtCita( int remoteHandle ,
                   ModelContext context )
   {
      super( remoteHandle, context, "SdtCita");
      initialize( remoteHandle) ;
   }

   public SdtCita( int remoteHandle ,
                   StructSdtCita struct )
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

   public void Load( int AV19CitaId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV19CitaId)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"CitaId", int.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Cita");
      metadata.set("BT", "Cita");
      metadata.set("PK", "[ \"CitaId\" ]");
      metadata.set("PKAssigned", "[ \"CitaId\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"DisponibilidadId\" ],\"FKMap\":[ \"SGCitaDisponibilidadId-DisponibilidadId\" ] },{ \"FK\":[ \"PacienteId\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaId") )
            {
               gxTv_SdtCita_Citaid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaCode") )
            {
               gxTv_SdtCita_Citacode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteId") )
            {
               gxTv_SdtCita_Pacienteid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteApellidoPaterno") )
            {
               gxTv_SdtCita_Pacienteapellidopaterno = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteApellidoMaterno") )
            {
               gxTv_SdtCita_Pacienteapellidomaterno = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteNombres") )
            {
               gxTv_SdtCita_Pacientenombres = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteNroDocumento") )
            {
               gxTv_SdtCita_Pacientenrodocumento = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaTipoDiagnostico") )
            {
               gxTv_SdtCita_Citatipodiagnostico = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadId") )
            {
               gxTv_SdtCita_Sgcitadisponibilidadid = (int)(getnumericvalue(oReader.getValue())) ;
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
                  gxTv_SdtCita_Sgcitadisponibilidadfecha = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtCita_Sgcitadisponibilidadfecha = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
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
                  gxTv_SdtCita_Sgcitadisponibilidadhorainicio = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtCita_Sgcitadisponibilidadhorainicio = GXutil.resetDate(localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))))) ;
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
                  gxTv_SdtCita_Sgcitadisponibilidadhorafin = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtCita_Sgcitadisponibilidadhorafin = GXutil.resetDate(localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))))) ;
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
               gxTv_SdtCita_Sgcitadisponibilidadespecialidadid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadEspecialidadNombre") )
            {
               gxTv_SdtCita_Sgcitadisponibilidadespecialidadnombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadSedeId") )
            {
               gxTv_SdtCita_Sgcitadisponibilidadsedeid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadSedeNombre") )
            {
               gxTv_SdtCita_Sgcitadisponibilidadsedenombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadClinicaId") )
            {
               gxTv_SdtCita_Sgcitadisponibilidadclinicaid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadClinicaNombre") )
            {
               gxTv_SdtCita_Sgcitadisponibilidadclinicanombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadProfesionalId") )
            {
               gxTv_SdtCita_Sgcitadisponibilidadprofesionalid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadProFullName") )
            {
               gxTv_SdtCita_Sgcitadisponibilidadprofullname = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadProCOP") )
            {
               gxTv_SdtCita_Sgcitadisponibilidadprocop = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaEstadoCita") )
            {
               gxTv_SdtCita_Citaestadocita = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaInforme") )
            {
               gxTv_SdtCita_Citainforme = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaAntecedentes") )
            {
               gxTv_SdtCita_Citaantecedentes = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaLink") )
            {
               gxTv_SdtCita_Citalink = oReader.getValue() ;
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
                  gxTv_SdtCita_Citafechareserva = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtCita_Citafechareserva = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), ".")))) ;
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
               gxTv_SdtCita_Citalog = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaEmailGenLink") )
            {
               gxTv_SdtCita_Citaemailgenlink = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaEstado") )
            {
               gxTv_SdtCita_Citaestado = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaMotivoConsulta") )
            {
               gxTv_SdtCita_Citamotivoconsulta = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaArchivoNombre") )
            {
               gxTv_SdtCita_Citaarchivonombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaArchivo") )
            {
               gxTv_SdtCita_Citaarchivo=GXutil.blobFromBase64( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaArchivoExtencion") )
            {
               gxTv_SdtCita_Citaarchivoextencion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaConsentimiento") )
            {
               gxTv_SdtCita_Citaconsentimiento = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaGestante") )
            {
               gxTv_SdtCita_Citagestante = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaEstadoPago") )
            {
               gxTv_SdtCita_Citaestadopago = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaPeso") )
            {
               gxTv_SdtCita_Citapeso = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaEstatura") )
            {
               gxTv_SdtCita_Citaestatura = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtCita_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtCita_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaId_Z") )
            {
               gxTv_SdtCita_Citaid_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaCode_Z") )
            {
               gxTv_SdtCita_Citacode_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteId_Z") )
            {
               gxTv_SdtCita_Pacienteid_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteApellidoPaterno_Z") )
            {
               gxTv_SdtCita_Pacienteapellidopaterno_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteApellidoMaterno_Z") )
            {
               gxTv_SdtCita_Pacienteapellidomaterno_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteNombres_Z") )
            {
               gxTv_SdtCita_Pacientenombres_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteNroDocumento_Z") )
            {
               gxTv_SdtCita_Pacientenrodocumento_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaTipoDiagnostico_Z") )
            {
               gxTv_SdtCita_Citatipodiagnostico_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadId_Z") )
            {
               gxTv_SdtCita_Sgcitadisponibilidadid_Z = (int)(getnumericvalue(oReader.getValue())) ;
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
                  gxTv_SdtCita_Sgcitadisponibilidadfecha_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtCita_Sgcitadisponibilidadfecha_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadHoraInicio_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtCita_Sgcitadisponibilidadhorainicio_Z = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtCita_Sgcitadisponibilidadhorainicio_Z = GXutil.resetDate(localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadHoraFin_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtCita_Sgcitadisponibilidadhorafin_Z = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtCita_Sgcitadisponibilidadhorafin_Z = GXutil.resetDate(localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadEspecialidadId_Z") )
            {
               gxTv_SdtCita_Sgcitadisponibilidadespecialidadid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadEspecialidadNombre_Z") )
            {
               gxTv_SdtCita_Sgcitadisponibilidadespecialidadnombre_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadSedeId_Z") )
            {
               gxTv_SdtCita_Sgcitadisponibilidadsedeid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadSedeNombre_Z") )
            {
               gxTv_SdtCita_Sgcitadisponibilidadsedenombre_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadClinicaId_Z") )
            {
               gxTv_SdtCita_Sgcitadisponibilidadclinicaid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadClinicaNombre_Z") )
            {
               gxTv_SdtCita_Sgcitadisponibilidadclinicanombre_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadProfesionalId_Z") )
            {
               gxTv_SdtCita_Sgcitadisponibilidadprofesionalid_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadProFullName_Z") )
            {
               gxTv_SdtCita_Sgcitadisponibilidadprofullname_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadProCOP_Z") )
            {
               gxTv_SdtCita_Sgcitadisponibilidadprocop_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaEstadoCita_Z") )
            {
               gxTv_SdtCita_Citaestadocita_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaLink_Z") )
            {
               gxTv_SdtCita_Citalink_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaFechaReserva_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtCita_Citafechareserva_Z = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtCita_Citafechareserva_Z = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaLog_Z") )
            {
               gxTv_SdtCita_Citalog_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaEmailGenLink_Z") )
            {
               gxTv_SdtCita_Citaemailgenlink_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaEstado_Z") )
            {
               gxTv_SdtCita_Citaestado_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaArchivoNombre_Z") )
            {
               gxTv_SdtCita_Citaarchivonombre_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaArchivoExtencion_Z") )
            {
               gxTv_SdtCita_Citaarchivoextencion_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaConsentimiento_Z") )
            {
               gxTv_SdtCita_Citaconsentimiento_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaGestante_Z") )
            {
               gxTv_SdtCita_Citagestante_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaEstadoPago_Z") )
            {
               gxTv_SdtCita_Citaestadopago_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaPeso_Z") )
            {
               gxTv_SdtCita_Citapeso_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaEstatura_Z") )
            {
               gxTv_SdtCita_Citaestatura_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaId_N") )
            {
               gxTv_SdtCita_Citaid_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaTipoDiagnostico_N") )
            {
               gxTv_SdtCita_Citatipodiagnostico_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadFecha_N") )
            {
               gxTv_SdtCita_Sgcitadisponibilidadfecha_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadHoraInicio_N") )
            {
               gxTv_SdtCita_Sgcitadisponibilidadhorainicio_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGCitaDisponibilidadHoraFin_N") )
            {
               gxTv_SdtCita_Sgcitadisponibilidadhorafin_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaEstadoCita_N") )
            {
               gxTv_SdtCita_Citaestadocita_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaInforme_N") )
            {
               gxTv_SdtCita_Citainforme_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaAntecedentes_N") )
            {
               gxTv_SdtCita_Citaantecedentes_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaLink_N") )
            {
               gxTv_SdtCita_Citalink_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaFechaReserva_N") )
            {
               gxTv_SdtCita_Citafechareserva_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaLog_N") )
            {
               gxTv_SdtCita_Citalog_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaEmailGenLink_N") )
            {
               gxTv_SdtCita_Citaemailgenlink_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaEstado_N") )
            {
               gxTv_SdtCita_Citaestado_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaMotivoConsulta_N") )
            {
               gxTv_SdtCita_Citamotivoconsulta_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaArchivoNombre_N") )
            {
               gxTv_SdtCita_Citaarchivonombre_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaArchivo_N") )
            {
               gxTv_SdtCita_Citaarchivo_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaArchivoExtencion_N") )
            {
               gxTv_SdtCita_Citaarchivoextencion_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaConsentimiento_N") )
            {
               gxTv_SdtCita_Citaconsentimiento_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaGestante_N") )
            {
               gxTv_SdtCita_Citagestante_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaEstadoPago_N") )
            {
               gxTv_SdtCita_Citaestadopago_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaPeso_N") )
            {
               gxTv_SdtCita_Citapeso_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaEstatura_N") )
            {
               gxTv_SdtCita_Citaestatura_N = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "Cita" ;
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
      oWriter.writeElement("CitaId", GXutil.trim( GXutil.str( gxTv_SdtCita_Citaid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaCode", GXutil.rtrim( gxTv_SdtCita_Citacode));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteId", GXutil.trim( GXutil.str( gxTv_SdtCita_Pacienteid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteApellidoPaterno", GXutil.rtrim( gxTv_SdtCita_Pacienteapellidopaterno));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteApellidoMaterno", GXutil.rtrim( gxTv_SdtCita_Pacienteapellidomaterno));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteNombres", GXutil.rtrim( gxTv_SdtCita_Pacientenombres));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteNroDocumento", GXutil.rtrim( gxTv_SdtCita_Pacientenrodocumento));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaTipoDiagnostico", GXutil.rtrim( gxTv_SdtCita_Citatipodiagnostico));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGCitaDisponibilidadId", GXutil.trim( GXutil.str( gxTv_SdtCita_Sgcitadisponibilidadid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtCita_Sgcitadisponibilidadfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtCita_Sgcitadisponibilidadfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtCita_Sgcitadisponibilidadfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("SGCitaDisponibilidadFecha", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtCita_Sgcitadisponibilidadhorainicio), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtCita_Sgcitadisponibilidadhorainicio), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtCita_Sgcitadisponibilidadhorainicio), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtCita_Sgcitadisponibilidadhorainicio), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtCita_Sgcitadisponibilidadhorainicio), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtCita_Sgcitadisponibilidadhorainicio), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("SGCitaDisponibilidadHoraInicio", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtCita_Sgcitadisponibilidadhorafin), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtCita_Sgcitadisponibilidadhorafin), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtCita_Sgcitadisponibilidadhorafin), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtCita_Sgcitadisponibilidadhorafin), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtCita_Sgcitadisponibilidadhorafin), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtCita_Sgcitadisponibilidadhorafin), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("SGCitaDisponibilidadHoraFin", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGCitaDisponibilidadEspecialidadId", GXutil.trim( GXutil.str( gxTv_SdtCita_Sgcitadisponibilidadespecialidadid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGCitaDisponibilidadEspecialidadNombre", GXutil.rtrim( gxTv_SdtCita_Sgcitadisponibilidadespecialidadnombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGCitaDisponibilidadSedeId", GXutil.trim( GXutil.str( gxTv_SdtCita_Sgcitadisponibilidadsedeid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGCitaDisponibilidadSedeNombre", GXutil.rtrim( gxTv_SdtCita_Sgcitadisponibilidadsedenombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGCitaDisponibilidadClinicaId", GXutil.trim( GXutil.str( gxTv_SdtCita_Sgcitadisponibilidadclinicaid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGCitaDisponibilidadClinicaNombre", GXutil.rtrim( gxTv_SdtCita_Sgcitadisponibilidadclinicanombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGCitaDisponibilidadProfesionalId", GXutil.trim( GXutil.str( gxTv_SdtCita_Sgcitadisponibilidadprofesionalid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGCitaDisponibilidadProFullName", GXutil.rtrim( gxTv_SdtCita_Sgcitadisponibilidadprofullname));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGCitaDisponibilidadProCOP", GXutil.rtrim( gxTv_SdtCita_Sgcitadisponibilidadprocop));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaEstadoCita", GXutil.rtrim( gxTv_SdtCita_Citaestadocita));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaInforme", GXutil.rtrim( gxTv_SdtCita_Citainforme));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaAntecedentes", GXutil.rtrim( gxTv_SdtCita_Citaantecedentes));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaLink", GXutil.rtrim( gxTv_SdtCita_Citalink));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtCita_Citafechareserva), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtCita_Citafechareserva), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtCita_Citafechareserva), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtCita_Citafechareserva), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtCita_Citafechareserva), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtCita_Citafechareserva), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("CitaFechaReserva", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaLog", GXutil.rtrim( gxTv_SdtCita_Citalog));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaEmailGenLink", GXutil.rtrim( gxTv_SdtCita_Citaemailgenlink));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaEstado", GXutil.rtrim( gxTv_SdtCita_Citaestado));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaMotivoConsulta", GXutil.rtrim( gxTv_SdtCita_Citamotivoconsulta));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaArchivoNombre", GXutil.rtrim( gxTv_SdtCita_Citaarchivonombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaArchivo", GXutil.blobToBase64( gxTv_SdtCita_Citaarchivo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaArchivoExtencion", GXutil.rtrim( gxTv_SdtCita_Citaarchivoextencion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaConsentimiento", GXutil.rtrim( GXutil.booltostr( gxTv_SdtCita_Citaconsentimiento)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaGestante", GXutil.rtrim( GXutil.booltostr( gxTv_SdtCita_Citagestante)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaEstadoPago", GXutil.rtrim( gxTv_SdtCita_Citaestadopago));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaPeso", GXutil.trim( GXutil.strNoRound( gxTv_SdtCita_Citapeso, 6, 2)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaEstatura", GXutil.trim( GXutil.strNoRound( gxTv_SdtCita_Citaestatura, 4, 2)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", GXutil.rtrim( gxTv_SdtCita_Mode));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtCita_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaId_Z", GXutil.trim( GXutil.str( gxTv_SdtCita_Citaid_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaCode_Z", GXutil.rtrim( gxTv_SdtCita_Citacode_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PacienteId_Z", GXutil.trim( GXutil.str( gxTv_SdtCita_Pacienteid_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PacienteApellidoPaterno_Z", GXutil.rtrim( gxTv_SdtCita_Pacienteapellidopaterno_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PacienteApellidoMaterno_Z", GXutil.rtrim( gxTv_SdtCita_Pacienteapellidomaterno_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PacienteNombres_Z", GXutil.rtrim( gxTv_SdtCita_Pacientenombres_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PacienteNroDocumento_Z", GXutil.rtrim( gxTv_SdtCita_Pacientenrodocumento_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaTipoDiagnostico_Z", GXutil.rtrim( gxTv_SdtCita_Citatipodiagnostico_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SGCitaDisponibilidadId_Z", GXutil.trim( GXutil.str( gxTv_SdtCita_Sgcitadisponibilidadid_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtCita_Sgcitadisponibilidadfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtCita_Sgcitadisponibilidadfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtCita_Sgcitadisponibilidadfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("SGCitaDisponibilidadFecha_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtCita_Sgcitadisponibilidadhorainicio_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtCita_Sgcitadisponibilidadhorainicio_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtCita_Sgcitadisponibilidadhorainicio_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtCita_Sgcitadisponibilidadhorainicio_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtCita_Sgcitadisponibilidadhorainicio_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtCita_Sgcitadisponibilidadhorainicio_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("SGCitaDisponibilidadHoraInicio_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtCita_Sgcitadisponibilidadhorafin_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtCita_Sgcitadisponibilidadhorafin_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtCita_Sgcitadisponibilidadhorafin_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtCita_Sgcitadisponibilidadhorafin_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtCita_Sgcitadisponibilidadhorafin_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtCita_Sgcitadisponibilidadhorafin_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("SGCitaDisponibilidadHoraFin_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SGCitaDisponibilidadEspecialidadId_Z", GXutil.trim( GXutil.str( gxTv_SdtCita_Sgcitadisponibilidadespecialidadid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SGCitaDisponibilidadEspecialidadNombre_Z", GXutil.rtrim( gxTv_SdtCita_Sgcitadisponibilidadespecialidadnombre_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SGCitaDisponibilidadSedeId_Z", GXutil.trim( GXutil.str( gxTv_SdtCita_Sgcitadisponibilidadsedeid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SGCitaDisponibilidadSedeNombre_Z", GXutil.rtrim( gxTv_SdtCita_Sgcitadisponibilidadsedenombre_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SGCitaDisponibilidadClinicaId_Z", GXutil.trim( GXutil.str( gxTv_SdtCita_Sgcitadisponibilidadclinicaid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SGCitaDisponibilidadClinicaNombre_Z", GXutil.rtrim( gxTv_SdtCita_Sgcitadisponibilidadclinicanombre_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SGCitaDisponibilidadProfesionalId_Z", GXutil.trim( GXutil.str( gxTv_SdtCita_Sgcitadisponibilidadprofesionalid_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SGCitaDisponibilidadProFullName_Z", GXutil.rtrim( gxTv_SdtCita_Sgcitadisponibilidadprofullname_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SGCitaDisponibilidadProCOP_Z", GXutil.rtrim( gxTv_SdtCita_Sgcitadisponibilidadprocop_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaEstadoCita_Z", GXutil.rtrim( gxTv_SdtCita_Citaestadocita_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaLink_Z", GXutil.rtrim( gxTv_SdtCita_Citalink_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtCita_Citafechareserva_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtCita_Citafechareserva_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtCita_Citafechareserva_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtCita_Citafechareserva_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtCita_Citafechareserva_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtCita_Citafechareserva_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("CitaFechaReserva_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaLog_Z", GXutil.rtrim( gxTv_SdtCita_Citalog_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaEmailGenLink_Z", GXutil.rtrim( gxTv_SdtCita_Citaemailgenlink_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaEstado_Z", GXutil.rtrim( gxTv_SdtCita_Citaestado_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaArchivoNombre_Z", GXutil.rtrim( gxTv_SdtCita_Citaarchivonombre_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaArchivoExtencion_Z", GXutil.rtrim( gxTv_SdtCita_Citaarchivoextencion_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaConsentimiento_Z", GXutil.rtrim( GXutil.booltostr( gxTv_SdtCita_Citaconsentimiento_Z)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaGestante_Z", GXutil.rtrim( GXutil.booltostr( gxTv_SdtCita_Citagestante_Z)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaEstadoPago_Z", GXutil.rtrim( gxTv_SdtCita_Citaestadopago_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaPeso_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtCita_Citapeso_Z, 6, 2)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaEstatura_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtCita_Citaestatura_Z, 4, 2)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaId_N", GXutil.trim( GXutil.str( gxTv_SdtCita_Citaid_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaTipoDiagnostico_N", GXutil.trim( GXutil.str( gxTv_SdtCita_Citatipodiagnostico_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SGCitaDisponibilidadFecha_N", GXutil.trim( GXutil.str( gxTv_SdtCita_Sgcitadisponibilidadfecha_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SGCitaDisponibilidadHoraInicio_N", GXutil.trim( GXutil.str( gxTv_SdtCita_Sgcitadisponibilidadhorainicio_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SGCitaDisponibilidadHoraFin_N", GXutil.trim( GXutil.str( gxTv_SdtCita_Sgcitadisponibilidadhorafin_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaEstadoCita_N", GXutil.trim( GXutil.str( gxTv_SdtCita_Citaestadocita_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaInforme_N", GXutil.trim( GXutil.str( gxTv_SdtCita_Citainforme_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaAntecedentes_N", GXutil.trim( GXutil.str( gxTv_SdtCita_Citaantecedentes_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaLink_N", GXutil.trim( GXutil.str( gxTv_SdtCita_Citalink_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaFechaReserva_N", GXutil.trim( GXutil.str( gxTv_SdtCita_Citafechareserva_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaLog_N", GXutil.trim( GXutil.str( gxTv_SdtCita_Citalog_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaEmailGenLink_N", GXutil.trim( GXutil.str( gxTv_SdtCita_Citaemailgenlink_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaEstado_N", GXutil.trim( GXutil.str( gxTv_SdtCita_Citaestado_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaMotivoConsulta_N", GXutil.trim( GXutil.str( gxTv_SdtCita_Citamotivoconsulta_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaArchivoNombre_N", GXutil.trim( GXutil.str( gxTv_SdtCita_Citaarchivonombre_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaArchivo_N", GXutil.trim( GXutil.str( gxTv_SdtCita_Citaarchivo_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaArchivoExtencion_N", GXutil.trim( GXutil.str( gxTv_SdtCita_Citaarchivoextencion_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaConsentimiento_N", GXutil.trim( GXutil.str( gxTv_SdtCita_Citaconsentimiento_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaGestante_N", GXutil.trim( GXutil.str( gxTv_SdtCita_Citagestante_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaEstadoPago_N", GXutil.trim( GXutil.str( gxTv_SdtCita_Citaestadopago_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaPeso_N", GXutil.trim( GXutil.str( gxTv_SdtCita_Citapeso_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaEstatura_N", GXutil.trim( GXutil.str( gxTv_SdtCita_Citaestatura_N, 1, 0)));
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
      AddObjectProperty("CitaId", gxTv_SdtCita_Citaid, false, includeNonInitialized);
      AddObjectProperty("CitaId_N", gxTv_SdtCita_Citaid_N, false, includeNonInitialized);
      AddObjectProperty("CitaCode", gxTv_SdtCita_Citacode, false, includeNonInitialized);
      AddObjectProperty("PacienteId", gxTv_SdtCita_Pacienteid, false, includeNonInitialized);
      AddObjectProperty("PacienteApellidoPaterno", gxTv_SdtCita_Pacienteapellidopaterno, false, includeNonInitialized);
      AddObjectProperty("PacienteApellidoMaterno", gxTv_SdtCita_Pacienteapellidomaterno, false, includeNonInitialized);
      AddObjectProperty("PacienteNombres", gxTv_SdtCita_Pacientenombres, false, includeNonInitialized);
      AddObjectProperty("PacienteNroDocumento", gxTv_SdtCita_Pacientenrodocumento, false, includeNonInitialized);
      AddObjectProperty("CitaTipoDiagnostico", gxTv_SdtCita_Citatipodiagnostico, false, includeNonInitialized);
      AddObjectProperty("CitaTipoDiagnostico_N", gxTv_SdtCita_Citatipodiagnostico_N, false, includeNonInitialized);
      AddObjectProperty("SGCitaDisponibilidadId", gxTv_SdtCita_Sgcitadisponibilidadid, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtCita_Sgcitadisponibilidadfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtCita_Sgcitadisponibilidadfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtCita_Sgcitadisponibilidadfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("SGCitaDisponibilidadFecha", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("SGCitaDisponibilidadFecha_N", gxTv_SdtCita_Sgcitadisponibilidadfecha_N, false, includeNonInitialized);
      datetime_STZ = gxTv_SdtCita_Sgcitadisponibilidadhorainicio ;
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
      AddObjectProperty("SGCitaDisponibilidadHoraInicio", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("SGCitaDisponibilidadHoraInicio_N", gxTv_SdtCita_Sgcitadisponibilidadhorainicio_N, false, includeNonInitialized);
      datetime_STZ = gxTv_SdtCita_Sgcitadisponibilidadhorafin ;
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
      AddObjectProperty("SGCitaDisponibilidadHoraFin", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("SGCitaDisponibilidadHoraFin_N", gxTv_SdtCita_Sgcitadisponibilidadhorafin_N, false, includeNonInitialized);
      AddObjectProperty("SGCitaDisponibilidadEspecialidadId", gxTv_SdtCita_Sgcitadisponibilidadespecialidadid, false, includeNonInitialized);
      AddObjectProperty("SGCitaDisponibilidadEspecialidadNombre", gxTv_SdtCita_Sgcitadisponibilidadespecialidadnombre, false, includeNonInitialized);
      AddObjectProperty("SGCitaDisponibilidadSedeId", gxTv_SdtCita_Sgcitadisponibilidadsedeid, false, includeNonInitialized);
      AddObjectProperty("SGCitaDisponibilidadSedeNombre", gxTv_SdtCita_Sgcitadisponibilidadsedenombre, false, includeNonInitialized);
      AddObjectProperty("SGCitaDisponibilidadClinicaId", gxTv_SdtCita_Sgcitadisponibilidadclinicaid, false, includeNonInitialized);
      AddObjectProperty("SGCitaDisponibilidadClinicaNombre", gxTv_SdtCita_Sgcitadisponibilidadclinicanombre, false, includeNonInitialized);
      AddObjectProperty("SGCitaDisponibilidadProfesionalId", gxTv_SdtCita_Sgcitadisponibilidadprofesionalid, false, includeNonInitialized);
      AddObjectProperty("SGCitaDisponibilidadProFullName", gxTv_SdtCita_Sgcitadisponibilidadprofullname, false, includeNonInitialized);
      AddObjectProperty("SGCitaDisponibilidadProCOP", gxTv_SdtCita_Sgcitadisponibilidadprocop, false, includeNonInitialized);
      AddObjectProperty("CitaEstadoCita", gxTv_SdtCita_Citaestadocita, false, includeNonInitialized);
      AddObjectProperty("CitaEstadoCita_N", gxTv_SdtCita_Citaestadocita_N, false, includeNonInitialized);
      AddObjectProperty("CitaInforme", gxTv_SdtCita_Citainforme, false, includeNonInitialized);
      AddObjectProperty("CitaInforme_N", gxTv_SdtCita_Citainforme_N, false, includeNonInitialized);
      AddObjectProperty("CitaAntecedentes", gxTv_SdtCita_Citaantecedentes, false, includeNonInitialized);
      AddObjectProperty("CitaAntecedentes_N", gxTv_SdtCita_Citaantecedentes_N, false, includeNonInitialized);
      AddObjectProperty("CitaLink", gxTv_SdtCita_Citalink, false, includeNonInitialized);
      AddObjectProperty("CitaLink_N", gxTv_SdtCita_Citalink_N, false, includeNonInitialized);
      datetime_STZ = gxTv_SdtCita_Citafechareserva ;
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
      AddObjectProperty("CitaFechaReserva", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("CitaFechaReserva_N", gxTv_SdtCita_Citafechareserva_N, false, includeNonInitialized);
      AddObjectProperty("CitaLog", gxTv_SdtCita_Citalog, false, includeNonInitialized);
      AddObjectProperty("CitaLog_N", gxTv_SdtCita_Citalog_N, false, includeNonInitialized);
      AddObjectProperty("CitaEmailGenLink", gxTv_SdtCita_Citaemailgenlink, false, includeNonInitialized);
      AddObjectProperty("CitaEmailGenLink_N", gxTv_SdtCita_Citaemailgenlink_N, false, includeNonInitialized);
      AddObjectProperty("CitaEstado", gxTv_SdtCita_Citaestado, false, includeNonInitialized);
      AddObjectProperty("CitaEstado_N", gxTv_SdtCita_Citaestado_N, false, includeNonInitialized);
      AddObjectProperty("CitaMotivoConsulta", gxTv_SdtCita_Citamotivoconsulta, false, includeNonInitialized);
      AddObjectProperty("CitaMotivoConsulta_N", gxTv_SdtCita_Citamotivoconsulta_N, false, includeNonInitialized);
      AddObjectProperty("CitaArchivoNombre", gxTv_SdtCita_Citaarchivonombre, false, includeNonInitialized);
      AddObjectProperty("CitaArchivoNombre_N", gxTv_SdtCita_Citaarchivonombre_N, false, includeNonInitialized);
      AddObjectProperty("CitaArchivo", gxTv_SdtCita_Citaarchivo, false, includeNonInitialized);
      AddObjectProperty("CitaArchivo_N", gxTv_SdtCita_Citaarchivo_N, false, includeNonInitialized);
      AddObjectProperty("CitaArchivoExtencion", gxTv_SdtCita_Citaarchivoextencion, false, includeNonInitialized);
      AddObjectProperty("CitaArchivoExtencion_N", gxTv_SdtCita_Citaarchivoextencion_N, false, includeNonInitialized);
      AddObjectProperty("CitaConsentimiento", gxTv_SdtCita_Citaconsentimiento, false, includeNonInitialized);
      AddObjectProperty("CitaConsentimiento_N", gxTv_SdtCita_Citaconsentimiento_N, false, includeNonInitialized);
      AddObjectProperty("CitaGestante", gxTv_SdtCita_Citagestante, false, includeNonInitialized);
      AddObjectProperty("CitaGestante_N", gxTv_SdtCita_Citagestante_N, false, includeNonInitialized);
      AddObjectProperty("CitaEstadoPago", gxTv_SdtCita_Citaestadopago, false, includeNonInitialized);
      AddObjectProperty("CitaEstadoPago_N", gxTv_SdtCita_Citaestadopago_N, false, includeNonInitialized);
      AddObjectProperty("CitaPeso", gxTv_SdtCita_Citapeso, false, includeNonInitialized);
      AddObjectProperty("CitaPeso_N", gxTv_SdtCita_Citapeso_N, false, includeNonInitialized);
      AddObjectProperty("CitaEstatura", gxTv_SdtCita_Citaestatura, false, includeNonInitialized);
      AddObjectProperty("CitaEstatura_N", gxTv_SdtCita_Citaestatura_N, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtCita_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtCita_Initialized, false, includeNonInitialized);
         AddObjectProperty("CitaId_Z", gxTv_SdtCita_Citaid_Z, false, includeNonInitialized);
         AddObjectProperty("CitaCode_Z", gxTv_SdtCita_Citacode_Z, false, includeNonInitialized);
         AddObjectProperty("PacienteId_Z", gxTv_SdtCita_Pacienteid_Z, false, includeNonInitialized);
         AddObjectProperty("PacienteApellidoPaterno_Z", gxTv_SdtCita_Pacienteapellidopaterno_Z, false, includeNonInitialized);
         AddObjectProperty("PacienteApellidoMaterno_Z", gxTv_SdtCita_Pacienteapellidomaterno_Z, false, includeNonInitialized);
         AddObjectProperty("PacienteNombres_Z", gxTv_SdtCita_Pacientenombres_Z, false, includeNonInitialized);
         AddObjectProperty("PacienteNroDocumento_Z", gxTv_SdtCita_Pacientenrodocumento_Z, false, includeNonInitialized);
         AddObjectProperty("CitaTipoDiagnostico_Z", gxTv_SdtCita_Citatipodiagnostico_Z, false, includeNonInitialized);
         AddObjectProperty("SGCitaDisponibilidadId_Z", gxTv_SdtCita_Sgcitadisponibilidadid_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtCita_Sgcitadisponibilidadfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtCita_Sgcitadisponibilidadfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtCita_Sgcitadisponibilidadfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("SGCitaDisponibilidadFecha_Z", sDateCnv, false, includeNonInitialized);
         datetime_STZ = gxTv_SdtCita_Sgcitadisponibilidadhorainicio_Z ;
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
         AddObjectProperty("SGCitaDisponibilidadHoraInicio_Z", sDateCnv, false, includeNonInitialized);
         datetime_STZ = gxTv_SdtCita_Sgcitadisponibilidadhorafin_Z ;
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
         AddObjectProperty("SGCitaDisponibilidadHoraFin_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("SGCitaDisponibilidadEspecialidadId_Z", gxTv_SdtCita_Sgcitadisponibilidadespecialidadid_Z, false, includeNonInitialized);
         AddObjectProperty("SGCitaDisponibilidadEspecialidadNombre_Z", gxTv_SdtCita_Sgcitadisponibilidadespecialidadnombre_Z, false, includeNonInitialized);
         AddObjectProperty("SGCitaDisponibilidadSedeId_Z", gxTv_SdtCita_Sgcitadisponibilidadsedeid_Z, false, includeNonInitialized);
         AddObjectProperty("SGCitaDisponibilidadSedeNombre_Z", gxTv_SdtCita_Sgcitadisponibilidadsedenombre_Z, false, includeNonInitialized);
         AddObjectProperty("SGCitaDisponibilidadClinicaId_Z", gxTv_SdtCita_Sgcitadisponibilidadclinicaid_Z, false, includeNonInitialized);
         AddObjectProperty("SGCitaDisponibilidadClinicaNombre_Z", gxTv_SdtCita_Sgcitadisponibilidadclinicanombre_Z, false, includeNonInitialized);
         AddObjectProperty("SGCitaDisponibilidadProfesionalId_Z", gxTv_SdtCita_Sgcitadisponibilidadprofesionalid_Z, false, includeNonInitialized);
         AddObjectProperty("SGCitaDisponibilidadProFullName_Z", gxTv_SdtCita_Sgcitadisponibilidadprofullname_Z, false, includeNonInitialized);
         AddObjectProperty("SGCitaDisponibilidadProCOP_Z", gxTv_SdtCita_Sgcitadisponibilidadprocop_Z, false, includeNonInitialized);
         AddObjectProperty("CitaEstadoCita_Z", gxTv_SdtCita_Citaestadocita_Z, false, includeNonInitialized);
         AddObjectProperty("CitaLink_Z", gxTv_SdtCita_Citalink_Z, false, includeNonInitialized);
         datetime_STZ = gxTv_SdtCita_Citafechareserva_Z ;
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
         AddObjectProperty("CitaFechaReserva_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("CitaLog_Z", gxTv_SdtCita_Citalog_Z, false, includeNonInitialized);
         AddObjectProperty("CitaEmailGenLink_Z", gxTv_SdtCita_Citaemailgenlink_Z, false, includeNonInitialized);
         AddObjectProperty("CitaEstado_Z", gxTv_SdtCita_Citaestado_Z, false, includeNonInitialized);
         AddObjectProperty("CitaArchivoNombre_Z", gxTv_SdtCita_Citaarchivonombre_Z, false, includeNonInitialized);
         AddObjectProperty("CitaArchivoExtencion_Z", gxTv_SdtCita_Citaarchivoextencion_Z, false, includeNonInitialized);
         AddObjectProperty("CitaConsentimiento_Z", gxTv_SdtCita_Citaconsentimiento_Z, false, includeNonInitialized);
         AddObjectProperty("CitaGestante_Z", gxTv_SdtCita_Citagestante_Z, false, includeNonInitialized);
         AddObjectProperty("CitaEstadoPago_Z", gxTv_SdtCita_Citaestadopago_Z, false, includeNonInitialized);
         AddObjectProperty("CitaPeso_Z", gxTv_SdtCita_Citapeso_Z, false, includeNonInitialized);
         AddObjectProperty("CitaEstatura_Z", gxTv_SdtCita_Citaestatura_Z, false, includeNonInitialized);
         AddObjectProperty("CitaId_N", gxTv_SdtCita_Citaid_N, false, includeNonInitialized);
         AddObjectProperty("CitaTipoDiagnostico_N", gxTv_SdtCita_Citatipodiagnostico_N, false, includeNonInitialized);
         AddObjectProperty("SGCitaDisponibilidadFecha_N", gxTv_SdtCita_Sgcitadisponibilidadfecha_N, false, includeNonInitialized);
         AddObjectProperty("SGCitaDisponibilidadHoraInicio_N", gxTv_SdtCita_Sgcitadisponibilidadhorainicio_N, false, includeNonInitialized);
         AddObjectProperty("SGCitaDisponibilidadHoraFin_N", gxTv_SdtCita_Sgcitadisponibilidadhorafin_N, false, includeNonInitialized);
         AddObjectProperty("CitaEstadoCita_N", gxTv_SdtCita_Citaestadocita_N, false, includeNonInitialized);
         AddObjectProperty("CitaInforme_N", gxTv_SdtCita_Citainforme_N, false, includeNonInitialized);
         AddObjectProperty("CitaAntecedentes_N", gxTv_SdtCita_Citaantecedentes_N, false, includeNonInitialized);
         AddObjectProperty("CitaLink_N", gxTv_SdtCita_Citalink_N, false, includeNonInitialized);
         AddObjectProperty("CitaFechaReserva_N", gxTv_SdtCita_Citafechareserva_N, false, includeNonInitialized);
         AddObjectProperty("CitaLog_N", gxTv_SdtCita_Citalog_N, false, includeNonInitialized);
         AddObjectProperty("CitaEmailGenLink_N", gxTv_SdtCita_Citaemailgenlink_N, false, includeNonInitialized);
         AddObjectProperty("CitaEstado_N", gxTv_SdtCita_Citaestado_N, false, includeNonInitialized);
         AddObjectProperty("CitaMotivoConsulta_N", gxTv_SdtCita_Citamotivoconsulta_N, false, includeNonInitialized);
         AddObjectProperty("CitaArchivoNombre_N", gxTv_SdtCita_Citaarchivonombre_N, false, includeNonInitialized);
         AddObjectProperty("CitaArchivo_N", gxTv_SdtCita_Citaarchivo_N, false, includeNonInitialized);
         AddObjectProperty("CitaArchivoExtencion_N", gxTv_SdtCita_Citaarchivoextencion_N, false, includeNonInitialized);
         AddObjectProperty("CitaConsentimiento_N", gxTv_SdtCita_Citaconsentimiento_N, false, includeNonInitialized);
         AddObjectProperty("CitaGestante_N", gxTv_SdtCita_Citagestante_N, false, includeNonInitialized);
         AddObjectProperty("CitaEstadoPago_N", gxTv_SdtCita_Citaestadopago_N, false, includeNonInitialized);
         AddObjectProperty("CitaPeso_N", gxTv_SdtCita_Citapeso_N, false, includeNonInitialized);
         AddObjectProperty("CitaEstatura_N", gxTv_SdtCita_Citaestatura_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.projectthani.SdtCita sdt )
   {
      if ( sdt.IsDirty("CitaId") )
      {
         gxTv_SdtCita_N = (byte)(0) ;
         gxTv_SdtCita_Citaid = sdt.getgxTv_SdtCita_Citaid() ;
      }
      if ( sdt.IsDirty("CitaCode") )
      {
         gxTv_SdtCita_N = (byte)(0) ;
         gxTv_SdtCita_Citacode = sdt.getgxTv_SdtCita_Citacode() ;
      }
      if ( sdt.IsDirty("PacienteId") )
      {
         gxTv_SdtCita_N = (byte)(0) ;
         gxTv_SdtCita_Pacienteid = sdt.getgxTv_SdtCita_Pacienteid() ;
      }
      if ( sdt.IsDirty("PacienteApellidoPaterno") )
      {
         gxTv_SdtCita_N = (byte)(0) ;
         gxTv_SdtCita_Pacienteapellidopaterno = sdt.getgxTv_SdtCita_Pacienteapellidopaterno() ;
      }
      if ( sdt.IsDirty("PacienteApellidoMaterno") )
      {
         gxTv_SdtCita_N = (byte)(0) ;
         gxTv_SdtCita_Pacienteapellidomaterno = sdt.getgxTv_SdtCita_Pacienteapellidomaterno() ;
      }
      if ( sdt.IsDirty("PacienteNombres") )
      {
         gxTv_SdtCita_N = (byte)(0) ;
         gxTv_SdtCita_Pacientenombres = sdt.getgxTv_SdtCita_Pacientenombres() ;
      }
      if ( sdt.IsDirty("PacienteNroDocumento") )
      {
         gxTv_SdtCita_N = (byte)(0) ;
         gxTv_SdtCita_Pacientenrodocumento = sdt.getgxTv_SdtCita_Pacientenrodocumento() ;
      }
      if ( sdt.IsDirty("CitaTipoDiagnostico") )
      {
         gxTv_SdtCita_Citatipodiagnostico_N = (byte)(0) ;
         gxTv_SdtCita_N = (byte)(0) ;
         gxTv_SdtCita_Citatipodiagnostico = sdt.getgxTv_SdtCita_Citatipodiagnostico() ;
      }
      if ( sdt.IsDirty("SGCitaDisponibilidadId") )
      {
         gxTv_SdtCita_N = (byte)(0) ;
         gxTv_SdtCita_Sgcitadisponibilidadid = sdt.getgxTv_SdtCita_Sgcitadisponibilidadid() ;
      }
      if ( sdt.IsDirty("SGCitaDisponibilidadFecha") )
      {
         gxTv_SdtCita_Sgcitadisponibilidadfecha_N = (byte)(0) ;
         gxTv_SdtCita_N = (byte)(0) ;
         gxTv_SdtCita_Sgcitadisponibilidadfecha = sdt.getgxTv_SdtCita_Sgcitadisponibilidadfecha() ;
      }
      if ( sdt.IsDirty("SGCitaDisponibilidadHoraInicio") )
      {
         gxTv_SdtCita_Sgcitadisponibilidadhorainicio_N = (byte)(0) ;
         gxTv_SdtCita_N = (byte)(0) ;
         gxTv_SdtCita_Sgcitadisponibilidadhorainicio = sdt.getgxTv_SdtCita_Sgcitadisponibilidadhorainicio() ;
      }
      if ( sdt.IsDirty("SGCitaDisponibilidadHoraFin") )
      {
         gxTv_SdtCita_Sgcitadisponibilidadhorafin_N = (byte)(0) ;
         gxTv_SdtCita_N = (byte)(0) ;
         gxTv_SdtCita_Sgcitadisponibilidadhorafin = sdt.getgxTv_SdtCita_Sgcitadisponibilidadhorafin() ;
      }
      if ( sdt.IsDirty("SGCitaDisponibilidadEspecialidadId") )
      {
         gxTv_SdtCita_N = (byte)(0) ;
         gxTv_SdtCita_Sgcitadisponibilidadespecialidadid = sdt.getgxTv_SdtCita_Sgcitadisponibilidadespecialidadid() ;
      }
      if ( sdt.IsDirty("SGCitaDisponibilidadEspecialidadNombre") )
      {
         gxTv_SdtCita_N = (byte)(0) ;
         gxTv_SdtCita_Sgcitadisponibilidadespecialidadnombre = sdt.getgxTv_SdtCita_Sgcitadisponibilidadespecialidadnombre() ;
      }
      if ( sdt.IsDirty("SGCitaDisponibilidadSedeId") )
      {
         gxTv_SdtCita_N = (byte)(0) ;
         gxTv_SdtCita_Sgcitadisponibilidadsedeid = sdt.getgxTv_SdtCita_Sgcitadisponibilidadsedeid() ;
      }
      if ( sdt.IsDirty("SGCitaDisponibilidadSedeNombre") )
      {
         gxTv_SdtCita_N = (byte)(0) ;
         gxTv_SdtCita_Sgcitadisponibilidadsedenombre = sdt.getgxTv_SdtCita_Sgcitadisponibilidadsedenombre() ;
      }
      if ( sdt.IsDirty("SGCitaDisponibilidadClinicaId") )
      {
         gxTv_SdtCita_N = (byte)(0) ;
         gxTv_SdtCita_Sgcitadisponibilidadclinicaid = sdt.getgxTv_SdtCita_Sgcitadisponibilidadclinicaid() ;
      }
      if ( sdt.IsDirty("SGCitaDisponibilidadClinicaNombre") )
      {
         gxTv_SdtCita_N = (byte)(0) ;
         gxTv_SdtCita_Sgcitadisponibilidadclinicanombre = sdt.getgxTv_SdtCita_Sgcitadisponibilidadclinicanombre() ;
      }
      if ( sdt.IsDirty("SGCitaDisponibilidadProfesionalId") )
      {
         gxTv_SdtCita_N = (byte)(0) ;
         gxTv_SdtCita_Sgcitadisponibilidadprofesionalid = sdt.getgxTv_SdtCita_Sgcitadisponibilidadprofesionalid() ;
      }
      if ( sdt.IsDirty("SGCitaDisponibilidadProFullName") )
      {
         gxTv_SdtCita_N = (byte)(0) ;
         gxTv_SdtCita_Sgcitadisponibilidadprofullname = sdt.getgxTv_SdtCita_Sgcitadisponibilidadprofullname() ;
      }
      if ( sdt.IsDirty("SGCitaDisponibilidadProCOP") )
      {
         gxTv_SdtCita_N = (byte)(0) ;
         gxTv_SdtCita_Sgcitadisponibilidadprocop = sdt.getgxTv_SdtCita_Sgcitadisponibilidadprocop() ;
      }
      if ( sdt.IsDirty("CitaEstadoCita") )
      {
         gxTv_SdtCita_Citaestadocita_N = (byte)(0) ;
         gxTv_SdtCita_N = (byte)(0) ;
         gxTv_SdtCita_Citaestadocita = sdt.getgxTv_SdtCita_Citaestadocita() ;
      }
      if ( sdt.IsDirty("CitaInforme") )
      {
         gxTv_SdtCita_Citainforme_N = (byte)(0) ;
         gxTv_SdtCita_N = (byte)(0) ;
         gxTv_SdtCita_Citainforme = sdt.getgxTv_SdtCita_Citainforme() ;
      }
      if ( sdt.IsDirty("CitaAntecedentes") )
      {
         gxTv_SdtCita_Citaantecedentes_N = (byte)(0) ;
         gxTv_SdtCita_N = (byte)(0) ;
         gxTv_SdtCita_Citaantecedentes = sdt.getgxTv_SdtCita_Citaantecedentes() ;
      }
      if ( sdt.IsDirty("CitaLink") )
      {
         gxTv_SdtCita_Citalink_N = (byte)(0) ;
         gxTv_SdtCita_N = (byte)(0) ;
         gxTv_SdtCita_Citalink = sdt.getgxTv_SdtCita_Citalink() ;
      }
      if ( sdt.IsDirty("CitaFechaReserva") )
      {
         gxTv_SdtCita_Citafechareserva_N = (byte)(0) ;
         gxTv_SdtCita_N = (byte)(0) ;
         gxTv_SdtCita_Citafechareserva = sdt.getgxTv_SdtCita_Citafechareserva() ;
      }
      if ( sdt.IsDirty("CitaLog") )
      {
         gxTv_SdtCita_Citalog_N = (byte)(0) ;
         gxTv_SdtCita_N = (byte)(0) ;
         gxTv_SdtCita_Citalog = sdt.getgxTv_SdtCita_Citalog() ;
      }
      if ( sdt.IsDirty("CitaEmailGenLink") )
      {
         gxTv_SdtCita_Citaemailgenlink_N = (byte)(0) ;
         gxTv_SdtCita_N = (byte)(0) ;
         gxTv_SdtCita_Citaemailgenlink = sdt.getgxTv_SdtCita_Citaemailgenlink() ;
      }
      if ( sdt.IsDirty("CitaEstado") )
      {
         gxTv_SdtCita_Citaestado_N = (byte)(0) ;
         gxTv_SdtCita_N = (byte)(0) ;
         gxTv_SdtCita_Citaestado = sdt.getgxTv_SdtCita_Citaestado() ;
      }
      if ( sdt.IsDirty("CitaMotivoConsulta") )
      {
         gxTv_SdtCita_Citamotivoconsulta_N = (byte)(0) ;
         gxTv_SdtCita_N = (byte)(0) ;
         gxTv_SdtCita_Citamotivoconsulta = sdt.getgxTv_SdtCita_Citamotivoconsulta() ;
      }
      if ( sdt.IsDirty("CitaArchivoNombre") )
      {
         gxTv_SdtCita_Citaarchivonombre_N = (byte)(0) ;
         gxTv_SdtCita_N = (byte)(0) ;
         gxTv_SdtCita_Citaarchivonombre = sdt.getgxTv_SdtCita_Citaarchivonombre() ;
      }
      if ( sdt.IsDirty("CitaArchivo") )
      {
         gxTv_SdtCita_Citaarchivo_N = (byte)(0) ;
         gxTv_SdtCita_N = (byte)(0) ;
         gxTv_SdtCita_Citaarchivo = sdt.getgxTv_SdtCita_Citaarchivo() ;
      }
      if ( sdt.IsDirty("CitaArchivoExtencion") )
      {
         gxTv_SdtCita_Citaarchivoextencion_N = (byte)(0) ;
         gxTv_SdtCita_N = (byte)(0) ;
         gxTv_SdtCita_Citaarchivoextencion = sdt.getgxTv_SdtCita_Citaarchivoextencion() ;
      }
      if ( sdt.IsDirty("CitaConsentimiento") )
      {
         gxTv_SdtCita_Citaconsentimiento_N = (byte)(0) ;
         gxTv_SdtCita_N = (byte)(0) ;
         gxTv_SdtCita_Citaconsentimiento = sdt.getgxTv_SdtCita_Citaconsentimiento() ;
      }
      if ( sdt.IsDirty("CitaGestante") )
      {
         gxTv_SdtCita_Citagestante_N = (byte)(0) ;
         gxTv_SdtCita_N = (byte)(0) ;
         gxTv_SdtCita_Citagestante = sdt.getgxTv_SdtCita_Citagestante() ;
      }
      if ( sdt.IsDirty("CitaEstadoPago") )
      {
         gxTv_SdtCita_Citaestadopago_N = (byte)(0) ;
         gxTv_SdtCita_N = (byte)(0) ;
         gxTv_SdtCita_Citaestadopago = sdt.getgxTv_SdtCita_Citaestadopago() ;
      }
      if ( sdt.IsDirty("CitaPeso") )
      {
         gxTv_SdtCita_Citapeso_N = (byte)(0) ;
         gxTv_SdtCita_N = (byte)(0) ;
         gxTv_SdtCita_Citapeso = sdt.getgxTv_SdtCita_Citapeso() ;
      }
      if ( sdt.IsDirty("CitaEstatura") )
      {
         gxTv_SdtCita_Citaestatura_N = (byte)(0) ;
         gxTv_SdtCita_N = (byte)(0) ;
         gxTv_SdtCita_Citaestatura = sdt.getgxTv_SdtCita_Citaestatura() ;
      }
   }

   public int getgxTv_SdtCita_Citaid( )
   {
      return gxTv_SdtCita_Citaid ;
   }

   public void setgxTv_SdtCita_Citaid( int value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      if ( gxTv_SdtCita_Citaid != value )
      {
         gxTv_SdtCita_Mode = "INS" ;
         this.setgxTv_SdtCita_Citaid_Z_SetNull( );
         this.setgxTv_SdtCita_Citacode_Z_SetNull( );
         this.setgxTv_SdtCita_Pacienteid_Z_SetNull( );
         this.setgxTv_SdtCita_Pacienteapellidopaterno_Z_SetNull( );
         this.setgxTv_SdtCita_Pacienteapellidomaterno_Z_SetNull( );
         this.setgxTv_SdtCita_Pacientenombres_Z_SetNull( );
         this.setgxTv_SdtCita_Pacientenrodocumento_Z_SetNull( );
         this.setgxTv_SdtCita_Citatipodiagnostico_Z_SetNull( );
         this.setgxTv_SdtCita_Sgcitadisponibilidadid_Z_SetNull( );
         this.setgxTv_SdtCita_Sgcitadisponibilidadfecha_Z_SetNull( );
         this.setgxTv_SdtCita_Sgcitadisponibilidadhorainicio_Z_SetNull( );
         this.setgxTv_SdtCita_Sgcitadisponibilidadhorafin_Z_SetNull( );
         this.setgxTv_SdtCita_Sgcitadisponibilidadespecialidadid_Z_SetNull( );
         this.setgxTv_SdtCita_Sgcitadisponibilidadespecialidadnombre_Z_SetNull( );
         this.setgxTv_SdtCita_Sgcitadisponibilidadsedeid_Z_SetNull( );
         this.setgxTv_SdtCita_Sgcitadisponibilidadsedenombre_Z_SetNull( );
         this.setgxTv_SdtCita_Sgcitadisponibilidadclinicaid_Z_SetNull( );
         this.setgxTv_SdtCita_Sgcitadisponibilidadclinicanombre_Z_SetNull( );
         this.setgxTv_SdtCita_Sgcitadisponibilidadprofesionalid_Z_SetNull( );
         this.setgxTv_SdtCita_Sgcitadisponibilidadprofullname_Z_SetNull( );
         this.setgxTv_SdtCita_Sgcitadisponibilidadprocop_Z_SetNull( );
         this.setgxTv_SdtCita_Citaestadocita_Z_SetNull( );
         this.setgxTv_SdtCita_Citalink_Z_SetNull( );
         this.setgxTv_SdtCita_Citafechareserva_Z_SetNull( );
         this.setgxTv_SdtCita_Citalog_Z_SetNull( );
         this.setgxTv_SdtCita_Citaemailgenlink_Z_SetNull( );
         this.setgxTv_SdtCita_Citaestado_Z_SetNull( );
         this.setgxTv_SdtCita_Citaarchivonombre_Z_SetNull( );
         this.setgxTv_SdtCita_Citaarchivoextencion_Z_SetNull( );
         this.setgxTv_SdtCita_Citaconsentimiento_Z_SetNull( );
         this.setgxTv_SdtCita_Citagestante_Z_SetNull( );
         this.setgxTv_SdtCita_Citaestadopago_Z_SetNull( );
         this.setgxTv_SdtCita_Citapeso_Z_SetNull( );
         this.setgxTv_SdtCita_Citaestatura_Z_SetNull( );
      }
      SetDirty("Citaid");
      gxTv_SdtCita_Citaid = value ;
   }

   public String getgxTv_SdtCita_Citacode( )
   {
      return gxTv_SdtCita_Citacode ;
   }

   public void setgxTv_SdtCita_Citacode( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citacode");
      gxTv_SdtCita_Citacode = value ;
   }

   public int getgxTv_SdtCita_Pacienteid( )
   {
      return gxTv_SdtCita_Pacienteid ;
   }

   public void setgxTv_SdtCita_Pacienteid( int value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Pacienteid");
      gxTv_SdtCita_Pacienteid = value ;
   }

   public String getgxTv_SdtCita_Pacienteapellidopaterno( )
   {
      return gxTv_SdtCita_Pacienteapellidopaterno ;
   }

   public void setgxTv_SdtCita_Pacienteapellidopaterno( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Pacienteapellidopaterno");
      gxTv_SdtCita_Pacienteapellidopaterno = value ;
   }

   public String getgxTv_SdtCita_Pacienteapellidomaterno( )
   {
      return gxTv_SdtCita_Pacienteapellidomaterno ;
   }

   public void setgxTv_SdtCita_Pacienteapellidomaterno( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Pacienteapellidomaterno");
      gxTv_SdtCita_Pacienteapellidomaterno = value ;
   }

   public String getgxTv_SdtCita_Pacientenombres( )
   {
      return gxTv_SdtCita_Pacientenombres ;
   }

   public void setgxTv_SdtCita_Pacientenombres( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Pacientenombres");
      gxTv_SdtCita_Pacientenombres = value ;
   }

   public String getgxTv_SdtCita_Pacientenrodocumento( )
   {
      return gxTv_SdtCita_Pacientenrodocumento ;
   }

   public void setgxTv_SdtCita_Pacientenrodocumento( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Pacientenrodocumento");
      gxTv_SdtCita_Pacientenrodocumento = value ;
   }

   public String getgxTv_SdtCita_Citatipodiagnostico( )
   {
      return gxTv_SdtCita_Citatipodiagnostico ;
   }

   public void setgxTv_SdtCita_Citatipodiagnostico( String value )
   {
      gxTv_SdtCita_Citatipodiagnostico_N = (byte)(0) ;
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citatipodiagnostico");
      gxTv_SdtCita_Citatipodiagnostico = value ;
   }

   public void setgxTv_SdtCita_Citatipodiagnostico_SetNull( )
   {
      gxTv_SdtCita_Citatipodiagnostico_N = (byte)(1) ;
      gxTv_SdtCita_Citatipodiagnostico = "" ;
   }

   public boolean getgxTv_SdtCita_Citatipodiagnostico_IsNull( )
   {
      return (gxTv_SdtCita_Citatipodiagnostico_N==1) ;
   }

   public int getgxTv_SdtCita_Sgcitadisponibilidadid( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadid ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadid( int value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadid");
      gxTv_SdtCita_Sgcitadisponibilidadid = value ;
   }

   public java.util.Date getgxTv_SdtCita_Sgcitadisponibilidadfecha( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadfecha ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadfecha( java.util.Date value )
   {
      gxTv_SdtCita_Sgcitadisponibilidadfecha_N = (byte)(0) ;
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadfecha");
      gxTv_SdtCita_Sgcitadisponibilidadfecha = value ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadfecha_SetNull( )
   {
      gxTv_SdtCita_Sgcitadisponibilidadfecha_N = (byte)(1) ;
      gxTv_SdtCita_Sgcitadisponibilidadfecha = GXutil.nullDate() ;
   }

   public boolean getgxTv_SdtCita_Sgcitadisponibilidadfecha_IsNull( )
   {
      return (gxTv_SdtCita_Sgcitadisponibilidadfecha_N==1) ;
   }

   public java.util.Date getgxTv_SdtCita_Sgcitadisponibilidadhorainicio( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadhorainicio ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadhorainicio( java.util.Date value )
   {
      gxTv_SdtCita_Sgcitadisponibilidadhorainicio_N = (byte)(0) ;
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadhorainicio");
      gxTv_SdtCita_Sgcitadisponibilidadhorainicio = value ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadhorainicio_SetNull( )
   {
      gxTv_SdtCita_Sgcitadisponibilidadhorainicio_N = (byte)(1) ;
      gxTv_SdtCita_Sgcitadisponibilidadhorainicio = GXutil.resetTime( GXutil.nullDate() );
   }

   public boolean getgxTv_SdtCita_Sgcitadisponibilidadhorainicio_IsNull( )
   {
      return (gxTv_SdtCita_Sgcitadisponibilidadhorainicio_N==1) ;
   }

   public java.util.Date getgxTv_SdtCita_Sgcitadisponibilidadhorafin( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadhorafin ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadhorafin( java.util.Date value )
   {
      gxTv_SdtCita_Sgcitadisponibilidadhorafin_N = (byte)(0) ;
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadhorafin");
      gxTv_SdtCita_Sgcitadisponibilidadhorafin = value ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadhorafin_SetNull( )
   {
      gxTv_SdtCita_Sgcitadisponibilidadhorafin_N = (byte)(1) ;
      gxTv_SdtCita_Sgcitadisponibilidadhorafin = GXutil.resetTime( GXutil.nullDate() );
   }

   public boolean getgxTv_SdtCita_Sgcitadisponibilidadhorafin_IsNull( )
   {
      return (gxTv_SdtCita_Sgcitadisponibilidadhorafin_N==1) ;
   }

   public short getgxTv_SdtCita_Sgcitadisponibilidadespecialidadid( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadespecialidadid ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadespecialidadid( short value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadespecialidadid");
      gxTv_SdtCita_Sgcitadisponibilidadespecialidadid = value ;
   }

   public String getgxTv_SdtCita_Sgcitadisponibilidadespecialidadnombre( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadespecialidadnombre ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadespecialidadnombre( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadespecialidadnombre");
      gxTv_SdtCita_Sgcitadisponibilidadespecialidadnombre = value ;
   }

   public short getgxTv_SdtCita_Sgcitadisponibilidadsedeid( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadsedeid ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadsedeid( short value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadsedeid");
      gxTv_SdtCita_Sgcitadisponibilidadsedeid = value ;
   }

   public String getgxTv_SdtCita_Sgcitadisponibilidadsedenombre( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadsedenombre ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadsedenombre( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadsedenombre");
      gxTv_SdtCita_Sgcitadisponibilidadsedenombre = value ;
   }

   public short getgxTv_SdtCita_Sgcitadisponibilidadclinicaid( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadclinicaid ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadclinicaid( short value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadclinicaid");
      gxTv_SdtCita_Sgcitadisponibilidadclinicaid = value ;
   }

   public String getgxTv_SdtCita_Sgcitadisponibilidadclinicanombre( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadclinicanombre ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadclinicanombre( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadclinicanombre");
      gxTv_SdtCita_Sgcitadisponibilidadclinicanombre = value ;
   }

   public int getgxTv_SdtCita_Sgcitadisponibilidadprofesionalid( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadprofesionalid ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadprofesionalid( int value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadprofesionalid");
      gxTv_SdtCita_Sgcitadisponibilidadprofesionalid = value ;
   }

   public String getgxTv_SdtCita_Sgcitadisponibilidadprofullname( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadprofullname ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadprofullname( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadprofullname");
      gxTv_SdtCita_Sgcitadisponibilidadprofullname = value ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadprofullname_SetNull( )
   {
      gxTv_SdtCita_Sgcitadisponibilidadprofullname = "" ;
   }

   public boolean getgxTv_SdtCita_Sgcitadisponibilidadprofullname_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtCita_Sgcitadisponibilidadprocop( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadprocop ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadprocop( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadprocop");
      gxTv_SdtCita_Sgcitadisponibilidadprocop = value ;
   }

   public String getgxTv_SdtCita_Citaestadocita( )
   {
      return gxTv_SdtCita_Citaestadocita ;
   }

   public void setgxTv_SdtCita_Citaestadocita( String value )
   {
      gxTv_SdtCita_Citaestadocita_N = (byte)(0) ;
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citaestadocita");
      gxTv_SdtCita_Citaestadocita = value ;
   }

   public void setgxTv_SdtCita_Citaestadocita_SetNull( )
   {
      gxTv_SdtCita_Citaestadocita_N = (byte)(1) ;
      gxTv_SdtCita_Citaestadocita = "" ;
   }

   public boolean getgxTv_SdtCita_Citaestadocita_IsNull( )
   {
      return (gxTv_SdtCita_Citaestadocita_N==1) ;
   }

   public String getgxTv_SdtCita_Citainforme( )
   {
      return gxTv_SdtCita_Citainforme ;
   }

   public void setgxTv_SdtCita_Citainforme( String value )
   {
      gxTv_SdtCita_Citainforme_N = (byte)(0) ;
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citainforme");
      gxTv_SdtCita_Citainforme = value ;
   }

   public void setgxTv_SdtCita_Citainforme_SetNull( )
   {
      gxTv_SdtCita_Citainforme_N = (byte)(1) ;
      gxTv_SdtCita_Citainforme = "" ;
   }

   public boolean getgxTv_SdtCita_Citainforme_IsNull( )
   {
      return (gxTv_SdtCita_Citainforme_N==1) ;
   }

   public String getgxTv_SdtCita_Citaantecedentes( )
   {
      return gxTv_SdtCita_Citaantecedentes ;
   }

   public void setgxTv_SdtCita_Citaantecedentes( String value )
   {
      gxTv_SdtCita_Citaantecedentes_N = (byte)(0) ;
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citaantecedentes");
      gxTv_SdtCita_Citaantecedentes = value ;
   }

   public void setgxTv_SdtCita_Citaantecedentes_SetNull( )
   {
      gxTv_SdtCita_Citaantecedentes_N = (byte)(1) ;
      gxTv_SdtCita_Citaantecedentes = "" ;
   }

   public boolean getgxTv_SdtCita_Citaantecedentes_IsNull( )
   {
      return (gxTv_SdtCita_Citaantecedentes_N==1) ;
   }

   public String getgxTv_SdtCita_Citalink( )
   {
      return gxTv_SdtCita_Citalink ;
   }

   public void setgxTv_SdtCita_Citalink( String value )
   {
      gxTv_SdtCita_Citalink_N = (byte)(0) ;
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citalink");
      gxTv_SdtCita_Citalink = value ;
   }

   public void setgxTv_SdtCita_Citalink_SetNull( )
   {
      gxTv_SdtCita_Citalink_N = (byte)(1) ;
      gxTv_SdtCita_Citalink = "" ;
   }

   public boolean getgxTv_SdtCita_Citalink_IsNull( )
   {
      return (gxTv_SdtCita_Citalink_N==1) ;
   }

   public java.util.Date getgxTv_SdtCita_Citafechareserva( )
   {
      return gxTv_SdtCita_Citafechareserva ;
   }

   public void setgxTv_SdtCita_Citafechareserva( java.util.Date value )
   {
      gxTv_SdtCita_Citafechareserva_N = (byte)(0) ;
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citafechareserva");
      gxTv_SdtCita_Citafechareserva = value ;
   }

   public void setgxTv_SdtCita_Citafechareserva_SetNull( )
   {
      gxTv_SdtCita_Citafechareserva_N = (byte)(1) ;
      gxTv_SdtCita_Citafechareserva = GXutil.resetTime( GXutil.nullDate() );
   }

   public boolean getgxTv_SdtCita_Citafechareserva_IsNull( )
   {
      return (gxTv_SdtCita_Citafechareserva_N==1) ;
   }

   public String getgxTv_SdtCita_Citalog( )
   {
      return gxTv_SdtCita_Citalog ;
   }

   public void setgxTv_SdtCita_Citalog( String value )
   {
      gxTv_SdtCita_Citalog_N = (byte)(0) ;
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citalog");
      gxTv_SdtCita_Citalog = value ;
   }

   public void setgxTv_SdtCita_Citalog_SetNull( )
   {
      gxTv_SdtCita_Citalog_N = (byte)(1) ;
      gxTv_SdtCita_Citalog = "" ;
   }

   public boolean getgxTv_SdtCita_Citalog_IsNull( )
   {
      return (gxTv_SdtCita_Citalog_N==1) ;
   }

   public String getgxTv_SdtCita_Citaemailgenlink( )
   {
      return gxTv_SdtCita_Citaemailgenlink ;
   }

   public void setgxTv_SdtCita_Citaemailgenlink( String value )
   {
      gxTv_SdtCita_Citaemailgenlink_N = (byte)(0) ;
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citaemailgenlink");
      gxTv_SdtCita_Citaemailgenlink = value ;
   }

   public void setgxTv_SdtCita_Citaemailgenlink_SetNull( )
   {
      gxTv_SdtCita_Citaemailgenlink_N = (byte)(1) ;
      gxTv_SdtCita_Citaemailgenlink = "" ;
   }

   public boolean getgxTv_SdtCita_Citaemailgenlink_IsNull( )
   {
      return (gxTv_SdtCita_Citaemailgenlink_N==1) ;
   }

   public String getgxTv_SdtCita_Citaestado( )
   {
      return gxTv_SdtCita_Citaestado ;
   }

   public void setgxTv_SdtCita_Citaestado( String value )
   {
      gxTv_SdtCita_Citaestado_N = (byte)(0) ;
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citaestado");
      gxTv_SdtCita_Citaestado = value ;
   }

   public void setgxTv_SdtCita_Citaestado_SetNull( )
   {
      gxTv_SdtCita_Citaestado_N = (byte)(1) ;
      gxTv_SdtCita_Citaestado = "" ;
   }

   public boolean getgxTv_SdtCita_Citaestado_IsNull( )
   {
      return (gxTv_SdtCita_Citaestado_N==1) ;
   }

   public String getgxTv_SdtCita_Citamotivoconsulta( )
   {
      return gxTv_SdtCita_Citamotivoconsulta ;
   }

   public void setgxTv_SdtCita_Citamotivoconsulta( String value )
   {
      gxTv_SdtCita_Citamotivoconsulta_N = (byte)(0) ;
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citamotivoconsulta");
      gxTv_SdtCita_Citamotivoconsulta = value ;
   }

   public void setgxTv_SdtCita_Citamotivoconsulta_SetNull( )
   {
      gxTv_SdtCita_Citamotivoconsulta_N = (byte)(1) ;
      gxTv_SdtCita_Citamotivoconsulta = "" ;
   }

   public boolean getgxTv_SdtCita_Citamotivoconsulta_IsNull( )
   {
      return (gxTv_SdtCita_Citamotivoconsulta_N==1) ;
   }

   public String getgxTv_SdtCita_Citaarchivonombre( )
   {
      return gxTv_SdtCita_Citaarchivonombre ;
   }

   public void setgxTv_SdtCita_Citaarchivonombre( String value )
   {
      gxTv_SdtCita_Citaarchivonombre_N = (byte)(0) ;
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citaarchivonombre");
      gxTv_SdtCita_Citaarchivonombre = value ;
   }

   public void setgxTv_SdtCita_Citaarchivonombre_SetNull( )
   {
      gxTv_SdtCita_Citaarchivonombre_N = (byte)(1) ;
      gxTv_SdtCita_Citaarchivonombre = "" ;
   }

   public boolean getgxTv_SdtCita_Citaarchivonombre_IsNull( )
   {
      return (gxTv_SdtCita_Citaarchivonombre_N==1) ;
   }

   @GxUpload
   public String getgxTv_SdtCita_Citaarchivo( )
   {
      return gxTv_SdtCita_Citaarchivo ;
   }

   public void setgxTv_SdtCita_Citaarchivo( String value )
   {
      gxTv_SdtCita_Citaarchivo_N = (byte)(0) ;
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citaarchivo");
      gxTv_SdtCita_Citaarchivo = value ;
   }

   public void setgxTv_SdtCita_Citaarchivo_SetBlob( String blob ,
                                                    String fileName ,
                                                    String fileType )
   {
      gxTv_SdtCita_Citaarchivo = blob ;
   }

   public void setgxTv_SdtCita_Citaarchivo_SetNull( )
   {
      gxTv_SdtCita_Citaarchivo_N = (byte)(1) ;
      gxTv_SdtCita_Citaarchivo = "" ;
   }

   public boolean getgxTv_SdtCita_Citaarchivo_IsNull( )
   {
      return (gxTv_SdtCita_Citaarchivo_N==1) ;
   }

   public String getgxTv_SdtCita_Citaarchivoextencion( )
   {
      return gxTv_SdtCita_Citaarchivoextencion ;
   }

   public void setgxTv_SdtCita_Citaarchivoextencion( String value )
   {
      gxTv_SdtCita_Citaarchivoextencion_N = (byte)(0) ;
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citaarchivoextencion");
      gxTv_SdtCita_Citaarchivoextencion = value ;
   }

   public void setgxTv_SdtCita_Citaarchivoextencion_SetNull( )
   {
      gxTv_SdtCita_Citaarchivoextencion_N = (byte)(1) ;
      gxTv_SdtCita_Citaarchivoextencion = "" ;
   }

   public boolean getgxTv_SdtCita_Citaarchivoextencion_IsNull( )
   {
      return (gxTv_SdtCita_Citaarchivoextencion_N==1) ;
   }

   public boolean getgxTv_SdtCita_Citaconsentimiento( )
   {
      return gxTv_SdtCita_Citaconsentimiento ;
   }

   public void setgxTv_SdtCita_Citaconsentimiento( boolean value )
   {
      gxTv_SdtCita_Citaconsentimiento_N = (byte)(0) ;
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citaconsentimiento");
      gxTv_SdtCita_Citaconsentimiento = value ;
   }

   public void setgxTv_SdtCita_Citaconsentimiento_SetNull( )
   {
      gxTv_SdtCita_Citaconsentimiento_N = (byte)(1) ;
      gxTv_SdtCita_Citaconsentimiento = false ;
   }

   public boolean getgxTv_SdtCita_Citaconsentimiento_IsNull( )
   {
      return (gxTv_SdtCita_Citaconsentimiento_N==1) ;
   }

   public boolean getgxTv_SdtCita_Citagestante( )
   {
      return gxTv_SdtCita_Citagestante ;
   }

   public void setgxTv_SdtCita_Citagestante( boolean value )
   {
      gxTv_SdtCita_Citagestante_N = (byte)(0) ;
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citagestante");
      gxTv_SdtCita_Citagestante = value ;
   }

   public void setgxTv_SdtCita_Citagestante_SetNull( )
   {
      gxTv_SdtCita_Citagestante_N = (byte)(1) ;
      gxTv_SdtCita_Citagestante = false ;
   }

   public boolean getgxTv_SdtCita_Citagestante_IsNull( )
   {
      return (gxTv_SdtCita_Citagestante_N==1) ;
   }

   public String getgxTv_SdtCita_Citaestadopago( )
   {
      return gxTv_SdtCita_Citaestadopago ;
   }

   public void setgxTv_SdtCita_Citaestadopago( String value )
   {
      gxTv_SdtCita_Citaestadopago_N = (byte)(0) ;
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citaestadopago");
      gxTv_SdtCita_Citaestadopago = value ;
   }

   public void setgxTv_SdtCita_Citaestadopago_SetNull( )
   {
      gxTv_SdtCita_Citaestadopago_N = (byte)(1) ;
      gxTv_SdtCita_Citaestadopago = "" ;
   }

   public boolean getgxTv_SdtCita_Citaestadopago_IsNull( )
   {
      return (gxTv_SdtCita_Citaestadopago_N==1) ;
   }

   public java.math.BigDecimal getgxTv_SdtCita_Citapeso( )
   {
      return gxTv_SdtCita_Citapeso ;
   }

   public void setgxTv_SdtCita_Citapeso( java.math.BigDecimal value )
   {
      gxTv_SdtCita_Citapeso_N = (byte)(0) ;
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citapeso");
      gxTv_SdtCita_Citapeso = value ;
   }

   public void setgxTv_SdtCita_Citapeso_SetNull( )
   {
      gxTv_SdtCita_Citapeso_N = (byte)(1) ;
      gxTv_SdtCita_Citapeso = DecimalUtil.ZERO ;
   }

   public boolean getgxTv_SdtCita_Citapeso_IsNull( )
   {
      return (gxTv_SdtCita_Citapeso_N==1) ;
   }

   public java.math.BigDecimal getgxTv_SdtCita_Citaestatura( )
   {
      return gxTv_SdtCita_Citaestatura ;
   }

   public void setgxTv_SdtCita_Citaestatura( java.math.BigDecimal value )
   {
      gxTv_SdtCita_Citaestatura_N = (byte)(0) ;
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citaestatura");
      gxTv_SdtCita_Citaestatura = value ;
   }

   public void setgxTv_SdtCita_Citaestatura_SetNull( )
   {
      gxTv_SdtCita_Citaestatura_N = (byte)(1) ;
      gxTv_SdtCita_Citaestatura = DecimalUtil.ZERO ;
   }

   public boolean getgxTv_SdtCita_Citaestatura_IsNull( )
   {
      return (gxTv_SdtCita_Citaestatura_N==1) ;
   }

   public String getgxTv_SdtCita_Mode( )
   {
      return gxTv_SdtCita_Mode ;
   }

   public void setgxTv_SdtCita_Mode( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtCita_Mode = value ;
   }

   public void setgxTv_SdtCita_Mode_SetNull( )
   {
      gxTv_SdtCita_Mode = "" ;
   }

   public boolean getgxTv_SdtCita_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtCita_Initialized( )
   {
      return gxTv_SdtCita_Initialized ;
   }

   public void setgxTv_SdtCita_Initialized( short value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtCita_Initialized = value ;
   }

   public void setgxTv_SdtCita_Initialized_SetNull( )
   {
      gxTv_SdtCita_Initialized = (short)(0) ;
   }

   public boolean getgxTv_SdtCita_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtCita_Citaid_Z( )
   {
      return gxTv_SdtCita_Citaid_Z ;
   }

   public void setgxTv_SdtCita_Citaid_Z( int value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citaid_Z");
      gxTv_SdtCita_Citaid_Z = value ;
   }

   public void setgxTv_SdtCita_Citaid_Z_SetNull( )
   {
      gxTv_SdtCita_Citaid_Z = 0 ;
   }

   public boolean getgxTv_SdtCita_Citaid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtCita_Citacode_Z( )
   {
      return gxTv_SdtCita_Citacode_Z ;
   }

   public void setgxTv_SdtCita_Citacode_Z( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citacode_Z");
      gxTv_SdtCita_Citacode_Z = value ;
   }

   public void setgxTv_SdtCita_Citacode_Z_SetNull( )
   {
      gxTv_SdtCita_Citacode_Z = "" ;
   }

   public boolean getgxTv_SdtCita_Citacode_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtCita_Pacienteid_Z( )
   {
      return gxTv_SdtCita_Pacienteid_Z ;
   }

   public void setgxTv_SdtCita_Pacienteid_Z( int value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Pacienteid_Z");
      gxTv_SdtCita_Pacienteid_Z = value ;
   }

   public void setgxTv_SdtCita_Pacienteid_Z_SetNull( )
   {
      gxTv_SdtCita_Pacienteid_Z = 0 ;
   }

   public boolean getgxTv_SdtCita_Pacienteid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtCita_Pacienteapellidopaterno_Z( )
   {
      return gxTv_SdtCita_Pacienteapellidopaterno_Z ;
   }

   public void setgxTv_SdtCita_Pacienteapellidopaterno_Z( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Pacienteapellidopaterno_Z");
      gxTv_SdtCita_Pacienteapellidopaterno_Z = value ;
   }

   public void setgxTv_SdtCita_Pacienteapellidopaterno_Z_SetNull( )
   {
      gxTv_SdtCita_Pacienteapellidopaterno_Z = "" ;
   }

   public boolean getgxTv_SdtCita_Pacienteapellidopaterno_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtCita_Pacienteapellidomaterno_Z( )
   {
      return gxTv_SdtCita_Pacienteapellidomaterno_Z ;
   }

   public void setgxTv_SdtCita_Pacienteapellidomaterno_Z( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Pacienteapellidomaterno_Z");
      gxTv_SdtCita_Pacienteapellidomaterno_Z = value ;
   }

   public void setgxTv_SdtCita_Pacienteapellidomaterno_Z_SetNull( )
   {
      gxTv_SdtCita_Pacienteapellidomaterno_Z = "" ;
   }

   public boolean getgxTv_SdtCita_Pacienteapellidomaterno_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtCita_Pacientenombres_Z( )
   {
      return gxTv_SdtCita_Pacientenombres_Z ;
   }

   public void setgxTv_SdtCita_Pacientenombres_Z( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Pacientenombres_Z");
      gxTv_SdtCita_Pacientenombres_Z = value ;
   }

   public void setgxTv_SdtCita_Pacientenombres_Z_SetNull( )
   {
      gxTv_SdtCita_Pacientenombres_Z = "" ;
   }

   public boolean getgxTv_SdtCita_Pacientenombres_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtCita_Pacientenrodocumento_Z( )
   {
      return gxTv_SdtCita_Pacientenrodocumento_Z ;
   }

   public void setgxTv_SdtCita_Pacientenrodocumento_Z( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Pacientenrodocumento_Z");
      gxTv_SdtCita_Pacientenrodocumento_Z = value ;
   }

   public void setgxTv_SdtCita_Pacientenrodocumento_Z_SetNull( )
   {
      gxTv_SdtCita_Pacientenrodocumento_Z = "" ;
   }

   public boolean getgxTv_SdtCita_Pacientenrodocumento_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtCita_Citatipodiagnostico_Z( )
   {
      return gxTv_SdtCita_Citatipodiagnostico_Z ;
   }

   public void setgxTv_SdtCita_Citatipodiagnostico_Z( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citatipodiagnostico_Z");
      gxTv_SdtCita_Citatipodiagnostico_Z = value ;
   }

   public void setgxTv_SdtCita_Citatipodiagnostico_Z_SetNull( )
   {
      gxTv_SdtCita_Citatipodiagnostico_Z = "" ;
   }

   public boolean getgxTv_SdtCita_Citatipodiagnostico_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtCita_Sgcitadisponibilidadid_Z( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadid_Z ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadid_Z( int value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadid_Z");
      gxTv_SdtCita_Sgcitadisponibilidadid_Z = value ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadid_Z_SetNull( )
   {
      gxTv_SdtCita_Sgcitadisponibilidadid_Z = 0 ;
   }

   public boolean getgxTv_SdtCita_Sgcitadisponibilidadid_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtCita_Sgcitadisponibilidadfecha_Z( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadfecha_Z ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadfecha_Z( java.util.Date value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadfecha_Z");
      gxTv_SdtCita_Sgcitadisponibilidadfecha_Z = value ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadfecha_Z_SetNull( )
   {
      gxTv_SdtCita_Sgcitadisponibilidadfecha_Z = GXutil.nullDate() ;
   }

   public boolean getgxTv_SdtCita_Sgcitadisponibilidadfecha_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtCita_Sgcitadisponibilidadhorainicio_Z( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadhorainicio_Z ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadhorainicio_Z( java.util.Date value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadhorainicio_Z");
      gxTv_SdtCita_Sgcitadisponibilidadhorainicio_Z = value ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadhorainicio_Z_SetNull( )
   {
      gxTv_SdtCita_Sgcitadisponibilidadhorainicio_Z = GXutil.resetTime( GXutil.nullDate() );
   }

   public boolean getgxTv_SdtCita_Sgcitadisponibilidadhorainicio_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtCita_Sgcitadisponibilidadhorafin_Z( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadhorafin_Z ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadhorafin_Z( java.util.Date value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadhorafin_Z");
      gxTv_SdtCita_Sgcitadisponibilidadhorafin_Z = value ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadhorafin_Z_SetNull( )
   {
      gxTv_SdtCita_Sgcitadisponibilidadhorafin_Z = GXutil.resetTime( GXutil.nullDate() );
   }

   public boolean getgxTv_SdtCita_Sgcitadisponibilidadhorafin_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtCita_Sgcitadisponibilidadespecialidadid_Z( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadespecialidadid_Z ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadespecialidadid_Z( short value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadespecialidadid_Z");
      gxTv_SdtCita_Sgcitadisponibilidadespecialidadid_Z = value ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadespecialidadid_Z_SetNull( )
   {
      gxTv_SdtCita_Sgcitadisponibilidadespecialidadid_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtCita_Sgcitadisponibilidadespecialidadid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtCita_Sgcitadisponibilidadespecialidadnombre_Z( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadespecialidadnombre_Z ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadespecialidadnombre_Z( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadespecialidadnombre_Z");
      gxTv_SdtCita_Sgcitadisponibilidadespecialidadnombre_Z = value ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadespecialidadnombre_Z_SetNull( )
   {
      gxTv_SdtCita_Sgcitadisponibilidadespecialidadnombre_Z = "" ;
   }

   public boolean getgxTv_SdtCita_Sgcitadisponibilidadespecialidadnombre_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtCita_Sgcitadisponibilidadsedeid_Z( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadsedeid_Z ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadsedeid_Z( short value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadsedeid_Z");
      gxTv_SdtCita_Sgcitadisponibilidadsedeid_Z = value ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadsedeid_Z_SetNull( )
   {
      gxTv_SdtCita_Sgcitadisponibilidadsedeid_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtCita_Sgcitadisponibilidadsedeid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtCita_Sgcitadisponibilidadsedenombre_Z( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadsedenombre_Z ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadsedenombre_Z( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadsedenombre_Z");
      gxTv_SdtCita_Sgcitadisponibilidadsedenombre_Z = value ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadsedenombre_Z_SetNull( )
   {
      gxTv_SdtCita_Sgcitadisponibilidadsedenombre_Z = "" ;
   }

   public boolean getgxTv_SdtCita_Sgcitadisponibilidadsedenombre_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtCita_Sgcitadisponibilidadclinicaid_Z( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadclinicaid_Z ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadclinicaid_Z( short value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadclinicaid_Z");
      gxTv_SdtCita_Sgcitadisponibilidadclinicaid_Z = value ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadclinicaid_Z_SetNull( )
   {
      gxTv_SdtCita_Sgcitadisponibilidadclinicaid_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtCita_Sgcitadisponibilidadclinicaid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtCita_Sgcitadisponibilidadclinicanombre_Z( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadclinicanombre_Z ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadclinicanombre_Z( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadclinicanombre_Z");
      gxTv_SdtCita_Sgcitadisponibilidadclinicanombre_Z = value ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadclinicanombre_Z_SetNull( )
   {
      gxTv_SdtCita_Sgcitadisponibilidadclinicanombre_Z = "" ;
   }

   public boolean getgxTv_SdtCita_Sgcitadisponibilidadclinicanombre_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtCita_Sgcitadisponibilidadprofesionalid_Z( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadprofesionalid_Z ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadprofesionalid_Z( int value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadprofesionalid_Z");
      gxTv_SdtCita_Sgcitadisponibilidadprofesionalid_Z = value ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadprofesionalid_Z_SetNull( )
   {
      gxTv_SdtCita_Sgcitadisponibilidadprofesionalid_Z = 0 ;
   }

   public boolean getgxTv_SdtCita_Sgcitadisponibilidadprofesionalid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtCita_Sgcitadisponibilidadprofullname_Z( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadprofullname_Z ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadprofullname_Z( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadprofullname_Z");
      gxTv_SdtCita_Sgcitadisponibilidadprofullname_Z = value ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadprofullname_Z_SetNull( )
   {
      gxTv_SdtCita_Sgcitadisponibilidadprofullname_Z = "" ;
   }

   public boolean getgxTv_SdtCita_Sgcitadisponibilidadprofullname_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtCita_Sgcitadisponibilidadprocop_Z( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadprocop_Z ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadprocop_Z( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadprocop_Z");
      gxTv_SdtCita_Sgcitadisponibilidadprocop_Z = value ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadprocop_Z_SetNull( )
   {
      gxTv_SdtCita_Sgcitadisponibilidadprocop_Z = "" ;
   }

   public boolean getgxTv_SdtCita_Sgcitadisponibilidadprocop_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtCita_Citaestadocita_Z( )
   {
      return gxTv_SdtCita_Citaestadocita_Z ;
   }

   public void setgxTv_SdtCita_Citaestadocita_Z( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citaestadocita_Z");
      gxTv_SdtCita_Citaestadocita_Z = value ;
   }

   public void setgxTv_SdtCita_Citaestadocita_Z_SetNull( )
   {
      gxTv_SdtCita_Citaestadocita_Z = "" ;
   }

   public boolean getgxTv_SdtCita_Citaestadocita_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtCita_Citalink_Z( )
   {
      return gxTv_SdtCita_Citalink_Z ;
   }

   public void setgxTv_SdtCita_Citalink_Z( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citalink_Z");
      gxTv_SdtCita_Citalink_Z = value ;
   }

   public void setgxTv_SdtCita_Citalink_Z_SetNull( )
   {
      gxTv_SdtCita_Citalink_Z = "" ;
   }

   public boolean getgxTv_SdtCita_Citalink_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtCita_Citafechareserva_Z( )
   {
      return gxTv_SdtCita_Citafechareserva_Z ;
   }

   public void setgxTv_SdtCita_Citafechareserva_Z( java.util.Date value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citafechareserva_Z");
      gxTv_SdtCita_Citafechareserva_Z = value ;
   }

   public void setgxTv_SdtCita_Citafechareserva_Z_SetNull( )
   {
      gxTv_SdtCita_Citafechareserva_Z = GXutil.resetTime( GXutil.nullDate() );
   }

   public boolean getgxTv_SdtCita_Citafechareserva_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtCita_Citalog_Z( )
   {
      return gxTv_SdtCita_Citalog_Z ;
   }

   public void setgxTv_SdtCita_Citalog_Z( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citalog_Z");
      gxTv_SdtCita_Citalog_Z = value ;
   }

   public void setgxTv_SdtCita_Citalog_Z_SetNull( )
   {
      gxTv_SdtCita_Citalog_Z = "" ;
   }

   public boolean getgxTv_SdtCita_Citalog_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtCita_Citaemailgenlink_Z( )
   {
      return gxTv_SdtCita_Citaemailgenlink_Z ;
   }

   public void setgxTv_SdtCita_Citaemailgenlink_Z( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citaemailgenlink_Z");
      gxTv_SdtCita_Citaemailgenlink_Z = value ;
   }

   public void setgxTv_SdtCita_Citaemailgenlink_Z_SetNull( )
   {
      gxTv_SdtCita_Citaemailgenlink_Z = "" ;
   }

   public boolean getgxTv_SdtCita_Citaemailgenlink_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtCita_Citaestado_Z( )
   {
      return gxTv_SdtCita_Citaestado_Z ;
   }

   public void setgxTv_SdtCita_Citaestado_Z( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citaestado_Z");
      gxTv_SdtCita_Citaestado_Z = value ;
   }

   public void setgxTv_SdtCita_Citaestado_Z_SetNull( )
   {
      gxTv_SdtCita_Citaestado_Z = "" ;
   }

   public boolean getgxTv_SdtCita_Citaestado_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtCita_Citaarchivonombre_Z( )
   {
      return gxTv_SdtCita_Citaarchivonombre_Z ;
   }

   public void setgxTv_SdtCita_Citaarchivonombre_Z( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citaarchivonombre_Z");
      gxTv_SdtCita_Citaarchivonombre_Z = value ;
   }

   public void setgxTv_SdtCita_Citaarchivonombre_Z_SetNull( )
   {
      gxTv_SdtCita_Citaarchivonombre_Z = "" ;
   }

   public boolean getgxTv_SdtCita_Citaarchivonombre_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtCita_Citaarchivoextencion_Z( )
   {
      return gxTv_SdtCita_Citaarchivoextencion_Z ;
   }

   public void setgxTv_SdtCita_Citaarchivoextencion_Z( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citaarchivoextencion_Z");
      gxTv_SdtCita_Citaarchivoextencion_Z = value ;
   }

   public void setgxTv_SdtCita_Citaarchivoextencion_Z_SetNull( )
   {
      gxTv_SdtCita_Citaarchivoextencion_Z = "" ;
   }

   public boolean getgxTv_SdtCita_Citaarchivoextencion_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtCita_Citaconsentimiento_Z( )
   {
      return gxTv_SdtCita_Citaconsentimiento_Z ;
   }

   public void setgxTv_SdtCita_Citaconsentimiento_Z( boolean value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citaconsentimiento_Z");
      gxTv_SdtCita_Citaconsentimiento_Z = value ;
   }

   public void setgxTv_SdtCita_Citaconsentimiento_Z_SetNull( )
   {
      gxTv_SdtCita_Citaconsentimiento_Z = false ;
   }

   public boolean getgxTv_SdtCita_Citaconsentimiento_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtCita_Citagestante_Z( )
   {
      return gxTv_SdtCita_Citagestante_Z ;
   }

   public void setgxTv_SdtCita_Citagestante_Z( boolean value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citagestante_Z");
      gxTv_SdtCita_Citagestante_Z = value ;
   }

   public void setgxTv_SdtCita_Citagestante_Z_SetNull( )
   {
      gxTv_SdtCita_Citagestante_Z = false ;
   }

   public boolean getgxTv_SdtCita_Citagestante_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtCita_Citaestadopago_Z( )
   {
      return gxTv_SdtCita_Citaestadopago_Z ;
   }

   public void setgxTv_SdtCita_Citaestadopago_Z( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citaestadopago_Z");
      gxTv_SdtCita_Citaestadopago_Z = value ;
   }

   public void setgxTv_SdtCita_Citaestadopago_Z_SetNull( )
   {
      gxTv_SdtCita_Citaestadopago_Z = "" ;
   }

   public boolean getgxTv_SdtCita_Citaestadopago_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtCita_Citapeso_Z( )
   {
      return gxTv_SdtCita_Citapeso_Z ;
   }

   public void setgxTv_SdtCita_Citapeso_Z( java.math.BigDecimal value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citapeso_Z");
      gxTv_SdtCita_Citapeso_Z = value ;
   }

   public void setgxTv_SdtCita_Citapeso_Z_SetNull( )
   {
      gxTv_SdtCita_Citapeso_Z = DecimalUtil.ZERO ;
   }

   public boolean getgxTv_SdtCita_Citapeso_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtCita_Citaestatura_Z( )
   {
      return gxTv_SdtCita_Citaestatura_Z ;
   }

   public void setgxTv_SdtCita_Citaestatura_Z( java.math.BigDecimal value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citaestatura_Z");
      gxTv_SdtCita_Citaestatura_Z = value ;
   }

   public void setgxTv_SdtCita_Citaestatura_Z_SetNull( )
   {
      gxTv_SdtCita_Citaestatura_Z = DecimalUtil.ZERO ;
   }

   public boolean getgxTv_SdtCita_Citaestatura_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtCita_Citaid_N( )
   {
      return gxTv_SdtCita_Citaid_N ;
   }

   public void setgxTv_SdtCita_Citaid_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citaid_N");
      gxTv_SdtCita_Citaid_N = value ;
   }

   public void setgxTv_SdtCita_Citaid_N_SetNull( )
   {
      gxTv_SdtCita_Citaid_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtCita_Citaid_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtCita_Citatipodiagnostico_N( )
   {
      return gxTv_SdtCita_Citatipodiagnostico_N ;
   }

   public void setgxTv_SdtCita_Citatipodiagnostico_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citatipodiagnostico_N");
      gxTv_SdtCita_Citatipodiagnostico_N = value ;
   }

   public void setgxTv_SdtCita_Citatipodiagnostico_N_SetNull( )
   {
      gxTv_SdtCita_Citatipodiagnostico_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtCita_Citatipodiagnostico_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtCita_Sgcitadisponibilidadfecha_N( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadfecha_N ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadfecha_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadfecha_N");
      gxTv_SdtCita_Sgcitadisponibilidadfecha_N = value ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadfecha_N_SetNull( )
   {
      gxTv_SdtCita_Sgcitadisponibilidadfecha_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtCita_Sgcitadisponibilidadfecha_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtCita_Sgcitadisponibilidadhorainicio_N( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadhorainicio_N ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadhorainicio_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadhorainicio_N");
      gxTv_SdtCita_Sgcitadisponibilidadhorainicio_N = value ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadhorainicio_N_SetNull( )
   {
      gxTv_SdtCita_Sgcitadisponibilidadhorainicio_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtCita_Sgcitadisponibilidadhorainicio_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtCita_Sgcitadisponibilidadhorafin_N( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadhorafin_N ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadhorafin_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Sgcitadisponibilidadhorafin_N");
      gxTv_SdtCita_Sgcitadisponibilidadhorafin_N = value ;
   }

   public void setgxTv_SdtCita_Sgcitadisponibilidadhorafin_N_SetNull( )
   {
      gxTv_SdtCita_Sgcitadisponibilidadhorafin_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtCita_Sgcitadisponibilidadhorafin_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtCita_Citaestadocita_N( )
   {
      return gxTv_SdtCita_Citaestadocita_N ;
   }

   public void setgxTv_SdtCita_Citaestadocita_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citaestadocita_N");
      gxTv_SdtCita_Citaestadocita_N = value ;
   }

   public void setgxTv_SdtCita_Citaestadocita_N_SetNull( )
   {
      gxTv_SdtCita_Citaestadocita_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtCita_Citaestadocita_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtCita_Citainforme_N( )
   {
      return gxTv_SdtCita_Citainforme_N ;
   }

   public void setgxTv_SdtCita_Citainforme_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citainforme_N");
      gxTv_SdtCita_Citainforme_N = value ;
   }

   public void setgxTv_SdtCita_Citainforme_N_SetNull( )
   {
      gxTv_SdtCita_Citainforme_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtCita_Citainforme_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtCita_Citaantecedentes_N( )
   {
      return gxTv_SdtCita_Citaantecedentes_N ;
   }

   public void setgxTv_SdtCita_Citaantecedentes_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citaantecedentes_N");
      gxTv_SdtCita_Citaantecedentes_N = value ;
   }

   public void setgxTv_SdtCita_Citaantecedentes_N_SetNull( )
   {
      gxTv_SdtCita_Citaantecedentes_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtCita_Citaantecedentes_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtCita_Citalink_N( )
   {
      return gxTv_SdtCita_Citalink_N ;
   }

   public void setgxTv_SdtCita_Citalink_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citalink_N");
      gxTv_SdtCita_Citalink_N = value ;
   }

   public void setgxTv_SdtCita_Citalink_N_SetNull( )
   {
      gxTv_SdtCita_Citalink_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtCita_Citalink_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtCita_Citafechareserva_N( )
   {
      return gxTv_SdtCita_Citafechareserva_N ;
   }

   public void setgxTv_SdtCita_Citafechareserva_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citafechareserva_N");
      gxTv_SdtCita_Citafechareserva_N = value ;
   }

   public void setgxTv_SdtCita_Citafechareserva_N_SetNull( )
   {
      gxTv_SdtCita_Citafechareserva_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtCita_Citafechareserva_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtCita_Citalog_N( )
   {
      return gxTv_SdtCita_Citalog_N ;
   }

   public void setgxTv_SdtCita_Citalog_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citalog_N");
      gxTv_SdtCita_Citalog_N = value ;
   }

   public void setgxTv_SdtCita_Citalog_N_SetNull( )
   {
      gxTv_SdtCita_Citalog_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtCita_Citalog_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtCita_Citaemailgenlink_N( )
   {
      return gxTv_SdtCita_Citaemailgenlink_N ;
   }

   public void setgxTv_SdtCita_Citaemailgenlink_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citaemailgenlink_N");
      gxTv_SdtCita_Citaemailgenlink_N = value ;
   }

   public void setgxTv_SdtCita_Citaemailgenlink_N_SetNull( )
   {
      gxTv_SdtCita_Citaemailgenlink_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtCita_Citaemailgenlink_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtCita_Citaestado_N( )
   {
      return gxTv_SdtCita_Citaestado_N ;
   }

   public void setgxTv_SdtCita_Citaestado_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citaestado_N");
      gxTv_SdtCita_Citaestado_N = value ;
   }

   public void setgxTv_SdtCita_Citaestado_N_SetNull( )
   {
      gxTv_SdtCita_Citaestado_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtCita_Citaestado_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtCita_Citamotivoconsulta_N( )
   {
      return gxTv_SdtCita_Citamotivoconsulta_N ;
   }

   public void setgxTv_SdtCita_Citamotivoconsulta_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citamotivoconsulta_N");
      gxTv_SdtCita_Citamotivoconsulta_N = value ;
   }

   public void setgxTv_SdtCita_Citamotivoconsulta_N_SetNull( )
   {
      gxTv_SdtCita_Citamotivoconsulta_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtCita_Citamotivoconsulta_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtCita_Citaarchivonombre_N( )
   {
      return gxTv_SdtCita_Citaarchivonombre_N ;
   }

   public void setgxTv_SdtCita_Citaarchivonombre_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citaarchivonombre_N");
      gxTv_SdtCita_Citaarchivonombre_N = value ;
   }

   public void setgxTv_SdtCita_Citaarchivonombre_N_SetNull( )
   {
      gxTv_SdtCita_Citaarchivonombre_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtCita_Citaarchivonombre_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtCita_Citaarchivo_N( )
   {
      return gxTv_SdtCita_Citaarchivo_N ;
   }

   public void setgxTv_SdtCita_Citaarchivo_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citaarchivo_N");
      gxTv_SdtCita_Citaarchivo_N = value ;
   }

   public void setgxTv_SdtCita_Citaarchivo_N_SetNull( )
   {
      gxTv_SdtCita_Citaarchivo_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtCita_Citaarchivo_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtCita_Citaarchivoextencion_N( )
   {
      return gxTv_SdtCita_Citaarchivoextencion_N ;
   }

   public void setgxTv_SdtCita_Citaarchivoextencion_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citaarchivoextencion_N");
      gxTv_SdtCita_Citaarchivoextencion_N = value ;
   }

   public void setgxTv_SdtCita_Citaarchivoextencion_N_SetNull( )
   {
      gxTv_SdtCita_Citaarchivoextencion_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtCita_Citaarchivoextencion_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtCita_Citaconsentimiento_N( )
   {
      return gxTv_SdtCita_Citaconsentimiento_N ;
   }

   public void setgxTv_SdtCita_Citaconsentimiento_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citaconsentimiento_N");
      gxTv_SdtCita_Citaconsentimiento_N = value ;
   }

   public void setgxTv_SdtCita_Citaconsentimiento_N_SetNull( )
   {
      gxTv_SdtCita_Citaconsentimiento_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtCita_Citaconsentimiento_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtCita_Citagestante_N( )
   {
      return gxTv_SdtCita_Citagestante_N ;
   }

   public void setgxTv_SdtCita_Citagestante_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citagestante_N");
      gxTv_SdtCita_Citagestante_N = value ;
   }

   public void setgxTv_SdtCita_Citagestante_N_SetNull( )
   {
      gxTv_SdtCita_Citagestante_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtCita_Citagestante_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtCita_Citaestadopago_N( )
   {
      return gxTv_SdtCita_Citaestadopago_N ;
   }

   public void setgxTv_SdtCita_Citaestadopago_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citaestadopago_N");
      gxTv_SdtCita_Citaestadopago_N = value ;
   }

   public void setgxTv_SdtCita_Citaestadopago_N_SetNull( )
   {
      gxTv_SdtCita_Citaestadopago_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtCita_Citaestadopago_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtCita_Citapeso_N( )
   {
      return gxTv_SdtCita_Citapeso_N ;
   }

   public void setgxTv_SdtCita_Citapeso_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citapeso_N");
      gxTv_SdtCita_Citapeso_N = value ;
   }

   public void setgxTv_SdtCita_Citapeso_N_SetNull( )
   {
      gxTv_SdtCita_Citapeso_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtCita_Citapeso_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtCita_Citaestatura_N( )
   {
      return gxTv_SdtCita_Citaestatura_N ;
   }

   public void setgxTv_SdtCita_Citaestatura_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      SetDirty("Citaestatura_N");
      gxTv_SdtCita_Citaestatura_N = value ;
   }

   public void setgxTv_SdtCita_Citaestatura_N_SetNull( )
   {
      gxTv_SdtCita_Citaestatura_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtCita_Citaestatura_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.projectthani.cita_bc obj;
      obj = new com.projectthani.cita_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtCita_N = (byte)(1) ;
      gxTv_SdtCita_Citacode = "" ;
      gxTv_SdtCita_Pacienteapellidopaterno = "" ;
      gxTv_SdtCita_Pacienteapellidomaterno = "" ;
      gxTv_SdtCita_Pacientenombres = "" ;
      gxTv_SdtCita_Pacientenrodocumento = "" ;
      gxTv_SdtCita_Citatipodiagnostico = "" ;
      gxTv_SdtCita_Sgcitadisponibilidadfecha = GXutil.nullDate() ;
      gxTv_SdtCita_Sgcitadisponibilidadhorainicio = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtCita_Sgcitadisponibilidadhorafin = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtCita_Sgcitadisponibilidadespecialidadnombre = "" ;
      gxTv_SdtCita_Sgcitadisponibilidadsedenombre = "" ;
      gxTv_SdtCita_Sgcitadisponibilidadclinicanombre = "" ;
      gxTv_SdtCita_Sgcitadisponibilidadprofullname = "" ;
      gxTv_SdtCita_Sgcitadisponibilidadprocop = "" ;
      gxTv_SdtCita_Citaestadocita = "" ;
      gxTv_SdtCita_Citainforme = "" ;
      gxTv_SdtCita_Citaantecedentes = "" ;
      gxTv_SdtCita_Citalink = "" ;
      gxTv_SdtCita_Citafechareserva = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtCita_Citalog = "" ;
      gxTv_SdtCita_Citaemailgenlink = "" ;
      gxTv_SdtCita_Citaestado = "" ;
      gxTv_SdtCita_Citamotivoconsulta = "" ;
      gxTv_SdtCita_Citaarchivonombre = "" ;
      gxTv_SdtCita_Citaarchivo = "" ;
      gxTv_SdtCita_Citaarchivoextencion = "" ;
      gxTv_SdtCita_Citaestadopago = "" ;
      gxTv_SdtCita_Citapeso = DecimalUtil.ZERO ;
      gxTv_SdtCita_Citaestatura = DecimalUtil.ZERO ;
      gxTv_SdtCita_Mode = "" ;
      gxTv_SdtCita_Citacode_Z = "" ;
      gxTv_SdtCita_Pacienteapellidopaterno_Z = "" ;
      gxTv_SdtCita_Pacienteapellidomaterno_Z = "" ;
      gxTv_SdtCita_Pacientenombres_Z = "" ;
      gxTv_SdtCita_Pacientenrodocumento_Z = "" ;
      gxTv_SdtCita_Citatipodiagnostico_Z = "" ;
      gxTv_SdtCita_Sgcitadisponibilidadfecha_Z = GXutil.nullDate() ;
      gxTv_SdtCita_Sgcitadisponibilidadhorainicio_Z = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtCita_Sgcitadisponibilidadhorafin_Z = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtCita_Sgcitadisponibilidadespecialidadnombre_Z = "" ;
      gxTv_SdtCita_Sgcitadisponibilidadsedenombre_Z = "" ;
      gxTv_SdtCita_Sgcitadisponibilidadclinicanombre_Z = "" ;
      gxTv_SdtCita_Sgcitadisponibilidadprofullname_Z = "" ;
      gxTv_SdtCita_Sgcitadisponibilidadprocop_Z = "" ;
      gxTv_SdtCita_Citaestadocita_Z = "" ;
      gxTv_SdtCita_Citalink_Z = "" ;
      gxTv_SdtCita_Citafechareserva_Z = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtCita_Citalog_Z = "" ;
      gxTv_SdtCita_Citaemailgenlink_Z = "" ;
      gxTv_SdtCita_Citaestado_Z = "" ;
      gxTv_SdtCita_Citaarchivonombre_Z = "" ;
      gxTv_SdtCita_Citaarchivoextencion_Z = "" ;
      gxTv_SdtCita_Citaestadopago_Z = "" ;
      gxTv_SdtCita_Citapeso_Z = DecimalUtil.ZERO ;
      gxTv_SdtCita_Citaestatura_Z = DecimalUtil.ZERO ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
      datetime_STZ = GXutil.resetTime( GXutil.nullDate() );
   }

   public byte isNull( )
   {
      return gxTv_SdtCita_N ;
   }

   public com.projectthani.SdtCita Clone( )
   {
      com.projectthani.SdtCita sdt;
      com.projectthani.cita_bc obj;
      sdt = (com.projectthani.SdtCita)(clone()) ;
      obj = (com.projectthani.cita_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.projectthani.StructSdtCita struct )
   {
      setgxTv_SdtCita_Citaid(struct.getCitaid());
      setgxTv_SdtCita_Citacode(struct.getCitacode());
      setgxTv_SdtCita_Pacienteid(struct.getPacienteid());
      setgxTv_SdtCita_Pacienteapellidopaterno(struct.getPacienteapellidopaterno());
      setgxTv_SdtCita_Pacienteapellidomaterno(struct.getPacienteapellidomaterno());
      setgxTv_SdtCita_Pacientenombres(struct.getPacientenombres());
      setgxTv_SdtCita_Pacientenrodocumento(struct.getPacientenrodocumento());
      setgxTv_SdtCita_Citatipodiagnostico(struct.getCitatipodiagnostico());
      setgxTv_SdtCita_Sgcitadisponibilidadid(struct.getSgcitadisponibilidadid());
      setgxTv_SdtCita_Sgcitadisponibilidadfecha(struct.getSgcitadisponibilidadfecha());
      setgxTv_SdtCita_Sgcitadisponibilidadhorainicio(struct.getSgcitadisponibilidadhorainicio());
      setgxTv_SdtCita_Sgcitadisponibilidadhorafin(struct.getSgcitadisponibilidadhorafin());
      setgxTv_SdtCita_Sgcitadisponibilidadespecialidadid(struct.getSgcitadisponibilidadespecialidadid());
      setgxTv_SdtCita_Sgcitadisponibilidadespecialidadnombre(struct.getSgcitadisponibilidadespecialidadnombre());
      setgxTv_SdtCita_Sgcitadisponibilidadsedeid(struct.getSgcitadisponibilidadsedeid());
      setgxTv_SdtCita_Sgcitadisponibilidadsedenombre(struct.getSgcitadisponibilidadsedenombre());
      setgxTv_SdtCita_Sgcitadisponibilidadclinicaid(struct.getSgcitadisponibilidadclinicaid());
      setgxTv_SdtCita_Sgcitadisponibilidadclinicanombre(struct.getSgcitadisponibilidadclinicanombre());
      setgxTv_SdtCita_Sgcitadisponibilidadprofesionalid(struct.getSgcitadisponibilidadprofesionalid());
      setgxTv_SdtCita_Sgcitadisponibilidadprofullname(struct.getSgcitadisponibilidadprofullname());
      setgxTv_SdtCita_Sgcitadisponibilidadprocop(struct.getSgcitadisponibilidadprocop());
      setgxTv_SdtCita_Citaestadocita(struct.getCitaestadocita());
      setgxTv_SdtCita_Citainforme(struct.getCitainforme());
      setgxTv_SdtCita_Citaantecedentes(struct.getCitaantecedentes());
      setgxTv_SdtCita_Citalink(struct.getCitalink());
      setgxTv_SdtCita_Citafechareserva(struct.getCitafechareserva());
      setgxTv_SdtCita_Citalog(struct.getCitalog());
      setgxTv_SdtCita_Citaemailgenlink(struct.getCitaemailgenlink());
      setgxTv_SdtCita_Citaestado(struct.getCitaestado());
      setgxTv_SdtCita_Citamotivoconsulta(struct.getCitamotivoconsulta());
      setgxTv_SdtCita_Citaarchivonombre(struct.getCitaarchivonombre());
      setgxTv_SdtCita_Citaarchivo(struct.getCitaarchivo());
      setgxTv_SdtCita_Citaarchivoextencion(struct.getCitaarchivoextencion());
      setgxTv_SdtCita_Citaconsentimiento(struct.getCitaconsentimiento());
      setgxTv_SdtCita_Citagestante(struct.getCitagestante());
      setgxTv_SdtCita_Citaestadopago(struct.getCitaestadopago());
      setgxTv_SdtCita_Citapeso(struct.getCitapeso());
      setgxTv_SdtCita_Citaestatura(struct.getCitaestatura());
      setgxTv_SdtCita_Mode(struct.getMode());
      setgxTv_SdtCita_Initialized(struct.getInitialized());
      setgxTv_SdtCita_Citaid_Z(struct.getCitaid_Z());
      setgxTv_SdtCita_Citacode_Z(struct.getCitacode_Z());
      setgxTv_SdtCita_Pacienteid_Z(struct.getPacienteid_Z());
      setgxTv_SdtCita_Pacienteapellidopaterno_Z(struct.getPacienteapellidopaterno_Z());
      setgxTv_SdtCita_Pacienteapellidomaterno_Z(struct.getPacienteapellidomaterno_Z());
      setgxTv_SdtCita_Pacientenombres_Z(struct.getPacientenombres_Z());
      setgxTv_SdtCita_Pacientenrodocumento_Z(struct.getPacientenrodocumento_Z());
      setgxTv_SdtCita_Citatipodiagnostico_Z(struct.getCitatipodiagnostico_Z());
      setgxTv_SdtCita_Sgcitadisponibilidadid_Z(struct.getSgcitadisponibilidadid_Z());
      setgxTv_SdtCita_Sgcitadisponibilidadfecha_Z(struct.getSgcitadisponibilidadfecha_Z());
      setgxTv_SdtCita_Sgcitadisponibilidadhorainicio_Z(struct.getSgcitadisponibilidadhorainicio_Z());
      setgxTv_SdtCita_Sgcitadisponibilidadhorafin_Z(struct.getSgcitadisponibilidadhorafin_Z());
      setgxTv_SdtCita_Sgcitadisponibilidadespecialidadid_Z(struct.getSgcitadisponibilidadespecialidadid_Z());
      setgxTv_SdtCita_Sgcitadisponibilidadespecialidadnombre_Z(struct.getSgcitadisponibilidadespecialidadnombre_Z());
      setgxTv_SdtCita_Sgcitadisponibilidadsedeid_Z(struct.getSgcitadisponibilidadsedeid_Z());
      setgxTv_SdtCita_Sgcitadisponibilidadsedenombre_Z(struct.getSgcitadisponibilidadsedenombre_Z());
      setgxTv_SdtCita_Sgcitadisponibilidadclinicaid_Z(struct.getSgcitadisponibilidadclinicaid_Z());
      setgxTv_SdtCita_Sgcitadisponibilidadclinicanombre_Z(struct.getSgcitadisponibilidadclinicanombre_Z());
      setgxTv_SdtCita_Sgcitadisponibilidadprofesionalid_Z(struct.getSgcitadisponibilidadprofesionalid_Z());
      setgxTv_SdtCita_Sgcitadisponibilidadprofullname_Z(struct.getSgcitadisponibilidadprofullname_Z());
      setgxTv_SdtCita_Sgcitadisponibilidadprocop_Z(struct.getSgcitadisponibilidadprocop_Z());
      setgxTv_SdtCita_Citaestadocita_Z(struct.getCitaestadocita_Z());
      setgxTv_SdtCita_Citalink_Z(struct.getCitalink_Z());
      setgxTv_SdtCita_Citafechareserva_Z(struct.getCitafechareserva_Z());
      setgxTv_SdtCita_Citalog_Z(struct.getCitalog_Z());
      setgxTv_SdtCita_Citaemailgenlink_Z(struct.getCitaemailgenlink_Z());
      setgxTv_SdtCita_Citaestado_Z(struct.getCitaestado_Z());
      setgxTv_SdtCita_Citaarchivonombre_Z(struct.getCitaarchivonombre_Z());
      setgxTv_SdtCita_Citaarchivoextencion_Z(struct.getCitaarchivoextencion_Z());
      setgxTv_SdtCita_Citaconsentimiento_Z(struct.getCitaconsentimiento_Z());
      setgxTv_SdtCita_Citagestante_Z(struct.getCitagestante_Z());
      setgxTv_SdtCita_Citaestadopago_Z(struct.getCitaestadopago_Z());
      setgxTv_SdtCita_Citapeso_Z(struct.getCitapeso_Z());
      setgxTv_SdtCita_Citaestatura_Z(struct.getCitaestatura_Z());
      setgxTv_SdtCita_Citaid_N(struct.getCitaid_N());
      setgxTv_SdtCita_Citatipodiagnostico_N(struct.getCitatipodiagnostico_N());
      setgxTv_SdtCita_Sgcitadisponibilidadfecha_N(struct.getSgcitadisponibilidadfecha_N());
      setgxTv_SdtCita_Sgcitadisponibilidadhorainicio_N(struct.getSgcitadisponibilidadhorainicio_N());
      setgxTv_SdtCita_Sgcitadisponibilidadhorafin_N(struct.getSgcitadisponibilidadhorafin_N());
      setgxTv_SdtCita_Citaestadocita_N(struct.getCitaestadocita_N());
      setgxTv_SdtCita_Citainforme_N(struct.getCitainforme_N());
      setgxTv_SdtCita_Citaantecedentes_N(struct.getCitaantecedentes_N());
      setgxTv_SdtCita_Citalink_N(struct.getCitalink_N());
      setgxTv_SdtCita_Citafechareserva_N(struct.getCitafechareserva_N());
      setgxTv_SdtCita_Citalog_N(struct.getCitalog_N());
      setgxTv_SdtCita_Citaemailgenlink_N(struct.getCitaemailgenlink_N());
      setgxTv_SdtCita_Citaestado_N(struct.getCitaestado_N());
      setgxTv_SdtCita_Citamotivoconsulta_N(struct.getCitamotivoconsulta_N());
      setgxTv_SdtCita_Citaarchivonombre_N(struct.getCitaarchivonombre_N());
      setgxTv_SdtCita_Citaarchivo_N(struct.getCitaarchivo_N());
      setgxTv_SdtCita_Citaarchivoextencion_N(struct.getCitaarchivoextencion_N());
      setgxTv_SdtCita_Citaconsentimiento_N(struct.getCitaconsentimiento_N());
      setgxTv_SdtCita_Citagestante_N(struct.getCitagestante_N());
      setgxTv_SdtCita_Citaestadopago_N(struct.getCitaestadopago_N());
      setgxTv_SdtCita_Citapeso_N(struct.getCitapeso_N());
      setgxTv_SdtCita_Citaestatura_N(struct.getCitaestatura_N());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtCita getStruct( )
   {
      com.projectthani.StructSdtCita struct = new com.projectthani.StructSdtCita ();
      struct.setCitaid(getgxTv_SdtCita_Citaid());
      struct.setCitacode(getgxTv_SdtCita_Citacode());
      struct.setPacienteid(getgxTv_SdtCita_Pacienteid());
      struct.setPacienteapellidopaterno(getgxTv_SdtCita_Pacienteapellidopaterno());
      struct.setPacienteapellidomaterno(getgxTv_SdtCita_Pacienteapellidomaterno());
      struct.setPacientenombres(getgxTv_SdtCita_Pacientenombres());
      struct.setPacientenrodocumento(getgxTv_SdtCita_Pacientenrodocumento());
      struct.setCitatipodiagnostico(getgxTv_SdtCita_Citatipodiagnostico());
      struct.setSgcitadisponibilidadid(getgxTv_SdtCita_Sgcitadisponibilidadid());
      struct.setSgcitadisponibilidadfecha(getgxTv_SdtCita_Sgcitadisponibilidadfecha());
      struct.setSgcitadisponibilidadhorainicio(getgxTv_SdtCita_Sgcitadisponibilidadhorainicio());
      struct.setSgcitadisponibilidadhorafin(getgxTv_SdtCita_Sgcitadisponibilidadhorafin());
      struct.setSgcitadisponibilidadespecialidadid(getgxTv_SdtCita_Sgcitadisponibilidadespecialidadid());
      struct.setSgcitadisponibilidadespecialidadnombre(getgxTv_SdtCita_Sgcitadisponibilidadespecialidadnombre());
      struct.setSgcitadisponibilidadsedeid(getgxTv_SdtCita_Sgcitadisponibilidadsedeid());
      struct.setSgcitadisponibilidadsedenombre(getgxTv_SdtCita_Sgcitadisponibilidadsedenombre());
      struct.setSgcitadisponibilidadclinicaid(getgxTv_SdtCita_Sgcitadisponibilidadclinicaid());
      struct.setSgcitadisponibilidadclinicanombre(getgxTv_SdtCita_Sgcitadisponibilidadclinicanombre());
      struct.setSgcitadisponibilidadprofesionalid(getgxTv_SdtCita_Sgcitadisponibilidadprofesionalid());
      struct.setSgcitadisponibilidadprofullname(getgxTv_SdtCita_Sgcitadisponibilidadprofullname());
      struct.setSgcitadisponibilidadprocop(getgxTv_SdtCita_Sgcitadisponibilidadprocop());
      struct.setCitaestadocita(getgxTv_SdtCita_Citaestadocita());
      struct.setCitainforme(getgxTv_SdtCita_Citainforme());
      struct.setCitaantecedentes(getgxTv_SdtCita_Citaantecedentes());
      struct.setCitalink(getgxTv_SdtCita_Citalink());
      struct.setCitafechareserva(getgxTv_SdtCita_Citafechareserva());
      struct.setCitalog(getgxTv_SdtCita_Citalog());
      struct.setCitaemailgenlink(getgxTv_SdtCita_Citaemailgenlink());
      struct.setCitaestado(getgxTv_SdtCita_Citaestado());
      struct.setCitamotivoconsulta(getgxTv_SdtCita_Citamotivoconsulta());
      struct.setCitaarchivonombre(getgxTv_SdtCita_Citaarchivonombre());
      struct.setCitaarchivo(getgxTv_SdtCita_Citaarchivo());
      struct.setCitaarchivoextencion(getgxTv_SdtCita_Citaarchivoextencion());
      struct.setCitaconsentimiento(getgxTv_SdtCita_Citaconsentimiento());
      struct.setCitagestante(getgxTv_SdtCita_Citagestante());
      struct.setCitaestadopago(getgxTv_SdtCita_Citaestadopago());
      struct.setCitapeso(getgxTv_SdtCita_Citapeso());
      struct.setCitaestatura(getgxTv_SdtCita_Citaestatura());
      struct.setMode(getgxTv_SdtCita_Mode());
      struct.setInitialized(getgxTv_SdtCita_Initialized());
      struct.setCitaid_Z(getgxTv_SdtCita_Citaid_Z());
      struct.setCitacode_Z(getgxTv_SdtCita_Citacode_Z());
      struct.setPacienteid_Z(getgxTv_SdtCita_Pacienteid_Z());
      struct.setPacienteapellidopaterno_Z(getgxTv_SdtCita_Pacienteapellidopaterno_Z());
      struct.setPacienteapellidomaterno_Z(getgxTv_SdtCita_Pacienteapellidomaterno_Z());
      struct.setPacientenombres_Z(getgxTv_SdtCita_Pacientenombres_Z());
      struct.setPacientenrodocumento_Z(getgxTv_SdtCita_Pacientenrodocumento_Z());
      struct.setCitatipodiagnostico_Z(getgxTv_SdtCita_Citatipodiagnostico_Z());
      struct.setSgcitadisponibilidadid_Z(getgxTv_SdtCita_Sgcitadisponibilidadid_Z());
      struct.setSgcitadisponibilidadfecha_Z(getgxTv_SdtCita_Sgcitadisponibilidadfecha_Z());
      struct.setSgcitadisponibilidadhorainicio_Z(getgxTv_SdtCita_Sgcitadisponibilidadhorainicio_Z());
      struct.setSgcitadisponibilidadhorafin_Z(getgxTv_SdtCita_Sgcitadisponibilidadhorafin_Z());
      struct.setSgcitadisponibilidadespecialidadid_Z(getgxTv_SdtCita_Sgcitadisponibilidadespecialidadid_Z());
      struct.setSgcitadisponibilidadespecialidadnombre_Z(getgxTv_SdtCita_Sgcitadisponibilidadespecialidadnombre_Z());
      struct.setSgcitadisponibilidadsedeid_Z(getgxTv_SdtCita_Sgcitadisponibilidadsedeid_Z());
      struct.setSgcitadisponibilidadsedenombre_Z(getgxTv_SdtCita_Sgcitadisponibilidadsedenombre_Z());
      struct.setSgcitadisponibilidadclinicaid_Z(getgxTv_SdtCita_Sgcitadisponibilidadclinicaid_Z());
      struct.setSgcitadisponibilidadclinicanombre_Z(getgxTv_SdtCita_Sgcitadisponibilidadclinicanombre_Z());
      struct.setSgcitadisponibilidadprofesionalid_Z(getgxTv_SdtCita_Sgcitadisponibilidadprofesionalid_Z());
      struct.setSgcitadisponibilidadprofullname_Z(getgxTv_SdtCita_Sgcitadisponibilidadprofullname_Z());
      struct.setSgcitadisponibilidadprocop_Z(getgxTv_SdtCita_Sgcitadisponibilidadprocop_Z());
      struct.setCitaestadocita_Z(getgxTv_SdtCita_Citaestadocita_Z());
      struct.setCitalink_Z(getgxTv_SdtCita_Citalink_Z());
      struct.setCitafechareserva_Z(getgxTv_SdtCita_Citafechareserva_Z());
      struct.setCitalog_Z(getgxTv_SdtCita_Citalog_Z());
      struct.setCitaemailgenlink_Z(getgxTv_SdtCita_Citaemailgenlink_Z());
      struct.setCitaestado_Z(getgxTv_SdtCita_Citaestado_Z());
      struct.setCitaarchivonombre_Z(getgxTv_SdtCita_Citaarchivonombre_Z());
      struct.setCitaarchivoextencion_Z(getgxTv_SdtCita_Citaarchivoextencion_Z());
      struct.setCitaconsentimiento_Z(getgxTv_SdtCita_Citaconsentimiento_Z());
      struct.setCitagestante_Z(getgxTv_SdtCita_Citagestante_Z());
      struct.setCitaestadopago_Z(getgxTv_SdtCita_Citaestadopago_Z());
      struct.setCitapeso_Z(getgxTv_SdtCita_Citapeso_Z());
      struct.setCitaestatura_Z(getgxTv_SdtCita_Citaestatura_Z());
      struct.setCitaid_N(getgxTv_SdtCita_Citaid_N());
      struct.setCitatipodiagnostico_N(getgxTv_SdtCita_Citatipodiagnostico_N());
      struct.setSgcitadisponibilidadfecha_N(getgxTv_SdtCita_Sgcitadisponibilidadfecha_N());
      struct.setSgcitadisponibilidadhorainicio_N(getgxTv_SdtCita_Sgcitadisponibilidadhorainicio_N());
      struct.setSgcitadisponibilidadhorafin_N(getgxTv_SdtCita_Sgcitadisponibilidadhorafin_N());
      struct.setCitaestadocita_N(getgxTv_SdtCita_Citaestadocita_N());
      struct.setCitainforme_N(getgxTv_SdtCita_Citainforme_N());
      struct.setCitaantecedentes_N(getgxTv_SdtCita_Citaantecedentes_N());
      struct.setCitalink_N(getgxTv_SdtCita_Citalink_N());
      struct.setCitafechareserva_N(getgxTv_SdtCita_Citafechareserva_N());
      struct.setCitalog_N(getgxTv_SdtCita_Citalog_N());
      struct.setCitaemailgenlink_N(getgxTv_SdtCita_Citaemailgenlink_N());
      struct.setCitaestado_N(getgxTv_SdtCita_Citaestado_N());
      struct.setCitamotivoconsulta_N(getgxTv_SdtCita_Citamotivoconsulta_N());
      struct.setCitaarchivonombre_N(getgxTv_SdtCita_Citaarchivonombre_N());
      struct.setCitaarchivo_N(getgxTv_SdtCita_Citaarchivo_N());
      struct.setCitaarchivoextencion_N(getgxTv_SdtCita_Citaarchivoextencion_N());
      struct.setCitaconsentimiento_N(getgxTv_SdtCita_Citaconsentimiento_N());
      struct.setCitagestante_N(getgxTv_SdtCita_Citagestante_N());
      struct.setCitaestadopago_N(getgxTv_SdtCita_Citaestadopago_N());
      struct.setCitapeso_N(getgxTv_SdtCita_Citapeso_N());
      struct.setCitaestatura_N(getgxTv_SdtCita_Citaestatura_N());
      return struct ;
   }

   private byte gxTv_SdtCita_N ;
   private byte gxTv_SdtCita_Citaid_N ;
   private byte gxTv_SdtCita_Citatipodiagnostico_N ;
   private byte gxTv_SdtCita_Sgcitadisponibilidadfecha_N ;
   private byte gxTv_SdtCita_Sgcitadisponibilidadhorainicio_N ;
   private byte gxTv_SdtCita_Sgcitadisponibilidadhorafin_N ;
   private byte gxTv_SdtCita_Citaestadocita_N ;
   private byte gxTv_SdtCita_Citainforme_N ;
   private byte gxTv_SdtCita_Citaantecedentes_N ;
   private byte gxTv_SdtCita_Citalink_N ;
   private byte gxTv_SdtCita_Citafechareserva_N ;
   private byte gxTv_SdtCita_Citalog_N ;
   private byte gxTv_SdtCita_Citaemailgenlink_N ;
   private byte gxTv_SdtCita_Citaestado_N ;
   private byte gxTv_SdtCita_Citamotivoconsulta_N ;
   private byte gxTv_SdtCita_Citaarchivonombre_N ;
   private byte gxTv_SdtCita_Citaarchivo_N ;
   private byte gxTv_SdtCita_Citaarchivoextencion_N ;
   private byte gxTv_SdtCita_Citaconsentimiento_N ;
   private byte gxTv_SdtCita_Citagestante_N ;
   private byte gxTv_SdtCita_Citaestadopago_N ;
   private byte gxTv_SdtCita_Citapeso_N ;
   private byte gxTv_SdtCita_Citaestatura_N ;
   private short gxTv_SdtCita_Sgcitadisponibilidadespecialidadid ;
   private short gxTv_SdtCita_Sgcitadisponibilidadsedeid ;
   private short gxTv_SdtCita_Sgcitadisponibilidadclinicaid ;
   private short gxTv_SdtCita_Initialized ;
   private short gxTv_SdtCita_Sgcitadisponibilidadespecialidadid_Z ;
   private short gxTv_SdtCita_Sgcitadisponibilidadsedeid_Z ;
   private short gxTv_SdtCita_Sgcitadisponibilidadclinicaid_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtCita_Citaid ;
   private int gxTv_SdtCita_Pacienteid ;
   private int gxTv_SdtCita_Sgcitadisponibilidadid ;
   private int gxTv_SdtCita_Sgcitadisponibilidadprofesionalid ;
   private int gxTv_SdtCita_Citaid_Z ;
   private int gxTv_SdtCita_Pacienteid_Z ;
   private int gxTv_SdtCita_Sgcitadisponibilidadid_Z ;
   private int gxTv_SdtCita_Sgcitadisponibilidadprofesionalid_Z ;
   private java.math.BigDecimal gxTv_SdtCita_Citapeso ;
   private java.math.BigDecimal gxTv_SdtCita_Citaestatura ;
   private java.math.BigDecimal gxTv_SdtCita_Citapeso_Z ;
   private java.math.BigDecimal gxTv_SdtCita_Citaestatura_Z ;
   private String gxTv_SdtCita_Citaestadocita ;
   private String gxTv_SdtCita_Citaestado ;
   private String gxTv_SdtCita_Citaestadopago ;
   private String gxTv_SdtCita_Mode ;
   private String gxTv_SdtCita_Citaestadocita_Z ;
   private String gxTv_SdtCita_Citaestado_Z ;
   private String gxTv_SdtCita_Citaestadopago_Z ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_SdtCita_Sgcitadisponibilidadhorainicio ;
   private java.util.Date gxTv_SdtCita_Sgcitadisponibilidadhorafin ;
   private java.util.Date gxTv_SdtCita_Citafechareserva ;
   private java.util.Date gxTv_SdtCita_Sgcitadisponibilidadhorainicio_Z ;
   private java.util.Date gxTv_SdtCita_Sgcitadisponibilidadhorafin_Z ;
   private java.util.Date gxTv_SdtCita_Citafechareserva_Z ;
   private java.util.Date datetime_STZ ;
   private java.util.Date gxTv_SdtCita_Sgcitadisponibilidadfecha ;
   private java.util.Date gxTv_SdtCita_Sgcitadisponibilidadfecha_Z ;
   private boolean gxTv_SdtCita_Citaconsentimiento ;
   private boolean gxTv_SdtCita_Citagestante ;
   private boolean gxTv_SdtCita_Citaconsentimiento_Z ;
   private boolean gxTv_SdtCita_Citagestante_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtCita_Citainforme ;
   private String gxTv_SdtCita_Citaantecedentes ;
   private String gxTv_SdtCita_Citamotivoconsulta ;
   private String gxTv_SdtCita_Citaarchivo ;
   private String gxTv_SdtCita_Citacode ;
   private String gxTv_SdtCita_Pacienteapellidopaterno ;
   private String gxTv_SdtCita_Pacienteapellidomaterno ;
   private String gxTv_SdtCita_Pacientenombres ;
   private String gxTv_SdtCita_Pacientenrodocumento ;
   private String gxTv_SdtCita_Citatipodiagnostico ;
   private String gxTv_SdtCita_Sgcitadisponibilidadespecialidadnombre ;
   private String gxTv_SdtCita_Sgcitadisponibilidadsedenombre ;
   private String gxTv_SdtCita_Sgcitadisponibilidadclinicanombre ;
   private String gxTv_SdtCita_Sgcitadisponibilidadprofullname ;
   private String gxTv_SdtCita_Sgcitadisponibilidadprocop ;
   private String gxTv_SdtCita_Citalink ;
   private String gxTv_SdtCita_Citalog ;
   private String gxTv_SdtCita_Citaemailgenlink ;
   private String gxTv_SdtCita_Citaarchivonombre ;
   private String gxTv_SdtCita_Citaarchivoextencion ;
   private String gxTv_SdtCita_Citacode_Z ;
   private String gxTv_SdtCita_Pacienteapellidopaterno_Z ;
   private String gxTv_SdtCita_Pacienteapellidomaterno_Z ;
   private String gxTv_SdtCita_Pacientenombres_Z ;
   private String gxTv_SdtCita_Pacientenrodocumento_Z ;
   private String gxTv_SdtCita_Citatipodiagnostico_Z ;
   private String gxTv_SdtCita_Sgcitadisponibilidadespecialidadnombre_Z ;
   private String gxTv_SdtCita_Sgcitadisponibilidadsedenombre_Z ;
   private String gxTv_SdtCita_Sgcitadisponibilidadclinicanombre_Z ;
   private String gxTv_SdtCita_Sgcitadisponibilidadprofullname_Z ;
   private String gxTv_SdtCita_Sgcitadisponibilidadprocop_Z ;
   private String gxTv_SdtCita_Citalink_Z ;
   private String gxTv_SdtCita_Citalog_Z ;
   private String gxTv_SdtCita_Citaemailgenlink_Z ;
   private String gxTv_SdtCita_Citaarchivonombre_Z ;
   private String gxTv_SdtCita_Citaarchivoextencion_Z ;
}

