package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtQueryViewerElements_Element_Actions extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtQueryViewerElements_Element_Actions( )
   {
      this(  new ModelContext(SdtQueryViewerElements_Element_Actions.class));
   }

   public SdtQueryViewerElements_Element_Actions( ModelContext context )
   {
      super( context, "SdtQueryViewerElements_Element_Actions");
   }

   public SdtQueryViewerElements_Element_Actions( int remoteHandle ,
                                                  ModelContext context )
   {
      super( remoteHandle, context, "SdtQueryViewerElements_Element_Actions");
   }

   public SdtQueryViewerElements_Element_Actions( StructSdtQueryViewerElements_Element_Actions struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "RaiseItemClick") )
            {
               gxTv_SdtQueryViewerElements_Element_Actions_Raiseitemclick = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
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
         sName = "QueryViewerElements.Element.Actions" ;
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
      oWriter.writeElement("RaiseItemClick", GXutil.rtrim( GXutil.booltostr( gxTv_SdtQueryViewerElements_Element_Actions_Raiseitemclick)));
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
      AddObjectProperty("RaiseItemClick", gxTv_SdtQueryViewerElements_Element_Actions_Raiseitemclick, false, false);
   }

   public boolean getgxTv_SdtQueryViewerElements_Element_Actions_Raiseitemclick( )
   {
      return gxTv_SdtQueryViewerElements_Element_Actions_Raiseitemclick ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Actions_Raiseitemclick( boolean value )
   {
      gxTv_SdtQueryViewerElements_Element_Actions_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Actions_Raiseitemclick = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtQueryViewerElements_Element_Actions_Raiseitemclick = true ;
      gxTv_SdtQueryViewerElements_Element_Actions_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtQueryViewerElements_Element_Actions_N ;
   }

   public com.projectthani.SdtQueryViewerElements_Element_Actions Clone( )
   {
      return (com.projectthani.SdtQueryViewerElements_Element_Actions)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtQueryViewerElements_Element_Actions struct )
   {
      setgxTv_SdtQueryViewerElements_Element_Actions_Raiseitemclick(struct.getRaiseitemclick());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtQueryViewerElements_Element_Actions getStruct( )
   {
      com.projectthani.StructSdtQueryViewerElements_Element_Actions struct = new com.projectthani.StructSdtQueryViewerElements_Element_Actions ();
      struct.setRaiseitemclick(getgxTv_SdtQueryViewerElements_Element_Actions_Raiseitemclick());
      return struct ;
   }

   protected byte gxTv_SdtQueryViewerElements_Element_Actions_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean gxTv_SdtQueryViewerElements_Element_Actions_Raiseitemclick ;
   protected boolean readElement ;
   protected boolean formatError ;
}

