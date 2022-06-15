package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem( )
   {
      this(  new ModelContext(SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem.class));
   }

   public SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem( ModelContext context )
   {
      super( context, "SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem");
   }

   public SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem( int remoteHandle ,
                                                                                        ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem");
   }

   public SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem( StructSdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Titulo") )
            {
               gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem_Titulo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Descripcion") )
            {
               gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem_Descripcion = oReader.getValue() ;
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
         sName = "SDTTermCondProveedor.SubSDTTermCondProveedorItem.SubSubSDTTCProveedorItem" ;
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
      oWriter.writeElement("Titulo", GXutil.rtrim( gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem_Titulo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Descripcion", GXutil.rtrim( gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem_Descripcion));
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
      AddObjectProperty("Titulo", gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem_Titulo, false, false);
      AddObjectProperty("Descripcion", gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem_Descripcion, false, false);
   }

   public String getgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem_Titulo( )
   {
      return gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem_Titulo ;
   }

   public void setgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem_Titulo( String value )
   {
      gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem_N = (byte)(0) ;
      gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem_Titulo = value ;
   }

   public String getgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem_Descripcion( )
   {
      return gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem_Descripcion ;
   }

   public void setgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem_Descripcion( String value )
   {
      gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem_N = (byte)(0) ;
      gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem_Descripcion = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem_Titulo = "" ;
      gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem_N = (byte)(1) ;
      gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem_Descripcion = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem_N ;
   }

   public com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem Clone( )
   {
      return (com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem struct )
   {
      setgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem_Titulo(struct.getTitulo());
      setgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem_Descripcion(struct.getDescripcion());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem getStruct( )
   {
      com.projectthani.StructSdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem struct = new com.projectthani.StructSdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem ();
      struct.setTitulo(getgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem_Titulo());
      struct.setDescripcion(getgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem_Descripcion());
      return struct ;
   }

   protected byte gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem_Titulo ;
   protected String gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem_Descripcion ;
}

