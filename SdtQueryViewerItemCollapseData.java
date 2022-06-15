package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtQueryViewerItemCollapseData extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtQueryViewerItemCollapseData( )
   {
      this(  new ModelContext(SdtQueryViewerItemCollapseData.class));
   }

   public SdtQueryViewerItemCollapseData( ModelContext context )
   {
      super( context, "SdtQueryViewerItemCollapseData");
   }

   public SdtQueryViewerItemCollapseData( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle, context, "SdtQueryViewerItemCollapseData");
   }

   public SdtQueryViewerItemCollapseData( StructSdtQueryViewerItemCollapseData struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Name") )
            {
               gxTv_SdtQueryViewerItemCollapseData_Name = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Value") )
            {
               gxTv_SdtQueryViewerItemCollapseData_Value = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ExpandedValues") )
            {
               if ( gxTv_SdtQueryViewerItemCollapseData_Expandedvalues == null )
               {
                  gxTv_SdtQueryViewerItemCollapseData_Expandedvalues = new GXSimpleCollection<String>(String.class, "internal", "");
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_SdtQueryViewerItemCollapseData_Expandedvalues.readxmlcollection(oReader, "ExpandedValues", "Item") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "ExpandedValues") )
               {
                  GXSoapError = oReader.read() ;
               }
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
         sName = "QueryViewerItemCollapseData" ;
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
      oWriter.writeElement("Name", GXutil.rtrim( gxTv_SdtQueryViewerItemCollapseData_Name));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Value", GXutil.rtrim( gxTv_SdtQueryViewerItemCollapseData_Value));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( gxTv_SdtQueryViewerItemCollapseData_Expandedvalues != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "ProjectThani" ;
         }
         else
         {
            sNameSpace1 = "ProjectThani" ;
         }
         gxTv_SdtQueryViewerItemCollapseData_Expandedvalues.writexmlcollection(oWriter, "ExpandedValues", sNameSpace1, "Item", sNameSpace1);
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
      AddObjectProperty("Name", gxTv_SdtQueryViewerItemCollapseData_Name, false, false);
      AddObjectProperty("Value", gxTv_SdtQueryViewerItemCollapseData_Value, false, false);
      if ( gxTv_SdtQueryViewerItemCollapseData_Expandedvalues != null )
      {
         AddObjectProperty("ExpandedValues", gxTv_SdtQueryViewerItemCollapseData_Expandedvalues, false, false);
      }
   }

   public String getgxTv_SdtQueryViewerItemCollapseData_Name( )
   {
      return gxTv_SdtQueryViewerItemCollapseData_Name ;
   }

   public void setgxTv_SdtQueryViewerItemCollapseData_Name( String value )
   {
      gxTv_SdtQueryViewerItemCollapseData_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemCollapseData_Name = value ;
   }

   public String getgxTv_SdtQueryViewerItemCollapseData_Value( )
   {
      return gxTv_SdtQueryViewerItemCollapseData_Value ;
   }

   public void setgxTv_SdtQueryViewerItemCollapseData_Value( String value )
   {
      gxTv_SdtQueryViewerItemCollapseData_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemCollapseData_Value = value ;
   }

   public GXSimpleCollection<String> getgxTv_SdtQueryViewerItemCollapseData_Expandedvalues( )
   {
      if ( gxTv_SdtQueryViewerItemCollapseData_Expandedvalues == null )
      {
         gxTv_SdtQueryViewerItemCollapseData_Expandedvalues = new GXSimpleCollection<String>(String.class, "internal", "");
      }
      gxTv_SdtQueryViewerItemCollapseData_Expandedvalues_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemCollapseData_N = (byte)(0) ;
      return gxTv_SdtQueryViewerItemCollapseData_Expandedvalues ;
   }

   public void setgxTv_SdtQueryViewerItemCollapseData_Expandedvalues( GXSimpleCollection<String> value )
   {
      gxTv_SdtQueryViewerItemCollapseData_Expandedvalues_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemCollapseData_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemCollapseData_Expandedvalues = value ;
   }

   public void setgxTv_SdtQueryViewerItemCollapseData_Expandedvalues_SetNull( )
   {
      gxTv_SdtQueryViewerItemCollapseData_Expandedvalues_N = (byte)(1) ;
      gxTv_SdtQueryViewerItemCollapseData_Expandedvalues = null ;
   }

   public boolean getgxTv_SdtQueryViewerItemCollapseData_Expandedvalues_IsNull( )
   {
      if ( gxTv_SdtQueryViewerItemCollapseData_Expandedvalues == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtQueryViewerItemCollapseData_Expandedvalues_N( )
   {
      return gxTv_SdtQueryViewerItemCollapseData_Expandedvalues_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtQueryViewerItemCollapseData_Name = "" ;
      gxTv_SdtQueryViewerItemCollapseData_N = (byte)(1) ;
      gxTv_SdtQueryViewerItemCollapseData_Value = "" ;
      gxTv_SdtQueryViewerItemCollapseData_Expandedvalues_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtQueryViewerItemCollapseData_N ;
   }

   public com.projectthani.SdtQueryViewerItemCollapseData Clone( )
   {
      return (com.projectthani.SdtQueryViewerItemCollapseData)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtQueryViewerItemCollapseData struct )
   {
      setgxTv_SdtQueryViewerItemCollapseData_Name(struct.getName());
      setgxTv_SdtQueryViewerItemCollapseData_Value(struct.getValue());
      setgxTv_SdtQueryViewerItemCollapseData_Expandedvalues(new GXSimpleCollection<String>(String.class, "internal", "", struct.getExpandedvalues()));
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtQueryViewerItemCollapseData getStruct( )
   {
      com.projectthani.StructSdtQueryViewerItemCollapseData struct = new com.projectthani.StructSdtQueryViewerItemCollapseData ();
      struct.setName(getgxTv_SdtQueryViewerItemCollapseData_Name());
      struct.setValue(getgxTv_SdtQueryViewerItemCollapseData_Value());
      struct.setExpandedvalues(getgxTv_SdtQueryViewerItemCollapseData_Expandedvalues().getStruct());
      return struct ;
   }

   protected byte gxTv_SdtQueryViewerItemCollapseData_N ;
   protected byte gxTv_SdtQueryViewerItemCollapseData_Expandedvalues_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtQueryViewerItemCollapseData_Name ;
   protected String gxTv_SdtQueryViewerItemCollapseData_Value ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected GXSimpleCollection<String> gxTv_SdtQueryViewerItemCollapseData_Expandedvalues=null ;
}

