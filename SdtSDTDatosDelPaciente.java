package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTDatosDelPaciente extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTDatosDelPaciente( )
   {
      this(  new ModelContext(SdtSDTDatosDelPaciente.class));
   }

   public SdtSDTDatosDelPaciente( ModelContext context )
   {
      super( context, "SdtSDTDatosDelPaciente");
   }

   public SdtSDTDatosDelPaciente( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTDatosDelPaciente");
   }

   public SdtSDTDatosDelPaciente( StructSdtSDTDatosDelPaciente struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "idPaciente") )
            {
               gxTv_SdtSDTDatosDelPaciente_Idpaciente = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "NombresApellidos") )
            {
               gxTv_SdtSDTDatosDelPaciente_Nombresapellidos = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FechaNacimientoEdad") )
            {
               gxTv_SdtSDTDatosDelPaciente_Fechanacimientoedad = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Direccion") )
            {
               gxTv_SdtSDTDatosDelPaciente_Direccion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Fotografia") )
            {
               gxTv_SdtSDTDatosDelPaciente_Fotografia = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Fotografia_GXI") )
            {
               gxTv_SdtSDTDatosDelPaciente_Fotografia_gxi = oReader.getValue() ;
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
         sName = "SDTDatosDelPaciente" ;
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
      oWriter.writeElement("idPaciente", GXutil.trim( GXutil.str( gxTv_SdtSDTDatosDelPaciente_Idpaciente, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("NombresApellidos", GXutil.rtrim( gxTv_SdtSDTDatosDelPaciente_Nombresapellidos));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("FechaNacimientoEdad", GXutil.rtrim( gxTv_SdtSDTDatosDelPaciente_Fechanacimientoedad));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Direccion", GXutil.rtrim( gxTv_SdtSDTDatosDelPaciente_Direccion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Fotografia", GXutil.rtrim( gxTv_SdtSDTDatosDelPaciente_Fotografia));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Fotografia_GXI", GXutil.rtrim( gxTv_SdtSDTDatosDelPaciente_Fotografia_gxi));
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
      AddObjectProperty("idPaciente", gxTv_SdtSDTDatosDelPaciente_Idpaciente, false, false);
      AddObjectProperty("NombresApellidos", gxTv_SdtSDTDatosDelPaciente_Nombresapellidos, false, false);
      AddObjectProperty("FechaNacimientoEdad", gxTv_SdtSDTDatosDelPaciente_Fechanacimientoedad, false, false);
      AddObjectProperty("Direccion", gxTv_SdtSDTDatosDelPaciente_Direccion, false, false);
      AddObjectProperty("Fotografia", gxTv_SdtSDTDatosDelPaciente_Fotografia, false, false);
      AddObjectProperty("Fotografia_GXI", gxTv_SdtSDTDatosDelPaciente_Fotografia_gxi, false, false);
   }

   public short getgxTv_SdtSDTDatosDelPaciente_Idpaciente( )
   {
      return gxTv_SdtSDTDatosDelPaciente_Idpaciente ;
   }

   public void setgxTv_SdtSDTDatosDelPaciente_Idpaciente( short value )
   {
      gxTv_SdtSDTDatosDelPaciente_N = (byte)(0) ;
      gxTv_SdtSDTDatosDelPaciente_Idpaciente = value ;
   }

   public String getgxTv_SdtSDTDatosDelPaciente_Nombresapellidos( )
   {
      return gxTv_SdtSDTDatosDelPaciente_Nombresapellidos ;
   }

   public void setgxTv_SdtSDTDatosDelPaciente_Nombresapellidos( String value )
   {
      gxTv_SdtSDTDatosDelPaciente_N = (byte)(0) ;
      gxTv_SdtSDTDatosDelPaciente_Nombresapellidos = value ;
   }

   public String getgxTv_SdtSDTDatosDelPaciente_Fechanacimientoedad( )
   {
      return gxTv_SdtSDTDatosDelPaciente_Fechanacimientoedad ;
   }

   public void setgxTv_SdtSDTDatosDelPaciente_Fechanacimientoedad( String value )
   {
      gxTv_SdtSDTDatosDelPaciente_N = (byte)(0) ;
      gxTv_SdtSDTDatosDelPaciente_Fechanacimientoedad = value ;
   }

   public String getgxTv_SdtSDTDatosDelPaciente_Direccion( )
   {
      return gxTv_SdtSDTDatosDelPaciente_Direccion ;
   }

   public void setgxTv_SdtSDTDatosDelPaciente_Direccion( String value )
   {
      gxTv_SdtSDTDatosDelPaciente_N = (byte)(0) ;
      gxTv_SdtSDTDatosDelPaciente_Direccion = value ;
   }

   @GxUpload
   public String getgxTv_SdtSDTDatosDelPaciente_Fotografia( )
   {
      return gxTv_SdtSDTDatosDelPaciente_Fotografia ;
   }

   public void setgxTv_SdtSDTDatosDelPaciente_Fotografia( String value )
   {
      gxTv_SdtSDTDatosDelPaciente_N = (byte)(0) ;
      gxTv_SdtSDTDatosDelPaciente_Fotografia = value ;
   }

   public String getgxTv_SdtSDTDatosDelPaciente_Fotografia_gxi( )
   {
      return gxTv_SdtSDTDatosDelPaciente_Fotografia_gxi ;
   }

   public void setgxTv_SdtSDTDatosDelPaciente_Fotografia_gxi( String value )
   {
      gxTv_SdtSDTDatosDelPaciente_N = (byte)(0) ;
      gxTv_SdtSDTDatosDelPaciente_Fotografia_gxi = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTDatosDelPaciente_N = (byte)(1) ;
      gxTv_SdtSDTDatosDelPaciente_Nombresapellidos = "" ;
      gxTv_SdtSDTDatosDelPaciente_Fechanacimientoedad = "" ;
      gxTv_SdtSDTDatosDelPaciente_Direccion = "" ;
      gxTv_SdtSDTDatosDelPaciente_Fotografia = "" ;
      gxTv_SdtSDTDatosDelPaciente_Fotografia_gxi = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTDatosDelPaciente_N ;
   }

   public com.projectthani.SdtSDTDatosDelPaciente Clone( )
   {
      return (com.projectthani.SdtSDTDatosDelPaciente)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTDatosDelPaciente struct )
   {
      setgxTv_SdtSDTDatosDelPaciente_Idpaciente(struct.getIdpaciente());
      setgxTv_SdtSDTDatosDelPaciente_Nombresapellidos(struct.getNombresapellidos());
      setgxTv_SdtSDTDatosDelPaciente_Fechanacimientoedad(struct.getFechanacimientoedad());
      setgxTv_SdtSDTDatosDelPaciente_Direccion(struct.getDireccion());
      setgxTv_SdtSDTDatosDelPaciente_Fotografia(struct.getFotografia());
      setgxTv_SdtSDTDatosDelPaciente_Fotografia_gxi(struct.getFotografia_gxi());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTDatosDelPaciente getStruct( )
   {
      com.projectthani.StructSdtSDTDatosDelPaciente struct = new com.projectthani.StructSdtSDTDatosDelPaciente ();
      struct.setIdpaciente(getgxTv_SdtSDTDatosDelPaciente_Idpaciente());
      struct.setNombresapellidos(getgxTv_SdtSDTDatosDelPaciente_Nombresapellidos());
      struct.setFechanacimientoedad(getgxTv_SdtSDTDatosDelPaciente_Fechanacimientoedad());
      struct.setDireccion(getgxTv_SdtSDTDatosDelPaciente_Direccion());
      struct.setFotografia(getgxTv_SdtSDTDatosDelPaciente_Fotografia());
      struct.setFotografia_gxi(getgxTv_SdtSDTDatosDelPaciente_Fotografia_gxi());
      return struct ;
   }

   protected byte gxTv_SdtSDTDatosDelPaciente_N ;
   protected short gxTv_SdtSDTDatosDelPaciente_Idpaciente ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTDatosDelPaciente_Fechanacimientoedad ;
   protected String gxTv_SdtSDTDatosDelPaciente_Direccion ;
   protected String gxTv_SdtSDTDatosDelPaciente_Nombresapellidos ;
   protected String gxTv_SdtSDTDatosDelPaciente_Fotografia_gxi ;
   protected String gxTv_SdtSDTDatosDelPaciente_Fotografia ;
}

