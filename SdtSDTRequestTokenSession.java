package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTRequestTokenSession extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTRequestTokenSession( )
   {
      this(  new ModelContext(SdtSDTRequestTokenSession.class));
   }

   public SdtSDTRequestTokenSession( ModelContext context )
   {
      super( context, "SdtSDTRequestTokenSession");
   }

   public SdtSDTRequestTokenSession( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTRequestTokenSession");
   }

   public SdtSDTRequestTokenSession( StructSdtSDTRequestTokenSession struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "amount") )
            {
               gxTv_SdtSDTRequestTokenSession_Amount = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "channel") )
            {
               gxTv_SdtSDTRequestTokenSession_Channel = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "antifraud") )
            {
               if ( gxTv_SdtSDTRequestTokenSession_Antifraud == null )
               {
                  gxTv_SdtSDTRequestTokenSession_Antifraud = new com.projectthani.SdtSDTRequestAutorizacionPagoAntifraud(remoteHandle, context);
               }
               GXSoapError = gxTv_SdtSDTRequestTokenSession_Antifraud.readxml(oReader, "antifraud") ;
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
         sName = "SDTRequestTokenSession" ;
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
      oWriter.writeElement("amount", GXutil.trim( GXutil.strNoRound( gxTv_SdtSDTRequestTokenSession_Amount, 6, 2)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("channel", GXutil.rtrim( gxTv_SdtSDTRequestTokenSession_Channel));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( gxTv_SdtSDTRequestTokenSession_Antifraud != null )
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
         gxTv_SdtSDTRequestTokenSession_Antifraud.writexml(oWriter, "antifraud", sNameSpace1);
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
      AddObjectProperty("amount", gxTv_SdtSDTRequestTokenSession_Amount, false, false);
      AddObjectProperty("channel", gxTv_SdtSDTRequestTokenSession_Channel, false, false);
      if ( gxTv_SdtSDTRequestTokenSession_Antifraud != null )
      {
         AddObjectProperty("antifraud", gxTv_SdtSDTRequestTokenSession_Antifraud, false, false);
      }
   }

   public java.math.BigDecimal getgxTv_SdtSDTRequestTokenSession_Amount( )
   {
      return gxTv_SdtSDTRequestTokenSession_Amount ;
   }

   public void setgxTv_SdtSDTRequestTokenSession_Amount( java.math.BigDecimal value )
   {
      gxTv_SdtSDTRequestTokenSession_N = (byte)(0) ;
      gxTv_SdtSDTRequestTokenSession_Amount = value ;
   }

   public String getgxTv_SdtSDTRequestTokenSession_Channel( )
   {
      return gxTv_SdtSDTRequestTokenSession_Channel ;
   }

   public void setgxTv_SdtSDTRequestTokenSession_Channel( String value )
   {
      gxTv_SdtSDTRequestTokenSession_N = (byte)(0) ;
      gxTv_SdtSDTRequestTokenSession_Channel = value ;
   }

   public com.projectthani.SdtSDTRequestAutorizacionPagoAntifraud getgxTv_SdtSDTRequestTokenSession_Antifraud( )
   {
      if ( gxTv_SdtSDTRequestTokenSession_Antifraud == null )
      {
         gxTv_SdtSDTRequestTokenSession_Antifraud = new com.projectthani.SdtSDTRequestAutorizacionPagoAntifraud(remoteHandle, context);
      }
      gxTv_SdtSDTRequestTokenSession_Antifraud_N = (byte)(0) ;
      gxTv_SdtSDTRequestTokenSession_N = (byte)(0) ;
      return gxTv_SdtSDTRequestTokenSession_Antifraud ;
   }

   public void setgxTv_SdtSDTRequestTokenSession_Antifraud( com.projectthani.SdtSDTRequestAutorizacionPagoAntifraud value )
   {
      gxTv_SdtSDTRequestTokenSession_Antifraud_N = (byte)(0) ;
      gxTv_SdtSDTRequestTokenSession_N = (byte)(0) ;
      gxTv_SdtSDTRequestTokenSession_Antifraud = value;
   }

   public void setgxTv_SdtSDTRequestTokenSession_Antifraud_SetNull( )
   {
      gxTv_SdtSDTRequestTokenSession_Antifraud_N = (byte)(1) ;
      gxTv_SdtSDTRequestTokenSession_Antifraud = (com.projectthani.SdtSDTRequestAutorizacionPagoAntifraud)null;
   }

   public boolean getgxTv_SdtSDTRequestTokenSession_Antifraud_IsNull( )
   {
      if ( gxTv_SdtSDTRequestTokenSession_Antifraud == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtSDTRequestTokenSession_Antifraud_N( )
   {
      return gxTv_SdtSDTRequestTokenSession_Antifraud_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTRequestTokenSession_Amount = DecimalUtil.ZERO ;
      gxTv_SdtSDTRequestTokenSession_N = (byte)(1) ;
      gxTv_SdtSDTRequestTokenSession_Channel = "" ;
      gxTv_SdtSDTRequestTokenSession_Antifraud_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTRequestTokenSession_N ;
   }

   public com.projectthani.SdtSDTRequestTokenSession Clone( )
   {
      return (com.projectthani.SdtSDTRequestTokenSession)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTRequestTokenSession struct )
   {
      setgxTv_SdtSDTRequestTokenSession_Amount(struct.getAmount());
      setgxTv_SdtSDTRequestTokenSession_Channel(struct.getChannel());
      setgxTv_SdtSDTRequestTokenSession_Antifraud(new com.projectthani.SdtSDTRequestAutorizacionPagoAntifraud(struct.getAntifraud()));
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTRequestTokenSession getStruct( )
   {
      com.projectthani.StructSdtSDTRequestTokenSession struct = new com.projectthani.StructSdtSDTRequestTokenSession ();
      struct.setAmount(getgxTv_SdtSDTRequestTokenSession_Amount());
      struct.setChannel(getgxTv_SdtSDTRequestTokenSession_Channel());
      struct.setAntifraud(getgxTv_SdtSDTRequestTokenSession_Antifraud().getStruct());
      return struct ;
   }

   protected byte gxTv_SdtSDTRequestTokenSession_N ;
   protected byte gxTv_SdtSDTRequestTokenSession_Antifraud_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_SdtSDTRequestTokenSession_Amount ;
   protected String gxTv_SdtSDTRequestTokenSession_Channel ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected com.projectthani.SdtSDTRequestAutorizacionPagoAntifraud gxTv_SdtSDTRequestTokenSession_Antifraud=null ;
}

