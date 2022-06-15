package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTInformacionDelPacienteFamiliar extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTInformacionDelPacienteFamiliar( )
   {
      this(  new ModelContext(SdtSDTInformacionDelPacienteFamiliar.class));
   }

   public SdtSDTInformacionDelPacienteFamiliar( ModelContext context )
   {
      super( context, "SdtSDTInformacionDelPacienteFamiliar");
   }

   public SdtSDTInformacionDelPacienteFamiliar( int remoteHandle ,
                                                ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTInformacionDelPacienteFamiliar");
   }

   public SdtSDTInformacionDelPacienteFamiliar( StructSdtSDTInformacionDelPacienteFamiliar struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Id") )
            {
               gxTv_SdtSDTInformacionDelPacienteFamiliar_Id = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Nombres") )
            {
               gxTv_SdtSDTInformacionDelPacienteFamiliar_Nombres = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ApellidoPaterno") )
            {
               gxTv_SdtSDTInformacionDelPacienteFamiliar_Apellidopaterno = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ApellidoMaterno") )
            {
               gxTv_SdtSDTInformacionDelPacienteFamiliar_Apellidomaterno = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TipoDocumento") )
            {
               gxTv_SdtSDTInformacionDelPacienteFamiliar_Tipodocumento = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "NroDocumento") )
            {
               gxTv_SdtSDTInformacionDelPacienteFamiliar_Nrodocumento = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FechaNacimiento") )
            {
               gxTv_SdtSDTInformacionDelPacienteFamiliar_Fechanacimiento = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Sexo") )
            {
               gxTv_SdtSDTInformacionDelPacienteFamiliar_Sexo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Peso") )
            {
               gxTv_SdtSDTInformacionDelPacienteFamiliar_Peso = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Estatura") )
            {
               gxTv_SdtSDTInformacionDelPacienteFamiliar_Estatura = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Email") )
            {
               gxTv_SdtSDTInformacionDelPacienteFamiliar_Email = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MotivoConsulta") )
            {
               gxTv_SdtSDTInformacionDelPacienteFamiliar_Motivoconsulta = oReader.getValue() ;
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
         sName = "SDTInformacionDelPacienteFamiliar" ;
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
      oWriter.writeElement("Id", GXutil.trim( GXutil.str( gxTv_SdtSDTInformacionDelPacienteFamiliar_Id, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Nombres", GXutil.rtrim( gxTv_SdtSDTInformacionDelPacienteFamiliar_Nombres));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ApellidoPaterno", GXutil.rtrim( gxTv_SdtSDTInformacionDelPacienteFamiliar_Apellidopaterno));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ApellidoMaterno", GXutil.rtrim( gxTv_SdtSDTInformacionDelPacienteFamiliar_Apellidomaterno));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("TipoDocumento", GXutil.rtrim( gxTv_SdtSDTInformacionDelPacienteFamiliar_Tipodocumento));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("NroDocumento", GXutil.rtrim( gxTv_SdtSDTInformacionDelPacienteFamiliar_Nrodocumento));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("FechaNacimiento", GXutil.rtrim( gxTv_SdtSDTInformacionDelPacienteFamiliar_Fechanacimiento));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Sexo", GXutil.rtrim( gxTv_SdtSDTInformacionDelPacienteFamiliar_Sexo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Peso", GXutil.trim( GXutil.strNoRound( gxTv_SdtSDTInformacionDelPacienteFamiliar_Peso, 6, 2)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Estatura", GXutil.trim( GXutil.strNoRound( gxTv_SdtSDTInformacionDelPacienteFamiliar_Estatura, 4, 2)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Email", GXutil.rtrim( gxTv_SdtSDTInformacionDelPacienteFamiliar_Email));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("MotivoConsulta", GXutil.rtrim( gxTv_SdtSDTInformacionDelPacienteFamiliar_Motivoconsulta));
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
      AddObjectProperty("Id", gxTv_SdtSDTInformacionDelPacienteFamiliar_Id, false, false);
      AddObjectProperty("Nombres", gxTv_SdtSDTInformacionDelPacienteFamiliar_Nombres, false, false);
      AddObjectProperty("ApellidoPaterno", gxTv_SdtSDTInformacionDelPacienteFamiliar_Apellidopaterno, false, false);
      AddObjectProperty("ApellidoMaterno", gxTv_SdtSDTInformacionDelPacienteFamiliar_Apellidomaterno, false, false);
      AddObjectProperty("TipoDocumento", gxTv_SdtSDTInformacionDelPacienteFamiliar_Tipodocumento, false, false);
      AddObjectProperty("NroDocumento", gxTv_SdtSDTInformacionDelPacienteFamiliar_Nrodocumento, false, false);
      AddObjectProperty("FechaNacimiento", gxTv_SdtSDTInformacionDelPacienteFamiliar_Fechanacimiento, false, false);
      AddObjectProperty("Sexo", gxTv_SdtSDTInformacionDelPacienteFamiliar_Sexo, false, false);
      AddObjectProperty("Peso", gxTv_SdtSDTInformacionDelPacienteFamiliar_Peso, false, false);
      AddObjectProperty("Estatura", gxTv_SdtSDTInformacionDelPacienteFamiliar_Estatura, false, false);
      AddObjectProperty("Email", gxTv_SdtSDTInformacionDelPacienteFamiliar_Email, false, false);
      AddObjectProperty("MotivoConsulta", gxTv_SdtSDTInformacionDelPacienteFamiliar_Motivoconsulta, false, false);
   }

   public int getgxTv_SdtSDTInformacionDelPacienteFamiliar_Id( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFamiliar_Id ;
   }

   public void setgxTv_SdtSDTInformacionDelPacienteFamiliar_Id( int value )
   {
      gxTv_SdtSDTInformacionDelPacienteFamiliar_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Id = value ;
   }

   public String getgxTv_SdtSDTInformacionDelPacienteFamiliar_Nombres( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFamiliar_Nombres ;
   }

   public void setgxTv_SdtSDTInformacionDelPacienteFamiliar_Nombres( String value )
   {
      gxTv_SdtSDTInformacionDelPacienteFamiliar_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Nombres = value ;
   }

   public String getgxTv_SdtSDTInformacionDelPacienteFamiliar_Apellidopaterno( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFamiliar_Apellidopaterno ;
   }

   public void setgxTv_SdtSDTInformacionDelPacienteFamiliar_Apellidopaterno( String value )
   {
      gxTv_SdtSDTInformacionDelPacienteFamiliar_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Apellidopaterno = value ;
   }

   public String getgxTv_SdtSDTInformacionDelPacienteFamiliar_Apellidomaterno( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFamiliar_Apellidomaterno ;
   }

   public void setgxTv_SdtSDTInformacionDelPacienteFamiliar_Apellidomaterno( String value )
   {
      gxTv_SdtSDTInformacionDelPacienteFamiliar_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Apellidomaterno = value ;
   }

   public String getgxTv_SdtSDTInformacionDelPacienteFamiliar_Tipodocumento( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFamiliar_Tipodocumento ;
   }

   public void setgxTv_SdtSDTInformacionDelPacienteFamiliar_Tipodocumento( String value )
   {
      gxTv_SdtSDTInformacionDelPacienteFamiliar_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Tipodocumento = value ;
   }

   public String getgxTv_SdtSDTInformacionDelPacienteFamiliar_Nrodocumento( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFamiliar_Nrodocumento ;
   }

   public void setgxTv_SdtSDTInformacionDelPacienteFamiliar_Nrodocumento( String value )
   {
      gxTv_SdtSDTInformacionDelPacienteFamiliar_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Nrodocumento = value ;
   }

   public String getgxTv_SdtSDTInformacionDelPacienteFamiliar_Fechanacimiento( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFamiliar_Fechanacimiento ;
   }

   public void setgxTv_SdtSDTInformacionDelPacienteFamiliar_Fechanacimiento( String value )
   {
      gxTv_SdtSDTInformacionDelPacienteFamiliar_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Fechanacimiento = value ;
   }

   public String getgxTv_SdtSDTInformacionDelPacienteFamiliar_Sexo( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFamiliar_Sexo ;
   }

   public void setgxTv_SdtSDTInformacionDelPacienteFamiliar_Sexo( String value )
   {
      gxTv_SdtSDTInformacionDelPacienteFamiliar_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Sexo = value ;
   }

   public java.math.BigDecimal getgxTv_SdtSDTInformacionDelPacienteFamiliar_Peso( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFamiliar_Peso ;
   }

   public void setgxTv_SdtSDTInformacionDelPacienteFamiliar_Peso( java.math.BigDecimal value )
   {
      gxTv_SdtSDTInformacionDelPacienteFamiliar_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Peso = value ;
   }

   public java.math.BigDecimal getgxTv_SdtSDTInformacionDelPacienteFamiliar_Estatura( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFamiliar_Estatura ;
   }

   public void setgxTv_SdtSDTInformacionDelPacienteFamiliar_Estatura( java.math.BigDecimal value )
   {
      gxTv_SdtSDTInformacionDelPacienteFamiliar_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Estatura = value ;
   }

   public String getgxTv_SdtSDTInformacionDelPacienteFamiliar_Email( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFamiliar_Email ;
   }

   public void setgxTv_SdtSDTInformacionDelPacienteFamiliar_Email( String value )
   {
      gxTv_SdtSDTInformacionDelPacienteFamiliar_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Email = value ;
   }

   public String getgxTv_SdtSDTInformacionDelPacienteFamiliar_Motivoconsulta( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFamiliar_Motivoconsulta ;
   }

   public void setgxTv_SdtSDTInformacionDelPacienteFamiliar_Motivoconsulta( String value )
   {
      gxTv_SdtSDTInformacionDelPacienteFamiliar_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Motivoconsulta = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTInformacionDelPacienteFamiliar_N = (byte)(1) ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Nombres = "" ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Apellidopaterno = "" ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Apellidomaterno = "" ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Tipodocumento = "" ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Nrodocumento = "" ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Fechanacimiento = "" ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Sexo = "" ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Peso = DecimalUtil.ZERO ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Estatura = DecimalUtil.ZERO ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Email = "" ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Motivoconsulta = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFamiliar_N ;
   }

   public com.projectthani.SdtSDTInformacionDelPacienteFamiliar Clone( )
   {
      return (com.projectthani.SdtSDTInformacionDelPacienteFamiliar)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTInformacionDelPacienteFamiliar struct )
   {
      setgxTv_SdtSDTInformacionDelPacienteFamiliar_Id(struct.getId());
      setgxTv_SdtSDTInformacionDelPacienteFamiliar_Nombres(struct.getNombres());
      setgxTv_SdtSDTInformacionDelPacienteFamiliar_Apellidopaterno(struct.getApellidopaterno());
      setgxTv_SdtSDTInformacionDelPacienteFamiliar_Apellidomaterno(struct.getApellidomaterno());
      setgxTv_SdtSDTInformacionDelPacienteFamiliar_Tipodocumento(struct.getTipodocumento());
      setgxTv_SdtSDTInformacionDelPacienteFamiliar_Nrodocumento(struct.getNrodocumento());
      setgxTv_SdtSDTInformacionDelPacienteFamiliar_Fechanacimiento(struct.getFechanacimiento());
      setgxTv_SdtSDTInformacionDelPacienteFamiliar_Sexo(struct.getSexo());
      setgxTv_SdtSDTInformacionDelPacienteFamiliar_Peso(struct.getPeso());
      setgxTv_SdtSDTInformacionDelPacienteFamiliar_Estatura(struct.getEstatura());
      setgxTv_SdtSDTInformacionDelPacienteFamiliar_Email(struct.getEmail());
      setgxTv_SdtSDTInformacionDelPacienteFamiliar_Motivoconsulta(struct.getMotivoconsulta());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTInformacionDelPacienteFamiliar getStruct( )
   {
      com.projectthani.StructSdtSDTInformacionDelPacienteFamiliar struct = new com.projectthani.StructSdtSDTInformacionDelPacienteFamiliar ();
      struct.setId(getgxTv_SdtSDTInformacionDelPacienteFamiliar_Id());
      struct.setNombres(getgxTv_SdtSDTInformacionDelPacienteFamiliar_Nombres());
      struct.setApellidopaterno(getgxTv_SdtSDTInformacionDelPacienteFamiliar_Apellidopaterno());
      struct.setApellidomaterno(getgxTv_SdtSDTInformacionDelPacienteFamiliar_Apellidomaterno());
      struct.setTipodocumento(getgxTv_SdtSDTInformacionDelPacienteFamiliar_Tipodocumento());
      struct.setNrodocumento(getgxTv_SdtSDTInformacionDelPacienteFamiliar_Nrodocumento());
      struct.setFechanacimiento(getgxTv_SdtSDTInformacionDelPacienteFamiliar_Fechanacimiento());
      struct.setSexo(getgxTv_SdtSDTInformacionDelPacienteFamiliar_Sexo());
      struct.setPeso(getgxTv_SdtSDTInformacionDelPacienteFamiliar_Peso());
      struct.setEstatura(getgxTv_SdtSDTInformacionDelPacienteFamiliar_Estatura());
      struct.setEmail(getgxTv_SdtSDTInformacionDelPacienteFamiliar_Email());
      struct.setMotivoconsulta(getgxTv_SdtSDTInformacionDelPacienteFamiliar_Motivoconsulta());
      return struct ;
   }

   protected byte gxTv_SdtSDTInformacionDelPacienteFamiliar_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_SdtSDTInformacionDelPacienteFamiliar_Id ;
   protected java.math.BigDecimal gxTv_SdtSDTInformacionDelPacienteFamiliar_Peso ;
   protected java.math.BigDecimal gxTv_SdtSDTInformacionDelPacienteFamiliar_Estatura ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTInformacionDelPacienteFamiliar_Nombres ;
   protected String gxTv_SdtSDTInformacionDelPacienteFamiliar_Apellidopaterno ;
   protected String gxTv_SdtSDTInformacionDelPacienteFamiliar_Apellidomaterno ;
   protected String gxTv_SdtSDTInformacionDelPacienteFamiliar_Tipodocumento ;
   protected String gxTv_SdtSDTInformacionDelPacienteFamiliar_Nrodocumento ;
   protected String gxTv_SdtSDTInformacionDelPacienteFamiliar_Fechanacimiento ;
   protected String gxTv_SdtSDTInformacionDelPacienteFamiliar_Sexo ;
   protected String gxTv_SdtSDTInformacionDelPacienteFamiliar_Email ;
   protected String gxTv_SdtSDTInformacionDelPacienteFamiliar_Motivoconsulta ;
}

