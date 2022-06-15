package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTRequestNubefact_itemsItem extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTRequestNubefact_itemsItem( )
   {
      this(  new ModelContext(SdtSDTRequestNubefact_itemsItem.class));
   }

   public SdtSDTRequestNubefact_itemsItem( ModelContext context )
   {
      super( context, "SdtSDTRequestNubefact_itemsItem");
   }

   public SdtSDTRequestNubefact_itemsItem( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTRequestNubefact_itemsItem");
   }

   public SdtSDTRequestNubefact_itemsItem( StructSdtSDTRequestNubefact_itemsItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "unidad_de_medida") )
            {
               gxTv_SdtSDTRequestNubefact_itemsItem_Unidad_de_medida = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "codigo") )
            {
               gxTv_SdtSDTRequestNubefact_itemsItem_Codigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "codigo_producto_sunat") )
            {
               gxTv_SdtSDTRequestNubefact_itemsItem_Codigo_producto_sunat = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "descripcion") )
            {
               gxTv_SdtSDTRequestNubefact_itemsItem_Descripcion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "cantidad") )
            {
               gxTv_SdtSDTRequestNubefact_itemsItem_Cantidad = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "valor_unitario") )
            {
               gxTv_SdtSDTRequestNubefact_itemsItem_Valor_unitario = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "precio_unitario") )
            {
               gxTv_SdtSDTRequestNubefact_itemsItem_Precio_unitario = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "descuento") )
            {
               gxTv_SdtSDTRequestNubefact_itemsItem_Descuento = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "subtotal") )
            {
               gxTv_SdtSDTRequestNubefact_itemsItem_Subtotal = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "tipo_de_igv") )
            {
               gxTv_SdtSDTRequestNubefact_itemsItem_Tipo_de_igv = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "igv") )
            {
               gxTv_SdtSDTRequestNubefact_itemsItem_Igv = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "total") )
            {
               gxTv_SdtSDTRequestNubefact_itemsItem_Total = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "anticipo_regularizacion") )
            {
               gxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_regularizacion = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "anticipo_documento_serie") )
            {
               gxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_documento_serie = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "anticipo_documento_numero") )
            {
               gxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_documento_numero = oReader.getValue() ;
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
         sName = "SDTRequestNubefact.itemsItem" ;
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
      oWriter.writeElement("unidad_de_medida", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_itemsItem_Unidad_de_medida));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("codigo", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_itemsItem_Codigo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("codigo_producto_sunat", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_itemsItem_Codigo_producto_sunat));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("descripcion", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_itemsItem_Descripcion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("cantidad", GXutil.trim( GXutil.strNoRound( gxTv_SdtSDTRequestNubefact_itemsItem_Cantidad, 10, 5)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("valor_unitario", GXutil.trim( GXutil.strNoRound( gxTv_SdtSDTRequestNubefact_itemsItem_Valor_unitario, 10, 5)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("precio_unitario", GXutil.trim( GXutil.strNoRound( gxTv_SdtSDTRequestNubefact_itemsItem_Precio_unitario, 10, 5)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("descuento", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_itemsItem_Descuento));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("subtotal", GXutil.trim( GXutil.strNoRound( gxTv_SdtSDTRequestNubefact_itemsItem_Subtotal, 10, 5)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("tipo_de_igv", GXutil.trim( GXutil.strNoRound( gxTv_SdtSDTRequestNubefact_itemsItem_Tipo_de_igv, 10, 5)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("igv", GXutil.trim( GXutil.strNoRound( gxTv_SdtSDTRequestNubefact_itemsItem_Igv, 10, 5)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("total", GXutil.trim( GXutil.strNoRound( gxTv_SdtSDTRequestNubefact_itemsItem_Total, 10, 5)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("anticipo_regularizacion", GXutil.rtrim( GXutil.booltostr( gxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_regularizacion)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("anticipo_documento_serie", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_documento_serie));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("anticipo_documento_numero", GXutil.rtrim( gxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_documento_numero));
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
      AddObjectProperty("unidad_de_medida", gxTv_SdtSDTRequestNubefact_itemsItem_Unidad_de_medida, false, false);
      AddObjectProperty("codigo", gxTv_SdtSDTRequestNubefact_itemsItem_Codigo, false, false);
      AddObjectProperty("codigo_producto_sunat", gxTv_SdtSDTRequestNubefact_itemsItem_Codigo_producto_sunat, false, false);
      AddObjectProperty("descripcion", gxTv_SdtSDTRequestNubefact_itemsItem_Descripcion, false, false);
      AddObjectProperty("cantidad", gxTv_SdtSDTRequestNubefact_itemsItem_Cantidad, false, false);
      AddObjectProperty("valor_unitario", gxTv_SdtSDTRequestNubefact_itemsItem_Valor_unitario, false, false);
      AddObjectProperty("precio_unitario", gxTv_SdtSDTRequestNubefact_itemsItem_Precio_unitario, false, false);
      AddObjectProperty("descuento", gxTv_SdtSDTRequestNubefact_itemsItem_Descuento, false, false);
      AddObjectProperty("subtotal", gxTv_SdtSDTRequestNubefact_itemsItem_Subtotal, false, false);
      AddObjectProperty("tipo_de_igv", gxTv_SdtSDTRequestNubefact_itemsItem_Tipo_de_igv, false, false);
      AddObjectProperty("igv", gxTv_SdtSDTRequestNubefact_itemsItem_Igv, false, false);
      AddObjectProperty("total", gxTv_SdtSDTRequestNubefact_itemsItem_Total, false, false);
      AddObjectProperty("anticipo_regularizacion", gxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_regularizacion, false, false);
      AddObjectProperty("anticipo_documento_serie", gxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_documento_serie, false, false);
      AddObjectProperty("anticipo_documento_numero", gxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_documento_numero, false, false);
   }

   public String getgxTv_SdtSDTRequestNubefact_itemsItem_Unidad_de_medida( )
   {
      return gxTv_SdtSDTRequestNubefact_itemsItem_Unidad_de_medida ;
   }

   public void setgxTv_SdtSDTRequestNubefact_itemsItem_Unidad_de_medida( String value )
   {
      gxTv_SdtSDTRequestNubefact_itemsItem_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Unidad_de_medida = value ;
   }

   public String getgxTv_SdtSDTRequestNubefact_itemsItem_Codigo( )
   {
      return gxTv_SdtSDTRequestNubefact_itemsItem_Codigo ;
   }

   public void setgxTv_SdtSDTRequestNubefact_itemsItem_Codigo( String value )
   {
      gxTv_SdtSDTRequestNubefact_itemsItem_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Codigo = value ;
   }

   public String getgxTv_SdtSDTRequestNubefact_itemsItem_Codigo_producto_sunat( )
   {
      return gxTv_SdtSDTRequestNubefact_itemsItem_Codigo_producto_sunat ;
   }

   public void setgxTv_SdtSDTRequestNubefact_itemsItem_Codigo_producto_sunat( String value )
   {
      gxTv_SdtSDTRequestNubefact_itemsItem_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Codigo_producto_sunat = value ;
   }

   public String getgxTv_SdtSDTRequestNubefact_itemsItem_Descripcion( )
   {
      return gxTv_SdtSDTRequestNubefact_itemsItem_Descripcion ;
   }

   public void setgxTv_SdtSDTRequestNubefact_itemsItem_Descripcion( String value )
   {
      gxTv_SdtSDTRequestNubefact_itemsItem_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Descripcion = value ;
   }

   public java.math.BigDecimal getgxTv_SdtSDTRequestNubefact_itemsItem_Cantidad( )
   {
      return gxTv_SdtSDTRequestNubefact_itemsItem_Cantidad ;
   }

   public void setgxTv_SdtSDTRequestNubefact_itemsItem_Cantidad( java.math.BigDecimal value )
   {
      gxTv_SdtSDTRequestNubefact_itemsItem_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Cantidad = value ;
   }

   public java.math.BigDecimal getgxTv_SdtSDTRequestNubefact_itemsItem_Valor_unitario( )
   {
      return gxTv_SdtSDTRequestNubefact_itemsItem_Valor_unitario ;
   }

   public void setgxTv_SdtSDTRequestNubefact_itemsItem_Valor_unitario( java.math.BigDecimal value )
   {
      gxTv_SdtSDTRequestNubefact_itemsItem_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Valor_unitario = value ;
   }

   public java.math.BigDecimal getgxTv_SdtSDTRequestNubefact_itemsItem_Precio_unitario( )
   {
      return gxTv_SdtSDTRequestNubefact_itemsItem_Precio_unitario ;
   }

   public void setgxTv_SdtSDTRequestNubefact_itemsItem_Precio_unitario( java.math.BigDecimal value )
   {
      gxTv_SdtSDTRequestNubefact_itemsItem_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Precio_unitario = value ;
   }

   public String getgxTv_SdtSDTRequestNubefact_itemsItem_Descuento( )
   {
      return gxTv_SdtSDTRequestNubefact_itemsItem_Descuento ;
   }

   public void setgxTv_SdtSDTRequestNubefact_itemsItem_Descuento( String value )
   {
      gxTv_SdtSDTRequestNubefact_itemsItem_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Descuento = value ;
   }

   public java.math.BigDecimal getgxTv_SdtSDTRequestNubefact_itemsItem_Subtotal( )
   {
      return gxTv_SdtSDTRequestNubefact_itemsItem_Subtotal ;
   }

   public void setgxTv_SdtSDTRequestNubefact_itemsItem_Subtotal( java.math.BigDecimal value )
   {
      gxTv_SdtSDTRequestNubefact_itemsItem_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Subtotal = value ;
   }

   public java.math.BigDecimal getgxTv_SdtSDTRequestNubefact_itemsItem_Tipo_de_igv( )
   {
      return gxTv_SdtSDTRequestNubefact_itemsItem_Tipo_de_igv ;
   }

   public void setgxTv_SdtSDTRequestNubefact_itemsItem_Tipo_de_igv( java.math.BigDecimal value )
   {
      gxTv_SdtSDTRequestNubefact_itemsItem_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Tipo_de_igv = value ;
   }

   public java.math.BigDecimal getgxTv_SdtSDTRequestNubefact_itemsItem_Igv( )
   {
      return gxTv_SdtSDTRequestNubefact_itemsItem_Igv ;
   }

   public void setgxTv_SdtSDTRequestNubefact_itemsItem_Igv( java.math.BigDecimal value )
   {
      gxTv_SdtSDTRequestNubefact_itemsItem_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Igv = value ;
   }

   public java.math.BigDecimal getgxTv_SdtSDTRequestNubefact_itemsItem_Total( )
   {
      return gxTv_SdtSDTRequestNubefact_itemsItem_Total ;
   }

   public void setgxTv_SdtSDTRequestNubefact_itemsItem_Total( java.math.BigDecimal value )
   {
      gxTv_SdtSDTRequestNubefact_itemsItem_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Total = value ;
   }

   public boolean getgxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_regularizacion( )
   {
      return gxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_regularizacion ;
   }

   public void setgxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_regularizacion( boolean value )
   {
      gxTv_SdtSDTRequestNubefact_itemsItem_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_regularizacion = value ;
   }

   public String getgxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_documento_serie( )
   {
      return gxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_documento_serie ;
   }

   public void setgxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_documento_serie( String value )
   {
      gxTv_SdtSDTRequestNubefact_itemsItem_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_documento_serie = value ;
   }

   public String getgxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_documento_numero( )
   {
      return gxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_documento_numero ;
   }

   public void setgxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_documento_numero( String value )
   {
      gxTv_SdtSDTRequestNubefact_itemsItem_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_documento_numero = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTRequestNubefact_itemsItem_Unidad_de_medida = "" ;
      gxTv_SdtSDTRequestNubefact_itemsItem_N = (byte)(1) ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Codigo = "" ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Codigo_producto_sunat = "" ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Descripcion = "" ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Cantidad = DecimalUtil.ZERO ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Valor_unitario = DecimalUtil.ZERO ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Precio_unitario = DecimalUtil.ZERO ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Descuento = "" ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Subtotal = DecimalUtil.ZERO ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Tipo_de_igv = DecimalUtil.ZERO ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Igv = DecimalUtil.ZERO ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Total = DecimalUtil.ZERO ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_documento_serie = "" ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_documento_numero = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTRequestNubefact_itemsItem_N ;
   }

   public com.projectthani.SdtSDTRequestNubefact_itemsItem Clone( )
   {
      return (com.projectthani.SdtSDTRequestNubefact_itemsItem)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTRequestNubefact_itemsItem struct )
   {
      setgxTv_SdtSDTRequestNubefact_itemsItem_Unidad_de_medida(struct.getUnidad_de_medida());
      setgxTv_SdtSDTRequestNubefact_itemsItem_Codigo(struct.getCodigo());
      setgxTv_SdtSDTRequestNubefact_itemsItem_Codigo_producto_sunat(struct.getCodigo_producto_sunat());
      setgxTv_SdtSDTRequestNubefact_itemsItem_Descripcion(struct.getDescripcion());
      setgxTv_SdtSDTRequestNubefact_itemsItem_Cantidad(struct.getCantidad());
      setgxTv_SdtSDTRequestNubefact_itemsItem_Valor_unitario(struct.getValor_unitario());
      setgxTv_SdtSDTRequestNubefact_itemsItem_Precio_unitario(struct.getPrecio_unitario());
      setgxTv_SdtSDTRequestNubefact_itemsItem_Descuento(struct.getDescuento());
      setgxTv_SdtSDTRequestNubefact_itemsItem_Subtotal(struct.getSubtotal());
      setgxTv_SdtSDTRequestNubefact_itemsItem_Tipo_de_igv(struct.getTipo_de_igv());
      setgxTv_SdtSDTRequestNubefact_itemsItem_Igv(struct.getIgv());
      setgxTv_SdtSDTRequestNubefact_itemsItem_Total(struct.getTotal());
      setgxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_regularizacion(struct.getAnticipo_regularizacion());
      setgxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_documento_serie(struct.getAnticipo_documento_serie());
      setgxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_documento_numero(struct.getAnticipo_documento_numero());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTRequestNubefact_itemsItem getStruct( )
   {
      com.projectthani.StructSdtSDTRequestNubefact_itemsItem struct = new com.projectthani.StructSdtSDTRequestNubefact_itemsItem ();
      struct.setUnidad_de_medida(getgxTv_SdtSDTRequestNubefact_itemsItem_Unidad_de_medida());
      struct.setCodigo(getgxTv_SdtSDTRequestNubefact_itemsItem_Codigo());
      struct.setCodigo_producto_sunat(getgxTv_SdtSDTRequestNubefact_itemsItem_Codigo_producto_sunat());
      struct.setDescripcion(getgxTv_SdtSDTRequestNubefact_itemsItem_Descripcion());
      struct.setCantidad(getgxTv_SdtSDTRequestNubefact_itemsItem_Cantidad());
      struct.setValor_unitario(getgxTv_SdtSDTRequestNubefact_itemsItem_Valor_unitario());
      struct.setPrecio_unitario(getgxTv_SdtSDTRequestNubefact_itemsItem_Precio_unitario());
      struct.setDescuento(getgxTv_SdtSDTRequestNubefact_itemsItem_Descuento());
      struct.setSubtotal(getgxTv_SdtSDTRequestNubefact_itemsItem_Subtotal());
      struct.setTipo_de_igv(getgxTv_SdtSDTRequestNubefact_itemsItem_Tipo_de_igv());
      struct.setIgv(getgxTv_SdtSDTRequestNubefact_itemsItem_Igv());
      struct.setTotal(getgxTv_SdtSDTRequestNubefact_itemsItem_Total());
      struct.setAnticipo_regularizacion(getgxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_regularizacion());
      struct.setAnticipo_documento_serie(getgxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_documento_serie());
      struct.setAnticipo_documento_numero(getgxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_documento_numero());
      return struct ;
   }

   protected byte gxTv_SdtSDTRequestNubefact_itemsItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_SdtSDTRequestNubefact_itemsItem_Cantidad ;
   protected java.math.BigDecimal gxTv_SdtSDTRequestNubefact_itemsItem_Valor_unitario ;
   protected java.math.BigDecimal gxTv_SdtSDTRequestNubefact_itemsItem_Precio_unitario ;
   protected java.math.BigDecimal gxTv_SdtSDTRequestNubefact_itemsItem_Subtotal ;
   protected java.math.BigDecimal gxTv_SdtSDTRequestNubefact_itemsItem_Tipo_de_igv ;
   protected java.math.BigDecimal gxTv_SdtSDTRequestNubefact_itemsItem_Igv ;
   protected java.math.BigDecimal gxTv_SdtSDTRequestNubefact_itemsItem_Total ;
   protected String sTagName ;
   protected boolean gxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_regularizacion ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTRequestNubefact_itemsItem_Unidad_de_medida ;
   protected String gxTv_SdtSDTRequestNubefact_itemsItem_Codigo ;
   protected String gxTv_SdtSDTRequestNubefact_itemsItem_Codigo_producto_sunat ;
   protected String gxTv_SdtSDTRequestNubefact_itemsItem_Descripcion ;
   protected String gxTv_SdtSDTRequestNubefact_itemsItem_Descuento ;
   protected String gxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_documento_serie ;
   protected String gxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_documento_numero ;
}

