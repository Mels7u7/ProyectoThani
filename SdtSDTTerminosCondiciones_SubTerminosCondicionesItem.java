package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTTerminosCondiciones_SubTerminosCondicionesItem extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTTerminosCondiciones_SubTerminosCondicionesItem( )
   {
      this(  new ModelContext(SdtSDTTerminosCondiciones_SubTerminosCondicionesItem.class));
   }

   public SdtSDTTerminosCondiciones_SubTerminosCondicionesItem( ModelContext context )
   {
      super( context, "SdtSDTTerminosCondiciones_SubTerminosCondicionesItem");
   }

   public SdtSDTTerminosCondiciones_SubTerminosCondicionesItem( int remoteHandle ,
                                                                ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTTerminosCondiciones_SubTerminosCondicionesItem");
   }

   public SdtSDTTerminosCondiciones_SubTerminosCondicionesItem( StructSdtSDTTerminosCondiciones_SubTerminosCondicionesItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTItemTitulo") )
            {
               gxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Sdtitemtitulo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "STCItemDescripcion") )
            {
               gxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Stcitemdescripcion = oReader.getValue() ;
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
         sName = "SDTTerminosCondiciones.SubTerminosCondicionesItem" ;
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
      oWriter.writeElement("SDTItemTitulo", GXutil.rtrim( gxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Sdtitemtitulo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("STCItemDescripcion", GXutil.rtrim( gxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Stcitemdescripcion));
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
      AddObjectProperty("SDTItemTitulo", gxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Sdtitemtitulo, false, false);
      AddObjectProperty("STCItemDescripcion", gxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Stcitemdescripcion, false, false);
   }

   public String getgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Sdtitemtitulo( )
   {
      return gxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Sdtitemtitulo ;
   }

   public void setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Sdtitemtitulo( String value )
   {
      gxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_N = (byte)(0) ;
      gxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Sdtitemtitulo = value ;
   }

   public String getgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Stcitemdescripcion( )
   {
      return gxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Stcitemdescripcion ;
   }

   public void setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Stcitemdescripcion( String value )
   {
      gxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_N = (byte)(0) ;
      gxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Stcitemdescripcion = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Sdtitemtitulo = "" ;
      gxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_N = (byte)(1) ;
      gxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Stcitemdescripcion = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_N ;
   }

   public com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem Clone( )
   {
      return (com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTTerminosCondiciones_SubTerminosCondicionesItem struct )
   {
      setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Sdtitemtitulo(struct.getSdtitemtitulo());
      setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Stcitemdescripcion(struct.getStcitemdescripcion());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTTerminosCondiciones_SubTerminosCondicionesItem getStruct( )
   {
      com.projectthani.StructSdtSDTTerminosCondiciones_SubTerminosCondicionesItem struct = new com.projectthani.StructSdtSDTTerminosCondiciones_SubTerminosCondicionesItem ();
      struct.setSdtitemtitulo(getgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Sdtitemtitulo());
      struct.setStcitemdescripcion(getgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Stcitemdescripcion());
      return struct ;
   }

   protected byte gxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Sdtitemtitulo ;
   protected String gxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Stcitemdescripcion ;
}

