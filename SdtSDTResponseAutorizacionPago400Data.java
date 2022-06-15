package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTResponseAutorizacionPago400Data extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTResponseAutorizacionPago400Data( )
   {
      this(  new ModelContext(SdtSDTResponseAutorizacionPago400Data.class));
   }

   public SdtSDTResponseAutorizacionPago400Data( ModelContext context )
   {
      super( context, "SdtSDTResponseAutorizacionPago400Data");
   }

   public SdtSDTResponseAutorizacionPago400Data( int remoteHandle ,
                                                 ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTResponseAutorizacionPago400Data");
   }

   public SdtSDTResponseAutorizacionPago400Data( StructSdtSDTResponseAutorizacionPago400Data struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "CURRENCY") )
            {
               gxTv_SdtSDTResponseAutorizacionPago400Data_Currency = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AMOUNT") )
            {
               gxTv_SdtSDTResponseAutorizacionPago400Data_Amount = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MERCHANT") )
            {
               gxTv_SdtSDTResponseAutorizacionPago400Data_Merchant = oReader.getValue() ;
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
         sName = "SDTResponseAutorizacionPago400Data" ;
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
      oWriter.writeElement("CURRENCY", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago400Data_Currency));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("AMOUNT", GXutil.trim( GXutil.strNoRound( gxTv_SdtSDTResponseAutorizacionPago400Data_Amount, 6, 2)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("MERCHANT", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago400Data_Merchant));
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
      AddObjectProperty("CURRENCY", gxTv_SdtSDTResponseAutorizacionPago400Data_Currency, false, false);
      AddObjectProperty("AMOUNT", gxTv_SdtSDTResponseAutorizacionPago400Data_Amount, false, false);
      AddObjectProperty("MERCHANT", gxTv_SdtSDTResponseAutorizacionPago400Data_Merchant, false, false);
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago400Data_Currency( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago400Data_Currency ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago400Data_Currency( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago400Data_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago400Data_Currency = value ;
   }

   public java.math.BigDecimal getgxTv_SdtSDTResponseAutorizacionPago400Data_Amount( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago400Data_Amount ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago400Data_Amount( java.math.BigDecimal value )
   {
      gxTv_SdtSDTResponseAutorizacionPago400Data_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago400Data_Amount = value ;
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago400Data_Merchant( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago400Data_Merchant ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago400Data_Merchant( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago400Data_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago400Data_Merchant = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTResponseAutorizacionPago400Data_Currency = "" ;
      gxTv_SdtSDTResponseAutorizacionPago400Data_N = (byte)(1) ;
      gxTv_SdtSDTResponseAutorizacionPago400Data_Amount = DecimalUtil.ZERO ;
      gxTv_SdtSDTResponseAutorizacionPago400Data_Merchant = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago400Data_N ;
   }

   public com.projectthani.SdtSDTResponseAutorizacionPago400Data Clone( )
   {
      return (com.projectthani.SdtSDTResponseAutorizacionPago400Data)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTResponseAutorizacionPago400Data struct )
   {
      setgxTv_SdtSDTResponseAutorizacionPago400Data_Currency(struct.getCurrency());
      setgxTv_SdtSDTResponseAutorizacionPago400Data_Amount(struct.getAmount());
      setgxTv_SdtSDTResponseAutorizacionPago400Data_Merchant(struct.getMerchant());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTResponseAutorizacionPago400Data getStruct( )
   {
      com.projectthani.StructSdtSDTResponseAutorizacionPago400Data struct = new com.projectthani.StructSdtSDTResponseAutorizacionPago400Data ();
      struct.setCurrency(getgxTv_SdtSDTResponseAutorizacionPago400Data_Currency());
      struct.setAmount(getgxTv_SdtSDTResponseAutorizacionPago400Data_Amount());
      struct.setMerchant(getgxTv_SdtSDTResponseAutorizacionPago400Data_Merchant());
      return struct ;
   }

   protected byte gxTv_SdtSDTResponseAutorizacionPago400Data_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_SdtSDTResponseAutorizacionPago400Data_Amount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTResponseAutorizacionPago400Data_Currency ;
   protected String gxTv_SdtSDTResponseAutorizacionPago400Data_Merchant ;
}

