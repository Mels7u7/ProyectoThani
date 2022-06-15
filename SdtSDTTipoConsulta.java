package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTTipoConsulta extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTTipoConsulta( )
   {
      this(  new ModelContext(SdtSDTTipoConsulta.class));
   }

   public SdtSDTTipoConsulta( ModelContext context )
   {
      super( context, "SdtSDTTipoConsulta");
   }

   public SdtSDTTipoConsulta( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTTipoConsulta");
   }

   public SdtSDTTipoConsulta( StructSdtSDTTipoConsulta struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "SedeTipoConsulta") )
            {
               gxTv_SdtSDTTipoConsulta_Sedetipoconsulta = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SedeTipoConsultaDescripcion") )
            {
               gxTv_SdtSDTTipoConsulta_Sedetipoconsultadescripcion = oReader.getValue() ;
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
         sName = "SDTTipoConsulta" ;
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
      oWriter.writeElement("SedeTipoConsulta", GXutil.rtrim( gxTv_SdtSDTTipoConsulta_Sedetipoconsulta));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SedeTipoConsultaDescripcion", GXutil.rtrim( gxTv_SdtSDTTipoConsulta_Sedetipoconsultadescripcion));
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
      AddObjectProperty("SedeTipoConsulta", gxTv_SdtSDTTipoConsulta_Sedetipoconsulta, false, false);
      AddObjectProperty("SedeTipoConsultaDescripcion", gxTv_SdtSDTTipoConsulta_Sedetipoconsultadescripcion, false, false);
   }

   public String getgxTv_SdtSDTTipoConsulta_Sedetipoconsulta( )
   {
      return gxTv_SdtSDTTipoConsulta_Sedetipoconsulta ;
   }

   public void setgxTv_SdtSDTTipoConsulta_Sedetipoconsulta( String value )
   {
      gxTv_SdtSDTTipoConsulta_N = (byte)(0) ;
      gxTv_SdtSDTTipoConsulta_Sedetipoconsulta = value ;
   }

   public String getgxTv_SdtSDTTipoConsulta_Sedetipoconsultadescripcion( )
   {
      return gxTv_SdtSDTTipoConsulta_Sedetipoconsultadescripcion ;
   }

   public void setgxTv_SdtSDTTipoConsulta_Sedetipoconsultadescripcion( String value )
   {
      gxTv_SdtSDTTipoConsulta_N = (byte)(0) ;
      gxTv_SdtSDTTipoConsulta_Sedetipoconsultadescripcion = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTTipoConsulta_Sedetipoconsulta = "" ;
      gxTv_SdtSDTTipoConsulta_N = (byte)(1) ;
      gxTv_SdtSDTTipoConsulta_Sedetipoconsultadescripcion = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTTipoConsulta_N ;
   }

   public com.projectthani.SdtSDTTipoConsulta Clone( )
   {
      return (com.projectthani.SdtSDTTipoConsulta)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTTipoConsulta struct )
   {
      setgxTv_SdtSDTTipoConsulta_Sedetipoconsulta(struct.getSedetipoconsulta());
      setgxTv_SdtSDTTipoConsulta_Sedetipoconsultadescripcion(struct.getSedetipoconsultadescripcion());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTTipoConsulta getStruct( )
   {
      com.projectthani.StructSdtSDTTipoConsulta struct = new com.projectthani.StructSdtSDTTipoConsulta ();
      struct.setSedetipoconsulta(getgxTv_SdtSDTTipoConsulta_Sedetipoconsulta());
      struct.setSedetipoconsultadescripcion(getgxTv_SdtSDTTipoConsulta_Sedetipoconsultadescripcion());
      return struct ;
   }

   protected byte gxTv_SdtSDTTipoConsulta_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtSDTTipoConsulta_Sedetipoconsulta ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTTipoConsulta_Sedetipoconsultadescripcion ;
}

