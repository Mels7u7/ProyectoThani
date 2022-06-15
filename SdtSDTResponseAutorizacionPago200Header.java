package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTResponseAutorizacionPago200Header extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTResponseAutorizacionPago200Header( )
   {
      this(  new ModelContext(SdtSDTResponseAutorizacionPago200Header.class));
   }

   public SdtSDTResponseAutorizacionPago200Header( ModelContext context )
   {
      super( context, "SdtSDTResponseAutorizacionPago200Header");
   }

   public SdtSDTResponseAutorizacionPago200Header( int remoteHandle ,
                                                   ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTResponseAutorizacionPago200Header");
   }

   public SdtSDTResponseAutorizacionPago200Header( StructSdtSDTResponseAutorizacionPago200Header struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ecoreTransactionUUID") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200Header_Ecoretransactionuuid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ecoreTransactionDate") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200Header_Ecoretransactiondate = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "milllis") )
            {
               gxTv_SdtSDTResponseAutorizacionPago200Header_Milllis = (int)(getnumericvalue(oReader.getValue())) ;
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
         sName = "SDTResponseAutorizacionPago200Header" ;
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
      oWriter.writeElement("ecoreTransactionUUID", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago200Header_Ecoretransactionuuid));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ecoreTransactionDate", GXutil.rtrim( gxTv_SdtSDTResponseAutorizacionPago200Header_Ecoretransactiondate));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("milllis", GXutil.trim( GXutil.str( gxTv_SdtSDTResponseAutorizacionPago200Header_Milllis, 8, 0)));
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
      AddObjectProperty("ecoreTransactionUUID", gxTv_SdtSDTResponseAutorizacionPago200Header_Ecoretransactionuuid, false, false);
      AddObjectProperty("ecoreTransactionDate", gxTv_SdtSDTResponseAutorizacionPago200Header_Ecoretransactiondate, false, false);
      AddObjectProperty("milllis", gxTv_SdtSDTResponseAutorizacionPago200Header_Milllis, false, false);
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago200Header_Ecoretransactionuuid( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Header_Ecoretransactionuuid ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200Header_Ecoretransactionuuid( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Header_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Header_Ecoretransactionuuid = value ;
   }

   public String getgxTv_SdtSDTResponseAutorizacionPago200Header_Ecoretransactiondate( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Header_Ecoretransactiondate ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200Header_Ecoretransactiondate( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Header_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Header_Ecoretransactiondate = value ;
   }

   public int getgxTv_SdtSDTResponseAutorizacionPago200Header_Milllis( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Header_Milllis ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200Header_Milllis( int value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Header_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Header_Milllis = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Header_Ecoretransactionuuid = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200Header_N = (byte)(1) ;
      gxTv_SdtSDTResponseAutorizacionPago200Header_Ecoretransactiondate = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Header_N ;
   }

   public com.projectthani.SdtSDTResponseAutorizacionPago200Header Clone( )
   {
      return (com.projectthani.SdtSDTResponseAutorizacionPago200Header)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTResponseAutorizacionPago200Header struct )
   {
      setgxTv_SdtSDTResponseAutorizacionPago200Header_Ecoretransactionuuid(struct.getEcoretransactionuuid());
      setgxTv_SdtSDTResponseAutorizacionPago200Header_Ecoretransactiondate(struct.getEcoretransactiondate());
      setgxTv_SdtSDTResponseAutorizacionPago200Header_Milllis(struct.getMilllis());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTResponseAutorizacionPago200Header getStruct( )
   {
      com.projectthani.StructSdtSDTResponseAutorizacionPago200Header struct = new com.projectthani.StructSdtSDTResponseAutorizacionPago200Header ();
      struct.setEcoretransactionuuid(getgxTv_SdtSDTResponseAutorizacionPago200Header_Ecoretransactionuuid());
      struct.setEcoretransactiondate(getgxTv_SdtSDTResponseAutorizacionPago200Header_Ecoretransactiondate());
      struct.setMilllis(getgxTv_SdtSDTResponseAutorizacionPago200Header_Milllis());
      return struct ;
   }

   protected byte gxTv_SdtSDTResponseAutorizacionPago200Header_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_SdtSDTResponseAutorizacionPago200Header_Milllis ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200Header_Ecoretransactionuuid ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200Header_Ecoretransactiondate ;
}

