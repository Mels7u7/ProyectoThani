package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtQueryViewerItemExpandData extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtQueryViewerItemExpandData( )
   {
      this(  new ModelContext(SdtQueryViewerItemExpandData.class));
   }

   public SdtQueryViewerItemExpandData( ModelContext context )
   {
      super( context, "SdtQueryViewerItemExpandData");
   }

   public SdtQueryViewerItemExpandData( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle, context, "SdtQueryViewerItemExpandData");
   }

   public SdtQueryViewerItemExpandData( StructSdtQueryViewerItemExpandData struct )
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
               gxTv_SdtQueryViewerItemExpandData_Name = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Value") )
            {
               gxTv_SdtQueryViewerItemExpandData_Value = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ExpandedValues") )
            {
               if ( gxTv_SdtQueryViewerItemExpandData_Expandedvalues == null )
               {
                  gxTv_SdtQueryViewerItemExpandData_Expandedvalues = new GXSimpleCollection<String>(String.class, "internal", "");
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_SdtQueryViewerItemExpandData_Expandedvalues.readxmlcollection(oReader, "ExpandedValues", "Item") ;
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
         sName = "QueryViewerItemExpandData" ;
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
      oWriter.writeElement("Name", GXutil.rtrim( gxTv_SdtQueryViewerItemExpandData_Name));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Value", GXutil.rtrim( gxTv_SdtQueryViewerItemExpandData_Value));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( gxTv_SdtQueryViewerItemExpandData_Expandedvalues != null )
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
         gxTv_SdtQueryViewerItemExpandData_Expandedvalues.writexmlcollection(oWriter, "ExpandedValues", sNameSpace1, "Item", sNameSpace1);
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
      AddObjectProperty("Name", gxTv_SdtQueryViewerItemExpandData_Name, false, false);
      AddObjectProperty("Value", gxTv_SdtQueryViewerItemExpandData_Value, false, false);
      if ( gxTv_SdtQueryViewerItemExpandData_Expandedvalues != null )
      {
         AddObjectProperty("ExpandedValues", gxTv_SdtQueryViewerItemExpandData_Expandedvalues, false, false);
      }
   }

   public String getgxTv_SdtQueryViewerItemExpandData_Name( )
   {
      return gxTv_SdtQueryViewerItemExpandData_Name ;
   }

   public void setgxTv_SdtQueryViewerItemExpandData_Name( String value )
   {
      gxTv_SdtQueryViewerItemExpandData_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemExpandData_Name = value ;
   }

   public String getgxTv_SdtQueryViewerItemExpandData_Value( )
   {
      return gxTv_SdtQueryViewerItemExpandData_Value ;
   }

   public void setgxTv_SdtQueryViewerItemExpandData_Value( String value )
   {
      gxTv_SdtQueryViewerItemExpandData_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemExpandData_Value = value ;
   }

   public GXSimpleCollection<String> getgxTv_SdtQueryViewerItemExpandData_Expandedvalues( )
   {
      if ( gxTv_SdtQueryViewerItemExpandData_Expandedvalues == null )
      {
         gxTv_SdtQueryViewerItemExpandData_Expandedvalues = new GXSimpleCollection<String>(String.class, "internal", "");
      }
      gxTv_SdtQueryViewerItemExpandData_Expandedvalues_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemExpandData_N = (byte)(0) ;
      return gxTv_SdtQueryViewerItemExpandData_Expandedvalues ;
   }

   public void setgxTv_SdtQueryViewerItemExpandData_Expandedvalues( GXSimpleCollection<String> value )
   {
      gxTv_SdtQueryViewerItemExpandData_Expandedvalues_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemExpandData_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemExpandData_Expandedvalues = value ;
   }

   public void setgxTv_SdtQueryViewerItemExpandData_Expandedvalues_SetNull( )
   {
      gxTv_SdtQueryViewerItemExpandData_Expandedvalues_N = (byte)(1) ;
      gxTv_SdtQueryViewerItemExpandData_Expandedvalues = null ;
   }

   public boolean getgxTv_SdtQueryViewerItemExpandData_Expandedvalues_IsNull( )
   {
      if ( gxTv_SdtQueryViewerItemExpandData_Expandedvalues == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtQueryViewerItemExpandData_Expandedvalues_N( )
   {
      return gxTv_SdtQueryViewerItemExpandData_Expandedvalues_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtQueryViewerItemExpandData_Name = "" ;
      gxTv_SdtQueryViewerItemExpandData_N = (byte)(1) ;
      gxTv_SdtQueryViewerItemExpandData_Value = "" ;
      gxTv_SdtQueryViewerItemExpandData_Expandedvalues_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtQueryViewerItemExpandData_N ;
   }

   public com.projectthani.SdtQueryViewerItemExpandData Clone( )
   {
      return (com.projectthani.SdtQueryViewerItemExpandData)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtQueryViewerItemExpandData struct )
   {
      setgxTv_SdtQueryViewerItemExpandData_Name(struct.getName());
      setgxTv_SdtQueryViewerItemExpandData_Value(struct.getValue());
      setgxTv_SdtQueryViewerItemExpandData_Expandedvalues(new GXSimpleCollection<String>(String.class, "internal", "", struct.getExpandedvalues()));
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtQueryViewerItemExpandData getStruct( )
   {
      com.projectthani.StructSdtQueryViewerItemExpandData struct = new com.projectthani.StructSdtQueryViewerItemExpandData ();
      struct.setName(getgxTv_SdtQueryViewerItemExpandData_Name());
      struct.setValue(getgxTv_SdtQueryViewerItemExpandData_Value());
      struct.setExpandedvalues(getgxTv_SdtQueryViewerItemExpandData_Expandedvalues().getStruct());
      return struct ;
   }

   protected byte gxTv_SdtQueryViewerItemExpandData_N ;
   protected byte gxTv_SdtQueryViewerItemExpandData_Expandedvalues_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtQueryViewerItemExpandData_Name ;
   protected String gxTv_SdtQueryViewerItemExpandData_Value ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected GXSimpleCollection<String> gxTv_SdtQueryViewerItemExpandData_Expandedvalues=null ;
}

