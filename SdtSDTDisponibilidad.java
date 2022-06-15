package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTDisponibilidad extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTDisponibilidad( )
   {
      this(  new ModelContext(SdtSDTDisponibilidad.class));
   }

   public SdtSDTDisponibilidad( ModelContext context )
   {
      super( context, "SdtSDTDisponibilidad");
   }

   public SdtSDTDisponibilidad( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTDisponibilidad");
   }

   public SdtSDTDisponibilidad( StructSdtSDTDisponibilidad struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "DisponibilidadId") )
            {
               gxTv_SdtSDTDisponibilidad_Disponibilidadid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EventId") )
            {
               gxTv_SdtSDTDisponibilidad_Eventid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DisponibilidadDescription") )
            {
               gxTv_SdtSDTDisponibilidad_Disponibilidaddescription = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalId") )
            {
               gxTv_SdtSDTDisponibilidad_Profesionalid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DisponibilidadFecha") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtSDTDisponibilidad_Disponibilidadfecha = GXutil.nullDate() ;
                  gxTv_SdtSDTDisponibilidad_Disponibilidadfecha_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtSDTDisponibilidad_Disponibilidadfecha_N = (byte)(0) ;
                  gxTv_SdtSDTDisponibilidad_Disponibilidadfecha = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DisponibilidadHoraInicio") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio = GXutil.resetTime( GXutil.nullDate() );
                  gxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio_N = (byte)(0) ;
                  gxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio = GXutil.resetDate(localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DisponibilidadHoraFin") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtSDTDisponibilidad_Disponibilidadhorafin = GXutil.resetTime( GXutil.nullDate() );
                  gxTv_SdtSDTDisponibilidad_Disponibilidadhorafin_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtSDTDisponibilidad_Disponibilidadhorafin_N = (byte)(0) ;
                  gxTv_SdtSDTDisponibilidad_Disponibilidadhorafin = GXutil.resetDate(localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EspecialidadId") )
            {
               gxTv_SdtSDTDisponibilidad_Especialidadid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGSedeDisponibilidadSedeId") )
            {
               gxTv_SdtSDTDisponibilidad_Sgsededisponibilidadsedeid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGSedeDisponibilidadSedeNombre") )
            {
               gxTv_SdtSDTDisponibilidad_Sgsededisponibilidadsedenombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGSedeDisponibilidadClinicaId") )
            {
               gxTv_SdtSDTDisponibilidad_Sgsededisponibilidadclinicaid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGSedeDisponibilidadClinicaAbreviado") )
            {
               gxTv_SdtSDTDisponibilidad_Sgsededisponibilidadclinicaabreviado = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DisponibilidadEstado") )
            {
               gxTv_SdtSDTDisponibilidad_Disponibilidadestado = oReader.getValue() ;
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
         sName = "SDTDisponibilidad" ;
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
      oWriter.writeElement("DisponibilidadId", GXutil.trim( GXutil.str( gxTv_SdtSDTDisponibilidad_Disponibilidadid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("EventId", GXutil.rtrim( gxTv_SdtSDTDisponibilidad_Eventid));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("DisponibilidadDescription", GXutil.rtrim( gxTv_SdtSDTDisponibilidad_Disponibilidaddescription));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalId", GXutil.trim( GXutil.str( gxTv_SdtSDTDisponibilidad_Profesionalid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_SdtSDTDisponibilidad_Disponibilidadfecha)) && ( gxTv_SdtSDTDisponibilidad_Disponibilidadfecha_N == 1 ) )
      {
         oWriter.writeElement("DisponibilidadFecha", "");
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTDisponibilidad_Disponibilidadfecha), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTDisponibilidad_Disponibilidadfecha), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTDisponibilidad_Disponibilidadfecha), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("DisponibilidadFecha", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      if ( GXutil.dateCompare(GXutil.nullDate(), gxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio) && ( gxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio_N == 1 ) )
      {
         oWriter.writeElement("DisponibilidadHoraInicio", "");
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("DisponibilidadHoraInicio", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      if ( GXutil.dateCompare(GXutil.nullDate(), gxTv_SdtSDTDisponibilidad_Disponibilidadhorafin) && ( gxTv_SdtSDTDisponibilidad_Disponibilidadhorafin_N == 1 ) )
      {
         oWriter.writeElement("DisponibilidadHoraFin", "");
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTDisponibilidad_Disponibilidadhorafin), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTDisponibilidad_Disponibilidadhorafin), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTDisponibilidad_Disponibilidadhorafin), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtSDTDisponibilidad_Disponibilidadhorafin), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtSDTDisponibilidad_Disponibilidadhorafin), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtSDTDisponibilidad_Disponibilidadhorafin), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("DisponibilidadHoraFin", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      oWriter.writeElement("EspecialidadId", GXutil.trim( GXutil.str( gxTv_SdtSDTDisponibilidad_Especialidadid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGSedeDisponibilidadSedeId", GXutil.trim( GXutil.str( gxTv_SdtSDTDisponibilidad_Sgsededisponibilidadsedeid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGSedeDisponibilidadSedeNombre", GXutil.rtrim( gxTv_SdtSDTDisponibilidad_Sgsededisponibilidadsedenombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGSedeDisponibilidadClinicaId", GXutil.trim( GXutil.str( gxTv_SdtSDTDisponibilidad_Sgsededisponibilidadclinicaid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGSedeDisponibilidadClinicaAbreviado", GXutil.rtrim( gxTv_SdtSDTDisponibilidad_Sgsededisponibilidadclinicaabreviado));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("DisponibilidadEstado", GXutil.rtrim( gxTv_SdtSDTDisponibilidad_Disponibilidadestado));
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
      AddObjectProperty("DisponibilidadId", gxTv_SdtSDTDisponibilidad_Disponibilidadid, false, false);
      AddObjectProperty("EventId", gxTv_SdtSDTDisponibilidad_Eventid, false, false);
      AddObjectProperty("DisponibilidadDescription", gxTv_SdtSDTDisponibilidad_Disponibilidaddescription, false, false);
      AddObjectProperty("ProfesionalId", gxTv_SdtSDTDisponibilidad_Profesionalid, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTDisponibilidad_Disponibilidadfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTDisponibilidad_Disponibilidadfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTDisponibilidad_Disponibilidadfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("DisponibilidadFecha", sDateCnv, false, false);
      datetime_STZ = gxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio ;
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("DisponibilidadHoraInicio", sDateCnv, false, false);
      datetime_STZ = gxTv_SdtSDTDisponibilidad_Disponibilidadhorafin ;
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("DisponibilidadHoraFin", sDateCnv, false, false);
      AddObjectProperty("EspecialidadId", gxTv_SdtSDTDisponibilidad_Especialidadid, false, false);
      AddObjectProperty("SGSedeDisponibilidadSedeId", gxTv_SdtSDTDisponibilidad_Sgsededisponibilidadsedeid, false, false);
      AddObjectProperty("SGSedeDisponibilidadSedeNombre", gxTv_SdtSDTDisponibilidad_Sgsededisponibilidadsedenombre, false, false);
      AddObjectProperty("SGSedeDisponibilidadClinicaId", gxTv_SdtSDTDisponibilidad_Sgsededisponibilidadclinicaid, false, false);
      AddObjectProperty("SGSedeDisponibilidadClinicaAbreviado", gxTv_SdtSDTDisponibilidad_Sgsededisponibilidadclinicaabreviado, false, false);
      AddObjectProperty("DisponibilidadEstado", gxTv_SdtSDTDisponibilidad_Disponibilidadestado, false, false);
   }

   public int getgxTv_SdtSDTDisponibilidad_Disponibilidadid( )
   {
      return gxTv_SdtSDTDisponibilidad_Disponibilidadid ;
   }

   public void setgxTv_SdtSDTDisponibilidad_Disponibilidadid( int value )
   {
      gxTv_SdtSDTDisponibilidad_N = (byte)(0) ;
      gxTv_SdtSDTDisponibilidad_Disponibilidadid = value ;
   }

   public String getgxTv_SdtSDTDisponibilidad_Eventid( )
   {
      return gxTv_SdtSDTDisponibilidad_Eventid ;
   }

   public void setgxTv_SdtSDTDisponibilidad_Eventid( String value )
   {
      gxTv_SdtSDTDisponibilidad_N = (byte)(0) ;
      gxTv_SdtSDTDisponibilidad_Eventid = value ;
   }

   public String getgxTv_SdtSDTDisponibilidad_Disponibilidaddescription( )
   {
      return gxTv_SdtSDTDisponibilidad_Disponibilidaddescription ;
   }

   public void setgxTv_SdtSDTDisponibilidad_Disponibilidaddescription( String value )
   {
      gxTv_SdtSDTDisponibilidad_N = (byte)(0) ;
      gxTv_SdtSDTDisponibilidad_Disponibilidaddescription = value ;
   }

   public int getgxTv_SdtSDTDisponibilidad_Profesionalid( )
   {
      return gxTv_SdtSDTDisponibilidad_Profesionalid ;
   }

   public void setgxTv_SdtSDTDisponibilidad_Profesionalid( int value )
   {
      gxTv_SdtSDTDisponibilidad_N = (byte)(0) ;
      gxTv_SdtSDTDisponibilidad_Profesionalid = value ;
   }

   public java.util.Date getgxTv_SdtSDTDisponibilidad_Disponibilidadfecha( )
   {
      return gxTv_SdtSDTDisponibilidad_Disponibilidadfecha ;
   }

   public void setgxTv_SdtSDTDisponibilidad_Disponibilidadfecha( java.util.Date value )
   {
      gxTv_SdtSDTDisponibilidad_Disponibilidadfecha_N = (byte)(0) ;
      gxTv_SdtSDTDisponibilidad_N = (byte)(0) ;
      gxTv_SdtSDTDisponibilidad_Disponibilidadfecha = value ;
   }

   public java.util.Date getgxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio( )
   {
      return gxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio ;
   }

   public void setgxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio( java.util.Date value )
   {
      gxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio_N = (byte)(0) ;
      gxTv_SdtSDTDisponibilidad_N = (byte)(0) ;
      gxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio = value ;
   }

   public java.util.Date getgxTv_SdtSDTDisponibilidad_Disponibilidadhorafin( )
   {
      return gxTv_SdtSDTDisponibilidad_Disponibilidadhorafin ;
   }

   public void setgxTv_SdtSDTDisponibilidad_Disponibilidadhorafin( java.util.Date value )
   {
      gxTv_SdtSDTDisponibilidad_Disponibilidadhorafin_N = (byte)(0) ;
      gxTv_SdtSDTDisponibilidad_N = (byte)(0) ;
      gxTv_SdtSDTDisponibilidad_Disponibilidadhorafin = value ;
   }

   public short getgxTv_SdtSDTDisponibilidad_Especialidadid( )
   {
      return gxTv_SdtSDTDisponibilidad_Especialidadid ;
   }

   public void setgxTv_SdtSDTDisponibilidad_Especialidadid( short value )
   {
      gxTv_SdtSDTDisponibilidad_N = (byte)(0) ;
      gxTv_SdtSDTDisponibilidad_Especialidadid = value ;
   }

   public short getgxTv_SdtSDTDisponibilidad_Sgsededisponibilidadsedeid( )
   {
      return gxTv_SdtSDTDisponibilidad_Sgsededisponibilidadsedeid ;
   }

   public void setgxTv_SdtSDTDisponibilidad_Sgsededisponibilidadsedeid( short value )
   {
      gxTv_SdtSDTDisponibilidad_N = (byte)(0) ;
      gxTv_SdtSDTDisponibilidad_Sgsededisponibilidadsedeid = value ;
   }

   public String getgxTv_SdtSDTDisponibilidad_Sgsededisponibilidadsedenombre( )
   {
      return gxTv_SdtSDTDisponibilidad_Sgsededisponibilidadsedenombre ;
   }

   public void setgxTv_SdtSDTDisponibilidad_Sgsededisponibilidadsedenombre( String value )
   {
      gxTv_SdtSDTDisponibilidad_N = (byte)(0) ;
      gxTv_SdtSDTDisponibilidad_Sgsededisponibilidadsedenombre = value ;
   }

   public short getgxTv_SdtSDTDisponibilidad_Sgsededisponibilidadclinicaid( )
   {
      return gxTv_SdtSDTDisponibilidad_Sgsededisponibilidadclinicaid ;
   }

   public void setgxTv_SdtSDTDisponibilidad_Sgsededisponibilidadclinicaid( short value )
   {
      gxTv_SdtSDTDisponibilidad_N = (byte)(0) ;
      gxTv_SdtSDTDisponibilidad_Sgsededisponibilidadclinicaid = value ;
   }

   public String getgxTv_SdtSDTDisponibilidad_Sgsededisponibilidadclinicaabreviado( )
   {
      return gxTv_SdtSDTDisponibilidad_Sgsededisponibilidadclinicaabreviado ;
   }

   public void setgxTv_SdtSDTDisponibilidad_Sgsededisponibilidadclinicaabreviado( String value )
   {
      gxTv_SdtSDTDisponibilidad_N = (byte)(0) ;
      gxTv_SdtSDTDisponibilidad_Sgsededisponibilidadclinicaabreviado = value ;
   }

   public String getgxTv_SdtSDTDisponibilidad_Disponibilidadestado( )
   {
      return gxTv_SdtSDTDisponibilidad_Disponibilidadestado ;
   }

   public void setgxTv_SdtSDTDisponibilidad_Disponibilidadestado( String value )
   {
      gxTv_SdtSDTDisponibilidad_N = (byte)(0) ;
      gxTv_SdtSDTDisponibilidad_Disponibilidadestado = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTDisponibilidad_N = (byte)(1) ;
      gxTv_SdtSDTDisponibilidad_Eventid = "" ;
      gxTv_SdtSDTDisponibilidad_Disponibilidaddescription = "" ;
      gxTv_SdtSDTDisponibilidad_Disponibilidadfecha = GXutil.nullDate() ;
      gxTv_SdtSDTDisponibilidad_Disponibilidadfecha_N = (byte)(1) ;
      gxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio_N = (byte)(1) ;
      gxTv_SdtSDTDisponibilidad_Disponibilidadhorafin = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtSDTDisponibilidad_Disponibilidadhorafin_N = (byte)(1) ;
      gxTv_SdtSDTDisponibilidad_Sgsededisponibilidadsedenombre = "" ;
      gxTv_SdtSDTDisponibilidad_Sgsededisponibilidadclinicaabreviado = "" ;
      gxTv_SdtSDTDisponibilidad_Disponibilidadestado = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
      datetime_STZ = GXutil.resetTime( GXutil.nullDate() );
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTDisponibilidad_N ;
   }

   public com.projectthani.SdtSDTDisponibilidad Clone( )
   {
      return (com.projectthani.SdtSDTDisponibilidad)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTDisponibilidad struct )
   {
      setgxTv_SdtSDTDisponibilidad_Disponibilidadid(struct.getDisponibilidadid());
      setgxTv_SdtSDTDisponibilidad_Eventid(struct.getEventid());
      setgxTv_SdtSDTDisponibilidad_Disponibilidaddescription(struct.getDisponibilidaddescription());
      setgxTv_SdtSDTDisponibilidad_Profesionalid(struct.getProfesionalid());
      if ( struct.gxTv_SdtSDTDisponibilidad_Disponibilidadfecha_N == 0 )
      {
         setgxTv_SdtSDTDisponibilidad_Disponibilidadfecha(struct.getDisponibilidadfecha());
      }
      if ( struct.gxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio_N == 0 )
      {
         setgxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio(struct.getDisponibilidadhorainicio());
      }
      if ( struct.gxTv_SdtSDTDisponibilidad_Disponibilidadhorafin_N == 0 )
      {
         setgxTv_SdtSDTDisponibilidad_Disponibilidadhorafin(struct.getDisponibilidadhorafin());
      }
      setgxTv_SdtSDTDisponibilidad_Especialidadid(struct.getEspecialidadid());
      setgxTv_SdtSDTDisponibilidad_Sgsededisponibilidadsedeid(struct.getSgsededisponibilidadsedeid());
      setgxTv_SdtSDTDisponibilidad_Sgsededisponibilidadsedenombre(struct.getSgsededisponibilidadsedenombre());
      setgxTv_SdtSDTDisponibilidad_Sgsededisponibilidadclinicaid(struct.getSgsededisponibilidadclinicaid());
      setgxTv_SdtSDTDisponibilidad_Sgsededisponibilidadclinicaabreviado(struct.getSgsededisponibilidadclinicaabreviado());
      setgxTv_SdtSDTDisponibilidad_Disponibilidadestado(struct.getDisponibilidadestado());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTDisponibilidad getStruct( )
   {
      com.projectthani.StructSdtSDTDisponibilidad struct = new com.projectthani.StructSdtSDTDisponibilidad ();
      struct.setDisponibilidadid(getgxTv_SdtSDTDisponibilidad_Disponibilidadid());
      struct.setEventid(getgxTv_SdtSDTDisponibilidad_Eventid());
      struct.setDisponibilidaddescription(getgxTv_SdtSDTDisponibilidad_Disponibilidaddescription());
      struct.setProfesionalid(getgxTv_SdtSDTDisponibilidad_Profesionalid());
      if ( gxTv_SdtSDTDisponibilidad_Disponibilidadfecha_N == 0 )
      {
         struct.setDisponibilidadfecha(getgxTv_SdtSDTDisponibilidad_Disponibilidadfecha());
      }
      if ( gxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio_N == 0 )
      {
         struct.setDisponibilidadhorainicio(getgxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio());
      }
      if ( gxTv_SdtSDTDisponibilidad_Disponibilidadhorafin_N == 0 )
      {
         struct.setDisponibilidadhorafin(getgxTv_SdtSDTDisponibilidad_Disponibilidadhorafin());
      }
      struct.setEspecialidadid(getgxTv_SdtSDTDisponibilidad_Especialidadid());
      struct.setSgsededisponibilidadsedeid(getgxTv_SdtSDTDisponibilidad_Sgsededisponibilidadsedeid());
      struct.setSgsededisponibilidadsedenombre(getgxTv_SdtSDTDisponibilidad_Sgsededisponibilidadsedenombre());
      struct.setSgsededisponibilidadclinicaid(getgxTv_SdtSDTDisponibilidad_Sgsededisponibilidadclinicaid());
      struct.setSgsededisponibilidadclinicaabreviado(getgxTv_SdtSDTDisponibilidad_Sgsededisponibilidadclinicaabreviado());
      struct.setDisponibilidadestado(getgxTv_SdtSDTDisponibilidad_Disponibilidadestado());
      return struct ;
   }

   protected byte gxTv_SdtSDTDisponibilidad_N ;
   protected byte gxTv_SdtSDTDisponibilidad_Disponibilidadfecha_N ;
   protected byte gxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio_N ;
   protected byte gxTv_SdtSDTDisponibilidad_Disponibilidadhorafin_N ;
   protected short gxTv_SdtSDTDisponibilidad_Especialidadid ;
   protected short gxTv_SdtSDTDisponibilidad_Sgsededisponibilidadsedeid ;
   protected short gxTv_SdtSDTDisponibilidad_Sgsededisponibilidadclinicaid ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_SdtSDTDisponibilidad_Disponibilidadid ;
   protected int gxTv_SdtSDTDisponibilidad_Profesionalid ;
   protected String gxTv_SdtSDTDisponibilidad_Eventid ;
   protected String gxTv_SdtSDTDisponibilidad_Disponibilidadestado ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio ;
   protected java.util.Date gxTv_SdtSDTDisponibilidad_Disponibilidadhorafin ;
   protected java.util.Date datetime_STZ ;
   protected java.util.Date gxTv_SdtSDTDisponibilidad_Disponibilidadfecha ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTDisponibilidad_Disponibilidaddescription ;
   protected String gxTv_SdtSDTDisponibilidad_Sgsededisponibilidadsedenombre ;
   protected String gxTv_SdtSDTDisponibilidad_Sgsededisponibilidadclinicaabreviado ;
}

