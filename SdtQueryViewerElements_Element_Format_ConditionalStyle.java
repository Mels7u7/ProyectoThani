package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtQueryViewerElements_Element_Format_ConditionalStyle extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtQueryViewerElements_Element_Format_ConditionalStyle( )
   {
      this(  new ModelContext(SdtQueryViewerElements_Element_Format_ConditionalStyle.class));
   }

   public SdtQueryViewerElements_Element_Format_ConditionalStyle( ModelContext context )
   {
      super( context, "SdtQueryViewerElements_Element_Format_ConditionalStyle");
   }

   public SdtQueryViewerElements_Element_Format_ConditionalStyle( int remoteHandle ,
                                                                  ModelContext context )
   {
      super( remoteHandle, context, "SdtQueryViewerElements_Element_Format_ConditionalStyle");
   }

   public SdtQueryViewerElements_Element_Format_ConditionalStyle( StructSdtQueryViewerElements_Element_Format_ConditionalStyle struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Operator") )
            {
               gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Operator = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Value1") )
            {
               gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Value1 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Value2") )
            {
               gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Value2 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "StyleOrClass") )
            {
               gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Styleorclass = oReader.getValue() ;
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
         sName = "QueryViewerElements.Element.Format.ConditionalStyle" ;
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
      oWriter.writeElement("Operator", GXutil.rtrim( gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Operator));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Value1", GXutil.rtrim( gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Value1));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Value2", GXutil.rtrim( gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Value2));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("StyleOrClass", GXutil.rtrim( gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Styleorclass));
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
      AddObjectProperty("Operator", gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Operator, false, false);
      AddObjectProperty("Value1", gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Value1, false, false);
      AddObjectProperty("Value2", gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Value2, false, false);
      AddObjectProperty("StyleOrClass", gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Styleorclass, false, false);
   }

   public String getgxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Operator( )
   {
      return gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Operator ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Operator( String value )
   {
      gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Operator = value ;
   }

   public String getgxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Value1( )
   {
      return gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Value1 ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Value1( String value )
   {
      gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Value1 = value ;
   }

   public String getgxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Value2( )
   {
      return gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Value2 ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Value2( String value )
   {
      gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Value2 = value ;
   }

   public String getgxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Styleorclass( )
   {
      return gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Styleorclass ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Styleorclass( String value )
   {
      gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Styleorclass = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Operator = "" ;
      gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_N = (byte)(1) ;
      gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Value1 = "" ;
      gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Value2 = "" ;
      gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Styleorclass = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_N ;
   }

   public com.projectthani.SdtQueryViewerElements_Element_Format_ConditionalStyle Clone( )
   {
      return (com.projectthani.SdtQueryViewerElements_Element_Format_ConditionalStyle)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtQueryViewerElements_Element_Format_ConditionalStyle struct )
   {
      setgxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Operator(struct.getOperator());
      setgxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Value1(struct.getValue1());
      setgxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Value2(struct.getValue2());
      setgxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Styleorclass(struct.getStyleorclass());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtQueryViewerElements_Element_Format_ConditionalStyle getStruct( )
   {
      com.projectthani.StructSdtQueryViewerElements_Element_Format_ConditionalStyle struct = new com.projectthani.StructSdtQueryViewerElements_Element_Format_ConditionalStyle ();
      struct.setOperator(getgxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Operator());
      struct.setValue1(getgxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Value1());
      struct.setValue2(getgxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Value2());
      struct.setStyleorclass(getgxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Styleorclass());
      return struct ;
   }

   protected byte gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Operator ;
   protected String gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Value1 ;
   protected String gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Value2 ;
   protected String gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Styleorclass ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

