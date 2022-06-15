package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTResponseAutorizacionPago400 extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTResponseAutorizacionPago400( )
   {
      this(  new ModelContext(SdtSDTResponseAutorizacionPago400.class));
   }

   public SdtSDTResponseAutorizacionPago400( ModelContext context )
   {
      super( context, "SdtSDTResponseAutorizacionPago400");
   }

   public SdtSDTResponseAutorizacionPago400( int remoteHandle ,
                                             ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTResponseAutorizacionPago400");
   }

   public SdtSDTResponseAutorizacionPago400( StructSdtSDTResponseAutorizacionPago400 struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "errorCode") )
            {
               gxTv_SdtSDTResponseAutorizacionPago400_Errorcode = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "errorMessage") )
            {
               gxTv_SdtSDTResponseAutorizacionPago400_Errormessage = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "header") )
            {
               if ( gxTv_SdtSDTResponseAutorizacionPago400_Header == null )
               {
                  gxTv_SdtSDTResponseAutorizacionPago400_Header = new com.projectthani.SdtSDTResponseAutorizacionPago200Header(remoteHandle, context);
               }
               GXSoapError = gxTv_SdtSDTResponseAutorizacionPago400_Header.readxml(oReader, "header") ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "data") )
            {
               if ( gxTv_SdtSDTResponseAutorizacionPago400_Data == null )
               {
                  gxTv_SdtSDTResponseAutorizacionPago400_Data = new com.projectthani.SdtSDTResponseAutorizacionPago400Data(remoteHandle, context);
               }
               GXSoapError = gxTv_SdtSDTResponseAutorizacionPago400_Data.readxml(oReader, "data") ;
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
         sName = "SDTResponseAutorizacionPago400" ;
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
      oWriter.writeElement("errorCode", GXutil.trim( GXutil.str( gxTv_SdtSDTResponseAutorizacionPago400_Errorcode, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("errorMessage", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago400_Errormessage));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( gxTv_SdtSDTResponseAutorizacionPago400_Header != null )
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
         gxTv_SdtSDTResponseAutorizacionPago400_Header.writexml(oWriter, "header", sNameSpace1);
      }
      if ( gxTv_SdtSDTResponseAutorizacionPago400_Data != null )
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
         gxTv_SdtSDTResponseAutorizacionPago400_Data.writexml(oWriter, "data", sNameSpace1);
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
      AddObjectProperty("errorCode", gxTv_SdtSDTResponseAutorizacionPago400_Errorcode, false, false);
      AddObjectProperty("errorMessage", gxTv_SdtSDTResponseAutorizacionPago400_Errormessage, false, false);
      if ( gxTv_SdtSDTResponseAutorizacionPago400_Header != null )
      {
         AddObjectProperty("header", gxTv_SdtSDTResponseAutorizacionPago400_Header, false, false);
      }
      if ( gxTv_SdtSDTResponseAutorizacionPago400_Data != null )
      {
         AddObjectProperty("data", gxTv_SdtSDTResponseAutorizacionPago400_Data, false, false);
      }
   }

   public int getgxTv_SdtSDTResponseAutorizacionPago400_Errorcode( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago400_Errorcode ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago400_Errorcode( int value )
   {
      gxTv_SdtSDTResponseAutorizacionPago400_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago400_Errorcode = value ;
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago400_Errormessage( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago400_Errormessage ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago400_Errormessage( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago400_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago400_Errormessage = value ;
   }

   public com.projectthani.SdtSDTResponseAutorizacionPago200Header getgxTv_SdtSDTResponseAutorizacionPago400_Header( )
   {
      if ( gxTv_SdtSDTResponseAutorizacionPago400_Header == null )
      {
         gxTv_SdtSDTResponseAutorizacionPago400_Header = new com.projectthani.SdtSDTResponseAutorizacionPago200Header(remoteHandle, context);
      }
      gxTv_SdtSDTResponseAutorizacionPago400_Header_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago400_N = (byte)(0) ;
      return gxTv_SdtSDTResponseAutorizacionPago400_Header ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago400_Header( com.projectthani.SdtSDTResponseAutorizacionPago200Header value )
   {
      gxTv_SdtSDTResponseAutorizacionPago400_Header_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago400_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago400_Header = value;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago400_Header_SetNull( )
   {
      gxTv_SdtSDTResponseAutorizacionPago400_Header_N = (byte)(1) ;
      gxTv_SdtSDTResponseAutorizacionPago400_Header = (com.projectthani.SdtSDTResponseAutorizacionPago200Header)null;
   }

   public boolean getgxTv_SdtSDTResponseAutorizacionPago400_Header_IsNull( )
   {
      if ( gxTv_SdtSDTResponseAutorizacionPago400_Header == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtSDTResponseAutorizacionPago400_Header_N( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago400_Header_N ;
   }

   public com.projectthani.SdtSDTResponseAutorizacionPago400Data getgxTv_SdtSDTResponseAutorizacionPago400_Data( )
   {
      if ( gxTv_SdtSDTResponseAutorizacionPago400_Data == null )
      {
         gxTv_SdtSDTResponseAutorizacionPago400_Data = new com.projectthani.SdtSDTResponseAutorizacionPago400Data(remoteHandle, context);
      }
      gxTv_SdtSDTResponseAutorizacionPago400_Data_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago400_N = (byte)(0) ;
      return gxTv_SdtSDTResponseAutorizacionPago400_Data ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago400_Data( com.projectthani.SdtSDTResponseAutorizacionPago400Data value )
   {
      gxTv_SdtSDTResponseAutorizacionPago400_Data_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago400_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago400_Data = value;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago400_Data_SetNull( )
   {
      gxTv_SdtSDTResponseAutorizacionPago400_Data_N = (byte)(1) ;
      gxTv_SdtSDTResponseAutorizacionPago400_Data = (com.projectthani.SdtSDTResponseAutorizacionPago400Data)null;
   }

   public boolean getgxTv_SdtSDTResponseAutorizacionPago400_Data_IsNull( )
   {
      if ( gxTv_SdtSDTResponseAutorizacionPago400_Data == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtSDTResponseAutorizacionPago400_Data_N( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago400_Data_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTResponseAutorizacionPago400_N = (byte)(1) ;
      gxTv_SdtSDTResponseAutorizacionPago400_Errormessage = "" ;
      gxTv_SdtSDTResponseAutorizacionPago400_Header_N = (byte)(1) ;
      gxTv_SdtSDTResponseAutorizacionPago400_Data_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago400_N ;
   }

   public com.projectthani.SdtSDTResponseAutorizacionPago400 Clone( )
   {
      return (com.projectthani.SdtSDTResponseAutorizacionPago400)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTResponseAutorizacionPago400 struct )
   {
      setgxTv_SdtSDTResponseAutorizacionPago400_Errorcode(struct.getErrorcode());
      setgxTv_SdtSDTResponseAutorizacionPago400_Errormessage(struct.getErrormessage());
      setgxTv_SdtSDTResponseAutorizacionPago400_Header(new com.projectthani.SdtSDTResponseAutorizacionPago200Header(struct.getHeader()));
      setgxTv_SdtSDTResponseAutorizacionPago400_Data(new com.projectthani.SdtSDTResponseAutorizacionPago400Data(struct.getData()));
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTResponseAutorizacionPago400 getStruct( )
   {
      com.projectthani.StructSdtSDTResponseAutorizacionPago400 struct = new com.projectthani.StructSdtSDTResponseAutorizacionPago400 ();
      struct.setErrorcode(getgxTv_SdtSDTResponseAutorizacionPago400_Errorcode());
      struct.setErrormessage(getgxTv_SdtSDTResponseAutorizacionPago400_Errormessage());
      struct.setHeader(getgxTv_SdtSDTResponseAutorizacionPago400_Header().getStruct());
      struct.setData(getgxTv_SdtSDTResponseAutorizacionPago400_Data().getStruct());
      return struct ;
   }

   protected byte gxTv_SdtSDTResponseAutorizacionPago400_N ;
   protected byte gxTv_SdtSDTResponseAutorizacionPago400_Header_N ;
   protected byte gxTv_SdtSDTResponseAutorizacionPago400_Data_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_SdtSDTResponseAutorizacionPago400_Errorcode ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTResponseAutorizacionPago400_Errormessage ;
   protected com.projectthani.SdtSDTResponseAutorizacionPago200Header gxTv_SdtSDTResponseAutorizacionPago400_Header=null ;
   protected com.projectthani.SdtSDTResponseAutorizacionPago400Data gxTv_SdtSDTResponseAutorizacionPago400_Data=null ;
}

