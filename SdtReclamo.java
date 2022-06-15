package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtReclamo extends GxSilentTrnSdt implements Cloneable, java.io.Serializable
{
   public SdtReclamo( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtReclamo.class));
   }

   public SdtReclamo( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle, context, "SdtReclamo");
      initialize( remoteHandle) ;
   }

   public SdtReclamo( int remoteHandle ,
                      StructSdtReclamo struct )
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

   public void Load( int AV51ReclamoId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV51ReclamoId)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"ReclamoId", int.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Reclamo");
      metadata.set("BT", "Reclamo");
      metadata.set("PK", "[ \"ReclamoId\" ]");
      metadata.set("PKAssigned", "[ \"ReclamoId\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"PacienteId\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ReclamoId") )
            {
               gxTv_SdtReclamo_Reclamoid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteId") )
            {
               gxTv_SdtReclamo_Pacienteid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ReclamoDescripcion") )
            {
               gxTv_SdtReclamo_Reclamodescripcion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ReclamoFecha") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtReclamo_Reclamofecha = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtReclamo_Reclamofecha = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtReclamo_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtReclamo_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ReclamoId_Z") )
            {
               gxTv_SdtReclamo_Reclamoid_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteId_Z") )
            {
               gxTv_SdtReclamo_Pacienteid_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ReclamoFecha_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtReclamo_Reclamofecha_Z = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtReclamo_Reclamofecha_Z = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), ".")))) ;
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
         sName = "Reclamo" ;
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
      oWriter.writeElement("ReclamoId", GXutil.trim( GXutil.str( gxTv_SdtReclamo_Reclamoid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteId", GXutil.trim( GXutil.str( gxTv_SdtReclamo_Pacienteid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ReclamoDescripcion", GXutil.rtrim( gxTv_SdtReclamo_Reclamodescripcion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtReclamo_Reclamofecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtReclamo_Reclamofecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtReclamo_Reclamofecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtReclamo_Reclamofecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtReclamo_Reclamofecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtReclamo_Reclamofecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("ReclamoFecha", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", GXutil.rtrim( gxTv_SdtReclamo_Mode));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtReclamo_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ReclamoId_Z", GXutil.trim( GXutil.str( gxTv_SdtReclamo_Reclamoid_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PacienteId_Z", GXutil.trim( GXutil.str( gxTv_SdtReclamo_Pacienteid_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtReclamo_Reclamofecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtReclamo_Reclamofecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtReclamo_Reclamofecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtReclamo_Reclamofecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtReclamo_Reclamofecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtReclamo_Reclamofecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("ReclamoFecha_Z", sDateCnv);
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
      AddObjectProperty("ReclamoId", gxTv_SdtReclamo_Reclamoid, false, includeNonInitialized);
      AddObjectProperty("PacienteId", gxTv_SdtReclamo_Pacienteid, false, includeNonInitialized);
      AddObjectProperty("ReclamoDescripcion", gxTv_SdtReclamo_Reclamodescripcion, false, includeNonInitialized);
      datetime_STZ = gxTv_SdtReclamo_Reclamofecha ;
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("ReclamoFecha", sDateCnv, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtReclamo_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtReclamo_Initialized, false, includeNonInitialized);
         AddObjectProperty("ReclamoId_Z", gxTv_SdtReclamo_Reclamoid_Z, false, includeNonInitialized);
         AddObjectProperty("PacienteId_Z", gxTv_SdtReclamo_Pacienteid_Z, false, includeNonInitialized);
         datetime_STZ = gxTv_SdtReclamo_Reclamofecha_Z ;
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( datetime_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( datetime_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( datetime_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( datetime_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( datetime_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( datetime_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("ReclamoFecha_Z", sDateCnv, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.projectthani.SdtReclamo sdt )
   {
      if ( sdt.IsDirty("ReclamoId") )
      {
         gxTv_SdtReclamo_N = (byte)(0) ;
         gxTv_SdtReclamo_Reclamoid = sdt.getgxTv_SdtReclamo_Reclamoid() ;
      }
      if ( sdt.IsDirty("PacienteId") )
      {
         gxTv_SdtReclamo_N = (byte)(0) ;
         gxTv_SdtReclamo_Pacienteid = sdt.getgxTv_SdtReclamo_Pacienteid() ;
      }
      if ( sdt.IsDirty("ReclamoDescripcion") )
      {
         gxTv_SdtReclamo_N = (byte)(0) ;
         gxTv_SdtReclamo_Reclamodescripcion = sdt.getgxTv_SdtReclamo_Reclamodescripcion() ;
      }
      if ( sdt.IsDirty("ReclamoFecha") )
      {
         gxTv_SdtReclamo_N = (byte)(0) ;
         gxTv_SdtReclamo_Reclamofecha = sdt.getgxTv_SdtReclamo_Reclamofecha() ;
      }
   }

   public int getgxTv_SdtReclamo_Reclamoid( )
   {
      return gxTv_SdtReclamo_Reclamoid ;
   }

   public void setgxTv_SdtReclamo_Reclamoid( int value )
   {
      gxTv_SdtReclamo_N = (byte)(0) ;
      if ( gxTv_SdtReclamo_Reclamoid != value )
      {
         gxTv_SdtReclamo_Mode = "INS" ;
         this.setgxTv_SdtReclamo_Reclamoid_Z_SetNull( );
         this.setgxTv_SdtReclamo_Pacienteid_Z_SetNull( );
         this.setgxTv_SdtReclamo_Reclamofecha_Z_SetNull( );
      }
      SetDirty("Reclamoid");
      gxTv_SdtReclamo_Reclamoid = value ;
   }

   public int getgxTv_SdtReclamo_Pacienteid( )
   {
      return gxTv_SdtReclamo_Pacienteid ;
   }

   public void setgxTv_SdtReclamo_Pacienteid( int value )
   {
      gxTv_SdtReclamo_N = (byte)(0) ;
      SetDirty("Pacienteid");
      gxTv_SdtReclamo_Pacienteid = value ;
   }

   public String getgxTv_SdtReclamo_Reclamodescripcion( )
   {
      return gxTv_SdtReclamo_Reclamodescripcion ;
   }

   public void setgxTv_SdtReclamo_Reclamodescripcion( String value )
   {
      gxTv_SdtReclamo_N = (byte)(0) ;
      SetDirty("Reclamodescripcion");
      gxTv_SdtReclamo_Reclamodescripcion = value ;
   }

   public java.util.Date getgxTv_SdtReclamo_Reclamofecha( )
   {
      return gxTv_SdtReclamo_Reclamofecha ;
   }

   public void setgxTv_SdtReclamo_Reclamofecha( java.util.Date value )
   {
      gxTv_SdtReclamo_N = (byte)(0) ;
      SetDirty("Reclamofecha");
      gxTv_SdtReclamo_Reclamofecha = value ;
   }

   public String getgxTv_SdtReclamo_Mode( )
   {
      return gxTv_SdtReclamo_Mode ;
   }

   public void setgxTv_SdtReclamo_Mode( String value )
   {
      gxTv_SdtReclamo_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtReclamo_Mode = value ;
   }

   public void setgxTv_SdtReclamo_Mode_SetNull( )
   {
      gxTv_SdtReclamo_Mode = "" ;
   }

   public boolean getgxTv_SdtReclamo_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtReclamo_Initialized( )
   {
      return gxTv_SdtReclamo_Initialized ;
   }

   public void setgxTv_SdtReclamo_Initialized( short value )
   {
      gxTv_SdtReclamo_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtReclamo_Initialized = value ;
   }

   public void setgxTv_SdtReclamo_Initialized_SetNull( )
   {
      gxTv_SdtReclamo_Initialized = (short)(0) ;
   }

   public boolean getgxTv_SdtReclamo_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtReclamo_Reclamoid_Z( )
   {
      return gxTv_SdtReclamo_Reclamoid_Z ;
   }

   public void setgxTv_SdtReclamo_Reclamoid_Z( int value )
   {
      gxTv_SdtReclamo_N = (byte)(0) ;
      SetDirty("Reclamoid_Z");
      gxTv_SdtReclamo_Reclamoid_Z = value ;
   }

   public void setgxTv_SdtReclamo_Reclamoid_Z_SetNull( )
   {
      gxTv_SdtReclamo_Reclamoid_Z = 0 ;
   }

   public boolean getgxTv_SdtReclamo_Reclamoid_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtReclamo_Pacienteid_Z( )
   {
      return gxTv_SdtReclamo_Pacienteid_Z ;
   }

   public void setgxTv_SdtReclamo_Pacienteid_Z( int value )
   {
      gxTv_SdtReclamo_N = (byte)(0) ;
      SetDirty("Pacienteid_Z");
      gxTv_SdtReclamo_Pacienteid_Z = value ;
   }

   public void setgxTv_SdtReclamo_Pacienteid_Z_SetNull( )
   {
      gxTv_SdtReclamo_Pacienteid_Z = 0 ;
   }

   public boolean getgxTv_SdtReclamo_Pacienteid_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtReclamo_Reclamofecha_Z( )
   {
      return gxTv_SdtReclamo_Reclamofecha_Z ;
   }

   public void setgxTv_SdtReclamo_Reclamofecha_Z( java.util.Date value )
   {
      gxTv_SdtReclamo_N = (byte)(0) ;
      SetDirty("Reclamofecha_Z");
      gxTv_SdtReclamo_Reclamofecha_Z = value ;
   }

   public void setgxTv_SdtReclamo_Reclamofecha_Z_SetNull( )
   {
      gxTv_SdtReclamo_Reclamofecha_Z = GXutil.resetTime( GXutil.nullDate() );
   }

   public boolean getgxTv_SdtReclamo_Reclamofecha_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.projectthani.reclamo_bc obj;
      obj = new com.projectthani.reclamo_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtReclamo_N = (byte)(1) ;
      gxTv_SdtReclamo_Reclamodescripcion = "" ;
      gxTv_SdtReclamo_Reclamofecha = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtReclamo_Mode = "" ;
      gxTv_SdtReclamo_Reclamofecha_Z = GXutil.resetTime( GXutil.nullDate() );
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
      datetime_STZ = GXutil.resetTime( GXutil.nullDate() );
   }

   public byte isNull( )
   {
      return gxTv_SdtReclamo_N ;
   }

   public com.projectthani.SdtReclamo Clone( )
   {
      com.projectthani.SdtReclamo sdt;
      com.projectthani.reclamo_bc obj;
      sdt = (com.projectthani.SdtReclamo)(clone()) ;
      obj = (com.projectthani.reclamo_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.projectthani.StructSdtReclamo struct )
   {
      setgxTv_SdtReclamo_Reclamoid(struct.getReclamoid());
      setgxTv_SdtReclamo_Pacienteid(struct.getPacienteid());
      setgxTv_SdtReclamo_Reclamodescripcion(struct.getReclamodescripcion());
      setgxTv_SdtReclamo_Reclamofecha(struct.getReclamofecha());
      setgxTv_SdtReclamo_Mode(struct.getMode());
      setgxTv_SdtReclamo_Initialized(struct.getInitialized());
      setgxTv_SdtReclamo_Reclamoid_Z(struct.getReclamoid_Z());
      setgxTv_SdtReclamo_Pacienteid_Z(struct.getPacienteid_Z());
      setgxTv_SdtReclamo_Reclamofecha_Z(struct.getReclamofecha_Z());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtReclamo getStruct( )
   {
      com.projectthani.StructSdtReclamo struct = new com.projectthani.StructSdtReclamo ();
      struct.setReclamoid(getgxTv_SdtReclamo_Reclamoid());
      struct.setPacienteid(getgxTv_SdtReclamo_Pacienteid());
      struct.setReclamodescripcion(getgxTv_SdtReclamo_Reclamodescripcion());
      struct.setReclamofecha(getgxTv_SdtReclamo_Reclamofecha());
      struct.setMode(getgxTv_SdtReclamo_Mode());
      struct.setInitialized(getgxTv_SdtReclamo_Initialized());
      struct.setReclamoid_Z(getgxTv_SdtReclamo_Reclamoid_Z());
      struct.setPacienteid_Z(getgxTv_SdtReclamo_Pacienteid_Z());
      struct.setReclamofecha_Z(getgxTv_SdtReclamo_Reclamofecha_Z());
      return struct ;
   }

   private byte gxTv_SdtReclamo_N ;
   private short gxTv_SdtReclamo_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtReclamo_Reclamoid ;
   private int gxTv_SdtReclamo_Pacienteid ;
   private int gxTv_SdtReclamo_Reclamoid_Z ;
   private int gxTv_SdtReclamo_Pacienteid_Z ;
   private String gxTv_SdtReclamo_Mode ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_SdtReclamo_Reclamofecha ;
   private java.util.Date gxTv_SdtReclamo_Reclamofecha_Z ;
   private java.util.Date datetime_STZ ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtReclamo_Reclamodescripcion ;
}

