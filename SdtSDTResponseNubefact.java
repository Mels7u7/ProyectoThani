package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTResponseNubefact extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTResponseNubefact( )
   {
      this(  new ModelContext(SdtSDTResponseNubefact.class));
   }

   public SdtSDTResponseNubefact( ModelContext context )
   {
      super( context, "SdtSDTResponseNubefact");
   }

   public SdtSDTResponseNubefact( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTResponseNubefact");
   }

   public SdtSDTResponseNubefact( StructSdtSDTResponseNubefact struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "tipo_de_comprobante") )
            {
               gxTv_SdtSDTResponseNubefact_Tipo_de_comprobante = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "serie") )
            {
               gxTv_SdtSDTResponseNubefact_Serie = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "numero") )
            {
               gxTv_SdtSDTResponseNubefact_Numero = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "enlace") )
            {
               gxTv_SdtSDTResponseNubefact_Enlace = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "aceptada_por_sunat") )
            {
               gxTv_SdtSDTResponseNubefact_Aceptada_por_sunat = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "sunat_soap_error") )
            {
               gxTv_SdtSDTResponseNubefact_Sunat_soap_error = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "cadena_para_codigo_qr") )
            {
               gxTv_SdtSDTResponseNubefact_Cadena_para_codigo_qr = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "codigo_hash") )
            {
               gxTv_SdtSDTResponseNubefact_Codigo_hash = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "codigo_de_barras") )
            {
               gxTv_SdtSDTResponseNubefact_Codigo_de_barras = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "key") )
            {
               gxTv_SdtSDTResponseNubefact_Key = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "digest_value") )
            {
               gxTv_SdtSDTResponseNubefact_Digest_value = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "enlace_del_pdf") )
            {
               gxTv_SdtSDTResponseNubefact_Enlace_del_pdf = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "enlace_del_xml") )
            {
               gxTv_SdtSDTResponseNubefact_Enlace_del_xml = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "invoice") )
            {
               if ( gxTv_SdtSDTResponseNubefact_Invoice == null )
               {
                  gxTv_SdtSDTResponseNubefact_Invoice = new com.projectthani.SdtSDTResponseNubefact_invoice(remoteHandle, context);
               }
               GXSoapError = gxTv_SdtSDTResponseNubefact_Invoice.readxml(oReader, "invoice") ;
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
         sName = "SDTResponseNubefact" ;
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
      oWriter.writeElement("tipo_de_comprobante", GXutil.trim( GXutil.strNoRound( gxTv_SdtSDTResponseNubefact_Tipo_de_comprobante, 10, 5)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("serie", GXutil.rtrim( gxTv_SdtSDTResponseNubefact_Serie));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("numero", GXutil.trim( GXutil.strNoRound( gxTv_SdtSDTResponseNubefact_Numero, 10, 5)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("enlace", GXutil.rtrim( gxTv_SdtSDTResponseNubefact_Enlace));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("aceptada_por_sunat", GXutil.rtrim( GXutil.booltostr( gxTv_SdtSDTResponseNubefact_Aceptada_por_sunat)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("sunat_soap_error", GXutil.rtrim( gxTv_SdtSDTResponseNubefact_Sunat_soap_error));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("cadena_para_codigo_qr", GXutil.rtrim( gxTv_SdtSDTResponseNubefact_Cadena_para_codigo_qr));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("codigo_hash", GXutil.rtrim( gxTv_SdtSDTResponseNubefact_Codigo_hash));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("codigo_de_barras", GXutil.rtrim( gxTv_SdtSDTResponseNubefact_Codigo_de_barras));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("key", GXutil.rtrim( gxTv_SdtSDTResponseNubefact_Key));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("digest_value", GXutil.rtrim( gxTv_SdtSDTResponseNubefact_Digest_value));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("enlace_del_pdf", GXutil.rtrim( gxTv_SdtSDTResponseNubefact_Enlace_del_pdf));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("enlace_del_xml", GXutil.rtrim( gxTv_SdtSDTResponseNubefact_Enlace_del_xml));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( gxTv_SdtSDTResponseNubefact_Invoice != null )
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
         gxTv_SdtSDTResponseNubefact_Invoice.writexml(oWriter, "invoice", sNameSpace1);
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
      AddObjectProperty("tipo_de_comprobante", gxTv_SdtSDTResponseNubefact_Tipo_de_comprobante, false, false);
      AddObjectProperty("serie", gxTv_SdtSDTResponseNubefact_Serie, false, false);
      AddObjectProperty("numero", gxTv_SdtSDTResponseNubefact_Numero, false, false);
      AddObjectProperty("enlace", gxTv_SdtSDTResponseNubefact_Enlace, false, false);
      AddObjectProperty("aceptada_por_sunat", gxTv_SdtSDTResponseNubefact_Aceptada_por_sunat, false, false);
      AddObjectProperty("sunat_soap_error", gxTv_SdtSDTResponseNubefact_Sunat_soap_error, false, false);
      AddObjectProperty("cadena_para_codigo_qr", gxTv_SdtSDTResponseNubefact_Cadena_para_codigo_qr, false, false);
      AddObjectProperty("codigo_hash", gxTv_SdtSDTResponseNubefact_Codigo_hash, false, false);
      AddObjectProperty("codigo_de_barras", gxTv_SdtSDTResponseNubefact_Codigo_de_barras, false, false);
      AddObjectProperty("key", gxTv_SdtSDTResponseNubefact_Key, false, false);
      AddObjectProperty("digest_value", gxTv_SdtSDTResponseNubefact_Digest_value, false, false);
      AddObjectProperty("enlace_del_pdf", gxTv_SdtSDTResponseNubefact_Enlace_del_pdf, false, false);
      AddObjectProperty("enlace_del_xml", gxTv_SdtSDTResponseNubefact_Enlace_del_xml, false, false);
      if ( gxTv_SdtSDTResponseNubefact_Invoice != null )
      {
         AddObjectProperty("invoice", gxTv_SdtSDTResponseNubefact_Invoice, false, false);
      }
   }

   public java.math.BigDecimal getgxTv_SdtSDTResponseNubefact_Tipo_de_comprobante( )
   {
      return gxTv_SdtSDTResponseNubefact_Tipo_de_comprobante ;
   }

   public void setgxTv_SdtSDTResponseNubefact_Tipo_de_comprobante( java.math.BigDecimal value )
   {
      gxTv_SdtSDTResponseNubefact_N = (byte)(0) ;
      gxTv_SdtSDTResponseNubefact_Tipo_de_comprobante = value ;
   }

   public String getgxTv_SdtSDTResponseNubefact_Serie( )
   {
      return gxTv_SdtSDTResponseNubefact_Serie ;
   }

   public void setgxTv_SdtSDTResponseNubefact_Serie( String value )
   {
      gxTv_SdtSDTResponseNubefact_N = (byte)(0) ;
      gxTv_SdtSDTResponseNubefact_Serie = value ;
   }

   public java.math.BigDecimal getgxTv_SdtSDTResponseNubefact_Numero( )
   {
      return gxTv_SdtSDTResponseNubefact_Numero ;
   }

   public void setgxTv_SdtSDTResponseNubefact_Numero( java.math.BigDecimal value )
   {
      gxTv_SdtSDTResponseNubefact_N = (byte)(0) ;
      gxTv_SdtSDTResponseNubefact_Numero = value ;
   }

   public String getgxTv_SdtSDTResponseNubefact_Enlace( )
   {
      return gxTv_SdtSDTResponseNubefact_Enlace ;
   }

   public void setgxTv_SdtSDTResponseNubefact_Enlace( String value )
   {
      gxTv_SdtSDTResponseNubefact_N = (byte)(0) ;
      gxTv_SdtSDTResponseNubefact_Enlace = value ;
   }

   public boolean getgxTv_SdtSDTResponseNubefact_Aceptada_por_sunat( )
   {
      return gxTv_SdtSDTResponseNubefact_Aceptada_por_sunat ;
   }

   public void setgxTv_SdtSDTResponseNubefact_Aceptada_por_sunat( boolean value )
   {
      gxTv_SdtSDTResponseNubefact_N = (byte)(0) ;
      gxTv_SdtSDTResponseNubefact_Aceptada_por_sunat = value ;
   }

   public String getgxTv_SdtSDTResponseNubefact_Sunat_soap_error( )
   {
      return gxTv_SdtSDTResponseNubefact_Sunat_soap_error ;
   }

   public void setgxTv_SdtSDTResponseNubefact_Sunat_soap_error( String value )
   {
      gxTv_SdtSDTResponseNubefact_N = (byte)(0) ;
      gxTv_SdtSDTResponseNubefact_Sunat_soap_error = value ;
   }

   public String getgxTv_SdtSDTResponseNubefact_Cadena_para_codigo_qr( )
   {
      return gxTv_SdtSDTResponseNubefact_Cadena_para_codigo_qr ;
   }

   public void setgxTv_SdtSDTResponseNubefact_Cadena_para_codigo_qr( String value )
   {
      gxTv_SdtSDTResponseNubefact_N = (byte)(0) ;
      gxTv_SdtSDTResponseNubefact_Cadena_para_codigo_qr = value ;
   }

   public String getgxTv_SdtSDTResponseNubefact_Codigo_hash( )
   {
      return gxTv_SdtSDTResponseNubefact_Codigo_hash ;
   }

   public void setgxTv_SdtSDTResponseNubefact_Codigo_hash( String value )
   {
      gxTv_SdtSDTResponseNubefact_N = (byte)(0) ;
      gxTv_SdtSDTResponseNubefact_Codigo_hash = value ;
   }

   public String getgxTv_SdtSDTResponseNubefact_Codigo_de_barras( )
   {
      return gxTv_SdtSDTResponseNubefact_Codigo_de_barras ;
   }

   public void setgxTv_SdtSDTResponseNubefact_Codigo_de_barras( String value )
   {
      gxTv_SdtSDTResponseNubefact_N = (byte)(0) ;
      gxTv_SdtSDTResponseNubefact_Codigo_de_barras = value ;
   }

   public String getgxTv_SdtSDTResponseNubefact_Key( )
   {
      return gxTv_SdtSDTResponseNubefact_Key ;
   }

   public void setgxTv_SdtSDTResponseNubefact_Key( String value )
   {
      gxTv_SdtSDTResponseNubefact_N = (byte)(0) ;
      gxTv_SdtSDTResponseNubefact_Key = value ;
   }

   public String getgxTv_SdtSDTResponseNubefact_Digest_value( )
   {
      return gxTv_SdtSDTResponseNubefact_Digest_value ;
   }

   public void setgxTv_SdtSDTResponseNubefact_Digest_value( String value )
   {
      gxTv_SdtSDTResponseNubefact_N = (byte)(0) ;
      gxTv_SdtSDTResponseNubefact_Digest_value = value ;
   }

   public String getgxTv_SdtSDTResponseNubefact_Enlace_del_pdf( )
   {
      return gxTv_SdtSDTResponseNubefact_Enlace_del_pdf ;
   }

   public void setgxTv_SdtSDTResponseNubefact_Enlace_del_pdf( String value )
   {
      gxTv_SdtSDTResponseNubefact_N = (byte)(0) ;
      gxTv_SdtSDTResponseNubefact_Enlace_del_pdf = value ;
   }

   public String getgxTv_SdtSDTResponseNubefact_Enlace_del_xml( )
   {
      return gxTv_SdtSDTResponseNubefact_Enlace_del_xml ;
   }

   public void setgxTv_SdtSDTResponseNubefact_Enlace_del_xml( String value )
   {
      gxTv_SdtSDTResponseNubefact_N = (byte)(0) ;
      gxTv_SdtSDTResponseNubefact_Enlace_del_xml = value ;
   }

   public com.projectthani.SdtSDTResponseNubefact_invoice getgxTv_SdtSDTResponseNubefact_Invoice( )
   {
      if ( gxTv_SdtSDTResponseNubefact_Invoice == null )
      {
         gxTv_SdtSDTResponseNubefact_Invoice = new com.projectthani.SdtSDTResponseNubefact_invoice(remoteHandle, context);
      }
      gxTv_SdtSDTResponseNubefact_Invoice_N = (byte)(0) ;
      gxTv_SdtSDTResponseNubefact_N = (byte)(0) ;
      return gxTv_SdtSDTResponseNubefact_Invoice ;
   }

   public void setgxTv_SdtSDTResponseNubefact_Invoice( com.projectthani.SdtSDTResponseNubefact_invoice value )
   {
      gxTv_SdtSDTResponseNubefact_Invoice_N = (byte)(0) ;
      gxTv_SdtSDTResponseNubefact_N = (byte)(0) ;
      gxTv_SdtSDTResponseNubefact_Invoice = value;
   }

   public void setgxTv_SdtSDTResponseNubefact_Invoice_SetNull( )
   {
      gxTv_SdtSDTResponseNubefact_Invoice_N = (byte)(1) ;
      gxTv_SdtSDTResponseNubefact_Invoice = (com.projectthani.SdtSDTResponseNubefact_invoice)null;
   }

   public boolean getgxTv_SdtSDTResponseNubefact_Invoice_IsNull( )
   {
      if ( gxTv_SdtSDTResponseNubefact_Invoice == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtSDTResponseNubefact_Invoice_N( )
   {
      return gxTv_SdtSDTResponseNubefact_Invoice_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTResponseNubefact_Tipo_de_comprobante = DecimalUtil.ZERO ;
      gxTv_SdtSDTResponseNubefact_N = (byte)(1) ;
      gxTv_SdtSDTResponseNubefact_Serie = "" ;
      gxTv_SdtSDTResponseNubefact_Numero = DecimalUtil.ZERO ;
      gxTv_SdtSDTResponseNubefact_Enlace = "" ;
      gxTv_SdtSDTResponseNubefact_Sunat_soap_error = "" ;
      gxTv_SdtSDTResponseNubefact_Cadena_para_codigo_qr = "" ;
      gxTv_SdtSDTResponseNubefact_Codigo_hash = "" ;
      gxTv_SdtSDTResponseNubefact_Codigo_de_barras = "" ;
      gxTv_SdtSDTResponseNubefact_Key = "" ;
      gxTv_SdtSDTResponseNubefact_Digest_value = "" ;
      gxTv_SdtSDTResponseNubefact_Enlace_del_pdf = "" ;
      gxTv_SdtSDTResponseNubefact_Enlace_del_xml = "" ;
      gxTv_SdtSDTResponseNubefact_Invoice_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTResponseNubefact_N ;
   }

   public com.projectthani.SdtSDTResponseNubefact Clone( )
   {
      return (com.projectthani.SdtSDTResponseNubefact)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTResponseNubefact struct )
   {
      setgxTv_SdtSDTResponseNubefact_Tipo_de_comprobante(struct.getTipo_de_comprobante());
      setgxTv_SdtSDTResponseNubefact_Serie(struct.getSerie());
      setgxTv_SdtSDTResponseNubefact_Numero(struct.getNumero());
      setgxTv_SdtSDTResponseNubefact_Enlace(struct.getEnlace());
      setgxTv_SdtSDTResponseNubefact_Aceptada_por_sunat(struct.getAceptada_por_sunat());
      setgxTv_SdtSDTResponseNubefact_Sunat_soap_error(struct.getSunat_soap_error());
      setgxTv_SdtSDTResponseNubefact_Cadena_para_codigo_qr(struct.getCadena_para_codigo_qr());
      setgxTv_SdtSDTResponseNubefact_Codigo_hash(struct.getCodigo_hash());
      setgxTv_SdtSDTResponseNubefact_Codigo_de_barras(struct.getCodigo_de_barras());
      setgxTv_SdtSDTResponseNubefact_Key(struct.getKey());
      setgxTv_SdtSDTResponseNubefact_Digest_value(struct.getDigest_value());
      setgxTv_SdtSDTResponseNubefact_Enlace_del_pdf(struct.getEnlace_del_pdf());
      setgxTv_SdtSDTResponseNubefact_Enlace_del_xml(struct.getEnlace_del_xml());
      setgxTv_SdtSDTResponseNubefact_Invoice(new com.projectthani.SdtSDTResponseNubefact_invoice(struct.getInvoice()));
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTResponseNubefact getStruct( )
   {
      com.projectthani.StructSdtSDTResponseNubefact struct = new com.projectthani.StructSdtSDTResponseNubefact ();
      struct.setTipo_de_comprobante(getgxTv_SdtSDTResponseNubefact_Tipo_de_comprobante());
      struct.setSerie(getgxTv_SdtSDTResponseNubefact_Serie());
      struct.setNumero(getgxTv_SdtSDTResponseNubefact_Numero());
      struct.setEnlace(getgxTv_SdtSDTResponseNubefact_Enlace());
      struct.setAceptada_por_sunat(getgxTv_SdtSDTResponseNubefact_Aceptada_por_sunat());
      struct.setSunat_soap_error(getgxTv_SdtSDTResponseNubefact_Sunat_soap_error());
      struct.setCadena_para_codigo_qr(getgxTv_SdtSDTResponseNubefact_Cadena_para_codigo_qr());
      struct.setCodigo_hash(getgxTv_SdtSDTResponseNubefact_Codigo_hash());
      struct.setCodigo_de_barras(getgxTv_SdtSDTResponseNubefact_Codigo_de_barras());
      struct.setKey(getgxTv_SdtSDTResponseNubefact_Key());
      struct.setDigest_value(getgxTv_SdtSDTResponseNubefact_Digest_value());
      struct.setEnlace_del_pdf(getgxTv_SdtSDTResponseNubefact_Enlace_del_pdf());
      struct.setEnlace_del_xml(getgxTv_SdtSDTResponseNubefact_Enlace_del_xml());
      struct.setInvoice(getgxTv_SdtSDTResponseNubefact_Invoice().getStruct());
      return struct ;
   }

   protected byte gxTv_SdtSDTResponseNubefact_N ;
   protected byte gxTv_SdtSDTResponseNubefact_Invoice_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_SdtSDTResponseNubefact_Tipo_de_comprobante ;
   protected java.math.BigDecimal gxTv_SdtSDTResponseNubefact_Numero ;
   protected String sTagName ;
   protected boolean gxTv_SdtSDTResponseNubefact_Aceptada_por_sunat ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTResponseNubefact_Serie ;
   protected String gxTv_SdtSDTResponseNubefact_Enlace ;
   protected String gxTv_SdtSDTResponseNubefact_Sunat_soap_error ;
   protected String gxTv_SdtSDTResponseNubefact_Cadena_para_codigo_qr ;
   protected String gxTv_SdtSDTResponseNubefact_Codigo_hash ;
   protected String gxTv_SdtSDTResponseNubefact_Codigo_de_barras ;
   protected String gxTv_SdtSDTResponseNubefact_Key ;
   protected String gxTv_SdtSDTResponseNubefact_Digest_value ;
   protected String gxTv_SdtSDTResponseNubefact_Enlace_del_pdf ;
   protected String gxTv_SdtSDTResponseNubefact_Enlace_del_xml ;
   protected com.projectthani.SdtSDTResponseNubefact_invoice gxTv_SdtSDTResponseNubefact_Invoice=null ;
}

