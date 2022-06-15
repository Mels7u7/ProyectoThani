package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtProfesional extends GxSilentTrnSdt implements Cloneable, java.io.Serializable
{
   public SdtProfesional( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtProfesional.class));
   }

   public SdtProfesional( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle, context, "SdtProfesional");
      initialize( remoteHandle) ;
   }

   public SdtProfesional( int remoteHandle ,
                          StructSdtProfesional struct )
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

   public void Load( int AV31ProfesionalId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV31ProfesionalId)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"ProfesionalId", int.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Profesional");
      metadata.set("BT", "Profesional");
      metadata.set("PK", "[ \"ProfesionalId\" ]");
      metadata.set("PKAssigned", "[ \"ProfesionalId\" ]");
      metadata.set("Levels", "[ \"Educacion\",\"Especialidad\",\"ExperienciaLaboral\",\"Premios\",\"Servicios\" ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalId") )
            {
               gxTv_SdtProfesional_Profesionalid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalTipoDocumento") )
            {
               gxTv_SdtProfesional_Profesionaltipodocumento = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalNroDocumento") )
            {
               gxTv_SdtProfesional_Profesionalnrodocumento = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalApellidoPaterno") )
            {
               gxTv_SdtProfesional_Profesionalapellidopaterno = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalApellidoMaterno") )
            {
               gxTv_SdtProfesional_Profesionalapellidomaterno = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalNombres") )
            {
               gxTv_SdtProfesional_Profesionalnombres = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalNombreCompleto2") )
            {
               gxTv_SdtProfesional_Profesionalnombrecompleto2 = oReader.getValue() ;
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
                  gxTv_SdtProfesional_Profesionalfechanacimiento = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtProfesional_Profesionalfechanacimiento = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
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
               gxTv_SdtProfesional_Profesionalsexo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalDescripcion") )
            {
               gxTv_SdtProfesional_Profesionaldescripcion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalCorreo") )
            {
               gxTv_SdtProfesional_Profesionalcorreo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalCOP") )
            {
               gxTv_SdtProfesional_Profesionalcop = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalColorDisponible") )
            {
               gxTv_SdtProfesional_Profesionalcolordisponible = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalColorCita") )
            {
               gxTv_SdtProfesional_Profesionalcolorcita = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalTiempoCita") )
            {
               gxTv_SdtProfesional_Profesionaltiempocita = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalDireccion") )
            {
               gxTv_SdtProfesional_Profesionaldireccion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaisId") )
            {
               gxTv_SdtProfesional_Paisid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaisDescripcion") )
            {
               gxTv_SdtProfesional_Paisdescripcion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "UbigeoCode") )
            {
               gxTv_SdtProfesional_Ubigeocode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "UbigeoNombre") )
            {
               gxTv_SdtProfesional_Ubigeonombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalFoto") )
            {
               gxTv_SdtProfesional_Profesionalfoto = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalFoto_GXI") )
            {
               gxTv_SdtProfesional_Profesionalfoto_gxi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalTwitter") )
            {
               gxTv_SdtProfesional_Profesionaltwitter = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalFacebook") )
            {
               gxTv_SdtProfesional_Profesionalfacebook = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalInstagram") )
            {
               gxTv_SdtProfesional_Profesionalinstagram = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalLinkedin") )
            {
               gxTv_SdtProfesional_Profesionallinkedin = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalTelefono") )
            {
               gxTv_SdtProfesional_Profesionaltelefono = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserId") )
            {
               gxTv_SdtProfesional_Secuserid = (short)(getnumericvalue(oReader.getValue())) ;
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
                  gxTv_SdtProfesional_Profesionalfecharegistro = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtProfesional_Profesionalfecharegistro = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalTerminosCondiciones") )
            {
               gxTv_SdtProfesional_Profesionalterminoscondiciones = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalEstadoCuenta") )
            {
               gxTv_SdtProfesional_Profesionalestadocuenta = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalEstado") )
            {
               gxTv_SdtProfesional_Profesionalestado = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Especialidad") )
            {
               if ( gxTv_SdtProfesional_Especialidad == null )
               {
                  gxTv_SdtProfesional_Especialidad = new GXBCLevelCollection<com.projectthani.SdtProfesional_Especialidad>(com.projectthani.SdtProfesional_Especialidad.class, "Profesional.Especialidad", "ProjectThani", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtProfesional_Especialidad.readxml(oReader, "Especialidad") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Especialidad") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Educacion") )
            {
               if ( gxTv_SdtProfesional_Educacion == null )
               {
                  gxTv_SdtProfesional_Educacion = new GXBCLevelCollection<com.projectthani.SdtProfesional_Educacion>(com.projectthani.SdtProfesional_Educacion.class, "Profesional.Educacion", "ProjectThani", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtProfesional_Educacion.readxml(oReader, "Educacion") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Educacion") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ExperienciaLaboral") )
            {
               if ( gxTv_SdtProfesional_Experiencialaboral == null )
               {
                  gxTv_SdtProfesional_Experiencialaboral = new GXBCLevelCollection<com.projectthani.SdtProfesional_ExperienciaLaboral>(com.projectthani.SdtProfesional_ExperienciaLaboral.class, "Profesional.ExperienciaLaboral", "ProjectThani", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtProfesional_Experiencialaboral.readxml(oReader, "ExperienciaLaboral") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "ExperienciaLaboral") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Premios") )
            {
               if ( gxTv_SdtProfesional_Premios == null )
               {
                  gxTv_SdtProfesional_Premios = new GXBCLevelCollection<com.projectthani.SdtProfesional_Premios>(com.projectthani.SdtProfesional_Premios.class, "Profesional.Premios", "ProjectThani", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtProfesional_Premios.readxml(oReader, "Premios") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Premios") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Servicios") )
            {
               if ( gxTv_SdtProfesional_Servicios == null )
               {
                  gxTv_SdtProfesional_Servicios = new GXBCLevelCollection<com.projectthani.SdtProfesional_Servicios>(com.projectthani.SdtProfesional_Servicios.class, "Profesional.Servicios", "ProjectThani", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtProfesional_Servicios.readxml(oReader, "Servicios") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Servicios") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtProfesional_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtProfesional_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalId_Z") )
            {
               gxTv_SdtProfesional_Profesionalid_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalTipoDocumento_Z") )
            {
               gxTv_SdtProfesional_Profesionaltipodocumento_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalNroDocumento_Z") )
            {
               gxTv_SdtProfesional_Profesionalnrodocumento_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalApellidoPaterno_Z") )
            {
               gxTv_SdtProfesional_Profesionalapellidopaterno_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalApellidoMaterno_Z") )
            {
               gxTv_SdtProfesional_Profesionalapellidomaterno_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalNombres_Z") )
            {
               gxTv_SdtProfesional_Profesionalnombres_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalNombreCompleto2_Z") )
            {
               gxTv_SdtProfesional_Profesionalnombrecompleto2_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalFechaNacimiento_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtProfesional_Profesionalfechanacimiento_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtProfesional_Profesionalfechanacimiento_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalSexo_Z") )
            {
               gxTv_SdtProfesional_Profesionalsexo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalDescripcion_Z") )
            {
               gxTv_SdtProfesional_Profesionaldescripcion_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalCorreo_Z") )
            {
               gxTv_SdtProfesional_Profesionalcorreo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalCOP_Z") )
            {
               gxTv_SdtProfesional_Profesionalcop_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalColorDisponible_Z") )
            {
               gxTv_SdtProfesional_Profesionalcolordisponible_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalColorCita_Z") )
            {
               gxTv_SdtProfesional_Profesionalcolorcita_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalTiempoCita_Z") )
            {
               gxTv_SdtProfesional_Profesionaltiempocita_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalDireccion_Z") )
            {
               gxTv_SdtProfesional_Profesionaldireccion_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaisId_Z") )
            {
               gxTv_SdtProfesional_Paisid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaisDescripcion_Z") )
            {
               gxTv_SdtProfesional_Paisdescripcion_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "UbigeoCode_Z") )
            {
               gxTv_SdtProfesional_Ubigeocode_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "UbigeoNombre_Z") )
            {
               gxTv_SdtProfesional_Ubigeonombre_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalTwitter_Z") )
            {
               gxTv_SdtProfesional_Profesionaltwitter_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalFacebook_Z") )
            {
               gxTv_SdtProfesional_Profesionalfacebook_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalInstagram_Z") )
            {
               gxTv_SdtProfesional_Profesionalinstagram_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalLinkedin_Z") )
            {
               gxTv_SdtProfesional_Profesionallinkedin_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalTelefono_Z") )
            {
               gxTv_SdtProfesional_Profesionaltelefono_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserId_Z") )
            {
               gxTv_SdtProfesional_Secuserid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalFechaRegistro_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtProfesional_Profesionalfecharegistro_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtProfesional_Profesionalfecharegistro_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalTerminosCondiciones_Z") )
            {
               gxTv_SdtProfesional_Profesionalterminoscondiciones_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalEstadoCuenta_Z") )
            {
               gxTv_SdtProfesional_Profesionalestadocuenta_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalEstado_Z") )
            {
               gxTv_SdtProfesional_Profesionalestado_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalFoto_GXI_Z") )
            {
               gxTv_SdtProfesional_Profesionalfoto_gxi_Z = oReader.getValue() ;
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
         sName = "Profesional" ;
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
      oWriter.writeElement("ProfesionalId", GXutil.trim( GXutil.str( gxTv_SdtProfesional_Profesionalid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalTipoDocumento", GXutil.rtrim( gxTv_SdtProfesional_Profesionaltipodocumento));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalNroDocumento", GXutil.rtrim( gxTv_SdtProfesional_Profesionalnrodocumento));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalApellidoPaterno", GXutil.rtrim( gxTv_SdtProfesional_Profesionalapellidopaterno));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalApellidoMaterno", GXutil.rtrim( gxTv_SdtProfesional_Profesionalapellidomaterno));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalNombres", GXutil.rtrim( gxTv_SdtProfesional_Profesionalnombres));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalNombreCompleto2", GXutil.rtrim( gxTv_SdtProfesional_Profesionalnombrecompleto2));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtProfesional_Profesionalfechanacimiento), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtProfesional_Profesionalfechanacimiento), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtProfesional_Profesionalfechanacimiento), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("ProfesionalFechaNacimiento", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalSexo", GXutil.rtrim( gxTv_SdtProfesional_Profesionalsexo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalDescripcion", GXutil.rtrim( gxTv_SdtProfesional_Profesionaldescripcion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalCorreo", GXutil.rtrim( gxTv_SdtProfesional_Profesionalcorreo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalCOP", GXutil.rtrim( gxTv_SdtProfesional_Profesionalcop));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalColorDisponible", GXutil.rtrim( gxTv_SdtProfesional_Profesionalcolordisponible));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalColorCita", GXutil.rtrim( gxTv_SdtProfesional_Profesionalcolorcita));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalTiempoCita", GXutil.trim( GXutil.str( gxTv_SdtProfesional_Profesionaltiempocita, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalDireccion", GXutil.rtrim( gxTv_SdtProfesional_Profesionaldireccion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PaisId", GXutil.trim( GXutil.str( gxTv_SdtProfesional_Paisid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PaisDescripcion", GXutil.rtrim( gxTv_SdtProfesional_Paisdescripcion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("UbigeoCode", GXutil.rtrim( gxTv_SdtProfesional_Ubigeocode));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("UbigeoNombre", GXutil.rtrim( gxTv_SdtProfesional_Ubigeonombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalFoto", GXutil.rtrim( gxTv_SdtProfesional_Profesionalfoto));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalTwitter", GXutil.rtrim( gxTv_SdtProfesional_Profesionaltwitter));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalFacebook", GXutil.rtrim( gxTv_SdtProfesional_Profesionalfacebook));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalInstagram", GXutil.rtrim( gxTv_SdtProfesional_Profesionalinstagram));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalLinkedin", GXutil.rtrim( gxTv_SdtProfesional_Profesionallinkedin));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalTelefono", GXutil.rtrim( gxTv_SdtProfesional_Profesionaltelefono));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SecUserId", GXutil.trim( GXutil.str( gxTv_SdtProfesional_Secuserid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtProfesional_Profesionalfecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtProfesional_Profesionalfecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtProfesional_Profesionalfecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("ProfesionalFechaRegistro", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalTerminosCondiciones", GXutil.rtrim( GXutil.booltostr( gxTv_SdtProfesional_Profesionalterminoscondiciones)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalEstadoCuenta", GXutil.rtrim( gxTv_SdtProfesional_Profesionalestadocuenta));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalEstado", GXutil.rtrim( gxTv_SdtProfesional_Profesionalestado));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( gxTv_SdtProfesional_Especialidad != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "ProjectThani" ;
         }
         else
         {
            sNameSpace1 = "ProjectThani" ;
         }
         gxTv_SdtProfesional_Especialidad.writexml(oWriter, "Especialidad", sNameSpace1, sIncludeState);
      }
      if ( gxTv_SdtProfesional_Educacion != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "ProjectThani" ;
         }
         else
         {
            sNameSpace1 = "ProjectThani" ;
         }
         gxTv_SdtProfesional_Educacion.writexml(oWriter, "Educacion", sNameSpace1, sIncludeState);
      }
      if ( gxTv_SdtProfesional_Experiencialaboral != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "ProjectThani" ;
         }
         else
         {
            sNameSpace1 = "ProjectThani" ;
         }
         gxTv_SdtProfesional_Experiencialaboral.writexml(oWriter, "ExperienciaLaboral", sNameSpace1, sIncludeState);
      }
      if ( gxTv_SdtProfesional_Premios != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "ProjectThani" ;
         }
         else
         {
            sNameSpace1 = "ProjectThani" ;
         }
         gxTv_SdtProfesional_Premios.writexml(oWriter, "Premios", sNameSpace1, sIncludeState);
      }
      if ( gxTv_SdtProfesional_Servicios != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "ProjectThani" ;
         }
         else
         {
            sNameSpace1 = "ProjectThani" ;
         }
         gxTv_SdtProfesional_Servicios.writexml(oWriter, "Servicios", sNameSpace1, sIncludeState);
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("ProfesionalFoto_GXI", GXutil.rtrim( gxTv_SdtProfesional_Profesionalfoto_gxi));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Mode", GXutil.rtrim( gxTv_SdtProfesional_Mode));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtProfesional_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ProfesionalId_Z", GXutil.trim( GXutil.str( gxTv_SdtProfesional_Profesionalid_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ProfesionalTipoDocumento_Z", GXutil.rtrim( gxTv_SdtProfesional_Profesionaltipodocumento_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ProfesionalNroDocumento_Z", GXutil.rtrim( gxTv_SdtProfesional_Profesionalnrodocumento_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ProfesionalApellidoPaterno_Z", GXutil.rtrim( gxTv_SdtProfesional_Profesionalapellidopaterno_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ProfesionalApellidoMaterno_Z", GXutil.rtrim( gxTv_SdtProfesional_Profesionalapellidomaterno_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ProfesionalNombres_Z", GXutil.rtrim( gxTv_SdtProfesional_Profesionalnombres_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ProfesionalNombreCompleto2_Z", GXutil.rtrim( gxTv_SdtProfesional_Profesionalnombrecompleto2_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtProfesional_Profesionalfechanacimiento_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtProfesional_Profesionalfechanacimiento_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtProfesional_Profesionalfechanacimiento_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("ProfesionalFechaNacimiento_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ProfesionalSexo_Z", GXutil.rtrim( gxTv_SdtProfesional_Profesionalsexo_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ProfesionalDescripcion_Z", GXutil.rtrim( gxTv_SdtProfesional_Profesionaldescripcion_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ProfesionalCorreo_Z", GXutil.rtrim( gxTv_SdtProfesional_Profesionalcorreo_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ProfesionalCOP_Z", GXutil.rtrim( gxTv_SdtProfesional_Profesionalcop_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ProfesionalColorDisponible_Z", GXutil.rtrim( gxTv_SdtProfesional_Profesionalcolordisponible_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ProfesionalColorCita_Z", GXutil.rtrim( gxTv_SdtProfesional_Profesionalcolorcita_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ProfesionalTiempoCita_Z", GXutil.trim( GXutil.str( gxTv_SdtProfesional_Profesionaltiempocita_Z, 2, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ProfesionalDireccion_Z", GXutil.rtrim( gxTv_SdtProfesional_Profesionaldireccion_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PaisId_Z", GXutil.trim( GXutil.str( gxTv_SdtProfesional_Paisid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PaisDescripcion_Z", GXutil.rtrim( gxTv_SdtProfesional_Paisdescripcion_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("UbigeoCode_Z", GXutil.rtrim( gxTv_SdtProfesional_Ubigeocode_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("UbigeoNombre_Z", GXutil.rtrim( gxTv_SdtProfesional_Ubigeonombre_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ProfesionalTwitter_Z", GXutil.rtrim( gxTv_SdtProfesional_Profesionaltwitter_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ProfesionalFacebook_Z", GXutil.rtrim( gxTv_SdtProfesional_Profesionalfacebook_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ProfesionalInstagram_Z", GXutil.rtrim( gxTv_SdtProfesional_Profesionalinstagram_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ProfesionalLinkedin_Z", GXutil.rtrim( gxTv_SdtProfesional_Profesionallinkedin_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ProfesionalTelefono_Z", GXutil.rtrim( gxTv_SdtProfesional_Profesionaltelefono_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SecUserId_Z", GXutil.trim( GXutil.str( gxTv_SdtProfesional_Secuserid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtProfesional_Profesionalfecharegistro_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtProfesional_Profesionalfecharegistro_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtProfesional_Profesionalfecharegistro_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("ProfesionalFechaRegistro_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ProfesionalTerminosCondiciones_Z", GXutil.rtrim( GXutil.booltostr( gxTv_SdtProfesional_Profesionalterminoscondiciones_Z)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ProfesionalEstadoCuenta_Z", GXutil.rtrim( gxTv_SdtProfesional_Profesionalestadocuenta_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ProfesionalEstado_Z", GXutil.rtrim( gxTv_SdtProfesional_Profesionalestado_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ProfesionalFoto_GXI_Z", GXutil.rtrim( gxTv_SdtProfesional_Profesionalfoto_gxi_Z));
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
      AddObjectProperty("ProfesionalId", gxTv_SdtProfesional_Profesionalid, false, includeNonInitialized);
      AddObjectProperty("ProfesionalTipoDocumento", gxTv_SdtProfesional_Profesionaltipodocumento, false, includeNonInitialized);
      AddObjectProperty("ProfesionalNroDocumento", gxTv_SdtProfesional_Profesionalnrodocumento, false, includeNonInitialized);
      AddObjectProperty("ProfesionalApellidoPaterno", gxTv_SdtProfesional_Profesionalapellidopaterno, false, includeNonInitialized);
      AddObjectProperty("ProfesionalApellidoMaterno", gxTv_SdtProfesional_Profesionalapellidomaterno, false, includeNonInitialized);
      AddObjectProperty("ProfesionalNombres", gxTv_SdtProfesional_Profesionalnombres, false, includeNonInitialized);
      AddObjectProperty("ProfesionalNombreCompleto2", gxTv_SdtProfesional_Profesionalnombrecompleto2, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtProfesional_Profesionalfechanacimiento), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtProfesional_Profesionalfechanacimiento), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtProfesional_Profesionalfechanacimiento), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("ProfesionalFechaNacimiento", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("ProfesionalSexo", gxTv_SdtProfesional_Profesionalsexo, false, includeNonInitialized);
      AddObjectProperty("ProfesionalDescripcion", gxTv_SdtProfesional_Profesionaldescripcion, false, includeNonInitialized);
      AddObjectProperty("ProfesionalCorreo", gxTv_SdtProfesional_Profesionalcorreo, false, includeNonInitialized);
      AddObjectProperty("ProfesionalCOP", gxTv_SdtProfesional_Profesionalcop, false, includeNonInitialized);
      AddObjectProperty("ProfesionalColorDisponible", gxTv_SdtProfesional_Profesionalcolordisponible, false, includeNonInitialized);
      AddObjectProperty("ProfesionalColorCita", gxTv_SdtProfesional_Profesionalcolorcita, false, includeNonInitialized);
      AddObjectProperty("ProfesionalTiempoCita", gxTv_SdtProfesional_Profesionaltiempocita, false, includeNonInitialized);
      AddObjectProperty("ProfesionalDireccion", gxTv_SdtProfesional_Profesionaldireccion, false, includeNonInitialized);
      AddObjectProperty("PaisId", gxTv_SdtProfesional_Paisid, false, includeNonInitialized);
      AddObjectProperty("PaisDescripcion", gxTv_SdtProfesional_Paisdescripcion, false, includeNonInitialized);
      AddObjectProperty("UbigeoCode", gxTv_SdtProfesional_Ubigeocode, false, includeNonInitialized);
      AddObjectProperty("UbigeoNombre", gxTv_SdtProfesional_Ubigeonombre, false, includeNonInitialized);
      AddObjectProperty("ProfesionalFoto", gxTv_SdtProfesional_Profesionalfoto, false, includeNonInitialized);
      AddObjectProperty("ProfesionalTwitter", gxTv_SdtProfesional_Profesionaltwitter, false, includeNonInitialized);
      AddObjectProperty("ProfesionalFacebook", gxTv_SdtProfesional_Profesionalfacebook, false, includeNonInitialized);
      AddObjectProperty("ProfesionalInstagram", gxTv_SdtProfesional_Profesionalinstagram, false, includeNonInitialized);
      AddObjectProperty("ProfesionalLinkedin", gxTv_SdtProfesional_Profesionallinkedin, false, includeNonInitialized);
      AddObjectProperty("ProfesionalTelefono", gxTv_SdtProfesional_Profesionaltelefono, false, includeNonInitialized);
      AddObjectProperty("SecUserId", gxTv_SdtProfesional_Secuserid, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtProfesional_Profesionalfecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtProfesional_Profesionalfecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtProfesional_Profesionalfecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("ProfesionalFechaRegistro", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("ProfesionalTerminosCondiciones", gxTv_SdtProfesional_Profesionalterminoscondiciones, false, includeNonInitialized);
      AddObjectProperty("ProfesionalEstadoCuenta", gxTv_SdtProfesional_Profesionalestadocuenta, false, includeNonInitialized);
      AddObjectProperty("ProfesionalEstado", gxTv_SdtProfesional_Profesionalestado, false, includeNonInitialized);
      if ( gxTv_SdtProfesional_Especialidad != null )
      {
         AddObjectProperty("Especialidad", gxTv_SdtProfesional_Especialidad, includeState, includeNonInitialized);
      }
      if ( gxTv_SdtProfesional_Educacion != null )
      {
         AddObjectProperty("Educacion", gxTv_SdtProfesional_Educacion, includeState, includeNonInitialized);
      }
      if ( gxTv_SdtProfesional_Experiencialaboral != null )
      {
         AddObjectProperty("ExperienciaLaboral", gxTv_SdtProfesional_Experiencialaboral, includeState, includeNonInitialized);
      }
      if ( gxTv_SdtProfesional_Premios != null )
      {
         AddObjectProperty("Premios", gxTv_SdtProfesional_Premios, includeState, includeNonInitialized);
      }
      if ( gxTv_SdtProfesional_Servicios != null )
      {
         AddObjectProperty("Servicios", gxTv_SdtProfesional_Servicios, includeState, includeNonInitialized);
      }
      if ( includeState )
      {
         AddObjectProperty("ProfesionalFoto_GXI", gxTv_SdtProfesional_Profesionalfoto_gxi, false, includeNonInitialized);
         AddObjectProperty("Mode", gxTv_SdtProfesional_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtProfesional_Initialized, false, includeNonInitialized);
         AddObjectProperty("ProfesionalId_Z", gxTv_SdtProfesional_Profesionalid_Z, false, includeNonInitialized);
         AddObjectProperty("ProfesionalTipoDocumento_Z", gxTv_SdtProfesional_Profesionaltipodocumento_Z, false, includeNonInitialized);
         AddObjectProperty("ProfesionalNroDocumento_Z", gxTv_SdtProfesional_Profesionalnrodocumento_Z, false, includeNonInitialized);
         AddObjectProperty("ProfesionalApellidoPaterno_Z", gxTv_SdtProfesional_Profesionalapellidopaterno_Z, false, includeNonInitialized);
         AddObjectProperty("ProfesionalApellidoMaterno_Z", gxTv_SdtProfesional_Profesionalapellidomaterno_Z, false, includeNonInitialized);
         AddObjectProperty("ProfesionalNombres_Z", gxTv_SdtProfesional_Profesionalnombres_Z, false, includeNonInitialized);
         AddObjectProperty("ProfesionalNombreCompleto2_Z", gxTv_SdtProfesional_Profesionalnombrecompleto2_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtProfesional_Profesionalfechanacimiento_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtProfesional_Profesionalfechanacimiento_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtProfesional_Profesionalfechanacimiento_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("ProfesionalFechaNacimiento_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("ProfesionalSexo_Z", gxTv_SdtProfesional_Profesionalsexo_Z, false, includeNonInitialized);
         AddObjectProperty("ProfesionalDescripcion_Z", gxTv_SdtProfesional_Profesionaldescripcion_Z, false, includeNonInitialized);
         AddObjectProperty("ProfesionalCorreo_Z", gxTv_SdtProfesional_Profesionalcorreo_Z, false, includeNonInitialized);
         AddObjectProperty("ProfesionalCOP_Z", gxTv_SdtProfesional_Profesionalcop_Z, false, includeNonInitialized);
         AddObjectProperty("ProfesionalColorDisponible_Z", gxTv_SdtProfesional_Profesionalcolordisponible_Z, false, includeNonInitialized);
         AddObjectProperty("ProfesionalColorCita_Z", gxTv_SdtProfesional_Profesionalcolorcita_Z, false, includeNonInitialized);
         AddObjectProperty("ProfesionalTiempoCita_Z", gxTv_SdtProfesional_Profesionaltiempocita_Z, false, includeNonInitialized);
         AddObjectProperty("ProfesionalDireccion_Z", gxTv_SdtProfesional_Profesionaldireccion_Z, false, includeNonInitialized);
         AddObjectProperty("PaisId_Z", gxTv_SdtProfesional_Paisid_Z, false, includeNonInitialized);
         AddObjectProperty("PaisDescripcion_Z", gxTv_SdtProfesional_Paisdescripcion_Z, false, includeNonInitialized);
         AddObjectProperty("UbigeoCode_Z", gxTv_SdtProfesional_Ubigeocode_Z, false, includeNonInitialized);
         AddObjectProperty("UbigeoNombre_Z", gxTv_SdtProfesional_Ubigeonombre_Z, false, includeNonInitialized);
         AddObjectProperty("ProfesionalTwitter_Z", gxTv_SdtProfesional_Profesionaltwitter_Z, false, includeNonInitialized);
         AddObjectProperty("ProfesionalFacebook_Z", gxTv_SdtProfesional_Profesionalfacebook_Z, false, includeNonInitialized);
         AddObjectProperty("ProfesionalInstagram_Z", gxTv_SdtProfesional_Profesionalinstagram_Z, false, includeNonInitialized);
         AddObjectProperty("ProfesionalLinkedin_Z", gxTv_SdtProfesional_Profesionallinkedin_Z, false, includeNonInitialized);
         AddObjectProperty("ProfesionalTelefono_Z", gxTv_SdtProfesional_Profesionaltelefono_Z, false, includeNonInitialized);
         AddObjectProperty("SecUserId_Z", gxTv_SdtProfesional_Secuserid_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtProfesional_Profesionalfecharegistro_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtProfesional_Profesionalfecharegistro_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtProfesional_Profesionalfecharegistro_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("ProfesionalFechaRegistro_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("ProfesionalTerminosCondiciones_Z", gxTv_SdtProfesional_Profesionalterminoscondiciones_Z, false, includeNonInitialized);
         AddObjectProperty("ProfesionalEstadoCuenta_Z", gxTv_SdtProfesional_Profesionalestadocuenta_Z, false, includeNonInitialized);
         AddObjectProperty("ProfesionalEstado_Z", gxTv_SdtProfesional_Profesionalestado_Z, false, includeNonInitialized);
         AddObjectProperty("ProfesionalFoto_GXI_Z", gxTv_SdtProfesional_Profesionalfoto_gxi_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.projectthani.SdtProfesional sdt )
   {
      if ( sdt.IsDirty("ProfesionalId") )
      {
         gxTv_SdtProfesional_N = (byte)(0) ;
         gxTv_SdtProfesional_Profesionalid = sdt.getgxTv_SdtProfesional_Profesionalid() ;
      }
      if ( sdt.IsDirty("ProfesionalTipoDocumento") )
      {
         gxTv_SdtProfesional_N = (byte)(0) ;
         gxTv_SdtProfesional_Profesionaltipodocumento = sdt.getgxTv_SdtProfesional_Profesionaltipodocumento() ;
      }
      if ( sdt.IsDirty("ProfesionalNroDocumento") )
      {
         gxTv_SdtProfesional_N = (byte)(0) ;
         gxTv_SdtProfesional_Profesionalnrodocumento = sdt.getgxTv_SdtProfesional_Profesionalnrodocumento() ;
      }
      if ( sdt.IsDirty("ProfesionalApellidoPaterno") )
      {
         gxTv_SdtProfesional_N = (byte)(0) ;
         gxTv_SdtProfesional_Profesionalapellidopaterno = sdt.getgxTv_SdtProfesional_Profesionalapellidopaterno() ;
      }
      if ( sdt.IsDirty("ProfesionalApellidoMaterno") )
      {
         gxTv_SdtProfesional_N = (byte)(0) ;
         gxTv_SdtProfesional_Profesionalapellidomaterno = sdt.getgxTv_SdtProfesional_Profesionalapellidomaterno() ;
      }
      if ( sdt.IsDirty("ProfesionalNombres") )
      {
         gxTv_SdtProfesional_N = (byte)(0) ;
         gxTv_SdtProfesional_Profesionalnombres = sdt.getgxTv_SdtProfesional_Profesionalnombres() ;
      }
      if ( sdt.IsDirty("ProfesionalNombreCompleto2") )
      {
         gxTv_SdtProfesional_N = (byte)(0) ;
         gxTv_SdtProfesional_Profesionalnombrecompleto2 = sdt.getgxTv_SdtProfesional_Profesionalnombrecompleto2() ;
      }
      if ( sdt.IsDirty("ProfesionalFechaNacimiento") )
      {
         gxTv_SdtProfesional_N = (byte)(0) ;
         gxTv_SdtProfesional_Profesionalfechanacimiento = sdt.getgxTv_SdtProfesional_Profesionalfechanacimiento() ;
      }
      if ( sdt.IsDirty("ProfesionalSexo") )
      {
         gxTv_SdtProfesional_N = (byte)(0) ;
         gxTv_SdtProfesional_Profesionalsexo = sdt.getgxTv_SdtProfesional_Profesionalsexo() ;
      }
      if ( sdt.IsDirty("ProfesionalDescripcion") )
      {
         gxTv_SdtProfesional_N = (byte)(0) ;
         gxTv_SdtProfesional_Profesionaldescripcion = sdt.getgxTv_SdtProfesional_Profesionaldescripcion() ;
      }
      if ( sdt.IsDirty("ProfesionalCorreo") )
      {
         gxTv_SdtProfesional_N = (byte)(0) ;
         gxTv_SdtProfesional_Profesionalcorreo = sdt.getgxTv_SdtProfesional_Profesionalcorreo() ;
      }
      if ( sdt.IsDirty("ProfesionalCOP") )
      {
         gxTv_SdtProfesional_N = (byte)(0) ;
         gxTv_SdtProfesional_Profesionalcop = sdt.getgxTv_SdtProfesional_Profesionalcop() ;
      }
      if ( sdt.IsDirty("ProfesionalColorDisponible") )
      {
         gxTv_SdtProfesional_N = (byte)(0) ;
         gxTv_SdtProfesional_Profesionalcolordisponible = sdt.getgxTv_SdtProfesional_Profesionalcolordisponible() ;
      }
      if ( sdt.IsDirty("ProfesionalColorCita") )
      {
         gxTv_SdtProfesional_N = (byte)(0) ;
         gxTv_SdtProfesional_Profesionalcolorcita = sdt.getgxTv_SdtProfesional_Profesionalcolorcita() ;
      }
      if ( sdt.IsDirty("ProfesionalTiempoCita") )
      {
         gxTv_SdtProfesional_N = (byte)(0) ;
         gxTv_SdtProfesional_Profesionaltiempocita = sdt.getgxTv_SdtProfesional_Profesionaltiempocita() ;
      }
      if ( sdt.IsDirty("ProfesionalDireccion") )
      {
         gxTv_SdtProfesional_N = (byte)(0) ;
         gxTv_SdtProfesional_Profesionaldireccion = sdt.getgxTv_SdtProfesional_Profesionaldireccion() ;
      }
      if ( sdt.IsDirty("PaisId") )
      {
         gxTv_SdtProfesional_N = (byte)(0) ;
         gxTv_SdtProfesional_Paisid = sdt.getgxTv_SdtProfesional_Paisid() ;
      }
      if ( sdt.IsDirty("PaisDescripcion") )
      {
         gxTv_SdtProfesional_N = (byte)(0) ;
         gxTv_SdtProfesional_Paisdescripcion = sdt.getgxTv_SdtProfesional_Paisdescripcion() ;
      }
      if ( sdt.IsDirty("UbigeoCode") )
      {
         gxTv_SdtProfesional_N = (byte)(0) ;
         gxTv_SdtProfesional_Ubigeocode = sdt.getgxTv_SdtProfesional_Ubigeocode() ;
      }
      if ( sdt.IsDirty("UbigeoNombre") )
      {
         gxTv_SdtProfesional_N = (byte)(0) ;
         gxTv_SdtProfesional_Ubigeonombre = sdt.getgxTv_SdtProfesional_Ubigeonombre() ;
      }
      if ( sdt.IsDirty("ProfesionalFoto") )
      {
         gxTv_SdtProfesional_N = (byte)(0) ;
         gxTv_SdtProfesional_Profesionalfoto = sdt.getgxTv_SdtProfesional_Profesionalfoto() ;
      }
      if ( sdt.IsDirty("ProfesionalFoto") )
      {
         gxTv_SdtProfesional_N = (byte)(0) ;
         gxTv_SdtProfesional_Profesionalfoto_gxi = sdt.getgxTv_SdtProfesional_Profesionalfoto_gxi() ;
      }
      if ( sdt.IsDirty("ProfesionalTwitter") )
      {
         gxTv_SdtProfesional_N = (byte)(0) ;
         gxTv_SdtProfesional_Profesionaltwitter = sdt.getgxTv_SdtProfesional_Profesionaltwitter() ;
      }
      if ( sdt.IsDirty("ProfesionalFacebook") )
      {
         gxTv_SdtProfesional_N = (byte)(0) ;
         gxTv_SdtProfesional_Profesionalfacebook = sdt.getgxTv_SdtProfesional_Profesionalfacebook() ;
      }
      if ( sdt.IsDirty("ProfesionalInstagram") )
      {
         gxTv_SdtProfesional_N = (byte)(0) ;
         gxTv_SdtProfesional_Profesionalinstagram = sdt.getgxTv_SdtProfesional_Profesionalinstagram() ;
      }
      if ( sdt.IsDirty("ProfesionalLinkedin") )
      {
         gxTv_SdtProfesional_N = (byte)(0) ;
         gxTv_SdtProfesional_Profesionallinkedin = sdt.getgxTv_SdtProfesional_Profesionallinkedin() ;
      }
      if ( sdt.IsDirty("ProfesionalTelefono") )
      {
         gxTv_SdtProfesional_N = (byte)(0) ;
         gxTv_SdtProfesional_Profesionaltelefono = sdt.getgxTv_SdtProfesional_Profesionaltelefono() ;
      }
      if ( sdt.IsDirty("SecUserId") )
      {
         gxTv_SdtProfesional_N = (byte)(0) ;
         gxTv_SdtProfesional_Secuserid = sdt.getgxTv_SdtProfesional_Secuserid() ;
      }
      if ( sdt.IsDirty("ProfesionalFechaRegistro") )
      {
         gxTv_SdtProfesional_N = (byte)(0) ;
         gxTv_SdtProfesional_Profesionalfecharegistro = sdt.getgxTv_SdtProfesional_Profesionalfecharegistro() ;
      }
      if ( sdt.IsDirty("ProfesionalTerminosCondiciones") )
      {
         gxTv_SdtProfesional_N = (byte)(0) ;
         gxTv_SdtProfesional_Profesionalterminoscondiciones = sdt.getgxTv_SdtProfesional_Profesionalterminoscondiciones() ;
      }
      if ( sdt.IsDirty("ProfesionalEstadoCuenta") )
      {
         gxTv_SdtProfesional_N = (byte)(0) ;
         gxTv_SdtProfesional_Profesionalestadocuenta = sdt.getgxTv_SdtProfesional_Profesionalestadocuenta() ;
      }
      if ( sdt.IsDirty("ProfesionalEstado") )
      {
         gxTv_SdtProfesional_N = (byte)(0) ;
         gxTv_SdtProfesional_Profesionalestado = sdt.getgxTv_SdtProfesional_Profesionalestado() ;
      }
      if ( gxTv_SdtProfesional_Especialidad != null )
      {
         GXBCLevelCollection<com.projectthani.SdtProfesional_Especialidad> newCollectionEspecialidad = sdt.getgxTv_SdtProfesional_Especialidad();
         com.projectthani.SdtProfesional_Especialidad currItemEspecialidad;
         com.projectthani.SdtProfesional_Especialidad newItemEspecialidad;
         short idx = 1;
         while ( idx <= newCollectionEspecialidad.size() )
         {
            newItemEspecialidad = (com.projectthani.SdtProfesional_Especialidad)((com.projectthani.SdtProfesional_Especialidad)newCollectionEspecialidad.elementAt(-1+idx));
            currItemEspecialidad = (com.projectthani.SdtProfesional_Especialidad)gxTv_SdtProfesional_Especialidad.getByKey(newItemEspecialidad.getgxTv_SdtProfesional_Especialidad_Especialidadid());
            if ( GXutil.strcmp(currItemEspecialidad.getgxTv_SdtProfesional_Especialidad_Mode(), "UPD") == 0 )
            {
               currItemEspecialidad.updateDirties(newItemEspecialidad);
               if ( GXutil.strcmp(newItemEspecialidad.getgxTv_SdtProfesional_Especialidad_Mode(), "DLT") == 0 )
               {
                  currItemEspecialidad.setgxTv_SdtProfesional_Especialidad_Mode( "DLT" );
               }
               currItemEspecialidad.setgxTv_SdtProfesional_Especialidad_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtProfesional_Especialidad.add(newItemEspecialidad, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
      if ( gxTv_SdtProfesional_Educacion != null )
      {
         GXBCLevelCollection<com.projectthani.SdtProfesional_Educacion> newCollectionEducacion = sdt.getgxTv_SdtProfesional_Educacion();
         com.projectthani.SdtProfesional_Educacion currItemEducacion;
         com.projectthani.SdtProfesional_Educacion newItemEducacion;
         short idx = 1;
         while ( idx <= newCollectionEducacion.size() )
         {
            newItemEducacion = (com.projectthani.SdtProfesional_Educacion)((com.projectthani.SdtProfesional_Educacion)newCollectionEducacion.elementAt(-1+idx));
            currItemEducacion = (com.projectthani.SdtProfesional_Educacion)gxTv_SdtProfesional_Educacion.getByKey(newItemEducacion.getgxTv_SdtProfesional_Educacion_Educacionid());
            if ( GXutil.strcmp(currItemEducacion.getgxTv_SdtProfesional_Educacion_Mode(), "UPD") == 0 )
            {
               currItemEducacion.updateDirties(newItemEducacion);
               if ( GXutil.strcmp(newItemEducacion.getgxTv_SdtProfesional_Educacion_Mode(), "DLT") == 0 )
               {
                  currItemEducacion.setgxTv_SdtProfesional_Educacion_Mode( "DLT" );
               }
               currItemEducacion.setgxTv_SdtProfesional_Educacion_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtProfesional_Educacion.add(newItemEducacion, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
      if ( gxTv_SdtProfesional_Experiencialaboral != null )
      {
         GXBCLevelCollection<com.projectthani.SdtProfesional_ExperienciaLaboral> newCollectionExperiencialaboral = sdt.getgxTv_SdtProfesional_Experiencialaboral();
         com.projectthani.SdtProfesional_ExperienciaLaboral currItemExperiencialaboral;
         com.projectthani.SdtProfesional_ExperienciaLaboral newItemExperiencialaboral;
         short idx = 1;
         while ( idx <= newCollectionExperiencialaboral.size() )
         {
            newItemExperiencialaboral = (com.projectthani.SdtProfesional_ExperienciaLaboral)((com.projectthani.SdtProfesional_ExperienciaLaboral)newCollectionExperiencialaboral.elementAt(-1+idx));
            currItemExperiencialaboral = (com.projectthani.SdtProfesional_ExperienciaLaboral)gxTv_SdtProfesional_Experiencialaboral.getByKey(newItemExperiencialaboral.getgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid());
            if ( GXutil.strcmp(currItemExperiencialaboral.getgxTv_SdtProfesional_ExperienciaLaboral_Mode(), "UPD") == 0 )
            {
               currItemExperiencialaboral.updateDirties(newItemExperiencialaboral);
               if ( GXutil.strcmp(newItemExperiencialaboral.getgxTv_SdtProfesional_ExperienciaLaboral_Mode(), "DLT") == 0 )
               {
                  currItemExperiencialaboral.setgxTv_SdtProfesional_ExperienciaLaboral_Mode( "DLT" );
               }
               currItemExperiencialaboral.setgxTv_SdtProfesional_ExperienciaLaboral_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtProfesional_Experiencialaboral.add(newItemExperiencialaboral, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
      if ( gxTv_SdtProfesional_Premios != null )
      {
         GXBCLevelCollection<com.projectthani.SdtProfesional_Premios> newCollectionPremios = sdt.getgxTv_SdtProfesional_Premios();
         com.projectthani.SdtProfesional_Premios currItemPremios;
         com.projectthani.SdtProfesional_Premios newItemPremios;
         short idx = 1;
         while ( idx <= newCollectionPremios.size() )
         {
            newItemPremios = (com.projectthani.SdtProfesional_Premios)((com.projectthani.SdtProfesional_Premios)newCollectionPremios.elementAt(-1+idx));
            currItemPremios = (com.projectthani.SdtProfesional_Premios)gxTv_SdtProfesional_Premios.getByKey(newItemPremios.getgxTv_SdtProfesional_Premios_Premiosid());
            if ( GXutil.strcmp(currItemPremios.getgxTv_SdtProfesional_Premios_Mode(), "UPD") == 0 )
            {
               currItemPremios.updateDirties(newItemPremios);
               if ( GXutil.strcmp(newItemPremios.getgxTv_SdtProfesional_Premios_Mode(), "DLT") == 0 )
               {
                  currItemPremios.setgxTv_SdtProfesional_Premios_Mode( "DLT" );
               }
               currItemPremios.setgxTv_SdtProfesional_Premios_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtProfesional_Premios.add(newItemPremios, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
      if ( gxTv_SdtProfesional_Servicios != null )
      {
         GXBCLevelCollection<com.projectthani.SdtProfesional_Servicios> newCollectionServicios = sdt.getgxTv_SdtProfesional_Servicios();
         com.projectthani.SdtProfesional_Servicios currItemServicios;
         com.projectthani.SdtProfesional_Servicios newItemServicios;
         short idx = 1;
         while ( idx <= newCollectionServicios.size() )
         {
            newItemServicios = (com.projectthani.SdtProfesional_Servicios)((com.projectthani.SdtProfesional_Servicios)newCollectionServicios.elementAt(-1+idx));
            currItemServicios = (com.projectthani.SdtProfesional_Servicios)gxTv_SdtProfesional_Servicios.getByKey(newItemServicios.getgxTv_SdtProfesional_Servicios_Serviciosid());
            if ( GXutil.strcmp(currItemServicios.getgxTv_SdtProfesional_Servicios_Mode(), "UPD") == 0 )
            {
               currItemServicios.updateDirties(newItemServicios);
               if ( GXutil.strcmp(newItemServicios.getgxTv_SdtProfesional_Servicios_Mode(), "DLT") == 0 )
               {
                  currItemServicios.setgxTv_SdtProfesional_Servicios_Mode( "DLT" );
               }
               currItemServicios.setgxTv_SdtProfesional_Servicios_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtProfesional_Servicios.add(newItemServicios, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
   }

   public int getgxTv_SdtProfesional_Profesionalid( )
   {
      return gxTv_SdtProfesional_Profesionalid ;
   }

   public void setgxTv_SdtProfesional_Profesionalid( int value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      if ( gxTv_SdtProfesional_Profesionalid != value )
      {
         gxTv_SdtProfesional_Mode = "INS" ;
         this.setgxTv_SdtProfesional_Profesionalid_Z_SetNull( );
         this.setgxTv_SdtProfesional_Profesionaltipodocumento_Z_SetNull( );
         this.setgxTv_SdtProfesional_Profesionalnrodocumento_Z_SetNull( );
         this.setgxTv_SdtProfesional_Profesionalapellidopaterno_Z_SetNull( );
         this.setgxTv_SdtProfesional_Profesionalapellidomaterno_Z_SetNull( );
         this.setgxTv_SdtProfesional_Profesionalnombres_Z_SetNull( );
         this.setgxTv_SdtProfesional_Profesionalnombrecompleto2_Z_SetNull( );
         this.setgxTv_SdtProfesional_Profesionalfechanacimiento_Z_SetNull( );
         this.setgxTv_SdtProfesional_Profesionalsexo_Z_SetNull( );
         this.setgxTv_SdtProfesional_Profesionaldescripcion_Z_SetNull( );
         this.setgxTv_SdtProfesional_Profesionalcorreo_Z_SetNull( );
         this.setgxTv_SdtProfesional_Profesionalcop_Z_SetNull( );
         this.setgxTv_SdtProfesional_Profesionalcolordisponible_Z_SetNull( );
         this.setgxTv_SdtProfesional_Profesionalcolorcita_Z_SetNull( );
         this.setgxTv_SdtProfesional_Profesionaltiempocita_Z_SetNull( );
         this.setgxTv_SdtProfesional_Profesionaldireccion_Z_SetNull( );
         this.setgxTv_SdtProfesional_Paisid_Z_SetNull( );
         this.setgxTv_SdtProfesional_Paisdescripcion_Z_SetNull( );
         this.setgxTv_SdtProfesional_Ubigeocode_Z_SetNull( );
         this.setgxTv_SdtProfesional_Ubigeonombre_Z_SetNull( );
         this.setgxTv_SdtProfesional_Profesionaltwitter_Z_SetNull( );
         this.setgxTv_SdtProfesional_Profesionalfacebook_Z_SetNull( );
         this.setgxTv_SdtProfesional_Profesionalinstagram_Z_SetNull( );
         this.setgxTv_SdtProfesional_Profesionallinkedin_Z_SetNull( );
         this.setgxTv_SdtProfesional_Profesionaltelefono_Z_SetNull( );
         this.setgxTv_SdtProfesional_Secuserid_Z_SetNull( );
         this.setgxTv_SdtProfesional_Profesionalfecharegistro_Z_SetNull( );
         this.setgxTv_SdtProfesional_Profesionalterminoscondiciones_Z_SetNull( );
         this.setgxTv_SdtProfesional_Profesionalestadocuenta_Z_SetNull( );
         this.setgxTv_SdtProfesional_Profesionalestado_Z_SetNull( );
         this.setgxTv_SdtProfesional_Profesionalfoto_gxi_Z_SetNull( );
         if ( gxTv_SdtProfesional_Especialidad != null )
         {
            GXBCLevelCollection<com.projectthani.SdtProfesional_Especialidad> collectionEspecialidad = gxTv_SdtProfesional_Especialidad;
            com.projectthani.SdtProfesional_Especialidad currItemEspecialidad;
            short idx = 1;
            while ( idx <= collectionEspecialidad.size() )
            {
               currItemEspecialidad = (com.projectthani.SdtProfesional_Especialidad)((com.projectthani.SdtProfesional_Especialidad)collectionEspecialidad.elementAt(-1+idx));
               currItemEspecialidad.setgxTv_SdtProfesional_Especialidad_Mode( "INS" );
               currItemEspecialidad.setgxTv_SdtProfesional_Especialidad_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_SdtProfesional_Educacion != null )
         {
            GXBCLevelCollection<com.projectthani.SdtProfesional_Educacion> collectionEducacion = gxTv_SdtProfesional_Educacion;
            com.projectthani.SdtProfesional_Educacion currItemEducacion;
            short idx = 1;
            while ( idx <= collectionEducacion.size() )
            {
               currItemEducacion = (com.projectthani.SdtProfesional_Educacion)((com.projectthani.SdtProfesional_Educacion)collectionEducacion.elementAt(-1+idx));
               currItemEducacion.setgxTv_SdtProfesional_Educacion_Mode( "INS" );
               currItemEducacion.setgxTv_SdtProfesional_Educacion_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_SdtProfesional_Experiencialaboral != null )
         {
            GXBCLevelCollection<com.projectthani.SdtProfesional_ExperienciaLaboral> collectionExperiencialaboral = gxTv_SdtProfesional_Experiencialaboral;
            com.projectthani.SdtProfesional_ExperienciaLaboral currItemExperiencialaboral;
            short idx = 1;
            while ( idx <= collectionExperiencialaboral.size() )
            {
               currItemExperiencialaboral = (com.projectthani.SdtProfesional_ExperienciaLaboral)((com.projectthani.SdtProfesional_ExperienciaLaboral)collectionExperiencialaboral.elementAt(-1+idx));
               currItemExperiencialaboral.setgxTv_SdtProfesional_ExperienciaLaboral_Mode( "INS" );
               currItemExperiencialaboral.setgxTv_SdtProfesional_ExperienciaLaboral_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_SdtProfesional_Premios != null )
         {
            GXBCLevelCollection<com.projectthani.SdtProfesional_Premios> collectionPremios = gxTv_SdtProfesional_Premios;
            com.projectthani.SdtProfesional_Premios currItemPremios;
            short idx = 1;
            while ( idx <= collectionPremios.size() )
            {
               currItemPremios = (com.projectthani.SdtProfesional_Premios)((com.projectthani.SdtProfesional_Premios)collectionPremios.elementAt(-1+idx));
               currItemPremios.setgxTv_SdtProfesional_Premios_Mode( "INS" );
               currItemPremios.setgxTv_SdtProfesional_Premios_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_SdtProfesional_Servicios != null )
         {
            GXBCLevelCollection<com.projectthani.SdtProfesional_Servicios> collectionServicios = gxTv_SdtProfesional_Servicios;
            com.projectthani.SdtProfesional_Servicios currItemServicios;
            short idx = 1;
            while ( idx <= collectionServicios.size() )
            {
               currItemServicios = (com.projectthani.SdtProfesional_Servicios)((com.projectthani.SdtProfesional_Servicios)collectionServicios.elementAt(-1+idx));
               currItemServicios.setgxTv_SdtProfesional_Servicios_Mode( "INS" );
               currItemServicios.setgxTv_SdtProfesional_Servicios_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
      }
      SetDirty("Profesionalid");
      gxTv_SdtProfesional_Profesionalid = value ;
   }

   public String getgxTv_SdtProfesional_Profesionaltipodocumento( )
   {
      return gxTv_SdtProfesional_Profesionaltipodocumento ;
   }

   public void setgxTv_SdtProfesional_Profesionaltipodocumento( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionaltipodocumento");
      gxTv_SdtProfesional_Profesionaltipodocumento = value ;
   }

   public String getgxTv_SdtProfesional_Profesionalnrodocumento( )
   {
      return gxTv_SdtProfesional_Profesionalnrodocumento ;
   }

   public void setgxTv_SdtProfesional_Profesionalnrodocumento( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionalnrodocumento");
      gxTv_SdtProfesional_Profesionalnrodocumento = value ;
   }

   public String getgxTv_SdtProfesional_Profesionalapellidopaterno( )
   {
      return gxTv_SdtProfesional_Profesionalapellidopaterno ;
   }

   public void setgxTv_SdtProfesional_Profesionalapellidopaterno( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionalapellidopaterno");
      gxTv_SdtProfesional_Profesionalapellidopaterno = value ;
   }

   public String getgxTv_SdtProfesional_Profesionalapellidomaterno( )
   {
      return gxTv_SdtProfesional_Profesionalapellidomaterno ;
   }

   public void setgxTv_SdtProfesional_Profesionalapellidomaterno( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionalapellidomaterno");
      gxTv_SdtProfesional_Profesionalapellidomaterno = value ;
   }

   public String getgxTv_SdtProfesional_Profesionalnombres( )
   {
      return gxTv_SdtProfesional_Profesionalnombres ;
   }

   public void setgxTv_SdtProfesional_Profesionalnombres( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionalnombres");
      gxTv_SdtProfesional_Profesionalnombres = value ;
   }

   public String getgxTv_SdtProfesional_Profesionalnombrecompleto2( )
   {
      return gxTv_SdtProfesional_Profesionalnombrecompleto2 ;
   }

   public void setgxTv_SdtProfesional_Profesionalnombrecompleto2( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionalnombrecompleto2");
      gxTv_SdtProfesional_Profesionalnombrecompleto2 = value ;
   }

   public void setgxTv_SdtProfesional_Profesionalnombrecompleto2_SetNull( )
   {
      gxTv_SdtProfesional_Profesionalnombrecompleto2 = "" ;
   }

   public boolean getgxTv_SdtProfesional_Profesionalnombrecompleto2_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtProfesional_Profesionalfechanacimiento( )
   {
      return gxTv_SdtProfesional_Profesionalfechanacimiento ;
   }

   public void setgxTv_SdtProfesional_Profesionalfechanacimiento( java.util.Date value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionalfechanacimiento");
      gxTv_SdtProfesional_Profesionalfechanacimiento = value ;
   }

   public String getgxTv_SdtProfesional_Profesionalsexo( )
   {
      return gxTv_SdtProfesional_Profesionalsexo ;
   }

   public void setgxTv_SdtProfesional_Profesionalsexo( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionalsexo");
      gxTv_SdtProfesional_Profesionalsexo = value ;
   }

   public String getgxTv_SdtProfesional_Profesionaldescripcion( )
   {
      return gxTv_SdtProfesional_Profesionaldescripcion ;
   }

   public void setgxTv_SdtProfesional_Profesionaldescripcion( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionaldescripcion");
      gxTv_SdtProfesional_Profesionaldescripcion = value ;
   }

   public String getgxTv_SdtProfesional_Profesionalcorreo( )
   {
      return gxTv_SdtProfesional_Profesionalcorreo ;
   }

   public void setgxTv_SdtProfesional_Profesionalcorreo( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionalcorreo");
      gxTv_SdtProfesional_Profesionalcorreo = value ;
   }

   public String getgxTv_SdtProfesional_Profesionalcop( )
   {
      return gxTv_SdtProfesional_Profesionalcop ;
   }

   public void setgxTv_SdtProfesional_Profesionalcop( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionalcop");
      gxTv_SdtProfesional_Profesionalcop = value ;
   }

   public String getgxTv_SdtProfesional_Profesionalcolordisponible( )
   {
      return gxTv_SdtProfesional_Profesionalcolordisponible ;
   }

   public void setgxTv_SdtProfesional_Profesionalcolordisponible( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionalcolordisponible");
      gxTv_SdtProfesional_Profesionalcolordisponible = value ;
   }

   public String getgxTv_SdtProfesional_Profesionalcolorcita( )
   {
      return gxTv_SdtProfesional_Profesionalcolorcita ;
   }

   public void setgxTv_SdtProfesional_Profesionalcolorcita( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionalcolorcita");
      gxTv_SdtProfesional_Profesionalcolorcita = value ;
   }

   public byte getgxTv_SdtProfesional_Profesionaltiempocita( )
   {
      return gxTv_SdtProfesional_Profesionaltiempocita ;
   }

   public void setgxTv_SdtProfesional_Profesionaltiempocita( byte value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionaltiempocita");
      gxTv_SdtProfesional_Profesionaltiempocita = value ;
   }

   public String getgxTv_SdtProfesional_Profesionaldireccion( )
   {
      return gxTv_SdtProfesional_Profesionaldireccion ;
   }

   public void setgxTv_SdtProfesional_Profesionaldireccion( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionaldireccion");
      gxTv_SdtProfesional_Profesionaldireccion = value ;
   }

   public short getgxTv_SdtProfesional_Paisid( )
   {
      return gxTv_SdtProfesional_Paisid ;
   }

   public void setgxTv_SdtProfesional_Paisid( short value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Paisid");
      gxTv_SdtProfesional_Paisid = value ;
   }

   public String getgxTv_SdtProfesional_Paisdescripcion( )
   {
      return gxTv_SdtProfesional_Paisdescripcion ;
   }

   public void setgxTv_SdtProfesional_Paisdescripcion( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Paisdescripcion");
      gxTv_SdtProfesional_Paisdescripcion = value ;
   }

   public String getgxTv_SdtProfesional_Ubigeocode( )
   {
      return gxTv_SdtProfesional_Ubigeocode ;
   }

   public void setgxTv_SdtProfesional_Ubigeocode( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Ubigeocode");
      gxTv_SdtProfesional_Ubigeocode = value ;
   }

   public String getgxTv_SdtProfesional_Ubigeonombre( )
   {
      return gxTv_SdtProfesional_Ubigeonombre ;
   }

   public void setgxTv_SdtProfesional_Ubigeonombre( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Ubigeonombre");
      gxTv_SdtProfesional_Ubigeonombre = value ;
   }

   public void setgxTv_SdtProfesional_Ubigeonombre_SetNull( )
   {
      gxTv_SdtProfesional_Ubigeonombre = "" ;
   }

   public boolean getgxTv_SdtProfesional_Ubigeonombre_IsNull( )
   {
      return false ;
   }

   @GxUpload
   public String getgxTv_SdtProfesional_Profesionalfoto( )
   {
      return gxTv_SdtProfesional_Profesionalfoto ;
   }

   public void setgxTv_SdtProfesional_Profesionalfoto( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionalfoto");
      gxTv_SdtProfesional_Profesionalfoto = value ;
   }

   public String getgxTv_SdtProfesional_Profesionalfoto_gxi( )
   {
      return gxTv_SdtProfesional_Profesionalfoto_gxi ;
   }

   public void setgxTv_SdtProfesional_Profesionalfoto_gxi( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionalfoto_gxi");
      gxTv_SdtProfesional_Profesionalfoto_gxi = value ;
   }

   public String getgxTv_SdtProfesional_Profesionaltwitter( )
   {
      return gxTv_SdtProfesional_Profesionaltwitter ;
   }

   public void setgxTv_SdtProfesional_Profesionaltwitter( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionaltwitter");
      gxTv_SdtProfesional_Profesionaltwitter = value ;
   }

   public String getgxTv_SdtProfesional_Profesionalfacebook( )
   {
      return gxTv_SdtProfesional_Profesionalfacebook ;
   }

   public void setgxTv_SdtProfesional_Profesionalfacebook( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionalfacebook");
      gxTv_SdtProfesional_Profesionalfacebook = value ;
   }

   public String getgxTv_SdtProfesional_Profesionalinstagram( )
   {
      return gxTv_SdtProfesional_Profesionalinstagram ;
   }

   public void setgxTv_SdtProfesional_Profesionalinstagram( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionalinstagram");
      gxTv_SdtProfesional_Profesionalinstagram = value ;
   }

   public String getgxTv_SdtProfesional_Profesionallinkedin( )
   {
      return gxTv_SdtProfesional_Profesionallinkedin ;
   }

   public void setgxTv_SdtProfesional_Profesionallinkedin( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionallinkedin");
      gxTv_SdtProfesional_Profesionallinkedin = value ;
   }

   public String getgxTv_SdtProfesional_Profesionaltelefono( )
   {
      return gxTv_SdtProfesional_Profesionaltelefono ;
   }

   public void setgxTv_SdtProfesional_Profesionaltelefono( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionaltelefono");
      gxTv_SdtProfesional_Profesionaltelefono = value ;
   }

   public short getgxTv_SdtProfesional_Secuserid( )
   {
      return gxTv_SdtProfesional_Secuserid ;
   }

   public void setgxTv_SdtProfesional_Secuserid( short value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Secuserid");
      gxTv_SdtProfesional_Secuserid = value ;
   }

   public java.util.Date getgxTv_SdtProfesional_Profesionalfecharegistro( )
   {
      return gxTv_SdtProfesional_Profesionalfecharegistro ;
   }

   public void setgxTv_SdtProfesional_Profesionalfecharegistro( java.util.Date value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionalfecharegistro");
      gxTv_SdtProfesional_Profesionalfecharegistro = value ;
   }

   public boolean getgxTv_SdtProfesional_Profesionalterminoscondiciones( )
   {
      return gxTv_SdtProfesional_Profesionalterminoscondiciones ;
   }

   public void setgxTv_SdtProfesional_Profesionalterminoscondiciones( boolean value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionalterminoscondiciones");
      gxTv_SdtProfesional_Profesionalterminoscondiciones = value ;
   }

   public String getgxTv_SdtProfesional_Profesionalestadocuenta( )
   {
      return gxTv_SdtProfesional_Profesionalestadocuenta ;
   }

   public void setgxTv_SdtProfesional_Profesionalestadocuenta( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionalestadocuenta");
      gxTv_SdtProfesional_Profesionalestadocuenta = value ;
   }

   public String getgxTv_SdtProfesional_Profesionalestado( )
   {
      return gxTv_SdtProfesional_Profesionalestado ;
   }

   public void setgxTv_SdtProfesional_Profesionalestado( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionalestado");
      gxTv_SdtProfesional_Profesionalestado = value ;
   }

   public GXBCLevelCollection<com.projectthani.SdtProfesional_Especialidad> getgxTv_SdtProfesional_Especialidad( )
   {
      if ( gxTv_SdtProfesional_Especialidad == null )
      {
         gxTv_SdtProfesional_Especialidad = new GXBCLevelCollection<com.projectthani.SdtProfesional_Especialidad>(com.projectthani.SdtProfesional_Especialidad.class, "Profesional.Especialidad", "ProjectThani", remoteHandle);
      }
      gxTv_SdtProfesional_N = (byte)(0) ;
      return gxTv_SdtProfesional_Especialidad ;
   }

   public void setgxTv_SdtProfesional_Especialidad( GXBCLevelCollection<com.projectthani.SdtProfesional_Especialidad> value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Especialidad");
      gxTv_SdtProfesional_Especialidad = value ;
   }

   public void setgxTv_SdtProfesional_Especialidad_SetNull( )
   {
      gxTv_SdtProfesional_Especialidad = null ;
   }

   public boolean getgxTv_SdtProfesional_Especialidad_IsNull( )
   {
      if ( gxTv_SdtProfesional_Especialidad == null )
      {
         return true ;
      }
      return false ;
   }

   public GXBCLevelCollection<com.projectthani.SdtProfesional_Educacion> getgxTv_SdtProfesional_Educacion( )
   {
      if ( gxTv_SdtProfesional_Educacion == null )
      {
         gxTv_SdtProfesional_Educacion = new GXBCLevelCollection<com.projectthani.SdtProfesional_Educacion>(com.projectthani.SdtProfesional_Educacion.class, "Profesional.Educacion", "ProjectThani", remoteHandle);
      }
      gxTv_SdtProfesional_N = (byte)(0) ;
      return gxTv_SdtProfesional_Educacion ;
   }

   public void setgxTv_SdtProfesional_Educacion( GXBCLevelCollection<com.projectthani.SdtProfesional_Educacion> value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Educacion");
      gxTv_SdtProfesional_Educacion = value ;
   }

   public void setgxTv_SdtProfesional_Educacion_SetNull( )
   {
      gxTv_SdtProfesional_Educacion = null ;
   }

   public boolean getgxTv_SdtProfesional_Educacion_IsNull( )
   {
      if ( gxTv_SdtProfesional_Educacion == null )
      {
         return true ;
      }
      return false ;
   }

   public GXBCLevelCollection<com.projectthani.SdtProfesional_ExperienciaLaboral> getgxTv_SdtProfesional_Experiencialaboral( )
   {
      if ( gxTv_SdtProfesional_Experiencialaboral == null )
      {
         gxTv_SdtProfesional_Experiencialaboral = new GXBCLevelCollection<com.projectthani.SdtProfesional_ExperienciaLaboral>(com.projectthani.SdtProfesional_ExperienciaLaboral.class, "Profesional.ExperienciaLaboral", "ProjectThani", remoteHandle);
      }
      gxTv_SdtProfesional_N = (byte)(0) ;
      return gxTv_SdtProfesional_Experiencialaboral ;
   }

   public void setgxTv_SdtProfesional_Experiencialaboral( GXBCLevelCollection<com.projectthani.SdtProfesional_ExperienciaLaboral> value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Experiencialaboral");
      gxTv_SdtProfesional_Experiencialaboral = value ;
   }

   public void setgxTv_SdtProfesional_Experiencialaboral_SetNull( )
   {
      gxTv_SdtProfesional_Experiencialaboral = null ;
   }

   public boolean getgxTv_SdtProfesional_Experiencialaboral_IsNull( )
   {
      if ( gxTv_SdtProfesional_Experiencialaboral == null )
      {
         return true ;
      }
      return false ;
   }

   public GXBCLevelCollection<com.projectthani.SdtProfesional_Premios> getgxTv_SdtProfesional_Premios( )
   {
      if ( gxTv_SdtProfesional_Premios == null )
      {
         gxTv_SdtProfesional_Premios = new GXBCLevelCollection<com.projectthani.SdtProfesional_Premios>(com.projectthani.SdtProfesional_Premios.class, "Profesional.Premios", "ProjectThani", remoteHandle);
      }
      gxTv_SdtProfesional_N = (byte)(0) ;
      return gxTv_SdtProfesional_Premios ;
   }

   public void setgxTv_SdtProfesional_Premios( GXBCLevelCollection<com.projectthani.SdtProfesional_Premios> value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Premios");
      gxTv_SdtProfesional_Premios = value ;
   }

   public void setgxTv_SdtProfesional_Premios_SetNull( )
   {
      gxTv_SdtProfesional_Premios = null ;
   }

   public boolean getgxTv_SdtProfesional_Premios_IsNull( )
   {
      if ( gxTv_SdtProfesional_Premios == null )
      {
         return true ;
      }
      return false ;
   }

   public GXBCLevelCollection<com.projectthani.SdtProfesional_Servicios> getgxTv_SdtProfesional_Servicios( )
   {
      if ( gxTv_SdtProfesional_Servicios == null )
      {
         gxTv_SdtProfesional_Servicios = new GXBCLevelCollection<com.projectthani.SdtProfesional_Servicios>(com.projectthani.SdtProfesional_Servicios.class, "Profesional.Servicios", "ProjectThani", remoteHandle);
      }
      gxTv_SdtProfesional_N = (byte)(0) ;
      return gxTv_SdtProfesional_Servicios ;
   }

   public void setgxTv_SdtProfesional_Servicios( GXBCLevelCollection<com.projectthani.SdtProfesional_Servicios> value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Servicios");
      gxTv_SdtProfesional_Servicios = value ;
   }

   public void setgxTv_SdtProfesional_Servicios_SetNull( )
   {
      gxTv_SdtProfesional_Servicios = null ;
   }

   public boolean getgxTv_SdtProfesional_Servicios_IsNull( )
   {
      if ( gxTv_SdtProfesional_Servicios == null )
      {
         return true ;
      }
      return false ;
   }

   public String getgxTv_SdtProfesional_Mode( )
   {
      return gxTv_SdtProfesional_Mode ;
   }

   public void setgxTv_SdtProfesional_Mode( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtProfesional_Mode = value ;
   }

   public void setgxTv_SdtProfesional_Mode_SetNull( )
   {
      gxTv_SdtProfesional_Mode = "" ;
   }

   public boolean getgxTv_SdtProfesional_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtProfesional_Initialized( )
   {
      return gxTv_SdtProfesional_Initialized ;
   }

   public void setgxTv_SdtProfesional_Initialized( short value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtProfesional_Initialized = value ;
   }

   public void setgxTv_SdtProfesional_Initialized_SetNull( )
   {
      gxTv_SdtProfesional_Initialized = (short)(0) ;
   }

   public boolean getgxTv_SdtProfesional_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtProfesional_Profesionalid_Z( )
   {
      return gxTv_SdtProfesional_Profesionalid_Z ;
   }

   public void setgxTv_SdtProfesional_Profesionalid_Z( int value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionalid_Z");
      gxTv_SdtProfesional_Profesionalid_Z = value ;
   }

   public void setgxTv_SdtProfesional_Profesionalid_Z_SetNull( )
   {
      gxTv_SdtProfesional_Profesionalid_Z = 0 ;
   }

   public boolean getgxTv_SdtProfesional_Profesionalid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtProfesional_Profesionaltipodocumento_Z( )
   {
      return gxTv_SdtProfesional_Profesionaltipodocumento_Z ;
   }

   public void setgxTv_SdtProfesional_Profesionaltipodocumento_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionaltipodocumento_Z");
      gxTv_SdtProfesional_Profesionaltipodocumento_Z = value ;
   }

   public void setgxTv_SdtProfesional_Profesionaltipodocumento_Z_SetNull( )
   {
      gxTv_SdtProfesional_Profesionaltipodocumento_Z = "" ;
   }

   public boolean getgxTv_SdtProfesional_Profesionaltipodocumento_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtProfesional_Profesionalnrodocumento_Z( )
   {
      return gxTv_SdtProfesional_Profesionalnrodocumento_Z ;
   }

   public void setgxTv_SdtProfesional_Profesionalnrodocumento_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionalnrodocumento_Z");
      gxTv_SdtProfesional_Profesionalnrodocumento_Z = value ;
   }

   public void setgxTv_SdtProfesional_Profesionalnrodocumento_Z_SetNull( )
   {
      gxTv_SdtProfesional_Profesionalnrodocumento_Z = "" ;
   }

   public boolean getgxTv_SdtProfesional_Profesionalnrodocumento_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtProfesional_Profesionalapellidopaterno_Z( )
   {
      return gxTv_SdtProfesional_Profesionalapellidopaterno_Z ;
   }

   public void setgxTv_SdtProfesional_Profesionalapellidopaterno_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionalapellidopaterno_Z");
      gxTv_SdtProfesional_Profesionalapellidopaterno_Z = value ;
   }

   public void setgxTv_SdtProfesional_Profesionalapellidopaterno_Z_SetNull( )
   {
      gxTv_SdtProfesional_Profesionalapellidopaterno_Z = "" ;
   }

   public boolean getgxTv_SdtProfesional_Profesionalapellidopaterno_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtProfesional_Profesionalapellidomaterno_Z( )
   {
      return gxTv_SdtProfesional_Profesionalapellidomaterno_Z ;
   }

   public void setgxTv_SdtProfesional_Profesionalapellidomaterno_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionalapellidomaterno_Z");
      gxTv_SdtProfesional_Profesionalapellidomaterno_Z = value ;
   }

   public void setgxTv_SdtProfesional_Profesionalapellidomaterno_Z_SetNull( )
   {
      gxTv_SdtProfesional_Profesionalapellidomaterno_Z = "" ;
   }

   public boolean getgxTv_SdtProfesional_Profesionalapellidomaterno_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtProfesional_Profesionalnombres_Z( )
   {
      return gxTv_SdtProfesional_Profesionalnombres_Z ;
   }

   public void setgxTv_SdtProfesional_Profesionalnombres_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionalnombres_Z");
      gxTv_SdtProfesional_Profesionalnombres_Z = value ;
   }

   public void setgxTv_SdtProfesional_Profesionalnombres_Z_SetNull( )
   {
      gxTv_SdtProfesional_Profesionalnombres_Z = "" ;
   }

   public boolean getgxTv_SdtProfesional_Profesionalnombres_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtProfesional_Profesionalnombrecompleto2_Z( )
   {
      return gxTv_SdtProfesional_Profesionalnombrecompleto2_Z ;
   }

   public void setgxTv_SdtProfesional_Profesionalnombrecompleto2_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionalnombrecompleto2_Z");
      gxTv_SdtProfesional_Profesionalnombrecompleto2_Z = value ;
   }

   public void setgxTv_SdtProfesional_Profesionalnombrecompleto2_Z_SetNull( )
   {
      gxTv_SdtProfesional_Profesionalnombrecompleto2_Z = "" ;
   }

   public boolean getgxTv_SdtProfesional_Profesionalnombrecompleto2_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtProfesional_Profesionalfechanacimiento_Z( )
   {
      return gxTv_SdtProfesional_Profesionalfechanacimiento_Z ;
   }

   public void setgxTv_SdtProfesional_Profesionalfechanacimiento_Z( java.util.Date value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionalfechanacimiento_Z");
      gxTv_SdtProfesional_Profesionalfechanacimiento_Z = value ;
   }

   public void setgxTv_SdtProfesional_Profesionalfechanacimiento_Z_SetNull( )
   {
      gxTv_SdtProfesional_Profesionalfechanacimiento_Z = GXutil.nullDate() ;
   }

   public boolean getgxTv_SdtProfesional_Profesionalfechanacimiento_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtProfesional_Profesionalsexo_Z( )
   {
      return gxTv_SdtProfesional_Profesionalsexo_Z ;
   }

   public void setgxTv_SdtProfesional_Profesionalsexo_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionalsexo_Z");
      gxTv_SdtProfesional_Profesionalsexo_Z = value ;
   }

   public void setgxTv_SdtProfesional_Profesionalsexo_Z_SetNull( )
   {
      gxTv_SdtProfesional_Profesionalsexo_Z = "" ;
   }

   public boolean getgxTv_SdtProfesional_Profesionalsexo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtProfesional_Profesionaldescripcion_Z( )
   {
      return gxTv_SdtProfesional_Profesionaldescripcion_Z ;
   }

   public void setgxTv_SdtProfesional_Profesionaldescripcion_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionaldescripcion_Z");
      gxTv_SdtProfesional_Profesionaldescripcion_Z = value ;
   }

   public void setgxTv_SdtProfesional_Profesionaldescripcion_Z_SetNull( )
   {
      gxTv_SdtProfesional_Profesionaldescripcion_Z = "" ;
   }

   public boolean getgxTv_SdtProfesional_Profesionaldescripcion_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtProfesional_Profesionalcorreo_Z( )
   {
      return gxTv_SdtProfesional_Profesionalcorreo_Z ;
   }

   public void setgxTv_SdtProfesional_Profesionalcorreo_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionalcorreo_Z");
      gxTv_SdtProfesional_Profesionalcorreo_Z = value ;
   }

   public void setgxTv_SdtProfesional_Profesionalcorreo_Z_SetNull( )
   {
      gxTv_SdtProfesional_Profesionalcorreo_Z = "" ;
   }

   public boolean getgxTv_SdtProfesional_Profesionalcorreo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtProfesional_Profesionalcop_Z( )
   {
      return gxTv_SdtProfesional_Profesionalcop_Z ;
   }

   public void setgxTv_SdtProfesional_Profesionalcop_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionalcop_Z");
      gxTv_SdtProfesional_Profesionalcop_Z = value ;
   }

   public void setgxTv_SdtProfesional_Profesionalcop_Z_SetNull( )
   {
      gxTv_SdtProfesional_Profesionalcop_Z = "" ;
   }

   public boolean getgxTv_SdtProfesional_Profesionalcop_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtProfesional_Profesionalcolordisponible_Z( )
   {
      return gxTv_SdtProfesional_Profesionalcolordisponible_Z ;
   }

   public void setgxTv_SdtProfesional_Profesionalcolordisponible_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionalcolordisponible_Z");
      gxTv_SdtProfesional_Profesionalcolordisponible_Z = value ;
   }

   public void setgxTv_SdtProfesional_Profesionalcolordisponible_Z_SetNull( )
   {
      gxTv_SdtProfesional_Profesionalcolordisponible_Z = "" ;
   }

   public boolean getgxTv_SdtProfesional_Profesionalcolordisponible_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtProfesional_Profesionalcolorcita_Z( )
   {
      return gxTv_SdtProfesional_Profesionalcolorcita_Z ;
   }

   public void setgxTv_SdtProfesional_Profesionalcolorcita_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionalcolorcita_Z");
      gxTv_SdtProfesional_Profesionalcolorcita_Z = value ;
   }

   public void setgxTv_SdtProfesional_Profesionalcolorcita_Z_SetNull( )
   {
      gxTv_SdtProfesional_Profesionalcolorcita_Z = "" ;
   }

   public boolean getgxTv_SdtProfesional_Profesionalcolorcita_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtProfesional_Profesionaltiempocita_Z( )
   {
      return gxTv_SdtProfesional_Profesionaltiempocita_Z ;
   }

   public void setgxTv_SdtProfesional_Profesionaltiempocita_Z( byte value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionaltiempocita_Z");
      gxTv_SdtProfesional_Profesionaltiempocita_Z = value ;
   }

   public void setgxTv_SdtProfesional_Profesionaltiempocita_Z_SetNull( )
   {
      gxTv_SdtProfesional_Profesionaltiempocita_Z = (byte)(0) ;
   }

   public boolean getgxTv_SdtProfesional_Profesionaltiempocita_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtProfesional_Profesionaldireccion_Z( )
   {
      return gxTv_SdtProfesional_Profesionaldireccion_Z ;
   }

   public void setgxTv_SdtProfesional_Profesionaldireccion_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionaldireccion_Z");
      gxTv_SdtProfesional_Profesionaldireccion_Z = value ;
   }

   public void setgxTv_SdtProfesional_Profesionaldireccion_Z_SetNull( )
   {
      gxTv_SdtProfesional_Profesionaldireccion_Z = "" ;
   }

   public boolean getgxTv_SdtProfesional_Profesionaldireccion_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtProfesional_Paisid_Z( )
   {
      return gxTv_SdtProfesional_Paisid_Z ;
   }

   public void setgxTv_SdtProfesional_Paisid_Z( short value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Paisid_Z");
      gxTv_SdtProfesional_Paisid_Z = value ;
   }

   public void setgxTv_SdtProfesional_Paisid_Z_SetNull( )
   {
      gxTv_SdtProfesional_Paisid_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtProfesional_Paisid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtProfesional_Paisdescripcion_Z( )
   {
      return gxTv_SdtProfesional_Paisdescripcion_Z ;
   }

   public void setgxTv_SdtProfesional_Paisdescripcion_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Paisdescripcion_Z");
      gxTv_SdtProfesional_Paisdescripcion_Z = value ;
   }

   public void setgxTv_SdtProfesional_Paisdescripcion_Z_SetNull( )
   {
      gxTv_SdtProfesional_Paisdescripcion_Z = "" ;
   }

   public boolean getgxTv_SdtProfesional_Paisdescripcion_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtProfesional_Ubigeocode_Z( )
   {
      return gxTv_SdtProfesional_Ubigeocode_Z ;
   }

   public void setgxTv_SdtProfesional_Ubigeocode_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Ubigeocode_Z");
      gxTv_SdtProfesional_Ubigeocode_Z = value ;
   }

   public void setgxTv_SdtProfesional_Ubigeocode_Z_SetNull( )
   {
      gxTv_SdtProfesional_Ubigeocode_Z = "" ;
   }

   public boolean getgxTv_SdtProfesional_Ubigeocode_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtProfesional_Ubigeonombre_Z( )
   {
      return gxTv_SdtProfesional_Ubigeonombre_Z ;
   }

   public void setgxTv_SdtProfesional_Ubigeonombre_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Ubigeonombre_Z");
      gxTv_SdtProfesional_Ubigeonombre_Z = value ;
   }

   public void setgxTv_SdtProfesional_Ubigeonombre_Z_SetNull( )
   {
      gxTv_SdtProfesional_Ubigeonombre_Z = "" ;
   }

   public boolean getgxTv_SdtProfesional_Ubigeonombre_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtProfesional_Profesionaltwitter_Z( )
   {
      return gxTv_SdtProfesional_Profesionaltwitter_Z ;
   }

   public void setgxTv_SdtProfesional_Profesionaltwitter_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionaltwitter_Z");
      gxTv_SdtProfesional_Profesionaltwitter_Z = value ;
   }

   public void setgxTv_SdtProfesional_Profesionaltwitter_Z_SetNull( )
   {
      gxTv_SdtProfesional_Profesionaltwitter_Z = "" ;
   }

   public boolean getgxTv_SdtProfesional_Profesionaltwitter_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtProfesional_Profesionalfacebook_Z( )
   {
      return gxTv_SdtProfesional_Profesionalfacebook_Z ;
   }

   public void setgxTv_SdtProfesional_Profesionalfacebook_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionalfacebook_Z");
      gxTv_SdtProfesional_Profesionalfacebook_Z = value ;
   }

   public void setgxTv_SdtProfesional_Profesionalfacebook_Z_SetNull( )
   {
      gxTv_SdtProfesional_Profesionalfacebook_Z = "" ;
   }

   public boolean getgxTv_SdtProfesional_Profesionalfacebook_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtProfesional_Profesionalinstagram_Z( )
   {
      return gxTv_SdtProfesional_Profesionalinstagram_Z ;
   }

   public void setgxTv_SdtProfesional_Profesionalinstagram_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionalinstagram_Z");
      gxTv_SdtProfesional_Profesionalinstagram_Z = value ;
   }

   public void setgxTv_SdtProfesional_Profesionalinstagram_Z_SetNull( )
   {
      gxTv_SdtProfesional_Profesionalinstagram_Z = "" ;
   }

   public boolean getgxTv_SdtProfesional_Profesionalinstagram_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtProfesional_Profesionallinkedin_Z( )
   {
      return gxTv_SdtProfesional_Profesionallinkedin_Z ;
   }

   public void setgxTv_SdtProfesional_Profesionallinkedin_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionallinkedin_Z");
      gxTv_SdtProfesional_Profesionallinkedin_Z = value ;
   }

   public void setgxTv_SdtProfesional_Profesionallinkedin_Z_SetNull( )
   {
      gxTv_SdtProfesional_Profesionallinkedin_Z = "" ;
   }

   public boolean getgxTv_SdtProfesional_Profesionallinkedin_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtProfesional_Profesionaltelefono_Z( )
   {
      return gxTv_SdtProfesional_Profesionaltelefono_Z ;
   }

   public void setgxTv_SdtProfesional_Profesionaltelefono_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionaltelefono_Z");
      gxTv_SdtProfesional_Profesionaltelefono_Z = value ;
   }

   public void setgxTv_SdtProfesional_Profesionaltelefono_Z_SetNull( )
   {
      gxTv_SdtProfesional_Profesionaltelefono_Z = "" ;
   }

   public boolean getgxTv_SdtProfesional_Profesionaltelefono_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtProfesional_Secuserid_Z( )
   {
      return gxTv_SdtProfesional_Secuserid_Z ;
   }

   public void setgxTv_SdtProfesional_Secuserid_Z( short value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Secuserid_Z");
      gxTv_SdtProfesional_Secuserid_Z = value ;
   }

   public void setgxTv_SdtProfesional_Secuserid_Z_SetNull( )
   {
      gxTv_SdtProfesional_Secuserid_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtProfesional_Secuserid_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtProfesional_Profesionalfecharegistro_Z( )
   {
      return gxTv_SdtProfesional_Profesionalfecharegistro_Z ;
   }

   public void setgxTv_SdtProfesional_Profesionalfecharegistro_Z( java.util.Date value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionalfecharegistro_Z");
      gxTv_SdtProfesional_Profesionalfecharegistro_Z = value ;
   }

   public void setgxTv_SdtProfesional_Profesionalfecharegistro_Z_SetNull( )
   {
      gxTv_SdtProfesional_Profesionalfecharegistro_Z = GXutil.nullDate() ;
   }

   public boolean getgxTv_SdtProfesional_Profesionalfecharegistro_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtProfesional_Profesionalterminoscondiciones_Z( )
   {
      return gxTv_SdtProfesional_Profesionalterminoscondiciones_Z ;
   }

   public void setgxTv_SdtProfesional_Profesionalterminoscondiciones_Z( boolean value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionalterminoscondiciones_Z");
      gxTv_SdtProfesional_Profesionalterminoscondiciones_Z = value ;
   }

   public void setgxTv_SdtProfesional_Profesionalterminoscondiciones_Z_SetNull( )
   {
      gxTv_SdtProfesional_Profesionalterminoscondiciones_Z = false ;
   }

   public boolean getgxTv_SdtProfesional_Profesionalterminoscondiciones_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtProfesional_Profesionalestadocuenta_Z( )
   {
      return gxTv_SdtProfesional_Profesionalestadocuenta_Z ;
   }

   public void setgxTv_SdtProfesional_Profesionalestadocuenta_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionalestadocuenta_Z");
      gxTv_SdtProfesional_Profesionalestadocuenta_Z = value ;
   }

   public void setgxTv_SdtProfesional_Profesionalestadocuenta_Z_SetNull( )
   {
      gxTv_SdtProfesional_Profesionalestadocuenta_Z = "" ;
   }

   public boolean getgxTv_SdtProfesional_Profesionalestadocuenta_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtProfesional_Profesionalestado_Z( )
   {
      return gxTv_SdtProfesional_Profesionalestado_Z ;
   }

   public void setgxTv_SdtProfesional_Profesionalestado_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionalestado_Z");
      gxTv_SdtProfesional_Profesionalestado_Z = value ;
   }

   public void setgxTv_SdtProfesional_Profesionalestado_Z_SetNull( )
   {
      gxTv_SdtProfesional_Profesionalestado_Z = "" ;
   }

   public boolean getgxTv_SdtProfesional_Profesionalestado_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtProfesional_Profesionalfoto_gxi_Z( )
   {
      return gxTv_SdtProfesional_Profesionalfoto_gxi_Z ;
   }

   public void setgxTv_SdtProfesional_Profesionalfoto_gxi_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      SetDirty("Profesionalfoto_gxi_Z");
      gxTv_SdtProfesional_Profesionalfoto_gxi_Z = value ;
   }

   public void setgxTv_SdtProfesional_Profesionalfoto_gxi_Z_SetNull( )
   {
      gxTv_SdtProfesional_Profesionalfoto_gxi_Z = "" ;
   }

   public boolean getgxTv_SdtProfesional_Profesionalfoto_gxi_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.projectthani.profesional_bc obj;
      obj = new com.projectthani.profesional_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtProfesional_N = (byte)(1) ;
      gxTv_SdtProfesional_Profesionaltipodocumento = "" ;
      gxTv_SdtProfesional_Profesionalnrodocumento = "" ;
      gxTv_SdtProfesional_Profesionalapellidopaterno = "" ;
      gxTv_SdtProfesional_Profesionalapellidomaterno = "" ;
      gxTv_SdtProfesional_Profesionalnombres = "" ;
      gxTv_SdtProfesional_Profesionalnombrecompleto2 = "" ;
      gxTv_SdtProfesional_Profesionalfechanacimiento = GXutil.nullDate() ;
      gxTv_SdtProfesional_Profesionalsexo = "" ;
      gxTv_SdtProfesional_Profesionaldescripcion = "" ;
      gxTv_SdtProfesional_Profesionalcorreo = "" ;
      gxTv_SdtProfesional_Profesionalcop = "" ;
      gxTv_SdtProfesional_Profesionalcolordisponible = "" ;
      gxTv_SdtProfesional_Profesionalcolorcita = "" ;
      gxTv_SdtProfesional_Profesionaltiempocita = (byte)(30) ;
      gxTv_SdtProfesional_Profesionaldireccion = "" ;
      gxTv_SdtProfesional_Paisdescripcion = "" ;
      gxTv_SdtProfesional_Ubigeocode = "" ;
      gxTv_SdtProfesional_Ubigeonombre = "" ;
      gxTv_SdtProfesional_Profesionalfoto = "" ;
      gxTv_SdtProfesional_Profesionalfoto_gxi = "" ;
      gxTv_SdtProfesional_Profesionaltwitter = "" ;
      gxTv_SdtProfesional_Profesionalfacebook = "" ;
      gxTv_SdtProfesional_Profesionalinstagram = "" ;
      gxTv_SdtProfesional_Profesionallinkedin = "" ;
      gxTv_SdtProfesional_Profesionaltelefono = "" ;
      gxTv_SdtProfesional_Profesionalfecharegistro = GXutil.nullDate() ;
      gxTv_SdtProfesional_Profesionalestadocuenta = "" ;
      gxTv_SdtProfesional_Profesionalestado = "" ;
      gxTv_SdtProfesional_Mode = "" ;
      gxTv_SdtProfesional_Profesionaltipodocumento_Z = "" ;
      gxTv_SdtProfesional_Profesionalnrodocumento_Z = "" ;
      gxTv_SdtProfesional_Profesionalapellidopaterno_Z = "" ;
      gxTv_SdtProfesional_Profesionalapellidomaterno_Z = "" ;
      gxTv_SdtProfesional_Profesionalnombres_Z = "" ;
      gxTv_SdtProfesional_Profesionalnombrecompleto2_Z = "" ;
      gxTv_SdtProfesional_Profesionalfechanacimiento_Z = GXutil.nullDate() ;
      gxTv_SdtProfesional_Profesionalsexo_Z = "" ;
      gxTv_SdtProfesional_Profesionaldescripcion_Z = "" ;
      gxTv_SdtProfesional_Profesionalcorreo_Z = "" ;
      gxTv_SdtProfesional_Profesionalcop_Z = "" ;
      gxTv_SdtProfesional_Profesionalcolordisponible_Z = "" ;
      gxTv_SdtProfesional_Profesionalcolorcita_Z = "" ;
      gxTv_SdtProfesional_Profesionaldireccion_Z = "" ;
      gxTv_SdtProfesional_Paisdescripcion_Z = "" ;
      gxTv_SdtProfesional_Ubigeocode_Z = "" ;
      gxTv_SdtProfesional_Ubigeonombre_Z = "" ;
      gxTv_SdtProfesional_Profesionaltwitter_Z = "" ;
      gxTv_SdtProfesional_Profesionalfacebook_Z = "" ;
      gxTv_SdtProfesional_Profesionalinstagram_Z = "" ;
      gxTv_SdtProfesional_Profesionallinkedin_Z = "" ;
      gxTv_SdtProfesional_Profesionaltelefono_Z = "" ;
      gxTv_SdtProfesional_Profesionalfecharegistro_Z = GXutil.nullDate() ;
      gxTv_SdtProfesional_Profesionalestadocuenta_Z = "" ;
      gxTv_SdtProfesional_Profesionalestado_Z = "" ;
      gxTv_SdtProfesional_Profesionalfoto_gxi_Z = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtProfesional_N ;
   }

   public com.projectthani.SdtProfesional Clone( )
   {
      com.projectthani.SdtProfesional sdt;
      com.projectthani.profesional_bc obj;
      sdt = (com.projectthani.SdtProfesional)(clone()) ;
      obj = (com.projectthani.profesional_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.projectthani.StructSdtProfesional struct )
   {
      setgxTv_SdtProfesional_Profesionalid(struct.getProfesionalid());
      setgxTv_SdtProfesional_Profesionaltipodocumento(struct.getProfesionaltipodocumento());
      setgxTv_SdtProfesional_Profesionalnrodocumento(struct.getProfesionalnrodocumento());
      setgxTv_SdtProfesional_Profesionalapellidopaterno(struct.getProfesionalapellidopaterno());
      setgxTv_SdtProfesional_Profesionalapellidomaterno(struct.getProfesionalapellidomaterno());
      setgxTv_SdtProfesional_Profesionalnombres(struct.getProfesionalnombres());
      setgxTv_SdtProfesional_Profesionalnombrecompleto2(struct.getProfesionalnombrecompleto2());
      setgxTv_SdtProfesional_Profesionalfechanacimiento(struct.getProfesionalfechanacimiento());
      setgxTv_SdtProfesional_Profesionalsexo(struct.getProfesionalsexo());
      setgxTv_SdtProfesional_Profesionaldescripcion(struct.getProfesionaldescripcion());
      setgxTv_SdtProfesional_Profesionalcorreo(struct.getProfesionalcorreo());
      setgxTv_SdtProfesional_Profesionalcop(struct.getProfesionalcop());
      setgxTv_SdtProfesional_Profesionalcolordisponible(struct.getProfesionalcolordisponible());
      setgxTv_SdtProfesional_Profesionalcolorcita(struct.getProfesionalcolorcita());
      setgxTv_SdtProfesional_Profesionaltiempocita(struct.getProfesionaltiempocita());
      setgxTv_SdtProfesional_Profesionaldireccion(struct.getProfesionaldireccion());
      setgxTv_SdtProfesional_Paisid(struct.getPaisid());
      setgxTv_SdtProfesional_Paisdescripcion(struct.getPaisdescripcion());
      setgxTv_SdtProfesional_Ubigeocode(struct.getUbigeocode());
      setgxTv_SdtProfesional_Ubigeonombre(struct.getUbigeonombre());
      setgxTv_SdtProfesional_Profesionalfoto(struct.getProfesionalfoto());
      setgxTv_SdtProfesional_Profesionalfoto_gxi(struct.getProfesionalfoto_gxi());
      setgxTv_SdtProfesional_Profesionaltwitter(struct.getProfesionaltwitter());
      setgxTv_SdtProfesional_Profesionalfacebook(struct.getProfesionalfacebook());
      setgxTv_SdtProfesional_Profesionalinstagram(struct.getProfesionalinstagram());
      setgxTv_SdtProfesional_Profesionallinkedin(struct.getProfesionallinkedin());
      setgxTv_SdtProfesional_Profesionaltelefono(struct.getProfesionaltelefono());
      setgxTv_SdtProfesional_Secuserid(struct.getSecuserid());
      setgxTv_SdtProfesional_Profesionalfecharegistro(struct.getProfesionalfecharegistro());
      setgxTv_SdtProfesional_Profesionalterminoscondiciones(struct.getProfesionalterminoscondiciones());
      setgxTv_SdtProfesional_Profesionalestadocuenta(struct.getProfesionalestadocuenta());
      setgxTv_SdtProfesional_Profesionalestado(struct.getProfesionalestado());
      GXBCLevelCollection<com.projectthani.SdtProfesional_Especialidad> gxTv_SdtProfesional_Especialidad_aux = new GXBCLevelCollection<com.projectthani.SdtProfesional_Especialidad>(com.projectthani.SdtProfesional_Especialidad.class, "Profesional.Especialidad", "ProjectThani", remoteHandle);
      Vector<com.projectthani.StructSdtProfesional_Especialidad> gxTv_SdtProfesional_Especialidad_aux1 = struct.getEspecialidad();
      if (gxTv_SdtProfesional_Especialidad_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtProfesional_Especialidad_aux1.size(); i++)
         {
            gxTv_SdtProfesional_Especialidad_aux.add(new com.projectthani.SdtProfesional_Especialidad(remoteHandle, gxTv_SdtProfesional_Especialidad_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtProfesional_Especialidad(gxTv_SdtProfesional_Especialidad_aux);
      GXBCLevelCollection<com.projectthani.SdtProfesional_Educacion> gxTv_SdtProfesional_Educacion_aux = new GXBCLevelCollection<com.projectthani.SdtProfesional_Educacion>(com.projectthani.SdtProfesional_Educacion.class, "Profesional.Educacion", "ProjectThani", remoteHandle);
      Vector<com.projectthani.StructSdtProfesional_Educacion> gxTv_SdtProfesional_Educacion_aux1 = struct.getEducacion();
      if (gxTv_SdtProfesional_Educacion_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtProfesional_Educacion_aux1.size(); i++)
         {
            gxTv_SdtProfesional_Educacion_aux.add(new com.projectthani.SdtProfesional_Educacion(remoteHandle, gxTv_SdtProfesional_Educacion_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtProfesional_Educacion(gxTv_SdtProfesional_Educacion_aux);
      GXBCLevelCollection<com.projectthani.SdtProfesional_ExperienciaLaboral> gxTv_SdtProfesional_Experiencialaboral_aux = new GXBCLevelCollection<com.projectthani.SdtProfesional_ExperienciaLaboral>(com.projectthani.SdtProfesional_ExperienciaLaboral.class, "Profesional.ExperienciaLaboral", "ProjectThani", remoteHandle);
      Vector<com.projectthani.StructSdtProfesional_ExperienciaLaboral> gxTv_SdtProfesional_Experiencialaboral_aux1 = struct.getExperiencialaboral();
      if (gxTv_SdtProfesional_Experiencialaboral_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtProfesional_Experiencialaboral_aux1.size(); i++)
         {
            gxTv_SdtProfesional_Experiencialaboral_aux.add(new com.projectthani.SdtProfesional_ExperienciaLaboral(remoteHandle, gxTv_SdtProfesional_Experiencialaboral_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtProfesional_Experiencialaboral(gxTv_SdtProfesional_Experiencialaboral_aux);
      GXBCLevelCollection<com.projectthani.SdtProfesional_Premios> gxTv_SdtProfesional_Premios_aux = new GXBCLevelCollection<com.projectthani.SdtProfesional_Premios>(com.projectthani.SdtProfesional_Premios.class, "Profesional.Premios", "ProjectThani", remoteHandle);
      Vector<com.projectthani.StructSdtProfesional_Premios> gxTv_SdtProfesional_Premios_aux1 = struct.getPremios();
      if (gxTv_SdtProfesional_Premios_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtProfesional_Premios_aux1.size(); i++)
         {
            gxTv_SdtProfesional_Premios_aux.add(new com.projectthani.SdtProfesional_Premios(remoteHandle, gxTv_SdtProfesional_Premios_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtProfesional_Premios(gxTv_SdtProfesional_Premios_aux);
      GXBCLevelCollection<com.projectthani.SdtProfesional_Servicios> gxTv_SdtProfesional_Servicios_aux = new GXBCLevelCollection<com.projectthani.SdtProfesional_Servicios>(com.projectthani.SdtProfesional_Servicios.class, "Profesional.Servicios", "ProjectThani", remoteHandle);
      Vector<com.projectthani.StructSdtProfesional_Servicios> gxTv_SdtProfesional_Servicios_aux1 = struct.getServicios();
      if (gxTv_SdtProfesional_Servicios_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtProfesional_Servicios_aux1.size(); i++)
         {
            gxTv_SdtProfesional_Servicios_aux.add(new com.projectthani.SdtProfesional_Servicios(remoteHandle, gxTv_SdtProfesional_Servicios_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtProfesional_Servicios(gxTv_SdtProfesional_Servicios_aux);
      setgxTv_SdtProfesional_Mode(struct.getMode());
      setgxTv_SdtProfesional_Initialized(struct.getInitialized());
      setgxTv_SdtProfesional_Profesionalid_Z(struct.getProfesionalid_Z());
      setgxTv_SdtProfesional_Profesionaltipodocumento_Z(struct.getProfesionaltipodocumento_Z());
      setgxTv_SdtProfesional_Profesionalnrodocumento_Z(struct.getProfesionalnrodocumento_Z());
      setgxTv_SdtProfesional_Profesionalapellidopaterno_Z(struct.getProfesionalapellidopaterno_Z());
      setgxTv_SdtProfesional_Profesionalapellidomaterno_Z(struct.getProfesionalapellidomaterno_Z());
      setgxTv_SdtProfesional_Profesionalnombres_Z(struct.getProfesionalnombres_Z());
      setgxTv_SdtProfesional_Profesionalnombrecompleto2_Z(struct.getProfesionalnombrecompleto2_Z());
      setgxTv_SdtProfesional_Profesionalfechanacimiento_Z(struct.getProfesionalfechanacimiento_Z());
      setgxTv_SdtProfesional_Profesionalsexo_Z(struct.getProfesionalsexo_Z());
      setgxTv_SdtProfesional_Profesionaldescripcion_Z(struct.getProfesionaldescripcion_Z());
      setgxTv_SdtProfesional_Profesionalcorreo_Z(struct.getProfesionalcorreo_Z());
      setgxTv_SdtProfesional_Profesionalcop_Z(struct.getProfesionalcop_Z());
      setgxTv_SdtProfesional_Profesionalcolordisponible_Z(struct.getProfesionalcolordisponible_Z());
      setgxTv_SdtProfesional_Profesionalcolorcita_Z(struct.getProfesionalcolorcita_Z());
      setgxTv_SdtProfesional_Profesionaltiempocita_Z(struct.getProfesionaltiempocita_Z());
      setgxTv_SdtProfesional_Profesionaldireccion_Z(struct.getProfesionaldireccion_Z());
      setgxTv_SdtProfesional_Paisid_Z(struct.getPaisid_Z());
      setgxTv_SdtProfesional_Paisdescripcion_Z(struct.getPaisdescripcion_Z());
      setgxTv_SdtProfesional_Ubigeocode_Z(struct.getUbigeocode_Z());
      setgxTv_SdtProfesional_Ubigeonombre_Z(struct.getUbigeonombre_Z());
      setgxTv_SdtProfesional_Profesionaltwitter_Z(struct.getProfesionaltwitter_Z());
      setgxTv_SdtProfesional_Profesionalfacebook_Z(struct.getProfesionalfacebook_Z());
      setgxTv_SdtProfesional_Profesionalinstagram_Z(struct.getProfesionalinstagram_Z());
      setgxTv_SdtProfesional_Profesionallinkedin_Z(struct.getProfesionallinkedin_Z());
      setgxTv_SdtProfesional_Profesionaltelefono_Z(struct.getProfesionaltelefono_Z());
      setgxTv_SdtProfesional_Secuserid_Z(struct.getSecuserid_Z());
      setgxTv_SdtProfesional_Profesionalfecharegistro_Z(struct.getProfesionalfecharegistro_Z());
      setgxTv_SdtProfesional_Profesionalterminoscondiciones_Z(struct.getProfesionalterminoscondiciones_Z());
      setgxTv_SdtProfesional_Profesionalestadocuenta_Z(struct.getProfesionalestadocuenta_Z());
      setgxTv_SdtProfesional_Profesionalestado_Z(struct.getProfesionalestado_Z());
      setgxTv_SdtProfesional_Profesionalfoto_gxi_Z(struct.getProfesionalfoto_gxi_Z());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtProfesional getStruct( )
   {
      com.projectthani.StructSdtProfesional struct = new com.projectthani.StructSdtProfesional ();
      struct.setProfesionalid(getgxTv_SdtProfesional_Profesionalid());
      struct.setProfesionaltipodocumento(getgxTv_SdtProfesional_Profesionaltipodocumento());
      struct.setProfesionalnrodocumento(getgxTv_SdtProfesional_Profesionalnrodocumento());
      struct.setProfesionalapellidopaterno(getgxTv_SdtProfesional_Profesionalapellidopaterno());
      struct.setProfesionalapellidomaterno(getgxTv_SdtProfesional_Profesionalapellidomaterno());
      struct.setProfesionalnombres(getgxTv_SdtProfesional_Profesionalnombres());
      struct.setProfesionalnombrecompleto2(getgxTv_SdtProfesional_Profesionalnombrecompleto2());
      struct.setProfesionalfechanacimiento(getgxTv_SdtProfesional_Profesionalfechanacimiento());
      struct.setProfesionalsexo(getgxTv_SdtProfesional_Profesionalsexo());
      struct.setProfesionaldescripcion(getgxTv_SdtProfesional_Profesionaldescripcion());
      struct.setProfesionalcorreo(getgxTv_SdtProfesional_Profesionalcorreo());
      struct.setProfesionalcop(getgxTv_SdtProfesional_Profesionalcop());
      struct.setProfesionalcolordisponible(getgxTv_SdtProfesional_Profesionalcolordisponible());
      struct.setProfesionalcolorcita(getgxTv_SdtProfesional_Profesionalcolorcita());
      struct.setProfesionaltiempocita(getgxTv_SdtProfesional_Profesionaltiempocita());
      struct.setProfesionaldireccion(getgxTv_SdtProfesional_Profesionaldireccion());
      struct.setPaisid(getgxTv_SdtProfesional_Paisid());
      struct.setPaisdescripcion(getgxTv_SdtProfesional_Paisdescripcion());
      struct.setUbigeocode(getgxTv_SdtProfesional_Ubigeocode());
      struct.setUbigeonombre(getgxTv_SdtProfesional_Ubigeonombre());
      struct.setProfesionalfoto(getgxTv_SdtProfesional_Profesionalfoto());
      struct.setProfesionalfoto_gxi(getgxTv_SdtProfesional_Profesionalfoto_gxi());
      struct.setProfesionaltwitter(getgxTv_SdtProfesional_Profesionaltwitter());
      struct.setProfesionalfacebook(getgxTv_SdtProfesional_Profesionalfacebook());
      struct.setProfesionalinstagram(getgxTv_SdtProfesional_Profesionalinstagram());
      struct.setProfesionallinkedin(getgxTv_SdtProfesional_Profesionallinkedin());
      struct.setProfesionaltelefono(getgxTv_SdtProfesional_Profesionaltelefono());
      struct.setSecuserid(getgxTv_SdtProfesional_Secuserid());
      struct.setProfesionalfecharegistro(getgxTv_SdtProfesional_Profesionalfecharegistro());
      struct.setProfesionalterminoscondiciones(getgxTv_SdtProfesional_Profesionalterminoscondiciones());
      struct.setProfesionalestadocuenta(getgxTv_SdtProfesional_Profesionalestadocuenta());
      struct.setProfesionalestado(getgxTv_SdtProfesional_Profesionalestado());
      struct.setEspecialidad(getgxTv_SdtProfesional_Especialidad().getStruct());
      struct.setEducacion(getgxTv_SdtProfesional_Educacion().getStruct());
      struct.setExperiencialaboral(getgxTv_SdtProfesional_Experiencialaboral().getStruct());
      struct.setPremios(getgxTv_SdtProfesional_Premios().getStruct());
      struct.setServicios(getgxTv_SdtProfesional_Servicios().getStruct());
      struct.setMode(getgxTv_SdtProfesional_Mode());
      struct.setInitialized(getgxTv_SdtProfesional_Initialized());
      struct.setProfesionalid_Z(getgxTv_SdtProfesional_Profesionalid_Z());
      struct.setProfesionaltipodocumento_Z(getgxTv_SdtProfesional_Profesionaltipodocumento_Z());
      struct.setProfesionalnrodocumento_Z(getgxTv_SdtProfesional_Profesionalnrodocumento_Z());
      struct.setProfesionalapellidopaterno_Z(getgxTv_SdtProfesional_Profesionalapellidopaterno_Z());
      struct.setProfesionalapellidomaterno_Z(getgxTv_SdtProfesional_Profesionalapellidomaterno_Z());
      struct.setProfesionalnombres_Z(getgxTv_SdtProfesional_Profesionalnombres_Z());
      struct.setProfesionalnombrecompleto2_Z(getgxTv_SdtProfesional_Profesionalnombrecompleto2_Z());
      struct.setProfesionalfechanacimiento_Z(getgxTv_SdtProfesional_Profesionalfechanacimiento_Z());
      struct.setProfesionalsexo_Z(getgxTv_SdtProfesional_Profesionalsexo_Z());
      struct.setProfesionaldescripcion_Z(getgxTv_SdtProfesional_Profesionaldescripcion_Z());
      struct.setProfesionalcorreo_Z(getgxTv_SdtProfesional_Profesionalcorreo_Z());
      struct.setProfesionalcop_Z(getgxTv_SdtProfesional_Profesionalcop_Z());
      struct.setProfesionalcolordisponible_Z(getgxTv_SdtProfesional_Profesionalcolordisponible_Z());
      struct.setProfesionalcolorcita_Z(getgxTv_SdtProfesional_Profesionalcolorcita_Z());
      struct.setProfesionaltiempocita_Z(getgxTv_SdtProfesional_Profesionaltiempocita_Z());
      struct.setProfesionaldireccion_Z(getgxTv_SdtProfesional_Profesionaldireccion_Z());
      struct.setPaisid_Z(getgxTv_SdtProfesional_Paisid_Z());
      struct.setPaisdescripcion_Z(getgxTv_SdtProfesional_Paisdescripcion_Z());
      struct.setUbigeocode_Z(getgxTv_SdtProfesional_Ubigeocode_Z());
      struct.setUbigeonombre_Z(getgxTv_SdtProfesional_Ubigeonombre_Z());
      struct.setProfesionaltwitter_Z(getgxTv_SdtProfesional_Profesionaltwitter_Z());
      struct.setProfesionalfacebook_Z(getgxTv_SdtProfesional_Profesionalfacebook_Z());
      struct.setProfesionalinstagram_Z(getgxTv_SdtProfesional_Profesionalinstagram_Z());
      struct.setProfesionallinkedin_Z(getgxTv_SdtProfesional_Profesionallinkedin_Z());
      struct.setProfesionaltelefono_Z(getgxTv_SdtProfesional_Profesionaltelefono_Z());
      struct.setSecuserid_Z(getgxTv_SdtProfesional_Secuserid_Z());
      struct.setProfesionalfecharegistro_Z(getgxTv_SdtProfesional_Profesionalfecharegistro_Z());
      struct.setProfesionalterminoscondiciones_Z(getgxTv_SdtProfesional_Profesionalterminoscondiciones_Z());
      struct.setProfesionalestadocuenta_Z(getgxTv_SdtProfesional_Profesionalestadocuenta_Z());
      struct.setProfesionalestado_Z(getgxTv_SdtProfesional_Profesionalestado_Z());
      struct.setProfesionalfoto_gxi_Z(getgxTv_SdtProfesional_Profesionalfoto_gxi_Z());
      return struct ;
   }

   private byte gxTv_SdtProfesional_N ;
   private byte gxTv_SdtProfesional_Profesionaltiempocita ;
   private byte gxTv_SdtProfesional_Profesionaltiempocita_Z ;
   private short gxTv_SdtProfesional_Paisid ;
   private short gxTv_SdtProfesional_Secuserid ;
   private short gxTv_SdtProfesional_Initialized ;
   private short gxTv_SdtProfesional_Paisid_Z ;
   private short gxTv_SdtProfesional_Secuserid_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtProfesional_Profesionalid ;
   private int gxTv_SdtProfesional_Profesionalid_Z ;
   private String gxTv_SdtProfesional_Profesionaltipodocumento ;
   private String gxTv_SdtProfesional_Profesionalsexo ;
   private String gxTv_SdtProfesional_Profesionalcolordisponible ;
   private String gxTv_SdtProfesional_Profesionalcolorcita ;
   private String gxTv_SdtProfesional_Ubigeocode ;
   private String gxTv_SdtProfesional_Profesionaltelefono ;
   private String gxTv_SdtProfesional_Profesionalestadocuenta ;
   private String gxTv_SdtProfesional_Profesionalestado ;
   private String gxTv_SdtProfesional_Mode ;
   private String gxTv_SdtProfesional_Profesionaltipodocumento_Z ;
   private String gxTv_SdtProfesional_Profesionalsexo_Z ;
   private String gxTv_SdtProfesional_Profesionalcolordisponible_Z ;
   private String gxTv_SdtProfesional_Profesionalcolorcita_Z ;
   private String gxTv_SdtProfesional_Ubigeocode_Z ;
   private String gxTv_SdtProfesional_Profesionaltelefono_Z ;
   private String gxTv_SdtProfesional_Profesionalestadocuenta_Z ;
   private String gxTv_SdtProfesional_Profesionalestado_Z ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_SdtProfesional_Profesionalfechanacimiento ;
   private java.util.Date gxTv_SdtProfesional_Profesionalfecharegistro ;
   private java.util.Date gxTv_SdtProfesional_Profesionalfechanacimiento_Z ;
   private java.util.Date gxTv_SdtProfesional_Profesionalfecharegistro_Z ;
   private boolean gxTv_SdtProfesional_Profesionalterminoscondiciones ;
   private boolean gxTv_SdtProfesional_Profesionalterminoscondiciones_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtProfesional_Profesionalnrodocumento ;
   private String gxTv_SdtProfesional_Profesionalapellidopaterno ;
   private String gxTv_SdtProfesional_Profesionalapellidomaterno ;
   private String gxTv_SdtProfesional_Profesionalnombres ;
   private String gxTv_SdtProfesional_Profesionalnombrecompleto2 ;
   private String gxTv_SdtProfesional_Profesionaldescripcion ;
   private String gxTv_SdtProfesional_Profesionalcorreo ;
   private String gxTv_SdtProfesional_Profesionalcop ;
   private String gxTv_SdtProfesional_Profesionaldireccion ;
   private String gxTv_SdtProfesional_Paisdescripcion ;
   private String gxTv_SdtProfesional_Ubigeonombre ;
   private String gxTv_SdtProfesional_Profesionalfoto_gxi ;
   private String gxTv_SdtProfesional_Profesionaltwitter ;
   private String gxTv_SdtProfesional_Profesionalfacebook ;
   private String gxTv_SdtProfesional_Profesionalinstagram ;
   private String gxTv_SdtProfesional_Profesionallinkedin ;
   private String gxTv_SdtProfesional_Profesionalnrodocumento_Z ;
   private String gxTv_SdtProfesional_Profesionalapellidopaterno_Z ;
   private String gxTv_SdtProfesional_Profesionalapellidomaterno_Z ;
   private String gxTv_SdtProfesional_Profesionalnombres_Z ;
   private String gxTv_SdtProfesional_Profesionalnombrecompleto2_Z ;
   private String gxTv_SdtProfesional_Profesionaldescripcion_Z ;
   private String gxTv_SdtProfesional_Profesionalcorreo_Z ;
   private String gxTv_SdtProfesional_Profesionalcop_Z ;
   private String gxTv_SdtProfesional_Profesionaldireccion_Z ;
   private String gxTv_SdtProfesional_Paisdescripcion_Z ;
   private String gxTv_SdtProfesional_Ubigeonombre_Z ;
   private String gxTv_SdtProfesional_Profesionaltwitter_Z ;
   private String gxTv_SdtProfesional_Profesionalfacebook_Z ;
   private String gxTv_SdtProfesional_Profesionalinstagram_Z ;
   private String gxTv_SdtProfesional_Profesionallinkedin_Z ;
   private String gxTv_SdtProfesional_Profesionalfoto_gxi_Z ;
   private String gxTv_SdtProfesional_Profesionalfoto ;
   private GXBCLevelCollection<com.projectthani.SdtProfesional_Especialidad> gxTv_SdtProfesional_Especialidad_aux ;
   private GXBCLevelCollection<com.projectthani.SdtProfesional_Educacion> gxTv_SdtProfesional_Educacion_aux ;
   private GXBCLevelCollection<com.projectthani.SdtProfesional_ExperienciaLaboral> gxTv_SdtProfesional_Experiencialaboral_aux ;
   private GXBCLevelCollection<com.projectthani.SdtProfesional_Premios> gxTv_SdtProfesional_Premios_aux ;
   private GXBCLevelCollection<com.projectthani.SdtProfesional_Servicios> gxTv_SdtProfesional_Servicios_aux ;
   private GXBCLevelCollection<com.projectthani.SdtProfesional_Especialidad> gxTv_SdtProfesional_Especialidad=null ;
   private GXBCLevelCollection<com.projectthani.SdtProfesional_Educacion> gxTv_SdtProfesional_Educacion=null ;
   private GXBCLevelCollection<com.projectthani.SdtProfesional_ExperienciaLaboral> gxTv_SdtProfesional_Experiencialaboral=null ;
   private GXBCLevelCollection<com.projectthani.SdtProfesional_Premios> gxTv_SdtProfesional_Premios=null ;
   private GXBCLevelCollection<com.projectthani.SdtProfesional_Servicios> gxTv_SdtProfesional_Servicios=null ;
}

