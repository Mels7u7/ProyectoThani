package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtDVHorizontalMenuData_DVHorizontalMenuItem extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtDVHorizontalMenuData_DVHorizontalMenuItem( )
   {
      this(  new ModelContext(SdtDVHorizontalMenuData_DVHorizontalMenuItem.class));
   }

   public SdtDVHorizontalMenuData_DVHorizontalMenuItem( ModelContext context )
   {
      super( context, "SdtDVHorizontalMenuData_DVHorizontalMenuItem");
   }

   public SdtDVHorizontalMenuData_DVHorizontalMenuItem( int remoteHandle ,
                                                        ModelContext context )
   {
      super( remoteHandle, context, "SdtDVHorizontalMenuData_DVHorizontalMenuItem");
   }

   public SdtDVHorizontalMenuData_DVHorizontalMenuItem( StructSdtDVHorizontalMenuData_DVHorizontalMenuItem struct )
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
               gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Code = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Title") )
            {
               gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Title = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "URL") )
            {
               gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Url = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LinkTarget") )
            {
               gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Linktarget = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Image") )
            {
               gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Image = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Description") )
            {
               gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Description = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Index") )
            {
               gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Index = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SubItems") )
            {
               if ( gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Subitems == null )
               {
                  gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Subitems = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVHorizontalMenuData_DVHorizontalMenuItem>(com.projectthani.wwpbaseobjects.SdtDVHorizontalMenuData_DVHorizontalMenuItem.class, "DVHorizontalMenuItem", "ProjectThani", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Subitems.readxml(oReader, "SubItems") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "SubItems") )
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
         sName = "DVHorizontalMenuData.DVHorizontalMenuItem" ;
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
      oWriter.writeElement("Code", GXutil.rtrim( gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Code));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Title", GXutil.rtrim( gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Title));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("URL", GXutil.rtrim( gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Url));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("LinkTarget", GXutil.rtrim( gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Linktarget));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Image", GXutil.rtrim( gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Image));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Description", GXutil.rtrim( gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Description));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Index", GXutil.trim( GXutil.str( gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Index, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Subitems != null )
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
         gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Subitems.writexml(oWriter, "SubItems", sNameSpace1, sIncludeState);
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
      AddObjectProperty("Code", gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Code, false, false);
      AddObjectProperty("Title", gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Title, false, false);
      AddObjectProperty("URL", gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Url, false, false);
      AddObjectProperty("LinkTarget", gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Linktarget, false, false);
      AddObjectProperty("Image", gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Image, false, false);
      AddObjectProperty("Description", gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Description, false, false);
      AddObjectProperty("Index", gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Index, false, false);
      if ( gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Subitems != null )
      {
         AddObjectProperty("SubItems", gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Subitems, false, false);
      }
   }

   public String getgxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Code( )
   {
      return gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Code ;
   }

   public void setgxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Code( String value )
   {
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_N = (byte)(0) ;
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Code = value ;
   }

   public String getgxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Title( )
   {
      return gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Title ;
   }

   public void setgxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Title( String value )
   {
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_N = (byte)(0) ;
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Title = value ;
   }

   public String getgxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Url( )
   {
      return gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Url ;
   }

   public void setgxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Url( String value )
   {
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_N = (byte)(0) ;
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Url = value ;
   }

   public String getgxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Linktarget( )
   {
      return gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Linktarget ;
   }

   public void setgxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Linktarget( String value )
   {
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_N = (byte)(0) ;
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Linktarget = value ;
   }

   public String getgxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Image( )
   {
      return gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Image ;
   }

   public void setgxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Image( String value )
   {
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_N = (byte)(0) ;
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Image = value ;
   }

   public String getgxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Description( )
   {
      return gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Description ;
   }

   public void setgxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Description( String value )
   {
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_N = (byte)(0) ;
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Description = value ;
   }

   public short getgxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Index( )
   {
      return gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Index ;
   }

   public void setgxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Index( short value )
   {
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_N = (byte)(0) ;
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Index = value ;
   }

   public GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVHorizontalMenuData_DVHorizontalMenuItem> getgxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Subitems( )
   {
      if ( gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Subitems == null )
      {
         gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Subitems = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVHorizontalMenuData_DVHorizontalMenuItem>(com.projectthani.wwpbaseobjects.SdtDVHorizontalMenuData_DVHorizontalMenuItem.class, "DVHorizontalMenuItem", "ProjectThani", remoteHandle);
      }
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Subitems_N = (byte)(0) ;
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_N = (byte)(0) ;
      return gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Subitems ;
   }

   public void setgxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Subitems( GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVHorizontalMenuData_DVHorizontalMenuItem> value )
   {
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Subitems_N = (byte)(0) ;
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_N = (byte)(0) ;
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Subitems = value ;
   }

   public void setgxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Subitems_SetNull( )
   {
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Subitems_N = (byte)(1) ;
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Subitems = null ;
   }

   public boolean getgxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Subitems_IsNull( )
   {
      if ( gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Subitems == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Subitems_N( )
   {
      return gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Subitems_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Code = "" ;
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_N = (byte)(1) ;
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Title = "" ;
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Url = "" ;
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Linktarget = "" ;
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Image = "" ;
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Description = "" ;
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Subitems_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_N ;
   }

   public com.projectthani.wwpbaseobjects.SdtDVHorizontalMenuData_DVHorizontalMenuItem Clone( )
   {
      return (com.projectthani.wwpbaseobjects.SdtDVHorizontalMenuData_DVHorizontalMenuItem)(clone()) ;
   }

   public void setStruct( com.projectthani.wwpbaseobjects.StructSdtDVHorizontalMenuData_DVHorizontalMenuItem struct )
   {
      setgxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Code(struct.getCode());
      setgxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Title(struct.getTitle());
      setgxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Url(struct.getUrl());
      setgxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Linktarget(struct.getLinktarget());
      setgxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Image(struct.getImage());
      setgxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Description(struct.getDescription());
      setgxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Index(struct.getIndex());
      GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVHorizontalMenuData_DVHorizontalMenuItem> gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Subitems_aux = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVHorizontalMenuData_DVHorizontalMenuItem>(com.projectthani.wwpbaseobjects.SdtDVHorizontalMenuData_DVHorizontalMenuItem.class, "DVHorizontalMenuItem", "ProjectThani", remoteHandle);
      Vector<com.projectthani.wwpbaseobjects.StructSdtDVHorizontalMenuData_DVHorizontalMenuItem> gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Subitems_aux1 = struct.getSubitems();
      if (gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Subitems_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Subitems_aux1.size(); i++)
         {
            gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Subitems_aux.add(new com.projectthani.wwpbaseobjects.SdtDVHorizontalMenuData_DVHorizontalMenuItem(gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Subitems_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Subitems(gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Subitems_aux);
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.wwpbaseobjects.StructSdtDVHorizontalMenuData_DVHorizontalMenuItem getStruct( )
   {
      com.projectthani.wwpbaseobjects.StructSdtDVHorizontalMenuData_DVHorizontalMenuItem struct = new com.projectthani.wwpbaseobjects.StructSdtDVHorizontalMenuData_DVHorizontalMenuItem ();
      struct.setCode(getgxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Code());
      struct.setTitle(getgxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Title());
      struct.setUrl(getgxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Url());
      struct.setLinktarget(getgxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Linktarget());
      struct.setImage(getgxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Image());
      struct.setDescription(getgxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Description());
      struct.setIndex(getgxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Index());
      struct.setSubitems(getgxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Subitems().getStruct());
      return struct ;
   }

   protected byte gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_N ;
   protected byte gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Subitems_N ;
   protected short gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Index ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Code ;
   protected String gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Title ;
   protected String gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Url ;
   protected String gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Linktarget ;
   protected String gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Image ;
   protected String gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Description ;
   protected GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVHorizontalMenuData_DVHorizontalMenuItem> gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Subitems_aux ;
   protected GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVHorizontalMenuData_DVHorizontalMenuItem> gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Subitems=null ;
}

