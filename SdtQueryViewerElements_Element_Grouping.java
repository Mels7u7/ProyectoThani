package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtQueryViewerElements_Element_Grouping extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtQueryViewerElements_Element_Grouping( )
   {
      this(  new ModelContext(SdtQueryViewerElements_Element_Grouping.class));
   }

   public SdtQueryViewerElements_Element_Grouping( ModelContext context )
   {
      super( context, "SdtQueryViewerElements_Element_Grouping");
   }

   public SdtQueryViewerElements_Element_Grouping( int remoteHandle ,
                                                   ModelContext context )
   {
      super( remoteHandle, context, "SdtQueryViewerElements_Element_Grouping");
   }

   public SdtQueryViewerElements_Element_Grouping( StructSdtQueryViewerElements_Element_Grouping struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "GroupByYear") )
            {
               gxTv_SdtQueryViewerElements_Element_Grouping_Groupbyyear = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "YearTitle") )
            {
               gxTv_SdtQueryViewerElements_Element_Grouping_Yeartitle = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "GroupBySemester") )
            {
               gxTv_SdtQueryViewerElements_Element_Grouping_Groupbysemester = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SemesterTitle") )
            {
               gxTv_SdtQueryViewerElements_Element_Grouping_Semestertitle = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "GroupByQuarter") )
            {
               gxTv_SdtQueryViewerElements_Element_Grouping_Groupbyquarter = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "QuarterTitle") )
            {
               gxTv_SdtQueryViewerElements_Element_Grouping_Quartertitle = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "GroupByMonth") )
            {
               gxTv_SdtQueryViewerElements_Element_Grouping_Groupbymonth = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MonthTitle") )
            {
               gxTv_SdtQueryViewerElements_Element_Grouping_Monthtitle = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "GroupByDayOfWeek") )
            {
               gxTv_SdtQueryViewerElements_Element_Grouping_Groupbydayofweek = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DayOfWeekTitle") )
            {
               gxTv_SdtQueryViewerElements_Element_Grouping_Dayofweektitle = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "HideValue") )
            {
               gxTv_SdtQueryViewerElements_Element_Grouping_Hidevalue = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
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
         sName = "QueryViewerElements.Element.Grouping" ;
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
      oWriter.writeElement("GroupByYear", GXutil.rtrim( GXutil.booltostr( gxTv_SdtQueryViewerElements_Element_Grouping_Groupbyyear)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("YearTitle", GXutil.rtrim( gxTv_SdtQueryViewerElements_Element_Grouping_Yeartitle));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("GroupBySemester", GXutil.rtrim( GXutil.booltostr( gxTv_SdtQueryViewerElements_Element_Grouping_Groupbysemester)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SemesterTitle", GXutil.rtrim( gxTv_SdtQueryViewerElements_Element_Grouping_Semestertitle));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("GroupByQuarter", GXutil.rtrim( GXutil.booltostr( gxTv_SdtQueryViewerElements_Element_Grouping_Groupbyquarter)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("QuarterTitle", GXutil.rtrim( gxTv_SdtQueryViewerElements_Element_Grouping_Quartertitle));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("GroupByMonth", GXutil.rtrim( GXutil.booltostr( gxTv_SdtQueryViewerElements_Element_Grouping_Groupbymonth)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("MonthTitle", GXutil.rtrim( gxTv_SdtQueryViewerElements_Element_Grouping_Monthtitle));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("GroupByDayOfWeek", GXutil.rtrim( GXutil.booltostr( gxTv_SdtQueryViewerElements_Element_Grouping_Groupbydayofweek)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("DayOfWeekTitle", GXutil.rtrim( gxTv_SdtQueryViewerElements_Element_Grouping_Dayofweektitle));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("HideValue", GXutil.rtrim( GXutil.booltostr( gxTv_SdtQueryViewerElements_Element_Grouping_Hidevalue)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
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
      AddObjectProperty("GroupByYear", gxTv_SdtQueryViewerElements_Element_Grouping_Groupbyyear, false, false);
      AddObjectProperty("YearTitle", gxTv_SdtQueryViewerElements_Element_Grouping_Yeartitle, false, false);
      AddObjectProperty("GroupBySemester", gxTv_SdtQueryViewerElements_Element_Grouping_Groupbysemester, false, false);
      AddObjectProperty("SemesterTitle", gxTv_SdtQueryViewerElements_Element_Grouping_Semestertitle, false, false);
      AddObjectProperty("GroupByQuarter", gxTv_SdtQueryViewerElements_Element_Grouping_Groupbyquarter, false, false);
      AddObjectProperty("QuarterTitle", gxTv_SdtQueryViewerElements_Element_Grouping_Quartertitle, false, false);
      AddObjectProperty("GroupByMonth", gxTv_SdtQueryViewerElements_Element_Grouping_Groupbymonth, false, false);
      AddObjectProperty("MonthTitle", gxTv_SdtQueryViewerElements_Element_Grouping_Monthtitle, false, false);
      AddObjectProperty("GroupByDayOfWeek", gxTv_SdtQueryViewerElements_Element_Grouping_Groupbydayofweek, false, false);
      AddObjectProperty("DayOfWeekTitle", gxTv_SdtQueryViewerElements_Element_Grouping_Dayofweektitle, false, false);
      AddObjectProperty("HideValue", gxTv_SdtQueryViewerElements_Element_Grouping_Hidevalue, false, false);
   }

   public boolean getgxTv_SdtQueryViewerElements_Element_Grouping_Groupbyyear( )
   {
      return gxTv_SdtQueryViewerElements_Element_Grouping_Groupbyyear ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Grouping_Groupbyyear( boolean value )
   {
      gxTv_SdtQueryViewerElements_Element_Grouping_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Grouping_Groupbyyear = value ;
   }

   public String getgxTv_SdtQueryViewerElements_Element_Grouping_Yeartitle( )
   {
      return gxTv_SdtQueryViewerElements_Element_Grouping_Yeartitle ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Grouping_Yeartitle( String value )
   {
      gxTv_SdtQueryViewerElements_Element_Grouping_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Grouping_Yeartitle = value ;
   }

   public boolean getgxTv_SdtQueryViewerElements_Element_Grouping_Groupbysemester( )
   {
      return gxTv_SdtQueryViewerElements_Element_Grouping_Groupbysemester ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Grouping_Groupbysemester( boolean value )
   {
      gxTv_SdtQueryViewerElements_Element_Grouping_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Grouping_Groupbysemester = value ;
   }

   public String getgxTv_SdtQueryViewerElements_Element_Grouping_Semestertitle( )
   {
      return gxTv_SdtQueryViewerElements_Element_Grouping_Semestertitle ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Grouping_Semestertitle( String value )
   {
      gxTv_SdtQueryViewerElements_Element_Grouping_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Grouping_Semestertitle = value ;
   }

   public boolean getgxTv_SdtQueryViewerElements_Element_Grouping_Groupbyquarter( )
   {
      return gxTv_SdtQueryViewerElements_Element_Grouping_Groupbyquarter ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Grouping_Groupbyquarter( boolean value )
   {
      gxTv_SdtQueryViewerElements_Element_Grouping_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Grouping_Groupbyquarter = value ;
   }

   public String getgxTv_SdtQueryViewerElements_Element_Grouping_Quartertitle( )
   {
      return gxTv_SdtQueryViewerElements_Element_Grouping_Quartertitle ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Grouping_Quartertitle( String value )
   {
      gxTv_SdtQueryViewerElements_Element_Grouping_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Grouping_Quartertitle = value ;
   }

   public boolean getgxTv_SdtQueryViewerElements_Element_Grouping_Groupbymonth( )
   {
      return gxTv_SdtQueryViewerElements_Element_Grouping_Groupbymonth ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Grouping_Groupbymonth( boolean value )
   {
      gxTv_SdtQueryViewerElements_Element_Grouping_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Grouping_Groupbymonth = value ;
   }

   public String getgxTv_SdtQueryViewerElements_Element_Grouping_Monthtitle( )
   {
      return gxTv_SdtQueryViewerElements_Element_Grouping_Monthtitle ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Grouping_Monthtitle( String value )
   {
      gxTv_SdtQueryViewerElements_Element_Grouping_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Grouping_Monthtitle = value ;
   }

   public boolean getgxTv_SdtQueryViewerElements_Element_Grouping_Groupbydayofweek( )
   {
      return gxTv_SdtQueryViewerElements_Element_Grouping_Groupbydayofweek ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Grouping_Groupbydayofweek( boolean value )
   {
      gxTv_SdtQueryViewerElements_Element_Grouping_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Grouping_Groupbydayofweek = value ;
   }

   public String getgxTv_SdtQueryViewerElements_Element_Grouping_Dayofweektitle( )
   {
      return gxTv_SdtQueryViewerElements_Element_Grouping_Dayofweektitle ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Grouping_Dayofweektitle( String value )
   {
      gxTv_SdtQueryViewerElements_Element_Grouping_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Grouping_Dayofweektitle = value ;
   }

   public boolean getgxTv_SdtQueryViewerElements_Element_Grouping_Hidevalue( )
   {
      return gxTv_SdtQueryViewerElements_Element_Grouping_Hidevalue ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Grouping_Hidevalue( boolean value )
   {
      gxTv_SdtQueryViewerElements_Element_Grouping_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Grouping_Hidevalue = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtQueryViewerElements_Element_Grouping_N = (byte)(1) ;
      gxTv_SdtQueryViewerElements_Element_Grouping_Yeartitle = "" ;
      gxTv_SdtQueryViewerElements_Element_Grouping_Semestertitle = "" ;
      gxTv_SdtQueryViewerElements_Element_Grouping_Quartertitle = "" ;
      gxTv_SdtQueryViewerElements_Element_Grouping_Monthtitle = "" ;
      gxTv_SdtQueryViewerElements_Element_Grouping_Dayofweektitle = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtQueryViewerElements_Element_Grouping_N ;
   }

   public com.projectthani.SdtQueryViewerElements_Element_Grouping Clone( )
   {
      return (com.projectthani.SdtQueryViewerElements_Element_Grouping)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtQueryViewerElements_Element_Grouping struct )
   {
      setgxTv_SdtQueryViewerElements_Element_Grouping_Groupbyyear(struct.getGroupbyyear());
      setgxTv_SdtQueryViewerElements_Element_Grouping_Yeartitle(struct.getYeartitle());
      setgxTv_SdtQueryViewerElements_Element_Grouping_Groupbysemester(struct.getGroupbysemester());
      setgxTv_SdtQueryViewerElements_Element_Grouping_Semestertitle(struct.getSemestertitle());
      setgxTv_SdtQueryViewerElements_Element_Grouping_Groupbyquarter(struct.getGroupbyquarter());
      setgxTv_SdtQueryViewerElements_Element_Grouping_Quartertitle(struct.getQuartertitle());
      setgxTv_SdtQueryViewerElements_Element_Grouping_Groupbymonth(struct.getGroupbymonth());
      setgxTv_SdtQueryViewerElements_Element_Grouping_Monthtitle(struct.getMonthtitle());
      setgxTv_SdtQueryViewerElements_Element_Grouping_Groupbydayofweek(struct.getGroupbydayofweek());
      setgxTv_SdtQueryViewerElements_Element_Grouping_Dayofweektitle(struct.getDayofweektitle());
      setgxTv_SdtQueryViewerElements_Element_Grouping_Hidevalue(struct.getHidevalue());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtQueryViewerElements_Element_Grouping getStruct( )
   {
      com.projectthani.StructSdtQueryViewerElements_Element_Grouping struct = new com.projectthani.StructSdtQueryViewerElements_Element_Grouping ();
      struct.setGroupbyyear(getgxTv_SdtQueryViewerElements_Element_Grouping_Groupbyyear());
      struct.setYeartitle(getgxTv_SdtQueryViewerElements_Element_Grouping_Yeartitle());
      struct.setGroupbysemester(getgxTv_SdtQueryViewerElements_Element_Grouping_Groupbysemester());
      struct.setSemestertitle(getgxTv_SdtQueryViewerElements_Element_Grouping_Semestertitle());
      struct.setGroupbyquarter(getgxTv_SdtQueryViewerElements_Element_Grouping_Groupbyquarter());
      struct.setQuartertitle(getgxTv_SdtQueryViewerElements_Element_Grouping_Quartertitle());
      struct.setGroupbymonth(getgxTv_SdtQueryViewerElements_Element_Grouping_Groupbymonth());
      struct.setMonthtitle(getgxTv_SdtQueryViewerElements_Element_Grouping_Monthtitle());
      struct.setGroupbydayofweek(getgxTv_SdtQueryViewerElements_Element_Grouping_Groupbydayofweek());
      struct.setDayofweektitle(getgxTv_SdtQueryViewerElements_Element_Grouping_Dayofweektitle());
      struct.setHidevalue(getgxTv_SdtQueryViewerElements_Element_Grouping_Hidevalue());
      return struct ;
   }

   protected byte gxTv_SdtQueryViewerElements_Element_Grouping_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtQueryViewerElements_Element_Grouping_Yeartitle ;
   protected String gxTv_SdtQueryViewerElements_Element_Grouping_Semestertitle ;
   protected String gxTv_SdtQueryViewerElements_Element_Grouping_Quartertitle ;
   protected String gxTv_SdtQueryViewerElements_Element_Grouping_Monthtitle ;
   protected String gxTv_SdtQueryViewerElements_Element_Grouping_Dayofweektitle ;
   protected String sTagName ;
   protected boolean gxTv_SdtQueryViewerElements_Element_Grouping_Groupbyyear ;
   protected boolean gxTv_SdtQueryViewerElements_Element_Grouping_Groupbysemester ;
   protected boolean gxTv_SdtQueryViewerElements_Element_Grouping_Groupbyquarter ;
   protected boolean gxTv_SdtQueryViewerElements_Element_Grouping_Groupbymonth ;
   protected boolean gxTv_SdtQueryViewerElements_Element_Grouping_Groupbydayofweek ;
   protected boolean gxTv_SdtQueryViewerElements_Element_Grouping_Hidevalue ;
   protected boolean readElement ;
   protected boolean formatError ;
}

