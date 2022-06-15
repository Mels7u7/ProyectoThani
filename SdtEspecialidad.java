package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtEspecialidad extends GxSilentTrnSdt implements Cloneable, java.io.Serializable
{
   public SdtEspecialidad( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtEspecialidad.class));
   }

   public SdtEspecialidad( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle, context, "SdtEspecialidad");
      initialize( remoteHandle) ;
   }

   public SdtEspecialidad( int remoteHandle ,
                           StructSdtEspecialidad struct )
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

   public void Load( short AV32EspecialidadId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Short.valueOf(AV32EspecialidadId)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"EspecialidadId", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Especialidad");
      metadata.set("BT", "Especialidad");
      metadata.set("PK", "[ \"EspecialidadId\" ]");
      metadata.set("PKAssigned", "[ \"EspecialidadId\" ]");
      metadata.set("Levels", "[ \"Sede\" ]");
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
               gxTv_SdtEspecialidad_Especialidadid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EspecialidadNombre") )
            {
               gxTv_SdtEspecialidad_Especialidadnombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EspecialidadDescripcion") )
            {
               gxTv_SdtEspecialidad_Especialidaddescripcion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EspecialidadCodigo") )
            {
               gxTv_SdtEspecialidad_Especialidadcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EspecialidadFoto") )
            {
               gxTv_SdtEspecialidad_Especialidadfoto = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EspecialidadFoto_GXI") )
            {
               gxTv_SdtEspecialidad_Especialidadfoto_gxi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EspecialidadEstado") )
            {
               gxTv_SdtEspecialidad_Especialidadestado = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Sede") )
            {
               if ( gxTv_SdtEspecialidad_Sede == null )
               {
                  gxTv_SdtEspecialidad_Sede = new GXBCLevelCollection<com.projectthani.SdtEspecialidad_Sede>(com.projectthani.SdtEspecialidad_Sede.class, "Especialidad.Sede", "ProjectThani", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtEspecialidad_Sede.readxml(oReader, "Sede") ;
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
               gxTv_SdtEspecialidad_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtEspecialidad_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EspecialidadId_Z") )
            {
               gxTv_SdtEspecialidad_Especialidadid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EspecialidadNombre_Z") )
            {
               gxTv_SdtEspecialidad_Especialidadnombre_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EspecialidadDescripcion_Z") )
            {
               gxTv_SdtEspecialidad_Especialidaddescripcion_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EspecialidadCodigo_Z") )
            {
               gxTv_SdtEspecialidad_Especialidadcodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EspecialidadEstado_Z") )
            {
               gxTv_SdtEspecialidad_Especialidadestado_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EspecialidadFoto_GXI_Z") )
            {
               gxTv_SdtEspecialidad_Especialidadfoto_gxi_Z = oReader.getValue() ;
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
         sName = "Especialidad" ;
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
      oWriter.writeElement("EspecialidadId", GXutil.trim( GXutil.str( gxTv_SdtEspecialidad_Especialidadid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("EspecialidadNombre", GXutil.rtrim( gxTv_SdtEspecialidad_Especialidadnombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("EspecialidadDescripcion", GXutil.rtrim( gxTv_SdtEspecialidad_Especialidaddescripcion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("EspecialidadCodigo", GXutil.rtrim( gxTv_SdtEspecialidad_Especialidadcodigo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("EspecialidadFoto", GXutil.rtrim( gxTv_SdtEspecialidad_Especialidadfoto));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("EspecialidadEstado", GXutil.rtrim( gxTv_SdtEspecialidad_Especialidadestado));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( gxTv_SdtEspecialidad_Sede != null )
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
         gxTv_SdtEspecialidad_Sede.writexml(oWriter, "Sede", sNameSpace1, sIncludeState);
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("EspecialidadFoto_GXI", GXutil.rtrim( gxTv_SdtEspecialidad_Especialidadfoto_gxi));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Mode", GXutil.rtrim( gxTv_SdtEspecialidad_Mode));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtEspecialidad_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("EspecialidadId_Z", GXutil.trim( GXutil.str( gxTv_SdtEspecialidad_Especialidadid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("EspecialidadNombre_Z", GXutil.rtrim( gxTv_SdtEspecialidad_Especialidadnombre_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("EspecialidadDescripcion_Z", GXutil.rtrim( gxTv_SdtEspecialidad_Especialidaddescripcion_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("EspecialidadCodigo_Z", GXutil.rtrim( gxTv_SdtEspecialidad_Especialidadcodigo_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("EspecialidadEstado_Z", GXutil.rtrim( gxTv_SdtEspecialidad_Especialidadestado_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("EspecialidadFoto_GXI_Z", GXutil.rtrim( gxTv_SdtEspecialidad_Especialidadfoto_gxi_Z));
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
      AddObjectProperty("EspecialidadId", gxTv_SdtEspecialidad_Especialidadid, false, includeNonInitialized);
      AddObjectProperty("EspecialidadNombre", gxTv_SdtEspecialidad_Especialidadnombre, false, includeNonInitialized);
      AddObjectProperty("EspecialidadDescripcion", gxTv_SdtEspecialidad_Especialidaddescripcion, false, includeNonInitialized);
      AddObjectProperty("EspecialidadCodigo", gxTv_SdtEspecialidad_Especialidadcodigo, false, includeNonInitialized);
      AddObjectProperty("EspecialidadFoto", gxTv_SdtEspecialidad_Especialidadfoto, false, includeNonInitialized);
      AddObjectProperty("EspecialidadEstado", gxTv_SdtEspecialidad_Especialidadestado, false, includeNonInitialized);
      if ( gxTv_SdtEspecialidad_Sede != null )
      {
         AddObjectProperty("Sede", gxTv_SdtEspecialidad_Sede, includeState, includeNonInitialized);
      }
      if ( includeState )
      {
         AddObjectProperty("EspecialidadFoto_GXI", gxTv_SdtEspecialidad_Especialidadfoto_gxi, false, includeNonInitialized);
         AddObjectProperty("Mode", gxTv_SdtEspecialidad_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtEspecialidad_Initialized, false, includeNonInitialized);
         AddObjectProperty("EspecialidadId_Z", gxTv_SdtEspecialidad_Especialidadid_Z, false, includeNonInitialized);
         AddObjectProperty("EspecialidadNombre_Z", gxTv_SdtEspecialidad_Especialidadnombre_Z, false, includeNonInitialized);
         AddObjectProperty("EspecialidadDescripcion_Z", gxTv_SdtEspecialidad_Especialidaddescripcion_Z, false, includeNonInitialized);
         AddObjectProperty("EspecialidadCodigo_Z", gxTv_SdtEspecialidad_Especialidadcodigo_Z, false, includeNonInitialized);
         AddObjectProperty("EspecialidadEstado_Z", gxTv_SdtEspecialidad_Especialidadestado_Z, false, includeNonInitialized);
         AddObjectProperty("EspecialidadFoto_GXI_Z", gxTv_SdtEspecialidad_Especialidadfoto_gxi_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.projectthani.SdtEspecialidad sdt )
   {
      if ( sdt.IsDirty("EspecialidadId") )
      {
         gxTv_SdtEspecialidad_N = (byte)(0) ;
         gxTv_SdtEspecialidad_Especialidadid = sdt.getgxTv_SdtEspecialidad_Especialidadid() ;
      }
      if ( sdt.IsDirty("EspecialidadNombre") )
      {
         gxTv_SdtEspecialidad_N = (byte)(0) ;
         gxTv_SdtEspecialidad_Especialidadnombre = sdt.getgxTv_SdtEspecialidad_Especialidadnombre() ;
      }
      if ( sdt.IsDirty("EspecialidadDescripcion") )
      {
         gxTv_SdtEspecialidad_N = (byte)(0) ;
         gxTv_SdtEspecialidad_Especialidaddescripcion = sdt.getgxTv_SdtEspecialidad_Especialidaddescripcion() ;
      }
      if ( sdt.IsDirty("EspecialidadCodigo") )
      {
         gxTv_SdtEspecialidad_N = (byte)(0) ;
         gxTv_SdtEspecialidad_Especialidadcodigo = sdt.getgxTv_SdtEspecialidad_Especialidadcodigo() ;
      }
      if ( sdt.IsDirty("EspecialidadFoto") )
      {
         gxTv_SdtEspecialidad_N = (byte)(0) ;
         gxTv_SdtEspecialidad_Especialidadfoto = sdt.getgxTv_SdtEspecialidad_Especialidadfoto() ;
      }
      if ( sdt.IsDirty("EspecialidadFoto") )
      {
         gxTv_SdtEspecialidad_N = (byte)(0) ;
         gxTv_SdtEspecialidad_Especialidadfoto_gxi = sdt.getgxTv_SdtEspecialidad_Especialidadfoto_gxi() ;
      }
      if ( sdt.IsDirty("EspecialidadEstado") )
      {
         gxTv_SdtEspecialidad_N = (byte)(0) ;
         gxTv_SdtEspecialidad_Especialidadestado = sdt.getgxTv_SdtEspecialidad_Especialidadestado() ;
      }
      if ( gxTv_SdtEspecialidad_Sede != null )
      {
         GXBCLevelCollection<com.projectthani.SdtEspecialidad_Sede> newCollectionSede = sdt.getgxTv_SdtEspecialidad_Sede();
         com.projectthani.SdtEspecialidad_Sede currItemSede;
         com.projectthani.SdtEspecialidad_Sede newItemSede;
         short idx = 1;
         while ( idx <= newCollectionSede.size() )
         {
            newItemSede = (com.projectthani.SdtEspecialidad_Sede)((com.projectthani.SdtEspecialidad_Sede)newCollectionSede.elementAt(-1+idx));
            currItemSede = (com.projectthani.SdtEspecialidad_Sede)gxTv_SdtEspecialidad_Sede.getByKey(newItemSede.getgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeid());
            if ( GXutil.strcmp(currItemSede.getgxTv_SdtEspecialidad_Sede_Mode(), "UPD") == 0 )
            {
               currItemSede.updateDirties(newItemSede);
               if ( GXutil.strcmp(newItemSede.getgxTv_SdtEspecialidad_Sede_Mode(), "DLT") == 0 )
               {
                  currItemSede.setgxTv_SdtEspecialidad_Sede_Mode( "DLT" );
               }
               currItemSede.setgxTv_SdtEspecialidad_Sede_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtEspecialidad_Sede.add(newItemSede, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
   }

   public short getgxTv_SdtEspecialidad_Especialidadid( )
   {
      return gxTv_SdtEspecialidad_Especialidadid ;
   }

   public void setgxTv_SdtEspecialidad_Especialidadid( short value )
   {
      gxTv_SdtEspecialidad_N = (byte)(0) ;
      if ( gxTv_SdtEspecialidad_Especialidadid != value )
      {
         gxTv_SdtEspecialidad_Mode = "INS" ;
         this.setgxTv_SdtEspecialidad_Especialidadid_Z_SetNull( );
         this.setgxTv_SdtEspecialidad_Especialidadnombre_Z_SetNull( );
         this.setgxTv_SdtEspecialidad_Especialidaddescripcion_Z_SetNull( );
         this.setgxTv_SdtEspecialidad_Especialidadcodigo_Z_SetNull( );
         this.setgxTv_SdtEspecialidad_Especialidadestado_Z_SetNull( );
         this.setgxTv_SdtEspecialidad_Especialidadfoto_gxi_Z_SetNull( );
         if ( gxTv_SdtEspecialidad_Sede != null )
         {
            GXBCLevelCollection<com.projectthani.SdtEspecialidad_Sede> collectionSede = gxTv_SdtEspecialidad_Sede;
            com.projectthani.SdtEspecialidad_Sede currItemSede;
            short idx = 1;
            while ( idx <= collectionSede.size() )
            {
               currItemSede = (com.projectthani.SdtEspecialidad_Sede)((com.projectthani.SdtEspecialidad_Sede)collectionSede.elementAt(-1+idx));
               currItemSede.setgxTv_SdtEspecialidad_Sede_Mode( "INS" );
               currItemSede.setgxTv_SdtEspecialidad_Sede_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
      }
      SetDirty("Especialidadid");
      gxTv_SdtEspecialidad_Especialidadid = value ;
   }

   public String getgxTv_SdtEspecialidad_Especialidadnombre( )
   {
      return gxTv_SdtEspecialidad_Especialidadnombre ;
   }

   public void setgxTv_SdtEspecialidad_Especialidadnombre( String value )
   {
      gxTv_SdtEspecialidad_N = (byte)(0) ;
      SetDirty("Especialidadnombre");
      gxTv_SdtEspecialidad_Especialidadnombre = value ;
   }

   public String getgxTv_SdtEspecialidad_Especialidaddescripcion( )
   {
      return gxTv_SdtEspecialidad_Especialidaddescripcion ;
   }

   public void setgxTv_SdtEspecialidad_Especialidaddescripcion( String value )
   {
      gxTv_SdtEspecialidad_N = (byte)(0) ;
      SetDirty("Especialidaddescripcion");
      gxTv_SdtEspecialidad_Especialidaddescripcion = value ;
   }

   public String getgxTv_SdtEspecialidad_Especialidadcodigo( )
   {
      return gxTv_SdtEspecialidad_Especialidadcodigo ;
   }

   public void setgxTv_SdtEspecialidad_Especialidadcodigo( String value )
   {
      gxTv_SdtEspecialidad_N = (byte)(0) ;
      SetDirty("Especialidadcodigo");
      gxTv_SdtEspecialidad_Especialidadcodigo = value ;
   }

   @GxUpload
   public String getgxTv_SdtEspecialidad_Especialidadfoto( )
   {
      return gxTv_SdtEspecialidad_Especialidadfoto ;
   }

   public void setgxTv_SdtEspecialidad_Especialidadfoto( String value )
   {
      gxTv_SdtEspecialidad_N = (byte)(0) ;
      SetDirty("Especialidadfoto");
      gxTv_SdtEspecialidad_Especialidadfoto = value ;
   }

   public String getgxTv_SdtEspecialidad_Especialidadfoto_gxi( )
   {
      return gxTv_SdtEspecialidad_Especialidadfoto_gxi ;
   }

   public void setgxTv_SdtEspecialidad_Especialidadfoto_gxi( String value )
   {
      gxTv_SdtEspecialidad_N = (byte)(0) ;
      SetDirty("Especialidadfoto_gxi");
      gxTv_SdtEspecialidad_Especialidadfoto_gxi = value ;
   }

   public String getgxTv_SdtEspecialidad_Especialidadestado( )
   {
      return gxTv_SdtEspecialidad_Especialidadestado ;
   }

   public void setgxTv_SdtEspecialidad_Especialidadestado( String value )
   {
      gxTv_SdtEspecialidad_N = (byte)(0) ;
      SetDirty("Especialidadestado");
      gxTv_SdtEspecialidad_Especialidadestado = value ;
   }

   public GXBCLevelCollection<com.projectthani.SdtEspecialidad_Sede> getgxTv_SdtEspecialidad_Sede( )
   {
      if ( gxTv_SdtEspecialidad_Sede == null )
      {
         gxTv_SdtEspecialidad_Sede = new GXBCLevelCollection<com.projectthani.SdtEspecialidad_Sede>(com.projectthani.SdtEspecialidad_Sede.class, "Especialidad.Sede", "ProjectThani", remoteHandle);
      }
      gxTv_SdtEspecialidad_N = (byte)(0) ;
      return gxTv_SdtEspecialidad_Sede ;
   }

   public void setgxTv_SdtEspecialidad_Sede( GXBCLevelCollection<com.projectthani.SdtEspecialidad_Sede> value )
   {
      gxTv_SdtEspecialidad_N = (byte)(0) ;
      SetDirty("Sede");
      gxTv_SdtEspecialidad_Sede = value ;
   }

   public void setgxTv_SdtEspecialidad_Sede_SetNull( )
   {
      gxTv_SdtEspecialidad_Sede = null ;
   }

   public boolean getgxTv_SdtEspecialidad_Sede_IsNull( )
   {
      if ( gxTv_SdtEspecialidad_Sede == null )
      {
         return true ;
      }
      return false ;
   }

   public String getgxTv_SdtEspecialidad_Mode( )
   {
      return gxTv_SdtEspecialidad_Mode ;
   }

   public void setgxTv_SdtEspecialidad_Mode( String value )
   {
      gxTv_SdtEspecialidad_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtEspecialidad_Mode = value ;
   }

   public void setgxTv_SdtEspecialidad_Mode_SetNull( )
   {
      gxTv_SdtEspecialidad_Mode = "" ;
   }

   public boolean getgxTv_SdtEspecialidad_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEspecialidad_Initialized( )
   {
      return gxTv_SdtEspecialidad_Initialized ;
   }

   public void setgxTv_SdtEspecialidad_Initialized( short value )
   {
      gxTv_SdtEspecialidad_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtEspecialidad_Initialized = value ;
   }

   public void setgxTv_SdtEspecialidad_Initialized_SetNull( )
   {
      gxTv_SdtEspecialidad_Initialized = (short)(0) ;
   }

   public boolean getgxTv_SdtEspecialidad_Initialized_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEspecialidad_Especialidadid_Z( )
   {
      return gxTv_SdtEspecialidad_Especialidadid_Z ;
   }

   public void setgxTv_SdtEspecialidad_Especialidadid_Z( short value )
   {
      gxTv_SdtEspecialidad_N = (byte)(0) ;
      SetDirty("Especialidadid_Z");
      gxTv_SdtEspecialidad_Especialidadid_Z = value ;
   }

   public void setgxTv_SdtEspecialidad_Especialidadid_Z_SetNull( )
   {
      gxTv_SdtEspecialidad_Especialidadid_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtEspecialidad_Especialidadid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEspecialidad_Especialidadnombre_Z( )
   {
      return gxTv_SdtEspecialidad_Especialidadnombre_Z ;
   }

   public void setgxTv_SdtEspecialidad_Especialidadnombre_Z( String value )
   {
      gxTv_SdtEspecialidad_N = (byte)(0) ;
      SetDirty("Especialidadnombre_Z");
      gxTv_SdtEspecialidad_Especialidadnombre_Z = value ;
   }

   public void setgxTv_SdtEspecialidad_Especialidadnombre_Z_SetNull( )
   {
      gxTv_SdtEspecialidad_Especialidadnombre_Z = "" ;
   }

   public boolean getgxTv_SdtEspecialidad_Especialidadnombre_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEspecialidad_Especialidaddescripcion_Z( )
   {
      return gxTv_SdtEspecialidad_Especialidaddescripcion_Z ;
   }

   public void setgxTv_SdtEspecialidad_Especialidaddescripcion_Z( String value )
   {
      gxTv_SdtEspecialidad_N = (byte)(0) ;
      SetDirty("Especialidaddescripcion_Z");
      gxTv_SdtEspecialidad_Especialidaddescripcion_Z = value ;
   }

   public void setgxTv_SdtEspecialidad_Especialidaddescripcion_Z_SetNull( )
   {
      gxTv_SdtEspecialidad_Especialidaddescripcion_Z = "" ;
   }

   public boolean getgxTv_SdtEspecialidad_Especialidaddescripcion_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEspecialidad_Especialidadcodigo_Z( )
   {
      return gxTv_SdtEspecialidad_Especialidadcodigo_Z ;
   }

   public void setgxTv_SdtEspecialidad_Especialidadcodigo_Z( String value )
   {
      gxTv_SdtEspecialidad_N = (byte)(0) ;
      SetDirty("Especialidadcodigo_Z");
      gxTv_SdtEspecialidad_Especialidadcodigo_Z = value ;
   }

   public void setgxTv_SdtEspecialidad_Especialidadcodigo_Z_SetNull( )
   {
      gxTv_SdtEspecialidad_Especialidadcodigo_Z = "" ;
   }

   public boolean getgxTv_SdtEspecialidad_Especialidadcodigo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEspecialidad_Especialidadestado_Z( )
   {
      return gxTv_SdtEspecialidad_Especialidadestado_Z ;
   }

   public void setgxTv_SdtEspecialidad_Especialidadestado_Z( String value )
   {
      gxTv_SdtEspecialidad_N = (byte)(0) ;
      SetDirty("Especialidadestado_Z");
      gxTv_SdtEspecialidad_Especialidadestado_Z = value ;
   }

   public void setgxTv_SdtEspecialidad_Especialidadestado_Z_SetNull( )
   {
      gxTv_SdtEspecialidad_Especialidadestado_Z = "" ;
   }

   public boolean getgxTv_SdtEspecialidad_Especialidadestado_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEspecialidad_Especialidadfoto_gxi_Z( )
   {
      return gxTv_SdtEspecialidad_Especialidadfoto_gxi_Z ;
   }

   public void setgxTv_SdtEspecialidad_Especialidadfoto_gxi_Z( String value )
   {
      gxTv_SdtEspecialidad_N = (byte)(0) ;
      SetDirty("Especialidadfoto_gxi_Z");
      gxTv_SdtEspecialidad_Especialidadfoto_gxi_Z = value ;
   }

   public void setgxTv_SdtEspecialidad_Especialidadfoto_gxi_Z_SetNull( )
   {
      gxTv_SdtEspecialidad_Especialidadfoto_gxi_Z = "" ;
   }

   public boolean getgxTv_SdtEspecialidad_Especialidadfoto_gxi_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.projectthani.especialidad_bc obj;
      obj = new com.projectthani.especialidad_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtEspecialidad_N = (byte)(1) ;
      gxTv_SdtEspecialidad_Especialidadnombre = "" ;
      gxTv_SdtEspecialidad_Especialidaddescripcion = "" ;
      gxTv_SdtEspecialidad_Especialidadcodigo = "" ;
      gxTv_SdtEspecialidad_Especialidadfoto = "" ;
      gxTv_SdtEspecialidad_Especialidadfoto_gxi = "" ;
      gxTv_SdtEspecialidad_Especialidadestado = "" ;
      gxTv_SdtEspecialidad_Mode = "" ;
      gxTv_SdtEspecialidad_Especialidadnombre_Z = "" ;
      gxTv_SdtEspecialidad_Especialidaddescripcion_Z = "" ;
      gxTv_SdtEspecialidad_Especialidadcodigo_Z = "" ;
      gxTv_SdtEspecialidad_Especialidadestado_Z = "" ;
      gxTv_SdtEspecialidad_Especialidadfoto_gxi_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtEspecialidad_N ;
   }

   public com.projectthani.SdtEspecialidad Clone( )
   {
      com.projectthani.SdtEspecialidad sdt;
      com.projectthani.especialidad_bc obj;
      sdt = (com.projectthani.SdtEspecialidad)(clone()) ;
      obj = (com.projectthani.especialidad_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.projectthani.StructSdtEspecialidad struct )
   {
      setgxTv_SdtEspecialidad_Especialidadid(struct.getEspecialidadid());
      setgxTv_SdtEspecialidad_Especialidadnombre(struct.getEspecialidadnombre());
      setgxTv_SdtEspecialidad_Especialidaddescripcion(struct.getEspecialidaddescripcion());
      setgxTv_SdtEspecialidad_Especialidadcodigo(struct.getEspecialidadcodigo());
      setgxTv_SdtEspecialidad_Especialidadfoto(struct.getEspecialidadfoto());
      setgxTv_SdtEspecialidad_Especialidadfoto_gxi(struct.getEspecialidadfoto_gxi());
      setgxTv_SdtEspecialidad_Especialidadestado(struct.getEspecialidadestado());
      GXBCLevelCollection<com.projectthani.SdtEspecialidad_Sede> gxTv_SdtEspecialidad_Sede_aux = new GXBCLevelCollection<com.projectthani.SdtEspecialidad_Sede>(com.projectthani.SdtEspecialidad_Sede.class, "Especialidad.Sede", "ProjectThani", remoteHandle);
      Vector<com.projectthani.StructSdtEspecialidad_Sede> gxTv_SdtEspecialidad_Sede_aux1 = struct.getSede();
      if (gxTv_SdtEspecialidad_Sede_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtEspecialidad_Sede_aux1.size(); i++)
         {
            gxTv_SdtEspecialidad_Sede_aux.add(new com.projectthani.SdtEspecialidad_Sede(remoteHandle, gxTv_SdtEspecialidad_Sede_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtEspecialidad_Sede(gxTv_SdtEspecialidad_Sede_aux);
      setgxTv_SdtEspecialidad_Mode(struct.getMode());
      setgxTv_SdtEspecialidad_Initialized(struct.getInitialized());
      setgxTv_SdtEspecialidad_Especialidadid_Z(struct.getEspecialidadid_Z());
      setgxTv_SdtEspecialidad_Especialidadnombre_Z(struct.getEspecialidadnombre_Z());
      setgxTv_SdtEspecialidad_Especialidaddescripcion_Z(struct.getEspecialidaddescripcion_Z());
      setgxTv_SdtEspecialidad_Especialidadcodigo_Z(struct.getEspecialidadcodigo_Z());
      setgxTv_SdtEspecialidad_Especialidadestado_Z(struct.getEspecialidadestado_Z());
      setgxTv_SdtEspecialidad_Especialidadfoto_gxi_Z(struct.getEspecialidadfoto_gxi_Z());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtEspecialidad getStruct( )
   {
      com.projectthani.StructSdtEspecialidad struct = new com.projectthani.StructSdtEspecialidad ();
      struct.setEspecialidadid(getgxTv_SdtEspecialidad_Especialidadid());
      struct.setEspecialidadnombre(getgxTv_SdtEspecialidad_Especialidadnombre());
      struct.setEspecialidaddescripcion(getgxTv_SdtEspecialidad_Especialidaddescripcion());
      struct.setEspecialidadcodigo(getgxTv_SdtEspecialidad_Especialidadcodigo());
      struct.setEspecialidadfoto(getgxTv_SdtEspecialidad_Especialidadfoto());
      struct.setEspecialidadfoto_gxi(getgxTv_SdtEspecialidad_Especialidadfoto_gxi());
      struct.setEspecialidadestado(getgxTv_SdtEspecialidad_Especialidadestado());
      struct.setSede(getgxTv_SdtEspecialidad_Sede().getStruct());
      struct.setMode(getgxTv_SdtEspecialidad_Mode());
      struct.setInitialized(getgxTv_SdtEspecialidad_Initialized());
      struct.setEspecialidadid_Z(getgxTv_SdtEspecialidad_Especialidadid_Z());
      struct.setEspecialidadnombre_Z(getgxTv_SdtEspecialidad_Especialidadnombre_Z());
      struct.setEspecialidaddescripcion_Z(getgxTv_SdtEspecialidad_Especialidaddescripcion_Z());
      struct.setEspecialidadcodigo_Z(getgxTv_SdtEspecialidad_Especialidadcodigo_Z());
      struct.setEspecialidadestado_Z(getgxTv_SdtEspecialidad_Especialidadestado_Z());
      struct.setEspecialidadfoto_gxi_Z(getgxTv_SdtEspecialidad_Especialidadfoto_gxi_Z());
      return struct ;
   }

   private byte gxTv_SdtEspecialidad_N ;
   private short gxTv_SdtEspecialidad_Especialidadid ;
   private short gxTv_SdtEspecialidad_Initialized ;
   private short gxTv_SdtEspecialidad_Especialidadid_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtEspecialidad_Especialidadestado ;
   private String gxTv_SdtEspecialidad_Mode ;
   private String gxTv_SdtEspecialidad_Especialidadestado_Z ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtEspecialidad_Especialidadnombre ;
   private String gxTv_SdtEspecialidad_Especialidaddescripcion ;
   private String gxTv_SdtEspecialidad_Especialidadcodigo ;
   private String gxTv_SdtEspecialidad_Especialidadfoto_gxi ;
   private String gxTv_SdtEspecialidad_Especialidadnombre_Z ;
   private String gxTv_SdtEspecialidad_Especialidaddescripcion_Z ;
   private String gxTv_SdtEspecialidad_Especialidadcodigo_Z ;
   private String gxTv_SdtEspecialidad_Especialidadfoto_gxi_Z ;
   private String gxTv_SdtEspecialidad_Especialidadfoto ;
   private GXBCLevelCollection<com.projectthani.SdtEspecialidad_Sede> gxTv_SdtEspecialidad_Sede_aux ;
   private GXBCLevelCollection<com.projectthani.SdtEspecialidad_Sede> gxTv_SdtEspecialidad_Sede=null ;
}

