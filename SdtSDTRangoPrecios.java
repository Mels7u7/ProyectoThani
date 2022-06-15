package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTRangoPrecios extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTRangoPrecios( )
   {
      this(  new ModelContext(SdtSDTRangoPrecios.class));
   }

   public SdtSDTRangoPrecios( ModelContext context )
   {
      super( context, "SdtSDTRangoPrecios");
   }

   public SdtSDTRangoPrecios( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTRangoPrecios");
   }

   public SdtSDTRangoPrecios( StructSdtSDTRangoPrecios struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "idPrecio") )
            {
               gxTv_SdtSDTRangoPrecios_Idprecio = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Descripcion") )
            {
               gxTv_SdtSDTRangoPrecios_Descripcion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ValorA") )
            {
               gxTv_SdtSDTRangoPrecios_Valora = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ValorB") )
            {
               gxTv_SdtSDTRangoPrecios_Valorb = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Estado") )
            {
               gxTv_SdtSDTRangoPrecios_Estado = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
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
         sName = "SDTRangoPrecios" ;
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
      oWriter.writeElement("idPrecio", GXutil.trim( GXutil.str( gxTv_SdtSDTRangoPrecios_Idprecio, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Descripcion", GXutil.rtrim( gxTv_SdtSDTRangoPrecios_Descripcion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ValorA", GXutil.trim( GXutil.strNoRound( gxTv_SdtSDTRangoPrecios_Valora, 6, 2)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ValorB", GXutil.trim( GXutil.strNoRound( gxTv_SdtSDTRangoPrecios_Valorb, 6, 2)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Estado", GXutil.rtrim( GXutil.booltostr( gxTv_SdtSDTRangoPrecios_Estado)));
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
      AddObjectProperty("idPrecio", gxTv_SdtSDTRangoPrecios_Idprecio, false, false);
      AddObjectProperty("Descripcion", gxTv_SdtSDTRangoPrecios_Descripcion, false, false);
      AddObjectProperty("ValorA", gxTv_SdtSDTRangoPrecios_Valora, false, false);
      AddObjectProperty("ValorB", gxTv_SdtSDTRangoPrecios_Valorb, false, false);
      AddObjectProperty("Estado", gxTv_SdtSDTRangoPrecios_Estado, false, false);
   }

   public short getgxTv_SdtSDTRangoPrecios_Idprecio( )
   {
      return gxTv_SdtSDTRangoPrecios_Idprecio ;
   }

   public void setgxTv_SdtSDTRangoPrecios_Idprecio( short value )
   {
      gxTv_SdtSDTRangoPrecios_N = (byte)(0) ;
      gxTv_SdtSDTRangoPrecios_Idprecio = value ;
   }

   public String getgxTv_SdtSDTRangoPrecios_Descripcion( )
   {
      return gxTv_SdtSDTRangoPrecios_Descripcion ;
   }

   public void setgxTv_SdtSDTRangoPrecios_Descripcion( String value )
   {
      gxTv_SdtSDTRangoPrecios_N = (byte)(0) ;
      gxTv_SdtSDTRangoPrecios_Descripcion = value ;
   }

   public java.math.BigDecimal getgxTv_SdtSDTRangoPrecios_Valora( )
   {
      return gxTv_SdtSDTRangoPrecios_Valora ;
   }

   public void setgxTv_SdtSDTRangoPrecios_Valora( java.math.BigDecimal value )
   {
      gxTv_SdtSDTRangoPrecios_N = (byte)(0) ;
      gxTv_SdtSDTRangoPrecios_Valora = value ;
   }

   public java.math.BigDecimal getgxTv_SdtSDTRangoPrecios_Valorb( )
   {
      return gxTv_SdtSDTRangoPrecios_Valorb ;
   }

   public void setgxTv_SdtSDTRangoPrecios_Valorb( java.math.BigDecimal value )
   {
      gxTv_SdtSDTRangoPrecios_N = (byte)(0) ;
      gxTv_SdtSDTRangoPrecios_Valorb = value ;
   }

   public boolean getgxTv_SdtSDTRangoPrecios_Estado( )
   {
      return gxTv_SdtSDTRangoPrecios_Estado ;
   }

   public void setgxTv_SdtSDTRangoPrecios_Estado( boolean value )
   {
      gxTv_SdtSDTRangoPrecios_N = (byte)(0) ;
      gxTv_SdtSDTRangoPrecios_Estado = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTRangoPrecios_N = (byte)(1) ;
      gxTv_SdtSDTRangoPrecios_Descripcion = "" ;
      gxTv_SdtSDTRangoPrecios_Valora = DecimalUtil.ZERO ;
      gxTv_SdtSDTRangoPrecios_Valorb = DecimalUtil.ZERO ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTRangoPrecios_N ;
   }

   public com.projectthani.SdtSDTRangoPrecios Clone( )
   {
      return (com.projectthani.SdtSDTRangoPrecios)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTRangoPrecios struct )
   {
      setgxTv_SdtSDTRangoPrecios_Idprecio(struct.getIdprecio());
      setgxTv_SdtSDTRangoPrecios_Descripcion(struct.getDescripcion());
      setgxTv_SdtSDTRangoPrecios_Valora(struct.getValora());
      setgxTv_SdtSDTRangoPrecios_Valorb(struct.getValorb());
      setgxTv_SdtSDTRangoPrecios_Estado(struct.getEstado());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTRangoPrecios getStruct( )
   {
      com.projectthani.StructSdtSDTRangoPrecios struct = new com.projectthani.StructSdtSDTRangoPrecios ();
      struct.setIdprecio(getgxTv_SdtSDTRangoPrecios_Idprecio());
      struct.setDescripcion(getgxTv_SdtSDTRangoPrecios_Descripcion());
      struct.setValora(getgxTv_SdtSDTRangoPrecios_Valora());
      struct.setValorb(getgxTv_SdtSDTRangoPrecios_Valorb());
      struct.setEstado(getgxTv_SdtSDTRangoPrecios_Estado());
      return struct ;
   }

   protected byte gxTv_SdtSDTRangoPrecios_N ;
   protected short gxTv_SdtSDTRangoPrecios_Idprecio ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_SdtSDTRangoPrecios_Valora ;
   protected java.math.BigDecimal gxTv_SdtSDTRangoPrecios_Valorb ;
   protected String sTagName ;
   protected boolean gxTv_SdtSDTRangoPrecios_Estado ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTRangoPrecios_Descripcion ;
}

