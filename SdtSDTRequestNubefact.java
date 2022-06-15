package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTRequestNubefact extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTRequestNubefact( )
   {
      this(  new ModelContext(SdtSDTRequestNubefact.class));
   }

   public SdtSDTRequestNubefact( ModelContext context )
   {
      super( context, "SdtSDTRequestNubefact");
   }

   public SdtSDTRequestNubefact( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTRequestNubefact");
   }

   public SdtSDTRequestNubefact( StructSdtSDTRequestNubefact struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "operacion") )
            {
               gxTv_SdtSDTRequestNubefact_Operacion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "tipo_de_comprobante") )
            {
               gxTv_SdtSDTRequestNubefact_Tipo_de_comprobante = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "serie") )
            {
               gxTv_SdtSDTRequestNubefact_Serie = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "numero") )
            {
               gxTv_SdtSDTRequestNubefact_Numero = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "sunat_transaction") )
            {
               gxTv_SdtSDTRequestNubefact_Sunat_transaction = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "cliente_tipo_de_documento") )
            {
               gxTv_SdtSDTRequestNubefact_Cliente_tipo_de_documento = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "cliente_numero_de_documento") )
            {
               gxTv_SdtSDTRequestNubefact_Cliente_numero_de_documento = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "cliente_denominacion") )
            {
               gxTv_SdtSDTRequestNubefact_Cliente_denominacion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "cliente_direccion") )
            {
               gxTv_SdtSDTRequestNubefact_Cliente_direccion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "cliente_email") )
            {
               gxTv_SdtSDTRequestNubefact_Cliente_email = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "cliente_email_1") )
            {
               gxTv_SdtSDTRequestNubefact_Cliente_email_1 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "cliente_email_2") )
            {
               gxTv_SdtSDTRequestNubefact_Cliente_email_2 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "fecha_de_emision") )
            {
               gxTv_SdtSDTRequestNubefact_Fecha_de_emision = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "fecha_de_vencimiento") )
            {
               gxTv_SdtSDTRequestNubefact_Fecha_de_vencimiento = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "moneda") )
            {
               gxTv_SdtSDTRequestNubefact_Moneda = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "tipo_de_cambio") )
            {
               gxTv_SdtSDTRequestNubefact_Tipo_de_cambio = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "porcentaje_de_igv") )
            {
               gxTv_SdtSDTRequestNubefact_Porcentaje_de_igv = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "descuento_global") )
            {
               gxTv_SdtSDTRequestNubefact_Descuento_global = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "total_descuento") )
            {
               gxTv_SdtSDTRequestNubefact_Total_descuento = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "total_anticipo") )
            {
               gxTv_SdtSDTRequestNubefact_Total_anticipo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "total_gravada") )
            {
               gxTv_SdtSDTRequestNubefact_Total_gravada = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "total_inafecta") )
            {
               gxTv_SdtSDTRequestNubefact_Total_inafecta = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "total_exonerada") )
            {
               gxTv_SdtSDTRequestNubefact_Total_exonerada = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "total_igv") )
            {
               gxTv_SdtSDTRequestNubefact_Total_igv = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "total_gratuita") )
            {
               gxTv_SdtSDTRequestNubefact_Total_gratuita = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "total_otros_cargos") )
            {
               gxTv_SdtSDTRequestNubefact_Total_otros_cargos = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "total") )
            {
               gxTv_SdtSDTRequestNubefact_Total = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "percepcion_tipo") )
            {
               gxTv_SdtSDTRequestNubefact_Percepcion_tipo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "percepcion_base_imponible") )
            {
               gxTv_SdtSDTRequestNubefact_Percepcion_base_imponible = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "total_percepcion") )
            {
               gxTv_SdtSDTRequestNubefact_Total_percepcion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "total_incluido_percepcion") )
            {
               gxTv_SdtSDTRequestNubefact_Total_incluido_percepcion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "total_impuestos_bolsas") )
            {
               gxTv_SdtSDTRequestNubefact_Total_impuestos_bolsas = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "detraccion") )
            {
               gxTv_SdtSDTRequestNubefact_Detraccion = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "observaciones") )
            {
               gxTv_SdtSDTRequestNubefact_Observaciones = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "documento_que_se_modifica_tipo") )
            {
               gxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_tipo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "documento_que_se_modifica_serie") )
            {
               gxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_serie = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "documento_que_se_modifica_numero") )
            {
               gxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_numero = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "tipo_de_nota_de_credito") )
            {
               gxTv_SdtSDTRequestNubefact_Tipo_de_nota_de_credito = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "tipo_de_nota_de_debito") )
            {
               gxTv_SdtSDTRequestNubefact_Tipo_de_nota_de_debito = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "enviar_automaticamente_a_la_sunat") )
            {
               gxTv_SdtSDTRequestNubefact_Enviar_automaticamente_a_la_sunat = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "enviar_automaticamente_al_cliente") )
            {
               gxTv_SdtSDTRequestNubefact_Enviar_automaticamente_al_cliente = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "condiciones_de_pago") )
            {
               gxTv_SdtSDTRequestNubefact_Condiciones_de_pago = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "medio_de_pago") )
            {
               gxTv_SdtSDTRequestNubefact_Medio_de_pago = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "placa_vehiculo") )
            {
               gxTv_SdtSDTRequestNubefact_Placa_vehiculo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "orden_compra_servicio") )
            {
               gxTv_SdtSDTRequestNubefact_Orden_compra_servicio = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "formato_de_pdf") )
            {
               gxTv_SdtSDTRequestNubefact_Formato_de_pdf = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "generado_por_contingencia") )
            {
               gxTv_SdtSDTRequestNubefact_Generado_por_contingencia = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "bienes_region_selva") )
            {
               gxTv_SdtSDTRequestNubefact_Bienes_region_selva = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "servicios_region_selva") )
            {
               gxTv_SdtSDTRequestNubefact_Servicios_region_selva = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "items") )
            {
               if ( gxTv_SdtSDTRequestNubefact_Items == null )
               {
                  gxTv_SdtSDTRequestNubefact_Items = new GXBaseCollection<com.projectthani.SdtSDTRequestNubefact_itemsItem>(com.projectthani.SdtSDTRequestNubefact_itemsItem.class, "SDTRequestNubefact.itemsItem", "ProjectThani", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_SdtSDTRequestNubefact_Items.readxmlcollection(oReader, "items", "itemsItem") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "items") )
               {
                  GXSoapError = oReader.read() ;
               }
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
         sName = "SDTRequestNubefact" ;
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
      oWriter.writeElement("operacion", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_Operacion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("tipo_de_comprobante", GXutil.trim( GXutil.strNoRound( gxTv_SdtSDTRequestNubefact_Tipo_de_comprobante, 10, 5)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("serie", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_Serie));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("numero", GXutil.trim( GXutil.strNoRound( gxTv_SdtSDTRequestNubefact_Numero, 10, 5)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("sunat_transaction", GXutil.trim( GXutil.strNoRound( gxTv_SdtSDTRequestNubefact_Sunat_transaction, 10, 5)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("cliente_tipo_de_documento", GXutil.trim( GXutil.strNoRound( gxTv_SdtSDTRequestNubefact_Cliente_tipo_de_documento, 10, 5)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("cliente_numero_de_documento", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_Cliente_numero_de_documento));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("cliente_denominacion", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_Cliente_denominacion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("cliente_direccion", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_Cliente_direccion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("cliente_email", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_Cliente_email));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("cliente_email_1", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_Cliente_email_1));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("cliente_email_2", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_Cliente_email_2));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("fecha_de_emision", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_Fecha_de_emision));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("fecha_de_vencimiento", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_Fecha_de_vencimiento));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("moneda", GXutil.trim( GXutil.strNoRound( gxTv_SdtSDTRequestNubefact_Moneda, 10, 5)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("tipo_de_cambio", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_Tipo_de_cambio));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("porcentaje_de_igv", GXutil.trim( GXutil.strNoRound( gxTv_SdtSDTRequestNubefact_Porcentaje_de_igv, 10, 5)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("descuento_global", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_Descuento_global));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("total_descuento", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_Total_descuento));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("total_anticipo", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_Total_anticipo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("total_gravada", GXutil.trim( GXutil.strNoRound( gxTv_SdtSDTRequestNubefact_Total_gravada, 10, 5)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("total_inafecta", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_Total_inafecta));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("total_exonerada", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_Total_exonerada));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("total_igv", GXutil.trim( GXutil.strNoRound( gxTv_SdtSDTRequestNubefact_Total_igv, 10, 5)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("total_gratuita", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_Total_gratuita));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("total_otros_cargos", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_Total_otros_cargos));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("total", GXutil.trim( GXutil.strNoRound( gxTv_SdtSDTRequestNubefact_Total, 10, 5)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("percepcion_tipo", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_Percepcion_tipo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("percepcion_base_imponible", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_Percepcion_base_imponible));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("total_percepcion", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_Total_percepcion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("total_incluido_percepcion", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_Total_incluido_percepcion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("total_impuestos_bolsas", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_Total_impuestos_bolsas));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("detraccion", GXutil.rtrim( GXutil.booltostr( gxTv_SdtSDTRequestNubefact_Detraccion)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("observaciones", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_Observaciones));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("documento_que_se_modifica_tipo", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_tipo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("documento_que_se_modifica_serie", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_serie));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("documento_que_se_modifica_numero", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_numero));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("tipo_de_nota_de_credito", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_Tipo_de_nota_de_credito));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("tipo_de_nota_de_debito", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_Tipo_de_nota_de_debito));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("enviar_automaticamente_a_la_sunat", GXutil.rtrim( GXutil.booltostr( gxTv_SdtSDTRequestNubefact_Enviar_automaticamente_a_la_sunat)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("enviar_automaticamente_al_cliente", GXutil.rtrim( GXutil.booltostr( gxTv_SdtSDTRequestNubefact_Enviar_automaticamente_al_cliente)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("condiciones_de_pago", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_Condiciones_de_pago));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("medio_de_pago", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_Medio_de_pago));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("placa_vehiculo", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_Placa_vehiculo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("orden_compra_servicio", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_Orden_compra_servicio));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("formato_de_pdf", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_Formato_de_pdf));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("generado_por_contingencia", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_Generado_por_contingencia));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("bienes_region_selva", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_Bienes_region_selva));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("servicios_region_selva", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_Servicios_region_selva));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( gxTv_SdtSDTRequestNubefact_Items != null )
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
         gxTv_SdtSDTRequestNubefact_Items.writexmlcollection(oWriter, "items", sNameSpace1, "itemsItem", sNameSpace1);
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
      AddObjectProperty("operacion", gxTv_SdtSDTRequestNubefact_Operacion, false, false);
      AddObjectProperty("tipo_de_comprobante", gxTv_SdtSDTRequestNubefact_Tipo_de_comprobante, false, false);
      AddObjectProperty("serie", gxTv_SdtSDTRequestNubefact_Serie, false, false);
      AddObjectProperty("numero", gxTv_SdtSDTRequestNubefact_Numero, false, false);
      AddObjectProperty("sunat_transaction", gxTv_SdtSDTRequestNubefact_Sunat_transaction, false, false);
      AddObjectProperty("cliente_tipo_de_documento", gxTv_SdtSDTRequestNubefact_Cliente_tipo_de_documento, false, false);
      AddObjectProperty("cliente_numero_de_documento", gxTv_SdtSDTRequestNubefact_Cliente_numero_de_documento, false, false);
      AddObjectProperty("cliente_denominacion", gxTv_SdtSDTRequestNubefact_Cliente_denominacion, false, false);
      AddObjectProperty("cliente_direccion", gxTv_SdtSDTRequestNubefact_Cliente_direccion, false, false);
      AddObjectProperty("cliente_email", gxTv_SdtSDTRequestNubefact_Cliente_email, false, false);
      AddObjectProperty("cliente_email_1", gxTv_SdtSDTRequestNubefact_Cliente_email_1, false, false);
      AddObjectProperty("cliente_email_2", gxTv_SdtSDTRequestNubefact_Cliente_email_2, false, false);
      AddObjectProperty("fecha_de_emision", gxTv_SdtSDTRequestNubefact_Fecha_de_emision, false, false);
      AddObjectProperty("fecha_de_vencimiento", gxTv_SdtSDTRequestNubefact_Fecha_de_vencimiento, false, false);
      AddObjectProperty("moneda", gxTv_SdtSDTRequestNubefact_Moneda, false, false);
      AddObjectProperty("tipo_de_cambio", gxTv_SdtSDTRequestNubefact_Tipo_de_cambio, false, false);
      AddObjectProperty("porcentaje_de_igv", gxTv_SdtSDTRequestNubefact_Porcentaje_de_igv, false, false);
      AddObjectProperty("descuento_global", gxTv_SdtSDTRequestNubefact_Descuento_global, false, false);
      AddObjectProperty("total_descuento", gxTv_SdtSDTRequestNubefact_Total_descuento, false, false);
      AddObjectProperty("total_anticipo", gxTv_SdtSDTRequestNubefact_Total_anticipo, false, false);
      AddObjectProperty("total_gravada", gxTv_SdtSDTRequestNubefact_Total_gravada, false, false);
      AddObjectProperty("total_inafecta", gxTv_SdtSDTRequestNubefact_Total_inafecta, false, false);
      AddObjectProperty("total_exonerada", gxTv_SdtSDTRequestNubefact_Total_exonerada, false, false);
      AddObjectProperty("total_igv", gxTv_SdtSDTRequestNubefact_Total_igv, false, false);
      AddObjectProperty("total_gratuita", gxTv_SdtSDTRequestNubefact_Total_gratuita, false, false);
      AddObjectProperty("total_otros_cargos", gxTv_SdtSDTRequestNubefact_Total_otros_cargos, false, false);
      AddObjectProperty("total", gxTv_SdtSDTRequestNubefact_Total, false, false);
      AddObjectProperty("percepcion_tipo", gxTv_SdtSDTRequestNubefact_Percepcion_tipo, false, false);
      AddObjectProperty("percepcion_base_imponible", gxTv_SdtSDTRequestNubefact_Percepcion_base_imponible, false, false);
      AddObjectProperty("total_percepcion", gxTv_SdtSDTRequestNubefact_Total_percepcion, false, false);
      AddObjectProperty("total_incluido_percepcion", gxTv_SdtSDTRequestNubefact_Total_incluido_percepcion, false, false);
      AddObjectProperty("total_impuestos_bolsas", gxTv_SdtSDTRequestNubefact_Total_impuestos_bolsas, false, false);
      AddObjectProperty("detraccion", gxTv_SdtSDTRequestNubefact_Detraccion, false, false);
      AddObjectProperty("observaciones", gxTv_SdtSDTRequestNubefact_Observaciones, false, false);
      AddObjectProperty("documento_que_se_modifica_tipo", gxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_tipo, false, false);
      AddObjectProperty("documento_que_se_modifica_serie", gxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_serie, false, false);
      AddObjectProperty("documento_que_se_modifica_numero", gxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_numero, false, false);
      AddObjectProperty("tipo_de_nota_de_credito", gxTv_SdtSDTRequestNubefact_Tipo_de_nota_de_credito, false, false);
      AddObjectProperty("tipo_de_nota_de_debito", gxTv_SdtSDTRequestNubefact_Tipo_de_nota_de_debito, false, false);
      AddObjectProperty("enviar_automaticamente_a_la_sunat", gxTv_SdtSDTRequestNubefact_Enviar_automaticamente_a_la_sunat, false, false);
      AddObjectProperty("enviar_automaticamente_al_cliente", gxTv_SdtSDTRequestNubefact_Enviar_automaticamente_al_cliente, false, false);
      AddObjectProperty("condiciones_de_pago", gxTv_SdtSDTRequestNubefact_Condiciones_de_pago, false, false);
      AddObjectProperty("medio_de_pago", gxTv_SdtSDTRequestNubefact_Medio_de_pago, false, false);
      AddObjectProperty("placa_vehiculo", gxTv_SdtSDTRequestNubefact_Placa_vehiculo, false, false);
      AddObjectProperty("orden_compra_servicio", gxTv_SdtSDTRequestNubefact_Orden_compra_servicio, false, false);
      AddObjectProperty("formato_de_pdf", gxTv_SdtSDTRequestNubefact_Formato_de_pdf, false, false);
      AddObjectProperty("generado_por_contingencia", gxTv_SdtSDTRequestNubefact_Generado_por_contingencia, false, false);
      AddObjectProperty("bienes_region_selva", gxTv_SdtSDTRequestNubefact_Bienes_region_selva, false, false);
      AddObjectProperty("servicios_region_selva", gxTv_SdtSDTRequestNubefact_Servicios_region_selva, false, false);
      if ( gxTv_SdtSDTRequestNubefact_Items != null )
      {
         AddObjectProperty("items", gxTv_SdtSDTRequestNubefact_Items, false, false);
      }
   }

   public String getgxTv_SdtSDTRequestNubefact_Operacion( )
   {
      return gxTv_SdtSDTRequestNubefact_Operacion ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Operacion( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Operacion = value ;
   }

   public java.math.BigDecimal getgxTv_SdtSDTRequestNubefact_Tipo_de_comprobante( )
   {
      return gxTv_SdtSDTRequestNubefact_Tipo_de_comprobante ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Tipo_de_comprobante( java.math.BigDecimal value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Tipo_de_comprobante = value ;
   }

   public String getgxTv_SdtSDTRequestNubefact_Serie( )
   {
      return gxTv_SdtSDTRequestNubefact_Serie ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Serie( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Serie = value ;
   }

   public java.math.BigDecimal getgxTv_SdtSDTRequestNubefact_Numero( )
   {
      return gxTv_SdtSDTRequestNubefact_Numero ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Numero( java.math.BigDecimal value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Numero = value ;
   }

   public java.math.BigDecimal getgxTv_SdtSDTRequestNubefact_Sunat_transaction( )
   {
      return gxTv_SdtSDTRequestNubefact_Sunat_transaction ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Sunat_transaction( java.math.BigDecimal value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Sunat_transaction = value ;
   }

   public java.math.BigDecimal getgxTv_SdtSDTRequestNubefact_Cliente_tipo_de_documento( )
   {
      return gxTv_SdtSDTRequestNubefact_Cliente_tipo_de_documento ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Cliente_tipo_de_documento( java.math.BigDecimal value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Cliente_tipo_de_documento = value ;
   }

   public String getgxTv_SdtSDTRequestNubefact_Cliente_numero_de_documento( )
   {
      return gxTv_SdtSDTRequestNubefact_Cliente_numero_de_documento ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Cliente_numero_de_documento( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Cliente_numero_de_documento = value ;
   }

   public String getgxTv_SdtSDTRequestNubefact_Cliente_denominacion( )
   {
      return gxTv_SdtSDTRequestNubefact_Cliente_denominacion ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Cliente_denominacion( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Cliente_denominacion = value ;
   }

   public String getgxTv_SdtSDTRequestNubefact_Cliente_direccion( )
   {
      return gxTv_SdtSDTRequestNubefact_Cliente_direccion ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Cliente_direccion( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Cliente_direccion = value ;
   }

   public String getgxTv_SdtSDTRequestNubefact_Cliente_email( )
   {
      return gxTv_SdtSDTRequestNubefact_Cliente_email ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Cliente_email( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Cliente_email = value ;
   }

   public String getgxTv_SdtSDTRequestNubefact_Cliente_email_1( )
   {
      return gxTv_SdtSDTRequestNubefact_Cliente_email_1 ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Cliente_email_1( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Cliente_email_1 = value ;
   }

   public String getgxTv_SdtSDTRequestNubefact_Cliente_email_2( )
   {
      return gxTv_SdtSDTRequestNubefact_Cliente_email_2 ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Cliente_email_2( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Cliente_email_2 = value ;
   }

   public String getgxTv_SdtSDTRequestNubefact_Fecha_de_emision( )
   {
      return gxTv_SdtSDTRequestNubefact_Fecha_de_emision ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Fecha_de_emision( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Fecha_de_emision = value ;
   }

   public String getgxTv_SdtSDTRequestNubefact_Fecha_de_vencimiento( )
   {
      return gxTv_SdtSDTRequestNubefact_Fecha_de_vencimiento ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Fecha_de_vencimiento( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Fecha_de_vencimiento = value ;
   }

   public java.math.BigDecimal getgxTv_SdtSDTRequestNubefact_Moneda( )
   {
      return gxTv_SdtSDTRequestNubefact_Moneda ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Moneda( java.math.BigDecimal value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Moneda = value ;
   }

   public String getgxTv_SdtSDTRequestNubefact_Tipo_de_cambio( )
   {
      return gxTv_SdtSDTRequestNubefact_Tipo_de_cambio ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Tipo_de_cambio( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Tipo_de_cambio = value ;
   }

   public java.math.BigDecimal getgxTv_SdtSDTRequestNubefact_Porcentaje_de_igv( )
   {
      return gxTv_SdtSDTRequestNubefact_Porcentaje_de_igv ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Porcentaje_de_igv( java.math.BigDecimal value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Porcentaje_de_igv = value ;
   }

   public String getgxTv_SdtSDTRequestNubefact_Descuento_global( )
   {
      return gxTv_SdtSDTRequestNubefact_Descuento_global ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Descuento_global( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Descuento_global = value ;
   }

   public String getgxTv_SdtSDTRequestNubefact_Total_descuento( )
   {
      return gxTv_SdtSDTRequestNubefact_Total_descuento ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Total_descuento( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Total_descuento = value ;
   }

   public String getgxTv_SdtSDTRequestNubefact_Total_anticipo( )
   {
      return gxTv_SdtSDTRequestNubefact_Total_anticipo ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Total_anticipo( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Total_anticipo = value ;
   }

   public java.math.BigDecimal getgxTv_SdtSDTRequestNubefact_Total_gravada( )
   {
      return gxTv_SdtSDTRequestNubefact_Total_gravada ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Total_gravada( java.math.BigDecimal value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Total_gravada = value ;
   }

   public String getgxTv_SdtSDTRequestNubefact_Total_inafecta( )
   {
      return gxTv_SdtSDTRequestNubefact_Total_inafecta ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Total_inafecta( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Total_inafecta = value ;
   }

   public String getgxTv_SdtSDTRequestNubefact_Total_exonerada( )
   {
      return gxTv_SdtSDTRequestNubefact_Total_exonerada ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Total_exonerada( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Total_exonerada = value ;
   }

   public java.math.BigDecimal getgxTv_SdtSDTRequestNubefact_Total_igv( )
   {
      return gxTv_SdtSDTRequestNubefact_Total_igv ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Total_igv( java.math.BigDecimal value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Total_igv = value ;
   }

   public String getgxTv_SdtSDTRequestNubefact_Total_gratuita( )
   {
      return gxTv_SdtSDTRequestNubefact_Total_gratuita ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Total_gratuita( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Total_gratuita = value ;
   }

   public String getgxTv_SdtSDTRequestNubefact_Total_otros_cargos( )
   {
      return gxTv_SdtSDTRequestNubefact_Total_otros_cargos ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Total_otros_cargos( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Total_otros_cargos = value ;
   }

   public java.math.BigDecimal getgxTv_SdtSDTRequestNubefact_Total( )
   {
      return gxTv_SdtSDTRequestNubefact_Total ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Total( java.math.BigDecimal value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Total = value ;
   }

   public String getgxTv_SdtSDTRequestNubefact_Percepcion_tipo( )
   {
      return gxTv_SdtSDTRequestNubefact_Percepcion_tipo ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Percepcion_tipo( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Percepcion_tipo = value ;
   }

   public String getgxTv_SdtSDTRequestNubefact_Percepcion_base_imponible( )
   {
      return gxTv_SdtSDTRequestNubefact_Percepcion_base_imponible ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Percepcion_base_imponible( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Percepcion_base_imponible = value ;
   }

   public String getgxTv_SdtSDTRequestNubefact_Total_percepcion( )
   {
      return gxTv_SdtSDTRequestNubefact_Total_percepcion ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Total_percepcion( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Total_percepcion = value ;
   }

   public String getgxTv_SdtSDTRequestNubefact_Total_incluido_percepcion( )
   {
      return gxTv_SdtSDTRequestNubefact_Total_incluido_percepcion ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Total_incluido_percepcion( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Total_incluido_percepcion = value ;
   }

   public String getgxTv_SdtSDTRequestNubefact_Total_impuestos_bolsas( )
   {
      return gxTv_SdtSDTRequestNubefact_Total_impuestos_bolsas ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Total_impuestos_bolsas( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Total_impuestos_bolsas = value ;
   }

   public boolean getgxTv_SdtSDTRequestNubefact_Detraccion( )
   {
      return gxTv_SdtSDTRequestNubefact_Detraccion ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Detraccion( boolean value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Detraccion = value ;
   }

   public String getgxTv_SdtSDTRequestNubefact_Observaciones( )
   {
      return gxTv_SdtSDTRequestNubefact_Observaciones ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Observaciones( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Observaciones = value ;
   }

   public String getgxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_tipo( )
   {
      return gxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_tipo ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_tipo( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_tipo = value ;
   }

   public String getgxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_serie( )
   {
      return gxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_serie ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_serie( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_serie = value ;
   }

   public String getgxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_numero( )
   {
      return gxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_numero ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_numero( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_numero = value ;
   }

   public String getgxTv_SdtSDTRequestNubefact_Tipo_de_nota_de_credito( )
   {
      return gxTv_SdtSDTRequestNubefact_Tipo_de_nota_de_credito ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Tipo_de_nota_de_credito( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Tipo_de_nota_de_credito = value ;
   }

   public String getgxTv_SdtSDTRequestNubefact_Tipo_de_nota_de_debito( )
   {
      return gxTv_SdtSDTRequestNubefact_Tipo_de_nota_de_debito ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Tipo_de_nota_de_debito( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Tipo_de_nota_de_debito = value ;
   }

   public boolean getgxTv_SdtSDTRequestNubefact_Enviar_automaticamente_a_la_sunat( )
   {
      return gxTv_SdtSDTRequestNubefact_Enviar_automaticamente_a_la_sunat ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Enviar_automaticamente_a_la_sunat( boolean value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Enviar_automaticamente_a_la_sunat = value ;
   }

   public boolean getgxTv_SdtSDTRequestNubefact_Enviar_automaticamente_al_cliente( )
   {
      return gxTv_SdtSDTRequestNubefact_Enviar_automaticamente_al_cliente ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Enviar_automaticamente_al_cliente( boolean value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Enviar_automaticamente_al_cliente = value ;
   }

   public String getgxTv_SdtSDTRequestNubefact_Condiciones_de_pago( )
   {
      return gxTv_SdtSDTRequestNubefact_Condiciones_de_pago ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Condiciones_de_pago( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Condiciones_de_pago = value ;
   }

   public String getgxTv_SdtSDTRequestNubefact_Medio_de_pago( )
   {
      return gxTv_SdtSDTRequestNubefact_Medio_de_pago ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Medio_de_pago( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Medio_de_pago = value ;
   }

   public String getgxTv_SdtSDTRequestNubefact_Placa_vehiculo( )
   {
      return gxTv_SdtSDTRequestNubefact_Placa_vehiculo ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Placa_vehiculo( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Placa_vehiculo = value ;
   }

   public String getgxTv_SdtSDTRequestNubefact_Orden_compra_servicio( )
   {
      return gxTv_SdtSDTRequestNubefact_Orden_compra_servicio ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Orden_compra_servicio( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Orden_compra_servicio = value ;
   }

   public String getgxTv_SdtSDTRequestNubefact_Formato_de_pdf( )
   {
      return gxTv_SdtSDTRequestNubefact_Formato_de_pdf ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Formato_de_pdf( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Formato_de_pdf = value ;
   }

   public String getgxTv_SdtSDTRequestNubefact_Generado_por_contingencia( )
   {
      return gxTv_SdtSDTRequestNubefact_Generado_por_contingencia ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Generado_por_contingencia( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Generado_por_contingencia = value ;
   }

   public String getgxTv_SdtSDTRequestNubefact_Bienes_region_selva( )
   {
      return gxTv_SdtSDTRequestNubefact_Bienes_region_selva ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Bienes_region_selva( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Bienes_region_selva = value ;
   }

   public String getgxTv_SdtSDTRequestNubefact_Servicios_region_selva( )
   {
      return gxTv_SdtSDTRequestNubefact_Servicios_region_selva ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Servicios_region_selva( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Servicios_region_selva = value ;
   }

   public GXBaseCollection<com.projectthani.SdtSDTRequestNubefact_itemsItem> getgxTv_SdtSDTRequestNubefact_Items( )
   {
      if ( gxTv_SdtSDTRequestNubefact_Items == null )
      {
         gxTv_SdtSDTRequestNubefact_Items = new GXBaseCollection<com.projectthani.SdtSDTRequestNubefact_itemsItem>(com.projectthani.SdtSDTRequestNubefact_itemsItem.class, "SDTRequestNubefact.itemsItem", "ProjectThani", remoteHandle);
      }
      gxTv_SdtSDTRequestNubefact_Items_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      return gxTv_SdtSDTRequestNubefact_Items ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Items( GXBaseCollection<com.projectthani.SdtSDTRequestNubefact_itemsItem> value )
   {
      gxTv_SdtSDTRequestNubefact_Items_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Items = value ;
   }

   public void setgxTv_SdtSDTRequestNubefact_Items_SetNull( )
   {
      gxTv_SdtSDTRequestNubefact_Items_N = (byte)(1) ;
      gxTv_SdtSDTRequestNubefact_Items = null ;
   }

   public boolean getgxTv_SdtSDTRequestNubefact_Items_IsNull( )
   {
      if ( gxTv_SdtSDTRequestNubefact_Items == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtSDTRequestNubefact_Items_N( )
   {
      return gxTv_SdtSDTRequestNubefact_Items_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTRequestNubefact_Operacion = "" ;
      gxTv_SdtSDTRequestNubefact_N = (byte)(1) ;
      gxTv_SdtSDTRequestNubefact_Tipo_de_comprobante = DecimalUtil.ZERO ;
      gxTv_SdtSDTRequestNubefact_Serie = "" ;
      gxTv_SdtSDTRequestNubefact_Numero = DecimalUtil.ZERO ;
      gxTv_SdtSDTRequestNubefact_Sunat_transaction = DecimalUtil.ZERO ;
      gxTv_SdtSDTRequestNubefact_Cliente_tipo_de_documento = DecimalUtil.ZERO ;
      gxTv_SdtSDTRequestNubefact_Cliente_numero_de_documento = "" ;
      gxTv_SdtSDTRequestNubefact_Cliente_denominacion = "" ;
      gxTv_SdtSDTRequestNubefact_Cliente_direccion = "" ;
      gxTv_SdtSDTRequestNubefact_Cliente_email = "" ;
      gxTv_SdtSDTRequestNubefact_Cliente_email_1 = "" ;
      gxTv_SdtSDTRequestNubefact_Cliente_email_2 = "" ;
      gxTv_SdtSDTRequestNubefact_Fecha_de_emision = "" ;
      gxTv_SdtSDTRequestNubefact_Fecha_de_vencimiento = "" ;
      gxTv_SdtSDTRequestNubefact_Moneda = DecimalUtil.ZERO ;
      gxTv_SdtSDTRequestNubefact_Tipo_de_cambio = "" ;
      gxTv_SdtSDTRequestNubefact_Porcentaje_de_igv = DecimalUtil.ZERO ;
      gxTv_SdtSDTRequestNubefact_Descuento_global = "" ;
      gxTv_SdtSDTRequestNubefact_Total_descuento = "" ;
      gxTv_SdtSDTRequestNubefact_Total_anticipo = "" ;
      gxTv_SdtSDTRequestNubefact_Total_gravada = DecimalUtil.ZERO ;
      gxTv_SdtSDTRequestNubefact_Total_inafecta = "" ;
      gxTv_SdtSDTRequestNubefact_Total_exonerada = "" ;
      gxTv_SdtSDTRequestNubefact_Total_igv = DecimalUtil.ZERO ;
      gxTv_SdtSDTRequestNubefact_Total_gratuita = "" ;
      gxTv_SdtSDTRequestNubefact_Total_otros_cargos = "" ;
      gxTv_SdtSDTRequestNubefact_Total = DecimalUtil.ZERO ;
      gxTv_SdtSDTRequestNubefact_Percepcion_tipo = "" ;
      gxTv_SdtSDTRequestNubefact_Percepcion_base_imponible = "" ;
      gxTv_SdtSDTRequestNubefact_Total_percepcion = "" ;
      gxTv_SdtSDTRequestNubefact_Total_incluido_percepcion = "" ;
      gxTv_SdtSDTRequestNubefact_Total_impuestos_bolsas = "" ;
      gxTv_SdtSDTRequestNubefact_Observaciones = "" ;
      gxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_tipo = "" ;
      gxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_serie = "" ;
      gxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_numero = "" ;
      gxTv_SdtSDTRequestNubefact_Tipo_de_nota_de_credito = "" ;
      gxTv_SdtSDTRequestNubefact_Tipo_de_nota_de_debito = "" ;
      gxTv_SdtSDTRequestNubefact_Condiciones_de_pago = "" ;
      gxTv_SdtSDTRequestNubefact_Medio_de_pago = "" ;
      gxTv_SdtSDTRequestNubefact_Placa_vehiculo = "" ;
      gxTv_SdtSDTRequestNubefact_Orden_compra_servicio = "" ;
      gxTv_SdtSDTRequestNubefact_Formato_de_pdf = "" ;
      gxTv_SdtSDTRequestNubefact_Generado_por_contingencia = "" ;
      gxTv_SdtSDTRequestNubefact_Bienes_region_selva = "" ;
      gxTv_SdtSDTRequestNubefact_Servicios_region_selva = "" ;
      gxTv_SdtSDTRequestNubefact_Items_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTRequestNubefact_N ;
   }

   public com.projectthani.SdtSDTRequestNubefact Clone( )
   {
      return (com.projectthani.SdtSDTRequestNubefact)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTRequestNubefact struct )
   {
      setgxTv_SdtSDTRequestNubefact_Operacion(struct.getOperacion());
      setgxTv_SdtSDTRequestNubefact_Tipo_de_comprobante(struct.getTipo_de_comprobante());
      setgxTv_SdtSDTRequestNubefact_Serie(struct.getSerie());
      setgxTv_SdtSDTRequestNubefact_Numero(struct.getNumero());
      setgxTv_SdtSDTRequestNubefact_Sunat_transaction(struct.getSunat_transaction());
      setgxTv_SdtSDTRequestNubefact_Cliente_tipo_de_documento(struct.getCliente_tipo_de_documento());
      setgxTv_SdtSDTRequestNubefact_Cliente_numero_de_documento(struct.getCliente_numero_de_documento());
      setgxTv_SdtSDTRequestNubefact_Cliente_denominacion(struct.getCliente_denominacion());
      setgxTv_SdtSDTRequestNubefact_Cliente_direccion(struct.getCliente_direccion());
      setgxTv_SdtSDTRequestNubefact_Cliente_email(struct.getCliente_email());
      setgxTv_SdtSDTRequestNubefact_Cliente_email_1(struct.getCliente_email_1());
      setgxTv_SdtSDTRequestNubefact_Cliente_email_2(struct.getCliente_email_2());
      setgxTv_SdtSDTRequestNubefact_Fecha_de_emision(struct.getFecha_de_emision());
      setgxTv_SdtSDTRequestNubefact_Fecha_de_vencimiento(struct.getFecha_de_vencimiento());
      setgxTv_SdtSDTRequestNubefact_Moneda(struct.getMoneda());
      setgxTv_SdtSDTRequestNubefact_Tipo_de_cambio(struct.getTipo_de_cambio());
      setgxTv_SdtSDTRequestNubefact_Porcentaje_de_igv(struct.getPorcentaje_de_igv());
      setgxTv_SdtSDTRequestNubefact_Descuento_global(struct.getDescuento_global());
      setgxTv_SdtSDTRequestNubefact_Total_descuento(struct.getTotal_descuento());
      setgxTv_SdtSDTRequestNubefact_Total_anticipo(struct.getTotal_anticipo());
      setgxTv_SdtSDTRequestNubefact_Total_gravada(struct.getTotal_gravada());
      setgxTv_SdtSDTRequestNubefact_Total_inafecta(struct.getTotal_inafecta());
      setgxTv_SdtSDTRequestNubefact_Total_exonerada(struct.getTotal_exonerada());
      setgxTv_SdtSDTRequestNubefact_Total_igv(struct.getTotal_igv());
      setgxTv_SdtSDTRequestNubefact_Total_gratuita(struct.getTotal_gratuita());
      setgxTv_SdtSDTRequestNubefact_Total_otros_cargos(struct.getTotal_otros_cargos());
      setgxTv_SdtSDTRequestNubefact_Total(struct.getTotal());
      setgxTv_SdtSDTRequestNubefact_Percepcion_tipo(struct.getPercepcion_tipo());
      setgxTv_SdtSDTRequestNubefact_Percepcion_base_imponible(struct.getPercepcion_base_imponible());
      setgxTv_SdtSDTRequestNubefact_Total_percepcion(struct.getTotal_percepcion());
      setgxTv_SdtSDTRequestNubefact_Total_incluido_percepcion(struct.getTotal_incluido_percepcion());
      setgxTv_SdtSDTRequestNubefact_Total_impuestos_bolsas(struct.getTotal_impuestos_bolsas());
      setgxTv_SdtSDTRequestNubefact_Detraccion(struct.getDetraccion());
      setgxTv_SdtSDTRequestNubefact_Observaciones(struct.getObservaciones());
      setgxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_tipo(struct.getDocumento_que_se_modifica_tipo());
      setgxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_serie(struct.getDocumento_que_se_modifica_serie());
      setgxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_numero(struct.getDocumento_que_se_modifica_numero());
      setgxTv_SdtSDTRequestNubefact_Tipo_de_nota_de_credito(struct.getTipo_de_nota_de_credito());
      setgxTv_SdtSDTRequestNubefact_Tipo_de_nota_de_debito(struct.getTipo_de_nota_de_debito());
      setgxTv_SdtSDTRequestNubefact_Enviar_automaticamente_a_la_sunat(struct.getEnviar_automaticamente_a_la_sunat());
      setgxTv_SdtSDTRequestNubefact_Enviar_automaticamente_al_cliente(struct.getEnviar_automaticamente_al_cliente());
      setgxTv_SdtSDTRequestNubefact_Condiciones_de_pago(struct.getCondiciones_de_pago());
      setgxTv_SdtSDTRequestNubefact_Medio_de_pago(struct.getMedio_de_pago());
      setgxTv_SdtSDTRequestNubefact_Placa_vehiculo(struct.getPlaca_vehiculo());
      setgxTv_SdtSDTRequestNubefact_Orden_compra_servicio(struct.getOrden_compra_servicio());
      setgxTv_SdtSDTRequestNubefact_Formato_de_pdf(struct.getFormato_de_pdf());
      setgxTv_SdtSDTRequestNubefact_Generado_por_contingencia(struct.getGenerado_por_contingencia());
      setgxTv_SdtSDTRequestNubefact_Bienes_region_selva(struct.getBienes_region_selva());
      setgxTv_SdtSDTRequestNubefact_Servicios_region_selva(struct.getServicios_region_selva());
      GXBaseCollection<com.projectthani.SdtSDTRequestNubefact_itemsItem> gxTv_SdtSDTRequestNubefact_Items_aux = new GXBaseCollection<com.projectthani.SdtSDTRequestNubefact_itemsItem>(com.projectthani.SdtSDTRequestNubefact_itemsItem.class, "SDTRequestNubefact.itemsItem", "ProjectThani", remoteHandle);
      Vector<com.projectthani.StructSdtSDTRequestNubefact_itemsItem> gxTv_SdtSDTRequestNubefact_Items_aux1 = struct.getItems();
      if (gxTv_SdtSDTRequestNubefact_Items_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtSDTRequestNubefact_Items_aux1.size(); i++)
         {
            gxTv_SdtSDTRequestNubefact_Items_aux.add(new com.projectthani.SdtSDTRequestNubefact_itemsItem(gxTv_SdtSDTRequestNubefact_Items_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtSDTRequestNubefact_Items(gxTv_SdtSDTRequestNubefact_Items_aux);
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTRequestNubefact getStruct( )
   {
      com.projectthani.StructSdtSDTRequestNubefact struct = new com.projectthani.StructSdtSDTRequestNubefact ();
      struct.setOperacion(getgxTv_SdtSDTRequestNubefact_Operacion());
      struct.setTipo_de_comprobante(getgxTv_SdtSDTRequestNubefact_Tipo_de_comprobante());
      struct.setSerie(getgxTv_SdtSDTRequestNubefact_Serie());
      struct.setNumero(getgxTv_SdtSDTRequestNubefact_Numero());
      struct.setSunat_transaction(getgxTv_SdtSDTRequestNubefact_Sunat_transaction());
      struct.setCliente_tipo_de_documento(getgxTv_SdtSDTRequestNubefact_Cliente_tipo_de_documento());
      struct.setCliente_numero_de_documento(getgxTv_SdtSDTRequestNubefact_Cliente_numero_de_documento());
      struct.setCliente_denominacion(getgxTv_SdtSDTRequestNubefact_Cliente_denominacion());
      struct.setCliente_direccion(getgxTv_SdtSDTRequestNubefact_Cliente_direccion());
      struct.setCliente_email(getgxTv_SdtSDTRequestNubefact_Cliente_email());
      struct.setCliente_email_1(getgxTv_SdtSDTRequestNubefact_Cliente_email_1());
      struct.setCliente_email_2(getgxTv_SdtSDTRequestNubefact_Cliente_email_2());
      struct.setFecha_de_emision(getgxTv_SdtSDTRequestNubefact_Fecha_de_emision());
      struct.setFecha_de_vencimiento(getgxTv_SdtSDTRequestNubefact_Fecha_de_vencimiento());
      struct.setMoneda(getgxTv_SdtSDTRequestNubefact_Moneda());
      struct.setTipo_de_cambio(getgxTv_SdtSDTRequestNubefact_Tipo_de_cambio());
      struct.setPorcentaje_de_igv(getgxTv_SdtSDTRequestNubefact_Porcentaje_de_igv());
      struct.setDescuento_global(getgxTv_SdtSDTRequestNubefact_Descuento_global());
      struct.setTotal_descuento(getgxTv_SdtSDTRequestNubefact_Total_descuento());
      struct.setTotal_anticipo(getgxTv_SdtSDTRequestNubefact_Total_anticipo());
      struct.setTotal_gravada(getgxTv_SdtSDTRequestNubefact_Total_gravada());
      struct.setTotal_inafecta(getgxTv_SdtSDTRequestNubefact_Total_inafecta());
      struct.setTotal_exonerada(getgxTv_SdtSDTRequestNubefact_Total_exonerada());
      struct.setTotal_igv(getgxTv_SdtSDTRequestNubefact_Total_igv());
      struct.setTotal_gratuita(getgxTv_SdtSDTRequestNubefact_Total_gratuita());
      struct.setTotal_otros_cargos(getgxTv_SdtSDTRequestNubefact_Total_otros_cargos());
      struct.setTotal(getgxTv_SdtSDTRequestNubefact_Total());
      struct.setPercepcion_tipo(getgxTv_SdtSDTRequestNubefact_Percepcion_tipo());
      struct.setPercepcion_base_imponible(getgxTv_SdtSDTRequestNubefact_Percepcion_base_imponible());
      struct.setTotal_percepcion(getgxTv_SdtSDTRequestNubefact_Total_percepcion());
      struct.setTotal_incluido_percepcion(getgxTv_SdtSDTRequestNubefact_Total_incluido_percepcion());
      struct.setTotal_impuestos_bolsas(getgxTv_SdtSDTRequestNubefact_Total_impuestos_bolsas());
      struct.setDetraccion(getgxTv_SdtSDTRequestNubefact_Detraccion());
      struct.setObservaciones(getgxTv_SdtSDTRequestNubefact_Observaciones());
      struct.setDocumento_que_se_modifica_tipo(getgxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_tipo());
      struct.setDocumento_que_se_modifica_serie(getgxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_serie());
      struct.setDocumento_que_se_modifica_numero(getgxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_numero());
      struct.setTipo_de_nota_de_credito(getgxTv_SdtSDTRequestNubefact_Tipo_de_nota_de_credito());
      struct.setTipo_de_nota_de_debito(getgxTv_SdtSDTRequestNubefact_Tipo_de_nota_de_debito());
      struct.setEnviar_automaticamente_a_la_sunat(getgxTv_SdtSDTRequestNubefact_Enviar_automaticamente_a_la_sunat());
      struct.setEnviar_automaticamente_al_cliente(getgxTv_SdtSDTRequestNubefact_Enviar_automaticamente_al_cliente());
      struct.setCondiciones_de_pago(getgxTv_SdtSDTRequestNubefact_Condiciones_de_pago());
      struct.setMedio_de_pago(getgxTv_SdtSDTRequestNubefact_Medio_de_pago());
      struct.setPlaca_vehiculo(getgxTv_SdtSDTRequestNubefact_Placa_vehiculo());
      struct.setOrden_compra_servicio(getgxTv_SdtSDTRequestNubefact_Orden_compra_servicio());
      struct.setFormato_de_pdf(getgxTv_SdtSDTRequestNubefact_Formato_de_pdf());
      struct.setGenerado_por_contingencia(getgxTv_SdtSDTRequestNubefact_Generado_por_contingencia());
      struct.setBienes_region_selva(getgxTv_SdtSDTRequestNubefact_Bienes_region_selva());
      struct.setServicios_region_selva(getgxTv_SdtSDTRequestNubefact_Servicios_region_selva());
      struct.setItems(getgxTv_SdtSDTRequestNubefact_Items().getStruct());
      return struct ;
   }

   protected byte gxTv_SdtSDTRequestNubefact_N ;
   protected byte gxTv_SdtSDTRequestNubefact_Items_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_SdtSDTRequestNubefact_Tipo_de_comprobante ;
   protected java.math.BigDecimal gxTv_SdtSDTRequestNubefact_Numero ;
   protected java.math.BigDecimal gxTv_SdtSDTRequestNubefact_Sunat_transaction ;
   protected java.math.BigDecimal gxTv_SdtSDTRequestNubefact_Cliente_tipo_de_documento ;
   protected java.math.BigDecimal gxTv_SdtSDTRequestNubefact_Moneda ;
   protected java.math.BigDecimal gxTv_SdtSDTRequestNubefact_Porcentaje_de_igv ;
   protected java.math.BigDecimal gxTv_SdtSDTRequestNubefact_Total_gravada ;
   protected java.math.BigDecimal gxTv_SdtSDTRequestNubefact_Total_igv ;
   protected java.math.BigDecimal gxTv_SdtSDTRequestNubefact_Total ;
   protected String sTagName ;
   protected boolean gxTv_SdtSDTRequestNubefact_Detraccion ;
   protected boolean gxTv_SdtSDTRequestNubefact_Enviar_automaticamente_a_la_sunat ;
   protected boolean gxTv_SdtSDTRequestNubefact_Enviar_automaticamente_al_cliente ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTRequestNubefact_Operacion ;
   protected String gxTv_SdtSDTRequestNubefact_Serie ;
   protected String gxTv_SdtSDTRequestNubefact_Cliente_numero_de_documento ;
   protected String gxTv_SdtSDTRequestNubefact_Cliente_denominacion ;
   protected String gxTv_SdtSDTRequestNubefact_Cliente_direccion ;
   protected String gxTv_SdtSDTRequestNubefact_Cliente_email ;
   protected String gxTv_SdtSDTRequestNubefact_Cliente_email_1 ;
   protected String gxTv_SdtSDTRequestNubefact_Cliente_email_2 ;
   protected String gxTv_SdtSDTRequestNubefact_Fecha_de_emision ;
   protected String gxTv_SdtSDTRequestNubefact_Fecha_de_vencimiento ;
   protected String gxTv_SdtSDTRequestNubefact_Tipo_de_cambio ;
   protected String gxTv_SdtSDTRequestNubefact_Descuento_global ;
   protected String gxTv_SdtSDTRequestNubefact_Total_descuento ;
   protected String gxTv_SdtSDTRequestNubefact_Total_anticipo ;
   protected String gxTv_SdtSDTRequestNubefact_Total_inafecta ;
   protected String gxTv_SdtSDTRequestNubefact_Total_exonerada ;
   protected String gxTv_SdtSDTRequestNubefact_Total_gratuita ;
   protected String gxTv_SdtSDTRequestNubefact_Total_otros_cargos ;
   protected String gxTv_SdtSDTRequestNubefact_Percepcion_tipo ;
   protected String gxTv_SdtSDTRequestNubefact_Percepcion_base_imponible ;
   protected String gxTv_SdtSDTRequestNubefact_Total_percepcion ;
   protected String gxTv_SdtSDTRequestNubefact_Total_incluido_percepcion ;
   protected String gxTv_SdtSDTRequestNubefact_Total_impuestos_bolsas ;
   protected String gxTv_SdtSDTRequestNubefact_Observaciones ;
   protected String gxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_tipo ;
   protected String gxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_serie ;
   protected String gxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_numero ;
   protected String gxTv_SdtSDTRequestNubefact_Tipo_de_nota_de_credito ;
   protected String gxTv_SdtSDTRequestNubefact_Tipo_de_nota_de_debito ;
   protected String gxTv_SdtSDTRequestNubefact_Condiciones_de_pago ;
   protected String gxTv_SdtSDTRequestNubefact_Medio_de_pago ;
   protected String gxTv_SdtSDTRequestNubefact_Placa_vehiculo ;
   protected String gxTv_SdtSDTRequestNubefact_Orden_compra_servicio ;
   protected String gxTv_SdtSDTRequestNubefact_Formato_de_pdf ;
   protected String gxTv_SdtSDTRequestNubefact_Generado_por_contingencia ;
   protected String gxTv_SdtSDTRequestNubefact_Bienes_region_selva ;
   protected String gxTv_SdtSDTRequestNubefact_Servicios_region_selva ;
   protected GXBaseCollection<com.projectthani.SdtSDTRequestNubefact_itemsItem> gxTv_SdtSDTRequestNubefact_Items_aux ;
   protected GXBaseCollection<com.projectthani.SdtSDTRequestNubefact_itemsItem> gxTv_SdtSDTRequestNubefact_Items=null ;
}

