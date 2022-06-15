package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTResponseTokenSession200 extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTResponseTokenSession200( )
   {
      this(  new ModelContext(SdtSDTResponseTokenSession200.class));
   }

   public SdtSDTResponseTokenSession200( ModelContext context )
   {
      super( context, "SdtSDTResponseTokenSession200");
   }

   public SdtSDTResponseTokenSession200( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTResponseTokenSession200");
   }

   public SdtSDTResponseTokenSession200( StructSdtSDTResponseTokenSession200 struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "sessionKey") )
            {
               gxTv_SdtSDTResponseTokenSession200_Sessionkey = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "expirationTime") )
            {
               gxTv_SdtSDTResponseTokenSession200_Expirationtime = (long)(getnumericvalue(oReader.getValue())) ;
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
         sName = "SDTResponseTokenSession200" ;
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
      oWriter.writeElement("sessionKey", GXutil.rtrim( gxTv_SdtSDTResponseTokenSession200_Sessionkey));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("expirationTime", GXutil.trim( GXutil.str( gxTv_SdtSDTResponseTokenSession200_Expirationtime, 13, 0)));
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
      AddObjectProperty("sessionKey", gxTv_SdtSDTResponseTokenSession200_Sessionkey, false, false);
      AddObjectProperty("expirationTime", gxTv_SdtSDTResponseTokenSession200_Expirationtime, false, false);
   }

   public String getgxTv_SdtSDTResponseTokenSession200_Sessionkey( )
   {
      return gxTv_SdtSDTResponseTokenSession200_Sessionkey ;
   }

   public void setgxTv_SdtSDTResponseTokenSession200_Sessionkey( String value )
   {
      gxTv_SdtSDTResponseTokenSession200_N = (byte)(0) ;
      gxTv_SdtSDTResponseTokenSession200_Sessionkey = value ;
   }

   public long getgxTv_SdtSDTResponseTokenSession200_Expirationtime( )
   {
      return gxTv_SdtSDTResponseTokenSession200_Expirationtime ;
   }

   public void setgxTv_SdtSDTResponseTokenSession200_Expirationtime( long value )
   {
      gxTv_SdtSDTResponseTokenSession200_N = (byte)(0) ;
      gxTv_SdtSDTResponseTokenSession200_Expirationtime = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTResponseTokenSession200_Sessionkey = "" ;
      gxTv_SdtSDTResponseTokenSession200_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTResponseTokenSession200_N ;
   }

   public com.projectthani.SdtSDTResponseTokenSession200 Clone( )
   {
      return (com.projectthani.SdtSDTResponseTokenSession200)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTResponseTokenSession200 struct )
   {
      setgxTv_SdtSDTResponseTokenSession200_Sessionkey(struct.getSessionkey());
      setgxTv_SdtSDTResponseTokenSession200_Expirationtime(struct.getExpirationtime());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTResponseTokenSession200 getStruct( )
   {
      com.projectthani.StructSdtSDTResponseTokenSession200 struct = new com.projectthani.StructSdtSDTResponseTokenSession200 ();
      struct.setSessionkey(getgxTv_SdtSDTResponseTokenSession200_Sessionkey());
      struct.setExpirationtime(getgxTv_SdtSDTResponseTokenSession200_Expirationtime());
      return struct ;
   }

   protected byte gxTv_SdtSDTResponseTokenSession200_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected long gxTv_SdtSDTResponseTokenSession200_Expirationtime ;
   protected String gxTv_SdtSDTResponseTokenSession200_Sessionkey ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

