package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtTabsMenuData_TabsMenuDataItem_SectionsItem extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtTabsMenuData_TabsMenuDataItem_SectionsItem( )
   {
      this(  new ModelContext(SdtTabsMenuData_TabsMenuDataItem_SectionsItem.class));
   }

   public SdtTabsMenuData_TabsMenuDataItem_SectionsItem( ModelContext context )
   {
      super( context, "SdtTabsMenuData_TabsMenuDataItem_SectionsItem");
   }

   public SdtTabsMenuData_TabsMenuDataItem_SectionsItem( int remoteHandle ,
                                                         ModelContext context )
   {
      super( remoteHandle, context, "SdtTabsMenuData_TabsMenuDataItem_SectionsItem");
   }

   public SdtTabsMenuData_TabsMenuDataItem_SectionsItem( StructSdtTabsMenuData_TabsMenuDataItem_SectionsItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "SectionId") )
            {
               gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectionid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SectionTitle") )
            {
               gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectiontitle = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SectionDescription") )
            {
               gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectiondescription = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SectionURL") )
            {
               gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectionurl = oReader.getValue() ;
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
         sName = "TabsMenuData.TabsMenuDataItem.SectionsItem" ;
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
      oWriter.writeElement("SectionId", GXutil.trim( GXutil.str( gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectionid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SectionTitle", GXutil.rtrim( gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectiontitle));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SectionDescription", GXutil.rtrim( gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectiondescription));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SectionURL", GXutil.rtrim( gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectionurl));
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
      AddObjectProperty("SectionId", gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectionid, false, false);
      AddObjectProperty("SectionTitle", gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectiontitle, false, false);
      AddObjectProperty("SectionDescription", gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectiondescription, false, false);
      AddObjectProperty("SectionURL", gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectionurl, false, false);
   }

   public short getgxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectionid( )
   {
      return gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectionid ;
   }

   public void setgxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectionid( short value )
   {
      gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_N = (byte)(0) ;
      gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectionid = value ;
   }

   public String getgxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectiontitle( )
   {
      return gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectiontitle ;
   }

   public void setgxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectiontitle( String value )
   {
      gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_N = (byte)(0) ;
      gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectiontitle = value ;
   }

   public String getgxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectiondescription( )
   {
      return gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectiondescription ;
   }

   public void setgxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectiondescription( String value )
   {
      gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_N = (byte)(0) ;
      gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectiondescription = value ;
   }

   public String getgxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectionurl( )
   {
      return gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectionurl ;
   }

   public void setgxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectionurl( String value )
   {
      gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_N = (byte)(0) ;
      gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectionurl = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_N = (byte)(1) ;
      gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectiontitle = "" ;
      gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectiondescription = "" ;
      gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectionurl = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_N ;
   }

   public com.projectthani.wwpbaseobjects.SdtTabsMenuData_TabsMenuDataItem_SectionsItem Clone( )
   {
      return (com.projectthani.wwpbaseobjects.SdtTabsMenuData_TabsMenuDataItem_SectionsItem)(clone()) ;
   }

   public void setStruct( com.projectthani.wwpbaseobjects.StructSdtTabsMenuData_TabsMenuDataItem_SectionsItem struct )
   {
      setgxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectionid(struct.getSectionid());
      setgxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectiontitle(struct.getSectiontitle());
      setgxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectiondescription(struct.getSectiondescription());
      setgxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectionurl(struct.getSectionurl());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.wwpbaseobjects.StructSdtTabsMenuData_TabsMenuDataItem_SectionsItem getStruct( )
   {
      com.projectthani.wwpbaseobjects.StructSdtTabsMenuData_TabsMenuDataItem_SectionsItem struct = new com.projectthani.wwpbaseobjects.StructSdtTabsMenuData_TabsMenuDataItem_SectionsItem ();
      struct.setSectionid(getgxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectionid());
      struct.setSectiontitle(getgxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectiontitle());
      struct.setSectiondescription(getgxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectiondescription());
      struct.setSectionurl(getgxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectionurl());
      return struct ;
   }

   protected byte gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_N ;
   protected short gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectionid ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectiontitle ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectiondescription ;
   protected String gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectionurl ;
}

