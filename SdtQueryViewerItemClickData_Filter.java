package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtQueryViewerItemClickData_Filter extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtQueryViewerItemClickData_Filter( )
   {
      this(  new ModelContext(SdtQueryViewerItemClickData_Filter.class));
   }

   public SdtQueryViewerItemClickData_Filter( ModelContext context )
   {
      super( context, "SdtQueryViewerItemClickData_Filter");
   }

   public SdtQueryViewerItemClickData_Filter( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle, context, "SdtQueryViewerItemClickData_Filter");
   }

   public SdtQueryViewerItemClickData_Filter( StructSdtQueryViewerItemClickData_Filter struct )
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
               gxTv_SdtQueryViewerItemClickData_Filter_Name = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Values") )
            {
               if ( gxTv_SdtQueryViewerItemClickData_Filter_Values == null )
               {
                  gxTv_SdtQueryViewerItemClickData_Filter_Values = new GXSimpleCollection<String>(String.class, "internal", "");
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_SdtQueryViewerItemClickData_Filter_Values.readxmlcollection(oReader, "Values", "Item") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Values") )
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
         sName = "QueryViewerItemClickData.Filter" ;
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
      oWriter.writeElement("Name", GXutil.rtrim( gxTv_SdtQueryViewerItemClickData_Filter_Name));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( gxTv_SdtQueryViewerItemClickData_Filter_Values != null )
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
         gxTv_SdtQueryViewerItemClickData_Filter_Values.writexmlcollection(oWriter, "Values", sNameSpace1, "Item", sNameSpace1);
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
      AddObjectProperty("Name", gxTv_SdtQueryViewerItemClickData_Filter_Name, false, false);
      if ( gxTv_SdtQueryViewerItemClickData_Filter_Values != null )
      {
         AddObjectProperty("Values", gxTv_SdtQueryViewerItemClickData_Filter_Values, false, false);
      }
   }

   public String getgxTv_SdtQueryViewerItemClickData_Filter_Name( )
   {
      return gxTv_SdtQueryViewerItemClickData_Filter_Name ;
   }

   public void setgxTv_SdtQueryViewerItemClickData_Filter_Name( String value )
   {
      gxTv_SdtQueryViewerItemClickData_Filter_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemClickData_Filter_Name = value ;
   }

   public GXSimpleCollection<String> getgxTv_SdtQueryViewerItemClickData_Filter_Values( )
   {
      if ( gxTv_SdtQueryViewerItemClickData_Filter_Values == null )
      {
         gxTv_SdtQueryViewerItemClickData_Filter_Values = new GXSimpleCollection<String>(String.class, "internal", "");
      }
      gxTv_SdtQueryViewerItemClickData_Filter_Values_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemClickData_Filter_N = (byte)(0) ;
      return gxTv_SdtQueryViewerItemClickData_Filter_Values ;
   }

   public void setgxTv_SdtQueryViewerItemClickData_Filter_Values( GXSimpleCollection<String> value )
   {
      gxTv_SdtQueryViewerItemClickData_Filter_Values_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemClickData_Filter_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemClickData_Filter_Values = value ;
   }

   public void setgxTv_SdtQueryViewerItemClickData_Filter_Values_SetNull( )
   {
      gxTv_SdtQueryViewerItemClickData_Filter_Values_N = (byte)(1) ;
      gxTv_SdtQueryViewerItemClickData_Filter_Values = null ;
   }

   public boolean getgxTv_SdtQueryViewerItemClickData_Filter_Values_IsNull( )
   {
      if ( gxTv_SdtQueryViewerItemClickData_Filter_Values == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtQueryViewerItemClickData_Filter_Values_N( )
   {
      return gxTv_SdtQueryViewerItemClickData_Filter_Values_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtQueryViewerItemClickData_Filter_Name = "" ;
      gxTv_SdtQueryViewerItemClickData_Filter_N = (byte)(1) ;
      gxTv_SdtQueryViewerItemClickData_Filter_Values_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtQueryViewerItemClickData_Filter_N ;
   }

   public com.projectthani.SdtQueryViewerItemClickData_Filter Clone( )
   {
      return (com.projectthani.SdtQueryViewerItemClickData_Filter)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtQueryViewerItemClickData_Filter struct )
   {
      setgxTv_SdtQueryViewerItemClickData_Filter_Name(struct.getName());
      setgxTv_SdtQueryViewerItemClickData_Filter_Values(new GXSimpleCollection<String>(String.class, "internal", "", struct.getValues()));
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtQueryViewerItemClickData_Filter getStruct( )
   {
      com.projectthani.StructSdtQueryViewerItemClickData_Filter struct = new com.projectthani.StructSdtQueryViewerItemClickData_Filter ();
      struct.setName(getgxTv_SdtQueryViewerItemClickData_Filter_Name());
      struct.setValues(getgxTv_SdtQueryViewerItemClickData_Filter_Values().getStruct());
      return struct ;
   }

   protected byte gxTv_SdtQueryViewerItemClickData_Filter_N ;
   protected byte gxTv_SdtQueryViewerItemClickData_Filter_Values_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtQueryViewerItemClickData_Filter_Name ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected GXSimpleCollection<String> gxTv_SdtQueryViewerItemClickData_Filter_Values=null ;
}

