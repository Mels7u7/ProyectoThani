package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtProfesional_Especialidad_Sede extends GxSilentTrnSdt implements Cloneable, java.io.Serializable
{
   public SdtProfesional_Especialidad_Sede( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtProfesional_Especialidad_Sede.class));
   }

   public SdtProfesional_Especialidad_Sede( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle, context, "SdtProfesional_Especialidad_Sede");
      initialize( remoteHandle) ;
   }

   public SdtProfesional_Especialidad_Sede( int remoteHandle ,
                                            StructSdtProfesional_Especialidad_Sede struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtProfesional_Especialidad_Sede( )
   {
      super( new ModelContext(SdtProfesional_Especialidad_Sede.class), "SdtProfesional_Especialidad_Sede");
      initialize( ) ;
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"SedeId", short.class}, new Object[]{"SedeTipoConsulta", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Sede");
      metadata.set("BT", "ProfesionalEspecialidadSede");
      metadata.set("PK", "[ \"SedeId\",\"SedeTipoConsulta\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"ProfesionalId\",\"EspecialidadId\" ],\"FKMap\":[  ] },{ \"FK\":[ \"SedeId\" ],\"FKMap\":[  ] } ]");
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
               gxTv_SdtProfesional_Especialidad_Sede_Sedeid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SedeTipoConsulta") )
            {
               gxTv_SdtProfesional_Especialidad_Sede_Sedetipoconsulta = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SedeNombre") )
            {
               gxTv_SdtProfesional_Especialidad_Sede_Sedenombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaNombreAbreviado") )
            {
               gxTv_SdtProfesional_Especialidad_Sede_Clinicanombreabreviado = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CostoConsulta") )
            {
               gxTv_SdtProfesional_Especialidad_Sede_Costoconsulta = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtProfesional_Especialidad_Sede_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtProfesional_Especialidad_Sede_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtProfesional_Especialidad_Sede_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SedeId_Z") )
            {
               gxTv_SdtProfesional_Especialidad_Sede_Sedeid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SedeTipoConsulta_Z") )
            {
               gxTv_SdtProfesional_Especialidad_Sede_Sedetipoconsulta_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SedeNombre_Z") )
            {
               gxTv_SdtProfesional_Especialidad_Sede_Sedenombre_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaNombreAbreviado_Z") )
            {
               gxTv_SdtProfesional_Especialidad_Sede_Clinicanombreabreviado_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CostoConsulta_Z") )
            {
               gxTv_SdtProfesional_Especialidad_Sede_Costoconsulta_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
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
         sName = "Profesional.Especialidad.Sede" ;
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
      oWriter.writeElement("SedeId", GXutil.trim( GXutil.str( gxTv_SdtProfesional_Especialidad_Sede_Sedeid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SedeTipoConsulta", GXutil.rtrim( gxTv_SdtProfesional_Especialidad_Sede_Sedetipoconsulta));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SedeNombre", GXutil.rtrim( gxTv_SdtProfesional_Especialidad_Sede_Sedenombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaNombreAbreviado", GXutil.rtrim( gxTv_SdtProfesional_Especialidad_Sede_Clinicanombreabreviado));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CostoConsulta", GXutil.trim( GXutil.strNoRound( gxTv_SdtProfesional_Especialidad_Sede_Costoconsulta, 6, 2)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", GXutil.rtrim( gxTv_SdtProfesional_Especialidad_Sede_Mode));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtProfesional_Especialidad_Sede_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtProfesional_Especialidad_Sede_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SedeId_Z", GXutil.trim( GXutil.str( gxTv_SdtProfesional_Especialidad_Sede_Sedeid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SedeTipoConsulta_Z", GXutil.rtrim( gxTv_SdtProfesional_Especialidad_Sede_Sedetipoconsulta_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SedeNombre_Z", GXutil.rtrim( gxTv_SdtProfesional_Especialidad_Sede_Sedenombre_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ClinicaNombreAbreviado_Z", GXutil.rtrim( gxTv_SdtProfesional_Especialidad_Sede_Clinicanombreabreviado_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CostoConsulta_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtProfesional_Especialidad_Sede_Costoconsulta_Z, 6, 2)));
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
      AddObjectProperty("SedeId", gxTv_SdtProfesional_Especialidad_Sede_Sedeid, false, includeNonInitialized);
      AddObjectProperty("SedeTipoConsulta", gxTv_SdtProfesional_Especialidad_Sede_Sedetipoconsulta, false, includeNonInitialized);
      AddObjectProperty("SedeNombre", gxTv_SdtProfesional_Especialidad_Sede_Sedenombre, false, includeNonInitialized);
      AddObjectProperty("ClinicaNombreAbreviado", gxTv_SdtProfesional_Especialidad_Sede_Clinicanombreabreviado, false, includeNonInitialized);
      AddObjectProperty("CostoConsulta", gxTv_SdtProfesional_Especialidad_Sede_Costoconsulta, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtProfesional_Especialidad_Sede_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtProfesional_Especialidad_Sede_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtProfesional_Especialidad_Sede_Initialized, false, includeNonInitialized);
         AddObjectProperty("SedeId_Z", gxTv_SdtProfesional_Especialidad_Sede_Sedeid_Z, false, includeNonInitialized);
         AddObjectProperty("SedeTipoConsulta_Z", gxTv_SdtProfesional_Especialidad_Sede_Sedetipoconsulta_Z, false, includeNonInitialized);
         AddObjectProperty("SedeNombre_Z", gxTv_SdtProfesional_Especialidad_Sede_Sedenombre_Z, false, includeNonInitialized);
         AddObjectProperty("ClinicaNombreAbreviado_Z", gxTv_SdtProfesional_Especialidad_Sede_Clinicanombreabreviado_Z, false, includeNonInitialized);
         AddObjectProperty("CostoConsulta_Z", gxTv_SdtProfesional_Especialidad_Sede_Costoconsulta_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.projectthani.SdtProfesional_Especialidad_Sede sdt )
   {
      if ( sdt.IsDirty("SedeId") )
      {
         gxTv_SdtProfesional_Especialidad_Sede_N = (byte)(0) ;
         gxTv_SdtProfesional_Especialidad_Sede_Sedeid = sdt.getgxTv_SdtProfesional_Especialidad_Sede_Sedeid() ;
      }
      if ( sdt.IsDirty("SedeTipoConsulta") )
      {
         gxTv_SdtProfesional_Especialidad_Sede_N = (byte)(0) ;
         gxTv_SdtProfesional_Especialidad_Sede_Sedetipoconsulta = sdt.getgxTv_SdtProfesional_Especialidad_Sede_Sedetipoconsulta() ;
      }
      if ( sdt.IsDirty("SedeNombre") )
      {
         gxTv_SdtProfesional_Especialidad_Sede_N = (byte)(0) ;
         gxTv_SdtProfesional_Especialidad_Sede_Sedenombre = sdt.getgxTv_SdtProfesional_Especialidad_Sede_Sedenombre() ;
      }
      if ( sdt.IsDirty("ClinicaNombreAbreviado") )
      {
         gxTv_SdtProfesional_Especialidad_Sede_N = (byte)(0) ;
         gxTv_SdtProfesional_Especialidad_Sede_Clinicanombreabreviado = sdt.getgxTv_SdtProfesional_Especialidad_Sede_Clinicanombreabreviado() ;
      }
      if ( sdt.IsDirty("CostoConsulta") )
      {
         gxTv_SdtProfesional_Especialidad_Sede_N = (byte)(0) ;
         gxTv_SdtProfesional_Especialidad_Sede_Costoconsulta = sdt.getgxTv_SdtProfesional_Especialidad_Sede_Costoconsulta() ;
      }
   }

   public short getgxTv_SdtProfesional_Especialidad_Sede_Sedeid( )
   {
      return gxTv_SdtProfesional_Especialidad_Sede_Sedeid ;
   }

   public void setgxTv_SdtProfesional_Especialidad_Sede_Sedeid( short value )
   {
      gxTv_SdtProfesional_Especialidad_Sede_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad_Sede_Modified = (short)(1) ;
      SetDirty("Sedeid");
      gxTv_SdtProfesional_Especialidad_Sede_Sedeid = value ;
   }

   public String getgxTv_SdtProfesional_Especialidad_Sede_Sedetipoconsulta( )
   {
      return gxTv_SdtProfesional_Especialidad_Sede_Sedetipoconsulta ;
   }

   public void setgxTv_SdtProfesional_Especialidad_Sede_Sedetipoconsulta( String value )
   {
      gxTv_SdtProfesional_Especialidad_Sede_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad_Sede_Modified = (short)(1) ;
      SetDirty("Sedetipoconsulta");
      gxTv_SdtProfesional_Especialidad_Sede_Sedetipoconsulta = value ;
   }

   public String getgxTv_SdtProfesional_Especialidad_Sede_Sedenombre( )
   {
      return gxTv_SdtProfesional_Especialidad_Sede_Sedenombre ;
   }

   public void setgxTv_SdtProfesional_Especialidad_Sede_Sedenombre( String value )
   {
      gxTv_SdtProfesional_Especialidad_Sede_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad_Sede_Modified = (short)(1) ;
      SetDirty("Sedenombre");
      gxTv_SdtProfesional_Especialidad_Sede_Sedenombre = value ;
   }

   public String getgxTv_SdtProfesional_Especialidad_Sede_Clinicanombreabreviado( )
   {
      return gxTv_SdtProfesional_Especialidad_Sede_Clinicanombreabreviado ;
   }

   public void setgxTv_SdtProfesional_Especialidad_Sede_Clinicanombreabreviado( String value )
   {
      gxTv_SdtProfesional_Especialidad_Sede_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad_Sede_Modified = (short)(1) ;
      SetDirty("Clinicanombreabreviado");
      gxTv_SdtProfesional_Especialidad_Sede_Clinicanombreabreviado = value ;
   }

   public java.math.BigDecimal getgxTv_SdtProfesional_Especialidad_Sede_Costoconsulta( )
   {
      return gxTv_SdtProfesional_Especialidad_Sede_Costoconsulta ;
   }

   public void setgxTv_SdtProfesional_Especialidad_Sede_Costoconsulta( java.math.BigDecimal value )
   {
      gxTv_SdtProfesional_Especialidad_Sede_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad_Sede_Modified = (short)(1) ;
      SetDirty("Costoconsulta");
      gxTv_SdtProfesional_Especialidad_Sede_Costoconsulta = value ;
   }

   public String getgxTv_SdtProfesional_Especialidad_Sede_Mode( )
   {
      return gxTv_SdtProfesional_Especialidad_Sede_Mode ;
   }

   public void setgxTv_SdtProfesional_Especialidad_Sede_Mode( String value )
   {
      gxTv_SdtProfesional_Especialidad_Sede_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtProfesional_Especialidad_Sede_Mode = value ;
   }

   public void setgxTv_SdtProfesional_Especialidad_Sede_Mode_SetNull( )
   {
      gxTv_SdtProfesional_Especialidad_Sede_Mode = "" ;
   }

   public boolean getgxTv_SdtProfesional_Especialidad_Sede_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtProfesional_Especialidad_Sede_Modified( )
   {
      return gxTv_SdtProfesional_Especialidad_Sede_Modified ;
   }

   public void setgxTv_SdtProfesional_Especialidad_Sede_Modified( short value )
   {
      gxTv_SdtProfesional_Especialidad_Sede_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtProfesional_Especialidad_Sede_Modified = value ;
   }

   public void setgxTv_SdtProfesional_Especialidad_Sede_Modified_SetNull( )
   {
      gxTv_SdtProfesional_Especialidad_Sede_Modified = (short)(0) ;
   }

   public boolean getgxTv_SdtProfesional_Especialidad_Sede_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtProfesional_Especialidad_Sede_Initialized( )
   {
      return gxTv_SdtProfesional_Especialidad_Sede_Initialized ;
   }

   public void setgxTv_SdtProfesional_Especialidad_Sede_Initialized( short value )
   {
      gxTv_SdtProfesional_Especialidad_Sede_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad_Sede_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtProfesional_Especialidad_Sede_Initialized = value ;
   }

   public void setgxTv_SdtProfesional_Especialidad_Sede_Initialized_SetNull( )
   {
      gxTv_SdtProfesional_Especialidad_Sede_Initialized = (short)(0) ;
   }

   public boolean getgxTv_SdtProfesional_Especialidad_Sede_Initialized_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtProfesional_Especialidad_Sede_Sedeid_Z( )
   {
      return gxTv_SdtProfesional_Especialidad_Sede_Sedeid_Z ;
   }

   public void setgxTv_SdtProfesional_Especialidad_Sede_Sedeid_Z( short value )
   {
      gxTv_SdtProfesional_Especialidad_Sede_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad_Sede_Modified = (short)(1) ;
      SetDirty("Sedeid_Z");
      gxTv_SdtProfesional_Especialidad_Sede_Sedeid_Z = value ;
   }

   public void setgxTv_SdtProfesional_Especialidad_Sede_Sedeid_Z_SetNull( )
   {
      gxTv_SdtProfesional_Especialidad_Sede_Sedeid_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtProfesional_Especialidad_Sede_Sedeid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtProfesional_Especialidad_Sede_Sedetipoconsulta_Z( )
   {
      return gxTv_SdtProfesional_Especialidad_Sede_Sedetipoconsulta_Z ;
   }

   public void setgxTv_SdtProfesional_Especialidad_Sede_Sedetipoconsulta_Z( String value )
   {
      gxTv_SdtProfesional_Especialidad_Sede_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad_Sede_Modified = (short)(1) ;
      SetDirty("Sedetipoconsulta_Z");
      gxTv_SdtProfesional_Especialidad_Sede_Sedetipoconsulta_Z = value ;
   }

   public void setgxTv_SdtProfesional_Especialidad_Sede_Sedetipoconsulta_Z_SetNull( )
   {
      gxTv_SdtProfesional_Especialidad_Sede_Sedetipoconsulta_Z = "" ;
   }

   public boolean getgxTv_SdtProfesional_Especialidad_Sede_Sedetipoconsulta_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtProfesional_Especialidad_Sede_Sedenombre_Z( )
   {
      return gxTv_SdtProfesional_Especialidad_Sede_Sedenombre_Z ;
   }

   public void setgxTv_SdtProfesional_Especialidad_Sede_Sedenombre_Z( String value )
   {
      gxTv_SdtProfesional_Especialidad_Sede_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad_Sede_Modified = (short)(1) ;
      SetDirty("Sedenombre_Z");
      gxTv_SdtProfesional_Especialidad_Sede_Sedenombre_Z = value ;
   }

   public void setgxTv_SdtProfesional_Especialidad_Sede_Sedenombre_Z_SetNull( )
   {
      gxTv_SdtProfesional_Especialidad_Sede_Sedenombre_Z = "" ;
   }

   public boolean getgxTv_SdtProfesional_Especialidad_Sede_Sedenombre_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtProfesional_Especialidad_Sede_Clinicanombreabreviado_Z( )
   {
      return gxTv_SdtProfesional_Especialidad_Sede_Clinicanombreabreviado_Z ;
   }

   public void setgxTv_SdtProfesional_Especialidad_Sede_Clinicanombreabreviado_Z( String value )
   {
      gxTv_SdtProfesional_Especialidad_Sede_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad_Sede_Modified = (short)(1) ;
      SetDirty("Clinicanombreabreviado_Z");
      gxTv_SdtProfesional_Especialidad_Sede_Clinicanombreabreviado_Z = value ;
   }

   public void setgxTv_SdtProfesional_Especialidad_Sede_Clinicanombreabreviado_Z_SetNull( )
   {
      gxTv_SdtProfesional_Especialidad_Sede_Clinicanombreabreviado_Z = "" ;
   }

   public boolean getgxTv_SdtProfesional_Especialidad_Sede_Clinicanombreabreviado_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtProfesional_Especialidad_Sede_Costoconsulta_Z( )
   {
      return gxTv_SdtProfesional_Especialidad_Sede_Costoconsulta_Z ;
   }

   public void setgxTv_SdtProfesional_Especialidad_Sede_Costoconsulta_Z( java.math.BigDecimal value )
   {
      gxTv_SdtProfesional_Especialidad_Sede_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad_Sede_Modified = (short)(1) ;
      SetDirty("Costoconsulta_Z");
      gxTv_SdtProfesional_Especialidad_Sede_Costoconsulta_Z = value ;
   }

   public void setgxTv_SdtProfesional_Especialidad_Sede_Costoconsulta_Z_SetNull( )
   {
      gxTv_SdtProfesional_Especialidad_Sede_Costoconsulta_Z = DecimalUtil.ZERO ;
   }

   public boolean getgxTv_SdtProfesional_Especialidad_Sede_Costoconsulta_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtProfesional_Especialidad_Sede_N = (byte)(1) ;
      gxTv_SdtProfesional_Especialidad_Sede_Sedetipoconsulta = "" ;
      gxTv_SdtProfesional_Especialidad_Sede_Sedenombre = "" ;
      gxTv_SdtProfesional_Especialidad_Sede_Clinicanombreabreviado = "" ;
      gxTv_SdtProfesional_Especialidad_Sede_Costoconsulta = DecimalUtil.stringToDec("0.00") ;
      gxTv_SdtProfesional_Especialidad_Sede_Mode = "" ;
      gxTv_SdtProfesional_Especialidad_Sede_Sedetipoconsulta_Z = "" ;
      gxTv_SdtProfesional_Especialidad_Sede_Sedenombre_Z = "" ;
      gxTv_SdtProfesional_Especialidad_Sede_Clinicanombreabreviado_Z = "" ;
      gxTv_SdtProfesional_Especialidad_Sede_Costoconsulta_Z = DecimalUtil.ZERO ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtProfesional_Especialidad_Sede_N ;
   }

   public com.projectthani.SdtProfesional_Especialidad_Sede Clone( )
   {
      return (com.projectthani.SdtProfesional_Especialidad_Sede)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtProfesional_Especialidad_Sede struct )
   {
      setgxTv_SdtProfesional_Especialidad_Sede_Sedeid(struct.getSedeid());
      setgxTv_SdtProfesional_Especialidad_Sede_Sedetipoconsulta(struct.getSedetipoconsulta());
      setgxTv_SdtProfesional_Especialidad_Sede_Sedenombre(struct.getSedenombre());
      setgxTv_SdtProfesional_Especialidad_Sede_Clinicanombreabreviado(struct.getClinicanombreabreviado());
      setgxTv_SdtProfesional_Especialidad_Sede_Costoconsulta(struct.getCostoconsulta());
      setgxTv_SdtProfesional_Especialidad_Sede_Mode(struct.getMode());
      setgxTv_SdtProfesional_Especialidad_Sede_Modified(struct.getModified());
      setgxTv_SdtProfesional_Especialidad_Sede_Initialized(struct.getInitialized());
      setgxTv_SdtProfesional_Especialidad_Sede_Sedeid_Z(struct.getSedeid_Z());
      setgxTv_SdtProfesional_Especialidad_Sede_Sedetipoconsulta_Z(struct.getSedetipoconsulta_Z());
      setgxTv_SdtProfesional_Especialidad_Sede_Sedenombre_Z(struct.getSedenombre_Z());
      setgxTv_SdtProfesional_Especialidad_Sede_Clinicanombreabreviado_Z(struct.getClinicanombreabreviado_Z());
      setgxTv_SdtProfesional_Especialidad_Sede_Costoconsulta_Z(struct.getCostoconsulta_Z());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtProfesional_Especialidad_Sede getStruct( )
   {
      com.projectthani.StructSdtProfesional_Especialidad_Sede struct = new com.projectthani.StructSdtProfesional_Especialidad_Sede ();
      struct.setSedeid(getgxTv_SdtProfesional_Especialidad_Sede_Sedeid());
      struct.setSedetipoconsulta(getgxTv_SdtProfesional_Especialidad_Sede_Sedetipoconsulta());
      struct.setSedenombre(getgxTv_SdtProfesional_Especialidad_Sede_Sedenombre());
      struct.setClinicanombreabreviado(getgxTv_SdtProfesional_Especialidad_Sede_Clinicanombreabreviado());
      struct.setCostoconsulta(getgxTv_SdtProfesional_Especialidad_Sede_Costoconsulta());
      struct.setMode(getgxTv_SdtProfesional_Especialidad_Sede_Mode());
      struct.setModified(getgxTv_SdtProfesional_Especialidad_Sede_Modified());
      struct.setInitialized(getgxTv_SdtProfesional_Especialidad_Sede_Initialized());
      struct.setSedeid_Z(getgxTv_SdtProfesional_Especialidad_Sede_Sedeid_Z());
      struct.setSedetipoconsulta_Z(getgxTv_SdtProfesional_Especialidad_Sede_Sedetipoconsulta_Z());
      struct.setSedenombre_Z(getgxTv_SdtProfesional_Especialidad_Sede_Sedenombre_Z());
      struct.setClinicanombreabreviado_Z(getgxTv_SdtProfesional_Especialidad_Sede_Clinicanombreabreviado_Z());
      struct.setCostoconsulta_Z(getgxTv_SdtProfesional_Especialidad_Sede_Costoconsulta_Z());
      return struct ;
   }

   private byte gxTv_SdtProfesional_Especialidad_Sede_N ;
   private short gxTv_SdtProfesional_Especialidad_Sede_Sedeid ;
   private short gxTv_SdtProfesional_Especialidad_Sede_Modified ;
   private short gxTv_SdtProfesional_Especialidad_Sede_Initialized ;
   private short gxTv_SdtProfesional_Especialidad_Sede_Sedeid_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private java.math.BigDecimal gxTv_SdtProfesional_Especialidad_Sede_Costoconsulta ;
   private java.math.BigDecimal gxTv_SdtProfesional_Especialidad_Sede_Costoconsulta_Z ;
   private String gxTv_SdtProfesional_Especialidad_Sede_Sedetipoconsulta ;
   private String gxTv_SdtProfesional_Especialidad_Sede_Mode ;
   private String gxTv_SdtProfesional_Especialidad_Sede_Sedetipoconsulta_Z ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtProfesional_Especialidad_Sede_Sedenombre ;
   private String gxTv_SdtProfesional_Especialidad_Sede_Clinicanombreabreviado ;
   private String gxTv_SdtProfesional_Especialidad_Sede_Sedenombre_Z ;
   private String gxTv_SdtProfesional_Especialidad_Sede_Clinicanombreabreviado_Z ;
}

