package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTRequestAutorizacionPagoAntifraud extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTRequestAutorizacionPagoAntifraud( )
   {
      this(  new ModelContext(SdtSDTRequestAutorizacionPagoAntifraud.class));
   }

   public SdtSDTRequestAutorizacionPagoAntifraud( ModelContext context )
   {
      super( context, "SdtSDTRequestAutorizacionPagoAntifraud");
   }

   public SdtSDTRequestAutorizacionPagoAntifraud( int remoteHandle ,
                                                  ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTRequestAutorizacionPagoAntifraud");
   }

   public SdtSDTRequestAutorizacionPagoAntifraud( StructSdtSDTRequestAutorizacionPagoAntifraud struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "clientIp") )
            {
               gxTv_SdtSDTRequestAutorizacionPagoAntifraud_Clientip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "merchantDefineData") )
            {
               if ( gxTv_SdtSDTRequestAutorizacionPagoAntifraud_Merchantdefinedata == null )
               {
                  gxTv_SdtSDTRequestAutorizacionPagoAntifraud_Merchantdefinedata = new com.projectthani.SdtSDTRequestAutorizacionPagoMerchantData(remoteHandle, context);
               }
               GXSoapError = gxTv_SdtSDTRequestAutorizacionPagoAntifraud_Merchantdefinedata.readxml(oReader, "merchantDefineData") ;
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
         sName = "SDTRequestAutorizacionPagoAntifraud" ;
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
      oWriter.writeElement("clientIp", GXutil.rtrim( gxTv_SdtSDTRequestAutorizacionPagoAntifraud_Clientip));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( gxTv_SdtSDTRequestAutorizacionPagoAntifraud_Merchantdefinedata != null )
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
         gxTv_SdtSDTRequestAutorizacionPagoAntifraud_Merchantdefinedata.writexml(oWriter, "merchantDefineData", sNameSpace1);
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
      AddObjectProperty("clientIp", gxTv_SdtSDTRequestAutorizacionPagoAntifraud_Clientip, false, false);
      if ( gxTv_SdtSDTRequestAutorizacionPagoAntifraud_Merchantdefinedata != null )
      {
         AddObjectProperty("merchantDefineData", gxTv_SdtSDTRequestAutorizacionPagoAntifraud_Merchantdefinedata, false, false);
      }
   }

   public String getgxTv_SdtSDTRequestAutorizacionPagoAntifraud_Clientip( )
   {
      return gxTv_SdtSDTRequestAutorizacionPagoAntifraud_Clientip ;
   }

   public void setgxTv_SdtSDTRequestAutorizacionPagoAntifraud_Clientip( String value )
   {
      gxTv_SdtSDTRequestAutorizacionPagoAntifraud_N = (byte)(0) ;
      gxTv_SdtSDTRequestAutorizacionPagoAntifraud_Clientip = value ;
   }

   public com.projectthani.SdtSDTRequestAutorizacionPagoMerchantData getgxTv_SdtSDTRequestAutorizacionPagoAntifraud_Merchantdefinedata( )
   {
      if ( gxTv_SdtSDTRequestAutorizacionPagoAntifraud_Merchantdefinedata == null )
      {
         gxTv_SdtSDTRequestAutorizacionPagoAntifraud_Merchantdefinedata = new com.projectthani.SdtSDTRequestAutorizacionPagoMerchantData(remoteHandle, context);
      }
      gxTv_SdtSDTRequestAutorizacionPagoAntifraud_Merchantdefinedata_N = (byte)(0) ;
      gxTv_SdtSDTRequestAutorizacionPagoAntifraud_N = (byte)(0) ;
      return gxTv_SdtSDTRequestAutorizacionPagoAntifraud_Merchantdefinedata ;
   }

   public void setgxTv_SdtSDTRequestAutorizacionPagoAntifraud_Merchantdefinedata( com.projectthani.SdtSDTRequestAutorizacionPagoMerchantData value )
   {
      gxTv_SdtSDTRequestAutorizacionPagoAntifraud_Merchantdefinedata_N = (byte)(0) ;
      gxTv_SdtSDTRequestAutorizacionPagoAntifraud_N = (byte)(0) ;
      gxTv_SdtSDTRequestAutorizacionPagoAntifraud_Merchantdefinedata = value;
   }

   public void setgxTv_SdtSDTRequestAutorizacionPagoAntifraud_Merchantdefinedata_SetNull( )
   {
      gxTv_SdtSDTRequestAutorizacionPagoAntifraud_Merchantdefinedata_N = (byte)(1) ;
      gxTv_SdtSDTRequestAutorizacionPagoAntifraud_Merchantdefinedata = (com.projectthani.SdtSDTRequestAutorizacionPagoMerchantData)null;
   }

   public boolean getgxTv_SdtSDTRequestAutorizacionPagoAntifraud_Merchantdefinedata_IsNull( )
   {
      if ( gxTv_SdtSDTRequestAutorizacionPagoAntifraud_Merchantdefinedata == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtSDTRequestAutorizacionPagoAntifraud_Merchantdefinedata_N( )
   {
      return gxTv_SdtSDTRequestAutorizacionPagoAntifraud_Merchantdefinedata_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTRequestAutorizacionPagoAntifraud_Clientip = "" ;
      gxTv_SdtSDTRequestAutorizacionPagoAntifraud_N = (byte)(1) ;
      gxTv_SdtSDTRequestAutorizacionPagoAntifraud_Merchantdefinedata_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTRequestAutorizacionPagoAntifraud_N ;
   }

   public com.projectthani.SdtSDTRequestAutorizacionPagoAntifraud Clone( )
   {
      return (com.projectthani.SdtSDTRequestAutorizacionPagoAntifraud)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTRequestAutorizacionPagoAntifraud struct )
   {
      setgxTv_SdtSDTRequestAutorizacionPagoAntifraud_Clientip(struct.getClientip());
      setgxTv_SdtSDTRequestAutorizacionPagoAntifraud_Merchantdefinedata(new com.projectthani.SdtSDTRequestAutorizacionPagoMerchantData(struct.getMerchantdefinedata()));
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTRequestAutorizacionPagoAntifraud getStruct( )
   {
      com.projectthani.StructSdtSDTRequestAutorizacionPagoAntifraud struct = new com.projectthani.StructSdtSDTRequestAutorizacionPagoAntifraud ();
      struct.setClientip(getgxTv_SdtSDTRequestAutorizacionPagoAntifraud_Clientip());
      struct.setMerchantdefinedata(getgxTv_SdtSDTRequestAutorizacionPagoAntifraud_Merchantdefinedata().getStruct());
      return struct ;
   }

   protected byte gxTv_SdtSDTRequestAutorizacionPagoAntifraud_N ;
   protected byte gxTv_SdtSDTRequestAutorizacionPagoAntifraud_Merchantdefinedata_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTRequestAutorizacionPagoAntifraud_Clientip ;
   protected com.projectthani.SdtSDTRequestAutorizacionPagoMerchantData gxTv_SdtSDTRequestAutorizacionPagoAntifraud_Merchantdefinedata=null ;
}

