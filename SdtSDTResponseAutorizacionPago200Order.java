package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTResponseAutorizacionPago200Order extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTResponseAutorizacionPago200Order( )
   {
      this(  new ModelContext(SdtSDTResponseAutorizacionPago200Order.class));
   }

   public SdtSDTResponseAutorizacionPago200Order( ModelContext context )
   {
      super( context, "SdtSDTResponseAutorizacionPago200Order");
   }

   public SdtSDTResponseAutorizacionPago200Order( int remoteHandle ,
                                                  ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTResponseAutorizacionPago200Order");
   }

   public SdtSDTResponseAutorizacionPago200Order( StructSdtSDTResponseAutorizacionPago200Order struct )
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
               gxTv_SdtSDTResponseAutorizacionPago200Order_Tokenid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "purchaseNumber") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200Order_Purchasenumber = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "amount") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200Order_Amount = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "installment") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200Order_Installment = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "currency") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200Order_Currency = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "authorizedAmount") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200Order_Authorizedamount = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "authorizationCode") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200Order_Authorizationcode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "actionCode") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200Order_Actioncode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "traceNumber") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200Order_Tracenumber = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "transactionDate") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200Order_Transactiondate = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "transactionId") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200Order_Transactionid = oReader.getValue() ;
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
         sName = "SDTResponseAutorizacionPago200Order" ;
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
      oWriter.writeElement("tokenId", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago200Order_Tokenid));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("purchaseNumber", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago200Order_Purchasenumber));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("amount", GXutil.trim( GXutil.strNoRound( gxTv_SdtSDTResponseAutorizacionPago200Order_Amount, 6, 2)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("installment", GXutil.trim( GXutil.str( gxTv_SdtSDTResponseAutorizacionPago200Order_Installment, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("currency", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago200Order_Currency));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("authorizedAmount", GXutil.trim( GXutil.strNoRound( gxTv_SdtSDTResponseAutorizacionPago200Order_Authorizedamount, 6, 2)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("authorizationCode", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago200Order_Authorizationcode));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("actionCode", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago200Order_Actioncode));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("traceNumber", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago200Order_Tracenumber));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("transactionDate", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago200Order_Transactiondate));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("transactionId", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago200Order_Transactionid));
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
      AddObjectProperty("tokenId", gxTv_SdtSDTResponseAutorizacionPago200Order_Tokenid, false, false);
      AddObjectProperty("purchaseNumber", gxTv_SdtSDTResponseAutorizacionPago200Order_Purchasenumber, false, false);
      AddObjectProperty("amount", gxTv_SdtSDTResponseAutorizacionPago200Order_Amount, false, false);
      AddObjectProperty("installment", gxTv_SdtSDTResponseAutorizacionPago200Order_Installment, false, false);
      AddObjectProperty("currency", gxTv_SdtSDTResponseAutorizacionPago200Order_Currency, false, false);
      AddObjectProperty("authorizedAmount", gxTv_SdtSDTResponseAutorizacionPago200Order_Authorizedamount, false, false);
      AddObjectProperty("authorizationCode", gxTv_SdtSDTResponseAutorizacionPago200Order_Authorizationcode, false, false);
      AddObjectProperty("actionCode", gxTv_SdtSDTResponseAutorizacionPago200Order_Actioncode, false, false);
      AddObjectProperty("traceNumber", gxTv_SdtSDTResponseAutorizacionPago200Order_Tracenumber, false, false);
      AddObjectProperty("transactionDate", gxTv_SdtSDTResponseAutorizacionPago200Order_Transactiondate, false, false);
      AddObjectProperty("transactionId", gxTv_SdtSDTResponseAutorizacionPago200Order_Transactionid, false, false);
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago200Order_Tokenid( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Order_Tokenid ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200Order_Tokenid( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Order_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Order_Tokenid = value ;
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago200Order_Purchasenumber( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Order_Purchasenumber ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200Order_Purchasenumber( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Order_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Order_Purchasenumber = value ;
   }

   public java.math.BigDecimal getgxTv_SdtSDTResponseAutorizacionPago200Order_Amount( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Order_Amount ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200Order_Amount( java.math.BigDecimal value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Order_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Order_Amount = value ;
   }

   public int getgxTv_SdtSDTResponseAutorizacionPago200Order_Installment( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Order_Installment ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200Order_Installment( int value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Order_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Order_Installment = value ;
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago200Order_Currency( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Order_Currency ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200Order_Currency( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Order_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Order_Currency = value ;
   }

   public java.math.BigDecimal getgxTv_SdtSDTResponseAutorizacionPago200Order_Authorizedamount( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Order_Authorizedamount ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200Order_Authorizedamount( java.math.BigDecimal value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Order_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Order_Authorizedamount = value ;
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago200Order_Authorizationcode( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Order_Authorizationcode ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200Order_Authorizationcode( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Order_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Order_Authorizationcode = value ;
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago200Order_Actioncode( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Order_Actioncode ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200Order_Actioncode( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Order_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Order_Actioncode = value ;
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago200Order_Tracenumber( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Order_Tracenumber ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200Order_Tracenumber( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Order_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Order_Tracenumber = value ;
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago200Order_Transactiondate( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Order_Transactiondate ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200Order_Transactiondate( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Order_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Order_Transactiondate = value ;
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago200Order_Transactionid( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Order_Transactionid ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200Order_Transactionid( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Order_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Order_Transactionid = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Order_Tokenid = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200Order_N = (byte)(1) ;
      gxTv_SdtSDTResponseAutorizacionPago200Order_Purchasenumber = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200Order_Amount = DecimalUtil.ZERO ;
      gxTv_SdtSDTResponseAutorizacionPago200Order_Currency = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200Order_Authorizedamount = DecimalUtil.ZERO ;
      gxTv_SdtSDTResponseAutorizacionPago200Order_Authorizationcode = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200Order_Actioncode = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200Order_Tracenumber = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200Order_Transactiondate = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200Order_Transactionid = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Order_N ;
   }

   public com.projectthani.SdtSDTResponseAutorizacionPago200Order Clone( )
   {
      return (com.projectthani.SdtSDTResponseAutorizacionPago200Order)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTResponseAutorizacionPago200Order struct )
   {
      setgxTv_SdtSDTResponseAutorizacionPago200Order_Tokenid(struct.getTokenid());
      setgxTv_SdtSDTResponseAutorizacionPago200Order_Purchasenumber(struct.getPurchasenumber());
      setgxTv_SdtSDTResponseAutorizacionPago200Order_Amount(struct.getAmount());
      setgxTv_SdtSDTResponseAutorizacionPago200Order_Installment(struct.getInstallment());
      setgxTv_SdtSDTResponseAutorizacionPago200Order_Currency(struct.getCurrency());
      setgxTv_SdtSDTResponseAutorizacionPago200Order_Authorizedamount(struct.getAuthorizedamount());
      setgxTv_SdtSDTResponseAutorizacionPago200Order_Authorizationcode(struct.getAuthorizationcode());
      setgxTv_SdtSDTResponseAutorizacionPago200Order_Actioncode(struct.getActioncode());
      setgxTv_SdtSDTResponseAutorizacionPago200Order_Tracenumber(struct.getTracenumber());
      setgxTv_SdtSDTResponseAutorizacionPago200Order_Transactiondate(struct.getTransactiondate());
      setgxTv_SdtSDTResponseAutorizacionPago200Order_Transactionid(struct.getTransactionid());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTResponseAutorizacionPago200Order getStruct( )
   {
      com.projectthani.StructSdtSDTResponseAutorizacionPago200Order struct = new com.projectthani.StructSdtSDTResponseAutorizacionPago200Order ();
      struct.setTokenid(getgxTv_SdtSDTResponseAutorizacionPago200Order_Tokenid());
      struct.setPurchasenumber(getgxTv_SdtSDTResponseAutorizacionPago200Order_Purchasenumber());
      struct.setAmount(getgxTv_SdtSDTResponseAutorizacionPago200Order_Amount());
      struct.setInstallment(getgxTv_SdtSDTResponseAutorizacionPago200Order_Installment());
      struct.setCurrency(getgxTv_SdtSDTResponseAutorizacionPago200Order_Currency());
      struct.setAuthorizedamount(getgxTv_SdtSDTResponseAutorizacionPago200Order_Authorizedamount());
      struct.setAuthorizationcode(getgxTv_SdtSDTResponseAutorizacionPago200Order_Authorizationcode());
      struct.setActioncode(getgxTv_SdtSDTResponseAutorizacionPago200Order_Actioncode());
      struct.setTracenumber(getgxTv_SdtSDTResponseAutorizacionPago200Order_Tracenumber());
      struct.setTransactiondate(getgxTv_SdtSDTResponseAutorizacionPago200Order_Transactiondate());
      struct.setTransactionid(getgxTv_SdtSDTResponseAutorizacionPago200Order_Transactionid());
      return struct ;
   }

   protected byte gxTv_SdtSDTResponseAutorizacionPago200Order_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_SdtSDTResponseAutorizacionPago200Order_Installment ;
   protected java.math.BigDecimal gxTv_SdtSDTResponseAutorizacionPago200Order_Amount ;
   protected java.math.BigDecimal gxTv_SdtSDTResponseAutorizacionPago200Order_Authorizedamount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200Order_Tokenid ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200Order_Purchasenumber ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200Order_Currency ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200Order_Authorizationcode ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200Order_Actioncode ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200Order_Tracenumber ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200Order_Transactiondate ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200Order_Transactionid ;
}

