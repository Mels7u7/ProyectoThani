package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTRequestOrder extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTRequestOrder( )
   {
      this(  new ModelContext(SdtSDTRequestOrder.class));
   }

   public SdtSDTRequestOrder( ModelContext context )
   {
      super( context, "SdtSDTRequestOrder");
   }

   public SdtSDTRequestOrder( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTRequestOrder");
   }

   public SdtSDTRequestOrder( StructSdtSDTRequestOrder struct )
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
               gxTv_SdtSDTRequestOrder_Tokenid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "purchaseNumber") )
            {
               gxTv_SdtSDTRequestOrder_Purchasenumber = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "amount") )
            {
               gxTv_SdtSDTRequestOrder_Amount = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "currency") )
            {
               gxTv_SdtSDTRequestOrder_Currency = oReader.getValue() ;
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
         sName = "SDTRequestOrder" ;
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
      oWriter.writeElement("tokenId", GXutil.rtrim( gxTv_SdtSDTRequestOrder_Tokenid));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("purchaseNumber", GXutil.rtrim( gxTv_SdtSDTRequestOrder_Purchasenumber));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("amount", GXutil.trim( GXutil.strNoRound( gxTv_SdtSDTRequestOrder_Amount, 6, 2)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("currency", GXutil.rtrim( gxTv_SdtSDTRequestOrder_Currency));
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
      AddObjectProperty("tokenId", gxTv_SdtSDTRequestOrder_Tokenid, false, false);
      AddObjectProperty("purchaseNumber", gxTv_SdtSDTRequestOrder_Purchasenumber, false, false);
      AddObjectProperty("amount", gxTv_SdtSDTRequestOrder_Amount, false, false);
      AddObjectProperty("currency", gxTv_SdtSDTRequestOrder_Currency, false, false);
   }

   public String getgxTv_SdtSDTRequestOrder_Tokenid( )
   {
      return gxTv_SdtSDTRequestOrder_Tokenid ;
   }

   public void setgxTv_SdtSDTRequestOrder_Tokenid( String value )
   {
      gxTv_SdtSDTRequestOrder_N = (byte)(0) ;
      gxTv_SdtSDTRequestOrder_Tokenid = value ;
   }

   public String getgxTv_SdtSDTRequestOrder_Purchasenumber( )
   {
      return gxTv_SdtSDTRequestOrder_Purchasenumber ;
   }

   public void setgxTv_SdtSDTRequestOrder_Purchasenumber( String value )
   {
      gxTv_SdtSDTRequestOrder_N = (byte)(0) ;
      gxTv_SdtSDTRequestOrder_Purchasenumber = value ;
   }

   public java.math.BigDecimal getgxTv_SdtSDTRequestOrder_Amount( )
   {
      return gxTv_SdtSDTRequestOrder_Amount ;
   }

   public void setgxTv_SdtSDTRequestOrder_Amount( java.math.BigDecimal value )
   {
      gxTv_SdtSDTRequestOrder_N = (byte)(0) ;
      gxTv_SdtSDTRequestOrder_Amount = value ;
   }

   public String getgxTv_SdtSDTRequestOrder_Currency( )
   {
      return gxTv_SdtSDTRequestOrder_Currency ;
   }

   public void setgxTv_SdtSDTRequestOrder_Currency( String value )
   {
      gxTv_SdtSDTRequestOrder_N = (byte)(0) ;
      gxTv_SdtSDTRequestOrder_Currency = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTRequestOrder_Tokenid = "" ;
      gxTv_SdtSDTRequestOrder_N = (byte)(1) ;
      gxTv_SdtSDTRequestOrder_Purchasenumber = "" ;
      gxTv_SdtSDTRequestOrder_Amount = DecimalUtil.ZERO ;
      gxTv_SdtSDTRequestOrder_Currency = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTRequestOrder_N ;
   }

   public com.projectthani.SdtSDTRequestOrder Clone( )
   {
      return (com.projectthani.SdtSDTRequestOrder)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTRequestOrder struct )
   {
      setgxTv_SdtSDTRequestOrder_Tokenid(struct.getTokenid());
      setgxTv_SdtSDTRequestOrder_Purchasenumber(struct.getPurchasenumber());
      setgxTv_SdtSDTRequestOrder_Amount(struct.getAmount());
      setgxTv_SdtSDTRequestOrder_Currency(struct.getCurrency());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTRequestOrder getStruct( )
   {
      com.projectthani.StructSdtSDTRequestOrder struct = new com.projectthani.StructSdtSDTRequestOrder ();
      struct.setTokenid(getgxTv_SdtSDTRequestOrder_Tokenid());
      struct.setPurchasenumber(getgxTv_SdtSDTRequestOrder_Purchasenumber());
      struct.setAmount(getgxTv_SdtSDTRequestOrder_Amount());
      struct.setCurrency(getgxTv_SdtSDTRequestOrder_Currency());
      return struct ;
   }

   protected byte gxTv_SdtSDTRequestOrder_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_SdtSDTRequestOrder_Amount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTRequestOrder_Tokenid ;
   protected String gxTv_SdtSDTRequestOrder_Purchasenumber ;
   protected String gxTv_SdtSDTRequestOrder_Currency ;
}

