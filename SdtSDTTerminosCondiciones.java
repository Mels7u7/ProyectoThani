package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTTerminosCondiciones extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTTerminosCondiciones( )
   {
      this(  new ModelContext(SdtSDTTerminosCondiciones.class));
   }

   public SdtSDTTerminosCondiciones( ModelContext context )
   {
      super( context, "SdtSDTTerminosCondiciones");
   }

   public SdtSDTTerminosCondiciones( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTTerminosCondiciones");
   }

   public SdtSDTTerminosCondiciones( StructSdtSDTTerminosCondiciones struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "TerminosCondicionesTitulo") )
            {
               gxTv_SdtSDTTerminosCondiciones_Terminoscondicionestitulo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TerminosCondicionesDescripcion") )
            {
               gxTv_SdtSDTTerminosCondiciones_Terminoscondicionesdescripcion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SubTerminosCondiciones") )
            {
               if ( gxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones == null )
               {
                  gxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones = new GXBaseCollection<com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem>(com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem.class, "SDTTerminosCondiciones.SubTerminosCondicionesItem", "ProjectThani", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones.readxmlcollection(oReader, "SubTerminosCondiciones", "SubTerminosCondicionesItem") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "SubTerminosCondiciones") )
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
         sName = "SDTTerminosCondiciones" ;
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
      oWriter.writeElement("TerminosCondicionesTitulo", GXutil.rtrim( gxTv_SdtSDTTerminosCondiciones_Terminoscondicionestitulo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("TerminosCondicionesDescripcion", GXutil.rtrim( gxTv_SdtSDTTerminosCondiciones_Terminoscondicionesdescripcion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( gxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones != null )
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
         gxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones.writexmlcollection(oWriter, "SubTerminosCondiciones", sNameSpace1, "SubTerminosCondicionesItem", sNameSpace1);
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
      AddObjectProperty("TerminosCondicionesTitulo", gxTv_SdtSDTTerminosCondiciones_Terminoscondicionestitulo, false, false);
      AddObjectProperty("TerminosCondicionesDescripcion", gxTv_SdtSDTTerminosCondiciones_Terminoscondicionesdescripcion, false, false);
      if ( gxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones != null )
      {
         AddObjectProperty("SubTerminosCondiciones", gxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones, false, false);
      }
   }

   public String getgxTv_SdtSDTTerminosCondiciones_Terminoscondicionestitulo( )
   {
      return gxTv_SdtSDTTerminosCondiciones_Terminoscondicionestitulo ;
   }

   public void setgxTv_SdtSDTTerminosCondiciones_Terminoscondicionestitulo( String value )
   {
      gxTv_SdtSDTTerminosCondiciones_N = (byte)(0) ;
      gxTv_SdtSDTTerminosCondiciones_Terminoscondicionestitulo = value ;
   }

   public String getgxTv_SdtSDTTerminosCondiciones_Terminoscondicionesdescripcion( )
   {
      return gxTv_SdtSDTTerminosCondiciones_Terminoscondicionesdescripcion ;
   }

   public void setgxTv_SdtSDTTerminosCondiciones_Terminoscondicionesdescripcion( String value )
   {
      gxTv_SdtSDTTerminosCondiciones_N = (byte)(0) ;
      gxTv_SdtSDTTerminosCondiciones_Terminoscondicionesdescripcion = value ;
   }

   public GXBaseCollection<com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem> getgxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones( )
   {
      if ( gxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones == null )
      {
         gxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones = new GXBaseCollection<com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem>(com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem.class, "SDTTerminosCondiciones.SubTerminosCondicionesItem", "ProjectThani", remoteHandle);
      }
      gxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones_N = (byte)(0) ;
      gxTv_SdtSDTTerminosCondiciones_N = (byte)(0) ;
      return gxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones ;
   }

   public void setgxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones( GXBaseCollection<com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem> value )
   {
      gxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones_N = (byte)(0) ;
      gxTv_SdtSDTTerminosCondiciones_N = (byte)(0) ;
      gxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones = value ;
   }

   public void setgxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones_SetNull( )
   {
      gxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones_N = (byte)(1) ;
      gxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones = null ;
   }

   public boolean getgxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones_IsNull( )
   {
      if ( gxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones_N( )
   {
      return gxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTTerminosCondiciones_Terminoscondicionestitulo = "" ;
      gxTv_SdtSDTTerminosCondiciones_N = (byte)(1) ;
      gxTv_SdtSDTTerminosCondiciones_Terminoscondicionesdescripcion = "" ;
      gxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTTerminosCondiciones_N ;
   }

   public com.projectthani.SdtSDTTerminosCondiciones Clone( )
   {
      return (com.projectthani.SdtSDTTerminosCondiciones)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTTerminosCondiciones struct )
   {
      setgxTv_SdtSDTTerminosCondiciones_Terminoscondicionestitulo(struct.getTerminoscondicionestitulo());
      setgxTv_SdtSDTTerminosCondiciones_Terminoscondicionesdescripcion(struct.getTerminoscondicionesdescripcion());
      GXBaseCollection<com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem> gxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones_aux = new GXBaseCollection<com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem>(com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem.class, "SDTTerminosCondiciones.SubTerminosCondicionesItem", "ProjectThani", remoteHandle);
      Vector<com.projectthani.StructSdtSDTTerminosCondiciones_SubTerminosCondicionesItem> gxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones_aux1 = struct.getSubterminoscondiciones();
      if (gxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones_aux1.size(); i++)
         {
            gxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones_aux.add(new com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem(gxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones(gxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones_aux);
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTTerminosCondiciones getStruct( )
   {
      com.projectthani.StructSdtSDTTerminosCondiciones struct = new com.projectthani.StructSdtSDTTerminosCondiciones ();
      struct.setTerminoscondicionestitulo(getgxTv_SdtSDTTerminosCondiciones_Terminoscondicionestitulo());
      struct.setTerminoscondicionesdescripcion(getgxTv_SdtSDTTerminosCondiciones_Terminoscondicionesdescripcion());
      struct.setSubterminoscondiciones(getgxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones().getStruct());
      return struct ;
   }

   protected byte gxTv_SdtSDTTerminosCondiciones_N ;
   protected byte gxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTTerminosCondiciones_Terminoscondicionestitulo ;
   protected String gxTv_SdtSDTTerminosCondiciones_Terminoscondicionesdescripcion ;
   protected GXBaseCollection<com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem> gxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones_aux ;
   protected GXBaseCollection<com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem> gxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones=null ;
}

