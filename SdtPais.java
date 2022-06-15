package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtPais extends GxSilentTrnSdt implements Cloneable, java.io.Serializable
{
   public SdtPais( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtPais.class));
   }

   public SdtPais( int remoteHandle ,
                   ModelContext context )
   {
      super( remoteHandle, context, "SdtPais");
      initialize( remoteHandle) ;
   }

   public SdtPais( int remoteHandle ,
                   StructSdtPais struct )
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

   public void Load( short AV43PaisId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Short.valueOf(AV43PaisId)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"PaisId", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Pais");
      metadata.set("BT", "Pais");
      metadata.set("PK", "[ \"PaisId\" ]");
      metadata.set("PKAssigned", "[ \"PaisId\" ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaisId") )
            {
               gxTv_SdtPais_Paisid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaisDescripcion") )
            {
               gxTv_SdtPais_Paisdescripcion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaisEstado") )
            {
               gxTv_SdtPais_Paisestado = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtPais_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtPais_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaisId_Z") )
            {
               gxTv_SdtPais_Paisid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaisDescripcion_Z") )
            {
               gxTv_SdtPais_Paisdescripcion_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaisEstado_Z") )
            {
               gxTv_SdtPais_Paisestado_Z = oReader.getValue() ;
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
         sName = "Pais" ;
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
      oWriter.writeElement("PaisId", GXutil.trim( GXutil.str( gxTv_SdtPais_Paisid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PaisDescripcion", GXutil.rtrim( gxTv_SdtPais_Paisdescripcion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PaisEstado", GXutil.rtrim( gxTv_SdtPais_Paisestado));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", GXutil.rtrim( gxTv_SdtPais_Mode));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtPais_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PaisId_Z", GXutil.trim( GXutil.str( gxTv_SdtPais_Paisid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PaisDescripcion_Z", GXutil.rtrim( gxTv_SdtPais_Paisdescripcion_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PaisEstado_Z", GXutil.rtrim( gxTv_SdtPais_Paisestado_Z));
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
      AddObjectProperty("PaisId", gxTv_SdtPais_Paisid, false, includeNonInitialized);
      AddObjectProperty("PaisDescripcion", gxTv_SdtPais_Paisdescripcion, false, includeNonInitialized);
      AddObjectProperty("PaisEstado", gxTv_SdtPais_Paisestado, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtPais_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtPais_Initialized, false, includeNonInitialized);
         AddObjectProperty("PaisId_Z", gxTv_SdtPais_Paisid_Z, false, includeNonInitialized);
         AddObjectProperty("PaisDescripcion_Z", gxTv_SdtPais_Paisdescripcion_Z, false, includeNonInitialized);
         AddObjectProperty("PaisEstado_Z", gxTv_SdtPais_Paisestado_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.projectthani.SdtPais sdt )
   {
      if ( sdt.IsDirty("PaisId") )
      {
         gxTv_SdtPais_N = (byte)(0) ;
         gxTv_SdtPais_Paisid = sdt.getgxTv_SdtPais_Paisid() ;
      }
      if ( sdt.IsDirty("PaisDescripcion") )
      {
         gxTv_SdtPais_N = (byte)(0) ;
         gxTv_SdtPais_Paisdescripcion = sdt.getgxTv_SdtPais_Paisdescripcion() ;
      }
      if ( sdt.IsDirty("PaisEstado") )
      {
         gxTv_SdtPais_N = (byte)(0) ;
         gxTv_SdtPais_Paisestado = sdt.getgxTv_SdtPais_Paisestado() ;
      }
   }

   public short getgxTv_SdtPais_Paisid( )
   {
      return gxTv_SdtPais_Paisid ;
   }

   public void setgxTv_SdtPais_Paisid( short value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      if ( gxTv_SdtPais_Paisid != value )
      {
         gxTv_SdtPais_Mode = "INS" ;
         this.setgxTv_SdtPais_Paisid_Z_SetNull( );
         this.setgxTv_SdtPais_Paisdescripcion_Z_SetNull( );
         this.setgxTv_SdtPais_Paisestado_Z_SetNull( );
      }
      SetDirty("Paisid");
      gxTv_SdtPais_Paisid = value ;
   }

   public String getgxTv_SdtPais_Paisdescripcion( )
   {
      return gxTv_SdtPais_Paisdescripcion ;
   }

   public void setgxTv_SdtPais_Paisdescripcion( String value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paisdescripcion");
      gxTv_SdtPais_Paisdescripcion = value ;
   }

   public String getgxTv_SdtPais_Paisestado( )
   {
      return gxTv_SdtPais_Paisestado ;
   }

   public void setgxTv_SdtPais_Paisestado( String value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paisestado");
      gxTv_SdtPais_Paisestado = value ;
   }

   public String getgxTv_SdtPais_Mode( )
   {
      return gxTv_SdtPais_Mode ;
   }

   public void setgxTv_SdtPais_Mode( String value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtPais_Mode = value ;
   }

   public void setgxTv_SdtPais_Mode_SetNull( )
   {
      gxTv_SdtPais_Mode = "" ;
   }

   public boolean getgxTv_SdtPais_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtPais_Initialized( )
   {
      return gxTv_SdtPais_Initialized ;
   }

   public void setgxTv_SdtPais_Initialized( short value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtPais_Initialized = value ;
   }

   public void setgxTv_SdtPais_Initialized_SetNull( )
   {
      gxTv_SdtPais_Initialized = (short)(0) ;
   }

   public boolean getgxTv_SdtPais_Initialized_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtPais_Paisid_Z( )
   {
      return gxTv_SdtPais_Paisid_Z ;
   }

   public void setgxTv_SdtPais_Paisid_Z( short value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paisid_Z");
      gxTv_SdtPais_Paisid_Z = value ;
   }

   public void setgxTv_SdtPais_Paisid_Z_SetNull( )
   {
      gxTv_SdtPais_Paisid_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtPais_Paisid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPais_Paisdescripcion_Z( )
   {
      return gxTv_SdtPais_Paisdescripcion_Z ;
   }

   public void setgxTv_SdtPais_Paisdescripcion_Z( String value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paisdescripcion_Z");
      gxTv_SdtPais_Paisdescripcion_Z = value ;
   }

   public void setgxTv_SdtPais_Paisdescripcion_Z_SetNull( )
   {
      gxTv_SdtPais_Paisdescripcion_Z = "" ;
   }

   public boolean getgxTv_SdtPais_Paisdescripcion_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPais_Paisestado_Z( )
   {
      return gxTv_SdtPais_Paisestado_Z ;
   }

   public void setgxTv_SdtPais_Paisestado_Z( String value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paisestado_Z");
      gxTv_SdtPais_Paisestado_Z = value ;
   }

   public void setgxTv_SdtPais_Paisestado_Z_SetNull( )
   {
      gxTv_SdtPais_Paisestado_Z = "" ;
   }

   public boolean getgxTv_SdtPais_Paisestado_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.projectthani.pais_bc obj;
      obj = new com.projectthani.pais_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtPais_N = (byte)(1) ;
      gxTv_SdtPais_Paisdescripcion = "" ;
      gxTv_SdtPais_Paisestado = "" ;
      gxTv_SdtPais_Mode = "" ;
      gxTv_SdtPais_Paisdescripcion_Z = "" ;
      gxTv_SdtPais_Paisestado_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtPais_N ;
   }

   public com.projectthani.SdtPais Clone( )
   {
      com.projectthani.SdtPais sdt;
      com.projectthani.pais_bc obj;
      sdt = (com.projectthani.SdtPais)(clone()) ;
      obj = (com.projectthani.pais_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.projectthani.StructSdtPais struct )
   {
      setgxTv_SdtPais_Paisid(struct.getPaisid());
      setgxTv_SdtPais_Paisdescripcion(struct.getPaisdescripcion());
      setgxTv_SdtPais_Paisestado(struct.getPaisestado());
      setgxTv_SdtPais_Mode(struct.getMode());
      setgxTv_SdtPais_Initialized(struct.getInitialized());
      setgxTv_SdtPais_Paisid_Z(struct.getPaisid_Z());
      setgxTv_SdtPais_Paisdescripcion_Z(struct.getPaisdescripcion_Z());
      setgxTv_SdtPais_Paisestado_Z(struct.getPaisestado_Z());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtPais getStruct( )
   {
      com.projectthani.StructSdtPais struct = new com.projectthani.StructSdtPais ();
      struct.setPaisid(getgxTv_SdtPais_Paisid());
      struct.setPaisdescripcion(getgxTv_SdtPais_Paisdescripcion());
      struct.setPaisestado(getgxTv_SdtPais_Paisestado());
      struct.setMode(getgxTv_SdtPais_Mode());
      struct.setInitialized(getgxTv_SdtPais_Initialized());
      struct.setPaisid_Z(getgxTv_SdtPais_Paisid_Z());
      struct.setPaisdescripcion_Z(getgxTv_SdtPais_Paisdescripcion_Z());
      struct.setPaisestado_Z(getgxTv_SdtPais_Paisestado_Z());
      return struct ;
   }

   private byte gxTv_SdtPais_N ;
   private short gxTv_SdtPais_Paisid ;
   private short gxTv_SdtPais_Initialized ;
   private short gxTv_SdtPais_Paisid_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtPais_Paisestado ;
   private String gxTv_SdtPais_Mode ;
   private String gxTv_SdtPais_Paisestado_Z ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtPais_Paisdescripcion ;
   private String gxTv_SdtPais_Paisdescripcion_Z ;
}

