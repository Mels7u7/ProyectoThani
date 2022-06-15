package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtQueryViewerElements_Element_Analytics extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtQueryViewerElements_Element_Analytics( )
   {
      this(  new ModelContext(SdtQueryViewerElements_Element_Analytics.class));
   }

   public SdtQueryViewerElements_Element_Analytics( ModelContext context )
   {
      super( context, "SdtQueryViewerElements_Element_Analytics");
   }

   public SdtQueryViewerElements_Element_Analytics( int remoteHandle ,
                                                    ModelContext context )
   {
      super( remoteHandle, context, "SdtQueryViewerElements_Element_Analytics");
   }

   public SdtQueryViewerElements_Element_Analytics( StructSdtQueryViewerElements_Element_Analytics struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ShowValuesAs") )
            {
               gxTv_SdtQueryViewerElements_Element_Analytics_Showvaluesas = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RollingAverageType") )
            {
               gxTv_SdtQueryViewerElements_Element_Analytics_Rollingaveragetype = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RollingAverageTerms") )
            {
               gxTv_SdtQueryViewerElements_Element_Analytics_Rollingaverageterms = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DifferenceFrom") )
            {
               gxTv_SdtQueryViewerElements_Element_Analytics_Differencefrom = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ShowAsPercentage") )
            {
               gxTv_SdtQueryViewerElements_Element_Analytics_Showaspercentage = oReader.getValue() ;
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
         sName = "QueryViewerElements.Element.Analytics" ;
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
      oWriter.writeElement("ShowValuesAs", GXutil.rtrim( gxTv_SdtQueryViewerElements_Element_Analytics_Showvaluesas));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("RollingAverageType", GXutil.rtrim( gxTv_SdtQueryViewerElements_Element_Analytics_Rollingaveragetype));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("RollingAverageTerms", GXutil.trim( GXutil.str( gxTv_SdtQueryViewerElements_Element_Analytics_Rollingaverageterms, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("DifferenceFrom", GXutil.rtrim( gxTv_SdtQueryViewerElements_Element_Analytics_Differencefrom));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ShowAsPercentage", GXutil.rtrim( gxTv_SdtQueryViewerElements_Element_Analytics_Showaspercentage));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
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
      AddObjectProperty("ShowValuesAs", gxTv_SdtQueryViewerElements_Element_Analytics_Showvaluesas, false, false);
      AddObjectProperty("RollingAverageType", gxTv_SdtQueryViewerElements_Element_Analytics_Rollingaveragetype, false, false);
      AddObjectProperty("RollingAverageTerms", gxTv_SdtQueryViewerElements_Element_Analytics_Rollingaverageterms, false, false);
      AddObjectProperty("DifferenceFrom", gxTv_SdtQueryViewerElements_Element_Analytics_Differencefrom, false, false);
      AddObjectProperty("ShowAsPercentage", gxTv_SdtQueryViewerElements_Element_Analytics_Showaspercentage, false, false);
   }

   public String getgxTv_SdtQueryViewerElements_Element_Analytics_Showvaluesas( )
   {
      return gxTv_SdtQueryViewerElements_Element_Analytics_Showvaluesas ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Analytics_Showvaluesas( String value )
   {
      gxTv_SdtQueryViewerElements_Element_Analytics_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Analytics_Showvaluesas = value ;
   }

   public String getgxTv_SdtQueryViewerElements_Element_Analytics_Rollingaveragetype( )
   {
      return gxTv_SdtQueryViewerElements_Element_Analytics_Rollingaveragetype ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Analytics_Rollingaveragetype( String value )
   {
      gxTv_SdtQueryViewerElements_Element_Analytics_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Analytics_Rollingaveragetype = value ;
   }

   public short getgxTv_SdtQueryViewerElements_Element_Analytics_Rollingaverageterms( )
   {
      return gxTv_SdtQueryViewerElements_Element_Analytics_Rollingaverageterms ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Analytics_Rollingaverageterms( short value )
   {
      gxTv_SdtQueryViewerElements_Element_Analytics_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Analytics_Rollingaverageterms = value ;
   }

   public String getgxTv_SdtQueryViewerElements_Element_Analytics_Differencefrom( )
   {
      return gxTv_SdtQueryViewerElements_Element_Analytics_Differencefrom ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Analytics_Differencefrom( String value )
   {
      gxTv_SdtQueryViewerElements_Element_Analytics_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Analytics_Differencefrom = value ;
   }

   public String getgxTv_SdtQueryViewerElements_Element_Analytics_Showaspercentage( )
   {
      return gxTv_SdtQueryViewerElements_Element_Analytics_Showaspercentage ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Analytics_Showaspercentage( String value )
   {
      gxTv_SdtQueryViewerElements_Element_Analytics_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Analytics_Showaspercentage = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtQueryViewerElements_Element_Analytics_Showvaluesas = "NoCalculation" ;
      gxTv_SdtQueryViewerElements_Element_Analytics_N = (byte)(1) ;
      gxTv_SdtQueryViewerElements_Element_Analytics_Rollingaveragetype = "Simple" ;
      gxTv_SdtQueryViewerElements_Element_Analytics_Differencefrom = "PreviousValue" ;
      gxTv_SdtQueryViewerElements_Element_Analytics_Showaspercentage = "No" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtQueryViewerElements_Element_Analytics_N ;
   }

   public com.projectthani.SdtQueryViewerElements_Element_Analytics Clone( )
   {
      return (com.projectthani.SdtQueryViewerElements_Element_Analytics)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtQueryViewerElements_Element_Analytics struct )
   {
      setgxTv_SdtQueryViewerElements_Element_Analytics_Showvaluesas(struct.getShowvaluesas());
      setgxTv_SdtQueryViewerElements_Element_Analytics_Rollingaveragetype(struct.getRollingaveragetype());
      setgxTv_SdtQueryViewerElements_Element_Analytics_Rollingaverageterms(struct.getRollingaverageterms());
      setgxTv_SdtQueryViewerElements_Element_Analytics_Differencefrom(struct.getDifferencefrom());
      setgxTv_SdtQueryViewerElements_Element_Analytics_Showaspercentage(struct.getShowaspercentage());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtQueryViewerElements_Element_Analytics getStruct( )
   {
      com.projectthani.StructSdtQueryViewerElements_Element_Analytics struct = new com.projectthani.StructSdtQueryViewerElements_Element_Analytics ();
      struct.setShowvaluesas(getgxTv_SdtQueryViewerElements_Element_Analytics_Showvaluesas());
      struct.setRollingaveragetype(getgxTv_SdtQueryViewerElements_Element_Analytics_Rollingaveragetype());
      struct.setRollingaverageterms(getgxTv_SdtQueryViewerElements_Element_Analytics_Rollingaverageterms());
      struct.setDifferencefrom(getgxTv_SdtQueryViewerElements_Element_Analytics_Differencefrom());
      struct.setShowaspercentage(getgxTv_SdtQueryViewerElements_Element_Analytics_Showaspercentage());
      return struct ;
   }

   protected byte gxTv_SdtQueryViewerElements_Element_Analytics_N ;
   protected short gxTv_SdtQueryViewerElements_Element_Analytics_Rollingaverageterms ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtQueryViewerElements_Element_Analytics_Showvaluesas ;
   protected String gxTv_SdtQueryViewerElements_Element_Analytics_Rollingaveragetype ;
   protected String gxTv_SdtQueryViewerElements_Element_Analytics_Differencefrom ;
   protected String gxTv_SdtQueryViewerElements_Element_Analytics_Showaspercentage ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

