package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTPacienteData extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTPacienteData( )
   {
      this(  new ModelContext(SdtSDTPacienteData.class));
   }

   public SdtSDTPacienteData( ModelContext context )
   {
      super( context, "SdtSDTPacienteData");
   }

   public SdtSDTPacienteData( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTPacienteData");
   }

   public SdtSDTPacienteData( StructSdtSDTPacienteData struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteApellidoPaterno") )
            {
               gxTv_SdtSDTPacienteData_Pacienteapellidopaterno = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteApellidoMaterno") )
            {
               gxTv_SdtSDTPacienteData_Pacienteapellidomaterno = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteNombres") )
            {
               gxTv_SdtSDTPacienteData_Pacientenombres = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteCorreo") )
            {
               gxTv_SdtSDTPacienteData_Pacientecorreo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteTelefono") )
            {
               gxTv_SdtSDTPacienteData_Pacientetelefono = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteFechaNacimiento") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtSDTPacienteData_Pacientefechanacimiento = GXutil.nullDate() ;
                  gxTv_SdtSDTPacienteData_Pacientefechanacimiento_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtSDTPacienteData_Pacientefechanacimiento_N = (byte)(0) ;
                  gxTv_SdtSDTPacienteData_Pacientefechanacimiento = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteFechaNacimientoDescripcion") )
            {
               gxTv_SdtSDTPacienteData_Pacientefechanacimientodescripcion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteNroDocumento") )
            {
               gxTv_SdtSDTPacienteData_Pacientenrodocumento = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteTipoDocumento") )
            {
               gxTv_SdtSDTPacienteData_Pacientetipodocumento = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteSexo") )
            {
               gxTv_SdtSDTPacienteData_Pacientesexo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteDireccion") )
            {
               gxTv_SdtSDTPacienteData_Pacientedireccion = oReader.getValue() ;
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
         sName = "SDTPacienteData" ;
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
      oWriter.writeElement("PacienteApellidoPaterno", GXutil.rtrim( gxTv_SdtSDTPacienteData_Pacienteapellidopaterno));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteApellidoMaterno", GXutil.rtrim( gxTv_SdtSDTPacienteData_Pacienteapellidomaterno));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteNombres", GXutil.rtrim( gxTv_SdtSDTPacienteData_Pacientenombres));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteCorreo", GXutil.rtrim( gxTv_SdtSDTPacienteData_Pacientecorreo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteTelefono", GXutil.rtrim( gxTv_SdtSDTPacienteData_Pacientetelefono));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_SdtSDTPacienteData_Pacientefechanacimiento)) && ( gxTv_SdtSDTPacienteData_Pacientefechanacimiento_N == 1 ) )
      {
         oWriter.writeElement("PacienteFechaNacimiento", "");
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTPacienteData_Pacientefechanacimiento), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTPacienteData_Pacientefechanacimiento), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTPacienteData_Pacientefechanacimiento), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("PacienteFechaNacimiento", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      oWriter.writeElement("PacienteFechaNacimientoDescripcion", GXutil.rtrim( gxTv_SdtSDTPacienteData_Pacientefechanacimientodescripcion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteNroDocumento", GXutil.rtrim( gxTv_SdtSDTPacienteData_Pacientenrodocumento));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteTipoDocumento", GXutil.rtrim( gxTv_SdtSDTPacienteData_Pacientetipodocumento));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteSexo", GXutil.rtrim( gxTv_SdtSDTPacienteData_Pacientesexo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteDireccion", GXutil.rtrim( gxTv_SdtSDTPacienteData_Pacientedireccion));
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
      AddObjectProperty("PacienteApellidoPaterno", gxTv_SdtSDTPacienteData_Pacienteapellidopaterno, false, false);
      AddObjectProperty("PacienteApellidoMaterno", gxTv_SdtSDTPacienteData_Pacienteapellidomaterno, false, false);
      AddObjectProperty("PacienteNombres", gxTv_SdtSDTPacienteData_Pacientenombres, false, false);
      AddObjectProperty("PacienteCorreo", gxTv_SdtSDTPacienteData_Pacientecorreo, false, false);
      AddObjectProperty("PacienteTelefono", gxTv_SdtSDTPacienteData_Pacientetelefono, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTPacienteData_Pacientefechanacimiento), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTPacienteData_Pacientefechanacimiento), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTPacienteData_Pacientefechanacimiento), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("PacienteFechaNacimiento", sDateCnv, false, false);
      AddObjectProperty("PacienteFechaNacimientoDescripcion", gxTv_SdtSDTPacienteData_Pacientefechanacimientodescripcion, false, false);
      AddObjectProperty("PacienteNroDocumento", gxTv_SdtSDTPacienteData_Pacientenrodocumento, false, false);
      AddObjectProperty("PacienteTipoDocumento", gxTv_SdtSDTPacienteData_Pacientetipodocumento, false, false);
      AddObjectProperty("PacienteSexo", gxTv_SdtSDTPacienteData_Pacientesexo, false, false);
      AddObjectProperty("PacienteDireccion", gxTv_SdtSDTPacienteData_Pacientedireccion, false, false);
   }

   public String getgxTv_SdtSDTPacienteData_Pacienteapellidopaterno( )
   {
      return gxTv_SdtSDTPacienteData_Pacienteapellidopaterno ;
   }

   public void setgxTv_SdtSDTPacienteData_Pacienteapellidopaterno( String value )
   {
      gxTv_SdtSDTPacienteData_N = (byte)(0) ;
      gxTv_SdtSDTPacienteData_Pacienteapellidopaterno = value ;
   }

   public String getgxTv_SdtSDTPacienteData_Pacienteapellidomaterno( )
   {
      return gxTv_SdtSDTPacienteData_Pacienteapellidomaterno ;
   }

   public void setgxTv_SdtSDTPacienteData_Pacienteapellidomaterno( String value )
   {
      gxTv_SdtSDTPacienteData_N = (byte)(0) ;
      gxTv_SdtSDTPacienteData_Pacienteapellidomaterno = value ;
   }

   public String getgxTv_SdtSDTPacienteData_Pacientenombres( )
   {
      return gxTv_SdtSDTPacienteData_Pacientenombres ;
   }

   public void setgxTv_SdtSDTPacienteData_Pacientenombres( String value )
   {
      gxTv_SdtSDTPacienteData_N = (byte)(0) ;
      gxTv_SdtSDTPacienteData_Pacientenombres = value ;
   }

   public String getgxTv_SdtSDTPacienteData_Pacientecorreo( )
   {
      return gxTv_SdtSDTPacienteData_Pacientecorreo ;
   }

   public void setgxTv_SdtSDTPacienteData_Pacientecorreo( String value )
   {
      gxTv_SdtSDTPacienteData_N = (byte)(0) ;
      gxTv_SdtSDTPacienteData_Pacientecorreo = value ;
   }

   public String getgxTv_SdtSDTPacienteData_Pacientetelefono( )
   {
      return gxTv_SdtSDTPacienteData_Pacientetelefono ;
   }

   public void setgxTv_SdtSDTPacienteData_Pacientetelefono( String value )
   {
      gxTv_SdtSDTPacienteData_N = (byte)(0) ;
      gxTv_SdtSDTPacienteData_Pacientetelefono = value ;
   }

   public java.util.Date getgxTv_SdtSDTPacienteData_Pacientefechanacimiento( )
   {
      return gxTv_SdtSDTPacienteData_Pacientefechanacimiento ;
   }

   public void setgxTv_SdtSDTPacienteData_Pacientefechanacimiento( java.util.Date value )
   {
      gxTv_SdtSDTPacienteData_Pacientefechanacimiento_N = (byte)(0) ;
      gxTv_SdtSDTPacienteData_N = (byte)(0) ;
      gxTv_SdtSDTPacienteData_Pacientefechanacimiento = value ;
   }

   public String getgxTv_SdtSDTPacienteData_Pacientefechanacimientodescripcion( )
   {
      return gxTv_SdtSDTPacienteData_Pacientefechanacimientodescripcion ;
   }

   public void setgxTv_SdtSDTPacienteData_Pacientefechanacimientodescripcion( String value )
   {
      gxTv_SdtSDTPacienteData_N = (byte)(0) ;
      gxTv_SdtSDTPacienteData_Pacientefechanacimientodescripcion = value ;
   }

   public String getgxTv_SdtSDTPacienteData_Pacientenrodocumento( )
   {
      return gxTv_SdtSDTPacienteData_Pacientenrodocumento ;
   }

   public void setgxTv_SdtSDTPacienteData_Pacientenrodocumento( String value )
   {
      gxTv_SdtSDTPacienteData_N = (byte)(0) ;
      gxTv_SdtSDTPacienteData_Pacientenrodocumento = value ;
   }

   public String getgxTv_SdtSDTPacienteData_Pacientetipodocumento( )
   {
      return gxTv_SdtSDTPacienteData_Pacientetipodocumento ;
   }

   public void setgxTv_SdtSDTPacienteData_Pacientetipodocumento( String value )
   {
      gxTv_SdtSDTPacienteData_N = (byte)(0) ;
      gxTv_SdtSDTPacienteData_Pacientetipodocumento = value ;
   }

   public String getgxTv_SdtSDTPacienteData_Pacientesexo( )
   {
      return gxTv_SdtSDTPacienteData_Pacientesexo ;
   }

   public void setgxTv_SdtSDTPacienteData_Pacientesexo( String value )
   {
      gxTv_SdtSDTPacienteData_N = (byte)(0) ;
      gxTv_SdtSDTPacienteData_Pacientesexo = value ;
   }

   public String getgxTv_SdtSDTPacienteData_Pacientedireccion( )
   {
      return gxTv_SdtSDTPacienteData_Pacientedireccion ;
   }

   public void setgxTv_SdtSDTPacienteData_Pacientedireccion( String value )
   {
      gxTv_SdtSDTPacienteData_N = (byte)(0) ;
      gxTv_SdtSDTPacienteData_Pacientedireccion = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTPacienteData_Pacienteapellidopaterno = "" ;
      gxTv_SdtSDTPacienteData_N = (byte)(1) ;
      gxTv_SdtSDTPacienteData_Pacienteapellidomaterno = "" ;
      gxTv_SdtSDTPacienteData_Pacientenombres = "" ;
      gxTv_SdtSDTPacienteData_Pacientecorreo = "" ;
      gxTv_SdtSDTPacienteData_Pacientetelefono = "" ;
      gxTv_SdtSDTPacienteData_Pacientefechanacimiento = GXutil.nullDate() ;
      gxTv_SdtSDTPacienteData_Pacientefechanacimiento_N = (byte)(1) ;
      gxTv_SdtSDTPacienteData_Pacientefechanacimientodescripcion = "" ;
      gxTv_SdtSDTPacienteData_Pacientenrodocumento = "" ;
      gxTv_SdtSDTPacienteData_Pacientetipodocumento = "" ;
      gxTv_SdtSDTPacienteData_Pacientesexo = "" ;
      gxTv_SdtSDTPacienteData_Pacientedireccion = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTPacienteData_N ;
   }

   public com.projectthani.SdtSDTPacienteData Clone( )
   {
      return (com.projectthani.SdtSDTPacienteData)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTPacienteData struct )
   {
      setgxTv_SdtSDTPacienteData_Pacienteapellidopaterno(struct.getPacienteapellidopaterno());
      setgxTv_SdtSDTPacienteData_Pacienteapellidomaterno(struct.getPacienteapellidomaterno());
      setgxTv_SdtSDTPacienteData_Pacientenombres(struct.getPacientenombres());
      setgxTv_SdtSDTPacienteData_Pacientecorreo(struct.getPacientecorreo());
      setgxTv_SdtSDTPacienteData_Pacientetelefono(struct.getPacientetelefono());
      if ( struct.gxTv_SdtSDTPacienteData_Pacientefechanacimiento_N == 0 )
      {
         setgxTv_SdtSDTPacienteData_Pacientefechanacimiento(struct.getPacientefechanacimiento());
      }
      setgxTv_SdtSDTPacienteData_Pacientefechanacimientodescripcion(struct.getPacientefechanacimientodescripcion());
      setgxTv_SdtSDTPacienteData_Pacientenrodocumento(struct.getPacientenrodocumento());
      setgxTv_SdtSDTPacienteData_Pacientetipodocumento(struct.getPacientetipodocumento());
      setgxTv_SdtSDTPacienteData_Pacientesexo(struct.getPacientesexo());
      setgxTv_SdtSDTPacienteData_Pacientedireccion(struct.getPacientedireccion());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTPacienteData getStruct( )
   {
      com.projectthani.StructSdtSDTPacienteData struct = new com.projectthani.StructSdtSDTPacienteData ();
      struct.setPacienteapellidopaterno(getgxTv_SdtSDTPacienteData_Pacienteapellidopaterno());
      struct.setPacienteapellidomaterno(getgxTv_SdtSDTPacienteData_Pacienteapellidomaterno());
      struct.setPacientenombres(getgxTv_SdtSDTPacienteData_Pacientenombres());
      struct.setPacientecorreo(getgxTv_SdtSDTPacienteData_Pacientecorreo());
      struct.setPacientetelefono(getgxTv_SdtSDTPacienteData_Pacientetelefono());
      if ( gxTv_SdtSDTPacienteData_Pacientefechanacimiento_N == 0 )
      {
         struct.setPacientefechanacimiento(getgxTv_SdtSDTPacienteData_Pacientefechanacimiento());
      }
      struct.setPacientefechanacimientodescripcion(getgxTv_SdtSDTPacienteData_Pacientefechanacimientodescripcion());
      struct.setPacientenrodocumento(getgxTv_SdtSDTPacienteData_Pacientenrodocumento());
      struct.setPacientetipodocumento(getgxTv_SdtSDTPacienteData_Pacientetipodocumento());
      struct.setPacientesexo(getgxTv_SdtSDTPacienteData_Pacientesexo());
      struct.setPacientedireccion(getgxTv_SdtSDTPacienteData_Pacientedireccion());
      return struct ;
   }

   protected byte gxTv_SdtSDTPacienteData_N ;
   protected byte gxTv_SdtSDTPacienteData_Pacientefechanacimiento_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtSDTPacienteData_Pacientetelefono ;
   protected String gxTv_SdtSDTPacienteData_Pacientetipodocumento ;
   protected String gxTv_SdtSDTPacienteData_Pacientesexo ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_SdtSDTPacienteData_Pacientefechanacimiento ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTPacienteData_Pacienteapellidopaterno ;
   protected String gxTv_SdtSDTPacienteData_Pacienteapellidomaterno ;
   protected String gxTv_SdtSDTPacienteData_Pacientenombres ;
   protected String gxTv_SdtSDTPacienteData_Pacientecorreo ;
   protected String gxTv_SdtSDTPacienteData_Pacientefechanacimientodescripcion ;
   protected String gxTv_SdtSDTPacienteData_Pacientenrodocumento ;
   protected String gxTv_SdtSDTPacienteData_Pacientedireccion ;
}

