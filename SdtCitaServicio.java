package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtCitaServicio extends GxSilentTrnSdt implements Cloneable, java.io.Serializable
{
   public SdtCitaServicio( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtCitaServicio.class));
   }

   public SdtCitaServicio( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle, context, "SdtCitaServicio");
      initialize( remoteHandle) ;
   }

   public SdtCitaServicio( int remoteHandle ,
                           StructSdtCitaServicio struct )
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

   public void Load( int AV26CitaServicioId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV26CitaServicioId)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"CitaServicioId", int.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "CitaServicio");
      metadata.set("BT", "CitaServicio");
      metadata.set("PK", "[ \"CitaServicioId\" ]");
      metadata.set("PKAssigned", "[ \"CitaServicioId\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CitaId\" ],\"FKMap\":[  ] },{ \"FK\":[ \"ServicioId\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaServicioId") )
            {
               gxTv_SdtCitaServicio_Citaservicioid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaId") )
            {
               gxTv_SdtCitaServicio_Citaid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ServicioId") )
            {
               gxTv_SdtCitaServicio_Servicioid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaServicioFlag") )
            {
               gxTv_SdtCitaServicio_Citaservicioflag = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaServicioEstado") )
            {
               gxTv_SdtCitaServicio_Citaservicioestado = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtCitaServicio_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtCitaServicio_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaServicioId_Z") )
            {
               gxTv_SdtCitaServicio_Citaservicioid_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaId_Z") )
            {
               gxTv_SdtCitaServicio_Citaid_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ServicioId_Z") )
            {
               gxTv_SdtCitaServicio_Servicioid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaServicioFlag_Z") )
            {
               gxTv_SdtCitaServicio_Citaservicioflag_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaServicioEstado_Z") )
            {
               gxTv_SdtCitaServicio_Citaservicioestado_Z = oReader.getValue() ;
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
         sName = "CitaServicio" ;
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
      oWriter.writeElement("CitaServicioId", GXutil.trim( GXutil.str( gxTv_SdtCitaServicio_Citaservicioid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaId", GXutil.trim( GXutil.str( gxTv_SdtCitaServicio_Citaid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ServicioId", GXutil.trim( GXutil.str( gxTv_SdtCitaServicio_Servicioid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaServicioFlag", GXutil.trim( GXutil.str( gxTv_SdtCitaServicio_Citaservicioflag, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaServicioEstado", GXutil.rtrim( gxTv_SdtCitaServicio_Citaservicioestado));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", GXutil.rtrim( gxTv_SdtCitaServicio_Mode));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtCitaServicio_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaServicioId_Z", GXutil.trim( GXutil.str( gxTv_SdtCitaServicio_Citaservicioid_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaId_Z", GXutil.trim( GXutil.str( gxTv_SdtCitaServicio_Citaid_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ServicioId_Z", GXutil.trim( GXutil.str( gxTv_SdtCitaServicio_Servicioid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaServicioFlag_Z", GXutil.trim( GXutil.str( gxTv_SdtCitaServicio_Citaservicioflag_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaServicioEstado_Z", GXutil.rtrim( gxTv_SdtCitaServicio_Citaservicioestado_Z));
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
      AddObjectProperty("CitaServicioId", gxTv_SdtCitaServicio_Citaservicioid, false, includeNonInitialized);
      AddObjectProperty("CitaId", gxTv_SdtCitaServicio_Citaid, false, includeNonInitialized);
      AddObjectProperty("ServicioId", gxTv_SdtCitaServicio_Servicioid, false, includeNonInitialized);
      AddObjectProperty("CitaServicioFlag", gxTv_SdtCitaServicio_Citaservicioflag, false, includeNonInitialized);
      AddObjectProperty("CitaServicioEstado", gxTv_SdtCitaServicio_Citaservicioestado, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtCitaServicio_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtCitaServicio_Initialized, false, includeNonInitialized);
         AddObjectProperty("CitaServicioId_Z", gxTv_SdtCitaServicio_Citaservicioid_Z, false, includeNonInitialized);
         AddObjectProperty("CitaId_Z", gxTv_SdtCitaServicio_Citaid_Z, false, includeNonInitialized);
         AddObjectProperty("ServicioId_Z", gxTv_SdtCitaServicio_Servicioid_Z, false, includeNonInitialized);
         AddObjectProperty("CitaServicioFlag_Z", gxTv_SdtCitaServicio_Citaservicioflag_Z, false, includeNonInitialized);
         AddObjectProperty("CitaServicioEstado_Z", gxTv_SdtCitaServicio_Citaservicioestado_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.projectthani.SdtCitaServicio sdt )
   {
      if ( sdt.IsDirty("CitaServicioId") )
      {
         gxTv_SdtCitaServicio_N = (byte)(0) ;
         gxTv_SdtCitaServicio_Citaservicioid = sdt.getgxTv_SdtCitaServicio_Citaservicioid() ;
      }
      if ( sdt.IsDirty("CitaId") )
      {
         gxTv_SdtCitaServicio_N = (byte)(0) ;
         gxTv_SdtCitaServicio_Citaid = sdt.getgxTv_SdtCitaServicio_Citaid() ;
      }
      if ( sdt.IsDirty("ServicioId") )
      {
         gxTv_SdtCitaServicio_N = (byte)(0) ;
         gxTv_SdtCitaServicio_Servicioid = sdt.getgxTv_SdtCitaServicio_Servicioid() ;
      }
      if ( sdt.IsDirty("CitaServicioFlag") )
      {
         gxTv_SdtCitaServicio_N = (byte)(0) ;
         gxTv_SdtCitaServicio_Citaservicioflag = sdt.getgxTv_SdtCitaServicio_Citaservicioflag() ;
      }
      if ( sdt.IsDirty("CitaServicioEstado") )
      {
         gxTv_SdtCitaServicio_N = (byte)(0) ;
         gxTv_SdtCitaServicio_Citaservicioestado = sdt.getgxTv_SdtCitaServicio_Citaservicioestado() ;
      }
   }

   public int getgxTv_SdtCitaServicio_Citaservicioid( )
   {
      return gxTv_SdtCitaServicio_Citaservicioid ;
   }

   public void setgxTv_SdtCitaServicio_Citaservicioid( int value )
   {
      gxTv_SdtCitaServicio_N = (byte)(0) ;
      if ( gxTv_SdtCitaServicio_Citaservicioid != value )
      {
         gxTv_SdtCitaServicio_Mode = "INS" ;
         this.setgxTv_SdtCitaServicio_Citaservicioid_Z_SetNull( );
         this.setgxTv_SdtCitaServicio_Citaid_Z_SetNull( );
         this.setgxTv_SdtCitaServicio_Servicioid_Z_SetNull( );
         this.setgxTv_SdtCitaServicio_Citaservicioflag_Z_SetNull( );
         this.setgxTv_SdtCitaServicio_Citaservicioestado_Z_SetNull( );
      }
      SetDirty("Citaservicioid");
      gxTv_SdtCitaServicio_Citaservicioid = value ;
   }

   public int getgxTv_SdtCitaServicio_Citaid( )
   {
      return gxTv_SdtCitaServicio_Citaid ;
   }

   public void setgxTv_SdtCitaServicio_Citaid( int value )
   {
      gxTv_SdtCitaServicio_N = (byte)(0) ;
      SetDirty("Citaid");
      gxTv_SdtCitaServicio_Citaid = value ;
   }

   public short getgxTv_SdtCitaServicio_Servicioid( )
   {
      return gxTv_SdtCitaServicio_Servicioid ;
   }

   public void setgxTv_SdtCitaServicio_Servicioid( short value )
   {
      gxTv_SdtCitaServicio_N = (byte)(0) ;
      SetDirty("Servicioid");
      gxTv_SdtCitaServicio_Servicioid = value ;
   }

   public byte getgxTv_SdtCitaServicio_Citaservicioflag( )
   {
      return gxTv_SdtCitaServicio_Citaservicioflag ;
   }

   public void setgxTv_SdtCitaServicio_Citaservicioflag( byte value )
   {
      gxTv_SdtCitaServicio_N = (byte)(0) ;
      SetDirty("Citaservicioflag");
      gxTv_SdtCitaServicio_Citaservicioflag = value ;
   }

   public String getgxTv_SdtCitaServicio_Citaservicioestado( )
   {
      return gxTv_SdtCitaServicio_Citaservicioestado ;
   }

   public void setgxTv_SdtCitaServicio_Citaservicioestado( String value )
   {
      gxTv_SdtCitaServicio_N = (byte)(0) ;
      SetDirty("Citaservicioestado");
      gxTv_SdtCitaServicio_Citaservicioestado = value ;
   }

   public String getgxTv_SdtCitaServicio_Mode( )
   {
      return gxTv_SdtCitaServicio_Mode ;
   }

   public void setgxTv_SdtCitaServicio_Mode( String value )
   {
      gxTv_SdtCitaServicio_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtCitaServicio_Mode = value ;
   }

   public void setgxTv_SdtCitaServicio_Mode_SetNull( )
   {
      gxTv_SdtCitaServicio_Mode = "" ;
   }

   public boolean getgxTv_SdtCitaServicio_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtCitaServicio_Initialized( )
   {
      return gxTv_SdtCitaServicio_Initialized ;
   }

   public void setgxTv_SdtCitaServicio_Initialized( short value )
   {
      gxTv_SdtCitaServicio_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtCitaServicio_Initialized = value ;
   }

   public void setgxTv_SdtCitaServicio_Initialized_SetNull( )
   {
      gxTv_SdtCitaServicio_Initialized = (short)(0) ;
   }

   public boolean getgxTv_SdtCitaServicio_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtCitaServicio_Citaservicioid_Z( )
   {
      return gxTv_SdtCitaServicio_Citaservicioid_Z ;
   }

   public void setgxTv_SdtCitaServicio_Citaservicioid_Z( int value )
   {
      gxTv_SdtCitaServicio_N = (byte)(0) ;
      SetDirty("Citaservicioid_Z");
      gxTv_SdtCitaServicio_Citaservicioid_Z = value ;
   }

   public void setgxTv_SdtCitaServicio_Citaservicioid_Z_SetNull( )
   {
      gxTv_SdtCitaServicio_Citaservicioid_Z = 0 ;
   }

   public boolean getgxTv_SdtCitaServicio_Citaservicioid_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtCitaServicio_Citaid_Z( )
   {
      return gxTv_SdtCitaServicio_Citaid_Z ;
   }

   public void setgxTv_SdtCitaServicio_Citaid_Z( int value )
   {
      gxTv_SdtCitaServicio_N = (byte)(0) ;
      SetDirty("Citaid_Z");
      gxTv_SdtCitaServicio_Citaid_Z = value ;
   }

   public void setgxTv_SdtCitaServicio_Citaid_Z_SetNull( )
   {
      gxTv_SdtCitaServicio_Citaid_Z = 0 ;
   }

   public boolean getgxTv_SdtCitaServicio_Citaid_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtCitaServicio_Servicioid_Z( )
   {
      return gxTv_SdtCitaServicio_Servicioid_Z ;
   }

   public void setgxTv_SdtCitaServicio_Servicioid_Z( short value )
   {
      gxTv_SdtCitaServicio_N = (byte)(0) ;
      SetDirty("Servicioid_Z");
      gxTv_SdtCitaServicio_Servicioid_Z = value ;
   }

   public void setgxTv_SdtCitaServicio_Servicioid_Z_SetNull( )
   {
      gxTv_SdtCitaServicio_Servicioid_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtCitaServicio_Servicioid_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtCitaServicio_Citaservicioflag_Z( )
   {
      return gxTv_SdtCitaServicio_Citaservicioflag_Z ;
   }

   public void setgxTv_SdtCitaServicio_Citaservicioflag_Z( byte value )
   {
      gxTv_SdtCitaServicio_N = (byte)(0) ;
      SetDirty("Citaservicioflag_Z");
      gxTv_SdtCitaServicio_Citaservicioflag_Z = value ;
   }

   public void setgxTv_SdtCitaServicio_Citaservicioflag_Z_SetNull( )
   {
      gxTv_SdtCitaServicio_Citaservicioflag_Z = (byte)(0) ;
   }

   public boolean getgxTv_SdtCitaServicio_Citaservicioflag_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtCitaServicio_Citaservicioestado_Z( )
   {
      return gxTv_SdtCitaServicio_Citaservicioestado_Z ;
   }

   public void setgxTv_SdtCitaServicio_Citaservicioestado_Z( String value )
   {
      gxTv_SdtCitaServicio_N = (byte)(0) ;
      SetDirty("Citaservicioestado_Z");
      gxTv_SdtCitaServicio_Citaservicioestado_Z = value ;
   }

   public void setgxTv_SdtCitaServicio_Citaservicioestado_Z_SetNull( )
   {
      gxTv_SdtCitaServicio_Citaservicioestado_Z = "" ;
   }

   public boolean getgxTv_SdtCitaServicio_Citaservicioestado_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.projectthani.citaservicio_bc obj;
      obj = new com.projectthani.citaservicio_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtCitaServicio_N = (byte)(1) ;
      gxTv_SdtCitaServicio_Citaservicioestado = "" ;
      gxTv_SdtCitaServicio_Mode = "" ;
      gxTv_SdtCitaServicio_Citaservicioestado_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtCitaServicio_N ;
   }

   public com.projectthani.SdtCitaServicio Clone( )
   {
      com.projectthani.SdtCitaServicio sdt;
      com.projectthani.citaservicio_bc obj;
      sdt = (com.projectthani.SdtCitaServicio)(clone()) ;
      obj = (com.projectthani.citaservicio_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.projectthani.StructSdtCitaServicio struct )
   {
      setgxTv_SdtCitaServicio_Citaservicioid(struct.getCitaservicioid());
      setgxTv_SdtCitaServicio_Citaid(struct.getCitaid());
      setgxTv_SdtCitaServicio_Servicioid(struct.getServicioid());
      setgxTv_SdtCitaServicio_Citaservicioflag(struct.getCitaservicioflag());
      setgxTv_SdtCitaServicio_Citaservicioestado(struct.getCitaservicioestado());
      setgxTv_SdtCitaServicio_Mode(struct.getMode());
      setgxTv_SdtCitaServicio_Initialized(struct.getInitialized());
      setgxTv_SdtCitaServicio_Citaservicioid_Z(struct.getCitaservicioid_Z());
      setgxTv_SdtCitaServicio_Citaid_Z(struct.getCitaid_Z());
      setgxTv_SdtCitaServicio_Servicioid_Z(struct.getServicioid_Z());
      setgxTv_SdtCitaServicio_Citaservicioflag_Z(struct.getCitaservicioflag_Z());
      setgxTv_SdtCitaServicio_Citaservicioestado_Z(struct.getCitaservicioestado_Z());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtCitaServicio getStruct( )
   {
      com.projectthani.StructSdtCitaServicio struct = new com.projectthani.StructSdtCitaServicio ();
      struct.setCitaservicioid(getgxTv_SdtCitaServicio_Citaservicioid());
      struct.setCitaid(getgxTv_SdtCitaServicio_Citaid());
      struct.setServicioid(getgxTv_SdtCitaServicio_Servicioid());
      struct.setCitaservicioflag(getgxTv_SdtCitaServicio_Citaservicioflag());
      struct.setCitaservicioestado(getgxTv_SdtCitaServicio_Citaservicioestado());
      struct.setMode(getgxTv_SdtCitaServicio_Mode());
      struct.setInitialized(getgxTv_SdtCitaServicio_Initialized());
      struct.setCitaservicioid_Z(getgxTv_SdtCitaServicio_Citaservicioid_Z());
      struct.setCitaid_Z(getgxTv_SdtCitaServicio_Citaid_Z());
      struct.setServicioid_Z(getgxTv_SdtCitaServicio_Servicioid_Z());
      struct.setCitaservicioflag_Z(getgxTv_SdtCitaServicio_Citaservicioflag_Z());
      struct.setCitaservicioestado_Z(getgxTv_SdtCitaServicio_Citaservicioestado_Z());
      return struct ;
   }

   private byte gxTv_SdtCitaServicio_N ;
   private byte gxTv_SdtCitaServicio_Citaservicioflag ;
   private byte gxTv_SdtCitaServicio_Citaservicioflag_Z ;
   private short gxTv_SdtCitaServicio_Servicioid ;
   private short gxTv_SdtCitaServicio_Initialized ;
   private short gxTv_SdtCitaServicio_Servicioid_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtCitaServicio_Citaservicioid ;
   private int gxTv_SdtCitaServicio_Citaid ;
   private int gxTv_SdtCitaServicio_Citaservicioid_Z ;
   private int gxTv_SdtCitaServicio_Citaid_Z ;
   private String gxTv_SdtCitaServicio_Citaservicioestado ;
   private String gxTv_SdtCitaServicio_Mode ;
   private String gxTv_SdtCitaServicio_Citaservicioestado_Z ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
}

