package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSede extends GxSilentTrnSdt implements Cloneable, java.io.Serializable
{
   public SdtSede( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtSede.class));
   }

   public SdtSede( int remoteHandle ,
                   ModelContext context )
   {
      super( remoteHandle, context, "SdtSede");
      initialize( remoteHandle) ;
   }

   public SdtSede( int remoteHandle ,
                   StructSdtSede struct )
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

   public void Load( short AV30SedeId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Short.valueOf(AV30SedeId)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"SedeId", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Sede");
      metadata.set("BT", "Sede");
      metadata.set("PK", "[ \"SedeId\" ]");
      metadata.set("PKAssigned", "[ \"SedeId\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"ClinicaId\" ],\"FKMap\":[  ] },{ \"FK\":[ \"UbigeoCode\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "SedeId") )
            {
               gxTv_SdtSede_Sedeid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SedeNombre") )
            {
               gxTv_SdtSede_Sedenombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaId") )
            {
               gxTv_SdtSede_Clinicaid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaRUC") )
            {
               gxTv_SdtSede_Clinicaruc = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaNombreComercial") )
            {
               gxTv_SdtSede_Clinicanombrecomercial = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "UbigeoCode") )
            {
               gxTv_SdtSede_Ubigeocode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "UbigeoNombre") )
            {
               gxTv_SdtSede_Ubigeonombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SedeDireccion") )
            {
               gxTv_SdtSede_Sededireccion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SedeCorreo") )
            {
               gxTv_SdtSede_Sedecorreo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SedeEstado") )
            {
               gxTv_SdtSede_Sedeestado = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SedeTipo") )
            {
               gxTv_SdtSede_Sedetipo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SedeSector") )
            {
               gxTv_SdtSede_Sedesector = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtSede_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtSede_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SedeId_Z") )
            {
               gxTv_SdtSede_Sedeid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SedeNombre_Z") )
            {
               gxTv_SdtSede_Sedenombre_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaId_Z") )
            {
               gxTv_SdtSede_Clinicaid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaRUC_Z") )
            {
               gxTv_SdtSede_Clinicaruc_Z = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaNombreComercial_Z") )
            {
               gxTv_SdtSede_Clinicanombrecomercial_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "UbigeoCode_Z") )
            {
               gxTv_SdtSede_Ubigeocode_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "UbigeoNombre_Z") )
            {
               gxTv_SdtSede_Ubigeonombre_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SedeDireccion_Z") )
            {
               gxTv_SdtSede_Sededireccion_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SedeCorreo_Z") )
            {
               gxTv_SdtSede_Sedecorreo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SedeEstado_Z") )
            {
               gxTv_SdtSede_Sedeestado_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SedeTipo_Z") )
            {
               gxTv_SdtSede_Sedetipo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SedeSector_Z") )
            {
               gxTv_SdtSede_Sedesector_Z = oReader.getValue() ;
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
         sName = "Sede" ;
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
      oWriter.writeElement("SedeId", GXutil.trim( GXutil.str( gxTv_SdtSede_Sedeid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SedeNombre", GXutil.rtrim( gxTv_SdtSede_Sedenombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaId", GXutil.trim( GXutil.str( gxTv_SdtSede_Clinicaid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaRUC", GXutil.trim( GXutil.str( gxTv_SdtSede_Clinicaruc, 11, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaNombreComercial", GXutil.rtrim( gxTv_SdtSede_Clinicanombrecomercial));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("UbigeoCode", GXutil.rtrim( gxTv_SdtSede_Ubigeocode));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("UbigeoNombre", GXutil.rtrim( gxTv_SdtSede_Ubigeonombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SedeDireccion", GXutil.rtrim( gxTv_SdtSede_Sededireccion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SedeCorreo", GXutil.rtrim( gxTv_SdtSede_Sedecorreo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SedeEstado", GXutil.rtrim( gxTv_SdtSede_Sedeestado));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SedeTipo", GXutil.rtrim( gxTv_SdtSede_Sedetipo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SedeSector", GXutil.rtrim( gxTv_SdtSede_Sedesector));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", GXutil.rtrim( gxTv_SdtSede_Mode));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtSede_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SedeId_Z", GXutil.trim( GXutil.str( gxTv_SdtSede_Sedeid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SedeNombre_Z", GXutil.rtrim( gxTv_SdtSede_Sedenombre_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ClinicaId_Z", GXutil.trim( GXutil.str( gxTv_SdtSede_Clinicaid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ClinicaRUC_Z", GXutil.trim( GXutil.str( gxTv_SdtSede_Clinicaruc_Z, 11, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ClinicaNombreComercial_Z", GXutil.rtrim( gxTv_SdtSede_Clinicanombrecomercial_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("UbigeoCode_Z", GXutil.rtrim( gxTv_SdtSede_Ubigeocode_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("UbigeoNombre_Z", GXutil.rtrim( gxTv_SdtSede_Ubigeonombre_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SedeDireccion_Z", GXutil.rtrim( gxTv_SdtSede_Sededireccion_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SedeCorreo_Z", GXutil.rtrim( gxTv_SdtSede_Sedecorreo_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SedeEstado_Z", GXutil.rtrim( gxTv_SdtSede_Sedeestado_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SedeTipo_Z", GXutil.rtrim( gxTv_SdtSede_Sedetipo_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SedeSector_Z", GXutil.rtrim( gxTv_SdtSede_Sedesector_Z));
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
      AddObjectProperty("SedeId", gxTv_SdtSede_Sedeid, false, includeNonInitialized);
      AddObjectProperty("SedeNombre", gxTv_SdtSede_Sedenombre, false, includeNonInitialized);
      AddObjectProperty("ClinicaId", gxTv_SdtSede_Clinicaid, false, includeNonInitialized);
      AddObjectProperty("ClinicaRUC", gxTv_SdtSede_Clinicaruc, false, includeNonInitialized);
      AddObjectProperty("ClinicaNombreComercial", gxTv_SdtSede_Clinicanombrecomercial, false, includeNonInitialized);
      AddObjectProperty("UbigeoCode", gxTv_SdtSede_Ubigeocode, false, includeNonInitialized);
      AddObjectProperty("UbigeoNombre", gxTv_SdtSede_Ubigeonombre, false, includeNonInitialized);
      AddObjectProperty("SedeDireccion", gxTv_SdtSede_Sededireccion, false, includeNonInitialized);
      AddObjectProperty("SedeCorreo", gxTv_SdtSede_Sedecorreo, false, includeNonInitialized);
      AddObjectProperty("SedeEstado", gxTv_SdtSede_Sedeestado, false, includeNonInitialized);
      AddObjectProperty("SedeTipo", gxTv_SdtSede_Sedetipo, false, includeNonInitialized);
      AddObjectProperty("SedeSector", gxTv_SdtSede_Sedesector, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtSede_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtSede_Initialized, false, includeNonInitialized);
         AddObjectProperty("SedeId_Z", gxTv_SdtSede_Sedeid_Z, false, includeNonInitialized);
         AddObjectProperty("SedeNombre_Z", gxTv_SdtSede_Sedenombre_Z, false, includeNonInitialized);
         AddObjectProperty("ClinicaId_Z", gxTv_SdtSede_Clinicaid_Z, false, includeNonInitialized);
         AddObjectProperty("ClinicaRUC_Z", gxTv_SdtSede_Clinicaruc_Z, false, includeNonInitialized);
         AddObjectProperty("ClinicaNombreComercial_Z", gxTv_SdtSede_Clinicanombrecomercial_Z, false, includeNonInitialized);
         AddObjectProperty("UbigeoCode_Z", gxTv_SdtSede_Ubigeocode_Z, false, includeNonInitialized);
         AddObjectProperty("UbigeoNombre_Z", gxTv_SdtSede_Ubigeonombre_Z, false, includeNonInitialized);
         AddObjectProperty("SedeDireccion_Z", gxTv_SdtSede_Sededireccion_Z, false, includeNonInitialized);
         AddObjectProperty("SedeCorreo_Z", gxTv_SdtSede_Sedecorreo_Z, false, includeNonInitialized);
         AddObjectProperty("SedeEstado_Z", gxTv_SdtSede_Sedeestado_Z, false, includeNonInitialized);
         AddObjectProperty("SedeTipo_Z", gxTv_SdtSede_Sedetipo_Z, false, includeNonInitialized);
         AddObjectProperty("SedeSector_Z", gxTv_SdtSede_Sedesector_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.projectthani.SdtSede sdt )
   {
      if ( sdt.IsDirty("SedeId") )
      {
         gxTv_SdtSede_N = (byte)(0) ;
         gxTv_SdtSede_Sedeid = sdt.getgxTv_SdtSede_Sedeid() ;
      }
      if ( sdt.IsDirty("SedeNombre") )
      {
         gxTv_SdtSede_N = (byte)(0) ;
         gxTv_SdtSede_Sedenombre = sdt.getgxTv_SdtSede_Sedenombre() ;
      }
      if ( sdt.IsDirty("ClinicaId") )
      {
         gxTv_SdtSede_N = (byte)(0) ;
         gxTv_SdtSede_Clinicaid = sdt.getgxTv_SdtSede_Clinicaid() ;
      }
      if ( sdt.IsDirty("ClinicaRUC") )
      {
         gxTv_SdtSede_N = (byte)(0) ;
         gxTv_SdtSede_Clinicaruc = sdt.getgxTv_SdtSede_Clinicaruc() ;
      }
      if ( sdt.IsDirty("ClinicaNombreComercial") )
      {
         gxTv_SdtSede_N = (byte)(0) ;
         gxTv_SdtSede_Clinicanombrecomercial = sdt.getgxTv_SdtSede_Clinicanombrecomercial() ;
      }
      if ( sdt.IsDirty("UbigeoCode") )
      {
         gxTv_SdtSede_N = (byte)(0) ;
         gxTv_SdtSede_Ubigeocode = sdt.getgxTv_SdtSede_Ubigeocode() ;
      }
      if ( sdt.IsDirty("UbigeoNombre") )
      {
         gxTv_SdtSede_N = (byte)(0) ;
         gxTv_SdtSede_Ubigeonombre = sdt.getgxTv_SdtSede_Ubigeonombre() ;
      }
      if ( sdt.IsDirty("SedeDireccion") )
      {
         gxTv_SdtSede_N = (byte)(0) ;
         gxTv_SdtSede_Sededireccion = sdt.getgxTv_SdtSede_Sededireccion() ;
      }
      if ( sdt.IsDirty("SedeCorreo") )
      {
         gxTv_SdtSede_N = (byte)(0) ;
         gxTv_SdtSede_Sedecorreo = sdt.getgxTv_SdtSede_Sedecorreo() ;
      }
      if ( sdt.IsDirty("SedeEstado") )
      {
         gxTv_SdtSede_N = (byte)(0) ;
         gxTv_SdtSede_Sedeestado = sdt.getgxTv_SdtSede_Sedeestado() ;
      }
      if ( sdt.IsDirty("SedeTipo") )
      {
         gxTv_SdtSede_N = (byte)(0) ;
         gxTv_SdtSede_Sedetipo = sdt.getgxTv_SdtSede_Sedetipo() ;
      }
      if ( sdt.IsDirty("SedeSector") )
      {
         gxTv_SdtSede_N = (byte)(0) ;
         gxTv_SdtSede_Sedesector = sdt.getgxTv_SdtSede_Sedesector() ;
      }
   }

   public short getgxTv_SdtSede_Sedeid( )
   {
      return gxTv_SdtSede_Sedeid ;
   }

   public void setgxTv_SdtSede_Sedeid( short value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      if ( gxTv_SdtSede_Sedeid != value )
      {
         gxTv_SdtSede_Mode = "INS" ;
         this.setgxTv_SdtSede_Sedeid_Z_SetNull( );
         this.setgxTv_SdtSede_Sedenombre_Z_SetNull( );
         this.setgxTv_SdtSede_Clinicaid_Z_SetNull( );
         this.setgxTv_SdtSede_Clinicaruc_Z_SetNull( );
         this.setgxTv_SdtSede_Clinicanombrecomercial_Z_SetNull( );
         this.setgxTv_SdtSede_Ubigeocode_Z_SetNull( );
         this.setgxTv_SdtSede_Ubigeonombre_Z_SetNull( );
         this.setgxTv_SdtSede_Sededireccion_Z_SetNull( );
         this.setgxTv_SdtSede_Sedecorreo_Z_SetNull( );
         this.setgxTv_SdtSede_Sedeestado_Z_SetNull( );
         this.setgxTv_SdtSede_Sedetipo_Z_SetNull( );
         this.setgxTv_SdtSede_Sedesector_Z_SetNull( );
      }
      SetDirty("Sedeid");
      gxTv_SdtSede_Sedeid = value ;
   }

   public String getgxTv_SdtSede_Sedenombre( )
   {
      return gxTv_SdtSede_Sedenombre ;
   }

   public void setgxTv_SdtSede_Sedenombre( String value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      SetDirty("Sedenombre");
      gxTv_SdtSede_Sedenombre = value ;
   }

   public short getgxTv_SdtSede_Clinicaid( )
   {
      return gxTv_SdtSede_Clinicaid ;
   }

   public void setgxTv_SdtSede_Clinicaid( short value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      SetDirty("Clinicaid");
      gxTv_SdtSede_Clinicaid = value ;
   }

   public long getgxTv_SdtSede_Clinicaruc( )
   {
      return gxTv_SdtSede_Clinicaruc ;
   }

   public void setgxTv_SdtSede_Clinicaruc( long value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      SetDirty("Clinicaruc");
      gxTv_SdtSede_Clinicaruc = value ;
   }

   public String getgxTv_SdtSede_Clinicanombrecomercial( )
   {
      return gxTv_SdtSede_Clinicanombrecomercial ;
   }

   public void setgxTv_SdtSede_Clinicanombrecomercial( String value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      SetDirty("Clinicanombrecomercial");
      gxTv_SdtSede_Clinicanombrecomercial = value ;
   }

   public String getgxTv_SdtSede_Ubigeocode( )
   {
      return gxTv_SdtSede_Ubigeocode ;
   }

   public void setgxTv_SdtSede_Ubigeocode( String value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      SetDirty("Ubigeocode");
      gxTv_SdtSede_Ubigeocode = value ;
   }

   public String getgxTv_SdtSede_Ubigeonombre( )
   {
      return gxTv_SdtSede_Ubigeonombre ;
   }

   public void setgxTv_SdtSede_Ubigeonombre( String value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      SetDirty("Ubigeonombre");
      gxTv_SdtSede_Ubigeonombre = value ;
   }

   public void setgxTv_SdtSede_Ubigeonombre_SetNull( )
   {
      gxTv_SdtSede_Ubigeonombre = "" ;
   }

   public boolean getgxTv_SdtSede_Ubigeonombre_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtSede_Sededireccion( )
   {
      return gxTv_SdtSede_Sededireccion ;
   }

   public void setgxTv_SdtSede_Sededireccion( String value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      SetDirty("Sededireccion");
      gxTv_SdtSede_Sededireccion = value ;
   }

   public String getgxTv_SdtSede_Sedecorreo( )
   {
      return gxTv_SdtSede_Sedecorreo ;
   }

   public void setgxTv_SdtSede_Sedecorreo( String value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      SetDirty("Sedecorreo");
      gxTv_SdtSede_Sedecorreo = value ;
   }

   public String getgxTv_SdtSede_Sedeestado( )
   {
      return gxTv_SdtSede_Sedeestado ;
   }

   public void setgxTv_SdtSede_Sedeestado( String value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      SetDirty("Sedeestado");
      gxTv_SdtSede_Sedeestado = value ;
   }

   public String getgxTv_SdtSede_Sedetipo( )
   {
      return gxTv_SdtSede_Sedetipo ;
   }

   public void setgxTv_SdtSede_Sedetipo( String value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      SetDirty("Sedetipo");
      gxTv_SdtSede_Sedetipo = value ;
   }

   public String getgxTv_SdtSede_Sedesector( )
   {
      return gxTv_SdtSede_Sedesector ;
   }

   public void setgxTv_SdtSede_Sedesector( String value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      SetDirty("Sedesector");
      gxTv_SdtSede_Sedesector = value ;
   }

   public String getgxTv_SdtSede_Mode( )
   {
      return gxTv_SdtSede_Mode ;
   }

   public void setgxTv_SdtSede_Mode( String value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtSede_Mode = value ;
   }

   public void setgxTv_SdtSede_Mode_SetNull( )
   {
      gxTv_SdtSede_Mode = "" ;
   }

   public boolean getgxTv_SdtSede_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtSede_Initialized( )
   {
      return gxTv_SdtSede_Initialized ;
   }

   public void setgxTv_SdtSede_Initialized( short value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtSede_Initialized = value ;
   }

   public void setgxTv_SdtSede_Initialized_SetNull( )
   {
      gxTv_SdtSede_Initialized = (short)(0) ;
   }

   public boolean getgxTv_SdtSede_Initialized_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtSede_Sedeid_Z( )
   {
      return gxTv_SdtSede_Sedeid_Z ;
   }

   public void setgxTv_SdtSede_Sedeid_Z( short value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      SetDirty("Sedeid_Z");
      gxTv_SdtSede_Sedeid_Z = value ;
   }

   public void setgxTv_SdtSede_Sedeid_Z_SetNull( )
   {
      gxTv_SdtSede_Sedeid_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtSede_Sedeid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtSede_Sedenombre_Z( )
   {
      return gxTv_SdtSede_Sedenombre_Z ;
   }

   public void setgxTv_SdtSede_Sedenombre_Z( String value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      SetDirty("Sedenombre_Z");
      gxTv_SdtSede_Sedenombre_Z = value ;
   }

   public void setgxTv_SdtSede_Sedenombre_Z_SetNull( )
   {
      gxTv_SdtSede_Sedenombre_Z = "" ;
   }

   public boolean getgxTv_SdtSede_Sedenombre_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtSede_Clinicaid_Z( )
   {
      return gxTv_SdtSede_Clinicaid_Z ;
   }

   public void setgxTv_SdtSede_Clinicaid_Z( short value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      SetDirty("Clinicaid_Z");
      gxTv_SdtSede_Clinicaid_Z = value ;
   }

   public void setgxTv_SdtSede_Clinicaid_Z_SetNull( )
   {
      gxTv_SdtSede_Clinicaid_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtSede_Clinicaid_Z_IsNull( )
   {
      return false ;
   }

   public long getgxTv_SdtSede_Clinicaruc_Z( )
   {
      return gxTv_SdtSede_Clinicaruc_Z ;
   }

   public void setgxTv_SdtSede_Clinicaruc_Z( long value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      SetDirty("Clinicaruc_Z");
      gxTv_SdtSede_Clinicaruc_Z = value ;
   }

   public void setgxTv_SdtSede_Clinicaruc_Z_SetNull( )
   {
      gxTv_SdtSede_Clinicaruc_Z = 0 ;
   }

   public boolean getgxTv_SdtSede_Clinicaruc_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtSede_Clinicanombrecomercial_Z( )
   {
      return gxTv_SdtSede_Clinicanombrecomercial_Z ;
   }

   public void setgxTv_SdtSede_Clinicanombrecomercial_Z( String value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      SetDirty("Clinicanombrecomercial_Z");
      gxTv_SdtSede_Clinicanombrecomercial_Z = value ;
   }

   public void setgxTv_SdtSede_Clinicanombrecomercial_Z_SetNull( )
   {
      gxTv_SdtSede_Clinicanombrecomercial_Z = "" ;
   }

   public boolean getgxTv_SdtSede_Clinicanombrecomercial_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtSede_Ubigeocode_Z( )
   {
      return gxTv_SdtSede_Ubigeocode_Z ;
   }

   public void setgxTv_SdtSede_Ubigeocode_Z( String value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      SetDirty("Ubigeocode_Z");
      gxTv_SdtSede_Ubigeocode_Z = value ;
   }

   public void setgxTv_SdtSede_Ubigeocode_Z_SetNull( )
   {
      gxTv_SdtSede_Ubigeocode_Z = "" ;
   }

   public boolean getgxTv_SdtSede_Ubigeocode_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtSede_Ubigeonombre_Z( )
   {
      return gxTv_SdtSede_Ubigeonombre_Z ;
   }

   public void setgxTv_SdtSede_Ubigeonombre_Z( String value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      SetDirty("Ubigeonombre_Z");
      gxTv_SdtSede_Ubigeonombre_Z = value ;
   }

   public void setgxTv_SdtSede_Ubigeonombre_Z_SetNull( )
   {
      gxTv_SdtSede_Ubigeonombre_Z = "" ;
   }

   public boolean getgxTv_SdtSede_Ubigeonombre_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtSede_Sededireccion_Z( )
   {
      return gxTv_SdtSede_Sededireccion_Z ;
   }

   public void setgxTv_SdtSede_Sededireccion_Z( String value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      SetDirty("Sededireccion_Z");
      gxTv_SdtSede_Sededireccion_Z = value ;
   }

   public void setgxTv_SdtSede_Sededireccion_Z_SetNull( )
   {
      gxTv_SdtSede_Sededireccion_Z = "" ;
   }

   public boolean getgxTv_SdtSede_Sededireccion_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtSede_Sedecorreo_Z( )
   {
      return gxTv_SdtSede_Sedecorreo_Z ;
   }

   public void setgxTv_SdtSede_Sedecorreo_Z( String value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      SetDirty("Sedecorreo_Z");
      gxTv_SdtSede_Sedecorreo_Z = value ;
   }

   public void setgxTv_SdtSede_Sedecorreo_Z_SetNull( )
   {
      gxTv_SdtSede_Sedecorreo_Z = "" ;
   }

   public boolean getgxTv_SdtSede_Sedecorreo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtSede_Sedeestado_Z( )
   {
      return gxTv_SdtSede_Sedeestado_Z ;
   }

   public void setgxTv_SdtSede_Sedeestado_Z( String value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      SetDirty("Sedeestado_Z");
      gxTv_SdtSede_Sedeestado_Z = value ;
   }

   public void setgxTv_SdtSede_Sedeestado_Z_SetNull( )
   {
      gxTv_SdtSede_Sedeestado_Z = "" ;
   }

   public boolean getgxTv_SdtSede_Sedeestado_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtSede_Sedetipo_Z( )
   {
      return gxTv_SdtSede_Sedetipo_Z ;
   }

   public void setgxTv_SdtSede_Sedetipo_Z( String value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      SetDirty("Sedetipo_Z");
      gxTv_SdtSede_Sedetipo_Z = value ;
   }

   public void setgxTv_SdtSede_Sedetipo_Z_SetNull( )
   {
      gxTv_SdtSede_Sedetipo_Z = "" ;
   }

   public boolean getgxTv_SdtSede_Sedetipo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtSede_Sedesector_Z( )
   {
      return gxTv_SdtSede_Sedesector_Z ;
   }

   public void setgxTv_SdtSede_Sedesector_Z( String value )
   {
      gxTv_SdtSede_N = (byte)(0) ;
      SetDirty("Sedesector_Z");
      gxTv_SdtSede_Sedesector_Z = value ;
   }

   public void setgxTv_SdtSede_Sedesector_Z_SetNull( )
   {
      gxTv_SdtSede_Sedesector_Z = "" ;
   }

   public boolean getgxTv_SdtSede_Sedesector_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.projectthani.sede_bc obj;
      obj = new com.projectthani.sede_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtSede_N = (byte)(1) ;
      gxTv_SdtSede_Sedenombre = "" ;
      gxTv_SdtSede_Clinicanombrecomercial = "" ;
      gxTv_SdtSede_Ubigeocode = "" ;
      gxTv_SdtSede_Ubigeonombre = "" ;
      gxTv_SdtSede_Sededireccion = "" ;
      gxTv_SdtSede_Sedecorreo = "" ;
      gxTv_SdtSede_Sedeestado = "" ;
      gxTv_SdtSede_Sedetipo = "" ;
      gxTv_SdtSede_Sedesector = "" ;
      gxTv_SdtSede_Mode = "" ;
      gxTv_SdtSede_Sedenombre_Z = "" ;
      gxTv_SdtSede_Clinicanombrecomercial_Z = "" ;
      gxTv_SdtSede_Ubigeocode_Z = "" ;
      gxTv_SdtSede_Ubigeonombre_Z = "" ;
      gxTv_SdtSede_Sededireccion_Z = "" ;
      gxTv_SdtSede_Sedecorreo_Z = "" ;
      gxTv_SdtSede_Sedeestado_Z = "" ;
      gxTv_SdtSede_Sedetipo_Z = "" ;
      gxTv_SdtSede_Sedesector_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSede_N ;
   }

   public com.projectthani.SdtSede Clone( )
   {
      com.projectthani.SdtSede sdt;
      com.projectthani.sede_bc obj;
      sdt = (com.projectthani.SdtSede)(clone()) ;
      obj = (com.projectthani.sede_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.projectthani.StructSdtSede struct )
   {
      setgxTv_SdtSede_Sedeid(struct.getSedeid());
      setgxTv_SdtSede_Sedenombre(struct.getSedenombre());
      setgxTv_SdtSede_Clinicaid(struct.getClinicaid());
      setgxTv_SdtSede_Clinicaruc(struct.getClinicaruc());
      setgxTv_SdtSede_Clinicanombrecomercial(struct.getClinicanombrecomercial());
      setgxTv_SdtSede_Ubigeocode(struct.getUbigeocode());
      setgxTv_SdtSede_Ubigeonombre(struct.getUbigeonombre());
      setgxTv_SdtSede_Sededireccion(struct.getSededireccion());
      setgxTv_SdtSede_Sedecorreo(struct.getSedecorreo());
      setgxTv_SdtSede_Sedeestado(struct.getSedeestado());
      setgxTv_SdtSede_Sedetipo(struct.getSedetipo());
      setgxTv_SdtSede_Sedesector(struct.getSedesector());
      setgxTv_SdtSede_Mode(struct.getMode());
      setgxTv_SdtSede_Initialized(struct.getInitialized());
      setgxTv_SdtSede_Sedeid_Z(struct.getSedeid_Z());
      setgxTv_SdtSede_Sedenombre_Z(struct.getSedenombre_Z());
      setgxTv_SdtSede_Clinicaid_Z(struct.getClinicaid_Z());
      setgxTv_SdtSede_Clinicaruc_Z(struct.getClinicaruc_Z());
      setgxTv_SdtSede_Clinicanombrecomercial_Z(struct.getClinicanombrecomercial_Z());
      setgxTv_SdtSede_Ubigeocode_Z(struct.getUbigeocode_Z());
      setgxTv_SdtSede_Ubigeonombre_Z(struct.getUbigeonombre_Z());
      setgxTv_SdtSede_Sededireccion_Z(struct.getSededireccion_Z());
      setgxTv_SdtSede_Sedecorreo_Z(struct.getSedecorreo_Z());
      setgxTv_SdtSede_Sedeestado_Z(struct.getSedeestado_Z());
      setgxTv_SdtSede_Sedetipo_Z(struct.getSedetipo_Z());
      setgxTv_SdtSede_Sedesector_Z(struct.getSedesector_Z());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSede getStruct( )
   {
      com.projectthani.StructSdtSede struct = new com.projectthani.StructSdtSede ();
      struct.setSedeid(getgxTv_SdtSede_Sedeid());
      struct.setSedenombre(getgxTv_SdtSede_Sedenombre());
      struct.setClinicaid(getgxTv_SdtSede_Clinicaid());
      struct.setClinicaruc(getgxTv_SdtSede_Clinicaruc());
      struct.setClinicanombrecomercial(getgxTv_SdtSede_Clinicanombrecomercial());
      struct.setUbigeocode(getgxTv_SdtSede_Ubigeocode());
      struct.setUbigeonombre(getgxTv_SdtSede_Ubigeonombre());
      struct.setSededireccion(getgxTv_SdtSede_Sededireccion());
      struct.setSedecorreo(getgxTv_SdtSede_Sedecorreo());
      struct.setSedeestado(getgxTv_SdtSede_Sedeestado());
      struct.setSedetipo(getgxTv_SdtSede_Sedetipo());
      struct.setSedesector(getgxTv_SdtSede_Sedesector());
      struct.setMode(getgxTv_SdtSede_Mode());
      struct.setInitialized(getgxTv_SdtSede_Initialized());
      struct.setSedeid_Z(getgxTv_SdtSede_Sedeid_Z());
      struct.setSedenombre_Z(getgxTv_SdtSede_Sedenombre_Z());
      struct.setClinicaid_Z(getgxTv_SdtSede_Clinicaid_Z());
      struct.setClinicaruc_Z(getgxTv_SdtSede_Clinicaruc_Z());
      struct.setClinicanombrecomercial_Z(getgxTv_SdtSede_Clinicanombrecomercial_Z());
      struct.setUbigeocode_Z(getgxTv_SdtSede_Ubigeocode_Z());
      struct.setUbigeonombre_Z(getgxTv_SdtSede_Ubigeonombre_Z());
      struct.setSededireccion_Z(getgxTv_SdtSede_Sededireccion_Z());
      struct.setSedecorreo_Z(getgxTv_SdtSede_Sedecorreo_Z());
      struct.setSedeestado_Z(getgxTv_SdtSede_Sedeestado_Z());
      struct.setSedetipo_Z(getgxTv_SdtSede_Sedetipo_Z());
      struct.setSedesector_Z(getgxTv_SdtSede_Sedesector_Z());
      return struct ;
   }

   private byte gxTv_SdtSede_N ;
   private short gxTv_SdtSede_Sedeid ;
   private short gxTv_SdtSede_Clinicaid ;
   private short gxTv_SdtSede_Initialized ;
   private short gxTv_SdtSede_Sedeid_Z ;
   private short gxTv_SdtSede_Clinicaid_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private long gxTv_SdtSede_Clinicaruc ;
   private long gxTv_SdtSede_Clinicaruc_Z ;
   private String gxTv_SdtSede_Ubigeocode ;
   private String gxTv_SdtSede_Sedeestado ;
   private String gxTv_SdtSede_Sedetipo ;
   private String gxTv_SdtSede_Sedesector ;
   private String gxTv_SdtSede_Mode ;
   private String gxTv_SdtSede_Ubigeocode_Z ;
   private String gxTv_SdtSede_Sedeestado_Z ;
   private String gxTv_SdtSede_Sedetipo_Z ;
   private String gxTv_SdtSede_Sedesector_Z ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtSede_Sedenombre ;
   private String gxTv_SdtSede_Clinicanombrecomercial ;
   private String gxTv_SdtSede_Ubigeonombre ;
   private String gxTv_SdtSede_Sededireccion ;
   private String gxTv_SdtSede_Sedecorreo ;
   private String gxTv_SdtSede_Sedenombre_Z ;
   private String gxTv_SdtSede_Clinicanombrecomercial_Z ;
   private String gxTv_SdtSede_Ubigeonombre_Z ;
   private String gxTv_SdtSede_Sededireccion_Z ;
   private String gxTv_SdtSede_Sedecorreo_Z ;
}

