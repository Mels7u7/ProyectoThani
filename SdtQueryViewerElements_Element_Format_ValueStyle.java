package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtQueryViewerElements_Element_Format_ValueStyle extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtQueryViewerElements_Element_Format_ValueStyle( )
   {
      this(  new ModelContext(SdtQueryViewerElements_Element_Format_ValueStyle.class));
   }

   public SdtQueryViewerElements_Element_Format_ValueStyle( ModelContext context )
   {
      super( context, "SdtQueryViewerElements_Element_Format_ValueStyle");
   }

   public SdtQueryViewerElements_Element_Format_ValueStyle( int remoteHandle ,
                                                            ModelContext context )
   {
      super( remoteHandle, context, "SdtQueryViewerElements_Element_Format_ValueStyle");
   }

   public SdtQueryViewerElements_Element_Format_ValueStyle( StructSdtQueryViewerElements_Element_Format_ValueStyle struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Value") )
            {
               gxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Value = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "StyleOrClass") )
            {
               gxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Styleorclass = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ApplyToRowOrColumn") )
            {
               gxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Applytoroworcolumn = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
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
         sName = "QueryViewerElements.Element.Format.ValueStyle" ;
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
      oWriter.writeElement("Value", GXutil.rtrim( gxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Value));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("StyleOrClass", GXutil.rtrim( gxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Styleorclass));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ApplyToRowOrColumn", GXutil.rtrim( GXutil.booltostr( gxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Applytoroworcolumn)));
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
      AddObjectProperty("Value", gxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Value, false, false);
      AddObjectProperty("StyleOrClass", gxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Styleorclass, false, false);
      AddObjectProperty("ApplyToRowOrColumn", gxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Applytoroworcolumn, false, false);
   }

   public String getgxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Value( )
   {
      return gxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Value ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Value( String value )
   {
      gxTv_SdtQueryViewerElements_Element_Format_ValueStyle_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Value = value ;
   }

   public String getgxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Styleorclass( )
   {
      return gxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Styleorclass ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Styleorclass( String value )
   {
      gxTv_SdtQueryViewerElements_Element_Format_ValueStyle_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Styleorclass = value ;
   }

   public boolean getgxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Applytoroworcolumn( )
   {
      return gxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Applytoroworcolumn ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Applytoroworcolumn( boolean value )
   {
      gxTv_SdtQueryViewerElements_Element_Format_ValueStyle_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Applytoroworcolumn = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Value = "" ;
      gxTv_SdtQueryViewerElements_Element_Format_ValueStyle_N = (byte)(1) ;
      gxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Styleorclass = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtQueryViewerElements_Element_Format_ValueStyle_N ;
   }

   public com.projectthani.SdtQueryViewerElements_Element_Format_ValueStyle Clone( )
   {
      return (com.projectthani.SdtQueryViewerElements_Element_Format_ValueStyle)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtQueryViewerElements_Element_Format_ValueStyle struct )
   {
      setgxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Value(struct.getValue());
      setgxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Styleorclass(struct.getStyleorclass());
      setgxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Applytoroworcolumn(struct.getApplytoroworcolumn());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtQueryViewerElements_Element_Format_ValueStyle getStruct( )
   {
      com.projectthani.StructSdtQueryViewerElements_Element_Format_ValueStyle struct = new com.projectthani.StructSdtQueryViewerElements_Element_Format_ValueStyle ();
      struct.setValue(getgxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Value());
      struct.setStyleorclass(getgxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Styleorclass());
      struct.setApplytoroworcolumn(getgxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Applytoroworcolumn());
      return struct ;
   }

   protected byte gxTv_SdtQueryViewerElements_Element_Format_ValueStyle_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Value ;
   protected String gxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Styleorclass ;
   protected String sTagName ;
   protected boolean gxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Applytoroworcolumn ;
   protected boolean readElement ;
   protected boolean formatError ;
}

