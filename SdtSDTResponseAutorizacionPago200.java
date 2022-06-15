package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTResponseAutorizacionPago200 extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTResponseAutorizacionPago200( )
   {
      this(  new ModelContext(SdtSDTResponseAutorizacionPago200.class));
   }

   public SdtSDTResponseAutorizacionPago200( ModelContext context )
   {
      super( context, "SdtSDTResponseAutorizacionPago200");
   }

   public SdtSDTResponseAutorizacionPago200( int remoteHandle ,
                                             ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTResponseAutorizacionPago200");
   }

   public SdtSDTResponseAutorizacionPago200( StructSdtSDTResponseAutorizacionPago200 struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "header") )
            {
               if ( gxTv_SdtSDTResponseAutorizacionPago200_Header == null )
               {
                  gxTv_SdtSDTResponseAutorizacionPago200_Header = new com.projectthani.SdtSDTResponseAutorizacionPago200Header(remoteHandle, context);
               }
               GXSoapError = gxTv_SdtSDTResponseAutorizacionPago200_Header.readxml(oReader, "header") ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "fulfillment") )
            {
               if ( gxTv_SdtSDTResponseAutorizacionPago200_Fulfillment == null )
               {
                  gxTv_SdtSDTResponseAutorizacionPago200_Fulfillment = new com.projectthani.SdtSDTResponseAutorizacionPago200Fulfillment(remoteHandle, context);
               }
               GXSoapError = gxTv_SdtSDTResponseAutorizacionPago200_Fulfillment.readxml(oReader, "fulfillment") ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "order") )
            {
               if ( gxTv_SdtSDTResponseAutorizacionPago200_Order == null )
               {
                  gxTv_SdtSDTResponseAutorizacionPago200_Order = new com.projectthani.SdtSDTResponseAutorizacionPago200Order(remoteHandle, context);
               }
               GXSoapError = gxTv_SdtSDTResponseAutorizacionPago200_Order.readxml(oReader, "order") ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "token") )
            {
               if ( gxTv_SdtSDTResponseAutorizacionPago200_Token == null )
               {
                  gxTv_SdtSDTResponseAutorizacionPago200_Token = new com.projectthani.SdtSDTResponseAutorizacionPago200Token(remoteHandle, context);
               }
               GXSoapError = gxTv_SdtSDTResponseAutorizacionPago200_Token.readxml(oReader, "token") ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "dataMap") )
            {
               if ( gxTv_SdtSDTResponseAutorizacionPago200_Datamap == null )
               {
                  gxTv_SdtSDTResponseAutorizacionPago200_Datamap = new com.projectthani.SdtSDTResponseAutorizacionPago200DataMap(remoteHandle, context);
               }
               GXSoapError = gxTv_SdtSDTResponseAutorizacionPago200_Datamap.readxml(oReader, "dataMap") ;
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
         sName = "SDTResponseAutorizacionPago200" ;
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
      if ( gxTv_SdtSDTResponseAutorizacionPago200_Header != null )
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
         gxTv_SdtSDTResponseAutorizacionPago200_Header.writexml(oWriter, "header", sNameSpace1);
      }
      if ( gxTv_SdtSDTResponseAutorizacionPago200_Fulfillment != null )
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
         gxTv_SdtSDTResponseAutorizacionPago200_Fulfillment.writexml(oWriter, "fulfillment", sNameSpace1);
      }
      if ( gxTv_SdtSDTResponseAutorizacionPago200_Order != null )
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
         gxTv_SdtSDTResponseAutorizacionPago200_Order.writexml(oWriter, "order", sNameSpace1);
      }
      if ( gxTv_SdtSDTResponseAutorizacionPago200_Token != null )
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
         gxTv_SdtSDTResponseAutorizacionPago200_Token.writexml(oWriter, "token", sNameSpace1);
      }
      if ( gxTv_SdtSDTResponseAutorizacionPago200_Datamap != null )
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
         gxTv_SdtSDTResponseAutorizacionPago200_Datamap.writexml(oWriter, "dataMap", sNameSpace1);
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
      if ( gxTv_SdtSDTResponseAutorizacionPago200_Header != null )
      {
         AddObjectProperty("header", gxTv_SdtSDTResponseAutorizacionPago200_Header, false, false);
      }
      if ( gxTv_SdtSDTResponseAutorizacionPago200_Fulfillment != null )
      {
         AddObjectProperty("fulfillment", gxTv_SdtSDTResponseAutorizacionPago200_Fulfillment, false, false);
      }
      if ( gxTv_SdtSDTResponseAutorizacionPago200_Order != null )
      {
         AddObjectProperty("order", gxTv_SdtSDTResponseAutorizacionPago200_Order, false, false);
      }
      if ( gxTv_SdtSDTResponseAutorizacionPago200_Token != null )
      {
         AddObjectProperty("token", gxTv_SdtSDTResponseAutorizacionPago200_Token, false, false);
      }
      if ( gxTv_SdtSDTResponseAutorizacionPago200_Datamap != null )
      {
         AddObjectProperty("dataMap", gxTv_SdtSDTResponseAutorizacionPago200_Datamap, false, false);
      }
   }

   public com.projectthani.SdtSDTResponseAutorizacionPago200Header getgxTv_SdtSDTResponseAutorizacionPago200_Header( )
   {
      if ( gxTv_SdtSDTResponseAutorizacionPago200_Header == null )
      {
         gxTv_SdtSDTResponseAutorizacionPago200_Header = new com.projectthani.SdtSDTResponseAutorizacionPago200Header(remoteHandle, context);
      }
      gxTv_SdtSDTResponseAutorizacionPago200_Header_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200_N = (byte)(0) ;
      return gxTv_SdtSDTResponseAutorizacionPago200_Header ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200_Header( com.projectthani.SdtSDTResponseAutorizacionPago200Header value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200_Header_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200_Header = value;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200_Header_SetNull( )
   {
      gxTv_SdtSDTResponseAutorizacionPago200_Header_N = (byte)(1) ;
      gxTv_SdtSDTResponseAutorizacionPago200_Header = (com.projectthani.SdtSDTResponseAutorizacionPago200Header)null;
   }

   public boolean getgxTv_SdtSDTResponseAutorizacionPago200_Header_IsNull( )
   {
      if ( gxTv_SdtSDTResponseAutorizacionPago200_Header == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtSDTResponseAutorizacionPago200_Header_N( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200_Header_N ;
   }

   public com.projectthani.SdtSDTResponseAutorizacionPago200Fulfillment getgxTv_SdtSDTResponseAutorizacionPago200_Fulfillment( )
   {
      if ( gxTv_SdtSDTResponseAutorizacionPago200_Fulfillment == null )
      {
         gxTv_SdtSDTResponseAutorizacionPago200_Fulfillment = new com.projectthani.SdtSDTResponseAutorizacionPago200Fulfillment(remoteHandle, context);
      }
      gxTv_SdtSDTResponseAutorizacionPago200_Fulfillment_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200_N = (byte)(0) ;
      return gxTv_SdtSDTResponseAutorizacionPago200_Fulfillment ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200_Fulfillment( com.projectthani.SdtSDTResponseAutorizacionPago200Fulfillment value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200_Fulfillment_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200_Fulfillment = value;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200_Fulfillment_SetNull( )
   {
      gxTv_SdtSDTResponseAutorizacionPago200_Fulfillment_N = (byte)(1) ;
      gxTv_SdtSDTResponseAutorizacionPago200_Fulfillment = (com.projectthani.SdtSDTResponseAutorizacionPago200Fulfillment)null;
   }

   public boolean getgxTv_SdtSDTResponseAutorizacionPago200_Fulfillment_IsNull( )
   {
      if ( gxTv_SdtSDTResponseAutorizacionPago200_Fulfillment == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtSDTResponseAutorizacionPago200_Fulfillment_N( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200_Fulfillment_N ;
   }

   public com.projectthani.SdtSDTResponseAutorizacionPago200Order getgxTv_SdtSDTResponseAutorizacionPago200_Order( )
   {
      if ( gxTv_SdtSDTResponseAutorizacionPago200_Order == null )
      {
         gxTv_SdtSDTResponseAutorizacionPago200_Order = new com.projectthani.SdtSDTResponseAutorizacionPago200Order(remoteHandle, context);
      }
      gxTv_SdtSDTResponseAutorizacionPago200_Order_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200_N = (byte)(0) ;
      return gxTv_SdtSDTResponseAutorizacionPago200_Order ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200_Order( com.projectthani.SdtSDTResponseAutorizacionPago200Order value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200_Order_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200_Order = value;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200_Order_SetNull( )
   {
      gxTv_SdtSDTResponseAutorizacionPago200_Order_N = (byte)(1) ;
      gxTv_SdtSDTResponseAutorizacionPago200_Order = (com.projectthani.SdtSDTResponseAutorizacionPago200Order)null;
   }

   public boolean getgxTv_SdtSDTResponseAutorizacionPago200_Order_IsNull( )
   {
      if ( gxTv_SdtSDTResponseAutorizacionPago200_Order == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtSDTResponseAutorizacionPago200_Order_N( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200_Order_N ;
   }

   public com.projectthani.SdtSDTResponseAutorizacionPago200Token getgxTv_SdtSDTResponseAutorizacionPago200_Token( )
   {
      if ( gxTv_SdtSDTResponseAutorizacionPago200_Token == null )
      {
         gxTv_SdtSDTResponseAutorizacionPago200_Token = new com.projectthani.SdtSDTResponseAutorizacionPago200Token(remoteHandle, context);
      }
      gxTv_SdtSDTResponseAutorizacionPago200_Token_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200_N = (byte)(0) ;
      return gxTv_SdtSDTResponseAutorizacionPago200_Token ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200_Token( com.projectthani.SdtSDTResponseAutorizacionPago200Token value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200_Token_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200_Token = value;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200_Token_SetNull( )
   {
      gxTv_SdtSDTResponseAutorizacionPago200_Token_N = (byte)(1) ;
      gxTv_SdtSDTResponseAutorizacionPago200_Token = (com.projectthani.SdtSDTResponseAutorizacionPago200Token)null;
   }

   public boolean getgxTv_SdtSDTResponseAutorizacionPago200_Token_IsNull( )
   {
      if ( gxTv_SdtSDTResponseAutorizacionPago200_Token == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtSDTResponseAutorizacionPago200_Token_N( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200_Token_N ;
   }

   public com.projectthani.SdtSDTResponseAutorizacionPago200DataMap getgxTv_SdtSDTResponseAutorizacionPago200_Datamap( )
   {
      if ( gxTv_SdtSDTResponseAutorizacionPago200_Datamap == null )
      {
         gxTv_SdtSDTResponseAutorizacionPago200_Datamap = new com.projectthani.SdtSDTResponseAutorizacionPago200DataMap(remoteHandle, context);
      }
      gxTv_SdtSDTResponseAutorizacionPago200_Datamap_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200_N = (byte)(0) ;
      return gxTv_SdtSDTResponseAutorizacionPago200_Datamap ;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200_Datamap( com.projectthani.SdtSDTResponseAutorizacionPago200DataMap value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200_Datamap_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200_Datamap = value;
   }

   public void setgxTv_SdtSDTResponseAutorizacionPago200_Datamap_SetNull( )
   {
      gxTv_SdtSDTResponseAutorizacionPago200_Datamap_N = (byte)(1) ;
      gxTv_SdtSDTResponseAutorizacionPago200_Datamap = (com.projectthani.SdtSDTResponseAutorizacionPago200DataMap)null;
   }

   public boolean getgxTv_SdtSDTResponseAutorizacionPago200_Datamap_IsNull( )
   {
      if ( gxTv_SdtSDTResponseAutorizacionPago200_Datamap == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtSDTResponseAutorizacionPago200_Datamap_N( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200_Datamap_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTResponseAutorizacionPago200_Header_N = (byte)(1) ;
      gxTv_SdtSDTResponseAutorizacionPago200_N = (byte)(1) ;
      gxTv_SdtSDTResponseAutorizacionPago200_Fulfillment_N = (byte)(1) ;
      gxTv_SdtSDTResponseAutorizacionPago200_Order_N = (byte)(1) ;
      gxTv_SdtSDTResponseAutorizacionPago200_Token_N = (byte)(1) ;
      gxTv_SdtSDTResponseAutorizacionPago200_Datamap_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200_N ;
   }

   public com.projectthani.SdtSDTResponseAutorizacionPago200 Clone( )
   {
      return (com.projectthani.SdtSDTResponseAutorizacionPago200)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTResponseAutorizacionPago200 struct )
   {
      setgxTv_SdtSDTResponseAutorizacionPago200_Header(new com.projectthani.SdtSDTResponseAutorizacionPago200Header(struct.getHeader()));
      setgxTv_SdtSDTResponseAutorizacionPago200_Fulfillment(new com.projectthani.SdtSDTResponseAutorizacionPago200Fulfillment(struct.getFulfillment()));
      setgxTv_SdtSDTResponseAutorizacionPago200_Order(new com.projectthani.SdtSDTResponseAutorizacionPago200Order(struct.getOrder()));
      setgxTv_SdtSDTResponseAutorizacionPago200_Token(new com.projectthani.SdtSDTResponseAutorizacionPago200Token(struct.getToken()));
      setgxTv_SdtSDTResponseAutorizacionPago200_Datamap(new com.projectthani.SdtSDTResponseAutorizacionPago200DataMap(struct.getDatamap()));
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTResponseAutorizacionPago200 getStruct( )
   {
      com.projectthani.StructSdtSDTResponseAutorizacionPago200 struct = new com.projectthani.StructSdtSDTResponseAutorizacionPago200 ();
      struct.setHeader(getgxTv_SdtSDTResponseAutorizacionPago200_Header().getStruct());
      struct.setFulfillment(getgxTv_SdtSDTResponseAutorizacionPago200_Fulfillment().getStruct());
      struct.setOrder(getgxTv_SdtSDTResponseAutorizacionPago200_Order().getStruct());
      struct.setToken(getgxTv_SdtSDTResponseAutorizacionPago200_Token().getStruct());
      struct.setDatamap(getgxTv_SdtSDTResponseAutorizacionPago200_Datamap().getStruct());
      return struct ;
   }

   protected byte gxTv_SdtSDTResponseAutorizacionPago200_Header_N ;
   protected byte gxTv_SdtSDTResponseAutorizacionPago200_N ;
   protected byte gxTv_SdtSDTResponseAutorizacionPago200_Fulfillment_N ;
   protected byte gxTv_SdtSDTResponseAutorizacionPago200_Order_N ;
   protected byte gxTv_SdtSDTResponseAutorizacionPago200_Token_N ;
   protected byte gxTv_SdtSDTResponseAutorizacionPago200_Datamap_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected com.projectthani.SdtSDTResponseAutorizacionPago200Header gxTv_SdtSDTResponseAutorizacionPago200_Header=null ;
   protected com.projectthani.SdtSDTResponseAutorizacionPago200Fulfillment gxTv_SdtSDTResponseAutorizacionPago200_Fulfillment=null ;
   protected com.projectthani.SdtSDTResponseAutorizacionPago200Order gxTv_SdtSDTResponseAutorizacionPago200_Order=null ;
   protected com.projectthani.SdtSDTResponseAutorizacionPago200Token gxTv_SdtSDTResponseAutorizacionPago200_Token=null ;
   protected com.projectthani.SdtSDTResponseAutorizacionPago200DataMap gxTv_SdtSDTResponseAutorizacionPago200_Datamap=null ;
}

