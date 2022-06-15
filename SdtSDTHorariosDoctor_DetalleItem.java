package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTHorariosDoctor_DetalleItem extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTHorariosDoctor_DetalleItem( )
   {
      this(  new ModelContext(SdtSDTHorariosDoctor_DetalleItem.class));
   }

   public SdtSDTHorariosDoctor_DetalleItem( ModelContext context )
   {
      super( context, "SdtSDTHorariosDoctor_DetalleItem");
   }

   public SdtSDTHorariosDoctor_DetalleItem( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTHorariosDoctor_DetalleItem");
   }

   public SdtSDTHorariosDoctor_DetalleItem( StructSdtSDTHorariosDoctor_DetalleItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTHorariosDoctorDetalleDisponibilidadId") )
            {
               gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalledisponibilidadid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTHorariosDoctorDetalleHora") )
            {
               gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehora = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTHorariosDoctorDetalleHoraInicio") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorainicio = GXutil.resetTime( GXutil.nullDate() );
                  gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorainicio_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorainicio_N = (byte)(0) ;
                  gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorainicio = GXutil.resetDate(localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTHorariosDoctorDetalleHoraFin") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorafin = GXutil.resetTime( GXutil.nullDate() );
                  gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorafin_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorafin_N = (byte)(0) ;
                  gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorafin = GXutil.resetDate(localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTHorariosDoctorDetalleTipoCita") )
            {
               gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalletipocita = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTHorariosDoctorDetalleCostoCita") )
            {
               gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallecostocita = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTHorariosDoctorDetalleEstado") )
            {
               gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalleestado = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTHorariosDoctorDetalleLink") )
            {
               gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallelink = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTHorariosDoctorDetalleColor") )
            {
               gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallecolor = oReader.getValue() ;
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
         sName = "SDTHorariosDoctor.DetalleItem" ;
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
      oWriter.writeElement("SDTHorariosDoctorDetalleDisponibilidadId", GXutil.trim( GXutil.str( gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalledisponibilidadid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTHorariosDoctorDetalleHora", GXutil.rtrim( gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehora));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( GXutil.dateCompare(GXutil.nullDate(), gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorainicio) && ( gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorainicio_N == 1 ) )
      {
         oWriter.writeElement("SDTHorariosDoctorDetalleHoraInicio", "");
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorainicio), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorainicio), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorainicio), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorainicio), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorainicio), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorainicio), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("SDTHorariosDoctorDetalleHoraInicio", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      if ( GXutil.dateCompare(GXutil.nullDate(), gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorafin) && ( gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorafin_N == 1 ) )
      {
         oWriter.writeElement("SDTHorariosDoctorDetalleHoraFin", "");
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorafin), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorafin), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorafin), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorafin), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorafin), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorafin), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("SDTHorariosDoctorDetalleHoraFin", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      oWriter.writeElement("SDTHorariosDoctorDetalleTipoCita", GXutil.rtrim( gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalletipocita));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTHorariosDoctorDetalleCostoCita", GXutil.trim( GXutil.strNoRound( gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallecostocita, 6, 2)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTHorariosDoctorDetalleEstado", GXutil.rtrim( gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalleestado));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTHorariosDoctorDetalleLink", GXutil.rtrim( gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallelink));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTHorariosDoctorDetalleColor", GXutil.rtrim( gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallecolor));
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
      AddObjectProperty("SDTHorariosDoctorDetalleDisponibilidadId", gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalledisponibilidadid, false, false);
      AddObjectProperty("SDTHorariosDoctorDetalleHora", gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehora, false, false);
      datetime_STZ = gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorainicio ;
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
      AddObjectProperty("SDTHorariosDoctorDetalleHoraInicio", sDateCnv, false, false);
      datetime_STZ = gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorafin ;
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
      AddObjectProperty("SDTHorariosDoctorDetalleHoraFin", sDateCnv, false, false);
      AddObjectProperty("SDTHorariosDoctorDetalleTipoCita", gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalletipocita, false, false);
      AddObjectProperty("SDTHorariosDoctorDetalleCostoCita", gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallecostocita, false, false);
      AddObjectProperty("SDTHorariosDoctorDetalleEstado", gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalleestado, false, false);
      AddObjectProperty("SDTHorariosDoctorDetalleLink", gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallelink, false, false);
      AddObjectProperty("SDTHorariosDoctorDetalleColor", gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallecolor, false, false);
   }

   public int getgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalledisponibilidadid( )
   {
      return gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalledisponibilidadid ;
   }

   public void setgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalledisponibilidadid( int value )
   {
      gxTv_SdtSDTHorariosDoctor_DetalleItem_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalledisponibilidadid = value ;
   }

   public String getgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehora( )
   {
      return gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehora ;
   }

   public void setgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehora( String value )
   {
      gxTv_SdtSDTHorariosDoctor_DetalleItem_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehora = value ;
   }

   public java.util.Date getgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorainicio( )
   {
      return gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorainicio ;
   }

   public void setgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorainicio( java.util.Date value )
   {
      gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorainicio_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_DetalleItem_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorainicio = value ;
   }

   public java.util.Date getgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorafin( )
   {
      return gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorafin ;
   }

   public void setgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorafin( java.util.Date value )
   {
      gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorafin_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_DetalleItem_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorafin = value ;
   }

   public String getgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalletipocita( )
   {
      return gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalletipocita ;
   }

   public void setgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalletipocita( String value )
   {
      gxTv_SdtSDTHorariosDoctor_DetalleItem_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalletipocita = value ;
   }

   public java.math.BigDecimal getgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallecostocita( )
   {
      return gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallecostocita ;
   }

   public void setgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallecostocita( java.math.BigDecimal value )
   {
      gxTv_SdtSDTHorariosDoctor_DetalleItem_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallecostocita = value ;
   }

   public String getgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalleestado( )
   {
      return gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalleestado ;
   }

   public void setgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalleestado( String value )
   {
      gxTv_SdtSDTHorariosDoctor_DetalleItem_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalleestado = value ;
   }

   public String getgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallelink( )
   {
      return gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallelink ;
   }

   public void setgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallelink( String value )
   {
      gxTv_SdtSDTHorariosDoctor_DetalleItem_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallelink = value ;
   }

   public String getgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallecolor( )
   {
      return gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallecolor ;
   }

   public void setgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallecolor( String value )
   {
      gxTv_SdtSDTHorariosDoctor_DetalleItem_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallecolor = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTHorariosDoctor_DetalleItem_N = (byte)(1) ;
      gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehora = "" ;
      gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorainicio = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorainicio_N = (byte)(1) ;
      gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorafin = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorafin_N = (byte)(1) ;
      gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalletipocita = "" ;
      gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallecostocita = DecimalUtil.ZERO ;
      gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalleestado = "" ;
      gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallelink = "" ;
      gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallecolor = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
      datetime_STZ = GXutil.resetTime( GXutil.nullDate() );
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTHorariosDoctor_DetalleItem_N ;
   }

   public com.projectthani.SdtSDTHorariosDoctor_DetalleItem Clone( )
   {
      return (com.projectthani.SdtSDTHorariosDoctor_DetalleItem)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTHorariosDoctor_DetalleItem struct )
   {
      setgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalledisponibilidadid(struct.getSdthorariosdoctordetalledisponibilidadid());
      setgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehora(struct.getSdthorariosdoctordetallehora());
      if ( struct.gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorainicio_N == 0 )
      {
         setgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorainicio(struct.getSdthorariosdoctordetallehorainicio());
      }
      if ( struct.gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorafin_N == 0 )
      {
         setgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorafin(struct.getSdthorariosdoctordetallehorafin());
      }
      setgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalletipocita(struct.getSdthorariosdoctordetalletipocita());
      setgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallecostocita(struct.getSdthorariosdoctordetallecostocita());
      setgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalleestado(struct.getSdthorariosdoctordetalleestado());
      setgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallelink(struct.getSdthorariosdoctordetallelink());
      setgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallecolor(struct.getSdthorariosdoctordetallecolor());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTHorariosDoctor_DetalleItem getStruct( )
   {
      com.projectthani.StructSdtSDTHorariosDoctor_DetalleItem struct = new com.projectthani.StructSdtSDTHorariosDoctor_DetalleItem ();
      struct.setSdthorariosdoctordetalledisponibilidadid(getgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalledisponibilidadid());
      struct.setSdthorariosdoctordetallehora(getgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehora());
      if ( gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorainicio_N == 0 )
      {
         struct.setSdthorariosdoctordetallehorainicio(getgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorainicio());
      }
      if ( gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorafin_N == 0 )
      {
         struct.setSdthorariosdoctordetallehorafin(getgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorafin());
      }
      struct.setSdthorariosdoctordetalletipocita(getgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalletipocita());
      struct.setSdthorariosdoctordetallecostocita(getgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallecostocita());
      struct.setSdthorariosdoctordetalleestado(getgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalleestado());
      struct.setSdthorariosdoctordetallelink(getgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallelink());
      struct.setSdthorariosdoctordetallecolor(getgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallecolor());
      return struct ;
   }

   protected byte gxTv_SdtSDTHorariosDoctor_DetalleItem_N ;
   protected byte gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorainicio_N ;
   protected byte gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorafin_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalledisponibilidadid ;
   protected java.math.BigDecimal gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallecostocita ;
   protected String gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehora ;
   protected String gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalleestado ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorainicio ;
   protected java.util.Date gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorafin ;
   protected java.util.Date datetime_STZ ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalletipocita ;
   protected String gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallelink ;
   protected String gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallecolor ;
}

