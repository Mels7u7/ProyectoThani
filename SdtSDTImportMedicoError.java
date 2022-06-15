package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTImportMedicoError extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTImportMedicoError( )
   {
      this(  new ModelContext(SdtSDTImportMedicoError.class));
   }

   public SdtSDTImportMedicoError( ModelContext context )
   {
      super( context, "SdtSDTImportMedicoError");
   }

   public SdtSDTImportMedicoError( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTImportMedicoError");
   }

   public SdtSDTImportMedicoError( StructSdtSDTImportMedicoError struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalId") )
            {
               gxTv_SdtSDTImportMedicoError_Profesionalid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalTipoDocumento") )
            {
               gxTv_SdtSDTImportMedicoError_Profesionaltipodocumento = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalNroDocumento") )
            {
               gxTv_SdtSDTImportMedicoError_Profesionalnrodocumento = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalApellidoPaterno") )
            {
               gxTv_SdtSDTImportMedicoError_Profesionalapellidopaterno = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalApellidoMaterno") )
            {
               gxTv_SdtSDTImportMedicoError_Profesionalapellidomaterno = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalNombres") )
            {
               gxTv_SdtSDTImportMedicoError_Profesionalnombres = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalNombreCompleto2") )
            {
               gxTv_SdtSDTImportMedicoError_Profesionalnombrecompleto2 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalFechaNacimiento") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtSDTImportMedicoError_Profesionalfechanacimiento = GXutil.nullDate() ;
                  gxTv_SdtSDTImportMedicoError_Profesionalfechanacimiento_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtSDTImportMedicoError_Profesionalfechanacimiento_N = (byte)(0) ;
                  gxTv_SdtSDTImportMedicoError_Profesionalfechanacimiento = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalSexo") )
            {
               gxTv_SdtSDTImportMedicoError_Profesionalsexo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalDescripcion") )
            {
               gxTv_SdtSDTImportMedicoError_Profesionaldescripcion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalCorreo") )
            {
               gxTv_SdtSDTImportMedicoError_Profesionalcorreo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalCOP") )
            {
               gxTv_SdtSDTImportMedicoError_Profesionalcop = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalColorDisponible") )
            {
               gxTv_SdtSDTImportMedicoError_Profesionalcolordisponible = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalColorCita") )
            {
               gxTv_SdtSDTImportMedicoError_Profesionalcolorcita = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalTiempoCita") )
            {
               gxTv_SdtSDTImportMedicoError_Profesionaltiempocita = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalDireccion") )
            {
               gxTv_SdtSDTImportMedicoError_Profesionaldireccion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaisId") )
            {
               gxTv_SdtSDTImportMedicoError_Paisid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaisDescripcion") )
            {
               gxTv_SdtSDTImportMedicoError_Paisdescripcion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "UbigeoCode") )
            {
               gxTv_SdtSDTImportMedicoError_Ubigeocode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "UbigeoNombre") )
            {
               gxTv_SdtSDTImportMedicoError_Ubigeonombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalFoto") )
            {
               gxTv_SdtSDTImportMedicoError_Profesionalfoto = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalFoto_GXI") )
            {
               gxTv_SdtSDTImportMedicoError_Profesionalfoto_gxi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalTelefono") )
            {
               gxTv_SdtSDTImportMedicoError_Profesionaltelefono = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserId") )
            {
               gxTv_SdtSDTImportMedicoError_Secuserid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalFechaRegistro") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtSDTImportMedicoError_Profesionalfecharegistro = GXutil.nullDate() ;
                  gxTv_SdtSDTImportMedicoError_Profesionalfecharegistro_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtSDTImportMedicoError_Profesionalfecharegistro_N = (byte)(0) ;
                  gxTv_SdtSDTImportMedicoError_Profesionalfecharegistro = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalTerminosCondiciones") )
            {
               gxTv_SdtSDTImportMedicoError_Profesionalterminoscondiciones = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalEstadoCuenta") )
            {
               gxTv_SdtSDTImportMedicoError_Profesionalestadocuenta = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalEstado") )
            {
               gxTv_SdtSDTImportMedicoError_Profesionalestado = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EstadoImport") )
            {
               gxTv_SdtSDTImportMedicoError_Estadoimport = oReader.getValue() ;
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
         sName = "SDTImportMedicoError" ;
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
      oWriter.writeElement("ProfesionalId", GXutil.trim( GXutil.str( gxTv_SdtSDTImportMedicoError_Profesionalid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalTipoDocumento", GXutil.rtrim( gxTv_SdtSDTImportMedicoError_Profesionaltipodocumento));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalNroDocumento", GXutil.rtrim( gxTv_SdtSDTImportMedicoError_Profesionalnrodocumento));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalApellidoPaterno", GXutil.rtrim( gxTv_SdtSDTImportMedicoError_Profesionalapellidopaterno));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalApellidoMaterno", GXutil.rtrim( gxTv_SdtSDTImportMedicoError_Profesionalapellidomaterno));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalNombres", GXutil.rtrim( gxTv_SdtSDTImportMedicoError_Profesionalnombres));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalNombreCompleto2", GXutil.rtrim( gxTv_SdtSDTImportMedicoError_Profesionalnombrecompleto2));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_SdtSDTImportMedicoError_Profesionalfechanacimiento)) && ( gxTv_SdtSDTImportMedicoError_Profesionalfechanacimiento_N == 1 ) )
      {
         oWriter.writeElement("ProfesionalFechaNacimiento", "");
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTImportMedicoError_Profesionalfechanacimiento), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTImportMedicoError_Profesionalfechanacimiento), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTImportMedicoError_Profesionalfechanacimiento), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("ProfesionalFechaNacimiento", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      oWriter.writeElement("ProfesionalSexo", GXutil.rtrim( gxTv_SdtSDTImportMedicoError_Profesionalsexo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalDescripcion", GXutil.rtrim( gxTv_SdtSDTImportMedicoError_Profesionaldescripcion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalCorreo", GXutil.rtrim( gxTv_SdtSDTImportMedicoError_Profesionalcorreo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalCOP", GXutil.rtrim( gxTv_SdtSDTImportMedicoError_Profesionalcop));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalColorDisponible", GXutil.rtrim( gxTv_SdtSDTImportMedicoError_Profesionalcolordisponible));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalColorCita", GXutil.rtrim( gxTv_SdtSDTImportMedicoError_Profesionalcolorcita));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalTiempoCita", GXutil.trim( GXutil.str( gxTv_SdtSDTImportMedicoError_Profesionaltiempocita, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalDireccion", GXutil.rtrim( gxTv_SdtSDTImportMedicoError_Profesionaldireccion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PaisId", GXutil.trim( GXutil.str( gxTv_SdtSDTImportMedicoError_Paisid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PaisDescripcion", GXutil.rtrim( gxTv_SdtSDTImportMedicoError_Paisdescripcion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("UbigeoCode", GXutil.rtrim( gxTv_SdtSDTImportMedicoError_Ubigeocode));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("UbigeoNombre", GXutil.rtrim( gxTv_SdtSDTImportMedicoError_Ubigeonombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalFoto", GXutil.rtrim( gxTv_SdtSDTImportMedicoError_Profesionalfoto));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalFoto_GXI", GXutil.rtrim( gxTv_SdtSDTImportMedicoError_Profesionalfoto_gxi));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalTelefono", GXutil.rtrim( gxTv_SdtSDTImportMedicoError_Profesionaltelefono));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SecUserId", GXutil.trim( GXutil.str( gxTv_SdtSDTImportMedicoError_Secuserid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_SdtSDTImportMedicoError_Profesionalfecharegistro)) && ( gxTv_SdtSDTImportMedicoError_Profesionalfecharegistro_N == 1 ) )
      {
         oWriter.writeElement("ProfesionalFechaRegistro", "");
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTImportMedicoError_Profesionalfecharegistro), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTImportMedicoError_Profesionalfecharegistro), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTImportMedicoError_Profesionalfecharegistro), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("ProfesionalFechaRegistro", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      oWriter.writeElement("ProfesionalTerminosCondiciones", GXutil.rtrim( GXutil.booltostr( gxTv_SdtSDTImportMedicoError_Profesionalterminoscondiciones)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalEstadoCuenta", GXutil.rtrim( gxTv_SdtSDTImportMedicoError_Profesionalestadocuenta));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalEstado", GXutil.rtrim( gxTv_SdtSDTImportMedicoError_Profesionalestado));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("EstadoImport", GXutil.rtrim( gxTv_SdtSDTImportMedicoError_Estadoimport));
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
      AddObjectProperty("ProfesionalId", gxTv_SdtSDTImportMedicoError_Profesionalid, false, false);
      AddObjectProperty("ProfesionalTipoDocumento", gxTv_SdtSDTImportMedicoError_Profesionaltipodocumento, false, false);
      AddObjectProperty("ProfesionalNroDocumento", gxTv_SdtSDTImportMedicoError_Profesionalnrodocumento, false, false);
      AddObjectProperty("ProfesionalApellidoPaterno", gxTv_SdtSDTImportMedicoError_Profesionalapellidopaterno, false, false);
      AddObjectProperty("ProfesionalApellidoMaterno", gxTv_SdtSDTImportMedicoError_Profesionalapellidomaterno, false, false);
      AddObjectProperty("ProfesionalNombres", gxTv_SdtSDTImportMedicoError_Profesionalnombres, false, false);
      AddObjectProperty("ProfesionalNombreCompleto2", gxTv_SdtSDTImportMedicoError_Profesionalnombrecompleto2, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTImportMedicoError_Profesionalfechanacimiento), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTImportMedicoError_Profesionalfechanacimiento), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTImportMedicoError_Profesionalfechanacimiento), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("ProfesionalFechaNacimiento", sDateCnv, false, false);
      AddObjectProperty("ProfesionalSexo", gxTv_SdtSDTImportMedicoError_Profesionalsexo, false, false);
      AddObjectProperty("ProfesionalDescripcion", gxTv_SdtSDTImportMedicoError_Profesionaldescripcion, false, false);
      AddObjectProperty("ProfesionalCorreo", gxTv_SdtSDTImportMedicoError_Profesionalcorreo, false, false);
      AddObjectProperty("ProfesionalCOP", gxTv_SdtSDTImportMedicoError_Profesionalcop, false, false);
      AddObjectProperty("ProfesionalColorDisponible", gxTv_SdtSDTImportMedicoError_Profesionalcolordisponible, false, false);
      AddObjectProperty("ProfesionalColorCita", gxTv_SdtSDTImportMedicoError_Profesionalcolorcita, false, false);
      AddObjectProperty("ProfesionalTiempoCita", gxTv_SdtSDTImportMedicoError_Profesionaltiempocita, false, false);
      AddObjectProperty("ProfesionalDireccion", gxTv_SdtSDTImportMedicoError_Profesionaldireccion, false, false);
      AddObjectProperty("PaisId", gxTv_SdtSDTImportMedicoError_Paisid, false, false);
      AddObjectProperty("PaisDescripcion", gxTv_SdtSDTImportMedicoError_Paisdescripcion, false, false);
      AddObjectProperty("UbigeoCode", gxTv_SdtSDTImportMedicoError_Ubigeocode, false, false);
      AddObjectProperty("UbigeoNombre", gxTv_SdtSDTImportMedicoError_Ubigeonombre, false, false);
      AddObjectProperty("ProfesionalFoto", gxTv_SdtSDTImportMedicoError_Profesionalfoto, false, false);
      AddObjectProperty("ProfesionalFoto_GXI", gxTv_SdtSDTImportMedicoError_Profesionalfoto_gxi, false, false);
      AddObjectProperty("ProfesionalTelefono", gxTv_SdtSDTImportMedicoError_Profesionaltelefono, false, false);
      AddObjectProperty("SecUserId", gxTv_SdtSDTImportMedicoError_Secuserid, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTImportMedicoError_Profesionalfecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTImportMedicoError_Profesionalfecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTImportMedicoError_Profesionalfecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("ProfesionalFechaRegistro", sDateCnv, false, false);
      AddObjectProperty("ProfesionalTerminosCondiciones", gxTv_SdtSDTImportMedicoError_Profesionalterminoscondiciones, false, false);
      AddObjectProperty("ProfesionalEstadoCuenta", gxTv_SdtSDTImportMedicoError_Profesionalestadocuenta, false, false);
      AddObjectProperty("ProfesionalEstado", gxTv_SdtSDTImportMedicoError_Profesionalestado, false, false);
      AddObjectProperty("EstadoImport", gxTv_SdtSDTImportMedicoError_Estadoimport, false, false);
   }

   public int getgxTv_SdtSDTImportMedicoError_Profesionalid( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionalid ;
   }

   public void setgxTv_SdtSDTImportMedicoError_Profesionalid( int value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionalid = value ;
   }

   public String getgxTv_SdtSDTImportMedicoError_Profesionaltipodocumento( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionaltipodocumento ;
   }

   public void setgxTv_SdtSDTImportMedicoError_Profesionaltipodocumento( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionaltipodocumento = value ;
   }

   public String getgxTv_SdtSDTImportMedicoError_Profesionalnrodocumento( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionalnrodocumento ;
   }

   public void setgxTv_SdtSDTImportMedicoError_Profesionalnrodocumento( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionalnrodocumento = value ;
   }

   public String getgxTv_SdtSDTImportMedicoError_Profesionalapellidopaterno( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionalapellidopaterno ;
   }

   public void setgxTv_SdtSDTImportMedicoError_Profesionalapellidopaterno( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionalapellidopaterno = value ;
   }

   public String getgxTv_SdtSDTImportMedicoError_Profesionalapellidomaterno( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionalapellidomaterno ;
   }

   public void setgxTv_SdtSDTImportMedicoError_Profesionalapellidomaterno( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionalapellidomaterno = value ;
   }

   public String getgxTv_SdtSDTImportMedicoError_Profesionalnombres( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionalnombres ;
   }

   public void setgxTv_SdtSDTImportMedicoError_Profesionalnombres( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionalnombres = value ;
   }

   public String getgxTv_SdtSDTImportMedicoError_Profesionalnombrecompleto2( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionalnombrecompleto2 ;
   }

   public void setgxTv_SdtSDTImportMedicoError_Profesionalnombrecompleto2( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionalnombrecompleto2 = value ;
   }

   public java.util.Date getgxTv_SdtSDTImportMedicoError_Profesionalfechanacimiento( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionalfechanacimiento ;
   }

   public void setgxTv_SdtSDTImportMedicoError_Profesionalfechanacimiento( java.util.Date value )
   {
      gxTv_SdtSDTImportMedicoError_Profesionalfechanacimiento_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionalfechanacimiento = value ;
   }

   public String getgxTv_SdtSDTImportMedicoError_Profesionalsexo( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionalsexo ;
   }

   public void setgxTv_SdtSDTImportMedicoError_Profesionalsexo( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionalsexo = value ;
   }

   public String getgxTv_SdtSDTImportMedicoError_Profesionaldescripcion( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionaldescripcion ;
   }

   public void setgxTv_SdtSDTImportMedicoError_Profesionaldescripcion( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionaldescripcion = value ;
   }

   public String getgxTv_SdtSDTImportMedicoError_Profesionalcorreo( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionalcorreo ;
   }

   public void setgxTv_SdtSDTImportMedicoError_Profesionalcorreo( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionalcorreo = value ;
   }

   public String getgxTv_SdtSDTImportMedicoError_Profesionalcop( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionalcop ;
   }

   public void setgxTv_SdtSDTImportMedicoError_Profesionalcop( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionalcop = value ;
   }

   public String getgxTv_SdtSDTImportMedicoError_Profesionalcolordisponible( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionalcolordisponible ;
   }

   public void setgxTv_SdtSDTImportMedicoError_Profesionalcolordisponible( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionalcolordisponible = value ;
   }

   public String getgxTv_SdtSDTImportMedicoError_Profesionalcolorcita( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionalcolorcita ;
   }

   public void setgxTv_SdtSDTImportMedicoError_Profesionalcolorcita( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionalcolorcita = value ;
   }

   public byte getgxTv_SdtSDTImportMedicoError_Profesionaltiempocita( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionaltiempocita ;
   }

   public void setgxTv_SdtSDTImportMedicoError_Profesionaltiempocita( byte value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionaltiempocita = value ;
   }

   public String getgxTv_SdtSDTImportMedicoError_Profesionaldireccion( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionaldireccion ;
   }

   public void setgxTv_SdtSDTImportMedicoError_Profesionaldireccion( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionaldireccion = value ;
   }

   public short getgxTv_SdtSDTImportMedicoError_Paisid( )
   {
      return gxTv_SdtSDTImportMedicoError_Paisid ;
   }

   public void setgxTv_SdtSDTImportMedicoError_Paisid( short value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Paisid = value ;
   }

   public String getgxTv_SdtSDTImportMedicoError_Paisdescripcion( )
   {
      return gxTv_SdtSDTImportMedicoError_Paisdescripcion ;
   }

   public void setgxTv_SdtSDTImportMedicoError_Paisdescripcion( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Paisdescripcion = value ;
   }

   public String getgxTv_SdtSDTImportMedicoError_Ubigeocode( )
   {
      return gxTv_SdtSDTImportMedicoError_Ubigeocode ;
   }

   public void setgxTv_SdtSDTImportMedicoError_Ubigeocode( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Ubigeocode = value ;
   }

   public String getgxTv_SdtSDTImportMedicoError_Ubigeonombre( )
   {
      return gxTv_SdtSDTImportMedicoError_Ubigeonombre ;
   }

   public void setgxTv_SdtSDTImportMedicoError_Ubigeonombre( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Ubigeonombre = value ;
   }

   @GxUpload
   public String getgxTv_SdtSDTImportMedicoError_Profesionalfoto( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionalfoto ;
   }

   public void setgxTv_SdtSDTImportMedicoError_Profesionalfoto( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionalfoto = value ;
   }

   public String getgxTv_SdtSDTImportMedicoError_Profesionalfoto_gxi( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionalfoto_gxi ;
   }

   public void setgxTv_SdtSDTImportMedicoError_Profesionalfoto_gxi( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionalfoto_gxi = value ;
   }

   public String getgxTv_SdtSDTImportMedicoError_Profesionaltelefono( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionaltelefono ;
   }

   public void setgxTv_SdtSDTImportMedicoError_Profesionaltelefono( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionaltelefono = value ;
   }

   public short getgxTv_SdtSDTImportMedicoError_Secuserid( )
   {
      return gxTv_SdtSDTImportMedicoError_Secuserid ;
   }

   public void setgxTv_SdtSDTImportMedicoError_Secuserid( short value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Secuserid = value ;
   }

   public java.util.Date getgxTv_SdtSDTImportMedicoError_Profesionalfecharegistro( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionalfecharegistro ;
   }

   public void setgxTv_SdtSDTImportMedicoError_Profesionalfecharegistro( java.util.Date value )
   {
      gxTv_SdtSDTImportMedicoError_Profesionalfecharegistro_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionalfecharegistro = value ;
   }

   public boolean getgxTv_SdtSDTImportMedicoError_Profesionalterminoscondiciones( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionalterminoscondiciones ;
   }

   public void setgxTv_SdtSDTImportMedicoError_Profesionalterminoscondiciones( boolean value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionalterminoscondiciones = value ;
   }

   public String getgxTv_SdtSDTImportMedicoError_Profesionalestadocuenta( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionalestadocuenta ;
   }

   public void setgxTv_SdtSDTImportMedicoError_Profesionalestadocuenta( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionalestadocuenta = value ;
   }

   public String getgxTv_SdtSDTImportMedicoError_Profesionalestado( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionalestado ;
   }

   public void setgxTv_SdtSDTImportMedicoError_Profesionalestado( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionalestado = value ;
   }

   public String getgxTv_SdtSDTImportMedicoError_Estadoimport( )
   {
      return gxTv_SdtSDTImportMedicoError_Estadoimport ;
   }

   public void setgxTv_SdtSDTImportMedicoError_Estadoimport( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Estadoimport = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(1) ;
      gxTv_SdtSDTImportMedicoError_Profesionaltipodocumento = "" ;
      gxTv_SdtSDTImportMedicoError_Profesionalnrodocumento = "" ;
      gxTv_SdtSDTImportMedicoError_Profesionalapellidopaterno = "" ;
      gxTv_SdtSDTImportMedicoError_Profesionalapellidomaterno = "" ;
      gxTv_SdtSDTImportMedicoError_Profesionalnombres = "" ;
      gxTv_SdtSDTImportMedicoError_Profesionalnombrecompleto2 = "" ;
      gxTv_SdtSDTImportMedicoError_Profesionalfechanacimiento = GXutil.nullDate() ;
      gxTv_SdtSDTImportMedicoError_Profesionalfechanacimiento_N = (byte)(1) ;
      gxTv_SdtSDTImportMedicoError_Profesionalsexo = "" ;
      gxTv_SdtSDTImportMedicoError_Profesionaldescripcion = "" ;
      gxTv_SdtSDTImportMedicoError_Profesionalcorreo = "" ;
      gxTv_SdtSDTImportMedicoError_Profesionalcop = "" ;
      gxTv_SdtSDTImportMedicoError_Profesionalcolordisponible = "" ;
      gxTv_SdtSDTImportMedicoError_Profesionalcolorcita = "" ;
      gxTv_SdtSDTImportMedicoError_Profesionaltiempocita = (byte)(30) ;
      gxTv_SdtSDTImportMedicoError_Profesionaldireccion = "" ;
      gxTv_SdtSDTImportMedicoError_Paisdescripcion = "" ;
      gxTv_SdtSDTImportMedicoError_Ubigeocode = "" ;
      gxTv_SdtSDTImportMedicoError_Ubigeonombre = "" ;
      gxTv_SdtSDTImportMedicoError_Profesionalfoto = "" ;
      gxTv_SdtSDTImportMedicoError_Profesionalfoto_gxi = "" ;
      gxTv_SdtSDTImportMedicoError_Profesionaltelefono = "" ;
      gxTv_SdtSDTImportMedicoError_Profesionalfecharegistro = GXutil.nullDate() ;
      gxTv_SdtSDTImportMedicoError_Profesionalfecharegistro_N = (byte)(1) ;
      gxTv_SdtSDTImportMedicoError_Profesionalestadocuenta = "" ;
      gxTv_SdtSDTImportMedicoError_Profesionalestado = "" ;
      gxTv_SdtSDTImportMedicoError_Estadoimport = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTImportMedicoError_N ;
   }

   public com.projectthani.SdtSDTImportMedicoError Clone( )
   {
      return (com.projectthani.SdtSDTImportMedicoError)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTImportMedicoError struct )
   {
      setgxTv_SdtSDTImportMedicoError_Profesionalid(struct.getProfesionalid());
      setgxTv_SdtSDTImportMedicoError_Profesionaltipodocumento(struct.getProfesionaltipodocumento());
      setgxTv_SdtSDTImportMedicoError_Profesionalnrodocumento(struct.getProfesionalnrodocumento());
      setgxTv_SdtSDTImportMedicoError_Profesionalapellidopaterno(struct.getProfesionalapellidopaterno());
      setgxTv_SdtSDTImportMedicoError_Profesionalapellidomaterno(struct.getProfesionalapellidomaterno());
      setgxTv_SdtSDTImportMedicoError_Profesionalnombres(struct.getProfesionalnombres());
      setgxTv_SdtSDTImportMedicoError_Profesionalnombrecompleto2(struct.getProfesionalnombrecompleto2());
      if ( struct.gxTv_SdtSDTImportMedicoError_Profesionalfechanacimiento_N == 0 )
      {
         setgxTv_SdtSDTImportMedicoError_Profesionalfechanacimiento(struct.getProfesionalfechanacimiento());
      }
      setgxTv_SdtSDTImportMedicoError_Profesionalsexo(struct.getProfesionalsexo());
      setgxTv_SdtSDTImportMedicoError_Profesionaldescripcion(struct.getProfesionaldescripcion());
      setgxTv_SdtSDTImportMedicoError_Profesionalcorreo(struct.getProfesionalcorreo());
      setgxTv_SdtSDTImportMedicoError_Profesionalcop(struct.getProfesionalcop());
      setgxTv_SdtSDTImportMedicoError_Profesionalcolordisponible(struct.getProfesionalcolordisponible());
      setgxTv_SdtSDTImportMedicoError_Profesionalcolorcita(struct.getProfesionalcolorcita());
      setgxTv_SdtSDTImportMedicoError_Profesionaltiempocita(struct.getProfesionaltiempocita());
      setgxTv_SdtSDTImportMedicoError_Profesionaldireccion(struct.getProfesionaldireccion());
      setgxTv_SdtSDTImportMedicoError_Paisid(struct.getPaisid());
      setgxTv_SdtSDTImportMedicoError_Paisdescripcion(struct.getPaisdescripcion());
      setgxTv_SdtSDTImportMedicoError_Ubigeocode(struct.getUbigeocode());
      setgxTv_SdtSDTImportMedicoError_Ubigeonombre(struct.getUbigeonombre());
      setgxTv_SdtSDTImportMedicoError_Profesionalfoto(struct.getProfesionalfoto());
      setgxTv_SdtSDTImportMedicoError_Profesionalfoto_gxi(struct.getProfesionalfoto_gxi());
      setgxTv_SdtSDTImportMedicoError_Profesionaltelefono(struct.getProfesionaltelefono());
      setgxTv_SdtSDTImportMedicoError_Secuserid(struct.getSecuserid());
      if ( struct.gxTv_SdtSDTImportMedicoError_Profesionalfecharegistro_N == 0 )
      {
         setgxTv_SdtSDTImportMedicoError_Profesionalfecharegistro(struct.getProfesionalfecharegistro());
      }
      setgxTv_SdtSDTImportMedicoError_Profesionalterminoscondiciones(struct.getProfesionalterminoscondiciones());
      setgxTv_SdtSDTImportMedicoError_Profesionalestadocuenta(struct.getProfesionalestadocuenta());
      setgxTv_SdtSDTImportMedicoError_Profesionalestado(struct.getProfesionalestado());
      setgxTv_SdtSDTImportMedicoError_Estadoimport(struct.getEstadoimport());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTImportMedicoError getStruct( )
   {
      com.projectthani.StructSdtSDTImportMedicoError struct = new com.projectthani.StructSdtSDTImportMedicoError ();
      struct.setProfesionalid(getgxTv_SdtSDTImportMedicoError_Profesionalid());
      struct.setProfesionaltipodocumento(getgxTv_SdtSDTImportMedicoError_Profesionaltipodocumento());
      struct.setProfesionalnrodocumento(getgxTv_SdtSDTImportMedicoError_Profesionalnrodocumento());
      struct.setProfesionalapellidopaterno(getgxTv_SdtSDTImportMedicoError_Profesionalapellidopaterno());
      struct.setProfesionalapellidomaterno(getgxTv_SdtSDTImportMedicoError_Profesionalapellidomaterno());
      struct.setProfesionalnombres(getgxTv_SdtSDTImportMedicoError_Profesionalnombres());
      struct.setProfesionalnombrecompleto2(getgxTv_SdtSDTImportMedicoError_Profesionalnombrecompleto2());
      if ( gxTv_SdtSDTImportMedicoError_Profesionalfechanacimiento_N == 0 )
      {
         struct.setProfesionalfechanacimiento(getgxTv_SdtSDTImportMedicoError_Profesionalfechanacimiento());
      }
      struct.setProfesionalsexo(getgxTv_SdtSDTImportMedicoError_Profesionalsexo());
      struct.setProfesionaldescripcion(getgxTv_SdtSDTImportMedicoError_Profesionaldescripcion());
      struct.setProfesionalcorreo(getgxTv_SdtSDTImportMedicoError_Profesionalcorreo());
      struct.setProfesionalcop(getgxTv_SdtSDTImportMedicoError_Profesionalcop());
      struct.setProfesionalcolordisponible(getgxTv_SdtSDTImportMedicoError_Profesionalcolordisponible());
      struct.setProfesionalcolorcita(getgxTv_SdtSDTImportMedicoError_Profesionalcolorcita());
      struct.setProfesionaltiempocita(getgxTv_SdtSDTImportMedicoError_Profesionaltiempocita());
      struct.setProfesionaldireccion(getgxTv_SdtSDTImportMedicoError_Profesionaldireccion());
      struct.setPaisid(getgxTv_SdtSDTImportMedicoError_Paisid());
      struct.setPaisdescripcion(getgxTv_SdtSDTImportMedicoError_Paisdescripcion());
      struct.setUbigeocode(getgxTv_SdtSDTImportMedicoError_Ubigeocode());
      struct.setUbigeonombre(getgxTv_SdtSDTImportMedicoError_Ubigeonombre());
      struct.setProfesionalfoto(getgxTv_SdtSDTImportMedicoError_Profesionalfoto());
      struct.setProfesionalfoto_gxi(getgxTv_SdtSDTImportMedicoError_Profesionalfoto_gxi());
      struct.setProfesionaltelefono(getgxTv_SdtSDTImportMedicoError_Profesionaltelefono());
      struct.setSecuserid(getgxTv_SdtSDTImportMedicoError_Secuserid());
      if ( gxTv_SdtSDTImportMedicoError_Profesionalfecharegistro_N == 0 )
      {
         struct.setProfesionalfecharegistro(getgxTv_SdtSDTImportMedicoError_Profesionalfecharegistro());
      }
      struct.setProfesionalterminoscondiciones(getgxTv_SdtSDTImportMedicoError_Profesionalterminoscondiciones());
      struct.setProfesionalestadocuenta(getgxTv_SdtSDTImportMedicoError_Profesionalestadocuenta());
      struct.setProfesionalestado(getgxTv_SdtSDTImportMedicoError_Profesionalestado());
      struct.setEstadoimport(getgxTv_SdtSDTImportMedicoError_Estadoimport());
      return struct ;
   }

   protected byte gxTv_SdtSDTImportMedicoError_N ;
   protected byte gxTv_SdtSDTImportMedicoError_Profesionalfechanacimiento_N ;
   protected byte gxTv_SdtSDTImportMedicoError_Profesionaltiempocita ;
   protected byte gxTv_SdtSDTImportMedicoError_Profesionalfecharegistro_N ;
   protected short gxTv_SdtSDTImportMedicoError_Paisid ;
   protected short gxTv_SdtSDTImportMedicoError_Secuserid ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_SdtSDTImportMedicoError_Profesionalid ;
   protected String gxTv_SdtSDTImportMedicoError_Profesionaltipodocumento ;
   protected String gxTv_SdtSDTImportMedicoError_Profesionalsexo ;
   protected String gxTv_SdtSDTImportMedicoError_Profesionalcolordisponible ;
   protected String gxTv_SdtSDTImportMedicoError_Profesionalcolorcita ;
   protected String gxTv_SdtSDTImportMedicoError_Ubigeocode ;
   protected String gxTv_SdtSDTImportMedicoError_Profesionaltelefono ;
   protected String gxTv_SdtSDTImportMedicoError_Profesionalestadocuenta ;
   protected String gxTv_SdtSDTImportMedicoError_Profesionalestado ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_SdtSDTImportMedicoError_Profesionalfechanacimiento ;
   protected java.util.Date gxTv_SdtSDTImportMedicoError_Profesionalfecharegistro ;
   protected boolean gxTv_SdtSDTImportMedicoError_Profesionalterminoscondiciones ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTImportMedicoError_Profesionalnrodocumento ;
   protected String gxTv_SdtSDTImportMedicoError_Profesionalapellidopaterno ;
   protected String gxTv_SdtSDTImportMedicoError_Profesionalapellidomaterno ;
   protected String gxTv_SdtSDTImportMedicoError_Profesionalnombres ;
   protected String gxTv_SdtSDTImportMedicoError_Profesionalnombrecompleto2 ;
   protected String gxTv_SdtSDTImportMedicoError_Profesionaldescripcion ;
   protected String gxTv_SdtSDTImportMedicoError_Profesionalcorreo ;
   protected String gxTv_SdtSDTImportMedicoError_Profesionalcop ;
   protected String gxTv_SdtSDTImportMedicoError_Profesionaldireccion ;
   protected String gxTv_SdtSDTImportMedicoError_Paisdescripcion ;
   protected String gxTv_SdtSDTImportMedicoError_Ubigeonombre ;
   protected String gxTv_SdtSDTImportMedicoError_Profesionalfoto_gxi ;
   protected String gxTv_SdtSDTImportMedicoError_Estadoimport ;
   protected String gxTv_SdtSDTImportMedicoError_Profesionalfoto ;
}

