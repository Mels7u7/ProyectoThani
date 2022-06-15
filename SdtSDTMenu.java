package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTMenu extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTMenu( )
   {
      this(  new ModelContext(SdtSDTMenu.class));
   }

   public SdtSDTMenu( ModelContext context )
   {
      super( context, "SdtSDTMenu");
   }

   public SdtSDTMenu( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTMenu");
   }

   public SdtSDTMenu( StructSdtSDTMenu struct )
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
               gxTv_SdtSDTMenu_Menutexto = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MenuLink") )
            {
               gxTv_SdtSDTMenu_Menulink = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SubMenus") )
            {
               if ( gxTv_SdtSDTMenu_Submenus == null )
               {
                  gxTv_SdtSDTMenu_Submenus = new GXBaseCollection<com.projectthani.SdtSDTMenu_SubMenusItem>(com.projectthani.SdtSDTMenu_SubMenusItem.class, "SDTMenu.SubMenusItem", "ProjectThani", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_SdtSDTMenu_Submenus.readxmlcollection(oReader, "SubMenus", "SubMenusItem") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "SubMenus") )
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
         sName = "SDTMenu" ;
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
      oWriter.writeElement("MenuTexto", GXutil.rtrim( gxTv_SdtSDTMenu_Menutexto));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("MenuLink", GXutil.rtrim( gxTv_SdtSDTMenu_Menulink));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( gxTv_SdtSDTMenu_Submenus != null )
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
         gxTv_SdtSDTMenu_Submenus.writexmlcollection(oWriter, "SubMenus", sNameSpace1, "SubMenusItem", sNameSpace1);
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
      AddObjectProperty("MenuTexto", gxTv_SdtSDTMenu_Menutexto, false, false);
      AddObjectProperty("MenuLink", gxTv_SdtSDTMenu_Menulink, false, false);
      if ( gxTv_SdtSDTMenu_Submenus != null )
      {
         AddObjectProperty("SubMenus", gxTv_SdtSDTMenu_Submenus, false, false);
      }
   }

   public String getgxTv_SdtSDTMenu_Menutexto( )
   {
      return gxTv_SdtSDTMenu_Menutexto ;
   }

   public void setgxTv_SdtSDTMenu_Menutexto( String value )
   {
      gxTv_SdtSDTMenu_N = (byte)(0) ;
      gxTv_SdtSDTMenu_Menutexto = value ;
   }

   public String getgxTv_SdtSDTMenu_Menulink( )
   {
      return gxTv_SdtSDTMenu_Menulink ;
   }

   public void setgxTv_SdtSDTMenu_Menulink( String value )
   {
      gxTv_SdtSDTMenu_N = (byte)(0) ;
      gxTv_SdtSDTMenu_Menulink = value ;
   }

   public GXBaseCollection<com.projectthani.SdtSDTMenu_SubMenusItem> getgxTv_SdtSDTMenu_Submenus( )
   {
      if ( gxTv_SdtSDTMenu_Submenus == null )
      {
         gxTv_SdtSDTMenu_Submenus = new GXBaseCollection<com.projectthani.SdtSDTMenu_SubMenusItem>(com.projectthani.SdtSDTMenu_SubMenusItem.class, "SDTMenu.SubMenusItem", "ProjectThani", remoteHandle);
      }
      gxTv_SdtSDTMenu_Submenus_N = (byte)(0) ;
      gxTv_SdtSDTMenu_N = (byte)(0) ;
      return gxTv_SdtSDTMenu_Submenus ;
   }

   public void setgxTv_SdtSDTMenu_Submenus( GXBaseCollection<com.projectthani.SdtSDTMenu_SubMenusItem> value )
   {
      gxTv_SdtSDTMenu_Submenus_N = (byte)(0) ;
      gxTv_SdtSDTMenu_N = (byte)(0) ;
      gxTv_SdtSDTMenu_Submenus = value ;
   }

   public void setgxTv_SdtSDTMenu_Submenus_SetNull( )
   {
      gxTv_SdtSDTMenu_Submenus_N = (byte)(1) ;
      gxTv_SdtSDTMenu_Submenus = null ;
   }

   public boolean getgxTv_SdtSDTMenu_Submenus_IsNull( )
   {
      if ( gxTv_SdtSDTMenu_Submenus == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtSDTMenu_Submenus_N( )
   {
      return gxTv_SdtSDTMenu_Submenus_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTMenu_Menutexto = "" ;
      gxTv_SdtSDTMenu_N = (byte)(1) ;
      gxTv_SdtSDTMenu_Menulink = "" ;
      gxTv_SdtSDTMenu_Submenus_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTMenu_N ;
   }

   public com.projectthani.SdtSDTMenu Clone( )
   {
      return (com.projectthani.SdtSDTMenu)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTMenu struct )
   {
      setgxTv_SdtSDTMenu_Menutexto(struct.getMenutexto());
      setgxTv_SdtSDTMenu_Menulink(struct.getMenulink());
      GXBaseCollection<com.projectthani.SdtSDTMenu_SubMenusItem> gxTv_SdtSDTMenu_Submenus_aux = new GXBaseCollection<com.projectthani.SdtSDTMenu_SubMenusItem>(com.projectthani.SdtSDTMenu_SubMenusItem.class, "SDTMenu.SubMenusItem", "ProjectThani", remoteHandle);
      Vector<com.projectthani.StructSdtSDTMenu_SubMenusItem> gxTv_SdtSDTMenu_Submenus_aux1 = struct.getSubmenus();
      if (gxTv_SdtSDTMenu_Submenus_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtSDTMenu_Submenus_aux1.size(); i++)
         {
            gxTv_SdtSDTMenu_Submenus_aux.add(new com.projectthani.SdtSDTMenu_SubMenusItem(gxTv_SdtSDTMenu_Submenus_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtSDTMenu_Submenus(gxTv_SdtSDTMenu_Submenus_aux);
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTMenu getStruct( )
   {
      com.projectthani.StructSdtSDTMenu struct = new com.projectthani.StructSdtSDTMenu ();
      struct.setMenutexto(getgxTv_SdtSDTMenu_Menutexto());
      struct.setMenulink(getgxTv_SdtSDTMenu_Menulink());
      struct.setSubmenus(getgxTv_SdtSDTMenu_Submenus().getStruct());
      return struct ;
   }

   protected byte gxTv_SdtSDTMenu_N ;
   protected byte gxTv_SdtSDTMenu_Submenus_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTMenu_Menutexto ;
   protected String gxTv_SdtSDTMenu_Menulink ;
   protected GXBaseCollection<com.projectthani.SdtSDTMenu_SubMenusItem> gxTv_SdtSDTMenu_Submenus_aux ;
   protected GXBaseCollection<com.projectthani.SdtSDTMenu_SubMenusItem> gxTv_SdtSDTMenu_Submenus=null ;
}

