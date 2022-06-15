package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTListadoCitasPorPaciente extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTListadoCitasPorPaciente( )
   {
      this(  new ModelContext(SdtSDTListadoCitasPorPaciente.class));
   }

   public SdtSDTListadoCitasPorPaciente( ModelContext context )
   {
      super( context, "SdtSDTListadoCitasPorPaciente");
   }

   public SdtSDTListadoCitasPorPaciente( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTListadoCitasPorPaciente");
   }

   public SdtSDTListadoCitasPorPaciente( StructSdtSDTListadoCitasPorPaciente struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaId") )
            {
               gxTv_SdtSDTListadoCitasPorPaciente_Citaid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CodCita") )
            {
               gxTv_SdtSDTListadoCitasPorPaciente_Codcita = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteNombresApellidos") )
            {
               gxTv_SdtSDTListadoCitasPorPaciente_Pacientenombresapellidos = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FechaCita") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtSDTListadoCitasPorPaciente_Fechacita = GXutil.nullDate() ;
                  gxTv_SdtSDTListadoCitasPorPaciente_Fechacita_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtSDTListadoCitasPorPaciente_Fechacita_N = (byte)(0) ;
                  gxTv_SdtSDTListadoCitasPorPaciente_Fechacita = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "HoraCita") )
            {
               gxTv_SdtSDTListadoCitasPorPaciente_Horacita = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalId") )
            {
               gxTv_SdtSDTListadoCitasPorPaciente_Profesionalid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DoctorNombresApellidos") )
            {
               gxTv_SdtSDTListadoCitasPorPaciente_Doctornombresapellidos = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Especialidad") )
            {
               gxTv_SdtSDTListadoCitasPorPaciente_Especialidad = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EstadoCita") )
            {
               gxTv_SdtSDTListadoCitasPorPaciente_Estadocita = oReader.getValue() ;
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
         sName = "SDTListadoCitasPorPaciente" ;
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
      oWriter.writeElement("CitaId", GXutil.trim( GXutil.str( gxTv_SdtSDTListadoCitasPorPaciente_Citaid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CodCita", GXutil.rtrim( gxTv_SdtSDTListadoCitasPorPaciente_Codcita));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteNombresApellidos", GXutil.rtrim( gxTv_SdtSDTListadoCitasPorPaciente_Pacientenombresapellidos));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_SdtSDTListadoCitasPorPaciente_Fechacita)) && ( gxTv_SdtSDTListadoCitasPorPaciente_Fechacita_N == 1 ) )
      {
         oWriter.writeElement("FechaCita", "");
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTListadoCitasPorPaciente_Fechacita), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTListadoCitasPorPaciente_Fechacita), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTListadoCitasPorPaciente_Fechacita), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("FechaCita", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      oWriter.writeElement("HoraCita", GXutil.rtrim( gxTv_SdtSDTListadoCitasPorPaciente_Horacita));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalId", GXutil.trim( GXutil.str( gxTv_SdtSDTListadoCitasPorPaciente_Profesionalid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("DoctorNombresApellidos", GXutil.rtrim( gxTv_SdtSDTListadoCitasPorPaciente_Doctornombresapellidos));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Especialidad", GXutil.rtrim( gxTv_SdtSDTListadoCitasPorPaciente_Especialidad));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("EstadoCita", GXutil.rtrim( gxTv_SdtSDTListadoCitasPorPaciente_Estadocita));
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
      AddObjectProperty("CitaId", gxTv_SdtSDTListadoCitasPorPaciente_Citaid, false, false);
      AddObjectProperty("CodCita", gxTv_SdtSDTListadoCitasPorPaciente_Codcita, false, false);
      AddObjectProperty("PacienteNombresApellidos", gxTv_SdtSDTListadoCitasPorPaciente_Pacientenombresapellidos, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTListadoCitasPorPaciente_Fechacita), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTListadoCitasPorPaciente_Fechacita), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTListadoCitasPorPaciente_Fechacita), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("FechaCita", sDateCnv, false, false);
      AddObjectProperty("HoraCita", gxTv_SdtSDTListadoCitasPorPaciente_Horacita, false, false);
      AddObjectProperty("ProfesionalId", gxTv_SdtSDTListadoCitasPorPaciente_Profesionalid, false, false);
      AddObjectProperty("DoctorNombresApellidos", gxTv_SdtSDTListadoCitasPorPaciente_Doctornombresapellidos, false, false);
      AddObjectProperty("Especialidad", gxTv_SdtSDTListadoCitasPorPaciente_Especialidad, false, false);
      AddObjectProperty("EstadoCita", gxTv_SdtSDTListadoCitasPorPaciente_Estadocita, false, false);
   }

   public int getgxTv_SdtSDTListadoCitasPorPaciente_Citaid( )
   {
      return gxTv_SdtSDTListadoCitasPorPaciente_Citaid ;
   }

   public void setgxTv_SdtSDTListadoCitasPorPaciente_Citaid( int value )
   {
      gxTv_SdtSDTListadoCitasPorPaciente_N = (byte)(0) ;
      gxTv_SdtSDTListadoCitasPorPaciente_Citaid = value ;
   }

   public String getgxTv_SdtSDTListadoCitasPorPaciente_Codcita( )
   {
      return gxTv_SdtSDTListadoCitasPorPaciente_Codcita ;
   }

   public void setgxTv_SdtSDTListadoCitasPorPaciente_Codcita( String value )
   {
      gxTv_SdtSDTListadoCitasPorPaciente_N = (byte)(0) ;
      gxTv_SdtSDTListadoCitasPorPaciente_Codcita = value ;
   }

   public String getgxTv_SdtSDTListadoCitasPorPaciente_Pacientenombresapellidos( )
   {
      return gxTv_SdtSDTListadoCitasPorPaciente_Pacientenombresapellidos ;
   }

   public void setgxTv_SdtSDTListadoCitasPorPaciente_Pacientenombresapellidos( String value )
   {
      gxTv_SdtSDTListadoCitasPorPaciente_N = (byte)(0) ;
      gxTv_SdtSDTListadoCitasPorPaciente_Pacientenombresapellidos = value ;
   }

   public java.util.Date getgxTv_SdtSDTListadoCitasPorPaciente_Fechacita( )
   {
      return gxTv_SdtSDTListadoCitasPorPaciente_Fechacita ;
   }

   public void setgxTv_SdtSDTListadoCitasPorPaciente_Fechacita( java.util.Date value )
   {
      gxTv_SdtSDTListadoCitasPorPaciente_Fechacita_N = (byte)(0) ;
      gxTv_SdtSDTListadoCitasPorPaciente_N = (byte)(0) ;
      gxTv_SdtSDTListadoCitasPorPaciente_Fechacita = value ;
   }

   public String getgxTv_SdtSDTListadoCitasPorPaciente_Horacita( )
   {
      return gxTv_SdtSDTListadoCitasPorPaciente_Horacita ;
   }

   public void setgxTv_SdtSDTListadoCitasPorPaciente_Horacita( String value )
   {
      gxTv_SdtSDTListadoCitasPorPaciente_N = (byte)(0) ;
      gxTv_SdtSDTListadoCitasPorPaciente_Horacita = value ;
   }

   public int getgxTv_SdtSDTListadoCitasPorPaciente_Profesionalid( )
   {
      return gxTv_SdtSDTListadoCitasPorPaciente_Profesionalid ;
   }

   public void setgxTv_SdtSDTListadoCitasPorPaciente_Profesionalid( int value )
   {
      gxTv_SdtSDTListadoCitasPorPaciente_N = (byte)(0) ;
      gxTv_SdtSDTListadoCitasPorPaciente_Profesionalid = value ;
   }

   public String getgxTv_SdtSDTListadoCitasPorPaciente_Doctornombresapellidos( )
   {
      return gxTv_SdtSDTListadoCitasPorPaciente_Doctornombresapellidos ;
   }

   public void setgxTv_SdtSDTListadoCitasPorPaciente_Doctornombresapellidos( String value )
   {
      gxTv_SdtSDTListadoCitasPorPaciente_N = (byte)(0) ;
      gxTv_SdtSDTListadoCitasPorPaciente_Doctornombresapellidos = value ;
   }

   public String getgxTv_SdtSDTListadoCitasPorPaciente_Especialidad( )
   {
      return gxTv_SdtSDTListadoCitasPorPaciente_Especialidad ;
   }

   public void setgxTv_SdtSDTListadoCitasPorPaciente_Especialidad( String value )
   {
      gxTv_SdtSDTListadoCitasPorPaciente_N = (byte)(0) ;
      gxTv_SdtSDTListadoCitasPorPaciente_Especialidad = value ;
   }

   public String getgxTv_SdtSDTListadoCitasPorPaciente_Estadocita( )
   {
      return gxTv_SdtSDTListadoCitasPorPaciente_Estadocita ;
   }

   public void setgxTv_SdtSDTListadoCitasPorPaciente_Estadocita( String value )
   {
      gxTv_SdtSDTListadoCitasPorPaciente_N = (byte)(0) ;
      gxTv_SdtSDTListadoCitasPorPaciente_Estadocita = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTListadoCitasPorPaciente_N = (byte)(1) ;
      gxTv_SdtSDTListadoCitasPorPaciente_Codcita = "" ;
      gxTv_SdtSDTListadoCitasPorPaciente_Pacientenombresapellidos = "" ;
      gxTv_SdtSDTListadoCitasPorPaciente_Fechacita = GXutil.nullDate() ;
      gxTv_SdtSDTListadoCitasPorPaciente_Fechacita_N = (byte)(1) ;
      gxTv_SdtSDTListadoCitasPorPaciente_Horacita = "" ;
      gxTv_SdtSDTListadoCitasPorPaciente_Doctornombresapellidos = "" ;
      gxTv_SdtSDTListadoCitasPorPaciente_Especialidad = "" ;
      gxTv_SdtSDTListadoCitasPorPaciente_Estadocita = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTListadoCitasPorPaciente_N ;
   }

   public com.projectthani.SdtSDTListadoCitasPorPaciente Clone( )
   {
      return (com.projectthani.SdtSDTListadoCitasPorPaciente)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTListadoCitasPorPaciente struct )
   {
      setgxTv_SdtSDTListadoCitasPorPaciente_Citaid(struct.getCitaid());
      setgxTv_SdtSDTListadoCitasPorPaciente_Codcita(struct.getCodcita());
      setgxTv_SdtSDTListadoCitasPorPaciente_Pacientenombresapellidos(struct.getPacientenombresapellidos());
      if ( struct.gxTv_SdtSDTListadoCitasPorPaciente_Fechacita_N == 0 )
      {
         setgxTv_SdtSDTListadoCitasPorPaciente_Fechacita(struct.getFechacita());
      }
      setgxTv_SdtSDTListadoCitasPorPaciente_Horacita(struct.getHoracita());
      setgxTv_SdtSDTListadoCitasPorPaciente_Profesionalid(struct.getProfesionalid());
      setgxTv_SdtSDTListadoCitasPorPaciente_Doctornombresapellidos(struct.getDoctornombresapellidos());
      setgxTv_SdtSDTListadoCitasPorPaciente_Especialidad(struct.getEspecialidad());
      setgxTv_SdtSDTListadoCitasPorPaciente_Estadocita(struct.getEstadocita());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTListadoCitasPorPaciente getStruct( )
   {
      com.projectthani.StructSdtSDTListadoCitasPorPaciente struct = new com.projectthani.StructSdtSDTListadoCitasPorPaciente ();
      struct.setCitaid(getgxTv_SdtSDTListadoCitasPorPaciente_Citaid());
      struct.setCodcita(getgxTv_SdtSDTListadoCitasPorPaciente_Codcita());
      struct.setPacientenombresapellidos(getgxTv_SdtSDTListadoCitasPorPaciente_Pacientenombresapellidos());
      if ( gxTv_SdtSDTListadoCitasPorPaciente_Fechacita_N == 0 )
      {
         struct.setFechacita(getgxTv_SdtSDTListadoCitasPorPaciente_Fechacita());
      }
      struct.setHoracita(getgxTv_SdtSDTListadoCitasPorPaciente_Horacita());
      struct.setProfesionalid(getgxTv_SdtSDTListadoCitasPorPaciente_Profesionalid());
      struct.setDoctornombresapellidos(getgxTv_SdtSDTListadoCitasPorPaciente_Doctornombresapellidos());
      struct.setEspecialidad(getgxTv_SdtSDTListadoCitasPorPaciente_Especialidad());
      struct.setEstadocita(getgxTv_SdtSDTListadoCitasPorPaciente_Estadocita());
      return struct ;
   }

   protected byte gxTv_SdtSDTListadoCitasPorPaciente_N ;
   protected byte gxTv_SdtSDTListadoCitasPorPaciente_Fechacita_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_SdtSDTListadoCitasPorPaciente_Citaid ;
   protected int gxTv_SdtSDTListadoCitasPorPaciente_Profesionalid ;
   protected String gxTv_SdtSDTListadoCitasPorPaciente_Codcita ;
   protected String gxTv_SdtSDTListadoCitasPorPaciente_Estadocita ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_SdtSDTListadoCitasPorPaciente_Fechacita ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTListadoCitasPorPaciente_Pacientenombresapellidos ;
   protected String gxTv_SdtSDTListadoCitasPorPaciente_Horacita ;
   protected String gxTv_SdtSDTListadoCitasPorPaciente_Doctornombresapellidos ;
   protected String gxTv_SdtSDTListadoCitasPorPaciente_Especialidad ;
}

