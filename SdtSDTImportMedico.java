package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTImportMedico extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTImportMedico( )
   {
      this(  new ModelContext(SdtSDTImportMedico.class));
   }

   public SdtSDTImportMedico( ModelContext context )
   {
      super( context, "SdtSDTImportMedico");
   }

   public SdtSDTImportMedico( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTImportMedico");
   }

   public SdtSDTImportMedico( StructSdtSDTImportMedico struct )
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
               gxTv_SdtSDTImportMedico_Profesionalid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalTipoDocumento") )
            {
               gxTv_SdtSDTImportMedico_Profesionaltipodocumento = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalNroDocumento") )
            {
               gxTv_SdtSDTImportMedico_Profesionalnrodocumento = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalApellidoPaterno") )
            {
               gxTv_SdtSDTImportMedico_Profesionalapellidopaterno = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalApellidoMaterno") )
            {
               gxTv_SdtSDTImportMedico_Profesionalapellidomaterno = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalNombres") )
            {
               gxTv_SdtSDTImportMedico_Profesionalnombres = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalNombreCompleto2") )
            {
               gxTv_SdtSDTImportMedico_Profesionalnombrecompleto2 = oReader.getValue() ;
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
                  gxTv_SdtSDTImportMedico_Profesionalfechanacimiento = GXutil.nullDate() ;
                  gxTv_SdtSDTImportMedico_Profesionalfechanacimiento_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtSDTImportMedico_Profesionalfechanacimiento_N = (byte)(0) ;
                  gxTv_SdtSDTImportMedico_Profesionalfechanacimiento = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
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
               gxTv_SdtSDTImportMedico_Profesionalsexo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalDescripcion") )
            {
               gxTv_SdtSDTImportMedico_Profesionaldescripcion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalCorreo") )
            {
               gxTv_SdtSDTImportMedico_Profesionalcorreo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalCOP") )
            {
               gxTv_SdtSDTImportMedico_Profesionalcop = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalColorDisponible") )
            {
               gxTv_SdtSDTImportMedico_Profesionalcolordisponible = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalColorCita") )
            {
               gxTv_SdtSDTImportMedico_Profesionalcolorcita = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalTiempoCita") )
            {
               gxTv_SdtSDTImportMedico_Profesionaltiempocita = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalDireccion") )
            {
               gxTv_SdtSDTImportMedico_Profesionaldireccion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaisId") )
            {
               gxTv_SdtSDTImportMedico_Paisid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaisDescripcion") )
            {
               gxTv_SdtSDTImportMedico_Paisdescripcion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "UbigeoCode") )
            {
               gxTv_SdtSDTImportMedico_Ubigeocode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "UbigeoNombre") )
            {
               gxTv_SdtSDTImportMedico_Ubigeonombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalFoto") )
            {
               gxTv_SdtSDTImportMedico_Profesionalfoto = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalFoto_GXI") )
            {
               gxTv_SdtSDTImportMedico_Profesionalfoto_gxi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalTelefono") )
            {
               gxTv_SdtSDTImportMedico_Profesionaltelefono = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserId") )
            {
               gxTv_SdtSDTImportMedico_Secuserid = (short)(getnumericvalue(oReader.getValue())) ;
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
                  gxTv_SdtSDTImportMedico_Profesionalfecharegistro = GXutil.nullDate() ;
                  gxTv_SdtSDTImportMedico_Profesionalfecharegistro_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtSDTImportMedico_Profesionalfecharegistro_N = (byte)(0) ;
                  gxTv_SdtSDTImportMedico_Profesionalfecharegistro = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
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
               gxTv_SdtSDTImportMedico_Profesionalterminoscondiciones = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalEstadoCuenta") )
            {
               gxTv_SdtSDTImportMedico_Profesionalestadocuenta = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalEstado") )
            {
               gxTv_SdtSDTImportMedico_Profesionalestado = oReader.getValue() ;
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
         sName = "SDTImportMedico" ;
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
      oWriter.writeElement("ProfesionalId", GXutil.trim( GXutil.str( gxTv_SdtSDTImportMedico_Profesionalid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalTipoDocumento", GXutil.rtrim( gxTv_SdtSDTImportMedico_Profesionaltipodocumento));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalNroDocumento", GXutil.rtrim( gxTv_SdtSDTImportMedico_Profesionalnrodocumento));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalApellidoPaterno", GXutil.rtrim( gxTv_SdtSDTImportMedico_Profesionalapellidopaterno));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalApellidoMaterno", GXutil.rtrim( gxTv_SdtSDTImportMedico_Profesionalapellidomaterno));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalNombres", GXutil.rtrim( gxTv_SdtSDTImportMedico_Profesionalnombres));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalNombreCompleto2", GXutil.rtrim( gxTv_SdtSDTImportMedico_Profesionalnombrecompleto2));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_SdtSDTImportMedico_Profesionalfechanacimiento)) && ( gxTv_SdtSDTImportMedico_Profesionalfechanacimiento_N == 1 ) )
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
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTImportMedico_Profesionalfechanacimiento), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTImportMedico_Profesionalfechanacimiento), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTImportMedico_Profesionalfechanacimiento), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("ProfesionalFechaNacimiento", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      oWriter.writeElement("ProfesionalSexo", GXutil.rtrim( gxTv_SdtSDTImportMedico_Profesionalsexo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalDescripcion", GXutil.rtrim( gxTv_SdtSDTImportMedico_Profesionaldescripcion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalCorreo", GXutil.rtrim( gxTv_SdtSDTImportMedico_Profesionalcorreo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalCOP", GXutil.rtrim( gxTv_SdtSDTImportMedico_Profesionalcop));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalColorDisponible", GXutil.rtrim( gxTv_SdtSDTImportMedico_Profesionalcolordisponible));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalColorCita", GXutil.rtrim( gxTv_SdtSDTImportMedico_Profesionalcolorcita));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalTiempoCita", GXutil.trim( GXutil.str( gxTv_SdtSDTImportMedico_Profesionaltiempocita, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalDireccion", GXutil.rtrim( gxTv_SdtSDTImportMedico_Profesionaldireccion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PaisId", GXutil.trim( GXutil.str( gxTv_SdtSDTImportMedico_Paisid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PaisDescripcion", GXutil.rtrim( gxTv_SdtSDTImportMedico_Paisdescripcion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("UbigeoCode", GXutil.rtrim( gxTv_SdtSDTImportMedico_Ubigeocode));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("UbigeoNombre", GXutil.rtrim( gxTv_SdtSDTImportMedico_Ubigeonombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalFoto", GXutil.rtrim( gxTv_SdtSDTImportMedico_Profesionalfoto));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalFoto_GXI", GXutil.rtrim( gxTv_SdtSDTImportMedico_Profesionalfoto_gxi));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalTelefono", GXutil.rtrim( gxTv_SdtSDTImportMedico_Profesionaltelefono));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SecUserId", GXutil.trim( GXutil.str( gxTv_SdtSDTImportMedico_Secuserid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_SdtSDTImportMedico_Profesionalfecharegistro)) && ( gxTv_SdtSDTImportMedico_Profesionalfecharegistro_N == 1 ) )
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
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTImportMedico_Profesionalfecharegistro), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTImportMedico_Profesionalfecharegistro), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTImportMedico_Profesionalfecharegistro), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("ProfesionalFechaRegistro", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      oWriter.writeElement("ProfesionalTerminosCondiciones", GXutil.rtrim( GXutil.booltostr( gxTv_SdtSDTImportMedico_Profesionalterminoscondiciones)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalEstadoCuenta", GXutil.rtrim( gxTv_SdtSDTImportMedico_Profesionalestadocuenta));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalEstado", GXutil.rtrim( gxTv_SdtSDTImportMedico_Profesionalestado));
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
      AddObjectProperty("ProfesionalId", gxTv_SdtSDTImportMedico_Profesionalid, false, false);
      AddObjectProperty("ProfesionalTipoDocumento", gxTv_SdtSDTImportMedico_Profesionaltipodocumento, false, false);
      AddObjectProperty("ProfesionalNroDocumento", gxTv_SdtSDTImportMedico_Profesionalnrodocumento, false, false);
      AddObjectProperty("ProfesionalApellidoPaterno", gxTv_SdtSDTImportMedico_Profesionalapellidopaterno, false, false);
      AddObjectProperty("ProfesionalApellidoMaterno", gxTv_SdtSDTImportMedico_Profesionalapellidomaterno, false, false);
      AddObjectProperty("ProfesionalNombres", gxTv_SdtSDTImportMedico_Profesionalnombres, false, false);
      AddObjectProperty("ProfesionalNombreCompleto2", gxTv_SdtSDTImportMedico_Profesionalnombrecompleto2, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTImportMedico_Profesionalfechanacimiento), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTImportMedico_Profesionalfechanacimiento), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTImportMedico_Profesionalfechanacimiento), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("ProfesionalFechaNacimiento", sDateCnv, false, false);
      AddObjectProperty("ProfesionalSexo", gxTv_SdtSDTImportMedico_Profesionalsexo, false, false);
      AddObjectProperty("ProfesionalDescripcion", gxTv_SdtSDTImportMedico_Profesionaldescripcion, false, false);
      AddObjectProperty("ProfesionalCorreo", gxTv_SdtSDTImportMedico_Profesionalcorreo, false, false);
      AddObjectProperty("ProfesionalCOP", gxTv_SdtSDTImportMedico_Profesionalcop, false, false);
      AddObjectProperty("ProfesionalColorDisponible", gxTv_SdtSDTImportMedico_Profesionalcolordisponible, false, false);
      AddObjectProperty("ProfesionalColorCita", gxTv_SdtSDTImportMedico_Profesionalcolorcita, false, false);
      AddObjectProperty("ProfesionalTiempoCita", gxTv_SdtSDTImportMedico_Profesionaltiempocita, false, false);
      AddObjectProperty("ProfesionalDireccion", gxTv_SdtSDTImportMedico_Profesionaldireccion, false, false);
      AddObjectProperty("PaisId", gxTv_SdtSDTImportMedico_Paisid, false, false);
      AddObjectProperty("PaisDescripcion", gxTv_SdtSDTImportMedico_Paisdescripcion, false, false);
      AddObjectProperty("UbigeoCode", gxTv_SdtSDTImportMedico_Ubigeocode, false, false);
      AddObjectProperty("UbigeoNombre", gxTv_SdtSDTImportMedico_Ubigeonombre, false, false);
      AddObjectProperty("ProfesionalFoto", gxTv_SdtSDTImportMedico_Profesionalfoto, false, false);
      AddObjectProperty("ProfesionalFoto_GXI", gxTv_SdtSDTImportMedico_Profesionalfoto_gxi, false, false);
      AddObjectProperty("ProfesionalTelefono", gxTv_SdtSDTImportMedico_Profesionaltelefono, false, false);
      AddObjectProperty("SecUserId", gxTv_SdtSDTImportMedico_Secuserid, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTImportMedico_Profesionalfecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTImportMedico_Profesionalfecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTImportMedico_Profesionalfecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("ProfesionalFechaRegistro", sDateCnv, false, false);
      AddObjectProperty("ProfesionalTerminosCondiciones", gxTv_SdtSDTImportMedico_Profesionalterminoscondiciones, false, false);
      AddObjectProperty("ProfesionalEstadoCuenta", gxTv_SdtSDTImportMedico_Profesionalestadocuenta, false, false);
      AddObjectProperty("ProfesionalEstado", gxTv_SdtSDTImportMedico_Profesionalestado, false, false);
   }

   public int getgxTv_SdtSDTImportMedico_Profesionalid( )
   {
      return gxTv_SdtSDTImportMedico_Profesionalid ;
   }

   public void setgxTv_SdtSDTImportMedico_Profesionalid( int value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionalid = value ;
   }

   public String getgxTv_SdtSDTImportMedico_Profesionaltipodocumento( )
   {
      return gxTv_SdtSDTImportMedico_Profesionaltipodocumento ;
   }

   public void setgxTv_SdtSDTImportMedico_Profesionaltipodocumento( String value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionaltipodocumento = value ;
   }

   public String getgxTv_SdtSDTImportMedico_Profesionalnrodocumento( )
   {
      return gxTv_SdtSDTImportMedico_Profesionalnrodocumento ;
   }

   public void setgxTv_SdtSDTImportMedico_Profesionalnrodocumento( String value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionalnrodocumento = value ;
   }

   public String getgxTv_SdtSDTImportMedico_Profesionalapellidopaterno( )
   {
      return gxTv_SdtSDTImportMedico_Profesionalapellidopaterno ;
   }

   public void setgxTv_SdtSDTImportMedico_Profesionalapellidopaterno( String value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionalapellidopaterno = value ;
   }

   public String getgxTv_SdtSDTImportMedico_Profesionalapellidomaterno( )
   {
      return gxTv_SdtSDTImportMedico_Profesionalapellidomaterno ;
   }

   public void setgxTv_SdtSDTImportMedico_Profesionalapellidomaterno( String value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionalapellidomaterno = value ;
   }

   public String getgxTv_SdtSDTImportMedico_Profesionalnombres( )
   {
      return gxTv_SdtSDTImportMedico_Profesionalnombres ;
   }

   public void setgxTv_SdtSDTImportMedico_Profesionalnombres( String value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionalnombres = value ;
   }

   public String getgxTv_SdtSDTImportMedico_Profesionalnombrecompleto2( )
   {
      return gxTv_SdtSDTImportMedico_Profesionalnombrecompleto2 ;
   }

   public void setgxTv_SdtSDTImportMedico_Profesionalnombrecompleto2( String value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionalnombrecompleto2 = value ;
   }

   public java.util.Date getgxTv_SdtSDTImportMedico_Profesionalfechanacimiento( )
   {
      return gxTv_SdtSDTImportMedico_Profesionalfechanacimiento ;
   }

   public void setgxTv_SdtSDTImportMedico_Profesionalfechanacimiento( java.util.Date value )
   {
      gxTv_SdtSDTImportMedico_Profesionalfechanacimiento_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionalfechanacimiento = value ;
   }

   public String getgxTv_SdtSDTImportMedico_Profesionalsexo( )
   {
      return gxTv_SdtSDTImportMedico_Profesionalsexo ;
   }

   public void setgxTv_SdtSDTImportMedico_Profesionalsexo( String value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionalsexo = value ;
   }

   public String getgxTv_SdtSDTImportMedico_Profesionaldescripcion( )
   {
      return gxTv_SdtSDTImportMedico_Profesionaldescripcion ;
   }

   public void setgxTv_SdtSDTImportMedico_Profesionaldescripcion( String value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionaldescripcion = value ;
   }

   public String getgxTv_SdtSDTImportMedico_Profesionalcorreo( )
   {
      return gxTv_SdtSDTImportMedico_Profesionalcorreo ;
   }

   public void setgxTv_SdtSDTImportMedico_Profesionalcorreo( String value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionalcorreo = value ;
   }

   public String getgxTv_SdtSDTImportMedico_Profesionalcop( )
   {
      return gxTv_SdtSDTImportMedico_Profesionalcop ;
   }

   public void setgxTv_SdtSDTImportMedico_Profesionalcop( String value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionalcop = value ;
   }

   public String getgxTv_SdtSDTImportMedico_Profesionalcolordisponible( )
   {
      return gxTv_SdtSDTImportMedico_Profesionalcolordisponible ;
   }

   public void setgxTv_SdtSDTImportMedico_Profesionalcolordisponible( String value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionalcolordisponible = value ;
   }

   public String getgxTv_SdtSDTImportMedico_Profesionalcolorcita( )
   {
      return gxTv_SdtSDTImportMedico_Profesionalcolorcita ;
   }

   public void setgxTv_SdtSDTImportMedico_Profesionalcolorcita( String value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionalcolorcita = value ;
   }

   public byte getgxTv_SdtSDTImportMedico_Profesionaltiempocita( )
   {
      return gxTv_SdtSDTImportMedico_Profesionaltiempocita ;
   }

   public void setgxTv_SdtSDTImportMedico_Profesionaltiempocita( byte value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionaltiempocita = value ;
   }

   public String getgxTv_SdtSDTImportMedico_Profesionaldireccion( )
   {
      return gxTv_SdtSDTImportMedico_Profesionaldireccion ;
   }

   public void setgxTv_SdtSDTImportMedico_Profesionaldireccion( String value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionaldireccion = value ;
   }

   public short getgxTv_SdtSDTImportMedico_Paisid( )
   {
      return gxTv_SdtSDTImportMedico_Paisid ;
   }

   public void setgxTv_SdtSDTImportMedico_Paisid( short value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Paisid = value ;
   }

   public String getgxTv_SdtSDTImportMedico_Paisdescripcion( )
   {
      return gxTv_SdtSDTImportMedico_Paisdescripcion ;
   }

   public void setgxTv_SdtSDTImportMedico_Paisdescripcion( String value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Paisdescripcion = value ;
   }

   public String getgxTv_SdtSDTImportMedico_Ubigeocode( )
   {
      return gxTv_SdtSDTImportMedico_Ubigeocode ;
   }

   public void setgxTv_SdtSDTImportMedico_Ubigeocode( String value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Ubigeocode = value ;
   }

   public String getgxTv_SdtSDTImportMedico_Ubigeonombre( )
   {
      return gxTv_SdtSDTImportMedico_Ubigeonombre ;
   }

   public void setgxTv_SdtSDTImportMedico_Ubigeonombre( String value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Ubigeonombre = value ;
   }

   @GxUpload
   public String getgxTv_SdtSDTImportMedico_Profesionalfoto( )
   {
      return gxTv_SdtSDTImportMedico_Profesionalfoto ;
   }

   public void setgxTv_SdtSDTImportMedico_Profesionalfoto( String value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionalfoto = value ;
   }

   public String getgxTv_SdtSDTImportMedico_Profesionalfoto_gxi( )
   {
      return gxTv_SdtSDTImportMedico_Profesionalfoto_gxi ;
   }

   public void setgxTv_SdtSDTImportMedico_Profesionalfoto_gxi( String value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionalfoto_gxi = value ;
   }

   public String getgxTv_SdtSDTImportMedico_Profesionaltelefono( )
   {
      return gxTv_SdtSDTImportMedico_Profesionaltelefono ;
   }

   public void setgxTv_SdtSDTImportMedico_Profesionaltelefono( String value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionaltelefono = value ;
   }

   public short getgxTv_SdtSDTImportMedico_Secuserid( )
   {
      return gxTv_SdtSDTImportMedico_Secuserid ;
   }

   public void setgxTv_SdtSDTImportMedico_Secuserid( short value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Secuserid = value ;
   }

   public java.util.Date getgxTv_SdtSDTImportMedico_Profesionalfecharegistro( )
   {
      return gxTv_SdtSDTImportMedico_Profesionalfecharegistro ;
   }

   public void setgxTv_SdtSDTImportMedico_Profesionalfecharegistro( java.util.Date value )
   {
      gxTv_SdtSDTImportMedico_Profesionalfecharegistro_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionalfecharegistro = value ;
   }

   public boolean getgxTv_SdtSDTImportMedico_Profesionalterminoscondiciones( )
   {
      return gxTv_SdtSDTImportMedico_Profesionalterminoscondiciones ;
   }

   public void setgxTv_SdtSDTImportMedico_Profesionalterminoscondiciones( boolean value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionalterminoscondiciones = value ;
   }

   public String getgxTv_SdtSDTImportMedico_Profesionalestadocuenta( )
   {
      return gxTv_SdtSDTImportMedico_Profesionalestadocuenta ;
   }

   public void setgxTv_SdtSDTImportMedico_Profesionalestadocuenta( String value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionalestadocuenta = value ;
   }

   public String getgxTv_SdtSDTImportMedico_Profesionalestado( )
   {
      return gxTv_SdtSDTImportMedico_Profesionalestado ;
   }

   public void setgxTv_SdtSDTImportMedico_Profesionalestado( String value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionalestado = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(1) ;
      gxTv_SdtSDTImportMedico_Profesionaltipodocumento = "" ;
      gxTv_SdtSDTImportMedico_Profesionalnrodocumento = "" ;
      gxTv_SdtSDTImportMedico_Profesionalapellidopaterno = "" ;
      gxTv_SdtSDTImportMedico_Profesionalapellidomaterno = "" ;
      gxTv_SdtSDTImportMedico_Profesionalnombres = "" ;
      gxTv_SdtSDTImportMedico_Profesionalnombrecompleto2 = "" ;
      gxTv_SdtSDTImportMedico_Profesionalfechanacimiento = GXutil.nullDate() ;
      gxTv_SdtSDTImportMedico_Profesionalfechanacimiento_N = (byte)(1) ;
      gxTv_SdtSDTImportMedico_Profesionalsexo = "" ;
      gxTv_SdtSDTImportMedico_Profesionaldescripcion = "" ;
      gxTv_SdtSDTImportMedico_Profesionalcorreo = "" ;
      gxTv_SdtSDTImportMedico_Profesionalcop = "" ;
      gxTv_SdtSDTImportMedico_Profesionalcolordisponible = "" ;
      gxTv_SdtSDTImportMedico_Profesionalcolorcita = "" ;
      gxTv_SdtSDTImportMedico_Profesionaltiempocita = (byte)(30) ;
      gxTv_SdtSDTImportMedico_Profesionaldireccion = "" ;
      gxTv_SdtSDTImportMedico_Paisdescripcion = "" ;
      gxTv_SdtSDTImportMedico_Ubigeocode = "" ;
      gxTv_SdtSDTImportMedico_Ubigeonombre = "" ;
      gxTv_SdtSDTImportMedico_Profesionalfoto = "" ;
      gxTv_SdtSDTImportMedico_Profesionalfoto_gxi = "" ;
      gxTv_SdtSDTImportMedico_Profesionaltelefono = "" ;
      gxTv_SdtSDTImportMedico_Profesionalfecharegistro = GXutil.nullDate() ;
      gxTv_SdtSDTImportMedico_Profesionalfecharegistro_N = (byte)(1) ;
      gxTv_SdtSDTImportMedico_Profesionalestadocuenta = "" ;
      gxTv_SdtSDTImportMedico_Profesionalestado = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTImportMedico_N ;
   }

   public com.projectthani.SdtSDTImportMedico Clone( )
   {
      return (com.projectthani.SdtSDTImportMedico)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTImportMedico struct )
   {
      setgxTv_SdtSDTImportMedico_Profesionalid(struct.getProfesionalid());
      setgxTv_SdtSDTImportMedico_Profesionaltipodocumento(struct.getProfesionaltipodocumento());
      setgxTv_SdtSDTImportMedico_Profesionalnrodocumento(struct.getProfesionalnrodocumento());
      setgxTv_SdtSDTImportMedico_Profesionalapellidopaterno(struct.getProfesionalapellidopaterno());
      setgxTv_SdtSDTImportMedico_Profesionalapellidomaterno(struct.getProfesionalapellidomaterno());
      setgxTv_SdtSDTImportMedico_Profesionalnombres(struct.getProfesionalnombres());
      setgxTv_SdtSDTImportMedico_Profesionalnombrecompleto2(struct.getProfesionalnombrecompleto2());
      if ( struct.gxTv_SdtSDTImportMedico_Profesionalfechanacimiento_N == 0 )
      {
         setgxTv_SdtSDTImportMedico_Profesionalfechanacimiento(struct.getProfesionalfechanacimiento());
      }
      setgxTv_SdtSDTImportMedico_Profesionalsexo(struct.getProfesionalsexo());
      setgxTv_SdtSDTImportMedico_Profesionaldescripcion(struct.getProfesionaldescripcion());
      setgxTv_SdtSDTImportMedico_Profesionalcorreo(struct.getProfesionalcorreo());
      setgxTv_SdtSDTImportMedico_Profesionalcop(struct.getProfesionalcop());
      setgxTv_SdtSDTImportMedico_Profesionalcolordisponible(struct.getProfesionalcolordisponible());
      setgxTv_SdtSDTImportMedico_Profesionalcolorcita(struct.getProfesionalcolorcita());
      setgxTv_SdtSDTImportMedico_Profesionaltiempocita(struct.getProfesionaltiempocita());
      setgxTv_SdtSDTImportMedico_Profesionaldireccion(struct.getProfesionaldireccion());
      setgxTv_SdtSDTImportMedico_Paisid(struct.getPaisid());
      setgxTv_SdtSDTImportMedico_Paisdescripcion(struct.getPaisdescripcion());
      setgxTv_SdtSDTImportMedico_Ubigeocode(struct.getUbigeocode());
      setgxTv_SdtSDTImportMedico_Ubigeonombre(struct.getUbigeonombre());
      setgxTv_SdtSDTImportMedico_Profesionalfoto(struct.getProfesionalfoto());
      setgxTv_SdtSDTImportMedico_Profesionalfoto_gxi(struct.getProfesionalfoto_gxi());
      setgxTv_SdtSDTImportMedico_Profesionaltelefono(struct.getProfesionaltelefono());
      setgxTv_SdtSDTImportMedico_Secuserid(struct.getSecuserid());
      if ( struct.gxTv_SdtSDTImportMedico_Profesionalfecharegistro_N == 0 )
      {
         setgxTv_SdtSDTImportMedico_Profesionalfecharegistro(struct.getProfesionalfecharegistro());
      }
      setgxTv_SdtSDTImportMedico_Profesionalterminoscondiciones(struct.getProfesionalterminoscondiciones());
      setgxTv_SdtSDTImportMedico_Profesionalestadocuenta(struct.getProfesionalestadocuenta());
      setgxTv_SdtSDTImportMedico_Profesionalestado(struct.getProfesionalestado());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTImportMedico getStruct( )
   {
      com.projectthani.StructSdtSDTImportMedico struct = new com.projectthani.StructSdtSDTImportMedico ();
      struct.setProfesionalid(getgxTv_SdtSDTImportMedico_Profesionalid());
      struct.setProfesionaltipodocumento(getgxTv_SdtSDTImportMedico_Profesionaltipodocumento());
      struct.setProfesionalnrodocumento(getgxTv_SdtSDTImportMedico_Profesionalnrodocumento());
      struct.setProfesionalapellidopaterno(getgxTv_SdtSDTImportMedico_Profesionalapellidopaterno());
      struct.setProfesionalapellidomaterno(getgxTv_SdtSDTImportMedico_Profesionalapellidomaterno());
      struct.setProfesionalnombres(getgxTv_SdtSDTImportMedico_Profesionalnombres());
      struct.setProfesionalnombrecompleto2(getgxTv_SdtSDTImportMedico_Profesionalnombrecompleto2());
      if ( gxTv_SdtSDTImportMedico_Profesionalfechanacimiento_N == 0 )
      {
         struct.setProfesionalfechanacimiento(getgxTv_SdtSDTImportMedico_Profesionalfechanacimiento());
      }
      struct.setProfesionalsexo(getgxTv_SdtSDTImportMedico_Profesionalsexo());
      struct.setProfesionaldescripcion(getgxTv_SdtSDTImportMedico_Profesionaldescripcion());
      struct.setProfesionalcorreo(getgxTv_SdtSDTImportMedico_Profesionalcorreo());
      struct.setProfesionalcop(getgxTv_SdtSDTImportMedico_Profesionalcop());
      struct.setProfesionalcolordisponible(getgxTv_SdtSDTImportMedico_Profesionalcolordisponible());
      struct.setProfesionalcolorcita(getgxTv_SdtSDTImportMedico_Profesionalcolorcita());
      struct.setProfesionaltiempocita(getgxTv_SdtSDTImportMedico_Profesionaltiempocita());
      struct.setProfesionaldireccion(getgxTv_SdtSDTImportMedico_Profesionaldireccion());
      struct.setPaisid(getgxTv_SdtSDTImportMedico_Paisid());
      struct.setPaisdescripcion(getgxTv_SdtSDTImportMedico_Paisdescripcion());
      struct.setUbigeocode(getgxTv_SdtSDTImportMedico_Ubigeocode());
      struct.setUbigeonombre(getgxTv_SdtSDTImportMedico_Ubigeonombre());
      struct.setProfesionalfoto(getgxTv_SdtSDTImportMedico_Profesionalfoto());
      struct.setProfesionalfoto_gxi(getgxTv_SdtSDTImportMedico_Profesionalfoto_gxi());
      struct.setProfesionaltelefono(getgxTv_SdtSDTImportMedico_Profesionaltelefono());
      struct.setSecuserid(getgxTv_SdtSDTImportMedico_Secuserid());
      if ( gxTv_SdtSDTImportMedico_Profesionalfecharegistro_N == 0 )
      {
         struct.setProfesionalfecharegistro(getgxTv_SdtSDTImportMedico_Profesionalfecharegistro());
      }
      struct.setProfesionalterminoscondiciones(getgxTv_SdtSDTImportMedico_Profesionalterminoscondiciones());
      struct.setProfesionalestadocuenta(getgxTv_SdtSDTImportMedico_Profesionalestadocuenta());
      struct.setProfesionalestado(getgxTv_SdtSDTImportMedico_Profesionalestado());
      return struct ;
   }

   protected byte gxTv_SdtSDTImportMedico_N ;
   protected byte gxTv_SdtSDTImportMedico_Profesionalfechanacimiento_N ;
   protected byte gxTv_SdtSDTImportMedico_Profesionaltiempocita ;
   protected byte gxTv_SdtSDTImportMedico_Profesionalfecharegistro_N ;
   protected short gxTv_SdtSDTImportMedico_Paisid ;
   protected short gxTv_SdtSDTImportMedico_Secuserid ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_SdtSDTImportMedico_Profesionalid ;
   protected String gxTv_SdtSDTImportMedico_Profesionaltipodocumento ;
   protected String gxTv_SdtSDTImportMedico_Profesionalsexo ;
   protected String gxTv_SdtSDTImportMedico_Profesionalcolordisponible ;
   protected String gxTv_SdtSDTImportMedico_Profesionalcolorcita ;
   protected String gxTv_SdtSDTImportMedico_Ubigeocode ;
   protected String gxTv_SdtSDTImportMedico_Profesionaltelefono ;
   protected String gxTv_SdtSDTImportMedico_Profesionalestadocuenta ;
   protected String gxTv_SdtSDTImportMedico_Profesionalestado ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_SdtSDTImportMedico_Profesionalfechanacimiento ;
   protected java.util.Date gxTv_SdtSDTImportMedico_Profesionalfecharegistro ;
   protected boolean gxTv_SdtSDTImportMedico_Profesionalterminoscondiciones ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTImportMedico_Profesionalnrodocumento ;
   protected String gxTv_SdtSDTImportMedico_Profesionalapellidopaterno ;
   protected String gxTv_SdtSDTImportMedico_Profesionalapellidomaterno ;
   protected String gxTv_SdtSDTImportMedico_Profesionalnombres ;
   protected String gxTv_SdtSDTImportMedico_Profesionalnombrecompleto2 ;
   protected String gxTv_SdtSDTImportMedico_Profesionaldescripcion ;
   protected String gxTv_SdtSDTImportMedico_Profesionalcorreo ;
   protected String gxTv_SdtSDTImportMedico_Profesionalcop ;
   protected String gxTv_SdtSDTImportMedico_Profesionaldireccion ;
   protected String gxTv_SdtSDTImportMedico_Paisdescripcion ;
   protected String gxTv_SdtSDTImportMedico_Ubigeonombre ;
   protected String gxTv_SdtSDTImportMedico_Profesionalfoto_gxi ;
   protected String gxTv_SdtSDTImportMedico_Profesionalfoto ;
}

