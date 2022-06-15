package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTMenu_SubMenusItem extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTMenu_SubMenusItem( )
   {
      this(  new ModelContext(SdtSDTMenu_SubMenusItem.class));
   }

   public SdtSDTMenu_SubMenusItem( ModelContext context )
   {
      super( context, "SdtSDTMenu_SubMenusItem");
   }

   public SdtSDTMenu_SubMenusItem( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTMenu_SubMenusItem");
   }

   public SdtSDTMenu_SubMenusItem( StructSdtSDTMenu_SubMenusItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "MenuTexto") )
            {
               gxTv_SdtSDTMenu_SubMenusItem_Menutexto = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MenuLink") )
            {
               gxTv_SdtSDTMenu_SubMenusItem_Menulink = oReader.getValue() ;
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
         sName = "SDTMenu.SubMenusItem" ;
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
      oWriter.writeElement("MenuTexto", GXutil.rtrim( gxTv_SdtSDTMenu_SubMenusItem_Menutexto));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("MenuLink", GXutil.rtrim( gxTv_SdtSDTMenu_SubMenusItem_Menulink));
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
      AddObjectProperty("MenuTexto", gxTv_SdtSDTMenu_SubMenusItem_Menutexto, false, false);
      AddObjectProperty("MenuLink", gxTv_SdtSDTMenu_SubMenusItem_Menulink, false, false);
   }

   public String getgxTv_SdtSDTMenu_SubMenusItem_Menutexto( )
   {
      return gxTv_SdtSDTMenu_SubMenusItem_Menutexto ;
   }

   public void setgxTv_SdtSDTMenu_SubMenusItem_Menutexto( String value )
   {
      gxTv_SdtSDTMenu_SubMenusItem_N = (byte)(0) ;
      gxTv_SdtSDTMenu_SubMenusItem_Menutexto = value ;
   }

   public String getgxTv_SdtSDTMenu_SubMenusItem_Menulink( )
   {
      return gxTv_SdtSDTMenu_SubMenusItem_Menulink ;
   }

   public void setgxTv_SdtSDTMenu_SubMenusItem_Menulink( String value )
   {
      gxTv_SdtSDTMenu_SubMenusItem_N = (byte)(0) ;
      gxTv_SdtSDTMenu_SubMenusItem_Menulink = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTMenu_SubMenusItem_Menutexto = "" ;
      gxTv_SdtSDTMenu_SubMenusItem_N = (byte)(1) ;
      gxTv_SdtSDTMenu_SubMenusItem_Menulink = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTMenu_SubMenusItem_N ;
   }

   public com.projectthani.SdtSDTMenu_SubMenusItem Clone( )
   {
      return (com.projectthani.SdtSDTMenu_SubMenusItem)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTMenu_SubMenusItem struct )
   {
      setgxTv_SdtSDTMenu_SubMenusItem_Menutexto(struct.getMenutexto());
      setgxTv_SdtSDTMenu_SubMenusItem_Menulink(struct.getMenulink());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTMenu_SubMenusItem getStruct( )
   {
      com.projectthani.StructSdtSDTMenu_SubMenusItem struct = new com.projectthani.StructSdtSDTMenu_SubMenusItem ();
      struct.setMenutexto(getgxTv_SdtSDTMenu_SubMenusItem_Menutexto());
      struct.setMenulink(getgxTv_SdtSDTMenu_SubMenusItem_Menulink());
      return struct ;
   }

   protected byte gxTv_SdtSDTMenu_SubMenusItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTMenu_SubMenusItem_Menutexto ;
   protected String gxTv_SdtSDTMenu_SubMenusItem_Menulink ;
}

