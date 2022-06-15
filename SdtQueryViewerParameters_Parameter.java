package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtQueryViewerParameters_Parameter extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtQueryViewerParameters_Parameter( )
   {
      this(  new ModelContext(SdtQueryViewerParameters_Parameter.class));
   }

   public SdtQueryViewerParameters_Parameter( ModelContext context )
   {
      super( context, "SdtQueryViewerParameters_Parameter");
   }

   public SdtQueryViewerParameters_Parameter( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle, context, "SdtQueryViewerParameters_Parameter");
   }

   public SdtQueryViewerParameters_Parameter( StructSdtQueryViewerParameters_Parameter struct )
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
               gxTv_SdtQueryViewerParameters_Parameter_Name = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Value") )
            {
               gxTv_SdtQueryViewerParameters_Parameter_Value = oReader.getValue() ;
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
         sName = "QueryViewerParameters.Parameter" ;
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
      oWriter.writeElement("Name", GXutil.rtrim( gxTv_SdtQueryViewerParameters_Parameter_Name));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Value", GXutil.rtrim( gxTv_SdtQueryViewerParameters_Parameter_Value));
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
      AddObjectProperty("Name", gxTv_SdtQueryViewerParameters_Parameter_Name, false, false);
      AddObjectProperty("Value", gxTv_SdtQueryViewerParameters_Parameter_Value, false, false);
   }

   public String getgxTv_SdtQueryViewerParameters_Parameter_Name( )
   {
      return gxTv_SdtQueryViewerParameters_Parameter_Name ;
   }

   public void setgxTv_SdtQueryViewerParameters_Parameter_Name( String value )
   {
      gxTv_SdtQueryViewerParameters_Parameter_N = (byte)(0) ;
      gxTv_SdtQueryViewerParameters_Parameter_Name = value ;
   }

   public String getgxTv_SdtQueryViewerParameters_Parameter_Value( )
   {
      return gxTv_SdtQueryViewerParameters_Parameter_Value ;
   }

   public void setgxTv_SdtQueryViewerParameters_Parameter_Value( String value )
   {
      gxTv_SdtQueryViewerParameters_Parameter_N = (byte)(0) ;
      gxTv_SdtQueryViewerParameters_Parameter_Value = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtQueryViewerParameters_Parameter_Name = "" ;
      gxTv_SdtQueryViewerParameters_Parameter_N = (byte)(1) ;
      gxTv_SdtQueryViewerParameters_Parameter_Value = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtQueryViewerParameters_Parameter_N ;
   }

   public com.projectthani.SdtQueryViewerParameters_Parameter Clone( )
   {
      return (com.projectthani.SdtQueryViewerParameters_Parameter)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtQueryViewerParameters_Parameter struct )
   {
      setgxTv_SdtQueryViewerParameters_Parameter_Name(struct.getName());
      setgxTv_SdtQueryViewerParameters_Parameter_Value(struct.getValue());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtQueryViewerParameters_Parameter getStruct( )
   {
      com.projectthani.StructSdtQueryViewerParameters_Parameter struct = new com.projectthani.StructSdtQueryViewerParameters_Parameter ();
      struct.setName(getgxTv_SdtQueryViewerParameters_Parameter_Name());
      struct.setValue(getgxTv_SdtQueryViewerParameters_Parameter_Value());
      return struct ;
   }

   protected byte gxTv_SdtQueryViewerParameters_Parameter_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtQueryViewerParameters_Parameter_Name ;
   protected String gxTv_SdtQueryViewerParameters_Parameter_Value ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

