package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSecFunctionalitiesToLoad extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSecFunctionalitiesToLoad( )
   {
      this(  new ModelContext(SdtSecFunctionalitiesToLoad.class));
   }

   public SdtSecFunctionalitiesToLoad( ModelContext context )
   {
      super( context, "SdtSecFunctionalitiesToLoad");
   }

   public SdtSecFunctionalitiesToLoad( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle, context, "SdtSecFunctionalitiesToLoad");
   }

   public SdtSecFunctionalitiesToLoad( StructSdtSecFunctionalitiesToLoad struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecObjectName") )
            {
               gxTv_SdtSecFunctionalitiesToLoad_Secobjectname = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecFunctionalityType") )
            {
               gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitytype = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecParentFunctionalityKey") )
            {
               gxTv_SdtSecFunctionalitiesToLoad_Secparentfunctionalitykey = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecFunctionalityKeys") )
            {
               if ( gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys == null )
               {
                  gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem>(com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem.class, "SecFunctionalitiesToLoad.SecFunctionalityKeysItem", "ProjectThani", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys.readxmlcollection(oReader, "SecFunctionalityKeys", "SecFunctionalityKeysItem") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "SecFunctionalityKeys") )
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
         sName = "SecFunctionalitiesToLoad" ;
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
      oWriter.writeElement("SecObjectName", GXutil.rtrim( gxTv_SdtSecFunctionalitiesToLoad_Secobjectname));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SecFunctionalityType", GXutil.trim( GXutil.str( gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitytype, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SecParentFunctionalityKey", GXutil.rtrim( gxTv_SdtSecFunctionalitiesToLoad_Secparentfunctionalitykey));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys != null )
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
         gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys.writexmlcollection(oWriter, "SecFunctionalityKeys", sNameSpace1, "SecFunctionalityKeysItem", sNameSpace1);
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
      AddObjectProperty("SecObjectName", gxTv_SdtSecFunctionalitiesToLoad_Secobjectname, false, false);
      AddObjectProperty("SecFunctionalityType", gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitytype, false, false);
      AddObjectProperty("SecParentFunctionalityKey", gxTv_SdtSecFunctionalitiesToLoad_Secparentfunctionalitykey, false, false);
      if ( gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys != null )
      {
         AddObjectProperty("SecFunctionalityKeys", gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys, false, false);
      }
   }

   public String getgxTv_SdtSecFunctionalitiesToLoad_Secobjectname( )
   {
      return gxTv_SdtSecFunctionalitiesToLoad_Secobjectname ;
   }

   public void setgxTv_SdtSecFunctionalitiesToLoad_Secobjectname( String value )
   {
      gxTv_SdtSecFunctionalitiesToLoad_N = (byte)(0) ;
      gxTv_SdtSecFunctionalitiesToLoad_Secobjectname = value ;
   }

   public byte getgxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitytype( )
   {
      return gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitytype ;
   }

   public void setgxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitytype( byte value )
   {
      gxTv_SdtSecFunctionalitiesToLoad_N = (byte)(0) ;
      gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitytype = value ;
   }

   public String getgxTv_SdtSecFunctionalitiesToLoad_Secparentfunctionalitykey( )
   {
      return gxTv_SdtSecFunctionalitiesToLoad_Secparentfunctionalitykey ;
   }

   public void setgxTv_SdtSecFunctionalitiesToLoad_Secparentfunctionalitykey( String value )
   {
      gxTv_SdtSecFunctionalitiesToLoad_N = (byte)(0) ;
      gxTv_SdtSecFunctionalitiesToLoad_Secparentfunctionalitykey = value ;
   }

   public GXBaseCollection<com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem> getgxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys( )
   {
      if ( gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys == null )
      {
         gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem>(com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem.class, "SecFunctionalitiesToLoad.SecFunctionalityKeysItem", "ProjectThani", remoteHandle);
      }
      gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys_N = (byte)(0) ;
      gxTv_SdtSecFunctionalitiesToLoad_N = (byte)(0) ;
      return gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys ;
   }

   public void setgxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys( GXBaseCollection<com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem> value )
   {
      gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys_N = (byte)(0) ;
      gxTv_SdtSecFunctionalitiesToLoad_N = (byte)(0) ;
      gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys = value ;
   }

   public void setgxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys_SetNull( )
   {
      gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys_N = (byte)(1) ;
      gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys = null ;
   }

   public boolean getgxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys_IsNull( )
   {
      if ( gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys_N( )
   {
      return gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSecFunctionalitiesToLoad_Secobjectname = "" ;
      gxTv_SdtSecFunctionalitiesToLoad_N = (byte)(1) ;
      gxTv_SdtSecFunctionalitiesToLoad_Secparentfunctionalitykey = "" ;
      gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSecFunctionalitiesToLoad_N ;
   }

   public com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad Clone( )
   {
      return (com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad)(clone()) ;
   }

   public void setStruct( com.projectthani.wwpbaseobjects.StructSdtSecFunctionalitiesToLoad struct )
   {
      setgxTv_SdtSecFunctionalitiesToLoad_Secobjectname(struct.getSecobjectname());
      setgxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitytype(struct.getSecfunctionalitytype());
      setgxTv_SdtSecFunctionalitiesToLoad_Secparentfunctionalitykey(struct.getSecparentfunctionalitykey());
      GXBaseCollection<com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem> gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys_aux = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem>(com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem.class, "SecFunctionalitiesToLoad.SecFunctionalityKeysItem", "ProjectThani", remoteHandle);
      Vector<com.projectthani.wwpbaseobjects.StructSdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem> gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys_aux1 = struct.getSecfunctionalitykeys();
      if (gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys_aux1.size(); i++)
         {
            gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys_aux.add(new com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem(gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys(gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys_aux);
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.wwpbaseobjects.StructSdtSecFunctionalitiesToLoad getStruct( )
   {
      com.projectthani.wwpbaseobjects.StructSdtSecFunctionalitiesToLoad struct = new com.projectthani.wwpbaseobjects.StructSdtSecFunctionalitiesToLoad ();
      struct.setSecobjectname(getgxTv_SdtSecFunctionalitiesToLoad_Secobjectname());
      struct.setSecfunctionalitytype(getgxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitytype());
      struct.setSecparentfunctionalitykey(getgxTv_SdtSecFunctionalitiesToLoad_Secparentfunctionalitykey());
      struct.setSecfunctionalitykeys(getgxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys().getStruct());
      return struct ;
   }

   protected byte gxTv_SdtSecFunctionalitiesToLoad_N ;
   protected byte gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitytype ;
   protected byte gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSecFunctionalitiesToLoad_Secobjectname ;
   protected String gxTv_SdtSecFunctionalitiesToLoad_Secparentfunctionalitykey ;
   protected GXBaseCollection<com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem> gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys_aux ;
   protected GXBaseCollection<com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem> gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys=null ;
}

