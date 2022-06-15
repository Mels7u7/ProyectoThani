package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTTermCondProveedor extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTTermCondProveedor( )
   {
      this(  new ModelContext(SdtSDTTermCondProveedor.class));
   }

   public SdtSDTTermCondProveedor( ModelContext context )
   {
      super( context, "SdtSDTTermCondProveedor");
   }

   public SdtSDTTermCondProveedor( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTTermCondProveedor");
   }

   public SdtSDTTermCondProveedor( StructSdtSDTTermCondProveedor struct )
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
               gxTv_SdtSDTTermCondProveedor_Titulo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Descripcion") )
            {
               gxTv_SdtSDTTermCondProveedor_Descripcion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SubSDTTermCondProveedor") )
            {
               if ( gxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor == null )
               {
                  gxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor = new GXBaseCollection<com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem>(com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem.class, "SDTTermCondProveedor.SubSDTTermCondProveedorItem", "ProjectThani", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor.readxmlcollection(oReader, "SubSDTTermCondProveedor", "SubSDTTermCondProveedorItem") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "SubSDTTermCondProveedor") )
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
         sName = "SDTTermCondProveedor" ;
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
      oWriter.writeElement("Titulo", GXutil.rtrim( gxTv_SdtSDTTermCondProveedor_Titulo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Descripcion", GXutil.rtrim( gxTv_SdtSDTTermCondProveedor_Descripcion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( gxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor != null )
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
         gxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor.writexmlcollection(oWriter, "SubSDTTermCondProveedor", sNameSpace1, "SubSDTTermCondProveedorItem", sNameSpace1);
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
      AddObjectProperty("Titulo", gxTv_SdtSDTTermCondProveedor_Titulo, false, false);
      AddObjectProperty("Descripcion", gxTv_SdtSDTTermCondProveedor_Descripcion, false, false);
      if ( gxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor != null )
      {
         AddObjectProperty("SubSDTTermCondProveedor", gxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor, false, false);
      }
   }

   public String getgxTv_SdtSDTTermCondProveedor_Titulo( )
   {
      return gxTv_SdtSDTTermCondProveedor_Titulo ;
   }

   public void setgxTv_SdtSDTTermCondProveedor_Titulo( String value )
   {
      gxTv_SdtSDTTermCondProveedor_N = (byte)(0) ;
      gxTv_SdtSDTTermCondProveedor_Titulo = value ;
   }

   public String getgxTv_SdtSDTTermCondProveedor_Descripcion( )
   {
      return gxTv_SdtSDTTermCondProveedor_Descripcion ;
   }

   public void setgxTv_SdtSDTTermCondProveedor_Descripcion( String value )
   {
      gxTv_SdtSDTTermCondProveedor_N = (byte)(0) ;
      gxTv_SdtSDTTermCondProveedor_Descripcion = value ;
   }

   public GXBaseCollection<com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem> getgxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor( )
   {
      if ( gxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor == null )
      {
         gxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor = new GXBaseCollection<com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem>(com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem.class, "SDTTermCondProveedor.SubSDTTermCondProveedorItem", "ProjectThani", remoteHandle);
      }
      gxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor_N = (byte)(0) ;
      gxTv_SdtSDTTermCondProveedor_N = (byte)(0) ;
      return gxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor ;
   }

   public void setgxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor( GXBaseCollection<com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem> value )
   {
      gxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor_N = (byte)(0) ;
      gxTv_SdtSDTTermCondProveedor_N = (byte)(0) ;
      gxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor = value ;
   }

   public void setgxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor_SetNull( )
   {
      gxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor_N = (byte)(1) ;
      gxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor = null ;
   }

   public boolean getgxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor_IsNull( )
   {
      if ( gxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor_N( )
   {
      return gxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTTermCondProveedor_Titulo = "" ;
      gxTv_SdtSDTTermCondProveedor_N = (byte)(1) ;
      gxTv_SdtSDTTermCondProveedor_Descripcion = "" ;
      gxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTTermCondProveedor_N ;
   }

   public com.projectthani.SdtSDTTermCondProveedor Clone( )
   {
      return (com.projectthani.SdtSDTTermCondProveedor)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTTermCondProveedor struct )
   {
      setgxTv_SdtSDTTermCondProveedor_Titulo(struct.getTitulo());
      setgxTv_SdtSDTTermCondProveedor_Descripcion(struct.getDescripcion());
      GXBaseCollection<com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem> gxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor_aux = new GXBaseCollection<com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem>(com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem.class, "SDTTermCondProveedor.SubSDTTermCondProveedorItem", "ProjectThani", remoteHandle);
      Vector<com.projectthani.StructSdtSDTTermCondProveedor_SubSDTTermCondProveedorItem> gxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor_aux1 = struct.getSubsdttermcondproveedor();
      if (gxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor_aux1.size(); i++)
         {
            gxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor_aux.add(new com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem(gxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor(gxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor_aux);
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTTermCondProveedor getStruct( )
   {
      com.projectthani.StructSdtSDTTermCondProveedor struct = new com.projectthani.StructSdtSDTTermCondProveedor ();
      struct.setTitulo(getgxTv_SdtSDTTermCondProveedor_Titulo());
      struct.setDescripcion(getgxTv_SdtSDTTermCondProveedor_Descripcion());
      struct.setSubsdttermcondproveedor(getgxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor().getStruct());
      return struct ;
   }

   protected byte gxTv_SdtSDTTermCondProveedor_N ;
   protected byte gxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTTermCondProveedor_Titulo ;
   protected String gxTv_SdtSDTTermCondProveedor_Descripcion ;
   protected GXBaseCollection<com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem> gxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor_aux ;
   protected GXBaseCollection<com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem> gxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor=null ;
}

