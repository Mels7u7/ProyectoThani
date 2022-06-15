package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem( )
   {
      this(  new ModelContext(SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem.class));
   }

   public SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem( ModelContext context )
   {
      super( context, "SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem");
   }

   public SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem( int remoteHandle ,
                                                                                                  ModelContext context )
   {
      super( remoteHandle, context, "SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem");
   }

   public SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem( StructSdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem struct )
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
               gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem_Titulo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Descripcion") )
            {
               gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem_Descripcion = oReader.getValue() ;
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
         sName = "SDT_PPDP.SDT_PPDP_SubItem.SDT_PPDP_SubItem_SubItem.SDT_PPDP_SubItem_SubItem_SubItem" ;
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
      oWriter.writeElement("Titulo", GXutil.rtrim( gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem_Titulo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Descripcion", GXutil.rtrim( gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem_Descripcion));
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
      AddObjectProperty("Titulo", gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem_Titulo, false, false);
      AddObjectProperty("Descripcion", gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem_Descripcion, false, false);
   }

   public String getgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem_Titulo( )
   {
      return gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem_Titulo ;
   }

   public void setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem_Titulo( String value )
   {
      gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem_N = (byte)(0) ;
      gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem_Titulo = value ;
   }

   public String getgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem_Descripcion( )
   {
      return gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem_Descripcion ;
   }

   public void setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem_Descripcion( String value )
   {
      gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem_N = (byte)(0) ;
      gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem_Descripcion = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem_Titulo = "" ;
      gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem_N = (byte)(1) ;
      gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem_Descripcion = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem_N ;
   }

   public com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem Clone( )
   {
      return (com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem struct )
   {
      setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem_Titulo(struct.getTitulo());
      setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem_Descripcion(struct.getDescripcion());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem getStruct( )
   {
      com.projectthani.StructSdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem struct = new com.projectthani.StructSdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem ();
      struct.setTitulo(getgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem_Titulo());
      struct.setDescripcion(getgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem_Descripcion());
      return struct ;
   }

   protected byte gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem_Titulo ;
   protected String gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem_Descripcion ;
}

