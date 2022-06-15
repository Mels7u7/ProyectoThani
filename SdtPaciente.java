package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtPaciente extends GxSilentTrnSdt implements Cloneable, java.io.Serializable
{
   public SdtPaciente( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtPaciente.class));
   }

   public SdtPaciente( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle, context, "SdtPaciente");
      initialize( remoteHandle) ;
   }

   public SdtPaciente( int remoteHandle ,
                       StructSdtPaciente struct )
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

   public void Load( int AV20PacienteId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV20PacienteId)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"PacienteId", int.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Paciente");
      metadata.set("BT", "Paciente");
      metadata.set("PK", "[ \"PacienteId\" ]");
      metadata.set("PKAssigned", "[ \"PacienteId\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"PaisId\" ],\"FKMap\":[  ] },{ \"FK\":[ \"SecUserId\" ],\"FKMap\":[  ] },{ \"FK\":[ \"UbigeoCode\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteId") )
            {
               gxTv_SdtPaciente_Pacienteid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteApellidoPaterno") )
            {
               gxTv_SdtPaciente_Pacienteapellidopaterno = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteApellidoMaterno") )
            {
               gxTv_SdtPaciente_Pacienteapellidomaterno = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteNombres") )
            {
               gxTv_SdtPaciente_Pacientenombres = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteNombreCompleto") )
            {
               gxTv_SdtPaciente_Pacientenombrecompleto = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteFechaNacimiento") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtPaciente_Pacientefechanacimiento = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtPaciente_Pacientefechanacimiento = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteTipoDocumento") )
            {
               gxTv_SdtPaciente_Pacientetipodocumento = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteNroDocumento") )
            {
               gxTv_SdtPaciente_Pacientenrodocumento = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteDireccion") )
            {
               gxTv_SdtPaciente_Pacientedireccion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteSexo") )
            {
               gxTv_SdtPaciente_Pacientesexo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteCorreo") )
            {
               gxTv_SdtPaciente_Pacientecorreo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteTelefono") )
            {
               gxTv_SdtPaciente_Pacientetelefono = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaisId") )
            {
               gxTv_SdtPaciente_Paisid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaisDescripcion") )
            {
               gxTv_SdtPaciente_Paisdescripcion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteEstado") )
            {
               gxTv_SdtPaciente_Pacienteestado = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserId") )
            {
               gxTv_SdtPaciente_Secuserid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "UbigeoCode") )
            {
               gxTv_SdtPaciente_Ubigeocode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "UbigeoNombre") )
            {
               gxTv_SdtPaciente_Ubigeonombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteEstatura") )
            {
               gxTv_SdtPaciente_Pacienteestatura = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacientePeso") )
            {
               gxTv_SdtPaciente_Pacientepeso = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteNombreAnexo") )
            {
               gxTv_SdtPaciente_Pacientenombreanexo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteAnexos") )
            {
               gxTv_SdtPaciente_Pacienteanexos=GXutil.blobFromBase64( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteEnterarse") )
            {
               gxTv_SdtPaciente_Pacienteenterarse = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteEspecifique") )
            {
               gxTv_SdtPaciente_Pacienteespecifique = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteFechaRegistro") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtPaciente_Pacientefecharegistro = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtPaciente_Pacientefecharegistro = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtPaciente_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtPaciente_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteId_Z") )
            {
               gxTv_SdtPaciente_Pacienteid_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteApellidoPaterno_Z") )
            {
               gxTv_SdtPaciente_Pacienteapellidopaterno_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteApellidoMaterno_Z") )
            {
               gxTv_SdtPaciente_Pacienteapellidomaterno_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteNombres_Z") )
            {
               gxTv_SdtPaciente_Pacientenombres_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteNombreCompleto_Z") )
            {
               gxTv_SdtPaciente_Pacientenombrecompleto_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteFechaNacimiento_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtPaciente_Pacientefechanacimiento_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtPaciente_Pacientefechanacimiento_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteTipoDocumento_Z") )
            {
               gxTv_SdtPaciente_Pacientetipodocumento_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteNroDocumento_Z") )
            {
               gxTv_SdtPaciente_Pacientenrodocumento_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteDireccion_Z") )
            {
               gxTv_SdtPaciente_Pacientedireccion_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteSexo_Z") )
            {
               gxTv_SdtPaciente_Pacientesexo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteCorreo_Z") )
            {
               gxTv_SdtPaciente_Pacientecorreo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteTelefono_Z") )
            {
               gxTv_SdtPaciente_Pacientetelefono_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaisId_Z") )
            {
               gxTv_SdtPaciente_Paisid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaisDescripcion_Z") )
            {
               gxTv_SdtPaciente_Paisdescripcion_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteEstado_Z") )
            {
               gxTv_SdtPaciente_Pacienteestado_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserId_Z") )
            {
               gxTv_SdtPaciente_Secuserid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "UbigeoCode_Z") )
            {
               gxTv_SdtPaciente_Ubigeocode_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "UbigeoNombre_Z") )
            {
               gxTv_SdtPaciente_Ubigeonombre_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteEstatura_Z") )
            {
               gxTv_SdtPaciente_Pacienteestatura_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacientePeso_Z") )
            {
               gxTv_SdtPaciente_Pacientepeso_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteNombreAnexo_Z") )
            {
               gxTv_SdtPaciente_Pacientenombreanexo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteEnterarse_Z") )
            {
               gxTv_SdtPaciente_Pacienteenterarse_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteFechaRegistro_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtPaciente_Pacientefecharegistro_Z = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtPaciente_Pacientefecharegistro_Z = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserId_N") )
            {
               gxTv_SdtPaciente_Secuserid_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "UbigeoCode_N") )
            {
               gxTv_SdtPaciente_Ubigeocode_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteNombreAnexo_N") )
            {
               gxTv_SdtPaciente_Pacientenombreanexo_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteAnexos_N") )
            {
               gxTv_SdtPaciente_Pacienteanexos_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteEnterarse_N") )
            {
               gxTv_SdtPaciente_Pacienteenterarse_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteEspecifique_N") )
            {
               gxTv_SdtPaciente_Pacienteespecifique_N = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "Paciente" ;
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
      oWriter.writeElement("PacienteId", GXutil.trim( GXutil.str( gxTv_SdtPaciente_Pacienteid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteApellidoPaterno", GXutil.rtrim( gxTv_SdtPaciente_Pacienteapellidopaterno));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteApellidoMaterno", GXutil.rtrim( gxTv_SdtPaciente_Pacienteapellidomaterno));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteNombres", GXutil.rtrim( gxTv_SdtPaciente_Pacientenombres));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteNombreCompleto", GXutil.rtrim( gxTv_SdtPaciente_Pacientenombrecompleto));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtPaciente_Pacientefechanacimiento), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtPaciente_Pacientefechanacimiento), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtPaciente_Pacientefechanacimiento), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("PacienteFechaNacimiento", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteTipoDocumento", GXutil.rtrim( gxTv_SdtPaciente_Pacientetipodocumento));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteNroDocumento", GXutil.rtrim( gxTv_SdtPaciente_Pacientenrodocumento));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteDireccion", GXutil.rtrim( gxTv_SdtPaciente_Pacientedireccion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteSexo", GXutil.rtrim( gxTv_SdtPaciente_Pacientesexo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteCorreo", GXutil.rtrim( gxTv_SdtPaciente_Pacientecorreo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteTelefono", GXutil.rtrim( gxTv_SdtPaciente_Pacientetelefono));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PaisId", GXutil.trim( GXutil.str( gxTv_SdtPaciente_Paisid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PaisDescripcion", GXutil.rtrim( gxTv_SdtPaciente_Paisdescripcion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteEstado", GXutil.rtrim( gxTv_SdtPaciente_Pacienteestado));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SecUserId", GXutil.trim( GXutil.str( gxTv_SdtPaciente_Secuserid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("UbigeoCode", GXutil.rtrim( gxTv_SdtPaciente_Ubigeocode));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("UbigeoNombre", GXutil.rtrim( gxTv_SdtPaciente_Ubigeonombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteEstatura", GXutil.trim( GXutil.strNoRound( gxTv_SdtPaciente_Pacienteestatura, 4, 2)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacientePeso", GXutil.trim( GXutil.strNoRound( gxTv_SdtPaciente_Pacientepeso, 6, 2)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteNombreAnexo", GXutil.rtrim( gxTv_SdtPaciente_Pacientenombreanexo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteAnexos", GXutil.blobToBase64( gxTv_SdtPaciente_Pacienteanexos));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteEnterarse", GXutil.rtrim( gxTv_SdtPaciente_Pacienteenterarse));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteEspecifique", GXutil.rtrim( gxTv_SdtPaciente_Pacienteespecifique));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtPaciente_Pacientefecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtPaciente_Pacientefecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtPaciente_Pacientefecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtPaciente_Pacientefecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtPaciente_Pacientefecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtPaciente_Pacientefecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("PacienteFechaRegistro", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", GXutil.rtrim( gxTv_SdtPaciente_Mode));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtPaciente_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PacienteId_Z", GXutil.trim( GXutil.str( gxTv_SdtPaciente_Pacienteid_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PacienteApellidoPaterno_Z", GXutil.rtrim( gxTv_SdtPaciente_Pacienteapellidopaterno_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PacienteApellidoMaterno_Z", GXutil.rtrim( gxTv_SdtPaciente_Pacienteapellidomaterno_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PacienteNombres_Z", GXutil.rtrim( gxTv_SdtPaciente_Pacientenombres_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PacienteNombreCompleto_Z", GXutil.rtrim( gxTv_SdtPaciente_Pacientenombrecompleto_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtPaciente_Pacientefechanacimiento_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtPaciente_Pacientefechanacimiento_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtPaciente_Pacientefechanacimiento_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("PacienteFechaNacimiento_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PacienteTipoDocumento_Z", GXutil.rtrim( gxTv_SdtPaciente_Pacientetipodocumento_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PacienteNroDocumento_Z", GXutil.rtrim( gxTv_SdtPaciente_Pacientenrodocumento_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PacienteDireccion_Z", GXutil.rtrim( gxTv_SdtPaciente_Pacientedireccion_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PacienteSexo_Z", GXutil.rtrim( gxTv_SdtPaciente_Pacientesexo_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PacienteCorreo_Z", GXutil.rtrim( gxTv_SdtPaciente_Pacientecorreo_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PacienteTelefono_Z", GXutil.rtrim( gxTv_SdtPaciente_Pacientetelefono_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PaisId_Z", GXutil.trim( GXutil.str( gxTv_SdtPaciente_Paisid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PaisDescripcion_Z", GXutil.rtrim( gxTv_SdtPaciente_Paisdescripcion_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PacienteEstado_Z", GXutil.rtrim( gxTv_SdtPaciente_Pacienteestado_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SecUserId_Z", GXutil.trim( GXutil.str( gxTv_SdtPaciente_Secuserid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("UbigeoCode_Z", GXutil.rtrim( gxTv_SdtPaciente_Ubigeocode_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("UbigeoNombre_Z", GXutil.rtrim( gxTv_SdtPaciente_Ubigeonombre_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PacienteEstatura_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtPaciente_Pacienteestatura_Z, 4, 2)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PacientePeso_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtPaciente_Pacientepeso_Z, 6, 2)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PacienteNombreAnexo_Z", GXutil.rtrim( gxTv_SdtPaciente_Pacientenombreanexo_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PacienteEnterarse_Z", GXutil.rtrim( gxTv_SdtPaciente_Pacienteenterarse_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtPaciente_Pacientefecharegistro_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtPaciente_Pacientefecharegistro_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtPaciente_Pacientefecharegistro_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtPaciente_Pacientefecharegistro_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtPaciente_Pacientefecharegistro_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtPaciente_Pacientefecharegistro_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("PacienteFechaRegistro_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SecUserId_N", GXutil.trim( GXutil.str( gxTv_SdtPaciente_Secuserid_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("UbigeoCode_N", GXutil.trim( GXutil.str( gxTv_SdtPaciente_Ubigeocode_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PacienteNombreAnexo_N", GXutil.trim( GXutil.str( gxTv_SdtPaciente_Pacientenombreanexo_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PacienteAnexos_N", GXutil.trim( GXutil.str( gxTv_SdtPaciente_Pacienteanexos_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PacienteEnterarse_N", GXutil.trim( GXutil.str( gxTv_SdtPaciente_Pacienteenterarse_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PacienteEspecifique_N", GXutil.trim( GXutil.str( gxTv_SdtPaciente_Pacienteespecifique_N, 1, 0)));
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
      AddObjectProperty("PacienteId", gxTv_SdtPaciente_Pacienteid, false, includeNonInitialized);
      AddObjectProperty("PacienteApellidoPaterno", gxTv_SdtPaciente_Pacienteapellidopaterno, false, includeNonInitialized);
      AddObjectProperty("PacienteApellidoMaterno", gxTv_SdtPaciente_Pacienteapellidomaterno, false, includeNonInitialized);
      AddObjectProperty("PacienteNombres", gxTv_SdtPaciente_Pacientenombres, false, includeNonInitialized);
      AddObjectProperty("PacienteNombreCompleto", gxTv_SdtPaciente_Pacientenombrecompleto, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtPaciente_Pacientefechanacimiento), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtPaciente_Pacientefechanacimiento), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtPaciente_Pacientefechanacimiento), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("PacienteFechaNacimiento", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("PacienteTipoDocumento", gxTv_SdtPaciente_Pacientetipodocumento, false, includeNonInitialized);
      AddObjectProperty("PacienteNroDocumento", gxTv_SdtPaciente_Pacientenrodocumento, false, includeNonInitialized);
      AddObjectProperty("PacienteDireccion", gxTv_SdtPaciente_Pacientedireccion, false, includeNonInitialized);
      AddObjectProperty("PacienteSexo", gxTv_SdtPaciente_Pacientesexo, false, includeNonInitialized);
      AddObjectProperty("PacienteCorreo", gxTv_SdtPaciente_Pacientecorreo, false, includeNonInitialized);
      AddObjectProperty("PacienteTelefono", gxTv_SdtPaciente_Pacientetelefono, false, includeNonInitialized);
      AddObjectProperty("PaisId", gxTv_SdtPaciente_Paisid, false, includeNonInitialized);
      AddObjectProperty("PaisDescripcion", gxTv_SdtPaciente_Paisdescripcion, false, includeNonInitialized);
      AddObjectProperty("PacienteEstado", gxTv_SdtPaciente_Pacienteestado, false, includeNonInitialized);
      AddObjectProperty("SecUserId", gxTv_SdtPaciente_Secuserid, false, includeNonInitialized);
      AddObjectProperty("SecUserId_N", gxTv_SdtPaciente_Secuserid_N, false, includeNonInitialized);
      AddObjectProperty("UbigeoCode", gxTv_SdtPaciente_Ubigeocode, false, includeNonInitialized);
      AddObjectProperty("UbigeoCode_N", gxTv_SdtPaciente_Ubigeocode_N, false, includeNonInitialized);
      AddObjectProperty("UbigeoNombre", gxTv_SdtPaciente_Ubigeonombre, false, includeNonInitialized);
      AddObjectProperty("PacienteEstatura", gxTv_SdtPaciente_Pacienteestatura, false, includeNonInitialized);
      AddObjectProperty("PacientePeso", gxTv_SdtPaciente_Pacientepeso, false, includeNonInitialized);
      AddObjectProperty("PacienteNombreAnexo", gxTv_SdtPaciente_Pacientenombreanexo, false, includeNonInitialized);
      AddObjectProperty("PacienteNombreAnexo_N", gxTv_SdtPaciente_Pacientenombreanexo_N, false, includeNonInitialized);
      AddObjectProperty("PacienteAnexos", gxTv_SdtPaciente_Pacienteanexos, false, includeNonInitialized);
      AddObjectProperty("PacienteAnexos_N", gxTv_SdtPaciente_Pacienteanexos_N, false, includeNonInitialized);
      AddObjectProperty("PacienteEnterarse", gxTv_SdtPaciente_Pacienteenterarse, false, includeNonInitialized);
      AddObjectProperty("PacienteEnterarse_N", gxTv_SdtPaciente_Pacienteenterarse_N, false, includeNonInitialized);
      AddObjectProperty("PacienteEspecifique", gxTv_SdtPaciente_Pacienteespecifique, false, includeNonInitialized);
      AddObjectProperty("PacienteEspecifique_N", gxTv_SdtPaciente_Pacienteespecifique_N, false, includeNonInitialized);
      datetime_STZ = gxTv_SdtPaciente_Pacientefecharegistro ;
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
      AddObjectProperty("PacienteFechaRegistro", sDateCnv, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtPaciente_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtPaciente_Initialized, false, includeNonInitialized);
         AddObjectProperty("PacienteId_Z", gxTv_SdtPaciente_Pacienteid_Z, false, includeNonInitialized);
         AddObjectProperty("PacienteApellidoPaterno_Z", gxTv_SdtPaciente_Pacienteapellidopaterno_Z, false, includeNonInitialized);
         AddObjectProperty("PacienteApellidoMaterno_Z", gxTv_SdtPaciente_Pacienteapellidomaterno_Z, false, includeNonInitialized);
         AddObjectProperty("PacienteNombres_Z", gxTv_SdtPaciente_Pacientenombres_Z, false, includeNonInitialized);
         AddObjectProperty("PacienteNombreCompleto_Z", gxTv_SdtPaciente_Pacientenombrecompleto_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtPaciente_Pacientefechanacimiento_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtPaciente_Pacientefechanacimiento_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtPaciente_Pacientefechanacimiento_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("PacienteFechaNacimiento_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("PacienteTipoDocumento_Z", gxTv_SdtPaciente_Pacientetipodocumento_Z, false, includeNonInitialized);
         AddObjectProperty("PacienteNroDocumento_Z", gxTv_SdtPaciente_Pacientenrodocumento_Z, false, includeNonInitialized);
         AddObjectProperty("PacienteDireccion_Z", gxTv_SdtPaciente_Pacientedireccion_Z, false, includeNonInitialized);
         AddObjectProperty("PacienteSexo_Z", gxTv_SdtPaciente_Pacientesexo_Z, false, includeNonInitialized);
         AddObjectProperty("PacienteCorreo_Z", gxTv_SdtPaciente_Pacientecorreo_Z, false, includeNonInitialized);
         AddObjectProperty("PacienteTelefono_Z", gxTv_SdtPaciente_Pacientetelefono_Z, false, includeNonInitialized);
         AddObjectProperty("PaisId_Z", gxTv_SdtPaciente_Paisid_Z, false, includeNonInitialized);
         AddObjectProperty("PaisDescripcion_Z", gxTv_SdtPaciente_Paisdescripcion_Z, false, includeNonInitialized);
         AddObjectProperty("PacienteEstado_Z", gxTv_SdtPaciente_Pacienteestado_Z, false, includeNonInitialized);
         AddObjectProperty("SecUserId_Z", gxTv_SdtPaciente_Secuserid_Z, false, includeNonInitialized);
         AddObjectProperty("UbigeoCode_Z", gxTv_SdtPaciente_Ubigeocode_Z, false, includeNonInitialized);
         AddObjectProperty("UbigeoNombre_Z", gxTv_SdtPaciente_Ubigeonombre_Z, false, includeNonInitialized);
         AddObjectProperty("PacienteEstatura_Z", gxTv_SdtPaciente_Pacienteestatura_Z, false, includeNonInitialized);
         AddObjectProperty("PacientePeso_Z", gxTv_SdtPaciente_Pacientepeso_Z, false, includeNonInitialized);
         AddObjectProperty("PacienteNombreAnexo_Z", gxTv_SdtPaciente_Pacientenombreanexo_Z, false, includeNonInitialized);
         AddObjectProperty("PacienteEnterarse_Z", gxTv_SdtPaciente_Pacienteenterarse_Z, false, includeNonInitialized);
         datetime_STZ = gxTv_SdtPaciente_Pacientefecharegistro_Z ;
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
         AddObjectProperty("PacienteFechaRegistro_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("SecUserId_N", gxTv_SdtPaciente_Secuserid_N, false, includeNonInitialized);
         AddObjectProperty("UbigeoCode_N", gxTv_SdtPaciente_Ubigeocode_N, false, includeNonInitialized);
         AddObjectProperty("PacienteNombreAnexo_N", gxTv_SdtPaciente_Pacientenombreanexo_N, false, includeNonInitialized);
         AddObjectProperty("PacienteAnexos_N", gxTv_SdtPaciente_Pacienteanexos_N, false, includeNonInitialized);
         AddObjectProperty("PacienteEnterarse_N", gxTv_SdtPaciente_Pacienteenterarse_N, false, includeNonInitialized);
         AddObjectProperty("PacienteEspecifique_N", gxTv_SdtPaciente_Pacienteespecifique_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.projectthani.SdtPaciente sdt )
   {
      if ( sdt.IsDirty("PacienteId") )
      {
         gxTv_SdtPaciente_N = (byte)(0) ;
         gxTv_SdtPaciente_Pacienteid = sdt.getgxTv_SdtPaciente_Pacienteid() ;
      }
      if ( sdt.IsDirty("PacienteApellidoPaterno") )
      {
         gxTv_SdtPaciente_N = (byte)(0) ;
         gxTv_SdtPaciente_Pacienteapellidopaterno = sdt.getgxTv_SdtPaciente_Pacienteapellidopaterno() ;
      }
      if ( sdt.IsDirty("PacienteApellidoMaterno") )
      {
         gxTv_SdtPaciente_N = (byte)(0) ;
         gxTv_SdtPaciente_Pacienteapellidomaterno = sdt.getgxTv_SdtPaciente_Pacienteapellidomaterno() ;
      }
      if ( sdt.IsDirty("PacienteNombres") )
      {
         gxTv_SdtPaciente_N = (byte)(0) ;
         gxTv_SdtPaciente_Pacientenombres = sdt.getgxTv_SdtPaciente_Pacientenombres() ;
      }
      if ( sdt.IsDirty("PacienteNombreCompleto") )
      {
         gxTv_SdtPaciente_N = (byte)(0) ;
         gxTv_SdtPaciente_Pacientenombrecompleto = sdt.getgxTv_SdtPaciente_Pacientenombrecompleto() ;
      }
      if ( sdt.IsDirty("PacienteFechaNacimiento") )
      {
         gxTv_SdtPaciente_N = (byte)(0) ;
         gxTv_SdtPaciente_Pacientefechanacimiento = sdt.getgxTv_SdtPaciente_Pacientefechanacimiento() ;
      }
      if ( sdt.IsDirty("PacienteTipoDocumento") )
      {
         gxTv_SdtPaciente_N = (byte)(0) ;
         gxTv_SdtPaciente_Pacientetipodocumento = sdt.getgxTv_SdtPaciente_Pacientetipodocumento() ;
      }
      if ( sdt.IsDirty("PacienteNroDocumento") )
      {
         gxTv_SdtPaciente_N = (byte)(0) ;
         gxTv_SdtPaciente_Pacientenrodocumento = sdt.getgxTv_SdtPaciente_Pacientenrodocumento() ;
      }
      if ( sdt.IsDirty("PacienteDireccion") )
      {
         gxTv_SdtPaciente_N = (byte)(0) ;
         gxTv_SdtPaciente_Pacientedireccion = sdt.getgxTv_SdtPaciente_Pacientedireccion() ;
      }
      if ( sdt.IsDirty("PacienteSexo") )
      {
         gxTv_SdtPaciente_N = (byte)(0) ;
         gxTv_SdtPaciente_Pacientesexo = sdt.getgxTv_SdtPaciente_Pacientesexo() ;
      }
      if ( sdt.IsDirty("PacienteCorreo") )
      {
         gxTv_SdtPaciente_N = (byte)(0) ;
         gxTv_SdtPaciente_Pacientecorreo = sdt.getgxTv_SdtPaciente_Pacientecorreo() ;
      }
      if ( sdt.IsDirty("PacienteTelefono") )
      {
         gxTv_SdtPaciente_N = (byte)(0) ;
         gxTv_SdtPaciente_Pacientetelefono = sdt.getgxTv_SdtPaciente_Pacientetelefono() ;
      }
      if ( sdt.IsDirty("PaisId") )
      {
         gxTv_SdtPaciente_N = (byte)(0) ;
         gxTv_SdtPaciente_Paisid = sdt.getgxTv_SdtPaciente_Paisid() ;
      }
      if ( sdt.IsDirty("PaisDescripcion") )
      {
         gxTv_SdtPaciente_N = (byte)(0) ;
         gxTv_SdtPaciente_Paisdescripcion = sdt.getgxTv_SdtPaciente_Paisdescripcion() ;
      }
      if ( sdt.IsDirty("PacienteEstado") )
      {
         gxTv_SdtPaciente_N = (byte)(0) ;
         gxTv_SdtPaciente_Pacienteestado = sdt.getgxTv_SdtPaciente_Pacienteestado() ;
      }
      if ( sdt.IsDirty("SecUserId") )
      {
         gxTv_SdtPaciente_Secuserid_N = (byte)(0) ;
         gxTv_SdtPaciente_N = (byte)(0) ;
         gxTv_SdtPaciente_Secuserid = sdt.getgxTv_SdtPaciente_Secuserid() ;
      }
      if ( sdt.IsDirty("UbigeoCode") )
      {
         gxTv_SdtPaciente_Ubigeocode_N = (byte)(0) ;
         gxTv_SdtPaciente_N = (byte)(0) ;
         gxTv_SdtPaciente_Ubigeocode = sdt.getgxTv_SdtPaciente_Ubigeocode() ;
      }
      if ( sdt.IsDirty("UbigeoNombre") )
      {
         gxTv_SdtPaciente_N = (byte)(0) ;
         gxTv_SdtPaciente_Ubigeonombre = sdt.getgxTv_SdtPaciente_Ubigeonombre() ;
      }
      if ( sdt.IsDirty("PacienteEstatura") )
      {
         gxTv_SdtPaciente_N = (byte)(0) ;
         gxTv_SdtPaciente_Pacienteestatura = sdt.getgxTv_SdtPaciente_Pacienteestatura() ;
      }
      if ( sdt.IsDirty("PacientePeso") )
      {
         gxTv_SdtPaciente_N = (byte)(0) ;
         gxTv_SdtPaciente_Pacientepeso = sdt.getgxTv_SdtPaciente_Pacientepeso() ;
      }
      if ( sdt.IsDirty("PacienteNombreAnexo") )
      {
         gxTv_SdtPaciente_Pacientenombreanexo_N = (byte)(0) ;
         gxTv_SdtPaciente_N = (byte)(0) ;
         gxTv_SdtPaciente_Pacientenombreanexo = sdt.getgxTv_SdtPaciente_Pacientenombreanexo() ;
      }
      if ( sdt.IsDirty("PacienteAnexos") )
      {
         gxTv_SdtPaciente_Pacienteanexos_N = (byte)(0) ;
         gxTv_SdtPaciente_N = (byte)(0) ;
         gxTv_SdtPaciente_Pacienteanexos = sdt.getgxTv_SdtPaciente_Pacienteanexos() ;
      }
      if ( sdt.IsDirty("PacienteEnterarse") )
      {
         gxTv_SdtPaciente_Pacienteenterarse_N = (byte)(0) ;
         gxTv_SdtPaciente_N = (byte)(0) ;
         gxTv_SdtPaciente_Pacienteenterarse = sdt.getgxTv_SdtPaciente_Pacienteenterarse() ;
      }
      if ( sdt.IsDirty("PacienteEspecifique") )
      {
         gxTv_SdtPaciente_Pacienteespecifique_N = (byte)(0) ;
         gxTv_SdtPaciente_N = (byte)(0) ;
         gxTv_SdtPaciente_Pacienteespecifique = sdt.getgxTv_SdtPaciente_Pacienteespecifique() ;
      }
      if ( sdt.IsDirty("PacienteFechaRegistro") )
      {
         gxTv_SdtPaciente_N = (byte)(0) ;
         gxTv_SdtPaciente_Pacientefecharegistro = sdt.getgxTv_SdtPaciente_Pacientefecharegistro() ;
      }
   }

   public int getgxTv_SdtPaciente_Pacienteid( )
   {
      return gxTv_SdtPaciente_Pacienteid ;
   }

   public void setgxTv_SdtPaciente_Pacienteid( int value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      if ( gxTv_SdtPaciente_Pacienteid != value )
      {
         gxTv_SdtPaciente_Mode = "INS" ;
         this.setgxTv_SdtPaciente_Pacienteid_Z_SetNull( );
         this.setgxTv_SdtPaciente_Pacienteapellidopaterno_Z_SetNull( );
         this.setgxTv_SdtPaciente_Pacienteapellidomaterno_Z_SetNull( );
         this.setgxTv_SdtPaciente_Pacientenombres_Z_SetNull( );
         this.setgxTv_SdtPaciente_Pacientenombrecompleto_Z_SetNull( );
         this.setgxTv_SdtPaciente_Pacientefechanacimiento_Z_SetNull( );
         this.setgxTv_SdtPaciente_Pacientetipodocumento_Z_SetNull( );
         this.setgxTv_SdtPaciente_Pacientenrodocumento_Z_SetNull( );
         this.setgxTv_SdtPaciente_Pacientedireccion_Z_SetNull( );
         this.setgxTv_SdtPaciente_Pacientesexo_Z_SetNull( );
         this.setgxTv_SdtPaciente_Pacientecorreo_Z_SetNull( );
         this.setgxTv_SdtPaciente_Pacientetelefono_Z_SetNull( );
         this.setgxTv_SdtPaciente_Paisid_Z_SetNull( );
         this.setgxTv_SdtPaciente_Paisdescripcion_Z_SetNull( );
         this.setgxTv_SdtPaciente_Pacienteestado_Z_SetNull( );
         this.setgxTv_SdtPaciente_Secuserid_Z_SetNull( );
         this.setgxTv_SdtPaciente_Ubigeocode_Z_SetNull( );
         this.setgxTv_SdtPaciente_Ubigeonombre_Z_SetNull( );
         this.setgxTv_SdtPaciente_Pacienteestatura_Z_SetNull( );
         this.setgxTv_SdtPaciente_Pacientepeso_Z_SetNull( );
         this.setgxTv_SdtPaciente_Pacientenombreanexo_Z_SetNull( );
         this.setgxTv_SdtPaciente_Pacienteenterarse_Z_SetNull( );
         this.setgxTv_SdtPaciente_Pacientefecharegistro_Z_SetNull( );
      }
      SetDirty("Pacienteid");
      gxTv_SdtPaciente_Pacienteid = value ;
   }

   public String getgxTv_SdtPaciente_Pacienteapellidopaterno( )
   {
      return gxTv_SdtPaciente_Pacienteapellidopaterno ;
   }

   public void setgxTv_SdtPaciente_Pacienteapellidopaterno( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Pacienteapellidopaterno");
      gxTv_SdtPaciente_Pacienteapellidopaterno = value ;
   }

   public String getgxTv_SdtPaciente_Pacienteapellidomaterno( )
   {
      return gxTv_SdtPaciente_Pacienteapellidomaterno ;
   }

   public void setgxTv_SdtPaciente_Pacienteapellidomaterno( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Pacienteapellidomaterno");
      gxTv_SdtPaciente_Pacienteapellidomaterno = value ;
   }

   public String getgxTv_SdtPaciente_Pacientenombres( )
   {
      return gxTv_SdtPaciente_Pacientenombres ;
   }

   public void setgxTv_SdtPaciente_Pacientenombres( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Pacientenombres");
      gxTv_SdtPaciente_Pacientenombres = value ;
   }

   public String getgxTv_SdtPaciente_Pacientenombrecompleto( )
   {
      return gxTv_SdtPaciente_Pacientenombrecompleto ;
   }

   public void setgxTv_SdtPaciente_Pacientenombrecompleto( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Pacientenombrecompleto");
      gxTv_SdtPaciente_Pacientenombrecompleto = value ;
   }

   public void setgxTv_SdtPaciente_Pacientenombrecompleto_SetNull( )
   {
      gxTv_SdtPaciente_Pacientenombrecompleto = "" ;
   }

   public boolean getgxTv_SdtPaciente_Pacientenombrecompleto_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtPaciente_Pacientefechanacimiento( )
   {
      return gxTv_SdtPaciente_Pacientefechanacimiento ;
   }

   public void setgxTv_SdtPaciente_Pacientefechanacimiento( java.util.Date value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Pacientefechanacimiento");
      gxTv_SdtPaciente_Pacientefechanacimiento = value ;
   }

   public String getgxTv_SdtPaciente_Pacientetipodocumento( )
   {
      return gxTv_SdtPaciente_Pacientetipodocumento ;
   }

   public void setgxTv_SdtPaciente_Pacientetipodocumento( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Pacientetipodocumento");
      gxTv_SdtPaciente_Pacientetipodocumento = value ;
   }

   public String getgxTv_SdtPaciente_Pacientenrodocumento( )
   {
      return gxTv_SdtPaciente_Pacientenrodocumento ;
   }

   public void setgxTv_SdtPaciente_Pacientenrodocumento( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Pacientenrodocumento");
      gxTv_SdtPaciente_Pacientenrodocumento = value ;
   }

   public String getgxTv_SdtPaciente_Pacientedireccion( )
   {
      return gxTv_SdtPaciente_Pacientedireccion ;
   }

   public void setgxTv_SdtPaciente_Pacientedireccion( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Pacientedireccion");
      gxTv_SdtPaciente_Pacientedireccion = value ;
   }

   public String getgxTv_SdtPaciente_Pacientesexo( )
   {
      return gxTv_SdtPaciente_Pacientesexo ;
   }

   public void setgxTv_SdtPaciente_Pacientesexo( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Pacientesexo");
      gxTv_SdtPaciente_Pacientesexo = value ;
   }

   public String getgxTv_SdtPaciente_Pacientecorreo( )
   {
      return gxTv_SdtPaciente_Pacientecorreo ;
   }

   public void setgxTv_SdtPaciente_Pacientecorreo( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Pacientecorreo");
      gxTv_SdtPaciente_Pacientecorreo = value ;
   }

   public String getgxTv_SdtPaciente_Pacientetelefono( )
   {
      return gxTv_SdtPaciente_Pacientetelefono ;
   }

   public void setgxTv_SdtPaciente_Pacientetelefono( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Pacientetelefono");
      gxTv_SdtPaciente_Pacientetelefono = value ;
   }

   public short getgxTv_SdtPaciente_Paisid( )
   {
      return gxTv_SdtPaciente_Paisid ;
   }

   public void setgxTv_SdtPaciente_Paisid( short value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Paisid");
      gxTv_SdtPaciente_Paisid = value ;
   }

   public String getgxTv_SdtPaciente_Paisdescripcion( )
   {
      return gxTv_SdtPaciente_Paisdescripcion ;
   }

   public void setgxTv_SdtPaciente_Paisdescripcion( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Paisdescripcion");
      gxTv_SdtPaciente_Paisdescripcion = value ;
   }

   public String getgxTv_SdtPaciente_Pacienteestado( )
   {
      return gxTv_SdtPaciente_Pacienteestado ;
   }

   public void setgxTv_SdtPaciente_Pacienteestado( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Pacienteestado");
      gxTv_SdtPaciente_Pacienteestado = value ;
   }

   public short getgxTv_SdtPaciente_Secuserid( )
   {
      return gxTv_SdtPaciente_Secuserid ;
   }

   public void setgxTv_SdtPaciente_Secuserid( short value )
   {
      gxTv_SdtPaciente_Secuserid_N = (byte)(0) ;
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Secuserid");
      gxTv_SdtPaciente_Secuserid = value ;
   }

   public void setgxTv_SdtPaciente_Secuserid_SetNull( )
   {
      gxTv_SdtPaciente_Secuserid_N = (byte)(1) ;
      gxTv_SdtPaciente_Secuserid = (short)(0) ;
   }

   public boolean getgxTv_SdtPaciente_Secuserid_IsNull( )
   {
      return (gxTv_SdtPaciente_Secuserid_N==1) ;
   }

   public String getgxTv_SdtPaciente_Ubigeocode( )
   {
      return gxTv_SdtPaciente_Ubigeocode ;
   }

   public void setgxTv_SdtPaciente_Ubigeocode( String value )
   {
      gxTv_SdtPaciente_Ubigeocode_N = (byte)(0) ;
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Ubigeocode");
      gxTv_SdtPaciente_Ubigeocode = value ;
   }

   public void setgxTv_SdtPaciente_Ubigeocode_SetNull( )
   {
      gxTv_SdtPaciente_Ubigeocode_N = (byte)(1) ;
      gxTv_SdtPaciente_Ubigeocode = "" ;
   }

   public boolean getgxTv_SdtPaciente_Ubigeocode_IsNull( )
   {
      return (gxTv_SdtPaciente_Ubigeocode_N==1) ;
   }

   public String getgxTv_SdtPaciente_Ubigeonombre( )
   {
      return gxTv_SdtPaciente_Ubigeonombre ;
   }

   public void setgxTv_SdtPaciente_Ubigeonombre( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Ubigeonombre");
      gxTv_SdtPaciente_Ubigeonombre = value ;
   }

   public void setgxTv_SdtPaciente_Ubigeonombre_SetNull( )
   {
      gxTv_SdtPaciente_Ubigeonombre = "" ;
   }

   public boolean getgxTv_SdtPaciente_Ubigeonombre_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtPaciente_Pacienteestatura( )
   {
      return gxTv_SdtPaciente_Pacienteestatura ;
   }

   public void setgxTv_SdtPaciente_Pacienteestatura( java.math.BigDecimal value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Pacienteestatura");
      gxTv_SdtPaciente_Pacienteestatura = value ;
   }

   public java.math.BigDecimal getgxTv_SdtPaciente_Pacientepeso( )
   {
      return gxTv_SdtPaciente_Pacientepeso ;
   }

   public void setgxTv_SdtPaciente_Pacientepeso( java.math.BigDecimal value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Pacientepeso");
      gxTv_SdtPaciente_Pacientepeso = value ;
   }

   public String getgxTv_SdtPaciente_Pacientenombreanexo( )
   {
      return gxTv_SdtPaciente_Pacientenombreanexo ;
   }

   public void setgxTv_SdtPaciente_Pacientenombreanexo( String value )
   {
      gxTv_SdtPaciente_Pacientenombreanexo_N = (byte)(0) ;
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Pacientenombreanexo");
      gxTv_SdtPaciente_Pacientenombreanexo = value ;
   }

   public void setgxTv_SdtPaciente_Pacientenombreanexo_SetNull( )
   {
      gxTv_SdtPaciente_Pacientenombreanexo_N = (byte)(1) ;
      gxTv_SdtPaciente_Pacientenombreanexo = "" ;
   }

   public boolean getgxTv_SdtPaciente_Pacientenombreanexo_IsNull( )
   {
      return (gxTv_SdtPaciente_Pacientenombreanexo_N==1) ;
   }

   @GxUpload
   public String getgxTv_SdtPaciente_Pacienteanexos( )
   {
      return gxTv_SdtPaciente_Pacienteanexos ;
   }

   public void setgxTv_SdtPaciente_Pacienteanexos( String value )
   {
      gxTv_SdtPaciente_Pacienteanexos_N = (byte)(0) ;
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Pacienteanexos");
      gxTv_SdtPaciente_Pacienteanexos = value ;
   }

   public void setgxTv_SdtPaciente_Pacienteanexos_SetBlob( String blob ,
                                                           String fileName ,
                                                           String fileType )
   {
      gxTv_SdtPaciente_Pacienteanexos = blob ;
   }

   public void setgxTv_SdtPaciente_Pacienteanexos_SetNull( )
   {
      gxTv_SdtPaciente_Pacienteanexos_N = (byte)(1) ;
      gxTv_SdtPaciente_Pacienteanexos = "" ;
   }

   public boolean getgxTv_SdtPaciente_Pacienteanexos_IsNull( )
   {
      return (gxTv_SdtPaciente_Pacienteanexos_N==1) ;
   }

   public String getgxTv_SdtPaciente_Pacienteenterarse( )
   {
      return gxTv_SdtPaciente_Pacienteenterarse ;
   }

   public void setgxTv_SdtPaciente_Pacienteenterarse( String value )
   {
      gxTv_SdtPaciente_Pacienteenterarse_N = (byte)(0) ;
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Pacienteenterarse");
      gxTv_SdtPaciente_Pacienteenterarse = value ;
   }

   public void setgxTv_SdtPaciente_Pacienteenterarse_SetNull( )
   {
      gxTv_SdtPaciente_Pacienteenterarse_N = (byte)(1) ;
      gxTv_SdtPaciente_Pacienteenterarse = "" ;
   }

   public boolean getgxTv_SdtPaciente_Pacienteenterarse_IsNull( )
   {
      return (gxTv_SdtPaciente_Pacienteenterarse_N==1) ;
   }

   public String getgxTv_SdtPaciente_Pacienteespecifique( )
   {
      return gxTv_SdtPaciente_Pacienteespecifique ;
   }

   public void setgxTv_SdtPaciente_Pacienteespecifique( String value )
   {
      gxTv_SdtPaciente_Pacienteespecifique_N = (byte)(0) ;
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Pacienteespecifique");
      gxTv_SdtPaciente_Pacienteespecifique = value ;
   }

   public void setgxTv_SdtPaciente_Pacienteespecifique_SetNull( )
   {
      gxTv_SdtPaciente_Pacienteespecifique_N = (byte)(1) ;
      gxTv_SdtPaciente_Pacienteespecifique = "" ;
   }

   public boolean getgxTv_SdtPaciente_Pacienteespecifique_IsNull( )
   {
      return (gxTv_SdtPaciente_Pacienteespecifique_N==1) ;
   }

   public java.util.Date getgxTv_SdtPaciente_Pacientefecharegistro( )
   {
      return gxTv_SdtPaciente_Pacientefecharegistro ;
   }

   public void setgxTv_SdtPaciente_Pacientefecharegistro( java.util.Date value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Pacientefecharegistro");
      gxTv_SdtPaciente_Pacientefecharegistro = value ;
   }

   public String getgxTv_SdtPaciente_Mode( )
   {
      return gxTv_SdtPaciente_Mode ;
   }

   public void setgxTv_SdtPaciente_Mode( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtPaciente_Mode = value ;
   }

   public void setgxTv_SdtPaciente_Mode_SetNull( )
   {
      gxTv_SdtPaciente_Mode = "" ;
   }

   public boolean getgxTv_SdtPaciente_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtPaciente_Initialized( )
   {
      return gxTv_SdtPaciente_Initialized ;
   }

   public void setgxTv_SdtPaciente_Initialized( short value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtPaciente_Initialized = value ;
   }

   public void setgxTv_SdtPaciente_Initialized_SetNull( )
   {
      gxTv_SdtPaciente_Initialized = (short)(0) ;
   }

   public boolean getgxTv_SdtPaciente_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtPaciente_Pacienteid_Z( )
   {
      return gxTv_SdtPaciente_Pacienteid_Z ;
   }

   public void setgxTv_SdtPaciente_Pacienteid_Z( int value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Pacienteid_Z");
      gxTv_SdtPaciente_Pacienteid_Z = value ;
   }

   public void setgxTv_SdtPaciente_Pacienteid_Z_SetNull( )
   {
      gxTv_SdtPaciente_Pacienteid_Z = 0 ;
   }

   public boolean getgxTv_SdtPaciente_Pacienteid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPaciente_Pacienteapellidopaterno_Z( )
   {
      return gxTv_SdtPaciente_Pacienteapellidopaterno_Z ;
   }

   public void setgxTv_SdtPaciente_Pacienteapellidopaterno_Z( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Pacienteapellidopaterno_Z");
      gxTv_SdtPaciente_Pacienteapellidopaterno_Z = value ;
   }

   public void setgxTv_SdtPaciente_Pacienteapellidopaterno_Z_SetNull( )
   {
      gxTv_SdtPaciente_Pacienteapellidopaterno_Z = "" ;
   }

   public boolean getgxTv_SdtPaciente_Pacienteapellidopaterno_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPaciente_Pacienteapellidomaterno_Z( )
   {
      return gxTv_SdtPaciente_Pacienteapellidomaterno_Z ;
   }

   public void setgxTv_SdtPaciente_Pacienteapellidomaterno_Z( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Pacienteapellidomaterno_Z");
      gxTv_SdtPaciente_Pacienteapellidomaterno_Z = value ;
   }

   public void setgxTv_SdtPaciente_Pacienteapellidomaterno_Z_SetNull( )
   {
      gxTv_SdtPaciente_Pacienteapellidomaterno_Z = "" ;
   }

   public boolean getgxTv_SdtPaciente_Pacienteapellidomaterno_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPaciente_Pacientenombres_Z( )
   {
      return gxTv_SdtPaciente_Pacientenombres_Z ;
   }

   public void setgxTv_SdtPaciente_Pacientenombres_Z( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Pacientenombres_Z");
      gxTv_SdtPaciente_Pacientenombres_Z = value ;
   }

   public void setgxTv_SdtPaciente_Pacientenombres_Z_SetNull( )
   {
      gxTv_SdtPaciente_Pacientenombres_Z = "" ;
   }

   public boolean getgxTv_SdtPaciente_Pacientenombres_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPaciente_Pacientenombrecompleto_Z( )
   {
      return gxTv_SdtPaciente_Pacientenombrecompleto_Z ;
   }

   public void setgxTv_SdtPaciente_Pacientenombrecompleto_Z( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Pacientenombrecompleto_Z");
      gxTv_SdtPaciente_Pacientenombrecompleto_Z = value ;
   }

   public void setgxTv_SdtPaciente_Pacientenombrecompleto_Z_SetNull( )
   {
      gxTv_SdtPaciente_Pacientenombrecompleto_Z = "" ;
   }

   public boolean getgxTv_SdtPaciente_Pacientenombrecompleto_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtPaciente_Pacientefechanacimiento_Z( )
   {
      return gxTv_SdtPaciente_Pacientefechanacimiento_Z ;
   }

   public void setgxTv_SdtPaciente_Pacientefechanacimiento_Z( java.util.Date value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Pacientefechanacimiento_Z");
      gxTv_SdtPaciente_Pacientefechanacimiento_Z = value ;
   }

   public void setgxTv_SdtPaciente_Pacientefechanacimiento_Z_SetNull( )
   {
      gxTv_SdtPaciente_Pacientefechanacimiento_Z = GXutil.nullDate() ;
   }

   public boolean getgxTv_SdtPaciente_Pacientefechanacimiento_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPaciente_Pacientetipodocumento_Z( )
   {
      return gxTv_SdtPaciente_Pacientetipodocumento_Z ;
   }

   public void setgxTv_SdtPaciente_Pacientetipodocumento_Z( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Pacientetipodocumento_Z");
      gxTv_SdtPaciente_Pacientetipodocumento_Z = value ;
   }

   public void setgxTv_SdtPaciente_Pacientetipodocumento_Z_SetNull( )
   {
      gxTv_SdtPaciente_Pacientetipodocumento_Z = "" ;
   }

   public boolean getgxTv_SdtPaciente_Pacientetipodocumento_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPaciente_Pacientenrodocumento_Z( )
   {
      return gxTv_SdtPaciente_Pacientenrodocumento_Z ;
   }

   public void setgxTv_SdtPaciente_Pacientenrodocumento_Z( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Pacientenrodocumento_Z");
      gxTv_SdtPaciente_Pacientenrodocumento_Z = value ;
   }

   public void setgxTv_SdtPaciente_Pacientenrodocumento_Z_SetNull( )
   {
      gxTv_SdtPaciente_Pacientenrodocumento_Z = "" ;
   }

   public boolean getgxTv_SdtPaciente_Pacientenrodocumento_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPaciente_Pacientedireccion_Z( )
   {
      return gxTv_SdtPaciente_Pacientedireccion_Z ;
   }

   public void setgxTv_SdtPaciente_Pacientedireccion_Z( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Pacientedireccion_Z");
      gxTv_SdtPaciente_Pacientedireccion_Z = value ;
   }

   public void setgxTv_SdtPaciente_Pacientedireccion_Z_SetNull( )
   {
      gxTv_SdtPaciente_Pacientedireccion_Z = "" ;
   }

   public boolean getgxTv_SdtPaciente_Pacientedireccion_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPaciente_Pacientesexo_Z( )
   {
      return gxTv_SdtPaciente_Pacientesexo_Z ;
   }

   public void setgxTv_SdtPaciente_Pacientesexo_Z( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Pacientesexo_Z");
      gxTv_SdtPaciente_Pacientesexo_Z = value ;
   }

   public void setgxTv_SdtPaciente_Pacientesexo_Z_SetNull( )
   {
      gxTv_SdtPaciente_Pacientesexo_Z = "" ;
   }

   public boolean getgxTv_SdtPaciente_Pacientesexo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPaciente_Pacientecorreo_Z( )
   {
      return gxTv_SdtPaciente_Pacientecorreo_Z ;
   }

   public void setgxTv_SdtPaciente_Pacientecorreo_Z( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Pacientecorreo_Z");
      gxTv_SdtPaciente_Pacientecorreo_Z = value ;
   }

   public void setgxTv_SdtPaciente_Pacientecorreo_Z_SetNull( )
   {
      gxTv_SdtPaciente_Pacientecorreo_Z = "" ;
   }

   public boolean getgxTv_SdtPaciente_Pacientecorreo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPaciente_Pacientetelefono_Z( )
   {
      return gxTv_SdtPaciente_Pacientetelefono_Z ;
   }

   public void setgxTv_SdtPaciente_Pacientetelefono_Z( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Pacientetelefono_Z");
      gxTv_SdtPaciente_Pacientetelefono_Z = value ;
   }

   public void setgxTv_SdtPaciente_Pacientetelefono_Z_SetNull( )
   {
      gxTv_SdtPaciente_Pacientetelefono_Z = "" ;
   }

   public boolean getgxTv_SdtPaciente_Pacientetelefono_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtPaciente_Paisid_Z( )
   {
      return gxTv_SdtPaciente_Paisid_Z ;
   }

   public void setgxTv_SdtPaciente_Paisid_Z( short value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Paisid_Z");
      gxTv_SdtPaciente_Paisid_Z = value ;
   }

   public void setgxTv_SdtPaciente_Paisid_Z_SetNull( )
   {
      gxTv_SdtPaciente_Paisid_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtPaciente_Paisid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPaciente_Paisdescripcion_Z( )
   {
      return gxTv_SdtPaciente_Paisdescripcion_Z ;
   }

   public void setgxTv_SdtPaciente_Paisdescripcion_Z( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Paisdescripcion_Z");
      gxTv_SdtPaciente_Paisdescripcion_Z = value ;
   }

   public void setgxTv_SdtPaciente_Paisdescripcion_Z_SetNull( )
   {
      gxTv_SdtPaciente_Paisdescripcion_Z = "" ;
   }

   public boolean getgxTv_SdtPaciente_Paisdescripcion_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPaciente_Pacienteestado_Z( )
   {
      return gxTv_SdtPaciente_Pacienteestado_Z ;
   }

   public void setgxTv_SdtPaciente_Pacienteestado_Z( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Pacienteestado_Z");
      gxTv_SdtPaciente_Pacienteestado_Z = value ;
   }

   public void setgxTv_SdtPaciente_Pacienteestado_Z_SetNull( )
   {
      gxTv_SdtPaciente_Pacienteestado_Z = "" ;
   }

   public boolean getgxTv_SdtPaciente_Pacienteestado_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtPaciente_Secuserid_Z( )
   {
      return gxTv_SdtPaciente_Secuserid_Z ;
   }

   public void setgxTv_SdtPaciente_Secuserid_Z( short value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Secuserid_Z");
      gxTv_SdtPaciente_Secuserid_Z = value ;
   }

   public void setgxTv_SdtPaciente_Secuserid_Z_SetNull( )
   {
      gxTv_SdtPaciente_Secuserid_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtPaciente_Secuserid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPaciente_Ubigeocode_Z( )
   {
      return gxTv_SdtPaciente_Ubigeocode_Z ;
   }

   public void setgxTv_SdtPaciente_Ubigeocode_Z( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Ubigeocode_Z");
      gxTv_SdtPaciente_Ubigeocode_Z = value ;
   }

   public void setgxTv_SdtPaciente_Ubigeocode_Z_SetNull( )
   {
      gxTv_SdtPaciente_Ubigeocode_Z = "" ;
   }

   public boolean getgxTv_SdtPaciente_Ubigeocode_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPaciente_Ubigeonombre_Z( )
   {
      return gxTv_SdtPaciente_Ubigeonombre_Z ;
   }

   public void setgxTv_SdtPaciente_Ubigeonombre_Z( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Ubigeonombre_Z");
      gxTv_SdtPaciente_Ubigeonombre_Z = value ;
   }

   public void setgxTv_SdtPaciente_Ubigeonombre_Z_SetNull( )
   {
      gxTv_SdtPaciente_Ubigeonombre_Z = "" ;
   }

   public boolean getgxTv_SdtPaciente_Ubigeonombre_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtPaciente_Pacienteestatura_Z( )
   {
      return gxTv_SdtPaciente_Pacienteestatura_Z ;
   }

   public void setgxTv_SdtPaciente_Pacienteestatura_Z( java.math.BigDecimal value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Pacienteestatura_Z");
      gxTv_SdtPaciente_Pacienteestatura_Z = value ;
   }

   public void setgxTv_SdtPaciente_Pacienteestatura_Z_SetNull( )
   {
      gxTv_SdtPaciente_Pacienteestatura_Z = DecimalUtil.ZERO ;
   }

   public boolean getgxTv_SdtPaciente_Pacienteestatura_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtPaciente_Pacientepeso_Z( )
   {
      return gxTv_SdtPaciente_Pacientepeso_Z ;
   }

   public void setgxTv_SdtPaciente_Pacientepeso_Z( java.math.BigDecimal value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Pacientepeso_Z");
      gxTv_SdtPaciente_Pacientepeso_Z = value ;
   }

   public void setgxTv_SdtPaciente_Pacientepeso_Z_SetNull( )
   {
      gxTv_SdtPaciente_Pacientepeso_Z = DecimalUtil.ZERO ;
   }

   public boolean getgxTv_SdtPaciente_Pacientepeso_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPaciente_Pacientenombreanexo_Z( )
   {
      return gxTv_SdtPaciente_Pacientenombreanexo_Z ;
   }

   public void setgxTv_SdtPaciente_Pacientenombreanexo_Z( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Pacientenombreanexo_Z");
      gxTv_SdtPaciente_Pacientenombreanexo_Z = value ;
   }

   public void setgxTv_SdtPaciente_Pacientenombreanexo_Z_SetNull( )
   {
      gxTv_SdtPaciente_Pacientenombreanexo_Z = "" ;
   }

   public boolean getgxTv_SdtPaciente_Pacientenombreanexo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPaciente_Pacienteenterarse_Z( )
   {
      return gxTv_SdtPaciente_Pacienteenterarse_Z ;
   }

   public void setgxTv_SdtPaciente_Pacienteenterarse_Z( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Pacienteenterarse_Z");
      gxTv_SdtPaciente_Pacienteenterarse_Z = value ;
   }

   public void setgxTv_SdtPaciente_Pacienteenterarse_Z_SetNull( )
   {
      gxTv_SdtPaciente_Pacienteenterarse_Z = "" ;
   }

   public boolean getgxTv_SdtPaciente_Pacienteenterarse_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtPaciente_Pacientefecharegistro_Z( )
   {
      return gxTv_SdtPaciente_Pacientefecharegistro_Z ;
   }

   public void setgxTv_SdtPaciente_Pacientefecharegistro_Z( java.util.Date value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Pacientefecharegistro_Z");
      gxTv_SdtPaciente_Pacientefecharegistro_Z = value ;
   }

   public void setgxTv_SdtPaciente_Pacientefecharegistro_Z_SetNull( )
   {
      gxTv_SdtPaciente_Pacientefecharegistro_Z = GXutil.resetTime( GXutil.nullDate() );
   }

   public boolean getgxTv_SdtPaciente_Pacientefecharegistro_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtPaciente_Secuserid_N( )
   {
      return gxTv_SdtPaciente_Secuserid_N ;
   }

   public void setgxTv_SdtPaciente_Secuserid_N( byte value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Secuserid_N");
      gxTv_SdtPaciente_Secuserid_N = value ;
   }

   public void setgxTv_SdtPaciente_Secuserid_N_SetNull( )
   {
      gxTv_SdtPaciente_Secuserid_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtPaciente_Secuserid_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtPaciente_Ubigeocode_N( )
   {
      return gxTv_SdtPaciente_Ubigeocode_N ;
   }

   public void setgxTv_SdtPaciente_Ubigeocode_N( byte value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Ubigeocode_N");
      gxTv_SdtPaciente_Ubigeocode_N = value ;
   }

   public void setgxTv_SdtPaciente_Ubigeocode_N_SetNull( )
   {
      gxTv_SdtPaciente_Ubigeocode_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtPaciente_Ubigeocode_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtPaciente_Pacientenombreanexo_N( )
   {
      return gxTv_SdtPaciente_Pacientenombreanexo_N ;
   }

   public void setgxTv_SdtPaciente_Pacientenombreanexo_N( byte value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Pacientenombreanexo_N");
      gxTv_SdtPaciente_Pacientenombreanexo_N = value ;
   }

   public void setgxTv_SdtPaciente_Pacientenombreanexo_N_SetNull( )
   {
      gxTv_SdtPaciente_Pacientenombreanexo_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtPaciente_Pacientenombreanexo_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtPaciente_Pacienteanexos_N( )
   {
      return gxTv_SdtPaciente_Pacienteanexos_N ;
   }

   public void setgxTv_SdtPaciente_Pacienteanexos_N( byte value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Pacienteanexos_N");
      gxTv_SdtPaciente_Pacienteanexos_N = value ;
   }

   public void setgxTv_SdtPaciente_Pacienteanexos_N_SetNull( )
   {
      gxTv_SdtPaciente_Pacienteanexos_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtPaciente_Pacienteanexos_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtPaciente_Pacienteenterarse_N( )
   {
      return gxTv_SdtPaciente_Pacienteenterarse_N ;
   }

   public void setgxTv_SdtPaciente_Pacienteenterarse_N( byte value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Pacienteenterarse_N");
      gxTv_SdtPaciente_Pacienteenterarse_N = value ;
   }

   public void setgxTv_SdtPaciente_Pacienteenterarse_N_SetNull( )
   {
      gxTv_SdtPaciente_Pacienteenterarse_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtPaciente_Pacienteenterarse_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtPaciente_Pacienteespecifique_N( )
   {
      return gxTv_SdtPaciente_Pacienteespecifique_N ;
   }

   public void setgxTv_SdtPaciente_Pacienteespecifique_N( byte value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      SetDirty("Pacienteespecifique_N");
      gxTv_SdtPaciente_Pacienteespecifique_N = value ;
   }

   public void setgxTv_SdtPaciente_Pacienteespecifique_N_SetNull( )
   {
      gxTv_SdtPaciente_Pacienteespecifique_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtPaciente_Pacienteespecifique_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.projectthani.paciente_bc obj;
      obj = new com.projectthani.paciente_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtPaciente_N = (byte)(1) ;
      gxTv_SdtPaciente_Pacienteapellidopaterno = "" ;
      gxTv_SdtPaciente_Pacienteapellidomaterno = "" ;
      gxTv_SdtPaciente_Pacientenombres = "" ;
      gxTv_SdtPaciente_Pacientenombrecompleto = "" ;
      gxTv_SdtPaciente_Pacientefechanacimiento = GXutil.nullDate() ;
      gxTv_SdtPaciente_Pacientetipodocumento = "" ;
      gxTv_SdtPaciente_Pacientenrodocumento = "" ;
      gxTv_SdtPaciente_Pacientedireccion = "" ;
      gxTv_SdtPaciente_Pacientesexo = "" ;
      gxTv_SdtPaciente_Pacientecorreo = "" ;
      gxTv_SdtPaciente_Pacientetelefono = "" ;
      gxTv_SdtPaciente_Paisdescripcion = "" ;
      gxTv_SdtPaciente_Pacienteestado = "" ;
      gxTv_SdtPaciente_Ubigeocode = "" ;
      gxTv_SdtPaciente_Ubigeonombre = "" ;
      gxTv_SdtPaciente_Pacienteestatura = DecimalUtil.ZERO ;
      gxTv_SdtPaciente_Pacientepeso = DecimalUtil.ZERO ;
      gxTv_SdtPaciente_Pacientenombreanexo = "" ;
      gxTv_SdtPaciente_Pacienteanexos = "" ;
      gxTv_SdtPaciente_Pacienteenterarse = "" ;
      gxTv_SdtPaciente_Pacienteespecifique = "" ;
      gxTv_SdtPaciente_Pacientefecharegistro = GXutil.now( ) ;
      gxTv_SdtPaciente_Mode = "" ;
      gxTv_SdtPaciente_Pacienteapellidopaterno_Z = "" ;
      gxTv_SdtPaciente_Pacienteapellidomaterno_Z = "" ;
      gxTv_SdtPaciente_Pacientenombres_Z = "" ;
      gxTv_SdtPaciente_Pacientenombrecompleto_Z = "" ;
      gxTv_SdtPaciente_Pacientefechanacimiento_Z = GXutil.nullDate() ;
      gxTv_SdtPaciente_Pacientetipodocumento_Z = "" ;
      gxTv_SdtPaciente_Pacientenrodocumento_Z = "" ;
      gxTv_SdtPaciente_Pacientedireccion_Z = "" ;
      gxTv_SdtPaciente_Pacientesexo_Z = "" ;
      gxTv_SdtPaciente_Pacientecorreo_Z = "" ;
      gxTv_SdtPaciente_Pacientetelefono_Z = "" ;
      gxTv_SdtPaciente_Paisdescripcion_Z = "" ;
      gxTv_SdtPaciente_Pacienteestado_Z = "" ;
      gxTv_SdtPaciente_Ubigeocode_Z = "" ;
      gxTv_SdtPaciente_Ubigeonombre_Z = "" ;
      gxTv_SdtPaciente_Pacienteestatura_Z = DecimalUtil.ZERO ;
      gxTv_SdtPaciente_Pacientepeso_Z = DecimalUtil.ZERO ;
      gxTv_SdtPaciente_Pacientenombreanexo_Z = "" ;
      gxTv_SdtPaciente_Pacienteenterarse_Z = "" ;
      gxTv_SdtPaciente_Pacientefecharegistro_Z = GXutil.resetTime( GXutil.nullDate() );
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
      datetime_STZ = GXutil.resetTime( GXutil.nullDate() );
   }

   public byte isNull( )
   {
      return gxTv_SdtPaciente_N ;
   }

   public com.projectthani.SdtPaciente Clone( )
   {
      com.projectthani.SdtPaciente sdt;
      com.projectthani.paciente_bc obj;
      sdt = (com.projectthani.SdtPaciente)(clone()) ;
      obj = (com.projectthani.paciente_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.projectthani.StructSdtPaciente struct )
   {
      setgxTv_SdtPaciente_Pacienteid(struct.getPacienteid());
      setgxTv_SdtPaciente_Pacienteapellidopaterno(struct.getPacienteapellidopaterno());
      setgxTv_SdtPaciente_Pacienteapellidomaterno(struct.getPacienteapellidomaterno());
      setgxTv_SdtPaciente_Pacientenombres(struct.getPacientenombres());
      setgxTv_SdtPaciente_Pacientenombrecompleto(struct.getPacientenombrecompleto());
      setgxTv_SdtPaciente_Pacientefechanacimiento(struct.getPacientefechanacimiento());
      setgxTv_SdtPaciente_Pacientetipodocumento(struct.getPacientetipodocumento());
      setgxTv_SdtPaciente_Pacientenrodocumento(struct.getPacientenrodocumento());
      setgxTv_SdtPaciente_Pacientedireccion(struct.getPacientedireccion());
      setgxTv_SdtPaciente_Pacientesexo(struct.getPacientesexo());
      setgxTv_SdtPaciente_Pacientecorreo(struct.getPacientecorreo());
      setgxTv_SdtPaciente_Pacientetelefono(struct.getPacientetelefono());
      setgxTv_SdtPaciente_Paisid(struct.getPaisid());
      setgxTv_SdtPaciente_Paisdescripcion(struct.getPaisdescripcion());
      setgxTv_SdtPaciente_Pacienteestado(struct.getPacienteestado());
      setgxTv_SdtPaciente_Secuserid(struct.getSecuserid());
      setgxTv_SdtPaciente_Ubigeocode(struct.getUbigeocode());
      setgxTv_SdtPaciente_Ubigeonombre(struct.getUbigeonombre());
      setgxTv_SdtPaciente_Pacienteestatura(struct.getPacienteestatura());
      setgxTv_SdtPaciente_Pacientepeso(struct.getPacientepeso());
      setgxTv_SdtPaciente_Pacientenombreanexo(struct.getPacientenombreanexo());
      setgxTv_SdtPaciente_Pacienteanexos(struct.getPacienteanexos());
      setgxTv_SdtPaciente_Pacienteenterarse(struct.getPacienteenterarse());
      setgxTv_SdtPaciente_Pacienteespecifique(struct.getPacienteespecifique());
      setgxTv_SdtPaciente_Pacientefecharegistro(struct.getPacientefecharegistro());
      setgxTv_SdtPaciente_Mode(struct.getMode());
      setgxTv_SdtPaciente_Initialized(struct.getInitialized());
      setgxTv_SdtPaciente_Pacienteid_Z(struct.getPacienteid_Z());
      setgxTv_SdtPaciente_Pacienteapellidopaterno_Z(struct.getPacienteapellidopaterno_Z());
      setgxTv_SdtPaciente_Pacienteapellidomaterno_Z(struct.getPacienteapellidomaterno_Z());
      setgxTv_SdtPaciente_Pacientenombres_Z(struct.getPacientenombres_Z());
      setgxTv_SdtPaciente_Pacientenombrecompleto_Z(struct.getPacientenombrecompleto_Z());
      setgxTv_SdtPaciente_Pacientefechanacimiento_Z(struct.getPacientefechanacimiento_Z());
      setgxTv_SdtPaciente_Pacientetipodocumento_Z(struct.getPacientetipodocumento_Z());
      setgxTv_SdtPaciente_Pacientenrodocumento_Z(struct.getPacientenrodocumento_Z());
      setgxTv_SdtPaciente_Pacientedireccion_Z(struct.getPacientedireccion_Z());
      setgxTv_SdtPaciente_Pacientesexo_Z(struct.getPacientesexo_Z());
      setgxTv_SdtPaciente_Pacientecorreo_Z(struct.getPacientecorreo_Z());
      setgxTv_SdtPaciente_Pacientetelefono_Z(struct.getPacientetelefono_Z());
      setgxTv_SdtPaciente_Paisid_Z(struct.getPaisid_Z());
      setgxTv_SdtPaciente_Paisdescripcion_Z(struct.getPaisdescripcion_Z());
      setgxTv_SdtPaciente_Pacienteestado_Z(struct.getPacienteestado_Z());
      setgxTv_SdtPaciente_Secuserid_Z(struct.getSecuserid_Z());
      setgxTv_SdtPaciente_Ubigeocode_Z(struct.getUbigeocode_Z());
      setgxTv_SdtPaciente_Ubigeonombre_Z(struct.getUbigeonombre_Z());
      setgxTv_SdtPaciente_Pacienteestatura_Z(struct.getPacienteestatura_Z());
      setgxTv_SdtPaciente_Pacientepeso_Z(struct.getPacientepeso_Z());
      setgxTv_SdtPaciente_Pacientenombreanexo_Z(struct.getPacientenombreanexo_Z());
      setgxTv_SdtPaciente_Pacienteenterarse_Z(struct.getPacienteenterarse_Z());
      setgxTv_SdtPaciente_Pacientefecharegistro_Z(struct.getPacientefecharegistro_Z());
      setgxTv_SdtPaciente_Secuserid_N(struct.getSecuserid_N());
      setgxTv_SdtPaciente_Ubigeocode_N(struct.getUbigeocode_N());
      setgxTv_SdtPaciente_Pacientenombreanexo_N(struct.getPacientenombreanexo_N());
      setgxTv_SdtPaciente_Pacienteanexos_N(struct.getPacienteanexos_N());
      setgxTv_SdtPaciente_Pacienteenterarse_N(struct.getPacienteenterarse_N());
      setgxTv_SdtPaciente_Pacienteespecifique_N(struct.getPacienteespecifique_N());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtPaciente getStruct( )
   {
      com.projectthani.StructSdtPaciente struct = new com.projectthani.StructSdtPaciente ();
      struct.setPacienteid(getgxTv_SdtPaciente_Pacienteid());
      struct.setPacienteapellidopaterno(getgxTv_SdtPaciente_Pacienteapellidopaterno());
      struct.setPacienteapellidomaterno(getgxTv_SdtPaciente_Pacienteapellidomaterno());
      struct.setPacientenombres(getgxTv_SdtPaciente_Pacientenombres());
      struct.setPacientenombrecompleto(getgxTv_SdtPaciente_Pacientenombrecompleto());
      struct.setPacientefechanacimiento(getgxTv_SdtPaciente_Pacientefechanacimiento());
      struct.setPacientetipodocumento(getgxTv_SdtPaciente_Pacientetipodocumento());
      struct.setPacientenrodocumento(getgxTv_SdtPaciente_Pacientenrodocumento());
      struct.setPacientedireccion(getgxTv_SdtPaciente_Pacientedireccion());
      struct.setPacientesexo(getgxTv_SdtPaciente_Pacientesexo());
      struct.setPacientecorreo(getgxTv_SdtPaciente_Pacientecorreo());
      struct.setPacientetelefono(getgxTv_SdtPaciente_Pacientetelefono());
      struct.setPaisid(getgxTv_SdtPaciente_Paisid());
      struct.setPaisdescripcion(getgxTv_SdtPaciente_Paisdescripcion());
      struct.setPacienteestado(getgxTv_SdtPaciente_Pacienteestado());
      struct.setSecuserid(getgxTv_SdtPaciente_Secuserid());
      struct.setUbigeocode(getgxTv_SdtPaciente_Ubigeocode());
      struct.setUbigeonombre(getgxTv_SdtPaciente_Ubigeonombre());
      struct.setPacienteestatura(getgxTv_SdtPaciente_Pacienteestatura());
      struct.setPacientepeso(getgxTv_SdtPaciente_Pacientepeso());
      struct.setPacientenombreanexo(getgxTv_SdtPaciente_Pacientenombreanexo());
      struct.setPacienteanexos(getgxTv_SdtPaciente_Pacienteanexos());
      struct.setPacienteenterarse(getgxTv_SdtPaciente_Pacienteenterarse());
      struct.setPacienteespecifique(getgxTv_SdtPaciente_Pacienteespecifique());
      struct.setPacientefecharegistro(getgxTv_SdtPaciente_Pacientefecharegistro());
      struct.setMode(getgxTv_SdtPaciente_Mode());
      struct.setInitialized(getgxTv_SdtPaciente_Initialized());
      struct.setPacienteid_Z(getgxTv_SdtPaciente_Pacienteid_Z());
      struct.setPacienteapellidopaterno_Z(getgxTv_SdtPaciente_Pacienteapellidopaterno_Z());
      struct.setPacienteapellidomaterno_Z(getgxTv_SdtPaciente_Pacienteapellidomaterno_Z());
      struct.setPacientenombres_Z(getgxTv_SdtPaciente_Pacientenombres_Z());
      struct.setPacientenombrecompleto_Z(getgxTv_SdtPaciente_Pacientenombrecompleto_Z());
      struct.setPacientefechanacimiento_Z(getgxTv_SdtPaciente_Pacientefechanacimiento_Z());
      struct.setPacientetipodocumento_Z(getgxTv_SdtPaciente_Pacientetipodocumento_Z());
      struct.setPacientenrodocumento_Z(getgxTv_SdtPaciente_Pacientenrodocumento_Z());
      struct.setPacientedireccion_Z(getgxTv_SdtPaciente_Pacientedireccion_Z());
      struct.setPacientesexo_Z(getgxTv_SdtPaciente_Pacientesexo_Z());
      struct.setPacientecorreo_Z(getgxTv_SdtPaciente_Pacientecorreo_Z());
      struct.setPacientetelefono_Z(getgxTv_SdtPaciente_Pacientetelefono_Z());
      struct.setPaisid_Z(getgxTv_SdtPaciente_Paisid_Z());
      struct.setPaisdescripcion_Z(getgxTv_SdtPaciente_Paisdescripcion_Z());
      struct.setPacienteestado_Z(getgxTv_SdtPaciente_Pacienteestado_Z());
      struct.setSecuserid_Z(getgxTv_SdtPaciente_Secuserid_Z());
      struct.setUbigeocode_Z(getgxTv_SdtPaciente_Ubigeocode_Z());
      struct.setUbigeonombre_Z(getgxTv_SdtPaciente_Ubigeonombre_Z());
      struct.setPacienteestatura_Z(getgxTv_SdtPaciente_Pacienteestatura_Z());
      struct.setPacientepeso_Z(getgxTv_SdtPaciente_Pacientepeso_Z());
      struct.setPacientenombreanexo_Z(getgxTv_SdtPaciente_Pacientenombreanexo_Z());
      struct.setPacienteenterarse_Z(getgxTv_SdtPaciente_Pacienteenterarse_Z());
      struct.setPacientefecharegistro_Z(getgxTv_SdtPaciente_Pacientefecharegistro_Z());
      struct.setSecuserid_N(getgxTv_SdtPaciente_Secuserid_N());
      struct.setUbigeocode_N(getgxTv_SdtPaciente_Ubigeocode_N());
      struct.setPacientenombreanexo_N(getgxTv_SdtPaciente_Pacientenombreanexo_N());
      struct.setPacienteanexos_N(getgxTv_SdtPaciente_Pacienteanexos_N());
      struct.setPacienteenterarse_N(getgxTv_SdtPaciente_Pacienteenterarse_N());
      struct.setPacienteespecifique_N(getgxTv_SdtPaciente_Pacienteespecifique_N());
      return struct ;
   }

   private byte gxTv_SdtPaciente_N ;
   private byte gxTv_SdtPaciente_Secuserid_N ;
   private byte gxTv_SdtPaciente_Ubigeocode_N ;
   private byte gxTv_SdtPaciente_Pacientenombreanexo_N ;
   private byte gxTv_SdtPaciente_Pacienteanexos_N ;
   private byte gxTv_SdtPaciente_Pacienteenterarse_N ;
   private byte gxTv_SdtPaciente_Pacienteespecifique_N ;
   private short gxTv_SdtPaciente_Paisid ;
   private short gxTv_SdtPaciente_Secuserid ;
   private short gxTv_SdtPaciente_Initialized ;
   private short gxTv_SdtPaciente_Paisid_Z ;
   private short gxTv_SdtPaciente_Secuserid_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtPaciente_Pacienteid ;
   private int gxTv_SdtPaciente_Pacienteid_Z ;
   private java.math.BigDecimal gxTv_SdtPaciente_Pacienteestatura ;
   private java.math.BigDecimal gxTv_SdtPaciente_Pacientepeso ;
   private java.math.BigDecimal gxTv_SdtPaciente_Pacienteestatura_Z ;
   private java.math.BigDecimal gxTv_SdtPaciente_Pacientepeso_Z ;
   private String gxTv_SdtPaciente_Pacientetipodocumento ;
   private String gxTv_SdtPaciente_Pacientesexo ;
   private String gxTv_SdtPaciente_Pacientetelefono ;
   private String gxTv_SdtPaciente_Pacienteestado ;
   private String gxTv_SdtPaciente_Ubigeocode ;
   private String gxTv_SdtPaciente_Mode ;
   private String gxTv_SdtPaciente_Pacientetipodocumento_Z ;
   private String gxTv_SdtPaciente_Pacientesexo_Z ;
   private String gxTv_SdtPaciente_Pacientetelefono_Z ;
   private String gxTv_SdtPaciente_Pacienteestado_Z ;
   private String gxTv_SdtPaciente_Ubigeocode_Z ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_SdtPaciente_Pacientefecharegistro ;
   private java.util.Date gxTv_SdtPaciente_Pacientefecharegistro_Z ;
   private java.util.Date datetime_STZ ;
   private java.util.Date gxTv_SdtPaciente_Pacientefechanacimiento ;
   private java.util.Date gxTv_SdtPaciente_Pacientefechanacimiento_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtPaciente_Pacienteespecifique ;
   private String gxTv_SdtPaciente_Pacienteanexos ;
   private String gxTv_SdtPaciente_Pacienteapellidopaterno ;
   private String gxTv_SdtPaciente_Pacienteapellidomaterno ;
   private String gxTv_SdtPaciente_Pacientenombres ;
   private String gxTv_SdtPaciente_Pacientenombrecompleto ;
   private String gxTv_SdtPaciente_Pacientenrodocumento ;
   private String gxTv_SdtPaciente_Pacientedireccion ;
   private String gxTv_SdtPaciente_Pacientecorreo ;
   private String gxTv_SdtPaciente_Paisdescripcion ;
   private String gxTv_SdtPaciente_Ubigeonombre ;
   private String gxTv_SdtPaciente_Pacientenombreanexo ;
   private String gxTv_SdtPaciente_Pacienteenterarse ;
   private String gxTv_SdtPaciente_Pacienteapellidopaterno_Z ;
   private String gxTv_SdtPaciente_Pacienteapellidomaterno_Z ;
   private String gxTv_SdtPaciente_Pacientenombres_Z ;
   private String gxTv_SdtPaciente_Pacientenombrecompleto_Z ;
   private String gxTv_SdtPaciente_Pacientenrodocumento_Z ;
   private String gxTv_SdtPaciente_Pacientedireccion_Z ;
   private String gxTv_SdtPaciente_Pacientecorreo_Z ;
   private String gxTv_SdtPaciente_Paisdescripcion_Z ;
   private String gxTv_SdtPaciente_Ubigeonombre_Z ;
   private String gxTv_SdtPaciente_Pacientenombreanexo_Z ;
   private String gxTv_SdtPaciente_Pacienteenterarse_Z ;
}

