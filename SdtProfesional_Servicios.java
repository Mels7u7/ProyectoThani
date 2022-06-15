package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtProfesional_Servicios extends GxSilentTrnSdt implements Cloneable, java.io.Serializable
{
   public SdtProfesional_Servicios( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtProfesional_Servicios.class));
   }

   public SdtProfesional_Servicios( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle, context, "SdtProfesional_Servicios");
      initialize( remoteHandle) ;
   }

   public SdtProfesional_Servicios( int remoteHandle ,
                                    StructSdtProfesional_Servicios struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtProfesional_Servicios( )
   {
      super( new ModelContext(SdtProfesional_Servicios.class), "SdtProfesional_Servicios");
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
      return (Object[][])(new Object[][]{new Object[]{"ServiciosId", java.util.UUID.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Servicios");
      metadata.set("BT", "ProfesionalServicios");
      metadata.set("PK", "[ \"ServiciosId\" ]");
      metadata.set("PKAssigned", "[ \"ServiciosId\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"ProfesionalId\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ServiciosId") )
            {
               gxTv_SdtProfesional_Servicios_Serviciosid = GXutil.strToGuid(oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ServiciosNombre") )
            {
               gxTv_SdtProfesional_Servicios_Serviciosnombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtProfesional_Servicios_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtProfesional_Servicios_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtProfesional_Servicios_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ServiciosId_Z") )
            {
               gxTv_SdtProfesional_Servicios_Serviciosid_Z = GXutil.strToGuid(oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ServiciosNombre_Z") )
            {
               gxTv_SdtProfesional_Servicios_Serviciosnombre_Z = oReader.getValue() ;
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
         sName = "Profesional.Servicios" ;
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
      oWriter.writeElement("ServiciosId", GXutil.rtrim( gxTv_SdtProfesional_Servicios_Serviciosid.toString()));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ServiciosNombre", GXutil.rtrim( gxTv_SdtProfesional_Servicios_Serviciosnombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", GXutil.rtrim( gxTv_SdtProfesional_Servicios_Mode));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtProfesional_Servicios_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtProfesional_Servicios_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ServiciosId_Z", GXutil.rtrim( gxTv_SdtProfesional_Servicios_Serviciosid_Z.toString()));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ServiciosNombre_Z", GXutil.rtrim( gxTv_SdtProfesional_Servicios_Serviciosnombre_Z));
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
      AddObjectProperty("ServiciosId", gxTv_SdtProfesional_Servicios_Serviciosid, false, includeNonInitialized);
      AddObjectProperty("ServiciosNombre", gxTv_SdtProfesional_Servicios_Serviciosnombre, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtProfesional_Servicios_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtProfesional_Servicios_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtProfesional_Servicios_Initialized, false, includeNonInitialized);
         AddObjectProperty("ServiciosId_Z", gxTv_SdtProfesional_Servicios_Serviciosid_Z, false, includeNonInitialized);
         AddObjectProperty("ServiciosNombre_Z", gxTv_SdtProfesional_Servicios_Serviciosnombre_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.projectthani.SdtProfesional_Servicios sdt )
   {
      if ( sdt.IsDirty("ServiciosId") )
      {
         gxTv_SdtProfesional_Servicios_N = (byte)(0) ;
         gxTv_SdtProfesional_Servicios_Serviciosid = sdt.getgxTv_SdtProfesional_Servicios_Serviciosid() ;
      }
      if ( sdt.IsDirty("ServiciosNombre") )
      {
         gxTv_SdtProfesional_Servicios_N = (byte)(0) ;
         gxTv_SdtProfesional_Servicios_Serviciosnombre = sdt.getgxTv_SdtProfesional_Servicios_Serviciosnombre() ;
      }
   }

   public java.util.UUID getgxTv_SdtProfesional_Servicios_Serviciosid( )
   {
      return gxTv_SdtProfesional_Servicios_Serviciosid ;
   }

   public void setgxTv_SdtProfesional_Servicios_Serviciosid( java.util.UUID value )
   {
      gxTv_SdtProfesional_Servicios_N = (byte)(0) ;
      gxTv_SdtProfesional_Servicios_Modified = (short)(1) ;
      SetDirty("Serviciosid");
      gxTv_SdtProfesional_Servicios_Serviciosid = value ;
   }

   public String getgxTv_SdtProfesional_Servicios_Serviciosnombre( )
   {
      return gxTv_SdtProfesional_Servicios_Serviciosnombre ;
   }

   public void setgxTv_SdtProfesional_Servicios_Serviciosnombre( String value )
   {
      gxTv_SdtProfesional_Servicios_N = (byte)(0) ;
      gxTv_SdtProfesional_Servicios_Modified = (short)(1) ;
      SetDirty("Serviciosnombre");
      gxTv_SdtProfesional_Servicios_Serviciosnombre = value ;
   }

   public String getgxTv_SdtProfesional_Servicios_Mode( )
   {
      return gxTv_SdtProfesional_Servicios_Mode ;
   }

   public void setgxTv_SdtProfesional_Servicios_Mode( String value )
   {
      gxTv_SdtProfesional_Servicios_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtProfesional_Servicios_Mode = value ;
   }

   public void setgxTv_SdtProfesional_Servicios_Mode_SetNull( )
   {
      gxTv_SdtProfesional_Servicios_Mode = "" ;
   }

   public boolean getgxTv_SdtProfesional_Servicios_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtProfesional_Servicios_Modified( )
   {
      return gxTv_SdtProfesional_Servicios_Modified ;
   }

   public void setgxTv_SdtProfesional_Servicios_Modified( short value )
   {
      gxTv_SdtProfesional_Servicios_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtProfesional_Servicios_Modified = value ;
   }

   public void setgxTv_SdtProfesional_Servicios_Modified_SetNull( )
   {
      gxTv_SdtProfesional_Servicios_Modified = (short)(0) ;
   }

   public boolean getgxTv_SdtProfesional_Servicios_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtProfesional_Servicios_Initialized( )
   {
      return gxTv_SdtProfesional_Servicios_Initialized ;
   }

   public void setgxTv_SdtProfesional_Servicios_Initialized( short value )
   {
      gxTv_SdtProfesional_Servicios_N = (byte)(0) ;
      gxTv_SdtProfesional_Servicios_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtProfesional_Servicios_Initialized = value ;
   }

   public void setgxTv_SdtProfesional_Servicios_Initialized_SetNull( )
   {
      gxTv_SdtProfesional_Servicios_Initialized = (short)(0) ;
   }

   public boolean getgxTv_SdtProfesional_Servicios_Initialized_IsNull( )
   {
      return false ;
   }

   public java.util.UUID getgxTv_SdtProfesional_Servicios_Serviciosid_Z( )
   {
      return gxTv_SdtProfesional_Servicios_Serviciosid_Z ;
   }

   public void setgxTv_SdtProfesional_Servicios_Serviciosid_Z( java.util.UUID value )
   {
      gxTv_SdtProfesional_Servicios_N = (byte)(0) ;
      gxTv_SdtProfesional_Servicios_Modified = (short)(1) ;
      SetDirty("Serviciosid_Z");
      gxTv_SdtProfesional_Servicios_Serviciosid_Z = value ;
   }

   public void setgxTv_SdtProfesional_Servicios_Serviciosid_Z_SetNull( )
   {
      gxTv_SdtProfesional_Servicios_Serviciosid_Z = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
   }

   public boolean getgxTv_SdtProfesional_Servicios_Serviciosid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtProfesional_Servicios_Serviciosnombre_Z( )
   {
      return gxTv_SdtProfesional_Servicios_Serviciosnombre_Z ;
   }

   public void setgxTv_SdtProfesional_Servicios_Serviciosnombre_Z( String value )
   {
      gxTv_SdtProfesional_Servicios_N = (byte)(0) ;
      gxTv_SdtProfesional_Servicios_Modified = (short)(1) ;
      SetDirty("Serviciosnombre_Z");
      gxTv_SdtProfesional_Servicios_Serviciosnombre_Z = value ;
   }

   public void setgxTv_SdtProfesional_Servicios_Serviciosnombre_Z_SetNull( )
   {
      gxTv_SdtProfesional_Servicios_Serviciosnombre_Z = "" ;
   }

   public boolean getgxTv_SdtProfesional_Servicios_Serviciosnombre_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtProfesional_Servicios_Serviciosid = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      gxTv_SdtProfesional_Servicios_N = (byte)(1) ;
      gxTv_SdtProfesional_Servicios_Serviciosnombre = "" ;
      gxTv_SdtProfesional_Servicios_Mode = "" ;
      gxTv_SdtProfesional_Servicios_Serviciosid_Z = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      gxTv_SdtProfesional_Servicios_Serviciosnombre_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtProfesional_Servicios_N ;
   }

   public com.projectthani.SdtProfesional_Servicios Clone( )
   {
      return (com.projectthani.SdtProfesional_Servicios)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtProfesional_Servicios struct )
   {
      setgxTv_SdtProfesional_Servicios_Serviciosid(struct.getServiciosid());
      setgxTv_SdtProfesional_Servicios_Serviciosnombre(struct.getServiciosnombre());
      setgxTv_SdtProfesional_Servicios_Mode(struct.getMode());
      setgxTv_SdtProfesional_Servicios_Modified(struct.getModified());
      setgxTv_SdtProfesional_Servicios_Initialized(struct.getInitialized());
      setgxTv_SdtProfesional_Servicios_Serviciosid_Z(struct.getServiciosid_Z());
      setgxTv_SdtProfesional_Servicios_Serviciosnombre_Z(struct.getServiciosnombre_Z());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtProfesional_Servicios getStruct( )
   {
      com.projectthani.StructSdtProfesional_Servicios struct = new com.projectthani.StructSdtProfesional_Servicios ();
      struct.setServiciosid(getgxTv_SdtProfesional_Servicios_Serviciosid());
      struct.setServiciosnombre(getgxTv_SdtProfesional_Servicios_Serviciosnombre());
      struct.setMode(getgxTv_SdtProfesional_Servicios_Mode());
      struct.setModified(getgxTv_SdtProfesional_Servicios_Modified());
      struct.setInitialized(getgxTv_SdtProfesional_Servicios_Initialized());
      struct.setServiciosid_Z(getgxTv_SdtProfesional_Servicios_Serviciosid_Z());
      struct.setServiciosnombre_Z(getgxTv_SdtProfesional_Servicios_Serviciosnombre_Z());
      return struct ;
   }

   private byte gxTv_SdtProfesional_Servicios_N ;
   private short gxTv_SdtProfesional_Servicios_Modified ;
   private short gxTv_SdtProfesional_Servicios_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtProfesional_Servicios_Mode ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtProfesional_Servicios_Serviciosnombre ;
   private String gxTv_SdtProfesional_Servicios_Serviciosnombre_Z ;
   private java.util.UUID gxTv_SdtProfesional_Servicios_Serviciosid ;
   private java.util.UUID gxTv_SdtProfesional_Servicios_Serviciosid_Z ;
}

