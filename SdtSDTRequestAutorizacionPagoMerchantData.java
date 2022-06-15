package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTRequestAutorizacionPagoMerchantData extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTRequestAutorizacionPagoMerchantData( )
   {
      this(  new ModelContext(SdtSDTRequestAutorizacionPagoMerchantData.class));
   }

   public SdtSDTRequestAutorizacionPagoMerchantData( ModelContext context )
   {
      super( context, "SdtSDTRequestAutorizacionPagoMerchantData");
   }

   public SdtSDTRequestAutorizacionPagoMerchantData( int remoteHandle ,
                                                     ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTRequestAutorizacionPagoMerchantData");
   }

   public SdtSDTRequestAutorizacionPagoMerchantData( StructSdtSDTRequestAutorizacionPagoMerchantData struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "MDD4") )
            {
               gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd4 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MDD21") )
            {
               gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd21 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MDD32") )
            {
               gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd32 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MDD75") )
            {
               gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd75 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MDD77") )
            {
               gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd77 = oReader.getValue() ;
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
         sName = "SDTRequestAutorizacionPagoMerchantData" ;
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
      oWriter.writeElement("MDD4", GXutil.rtrim( gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd4));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("MDD21", GXutil.rtrim( gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd21));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("MDD32", GXutil.rtrim( gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd32));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("MDD75", GXutil.rtrim( gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd75));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("MDD77", GXutil.rtrim( gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd77));
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
      AddObjectProperty("MDD4", gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd4, false, false);
      AddObjectProperty("MDD21", gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd21, false, false);
      AddObjectProperty("MDD32", gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd32, false, false);
      AddObjectProperty("MDD75", gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd75, false, false);
      AddObjectProperty("MDD77", gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd77, false, false);
   }

   public String getgxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd4( )
   {
      return gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd4 ;
   }

   public void setgxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd4( String value )
   {
      gxTv_SdtSDTRequestAutorizacionPagoMerchantData_N = (byte)(0) ;
      gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd4 = value ;
   }

   public String getgxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd21( )
   {
      return gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd21 ;
   }

   public void setgxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd21( String value )
   {
      gxTv_SdtSDTRequestAutorizacionPagoMerchantData_N = (byte)(0) ;
      gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd21 = value ;
   }

   public String getgxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd32( )
   {
      return gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd32 ;
   }

   public void setgxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd32( String value )
   {
      gxTv_SdtSDTRequestAutorizacionPagoMerchantData_N = (byte)(0) ;
      gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd32 = value ;
   }

   public String getgxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd75( )
   {
      return gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd75 ;
   }

   public void setgxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd75( String value )
   {
      gxTv_SdtSDTRequestAutorizacionPagoMerchantData_N = (byte)(0) ;
      gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd75 = value ;
   }

   public String getgxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd77( )
   {
      return gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd77 ;
   }

   public void setgxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd77( String value )
   {
      gxTv_SdtSDTRequestAutorizacionPagoMerchantData_N = (byte)(0) ;
      gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd77 = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd4 = "" ;
      gxTv_SdtSDTRequestAutorizacionPagoMerchantData_N = (byte)(1) ;
      gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd21 = "" ;
      gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd32 = "" ;
      gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd75 = "" ;
      gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd77 = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTRequestAutorizacionPagoMerchantData_N ;
   }

   public com.projectthani.SdtSDTRequestAutorizacionPagoMerchantData Clone( )
   {
      return (com.projectthani.SdtSDTRequestAutorizacionPagoMerchantData)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTRequestAutorizacionPagoMerchantData struct )
   {
      setgxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd4(struct.getMdd4());
      setgxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd21(struct.getMdd21());
      setgxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd32(struct.getMdd32());
      setgxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd75(struct.getMdd75());
      setgxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd77(struct.getMdd77());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTRequestAutorizacionPagoMerchantData getStruct( )
   {
      com.projectthani.StructSdtSDTRequestAutorizacionPagoMerchantData struct = new com.projectthani.StructSdtSDTRequestAutorizacionPagoMerchantData ();
      struct.setMdd4(getgxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd4());
      struct.setMdd21(getgxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd21());
      struct.setMdd32(getgxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd32());
      struct.setMdd75(getgxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd75());
      struct.setMdd77(getgxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd77());
      return struct ;
   }

   protected byte gxTv_SdtSDTRequestAutorizacionPagoMerchantData_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd4 ;
   protected String gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd21 ;
   protected String gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd32 ;
   protected String gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd75 ;
   protected String gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd77 ;
}

