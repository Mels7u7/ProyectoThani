package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem( )
   {
      this(  new ModelContext(SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem.class));
   }

   public SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem( ModelContext context )
   {
      super( context, "SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem");
   }

   public SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem( int remoteHandle ,
                                                                ModelContext context )
   {
      super( remoteHandle, context, "SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem");
   }

   public SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem( StructSdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecFunctionalityKey") )
            {
               gxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_Secfunctionalitykey = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecFunctionalityDsc") )
            {
               gxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_Secfunctionalitydsc = oReader.getValue() ;
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
         sName = "SecFunctionalitiesToLoad.SecFunctionalityKeysItem" ;
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
      oWriter.writeElement("SecFunctionalityKey", GXutil.rtrim( gxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_Secfunctionalitykey));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SecFunctionalityDsc", GXutil.rtrim( gxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_Secfunctionalitydsc));
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
      AddObjectProperty("SecFunctionalityKey", gxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_Secfunctionalitykey, false, false);
      AddObjectProperty("SecFunctionalityDsc", gxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_Secfunctionalitydsc, false, false);
   }

   public String getgxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_Secfunctionalitykey( )
   {
      return gxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_Secfunctionalitykey ;
   }

   public void setgxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_Secfunctionalitykey( String value )
   {
      gxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_N = (byte)(0) ;
      gxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_Secfunctionalitykey = value ;
   }

   public String getgxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_Secfunctionalitydsc( )
   {
      return gxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_Secfunctionalitydsc ;
   }

   public void setgxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_Secfunctionalitydsc( String value )
   {
      gxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_N = (byte)(0) ;
      gxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_Secfunctionalitydsc = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_Secfunctionalitykey = "" ;
      gxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_N = (byte)(1) ;
      gxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_Secfunctionalitydsc = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_N ;
   }

   public com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem Clone( )
   {
      return (com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem)(clone()) ;
   }

   public void setStruct( com.projectthani.wwpbaseobjects.StructSdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem struct )
   {
      setgxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_Secfunctionalitykey(struct.getSecfunctionalitykey());
      setgxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_Secfunctionalitydsc(struct.getSecfunctionalitydsc());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.wwpbaseobjects.StructSdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem getStruct( )
   {
      com.projectthani.wwpbaseobjects.StructSdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem struct = new com.projectthani.wwpbaseobjects.StructSdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem ();
      struct.setSecfunctionalitykey(getgxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_Secfunctionalitykey());
      struct.setSecfunctionalitydsc(getgxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_Secfunctionalitydsc());
      return struct ;
   }

   protected byte gxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_Secfunctionalitykey ;
   protected String gxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_Secfunctionalitydsc ;
}

