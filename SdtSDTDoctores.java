package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTDoctores extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTDoctores( )
   {
      this(  new ModelContext(SdtSDTDoctores.class));
   }

   public SdtSDTDoctores( ModelContext context )
   {
      super( context, "SdtSDTDoctores");
   }

   public SdtSDTDoctores( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTDoctores");
   }

   public SdtSDTDoctores( StructSdtSDTDoctores struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ApellidosNombres") )
            {
               gxTv_SdtSDTDoctores_Apellidosnombres = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Fotografia") )
            {
               gxTv_SdtSDTDoctores_Fotografia = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Fotografia_GXI") )
            {
               gxTv_SdtSDTDoctores_Fotografia_gxi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Especialidad") )
            {
               gxTv_SdtSDTDoctores_Especialidad = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EspecialidadId") )
            {
               gxTv_SdtSDTDoctores_Especialidadid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TipoCita") )
            {
               gxTv_SdtSDTDoctores_Tipocita = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Calificacion") )
            {
               gxTv_SdtSDTDoctores_Calificacion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Direccion") )
            {
               gxTv_SdtSDTDoctores_Direccion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Disponibilidad") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtSDTDoctores_Disponibilidad = GXutil.nullDate() ;
                  gxTv_SdtSDTDoctores_Disponibilidad_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtSDTDoctores_Disponibilidad_N = (byte)(0) ;
                  gxTv_SdtSDTDoctores_Disponibilidad = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PrecioConsulta") )
            {
               gxTv_SdtSDTDoctores_Precioconsulta = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalId") )
            {
               gxTv_SdtSDTDoctores_Profesionalid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTDoctoresVerPerfil") )
            {
               gxTv_SdtSDTDoctores_Sdtdoctoresverperfil = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTDoctoresReservarCita") )
            {
               gxTv_SdtSDTDoctores_Sdtdoctoresreservarcita = (short)(getnumericvalue(oReader.getValue())) ;
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
         sName = "SDTDoctores" ;
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
      oWriter.writeElement("ApellidosNombres", GXutil.rtrim( gxTv_SdtSDTDoctores_Apellidosnombres));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Fotografia", GXutil.rtrim( gxTv_SdtSDTDoctores_Fotografia));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Fotografia_GXI", GXutil.rtrim( gxTv_SdtSDTDoctores_Fotografia_gxi));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Especialidad", GXutil.rtrim( gxTv_SdtSDTDoctores_Especialidad));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("EspecialidadId", GXutil.trim( GXutil.str( gxTv_SdtSDTDoctores_Especialidadid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("TipoCita", GXutil.rtrim( gxTv_SdtSDTDoctores_Tipocita));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Calificacion", GXutil.rtrim( gxTv_SdtSDTDoctores_Calificacion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Direccion", GXutil.rtrim( gxTv_SdtSDTDoctores_Direccion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_SdtSDTDoctores_Disponibilidad)) && ( gxTv_SdtSDTDoctores_Disponibilidad_N == 1 ) )
      {
         oWriter.writeElement("Disponibilidad", "");
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTDoctores_Disponibilidad), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTDoctores_Disponibilidad), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTDoctores_Disponibilidad), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("Disponibilidad", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      oWriter.writeElement("PrecioConsulta", GXutil.rtrim( gxTv_SdtSDTDoctores_Precioconsulta));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalId", GXutil.trim( GXutil.str( gxTv_SdtSDTDoctores_Profesionalid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTDoctoresVerPerfil", GXutil.trim( GXutil.str( gxTv_SdtSDTDoctores_Sdtdoctoresverperfil, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTDoctoresReservarCita", GXutil.trim( GXutil.str( gxTv_SdtSDTDoctores_Sdtdoctoresreservarcita, 4, 0)));
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
      AddObjectProperty("ApellidosNombres", gxTv_SdtSDTDoctores_Apellidosnombres, false, false);
      AddObjectProperty("Fotografia", gxTv_SdtSDTDoctores_Fotografia, false, false);
      AddObjectProperty("Fotografia_GXI", gxTv_SdtSDTDoctores_Fotografia_gxi, false, false);
      AddObjectProperty("Especialidad", gxTv_SdtSDTDoctores_Especialidad, false, false);
      AddObjectProperty("EspecialidadId", gxTv_SdtSDTDoctores_Especialidadid, false, false);
      AddObjectProperty("TipoCita", gxTv_SdtSDTDoctores_Tipocita, false, false);
      AddObjectProperty("Calificacion", gxTv_SdtSDTDoctores_Calificacion, false, false);
      AddObjectProperty("Direccion", gxTv_SdtSDTDoctores_Direccion, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTDoctores_Disponibilidad), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTDoctores_Disponibilidad), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTDoctores_Disponibilidad), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("Disponibilidad", sDateCnv, false, false);
      AddObjectProperty("PrecioConsulta", gxTv_SdtSDTDoctores_Precioconsulta, false, false);
      AddObjectProperty("ProfesionalId", gxTv_SdtSDTDoctores_Profesionalid, false, false);
      AddObjectProperty("SDTDoctoresVerPerfil", gxTv_SdtSDTDoctores_Sdtdoctoresverperfil, false, false);
      AddObjectProperty("SDTDoctoresReservarCita", gxTv_SdtSDTDoctores_Sdtdoctoresreservarcita, false, false);
   }

   public String getgxTv_SdtSDTDoctores_Apellidosnombres( )
   {
      return gxTv_SdtSDTDoctores_Apellidosnombres ;
   }

   public void setgxTv_SdtSDTDoctores_Apellidosnombres( String value )
   {
      gxTv_SdtSDTDoctores_N = (byte)(0) ;
      gxTv_SdtSDTDoctores_Apellidosnombres = value ;
   }

   @GxUpload
   public String getgxTv_SdtSDTDoctores_Fotografia( )
   {
      return gxTv_SdtSDTDoctores_Fotografia ;
   }

   public void setgxTv_SdtSDTDoctores_Fotografia( String value )
   {
      gxTv_SdtSDTDoctores_N = (byte)(0) ;
      gxTv_SdtSDTDoctores_Fotografia = value ;
   }

   public String getgxTv_SdtSDTDoctores_Fotografia_gxi( )
   {
      return gxTv_SdtSDTDoctores_Fotografia_gxi ;
   }

   public void setgxTv_SdtSDTDoctores_Fotografia_gxi( String value )
   {
      gxTv_SdtSDTDoctores_N = (byte)(0) ;
      gxTv_SdtSDTDoctores_Fotografia_gxi = value ;
   }

   public String getgxTv_SdtSDTDoctores_Especialidad( )
   {
      return gxTv_SdtSDTDoctores_Especialidad ;
   }

   public void setgxTv_SdtSDTDoctores_Especialidad( String value )
   {
      gxTv_SdtSDTDoctores_N = (byte)(0) ;
      gxTv_SdtSDTDoctores_Especialidad = value ;
   }

   public short getgxTv_SdtSDTDoctores_Especialidadid( )
   {
      return gxTv_SdtSDTDoctores_Especialidadid ;
   }

   public void setgxTv_SdtSDTDoctores_Especialidadid( short value )
   {
      gxTv_SdtSDTDoctores_N = (byte)(0) ;
      gxTv_SdtSDTDoctores_Especialidadid = value ;
   }

   public String getgxTv_SdtSDTDoctores_Tipocita( )
   {
      return gxTv_SdtSDTDoctores_Tipocita ;
   }

   public void setgxTv_SdtSDTDoctores_Tipocita( String value )
   {
      gxTv_SdtSDTDoctores_N = (byte)(0) ;
      gxTv_SdtSDTDoctores_Tipocita = value ;
   }

   public String getgxTv_SdtSDTDoctores_Calificacion( )
   {
      return gxTv_SdtSDTDoctores_Calificacion ;
   }

   public void setgxTv_SdtSDTDoctores_Calificacion( String value )
   {
      gxTv_SdtSDTDoctores_N = (byte)(0) ;
      gxTv_SdtSDTDoctores_Calificacion = value ;
   }

   public String getgxTv_SdtSDTDoctores_Direccion( )
   {
      return gxTv_SdtSDTDoctores_Direccion ;
   }

   public void setgxTv_SdtSDTDoctores_Direccion( String value )
   {
      gxTv_SdtSDTDoctores_N = (byte)(0) ;
      gxTv_SdtSDTDoctores_Direccion = value ;
   }

   public java.util.Date getgxTv_SdtSDTDoctores_Disponibilidad( )
   {
      return gxTv_SdtSDTDoctores_Disponibilidad ;
   }

   public void setgxTv_SdtSDTDoctores_Disponibilidad( java.util.Date value )
   {
      gxTv_SdtSDTDoctores_Disponibilidad_N = (byte)(0) ;
      gxTv_SdtSDTDoctores_N = (byte)(0) ;
      gxTv_SdtSDTDoctores_Disponibilidad = value ;
   }

   public String getgxTv_SdtSDTDoctores_Precioconsulta( )
   {
      return gxTv_SdtSDTDoctores_Precioconsulta ;
   }

   public void setgxTv_SdtSDTDoctores_Precioconsulta( String value )
   {
      gxTv_SdtSDTDoctores_N = (byte)(0) ;
      gxTv_SdtSDTDoctores_Precioconsulta = value ;
   }

   public int getgxTv_SdtSDTDoctores_Profesionalid( )
   {
      return gxTv_SdtSDTDoctores_Profesionalid ;
   }

   public void setgxTv_SdtSDTDoctores_Profesionalid( int value )
   {
      gxTv_SdtSDTDoctores_N = (byte)(0) ;
      gxTv_SdtSDTDoctores_Profesionalid = value ;
   }

   public short getgxTv_SdtSDTDoctores_Sdtdoctoresverperfil( )
   {
      return gxTv_SdtSDTDoctores_Sdtdoctoresverperfil ;
   }

   public void setgxTv_SdtSDTDoctores_Sdtdoctoresverperfil( short value )
   {
      gxTv_SdtSDTDoctores_N = (byte)(0) ;
      gxTv_SdtSDTDoctores_Sdtdoctoresverperfil = value ;
   }

   public short getgxTv_SdtSDTDoctores_Sdtdoctoresreservarcita( )
   {
      return gxTv_SdtSDTDoctores_Sdtdoctoresreservarcita ;
   }

   public void setgxTv_SdtSDTDoctores_Sdtdoctoresreservarcita( short value )
   {
      gxTv_SdtSDTDoctores_N = (byte)(0) ;
      gxTv_SdtSDTDoctores_Sdtdoctoresreservarcita = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTDoctores_Apellidosnombres = "" ;
      gxTv_SdtSDTDoctores_N = (byte)(1) ;
      gxTv_SdtSDTDoctores_Fotografia = "" ;
      gxTv_SdtSDTDoctores_Fotografia_gxi = "" ;
      gxTv_SdtSDTDoctores_Especialidad = "" ;
      gxTv_SdtSDTDoctores_Tipocita = "" ;
      gxTv_SdtSDTDoctores_Calificacion = "" ;
      gxTv_SdtSDTDoctores_Direccion = "" ;
      gxTv_SdtSDTDoctores_Disponibilidad = GXutil.nullDate() ;
      gxTv_SdtSDTDoctores_Disponibilidad_N = (byte)(1) ;
      gxTv_SdtSDTDoctores_Precioconsulta = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTDoctores_N ;
   }

   public com.projectthani.SdtSDTDoctores Clone( )
   {
      return (com.projectthani.SdtSDTDoctores)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTDoctores struct )
   {
      setgxTv_SdtSDTDoctores_Apellidosnombres(struct.getApellidosnombres());
      setgxTv_SdtSDTDoctores_Fotografia(struct.getFotografia());
      setgxTv_SdtSDTDoctores_Fotografia_gxi(struct.getFotografia_gxi());
      setgxTv_SdtSDTDoctores_Especialidad(struct.getEspecialidad());
      setgxTv_SdtSDTDoctores_Especialidadid(struct.getEspecialidadid());
      setgxTv_SdtSDTDoctores_Tipocita(struct.getTipocita());
      setgxTv_SdtSDTDoctores_Calificacion(struct.getCalificacion());
      setgxTv_SdtSDTDoctores_Direccion(struct.getDireccion());
      if ( struct.gxTv_SdtSDTDoctores_Disponibilidad_N == 0 )
      {
         setgxTv_SdtSDTDoctores_Disponibilidad(struct.getDisponibilidad());
      }
      setgxTv_SdtSDTDoctores_Precioconsulta(struct.getPrecioconsulta());
      setgxTv_SdtSDTDoctores_Profesionalid(struct.getProfesionalid());
      setgxTv_SdtSDTDoctores_Sdtdoctoresverperfil(struct.getSdtdoctoresverperfil());
      setgxTv_SdtSDTDoctores_Sdtdoctoresreservarcita(struct.getSdtdoctoresreservarcita());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTDoctores getStruct( )
   {
      com.projectthani.StructSdtSDTDoctores struct = new com.projectthani.StructSdtSDTDoctores ();
      struct.setApellidosnombres(getgxTv_SdtSDTDoctores_Apellidosnombres());
      struct.setFotografia(getgxTv_SdtSDTDoctores_Fotografia());
      struct.setFotografia_gxi(getgxTv_SdtSDTDoctores_Fotografia_gxi());
      struct.setEspecialidad(getgxTv_SdtSDTDoctores_Especialidad());
      struct.setEspecialidadid(getgxTv_SdtSDTDoctores_Especialidadid());
      struct.setTipocita(getgxTv_SdtSDTDoctores_Tipocita());
      struct.setCalificacion(getgxTv_SdtSDTDoctores_Calificacion());
      struct.setDireccion(getgxTv_SdtSDTDoctores_Direccion());
      if ( gxTv_SdtSDTDoctores_Disponibilidad_N == 0 )
      {
         struct.setDisponibilidad(getgxTv_SdtSDTDoctores_Disponibilidad());
      }
      struct.setPrecioconsulta(getgxTv_SdtSDTDoctores_Precioconsulta());
      struct.setProfesionalid(getgxTv_SdtSDTDoctores_Profesionalid());
      struct.setSdtdoctoresverperfil(getgxTv_SdtSDTDoctores_Sdtdoctoresverperfil());
      struct.setSdtdoctoresreservarcita(getgxTv_SdtSDTDoctores_Sdtdoctoresreservarcita());
      return struct ;
   }

   protected byte gxTv_SdtSDTDoctores_N ;
   protected byte gxTv_SdtSDTDoctores_Disponibilidad_N ;
   protected short gxTv_SdtSDTDoctores_Especialidadid ;
   protected short gxTv_SdtSDTDoctores_Sdtdoctoresverperfil ;
   protected short gxTv_SdtSDTDoctores_Sdtdoctoresreservarcita ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_SdtSDTDoctores_Profesionalid ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_SdtSDTDoctores_Disponibilidad ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTDoctores_Calificacion ;
   protected String gxTv_SdtSDTDoctores_Apellidosnombres ;
   protected String gxTv_SdtSDTDoctores_Fotografia_gxi ;
   protected String gxTv_SdtSDTDoctores_Especialidad ;
   protected String gxTv_SdtSDTDoctores_Tipocita ;
   protected String gxTv_SdtSDTDoctores_Direccion ;
   protected String gxTv_SdtSDTDoctores_Precioconsulta ;
   protected String gxTv_SdtSDTDoctores_Fotografia ;
}

