package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTInformacionDelPacienteFacturacionB extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTInformacionDelPacienteFacturacionB( )
   {
      this(  new ModelContext(SdtSDTInformacionDelPacienteFacturacionB.class));
   }

   public SdtSDTInformacionDelPacienteFacturacionB( ModelContext context )
   {
      super( context, "SdtSDTInformacionDelPacienteFacturacionB");
   }

   public SdtSDTInformacionDelPacienteFacturacionB( int remoteHandle ,
                                                    ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTInformacionDelPacienteFacturacionB");
   }

   public SdtSDTInformacionDelPacienteFacturacionB( StructSdtSDTInformacionDelPacienteFacturacionB struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTInformacionDelPacienteFacturacionBNombres") )
            {
               gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbnombres = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTInformacionDelPacienteFacturacionBApellidos") )
            {
               gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbapellidos = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTInformacionDelPacienteFacturacionBTipoDocumento") )
            {
               gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtipodocumento = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTInformacionDelPacienteFacturacionBNroDocumento") )
            {
               gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbnrodocumento = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTInformacionDelPacienteFacturacionBEmail") )
            {
               gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbemail = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTInformacionDelPacienteFacturacionBTelefono") )
            {
               gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtelefono = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTInformacionDelPacienteFacturacionBDireccion") )
            {
               gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbdireccion = oReader.getValue() ;
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
         sName = "SDTInformacionDelPacienteFacturacionB" ;
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
      oWriter.writeElement("SDTInformacionDelPacienteFacturacionBNombres", GXutil.rtrim( gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbnombres));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTInformacionDelPacienteFacturacionBApellidos", GXutil.rtrim( gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbapellidos));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTInformacionDelPacienteFacturacionBTipoDocumento", GXutil.rtrim( gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtipodocumento));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTInformacionDelPacienteFacturacionBNroDocumento", GXutil.rtrim( gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbnrodocumento));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTInformacionDelPacienteFacturacionBEmail", GXutil.rtrim( gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbemail));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTInformacionDelPacienteFacturacionBTelefono", GXutil.rtrim( gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtelefono));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTInformacionDelPacienteFacturacionBDireccion", GXutil.rtrim( gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbdireccion));
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
      AddObjectProperty("SDTInformacionDelPacienteFacturacionBNombres", gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbnombres, false, false);
      AddObjectProperty("SDTInformacionDelPacienteFacturacionBApellidos", gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbapellidos, false, false);
      AddObjectProperty("SDTInformacionDelPacienteFacturacionBTipoDocumento", gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtipodocumento, false, false);
      AddObjectProperty("SDTInformacionDelPacienteFacturacionBNroDocumento", gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbnrodocumento, false, false);
      AddObjectProperty("SDTInformacionDelPacienteFacturacionBEmail", gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbemail, false, false);
      AddObjectProperty("SDTInformacionDelPacienteFacturacionBTelefono", gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtelefono, false, false);
      AddObjectProperty("SDTInformacionDelPacienteFacturacionBDireccion", gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbdireccion, false, false);
   }

   public String getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbnombres( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbnombres ;
   }

   public void setgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbnombres( String value )
   {
      gxTv_SdtSDTInformacionDelPacienteFacturacionB_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbnombres = value ;
   }

   public String getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbapellidos( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbapellidos ;
   }

   public void setgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbapellidos( String value )
   {
      gxTv_SdtSDTInformacionDelPacienteFacturacionB_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbapellidos = value ;
   }

   public String getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtipodocumento( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtipodocumento ;
   }

   public void setgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtipodocumento( String value )
   {
      gxTv_SdtSDTInformacionDelPacienteFacturacionB_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtipodocumento = value ;
   }

   public String getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbnrodocumento( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbnrodocumento ;
   }

   public void setgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbnrodocumento( String value )
   {
      gxTv_SdtSDTInformacionDelPacienteFacturacionB_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbnrodocumento = value ;
   }

   public String getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbemail( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbemail ;
   }

   public void setgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbemail( String value )
   {
      gxTv_SdtSDTInformacionDelPacienteFacturacionB_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbemail = value ;
   }

   public String getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtelefono( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtelefono ;
   }

   public void setgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtelefono( String value )
   {
      gxTv_SdtSDTInformacionDelPacienteFacturacionB_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtelefono = value ;
   }

   public String getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbdireccion( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbdireccion ;
   }

   public void setgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbdireccion( String value )
   {
      gxTv_SdtSDTInformacionDelPacienteFacturacionB_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbdireccion = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbnombres = "" ;
      gxTv_SdtSDTInformacionDelPacienteFacturacionB_N = (byte)(1) ;
      gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbapellidos = "" ;
      gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtipodocumento = "" ;
      gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbnrodocumento = "" ;
      gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbemail = "" ;
      gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtelefono = "" ;
      gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbdireccion = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFacturacionB_N ;
   }

   public com.projectthani.SdtSDTInformacionDelPacienteFacturacionB Clone( )
   {
      return (com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTInformacionDelPacienteFacturacionB struct )
   {
      setgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbnombres(struct.getSdtinformaciondelpacientefacturacionbnombres());
      setgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbapellidos(struct.getSdtinformaciondelpacientefacturacionbapellidos());
      setgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtipodocumento(struct.getSdtinformaciondelpacientefacturacionbtipodocumento());
      setgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbnrodocumento(struct.getSdtinformaciondelpacientefacturacionbnrodocumento());
      setgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbemail(struct.getSdtinformaciondelpacientefacturacionbemail());
      setgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtelefono(struct.getSdtinformaciondelpacientefacturacionbtelefono());
      setgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbdireccion(struct.getSdtinformaciondelpacientefacturacionbdireccion());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTInformacionDelPacienteFacturacionB getStruct( )
   {
      com.projectthani.StructSdtSDTInformacionDelPacienteFacturacionB struct = new com.projectthani.StructSdtSDTInformacionDelPacienteFacturacionB ();
      struct.setSdtinformaciondelpacientefacturacionbnombres(getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbnombres());
      struct.setSdtinformaciondelpacientefacturacionbapellidos(getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbapellidos());
      struct.setSdtinformaciondelpacientefacturacionbtipodocumento(getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtipodocumento());
      struct.setSdtinformaciondelpacientefacturacionbnrodocumento(getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbnrodocumento());
      struct.setSdtinformaciondelpacientefacturacionbemail(getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbemail());
      struct.setSdtinformaciondelpacientefacturacionbtelefono(getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtelefono());
      struct.setSdtinformaciondelpacientefacturacionbdireccion(getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbdireccion());
      return struct ;
   }

   protected byte gxTv_SdtSDTInformacionDelPacienteFacturacionB_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtipodocumento ;
   protected String gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtelefono ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbnombres ;
   protected String gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbapellidos ;
   protected String gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbnrodocumento ;
   protected String gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbemail ;
   protected String gxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbdireccion ;
}

