package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTInformacionDelPaciente extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTInformacionDelPaciente( )
   {
      this(  new ModelContext(SdtSDTInformacionDelPaciente.class));
   }

   public SdtSDTInformacionDelPaciente( ModelContext context )
   {
      super( context, "SdtSDTInformacionDelPaciente");
   }

   public SdtSDTInformacionDelPaciente( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTInformacionDelPaciente");
   }

   public SdtSDTInformacionDelPaciente( StructSdtSDTInformacionDelPaciente struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTInformacionDelPacienteId") )
            {
               gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTInformacionDelPacienteNombres") )
            {
               gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientenombres = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTInformacionDelPacienteApellidos") )
            {
               gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteapellidos = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTInformacionDelPacienteTipoDocumento") )
            {
               gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientetipodocumento = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTInformacionDelPacienteNroDocumento") )
            {
               gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientenrodocumento = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTInformacionDelPacienteFechaNacimiento") )
            {
               gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientefechanacimiento = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTInformacionDelPacienteSexo") )
            {
               gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientesexo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTInformacionDelPacientePeso") )
            {
               gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientepeso = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTInformacionDelPacienteEstatura") )
            {
               gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteestatura = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTInformacionDelPacienteEmail") )
            {
               gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteemail = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTInformacionDelPacienteMotivoConsulta") )
            {
               gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientemotivoconsulta = oReader.getValue() ;
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
         sName = "SDTInformacionDelPaciente" ;
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
      oWriter.writeElement("SDTInformacionDelPacienteId", GXutil.trim( GXutil.str( gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTInformacionDelPacienteNombres", GXutil.rtrim( gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientenombres));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTInformacionDelPacienteApellidos", GXutil.rtrim( gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteapellidos));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTInformacionDelPacienteTipoDocumento", GXutil.rtrim( gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientetipodocumento));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTInformacionDelPacienteNroDocumento", GXutil.rtrim( gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientenrodocumento));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTInformacionDelPacienteFechaNacimiento", GXutil.rtrim( gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientefechanacimiento));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTInformacionDelPacienteSexo", GXutil.rtrim( gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientesexo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTInformacionDelPacientePeso", GXutil.trim( GXutil.strNoRound( gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientepeso, 6, 2)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTInformacionDelPacienteEstatura", GXutil.trim( GXutil.strNoRound( gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteestatura, 4, 2)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTInformacionDelPacienteEmail", GXutil.rtrim( gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteemail));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTInformacionDelPacienteMotivoConsulta", GXutil.rtrim( gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientemotivoconsulta));
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
      AddObjectProperty("SDTInformacionDelPacienteId", gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteid, false, false);
      AddObjectProperty("SDTInformacionDelPacienteNombres", gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientenombres, false, false);
      AddObjectProperty("SDTInformacionDelPacienteApellidos", gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteapellidos, false, false);
      AddObjectProperty("SDTInformacionDelPacienteTipoDocumento", gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientetipodocumento, false, false);
      AddObjectProperty("SDTInformacionDelPacienteNroDocumento", gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientenrodocumento, false, false);
      AddObjectProperty("SDTInformacionDelPacienteFechaNacimiento", gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientefechanacimiento, false, false);
      AddObjectProperty("SDTInformacionDelPacienteSexo", gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientesexo, false, false);
      AddObjectProperty("SDTInformacionDelPacientePeso", gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientepeso, false, false);
      AddObjectProperty("SDTInformacionDelPacienteEstatura", gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteestatura, false, false);
      AddObjectProperty("SDTInformacionDelPacienteEmail", gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteemail, false, false);
      AddObjectProperty("SDTInformacionDelPacienteMotivoConsulta", gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientemotivoconsulta, false, false);
   }

   public int getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteid( )
   {
      return gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteid ;
   }

   public void setgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteid( int value )
   {
      gxTv_SdtSDTInformacionDelPaciente_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteid = value ;
   }

   public String getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientenombres( )
   {
      return gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientenombres ;
   }

   public void setgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientenombres( String value )
   {
      gxTv_SdtSDTInformacionDelPaciente_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientenombres = value ;
   }

   public String getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteapellidos( )
   {
      return gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteapellidos ;
   }

   public void setgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteapellidos( String value )
   {
      gxTv_SdtSDTInformacionDelPaciente_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteapellidos = value ;
   }

   public String getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientetipodocumento( )
   {
      return gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientetipodocumento ;
   }

   public void setgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientetipodocumento( String value )
   {
      gxTv_SdtSDTInformacionDelPaciente_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientetipodocumento = value ;
   }

   public String getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientenrodocumento( )
   {
      return gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientenrodocumento ;
   }

   public void setgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientenrodocumento( String value )
   {
      gxTv_SdtSDTInformacionDelPaciente_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientenrodocumento = value ;
   }

   public String getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientefechanacimiento( )
   {
      return gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientefechanacimiento ;
   }

   public void setgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientefechanacimiento( String value )
   {
      gxTv_SdtSDTInformacionDelPaciente_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientefechanacimiento = value ;
   }

   public String getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientesexo( )
   {
      return gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientesexo ;
   }

   public void setgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientesexo( String value )
   {
      gxTv_SdtSDTInformacionDelPaciente_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientesexo = value ;
   }

   public java.math.BigDecimal getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientepeso( )
   {
      return gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientepeso ;
   }

   public void setgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientepeso( java.math.BigDecimal value )
   {
      gxTv_SdtSDTInformacionDelPaciente_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientepeso = value ;
   }

   public java.math.BigDecimal getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteestatura( )
   {
      return gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteestatura ;
   }

   public void setgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteestatura( java.math.BigDecimal value )
   {
      gxTv_SdtSDTInformacionDelPaciente_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteestatura = value ;
   }

   public String getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteemail( )
   {
      return gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteemail ;
   }

   public void setgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteemail( String value )
   {
      gxTv_SdtSDTInformacionDelPaciente_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteemail = value ;
   }

   public String getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientemotivoconsulta( )
   {
      return gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientemotivoconsulta ;
   }

   public void setgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientemotivoconsulta( String value )
   {
      gxTv_SdtSDTInformacionDelPaciente_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientemotivoconsulta = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTInformacionDelPaciente_N = (byte)(1) ;
      gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientenombres = "" ;
      gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteapellidos = "" ;
      gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientetipodocumento = "" ;
      gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientenrodocumento = "" ;
      gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientefechanacimiento = "" ;
      gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientesexo = "" ;
      gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientepeso = DecimalUtil.ZERO ;
      gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteestatura = DecimalUtil.ZERO ;
      gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteemail = "" ;
      gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientemotivoconsulta = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTInformacionDelPaciente_N ;
   }

   public com.projectthani.SdtSDTInformacionDelPaciente Clone( )
   {
      return (com.projectthani.SdtSDTInformacionDelPaciente)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTInformacionDelPaciente struct )
   {
      setgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteid(struct.getSdtinformaciondelpacienteid());
      setgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientenombres(struct.getSdtinformaciondelpacientenombres());
      setgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteapellidos(struct.getSdtinformaciondelpacienteapellidos());
      setgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientetipodocumento(struct.getSdtinformaciondelpacientetipodocumento());
      setgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientenrodocumento(struct.getSdtinformaciondelpacientenrodocumento());
      setgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientefechanacimiento(struct.getSdtinformaciondelpacientefechanacimiento());
      setgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientesexo(struct.getSdtinformaciondelpacientesexo());
      setgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientepeso(struct.getSdtinformaciondelpacientepeso());
      setgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteestatura(struct.getSdtinformaciondelpacienteestatura());
      setgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteemail(struct.getSdtinformaciondelpacienteemail());
      setgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientemotivoconsulta(struct.getSdtinformaciondelpacientemotivoconsulta());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTInformacionDelPaciente getStruct( )
   {
      com.projectthani.StructSdtSDTInformacionDelPaciente struct = new com.projectthani.StructSdtSDTInformacionDelPaciente ();
      struct.setSdtinformaciondelpacienteid(getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteid());
      struct.setSdtinformaciondelpacientenombres(getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientenombres());
      struct.setSdtinformaciondelpacienteapellidos(getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteapellidos());
      struct.setSdtinformaciondelpacientetipodocumento(getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientetipodocumento());
      struct.setSdtinformaciondelpacientenrodocumento(getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientenrodocumento());
      struct.setSdtinformaciondelpacientefechanacimiento(getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientefechanacimiento());
      struct.setSdtinformaciondelpacientesexo(getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientesexo());
      struct.setSdtinformaciondelpacientepeso(getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientepeso());
      struct.setSdtinformaciondelpacienteestatura(getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteestatura());
      struct.setSdtinformaciondelpacienteemail(getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteemail());
      struct.setSdtinformaciondelpacientemotivoconsulta(getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientemotivoconsulta());
      return struct ;
   }

   protected byte gxTv_SdtSDTInformacionDelPaciente_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteid ;
   protected java.math.BigDecimal gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientepeso ;
   protected java.math.BigDecimal gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteestatura ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientenombres ;
   protected String gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteapellidos ;
   protected String gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientetipodocumento ;
   protected String gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientenrodocumento ;
   protected String gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientefechanacimiento ;
   protected String gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientesexo ;
   protected String gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteemail ;
   protected String gxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientemotivoconsulta ;
}

