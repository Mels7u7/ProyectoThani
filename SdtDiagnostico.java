package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtDiagnostico extends GxSilentTrnSdt implements Cloneable, java.io.Serializable
{
   public SdtDiagnostico( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtDiagnostico.class));
   }

   public SdtDiagnostico( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle, context, "SdtDiagnostico");
      initialize( remoteHandle) ;
   }

   public SdtDiagnostico( int remoteHandle ,
                          StructSdtDiagnostico struct )
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

   public void Load( int AV23DiagnosticoId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV23DiagnosticoId)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"DiagnosticoId", int.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Diagnostico");
      metadata.set("BT", "Diagnostico");
      metadata.set("PK", "[ \"DiagnosticoId\" ]");
      metadata.set("PKAssigned", "[ \"DiagnosticoId\" ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "DiagnosticoId") )
            {
               gxTv_SdtDiagnostico_Diagnosticoid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DiagnosticoCodigo") )
            {
               gxTv_SdtDiagnostico_Diagnosticocodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DiagnosticoDescripcion") )
            {
               gxTv_SdtDiagnostico_Diagnosticodescripcion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DiagnosticoTipoSexo") )
            {
               gxTv_SdtDiagnostico_Diagnosticotiposexo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DiagnosticoEstado") )
            {
               gxTv_SdtDiagnostico_Diagnosticoestado = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DiagnosticoLongDesc") )
            {
               gxTv_SdtDiagnostico_Diagnosticolongdesc = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtDiagnostico_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtDiagnostico_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DiagnosticoId_Z") )
            {
               gxTv_SdtDiagnostico_Diagnosticoid_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DiagnosticoCodigo_Z") )
            {
               gxTv_SdtDiagnostico_Diagnosticocodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DiagnosticoDescripcion_Z") )
            {
               gxTv_SdtDiagnostico_Diagnosticodescripcion_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DiagnosticoTipoSexo_Z") )
            {
               gxTv_SdtDiagnostico_Diagnosticotiposexo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DiagnosticoEstado_Z") )
            {
               gxTv_SdtDiagnostico_Diagnosticoestado_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DiagnosticoLongDesc_Z") )
            {
               gxTv_SdtDiagnostico_Diagnosticolongdesc_Z = oReader.getValue() ;
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
         sName = "Diagnostico" ;
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
      oWriter.writeElement("DiagnosticoId", GXutil.trim( GXutil.str( gxTv_SdtDiagnostico_Diagnosticoid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("DiagnosticoCodigo", GXutil.rtrim( gxTv_SdtDiagnostico_Diagnosticocodigo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("DiagnosticoDescripcion", GXutil.rtrim( gxTv_SdtDiagnostico_Diagnosticodescripcion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("DiagnosticoTipoSexo", GXutil.rtrim( gxTv_SdtDiagnostico_Diagnosticotiposexo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("DiagnosticoEstado", GXutil.rtrim( gxTv_SdtDiagnostico_Diagnosticoestado));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("DiagnosticoLongDesc", GXutil.rtrim( gxTv_SdtDiagnostico_Diagnosticolongdesc));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", GXutil.rtrim( gxTv_SdtDiagnostico_Mode));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtDiagnostico_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("DiagnosticoId_Z", GXutil.trim( GXutil.str( gxTv_SdtDiagnostico_Diagnosticoid_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("DiagnosticoCodigo_Z", GXutil.rtrim( gxTv_SdtDiagnostico_Diagnosticocodigo_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("DiagnosticoDescripcion_Z", GXutil.rtrim( gxTv_SdtDiagnostico_Diagnosticodescripcion_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("DiagnosticoTipoSexo_Z", GXutil.rtrim( gxTv_SdtDiagnostico_Diagnosticotiposexo_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("DiagnosticoEstado_Z", GXutil.rtrim( gxTv_SdtDiagnostico_Diagnosticoestado_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("DiagnosticoLongDesc_Z", GXutil.rtrim( gxTv_SdtDiagnostico_Diagnosticolongdesc_Z));
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
      AddObjectProperty("DiagnosticoId", gxTv_SdtDiagnostico_Diagnosticoid, false, includeNonInitialized);
      AddObjectProperty("DiagnosticoCodigo", gxTv_SdtDiagnostico_Diagnosticocodigo, false, includeNonInitialized);
      AddObjectProperty("DiagnosticoDescripcion", gxTv_SdtDiagnostico_Diagnosticodescripcion, false, includeNonInitialized);
      AddObjectProperty("DiagnosticoTipoSexo", gxTv_SdtDiagnostico_Diagnosticotiposexo, false, includeNonInitialized);
      AddObjectProperty("DiagnosticoEstado", gxTv_SdtDiagnostico_Diagnosticoestado, false, includeNonInitialized);
      AddObjectProperty("DiagnosticoLongDesc", gxTv_SdtDiagnostico_Diagnosticolongdesc, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtDiagnostico_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtDiagnostico_Initialized, false, includeNonInitialized);
         AddObjectProperty("DiagnosticoId_Z", gxTv_SdtDiagnostico_Diagnosticoid_Z, false, includeNonInitialized);
         AddObjectProperty("DiagnosticoCodigo_Z", gxTv_SdtDiagnostico_Diagnosticocodigo_Z, false, includeNonInitialized);
         AddObjectProperty("DiagnosticoDescripcion_Z", gxTv_SdtDiagnostico_Diagnosticodescripcion_Z, false, includeNonInitialized);
         AddObjectProperty("DiagnosticoTipoSexo_Z", gxTv_SdtDiagnostico_Diagnosticotiposexo_Z, false, includeNonInitialized);
         AddObjectProperty("DiagnosticoEstado_Z", gxTv_SdtDiagnostico_Diagnosticoestado_Z, false, includeNonInitialized);
         AddObjectProperty("DiagnosticoLongDesc_Z", gxTv_SdtDiagnostico_Diagnosticolongdesc_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.projectthani.SdtDiagnostico sdt )
   {
      if ( sdt.IsDirty("DiagnosticoId") )
      {
         gxTv_SdtDiagnostico_N = (byte)(0) ;
         gxTv_SdtDiagnostico_Diagnosticoid = sdt.getgxTv_SdtDiagnostico_Diagnosticoid() ;
      }
      if ( sdt.IsDirty("DiagnosticoCodigo") )
      {
         gxTv_SdtDiagnostico_N = (byte)(0) ;
         gxTv_SdtDiagnostico_Diagnosticocodigo = sdt.getgxTv_SdtDiagnostico_Diagnosticocodigo() ;
      }
      if ( sdt.IsDirty("DiagnosticoDescripcion") )
      {
         gxTv_SdtDiagnostico_N = (byte)(0) ;
         gxTv_SdtDiagnostico_Diagnosticodescripcion = sdt.getgxTv_SdtDiagnostico_Diagnosticodescripcion() ;
      }
      if ( sdt.IsDirty("DiagnosticoTipoSexo") )
      {
         gxTv_SdtDiagnostico_N = (byte)(0) ;
         gxTv_SdtDiagnostico_Diagnosticotiposexo = sdt.getgxTv_SdtDiagnostico_Diagnosticotiposexo() ;
      }
      if ( sdt.IsDirty("DiagnosticoEstado") )
      {
         gxTv_SdtDiagnostico_N = (byte)(0) ;
         gxTv_SdtDiagnostico_Diagnosticoestado = sdt.getgxTv_SdtDiagnostico_Diagnosticoestado() ;
      }
      if ( sdt.IsDirty("DiagnosticoLongDesc") )
      {
         gxTv_SdtDiagnostico_N = (byte)(0) ;
         gxTv_SdtDiagnostico_Diagnosticolongdesc = sdt.getgxTv_SdtDiagnostico_Diagnosticolongdesc() ;
      }
   }

   public int getgxTv_SdtDiagnostico_Diagnosticoid( )
   {
      return gxTv_SdtDiagnostico_Diagnosticoid ;
   }

   public void setgxTv_SdtDiagnostico_Diagnosticoid( int value )
   {
      gxTv_SdtDiagnostico_N = (byte)(0) ;
      if ( gxTv_SdtDiagnostico_Diagnosticoid != value )
      {
         gxTv_SdtDiagnostico_Mode = "INS" ;
         this.setgxTv_SdtDiagnostico_Diagnosticoid_Z_SetNull( );
         this.setgxTv_SdtDiagnostico_Diagnosticocodigo_Z_SetNull( );
         this.setgxTv_SdtDiagnostico_Diagnosticodescripcion_Z_SetNull( );
         this.setgxTv_SdtDiagnostico_Diagnosticotiposexo_Z_SetNull( );
         this.setgxTv_SdtDiagnostico_Diagnosticoestado_Z_SetNull( );
         this.setgxTv_SdtDiagnostico_Diagnosticolongdesc_Z_SetNull( );
      }
      SetDirty("Diagnosticoid");
      gxTv_SdtDiagnostico_Diagnosticoid = value ;
   }

   public String getgxTv_SdtDiagnostico_Diagnosticocodigo( )
   {
      return gxTv_SdtDiagnostico_Diagnosticocodigo ;
   }

   public void setgxTv_SdtDiagnostico_Diagnosticocodigo( String value )
   {
      gxTv_SdtDiagnostico_N = (byte)(0) ;
      SetDirty("Diagnosticocodigo");
      gxTv_SdtDiagnostico_Diagnosticocodigo = value ;
   }

   public String getgxTv_SdtDiagnostico_Diagnosticodescripcion( )
   {
      return gxTv_SdtDiagnostico_Diagnosticodescripcion ;
   }

   public void setgxTv_SdtDiagnostico_Diagnosticodescripcion( String value )
   {
      gxTv_SdtDiagnostico_N = (byte)(0) ;
      SetDirty("Diagnosticodescripcion");
      gxTv_SdtDiagnostico_Diagnosticodescripcion = value ;
   }

   public String getgxTv_SdtDiagnostico_Diagnosticotiposexo( )
   {
      return gxTv_SdtDiagnostico_Diagnosticotiposexo ;
   }

   public void setgxTv_SdtDiagnostico_Diagnosticotiposexo( String value )
   {
      gxTv_SdtDiagnostico_N = (byte)(0) ;
      SetDirty("Diagnosticotiposexo");
      gxTv_SdtDiagnostico_Diagnosticotiposexo = value ;
   }

   public String getgxTv_SdtDiagnostico_Diagnosticoestado( )
   {
      return gxTv_SdtDiagnostico_Diagnosticoestado ;
   }

   public void setgxTv_SdtDiagnostico_Diagnosticoestado( String value )
   {
      gxTv_SdtDiagnostico_N = (byte)(0) ;
      SetDirty("Diagnosticoestado");
      gxTv_SdtDiagnostico_Diagnosticoestado = value ;
   }

   public String getgxTv_SdtDiagnostico_Diagnosticolongdesc( )
   {
      return gxTv_SdtDiagnostico_Diagnosticolongdesc ;
   }

   public void setgxTv_SdtDiagnostico_Diagnosticolongdesc( String value )
   {
      gxTv_SdtDiagnostico_N = (byte)(0) ;
      SetDirty("Diagnosticolongdesc");
      gxTv_SdtDiagnostico_Diagnosticolongdesc = value ;
   }

   public void setgxTv_SdtDiagnostico_Diagnosticolongdesc_SetNull( )
   {
      gxTv_SdtDiagnostico_Diagnosticolongdesc = "" ;
   }

   public boolean getgxTv_SdtDiagnostico_Diagnosticolongdesc_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtDiagnostico_Mode( )
   {
      return gxTv_SdtDiagnostico_Mode ;
   }

   public void setgxTv_SdtDiagnostico_Mode( String value )
   {
      gxTv_SdtDiagnostico_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtDiagnostico_Mode = value ;
   }

   public void setgxTv_SdtDiagnostico_Mode_SetNull( )
   {
      gxTv_SdtDiagnostico_Mode = "" ;
   }

   public boolean getgxTv_SdtDiagnostico_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtDiagnostico_Initialized( )
   {
      return gxTv_SdtDiagnostico_Initialized ;
   }

   public void setgxTv_SdtDiagnostico_Initialized( short value )
   {
      gxTv_SdtDiagnostico_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtDiagnostico_Initialized = value ;
   }

   public void setgxTv_SdtDiagnostico_Initialized_SetNull( )
   {
      gxTv_SdtDiagnostico_Initialized = (short)(0) ;
   }

   public boolean getgxTv_SdtDiagnostico_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtDiagnostico_Diagnosticoid_Z( )
   {
      return gxTv_SdtDiagnostico_Diagnosticoid_Z ;
   }

   public void setgxTv_SdtDiagnostico_Diagnosticoid_Z( int value )
   {
      gxTv_SdtDiagnostico_N = (byte)(0) ;
      SetDirty("Diagnosticoid_Z");
      gxTv_SdtDiagnostico_Diagnosticoid_Z = value ;
   }

   public void setgxTv_SdtDiagnostico_Diagnosticoid_Z_SetNull( )
   {
      gxTv_SdtDiagnostico_Diagnosticoid_Z = 0 ;
   }

   public boolean getgxTv_SdtDiagnostico_Diagnosticoid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtDiagnostico_Diagnosticocodigo_Z( )
   {
      return gxTv_SdtDiagnostico_Diagnosticocodigo_Z ;
   }

   public void setgxTv_SdtDiagnostico_Diagnosticocodigo_Z( String value )
   {
      gxTv_SdtDiagnostico_N = (byte)(0) ;
      SetDirty("Diagnosticocodigo_Z");
      gxTv_SdtDiagnostico_Diagnosticocodigo_Z = value ;
   }

   public void setgxTv_SdtDiagnostico_Diagnosticocodigo_Z_SetNull( )
   {
      gxTv_SdtDiagnostico_Diagnosticocodigo_Z = "" ;
   }

   public boolean getgxTv_SdtDiagnostico_Diagnosticocodigo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtDiagnostico_Diagnosticodescripcion_Z( )
   {
      return gxTv_SdtDiagnostico_Diagnosticodescripcion_Z ;
   }

   public void setgxTv_SdtDiagnostico_Diagnosticodescripcion_Z( String value )
   {
      gxTv_SdtDiagnostico_N = (byte)(0) ;
      SetDirty("Diagnosticodescripcion_Z");
      gxTv_SdtDiagnostico_Diagnosticodescripcion_Z = value ;
   }

   public void setgxTv_SdtDiagnostico_Diagnosticodescripcion_Z_SetNull( )
   {
      gxTv_SdtDiagnostico_Diagnosticodescripcion_Z = "" ;
   }

   public boolean getgxTv_SdtDiagnostico_Diagnosticodescripcion_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtDiagnostico_Diagnosticotiposexo_Z( )
   {
      return gxTv_SdtDiagnostico_Diagnosticotiposexo_Z ;
   }

   public void setgxTv_SdtDiagnostico_Diagnosticotiposexo_Z( String value )
   {
      gxTv_SdtDiagnostico_N = (byte)(0) ;
      SetDirty("Diagnosticotiposexo_Z");
      gxTv_SdtDiagnostico_Diagnosticotiposexo_Z = value ;
   }

   public void setgxTv_SdtDiagnostico_Diagnosticotiposexo_Z_SetNull( )
   {
      gxTv_SdtDiagnostico_Diagnosticotiposexo_Z = "" ;
   }

   public boolean getgxTv_SdtDiagnostico_Diagnosticotiposexo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtDiagnostico_Diagnosticoestado_Z( )
   {
      return gxTv_SdtDiagnostico_Diagnosticoestado_Z ;
   }

   public void setgxTv_SdtDiagnostico_Diagnosticoestado_Z( String value )
   {
      gxTv_SdtDiagnostico_N = (byte)(0) ;
      SetDirty("Diagnosticoestado_Z");
      gxTv_SdtDiagnostico_Diagnosticoestado_Z = value ;
   }

   public void setgxTv_SdtDiagnostico_Diagnosticoestado_Z_SetNull( )
   {
      gxTv_SdtDiagnostico_Diagnosticoestado_Z = "" ;
   }

   public boolean getgxTv_SdtDiagnostico_Diagnosticoestado_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtDiagnostico_Diagnosticolongdesc_Z( )
   {
      return gxTv_SdtDiagnostico_Diagnosticolongdesc_Z ;
   }

   public void setgxTv_SdtDiagnostico_Diagnosticolongdesc_Z( String value )
   {
      gxTv_SdtDiagnostico_N = (byte)(0) ;
      SetDirty("Diagnosticolongdesc_Z");
      gxTv_SdtDiagnostico_Diagnosticolongdesc_Z = value ;
   }

   public void setgxTv_SdtDiagnostico_Diagnosticolongdesc_Z_SetNull( )
   {
      gxTv_SdtDiagnostico_Diagnosticolongdesc_Z = "" ;
   }

   public boolean getgxTv_SdtDiagnostico_Diagnosticolongdesc_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.projectthani.diagnostico_bc obj;
      obj = new com.projectthani.diagnostico_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtDiagnostico_N = (byte)(1) ;
      gxTv_SdtDiagnostico_Diagnosticocodigo = "" ;
      gxTv_SdtDiagnostico_Diagnosticodescripcion = "" ;
      gxTv_SdtDiagnostico_Diagnosticotiposexo = "" ;
      gxTv_SdtDiagnostico_Diagnosticoestado = "" ;
      gxTv_SdtDiagnostico_Diagnosticolongdesc = "" ;
      gxTv_SdtDiagnostico_Mode = "" ;
      gxTv_SdtDiagnostico_Diagnosticocodigo_Z = "" ;
      gxTv_SdtDiagnostico_Diagnosticodescripcion_Z = "" ;
      gxTv_SdtDiagnostico_Diagnosticotiposexo_Z = "" ;
      gxTv_SdtDiagnostico_Diagnosticoestado_Z = "" ;
      gxTv_SdtDiagnostico_Diagnosticolongdesc_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtDiagnostico_N ;
   }

   public com.projectthani.SdtDiagnostico Clone( )
   {
      com.projectthani.SdtDiagnostico sdt;
      com.projectthani.diagnostico_bc obj;
      sdt = (com.projectthani.SdtDiagnostico)(clone()) ;
      obj = (com.projectthani.diagnostico_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.projectthani.StructSdtDiagnostico struct )
   {
      setgxTv_SdtDiagnostico_Diagnosticoid(struct.getDiagnosticoid());
      setgxTv_SdtDiagnostico_Diagnosticocodigo(struct.getDiagnosticocodigo());
      setgxTv_SdtDiagnostico_Diagnosticodescripcion(struct.getDiagnosticodescripcion());
      setgxTv_SdtDiagnostico_Diagnosticotiposexo(struct.getDiagnosticotiposexo());
      setgxTv_SdtDiagnostico_Diagnosticoestado(struct.getDiagnosticoestado());
      setgxTv_SdtDiagnostico_Diagnosticolongdesc(struct.getDiagnosticolongdesc());
      setgxTv_SdtDiagnostico_Mode(struct.getMode());
      setgxTv_SdtDiagnostico_Initialized(struct.getInitialized());
      setgxTv_SdtDiagnostico_Diagnosticoid_Z(struct.getDiagnosticoid_Z());
      setgxTv_SdtDiagnostico_Diagnosticocodigo_Z(struct.getDiagnosticocodigo_Z());
      setgxTv_SdtDiagnostico_Diagnosticodescripcion_Z(struct.getDiagnosticodescripcion_Z());
      setgxTv_SdtDiagnostico_Diagnosticotiposexo_Z(struct.getDiagnosticotiposexo_Z());
      setgxTv_SdtDiagnostico_Diagnosticoestado_Z(struct.getDiagnosticoestado_Z());
      setgxTv_SdtDiagnostico_Diagnosticolongdesc_Z(struct.getDiagnosticolongdesc_Z());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtDiagnostico getStruct( )
   {
      com.projectthani.StructSdtDiagnostico struct = new com.projectthani.StructSdtDiagnostico ();
      struct.setDiagnosticoid(getgxTv_SdtDiagnostico_Diagnosticoid());
      struct.setDiagnosticocodigo(getgxTv_SdtDiagnostico_Diagnosticocodigo());
      struct.setDiagnosticodescripcion(getgxTv_SdtDiagnostico_Diagnosticodescripcion());
      struct.setDiagnosticotiposexo(getgxTv_SdtDiagnostico_Diagnosticotiposexo());
      struct.setDiagnosticoestado(getgxTv_SdtDiagnostico_Diagnosticoestado());
      struct.setDiagnosticolongdesc(getgxTv_SdtDiagnostico_Diagnosticolongdesc());
      struct.setMode(getgxTv_SdtDiagnostico_Mode());
      struct.setInitialized(getgxTv_SdtDiagnostico_Initialized());
      struct.setDiagnosticoid_Z(getgxTv_SdtDiagnostico_Diagnosticoid_Z());
      struct.setDiagnosticocodigo_Z(getgxTv_SdtDiagnostico_Diagnosticocodigo_Z());
      struct.setDiagnosticodescripcion_Z(getgxTv_SdtDiagnostico_Diagnosticodescripcion_Z());
      struct.setDiagnosticotiposexo_Z(getgxTv_SdtDiagnostico_Diagnosticotiposexo_Z());
      struct.setDiagnosticoestado_Z(getgxTv_SdtDiagnostico_Diagnosticoestado_Z());
      struct.setDiagnosticolongdesc_Z(getgxTv_SdtDiagnostico_Diagnosticolongdesc_Z());
      return struct ;
   }

   private byte gxTv_SdtDiagnostico_N ;
   private short gxTv_SdtDiagnostico_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtDiagnostico_Diagnosticoid ;
   private int gxTv_SdtDiagnostico_Diagnosticoid_Z ;
   private String gxTv_SdtDiagnostico_Diagnosticotiposexo ;
   private String gxTv_SdtDiagnostico_Diagnosticoestado ;
   private String gxTv_SdtDiagnostico_Mode ;
   private String gxTv_SdtDiagnostico_Diagnosticotiposexo_Z ;
   private String gxTv_SdtDiagnostico_Diagnosticoestado_Z ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtDiagnostico_Diagnosticocodigo ;
   private String gxTv_SdtDiagnostico_Diagnosticodescripcion ;
   private String gxTv_SdtDiagnostico_Diagnosticolongdesc ;
   private String gxTv_SdtDiagnostico_Diagnosticocodigo_Z ;
   private String gxTv_SdtDiagnostico_Diagnosticodescripcion_Z ;
   private String gxTv_SdtDiagnostico_Diagnosticolongdesc_Z ;
}

