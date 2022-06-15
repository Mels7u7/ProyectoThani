package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTHora_SDTHoraItem extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTHora_SDTHoraItem( )
   {
      this(  new ModelContext(SdtSDTHora_SDTHoraItem.class));
   }

   public SdtSDTHora_SDTHoraItem( ModelContext context )
   {
      super( context, "SdtSDTHora_SDTHoraItem");
   }

   public SdtSDTHora_SDTHoraItem( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTHora_SDTHoraItem");
   }

   public SdtSDTHora_SDTHoraItem( StructSdtSDTHora_SDTHoraItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "HoraId") )
            {
               gxTv_SdtSDTHora_SDTHoraItem_Horaid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "HoraValue") )
            {
               gxTv_SdtSDTHora_SDTHoraItem_Horavalue = oReader.getValue() ;
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
         sName = "SDTHora.SDTHoraItem" ;
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
      oWriter.writeElement("HoraId", GXutil.rtrim( gxTv_SdtSDTHora_SDTHoraItem_Horaid));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("HoraValue", GXutil.rtrim( gxTv_SdtSDTHora_SDTHoraItem_Horavalue));
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
      AddObjectProperty("HoraId", gxTv_SdtSDTHora_SDTHoraItem_Horaid, false, false);
      AddObjectProperty("HoraValue", gxTv_SdtSDTHora_SDTHoraItem_Horavalue, false, false);
   }

   public String getgxTv_SdtSDTHora_SDTHoraItem_Horaid( )
   {
      return gxTv_SdtSDTHora_SDTHoraItem_Horaid ;
   }

   public void setgxTv_SdtSDTHora_SDTHoraItem_Horaid( String value )
   {
      gxTv_SdtSDTHora_SDTHoraItem_N = (byte)(0) ;
      gxTv_SdtSDTHora_SDTHoraItem_Horaid = value ;
   }

   public String getgxTv_SdtSDTHora_SDTHoraItem_Horavalue( )
   {
      return gxTv_SdtSDTHora_SDTHoraItem_Horavalue ;
   }

   public void setgxTv_SdtSDTHora_SDTHoraItem_Horavalue( String value )
   {
      gxTv_SdtSDTHora_SDTHoraItem_N = (byte)(0) ;
      gxTv_SdtSDTHora_SDTHoraItem_Horavalue = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTHora_SDTHoraItem_Horaid = "" ;
      gxTv_SdtSDTHora_SDTHoraItem_N = (byte)(1) ;
      gxTv_SdtSDTHora_SDTHoraItem_Horavalue = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTHora_SDTHoraItem_N ;
   }

   public com.projectthani.SdtSDTHora_SDTHoraItem Clone( )
   {
      return (com.projectthani.SdtSDTHora_SDTHoraItem)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTHora_SDTHoraItem struct )
   {
      setgxTv_SdtSDTHora_SDTHoraItem_Horaid(struct.getHoraid());
      setgxTv_SdtSDTHora_SDTHoraItem_Horavalue(struct.getHoravalue());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTHora_SDTHoraItem getStruct( )
   {
      com.projectthani.StructSdtSDTHora_SDTHoraItem struct = new com.projectthani.StructSdtSDTHora_SDTHoraItem ();
      struct.setHoraid(getgxTv_SdtSDTHora_SDTHoraItem_Horaid());
      struct.setHoravalue(getgxTv_SdtSDTHora_SDTHoraItem_Horavalue());
      return struct ;
   }

   protected byte gxTv_SdtSDTHora_SDTHoraItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTHora_SDTHoraItem_Horaid ;
   protected String gxTv_SdtSDTHora_SDTHoraItem_Horavalue ;
}

