package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTListadoFamiliarPorPaciente extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTListadoFamiliarPorPaciente( )
   {
      this(  new ModelContext(SdtSDTListadoFamiliarPorPaciente.class));
   }

   public SdtSDTListadoFamiliarPorPaciente( ModelContext context )
   {
      super( context, "SdtSDTListadoFamiliarPorPaciente");
   }

   public SdtSDTListadoFamiliarPorPaciente( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTListadoFamiliarPorPaciente");
   }

   public SdtSDTListadoFamiliarPorPaciente( StructSdtSDTListadoFamiliarPorPaciente struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Nombres") )
            {
               gxTv_SdtSDTListadoFamiliarPorPaciente_Nombres = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Apellidos") )
            {
               gxTv_SdtSDTListadoFamiliarPorPaciente_Apellidos = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "NroDocumento") )
            {
               gxTv_SdtSDTListadoFamiliarPorPaciente_Nrodocumento = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FechaNacimento") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtSDTListadoFamiliarPorPaciente_Fechanacimento = GXutil.nullDate() ;
                  gxTv_SdtSDTListadoFamiliarPorPaciente_Fechanacimento_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtSDTListadoFamiliarPorPaciente_Fechanacimento_N = (byte)(0) ;
                  gxTv_SdtSDTListadoFamiliarPorPaciente_Fechanacimento = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Parentesco") )
            {
               gxTv_SdtSDTListadoFamiliarPorPaciente_Parentesco = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Sexo") )
            {
               gxTv_SdtSDTListadoFamiliarPorPaciente_Sexo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Nacionalidad") )
            {
               gxTv_SdtSDTListadoFamiliarPorPaciente_Nacionalidad = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Peso") )
            {
               gxTv_SdtSDTListadoFamiliarPorPaciente_Peso = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Estatura") )
            {
               gxTv_SdtSDTListadoFamiliarPorPaciente_Estatura = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteFamiliarId") )
            {
               gxTv_SdtSDTListadoFamiliarPorPaciente_Pacientefamiliarid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGPacienteHijoPacienteId") )
            {
               gxTv_SdtSDTListadoFamiliarPorPaciente_Sgpacientehijopacienteid = (int)(getnumericvalue(oReader.getValue())) ;
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
         sName = "SDTListadoFamiliarPorPaciente" ;
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
      oWriter.writeElement("Nombres", GXutil.rtrim( gxTv_SdtSDTListadoFamiliarPorPaciente_Nombres));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Apellidos", GXutil.rtrim( gxTv_SdtSDTListadoFamiliarPorPaciente_Apellidos));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("NroDocumento", GXutil.rtrim( gxTv_SdtSDTListadoFamiliarPorPaciente_Nrodocumento));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_SdtSDTListadoFamiliarPorPaciente_Fechanacimento)) && ( gxTv_SdtSDTListadoFamiliarPorPaciente_Fechanacimento_N == 1 ) )
      {
         oWriter.writeElement("FechaNacimento", "");
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTListadoFamiliarPorPaciente_Fechanacimento), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTListadoFamiliarPorPaciente_Fechanacimento), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTListadoFamiliarPorPaciente_Fechanacimento), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("FechaNacimento", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      oWriter.writeElement("Parentesco", GXutil.rtrim( gxTv_SdtSDTListadoFamiliarPorPaciente_Parentesco));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Sexo", GXutil.rtrim( gxTv_SdtSDTListadoFamiliarPorPaciente_Sexo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Nacionalidad", GXutil.rtrim( gxTv_SdtSDTListadoFamiliarPorPaciente_Nacionalidad));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Peso", GXutil.trim( GXutil.strNoRound( gxTv_SdtSDTListadoFamiliarPorPaciente_Peso, 6, 2)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Estatura", GXutil.trim( GXutil.strNoRound( gxTv_SdtSDTListadoFamiliarPorPaciente_Estatura, 4, 2)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteFamiliarId", GXutil.trim( GXutil.str( gxTv_SdtSDTListadoFamiliarPorPaciente_Pacientefamiliarid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGPacienteHijoPacienteId", GXutil.trim( GXutil.str( gxTv_SdtSDTListadoFamiliarPorPaciente_Sgpacientehijopacienteid, 8, 0)));
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
      AddObjectProperty("Nombres", gxTv_SdtSDTListadoFamiliarPorPaciente_Nombres, false, false);
      AddObjectProperty("Apellidos", gxTv_SdtSDTListadoFamiliarPorPaciente_Apellidos, false, false);
      AddObjectProperty("NroDocumento", gxTv_SdtSDTListadoFamiliarPorPaciente_Nrodocumento, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTListadoFamiliarPorPaciente_Fechanacimento), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTListadoFamiliarPorPaciente_Fechanacimento), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTListadoFamiliarPorPaciente_Fechanacimento), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("FechaNacimento", sDateCnv, false, false);
      AddObjectProperty("Parentesco", gxTv_SdtSDTListadoFamiliarPorPaciente_Parentesco, false, false);
      AddObjectProperty("Sexo", gxTv_SdtSDTListadoFamiliarPorPaciente_Sexo, false, false);
      AddObjectProperty("Nacionalidad", gxTv_SdtSDTListadoFamiliarPorPaciente_Nacionalidad, false, false);
      AddObjectProperty("Peso", gxTv_SdtSDTListadoFamiliarPorPaciente_Peso, false, false);
      AddObjectProperty("Estatura", gxTv_SdtSDTListadoFamiliarPorPaciente_Estatura, false, false);
      AddObjectProperty("PacienteFamiliarId", gxTv_SdtSDTListadoFamiliarPorPaciente_Pacientefamiliarid, false, false);
      AddObjectProperty("SGPacienteHijoPacienteId", gxTv_SdtSDTListadoFamiliarPorPaciente_Sgpacientehijopacienteid, false, false);
   }

   public String getgxTv_SdtSDTListadoFamiliarPorPaciente_Nombres( )
   {
      return gxTv_SdtSDTListadoFamiliarPorPaciente_Nombres ;
   }

   public void setgxTv_SdtSDTListadoFamiliarPorPaciente_Nombres( String value )
   {
      gxTv_SdtSDTListadoFamiliarPorPaciente_N = (byte)(0) ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_Nombres = value ;
   }

   public String getgxTv_SdtSDTListadoFamiliarPorPaciente_Apellidos( )
   {
      return gxTv_SdtSDTListadoFamiliarPorPaciente_Apellidos ;
   }

   public void setgxTv_SdtSDTListadoFamiliarPorPaciente_Apellidos( String value )
   {
      gxTv_SdtSDTListadoFamiliarPorPaciente_N = (byte)(0) ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_Apellidos = value ;
   }

   public String getgxTv_SdtSDTListadoFamiliarPorPaciente_Nrodocumento( )
   {
      return gxTv_SdtSDTListadoFamiliarPorPaciente_Nrodocumento ;
   }

   public void setgxTv_SdtSDTListadoFamiliarPorPaciente_Nrodocumento( String value )
   {
      gxTv_SdtSDTListadoFamiliarPorPaciente_N = (byte)(0) ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_Nrodocumento = value ;
   }

   public java.util.Date getgxTv_SdtSDTListadoFamiliarPorPaciente_Fechanacimento( )
   {
      return gxTv_SdtSDTListadoFamiliarPorPaciente_Fechanacimento ;
   }

   public void setgxTv_SdtSDTListadoFamiliarPorPaciente_Fechanacimento( java.util.Date value )
   {
      gxTv_SdtSDTListadoFamiliarPorPaciente_Fechanacimento_N = (byte)(0) ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_N = (byte)(0) ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_Fechanacimento = value ;
   }

   public String getgxTv_SdtSDTListadoFamiliarPorPaciente_Parentesco( )
   {
      return gxTv_SdtSDTListadoFamiliarPorPaciente_Parentesco ;
   }

   public void setgxTv_SdtSDTListadoFamiliarPorPaciente_Parentesco( String value )
   {
      gxTv_SdtSDTListadoFamiliarPorPaciente_N = (byte)(0) ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_Parentesco = value ;
   }

   public String getgxTv_SdtSDTListadoFamiliarPorPaciente_Sexo( )
   {
      return gxTv_SdtSDTListadoFamiliarPorPaciente_Sexo ;
   }

   public void setgxTv_SdtSDTListadoFamiliarPorPaciente_Sexo( String value )
   {
      gxTv_SdtSDTListadoFamiliarPorPaciente_N = (byte)(0) ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_Sexo = value ;
   }

   public String getgxTv_SdtSDTListadoFamiliarPorPaciente_Nacionalidad( )
   {
      return gxTv_SdtSDTListadoFamiliarPorPaciente_Nacionalidad ;
   }

   public void setgxTv_SdtSDTListadoFamiliarPorPaciente_Nacionalidad( String value )
   {
      gxTv_SdtSDTListadoFamiliarPorPaciente_N = (byte)(0) ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_Nacionalidad = value ;
   }

   public java.math.BigDecimal getgxTv_SdtSDTListadoFamiliarPorPaciente_Peso( )
   {
      return gxTv_SdtSDTListadoFamiliarPorPaciente_Peso ;
   }

   public void setgxTv_SdtSDTListadoFamiliarPorPaciente_Peso( java.math.BigDecimal value )
   {
      gxTv_SdtSDTListadoFamiliarPorPaciente_N = (byte)(0) ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_Peso = value ;
   }

   public java.math.BigDecimal getgxTv_SdtSDTListadoFamiliarPorPaciente_Estatura( )
   {
      return gxTv_SdtSDTListadoFamiliarPorPaciente_Estatura ;
   }

   public void setgxTv_SdtSDTListadoFamiliarPorPaciente_Estatura( java.math.BigDecimal value )
   {
      gxTv_SdtSDTListadoFamiliarPorPaciente_N = (byte)(0) ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_Estatura = value ;
   }

   public int getgxTv_SdtSDTListadoFamiliarPorPaciente_Pacientefamiliarid( )
   {
      return gxTv_SdtSDTListadoFamiliarPorPaciente_Pacientefamiliarid ;
   }

   public void setgxTv_SdtSDTListadoFamiliarPorPaciente_Pacientefamiliarid( int value )
   {
      gxTv_SdtSDTListadoFamiliarPorPaciente_N = (byte)(0) ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_Pacientefamiliarid = value ;
   }

   public int getgxTv_SdtSDTListadoFamiliarPorPaciente_Sgpacientehijopacienteid( )
   {
      return gxTv_SdtSDTListadoFamiliarPorPaciente_Sgpacientehijopacienteid ;
   }

   public void setgxTv_SdtSDTListadoFamiliarPorPaciente_Sgpacientehijopacienteid( int value )
   {
      gxTv_SdtSDTListadoFamiliarPorPaciente_N = (byte)(0) ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_Sgpacientehijopacienteid = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTListadoFamiliarPorPaciente_Nombres = "" ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_N = (byte)(1) ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_Apellidos = "" ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_Nrodocumento = "" ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_Fechanacimento = GXutil.nullDate() ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_Fechanacimento_N = (byte)(1) ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_Parentesco = "" ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_Sexo = "" ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_Nacionalidad = "" ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_Peso = DecimalUtil.ZERO ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_Estatura = DecimalUtil.ZERO ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTListadoFamiliarPorPaciente_N ;
   }

   public com.projectthani.SdtSDTListadoFamiliarPorPaciente Clone( )
   {
      return (com.projectthani.SdtSDTListadoFamiliarPorPaciente)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTListadoFamiliarPorPaciente struct )
   {
      setgxTv_SdtSDTListadoFamiliarPorPaciente_Nombres(struct.getNombres());
      setgxTv_SdtSDTListadoFamiliarPorPaciente_Apellidos(struct.getApellidos());
      setgxTv_SdtSDTListadoFamiliarPorPaciente_Nrodocumento(struct.getNrodocumento());
      if ( struct.gxTv_SdtSDTListadoFamiliarPorPaciente_Fechanacimento_N == 0 )
      {
         setgxTv_SdtSDTListadoFamiliarPorPaciente_Fechanacimento(struct.getFechanacimento());
      }
      setgxTv_SdtSDTListadoFamiliarPorPaciente_Parentesco(struct.getParentesco());
      setgxTv_SdtSDTListadoFamiliarPorPaciente_Sexo(struct.getSexo());
      setgxTv_SdtSDTListadoFamiliarPorPaciente_Nacionalidad(struct.getNacionalidad());
      setgxTv_SdtSDTListadoFamiliarPorPaciente_Peso(struct.getPeso());
      setgxTv_SdtSDTListadoFamiliarPorPaciente_Estatura(struct.getEstatura());
      setgxTv_SdtSDTListadoFamiliarPorPaciente_Pacientefamiliarid(struct.getPacientefamiliarid());
      setgxTv_SdtSDTListadoFamiliarPorPaciente_Sgpacientehijopacienteid(struct.getSgpacientehijopacienteid());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTListadoFamiliarPorPaciente getStruct( )
   {
      com.projectthani.StructSdtSDTListadoFamiliarPorPaciente struct = new com.projectthani.StructSdtSDTListadoFamiliarPorPaciente ();
      struct.setNombres(getgxTv_SdtSDTListadoFamiliarPorPaciente_Nombres());
      struct.setApellidos(getgxTv_SdtSDTListadoFamiliarPorPaciente_Apellidos());
      struct.setNrodocumento(getgxTv_SdtSDTListadoFamiliarPorPaciente_Nrodocumento());
      if ( gxTv_SdtSDTListadoFamiliarPorPaciente_Fechanacimento_N == 0 )
      {
         struct.setFechanacimento(getgxTv_SdtSDTListadoFamiliarPorPaciente_Fechanacimento());
      }
      struct.setParentesco(getgxTv_SdtSDTListadoFamiliarPorPaciente_Parentesco());
      struct.setSexo(getgxTv_SdtSDTListadoFamiliarPorPaciente_Sexo());
      struct.setNacionalidad(getgxTv_SdtSDTListadoFamiliarPorPaciente_Nacionalidad());
      struct.setPeso(getgxTv_SdtSDTListadoFamiliarPorPaciente_Peso());
      struct.setEstatura(getgxTv_SdtSDTListadoFamiliarPorPaciente_Estatura());
      struct.setPacientefamiliarid(getgxTv_SdtSDTListadoFamiliarPorPaciente_Pacientefamiliarid());
      struct.setSgpacientehijopacienteid(getgxTv_SdtSDTListadoFamiliarPorPaciente_Sgpacientehijopacienteid());
      return struct ;
   }

   protected byte gxTv_SdtSDTListadoFamiliarPorPaciente_N ;
   protected byte gxTv_SdtSDTListadoFamiliarPorPaciente_Fechanacimento_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_SdtSDTListadoFamiliarPorPaciente_Pacientefamiliarid ;
   protected int gxTv_SdtSDTListadoFamiliarPorPaciente_Sgpacientehijopacienteid ;
   protected java.math.BigDecimal gxTv_SdtSDTListadoFamiliarPorPaciente_Peso ;
   protected java.math.BigDecimal gxTv_SdtSDTListadoFamiliarPorPaciente_Estatura ;
   protected String gxTv_SdtSDTListadoFamiliarPorPaciente_Nrodocumento ;
   protected String gxTv_SdtSDTListadoFamiliarPorPaciente_Sexo ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_SdtSDTListadoFamiliarPorPaciente_Fechanacimento ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTListadoFamiliarPorPaciente_Nombres ;
   protected String gxTv_SdtSDTListadoFamiliarPorPaciente_Apellidos ;
   protected String gxTv_SdtSDTListadoFamiliarPorPaciente_Parentesco ;
   protected String gxTv_SdtSDTListadoFamiliarPorPaciente_Nacionalidad ;
}

