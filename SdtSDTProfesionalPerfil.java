package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTProfesionalPerfil extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTProfesionalPerfil( )
   {
      this(  new ModelContext(SdtSDTProfesionalPerfil.class));
   }

   public SdtSDTProfesionalPerfil( ModelContext context )
   {
      super( context, "SdtSDTProfesionalPerfil");
   }

   public SdtSDTProfesionalPerfil( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTProfesionalPerfil");
   }

   public SdtSDTProfesionalPerfil( StructSdtSDTProfesionalPerfil struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTProfesionalPerfilProfesionalId") )
            {
               gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilprofesionalid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTProfesionalPerfilNombresApellidos") )
            {
               gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilnombresapellidos = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTProfesionalPerfilFotografia") )
            {
               gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilfotografia = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTProfesionalPerfilFotografia_GXI") )
            {
               gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilfotografia_gxi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTProfesionalPerfilDescripcion") )
            {
               gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfildescripcion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTProfesionalPerfilEspecialidades") )
            {
               gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilespecialidades = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTProfesionalPerfilCalificacion") )
            {
               gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilcalificacion = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTProfesionalPerfilDireccion") )
            {
               gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfildireccion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTProfesionalPerfilFacebook") )
            {
               gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilfacebook = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTProfesionalPerfilTwiter") )
            {
               gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfiltwiter = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTProfesionalPerfilInstagram") )
            {
               gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilinstagram = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTProfesionalPerfilLinkedin") )
            {
               gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfillinkedin = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTProfesionalPerfilOtros") )
            {
               gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilotros = oReader.getValue() ;
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
         sName = "SDTProfesionalPerfil" ;
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
      oWriter.writeElement("SDTProfesionalPerfilProfesionalId", GXutil.trim( GXutil.str( gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilprofesionalid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTProfesionalPerfilNombresApellidos", GXutil.rtrim( gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilnombresapellidos));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTProfesionalPerfilFotografia", GXutil.rtrim( gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilfotografia));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTProfesionalPerfilFotografia_GXI", GXutil.rtrim( gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilfotografia_gxi));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTProfesionalPerfilDescripcion", GXutil.rtrim( gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfildescripcion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTProfesionalPerfilEspecialidades", GXutil.rtrim( gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilespecialidades));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTProfesionalPerfilCalificacion", GXutil.trim( GXutil.str( gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilcalificacion, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTProfesionalPerfilDireccion", GXutil.rtrim( gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfildireccion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTProfesionalPerfilFacebook", GXutil.rtrim( gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilfacebook));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTProfesionalPerfilTwiter", GXutil.rtrim( gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfiltwiter));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTProfesionalPerfilInstagram", GXutil.rtrim( gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilinstagram));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTProfesionalPerfilLinkedin", GXutil.rtrim( gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfillinkedin));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTProfesionalPerfilOtros", GXutil.rtrim( gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilotros));
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
      AddObjectProperty("SDTProfesionalPerfilProfesionalId", gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilprofesionalid, false, false);
      AddObjectProperty("SDTProfesionalPerfilNombresApellidos", gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilnombresapellidos, false, false);
      AddObjectProperty("SDTProfesionalPerfilFotografia", gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilfotografia, false, false);
      AddObjectProperty("SDTProfesionalPerfilFotografia_GXI", gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilfotografia_gxi, false, false);
      AddObjectProperty("SDTProfesionalPerfilDescripcion", gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfildescripcion, false, false);
      AddObjectProperty("SDTProfesionalPerfilEspecialidades", gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilespecialidades, false, false);
      AddObjectProperty("SDTProfesionalPerfilCalificacion", gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilcalificacion, false, false);
      AddObjectProperty("SDTProfesionalPerfilDireccion", gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfildireccion, false, false);
      AddObjectProperty("SDTProfesionalPerfilFacebook", gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilfacebook, false, false);
      AddObjectProperty("SDTProfesionalPerfilTwiter", gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfiltwiter, false, false);
      AddObjectProperty("SDTProfesionalPerfilInstagram", gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilinstagram, false, false);
      AddObjectProperty("SDTProfesionalPerfilLinkedin", gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfillinkedin, false, false);
      AddObjectProperty("SDTProfesionalPerfilOtros", gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilotros, false, false);
   }

   public short getgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilprofesionalid( )
   {
      return gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilprofesionalid ;
   }

   public void setgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilprofesionalid( short value )
   {
      gxTv_SdtSDTProfesionalPerfil_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilprofesionalid = value ;
   }

   public String getgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilnombresapellidos( )
   {
      return gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilnombresapellidos ;
   }

   public void setgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilnombresapellidos( String value )
   {
      gxTv_SdtSDTProfesionalPerfil_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilnombresapellidos = value ;
   }

   @GxUpload
   public String getgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilfotografia( )
   {
      return gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilfotografia ;
   }

   public void setgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilfotografia( String value )
   {
      gxTv_SdtSDTProfesionalPerfil_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilfotografia = value ;
   }

   public String getgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilfotografia_gxi( )
   {
      return gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilfotografia_gxi ;
   }

   public void setgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilfotografia_gxi( String value )
   {
      gxTv_SdtSDTProfesionalPerfil_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilfotografia_gxi = value ;
   }

   public String getgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfildescripcion( )
   {
      return gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfildescripcion ;
   }

   public void setgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfildescripcion( String value )
   {
      gxTv_SdtSDTProfesionalPerfil_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfildescripcion = value ;
   }

   public String getgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilespecialidades( )
   {
      return gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilespecialidades ;
   }

   public void setgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilespecialidades( String value )
   {
      gxTv_SdtSDTProfesionalPerfil_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilespecialidades = value ;
   }

   public short getgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilcalificacion( )
   {
      return gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilcalificacion ;
   }

   public void setgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilcalificacion( short value )
   {
      gxTv_SdtSDTProfesionalPerfil_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilcalificacion = value ;
   }

   public String getgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfildireccion( )
   {
      return gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfildireccion ;
   }

   public void setgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfildireccion( String value )
   {
      gxTv_SdtSDTProfesionalPerfil_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfildireccion = value ;
   }

   public String getgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilfacebook( )
   {
      return gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilfacebook ;
   }

   public void setgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilfacebook( String value )
   {
      gxTv_SdtSDTProfesionalPerfil_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilfacebook = value ;
   }

   public String getgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfiltwiter( )
   {
      return gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfiltwiter ;
   }

   public void setgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfiltwiter( String value )
   {
      gxTv_SdtSDTProfesionalPerfil_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfiltwiter = value ;
   }

   public String getgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilinstagram( )
   {
      return gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilinstagram ;
   }

   public void setgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilinstagram( String value )
   {
      gxTv_SdtSDTProfesionalPerfil_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilinstagram = value ;
   }

   public String getgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfillinkedin( )
   {
      return gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfillinkedin ;
   }

   public void setgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfillinkedin( String value )
   {
      gxTv_SdtSDTProfesionalPerfil_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfillinkedin = value ;
   }

   public String getgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilotros( )
   {
      return gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilotros ;
   }

   public void setgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilotros( String value )
   {
      gxTv_SdtSDTProfesionalPerfil_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilotros = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTProfesionalPerfil_N = (byte)(1) ;
      gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilnombresapellidos = "" ;
      gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilfotografia = "" ;
      gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilfotografia_gxi = "" ;
      gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfildescripcion = "" ;
      gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilespecialidades = "" ;
      gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfildireccion = "" ;
      gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilfacebook = "" ;
      gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfiltwiter = "" ;
      gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilinstagram = "" ;
      gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfillinkedin = "" ;
      gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilotros = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTProfesionalPerfil_N ;
   }

   public com.projectthani.SdtSDTProfesionalPerfil Clone( )
   {
      return (com.projectthani.SdtSDTProfesionalPerfil)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTProfesionalPerfil struct )
   {
      setgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilprofesionalid(struct.getSdtprofesionalperfilprofesionalid());
      setgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilnombresapellidos(struct.getSdtprofesionalperfilnombresapellidos());
      setgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilfotografia(struct.getSdtprofesionalperfilfotografia());
      setgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilfotografia_gxi(struct.getSdtprofesionalperfilfotografia_gxi());
      setgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfildescripcion(struct.getSdtprofesionalperfildescripcion());
      setgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilespecialidades(struct.getSdtprofesionalperfilespecialidades());
      setgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilcalificacion(struct.getSdtprofesionalperfilcalificacion());
      setgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfildireccion(struct.getSdtprofesionalperfildireccion());
      setgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilfacebook(struct.getSdtprofesionalperfilfacebook());
      setgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfiltwiter(struct.getSdtprofesionalperfiltwiter());
      setgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilinstagram(struct.getSdtprofesionalperfilinstagram());
      setgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfillinkedin(struct.getSdtprofesionalperfillinkedin());
      setgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilotros(struct.getSdtprofesionalperfilotros());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTProfesionalPerfil getStruct( )
   {
      com.projectthani.StructSdtSDTProfesionalPerfil struct = new com.projectthani.StructSdtSDTProfesionalPerfil ();
      struct.setSdtprofesionalperfilprofesionalid(getgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilprofesionalid());
      struct.setSdtprofesionalperfilnombresapellidos(getgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilnombresapellidos());
      struct.setSdtprofesionalperfilfotografia(getgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilfotografia());
      struct.setSdtprofesionalperfilfotografia_gxi(getgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilfotografia_gxi());
      struct.setSdtprofesionalperfildescripcion(getgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfildescripcion());
      struct.setSdtprofesionalperfilespecialidades(getgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilespecialidades());
      struct.setSdtprofesionalperfilcalificacion(getgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilcalificacion());
      struct.setSdtprofesionalperfildireccion(getgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfildireccion());
      struct.setSdtprofesionalperfilfacebook(getgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilfacebook());
      struct.setSdtprofesionalperfiltwiter(getgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfiltwiter());
      struct.setSdtprofesionalperfilinstagram(getgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilinstagram());
      struct.setSdtprofesionalperfillinkedin(getgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfillinkedin());
      struct.setSdtprofesionalperfilotros(getgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilotros());
      return struct ;
   }

   protected byte gxTv_SdtSDTProfesionalPerfil_N ;
   protected short gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilprofesionalid ;
   protected short gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilcalificacion ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilnombresapellidos ;
   protected String gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilfotografia_gxi ;
   protected String gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfildescripcion ;
   protected String gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilespecialidades ;
   protected String gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfildireccion ;
   protected String gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilfacebook ;
   protected String gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfiltwiter ;
   protected String gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilinstagram ;
   protected String gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfillinkedin ;
   protected String gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilotros ;
   protected String gxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilfotografia ;
}

