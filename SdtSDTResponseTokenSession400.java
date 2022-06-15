package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTResponseTokenSession400 extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTResponseTokenSession400( )
   {
      this(  new ModelContext(SdtSDTResponseTokenSession400.class));
   }

   public SdtSDTResponseTokenSession400( ModelContext context )
   {
      super( context, "SdtSDTResponseTokenSession400");
   }

   public SdtSDTResponseTokenSession400( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTResponseTokenSession400");
   }

   public SdtSDTResponseTokenSession400( StructSdtSDTResponseTokenSession400 struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "errorCode") )
            {
               gxTv_SdtSDTResponseTokenSession400_Errorcode = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "errorMessage") )
            {
               gxTv_SdtSDTResponseTokenSession400_Errormessage = oReader.getValue() ;
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
         sName = "SDTResponseTokenSession400" ;
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
      oWriter.writeElement("errorCode", GXutil.trim( GXutil.str( gxTv_SdtSDTResponseTokenSession400_Errorcode, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("errorMessage", GXutil.rtrim( gxTv_SdtSDTResponseTokenSession400_Errormessage));
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
      AddObjectProperty("errorCode", gxTv_SdtSDTResponseTokenSession400_Errorcode, false, false);
      AddObjectProperty("errorMessage", gxTv_SdtSDTResponseTokenSession400_Errormessage, false, false);
   }

   public short getgxTv_SdtSDTResponseTokenSession400_Errorcode( )
   {
      return gxTv_SdtSDTResponseTokenSession400_Errorcode ;
   }

   public void setgxTv_SdtSDTResponseTokenSession400_Errorcode( short value )
   {
      gxTv_SdtSDTResponseTokenSession400_N = (byte)(0) ;
      gxTv_SdtSDTResponseTokenSession400_Errorcode = value ;
   }

   public String getgxTv_SdtSDTResponseTokenSession400_Errormessage( )
   {
      return gxTv_SdtSDTResponseTokenSession400_Errormessage ;
   }

   public void setgxTv_SdtSDTResponseTokenSession400_Errormessage( String value )
   {
      gxTv_SdtSDTResponseTokenSession400_N = (byte)(0) ;
      gxTv_SdtSDTResponseTokenSession400_Errormessage = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTResponseTokenSession400_N = (byte)(1) ;
      gxTv_SdtSDTResponseTokenSession400_Errormessage = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTResponseTokenSession400_N ;
   }

   public com.projectthani.SdtSDTResponseTokenSession400 Clone( )
   {
      return (com.projectthani.SdtSDTResponseTokenSession400)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTResponseTokenSession400 struct )
   {
      setgxTv_SdtSDTResponseTokenSession400_Errorcode(struct.getErrorcode());
      setgxTv_SdtSDTResponseTokenSession400_Errormessage(struct.getErrormessage());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTResponseTokenSession400 getStruct( )
   {
      com.projectthani.StructSdtSDTResponseTokenSession400 struct = new com.projectthani.StructSdtSDTResponseTokenSession400 ();
      struct.setErrorcode(getgxTv_SdtSDTResponseTokenSession400_Errorcode());
      struct.setErrormessage(getgxTv_SdtSDTResponseTokenSession400_Errormessage());
      return struct ;
   }

   protected byte gxTv_SdtSDTResponseTokenSession400_N ;
   protected short gxTv_SdtSDTResponseTokenSession400_Errorcode ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTResponseTokenSession400_Errormessage ;
}

