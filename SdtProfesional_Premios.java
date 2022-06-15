package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtProfesional_Premios extends GxSilentTrnSdt implements Cloneable, java.io.Serializable
{
   public SdtProfesional_Premios( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtProfesional_Premios.class));
   }

   public SdtProfesional_Premios( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle, context, "SdtProfesional_Premios");
      initialize( remoteHandle) ;
   }

   public SdtProfesional_Premios( int remoteHandle ,
                                  StructSdtProfesional_Premios struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtProfesional_Premios( )
   {
      super( new ModelContext(SdtProfesional_Premios.class), "SdtProfesional_Premios");
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
      return (Object[][])(new Object[][]{new Object[]{"PremiosId", java.util.UUID.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Premios");
      metadata.set("BT", "ProfesionalPremios");
      metadata.set("PK", "[ \"PremiosId\" ]");
      metadata.set("PKAssigned", "[ \"PremiosId\" ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "PremiosId") )
            {
               gxTv_SdtProfesional_Premios_Premiosid = GXutil.strToGuid(oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PremiosNombre") )
            {
               gxTv_SdtProfesional_Premios_Premiosnombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PremiosFecha") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtProfesional_Premios_Premiosfecha = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtProfesional_Premios_Premiosfecha = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PremiosDescripcion") )
            {
               gxTv_SdtProfesional_Premios_Premiosdescripcion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtProfesional_Premios_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtProfesional_Premios_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtProfesional_Premios_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PremiosId_Z") )
            {
               gxTv_SdtProfesional_Premios_Premiosid_Z = GXutil.strToGuid(oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PremiosNombre_Z") )
            {
               gxTv_SdtProfesional_Premios_Premiosnombre_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PremiosFecha_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtProfesional_Premios_Premiosfecha_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtProfesional_Premios_Premiosfecha_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
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
         sName = "Profesional.Premios" ;
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
      oWriter.writeElement("PremiosId", GXutil.rtrim( gxTv_SdtProfesional_Premios_Premiosid.toString()));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PremiosNombre", GXutil.rtrim( gxTv_SdtProfesional_Premios_Premiosnombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtProfesional_Premios_Premiosfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtProfesional_Premios_Premiosfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtProfesional_Premios_Premiosfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("PremiosFecha", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PremiosDescripcion", GXutil.rtrim( gxTv_SdtProfesional_Premios_Premiosdescripcion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", GXutil.rtrim( gxTv_SdtProfesional_Premios_Mode));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtProfesional_Premios_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtProfesional_Premios_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PremiosId_Z", GXutil.rtrim( gxTv_SdtProfesional_Premios_Premiosid_Z.toString()));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PremiosNombre_Z", GXutil.rtrim( gxTv_SdtProfesional_Premios_Premiosnombre_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtProfesional_Premios_Premiosfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtProfesional_Premios_Premiosfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtProfesional_Premios_Premiosfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("PremiosFecha_Z", sDateCnv);
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
      AddObjectProperty("PremiosId", gxTv_SdtProfesional_Premios_Premiosid, false, includeNonInitialized);
      AddObjectProperty("PremiosNombre", gxTv_SdtProfesional_Premios_Premiosnombre, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtProfesional_Premios_Premiosfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtProfesional_Premios_Premiosfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtProfesional_Premios_Premiosfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("PremiosFecha", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("PremiosDescripcion", gxTv_SdtProfesional_Premios_Premiosdescripcion, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtProfesional_Premios_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtProfesional_Premios_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtProfesional_Premios_Initialized, false, includeNonInitialized);
         AddObjectProperty("PremiosId_Z", gxTv_SdtProfesional_Premios_Premiosid_Z, false, includeNonInitialized);
         AddObjectProperty("PremiosNombre_Z", gxTv_SdtProfesional_Premios_Premiosnombre_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtProfesional_Premios_Premiosfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtProfesional_Premios_Premiosfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtProfesional_Premios_Premiosfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("PremiosFecha_Z", sDateCnv, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.projectthani.SdtProfesional_Premios sdt )
   {
      if ( sdt.IsDirty("PremiosId") )
      {
         gxTv_SdtProfesional_Premios_N = (byte)(0) ;
         gxTv_SdtProfesional_Premios_Premiosid = sdt.getgxTv_SdtProfesional_Premios_Premiosid() ;
      }
      if ( sdt.IsDirty("PremiosNombre") )
      {
         gxTv_SdtProfesional_Premios_N = (byte)(0) ;
         gxTv_SdtProfesional_Premios_Premiosnombre = sdt.getgxTv_SdtProfesional_Premios_Premiosnombre() ;
      }
      if ( sdt.IsDirty("PremiosFecha") )
      {
         gxTv_SdtProfesional_Premios_N = (byte)(0) ;
         gxTv_SdtProfesional_Premios_Premiosfecha = sdt.getgxTv_SdtProfesional_Premios_Premiosfecha() ;
      }
      if ( sdt.IsDirty("PremiosDescripcion") )
      {
         gxTv_SdtProfesional_Premios_N = (byte)(0) ;
         gxTv_SdtProfesional_Premios_Premiosdescripcion = sdt.getgxTv_SdtProfesional_Premios_Premiosdescripcion() ;
      }
   }

   public java.util.UUID getgxTv_SdtProfesional_Premios_Premiosid( )
   {
      return gxTv_SdtProfesional_Premios_Premiosid ;
   }

   public void setgxTv_SdtProfesional_Premios_Premiosid( java.util.UUID value )
   {
      gxTv_SdtProfesional_Premios_N = (byte)(0) ;
      gxTv_SdtProfesional_Premios_Modified = (short)(1) ;
      SetDirty("Premiosid");
      gxTv_SdtProfesional_Premios_Premiosid = value ;
   }

   public String getgxTv_SdtProfesional_Premios_Premiosnombre( )
   {
      return gxTv_SdtProfesional_Premios_Premiosnombre ;
   }

   public void setgxTv_SdtProfesional_Premios_Premiosnombre( String value )
   {
      gxTv_SdtProfesional_Premios_N = (byte)(0) ;
      gxTv_SdtProfesional_Premios_Modified = (short)(1) ;
      SetDirty("Premiosnombre");
      gxTv_SdtProfesional_Premios_Premiosnombre = value ;
   }

   public java.util.Date getgxTv_SdtProfesional_Premios_Premiosfecha( )
   {
      return gxTv_SdtProfesional_Premios_Premiosfecha ;
   }

   public void setgxTv_SdtProfesional_Premios_Premiosfecha( java.util.Date value )
   {
      gxTv_SdtProfesional_Premios_N = (byte)(0) ;
      gxTv_SdtProfesional_Premios_Modified = (short)(1) ;
      SetDirty("Premiosfecha");
      gxTv_SdtProfesional_Premios_Premiosfecha = value ;
   }

   public String getgxTv_SdtProfesional_Premios_Premiosdescripcion( )
   {
      return gxTv_SdtProfesional_Premios_Premiosdescripcion ;
   }

   public void setgxTv_SdtProfesional_Premios_Premiosdescripcion( String value )
   {
      gxTv_SdtProfesional_Premios_N = (byte)(0) ;
      gxTv_SdtProfesional_Premios_Modified = (short)(1) ;
      SetDirty("Premiosdescripcion");
      gxTv_SdtProfesional_Premios_Premiosdescripcion = value ;
   }

   public String getgxTv_SdtProfesional_Premios_Mode( )
   {
      return gxTv_SdtProfesional_Premios_Mode ;
   }

   public void setgxTv_SdtProfesional_Premios_Mode( String value )
   {
      gxTv_SdtProfesional_Premios_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtProfesional_Premios_Mode = value ;
   }

   public void setgxTv_SdtProfesional_Premios_Mode_SetNull( )
   {
      gxTv_SdtProfesional_Premios_Mode = "" ;
   }

   public boolean getgxTv_SdtProfesional_Premios_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtProfesional_Premios_Modified( )
   {
      return gxTv_SdtProfesional_Premios_Modified ;
   }

   public void setgxTv_SdtProfesional_Premios_Modified( short value )
   {
      gxTv_SdtProfesional_Premios_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtProfesional_Premios_Modified = value ;
   }

   public void setgxTv_SdtProfesional_Premios_Modified_SetNull( )
   {
      gxTv_SdtProfesional_Premios_Modified = (short)(0) ;
   }

   public boolean getgxTv_SdtProfesional_Premios_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtProfesional_Premios_Initialized( )
   {
      return gxTv_SdtProfesional_Premios_Initialized ;
   }

   public void setgxTv_SdtProfesional_Premios_Initialized( short value )
   {
      gxTv_SdtProfesional_Premios_N = (byte)(0) ;
      gxTv_SdtProfesional_Premios_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtProfesional_Premios_Initialized = value ;
   }

   public void setgxTv_SdtProfesional_Premios_Initialized_SetNull( )
   {
      gxTv_SdtProfesional_Premios_Initialized = (short)(0) ;
   }

   public boolean getgxTv_SdtProfesional_Premios_Initialized_IsNull( )
   {
      return false ;
   }

   public java.util.UUID getgxTv_SdtProfesional_Premios_Premiosid_Z( )
   {
      return gxTv_SdtProfesional_Premios_Premiosid_Z ;
   }

   public void setgxTv_SdtProfesional_Premios_Premiosid_Z( java.util.UUID value )
   {
      gxTv_SdtProfesional_Premios_N = (byte)(0) ;
      gxTv_SdtProfesional_Premios_Modified = (short)(1) ;
      SetDirty("Premiosid_Z");
      gxTv_SdtProfesional_Premios_Premiosid_Z = value ;
   }

   public void setgxTv_SdtProfesional_Premios_Premiosid_Z_SetNull( )
   {
      gxTv_SdtProfesional_Premios_Premiosid_Z = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
   }

   public boolean getgxTv_SdtProfesional_Premios_Premiosid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtProfesional_Premios_Premiosnombre_Z( )
   {
      return gxTv_SdtProfesional_Premios_Premiosnombre_Z ;
   }

   public void setgxTv_SdtProfesional_Premios_Premiosnombre_Z( String value )
   {
      gxTv_SdtProfesional_Premios_N = (byte)(0) ;
      gxTv_SdtProfesional_Premios_Modified = (short)(1) ;
      SetDirty("Premiosnombre_Z");
      gxTv_SdtProfesional_Premios_Premiosnombre_Z = value ;
   }

   public void setgxTv_SdtProfesional_Premios_Premiosnombre_Z_SetNull( )
   {
      gxTv_SdtProfesional_Premios_Premiosnombre_Z = "" ;
   }

   public boolean getgxTv_SdtProfesional_Premios_Premiosnombre_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtProfesional_Premios_Premiosfecha_Z( )
   {
      return gxTv_SdtProfesional_Premios_Premiosfecha_Z ;
   }

   public void setgxTv_SdtProfesional_Premios_Premiosfecha_Z( java.util.Date value )
   {
      gxTv_SdtProfesional_Premios_N = (byte)(0) ;
      gxTv_SdtProfesional_Premios_Modified = (short)(1) ;
      SetDirty("Premiosfecha_Z");
      gxTv_SdtProfesional_Premios_Premiosfecha_Z = value ;
   }

   public void setgxTv_SdtProfesional_Premios_Premiosfecha_Z_SetNull( )
   {
      gxTv_SdtProfesional_Premios_Premiosfecha_Z = GXutil.nullDate() ;
   }

   public boolean getgxTv_SdtProfesional_Premios_Premiosfecha_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtProfesional_Premios_Premiosid = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      gxTv_SdtProfesional_Premios_N = (byte)(1) ;
      gxTv_SdtProfesional_Premios_Premiosnombre = "" ;
      gxTv_SdtProfesional_Premios_Premiosfecha = GXutil.nullDate() ;
      gxTv_SdtProfesional_Premios_Premiosdescripcion = "" ;
      gxTv_SdtProfesional_Premios_Mode = "" ;
      gxTv_SdtProfesional_Premios_Premiosid_Z = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      gxTv_SdtProfesional_Premios_Premiosnombre_Z = "" ;
      gxTv_SdtProfesional_Premios_Premiosfecha_Z = GXutil.nullDate() ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtProfesional_Premios_N ;
   }

   public com.projectthani.SdtProfesional_Premios Clone( )
   {
      return (com.projectthani.SdtProfesional_Premios)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtProfesional_Premios struct )
   {
      setgxTv_SdtProfesional_Premios_Premiosid(struct.getPremiosid());
      setgxTv_SdtProfesional_Premios_Premiosnombre(struct.getPremiosnombre());
      setgxTv_SdtProfesional_Premios_Premiosfecha(struct.getPremiosfecha());
      setgxTv_SdtProfesional_Premios_Premiosdescripcion(struct.getPremiosdescripcion());
      setgxTv_SdtProfesional_Premios_Mode(struct.getMode());
      setgxTv_SdtProfesional_Premios_Modified(struct.getModified());
      setgxTv_SdtProfesional_Premios_Initialized(struct.getInitialized());
      setgxTv_SdtProfesional_Premios_Premiosid_Z(struct.getPremiosid_Z());
      setgxTv_SdtProfesional_Premios_Premiosnombre_Z(struct.getPremiosnombre_Z());
      setgxTv_SdtProfesional_Premios_Premiosfecha_Z(struct.getPremiosfecha_Z());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtProfesional_Premios getStruct( )
   {
      com.projectthani.StructSdtProfesional_Premios struct = new com.projectthani.StructSdtProfesional_Premios ();
      struct.setPremiosid(getgxTv_SdtProfesional_Premios_Premiosid());
      struct.setPremiosnombre(getgxTv_SdtProfesional_Premios_Premiosnombre());
      struct.setPremiosfecha(getgxTv_SdtProfesional_Premios_Premiosfecha());
      struct.setPremiosdescripcion(getgxTv_SdtProfesional_Premios_Premiosdescripcion());
      struct.setMode(getgxTv_SdtProfesional_Premios_Mode());
      struct.setModified(getgxTv_SdtProfesional_Premios_Modified());
      struct.setInitialized(getgxTv_SdtProfesional_Premios_Initialized());
      struct.setPremiosid_Z(getgxTv_SdtProfesional_Premios_Premiosid_Z());
      struct.setPremiosnombre_Z(getgxTv_SdtProfesional_Premios_Premiosnombre_Z());
      struct.setPremiosfecha_Z(getgxTv_SdtProfesional_Premios_Premiosfecha_Z());
      return struct ;
   }

   private byte gxTv_SdtProfesional_Premios_N ;
   private short gxTv_SdtProfesional_Premios_Modified ;
   private short gxTv_SdtProfesional_Premios_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtProfesional_Premios_Mode ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_SdtProfesional_Premios_Premiosfecha ;
   private java.util.Date gxTv_SdtProfesional_Premios_Premiosfecha_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtProfesional_Premios_Premiosdescripcion ;
   private String gxTv_SdtProfesional_Premios_Premiosnombre ;
   private String gxTv_SdtProfesional_Premios_Premiosnombre_Z ;
   private java.util.UUID gxTv_SdtProfesional_Premios_Premiosid ;
   private java.util.UUID gxTv_SdtProfesional_Premios_Premiosid_Z ;
}

