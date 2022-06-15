package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTProfesionalEspecialidadSede extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTProfesionalEspecialidadSede( )
   {
      this(  new ModelContext(SdtSDTProfesionalEspecialidadSede.class));
   }

   public SdtSDTProfesionalEspecialidadSede( ModelContext context )
   {
      super( context, "SdtSDTProfesionalEspecialidadSede");
   }

   public SdtSDTProfesionalEspecialidadSede( int remoteHandle ,
                                             ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTProfesionalEspecialidadSede");
   }

   public SdtSDTProfesionalEspecialidadSede( StructSdtSDTProfesionalEspecialidadSede struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "EspecialidadId") )
            {
               gxTv_SdtSDTProfesionalEspecialidadSede_Especialidadid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EspecialidadCodigo") )
            {
               gxTv_SdtSDTProfesionalEspecialidadSede_Especialidadcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EspecialidadNombre") )
            {
               gxTv_SdtSDTProfesionalEspecialidadSede_Especialidadnombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SedeId") )
            {
               gxTv_SdtSDTProfesionalEspecialidadSede_Sedeid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SedeTipoConsulta") )
            {
               gxTv_SdtSDTProfesionalEspecialidadSede_Sedetipoconsulta = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CostoConsulta") )
            {
               gxTv_SdtSDTProfesionalEspecialidadSede_Costoconsulta = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SedeNombre") )
            {
               gxTv_SdtSDTProfesionalEspecialidadSede_Sedenombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClinicaNombreAbreviado") )
            {
               gxTv_SdtSDTProfesionalEspecialidadSede_Clinicanombreabreviado = oReader.getValue() ;
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
         sName = "SDTProfesionalEspecialidadSede" ;
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
      oWriter.writeElement("EspecialidadId", GXutil.trim( GXutil.str( gxTv_SdtSDTProfesionalEspecialidadSede_Especialidadid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("EspecialidadCodigo", GXutil.rtrim( gxTv_SdtSDTProfesionalEspecialidadSede_Especialidadcodigo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("EspecialidadNombre", GXutil.rtrim( gxTv_SdtSDTProfesionalEspecialidadSede_Especialidadnombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SedeId", GXutil.trim( GXutil.str( gxTv_SdtSDTProfesionalEspecialidadSede_Sedeid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SedeTipoConsulta", GXutil.rtrim( gxTv_SdtSDTProfesionalEspecialidadSede_Sedetipoconsulta));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CostoConsulta", GXutil.trim( GXutil.strNoRound( gxTv_SdtSDTProfesionalEspecialidadSede_Costoconsulta, 6, 2)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SedeNombre", GXutil.rtrim( gxTv_SdtSDTProfesionalEspecialidadSede_Sedenombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ClinicaNombreAbreviado", GXutil.rtrim( gxTv_SdtSDTProfesionalEspecialidadSede_Clinicanombreabreviado));
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
      AddObjectProperty("EspecialidadId", gxTv_SdtSDTProfesionalEspecialidadSede_Especialidadid, false, false);
      AddObjectProperty("EspecialidadCodigo", gxTv_SdtSDTProfesionalEspecialidadSede_Especialidadcodigo, false, false);
      AddObjectProperty("EspecialidadNombre", gxTv_SdtSDTProfesionalEspecialidadSede_Especialidadnombre, false, false);
      AddObjectProperty("SedeId", gxTv_SdtSDTProfesionalEspecialidadSede_Sedeid, false, false);
      AddObjectProperty("SedeTipoConsulta", gxTv_SdtSDTProfesionalEspecialidadSede_Sedetipoconsulta, false, false);
      AddObjectProperty("CostoConsulta", gxTv_SdtSDTProfesionalEspecialidadSede_Costoconsulta, false, false);
      AddObjectProperty("SedeNombre", gxTv_SdtSDTProfesionalEspecialidadSede_Sedenombre, false, false);
      AddObjectProperty("ClinicaNombreAbreviado", gxTv_SdtSDTProfesionalEspecialidadSede_Clinicanombreabreviado, false, false);
   }

   public short getgxTv_SdtSDTProfesionalEspecialidadSede_Especialidadid( )
   {
      return gxTv_SdtSDTProfesionalEspecialidadSede_Especialidadid ;
   }

   public void setgxTv_SdtSDTProfesionalEspecialidadSede_Especialidadid( short value )
   {
      gxTv_SdtSDTProfesionalEspecialidadSede_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEspecialidadSede_Especialidadid = value ;
   }

   public String getgxTv_SdtSDTProfesionalEspecialidadSede_Especialidadcodigo( )
   {
      return gxTv_SdtSDTProfesionalEspecialidadSede_Especialidadcodigo ;
   }

   public void setgxTv_SdtSDTProfesionalEspecialidadSede_Especialidadcodigo( String value )
   {
      gxTv_SdtSDTProfesionalEspecialidadSede_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEspecialidadSede_Especialidadcodigo = value ;
   }

   public String getgxTv_SdtSDTProfesionalEspecialidadSede_Especialidadnombre( )
   {
      return gxTv_SdtSDTProfesionalEspecialidadSede_Especialidadnombre ;
   }

   public void setgxTv_SdtSDTProfesionalEspecialidadSede_Especialidadnombre( String value )
   {
      gxTv_SdtSDTProfesionalEspecialidadSede_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEspecialidadSede_Especialidadnombre = value ;
   }

   public short getgxTv_SdtSDTProfesionalEspecialidadSede_Sedeid( )
   {
      return gxTv_SdtSDTProfesionalEspecialidadSede_Sedeid ;
   }

   public void setgxTv_SdtSDTProfesionalEspecialidadSede_Sedeid( short value )
   {
      gxTv_SdtSDTProfesionalEspecialidadSede_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEspecialidadSede_Sedeid = value ;
   }

   public String getgxTv_SdtSDTProfesionalEspecialidadSede_Sedetipoconsulta( )
   {
      return gxTv_SdtSDTProfesionalEspecialidadSede_Sedetipoconsulta ;
   }

   public void setgxTv_SdtSDTProfesionalEspecialidadSede_Sedetipoconsulta( String value )
   {
      gxTv_SdtSDTProfesionalEspecialidadSede_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEspecialidadSede_Sedetipoconsulta = value ;
   }

   public java.math.BigDecimal getgxTv_SdtSDTProfesionalEspecialidadSede_Costoconsulta( )
   {
      return gxTv_SdtSDTProfesionalEspecialidadSede_Costoconsulta ;
   }

   public void setgxTv_SdtSDTProfesionalEspecialidadSede_Costoconsulta( java.math.BigDecimal value )
   {
      gxTv_SdtSDTProfesionalEspecialidadSede_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEspecialidadSede_Costoconsulta = value ;
   }

   public String getgxTv_SdtSDTProfesionalEspecialidadSede_Sedenombre( )
   {
      return gxTv_SdtSDTProfesionalEspecialidadSede_Sedenombre ;
   }

   public void setgxTv_SdtSDTProfesionalEspecialidadSede_Sedenombre( String value )
   {
      gxTv_SdtSDTProfesionalEspecialidadSede_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEspecialidadSede_Sedenombre = value ;
   }

   public String getgxTv_SdtSDTProfesionalEspecialidadSede_Clinicanombreabreviado( )
   {
      return gxTv_SdtSDTProfesionalEspecialidadSede_Clinicanombreabreviado ;
   }

   public void setgxTv_SdtSDTProfesionalEspecialidadSede_Clinicanombreabreviado( String value )
   {
      gxTv_SdtSDTProfesionalEspecialidadSede_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEspecialidadSede_Clinicanombreabreviado = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTProfesionalEspecialidadSede_N = (byte)(1) ;
      gxTv_SdtSDTProfesionalEspecialidadSede_Especialidadcodigo = "" ;
      gxTv_SdtSDTProfesionalEspecialidadSede_Especialidadnombre = "" ;
      gxTv_SdtSDTProfesionalEspecialidadSede_Sedetipoconsulta = "" ;
      gxTv_SdtSDTProfesionalEspecialidadSede_Costoconsulta = DecimalUtil.stringToDec("0.00") ;
      gxTv_SdtSDTProfesionalEspecialidadSede_Sedenombre = "" ;
      gxTv_SdtSDTProfesionalEspecialidadSede_Clinicanombreabreviado = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTProfesionalEspecialidadSede_N ;
   }

   public com.projectthani.SdtSDTProfesionalEspecialidadSede Clone( )
   {
      return (com.projectthani.SdtSDTProfesionalEspecialidadSede)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTProfesionalEspecialidadSede struct )
   {
      setgxTv_SdtSDTProfesionalEspecialidadSede_Especialidadid(struct.getEspecialidadid());
      setgxTv_SdtSDTProfesionalEspecialidadSede_Especialidadcodigo(struct.getEspecialidadcodigo());
      setgxTv_SdtSDTProfesionalEspecialidadSede_Especialidadnombre(struct.getEspecialidadnombre());
      setgxTv_SdtSDTProfesionalEspecialidadSede_Sedeid(struct.getSedeid());
      setgxTv_SdtSDTProfesionalEspecialidadSede_Sedetipoconsulta(struct.getSedetipoconsulta());
      setgxTv_SdtSDTProfesionalEspecialidadSede_Costoconsulta(struct.getCostoconsulta());
      setgxTv_SdtSDTProfesionalEspecialidadSede_Sedenombre(struct.getSedenombre());
      setgxTv_SdtSDTProfesionalEspecialidadSede_Clinicanombreabreviado(struct.getClinicanombreabreviado());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTProfesionalEspecialidadSede getStruct( )
   {
      com.projectthani.StructSdtSDTProfesionalEspecialidadSede struct = new com.projectthani.StructSdtSDTProfesionalEspecialidadSede ();
      struct.setEspecialidadid(getgxTv_SdtSDTProfesionalEspecialidadSede_Especialidadid());
      struct.setEspecialidadcodigo(getgxTv_SdtSDTProfesionalEspecialidadSede_Especialidadcodigo());
      struct.setEspecialidadnombre(getgxTv_SdtSDTProfesionalEspecialidadSede_Especialidadnombre());
      struct.setSedeid(getgxTv_SdtSDTProfesionalEspecialidadSede_Sedeid());
      struct.setSedetipoconsulta(getgxTv_SdtSDTProfesionalEspecialidadSede_Sedetipoconsulta());
      struct.setCostoconsulta(getgxTv_SdtSDTProfesionalEspecialidadSede_Costoconsulta());
      struct.setSedenombre(getgxTv_SdtSDTProfesionalEspecialidadSede_Sedenombre());
      struct.setClinicanombreabreviado(getgxTv_SdtSDTProfesionalEspecialidadSede_Clinicanombreabreviado());
      return struct ;
   }

   protected byte gxTv_SdtSDTProfesionalEspecialidadSede_N ;
   protected short gxTv_SdtSDTProfesionalEspecialidadSede_Especialidadid ;
   protected short gxTv_SdtSDTProfesionalEspecialidadSede_Sedeid ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_SdtSDTProfesionalEspecialidadSede_Costoconsulta ;
   protected String gxTv_SdtSDTProfesionalEspecialidadSede_Sedetipoconsulta ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTProfesionalEspecialidadSede_Especialidadcodigo ;
   protected String gxTv_SdtSDTProfesionalEspecialidadSede_Especialidadnombre ;
   protected String gxTv_SdtSDTProfesionalEspecialidadSede_Sedenombre ;
   protected String gxTv_SdtSDTProfesionalEspecialidadSede_Clinicanombreabreviado ;
}

