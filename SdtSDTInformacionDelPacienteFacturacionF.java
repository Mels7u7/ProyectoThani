package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTInformacionDelPacienteFacturacionF extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTInformacionDelPacienteFacturacionF( )
   {
      this(  new ModelContext(SdtSDTInformacionDelPacienteFacturacionF.class));
   }

   public SdtSDTInformacionDelPacienteFacturacionF( ModelContext context )
   {
      super( context, "SdtSDTInformacionDelPacienteFacturacionF");
   }

   public SdtSDTInformacionDelPacienteFacturacionF( int remoteHandle ,
                                                    ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTInformacionDelPacienteFacturacionF");
   }

   public SdtSDTInformacionDelPacienteFacturacionF( StructSdtSDTInformacionDelPacienteFacturacionF struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTInformacionDelPacienteFacturacionFTipoDocumento") )
            {
               gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionftipodocumento = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTInformacionDelPacienteFacturacionFNroDocumento") )
            {
               gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfnrodocumento = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTInformacionDelPacienteFacturacionFRazonSocial") )
            {
               gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfrazonsocial = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTInformacionDelPacienteFacturacionFDireccion") )
            {
               gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfdireccion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTInformacionDelPacienteFacturacionFEmail") )
            {
               gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfemail = oReader.getValue() ;
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
         sName = "SDTInformacionDelPacienteFacturacionF" ;
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
      oWriter.writeElement("SDTInformacionDelPacienteFacturacionFTipoDocumento", GXutil.rtrim( gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionftipodocumento));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTInformacionDelPacienteFacturacionFNroDocumento", GXutil.rtrim( gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfnrodocumento));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTInformacionDelPacienteFacturacionFRazonSocial", GXutil.rtrim( gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfrazonsocial));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTInformacionDelPacienteFacturacionFDireccion", GXutil.rtrim( gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfdireccion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTInformacionDelPacienteFacturacionFEmail", GXutil.rtrim( gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfemail));
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
      AddObjectProperty("SDTInformacionDelPacienteFacturacionFTipoDocumento", gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionftipodocumento, false, false);
      AddObjectProperty("SDTInformacionDelPacienteFacturacionFNroDocumento", gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfnrodocumento, false, false);
      AddObjectProperty("SDTInformacionDelPacienteFacturacionFRazonSocial", gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfrazonsocial, false, false);
      AddObjectProperty("SDTInformacionDelPacienteFacturacionFDireccion", gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfdireccion, false, false);
      AddObjectProperty("SDTInformacionDelPacienteFacturacionFEmail", gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfemail, false, false);
   }

   public String getgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionftipodocumento( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionftipodocumento ;
   }

   public void setgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionftipodocumento( String value )
   {
      gxTv_SdtSDTInformacionDelPacienteFacturacionF_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionftipodocumento = value ;
   }

   public String getgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfnrodocumento( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfnrodocumento ;
   }

   public void setgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfnrodocumento( String value )
   {
      gxTv_SdtSDTInformacionDelPacienteFacturacionF_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfnrodocumento = value ;
   }

   public String getgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfrazonsocial( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfrazonsocial ;
   }

   public void setgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfrazonsocial( String value )
   {
      gxTv_SdtSDTInformacionDelPacienteFacturacionF_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfrazonsocial = value ;
   }

   public String getgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfdireccion( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfdireccion ;
   }

   public void setgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfdireccion( String value )
   {
      gxTv_SdtSDTInformacionDelPacienteFacturacionF_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfdireccion = value ;
   }

   public String getgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfemail( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfemail ;
   }

   public void setgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfemail( String value )
   {
      gxTv_SdtSDTInformacionDelPacienteFacturacionF_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfemail = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionftipodocumento = "" ;
      gxTv_SdtSDTInformacionDelPacienteFacturacionF_N = (byte)(1) ;
      gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfnrodocumento = "" ;
      gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfrazonsocial = "" ;
      gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfdireccion = "" ;
      gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfemail = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFacturacionF_N ;
   }

   public com.projectthani.SdtSDTInformacionDelPacienteFacturacionF Clone( )
   {
      return (com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTInformacionDelPacienteFacturacionF struct )
   {
      setgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionftipodocumento(struct.getSdtinformaciondelpacientefacturacionftipodocumento());
      setgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfnrodocumento(struct.getSdtinformaciondelpacientefacturacionfnrodocumento());
      setgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfrazonsocial(struct.getSdtinformaciondelpacientefacturacionfrazonsocial());
      setgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfdireccion(struct.getSdtinformaciondelpacientefacturacionfdireccion());
      setgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfemail(struct.getSdtinformaciondelpacientefacturacionfemail());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTInformacionDelPacienteFacturacionF getStruct( )
   {
      com.projectthani.StructSdtSDTInformacionDelPacienteFacturacionF struct = new com.projectthani.StructSdtSDTInformacionDelPacienteFacturacionF ();
      struct.setSdtinformaciondelpacientefacturacionftipodocumento(getgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionftipodocumento());
      struct.setSdtinformaciondelpacientefacturacionfnrodocumento(getgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfnrodocumento());
      struct.setSdtinformaciondelpacientefacturacionfrazonsocial(getgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfrazonsocial());
      struct.setSdtinformaciondelpacientefacturacionfdireccion(getgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfdireccion());
      struct.setSdtinformaciondelpacientefacturacionfemail(getgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfemail());
      return struct ;
   }

   protected byte gxTv_SdtSDTInformacionDelPacienteFacturacionF_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionftipodocumento ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfnrodocumento ;
   protected String gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfrazonsocial ;
   protected String gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfdireccion ;
   protected String gxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfemail ;
}

