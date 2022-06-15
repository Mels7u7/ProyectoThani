package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTRequestAutorizacionPago extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTRequestAutorizacionPago( )
   {
      this(  new ModelContext(SdtSDTRequestAutorizacionPago.class));
   }

   public SdtSDTRequestAutorizacionPago( ModelContext context )
   {
      super( context, "SdtSDTRequestAutorizacionPago");
   }

   public SdtSDTRequestAutorizacionPago( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTRequestAutorizacionPago");
   }

   public SdtSDTRequestAutorizacionPago( StructSdtSDTRequestAutorizacionPago struct )
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
               gxTv_SdtSDTRequestAutorizacionPago_Channel = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "captureType") )
            {
               gxTv_SdtSDTRequestAutorizacionPago_Capturetype = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "order") )
            {
               if ( gxTv_SdtSDTRequestAutorizacionPago_Order == null )
               {
                  gxTv_SdtSDTRequestAutorizacionPago_Order = new com.projectthani.SdtSDTRequestOrder(remoteHandle, context);
               }
               GXSoapError = gxTv_SdtSDTRequestAutorizacionPago_Order.readxml(oReader, "order") ;
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
         sName = "SDTRequestAutorizacionPago" ;
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
      oWriter.writeElement("channel", GXutil.rtrim( gxTv_SdtSDTRequestAutorizacionPago_Channel));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("captureType", GXutil.rtrim( gxTv_SdtSDTRequestAutorizacionPago_Capturetype));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( gxTv_SdtSDTRequestAutorizacionPago_Order != null )
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
         gxTv_SdtSDTRequestAutorizacionPago_Order.writexml(oWriter, "order", sNameSpace1);
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
      AddObjectProperty("channel", gxTv_SdtSDTRequestAutorizacionPago_Channel, false, false);
      AddObjectProperty("captureType", gxTv_SdtSDTRequestAutorizacionPago_Capturetype, false, false);
      if ( gxTv_SdtSDTRequestAutorizacionPago_Order != null )
      {
         AddObjectProperty("order", gxTv_SdtSDTRequestAutorizacionPago_Order, false, false);
      }
   }

   public String getgxTv_SdtSDTRequestAutorizacionPago_Channel( )
   {
      return gxTv_SdtSDTRequestAutorizacionPago_Channel ;
   }

   public void setgxTv_SdtSDTRequestAutorizacionPago_Channel( String value )
   {
      gxTv_SdtSDTRequestAutorizacionPago_N = (byte)(0) ;
      gxTv_SdtSDTRequestAutorizacionPago_Channel = value ;
   }

   public String getgxTv_SdtSDTRequestAutorizacionPago_Capturetype( )
   {
      return gxTv_SdtSDTRequestAutorizacionPago_Capturetype ;
   }

   public void setgxTv_SdtSDTRequestAutorizacionPago_Capturetype( String value )
   {
      gxTv_SdtSDTRequestAutorizacionPago_N = (byte)(0) ;
      gxTv_SdtSDTRequestAutorizacionPago_Capturetype = value ;
   }

   public com.projectthani.SdtSDTRequestOrder getgxTv_SdtSDTRequestAutorizacionPago_Order( )
   {
      if ( gxTv_SdtSDTRequestAutorizacionPago_Order == null )
      {
         gxTv_SdtSDTRequestAutorizacionPago_Order = new com.projectthani.SdtSDTRequestOrder(remoteHandle, context);
      }
      gxTv_SdtSDTRequestAutorizacionPago_Order_N = (byte)(0) ;
      gxTv_SdtSDTRequestAutorizacionPago_N = (byte)(0) ;
      return gxTv_SdtSDTRequestAutorizacionPago_Order ;
   }

   public void setgxTv_SdtSDTRequestAutorizacionPago_Order( com.projectthani.SdtSDTRequestOrder value )
   {
      gxTv_SdtSDTRequestAutorizacionPago_Order_N = (byte)(0) ;
      gxTv_SdtSDTRequestAutorizacionPago_N = (byte)(0) ;
      gxTv_SdtSDTRequestAutorizacionPago_Order = value;
   }

   public void setgxTv_SdtSDTRequestAutorizacionPago_Order_SetNull( )
   {
      gxTv_SdtSDTRequestAutorizacionPago_Order_N = (byte)(1) ;
      gxTv_SdtSDTRequestAutorizacionPago_Order = (com.projectthani.SdtSDTRequestOrder)null;
   }

   public boolean getgxTv_SdtSDTRequestAutorizacionPago_Order_IsNull( )
   {
      if ( gxTv_SdtSDTRequestAutorizacionPago_Order == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtSDTRequestAutorizacionPago_Order_N( )
   {
      return gxTv_SdtSDTRequestAutorizacionPago_Order_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTRequestAutorizacionPago_Channel = "" ;
      gxTv_SdtSDTRequestAutorizacionPago_N = (byte)(1) ;
      gxTv_SdtSDTRequestAutorizacionPago_Capturetype = "" ;
      gxTv_SdtSDTRequestAutorizacionPago_Order_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTRequestAutorizacionPago_N ;
   }

   public com.projectthani.SdtSDTRequestAutorizacionPago Clone( )
   {
      return (com.projectthani.SdtSDTRequestAutorizacionPago)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTRequestAutorizacionPago struct )
   {
      setgxTv_SdtSDTRequestAutorizacionPago_Channel(struct.getChannel());
      setgxTv_SdtSDTRequestAutorizacionPago_Capturetype(struct.getCapturetype());
      setgxTv_SdtSDTRequestAutorizacionPago_Order(new com.projectthani.SdtSDTRequestOrder(struct.getOrder()));
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTRequestAutorizacionPago getStruct( )
   {
      com.projectthani.StructSdtSDTRequestAutorizacionPago struct = new com.projectthani.StructSdtSDTRequestAutorizacionPago ();
      struct.setChannel(getgxTv_SdtSDTRequestAutorizacionPago_Channel());
      struct.setCapturetype(getgxTv_SdtSDTRequestAutorizacionPago_Capturetype());
      struct.setOrder(getgxTv_SdtSDTRequestAutorizacionPago_Order().getStruct());
      return struct ;
   }

   protected byte gxTv_SdtSDTRequestAutorizacionPago_N ;
   protected byte gxTv_SdtSDTRequestAutorizacionPago_Order_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTRequestAutorizacionPago_Channel ;
   protected String gxTv_SdtSDTRequestAutorizacionPago_Capturetype ;
   protected com.projectthani.SdtSDTRequestOrder gxTv_SdtSDTRequestAutorizacionPago_Order=null ;
}

