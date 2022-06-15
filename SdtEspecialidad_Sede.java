package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtEspecialidad_Sede extends GxSilentTrnSdt implements Cloneable, java.io.Serializable
{
   public SdtEspecialidad_Sede( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtEspecialidad_Sede.class));
   }

   public SdtEspecialidad_Sede( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle, context, "SdtEspecialidad_Sede");
      initialize( remoteHandle) ;
   }

   public SdtEspecialidad_Sede( int remoteHandle ,
                                StructSdtEspecialidad_Sede struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtEspecialidad_Sede( )
   {
      super( new ModelContext(SdtEspecialidad_Sede.class), "SdtEspecialidad_Sede");
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
      return (Object[][])(new Object[][]{new Object[]{"SGEspecialidadSedeId", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Sede");
      metadata.set("BT", "EspecialidadSede");
      metadata.set("PK", "[ \"SGEspecialidadSedeId\" ]");
      metadata.set("PKAssigned", "[ \"SGEspecialidadSedeId\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"EspecialidadId\" ],\"FKMap\":[  ] },{ \"FK\":[ \"SedeId\" ],\"FKMap\":[ \"SGEspecialidadSedeId-SedeId\" ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGEspecialidadSedeId") )
            {
               gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGEspecialidadSedeNombre") )
            {
               gxTv_SdtEspecialidad_Sede_Sgespecialidadsedenombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGEspecialidadSedeClinicaid") )
            {
               gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicaid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGEspecialidadSedeClinicaNombre") )
            {
               gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicanombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SedeCostoConsulta") )
            {
               gxTv_SdtEspecialidad_Sede_Sedecostoconsulta = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtEspecialidad_Sede_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtEspecialidad_Sede_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtEspecialidad_Sede_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGEspecialidadSedeId_Z") )
            {
               gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGEspecialidadSedeNombre_Z") )
            {
               gxTv_SdtEspecialidad_Sede_Sgespecialidadsedenombre_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGEspecialidadSedeClinicaid_Z") )
            {
               gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicaid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGEspecialidadSedeClinicaNombre_Z") )
            {
               gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicanombre_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SedeCostoConsulta_Z") )
            {
               gxTv_SdtEspecialidad_Sede_Sedecostoconsulta_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
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
         sName = "Especialidad.Sede" ;
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
      oWriter.writeElement("SGEspecialidadSedeId", GXutil.trim( GXutil.str( gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGEspecialidadSedeNombre", GXutil.rtrim( gxTv_SdtEspecialidad_Sede_Sgespecialidadsedenombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGEspecialidadSedeClinicaid", GXutil.trim( GXutil.str( gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicaid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGEspecialidadSedeClinicaNombre", GXutil.rtrim( gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicanombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SedeCostoConsulta", GXutil.trim( GXutil.strNoRound( gxTv_SdtEspecialidad_Sede_Sedecostoconsulta, 6, 2)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", GXutil.rtrim( gxTv_SdtEspecialidad_Sede_Mode));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtEspecialidad_Sede_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtEspecialidad_Sede_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SGEspecialidadSedeId_Z", GXutil.trim( GXutil.str( gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SGEspecialidadSedeNombre_Z", GXutil.rtrim( gxTv_SdtEspecialidad_Sede_Sgespecialidadsedenombre_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SGEspecialidadSedeClinicaid_Z", GXutil.trim( GXutil.str( gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicaid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SGEspecialidadSedeClinicaNombre_Z", GXutil.rtrim( gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicanombre_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SedeCostoConsulta_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtEspecialidad_Sede_Sedecostoconsulta_Z, 6, 2)));
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
      AddObjectProperty("SGEspecialidadSedeId", gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeid, false, includeNonInitialized);
      AddObjectProperty("SGEspecialidadSedeNombre", gxTv_SdtEspecialidad_Sede_Sgespecialidadsedenombre, false, includeNonInitialized);
      AddObjectProperty("SGEspecialidadSedeClinicaid", gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicaid, false, includeNonInitialized);
      AddObjectProperty("SGEspecialidadSedeClinicaNombre", gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicanombre, false, includeNonInitialized);
      AddObjectProperty("SedeCostoConsulta", gxTv_SdtEspecialidad_Sede_Sedecostoconsulta, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtEspecialidad_Sede_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtEspecialidad_Sede_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtEspecialidad_Sede_Initialized, false, includeNonInitialized);
         AddObjectProperty("SGEspecialidadSedeId_Z", gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeid_Z, false, includeNonInitialized);
         AddObjectProperty("SGEspecialidadSedeNombre_Z", gxTv_SdtEspecialidad_Sede_Sgespecialidadsedenombre_Z, false, includeNonInitialized);
         AddObjectProperty("SGEspecialidadSedeClinicaid_Z", gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicaid_Z, false, includeNonInitialized);
         AddObjectProperty("SGEspecialidadSedeClinicaNombre_Z", gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicanombre_Z, false, includeNonInitialized);
         AddObjectProperty("SedeCostoConsulta_Z", gxTv_SdtEspecialidad_Sede_Sedecostoconsulta_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.projectthani.SdtEspecialidad_Sede sdt )
   {
      if ( sdt.IsDirty("SGEspecialidadSedeId") )
      {
         gxTv_SdtEspecialidad_Sede_N = (byte)(0) ;
         gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeid = sdt.getgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeid() ;
      }
      if ( sdt.IsDirty("SGEspecialidadSedeNombre") )
      {
         gxTv_SdtEspecialidad_Sede_N = (byte)(0) ;
         gxTv_SdtEspecialidad_Sede_Sgespecialidadsedenombre = sdt.getgxTv_SdtEspecialidad_Sede_Sgespecialidadsedenombre() ;
      }
      if ( sdt.IsDirty("SGEspecialidadSedeClinicaid") )
      {
         gxTv_SdtEspecialidad_Sede_N = (byte)(0) ;
         gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicaid = sdt.getgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicaid() ;
      }
      if ( sdt.IsDirty("SGEspecialidadSedeClinicaNombre") )
      {
         gxTv_SdtEspecialidad_Sede_N = (byte)(0) ;
         gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicanombre = sdt.getgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicanombre() ;
      }
      if ( sdt.IsDirty("SedeCostoConsulta") )
      {
         gxTv_SdtEspecialidad_Sede_N = (byte)(0) ;
         gxTv_SdtEspecialidad_Sede_Sedecostoconsulta = sdt.getgxTv_SdtEspecialidad_Sede_Sedecostoconsulta() ;
      }
   }

   public short getgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeid( )
   {
      return gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeid ;
   }

   public void setgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeid( short value )
   {
      gxTv_SdtEspecialidad_Sede_N = (byte)(0) ;
      gxTv_SdtEspecialidad_Sede_Modified = (short)(1) ;
      SetDirty("Sgespecialidadsedeid");
      gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeid = value ;
   }

   public String getgxTv_SdtEspecialidad_Sede_Sgespecialidadsedenombre( )
   {
      return gxTv_SdtEspecialidad_Sede_Sgespecialidadsedenombre ;
   }

   public void setgxTv_SdtEspecialidad_Sede_Sgespecialidadsedenombre( String value )
   {
      gxTv_SdtEspecialidad_Sede_N = (byte)(0) ;
      gxTv_SdtEspecialidad_Sede_Modified = (short)(1) ;
      SetDirty("Sgespecialidadsedenombre");
      gxTv_SdtEspecialidad_Sede_Sgespecialidadsedenombre = value ;
   }

   public short getgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicaid( )
   {
      return gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicaid ;
   }

   public void setgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicaid( short value )
   {
      gxTv_SdtEspecialidad_Sede_N = (byte)(0) ;
      gxTv_SdtEspecialidad_Sede_Modified = (short)(1) ;
      SetDirty("Sgespecialidadsedeclinicaid");
      gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicaid = value ;
   }

   public String getgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicanombre( )
   {
      return gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicanombre ;
   }

   public void setgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicanombre( String value )
   {
      gxTv_SdtEspecialidad_Sede_N = (byte)(0) ;
      gxTv_SdtEspecialidad_Sede_Modified = (short)(1) ;
      SetDirty("Sgespecialidadsedeclinicanombre");
      gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicanombre = value ;
   }

   public java.math.BigDecimal getgxTv_SdtEspecialidad_Sede_Sedecostoconsulta( )
   {
      return gxTv_SdtEspecialidad_Sede_Sedecostoconsulta ;
   }

   public void setgxTv_SdtEspecialidad_Sede_Sedecostoconsulta( java.math.BigDecimal value )
   {
      gxTv_SdtEspecialidad_Sede_N = (byte)(0) ;
      gxTv_SdtEspecialidad_Sede_Modified = (short)(1) ;
      SetDirty("Sedecostoconsulta");
      gxTv_SdtEspecialidad_Sede_Sedecostoconsulta = value ;
   }

   public String getgxTv_SdtEspecialidad_Sede_Mode( )
   {
      return gxTv_SdtEspecialidad_Sede_Mode ;
   }

   public void setgxTv_SdtEspecialidad_Sede_Mode( String value )
   {
      gxTv_SdtEspecialidad_Sede_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtEspecialidad_Sede_Mode = value ;
   }

   public void setgxTv_SdtEspecialidad_Sede_Mode_SetNull( )
   {
      gxTv_SdtEspecialidad_Sede_Mode = "" ;
   }

   public boolean getgxTv_SdtEspecialidad_Sede_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEspecialidad_Sede_Modified( )
   {
      return gxTv_SdtEspecialidad_Sede_Modified ;
   }

   public void setgxTv_SdtEspecialidad_Sede_Modified( short value )
   {
      gxTv_SdtEspecialidad_Sede_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtEspecialidad_Sede_Modified = value ;
   }

   public void setgxTv_SdtEspecialidad_Sede_Modified_SetNull( )
   {
      gxTv_SdtEspecialidad_Sede_Modified = (short)(0) ;
   }

   public boolean getgxTv_SdtEspecialidad_Sede_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEspecialidad_Sede_Initialized( )
   {
      return gxTv_SdtEspecialidad_Sede_Initialized ;
   }

   public void setgxTv_SdtEspecialidad_Sede_Initialized( short value )
   {
      gxTv_SdtEspecialidad_Sede_N = (byte)(0) ;
      gxTv_SdtEspecialidad_Sede_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtEspecialidad_Sede_Initialized = value ;
   }

   public void setgxTv_SdtEspecialidad_Sede_Initialized_SetNull( )
   {
      gxTv_SdtEspecialidad_Sede_Initialized = (short)(0) ;
   }

   public boolean getgxTv_SdtEspecialidad_Sede_Initialized_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeid_Z( )
   {
      return gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeid_Z ;
   }

   public void setgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeid_Z( short value )
   {
      gxTv_SdtEspecialidad_Sede_N = (byte)(0) ;
      gxTv_SdtEspecialidad_Sede_Modified = (short)(1) ;
      SetDirty("Sgespecialidadsedeid_Z");
      gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeid_Z = value ;
   }

   public void setgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeid_Z_SetNull( )
   {
      gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeid_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEspecialidad_Sede_Sgespecialidadsedenombre_Z( )
   {
      return gxTv_SdtEspecialidad_Sede_Sgespecialidadsedenombre_Z ;
   }

   public void setgxTv_SdtEspecialidad_Sede_Sgespecialidadsedenombre_Z( String value )
   {
      gxTv_SdtEspecialidad_Sede_N = (byte)(0) ;
      gxTv_SdtEspecialidad_Sede_Modified = (short)(1) ;
      SetDirty("Sgespecialidadsedenombre_Z");
      gxTv_SdtEspecialidad_Sede_Sgespecialidadsedenombre_Z = value ;
   }

   public void setgxTv_SdtEspecialidad_Sede_Sgespecialidadsedenombre_Z_SetNull( )
   {
      gxTv_SdtEspecialidad_Sede_Sgespecialidadsedenombre_Z = "" ;
   }

   public boolean getgxTv_SdtEspecialidad_Sede_Sgespecialidadsedenombre_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicaid_Z( )
   {
      return gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicaid_Z ;
   }

   public void setgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicaid_Z( short value )
   {
      gxTv_SdtEspecialidad_Sede_N = (byte)(0) ;
      gxTv_SdtEspecialidad_Sede_Modified = (short)(1) ;
      SetDirty("Sgespecialidadsedeclinicaid_Z");
      gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicaid_Z = value ;
   }

   public void setgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicaid_Z_SetNull( )
   {
      gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicaid_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicaid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicanombre_Z( )
   {
      return gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicanombre_Z ;
   }

   public void setgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicanombre_Z( String value )
   {
      gxTv_SdtEspecialidad_Sede_N = (byte)(0) ;
      gxTv_SdtEspecialidad_Sede_Modified = (short)(1) ;
      SetDirty("Sgespecialidadsedeclinicanombre_Z");
      gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicanombre_Z = value ;
   }

   public void setgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicanombre_Z_SetNull( )
   {
      gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicanombre_Z = "" ;
   }

   public boolean getgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicanombre_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtEspecialidad_Sede_Sedecostoconsulta_Z( )
   {
      return gxTv_SdtEspecialidad_Sede_Sedecostoconsulta_Z ;
   }

   public void setgxTv_SdtEspecialidad_Sede_Sedecostoconsulta_Z( java.math.BigDecimal value )
   {
      gxTv_SdtEspecialidad_Sede_N = (byte)(0) ;
      gxTv_SdtEspecialidad_Sede_Modified = (short)(1) ;
      SetDirty("Sedecostoconsulta_Z");
      gxTv_SdtEspecialidad_Sede_Sedecostoconsulta_Z = value ;
   }

   public void setgxTv_SdtEspecialidad_Sede_Sedecostoconsulta_Z_SetNull( )
   {
      gxTv_SdtEspecialidad_Sede_Sedecostoconsulta_Z = DecimalUtil.ZERO ;
   }

   public boolean getgxTv_SdtEspecialidad_Sede_Sedecostoconsulta_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtEspecialidad_Sede_N = (byte)(1) ;
      gxTv_SdtEspecialidad_Sede_Sgespecialidadsedenombre = "" ;
      gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicanombre = "" ;
      gxTv_SdtEspecialidad_Sede_Sedecostoconsulta = DecimalUtil.ZERO ;
      gxTv_SdtEspecialidad_Sede_Mode = "" ;
      gxTv_SdtEspecialidad_Sede_Sgespecialidadsedenombre_Z = "" ;
      gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicanombre_Z = "" ;
      gxTv_SdtEspecialidad_Sede_Sedecostoconsulta_Z = DecimalUtil.ZERO ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtEspecialidad_Sede_N ;
   }

   public com.projectthani.SdtEspecialidad_Sede Clone( )
   {
      return (com.projectthani.SdtEspecialidad_Sede)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtEspecialidad_Sede struct )
   {
      setgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeid(struct.getSgespecialidadsedeid());
      setgxTv_SdtEspecialidad_Sede_Sgespecialidadsedenombre(struct.getSgespecialidadsedenombre());
      setgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicaid(struct.getSgespecialidadsedeclinicaid());
      setgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicanombre(struct.getSgespecialidadsedeclinicanombre());
      setgxTv_SdtEspecialidad_Sede_Sedecostoconsulta(struct.getSedecostoconsulta());
      setgxTv_SdtEspecialidad_Sede_Mode(struct.getMode());
      setgxTv_SdtEspecialidad_Sede_Modified(struct.getModified());
      setgxTv_SdtEspecialidad_Sede_Initialized(struct.getInitialized());
      setgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeid_Z(struct.getSgespecialidadsedeid_Z());
      setgxTv_SdtEspecialidad_Sede_Sgespecialidadsedenombre_Z(struct.getSgespecialidadsedenombre_Z());
      setgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicaid_Z(struct.getSgespecialidadsedeclinicaid_Z());
      setgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicanombre_Z(struct.getSgespecialidadsedeclinicanombre_Z());
      setgxTv_SdtEspecialidad_Sede_Sedecostoconsulta_Z(struct.getSedecostoconsulta_Z());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtEspecialidad_Sede getStruct( )
   {
      com.projectthani.StructSdtEspecialidad_Sede struct = new com.projectthani.StructSdtEspecialidad_Sede ();
      struct.setSgespecialidadsedeid(getgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeid());
      struct.setSgespecialidadsedenombre(getgxTv_SdtEspecialidad_Sede_Sgespecialidadsedenombre());
      struct.setSgespecialidadsedeclinicaid(getgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicaid());
      struct.setSgespecialidadsedeclinicanombre(getgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicanombre());
      struct.setSedecostoconsulta(getgxTv_SdtEspecialidad_Sede_Sedecostoconsulta());
      struct.setMode(getgxTv_SdtEspecialidad_Sede_Mode());
      struct.setModified(getgxTv_SdtEspecialidad_Sede_Modified());
      struct.setInitialized(getgxTv_SdtEspecialidad_Sede_Initialized());
      struct.setSgespecialidadsedeid_Z(getgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeid_Z());
      struct.setSgespecialidadsedenombre_Z(getgxTv_SdtEspecialidad_Sede_Sgespecialidadsedenombre_Z());
      struct.setSgespecialidadsedeclinicaid_Z(getgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicaid_Z());
      struct.setSgespecialidadsedeclinicanombre_Z(getgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicanombre_Z());
      struct.setSedecostoconsulta_Z(getgxTv_SdtEspecialidad_Sede_Sedecostoconsulta_Z());
      return struct ;
   }

   private byte gxTv_SdtEspecialidad_Sede_N ;
   private short gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeid ;
   private short gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicaid ;
   private short gxTv_SdtEspecialidad_Sede_Modified ;
   private short gxTv_SdtEspecialidad_Sede_Initialized ;
   private short gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeid_Z ;
   private short gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicaid_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private java.math.BigDecimal gxTv_SdtEspecialidad_Sede_Sedecostoconsulta ;
   private java.math.BigDecimal gxTv_SdtEspecialidad_Sede_Sedecostoconsulta_Z ;
   private String gxTv_SdtEspecialidad_Sede_Mode ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtEspecialidad_Sede_Sgespecialidadsedenombre ;
   private String gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicanombre ;
   private String gxTv_SdtEspecialidad_Sede_Sgespecialidadsedenombre_Z ;
   private String gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicanombre_Z ;
}

