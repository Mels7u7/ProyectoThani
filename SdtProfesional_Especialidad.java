package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtProfesional_Especialidad extends GxSilentTrnSdt implements Cloneable, java.io.Serializable
{
   public SdtProfesional_Especialidad( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtProfesional_Especialidad.class));
   }

   public SdtProfesional_Especialidad( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle, context, "SdtProfesional_Especialidad");
      initialize( remoteHandle) ;
   }

   public SdtProfesional_Especialidad( int remoteHandle ,
                                       StructSdtProfesional_Especialidad struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtProfesional_Especialidad( )
   {
      super( new ModelContext(SdtProfesional_Especialidad.class), "SdtProfesional_Especialidad");
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
      return (Object[][])(new Object[][]{new Object[]{"EspecialidadId", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Especialidad");
      metadata.set("BT", "ProfesionalEspecialidad");
      metadata.set("PK", "[ \"EspecialidadId\" ]");
      metadata.set("Levels", "[ \"Sede\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"EspecialidadId\" ],\"FKMap\":[  ] },{ \"FK\":[ \"ProfesionalId\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "EspecialidadId") )
            {
               gxTv_SdtProfesional_Especialidad_Especialidadid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EspecialidadCodigo") )
            {
               gxTv_SdtProfesional_Especialidad_Especialidadcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EspecialidadNombre") )
            {
               gxTv_SdtProfesional_Especialidad_Especialidadnombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Sede") )
            {
               if ( gxTv_SdtProfesional_Especialidad_Sede == null )
               {
                  gxTv_SdtProfesional_Especialidad_Sede = new GXBCLevelCollection<com.projectthani.SdtProfesional_Especialidad_Sede>(com.projectthani.SdtProfesional_Especialidad_Sede.class, "Profesional.Especialidad.Sede", "ProjectThani", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtProfesional_Especialidad_Sede.readxml(oReader, "Sede") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Sede") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtProfesional_Especialidad_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtProfesional_Especialidad_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtProfesional_Especialidad_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EspecialidadId_Z") )
            {
               gxTv_SdtProfesional_Especialidad_Especialidadid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EspecialidadCodigo_Z") )
            {
               gxTv_SdtProfesional_Especialidad_Especialidadcodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EspecialidadNombre_Z") )
            {
               gxTv_SdtProfesional_Especialidad_Especialidadnombre_Z = oReader.getValue() ;
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
         sName = "Profesional.Especialidad" ;
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
      oWriter.writeElement("EspecialidadId", GXutil.trim( GXutil.str( gxTv_SdtProfesional_Especialidad_Especialidadid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("EspecialidadCodigo", GXutil.rtrim( gxTv_SdtProfesional_Especialidad_Especialidadcodigo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("EspecialidadNombre", GXutil.rtrim( gxTv_SdtProfesional_Especialidad_Especialidadnombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( gxTv_SdtProfesional_Especialidad_Sede != null )
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
         gxTv_SdtProfesional_Especialidad_Sede.writexml(oWriter, "Sede", sNameSpace1, sIncludeState);
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", GXutil.rtrim( gxTv_SdtProfesional_Especialidad_Mode));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtProfesional_Especialidad_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtProfesional_Especialidad_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("EspecialidadId_Z", GXutil.trim( GXutil.str( gxTv_SdtProfesional_Especialidad_Especialidadid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("EspecialidadCodigo_Z", GXutil.rtrim( gxTv_SdtProfesional_Especialidad_Especialidadcodigo_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("EspecialidadNombre_Z", GXutil.rtrim( gxTv_SdtProfesional_Especialidad_Especialidadnombre_Z));
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
      AddObjectProperty("EspecialidadId", gxTv_SdtProfesional_Especialidad_Especialidadid, false, includeNonInitialized);
      AddObjectProperty("EspecialidadCodigo", gxTv_SdtProfesional_Especialidad_Especialidadcodigo, false, includeNonInitialized);
      AddObjectProperty("EspecialidadNombre", gxTv_SdtProfesional_Especialidad_Especialidadnombre, false, includeNonInitialized);
      if ( gxTv_SdtProfesional_Especialidad_Sede != null )
      {
         AddObjectProperty("Sede", gxTv_SdtProfesional_Especialidad_Sede, includeState, includeNonInitialized);
      }
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtProfesional_Especialidad_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtProfesional_Especialidad_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtProfesional_Especialidad_Initialized, false, includeNonInitialized);
         AddObjectProperty("EspecialidadId_Z", gxTv_SdtProfesional_Especialidad_Especialidadid_Z, false, includeNonInitialized);
         AddObjectProperty("EspecialidadCodigo_Z", gxTv_SdtProfesional_Especialidad_Especialidadcodigo_Z, false, includeNonInitialized);
         AddObjectProperty("EspecialidadNombre_Z", gxTv_SdtProfesional_Especialidad_Especialidadnombre_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.projectthani.SdtProfesional_Especialidad sdt )
   {
      if ( sdt.IsDirty("EspecialidadId") )
      {
         gxTv_SdtProfesional_Especialidad_N = (byte)(0) ;
         gxTv_SdtProfesional_Especialidad_Especialidadid = sdt.getgxTv_SdtProfesional_Especialidad_Especialidadid() ;
      }
      if ( sdt.IsDirty("EspecialidadCodigo") )
      {
         gxTv_SdtProfesional_Especialidad_N = (byte)(0) ;
         gxTv_SdtProfesional_Especialidad_Especialidadcodigo = sdt.getgxTv_SdtProfesional_Especialidad_Especialidadcodigo() ;
      }
      if ( sdt.IsDirty("EspecialidadNombre") )
      {
         gxTv_SdtProfesional_Especialidad_N = (byte)(0) ;
         gxTv_SdtProfesional_Especialidad_Especialidadnombre = sdt.getgxTv_SdtProfesional_Especialidad_Especialidadnombre() ;
      }
      if ( gxTv_SdtProfesional_Especialidad_Sede != null )
      {
         GXBCLevelCollection<com.projectthani.SdtProfesional_Especialidad_Sede> newCollectionSede = sdt.getgxTv_SdtProfesional_Especialidad_Sede();
         com.projectthani.SdtProfesional_Especialidad_Sede currItemSede;
         com.projectthani.SdtProfesional_Especialidad_Sede newItemSede;
         short idx = 1;
         while ( idx <= newCollectionSede.size() )
         {
            newItemSede = (com.projectthani.SdtProfesional_Especialidad_Sede)((com.projectthani.SdtProfesional_Especialidad_Sede)newCollectionSede.elementAt(-1+idx));
            currItemSede = (com.projectthani.SdtProfesional_Especialidad_Sede)gxTv_SdtProfesional_Especialidad_Sede.getByKey(newItemSede.getgxTv_SdtProfesional_Especialidad_Sede_Sedeid(), newItemSede.getgxTv_SdtProfesional_Especialidad_Sede_Sedetipoconsulta());
            if ( GXutil.strcmp(currItemSede.getgxTv_SdtProfesional_Especialidad_Sede_Mode(), "UPD") == 0 )
            {
               currItemSede.updateDirties(newItemSede);
               if ( GXutil.strcmp(newItemSede.getgxTv_SdtProfesional_Especialidad_Sede_Mode(), "DLT") == 0 )
               {
                  currItemSede.setgxTv_SdtProfesional_Especialidad_Sede_Mode( "DLT" );
               }
               currItemSede.setgxTv_SdtProfesional_Especialidad_Sede_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtProfesional_Especialidad_Sede.add(newItemSede, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
   }

   public short getgxTv_SdtProfesional_Especialidad_Especialidadid( )
   {
      return gxTv_SdtProfesional_Especialidad_Especialidadid ;
   }

   public void setgxTv_SdtProfesional_Especialidad_Especialidadid( short value )
   {
      gxTv_SdtProfesional_Especialidad_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad_Modified = (short)(1) ;
      SetDirty("Especialidadid");
      gxTv_SdtProfesional_Especialidad_Especialidadid = value ;
   }

   public String getgxTv_SdtProfesional_Especialidad_Especialidadcodigo( )
   {
      return gxTv_SdtProfesional_Especialidad_Especialidadcodigo ;
   }

   public void setgxTv_SdtProfesional_Especialidad_Especialidadcodigo( String value )
   {
      gxTv_SdtProfesional_Especialidad_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad_Modified = (short)(1) ;
      SetDirty("Especialidadcodigo");
      gxTv_SdtProfesional_Especialidad_Especialidadcodigo = value ;
   }

   public String getgxTv_SdtProfesional_Especialidad_Especialidadnombre( )
   {
      return gxTv_SdtProfesional_Especialidad_Especialidadnombre ;
   }

   public void setgxTv_SdtProfesional_Especialidad_Especialidadnombre( String value )
   {
      gxTv_SdtProfesional_Especialidad_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad_Modified = (short)(1) ;
      SetDirty("Especialidadnombre");
      gxTv_SdtProfesional_Especialidad_Especialidadnombre = value ;
   }

   public GXBCLevelCollection<com.projectthani.SdtProfesional_Especialidad_Sede> getgxTv_SdtProfesional_Especialidad_Sede( )
   {
      if ( gxTv_SdtProfesional_Especialidad_Sede == null )
      {
         gxTv_SdtProfesional_Especialidad_Sede = new GXBCLevelCollection<com.projectthani.SdtProfesional_Especialidad_Sede>(com.projectthani.SdtProfesional_Especialidad_Sede.class, "Profesional.Especialidad.Sede", "ProjectThani", remoteHandle);
      }
      gxTv_SdtProfesional_Especialidad_N = (byte)(0) ;
      return gxTv_SdtProfesional_Especialidad_Sede ;
   }

   public void setgxTv_SdtProfesional_Especialidad_Sede( GXBCLevelCollection<com.projectthani.SdtProfesional_Especialidad_Sede> value )
   {
      gxTv_SdtProfesional_Especialidad_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad_Modified = (short)(1) ;
      SetDirty("Sede");
      gxTv_SdtProfesional_Especialidad_Sede = value ;
   }

   public void setgxTv_SdtProfesional_Especialidad_Sede_SetNull( )
   {
      gxTv_SdtProfesional_Especialidad_Sede = null ;
   }

   public boolean getgxTv_SdtProfesional_Especialidad_Sede_IsNull( )
   {
      if ( gxTv_SdtProfesional_Especialidad_Sede == null )
      {
         return true ;
      }
      return false ;
   }

   public String getgxTv_SdtProfesional_Especialidad_Mode( )
   {
      return gxTv_SdtProfesional_Especialidad_Mode ;
   }

   public void setgxTv_SdtProfesional_Especialidad_Mode( String value )
   {
      gxTv_SdtProfesional_Especialidad_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtProfesional_Especialidad_Mode = value ;
   }

   public void setgxTv_SdtProfesional_Especialidad_Mode_SetNull( )
   {
      gxTv_SdtProfesional_Especialidad_Mode = "" ;
   }

   public boolean getgxTv_SdtProfesional_Especialidad_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtProfesional_Especialidad_Modified( )
   {
      return gxTv_SdtProfesional_Especialidad_Modified ;
   }

   public void setgxTv_SdtProfesional_Especialidad_Modified( short value )
   {
      gxTv_SdtProfesional_Especialidad_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtProfesional_Especialidad_Modified = value ;
   }

   public void setgxTv_SdtProfesional_Especialidad_Modified_SetNull( )
   {
      gxTv_SdtProfesional_Especialidad_Modified = (short)(0) ;
   }

   public boolean getgxTv_SdtProfesional_Especialidad_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtProfesional_Especialidad_Initialized( )
   {
      return gxTv_SdtProfesional_Especialidad_Initialized ;
   }

   public void setgxTv_SdtProfesional_Especialidad_Initialized( short value )
   {
      gxTv_SdtProfesional_Especialidad_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtProfesional_Especialidad_Initialized = value ;
   }

   public void setgxTv_SdtProfesional_Especialidad_Initialized_SetNull( )
   {
      gxTv_SdtProfesional_Especialidad_Initialized = (short)(0) ;
   }

   public boolean getgxTv_SdtProfesional_Especialidad_Initialized_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtProfesional_Especialidad_Especialidadid_Z( )
   {
      return gxTv_SdtProfesional_Especialidad_Especialidadid_Z ;
   }

   public void setgxTv_SdtProfesional_Especialidad_Especialidadid_Z( short value )
   {
      gxTv_SdtProfesional_Especialidad_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad_Modified = (short)(1) ;
      SetDirty("Especialidadid_Z");
      gxTv_SdtProfesional_Especialidad_Especialidadid_Z = value ;
   }

   public void setgxTv_SdtProfesional_Especialidad_Especialidadid_Z_SetNull( )
   {
      gxTv_SdtProfesional_Especialidad_Especialidadid_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtProfesional_Especialidad_Especialidadid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtProfesional_Especialidad_Especialidadcodigo_Z( )
   {
      return gxTv_SdtProfesional_Especialidad_Especialidadcodigo_Z ;
   }

   public void setgxTv_SdtProfesional_Especialidad_Especialidadcodigo_Z( String value )
   {
      gxTv_SdtProfesional_Especialidad_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad_Modified = (short)(1) ;
      SetDirty("Especialidadcodigo_Z");
      gxTv_SdtProfesional_Especialidad_Especialidadcodigo_Z = value ;
   }

   public void setgxTv_SdtProfesional_Especialidad_Especialidadcodigo_Z_SetNull( )
   {
      gxTv_SdtProfesional_Especialidad_Especialidadcodigo_Z = "" ;
   }

   public boolean getgxTv_SdtProfesional_Especialidad_Especialidadcodigo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtProfesional_Especialidad_Especialidadnombre_Z( )
   {
      return gxTv_SdtProfesional_Especialidad_Especialidadnombre_Z ;
   }

   public void setgxTv_SdtProfesional_Especialidad_Especialidadnombre_Z( String value )
   {
      gxTv_SdtProfesional_Especialidad_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad_Modified = (short)(1) ;
      SetDirty("Especialidadnombre_Z");
      gxTv_SdtProfesional_Especialidad_Especialidadnombre_Z = value ;
   }

   public void setgxTv_SdtProfesional_Especialidad_Especialidadnombre_Z_SetNull( )
   {
      gxTv_SdtProfesional_Especialidad_Especialidadnombre_Z = "" ;
   }

   public boolean getgxTv_SdtProfesional_Especialidad_Especialidadnombre_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtProfesional_Especialidad_N = (byte)(1) ;
      gxTv_SdtProfesional_Especialidad_Especialidadcodigo = "" ;
      gxTv_SdtProfesional_Especialidad_Especialidadnombre = "" ;
      gxTv_SdtProfesional_Especialidad_Mode = "" ;
      gxTv_SdtProfesional_Especialidad_Especialidadcodigo_Z = "" ;
      gxTv_SdtProfesional_Especialidad_Especialidadnombre_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtProfesional_Especialidad_N ;
   }

   public com.projectthani.SdtProfesional_Especialidad Clone( )
   {
      return (com.projectthani.SdtProfesional_Especialidad)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtProfesional_Especialidad struct )
   {
      setgxTv_SdtProfesional_Especialidad_Especialidadid(struct.getEspecialidadid());
      setgxTv_SdtProfesional_Especialidad_Especialidadcodigo(struct.getEspecialidadcodigo());
      setgxTv_SdtProfesional_Especialidad_Especialidadnombre(struct.getEspecialidadnombre());
      GXBCLevelCollection<com.projectthani.SdtProfesional_Especialidad_Sede> gxTv_SdtProfesional_Especialidad_Sede_aux = new GXBCLevelCollection<com.projectthani.SdtProfesional_Especialidad_Sede>(com.projectthani.SdtProfesional_Especialidad_Sede.class, "Profesional.Especialidad.Sede", "ProjectThani", remoteHandle);
      Vector<com.projectthani.StructSdtProfesional_Especialidad_Sede> gxTv_SdtProfesional_Especialidad_Sede_aux1 = struct.getSede();
      if (gxTv_SdtProfesional_Especialidad_Sede_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtProfesional_Especialidad_Sede_aux1.size(); i++)
         {
            gxTv_SdtProfesional_Especialidad_Sede_aux.add(new com.projectthani.SdtProfesional_Especialidad_Sede(remoteHandle, gxTv_SdtProfesional_Especialidad_Sede_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtProfesional_Especialidad_Sede(gxTv_SdtProfesional_Especialidad_Sede_aux);
      setgxTv_SdtProfesional_Especialidad_Mode(struct.getMode());
      setgxTv_SdtProfesional_Especialidad_Modified(struct.getModified());
      setgxTv_SdtProfesional_Especialidad_Initialized(struct.getInitialized());
      setgxTv_SdtProfesional_Especialidad_Especialidadid_Z(struct.getEspecialidadid_Z());
      setgxTv_SdtProfesional_Especialidad_Especialidadcodigo_Z(struct.getEspecialidadcodigo_Z());
      setgxTv_SdtProfesional_Especialidad_Especialidadnombre_Z(struct.getEspecialidadnombre_Z());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtProfesional_Especialidad getStruct( )
   {
      com.projectthani.StructSdtProfesional_Especialidad struct = new com.projectthani.StructSdtProfesional_Especialidad ();
      struct.setEspecialidadid(getgxTv_SdtProfesional_Especialidad_Especialidadid());
      struct.setEspecialidadcodigo(getgxTv_SdtProfesional_Especialidad_Especialidadcodigo());
      struct.setEspecialidadnombre(getgxTv_SdtProfesional_Especialidad_Especialidadnombre());
      struct.setSede(getgxTv_SdtProfesional_Especialidad_Sede().getStruct());
      struct.setMode(getgxTv_SdtProfesional_Especialidad_Mode());
      struct.setModified(getgxTv_SdtProfesional_Especialidad_Modified());
      struct.setInitialized(getgxTv_SdtProfesional_Especialidad_Initialized());
      struct.setEspecialidadid_Z(getgxTv_SdtProfesional_Especialidad_Especialidadid_Z());
      struct.setEspecialidadcodigo_Z(getgxTv_SdtProfesional_Especialidad_Especialidadcodigo_Z());
      struct.setEspecialidadnombre_Z(getgxTv_SdtProfesional_Especialidad_Especialidadnombre_Z());
      return struct ;
   }

   private byte gxTv_SdtProfesional_Especialidad_N ;
   private short gxTv_SdtProfesional_Especialidad_Especialidadid ;
   private short gxTv_SdtProfesional_Especialidad_Modified ;
   private short gxTv_SdtProfesional_Especialidad_Initialized ;
   private short gxTv_SdtProfesional_Especialidad_Especialidadid_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtProfesional_Especialidad_Mode ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtProfesional_Especialidad_Especialidadcodigo ;
   private String gxTv_SdtProfesional_Especialidad_Especialidadnombre ;
   private String gxTv_SdtProfesional_Especialidad_Especialidadcodigo_Z ;
   private String gxTv_SdtProfesional_Especialidad_Especialidadnombre_Z ;
   private GXBCLevelCollection<com.projectthani.SdtProfesional_Especialidad_Sede> gxTv_SdtProfesional_Especialidad_Sede_aux ;
   private GXBCLevelCollection<com.projectthani.SdtProfesional_Especialidad_Sede> gxTv_SdtProfesional_Especialidad_Sede=null ;
}

