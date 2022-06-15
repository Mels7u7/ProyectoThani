package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTResponseAutorizacionPago200Token extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTResponseAutorizacionPago200Token( )
   {
      this(  new ModelContext(SdtSDTResponseAutorizacionPago200Token.class));
   }

   public SdtSDTResponseAutorizacionPago200Token( ModelContext context )
   {
      super( context, "SdtSDTResponseAutorizacionPago200Token");
   }

   public SdtSDTResponseAutorizacionPago200Token( int remoteHandle ,
                                                  ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTResponseAutorizacionPago200Token");
   }

   public SdtSDTResponseAutorizacionPago200Token( StructSdtSDTResponseAutorizacionPago200Token struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "tokenId") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200Token_Tokenid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ownerId") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200Token_Ownerid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "expireOn") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200Token_Expireon = oReader.getValue() ;
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
         sName = "SDTResponseAutorizacionPago200Token" ;
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
      oWriter.writeElement("tokenId", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago200Token_Tokenid));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ownerId", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago200Token_Ownerid));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("expireOn", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago200Token_Expireon));
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
      AddObjectProperty("tokenId", gxTv_SdtSDTResponseAutorizacionPago200Token_Tokenid, false, false);
      AddObjectProperty("ownerId", gxTv_SdtSDTResponseAutorizacionPago200Token_Ownerid, false, false);
      AddObjectProperty("expireOn", gxTv_SdtSDTResponseAutorizacionPago200Token_Expireon, false, false);
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago200Token_Tokenid( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Token_Tokenid ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200Token_Tokenid( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Token_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Token_Tokenid = value ;
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago200Token_Ownerid( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Token_Ownerid ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200Token_Ownerid( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Token_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Token_Ownerid = value ;
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago200Token_Expireon( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Token_Expireon ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200Token_Expireon( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Token_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Token_Expireon = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Token_Tokenid = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200Token_N = (byte)(1) ;
      gxTv_SdtSDTResponseAutorizacionPago200Token_Ownerid = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200Token_Expireon = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Token_N ;
   }

   public com.projectthani.SdtSDTResponseAutorizacionPago200Token Clone( )
   {
      return (com.projectthani.SdtSDTResponseAutorizacionPago200Token)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTResponseAutorizacionPago200Token struct )
   {
      setgxTv_SdtSDTResponseAutorizacionPago200Token_Tokenid(struct.getTokenid());
      setgxTv_SdtSDTResponseAutorizacionPago200Token_Ownerid(struct.getOwnerid());
      setgxTv_SdtSDTResponseAutorizacionPago200Token_Expireon(struct.getExpireon());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTResponseAutorizacionPago200Token getStruct( )
   {
      com.projectthani.StructSdtSDTResponseAutorizacionPago200Token struct = new com.projectthani.StructSdtSDTResponseAutorizacionPago200Token ();
      struct.setTokenid(getgxTv_SdtSDTResponseAutorizacionPago200Token_Tokenid());
      struct.setOwnerid(getgxTv_SdtSDTResponseAutorizacionPago200Token_Ownerid());
      struct.setExpireon(getgxTv_SdtSDTResponseAutorizacionPago200Token_Expireon());
      return struct ;
   }

   protected byte gxTv_SdtSDTResponseAutorizacionPago200Token_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200Token_Tokenid ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200Token_Ownerid ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200Token_Expireon ;
}

