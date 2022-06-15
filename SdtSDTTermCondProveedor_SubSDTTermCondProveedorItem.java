package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem( )
   {
      this(  new ModelContext(SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem.class));
   }

   public SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem( ModelContext context )
   {
      super( context, "SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem");
   }

   public SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem( int remoteHandle ,
                                                               ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem");
   }

   public SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem( StructSdtSDTTermCondProveedor_SubSDTTermCondProveedorItem struct )
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
               gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Titulo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Descripcion") )
            {
               gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Descripcion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SubSubSDTTCProveedor") )
            {
               if ( gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor == null )
               {
                  gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor = new GXBaseCollection<com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem>(com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem.class, "SDTTermCondProveedor.SubSDTTermCondProveedorItem.SubSubSDTTCProveedorItem", "ProjectThani", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor.readxmlcollection(oReader, "SubSubSDTTCProveedor", "SubSubSDTTCProveedorItem") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "SubSubSDTTCProveedor") )
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
         sName = "SDTTermCondProveedor.SubSDTTermCondProveedorItem" ;
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
      oWriter.writeElement("Titulo", GXutil.rtrim( gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Titulo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Descripcion", GXutil.rtrim( gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Descripcion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor != null )
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
         gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor.writexmlcollection(oWriter, "SubSubSDTTCProveedor", sNameSpace1, "SubSubSDTTCProveedorItem", sNameSpace1);
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
      AddObjectProperty("Titulo", gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Titulo, false, false);
      AddObjectProperty("Descripcion", gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Descripcion, false, false);
      if ( gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor != null )
      {
         AddObjectProperty("SubSubSDTTCProveedor", gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor, false, false);
      }
   }

   public String getgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Titulo( )
   {
      return gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Titulo ;
   }

   public void setgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Titulo( String value )
   {
      gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_N = (byte)(0) ;
      gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Titulo = value ;
   }

   public String getgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Descripcion( )
   {
      return gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Descripcion ;
   }

   public void setgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Descripcion( String value )
   {
      gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_N = (byte)(0) ;
      gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Descripcion = value ;
   }

   public GXBaseCollection<com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem> getgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor( )
   {
      if ( gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor == null )
      {
         gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor = new GXBaseCollection<com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem>(com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem.class, "SDTTermCondProveedor.SubSDTTermCondProveedorItem.SubSubSDTTCProveedorItem", "ProjectThani", remoteHandle);
      }
      gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor_N = (byte)(0) ;
      gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_N = (byte)(0) ;
      return gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor ;
   }

   public void setgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor( GXBaseCollection<com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem> value )
   {
      gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor_N = (byte)(0) ;
      gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_N = (byte)(0) ;
      gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor = value ;
   }

   public void setgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor_SetNull( )
   {
      gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor_N = (byte)(1) ;
      gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor = null ;
   }

   public boolean getgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor_IsNull( )
   {
      if ( gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor_N( )
   {
      return gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Titulo = "" ;
      gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_N = (byte)(1) ;
      gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Descripcion = "" ;
      gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_N ;
   }

   public com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem Clone( )
   {
      return (com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTTermCondProveedor_SubSDTTermCondProveedorItem struct )
   {
      setgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Titulo(struct.getTitulo());
      setgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Descripcion(struct.getDescripcion());
      GXBaseCollection<com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem> gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor_aux = new GXBaseCollection<com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem>(com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem.class, "SDTTermCondProveedor.SubSDTTermCondProveedorItem.SubSubSDTTCProveedorItem", "ProjectThani", remoteHandle);
      Vector<com.projectthani.StructSdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem> gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor_aux1 = struct.getSubsubsdttcproveedor();
      if (gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor_aux1.size(); i++)
         {
            gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor_aux.add(new com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem(gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor(gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor_aux);
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTTermCondProveedor_SubSDTTermCondProveedorItem getStruct( )
   {
      com.projectthani.StructSdtSDTTermCondProveedor_SubSDTTermCondProveedorItem struct = new com.projectthani.StructSdtSDTTermCondProveedor_SubSDTTermCondProveedorItem ();
      struct.setTitulo(getgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Titulo());
      struct.setDescripcion(getgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Descripcion());
      struct.setSubsubsdttcproveedor(getgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor().getStruct());
      return struct ;
   }

   protected byte gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_N ;
   protected byte gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Titulo ;
   protected String gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Descripcion ;
   protected GXBaseCollection<com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem> gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor_aux ;
   protected GXBaseCollection<com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem> gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor=null ;
}

