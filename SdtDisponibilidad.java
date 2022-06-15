package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtDisponibilidad extends GxSilentTrnSdt implements Cloneable, java.io.Serializable
{
   public SdtDisponibilidad( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtDisponibilidad.class));
   }

   public SdtDisponibilidad( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle, context, "SdtDisponibilidad");
      initialize( remoteHandle) ;
   }

   public SdtDisponibilidad( int remoteHandle ,
                             StructSdtDisponibilidad struct )
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

   public void Load( int AV34DisponibilidadId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV34DisponibilidadId)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"DisponibilidadId", int.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Disponibilidad");
      metadata.set("BT", "Disponibilidad");
      metadata.set("PK", "[ \"DisponibilidadId\" ]");
      metadata.set("PKAssigned", "[ \"DisponibilidadId\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"ProfesionalId\",\"EspecialidadId\" ],\"FKMap\":[  ] },{ \"FK\":[ \"SedeId\" ],\"FKMap\":[ \"SGSedeDisponibilidadSedeId-SedeId\" ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "DisponibilidadId") )
            {
               gxTv_SdtDisponibilidad_Disponibilidadid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EventId") )
            {
               gxTv_SdtDisponibilidad_Eventid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DisponibilidadDescription") )
            {
               gxTv_SdtDisponibilidad_Disponibilidaddescription = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalId") )
            {
               gxTv_SdtDisponibilidad_Profesionalid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalApellidoPaterno") )
            {
               gxTv_SdtDisponibilidad_Profesionalapellidopaterno = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalApellidoMaterno") )
            {
               gxTv_SdtDisponibilidad_Profesionalapellidomaterno = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalNombres") )
            {
               gxTv_SdtDisponibilidad_Profesionalnombres = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalNombreCompleto") )
            {
               gxTv_SdtDisponibilidad_Profesionalnombrecompleto = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalCOP") )
            {
               gxTv_SdtDisponibilidad_Profesionalcop = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DisponibilidadFecha") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtDisponibilidad_Disponibilidadfecha = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtDisponibilidad_Disponibilidadfecha = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DisponibilidadHoraInicio") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtDisponibilidad_Disponibilidadhorainicio = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtDisponibilidad_Disponibilidadhorainicio = GXutil.resetDate(localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DisponibilidadHoraFin") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtDisponibilidad_Disponibilidadhorafin = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtDisponibilidad_Disponibilidadhorafin = GXutil.resetDate(localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EspecialidadId") )
            {
               gxTv_SdtDisponibilidad_Especialidadid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EspecialidadCodigo") )
            {
               gxTv_SdtDisponibilidad_Especialidadcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EspecialidadNombre") )
            {
               gxTv_SdtDisponibilidad_Especialidadnombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGSedeDisponibilidadSedeId") )
            {
               gxTv_SdtDisponibilidad_Sgsededisponibilidadsedeid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGSedeDisponibilidadSedeNombre") )
            {
               gxTv_SdtDisponibilidad_Sgsededisponibilidadsedenombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGSedeDisponibilidadClinicaId") )
            {
               gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGSedeDisponibilidadClinicaAbreviado") )
            {
               gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaabreviado = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DisponibilidadUser") )
            {
               gxTv_SdtDisponibilidad_Disponibilidaduser = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DisponibilidadEstado") )
            {
               gxTv_SdtDisponibilidad_Disponibilidadestado = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DisponibilidadEstadoCita") )
            {
               gxTv_SdtDisponibilidad_Disponibilidadestadocita = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DCitaId") )
            {
               gxTv_SdtDisponibilidad_Dcitaid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DisponibilidadTipoCita") )
            {
               gxTv_SdtDisponibilidad_Disponibilidadtipocita = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtDisponibilidad_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtDisponibilidad_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DisponibilidadId_Z") )
            {
               gxTv_SdtDisponibilidad_Disponibilidadid_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EventId_Z") )
            {
               gxTv_SdtDisponibilidad_Eventid_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DisponibilidadDescription_Z") )
            {
               gxTv_SdtDisponibilidad_Disponibilidaddescription_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalId_Z") )
            {
               gxTv_SdtDisponibilidad_Profesionalid_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalApellidoPaterno_Z") )
            {
               gxTv_SdtDisponibilidad_Profesionalapellidopaterno_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalApellidoMaterno_Z") )
            {
               gxTv_SdtDisponibilidad_Profesionalapellidomaterno_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalNombres_Z") )
            {
               gxTv_SdtDisponibilidad_Profesionalnombres_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalNombreCompleto_Z") )
            {
               gxTv_SdtDisponibilidad_Profesionalnombrecompleto_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalCOP_Z") )
            {
               gxTv_SdtDisponibilidad_Profesionalcop_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DisponibilidadFecha_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtDisponibilidad_Disponibilidadfecha_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtDisponibilidad_Disponibilidadfecha_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DisponibilidadHoraInicio_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtDisponibilidad_Disponibilidadhorainicio_Z = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtDisponibilidad_Disponibilidadhorainicio_Z = GXutil.resetDate(localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DisponibilidadHoraFin_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtDisponibilidad_Disponibilidadhorafin_Z = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtDisponibilidad_Disponibilidadhorafin_Z = GXutil.resetDate(localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EspecialidadId_Z") )
            {
               gxTv_SdtDisponibilidad_Especialidadid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EspecialidadCodigo_Z") )
            {
               gxTv_SdtDisponibilidad_Especialidadcodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EspecialidadNombre_Z") )
            {
               gxTv_SdtDisponibilidad_Especialidadnombre_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGSedeDisponibilidadSedeId_Z") )
            {
               gxTv_SdtDisponibilidad_Sgsededisponibilidadsedeid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGSedeDisponibilidadSedeNombre_Z") )
            {
               gxTv_SdtDisponibilidad_Sgsededisponibilidadsedenombre_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGSedeDisponibilidadClinicaId_Z") )
            {
               gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGSedeDisponibilidadClinicaAbreviado_Z") )
            {
               gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaabreviado_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DisponibilidadUser_Z") )
            {
               gxTv_SdtDisponibilidad_Disponibilidaduser_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DisponibilidadEstado_Z") )
            {
               gxTv_SdtDisponibilidad_Disponibilidadestado_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DisponibilidadEstadoCita_Z") )
            {
               gxTv_SdtDisponibilidad_Disponibilidadestadocita_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DCitaId_Z") )
            {
               gxTv_SdtDisponibilidad_Dcitaid_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DisponibilidadTipoCita_Z") )
            {
               gxTv_SdtDisponibilidad_Disponibilidadtipocita_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DisponibilidadId_N") )
            {
               gxTv_SdtDisponibilidad_Disponibilidadid_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DisponibilidadFecha_N") )
            {
               gxTv_SdtDisponibilidad_Disponibilidadfecha_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DisponibilidadHoraInicio_N") )
            {
               gxTv_SdtDisponibilidad_Disponibilidadhorainicio_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DisponibilidadHoraFin_N") )
            {
               gxTv_SdtDisponibilidad_Disponibilidadhorafin_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DCitaId_N") )
            {
               gxTv_SdtDisponibilidad_Dcitaid_N = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "Disponibilidad" ;
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
      oWriter.writeElement("DisponibilidadId", GXutil.trim( GXutil.str( gxTv_SdtDisponibilidad_Disponibilidadid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("EventId", GXutil.rtrim( gxTv_SdtDisponibilidad_Eventid));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("DisponibilidadDescription", GXutil.rtrim( gxTv_SdtDisponibilidad_Disponibilidaddescription));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalId", GXutil.trim( GXutil.str( gxTv_SdtDisponibilidad_Profesionalid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalApellidoPaterno", GXutil.rtrim( gxTv_SdtDisponibilidad_Profesionalapellidopaterno));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalApellidoMaterno", GXutil.rtrim( gxTv_SdtDisponibilidad_Profesionalapellidomaterno));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalNombres", GXutil.rtrim( gxTv_SdtDisponibilidad_Profesionalnombres));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalNombreCompleto", GXutil.rtrim( gxTv_SdtDisponibilidad_Profesionalnombrecompleto));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalCOP", GXutil.rtrim( gxTv_SdtDisponibilidad_Profesionalcop));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtDisponibilidad_Disponibilidadfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtDisponibilidad_Disponibilidadfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtDisponibilidad_Disponibilidadfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("DisponibilidadFecha", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtDisponibilidad_Disponibilidadhorainicio), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtDisponibilidad_Disponibilidadhorainicio), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtDisponibilidad_Disponibilidadhorainicio), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtDisponibilidad_Disponibilidadhorainicio), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtDisponibilidad_Disponibilidadhorainicio), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtDisponibilidad_Disponibilidadhorainicio), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("DisponibilidadHoraInicio", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtDisponibilidad_Disponibilidadhorafin), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtDisponibilidad_Disponibilidadhorafin), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtDisponibilidad_Disponibilidadhorafin), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtDisponibilidad_Disponibilidadhorafin), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtDisponibilidad_Disponibilidadhorafin), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtDisponibilidad_Disponibilidadhorafin), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("DisponibilidadHoraFin", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("EspecialidadId", GXutil.trim( GXutil.str( gxTv_SdtDisponibilidad_Especialidadid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("EspecialidadCodigo", GXutil.rtrim( gxTv_SdtDisponibilidad_Especialidadcodigo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("EspecialidadNombre", GXutil.rtrim( gxTv_SdtDisponibilidad_Especialidadnombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGSedeDisponibilidadSedeId", GXutil.trim( GXutil.str( gxTv_SdtDisponibilidad_Sgsededisponibilidadsedeid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGSedeDisponibilidadSedeNombre", GXutil.rtrim( gxTv_SdtDisponibilidad_Sgsededisponibilidadsedenombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGSedeDisponibilidadClinicaId", GXutil.trim( GXutil.str( gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGSedeDisponibilidadClinicaAbreviado", GXutil.rtrim( gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaabreviado));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("DisponibilidadUser", GXutil.trim( GXutil.str( gxTv_SdtDisponibilidad_Disponibilidaduser, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("DisponibilidadEstado", GXutil.rtrim( gxTv_SdtDisponibilidad_Disponibilidadestado));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("DisponibilidadEstadoCita", GXutil.rtrim( gxTv_SdtDisponibilidad_Disponibilidadestadocita));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("DCitaId", GXutil.trim( GXutil.str( gxTv_SdtDisponibilidad_Dcitaid, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("DisponibilidadTipoCita", GXutil.rtrim( gxTv_SdtDisponibilidad_Disponibilidadtipocita));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", GXutil.rtrim( gxTv_SdtDisponibilidad_Mode));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtDisponibilidad_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("DisponibilidadId_Z", GXutil.trim( GXutil.str( gxTv_SdtDisponibilidad_Disponibilidadid_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("EventId_Z", GXutil.rtrim( gxTv_SdtDisponibilidad_Eventid_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("DisponibilidadDescription_Z", GXutil.rtrim( gxTv_SdtDisponibilidad_Disponibilidaddescription_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ProfesionalId_Z", GXutil.trim( GXutil.str( gxTv_SdtDisponibilidad_Profesionalid_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ProfesionalApellidoPaterno_Z", GXutil.rtrim( gxTv_SdtDisponibilidad_Profesionalapellidopaterno_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ProfesionalApellidoMaterno_Z", GXutil.rtrim( gxTv_SdtDisponibilidad_Profesionalapellidomaterno_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ProfesionalNombres_Z", GXutil.rtrim( gxTv_SdtDisponibilidad_Profesionalnombres_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ProfesionalNombreCompleto_Z", GXutil.rtrim( gxTv_SdtDisponibilidad_Profesionalnombrecompleto_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ProfesionalCOP_Z", GXutil.rtrim( gxTv_SdtDisponibilidad_Profesionalcop_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtDisponibilidad_Disponibilidadfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtDisponibilidad_Disponibilidadfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtDisponibilidad_Disponibilidadfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("DisponibilidadFecha_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtDisponibilidad_Disponibilidadhorainicio_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtDisponibilidad_Disponibilidadhorainicio_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtDisponibilidad_Disponibilidadhorainicio_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtDisponibilidad_Disponibilidadhorainicio_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtDisponibilidad_Disponibilidadhorainicio_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtDisponibilidad_Disponibilidadhorainicio_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("DisponibilidadHoraInicio_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtDisponibilidad_Disponibilidadhorafin_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtDisponibilidad_Disponibilidadhorafin_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtDisponibilidad_Disponibilidadhorafin_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtDisponibilidad_Disponibilidadhorafin_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtDisponibilidad_Disponibilidadhorafin_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtDisponibilidad_Disponibilidadhorafin_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("DisponibilidadHoraFin_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("EspecialidadId_Z", GXutil.trim( GXutil.str( gxTv_SdtDisponibilidad_Especialidadid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("EspecialidadCodigo_Z", GXutil.rtrim( gxTv_SdtDisponibilidad_Especialidadcodigo_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("EspecialidadNombre_Z", GXutil.rtrim( gxTv_SdtDisponibilidad_Especialidadnombre_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SGSedeDisponibilidadSedeId_Z", GXutil.trim( GXutil.str( gxTv_SdtDisponibilidad_Sgsededisponibilidadsedeid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SGSedeDisponibilidadSedeNombre_Z", GXutil.rtrim( gxTv_SdtDisponibilidad_Sgsededisponibilidadsedenombre_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SGSedeDisponibilidadClinicaId_Z", GXutil.trim( GXutil.str( gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SGSedeDisponibilidadClinicaAbreviado_Z", GXutil.rtrim( gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaabreviado_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("DisponibilidadUser_Z", GXutil.trim( GXutil.str( gxTv_SdtDisponibilidad_Disponibilidaduser_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("DisponibilidadEstado_Z", GXutil.rtrim( gxTv_SdtDisponibilidad_Disponibilidadestado_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("DisponibilidadEstadoCita_Z", GXutil.rtrim( gxTv_SdtDisponibilidad_Disponibilidadestadocita_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("DCitaId_Z", GXutil.trim( GXutil.str( gxTv_SdtDisponibilidad_Dcitaid_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("DisponibilidadTipoCita_Z", GXutil.rtrim( gxTv_SdtDisponibilidad_Disponibilidadtipocita_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("DisponibilidadId_N", GXutil.trim( GXutil.str( gxTv_SdtDisponibilidad_Disponibilidadid_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("DisponibilidadFecha_N", GXutil.trim( GXutil.str( gxTv_SdtDisponibilidad_Disponibilidadfecha_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("DisponibilidadHoraInicio_N", GXutil.trim( GXutil.str( gxTv_SdtDisponibilidad_Disponibilidadhorainicio_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("DisponibilidadHoraFin_N", GXutil.trim( GXutil.str( gxTv_SdtDisponibilidad_Disponibilidadhorafin_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("DCitaId_N", GXutil.trim( GXutil.str( gxTv_SdtDisponibilidad_Dcitaid_N, 1, 0)));
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
      AddObjectProperty("DisponibilidadId", gxTv_SdtDisponibilidad_Disponibilidadid, false, includeNonInitialized);
      AddObjectProperty("DisponibilidadId_N", gxTv_SdtDisponibilidad_Disponibilidadid_N, false, includeNonInitialized);
      AddObjectProperty("EventId", gxTv_SdtDisponibilidad_Eventid, false, includeNonInitialized);
      AddObjectProperty("DisponibilidadDescription", gxTv_SdtDisponibilidad_Disponibilidaddescription, false, includeNonInitialized);
      AddObjectProperty("ProfesionalId", gxTv_SdtDisponibilidad_Profesionalid, false, includeNonInitialized);
      AddObjectProperty("ProfesionalApellidoPaterno", gxTv_SdtDisponibilidad_Profesionalapellidopaterno, false, includeNonInitialized);
      AddObjectProperty("ProfesionalApellidoMaterno", gxTv_SdtDisponibilidad_Profesionalapellidomaterno, false, includeNonInitialized);
      AddObjectProperty("ProfesionalNombres", gxTv_SdtDisponibilidad_Profesionalnombres, false, includeNonInitialized);
      AddObjectProperty("ProfesionalNombreCompleto", gxTv_SdtDisponibilidad_Profesionalnombrecompleto, false, includeNonInitialized);
      AddObjectProperty("ProfesionalCOP", gxTv_SdtDisponibilidad_Profesionalcop, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtDisponibilidad_Disponibilidadfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtDisponibilidad_Disponibilidadfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtDisponibilidad_Disponibilidadfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("DisponibilidadFecha", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("DisponibilidadFecha_N", gxTv_SdtDisponibilidad_Disponibilidadfecha_N, false, includeNonInitialized);
      datetime_STZ = gxTv_SdtDisponibilidad_Disponibilidadhorainicio ;
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
      AddObjectProperty("DisponibilidadHoraInicio", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("DisponibilidadHoraInicio_N", gxTv_SdtDisponibilidad_Disponibilidadhorainicio_N, false, includeNonInitialized);
      datetime_STZ = gxTv_SdtDisponibilidad_Disponibilidadhorafin ;
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
      AddObjectProperty("DisponibilidadHoraFin", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("DisponibilidadHoraFin_N", gxTv_SdtDisponibilidad_Disponibilidadhorafin_N, false, includeNonInitialized);
      AddObjectProperty("EspecialidadId", gxTv_SdtDisponibilidad_Especialidadid, false, includeNonInitialized);
      AddObjectProperty("EspecialidadCodigo", gxTv_SdtDisponibilidad_Especialidadcodigo, false, includeNonInitialized);
      AddObjectProperty("EspecialidadNombre", gxTv_SdtDisponibilidad_Especialidadnombre, false, includeNonInitialized);
      AddObjectProperty("SGSedeDisponibilidadSedeId", gxTv_SdtDisponibilidad_Sgsededisponibilidadsedeid, false, includeNonInitialized);
      AddObjectProperty("SGSedeDisponibilidadSedeNombre", gxTv_SdtDisponibilidad_Sgsededisponibilidadsedenombre, false, includeNonInitialized);
      AddObjectProperty("SGSedeDisponibilidadClinicaId", gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaid, false, includeNonInitialized);
      AddObjectProperty("SGSedeDisponibilidadClinicaAbreviado", gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaabreviado, false, includeNonInitialized);
      AddObjectProperty("DisponibilidadUser", gxTv_SdtDisponibilidad_Disponibilidaduser, false, includeNonInitialized);
      AddObjectProperty("DisponibilidadEstado", gxTv_SdtDisponibilidad_Disponibilidadestado, false, includeNonInitialized);
      AddObjectProperty("DisponibilidadEstadoCita", gxTv_SdtDisponibilidad_Disponibilidadestadocita, false, includeNonInitialized);
      AddObjectProperty("DCitaId", gxTv_SdtDisponibilidad_Dcitaid, false, includeNonInitialized);
      AddObjectProperty("DCitaId_N", gxTv_SdtDisponibilidad_Dcitaid_N, false, includeNonInitialized);
      AddObjectProperty("DisponibilidadTipoCita", gxTv_SdtDisponibilidad_Disponibilidadtipocita, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtDisponibilidad_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtDisponibilidad_Initialized, false, includeNonInitialized);
         AddObjectProperty("DisponibilidadId_Z", gxTv_SdtDisponibilidad_Disponibilidadid_Z, false, includeNonInitialized);
         AddObjectProperty("EventId_Z", gxTv_SdtDisponibilidad_Eventid_Z, false, includeNonInitialized);
         AddObjectProperty("DisponibilidadDescription_Z", gxTv_SdtDisponibilidad_Disponibilidaddescription_Z, false, includeNonInitialized);
         AddObjectProperty("ProfesionalId_Z", gxTv_SdtDisponibilidad_Profesionalid_Z, false, includeNonInitialized);
         AddObjectProperty("ProfesionalApellidoPaterno_Z", gxTv_SdtDisponibilidad_Profesionalapellidopaterno_Z, false, includeNonInitialized);
         AddObjectProperty("ProfesionalApellidoMaterno_Z", gxTv_SdtDisponibilidad_Profesionalapellidomaterno_Z, false, includeNonInitialized);
         AddObjectProperty("ProfesionalNombres_Z", gxTv_SdtDisponibilidad_Profesionalnombres_Z, false, includeNonInitialized);
         AddObjectProperty("ProfesionalNombreCompleto_Z", gxTv_SdtDisponibilidad_Profesionalnombrecompleto_Z, false, includeNonInitialized);
         AddObjectProperty("ProfesionalCOP_Z", gxTv_SdtDisponibilidad_Profesionalcop_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtDisponibilidad_Disponibilidadfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtDisponibilidad_Disponibilidadfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtDisponibilidad_Disponibilidadfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("DisponibilidadFecha_Z", sDateCnv, false, includeNonInitialized);
         datetime_STZ = gxTv_SdtDisponibilidad_Disponibilidadhorainicio_Z ;
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
         AddObjectProperty("DisponibilidadHoraInicio_Z", sDateCnv, false, includeNonInitialized);
         datetime_STZ = gxTv_SdtDisponibilidad_Disponibilidadhorafin_Z ;
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
         AddObjectProperty("DisponibilidadHoraFin_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("EspecialidadId_Z", gxTv_SdtDisponibilidad_Especialidadid_Z, false, includeNonInitialized);
         AddObjectProperty("EspecialidadCodigo_Z", gxTv_SdtDisponibilidad_Especialidadcodigo_Z, false, includeNonInitialized);
         AddObjectProperty("EspecialidadNombre_Z", gxTv_SdtDisponibilidad_Especialidadnombre_Z, false, includeNonInitialized);
         AddObjectProperty("SGSedeDisponibilidadSedeId_Z", gxTv_SdtDisponibilidad_Sgsededisponibilidadsedeid_Z, false, includeNonInitialized);
         AddObjectProperty("SGSedeDisponibilidadSedeNombre_Z", gxTv_SdtDisponibilidad_Sgsededisponibilidadsedenombre_Z, false, includeNonInitialized);
         AddObjectProperty("SGSedeDisponibilidadClinicaId_Z", gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaid_Z, false, includeNonInitialized);
         AddObjectProperty("SGSedeDisponibilidadClinicaAbreviado_Z", gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaabreviado_Z, false, includeNonInitialized);
         AddObjectProperty("DisponibilidadUser_Z", gxTv_SdtDisponibilidad_Disponibilidaduser_Z, false, includeNonInitialized);
         AddObjectProperty("DisponibilidadEstado_Z", gxTv_SdtDisponibilidad_Disponibilidadestado_Z, false, includeNonInitialized);
         AddObjectProperty("DisponibilidadEstadoCita_Z", gxTv_SdtDisponibilidad_Disponibilidadestadocita_Z, false, includeNonInitialized);
         AddObjectProperty("DCitaId_Z", gxTv_SdtDisponibilidad_Dcitaid_Z, false, includeNonInitialized);
         AddObjectProperty("DisponibilidadTipoCita_Z", gxTv_SdtDisponibilidad_Disponibilidadtipocita_Z, false, includeNonInitialized);
         AddObjectProperty("DisponibilidadId_N", gxTv_SdtDisponibilidad_Disponibilidadid_N, false, includeNonInitialized);
         AddObjectProperty("DisponibilidadFecha_N", gxTv_SdtDisponibilidad_Disponibilidadfecha_N, false, includeNonInitialized);
         AddObjectProperty("DisponibilidadHoraInicio_N", gxTv_SdtDisponibilidad_Disponibilidadhorainicio_N, false, includeNonInitialized);
         AddObjectProperty("DisponibilidadHoraFin_N", gxTv_SdtDisponibilidad_Disponibilidadhorafin_N, false, includeNonInitialized);
         AddObjectProperty("DCitaId_N", gxTv_SdtDisponibilidad_Dcitaid_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.projectthani.SdtDisponibilidad sdt )
   {
      if ( sdt.IsDirty("DisponibilidadId") )
      {
         gxTv_SdtDisponibilidad_N = (byte)(0) ;
         gxTv_SdtDisponibilidad_Disponibilidadid = sdt.getgxTv_SdtDisponibilidad_Disponibilidadid() ;
      }
      if ( sdt.IsDirty("EventId") )
      {
         gxTv_SdtDisponibilidad_N = (byte)(0) ;
         gxTv_SdtDisponibilidad_Eventid = sdt.getgxTv_SdtDisponibilidad_Eventid() ;
      }
      if ( sdt.IsDirty("DisponibilidadDescription") )
      {
         gxTv_SdtDisponibilidad_N = (byte)(0) ;
         gxTv_SdtDisponibilidad_Disponibilidaddescription = sdt.getgxTv_SdtDisponibilidad_Disponibilidaddescription() ;
      }
      if ( sdt.IsDirty("ProfesionalId") )
      {
         gxTv_SdtDisponibilidad_N = (byte)(0) ;
         gxTv_SdtDisponibilidad_Profesionalid = sdt.getgxTv_SdtDisponibilidad_Profesionalid() ;
      }
      if ( sdt.IsDirty("ProfesionalApellidoPaterno") )
      {
         gxTv_SdtDisponibilidad_N = (byte)(0) ;
         gxTv_SdtDisponibilidad_Profesionalapellidopaterno = sdt.getgxTv_SdtDisponibilidad_Profesionalapellidopaterno() ;
      }
      if ( sdt.IsDirty("ProfesionalApellidoMaterno") )
      {
         gxTv_SdtDisponibilidad_N = (byte)(0) ;
         gxTv_SdtDisponibilidad_Profesionalapellidomaterno = sdt.getgxTv_SdtDisponibilidad_Profesionalapellidomaterno() ;
      }
      if ( sdt.IsDirty("ProfesionalNombres") )
      {
         gxTv_SdtDisponibilidad_N = (byte)(0) ;
         gxTv_SdtDisponibilidad_Profesionalnombres = sdt.getgxTv_SdtDisponibilidad_Profesionalnombres() ;
      }
      if ( sdt.IsDirty("ProfesionalNombreCompleto") )
      {
         gxTv_SdtDisponibilidad_N = (byte)(0) ;
         gxTv_SdtDisponibilidad_Profesionalnombrecompleto = sdt.getgxTv_SdtDisponibilidad_Profesionalnombrecompleto() ;
      }
      if ( sdt.IsDirty("ProfesionalCOP") )
      {
         gxTv_SdtDisponibilidad_N = (byte)(0) ;
         gxTv_SdtDisponibilidad_Profesionalcop = sdt.getgxTv_SdtDisponibilidad_Profesionalcop() ;
      }
      if ( sdt.IsDirty("DisponibilidadFecha") )
      {
         gxTv_SdtDisponibilidad_Disponibilidadfecha_N = (byte)(0) ;
         gxTv_SdtDisponibilidad_N = (byte)(0) ;
         gxTv_SdtDisponibilidad_Disponibilidadfecha = sdt.getgxTv_SdtDisponibilidad_Disponibilidadfecha() ;
      }
      if ( sdt.IsDirty("DisponibilidadHoraInicio") )
      {
         gxTv_SdtDisponibilidad_Disponibilidadhorainicio_N = (byte)(0) ;
         gxTv_SdtDisponibilidad_N = (byte)(0) ;
         gxTv_SdtDisponibilidad_Disponibilidadhorainicio = sdt.getgxTv_SdtDisponibilidad_Disponibilidadhorainicio() ;
      }
      if ( sdt.IsDirty("DisponibilidadHoraFin") )
      {
         gxTv_SdtDisponibilidad_Disponibilidadhorafin_N = (byte)(0) ;
         gxTv_SdtDisponibilidad_N = (byte)(0) ;
         gxTv_SdtDisponibilidad_Disponibilidadhorafin = sdt.getgxTv_SdtDisponibilidad_Disponibilidadhorafin() ;
      }
      if ( sdt.IsDirty("EspecialidadId") )
      {
         gxTv_SdtDisponibilidad_N = (byte)(0) ;
         gxTv_SdtDisponibilidad_Especialidadid = sdt.getgxTv_SdtDisponibilidad_Especialidadid() ;
      }
      if ( sdt.IsDirty("EspecialidadCodigo") )
      {
         gxTv_SdtDisponibilidad_N = (byte)(0) ;
         gxTv_SdtDisponibilidad_Especialidadcodigo = sdt.getgxTv_SdtDisponibilidad_Especialidadcodigo() ;
      }
      if ( sdt.IsDirty("EspecialidadNombre") )
      {
         gxTv_SdtDisponibilidad_N = (byte)(0) ;
         gxTv_SdtDisponibilidad_Especialidadnombre = sdt.getgxTv_SdtDisponibilidad_Especialidadnombre() ;
      }
      if ( sdt.IsDirty("SGSedeDisponibilidadSedeId") )
      {
         gxTv_SdtDisponibilidad_N = (byte)(0) ;
         gxTv_SdtDisponibilidad_Sgsededisponibilidadsedeid = sdt.getgxTv_SdtDisponibilidad_Sgsededisponibilidadsedeid() ;
      }
      if ( sdt.IsDirty("SGSedeDisponibilidadSedeNombre") )
      {
         gxTv_SdtDisponibilidad_N = (byte)(0) ;
         gxTv_SdtDisponibilidad_Sgsededisponibilidadsedenombre = sdt.getgxTv_SdtDisponibilidad_Sgsededisponibilidadsedenombre() ;
      }
      if ( sdt.IsDirty("SGSedeDisponibilidadClinicaId") )
      {
         gxTv_SdtDisponibilidad_N = (byte)(0) ;
         gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaid = sdt.getgxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaid() ;
      }
      if ( sdt.IsDirty("SGSedeDisponibilidadClinicaAbreviado") )
      {
         gxTv_SdtDisponibilidad_N = (byte)(0) ;
         gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaabreviado = sdt.getgxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaabreviado() ;
      }
      if ( sdt.IsDirty("DisponibilidadUser") )
      {
         gxTv_SdtDisponibilidad_N = (byte)(0) ;
         gxTv_SdtDisponibilidad_Disponibilidaduser = sdt.getgxTv_SdtDisponibilidad_Disponibilidaduser() ;
      }
      if ( sdt.IsDirty("DisponibilidadEstado") )
      {
         gxTv_SdtDisponibilidad_N = (byte)(0) ;
         gxTv_SdtDisponibilidad_Disponibilidadestado = sdt.getgxTv_SdtDisponibilidad_Disponibilidadestado() ;
      }
      if ( sdt.IsDirty("DisponibilidadEstadoCita") )
      {
         gxTv_SdtDisponibilidad_N = (byte)(0) ;
         gxTv_SdtDisponibilidad_Disponibilidadestadocita = sdt.getgxTv_SdtDisponibilidad_Disponibilidadestadocita() ;
      }
      if ( sdt.IsDirty("DCitaId") )
      {
         gxTv_SdtDisponibilidad_Dcitaid_N = (byte)(0) ;
         gxTv_SdtDisponibilidad_N = (byte)(0) ;
         gxTv_SdtDisponibilidad_Dcitaid = sdt.getgxTv_SdtDisponibilidad_Dcitaid() ;
      }
      if ( sdt.IsDirty("DisponibilidadTipoCita") )
      {
         gxTv_SdtDisponibilidad_N = (byte)(0) ;
         gxTv_SdtDisponibilidad_Disponibilidadtipocita = sdt.getgxTv_SdtDisponibilidad_Disponibilidadtipocita() ;
      }
   }

   public int getgxTv_SdtDisponibilidad_Disponibilidadid( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidadid ;
   }

   public void setgxTv_SdtDisponibilidad_Disponibilidadid( int value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      if ( gxTv_SdtDisponibilidad_Disponibilidadid != value )
      {
         gxTv_SdtDisponibilidad_Mode = "INS" ;
         this.setgxTv_SdtDisponibilidad_Disponibilidadid_Z_SetNull( );
         this.setgxTv_SdtDisponibilidad_Eventid_Z_SetNull( );
         this.setgxTv_SdtDisponibilidad_Disponibilidaddescription_Z_SetNull( );
         this.setgxTv_SdtDisponibilidad_Profesionalid_Z_SetNull( );
         this.setgxTv_SdtDisponibilidad_Profesionalapellidopaterno_Z_SetNull( );
         this.setgxTv_SdtDisponibilidad_Profesionalapellidomaterno_Z_SetNull( );
         this.setgxTv_SdtDisponibilidad_Profesionalnombres_Z_SetNull( );
         this.setgxTv_SdtDisponibilidad_Profesionalnombrecompleto_Z_SetNull( );
         this.setgxTv_SdtDisponibilidad_Profesionalcop_Z_SetNull( );
         this.setgxTv_SdtDisponibilidad_Disponibilidadfecha_Z_SetNull( );
         this.setgxTv_SdtDisponibilidad_Disponibilidadhorainicio_Z_SetNull( );
         this.setgxTv_SdtDisponibilidad_Disponibilidadhorafin_Z_SetNull( );
         this.setgxTv_SdtDisponibilidad_Especialidadid_Z_SetNull( );
         this.setgxTv_SdtDisponibilidad_Especialidadcodigo_Z_SetNull( );
         this.setgxTv_SdtDisponibilidad_Especialidadnombre_Z_SetNull( );
         this.setgxTv_SdtDisponibilidad_Sgsededisponibilidadsedeid_Z_SetNull( );
         this.setgxTv_SdtDisponibilidad_Sgsededisponibilidadsedenombre_Z_SetNull( );
         this.setgxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaid_Z_SetNull( );
         this.setgxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaabreviado_Z_SetNull( );
         this.setgxTv_SdtDisponibilidad_Disponibilidaduser_Z_SetNull( );
         this.setgxTv_SdtDisponibilidad_Disponibilidadestado_Z_SetNull( );
         this.setgxTv_SdtDisponibilidad_Disponibilidadestadocita_Z_SetNull( );
         this.setgxTv_SdtDisponibilidad_Dcitaid_Z_SetNull( );
         this.setgxTv_SdtDisponibilidad_Disponibilidadtipocita_Z_SetNull( );
      }
      SetDirty("Disponibilidadid");
      gxTv_SdtDisponibilidad_Disponibilidadid = value ;
   }

   public String getgxTv_SdtDisponibilidad_Eventid( )
   {
      return gxTv_SdtDisponibilidad_Eventid ;
   }

   public void setgxTv_SdtDisponibilidad_Eventid( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Eventid");
      gxTv_SdtDisponibilidad_Eventid = value ;
   }

   public String getgxTv_SdtDisponibilidad_Disponibilidaddescription( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidaddescription ;
   }

   public void setgxTv_SdtDisponibilidad_Disponibilidaddescription( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Disponibilidaddescription");
      gxTv_SdtDisponibilidad_Disponibilidaddescription = value ;
   }

   public int getgxTv_SdtDisponibilidad_Profesionalid( )
   {
      return gxTv_SdtDisponibilidad_Profesionalid ;
   }

   public void setgxTv_SdtDisponibilidad_Profesionalid( int value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Profesionalid");
      gxTv_SdtDisponibilidad_Profesionalid = value ;
   }

   public String getgxTv_SdtDisponibilidad_Profesionalapellidopaterno( )
   {
      return gxTv_SdtDisponibilidad_Profesionalapellidopaterno ;
   }

   public void setgxTv_SdtDisponibilidad_Profesionalapellidopaterno( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Profesionalapellidopaterno");
      gxTv_SdtDisponibilidad_Profesionalapellidopaterno = value ;
   }

   public String getgxTv_SdtDisponibilidad_Profesionalapellidomaterno( )
   {
      return gxTv_SdtDisponibilidad_Profesionalapellidomaterno ;
   }

   public void setgxTv_SdtDisponibilidad_Profesionalapellidomaterno( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Profesionalapellidomaterno");
      gxTv_SdtDisponibilidad_Profesionalapellidomaterno = value ;
   }

   public String getgxTv_SdtDisponibilidad_Profesionalnombres( )
   {
      return gxTv_SdtDisponibilidad_Profesionalnombres ;
   }

   public void setgxTv_SdtDisponibilidad_Profesionalnombres( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Profesionalnombres");
      gxTv_SdtDisponibilidad_Profesionalnombres = value ;
   }

   public String getgxTv_SdtDisponibilidad_Profesionalnombrecompleto( )
   {
      return gxTv_SdtDisponibilidad_Profesionalnombrecompleto ;
   }

   public void setgxTv_SdtDisponibilidad_Profesionalnombrecompleto( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Profesionalnombrecompleto");
      gxTv_SdtDisponibilidad_Profesionalnombrecompleto = value ;
   }

   public void setgxTv_SdtDisponibilidad_Profesionalnombrecompleto_SetNull( )
   {
      gxTv_SdtDisponibilidad_Profesionalnombrecompleto = "" ;
   }

   public boolean getgxTv_SdtDisponibilidad_Profesionalnombrecompleto_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtDisponibilidad_Profesionalcop( )
   {
      return gxTv_SdtDisponibilidad_Profesionalcop ;
   }

   public void setgxTv_SdtDisponibilidad_Profesionalcop( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Profesionalcop");
      gxTv_SdtDisponibilidad_Profesionalcop = value ;
   }

   public java.util.Date getgxTv_SdtDisponibilidad_Disponibilidadfecha( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidadfecha ;
   }

   public void setgxTv_SdtDisponibilidad_Disponibilidadfecha( java.util.Date value )
   {
      gxTv_SdtDisponibilidad_Disponibilidadfecha_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Disponibilidadfecha");
      gxTv_SdtDisponibilidad_Disponibilidadfecha = value ;
   }

   public void setgxTv_SdtDisponibilidad_Disponibilidadfecha_SetNull( )
   {
      gxTv_SdtDisponibilidad_Disponibilidadfecha_N = (byte)(1) ;
      gxTv_SdtDisponibilidad_Disponibilidadfecha = GXutil.nullDate() ;
   }

   public boolean getgxTv_SdtDisponibilidad_Disponibilidadfecha_IsNull( )
   {
      return (gxTv_SdtDisponibilidad_Disponibilidadfecha_N==1) ;
   }

   public java.util.Date getgxTv_SdtDisponibilidad_Disponibilidadhorainicio( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidadhorainicio ;
   }

   public void setgxTv_SdtDisponibilidad_Disponibilidadhorainicio( java.util.Date value )
   {
      gxTv_SdtDisponibilidad_Disponibilidadhorainicio_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Disponibilidadhorainicio");
      gxTv_SdtDisponibilidad_Disponibilidadhorainicio = value ;
   }

   public void setgxTv_SdtDisponibilidad_Disponibilidadhorainicio_SetNull( )
   {
      gxTv_SdtDisponibilidad_Disponibilidadhorainicio_N = (byte)(1) ;
      gxTv_SdtDisponibilidad_Disponibilidadhorainicio = GXutil.resetTime( GXutil.nullDate() );
   }

   public boolean getgxTv_SdtDisponibilidad_Disponibilidadhorainicio_IsNull( )
   {
      return (gxTv_SdtDisponibilidad_Disponibilidadhorainicio_N==1) ;
   }

   public java.util.Date getgxTv_SdtDisponibilidad_Disponibilidadhorafin( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidadhorafin ;
   }

   public void setgxTv_SdtDisponibilidad_Disponibilidadhorafin( java.util.Date value )
   {
      gxTv_SdtDisponibilidad_Disponibilidadhorafin_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Disponibilidadhorafin");
      gxTv_SdtDisponibilidad_Disponibilidadhorafin = value ;
   }

   public void setgxTv_SdtDisponibilidad_Disponibilidadhorafin_SetNull( )
   {
      gxTv_SdtDisponibilidad_Disponibilidadhorafin_N = (byte)(1) ;
      gxTv_SdtDisponibilidad_Disponibilidadhorafin = GXutil.resetTime( GXutil.nullDate() );
   }

   public boolean getgxTv_SdtDisponibilidad_Disponibilidadhorafin_IsNull( )
   {
      return (gxTv_SdtDisponibilidad_Disponibilidadhorafin_N==1) ;
   }

   public short getgxTv_SdtDisponibilidad_Especialidadid( )
   {
      return gxTv_SdtDisponibilidad_Especialidadid ;
   }

   public void setgxTv_SdtDisponibilidad_Especialidadid( short value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Especialidadid");
      gxTv_SdtDisponibilidad_Especialidadid = value ;
   }

   public String getgxTv_SdtDisponibilidad_Especialidadcodigo( )
   {
      return gxTv_SdtDisponibilidad_Especialidadcodigo ;
   }

   public void setgxTv_SdtDisponibilidad_Especialidadcodigo( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Especialidadcodigo");
      gxTv_SdtDisponibilidad_Especialidadcodigo = value ;
   }

   public String getgxTv_SdtDisponibilidad_Especialidadnombre( )
   {
      return gxTv_SdtDisponibilidad_Especialidadnombre ;
   }

   public void setgxTv_SdtDisponibilidad_Especialidadnombre( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Especialidadnombre");
      gxTv_SdtDisponibilidad_Especialidadnombre = value ;
   }

   public short getgxTv_SdtDisponibilidad_Sgsededisponibilidadsedeid( )
   {
      return gxTv_SdtDisponibilidad_Sgsededisponibilidadsedeid ;
   }

   public void setgxTv_SdtDisponibilidad_Sgsededisponibilidadsedeid( short value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Sgsededisponibilidadsedeid");
      gxTv_SdtDisponibilidad_Sgsededisponibilidadsedeid = value ;
   }

   public String getgxTv_SdtDisponibilidad_Sgsededisponibilidadsedenombre( )
   {
      return gxTv_SdtDisponibilidad_Sgsededisponibilidadsedenombre ;
   }

   public void setgxTv_SdtDisponibilidad_Sgsededisponibilidadsedenombre( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Sgsededisponibilidadsedenombre");
      gxTv_SdtDisponibilidad_Sgsededisponibilidadsedenombre = value ;
   }

   public short getgxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaid( )
   {
      return gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaid ;
   }

   public void setgxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaid( short value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Sgsededisponibilidadclinicaid");
      gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaid = value ;
   }

   public String getgxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaabreviado( )
   {
      return gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaabreviado ;
   }

   public void setgxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaabreviado( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Sgsededisponibilidadclinicaabreviado");
      gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaabreviado = value ;
   }

   public int getgxTv_SdtDisponibilidad_Disponibilidaduser( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidaduser ;
   }

   public void setgxTv_SdtDisponibilidad_Disponibilidaduser( int value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Disponibilidaduser");
      gxTv_SdtDisponibilidad_Disponibilidaduser = value ;
   }

   public String getgxTv_SdtDisponibilidad_Disponibilidadestado( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidadestado ;
   }

   public void setgxTv_SdtDisponibilidad_Disponibilidadestado( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Disponibilidadestado");
      gxTv_SdtDisponibilidad_Disponibilidadestado = value ;
   }

   public String getgxTv_SdtDisponibilidad_Disponibilidadestadocita( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidadestadocita ;
   }

   public void setgxTv_SdtDisponibilidad_Disponibilidadestadocita( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Disponibilidadestadocita");
      gxTv_SdtDisponibilidad_Disponibilidadestadocita = value ;
   }

   public int getgxTv_SdtDisponibilidad_Dcitaid( )
   {
      return gxTv_SdtDisponibilidad_Dcitaid ;
   }

   public void setgxTv_SdtDisponibilidad_Dcitaid( int value )
   {
      gxTv_SdtDisponibilidad_Dcitaid_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Dcitaid");
      gxTv_SdtDisponibilidad_Dcitaid = value ;
   }

   public void setgxTv_SdtDisponibilidad_Dcitaid_SetNull( )
   {
      gxTv_SdtDisponibilidad_Dcitaid_N = (byte)(1) ;
      gxTv_SdtDisponibilidad_Dcitaid = 0 ;
   }

   public boolean getgxTv_SdtDisponibilidad_Dcitaid_IsNull( )
   {
      return (gxTv_SdtDisponibilidad_Dcitaid_N==1) ;
   }

   public String getgxTv_SdtDisponibilidad_Disponibilidadtipocita( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidadtipocita ;
   }

   public void setgxTv_SdtDisponibilidad_Disponibilidadtipocita( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Disponibilidadtipocita");
      gxTv_SdtDisponibilidad_Disponibilidadtipocita = value ;
   }

   public String getgxTv_SdtDisponibilidad_Mode( )
   {
      return gxTv_SdtDisponibilidad_Mode ;
   }

   public void setgxTv_SdtDisponibilidad_Mode( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtDisponibilidad_Mode = value ;
   }

   public void setgxTv_SdtDisponibilidad_Mode_SetNull( )
   {
      gxTv_SdtDisponibilidad_Mode = "" ;
   }

   public boolean getgxTv_SdtDisponibilidad_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtDisponibilidad_Initialized( )
   {
      return gxTv_SdtDisponibilidad_Initialized ;
   }

   public void setgxTv_SdtDisponibilidad_Initialized( short value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtDisponibilidad_Initialized = value ;
   }

   public void setgxTv_SdtDisponibilidad_Initialized_SetNull( )
   {
      gxTv_SdtDisponibilidad_Initialized = (short)(0) ;
   }

   public boolean getgxTv_SdtDisponibilidad_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtDisponibilidad_Disponibilidadid_Z( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidadid_Z ;
   }

   public void setgxTv_SdtDisponibilidad_Disponibilidadid_Z( int value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Disponibilidadid_Z");
      gxTv_SdtDisponibilidad_Disponibilidadid_Z = value ;
   }

   public void setgxTv_SdtDisponibilidad_Disponibilidadid_Z_SetNull( )
   {
      gxTv_SdtDisponibilidad_Disponibilidadid_Z = 0 ;
   }

   public boolean getgxTv_SdtDisponibilidad_Disponibilidadid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtDisponibilidad_Eventid_Z( )
   {
      return gxTv_SdtDisponibilidad_Eventid_Z ;
   }

   public void setgxTv_SdtDisponibilidad_Eventid_Z( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Eventid_Z");
      gxTv_SdtDisponibilidad_Eventid_Z = value ;
   }

   public void setgxTv_SdtDisponibilidad_Eventid_Z_SetNull( )
   {
      gxTv_SdtDisponibilidad_Eventid_Z = "" ;
   }

   public boolean getgxTv_SdtDisponibilidad_Eventid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtDisponibilidad_Disponibilidaddescription_Z( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidaddescription_Z ;
   }

   public void setgxTv_SdtDisponibilidad_Disponibilidaddescription_Z( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Disponibilidaddescription_Z");
      gxTv_SdtDisponibilidad_Disponibilidaddescription_Z = value ;
   }

   public void setgxTv_SdtDisponibilidad_Disponibilidaddescription_Z_SetNull( )
   {
      gxTv_SdtDisponibilidad_Disponibilidaddescription_Z = "" ;
   }

   public boolean getgxTv_SdtDisponibilidad_Disponibilidaddescription_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtDisponibilidad_Profesionalid_Z( )
   {
      return gxTv_SdtDisponibilidad_Profesionalid_Z ;
   }

   public void setgxTv_SdtDisponibilidad_Profesionalid_Z( int value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Profesionalid_Z");
      gxTv_SdtDisponibilidad_Profesionalid_Z = value ;
   }

   public void setgxTv_SdtDisponibilidad_Profesionalid_Z_SetNull( )
   {
      gxTv_SdtDisponibilidad_Profesionalid_Z = 0 ;
   }

   public boolean getgxTv_SdtDisponibilidad_Profesionalid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtDisponibilidad_Profesionalapellidopaterno_Z( )
   {
      return gxTv_SdtDisponibilidad_Profesionalapellidopaterno_Z ;
   }

   public void setgxTv_SdtDisponibilidad_Profesionalapellidopaterno_Z( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Profesionalapellidopaterno_Z");
      gxTv_SdtDisponibilidad_Profesionalapellidopaterno_Z = value ;
   }

   public void setgxTv_SdtDisponibilidad_Profesionalapellidopaterno_Z_SetNull( )
   {
      gxTv_SdtDisponibilidad_Profesionalapellidopaterno_Z = "" ;
   }

   public boolean getgxTv_SdtDisponibilidad_Profesionalapellidopaterno_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtDisponibilidad_Profesionalapellidomaterno_Z( )
   {
      return gxTv_SdtDisponibilidad_Profesionalapellidomaterno_Z ;
   }

   public void setgxTv_SdtDisponibilidad_Profesionalapellidomaterno_Z( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Profesionalapellidomaterno_Z");
      gxTv_SdtDisponibilidad_Profesionalapellidomaterno_Z = value ;
   }

   public void setgxTv_SdtDisponibilidad_Profesionalapellidomaterno_Z_SetNull( )
   {
      gxTv_SdtDisponibilidad_Profesionalapellidomaterno_Z = "" ;
   }

   public boolean getgxTv_SdtDisponibilidad_Profesionalapellidomaterno_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtDisponibilidad_Profesionalnombres_Z( )
   {
      return gxTv_SdtDisponibilidad_Profesionalnombres_Z ;
   }

   public void setgxTv_SdtDisponibilidad_Profesionalnombres_Z( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Profesionalnombres_Z");
      gxTv_SdtDisponibilidad_Profesionalnombres_Z = value ;
   }

   public void setgxTv_SdtDisponibilidad_Profesionalnombres_Z_SetNull( )
   {
      gxTv_SdtDisponibilidad_Profesionalnombres_Z = "" ;
   }

   public boolean getgxTv_SdtDisponibilidad_Profesionalnombres_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtDisponibilidad_Profesionalnombrecompleto_Z( )
   {
      return gxTv_SdtDisponibilidad_Profesionalnombrecompleto_Z ;
   }

   public void setgxTv_SdtDisponibilidad_Profesionalnombrecompleto_Z( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Profesionalnombrecompleto_Z");
      gxTv_SdtDisponibilidad_Profesionalnombrecompleto_Z = value ;
   }

   public void setgxTv_SdtDisponibilidad_Profesionalnombrecompleto_Z_SetNull( )
   {
      gxTv_SdtDisponibilidad_Profesionalnombrecompleto_Z = "" ;
   }

   public boolean getgxTv_SdtDisponibilidad_Profesionalnombrecompleto_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtDisponibilidad_Profesionalcop_Z( )
   {
      return gxTv_SdtDisponibilidad_Profesionalcop_Z ;
   }

   public void setgxTv_SdtDisponibilidad_Profesionalcop_Z( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Profesionalcop_Z");
      gxTv_SdtDisponibilidad_Profesionalcop_Z = value ;
   }

   public void setgxTv_SdtDisponibilidad_Profesionalcop_Z_SetNull( )
   {
      gxTv_SdtDisponibilidad_Profesionalcop_Z = "" ;
   }

   public boolean getgxTv_SdtDisponibilidad_Profesionalcop_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtDisponibilidad_Disponibilidadfecha_Z( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidadfecha_Z ;
   }

   public void setgxTv_SdtDisponibilidad_Disponibilidadfecha_Z( java.util.Date value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Disponibilidadfecha_Z");
      gxTv_SdtDisponibilidad_Disponibilidadfecha_Z = value ;
   }

   public void setgxTv_SdtDisponibilidad_Disponibilidadfecha_Z_SetNull( )
   {
      gxTv_SdtDisponibilidad_Disponibilidadfecha_Z = GXutil.nullDate() ;
   }

   public boolean getgxTv_SdtDisponibilidad_Disponibilidadfecha_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtDisponibilidad_Disponibilidadhorainicio_Z( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidadhorainicio_Z ;
   }

   public void setgxTv_SdtDisponibilidad_Disponibilidadhorainicio_Z( java.util.Date value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Disponibilidadhorainicio_Z");
      gxTv_SdtDisponibilidad_Disponibilidadhorainicio_Z = value ;
   }

   public void setgxTv_SdtDisponibilidad_Disponibilidadhorainicio_Z_SetNull( )
   {
      gxTv_SdtDisponibilidad_Disponibilidadhorainicio_Z = GXutil.resetTime( GXutil.nullDate() );
   }

   public boolean getgxTv_SdtDisponibilidad_Disponibilidadhorainicio_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtDisponibilidad_Disponibilidadhorafin_Z( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidadhorafin_Z ;
   }

   public void setgxTv_SdtDisponibilidad_Disponibilidadhorafin_Z( java.util.Date value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Disponibilidadhorafin_Z");
      gxTv_SdtDisponibilidad_Disponibilidadhorafin_Z = value ;
   }

   public void setgxTv_SdtDisponibilidad_Disponibilidadhorafin_Z_SetNull( )
   {
      gxTv_SdtDisponibilidad_Disponibilidadhorafin_Z = GXutil.resetTime( GXutil.nullDate() );
   }

   public boolean getgxTv_SdtDisponibilidad_Disponibilidadhorafin_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtDisponibilidad_Especialidadid_Z( )
   {
      return gxTv_SdtDisponibilidad_Especialidadid_Z ;
   }

   public void setgxTv_SdtDisponibilidad_Especialidadid_Z( short value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Especialidadid_Z");
      gxTv_SdtDisponibilidad_Especialidadid_Z = value ;
   }

   public void setgxTv_SdtDisponibilidad_Especialidadid_Z_SetNull( )
   {
      gxTv_SdtDisponibilidad_Especialidadid_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtDisponibilidad_Especialidadid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtDisponibilidad_Especialidadcodigo_Z( )
   {
      return gxTv_SdtDisponibilidad_Especialidadcodigo_Z ;
   }

   public void setgxTv_SdtDisponibilidad_Especialidadcodigo_Z( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Especialidadcodigo_Z");
      gxTv_SdtDisponibilidad_Especialidadcodigo_Z = value ;
   }

   public void setgxTv_SdtDisponibilidad_Especialidadcodigo_Z_SetNull( )
   {
      gxTv_SdtDisponibilidad_Especialidadcodigo_Z = "" ;
   }

   public boolean getgxTv_SdtDisponibilidad_Especialidadcodigo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtDisponibilidad_Especialidadnombre_Z( )
   {
      return gxTv_SdtDisponibilidad_Especialidadnombre_Z ;
   }

   public void setgxTv_SdtDisponibilidad_Especialidadnombre_Z( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Especialidadnombre_Z");
      gxTv_SdtDisponibilidad_Especialidadnombre_Z = value ;
   }

   public void setgxTv_SdtDisponibilidad_Especialidadnombre_Z_SetNull( )
   {
      gxTv_SdtDisponibilidad_Especialidadnombre_Z = "" ;
   }

   public boolean getgxTv_SdtDisponibilidad_Especialidadnombre_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtDisponibilidad_Sgsededisponibilidadsedeid_Z( )
   {
      return gxTv_SdtDisponibilidad_Sgsededisponibilidadsedeid_Z ;
   }

   public void setgxTv_SdtDisponibilidad_Sgsededisponibilidadsedeid_Z( short value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Sgsededisponibilidadsedeid_Z");
      gxTv_SdtDisponibilidad_Sgsededisponibilidadsedeid_Z = value ;
   }

   public void setgxTv_SdtDisponibilidad_Sgsededisponibilidadsedeid_Z_SetNull( )
   {
      gxTv_SdtDisponibilidad_Sgsededisponibilidadsedeid_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtDisponibilidad_Sgsededisponibilidadsedeid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtDisponibilidad_Sgsededisponibilidadsedenombre_Z( )
   {
      return gxTv_SdtDisponibilidad_Sgsededisponibilidadsedenombre_Z ;
   }

   public void setgxTv_SdtDisponibilidad_Sgsededisponibilidadsedenombre_Z( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Sgsededisponibilidadsedenombre_Z");
      gxTv_SdtDisponibilidad_Sgsededisponibilidadsedenombre_Z = value ;
   }

   public void setgxTv_SdtDisponibilidad_Sgsededisponibilidadsedenombre_Z_SetNull( )
   {
      gxTv_SdtDisponibilidad_Sgsededisponibilidadsedenombre_Z = "" ;
   }

   public boolean getgxTv_SdtDisponibilidad_Sgsededisponibilidadsedenombre_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaid_Z( )
   {
      return gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaid_Z ;
   }

   public void setgxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaid_Z( short value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Sgsededisponibilidadclinicaid_Z");
      gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaid_Z = value ;
   }

   public void setgxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaid_Z_SetNull( )
   {
      gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaid_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaabreviado_Z( )
   {
      return gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaabreviado_Z ;
   }

   public void setgxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaabreviado_Z( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Sgsededisponibilidadclinicaabreviado_Z");
      gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaabreviado_Z = value ;
   }

   public void setgxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaabreviado_Z_SetNull( )
   {
      gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaabreviado_Z = "" ;
   }

   public boolean getgxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaabreviado_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtDisponibilidad_Disponibilidaduser_Z( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidaduser_Z ;
   }

   public void setgxTv_SdtDisponibilidad_Disponibilidaduser_Z( int value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Disponibilidaduser_Z");
      gxTv_SdtDisponibilidad_Disponibilidaduser_Z = value ;
   }

   public void setgxTv_SdtDisponibilidad_Disponibilidaduser_Z_SetNull( )
   {
      gxTv_SdtDisponibilidad_Disponibilidaduser_Z = 0 ;
   }

   public boolean getgxTv_SdtDisponibilidad_Disponibilidaduser_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtDisponibilidad_Disponibilidadestado_Z( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidadestado_Z ;
   }

   public void setgxTv_SdtDisponibilidad_Disponibilidadestado_Z( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Disponibilidadestado_Z");
      gxTv_SdtDisponibilidad_Disponibilidadestado_Z = value ;
   }

   public void setgxTv_SdtDisponibilidad_Disponibilidadestado_Z_SetNull( )
   {
      gxTv_SdtDisponibilidad_Disponibilidadestado_Z = "" ;
   }

   public boolean getgxTv_SdtDisponibilidad_Disponibilidadestado_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtDisponibilidad_Disponibilidadestadocita_Z( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidadestadocita_Z ;
   }

   public void setgxTv_SdtDisponibilidad_Disponibilidadestadocita_Z( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Disponibilidadestadocita_Z");
      gxTv_SdtDisponibilidad_Disponibilidadestadocita_Z = value ;
   }

   public void setgxTv_SdtDisponibilidad_Disponibilidadestadocita_Z_SetNull( )
   {
      gxTv_SdtDisponibilidad_Disponibilidadestadocita_Z = "" ;
   }

   public boolean getgxTv_SdtDisponibilidad_Disponibilidadestadocita_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtDisponibilidad_Dcitaid_Z( )
   {
      return gxTv_SdtDisponibilidad_Dcitaid_Z ;
   }

   public void setgxTv_SdtDisponibilidad_Dcitaid_Z( int value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Dcitaid_Z");
      gxTv_SdtDisponibilidad_Dcitaid_Z = value ;
   }

   public void setgxTv_SdtDisponibilidad_Dcitaid_Z_SetNull( )
   {
      gxTv_SdtDisponibilidad_Dcitaid_Z = 0 ;
   }

   public boolean getgxTv_SdtDisponibilidad_Dcitaid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtDisponibilidad_Disponibilidadtipocita_Z( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidadtipocita_Z ;
   }

   public void setgxTv_SdtDisponibilidad_Disponibilidadtipocita_Z( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Disponibilidadtipocita_Z");
      gxTv_SdtDisponibilidad_Disponibilidadtipocita_Z = value ;
   }

   public void setgxTv_SdtDisponibilidad_Disponibilidadtipocita_Z_SetNull( )
   {
      gxTv_SdtDisponibilidad_Disponibilidadtipocita_Z = "" ;
   }

   public boolean getgxTv_SdtDisponibilidad_Disponibilidadtipocita_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtDisponibilidad_Disponibilidadid_N( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidadid_N ;
   }

   public void setgxTv_SdtDisponibilidad_Disponibilidadid_N( byte value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Disponibilidadid_N");
      gxTv_SdtDisponibilidad_Disponibilidadid_N = value ;
   }

   public void setgxTv_SdtDisponibilidad_Disponibilidadid_N_SetNull( )
   {
      gxTv_SdtDisponibilidad_Disponibilidadid_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtDisponibilidad_Disponibilidadid_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtDisponibilidad_Disponibilidadfecha_N( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidadfecha_N ;
   }

   public void setgxTv_SdtDisponibilidad_Disponibilidadfecha_N( byte value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Disponibilidadfecha_N");
      gxTv_SdtDisponibilidad_Disponibilidadfecha_N = value ;
   }

   public void setgxTv_SdtDisponibilidad_Disponibilidadfecha_N_SetNull( )
   {
      gxTv_SdtDisponibilidad_Disponibilidadfecha_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtDisponibilidad_Disponibilidadfecha_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtDisponibilidad_Disponibilidadhorainicio_N( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidadhorainicio_N ;
   }

   public void setgxTv_SdtDisponibilidad_Disponibilidadhorainicio_N( byte value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Disponibilidadhorainicio_N");
      gxTv_SdtDisponibilidad_Disponibilidadhorainicio_N = value ;
   }

   public void setgxTv_SdtDisponibilidad_Disponibilidadhorainicio_N_SetNull( )
   {
      gxTv_SdtDisponibilidad_Disponibilidadhorainicio_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtDisponibilidad_Disponibilidadhorainicio_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtDisponibilidad_Disponibilidadhorafin_N( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidadhorafin_N ;
   }

   public void setgxTv_SdtDisponibilidad_Disponibilidadhorafin_N( byte value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Disponibilidadhorafin_N");
      gxTv_SdtDisponibilidad_Disponibilidadhorafin_N = value ;
   }

   public void setgxTv_SdtDisponibilidad_Disponibilidadhorafin_N_SetNull( )
   {
      gxTv_SdtDisponibilidad_Disponibilidadhorafin_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtDisponibilidad_Disponibilidadhorafin_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtDisponibilidad_Dcitaid_N( )
   {
      return gxTv_SdtDisponibilidad_Dcitaid_N ;
   }

   public void setgxTv_SdtDisponibilidad_Dcitaid_N( byte value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      SetDirty("Dcitaid_N");
      gxTv_SdtDisponibilidad_Dcitaid_N = value ;
   }

   public void setgxTv_SdtDisponibilidad_Dcitaid_N_SetNull( )
   {
      gxTv_SdtDisponibilidad_Dcitaid_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtDisponibilidad_Dcitaid_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.projectthani.disponibilidad_bc obj;
      obj = new com.projectthani.disponibilidad_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtDisponibilidad_N = (byte)(1) ;
      gxTv_SdtDisponibilidad_Eventid = "" ;
      gxTv_SdtDisponibilidad_Disponibilidaddescription = "" ;
      gxTv_SdtDisponibilidad_Profesionalapellidopaterno = "" ;
      gxTv_SdtDisponibilidad_Profesionalapellidomaterno = "" ;
      gxTv_SdtDisponibilidad_Profesionalnombres = "" ;
      gxTv_SdtDisponibilidad_Profesionalnombrecompleto = "" ;
      gxTv_SdtDisponibilidad_Profesionalcop = "" ;
      gxTv_SdtDisponibilidad_Disponibilidadfecha = GXutil.nullDate() ;
      gxTv_SdtDisponibilidad_Disponibilidadhorainicio = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtDisponibilidad_Disponibilidadhorafin = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtDisponibilidad_Especialidadcodigo = "" ;
      gxTv_SdtDisponibilidad_Especialidadnombre = "" ;
      gxTv_SdtDisponibilidad_Sgsededisponibilidadsedenombre = "" ;
      gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaabreviado = "" ;
      gxTv_SdtDisponibilidad_Disponibilidadestado = "" ;
      gxTv_SdtDisponibilidad_Disponibilidadestadocita = "" ;
      gxTv_SdtDisponibilidad_Disponibilidadtipocita = "" ;
      gxTv_SdtDisponibilidad_Mode = "" ;
      gxTv_SdtDisponibilidad_Eventid_Z = "" ;
      gxTv_SdtDisponibilidad_Disponibilidaddescription_Z = "" ;
      gxTv_SdtDisponibilidad_Profesionalapellidopaterno_Z = "" ;
      gxTv_SdtDisponibilidad_Profesionalapellidomaterno_Z = "" ;
      gxTv_SdtDisponibilidad_Profesionalnombres_Z = "" ;
      gxTv_SdtDisponibilidad_Profesionalnombrecompleto_Z = "" ;
      gxTv_SdtDisponibilidad_Profesionalcop_Z = "" ;
      gxTv_SdtDisponibilidad_Disponibilidadfecha_Z = GXutil.nullDate() ;
      gxTv_SdtDisponibilidad_Disponibilidadhorainicio_Z = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtDisponibilidad_Disponibilidadhorafin_Z = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtDisponibilidad_Especialidadcodigo_Z = "" ;
      gxTv_SdtDisponibilidad_Especialidadnombre_Z = "" ;
      gxTv_SdtDisponibilidad_Sgsededisponibilidadsedenombre_Z = "" ;
      gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaabreviado_Z = "" ;
      gxTv_SdtDisponibilidad_Disponibilidadestado_Z = "" ;
      gxTv_SdtDisponibilidad_Disponibilidadestadocita_Z = "" ;
      gxTv_SdtDisponibilidad_Disponibilidadtipocita_Z = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
      datetime_STZ = GXutil.resetTime( GXutil.nullDate() );
   }

   public byte isNull( )
   {
      return gxTv_SdtDisponibilidad_N ;
   }

   public com.projectthani.SdtDisponibilidad Clone( )
   {
      com.projectthani.SdtDisponibilidad sdt;
      com.projectthani.disponibilidad_bc obj;
      sdt = (com.projectthani.SdtDisponibilidad)(clone()) ;
      obj = (com.projectthani.disponibilidad_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.projectthani.StructSdtDisponibilidad struct )
   {
      setgxTv_SdtDisponibilidad_Disponibilidadid(struct.getDisponibilidadid());
      setgxTv_SdtDisponibilidad_Eventid(struct.getEventid());
      setgxTv_SdtDisponibilidad_Disponibilidaddescription(struct.getDisponibilidaddescription());
      setgxTv_SdtDisponibilidad_Profesionalid(struct.getProfesionalid());
      setgxTv_SdtDisponibilidad_Profesionalapellidopaterno(struct.getProfesionalapellidopaterno());
      setgxTv_SdtDisponibilidad_Profesionalapellidomaterno(struct.getProfesionalapellidomaterno());
      setgxTv_SdtDisponibilidad_Profesionalnombres(struct.getProfesionalnombres());
      setgxTv_SdtDisponibilidad_Profesionalnombrecompleto(struct.getProfesionalnombrecompleto());
      setgxTv_SdtDisponibilidad_Profesionalcop(struct.getProfesionalcop());
      setgxTv_SdtDisponibilidad_Disponibilidadfecha(struct.getDisponibilidadfecha());
      setgxTv_SdtDisponibilidad_Disponibilidadhorainicio(struct.getDisponibilidadhorainicio());
      setgxTv_SdtDisponibilidad_Disponibilidadhorafin(struct.getDisponibilidadhorafin());
      setgxTv_SdtDisponibilidad_Especialidadid(struct.getEspecialidadid());
      setgxTv_SdtDisponibilidad_Especialidadcodigo(struct.getEspecialidadcodigo());
      setgxTv_SdtDisponibilidad_Especialidadnombre(struct.getEspecialidadnombre());
      setgxTv_SdtDisponibilidad_Sgsededisponibilidadsedeid(struct.getSgsededisponibilidadsedeid());
      setgxTv_SdtDisponibilidad_Sgsededisponibilidadsedenombre(struct.getSgsededisponibilidadsedenombre());
      setgxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaid(struct.getSgsededisponibilidadclinicaid());
      setgxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaabreviado(struct.getSgsededisponibilidadclinicaabreviado());
      setgxTv_SdtDisponibilidad_Disponibilidaduser(struct.getDisponibilidaduser());
      setgxTv_SdtDisponibilidad_Disponibilidadestado(struct.getDisponibilidadestado());
      setgxTv_SdtDisponibilidad_Disponibilidadestadocita(struct.getDisponibilidadestadocita());
      setgxTv_SdtDisponibilidad_Dcitaid(struct.getDcitaid());
      setgxTv_SdtDisponibilidad_Disponibilidadtipocita(struct.getDisponibilidadtipocita());
      setgxTv_SdtDisponibilidad_Mode(struct.getMode());
      setgxTv_SdtDisponibilidad_Initialized(struct.getInitialized());
      setgxTv_SdtDisponibilidad_Disponibilidadid_Z(struct.getDisponibilidadid_Z());
      setgxTv_SdtDisponibilidad_Eventid_Z(struct.getEventid_Z());
      setgxTv_SdtDisponibilidad_Disponibilidaddescription_Z(struct.getDisponibilidaddescription_Z());
      setgxTv_SdtDisponibilidad_Profesionalid_Z(struct.getProfesionalid_Z());
      setgxTv_SdtDisponibilidad_Profesionalapellidopaterno_Z(struct.getProfesionalapellidopaterno_Z());
      setgxTv_SdtDisponibilidad_Profesionalapellidomaterno_Z(struct.getProfesionalapellidomaterno_Z());
      setgxTv_SdtDisponibilidad_Profesionalnombres_Z(struct.getProfesionalnombres_Z());
      setgxTv_SdtDisponibilidad_Profesionalnombrecompleto_Z(struct.getProfesionalnombrecompleto_Z());
      setgxTv_SdtDisponibilidad_Profesionalcop_Z(struct.getProfesionalcop_Z());
      setgxTv_SdtDisponibilidad_Disponibilidadfecha_Z(struct.getDisponibilidadfecha_Z());
      setgxTv_SdtDisponibilidad_Disponibilidadhorainicio_Z(struct.getDisponibilidadhorainicio_Z());
      setgxTv_SdtDisponibilidad_Disponibilidadhorafin_Z(struct.getDisponibilidadhorafin_Z());
      setgxTv_SdtDisponibilidad_Especialidadid_Z(struct.getEspecialidadid_Z());
      setgxTv_SdtDisponibilidad_Especialidadcodigo_Z(struct.getEspecialidadcodigo_Z());
      setgxTv_SdtDisponibilidad_Especialidadnombre_Z(struct.getEspecialidadnombre_Z());
      setgxTv_SdtDisponibilidad_Sgsededisponibilidadsedeid_Z(struct.getSgsededisponibilidadsedeid_Z());
      setgxTv_SdtDisponibilidad_Sgsededisponibilidadsedenombre_Z(struct.getSgsededisponibilidadsedenombre_Z());
      setgxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaid_Z(struct.getSgsededisponibilidadclinicaid_Z());
      setgxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaabreviado_Z(struct.getSgsededisponibilidadclinicaabreviado_Z());
      setgxTv_SdtDisponibilidad_Disponibilidaduser_Z(struct.getDisponibilidaduser_Z());
      setgxTv_SdtDisponibilidad_Disponibilidadestado_Z(struct.getDisponibilidadestado_Z());
      setgxTv_SdtDisponibilidad_Disponibilidadestadocita_Z(struct.getDisponibilidadestadocita_Z());
      setgxTv_SdtDisponibilidad_Dcitaid_Z(struct.getDcitaid_Z());
      setgxTv_SdtDisponibilidad_Disponibilidadtipocita_Z(struct.getDisponibilidadtipocita_Z());
      setgxTv_SdtDisponibilidad_Disponibilidadid_N(struct.getDisponibilidadid_N());
      setgxTv_SdtDisponibilidad_Disponibilidadfecha_N(struct.getDisponibilidadfecha_N());
      setgxTv_SdtDisponibilidad_Disponibilidadhorainicio_N(struct.getDisponibilidadhorainicio_N());
      setgxTv_SdtDisponibilidad_Disponibilidadhorafin_N(struct.getDisponibilidadhorafin_N());
      setgxTv_SdtDisponibilidad_Dcitaid_N(struct.getDcitaid_N());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtDisponibilidad getStruct( )
   {
      com.projectthani.StructSdtDisponibilidad struct = new com.projectthani.StructSdtDisponibilidad ();
      struct.setDisponibilidadid(getgxTv_SdtDisponibilidad_Disponibilidadid());
      struct.setEventid(getgxTv_SdtDisponibilidad_Eventid());
      struct.setDisponibilidaddescription(getgxTv_SdtDisponibilidad_Disponibilidaddescription());
      struct.setProfesionalid(getgxTv_SdtDisponibilidad_Profesionalid());
      struct.setProfesionalapellidopaterno(getgxTv_SdtDisponibilidad_Profesionalapellidopaterno());
      struct.setProfesionalapellidomaterno(getgxTv_SdtDisponibilidad_Profesionalapellidomaterno());
      struct.setProfesionalnombres(getgxTv_SdtDisponibilidad_Profesionalnombres());
      struct.setProfesionalnombrecompleto(getgxTv_SdtDisponibilidad_Profesionalnombrecompleto());
      struct.setProfesionalcop(getgxTv_SdtDisponibilidad_Profesionalcop());
      struct.setDisponibilidadfecha(getgxTv_SdtDisponibilidad_Disponibilidadfecha());
      struct.setDisponibilidadhorainicio(getgxTv_SdtDisponibilidad_Disponibilidadhorainicio());
      struct.setDisponibilidadhorafin(getgxTv_SdtDisponibilidad_Disponibilidadhorafin());
      struct.setEspecialidadid(getgxTv_SdtDisponibilidad_Especialidadid());
      struct.setEspecialidadcodigo(getgxTv_SdtDisponibilidad_Especialidadcodigo());
      struct.setEspecialidadnombre(getgxTv_SdtDisponibilidad_Especialidadnombre());
      struct.setSgsededisponibilidadsedeid(getgxTv_SdtDisponibilidad_Sgsededisponibilidadsedeid());
      struct.setSgsededisponibilidadsedenombre(getgxTv_SdtDisponibilidad_Sgsededisponibilidadsedenombre());
      struct.setSgsededisponibilidadclinicaid(getgxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaid());
      struct.setSgsededisponibilidadclinicaabreviado(getgxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaabreviado());
      struct.setDisponibilidaduser(getgxTv_SdtDisponibilidad_Disponibilidaduser());
      struct.setDisponibilidadestado(getgxTv_SdtDisponibilidad_Disponibilidadestado());
      struct.setDisponibilidadestadocita(getgxTv_SdtDisponibilidad_Disponibilidadestadocita());
      struct.setDcitaid(getgxTv_SdtDisponibilidad_Dcitaid());
      struct.setDisponibilidadtipocita(getgxTv_SdtDisponibilidad_Disponibilidadtipocita());
      struct.setMode(getgxTv_SdtDisponibilidad_Mode());
      struct.setInitialized(getgxTv_SdtDisponibilidad_Initialized());
      struct.setDisponibilidadid_Z(getgxTv_SdtDisponibilidad_Disponibilidadid_Z());
      struct.setEventid_Z(getgxTv_SdtDisponibilidad_Eventid_Z());
      struct.setDisponibilidaddescription_Z(getgxTv_SdtDisponibilidad_Disponibilidaddescription_Z());
      struct.setProfesionalid_Z(getgxTv_SdtDisponibilidad_Profesionalid_Z());
      struct.setProfesionalapellidopaterno_Z(getgxTv_SdtDisponibilidad_Profesionalapellidopaterno_Z());
      struct.setProfesionalapellidomaterno_Z(getgxTv_SdtDisponibilidad_Profesionalapellidomaterno_Z());
      struct.setProfesionalnombres_Z(getgxTv_SdtDisponibilidad_Profesionalnombres_Z());
      struct.setProfesionalnombrecompleto_Z(getgxTv_SdtDisponibilidad_Profesionalnombrecompleto_Z());
      struct.setProfesionalcop_Z(getgxTv_SdtDisponibilidad_Profesionalcop_Z());
      struct.setDisponibilidadfecha_Z(getgxTv_SdtDisponibilidad_Disponibilidadfecha_Z());
      struct.setDisponibilidadhorainicio_Z(getgxTv_SdtDisponibilidad_Disponibilidadhorainicio_Z());
      struct.setDisponibilidadhorafin_Z(getgxTv_SdtDisponibilidad_Disponibilidadhorafin_Z());
      struct.setEspecialidadid_Z(getgxTv_SdtDisponibilidad_Especialidadid_Z());
      struct.setEspecialidadcodigo_Z(getgxTv_SdtDisponibilidad_Especialidadcodigo_Z());
      struct.setEspecialidadnombre_Z(getgxTv_SdtDisponibilidad_Especialidadnombre_Z());
      struct.setSgsededisponibilidadsedeid_Z(getgxTv_SdtDisponibilidad_Sgsededisponibilidadsedeid_Z());
      struct.setSgsededisponibilidadsedenombre_Z(getgxTv_SdtDisponibilidad_Sgsededisponibilidadsedenombre_Z());
      struct.setSgsededisponibilidadclinicaid_Z(getgxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaid_Z());
      struct.setSgsededisponibilidadclinicaabreviado_Z(getgxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaabreviado_Z());
      struct.setDisponibilidaduser_Z(getgxTv_SdtDisponibilidad_Disponibilidaduser_Z());
      struct.setDisponibilidadestado_Z(getgxTv_SdtDisponibilidad_Disponibilidadestado_Z());
      struct.setDisponibilidadestadocita_Z(getgxTv_SdtDisponibilidad_Disponibilidadestadocita_Z());
      struct.setDcitaid_Z(getgxTv_SdtDisponibilidad_Dcitaid_Z());
      struct.setDisponibilidadtipocita_Z(getgxTv_SdtDisponibilidad_Disponibilidadtipocita_Z());
      struct.setDisponibilidadid_N(getgxTv_SdtDisponibilidad_Disponibilidadid_N());
      struct.setDisponibilidadfecha_N(getgxTv_SdtDisponibilidad_Disponibilidadfecha_N());
      struct.setDisponibilidadhorainicio_N(getgxTv_SdtDisponibilidad_Disponibilidadhorainicio_N());
      struct.setDisponibilidadhorafin_N(getgxTv_SdtDisponibilidad_Disponibilidadhorafin_N());
      struct.setDcitaid_N(getgxTv_SdtDisponibilidad_Dcitaid_N());
      return struct ;
   }

   private byte gxTv_SdtDisponibilidad_N ;
   private byte gxTv_SdtDisponibilidad_Disponibilidadid_N ;
   private byte gxTv_SdtDisponibilidad_Disponibilidadfecha_N ;
   private byte gxTv_SdtDisponibilidad_Disponibilidadhorainicio_N ;
   private byte gxTv_SdtDisponibilidad_Disponibilidadhorafin_N ;
   private byte gxTv_SdtDisponibilidad_Dcitaid_N ;
   private short gxTv_SdtDisponibilidad_Especialidadid ;
   private short gxTv_SdtDisponibilidad_Sgsededisponibilidadsedeid ;
   private short gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaid ;
   private short gxTv_SdtDisponibilidad_Initialized ;
   private short gxTv_SdtDisponibilidad_Especialidadid_Z ;
   private short gxTv_SdtDisponibilidad_Sgsededisponibilidadsedeid_Z ;
   private short gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaid_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtDisponibilidad_Disponibilidadid ;
   private int gxTv_SdtDisponibilidad_Profesionalid ;
   private int gxTv_SdtDisponibilidad_Disponibilidaduser ;
   private int gxTv_SdtDisponibilidad_Dcitaid ;
   private int gxTv_SdtDisponibilidad_Disponibilidadid_Z ;
   private int gxTv_SdtDisponibilidad_Profesionalid_Z ;
   private int gxTv_SdtDisponibilidad_Disponibilidaduser_Z ;
   private int gxTv_SdtDisponibilidad_Dcitaid_Z ;
   private String gxTv_SdtDisponibilidad_Eventid ;
   private String gxTv_SdtDisponibilidad_Disponibilidadestado ;
   private String gxTv_SdtDisponibilidad_Disponibilidadtipocita ;
   private String gxTv_SdtDisponibilidad_Mode ;
   private String gxTv_SdtDisponibilidad_Eventid_Z ;
   private String gxTv_SdtDisponibilidad_Disponibilidadestado_Z ;
   private String gxTv_SdtDisponibilidad_Disponibilidadtipocita_Z ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_SdtDisponibilidad_Disponibilidadhorainicio ;
   private java.util.Date gxTv_SdtDisponibilidad_Disponibilidadhorafin ;
   private java.util.Date gxTv_SdtDisponibilidad_Disponibilidadhorainicio_Z ;
   private java.util.Date gxTv_SdtDisponibilidad_Disponibilidadhorafin_Z ;
   private java.util.Date datetime_STZ ;
   private java.util.Date gxTv_SdtDisponibilidad_Disponibilidadfecha ;
   private java.util.Date gxTv_SdtDisponibilidad_Disponibilidadfecha_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtDisponibilidad_Disponibilidaddescription ;
   private String gxTv_SdtDisponibilidad_Profesionalapellidopaterno ;
   private String gxTv_SdtDisponibilidad_Profesionalapellidomaterno ;
   private String gxTv_SdtDisponibilidad_Profesionalnombres ;
   private String gxTv_SdtDisponibilidad_Profesionalnombrecompleto ;
   private String gxTv_SdtDisponibilidad_Profesionalcop ;
   private String gxTv_SdtDisponibilidad_Especialidadcodigo ;
   private String gxTv_SdtDisponibilidad_Especialidadnombre ;
   private String gxTv_SdtDisponibilidad_Sgsededisponibilidadsedenombre ;
   private String gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaabreviado ;
   private String gxTv_SdtDisponibilidad_Disponibilidadestadocita ;
   private String gxTv_SdtDisponibilidad_Disponibilidaddescription_Z ;
   private String gxTv_SdtDisponibilidad_Profesionalapellidopaterno_Z ;
   private String gxTv_SdtDisponibilidad_Profesionalapellidomaterno_Z ;
   private String gxTv_SdtDisponibilidad_Profesionalnombres_Z ;
   private String gxTv_SdtDisponibilidad_Profesionalnombrecompleto_Z ;
   private String gxTv_SdtDisponibilidad_Profesionalcop_Z ;
   private String gxTv_SdtDisponibilidad_Especialidadcodigo_Z ;
   private String gxTv_SdtDisponibilidad_Especialidadnombre_Z ;
   private String gxTv_SdtDisponibilidad_Sgsededisponibilidadsedenombre_Z ;
   private String gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaabreviado_Z ;
   private String gxTv_SdtDisponibilidad_Disponibilidadestadocita_Z ;
}

