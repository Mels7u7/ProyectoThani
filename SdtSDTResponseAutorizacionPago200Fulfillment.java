package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTResponseAutorizacionPago200Fulfillment extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTResponseAutorizacionPago200Fulfillment( )
   {
      this(  new ModelContext(SdtSDTResponseAutorizacionPago200Fulfillment.class));
   }

   public SdtSDTResponseAutorizacionPago200Fulfillment( ModelContext context )
   {
      super( context, "SdtSDTResponseAutorizacionPago200Fulfillment");
   }

   public SdtSDTResponseAutorizacionPago200Fulfillment( int remoteHandle ,
                                                        ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTResponseAutorizacionPago200Fulfillment");
   }

   public SdtSDTResponseAutorizacionPago200Fulfillment( StructSdtSDTResponseAutorizacionPago200Fulfillment struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "channel") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Channel = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "merchantId") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Merchantid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "terminalId") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Terminalid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "captureType") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Capturetype = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "countable") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Countable = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "fastPayment") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Fastpayment = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "signature") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Signature = oReader.getValue() ;
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
         sName = "SDTResponseAutorizacionPago200Fulfillment" ;
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
      oWriter.writeElement("channel", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Channel));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("merchantId", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Merchantid));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("terminalId", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Terminalid));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("captureType", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Capturetype));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("countable", GXutil.rtrim( GXutil.booltostr( gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Countable)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("fastPayment", GXutil.rtrim( GXutil.booltostr( gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Fastpayment)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("signature", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Signature));
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
      AddObjectProperty("channel", gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Channel, false, false);
      AddObjectProperty("merchantId", gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Merchantid, false, false);
      AddObjectProperty("terminalId", gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Terminalid, false, false);
      AddObjectProperty("captureType", gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Capturetype, false, false);
      AddObjectProperty("countable", gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Countable, false, false);
      AddObjectProperty("fastPayment", gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Fastpayment, false, false);
      AddObjectProperty("signature", gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Signature, false, false);
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Channel( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Channel ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Channel( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Channel = value ;
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Merchantid( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Merchantid ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Merchantid( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Merchantid = value ;
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Terminalid( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Terminalid ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Terminalid( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Terminalid = value ;
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Capturetype( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Capturetype ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Capturetype( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Capturetype = value ;
   }

   public boolean getgxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Countable( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Countable ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Countable( boolean value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Countable = value ;
   }

   public boolean getgxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Fastpayment( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Fastpayment ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Fastpayment( boolean value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Fastpayment = value ;
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Signature( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Signature ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Signature( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Signature = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Channel = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_N = (byte)(1) ;
      gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Merchantid = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Terminalid = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Capturetype = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Signature = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_N ;
   }

   public com.projectthani.SdtSDTResponseAutorizacionPago200Fulfillment Clone( )
   {
      return (com.projectthani.SdtSDTResponseAutorizacionPago200Fulfillment)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTResponseAutorizacionPago200Fulfillment struct )
   {
      setgxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Channel(struct.getChannel());
      setgxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Merchantid(struct.getMerchantid());
      setgxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Terminalid(struct.getTerminalid());
      setgxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Capturetype(struct.getCapturetype());
      setgxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Countable(struct.getCountable());
      setgxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Fastpayment(struct.getFastpayment());
      setgxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Signature(struct.getSignature());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTResponseAutorizacionPago200Fulfillment getStruct( )
   {
      com.projectthani.StructSdtSDTResponseAutorizacionPago200Fulfillment struct = new com.projectthani.StructSdtSDTResponseAutorizacionPago200Fulfillment ();
      struct.setChannel(getgxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Channel());
      struct.setMerchantid(getgxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Merchantid());
      struct.setTerminalid(getgxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Terminalid());
      struct.setCapturetype(getgxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Capturetype());
      struct.setCountable(getgxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Countable());
      struct.setFastpayment(getgxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Fastpayment());
      struct.setSignature(getgxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Signature());
      return struct ;
   }

   protected byte gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Countable ;
   protected boolean gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Fastpayment ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Channel ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Merchantid ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Terminalid ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Capturetype ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Signature ;
}

