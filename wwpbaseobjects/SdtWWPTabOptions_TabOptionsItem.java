package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtWWPTabOptions_TabOptionsItem extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtWWPTabOptions_TabOptionsItem( )
   {
      this(  new ModelContext(SdtWWPTabOptions_TabOptionsItem.class));
   }

   public SdtWWPTabOptions_TabOptionsItem( ModelContext context )
   {
      super( context, "SdtWWPTabOptions_TabOptionsItem");
   }

   public SdtWWPTabOptions_TabOptionsItem( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle, context, "SdtWWPTabOptions_TabOptionsItem");
   }

   public SdtWWPTabOptions_TabOptionsItem( StructSdtWWPTabOptions_TabOptionsItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Code") )
            {
               gxTv_SdtWWPTabOptions_TabOptionsItem_Code = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Description") )
            {
               gxTv_SdtWWPTabOptions_TabOptionsItem_Description = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Link") )
            {
               gxTv_SdtWWPTabOptions_TabOptionsItem_Link = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WebComponent") )
            {
               gxTv_SdtWWPTabOptions_TabOptionsItem_Webcomponent = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "IncludeInPanel") )
            {
               gxTv_SdtWWPTabOptions_TabOptionsItem_Includeinpanel = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CollapsedByDefault") )
            {
               gxTv_SdtWWPTabOptions_TabOptionsItem_Collapsedbydefault = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Collapsable") )
            {
               gxTv_SdtWWPTabOptions_TabOptionsItem_Collapsable = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
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
         sName = "WWPTabOptions.TabOptionsItem" ;
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
      oWriter.writeElement("Code", GXutil.rtrim( gxTv_SdtWWPTabOptions_TabOptionsItem_Code));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Description", GXutil.rtrim( gxTv_SdtWWPTabOptions_TabOptionsItem_Description));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Link", GXutil.rtrim( gxTv_SdtWWPTabOptions_TabOptionsItem_Link));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("WebComponent", GXutil.rtrim( gxTv_SdtWWPTabOptions_TabOptionsItem_Webcomponent));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("IncludeInPanel", GXutil.trim( GXutil.str( gxTv_SdtWWPTabOptions_TabOptionsItem_Includeinpanel, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CollapsedByDefault", GXutil.rtrim( GXutil.booltostr( gxTv_SdtWWPTabOptions_TabOptionsItem_Collapsedbydefault)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Collapsable", GXutil.rtrim( GXutil.booltostr( gxTv_SdtWWPTabOptions_TabOptionsItem_Collapsable)));
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
      AddObjectProperty("Code", gxTv_SdtWWPTabOptions_TabOptionsItem_Code, false, false);
      AddObjectProperty("Description", gxTv_SdtWWPTabOptions_TabOptionsItem_Description, false, false);
      AddObjectProperty("Link", gxTv_SdtWWPTabOptions_TabOptionsItem_Link, false, false);
      AddObjectProperty("WebComponent", gxTv_SdtWWPTabOptions_TabOptionsItem_Webcomponent, false, false);
      AddObjectProperty("IncludeInPanel", gxTv_SdtWWPTabOptions_TabOptionsItem_Includeinpanel, false, false);
      AddObjectProperty("CollapsedByDefault", gxTv_SdtWWPTabOptions_TabOptionsItem_Collapsedbydefault, false, false);
      AddObjectProperty("Collapsable", gxTv_SdtWWPTabOptions_TabOptionsItem_Collapsable, false, false);
   }

   public String getgxTv_SdtWWPTabOptions_TabOptionsItem_Code( )
   {
      return gxTv_SdtWWPTabOptions_TabOptionsItem_Code ;
   }

   public void setgxTv_SdtWWPTabOptions_TabOptionsItem_Code( String value )
   {
      gxTv_SdtWWPTabOptions_TabOptionsItem_N = (byte)(0) ;
      gxTv_SdtWWPTabOptions_TabOptionsItem_Code = value ;
   }

   public String getgxTv_SdtWWPTabOptions_TabOptionsItem_Description( )
   {
      return gxTv_SdtWWPTabOptions_TabOptionsItem_Description ;
   }

   public void setgxTv_SdtWWPTabOptions_TabOptionsItem_Description( String value )
   {
      gxTv_SdtWWPTabOptions_TabOptionsItem_N = (byte)(0) ;
      gxTv_SdtWWPTabOptions_TabOptionsItem_Description = value ;
   }

   public String getgxTv_SdtWWPTabOptions_TabOptionsItem_Link( )
   {
      return gxTv_SdtWWPTabOptions_TabOptionsItem_Link ;
   }

   public void setgxTv_SdtWWPTabOptions_TabOptionsItem_Link( String value )
   {
      gxTv_SdtWWPTabOptions_TabOptionsItem_N = (byte)(0) ;
      gxTv_SdtWWPTabOptions_TabOptionsItem_Link = value ;
   }

   public String getgxTv_SdtWWPTabOptions_TabOptionsItem_Webcomponent( )
   {
      return gxTv_SdtWWPTabOptions_TabOptionsItem_Webcomponent ;
   }

   public void setgxTv_SdtWWPTabOptions_TabOptionsItem_Webcomponent( String value )
   {
      gxTv_SdtWWPTabOptions_TabOptionsItem_N = (byte)(0) ;
      gxTv_SdtWWPTabOptions_TabOptionsItem_Webcomponent = value ;
   }

   public byte getgxTv_SdtWWPTabOptions_TabOptionsItem_Includeinpanel( )
   {
      return gxTv_SdtWWPTabOptions_TabOptionsItem_Includeinpanel ;
   }

   public void setgxTv_SdtWWPTabOptions_TabOptionsItem_Includeinpanel( byte value )
   {
      gxTv_SdtWWPTabOptions_TabOptionsItem_N = (byte)(0) ;
      gxTv_SdtWWPTabOptions_TabOptionsItem_Includeinpanel = value ;
   }

   public boolean getgxTv_SdtWWPTabOptions_TabOptionsItem_Collapsedbydefault( )
   {
      return gxTv_SdtWWPTabOptions_TabOptionsItem_Collapsedbydefault ;
   }

   public void setgxTv_SdtWWPTabOptions_TabOptionsItem_Collapsedbydefault( boolean value )
   {
      gxTv_SdtWWPTabOptions_TabOptionsItem_N = (byte)(0) ;
      gxTv_SdtWWPTabOptions_TabOptionsItem_Collapsedbydefault = value ;
   }

   public boolean getgxTv_SdtWWPTabOptions_TabOptionsItem_Collapsable( )
   {
      return gxTv_SdtWWPTabOptions_TabOptionsItem_Collapsable ;
   }

   public void setgxTv_SdtWWPTabOptions_TabOptionsItem_Collapsable( boolean value )
   {
      gxTv_SdtWWPTabOptions_TabOptionsItem_N = (byte)(0) ;
      gxTv_SdtWWPTabOptions_TabOptionsItem_Collapsable = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtWWPTabOptions_TabOptionsItem_Code = "" ;
      gxTv_SdtWWPTabOptions_TabOptionsItem_N = (byte)(1) ;
      gxTv_SdtWWPTabOptions_TabOptionsItem_Description = "" ;
      gxTv_SdtWWPTabOptions_TabOptionsItem_Link = "" ;
      gxTv_SdtWWPTabOptions_TabOptionsItem_Webcomponent = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtWWPTabOptions_TabOptionsItem_N ;
   }

   public com.projectthani.wwpbaseobjects.SdtWWPTabOptions_TabOptionsItem Clone( )
   {
      return (com.projectthani.wwpbaseobjects.SdtWWPTabOptions_TabOptionsItem)(clone()) ;
   }

   public void setStruct( com.projectthani.wwpbaseobjects.StructSdtWWPTabOptions_TabOptionsItem struct )
   {
      setgxTv_SdtWWPTabOptions_TabOptionsItem_Code(struct.getCode());
      setgxTv_SdtWWPTabOptions_TabOptionsItem_Description(struct.getDescription());
      setgxTv_SdtWWPTabOptions_TabOptionsItem_Link(struct.getLink());
      setgxTv_SdtWWPTabOptions_TabOptionsItem_Webcomponent(struct.getWebcomponent());
      setgxTv_SdtWWPTabOptions_TabOptionsItem_Includeinpanel(struct.getIncludeinpanel());
      setgxTv_SdtWWPTabOptions_TabOptionsItem_Collapsedbydefault(struct.getCollapsedbydefault());
      setgxTv_SdtWWPTabOptions_TabOptionsItem_Collapsable(struct.getCollapsable());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.wwpbaseobjects.StructSdtWWPTabOptions_TabOptionsItem getStruct( )
   {
      com.projectthani.wwpbaseobjects.StructSdtWWPTabOptions_TabOptionsItem struct = new com.projectthani.wwpbaseobjects.StructSdtWWPTabOptions_TabOptionsItem ();
      struct.setCode(getgxTv_SdtWWPTabOptions_TabOptionsItem_Code());
      struct.setDescription(getgxTv_SdtWWPTabOptions_TabOptionsItem_Description());
      struct.setLink(getgxTv_SdtWWPTabOptions_TabOptionsItem_Link());
      struct.setWebcomponent(getgxTv_SdtWWPTabOptions_TabOptionsItem_Webcomponent());
      struct.setIncludeinpanel(getgxTv_SdtWWPTabOptions_TabOptionsItem_Includeinpanel());
      struct.setCollapsedbydefault(getgxTv_SdtWWPTabOptions_TabOptionsItem_Collapsedbydefault());
      struct.setCollapsable(getgxTv_SdtWWPTabOptions_TabOptionsItem_Collapsable());
      return struct ;
   }

   protected byte gxTv_SdtWWPTabOptions_TabOptionsItem_N ;
   protected byte gxTv_SdtWWPTabOptions_TabOptionsItem_Includeinpanel ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtWWPTabOptions_TabOptionsItem_Code ;
   protected String sTagName ;
   protected boolean gxTv_SdtWWPTabOptions_TabOptionsItem_Collapsedbydefault ;
   protected boolean gxTv_SdtWWPTabOptions_TabOptionsItem_Collapsable ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtWWPTabOptions_TabOptionsItem_Description ;
   protected String gxTv_SdtWWPTabOptions_TabOptionsItem_Link ;
   protected String gxTv_SdtWWPTabOptions_TabOptionsItem_Webcomponent ;
}

