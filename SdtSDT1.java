package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDT1 extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDT1( )
   {
      this(  new ModelContext(SdtSDT1.class));
   }

   public SdtSDT1( ModelContext context )
   {
      super( context, "SdtSDT1");
   }

   public SdtSDT1( int remoteHandle ,
                   ModelContext context )
   {
      super( remoteHandle, context, "SdtSDT1");
   }

   public SdtSDT1( StructSdtSDT1 struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Link") )
            {
               gxTv_SdtSDT1_Link = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Descripcion") )
            {
               gxTv_SdtSDT1_Descripcion = oReader.getValue() ;
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
         sName = "SDT1" ;
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
      oWriter.writeElement("Link", GXutil.rtrim( gxTv_SdtSDT1_Link));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Descripcion", GXutil.rtrim( gxTv_SdtSDT1_Descripcion));
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
      AddObjectProperty("Link", gxTv_SdtSDT1_Link, false, false);
      AddObjectProperty("Descripcion", gxTv_SdtSDT1_Descripcion, false, false);
   }

   public String getgxTv_SdtSDT1_Link( )
   {
      return gxTv_SdtSDT1_Link ;
   }

   public void setgxTv_SdtSDT1_Link( String value )
   {
      gxTv_SdtSDT1_N = (byte)(0) ;
      gxTv_SdtSDT1_Link = value ;
   }

   public String getgxTv_SdtSDT1_Descripcion( )
   {
      return gxTv_SdtSDT1_Descripcion ;
   }

   public void setgxTv_SdtSDT1_Descripcion( String value )
   {
      gxTv_SdtSDT1_N = (byte)(0) ;
      gxTv_SdtSDT1_Descripcion = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDT1_Link = "" ;
      gxTv_SdtSDT1_N = (byte)(1) ;
      gxTv_SdtSDT1_Descripcion = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDT1_N ;
   }

   public com.projectthani.SdtSDT1 Clone( )
   {
      return (com.projectthani.SdtSDT1)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDT1 struct )
   {
      setgxTv_SdtSDT1_Link(struct.getLink());
      setgxTv_SdtSDT1_Descripcion(struct.getDescripcion());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDT1 getStruct( )
   {
      com.projectthani.StructSdtSDT1 struct = new com.projectthani.StructSdtSDT1 ();
      struct.setLink(getgxTv_SdtSDT1_Link());
      struct.setDescripcion(getgxTv_SdtSDT1_Descripcion());
      return struct ;
   }

   protected byte gxTv_SdtSDT1_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDT1_Link ;
   protected String gxTv_SdtSDT1_Descripcion ;
}

