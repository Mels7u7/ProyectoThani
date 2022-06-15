package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtTabsMenuData_TabsMenuDataItem extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtTabsMenuData_TabsMenuDataItem( )
   {
      this(  new ModelContext(SdtTabsMenuData_TabsMenuDataItem.class));
   }

   public SdtTabsMenuData_TabsMenuDataItem( ModelContext context )
   {
      super( context, "SdtTabsMenuData_TabsMenuDataItem");
   }

   public SdtTabsMenuData_TabsMenuDataItem( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle, context, "SdtTabsMenuData_TabsMenuDataItem");
   }

   public SdtTabsMenuData_TabsMenuDataItem( StructSdtTabsMenuData_TabsMenuDataItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "MenuId") )
            {
               gxTv_SdtTabsMenuData_TabsMenuDataItem_Menuid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MenuTitle") )
            {
               gxTv_SdtTabsMenuData_TabsMenuDataItem_Menutitle = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MenuDescription") )
            {
               gxTv_SdtTabsMenuData_TabsMenuDataItem_Menudescription = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MenuURL") )
            {
               gxTv_SdtTabsMenuData_TabsMenuDataItem_Menuurl = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Sections") )
            {
               if ( gxTv_SdtTabsMenuData_TabsMenuDataItem_Sections == null )
               {
                  gxTv_SdtTabsMenuData_TabsMenuDataItem_Sections = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtTabsMenuData_TabsMenuDataItem_SectionsItem>(com.projectthani.wwpbaseobjects.SdtTabsMenuData_TabsMenuDataItem_SectionsItem.class, "TabsMenuData.TabsMenuDataItem.SectionsItem", "ProjectThani", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_SdtTabsMenuData_TabsMenuDataItem_Sections.readxmlcollection(oReader, "Sections", "SectionsItem") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Sections") )
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
         sName = "TabsMenuData.TabsMenuDataItem" ;
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
      oWriter.writeElement("MenuId", GXutil.trim( GXutil.str( gxTv_SdtTabsMenuData_TabsMenuDataItem_Menuid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("MenuTitle", GXutil.rtrim( gxTv_SdtTabsMenuData_TabsMenuDataItem_Menutitle));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("MenuDescription", GXutil.rtrim( gxTv_SdtTabsMenuData_TabsMenuDataItem_Menudescription));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("MenuURL", GXutil.rtrim( gxTv_SdtTabsMenuData_TabsMenuDataItem_Menuurl));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( gxTv_SdtTabsMenuData_TabsMenuDataItem_Sections != null )
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
         gxTv_SdtTabsMenuData_TabsMenuDataItem_Sections.writexmlcollection(oWriter, "Sections", sNameSpace1, "SectionsItem", sNameSpace1);
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
      AddObjectProperty("MenuId", gxTv_SdtTabsMenuData_TabsMenuDataItem_Menuid, false, false);
      AddObjectProperty("MenuTitle", gxTv_SdtTabsMenuData_TabsMenuDataItem_Menutitle, false, false);
      AddObjectProperty("MenuDescription", gxTv_SdtTabsMenuData_TabsMenuDataItem_Menudescription, false, false);
      AddObjectProperty("MenuURL", gxTv_SdtTabsMenuData_TabsMenuDataItem_Menuurl, false, false);
      if ( gxTv_SdtTabsMenuData_TabsMenuDataItem_Sections != null )
      {
         AddObjectProperty("Sections", gxTv_SdtTabsMenuData_TabsMenuDataItem_Sections, false, false);
      }
   }

   public short getgxTv_SdtTabsMenuData_TabsMenuDataItem_Menuid( )
   {
      return gxTv_SdtTabsMenuData_TabsMenuDataItem_Menuid ;
   }

   public void setgxTv_SdtTabsMenuData_TabsMenuDataItem_Menuid( short value )
   {
      gxTv_SdtTabsMenuData_TabsMenuDataItem_N = (byte)(0) ;
      gxTv_SdtTabsMenuData_TabsMenuDataItem_Menuid = value ;
   }

   public String getgxTv_SdtTabsMenuData_TabsMenuDataItem_Menutitle( )
   {
      return gxTv_SdtTabsMenuData_TabsMenuDataItem_Menutitle ;
   }

   public void setgxTv_SdtTabsMenuData_TabsMenuDataItem_Menutitle( String value )
   {
      gxTv_SdtTabsMenuData_TabsMenuDataItem_N = (byte)(0) ;
      gxTv_SdtTabsMenuData_TabsMenuDataItem_Menutitle = value ;
   }

   public String getgxTv_SdtTabsMenuData_TabsMenuDataItem_Menudescription( )
   {
      return gxTv_SdtTabsMenuData_TabsMenuDataItem_Menudescription ;
   }

   public void setgxTv_SdtTabsMenuData_TabsMenuDataItem_Menudescription( String value )
   {
      gxTv_SdtTabsMenuData_TabsMenuDataItem_N = (byte)(0) ;
      gxTv_SdtTabsMenuData_TabsMenuDataItem_Menudescription = value ;
   }

   public String getgxTv_SdtTabsMenuData_TabsMenuDataItem_Menuurl( )
   {
      return gxTv_SdtTabsMenuData_TabsMenuDataItem_Menuurl ;
   }

   public void setgxTv_SdtTabsMenuData_TabsMenuDataItem_Menuurl( String value )
   {
      gxTv_SdtTabsMenuData_TabsMenuDataItem_N = (byte)(0) ;
      gxTv_SdtTabsMenuData_TabsMenuDataItem_Menuurl = value ;
   }

   public GXBaseCollection<com.projectthani.wwpbaseobjects.SdtTabsMenuData_TabsMenuDataItem_SectionsItem> getgxTv_SdtTabsMenuData_TabsMenuDataItem_Sections( )
   {
      if ( gxTv_SdtTabsMenuData_TabsMenuDataItem_Sections == null )
      {
         gxTv_SdtTabsMenuData_TabsMenuDataItem_Sections = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtTabsMenuData_TabsMenuDataItem_SectionsItem>(com.projectthani.wwpbaseobjects.SdtTabsMenuData_TabsMenuDataItem_SectionsItem.class, "TabsMenuData.TabsMenuDataItem.SectionsItem", "ProjectThani", remoteHandle);
      }
      gxTv_SdtTabsMenuData_TabsMenuDataItem_Sections_N = (byte)(0) ;
      gxTv_SdtTabsMenuData_TabsMenuDataItem_N = (byte)(0) ;
      return gxTv_SdtTabsMenuData_TabsMenuDataItem_Sections ;
   }

   public void setgxTv_SdtTabsMenuData_TabsMenuDataItem_Sections( GXBaseCollection<com.projectthani.wwpbaseobjects.SdtTabsMenuData_TabsMenuDataItem_SectionsItem> value )
   {
      gxTv_SdtTabsMenuData_TabsMenuDataItem_Sections_N = (byte)(0) ;
      gxTv_SdtTabsMenuData_TabsMenuDataItem_N = (byte)(0) ;
      gxTv_SdtTabsMenuData_TabsMenuDataItem_Sections = value ;
   }

   public void setgxTv_SdtTabsMenuData_TabsMenuDataItem_Sections_SetNull( )
   {
      gxTv_SdtTabsMenuData_TabsMenuDataItem_Sections_N = (byte)(1) ;
      gxTv_SdtTabsMenuData_TabsMenuDataItem_Sections = null ;
   }

   public boolean getgxTv_SdtTabsMenuData_TabsMenuDataItem_Sections_IsNull( )
   {
      if ( gxTv_SdtTabsMenuData_TabsMenuDataItem_Sections == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtTabsMenuData_TabsMenuDataItem_Sections_N( )
   {
      return gxTv_SdtTabsMenuData_TabsMenuDataItem_Sections_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtTabsMenuData_TabsMenuDataItem_N = (byte)(1) ;
      gxTv_SdtTabsMenuData_TabsMenuDataItem_Menutitle = "" ;
      gxTv_SdtTabsMenuData_TabsMenuDataItem_Menudescription = "" ;
      gxTv_SdtTabsMenuData_TabsMenuDataItem_Menuurl = "" ;
      gxTv_SdtTabsMenuData_TabsMenuDataItem_Sections_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtTabsMenuData_TabsMenuDataItem_N ;
   }

   public com.projectthani.wwpbaseobjects.SdtTabsMenuData_TabsMenuDataItem Clone( )
   {
      return (com.projectthani.wwpbaseobjects.SdtTabsMenuData_TabsMenuDataItem)(clone()) ;
   }

   public void setStruct( com.projectthani.wwpbaseobjects.StructSdtTabsMenuData_TabsMenuDataItem struct )
   {
      setgxTv_SdtTabsMenuData_TabsMenuDataItem_Menuid(struct.getMenuid());
      setgxTv_SdtTabsMenuData_TabsMenuDataItem_Menutitle(struct.getMenutitle());
      setgxTv_SdtTabsMenuData_TabsMenuDataItem_Menudescription(struct.getMenudescription());
      setgxTv_SdtTabsMenuData_TabsMenuDataItem_Menuurl(struct.getMenuurl());
      GXBaseCollection<com.projectthani.wwpbaseobjects.SdtTabsMenuData_TabsMenuDataItem_SectionsItem> gxTv_SdtTabsMenuData_TabsMenuDataItem_Sections_aux = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtTabsMenuData_TabsMenuDataItem_SectionsItem>(com.projectthani.wwpbaseobjects.SdtTabsMenuData_TabsMenuDataItem_SectionsItem.class, "TabsMenuData.TabsMenuDataItem.SectionsItem", "ProjectThani", remoteHandle);
      Vector<com.projectthani.wwpbaseobjects.StructSdtTabsMenuData_TabsMenuDataItem_SectionsItem> gxTv_SdtTabsMenuData_TabsMenuDataItem_Sections_aux1 = struct.getSections();
      if (gxTv_SdtTabsMenuData_TabsMenuDataItem_Sections_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtTabsMenuData_TabsMenuDataItem_Sections_aux1.size(); i++)
         {
            gxTv_SdtTabsMenuData_TabsMenuDataItem_Sections_aux.add(new com.projectthani.wwpbaseobjects.SdtTabsMenuData_TabsMenuDataItem_SectionsItem(gxTv_SdtTabsMenuData_TabsMenuDataItem_Sections_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtTabsMenuData_TabsMenuDataItem_Sections(gxTv_SdtTabsMenuData_TabsMenuDataItem_Sections_aux);
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.wwpbaseobjects.StructSdtTabsMenuData_TabsMenuDataItem getStruct( )
   {
      com.projectthani.wwpbaseobjects.StructSdtTabsMenuData_TabsMenuDataItem struct = new com.projectthani.wwpbaseobjects.StructSdtTabsMenuData_TabsMenuDataItem ();
      struct.setMenuid(getgxTv_SdtTabsMenuData_TabsMenuDataItem_Menuid());
      struct.setMenutitle(getgxTv_SdtTabsMenuData_TabsMenuDataItem_Menutitle());
      struct.setMenudescription(getgxTv_SdtTabsMenuData_TabsMenuDataItem_Menudescription());
      struct.setMenuurl(getgxTv_SdtTabsMenuData_TabsMenuDataItem_Menuurl());
      struct.setSections(getgxTv_SdtTabsMenuData_TabsMenuDataItem_Sections().getStruct());
      return struct ;
   }

   protected byte gxTv_SdtTabsMenuData_TabsMenuDataItem_N ;
   protected byte gxTv_SdtTabsMenuData_TabsMenuDataItem_Sections_N ;
   protected short gxTv_SdtTabsMenuData_TabsMenuDataItem_Menuid ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtTabsMenuData_TabsMenuDataItem_Menutitle ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtTabsMenuData_TabsMenuDataItem_Menudescription ;
   protected String gxTv_SdtTabsMenuData_TabsMenuDataItem_Menuurl ;
   protected GXBaseCollection<com.projectthani.wwpbaseobjects.SdtTabsMenuData_TabsMenuDataItem_SectionsItem> gxTv_SdtTabsMenuData_TabsMenuDataItem_Sections_aux ;
   protected GXBaseCollection<com.projectthani.wwpbaseobjects.SdtTabsMenuData_TabsMenuDataItem_SectionsItem> gxTv_SdtTabsMenuData_TabsMenuDataItem_Sections=null ;
}

