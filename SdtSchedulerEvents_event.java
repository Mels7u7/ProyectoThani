package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSchedulerEvents_event extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSchedulerEvents_event( )
   {
      this(  new ModelContext(SdtSchedulerEvents_event.class));
   }

   public SdtSchedulerEvents_event( ModelContext context )
   {
      super( context, "SdtSchedulerEvents_event");
   }

   public SdtSchedulerEvents_event( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle, context, "SdtSchedulerEvents_event");
   }

   public SdtSchedulerEvents_event( StructSdtSchedulerEvents_event struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Id") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtSchedulerEvents_event_Id = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Name") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtSchedulerEvents_event_Name = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Notes") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtSchedulerEvents_event_Notes = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Link") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtSchedulerEvents_event_Link = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "StartTime") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtSchedulerEvents_event_Starttime = GXutil.resetTime( GXutil.nullDate() );
                  gxTv_SdtSchedulerEvents_event_Starttime_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtSchedulerEvents_event_Starttime_N = (byte)(0) ;
                  gxTv_SdtSchedulerEvents_event_Starttime = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EndTime") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtSchedulerEvents_event_Endtime = GXutil.resetTime( GXutil.nullDate() );
                  gxTv_SdtSchedulerEvents_event_Endtime_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtSchedulerEvents_event_Endtime_N = (byte)(0) ;
                  gxTv_SdtSchedulerEvents_event_Endtime = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AdditionalInformation") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtSchedulerEvents_event_Additionalinformation = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Color") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtSchedulerEvents_event_Color = oReader.getValue() ;
               gxTv_SdtSchedulerEvents_event_Color_N = (byte)(0) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "BackgroundColor") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtSchedulerEvents_event_Backgroundcolor = oReader.getValue() ;
               gxTv_SdtSchedulerEvents_event_Backgroundcolor_N = (byte)(0) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "NameWeekView") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtSchedulerEvents_event_Nameweekview = oReader.getValue() ;
               gxTv_SdtSchedulerEvents_event_Nameweekview_N = (byte)(0) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "NameMonthView") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtSchedulerEvents_event_Namemonthview = oReader.getValue() ;
               gxTv_SdtSchedulerEvents_event_Namemonthview_N = (byte)(0) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "NameDayView") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtSchedulerEvents_event_Namedayview = oReader.getValue() ;
               gxTv_SdtSchedulerEvents_event_Namedayview_N = (byte)(0) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ToolTip") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtSchedulerEvents_event_Tooltip = oReader.getValue() ;
               gxTv_SdtSchedulerEvents_event_Tooltip_N = (byte)(0) ;
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
         sName = "SchedulerEvents.event" ;
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
      oWriter.writeElement("Id", GXutil.rtrim( gxTv_SdtSchedulerEvents_event_Id));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("Name", GXutil.rtrim( gxTv_SdtSchedulerEvents_event_Name));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("Notes", GXutil.rtrim( gxTv_SdtSchedulerEvents_event_Notes));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("Link", GXutil.rtrim( gxTv_SdtSchedulerEvents_event_Link));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      if ( GXutil.dateCompare(GXutil.nullDate(), gxTv_SdtSchedulerEvents_event_Starttime) && ( gxTv_SdtSchedulerEvents_event_Starttime_N == 1 ) )
      {
         oWriter.writeElement("StartTime", "");
         if ( GXutil.strcmp(sNameSpace, "") != 0 )
         {
            oWriter.writeAttribute("xmlns", "");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSchedulerEvents_event_Starttime), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSchedulerEvents_event_Starttime), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSchedulerEvents_event_Starttime), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtSchedulerEvents_event_Starttime), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtSchedulerEvents_event_Starttime), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtSchedulerEvents_event_Starttime), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("StartTime", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "") != 0 )
         {
            oWriter.writeAttribute("xmlns", "");
         }
      }
      if ( GXutil.dateCompare(GXutil.nullDate(), gxTv_SdtSchedulerEvents_event_Endtime) && ( gxTv_SdtSchedulerEvents_event_Endtime_N == 1 ) )
      {
         oWriter.writeElement("EndTime", "");
         if ( GXutil.strcmp(sNameSpace, "") != 0 )
         {
            oWriter.writeAttribute("xmlns", "");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSchedulerEvents_event_Endtime), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSchedulerEvents_event_Endtime), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSchedulerEvents_event_Endtime), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtSchedulerEvents_event_Endtime), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtSchedulerEvents_event_Endtime), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtSchedulerEvents_event_Endtime), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("EndTime", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "") != 0 )
         {
            oWriter.writeAttribute("xmlns", "");
         }
      }
      oWriter.writeElement("AdditionalInformation", GXutil.rtrim( gxTv_SdtSchedulerEvents_event_Additionalinformation));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      if ( ! (GXutil.strcmp("", gxTv_SdtSchedulerEvents_event_Color)==0) || ( gxTv_SdtSchedulerEvents_event_Color_N != 1 ) )
      {
         oWriter.writeElement("Color", GXutil.rtrim( gxTv_SdtSchedulerEvents_event_Color));
         if ( GXutil.strcmp(sNameSpace, "") != 0 )
         {
            oWriter.writeAttribute("xmlns", "");
         }
      }
      if ( ! (GXutil.strcmp("", gxTv_SdtSchedulerEvents_event_Backgroundcolor)==0) || ( gxTv_SdtSchedulerEvents_event_Backgroundcolor_N != 1 ) )
      {
         oWriter.writeElement("BackgroundColor", GXutil.rtrim( gxTv_SdtSchedulerEvents_event_Backgroundcolor));
         if ( GXutil.strcmp(sNameSpace, "") != 0 )
         {
            oWriter.writeAttribute("xmlns", "");
         }
      }
      if ( ! (GXutil.strcmp("", gxTv_SdtSchedulerEvents_event_Nameweekview)==0) || ( gxTv_SdtSchedulerEvents_event_Nameweekview_N != 1 ) )
      {
         oWriter.writeElement("NameWeekView", GXutil.rtrim( gxTv_SdtSchedulerEvents_event_Nameweekview));
         if ( GXutil.strcmp(sNameSpace, "") != 0 )
         {
            oWriter.writeAttribute("xmlns", "");
         }
      }
      if ( ! (GXutil.strcmp("", gxTv_SdtSchedulerEvents_event_Namemonthview)==0) || ( gxTv_SdtSchedulerEvents_event_Namemonthview_N != 1 ) )
      {
         oWriter.writeElement("NameMonthView", GXutil.rtrim( gxTv_SdtSchedulerEvents_event_Namemonthview));
         if ( GXutil.strcmp(sNameSpace, "") != 0 )
         {
            oWriter.writeAttribute("xmlns", "");
         }
      }
      if ( ! (GXutil.strcmp("", gxTv_SdtSchedulerEvents_event_Namedayview)==0) || ( gxTv_SdtSchedulerEvents_event_Namedayview_N != 1 ) )
      {
         oWriter.writeElement("NameDayView", GXutil.rtrim( gxTv_SdtSchedulerEvents_event_Namedayview));
         if ( GXutil.strcmp(sNameSpace, "") != 0 )
         {
            oWriter.writeAttribute("xmlns", "");
         }
      }
      if ( ! (GXutil.strcmp("", gxTv_SdtSchedulerEvents_event_Tooltip)==0) || ( gxTv_SdtSchedulerEvents_event_Tooltip_N != 1 ) )
      {
         oWriter.writeElement("ToolTip", GXutil.rtrim( gxTv_SdtSchedulerEvents_event_Tooltip));
         if ( GXutil.strcmp(sNameSpace, "") != 0 )
         {
            oWriter.writeAttribute("xmlns", "");
         }
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
      AddObjectProperty("Id", gxTv_SdtSchedulerEvents_event_Id, false, false);
      AddObjectProperty("Name", gxTv_SdtSchedulerEvents_event_Name, false, false);
      AddObjectProperty("Notes", gxTv_SdtSchedulerEvents_event_Notes, false, false);
      AddObjectProperty("Link", gxTv_SdtSchedulerEvents_event_Link, false, false);
      datetime_STZ = gxTv_SdtSchedulerEvents_event_Starttime ;
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
      AddObjectProperty("StartTime", sDateCnv, false, false);
      datetime_STZ = gxTv_SdtSchedulerEvents_event_Endtime ;
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
      AddObjectProperty("EndTime", sDateCnv, false, false);
      AddObjectProperty("AdditionalInformation", gxTv_SdtSchedulerEvents_event_Additionalinformation, false, false);
      AddObjectProperty("Color", gxTv_SdtSchedulerEvents_event_Color, false, false);
      AddObjectProperty("BackgroundColor", gxTv_SdtSchedulerEvents_event_Backgroundcolor, false, false);
      AddObjectProperty("NameWeekView", gxTv_SdtSchedulerEvents_event_Nameweekview, false, false);
      AddObjectProperty("NameMonthView", gxTv_SdtSchedulerEvents_event_Namemonthview, false, false);
      AddObjectProperty("NameDayView", gxTv_SdtSchedulerEvents_event_Namedayview, false, false);
      AddObjectProperty("ToolTip", gxTv_SdtSchedulerEvents_event_Tooltip, false, false);
   }

   public String getgxTv_SdtSchedulerEvents_event_Id( )
   {
      return gxTv_SdtSchedulerEvents_event_Id ;
   }

   public void setgxTv_SdtSchedulerEvents_event_Id( String value )
   {
      gxTv_SdtSchedulerEvents_event_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_event_Id = value ;
   }

   public String getgxTv_SdtSchedulerEvents_event_Name( )
   {
      return gxTv_SdtSchedulerEvents_event_Name ;
   }

   public void setgxTv_SdtSchedulerEvents_event_Name( String value )
   {
      gxTv_SdtSchedulerEvents_event_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_event_Name = value ;
   }

   public String getgxTv_SdtSchedulerEvents_event_Notes( )
   {
      return gxTv_SdtSchedulerEvents_event_Notes ;
   }

   public void setgxTv_SdtSchedulerEvents_event_Notes( String value )
   {
      gxTv_SdtSchedulerEvents_event_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_event_Notes = value ;
   }

   public String getgxTv_SdtSchedulerEvents_event_Link( )
   {
      return gxTv_SdtSchedulerEvents_event_Link ;
   }

   public void setgxTv_SdtSchedulerEvents_event_Link( String value )
   {
      gxTv_SdtSchedulerEvents_event_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_event_Link = value ;
   }

   public java.util.Date getgxTv_SdtSchedulerEvents_event_Starttime( )
   {
      return gxTv_SdtSchedulerEvents_event_Starttime ;
   }

   public void setgxTv_SdtSchedulerEvents_event_Starttime( java.util.Date value )
   {
      gxTv_SdtSchedulerEvents_event_Starttime_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_event_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_event_Starttime = value ;
   }

   public java.util.Date getgxTv_SdtSchedulerEvents_event_Endtime( )
   {
      return gxTv_SdtSchedulerEvents_event_Endtime ;
   }

   public void setgxTv_SdtSchedulerEvents_event_Endtime( java.util.Date value )
   {
      gxTv_SdtSchedulerEvents_event_Endtime_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_event_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_event_Endtime = value ;
   }

   public String getgxTv_SdtSchedulerEvents_event_Additionalinformation( )
   {
      return gxTv_SdtSchedulerEvents_event_Additionalinformation ;
   }

   public void setgxTv_SdtSchedulerEvents_event_Additionalinformation( String value )
   {
      gxTv_SdtSchedulerEvents_event_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_event_Additionalinformation = value ;
   }

   public String getgxTv_SdtSchedulerEvents_event_Color( )
   {
      return gxTv_SdtSchedulerEvents_event_Color ;
   }

   public void setgxTv_SdtSchedulerEvents_event_Color( String value )
   {
      gxTv_SdtSchedulerEvents_event_Color_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_event_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_event_Color = value ;
   }

   public String getgxTv_SdtSchedulerEvents_event_Backgroundcolor( )
   {
      return gxTv_SdtSchedulerEvents_event_Backgroundcolor ;
   }

   public void setgxTv_SdtSchedulerEvents_event_Backgroundcolor( String value )
   {
      gxTv_SdtSchedulerEvents_event_Backgroundcolor_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_event_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_event_Backgroundcolor = value ;
   }

   public String getgxTv_SdtSchedulerEvents_event_Nameweekview( )
   {
      return gxTv_SdtSchedulerEvents_event_Nameweekview ;
   }

   public void setgxTv_SdtSchedulerEvents_event_Nameweekview( String value )
   {
      gxTv_SdtSchedulerEvents_event_Nameweekview_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_event_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_event_Nameweekview = value ;
   }

   public String getgxTv_SdtSchedulerEvents_event_Namemonthview( )
   {
      return gxTv_SdtSchedulerEvents_event_Namemonthview ;
   }

   public void setgxTv_SdtSchedulerEvents_event_Namemonthview( String value )
   {
      gxTv_SdtSchedulerEvents_event_Namemonthview_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_event_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_event_Namemonthview = value ;
   }

   public String getgxTv_SdtSchedulerEvents_event_Namedayview( )
   {
      return gxTv_SdtSchedulerEvents_event_Namedayview ;
   }

   public void setgxTv_SdtSchedulerEvents_event_Namedayview( String value )
   {
      gxTv_SdtSchedulerEvents_event_Namedayview_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_event_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_event_Namedayview = value ;
   }

   public String getgxTv_SdtSchedulerEvents_event_Tooltip( )
   {
      return gxTv_SdtSchedulerEvents_event_Tooltip ;
   }

   public void setgxTv_SdtSchedulerEvents_event_Tooltip( String value )
   {
      gxTv_SdtSchedulerEvents_event_Tooltip_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_event_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_event_Tooltip = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSchedulerEvents_event_Id = "" ;
      gxTv_SdtSchedulerEvents_event_N = (byte)(1) ;
      gxTv_SdtSchedulerEvents_event_Name = "" ;
      gxTv_SdtSchedulerEvents_event_Notes = "" ;
      gxTv_SdtSchedulerEvents_event_Link = "" ;
      gxTv_SdtSchedulerEvents_event_Starttime = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtSchedulerEvents_event_Starttime_N = (byte)(1) ;
      gxTv_SdtSchedulerEvents_event_Endtime = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtSchedulerEvents_event_Endtime_N = (byte)(1) ;
      gxTv_SdtSchedulerEvents_event_Additionalinformation = "" ;
      gxTv_SdtSchedulerEvents_event_Color = "" ;
      gxTv_SdtSchedulerEvents_event_Color_N = (byte)(1) ;
      gxTv_SdtSchedulerEvents_event_Backgroundcolor = "" ;
      gxTv_SdtSchedulerEvents_event_Backgroundcolor_N = (byte)(1) ;
      gxTv_SdtSchedulerEvents_event_Nameweekview = "" ;
      gxTv_SdtSchedulerEvents_event_Nameweekview_N = (byte)(1) ;
      gxTv_SdtSchedulerEvents_event_Namemonthview = "" ;
      gxTv_SdtSchedulerEvents_event_Namemonthview_N = (byte)(1) ;
      gxTv_SdtSchedulerEvents_event_Namedayview = "" ;
      gxTv_SdtSchedulerEvents_event_Namedayview_N = (byte)(1) ;
      gxTv_SdtSchedulerEvents_event_Tooltip = "" ;
      gxTv_SdtSchedulerEvents_event_Tooltip_N = (byte)(1) ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
      datetime_STZ = GXutil.resetTime( GXutil.nullDate() );
   }

   public byte isNull( )
   {
      return gxTv_SdtSchedulerEvents_event_N ;
   }

   public com.projectthani.SdtSchedulerEvents_event Clone( )
   {
      return (com.projectthani.SdtSchedulerEvents_event)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSchedulerEvents_event struct )
   {
      setgxTv_SdtSchedulerEvents_event_Id(struct.getId());
      setgxTv_SdtSchedulerEvents_event_Name(struct.getName());
      setgxTv_SdtSchedulerEvents_event_Notes(struct.getNotes());
      setgxTv_SdtSchedulerEvents_event_Link(struct.getLink());
      if ( struct.gxTv_SdtSchedulerEvents_event_Starttime_N == 0 )
      {
         setgxTv_SdtSchedulerEvents_event_Starttime(struct.getStarttime());
      }
      if ( struct.gxTv_SdtSchedulerEvents_event_Endtime_N == 0 )
      {
         setgxTv_SdtSchedulerEvents_event_Endtime(struct.getEndtime());
      }
      setgxTv_SdtSchedulerEvents_event_Additionalinformation(struct.getAdditionalinformation());
      if ( struct.gxTv_SdtSchedulerEvents_event_Color_N == 0 )
      {
         setgxTv_SdtSchedulerEvents_event_Color(struct.getColor());
      }
      if ( struct.gxTv_SdtSchedulerEvents_event_Backgroundcolor_N == 0 )
      {
         setgxTv_SdtSchedulerEvents_event_Backgroundcolor(struct.getBackgroundcolor());
      }
      if ( struct.gxTv_SdtSchedulerEvents_event_Nameweekview_N == 0 )
      {
         setgxTv_SdtSchedulerEvents_event_Nameweekview(struct.getNameweekview());
      }
      if ( struct.gxTv_SdtSchedulerEvents_event_Namemonthview_N == 0 )
      {
         setgxTv_SdtSchedulerEvents_event_Namemonthview(struct.getNamemonthview());
      }
      if ( struct.gxTv_SdtSchedulerEvents_event_Namedayview_N == 0 )
      {
         setgxTv_SdtSchedulerEvents_event_Namedayview(struct.getNamedayview());
      }
      if ( struct.gxTv_SdtSchedulerEvents_event_Tooltip_N == 0 )
      {
         setgxTv_SdtSchedulerEvents_event_Tooltip(struct.getTooltip());
      }
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSchedulerEvents_event getStruct( )
   {
      com.projectthani.StructSdtSchedulerEvents_event struct = new com.projectthani.StructSdtSchedulerEvents_event ();
      struct.setId(getgxTv_SdtSchedulerEvents_event_Id());
      struct.setName(getgxTv_SdtSchedulerEvents_event_Name());
      struct.setNotes(getgxTv_SdtSchedulerEvents_event_Notes());
      struct.setLink(getgxTv_SdtSchedulerEvents_event_Link());
      if ( gxTv_SdtSchedulerEvents_event_Starttime_N == 0 )
      {
         struct.setStarttime(getgxTv_SdtSchedulerEvents_event_Starttime());
      }
      if ( gxTv_SdtSchedulerEvents_event_Endtime_N == 0 )
      {
         struct.setEndtime(getgxTv_SdtSchedulerEvents_event_Endtime());
      }
      struct.setAdditionalinformation(getgxTv_SdtSchedulerEvents_event_Additionalinformation());
      if ( gxTv_SdtSchedulerEvents_event_Color_N == 0 )
      {
         struct.setColor(getgxTv_SdtSchedulerEvents_event_Color());
      }
      if ( gxTv_SdtSchedulerEvents_event_Backgroundcolor_N == 0 )
      {
         struct.setBackgroundcolor(getgxTv_SdtSchedulerEvents_event_Backgroundcolor());
      }
      if ( gxTv_SdtSchedulerEvents_event_Nameweekview_N == 0 )
      {
         struct.setNameweekview(getgxTv_SdtSchedulerEvents_event_Nameweekview());
      }
      if ( gxTv_SdtSchedulerEvents_event_Namemonthview_N == 0 )
      {
         struct.setNamemonthview(getgxTv_SdtSchedulerEvents_event_Namemonthview());
      }
      if ( gxTv_SdtSchedulerEvents_event_Namedayview_N == 0 )
      {
         struct.setNamedayview(getgxTv_SdtSchedulerEvents_event_Namedayview());
      }
      if ( gxTv_SdtSchedulerEvents_event_Tooltip_N == 0 )
      {
         struct.setTooltip(getgxTv_SdtSchedulerEvents_event_Tooltip());
      }
      return struct ;
   }

   protected byte gxTv_SdtSchedulerEvents_event_N ;
   protected byte gxTv_SdtSchedulerEvents_event_Starttime_N ;
   protected byte gxTv_SdtSchedulerEvents_event_Endtime_N ;
   protected byte gxTv_SdtSchedulerEvents_event_Color_N ;
   protected byte gxTv_SdtSchedulerEvents_event_Backgroundcolor_N ;
   protected byte gxTv_SdtSchedulerEvents_event_Nameweekview_N ;
   protected byte gxTv_SdtSchedulerEvents_event_Namemonthview_N ;
   protected byte gxTv_SdtSchedulerEvents_event_Namedayview_N ;
   protected byte gxTv_SdtSchedulerEvents_event_Tooltip_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtSchedulerEvents_event_Id ;
   protected String gxTv_SdtSchedulerEvents_event_Name ;
   protected String gxTv_SdtSchedulerEvents_event_Notes ;
   protected String gxTv_SdtSchedulerEvents_event_Link ;
   protected String gxTv_SdtSchedulerEvents_event_Additionalinformation ;
   protected String gxTv_SdtSchedulerEvents_event_Color ;
   protected String gxTv_SdtSchedulerEvents_event_Backgroundcolor ;
   protected String gxTv_SdtSchedulerEvents_event_Nameweekview ;
   protected String gxTv_SdtSchedulerEvents_event_Namemonthview ;
   protected String gxTv_SdtSchedulerEvents_event_Namedayview ;
   protected String gxTv_SdtSchedulerEvents_event_Tooltip ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_SdtSchedulerEvents_event_Starttime ;
   protected java.util.Date gxTv_SdtSchedulerEvents_event_Endtime ;
   protected java.util.Date datetime_STZ ;
   protected boolean readElement ;
   protected boolean formatError ;
}

