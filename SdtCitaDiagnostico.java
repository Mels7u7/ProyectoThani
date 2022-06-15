package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtCitaDiagnostico extends GxSilentTrnSdt implements Cloneable, java.io.Serializable
{
   public SdtCitaDiagnostico( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtCitaDiagnostico.class));
   }

   public SdtCitaDiagnostico( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle, context, "SdtCitaDiagnostico");
      initialize( remoteHandle) ;
   }

   public SdtCitaDiagnostico( int remoteHandle ,
                              StructSdtCitaDiagnostico struct )
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

   public void Load( int AV22CitaDiagnosticoId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV22CitaDiagnosticoId)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"CitaDiagnosticoId", int.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "CitaDiagnostico");
      metadata.set("BT", "CitaDiagnostico");
      metadata.set("PK", "[ \"CitaDiagnosticoId\" ]");
      metadata.set("PKAssigned", "[ \"CitaDiagnosticoId\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CitaId\" ],\"FKMap\":[  ] },{ \"FK\":[ \"DiagnosticoId\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaDiagnosticoId") )
            {
               gxTv_SdtCitaDiagnostico_Citadiagnosticoid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaId") )
            {
               gxTv_SdtCitaDiagnostico_Citaid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DiagnosticoId") )
            {
               gxTv_SdtCitaDiagnostico_Diagnosticoid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaDiagnosticoEstado") )
            {
               gxTv_SdtCitaDiagnostico_Citadiagnosticoestado = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtCitaDiagnostico_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtCitaDiagnostico_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaDiagnosticoId_Z") )
            {
               gxTv_SdtCitaDiagnostico_Citadiagnosticoid_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaId_Z") )
            {
               gxTv_SdtCitaDiagnostico_Citaid_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DiagnosticoId_Z") )
            {
               gxTv_SdtCitaDiagnostico_Diagnosticoid_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaDiagnosticoEstado_Z") )
            {
               gxTv_SdtCitaDiagnostico_Citadiagnosticoestado_Z = oReader.getValue() ;
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
         sName = "CitaDiagnostico" ;
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
      oWriter.writeElement("CitaDiagnosticoId", GXutil.trim( GXutil.str( gxTv_SdtCitaDiagnostico_Citadiagnosticoid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaId", GXutil.trim( GXutil.str( gxTv_SdtCitaDiagnostico_Citaid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("DiagnosticoId", GXutil.trim( GXutil.str( gxTv_SdtCitaDiagnostico_Diagnosticoid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaDiagnosticoEstado", GXutil.rtrim( gxTv_SdtCitaDiagnostico_Citadiagnosticoestado));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", GXutil.rtrim( gxTv_SdtCitaDiagnostico_Mode));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtCitaDiagnostico_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaDiagnosticoId_Z", GXutil.trim( GXutil.str( gxTv_SdtCitaDiagnostico_Citadiagnosticoid_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaId_Z", GXutil.trim( GXutil.str( gxTv_SdtCitaDiagnostico_Citaid_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("DiagnosticoId_Z", GXutil.trim( GXutil.str( gxTv_SdtCitaDiagnostico_Diagnosticoid_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaDiagnosticoEstado_Z", GXutil.rtrim( gxTv_SdtCitaDiagnostico_Citadiagnosticoestado_Z));
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
      AddObjectProperty("CitaDiagnosticoId", gxTv_SdtCitaDiagnostico_Citadiagnosticoid, false, includeNonInitialized);
      AddObjectProperty("CitaId", gxTv_SdtCitaDiagnostico_Citaid, false, includeNonInitialized);
      AddObjectProperty("DiagnosticoId", gxTv_SdtCitaDiagnostico_Diagnosticoid, false, includeNonInitialized);
      AddObjectProperty("CitaDiagnosticoEstado", gxTv_SdtCitaDiagnostico_Citadiagnosticoestado, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtCitaDiagnostico_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtCitaDiagnostico_Initialized, false, includeNonInitialized);
         AddObjectProperty("CitaDiagnosticoId_Z", gxTv_SdtCitaDiagnostico_Citadiagnosticoid_Z, false, includeNonInitialized);
         AddObjectProperty("CitaId_Z", gxTv_SdtCitaDiagnostico_Citaid_Z, false, includeNonInitialized);
         AddObjectProperty("DiagnosticoId_Z", gxTv_SdtCitaDiagnostico_Diagnosticoid_Z, false, includeNonInitialized);
         AddObjectProperty("CitaDiagnosticoEstado_Z", gxTv_SdtCitaDiagnostico_Citadiagnosticoestado_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.projectthani.SdtCitaDiagnostico sdt )
   {
      if ( sdt.IsDirty("CitaDiagnosticoId") )
      {
         gxTv_SdtCitaDiagnostico_N = (byte)(0) ;
         gxTv_SdtCitaDiagnostico_Citadiagnosticoid = sdt.getgxTv_SdtCitaDiagnostico_Citadiagnosticoid() ;
      }
      if ( sdt.IsDirty("CitaId") )
      {
         gxTv_SdtCitaDiagnostico_N = (byte)(0) ;
         gxTv_SdtCitaDiagnostico_Citaid = sdt.getgxTv_SdtCitaDiagnostico_Citaid() ;
      }
      if ( sdt.IsDirty("DiagnosticoId") )
      {
         gxTv_SdtCitaDiagnostico_N = (byte)(0) ;
         gxTv_SdtCitaDiagnostico_Diagnosticoid = sdt.getgxTv_SdtCitaDiagnostico_Diagnosticoid() ;
      }
      if ( sdt.IsDirty("CitaDiagnosticoEstado") )
      {
         gxTv_SdtCitaDiagnostico_N = (byte)(0) ;
         gxTv_SdtCitaDiagnostico_Citadiagnosticoestado = sdt.getgxTv_SdtCitaDiagnostico_Citadiagnosticoestado() ;
      }
   }

   public int getgxTv_SdtCitaDiagnostico_Citadiagnosticoid( )
   {
      return gxTv_SdtCitaDiagnostico_Citadiagnosticoid ;
   }

   public void setgxTv_SdtCitaDiagnostico_Citadiagnosticoid( int value )
   {
      gxTv_SdtCitaDiagnostico_N = (byte)(0) ;
      if ( gxTv_SdtCitaDiagnostico_Citadiagnosticoid != value )
      {
         gxTv_SdtCitaDiagnostico_Mode = "INS" ;
         this.setgxTv_SdtCitaDiagnostico_Citadiagnosticoid_Z_SetNull( );
         this.setgxTv_SdtCitaDiagnostico_Citaid_Z_SetNull( );
         this.setgxTv_SdtCitaDiagnostico_Diagnosticoid_Z_SetNull( );
         this.setgxTv_SdtCitaDiagnostico_Citadiagnosticoestado_Z_SetNull( );
      }
      SetDirty("Citadiagnosticoid");
      gxTv_SdtCitaDiagnostico_Citadiagnosticoid = value ;
   }

   public int getgxTv_SdtCitaDiagnostico_Citaid( )
   {
      return gxTv_SdtCitaDiagnostico_Citaid ;
   }

   public void setgxTv_SdtCitaDiagnostico_Citaid( int value )
   {
      gxTv_SdtCitaDiagnostico_N = (byte)(0) ;
      SetDirty("Citaid");
      gxTv_SdtCitaDiagnostico_Citaid = value ;
   }

   public int getgxTv_SdtCitaDiagnostico_Diagnosticoid( )
   {
      return gxTv_SdtCitaDiagnostico_Diagnosticoid ;
   }

   public void setgxTv_SdtCitaDiagnostico_Diagnosticoid( int value )
   {
      gxTv_SdtCitaDiagnostico_N = (byte)(0) ;
      SetDirty("Diagnosticoid");
      gxTv_SdtCitaDiagnostico_Diagnosticoid = value ;
   }

   public String getgxTv_SdtCitaDiagnostico_Citadiagnosticoestado( )
   {
      return gxTv_SdtCitaDiagnostico_Citadiagnosticoestado ;
   }

   public void setgxTv_SdtCitaDiagnostico_Citadiagnosticoestado( String value )
   {
      gxTv_SdtCitaDiagnostico_N = (byte)(0) ;
      SetDirty("Citadiagnosticoestado");
      gxTv_SdtCitaDiagnostico_Citadiagnosticoestado = value ;
   }

   public String getgxTv_SdtCitaDiagnostico_Mode( )
   {
      return gxTv_SdtCitaDiagnostico_Mode ;
   }

   public void setgxTv_SdtCitaDiagnostico_Mode( String value )
   {
      gxTv_SdtCitaDiagnostico_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtCitaDiagnostico_Mode = value ;
   }

   public void setgxTv_SdtCitaDiagnostico_Mode_SetNull( )
   {
      gxTv_SdtCitaDiagnostico_Mode = "" ;
   }

   public boolean getgxTv_SdtCitaDiagnostico_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtCitaDiagnostico_Initialized( )
   {
      return gxTv_SdtCitaDiagnostico_Initialized ;
   }

   public void setgxTv_SdtCitaDiagnostico_Initialized( short value )
   {
      gxTv_SdtCitaDiagnostico_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtCitaDiagnostico_Initialized = value ;
   }

   public void setgxTv_SdtCitaDiagnostico_Initialized_SetNull( )
   {
      gxTv_SdtCitaDiagnostico_Initialized = (short)(0) ;
   }

   public boolean getgxTv_SdtCitaDiagnostico_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtCitaDiagnostico_Citadiagnosticoid_Z( )
   {
      return gxTv_SdtCitaDiagnostico_Citadiagnosticoid_Z ;
   }

   public void setgxTv_SdtCitaDiagnostico_Citadiagnosticoid_Z( int value )
   {
      gxTv_SdtCitaDiagnostico_N = (byte)(0) ;
      SetDirty("Citadiagnosticoid_Z");
      gxTv_SdtCitaDiagnostico_Citadiagnosticoid_Z = value ;
   }

   public void setgxTv_SdtCitaDiagnostico_Citadiagnosticoid_Z_SetNull( )
   {
      gxTv_SdtCitaDiagnostico_Citadiagnosticoid_Z = 0 ;
   }

   public boolean getgxTv_SdtCitaDiagnostico_Citadiagnosticoid_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtCitaDiagnostico_Citaid_Z( )
   {
      return gxTv_SdtCitaDiagnostico_Citaid_Z ;
   }

   public void setgxTv_SdtCitaDiagnostico_Citaid_Z( int value )
   {
      gxTv_SdtCitaDiagnostico_N = (byte)(0) ;
      SetDirty("Citaid_Z");
      gxTv_SdtCitaDiagnostico_Citaid_Z = value ;
   }

   public void setgxTv_SdtCitaDiagnostico_Citaid_Z_SetNull( )
   {
      gxTv_SdtCitaDiagnostico_Citaid_Z = 0 ;
   }

   public boolean getgxTv_SdtCitaDiagnostico_Citaid_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtCitaDiagnostico_Diagnosticoid_Z( )
   {
      return gxTv_SdtCitaDiagnostico_Diagnosticoid_Z ;
   }

   public void setgxTv_SdtCitaDiagnostico_Diagnosticoid_Z( int value )
   {
      gxTv_SdtCitaDiagnostico_N = (byte)(0) ;
      SetDirty("Diagnosticoid_Z");
      gxTv_SdtCitaDiagnostico_Diagnosticoid_Z = value ;
   }

   public void setgxTv_SdtCitaDiagnostico_Diagnosticoid_Z_SetNull( )
   {
      gxTv_SdtCitaDiagnostico_Diagnosticoid_Z = 0 ;
   }

   public boolean getgxTv_SdtCitaDiagnostico_Diagnosticoid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtCitaDiagnostico_Citadiagnosticoestado_Z( )
   {
      return gxTv_SdtCitaDiagnostico_Citadiagnosticoestado_Z ;
   }

   public void setgxTv_SdtCitaDiagnostico_Citadiagnosticoestado_Z( String value )
   {
      gxTv_SdtCitaDiagnostico_N = (byte)(0) ;
      SetDirty("Citadiagnosticoestado_Z");
      gxTv_SdtCitaDiagnostico_Citadiagnosticoestado_Z = value ;
   }

   public void setgxTv_SdtCitaDiagnostico_Citadiagnosticoestado_Z_SetNull( )
   {
      gxTv_SdtCitaDiagnostico_Citadiagnosticoestado_Z = "" ;
   }

   public boolean getgxTv_SdtCitaDiagnostico_Citadiagnosticoestado_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.projectthani.citadiagnostico_bc obj;
      obj = new com.projectthani.citadiagnostico_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtCitaDiagnostico_N = (byte)(1) ;
      gxTv_SdtCitaDiagnostico_Citadiagnosticoestado = "" ;
      gxTv_SdtCitaDiagnostico_Mode = "" ;
      gxTv_SdtCitaDiagnostico_Citadiagnosticoestado_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtCitaDiagnostico_N ;
   }

   public com.projectthani.SdtCitaDiagnostico Clone( )
   {
      com.projectthani.SdtCitaDiagnostico sdt;
      com.projectthani.citadiagnostico_bc obj;
      sdt = (com.projectthani.SdtCitaDiagnostico)(clone()) ;
      obj = (com.projectthani.citadiagnostico_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.projectthani.StructSdtCitaDiagnostico struct )
   {
      setgxTv_SdtCitaDiagnostico_Citadiagnosticoid(struct.getCitadiagnosticoid());
      setgxTv_SdtCitaDiagnostico_Citaid(struct.getCitaid());
      setgxTv_SdtCitaDiagnostico_Diagnosticoid(struct.getDiagnosticoid());
      setgxTv_SdtCitaDiagnostico_Citadiagnosticoestado(struct.getCitadiagnosticoestado());
      setgxTv_SdtCitaDiagnostico_Mode(struct.getMode());
      setgxTv_SdtCitaDiagnostico_Initialized(struct.getInitialized());
      setgxTv_SdtCitaDiagnostico_Citadiagnosticoid_Z(struct.getCitadiagnosticoid_Z());
      setgxTv_SdtCitaDiagnostico_Citaid_Z(struct.getCitaid_Z());
      setgxTv_SdtCitaDiagnostico_Diagnosticoid_Z(struct.getDiagnosticoid_Z());
      setgxTv_SdtCitaDiagnostico_Citadiagnosticoestado_Z(struct.getCitadiagnosticoestado_Z());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtCitaDiagnostico getStruct( )
   {
      com.projectthani.StructSdtCitaDiagnostico struct = new com.projectthani.StructSdtCitaDiagnostico ();
      struct.setCitadiagnosticoid(getgxTv_SdtCitaDiagnostico_Citadiagnosticoid());
      struct.setCitaid(getgxTv_SdtCitaDiagnostico_Citaid());
      struct.setDiagnosticoid(getgxTv_SdtCitaDiagnostico_Diagnosticoid());
      struct.setCitadiagnosticoestado(getgxTv_SdtCitaDiagnostico_Citadiagnosticoestado());
      struct.setMode(getgxTv_SdtCitaDiagnostico_Mode());
      struct.setInitialized(getgxTv_SdtCitaDiagnostico_Initialized());
      struct.setCitadiagnosticoid_Z(getgxTv_SdtCitaDiagnostico_Citadiagnosticoid_Z());
      struct.setCitaid_Z(getgxTv_SdtCitaDiagnostico_Citaid_Z());
      struct.setDiagnosticoid_Z(getgxTv_SdtCitaDiagnostico_Diagnosticoid_Z());
      struct.setCitadiagnosticoestado_Z(getgxTv_SdtCitaDiagnostico_Citadiagnosticoestado_Z());
      return struct ;
   }

   private byte gxTv_SdtCitaDiagnostico_N ;
   private short gxTv_SdtCitaDiagnostico_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtCitaDiagnostico_Citadiagnosticoid ;
   private int gxTv_SdtCitaDiagnostico_Citaid ;
   private int gxTv_SdtCitaDiagnostico_Diagnosticoid ;
   private int gxTv_SdtCitaDiagnostico_Citadiagnosticoid_Z ;
   private int gxTv_SdtCitaDiagnostico_Citaid_Z ;
   private int gxTv_SdtCitaDiagnostico_Diagnosticoid_Z ;
   private String gxTv_SdtCitaDiagnostico_Mode ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtCitaDiagnostico_Citadiagnosticoestado ;
   private String gxTv_SdtCitaDiagnostico_Citadiagnosticoestado_Z ;
}

