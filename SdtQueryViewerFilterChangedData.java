package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtQueryViewerFilterChangedData extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtQueryViewerFilterChangedData( )
   {
      this(  new ModelContext(SdtQueryViewerFilterChangedData.class));
   }

   public SdtQueryViewerFilterChangedData( ModelContext context )
   {
      super( context, "SdtQueryViewerFilterChangedData");
   }

   public SdtQueryViewerFilterChangedData( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle, context, "SdtQueryViewerFilterChangedData");
   }

   public SdtQueryViewerFilterChangedData( StructSdtQueryViewerFilterChangedData struct )
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
               gxTv_SdtQueryViewerFilterChangedData_Name = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SelectedValues") )
            {
               if ( gxTv_SdtQueryViewerFilterChangedData_Selectedvalues == null )
               {
                  gxTv_SdtQueryViewerFilterChangedData_Selectedvalues = new GXSimpleCollection<String>(String.class, "internal", "");
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_SdtQueryViewerFilterChangedData_Selectedvalues.readxmlcollection(oReader, "SelectedValues", "Item") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "SelectedValues") )
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
         sName = "QueryViewerFilterChangedData" ;
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
      oWriter.writeElement("Name", GXutil.rtrim( gxTv_SdtQueryViewerFilterChangedData_Name));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( gxTv_SdtQueryViewerFilterChangedData_Selectedvalues != null )
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
         gxTv_SdtQueryViewerFilterChangedData_Selectedvalues.writexmlcollection(oWriter, "SelectedValues", sNameSpace1, "Item", sNameSpace1);
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
      AddObjectProperty("Name", gxTv_SdtQueryViewerFilterChangedData_Name, false, false);
      if ( gxTv_SdtQueryViewerFilterChangedData_Selectedvalues != null )
      {
         AddObjectProperty("SelectedValues", gxTv_SdtQueryViewerFilterChangedData_Selectedvalues, false, false);
      }
   }

   public String getgxTv_SdtQueryViewerFilterChangedData_Name( )
   {
      return gxTv_SdtQueryViewerFilterChangedData_Name ;
   }

   public void setgxTv_SdtQueryViewerFilterChangedData_Name( String value )
   {
      gxTv_SdtQueryViewerFilterChangedData_N = (byte)(0) ;
      gxTv_SdtQueryViewerFilterChangedData_Name = value ;
   }

   public GXSimpleCollection<String> getgxTv_SdtQueryViewerFilterChangedData_Selectedvalues( )
   {
      if ( gxTv_SdtQueryViewerFilterChangedData_Selectedvalues == null )
      {
         gxTv_SdtQueryViewerFilterChangedData_Selectedvalues = new GXSimpleCollection<String>(String.class, "internal", "");
      }
      gxTv_SdtQueryViewerFilterChangedData_Selectedvalues_N = (byte)(0) ;
      gxTv_SdtQueryViewerFilterChangedData_N = (byte)(0) ;
      return gxTv_SdtQueryViewerFilterChangedData_Selectedvalues ;
   }

   public void setgxTv_SdtQueryViewerFilterChangedData_Selectedvalues( GXSimpleCollection<String> value )
   {
      gxTv_SdtQueryViewerFilterChangedData_Selectedvalues_N = (byte)(0) ;
      gxTv_SdtQueryViewerFilterChangedData_N = (byte)(0) ;
      gxTv_SdtQueryViewerFilterChangedData_Selectedvalues = value ;
   }

   public void setgxTv_SdtQueryViewerFilterChangedData_Selectedvalues_SetNull( )
   {
      gxTv_SdtQueryViewerFilterChangedData_Selectedvalues_N = (byte)(1) ;
      gxTv_SdtQueryViewerFilterChangedData_Selectedvalues = null ;
   }

   public boolean getgxTv_SdtQueryViewerFilterChangedData_Selectedvalues_IsNull( )
   {
      if ( gxTv_SdtQueryViewerFilterChangedData_Selectedvalues == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtQueryViewerFilterChangedData_Selectedvalues_N( )
   {
      return gxTv_SdtQueryViewerFilterChangedData_Selectedvalues_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtQueryViewerFilterChangedData_Name = "" ;
      gxTv_SdtQueryViewerFilterChangedData_N = (byte)(1) ;
      gxTv_SdtQueryViewerFilterChangedData_Selectedvalues_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtQueryViewerFilterChangedData_N ;
   }

   public com.projectthani.SdtQueryViewerFilterChangedData Clone( )
   {
      return (com.projectthani.SdtQueryViewerFilterChangedData)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtQueryViewerFilterChangedData struct )
   {
      setgxTv_SdtQueryViewerFilterChangedData_Name(struct.getName());
      setgxTv_SdtQueryViewerFilterChangedData_Selectedvalues(new GXSimpleCollection<String>(String.class, "internal", "", struct.getSelectedvalues()));
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtQueryViewerFilterChangedData getStruct( )
   {
      com.projectthani.StructSdtQueryViewerFilterChangedData struct = new com.projectthani.StructSdtQueryViewerFilterChangedData ();
      struct.setName(getgxTv_SdtQueryViewerFilterChangedData_Name());
      struct.setSelectedvalues(getgxTv_SdtQueryViewerFilterChangedData_Selectedvalues().getStruct());
      return struct ;
   }

   protected byte gxTv_SdtQueryViewerFilterChangedData_N ;
   protected byte gxTv_SdtQueryViewerFilterChangedData_Selectedvalues_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtQueryViewerFilterChangedData_Name ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected GXSimpleCollection<String> gxTv_SdtQueryViewerFilterChangedData_Selectedvalues=null ;
}

