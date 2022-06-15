package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtConfig extends GxSilentTrnSdt implements Cloneable, java.io.Serializable
{
   public SdtConfig( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtConfig.class));
   }

   public SdtConfig( int remoteHandle ,
                     ModelContext context )
   {
      super( remoteHandle, context, "SdtConfig");
      initialize( remoteHandle) ;
   }

   public SdtConfig( int remoteHandle ,
                     StructSdtConfig struct )
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

   public void Load( short AV33ConfigId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Short.valueOf(AV33ConfigId)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"ConfigId", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Config");
      metadata.set("BT", "Config");
      metadata.set("PK", "[ \"ConfigId\" ]");
      metadata.set("PKAssigned", "[ \"ConfigId\" ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConfigId") )
            {
               gxTv_SdtConfig_Configid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConfigKey") )
            {
               gxTv_SdtConfig_Configkey = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConfigValue") )
            {
               gxTv_SdtConfig_Configvalue = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConfigEstadoR") )
            {
               gxTv_SdtConfig_Configestador = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtConfig_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtConfig_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConfigId_Z") )
            {
               gxTv_SdtConfig_Configid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConfigKey_Z") )
            {
               gxTv_SdtConfig_Configkey_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConfigValue_Z") )
            {
               gxTv_SdtConfig_Configvalue_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConfigEstadoR_Z") )
            {
               gxTv_SdtConfig_Configestador_Z = oReader.getValue() ;
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
         sName = "Config" ;
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
      oWriter.writeElement("ConfigId", GXutil.trim( GXutil.str( gxTv_SdtConfig_Configid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ConfigKey", GXutil.rtrim( gxTv_SdtConfig_Configkey));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ConfigValue", GXutil.rtrim( gxTv_SdtConfig_Configvalue));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ConfigEstadoR", GXutil.rtrim( gxTv_SdtConfig_Configestador));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", GXutil.rtrim( gxTv_SdtConfig_Mode));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtConfig_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ConfigId_Z", GXutil.trim( GXutil.str( gxTv_SdtConfig_Configid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ConfigKey_Z", GXutil.rtrim( gxTv_SdtConfig_Configkey_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ConfigValue_Z", GXutil.rtrim( gxTv_SdtConfig_Configvalue_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ConfigEstadoR_Z", GXutil.rtrim( gxTv_SdtConfig_Configestador_Z));
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
      AddObjectProperty("ConfigId", gxTv_SdtConfig_Configid, false, includeNonInitialized);
      AddObjectProperty("ConfigKey", gxTv_SdtConfig_Configkey, false, includeNonInitialized);
      AddObjectProperty("ConfigValue", gxTv_SdtConfig_Configvalue, false, includeNonInitialized);
      AddObjectProperty("ConfigEstadoR", gxTv_SdtConfig_Configestador, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtConfig_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtConfig_Initialized, false, includeNonInitialized);
         AddObjectProperty("ConfigId_Z", gxTv_SdtConfig_Configid_Z, false, includeNonInitialized);
         AddObjectProperty("ConfigKey_Z", gxTv_SdtConfig_Configkey_Z, false, includeNonInitialized);
         AddObjectProperty("ConfigValue_Z", gxTv_SdtConfig_Configvalue_Z, false, includeNonInitialized);
         AddObjectProperty("ConfigEstadoR_Z", gxTv_SdtConfig_Configestador_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.projectthani.SdtConfig sdt )
   {
      if ( sdt.IsDirty("ConfigId") )
      {
         gxTv_SdtConfig_N = (byte)(0) ;
         gxTv_SdtConfig_Configid = sdt.getgxTv_SdtConfig_Configid() ;
      }
      if ( sdt.IsDirty("ConfigKey") )
      {
         gxTv_SdtConfig_N = (byte)(0) ;
         gxTv_SdtConfig_Configkey = sdt.getgxTv_SdtConfig_Configkey() ;
      }
      if ( sdt.IsDirty("ConfigValue") )
      {
         gxTv_SdtConfig_N = (byte)(0) ;
         gxTv_SdtConfig_Configvalue = sdt.getgxTv_SdtConfig_Configvalue() ;
      }
      if ( sdt.IsDirty("ConfigEstadoR") )
      {
         gxTv_SdtConfig_N = (byte)(0) ;
         gxTv_SdtConfig_Configestador = sdt.getgxTv_SdtConfig_Configestador() ;
      }
   }

   public short getgxTv_SdtConfig_Configid( )
   {
      return gxTv_SdtConfig_Configid ;
   }

   public void setgxTv_SdtConfig_Configid( short value )
   {
      gxTv_SdtConfig_N = (byte)(0) ;
      if ( gxTv_SdtConfig_Configid != value )
      {
         gxTv_SdtConfig_Mode = "INS" ;
         this.setgxTv_SdtConfig_Configid_Z_SetNull( );
         this.setgxTv_SdtConfig_Configkey_Z_SetNull( );
         this.setgxTv_SdtConfig_Configvalue_Z_SetNull( );
         this.setgxTv_SdtConfig_Configestador_Z_SetNull( );
      }
      SetDirty("Configid");
      gxTv_SdtConfig_Configid = value ;
   }

   public String getgxTv_SdtConfig_Configkey( )
   {
      return gxTv_SdtConfig_Configkey ;
   }

   public void setgxTv_SdtConfig_Configkey( String value )
   {
      gxTv_SdtConfig_N = (byte)(0) ;
      SetDirty("Configkey");
      gxTv_SdtConfig_Configkey = value ;
   }

   public String getgxTv_SdtConfig_Configvalue( )
   {
      return gxTv_SdtConfig_Configvalue ;
   }

   public void setgxTv_SdtConfig_Configvalue( String value )
   {
      gxTv_SdtConfig_N = (byte)(0) ;
      SetDirty("Configvalue");
      gxTv_SdtConfig_Configvalue = value ;
   }

   public String getgxTv_SdtConfig_Configestador( )
   {
      return gxTv_SdtConfig_Configestador ;
   }

   public void setgxTv_SdtConfig_Configestador( String value )
   {
      gxTv_SdtConfig_N = (byte)(0) ;
      SetDirty("Configestador");
      gxTv_SdtConfig_Configestador = value ;
   }

   public String getgxTv_SdtConfig_Mode( )
   {
      return gxTv_SdtConfig_Mode ;
   }

   public void setgxTv_SdtConfig_Mode( String value )
   {
      gxTv_SdtConfig_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtConfig_Mode = value ;
   }

   public void setgxTv_SdtConfig_Mode_SetNull( )
   {
      gxTv_SdtConfig_Mode = "" ;
   }

   public boolean getgxTv_SdtConfig_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtConfig_Initialized( )
   {
      return gxTv_SdtConfig_Initialized ;
   }

   public void setgxTv_SdtConfig_Initialized( short value )
   {
      gxTv_SdtConfig_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtConfig_Initialized = value ;
   }

   public void setgxTv_SdtConfig_Initialized_SetNull( )
   {
      gxTv_SdtConfig_Initialized = (short)(0) ;
   }

   public boolean getgxTv_SdtConfig_Initialized_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtConfig_Configid_Z( )
   {
      return gxTv_SdtConfig_Configid_Z ;
   }

   public void setgxTv_SdtConfig_Configid_Z( short value )
   {
      gxTv_SdtConfig_N = (byte)(0) ;
      SetDirty("Configid_Z");
      gxTv_SdtConfig_Configid_Z = value ;
   }

   public void setgxTv_SdtConfig_Configid_Z_SetNull( )
   {
      gxTv_SdtConfig_Configid_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtConfig_Configid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConfig_Configkey_Z( )
   {
      return gxTv_SdtConfig_Configkey_Z ;
   }

   public void setgxTv_SdtConfig_Configkey_Z( String value )
   {
      gxTv_SdtConfig_N = (byte)(0) ;
      SetDirty("Configkey_Z");
      gxTv_SdtConfig_Configkey_Z = value ;
   }

   public void setgxTv_SdtConfig_Configkey_Z_SetNull( )
   {
      gxTv_SdtConfig_Configkey_Z = "" ;
   }

   public boolean getgxTv_SdtConfig_Configkey_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConfig_Configvalue_Z( )
   {
      return gxTv_SdtConfig_Configvalue_Z ;
   }

   public void setgxTv_SdtConfig_Configvalue_Z( String value )
   {
      gxTv_SdtConfig_N = (byte)(0) ;
      SetDirty("Configvalue_Z");
      gxTv_SdtConfig_Configvalue_Z = value ;
   }

   public void setgxTv_SdtConfig_Configvalue_Z_SetNull( )
   {
      gxTv_SdtConfig_Configvalue_Z = "" ;
   }

   public boolean getgxTv_SdtConfig_Configvalue_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConfig_Configestador_Z( )
   {
      return gxTv_SdtConfig_Configestador_Z ;
   }

   public void setgxTv_SdtConfig_Configestador_Z( String value )
   {
      gxTv_SdtConfig_N = (byte)(0) ;
      SetDirty("Configestador_Z");
      gxTv_SdtConfig_Configestador_Z = value ;
   }

   public void setgxTv_SdtConfig_Configestador_Z_SetNull( )
   {
      gxTv_SdtConfig_Configestador_Z = "" ;
   }

   public boolean getgxTv_SdtConfig_Configestador_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.projectthani.config_bc obj;
      obj = new com.projectthani.config_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtConfig_N = (byte)(1) ;
      gxTv_SdtConfig_Configkey = "" ;
      gxTv_SdtConfig_Configvalue = "" ;
      gxTv_SdtConfig_Configestador = "" ;
      gxTv_SdtConfig_Mode = "" ;
      gxTv_SdtConfig_Configkey_Z = "" ;
      gxTv_SdtConfig_Configvalue_Z = "" ;
      gxTv_SdtConfig_Configestador_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtConfig_N ;
   }

   public com.projectthani.SdtConfig Clone( )
   {
      com.projectthani.SdtConfig sdt;
      com.projectthani.config_bc obj;
      sdt = (com.projectthani.SdtConfig)(clone()) ;
      obj = (com.projectthani.config_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.projectthani.StructSdtConfig struct )
   {
      setgxTv_SdtConfig_Configid(struct.getConfigid());
      setgxTv_SdtConfig_Configkey(struct.getConfigkey());
      setgxTv_SdtConfig_Configvalue(struct.getConfigvalue());
      setgxTv_SdtConfig_Configestador(struct.getConfigestador());
      setgxTv_SdtConfig_Mode(struct.getMode());
      setgxTv_SdtConfig_Initialized(struct.getInitialized());
      setgxTv_SdtConfig_Configid_Z(struct.getConfigid_Z());
      setgxTv_SdtConfig_Configkey_Z(struct.getConfigkey_Z());
      setgxTv_SdtConfig_Configvalue_Z(struct.getConfigvalue_Z());
      setgxTv_SdtConfig_Configestador_Z(struct.getConfigestador_Z());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtConfig getStruct( )
   {
      com.projectthani.StructSdtConfig struct = new com.projectthani.StructSdtConfig ();
      struct.setConfigid(getgxTv_SdtConfig_Configid());
      struct.setConfigkey(getgxTv_SdtConfig_Configkey());
      struct.setConfigvalue(getgxTv_SdtConfig_Configvalue());
      struct.setConfigestador(getgxTv_SdtConfig_Configestador());
      struct.setMode(getgxTv_SdtConfig_Mode());
      struct.setInitialized(getgxTv_SdtConfig_Initialized());
      struct.setConfigid_Z(getgxTv_SdtConfig_Configid_Z());
      struct.setConfigkey_Z(getgxTv_SdtConfig_Configkey_Z());
      struct.setConfigvalue_Z(getgxTv_SdtConfig_Configvalue_Z());
      struct.setConfigestador_Z(getgxTv_SdtConfig_Configestador_Z());
      return struct ;
   }

   private byte gxTv_SdtConfig_N ;
   private short gxTv_SdtConfig_Configid ;
   private short gxTv_SdtConfig_Initialized ;
   private short gxTv_SdtConfig_Configid_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtConfig_Configestador ;
   private String gxTv_SdtConfig_Mode ;
   private String gxTv_SdtConfig_Configestador_Z ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtConfig_Configkey ;
   private String gxTv_SdtConfig_Configvalue ;
   private String gxTv_SdtConfig_Configkey_Z ;
   private String gxTv_SdtConfig_Configvalue_Z ;
}

