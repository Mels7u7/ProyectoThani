package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSchedulerEvents_Day extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSchedulerEvents_Day( )
   {
      this(  new ModelContext(SdtSchedulerEvents_Day.class));
   }

   public SdtSchedulerEvents_Day( ModelContext context )
   {
      super( context, "SdtSchedulerEvents_Day");
   }

   public SdtSchedulerEvents_Day( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle, context, "SdtSchedulerEvents_Day");
   }

   public SdtSchedulerEvents_Day( StructSdtSchedulerEvents_Day struct )
   {
      this();
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Date") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtSchedulerEvents_Day_Date = GXutil.nullDate() ;
                  gxTv_SdtSchedulerEvents_Day_Date_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtSchedulerEvents_Day_Date_N = (byte)(0) ;
                  gxTv_SdtSchedulerEvents_Day_Date = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Color") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtSchedulerEvents_Day_Color = oReader.getValue() ;
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
         sName = "SchedulerEvents.Day" ;
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
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_SdtSchedulerEvents_Day_Date)) && ( gxTv_SdtSchedulerEvents_Day_Date_N == 1 ) )
      {
         oWriter.writeElement("Date", "");
         if ( GXutil.strcmp(sNameSpace, "") != 0 )
         {
            oWriter.writeAttribute("xmlns", "");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSchedulerEvents_Day_Date), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSchedulerEvents_Day_Date), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSchedulerEvents_Day_Date), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("Date", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "") != 0 )
         {
            oWriter.writeAttribute("xmlns", "");
         }
      }
      oWriter.writeElement("Color", GXutil.rtrim( gxTv_SdtSchedulerEvents_Day_Color));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeEndElement();
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
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSchedulerEvents_Day_Date), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSchedulerEvents_Day_Date), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSchedulerEvents_Day_Date), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("Date", sDateCnv, false, false);
      AddObjectProperty("Color", gxTv_SdtSchedulerEvents_Day_Color, false, false);
   }

   public java.util.Date getgxTv_SdtSchedulerEvents_Day_Date( )
   {
      return gxTv_SdtSchedulerEvents_Day_Date ;
   }

   public void setgxTv_SdtSchedulerEvents_Day_Date( java.util.Date value )
   {
      gxTv_SdtSchedulerEvents_Day_Date_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_Day_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_Day_Date = value ;
   }

   public String getgxTv_SdtSchedulerEvents_Day_Color( )
   {
      return gxTv_SdtSchedulerEvents_Day_Color ;
   }

   public void setgxTv_SdtSchedulerEvents_Day_Color( String value )
   {
      gxTv_SdtSchedulerEvents_Day_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_Day_Color = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSchedulerEvents_Day_Date = GXutil.nullDate() ;
      gxTv_SdtSchedulerEvents_Day_Date_N = (byte)(1) ;
      gxTv_SdtSchedulerEvents_Day_N = (byte)(1) ;
      gxTv_SdtSchedulerEvents_Day_Color = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSchedulerEvents_Day_N ;
   }

   public com.projectthani.SdtSchedulerEvents_Day Clone( )
   {
      return (com.projectthani.SdtSchedulerEvents_Day)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSchedulerEvents_Day struct )
   {
      if ( struct.gxTv_SdtSchedulerEvents_Day_Date_N == 0 )
      {
         setgxTv_SdtSchedulerEvents_Day_Date(struct.getDate());
      }
      setgxTv_SdtSchedulerEvents_Day_Color(struct.getColor());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSchedulerEvents_Day getStruct( )
   {
      com.projectthani.StructSdtSchedulerEvents_Day struct = new com.projectthani.StructSdtSchedulerEvents_Day ();
      if ( gxTv_SdtSchedulerEvents_Day_Date_N == 0 )
      {
         struct.setDate(getgxTv_SdtSchedulerEvents_Day_Date());
      }
      struct.setColor(getgxTv_SdtSchedulerEvents_Day_Color());
      return struct ;
   }

   protected byte gxTv_SdtSchedulerEvents_Day_Date_N ;
   protected byte gxTv_SdtSchedulerEvents_Day_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtSchedulerEvents_Day_Color ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_SdtSchedulerEvents_Day_Date ;
   protected boolean readElement ;
   protected boolean formatError ;
}

