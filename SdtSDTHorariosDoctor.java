package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTHorariosDoctor extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTHorariosDoctor( )
   {
      this(  new ModelContext(SdtSDTHorariosDoctor.class));
   }

   public SdtSDTHorariosDoctor( ModelContext context )
   {
      super( context, "SdtSDTHorariosDoctor");
   }

   public SdtSDTHorariosDoctor( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTHorariosDoctor");
   }

   public SdtSDTHorariosDoctor( StructSdtSDTHorariosDoctor struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTHorariosDoctorProfesionalId") )
            {
               gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorprofesionalid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTHorariosDoctorNombresApellidos") )
            {
               gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombresapellidos = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTHorariosDoctorEspecialidadId") )
            {
               gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorespecialidadid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTHorariosDoctorEspecialidadNombre") )
            {
               gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorespecialidadnombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTHorariosDoctorNroDia") )
            {
               gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornrodia = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTHorariosDoctorNombreDia") )
            {
               gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombredia = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTHorariosDoctorNombreMes") )
            {
               gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombremes = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTHorariosDoctorFecha") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorfecha = GXutil.nullDate() ;
                  gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorfecha_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorfecha_N = (byte)(0) ;
                  gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorfecha = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Detalle") )
            {
               if ( gxTv_SdtSDTHorariosDoctor_Detalle == null )
               {
                  gxTv_SdtSDTHorariosDoctor_Detalle = new GXBaseCollection<com.projectthani.SdtSDTHorariosDoctor_DetalleItem>(com.projectthani.SdtSDTHorariosDoctor_DetalleItem.class, "SDTHorariosDoctor.DetalleItem", "ProjectThani", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_SdtSDTHorariosDoctor_Detalle.readxmlcollection(oReader, "Detalle", "DetalleItem") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Detalle") )
               {
                  GXSoapError = oReader.read() ;
               }
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
         sName = "SDTHorariosDoctor" ;
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
      oWriter.writeElement("SDTHorariosDoctorProfesionalId", GXutil.trim( GXutil.str( gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorprofesionalid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTHorariosDoctorNombresApellidos", GXutil.rtrim( gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombresapellidos));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTHorariosDoctorEspecialidadId", GXutil.trim( GXutil.str( gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorespecialidadid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTHorariosDoctorEspecialidadNombre", GXutil.rtrim( gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorespecialidadnombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTHorariosDoctorNroDia", GXutil.trim( GXutil.str( gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornrodia, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTHorariosDoctorNombreDia", GXutil.rtrim( gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombredia));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTHorariosDoctorNombreMes", GXutil.rtrim( gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombremes));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorfecha)) && ( gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorfecha_N == 1 ) )
      {
         oWriter.writeElement("SDTHorariosDoctorFecha", "");
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorfecha), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorfecha), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorfecha), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("SDTHorariosDoctorFecha", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      if ( gxTv_SdtSDTHorariosDoctor_Detalle != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "ProjectThani" ;
         }
         else
         {
            sNameSpace1 = "ProjectThani" ;
         }
         gxTv_SdtSDTHorariosDoctor_Detalle.writexmlcollection(oWriter, "Detalle", sNameSpace1, "DetalleItem", sNameSpace1);
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
      AddObjectProperty("SDTHorariosDoctorProfesionalId", gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorprofesionalid, false, false);
      AddObjectProperty("SDTHorariosDoctorNombresApellidos", gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombresapellidos, false, false);
      AddObjectProperty("SDTHorariosDoctorEspecialidadId", gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorespecialidadid, false, false);
      AddObjectProperty("SDTHorariosDoctorEspecialidadNombre", gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorespecialidadnombre, false, false);
      AddObjectProperty("SDTHorariosDoctorNroDia", gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornrodia, false, false);
      AddObjectProperty("SDTHorariosDoctorNombreDia", gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombredia, false, false);
      AddObjectProperty("SDTHorariosDoctorNombreMes", gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombremes, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("SDTHorariosDoctorFecha", sDateCnv, false, false);
      if ( gxTv_SdtSDTHorariosDoctor_Detalle != null )
      {
         AddObjectProperty("Detalle", gxTv_SdtSDTHorariosDoctor_Detalle, false, false);
      }
   }

   public short getgxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorprofesionalid( )
   {
      return gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorprofesionalid ;
   }

   public void setgxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorprofesionalid( short value )
   {
      gxTv_SdtSDTHorariosDoctor_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorprofesionalid = value ;
   }

   public String getgxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombresapellidos( )
   {
      return gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombresapellidos ;
   }

   public void setgxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombresapellidos( String value )
   {
      gxTv_SdtSDTHorariosDoctor_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombresapellidos = value ;
   }

   public short getgxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorespecialidadid( )
   {
      return gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorespecialidadid ;
   }

   public void setgxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorespecialidadid( short value )
   {
      gxTv_SdtSDTHorariosDoctor_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorespecialidadid = value ;
   }

   public String getgxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorespecialidadnombre( )
   {
      return gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorespecialidadnombre ;
   }

   public void setgxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorespecialidadnombre( String value )
   {
      gxTv_SdtSDTHorariosDoctor_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorespecialidadnombre = value ;
   }

   public short getgxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornrodia( )
   {
      return gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornrodia ;
   }

   public void setgxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornrodia( short value )
   {
      gxTv_SdtSDTHorariosDoctor_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornrodia = value ;
   }

   public String getgxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombredia( )
   {
      return gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombredia ;
   }

   public void setgxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombredia( String value )
   {
      gxTv_SdtSDTHorariosDoctor_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombredia = value ;
   }

   public String getgxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombremes( )
   {
      return gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombremes ;
   }

   public void setgxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombremes( String value )
   {
      gxTv_SdtSDTHorariosDoctor_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombremes = value ;
   }

   public java.util.Date getgxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorfecha( )
   {
      return gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorfecha ;
   }

   public void setgxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorfecha( java.util.Date value )
   {
      gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorfecha_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorfecha = value ;
   }

   public GXBaseCollection<com.projectthani.SdtSDTHorariosDoctor_DetalleItem> getgxTv_SdtSDTHorariosDoctor_Detalle( )
   {
      if ( gxTv_SdtSDTHorariosDoctor_Detalle == null )
      {
         gxTv_SdtSDTHorariosDoctor_Detalle = new GXBaseCollection<com.projectthani.SdtSDTHorariosDoctor_DetalleItem>(com.projectthani.SdtSDTHorariosDoctor_DetalleItem.class, "SDTHorariosDoctor.DetalleItem", "ProjectThani", remoteHandle);
      }
      gxTv_SdtSDTHorariosDoctor_Detalle_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_N = (byte)(0) ;
      return gxTv_SdtSDTHorariosDoctor_Detalle ;
   }

   public void setgxTv_SdtSDTHorariosDoctor_Detalle( GXBaseCollection<com.projectthani.SdtSDTHorariosDoctor_DetalleItem> value )
   {
      gxTv_SdtSDTHorariosDoctor_Detalle_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_Detalle = value ;
   }

   public void setgxTv_SdtSDTHorariosDoctor_Detalle_SetNull( )
   {
      gxTv_SdtSDTHorariosDoctor_Detalle_N = (byte)(1) ;
      gxTv_SdtSDTHorariosDoctor_Detalle = null ;
   }

   public boolean getgxTv_SdtSDTHorariosDoctor_Detalle_IsNull( )
   {
      if ( gxTv_SdtSDTHorariosDoctor_Detalle == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtSDTHorariosDoctor_Detalle_N( )
   {
      return gxTv_SdtSDTHorariosDoctor_Detalle_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTHorariosDoctor_N = (byte)(1) ;
      gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombresapellidos = "" ;
      gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorespecialidadnombre = "" ;
      gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombredia = "" ;
      gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombremes = "" ;
      gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorfecha = GXutil.nullDate() ;
      gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorfecha_N = (byte)(1) ;
      gxTv_SdtSDTHorariosDoctor_Detalle_N = (byte)(1) ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTHorariosDoctor_N ;
   }

   public com.projectthani.SdtSDTHorariosDoctor Clone( )
   {
      return (com.projectthani.SdtSDTHorariosDoctor)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTHorariosDoctor struct )
   {
      setgxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorprofesionalid(struct.getSdthorariosdoctorprofesionalid());
      setgxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombresapellidos(struct.getSdthorariosdoctornombresapellidos());
      setgxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorespecialidadid(struct.getSdthorariosdoctorespecialidadid());
      setgxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorespecialidadnombre(struct.getSdthorariosdoctorespecialidadnombre());
      setgxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornrodia(struct.getSdthorariosdoctornrodia());
      setgxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombredia(struct.getSdthorariosdoctornombredia());
      setgxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombremes(struct.getSdthorariosdoctornombremes());
      if ( struct.gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorfecha_N == 0 )
      {
         setgxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorfecha(struct.getSdthorariosdoctorfecha());
      }
      GXBaseCollection<com.projectthani.SdtSDTHorariosDoctor_DetalleItem> gxTv_SdtSDTHorariosDoctor_Detalle_aux = new GXBaseCollection<com.projectthani.SdtSDTHorariosDoctor_DetalleItem>(com.projectthani.SdtSDTHorariosDoctor_DetalleItem.class, "SDTHorariosDoctor.DetalleItem", "ProjectThani", remoteHandle);
      Vector<com.projectthani.StructSdtSDTHorariosDoctor_DetalleItem> gxTv_SdtSDTHorariosDoctor_Detalle_aux1 = struct.getDetalle();
      if (gxTv_SdtSDTHorariosDoctor_Detalle_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtSDTHorariosDoctor_Detalle_aux1.size(); i++)
         {
            gxTv_SdtSDTHorariosDoctor_Detalle_aux.add(new com.projectthani.SdtSDTHorariosDoctor_DetalleItem(gxTv_SdtSDTHorariosDoctor_Detalle_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtSDTHorariosDoctor_Detalle(gxTv_SdtSDTHorariosDoctor_Detalle_aux);
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTHorariosDoctor getStruct( )
   {
      com.projectthani.StructSdtSDTHorariosDoctor struct = new com.projectthani.StructSdtSDTHorariosDoctor ();
      struct.setSdthorariosdoctorprofesionalid(getgxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorprofesionalid());
      struct.setSdthorariosdoctornombresapellidos(getgxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombresapellidos());
      struct.setSdthorariosdoctorespecialidadid(getgxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorespecialidadid());
      struct.setSdthorariosdoctorespecialidadnombre(getgxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorespecialidadnombre());
      struct.setSdthorariosdoctornrodia(getgxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornrodia());
      struct.setSdthorariosdoctornombredia(getgxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombredia());
      struct.setSdthorariosdoctornombremes(getgxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombremes());
      if ( gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorfecha_N == 0 )
      {
         struct.setSdthorariosdoctorfecha(getgxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorfecha());
      }
      struct.setDetalle(getgxTv_SdtSDTHorariosDoctor_Detalle().getStruct());
      return struct ;
   }

   protected byte gxTv_SdtSDTHorariosDoctor_N ;
   protected byte gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorfecha_N ;
   protected byte gxTv_SdtSDTHorariosDoctor_Detalle_N ;
   protected short gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorprofesionalid ;
   protected short gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorespecialidadid ;
   protected short gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornrodia ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorfecha ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombresapellidos ;
   protected String gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorespecialidadnombre ;
   protected String gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombredia ;
   protected String gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombremes ;
   protected GXBaseCollection<com.projectthani.SdtSDTHorariosDoctor_DetalleItem> gxTv_SdtSDTHorariosDoctor_Detalle_aux ;
   protected GXBaseCollection<com.projectthani.SdtSDTHorariosDoctor_DetalleItem> gxTv_SdtSDTHorariosDoctor_Detalle=null ;
}

