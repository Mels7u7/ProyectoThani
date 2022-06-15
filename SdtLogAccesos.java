package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtLogAccesos extends GxSilentTrnSdt implements Cloneable, java.io.Serializable
{
   public SdtLogAccesos( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtLogAccesos.class));
   }

   public SdtLogAccesos( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle, context, "SdtLogAccesos");
      initialize( remoteHandle) ;
   }

   public SdtLogAccesos( int remoteHandle ,
                         StructSdtLogAccesos struct )
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

   public void Load( short AV41LogAccesosId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Short.valueOf(AV41LogAccesosId)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"LogAccesosId", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "LogAccesos");
      metadata.set("BT", "LogAccesos");
      metadata.set("PK", "[ \"LogAccesosId\" ]");
      metadata.set("PKAssigned", "[ \"LogAccesosId\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"SecUserId\",\"SecRoleId\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "LogAccesosId") )
            {
               gxTv_SdtLogAccesos_Logaccesosid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserId") )
            {
               gxTv_SdtLogAccesos_Secuserid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserName") )
            {
               gxTv_SdtLogAccesos_Secusername = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecRoleId") )
            {
               gxTv_SdtLogAccesos_Secroleid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecRoleDescription") )
            {
               gxTv_SdtLogAccesos_Secroledescription = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LogAccesosFullName") )
            {
               gxTv_SdtLogAccesos_Logaccesosfullname = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LogAccesosTipo") )
            {
               gxTv_SdtLogAccesos_Logaccesostipo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LogAccesosFecha") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLogAccesos_Logaccesosfecha = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtLogAccesos_Logaccesosfecha = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), ".")))) ;
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
               gxTv_SdtLogAccesos_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtLogAccesos_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LogAccesosId_Z") )
            {
               gxTv_SdtLogAccesos_Logaccesosid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserId_Z") )
            {
               gxTv_SdtLogAccesos_Secuserid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserName_Z") )
            {
               gxTv_SdtLogAccesos_Secusername_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecRoleId_Z") )
            {
               gxTv_SdtLogAccesos_Secroleid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecRoleDescription_Z") )
            {
               gxTv_SdtLogAccesos_Secroledescription_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LogAccesosFullName_Z") )
            {
               gxTv_SdtLogAccesos_Logaccesosfullname_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LogAccesosTipo_Z") )
            {
               gxTv_SdtLogAccesos_Logaccesostipo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LogAccesosFecha_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLogAccesos_Logaccesosfecha_Z = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtLogAccesos_Logaccesosfecha_Z = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), ".")))) ;
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
         sName = "LogAccesos" ;
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
      oWriter.writeElement("LogAccesosId", GXutil.trim( GXutil.str( gxTv_SdtLogAccesos_Logaccesosid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SecUserId", GXutil.trim( GXutil.str( gxTv_SdtLogAccesos_Secuserid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SecUserName", GXutil.rtrim( gxTv_SdtLogAccesos_Secusername));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SecRoleId", GXutil.trim( GXutil.str( gxTv_SdtLogAccesos_Secroleid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SecRoleDescription", GXutil.rtrim( gxTv_SdtLogAccesos_Secroledescription));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("LogAccesosFullName", GXutil.rtrim( gxTv_SdtLogAccesos_Logaccesosfullname));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("LogAccesosTipo", GXutil.rtrim( gxTv_SdtLogAccesos_Logaccesostipo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLogAccesos_Logaccesosfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLogAccesos_Logaccesosfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLogAccesos_Logaccesosfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtLogAccesos_Logaccesosfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtLogAccesos_Logaccesosfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtLogAccesos_Logaccesosfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("LogAccesosFecha", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", GXutil.rtrim( gxTv_SdtLogAccesos_Mode));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtLogAccesos_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("LogAccesosId_Z", GXutil.trim( GXutil.str( gxTv_SdtLogAccesos_Logaccesosid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SecUserId_Z", GXutil.trim( GXutil.str( gxTv_SdtLogAccesos_Secuserid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SecUserName_Z", GXutil.rtrim( gxTv_SdtLogAccesos_Secusername_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SecRoleId_Z", GXutil.trim( GXutil.str( gxTv_SdtLogAccesos_Secroleid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SecRoleDescription_Z", GXutil.rtrim( gxTv_SdtLogAccesos_Secroledescription_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("LogAccesosFullName_Z", GXutil.rtrim( gxTv_SdtLogAccesos_Logaccesosfullname_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("LogAccesosTipo_Z", GXutil.rtrim( gxTv_SdtLogAccesos_Logaccesostipo_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLogAccesos_Logaccesosfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLogAccesos_Logaccesosfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLogAccesos_Logaccesosfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtLogAccesos_Logaccesosfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtLogAccesos_Logaccesosfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtLogAccesos_Logaccesosfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LogAccesosFecha_Z", sDateCnv);
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
      AddObjectProperty("LogAccesosId", gxTv_SdtLogAccesos_Logaccesosid, false, includeNonInitialized);
      AddObjectProperty("SecUserId", gxTv_SdtLogAccesos_Secuserid, false, includeNonInitialized);
      AddObjectProperty("SecUserName", gxTv_SdtLogAccesos_Secusername, false, includeNonInitialized);
      AddObjectProperty("SecRoleId", gxTv_SdtLogAccesos_Secroleid, false, includeNonInitialized);
      AddObjectProperty("SecRoleDescription", gxTv_SdtLogAccesos_Secroledescription, false, includeNonInitialized);
      AddObjectProperty("LogAccesosFullName", gxTv_SdtLogAccesos_Logaccesosfullname, false, includeNonInitialized);
      AddObjectProperty("LogAccesosTipo", gxTv_SdtLogAccesos_Logaccesostipo, false, includeNonInitialized);
      datetime_STZ = gxTv_SdtLogAccesos_Logaccesosfecha ;
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
      AddObjectProperty("LogAccesosFecha", sDateCnv, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtLogAccesos_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtLogAccesos_Initialized, false, includeNonInitialized);
         AddObjectProperty("LogAccesosId_Z", gxTv_SdtLogAccesos_Logaccesosid_Z, false, includeNonInitialized);
         AddObjectProperty("SecUserId_Z", gxTv_SdtLogAccesos_Secuserid_Z, false, includeNonInitialized);
         AddObjectProperty("SecUserName_Z", gxTv_SdtLogAccesos_Secusername_Z, false, includeNonInitialized);
         AddObjectProperty("SecRoleId_Z", gxTv_SdtLogAccesos_Secroleid_Z, false, includeNonInitialized);
         AddObjectProperty("SecRoleDescription_Z", gxTv_SdtLogAccesos_Secroledescription_Z, false, includeNonInitialized);
         AddObjectProperty("LogAccesosFullName_Z", gxTv_SdtLogAccesos_Logaccesosfullname_Z, false, includeNonInitialized);
         AddObjectProperty("LogAccesosTipo_Z", gxTv_SdtLogAccesos_Logaccesostipo_Z, false, includeNonInitialized);
         datetime_STZ = gxTv_SdtLogAccesos_Logaccesosfecha_Z ;
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
         AddObjectProperty("LogAccesosFecha_Z", sDateCnv, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.projectthani.SdtLogAccesos sdt )
   {
      if ( sdt.IsDirty("LogAccesosId") )
      {
         gxTv_SdtLogAccesos_N = (byte)(0) ;
         gxTv_SdtLogAccesos_Logaccesosid = sdt.getgxTv_SdtLogAccesos_Logaccesosid() ;
      }
      if ( sdt.IsDirty("SecUserId") )
      {
         gxTv_SdtLogAccesos_N = (byte)(0) ;
         gxTv_SdtLogAccesos_Secuserid = sdt.getgxTv_SdtLogAccesos_Secuserid() ;
      }
      if ( sdt.IsDirty("SecUserName") )
      {
         gxTv_SdtLogAccesos_N = (byte)(0) ;
         gxTv_SdtLogAccesos_Secusername = sdt.getgxTv_SdtLogAccesos_Secusername() ;
      }
      if ( sdt.IsDirty("SecRoleId") )
      {
         gxTv_SdtLogAccesos_N = (byte)(0) ;
         gxTv_SdtLogAccesos_Secroleid = sdt.getgxTv_SdtLogAccesos_Secroleid() ;
      }
      if ( sdt.IsDirty("SecRoleDescription") )
      {
         gxTv_SdtLogAccesos_N = (byte)(0) ;
         gxTv_SdtLogAccesos_Secroledescription = sdt.getgxTv_SdtLogAccesos_Secroledescription() ;
      }
      if ( sdt.IsDirty("LogAccesosFullName") )
      {
         gxTv_SdtLogAccesos_N = (byte)(0) ;
         gxTv_SdtLogAccesos_Logaccesosfullname = sdt.getgxTv_SdtLogAccesos_Logaccesosfullname() ;
      }
      if ( sdt.IsDirty("LogAccesosTipo") )
      {
         gxTv_SdtLogAccesos_N = (byte)(0) ;
         gxTv_SdtLogAccesos_Logaccesostipo = sdt.getgxTv_SdtLogAccesos_Logaccesostipo() ;
      }
      if ( sdt.IsDirty("LogAccesosFecha") )
      {
         gxTv_SdtLogAccesos_N = (byte)(0) ;
         gxTv_SdtLogAccesos_Logaccesosfecha = sdt.getgxTv_SdtLogAccesos_Logaccesosfecha() ;
      }
   }

   public short getgxTv_SdtLogAccesos_Logaccesosid( )
   {
      return gxTv_SdtLogAccesos_Logaccesosid ;
   }

   public void setgxTv_SdtLogAccesos_Logaccesosid( short value )
   {
      gxTv_SdtLogAccesos_N = (byte)(0) ;
      if ( gxTv_SdtLogAccesos_Logaccesosid != value )
      {
         gxTv_SdtLogAccesos_Mode = "INS" ;
         this.setgxTv_SdtLogAccesos_Logaccesosid_Z_SetNull( );
         this.setgxTv_SdtLogAccesos_Secuserid_Z_SetNull( );
         this.setgxTv_SdtLogAccesos_Secusername_Z_SetNull( );
         this.setgxTv_SdtLogAccesos_Secroleid_Z_SetNull( );
         this.setgxTv_SdtLogAccesos_Secroledescription_Z_SetNull( );
         this.setgxTv_SdtLogAccesos_Logaccesosfullname_Z_SetNull( );
         this.setgxTv_SdtLogAccesos_Logaccesostipo_Z_SetNull( );
         this.setgxTv_SdtLogAccesos_Logaccesosfecha_Z_SetNull( );
      }
      SetDirty("Logaccesosid");
      gxTv_SdtLogAccesos_Logaccesosid = value ;
   }

   public short getgxTv_SdtLogAccesos_Secuserid( )
   {
      return gxTv_SdtLogAccesos_Secuserid ;
   }

   public void setgxTv_SdtLogAccesos_Secuserid( short value )
   {
      gxTv_SdtLogAccesos_N = (byte)(0) ;
      SetDirty("Secuserid");
      gxTv_SdtLogAccesos_Secuserid = value ;
   }

   public String getgxTv_SdtLogAccesos_Secusername( )
   {
      return gxTv_SdtLogAccesos_Secusername ;
   }

   public void setgxTv_SdtLogAccesos_Secusername( String value )
   {
      gxTv_SdtLogAccesos_N = (byte)(0) ;
      SetDirty("Secusername");
      gxTv_SdtLogAccesos_Secusername = value ;
   }

   public short getgxTv_SdtLogAccesos_Secroleid( )
   {
      return gxTv_SdtLogAccesos_Secroleid ;
   }

   public void setgxTv_SdtLogAccesos_Secroleid( short value )
   {
      gxTv_SdtLogAccesos_N = (byte)(0) ;
      SetDirty("Secroleid");
      gxTv_SdtLogAccesos_Secroleid = value ;
   }

   public String getgxTv_SdtLogAccesos_Secroledescription( )
   {
      return gxTv_SdtLogAccesos_Secroledescription ;
   }

   public void setgxTv_SdtLogAccesos_Secroledescription( String value )
   {
      gxTv_SdtLogAccesos_N = (byte)(0) ;
      SetDirty("Secroledescription");
      gxTv_SdtLogAccesos_Secroledescription = value ;
   }

   public String getgxTv_SdtLogAccesos_Logaccesosfullname( )
   {
      return gxTv_SdtLogAccesos_Logaccesosfullname ;
   }

   public void setgxTv_SdtLogAccesos_Logaccesosfullname( String value )
   {
      gxTv_SdtLogAccesos_N = (byte)(0) ;
      SetDirty("Logaccesosfullname");
      gxTv_SdtLogAccesos_Logaccesosfullname = value ;
   }

   public void setgxTv_SdtLogAccesos_Logaccesosfullname_SetNull( )
   {
      gxTv_SdtLogAccesos_Logaccesosfullname = "" ;
   }

   public boolean getgxTv_SdtLogAccesos_Logaccesosfullname_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLogAccesos_Logaccesostipo( )
   {
      return gxTv_SdtLogAccesos_Logaccesostipo ;
   }

   public void setgxTv_SdtLogAccesos_Logaccesostipo( String value )
   {
      gxTv_SdtLogAccesos_N = (byte)(0) ;
      SetDirty("Logaccesostipo");
      gxTv_SdtLogAccesos_Logaccesostipo = value ;
   }

   public java.util.Date getgxTv_SdtLogAccesos_Logaccesosfecha( )
   {
      return gxTv_SdtLogAccesos_Logaccesosfecha ;
   }

   public void setgxTv_SdtLogAccesos_Logaccesosfecha( java.util.Date value )
   {
      gxTv_SdtLogAccesos_N = (byte)(0) ;
      SetDirty("Logaccesosfecha");
      gxTv_SdtLogAccesos_Logaccesosfecha = value ;
   }

   public String getgxTv_SdtLogAccesos_Mode( )
   {
      return gxTv_SdtLogAccesos_Mode ;
   }

   public void setgxTv_SdtLogAccesos_Mode( String value )
   {
      gxTv_SdtLogAccesos_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtLogAccesos_Mode = value ;
   }

   public void setgxTv_SdtLogAccesos_Mode_SetNull( )
   {
      gxTv_SdtLogAccesos_Mode = "" ;
   }

   public boolean getgxTv_SdtLogAccesos_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLogAccesos_Initialized( )
   {
      return gxTv_SdtLogAccesos_Initialized ;
   }

   public void setgxTv_SdtLogAccesos_Initialized( short value )
   {
      gxTv_SdtLogAccesos_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtLogAccesos_Initialized = value ;
   }

   public void setgxTv_SdtLogAccesos_Initialized_SetNull( )
   {
      gxTv_SdtLogAccesos_Initialized = (short)(0) ;
   }

   public boolean getgxTv_SdtLogAccesos_Initialized_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLogAccesos_Logaccesosid_Z( )
   {
      return gxTv_SdtLogAccesos_Logaccesosid_Z ;
   }

   public void setgxTv_SdtLogAccesos_Logaccesosid_Z( short value )
   {
      gxTv_SdtLogAccesos_N = (byte)(0) ;
      SetDirty("Logaccesosid_Z");
      gxTv_SdtLogAccesos_Logaccesosid_Z = value ;
   }

   public void setgxTv_SdtLogAccesos_Logaccesosid_Z_SetNull( )
   {
      gxTv_SdtLogAccesos_Logaccesosid_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtLogAccesos_Logaccesosid_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLogAccesos_Secuserid_Z( )
   {
      return gxTv_SdtLogAccesos_Secuserid_Z ;
   }

   public void setgxTv_SdtLogAccesos_Secuserid_Z( short value )
   {
      gxTv_SdtLogAccesos_N = (byte)(0) ;
      SetDirty("Secuserid_Z");
      gxTv_SdtLogAccesos_Secuserid_Z = value ;
   }

   public void setgxTv_SdtLogAccesos_Secuserid_Z_SetNull( )
   {
      gxTv_SdtLogAccesos_Secuserid_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtLogAccesos_Secuserid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLogAccesos_Secusername_Z( )
   {
      return gxTv_SdtLogAccesos_Secusername_Z ;
   }

   public void setgxTv_SdtLogAccesos_Secusername_Z( String value )
   {
      gxTv_SdtLogAccesos_N = (byte)(0) ;
      SetDirty("Secusername_Z");
      gxTv_SdtLogAccesos_Secusername_Z = value ;
   }

   public void setgxTv_SdtLogAccesos_Secusername_Z_SetNull( )
   {
      gxTv_SdtLogAccesos_Secusername_Z = "" ;
   }

   public boolean getgxTv_SdtLogAccesos_Secusername_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLogAccesos_Secroleid_Z( )
   {
      return gxTv_SdtLogAccesos_Secroleid_Z ;
   }

   public void setgxTv_SdtLogAccesos_Secroleid_Z( short value )
   {
      gxTv_SdtLogAccesos_N = (byte)(0) ;
      SetDirty("Secroleid_Z");
      gxTv_SdtLogAccesos_Secroleid_Z = value ;
   }

   public void setgxTv_SdtLogAccesos_Secroleid_Z_SetNull( )
   {
      gxTv_SdtLogAccesos_Secroleid_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtLogAccesos_Secroleid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLogAccesos_Secroledescription_Z( )
   {
      return gxTv_SdtLogAccesos_Secroledescription_Z ;
   }

   public void setgxTv_SdtLogAccesos_Secroledescription_Z( String value )
   {
      gxTv_SdtLogAccesos_N = (byte)(0) ;
      SetDirty("Secroledescription_Z");
      gxTv_SdtLogAccesos_Secroledescription_Z = value ;
   }

   public void setgxTv_SdtLogAccesos_Secroledescription_Z_SetNull( )
   {
      gxTv_SdtLogAccesos_Secroledescription_Z = "" ;
   }

   public boolean getgxTv_SdtLogAccesos_Secroledescription_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLogAccesos_Logaccesosfullname_Z( )
   {
      return gxTv_SdtLogAccesos_Logaccesosfullname_Z ;
   }

   public void setgxTv_SdtLogAccesos_Logaccesosfullname_Z( String value )
   {
      gxTv_SdtLogAccesos_N = (byte)(0) ;
      SetDirty("Logaccesosfullname_Z");
      gxTv_SdtLogAccesos_Logaccesosfullname_Z = value ;
   }

   public void setgxTv_SdtLogAccesos_Logaccesosfullname_Z_SetNull( )
   {
      gxTv_SdtLogAccesos_Logaccesosfullname_Z = "" ;
   }

   public boolean getgxTv_SdtLogAccesos_Logaccesosfullname_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLogAccesos_Logaccesostipo_Z( )
   {
      return gxTv_SdtLogAccesos_Logaccesostipo_Z ;
   }

   public void setgxTv_SdtLogAccesos_Logaccesostipo_Z( String value )
   {
      gxTv_SdtLogAccesos_N = (byte)(0) ;
      SetDirty("Logaccesostipo_Z");
      gxTv_SdtLogAccesos_Logaccesostipo_Z = value ;
   }

   public void setgxTv_SdtLogAccesos_Logaccesostipo_Z_SetNull( )
   {
      gxTv_SdtLogAccesos_Logaccesostipo_Z = "" ;
   }

   public boolean getgxTv_SdtLogAccesos_Logaccesostipo_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtLogAccesos_Logaccesosfecha_Z( )
   {
      return gxTv_SdtLogAccesos_Logaccesosfecha_Z ;
   }

   public void setgxTv_SdtLogAccesos_Logaccesosfecha_Z( java.util.Date value )
   {
      gxTv_SdtLogAccesos_N = (byte)(0) ;
      SetDirty("Logaccesosfecha_Z");
      gxTv_SdtLogAccesos_Logaccesosfecha_Z = value ;
   }

   public void setgxTv_SdtLogAccesos_Logaccesosfecha_Z_SetNull( )
   {
      gxTv_SdtLogAccesos_Logaccesosfecha_Z = GXutil.resetTime( GXutil.nullDate() );
   }

   public boolean getgxTv_SdtLogAccesos_Logaccesosfecha_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.projectthani.logaccesos_bc obj;
      obj = new com.projectthani.logaccesos_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtLogAccesos_N = (byte)(1) ;
      gxTv_SdtLogAccesos_Secusername = "" ;
      gxTv_SdtLogAccesos_Secroledescription = "" ;
      gxTv_SdtLogAccesos_Logaccesosfullname = "" ;
      gxTv_SdtLogAccesos_Logaccesostipo = "" ;
      gxTv_SdtLogAccesos_Logaccesosfecha = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtLogAccesos_Mode = "" ;
      gxTv_SdtLogAccesos_Secusername_Z = "" ;
      gxTv_SdtLogAccesos_Secroledescription_Z = "" ;
      gxTv_SdtLogAccesos_Logaccesosfullname_Z = "" ;
      gxTv_SdtLogAccesos_Logaccesostipo_Z = "" ;
      gxTv_SdtLogAccesos_Logaccesosfecha_Z = GXutil.resetTime( GXutil.nullDate() );
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
      datetime_STZ = GXutil.resetTime( GXutil.nullDate() );
   }

   public byte isNull( )
   {
      return gxTv_SdtLogAccesos_N ;
   }

   public com.projectthani.SdtLogAccesos Clone( )
   {
      com.projectthani.SdtLogAccesos sdt;
      com.projectthani.logaccesos_bc obj;
      sdt = (com.projectthani.SdtLogAccesos)(clone()) ;
      obj = (com.projectthani.logaccesos_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.projectthani.StructSdtLogAccesos struct )
   {
      setgxTv_SdtLogAccesos_Logaccesosid(struct.getLogaccesosid());
      setgxTv_SdtLogAccesos_Secuserid(struct.getSecuserid());
      setgxTv_SdtLogAccesos_Secusername(struct.getSecusername());
      setgxTv_SdtLogAccesos_Secroleid(struct.getSecroleid());
      setgxTv_SdtLogAccesos_Secroledescription(struct.getSecroledescription());
      setgxTv_SdtLogAccesos_Logaccesosfullname(struct.getLogaccesosfullname());
      setgxTv_SdtLogAccesos_Logaccesostipo(struct.getLogaccesostipo());
      setgxTv_SdtLogAccesos_Logaccesosfecha(struct.getLogaccesosfecha());
      setgxTv_SdtLogAccesos_Mode(struct.getMode());
      setgxTv_SdtLogAccesos_Initialized(struct.getInitialized());
      setgxTv_SdtLogAccesos_Logaccesosid_Z(struct.getLogaccesosid_Z());
      setgxTv_SdtLogAccesos_Secuserid_Z(struct.getSecuserid_Z());
      setgxTv_SdtLogAccesos_Secusername_Z(struct.getSecusername_Z());
      setgxTv_SdtLogAccesos_Secroleid_Z(struct.getSecroleid_Z());
      setgxTv_SdtLogAccesos_Secroledescription_Z(struct.getSecroledescription_Z());
      setgxTv_SdtLogAccesos_Logaccesosfullname_Z(struct.getLogaccesosfullname_Z());
      setgxTv_SdtLogAccesos_Logaccesostipo_Z(struct.getLogaccesostipo_Z());
      setgxTv_SdtLogAccesos_Logaccesosfecha_Z(struct.getLogaccesosfecha_Z());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtLogAccesos getStruct( )
   {
      com.projectthani.StructSdtLogAccesos struct = new com.projectthani.StructSdtLogAccesos ();
      struct.setLogaccesosid(getgxTv_SdtLogAccesos_Logaccesosid());
      struct.setSecuserid(getgxTv_SdtLogAccesos_Secuserid());
      struct.setSecusername(getgxTv_SdtLogAccesos_Secusername());
      struct.setSecroleid(getgxTv_SdtLogAccesos_Secroleid());
      struct.setSecroledescription(getgxTv_SdtLogAccesos_Secroledescription());
      struct.setLogaccesosfullname(getgxTv_SdtLogAccesos_Logaccesosfullname());
      struct.setLogaccesostipo(getgxTv_SdtLogAccesos_Logaccesostipo());
      struct.setLogaccesosfecha(getgxTv_SdtLogAccesos_Logaccesosfecha());
      struct.setMode(getgxTv_SdtLogAccesos_Mode());
      struct.setInitialized(getgxTv_SdtLogAccesos_Initialized());
      struct.setLogaccesosid_Z(getgxTv_SdtLogAccesos_Logaccesosid_Z());
      struct.setSecuserid_Z(getgxTv_SdtLogAccesos_Secuserid_Z());
      struct.setSecusername_Z(getgxTv_SdtLogAccesos_Secusername_Z());
      struct.setSecroleid_Z(getgxTv_SdtLogAccesos_Secroleid_Z());
      struct.setSecroledescription_Z(getgxTv_SdtLogAccesos_Secroledescription_Z());
      struct.setLogaccesosfullname_Z(getgxTv_SdtLogAccesos_Logaccesosfullname_Z());
      struct.setLogaccesostipo_Z(getgxTv_SdtLogAccesos_Logaccesostipo_Z());
      struct.setLogaccesosfecha_Z(getgxTv_SdtLogAccesos_Logaccesosfecha_Z());
      return struct ;
   }

   private byte gxTv_SdtLogAccesos_N ;
   private short gxTv_SdtLogAccesos_Logaccesosid ;
   private short gxTv_SdtLogAccesos_Secuserid ;
   private short gxTv_SdtLogAccesos_Secroleid ;
   private short gxTv_SdtLogAccesos_Initialized ;
   private short gxTv_SdtLogAccesos_Logaccesosid_Z ;
   private short gxTv_SdtLogAccesos_Secuserid_Z ;
   private short gxTv_SdtLogAccesos_Secroleid_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtLogAccesos_Logaccesostipo ;
   private String gxTv_SdtLogAccesos_Mode ;
   private String gxTv_SdtLogAccesos_Logaccesostipo_Z ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_SdtLogAccesos_Logaccesosfecha ;
   private java.util.Date gxTv_SdtLogAccesos_Logaccesosfecha_Z ;
   private java.util.Date datetime_STZ ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtLogAccesos_Secusername ;
   private String gxTv_SdtLogAccesos_Secroledescription ;
   private String gxTv_SdtLogAccesos_Logaccesosfullname ;
   private String gxTv_SdtLogAccesos_Secusername_Z ;
   private String gxTv_SdtLogAccesos_Secroledescription_Z ;
   private String gxTv_SdtLogAccesos_Logaccesosfullname_Z ;
}

