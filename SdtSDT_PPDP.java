package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDT_PPDP extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDT_PPDP( )
   {
      this(  new ModelContext(SdtSDT_PPDP.class));
   }

   public SdtSDT_PPDP( ModelContext context )
   {
      super( context, "SdtSDT_PPDP");
   }

   public SdtSDT_PPDP( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle, context, "SdtSDT_PPDP");
   }

   public SdtSDT_PPDP( StructSdtSDT_PPDP struct )
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
               gxTv_SdtSDT_PPDP_Titulo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Descripcion") )
            {
               gxTv_SdtSDT_PPDP_Descripcion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDT_PPDP_Sub") )
            {
               if ( gxTv_SdtSDT_PPDP_Sdt_ppdp_sub == null )
               {
                  gxTv_SdtSDT_PPDP_Sdt_ppdp_sub = new GXBaseCollection<com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem>(com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem.class, "SDT_PPDP.SDT_PPDP_SubItem", "ProjectThani", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_SdtSDT_PPDP_Sdt_ppdp_sub.readxmlcollection(oReader, "SDT_PPDP_Sub", "SDT_PPDP_SubItem") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "SDT_PPDP_Sub") )
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
         sName = "SDT_PPDP" ;
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
      oWriter.writeElement("Titulo", GXutil.rtrim( gxTv_SdtSDT_PPDP_Titulo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Descripcion", GXutil.rtrim( gxTv_SdtSDT_PPDP_Descripcion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( gxTv_SdtSDT_PPDP_Sdt_ppdp_sub != null )
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
         gxTv_SdtSDT_PPDP_Sdt_ppdp_sub.writexmlcollection(oWriter, "SDT_PPDP_Sub", sNameSpace1, "SDT_PPDP_SubItem", sNameSpace1);
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
      AddObjectProperty("Titulo", gxTv_SdtSDT_PPDP_Titulo, false, false);
      AddObjectProperty("Descripcion", gxTv_SdtSDT_PPDP_Descripcion, false, false);
      if ( gxTv_SdtSDT_PPDP_Sdt_ppdp_sub != null )
      {
         AddObjectProperty("SDT_PPDP_Sub", gxTv_SdtSDT_PPDP_Sdt_ppdp_sub, false, false);
      }
   }

   public String getgxTv_SdtSDT_PPDP_Titulo( )
   {
      return gxTv_SdtSDT_PPDP_Titulo ;
   }

   public void setgxTv_SdtSDT_PPDP_Titulo( String value )
   {
      gxTv_SdtSDT_PPDP_N = (byte)(0) ;
      gxTv_SdtSDT_PPDP_Titulo = value ;
   }

   public String getgxTv_SdtSDT_PPDP_Descripcion( )
   {
      return gxTv_SdtSDT_PPDP_Descripcion ;
   }

   public void setgxTv_SdtSDT_PPDP_Descripcion( String value )
   {
      gxTv_SdtSDT_PPDP_N = (byte)(0) ;
      gxTv_SdtSDT_PPDP_Descripcion = value ;
   }

   public GXBaseCollection<com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem> getgxTv_SdtSDT_PPDP_Sdt_ppdp_sub( )
   {
      if ( gxTv_SdtSDT_PPDP_Sdt_ppdp_sub == null )
      {
         gxTv_SdtSDT_PPDP_Sdt_ppdp_sub = new GXBaseCollection<com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem>(com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem.class, "SDT_PPDP.SDT_PPDP_SubItem", "ProjectThani", remoteHandle);
      }
      gxTv_SdtSDT_PPDP_Sdt_ppdp_sub_N = (byte)(0) ;
      gxTv_SdtSDT_PPDP_N = (byte)(0) ;
      return gxTv_SdtSDT_PPDP_Sdt_ppdp_sub ;
   }

   public void setgxTv_SdtSDT_PPDP_Sdt_ppdp_sub( GXBaseCollection<com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem> value )
   {
      gxTv_SdtSDT_PPDP_Sdt_ppdp_sub_N = (byte)(0) ;
      gxTv_SdtSDT_PPDP_N = (byte)(0) ;
      gxTv_SdtSDT_PPDP_Sdt_ppdp_sub = value ;
   }

   public void setgxTv_SdtSDT_PPDP_Sdt_ppdp_sub_SetNull( )
   {
      gxTv_SdtSDT_PPDP_Sdt_ppdp_sub_N = (byte)(1) ;
      gxTv_SdtSDT_PPDP_Sdt_ppdp_sub = null ;
   }

   public boolean getgxTv_SdtSDT_PPDP_Sdt_ppdp_sub_IsNull( )
   {
      if ( gxTv_SdtSDT_PPDP_Sdt_ppdp_sub == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtSDT_PPDP_Sdt_ppdp_sub_N( )
   {
      return gxTv_SdtSDT_PPDP_Sdt_ppdp_sub_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDT_PPDP_Titulo = "" ;
      gxTv_SdtSDT_PPDP_N = (byte)(1) ;
      gxTv_SdtSDT_PPDP_Descripcion = "" ;
      gxTv_SdtSDT_PPDP_Sdt_ppdp_sub_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDT_PPDP_N ;
   }

   public com.projectthani.SdtSDT_PPDP Clone( )
   {
      return (com.projectthani.SdtSDT_PPDP)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDT_PPDP struct )
   {
      setgxTv_SdtSDT_PPDP_Titulo(struct.getTitulo());
      setgxTv_SdtSDT_PPDP_Descripcion(struct.getDescripcion());
      GXBaseCollection<com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem> gxTv_SdtSDT_PPDP_Sdt_ppdp_sub_aux = new GXBaseCollection<com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem>(com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem.class, "SDT_PPDP.SDT_PPDP_SubItem", "ProjectThani", remoteHandle);
      Vector<com.projectthani.StructSdtSDT_PPDP_SDT_PPDP_SubItem> gxTv_SdtSDT_PPDP_Sdt_ppdp_sub_aux1 = struct.getSdt_ppdp_sub();
      if (gxTv_SdtSDT_PPDP_Sdt_ppdp_sub_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtSDT_PPDP_Sdt_ppdp_sub_aux1.size(); i++)
         {
            gxTv_SdtSDT_PPDP_Sdt_ppdp_sub_aux.add(new com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem(gxTv_SdtSDT_PPDP_Sdt_ppdp_sub_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtSDT_PPDP_Sdt_ppdp_sub(gxTv_SdtSDT_PPDP_Sdt_ppdp_sub_aux);
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDT_PPDP getStruct( )
   {
      com.projectthani.StructSdtSDT_PPDP struct = new com.projectthani.StructSdtSDT_PPDP ();
      struct.setTitulo(getgxTv_SdtSDT_PPDP_Titulo());
      struct.setDescripcion(getgxTv_SdtSDT_PPDP_Descripcion());
      struct.setSdt_ppdp_sub(getgxTv_SdtSDT_PPDP_Sdt_ppdp_sub().getStruct());
      return struct ;
   }

   protected byte gxTv_SdtSDT_PPDP_N ;
   protected byte gxTv_SdtSDT_PPDP_Sdt_ppdp_sub_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDT_PPDP_Titulo ;
   protected String gxTv_SdtSDT_PPDP_Descripcion ;
   protected GXBaseCollection<com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem> gxTv_SdtSDT_PPDP_Sdt_ppdp_sub_aux ;
   protected GXBaseCollection<com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem> gxTv_SdtSDT_PPDP_Sdt_ppdp_sub=null ;
}
