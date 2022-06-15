package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTResponseWSDni extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTResponseWSDni( )
   {
      this(  new ModelContext(SdtSDTResponseWSDni.class));
   }

   public SdtSDTResponseWSDni( ModelContext context )
   {
      super( context, "SdtSDTResponseWSDni");
   }

   public SdtSDTResponseWSDni( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTResponseWSDni");
   }

   public SdtSDTResponseWSDni( StructSdtSDTResponseWSDni struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "success") )
            {
               gxTv_SdtSDTResponseWSDni_Success = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "data") )
            {
               if ( gxTv_SdtSDTResponseWSDni_Data == null )
               {
                  gxTv_SdtSDTResponseWSDni_Data = new com.projectthani.SdtSDTResponseDni(remoteHandle, context);
               }
               GXSoapError = gxTv_SdtSDTResponseWSDni_Data.readxml(oReader, "data") ;
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
         sName = "SDTResponseWSDni" ;
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
      oWriter.writeElement("success", GXutil.rtrim( GXutil.booltostr( gxTv_SdtSDTResponseWSDni_Success)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( gxTv_SdtSDTResponseWSDni_Data != null )
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
         gxTv_SdtSDTResponseWSDni_Data.writexml(oWriter, "data", sNameSpace1);
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
      AddObjectProperty("success", gxTv_SdtSDTResponseWSDni_Success, false, false);
      if ( gxTv_SdtSDTResponseWSDni_Data != null )
      {
         AddObjectProperty("data", gxTv_SdtSDTResponseWSDni_Data, false, false);
      }
   }

   public boolean getgxTv_SdtSDTResponseWSDni_Success( )
   {
      return gxTv_SdtSDTResponseWSDni_Success ;
   }

   public void setgxTv_SdtSDTResponseWSDni_Success( boolean value )
   {
      gxTv_SdtSDTResponseWSDni_N = (byte)(0) ;
      gxTv_SdtSDTResponseWSDni_Success = value ;
   }

   public com.projectthani.SdtSDTResponseDni getgxTv_SdtSDTResponseWSDni_Data( )
   {
      if ( gxTv_SdtSDTResponseWSDni_Data == null )
      {
         gxTv_SdtSDTResponseWSDni_Data = new com.projectthani.SdtSDTResponseDni(remoteHandle, context);
      }
      gxTv_SdtSDTResponseWSDni_Data_N = (byte)(0) ;
      gxTv_SdtSDTResponseWSDni_N = (byte)(0) ;
      return gxTv_SdtSDTResponseWSDni_Data ;
   }

   public void setgxTv_SdtSDTResponseWSDni_Data( com.projectthani.SdtSDTResponseDni value )
   {
      gxTv_SdtSDTResponseWSDni_Data_N = (byte)(0) ;
      gxTv_SdtSDTResponseWSDni_N = (byte)(0) ;
      gxTv_SdtSDTResponseWSDni_Data = value;
   }

   public void setgxTv_SdtSDTResponseWSDni_Data_SetNull( )
   {
      gxTv_SdtSDTResponseWSDni_Data_N = (byte)(1) ;
      gxTv_SdtSDTResponseWSDni_Data = (com.projectthani.SdtSDTResponseDni)null;
   }

   public boolean getgxTv_SdtSDTResponseWSDni_Data_IsNull( )
   {
      if ( gxTv_SdtSDTResponseWSDni_Data == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtSDTResponseWSDni_Data_N( )
   {
      return gxTv_SdtSDTResponseWSDni_Data_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTResponseWSDni_N = (byte)(1) ;
      gxTv_SdtSDTResponseWSDni_Data_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTResponseWSDni_N ;
   }

   public com.projectthani.SdtSDTResponseWSDni Clone( )
   {
      return (com.projectthani.SdtSDTResponseWSDni)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTResponseWSDni struct )
   {
      setgxTv_SdtSDTResponseWSDni_Success(struct.getSuccess());
      setgxTv_SdtSDTResponseWSDni_Data(new com.projectthani.SdtSDTResponseDni(struct.getData()));
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTResponseWSDni getStruct( )
   {
      com.projectthani.StructSdtSDTResponseWSDni struct = new com.projectthani.StructSdtSDTResponseWSDni ();
      struct.setSuccess(getgxTv_SdtSDTResponseWSDni_Success());
      struct.setData(getgxTv_SdtSDTResponseWSDni_Data().getStruct());
      return struct ;
   }

   protected byte gxTv_SdtSDTResponseWSDni_N ;
   protected byte gxTv_SdtSDTResponseWSDni_Data_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean gxTv_SdtSDTResponseWSDni_Success ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected com.projectthani.SdtSDTResponseDni gxTv_SdtSDTResponseWSDni_Data=null ;
}

