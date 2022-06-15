package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTResponseAutorizacionPago200DataMap extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTResponseAutorizacionPago200DataMap( )
   {
      this(  new ModelContext(SdtSDTResponseAutorizacionPago200DataMap.class));
   }

   public SdtSDTResponseAutorizacionPago200DataMap( ModelContext context )
   {
      super( context, "SdtSDTResponseAutorizacionPago200DataMap");
   }

   public SdtSDTResponseAutorizacionPago200DataMap( int remoteHandle ,
                                                    ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTResponseAutorizacionPago200DataMap");
   }

   public SdtSDTResponseAutorizacionPago200DataMap( StructSdtSDTResponseAutorizacionPago200DataMap struct )
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
               gxTv_SdtSDTResponseAutorizacionPago200DataMap_Currency = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TERMINAL") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200DataMap_Terminal = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TRANSACTION_DATE") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200DataMap_Transaction_date = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ACTION_CODE") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200DataMap_Action_code = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TRACE_NUMBER") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200DataMap_Trace_number = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CARD_TOKEN") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200DataMap_Card_token = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CARD_TYPE") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200DataMap_Card_type = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ECI_DESCRIPTION") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200DataMap_Eci_description = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ECI") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200DataMap_Eci = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SIGNATURE") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200DataMap_Signature = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CARD") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200DataMap_Card = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MERCHANT") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200DataMap_Merchant = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "BRAND") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200DataMap_Brand = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "STATUS") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200DataMap_Status = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "INSTALLMENTS_INFO") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200DataMap_Installments_info = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ACTION_DESCRIPTION") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200DataMap_Action_description = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ADQUIRENTE") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200DataMap_Adquirente = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "QUOTA_AMOUNT") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_amount = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ID_UNICO") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200DataMap_Id_unico = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AMOUNT") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200DataMap_Amount = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PROCCESS_CODE") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200DataMap_Proccess_code = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "QUOTA_NUMBER") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_number = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "VAULT_BLOCK") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200DataMap_Vault_block = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TRANSACTION_ID") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200DataMap_Transaction_id = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AUTHORIZATION_CODE") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200DataMap_Authorization_code = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "QUOTA_DEFERRED") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_deferred = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "QUOTA_NI_PROGRAM") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_program = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "QUOTA_NI_TYPE") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_type = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "QUOTA_NI_AMOUNT") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_amount = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "QUOTA_NI_DISCOUNT") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_discount = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "QUOTA_NI_MESSAGE") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_message = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CVV2_VALIDATION_RESULT") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200DataMap_Cvv2_validation_result = oReader.getValue() ;
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
         sName = "SDTResponseAutorizacionPago200DataMap" ;
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
      oWriter.writeElement("CURRENCY", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago200DataMap_Currency));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("TERMINAL", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago200DataMap_Terminal));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("TRANSACTION_DATE", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago200DataMap_Transaction_date));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ACTION_CODE", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago200DataMap_Action_code));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("TRACE_NUMBER", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago200DataMap_Trace_number));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CARD_TOKEN", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago200DataMap_Card_token));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CARD_TYPE", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago200DataMap_Card_type));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ECI_DESCRIPTION", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago200DataMap_Eci_description));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ECI", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago200DataMap_Eci));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SIGNATURE", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago200DataMap_Signature));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CARD", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago200DataMap_Card));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("MERCHANT", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago200DataMap_Merchant));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("BRAND", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago200DataMap_Brand));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("STATUS", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago200DataMap_Status));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("INSTALLMENTS_INFO", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago200DataMap_Installments_info));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ACTION_DESCRIPTION", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago200DataMap_Action_description));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ADQUIRENTE", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago200DataMap_Adquirente));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("QUOTA_AMOUNT", GXutil.trim( GXutil.strNoRound( gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_amount, 6, 2)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ID_UNICO", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago200DataMap_Id_unico));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("AMOUNT", GXutil.trim( GXutil.strNoRound( gxTv_SdtSDTResponseAutorizacionPago200DataMap_Amount, 6, 2)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PROCCESS_CODE", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago200DataMap_Proccess_code));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("QUOTA_NUMBER", GXutil.trim( GXutil.str( gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_number, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("VAULT_BLOCK", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago200DataMap_Vault_block));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("TRANSACTION_ID", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago200DataMap_Transaction_id));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("AUTHORIZATION_CODE", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago200DataMap_Authorization_code));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("QUOTA_DEFERRED", GXutil.trim( GXutil.str( gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_deferred, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("QUOTA_NI_PROGRAM", GXutil.trim( GXutil.str( gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_program, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("QUOTA_NI_TYPE", GXutil.trim( GXutil.str( gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_type, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("QUOTA_NI_AMOUNT", GXutil.trim( GXutil.strNoRound( gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_amount, 6, 2)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("QUOTA_NI_DISCOUNT", GXutil.trim( GXutil.strNoRound( gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_discount, 6, 2)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("QUOTA_NI_MESSAGE", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_message));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CVV2_VALIDATION_RESULT", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago200DataMap_Cvv2_validation_result));
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
      AddObjectProperty("CURRENCY", gxTv_SdtSDTResponseAutorizacionPago200DataMap_Currency, false, false);
      AddObjectProperty("TERMINAL", gxTv_SdtSDTResponseAutorizacionPago200DataMap_Terminal, false, false);
      AddObjectProperty("TRANSACTION_DATE", gxTv_SdtSDTResponseAutorizacionPago200DataMap_Transaction_date, false, false);
      AddObjectProperty("ACTION_CODE", gxTv_SdtSDTResponseAutorizacionPago200DataMap_Action_code, false, false);
      AddObjectProperty("TRACE_NUMBER", gxTv_SdtSDTResponseAutorizacionPago200DataMap_Trace_number, false, false);
      AddObjectProperty("CARD_TOKEN", gxTv_SdtSDTResponseAutorizacionPago200DataMap_Card_token, false, false);
      AddObjectProperty("CARD_TYPE", gxTv_SdtSDTResponseAutorizacionPago200DataMap_Card_type, false, false);
      AddObjectProperty("ECI_DESCRIPTION", gxTv_SdtSDTResponseAutorizacionPago200DataMap_Eci_description, false, false);
      AddObjectProperty("ECI", gxTv_SdtSDTResponseAutorizacionPago200DataMap_Eci, false, false);
      AddObjectProperty("SIGNATURE", gxTv_SdtSDTResponseAutorizacionPago200DataMap_Signature, false, false);
      AddObjectProperty("CARD", gxTv_SdtSDTResponseAutorizacionPago200DataMap_Card, false, false);
      AddObjectProperty("MERCHANT", gxTv_SdtSDTResponseAutorizacionPago200DataMap_Merchant, false, false);
      AddObjectProperty("BRAND", gxTv_SdtSDTResponseAutorizacionPago200DataMap_Brand, false, false);
      AddObjectProperty("STATUS", gxTv_SdtSDTResponseAutorizacionPago200DataMap_Status, false, false);
      AddObjectProperty("INSTALLMENTS_INFO", gxTv_SdtSDTResponseAutorizacionPago200DataMap_Installments_info, false, false);
      AddObjectProperty("ACTION_DESCRIPTION", gxTv_SdtSDTResponseAutorizacionPago200DataMap_Action_description, false, false);
      AddObjectProperty("ADQUIRENTE", gxTv_SdtSDTResponseAutorizacionPago200DataMap_Adquirente, false, false);
      AddObjectProperty("QUOTA_AMOUNT", gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_amount, false, false);
      AddObjectProperty("ID_UNICO", gxTv_SdtSDTResponseAutorizacionPago200DataMap_Id_unico, false, false);
      AddObjectProperty("AMOUNT", gxTv_SdtSDTResponseAutorizacionPago200DataMap_Amount, false, false);
      AddObjectProperty("PROCCESS_CODE", gxTv_SdtSDTResponseAutorizacionPago200DataMap_Proccess_code, false, false);
      AddObjectProperty("QUOTA_NUMBER", gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_number, false, false);
      AddObjectProperty("VAULT_BLOCK", gxTv_SdtSDTResponseAutorizacionPago200DataMap_Vault_block, false, false);
      AddObjectProperty("TRANSACTION_ID", gxTv_SdtSDTResponseAutorizacionPago200DataMap_Transaction_id, false, false);
      AddObjectProperty("AUTHORIZATION_CODE", gxTv_SdtSDTResponseAutorizacionPago200DataMap_Authorization_code, false, false);
      AddObjectProperty("QUOTA_DEFERRED", gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_deferred, false, false);
      AddObjectProperty("QUOTA_NI_PROGRAM", gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_program, false, false);
      AddObjectProperty("QUOTA_NI_TYPE", gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_type, false, false);
      AddObjectProperty("QUOTA_NI_AMOUNT", gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_amount, false, false);
      AddObjectProperty("QUOTA_NI_DISCOUNT", gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_discount, false, false);
      AddObjectProperty("QUOTA_NI_MESSAGE", gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_message, false, false);
      AddObjectProperty("CVV2_VALIDATION_RESULT", gxTv_SdtSDTResponseAutorizacionPago200DataMap_Cvv2_validation_result, false, false);
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Currency( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200DataMap_Currency ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Currency( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Currency = value ;
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Terminal( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200DataMap_Terminal ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Terminal( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Terminal = value ;
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Transaction_date( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200DataMap_Transaction_date ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Transaction_date( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Transaction_date = value ;
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Action_code( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200DataMap_Action_code ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Action_code( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Action_code = value ;
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Trace_number( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200DataMap_Trace_number ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Trace_number( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Trace_number = value ;
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Card_token( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200DataMap_Card_token ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Card_token( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Card_token = value ;
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Card_type( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200DataMap_Card_type ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Card_type( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Card_type = value ;
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Eci_description( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200DataMap_Eci_description ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Eci_description( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Eci_description = value ;
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Eci( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200DataMap_Eci ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Eci( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Eci = value ;
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Signature( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200DataMap_Signature ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Signature( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Signature = value ;
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Card( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200DataMap_Card ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Card( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Card = value ;
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Merchant( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200DataMap_Merchant ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Merchant( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Merchant = value ;
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Brand( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200DataMap_Brand ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Brand( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Brand = value ;
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Status( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200DataMap_Status ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Status( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Status = value ;
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Installments_info( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200DataMap_Installments_info ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Installments_info( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Installments_info = value ;
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Action_description( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200DataMap_Action_description ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Action_description( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Action_description = value ;
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Adquirente( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200DataMap_Adquirente ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Adquirente( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Adquirente = value ;
   }

   public java.math.BigDecimal getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_amount( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_amount ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_amount( java.math.BigDecimal value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_amount = value ;
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Id_unico( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200DataMap_Id_unico ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Id_unico( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Id_unico = value ;
   }

   public java.math.BigDecimal getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Amount( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200DataMap_Amount ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Amount( java.math.BigDecimal value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Amount = value ;
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Proccess_code( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200DataMap_Proccess_code ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Proccess_code( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Proccess_code = value ;
   }

   public int getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_number( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_number ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_number( int value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_number = value ;
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Vault_block( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200DataMap_Vault_block ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Vault_block( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Vault_block = value ;
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Transaction_id( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200DataMap_Transaction_id ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Transaction_id( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Transaction_id = value ;
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Authorization_code( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200DataMap_Authorization_code ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Authorization_code( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Authorization_code = value ;
   }

   public int getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_deferred( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_deferred ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_deferred( int value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_deferred = value ;
   }

   public int getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_program( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_program ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_program( int value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_program = value ;
   }

   public int getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_type( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_type ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_type( int value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_type = value ;
   }

   public java.math.BigDecimal getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_amount( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_amount ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_amount( java.math.BigDecimal value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_amount = value ;
   }

   public java.math.BigDecimal getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_discount( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_discount ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_discount( java.math.BigDecimal value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_discount = value ;
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_message( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_message ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_message( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_message = value ;
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Cvv2_validation_result( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200DataMap_Cvv2_validation_result ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Cvv2_validation_result( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Cvv2_validation_result = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Currency = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_N = (byte)(1) ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Terminal = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Transaction_date = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Action_code = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Trace_number = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Card_token = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Card_type = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Eci_description = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Eci = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Signature = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Card = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Merchant = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Brand = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Status = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Installments_info = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Action_description = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Adquirente = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_amount = DecimalUtil.ZERO ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Id_unico = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Amount = DecimalUtil.ZERO ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Proccess_code = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Vault_block = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Transaction_id = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Authorization_code = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_amount = DecimalUtil.ZERO ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_discount = DecimalUtil.ZERO ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_message = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200DataMap_Cvv2_validation_result = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200DataMap_N ;
   }

   public com.projectthani.SdtSDTResponseAutorizacionPago200DataMap Clone( )
   {
      return (com.projectthani.SdtSDTResponseAutorizacionPago200DataMap)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTResponseAutorizacionPago200DataMap struct )
   {
      setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Currency(struct.getCurrency());
      setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Terminal(struct.getTerminal());
      setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Transaction_date(struct.getTransaction_date());
      setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Action_code(struct.getAction_code());
      setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Trace_number(struct.getTrace_number());
      setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Card_token(struct.getCard_token());
      setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Card_type(struct.getCard_type());
      setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Eci_description(struct.getEci_description());
      setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Eci(struct.getEci());
      setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Signature(struct.getSignature());
      setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Card(struct.getCard());
      setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Merchant(struct.getMerchant());
      setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Brand(struct.getBrand());
      setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Status(struct.getStatus());
      setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Installments_info(struct.getInstallments_info());
      setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Action_description(struct.getAction_description());
      setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Adquirente(struct.getAdquirente());
      setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_amount(struct.getQuota_amount());
      setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Id_unico(struct.getId_unico());
      setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Amount(struct.getAmount());
      setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Proccess_code(struct.getProccess_code());
      setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_number(struct.getQuota_number());
      setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Vault_block(struct.getVault_block());
      setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Transaction_id(struct.getTransaction_id());
      setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Authorization_code(struct.getAuthorization_code());
      setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_deferred(struct.getQuota_deferred());
      setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_program(struct.getQuota_ni_program());
      setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_type(struct.getQuota_ni_type());
      setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_amount(struct.getQuota_ni_amount());
      setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_discount(struct.getQuota_ni_discount());
      setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_message(struct.getQuota_ni_message());
      setgxTv_SdtSDTResponseAutorizacionPago200DataMap_Cvv2_validation_result(struct.getCvv2_validation_result());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTResponseAutorizacionPago200DataMap getStruct( )
   {
      com.projectthani.StructSdtSDTResponseAutorizacionPago200DataMap struct = new com.projectthani.StructSdtSDTResponseAutorizacionPago200DataMap ();
      struct.setCurrency(getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Currency());
      struct.setTerminal(getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Terminal());
      struct.setTransaction_date(getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Transaction_date());
      struct.setAction_code(getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Action_code());
      struct.setTrace_number(getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Trace_number());
      struct.setCard_token(getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Card_token());
      struct.setCard_type(getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Card_type());
      struct.setEci_description(getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Eci_description());
      struct.setEci(getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Eci());
      struct.setSignature(getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Signature());
      struct.setCard(getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Card());
      struct.setMerchant(getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Merchant());
      struct.setBrand(getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Brand());
      struct.setStatus(getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Status());
      struct.setInstallments_info(getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Installments_info());
      struct.setAction_description(getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Action_description());
      struct.setAdquirente(getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Adquirente());
      struct.setQuota_amount(getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_amount());
      struct.setId_unico(getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Id_unico());
      struct.setAmount(getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Amount());
      struct.setProccess_code(getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Proccess_code());
      struct.setQuota_number(getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_number());
      struct.setVault_block(getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Vault_block());
      struct.setTransaction_id(getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Transaction_id());
      struct.setAuthorization_code(getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Authorization_code());
      struct.setQuota_deferred(getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_deferred());
      struct.setQuota_ni_program(getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_program());
      struct.setQuota_ni_type(getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_type());
      struct.setQuota_ni_amount(getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_amount());
      struct.setQuota_ni_discount(getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_discount());
      struct.setQuota_ni_message(getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_message());
      struct.setCvv2_validation_result(getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Cvv2_validation_result());
      return struct ;
   }

   protected byte gxTv_SdtSDTResponseAutorizacionPago200DataMap_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_number ;
   protected int gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_deferred ;
   protected int gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_program ;
   protected int gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_type ;
   protected java.math.BigDecimal gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_amount ;
   protected java.math.BigDecimal gxTv_SdtSDTResponseAutorizacionPago200DataMap_Amount ;
   protected java.math.BigDecimal gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_amount ;
   protected java.math.BigDecimal gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_discount ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200DataMap_Cvv2_validation_result ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200DataMap_Currency ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200DataMap_Terminal ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200DataMap_Transaction_date ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200DataMap_Action_code ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200DataMap_Trace_number ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200DataMap_Card_token ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200DataMap_Card_type ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200DataMap_Eci_description ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200DataMap_Eci ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200DataMap_Signature ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200DataMap_Card ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200DataMap_Merchant ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200DataMap_Brand ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200DataMap_Status ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200DataMap_Installments_info ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200DataMap_Action_description ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200DataMap_Adquirente ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200DataMap_Id_unico ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200DataMap_Proccess_code ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200DataMap_Vault_block ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200DataMap_Transaction_id ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200DataMap_Authorization_code ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200DataMap_Quota_ni_message ;
}

