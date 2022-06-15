package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTInformacionDeLaCita extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTInformacionDeLaCita( )
   {
      this(  new ModelContext(SdtSDTInformacionDeLaCita.class));
   }

   public SdtSDTInformacionDeLaCita( ModelContext context )
   {
      super( context, "SdtSDTInformacionDeLaCita");
   }

   public SdtSDTInformacionDeLaCita( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTInformacionDeLaCita");
   }

   public SdtSDTInformacionDeLaCita( StructSdtSDTInformacionDeLaCita struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTInformacionDeLaCitaId") )
            {
               gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTInformacionDeLaCitaNombresDoctor") )
            {
               gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitanombresdoctor = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTInformacionDeLaCitaFotografiaDoctor") )
            {
               gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafotografiadoctor = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTInformacionDeLaCitaFotografiaDoctor_GXI") )
            {
               gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafotografiadoctor_gxi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTInformacionDeLaCitaEspecialidadDoctor") )
            {
               gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaespecialidaddoctor = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTInformacionDeLaCitaTipoConsulta") )
            {
               gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitatipoconsulta = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTInformacionDeLaCitaHora") )
            {
               gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitahora = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTInformacionDeLaCitaCosto") )
            {
               gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitacosto = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTInformacionDeLaCitaFecha") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafecha = GXutil.nullDate() ;
                  gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafecha_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafecha_N = (byte)(0) ;
                  gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafecha = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTInformacionDeLaCitaClinica") )
            {
               gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaclinica = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTInformacionDeLaCitaSede") )
            {
               gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitasede = oReader.getValue() ;
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
         sName = "SDTInformacionDeLaCita" ;
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
      oWriter.writeElement("SDTInformacionDeLaCitaId", GXutil.trim( GXutil.str( gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTInformacionDeLaCitaNombresDoctor", GXutil.rtrim( gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitanombresdoctor));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTInformacionDeLaCitaFotografiaDoctor", GXutil.rtrim( gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafotografiadoctor));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTInformacionDeLaCitaFotografiaDoctor_GXI", GXutil.rtrim( gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafotografiadoctor_gxi));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTInformacionDeLaCitaEspecialidadDoctor", GXutil.rtrim( gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaespecialidaddoctor));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTInformacionDeLaCitaTipoConsulta", GXutil.rtrim( gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitatipoconsulta));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTInformacionDeLaCitaHora", GXutil.rtrim( gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitahora));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTInformacionDeLaCitaCosto", GXutil.trim( GXutil.str( gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitacosto, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafecha)) && ( gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafecha_N == 1 ) )
      {
         oWriter.writeElement("SDTInformacionDeLaCitaFecha", "");
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafecha), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafecha), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafecha), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("SDTInformacionDeLaCitaFecha", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      oWriter.writeElement("SDTInformacionDeLaCitaClinica", GXutil.rtrim( gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaclinica));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SDTInformacionDeLaCitaSede", GXutil.rtrim( gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitasede));
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
      AddObjectProperty("SDTInformacionDeLaCitaId", gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaid, false, false);
      AddObjectProperty("SDTInformacionDeLaCitaNombresDoctor", gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitanombresdoctor, false, false);
      AddObjectProperty("SDTInformacionDeLaCitaFotografiaDoctor", gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafotografiadoctor, false, false);
      AddObjectProperty("SDTInformacionDeLaCitaFotografiaDoctor_GXI", gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafotografiadoctor_gxi, false, false);
      AddObjectProperty("SDTInformacionDeLaCitaEspecialidadDoctor", gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaespecialidaddoctor, false, false);
      AddObjectProperty("SDTInformacionDeLaCitaTipoConsulta", gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitatipoconsulta, false, false);
      AddObjectProperty("SDTInformacionDeLaCitaHora", gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitahora, false, false);
      AddObjectProperty("SDTInformacionDeLaCitaCosto", gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitacosto, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("SDTInformacionDeLaCitaFecha", sDateCnv, false, false);
      AddObjectProperty("SDTInformacionDeLaCitaClinica", gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaclinica, false, false);
      AddObjectProperty("SDTInformacionDeLaCitaSede", gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitasede, false, false);
   }

   public short getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaid( )
   {
      return gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaid ;
   }

   public void setgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaid( short value )
   {
      gxTv_SdtSDTInformacionDeLaCita_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaid = value ;
   }

   public String getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitanombresdoctor( )
   {
      return gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitanombresdoctor ;
   }

   public void setgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitanombresdoctor( String value )
   {
      gxTv_SdtSDTInformacionDeLaCita_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitanombresdoctor = value ;
   }

   @GxUpload
   public String getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafotografiadoctor( )
   {
      return gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafotografiadoctor ;
   }

   public void setgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafotografiadoctor( String value )
   {
      gxTv_SdtSDTInformacionDeLaCita_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafotografiadoctor = value ;
   }

   public String getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafotografiadoctor_gxi( )
   {
      return gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafotografiadoctor_gxi ;
   }

   public void setgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafotografiadoctor_gxi( String value )
   {
      gxTv_SdtSDTInformacionDeLaCita_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafotografiadoctor_gxi = value ;
   }

   public String getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaespecialidaddoctor( )
   {
      return gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaespecialidaddoctor ;
   }

   public void setgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaespecialidaddoctor( String value )
   {
      gxTv_SdtSDTInformacionDeLaCita_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaespecialidaddoctor = value ;
   }

   public String getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitatipoconsulta( )
   {
      return gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitatipoconsulta ;
   }

   public void setgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitatipoconsulta( String value )
   {
      gxTv_SdtSDTInformacionDeLaCita_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitatipoconsulta = value ;
   }

   public String getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitahora( )
   {
      return gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitahora ;
   }

   public void setgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitahora( String value )
   {
      gxTv_SdtSDTInformacionDeLaCita_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitahora = value ;
   }

   public short getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitacosto( )
   {
      return gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitacosto ;
   }

   public void setgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitacosto( short value )
   {
      gxTv_SdtSDTInformacionDeLaCita_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitacosto = value ;
   }

   public java.util.Date getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafecha( )
   {
      return gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafecha ;
   }

   public void setgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafecha( java.util.Date value )
   {
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafecha_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDeLaCita_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafecha = value ;
   }

   public String getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaclinica( )
   {
      return gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaclinica ;
   }

   public void setgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaclinica( String value )
   {
      gxTv_SdtSDTInformacionDeLaCita_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaclinica = value ;
   }

   public String getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitasede( )
   {
      return gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitasede ;
   }

   public void setgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitasede( String value )
   {
      gxTv_SdtSDTInformacionDeLaCita_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitasede = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTInformacionDeLaCita_N = (byte)(1) ;
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitanombresdoctor = "" ;
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafotografiadoctor = "" ;
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafotografiadoctor_gxi = "" ;
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaespecialidaddoctor = "" ;
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitatipoconsulta = "" ;
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitahora = "" ;
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafecha = GXutil.nullDate() ;
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafecha_N = (byte)(1) ;
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaclinica = "" ;
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitasede = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTInformacionDeLaCita_N ;
   }

   public com.projectthani.SdtSDTInformacionDeLaCita Clone( )
   {
      return (com.projectthani.SdtSDTInformacionDeLaCita)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTInformacionDeLaCita struct )
   {
      setgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaid(struct.getSdtinformaciondelacitaid());
      setgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitanombresdoctor(struct.getSdtinformaciondelacitanombresdoctor());
      setgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafotografiadoctor(struct.getSdtinformaciondelacitafotografiadoctor());
      setgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafotografiadoctor_gxi(struct.getSdtinformaciondelacitafotografiadoctor_gxi());
      setgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaespecialidaddoctor(struct.getSdtinformaciondelacitaespecialidaddoctor());
      setgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitatipoconsulta(struct.getSdtinformaciondelacitatipoconsulta());
      setgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitahora(struct.getSdtinformaciondelacitahora());
      setgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitacosto(struct.getSdtinformaciondelacitacosto());
      if ( struct.gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafecha_N == 0 )
      {
         setgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafecha(struct.getSdtinformaciondelacitafecha());
      }
      setgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaclinica(struct.getSdtinformaciondelacitaclinica());
      setgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitasede(struct.getSdtinformaciondelacitasede());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTInformacionDeLaCita getStruct( )
   {
      com.projectthani.StructSdtSDTInformacionDeLaCita struct = new com.projectthani.StructSdtSDTInformacionDeLaCita ();
      struct.setSdtinformaciondelacitaid(getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaid());
      struct.setSdtinformaciondelacitanombresdoctor(getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitanombresdoctor());
      struct.setSdtinformaciondelacitafotografiadoctor(getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafotografiadoctor());
      struct.setSdtinformaciondelacitafotografiadoctor_gxi(getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafotografiadoctor_gxi());
      struct.setSdtinformaciondelacitaespecialidaddoctor(getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaespecialidaddoctor());
      struct.setSdtinformaciondelacitatipoconsulta(getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitatipoconsulta());
      struct.setSdtinformaciondelacitahora(getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitahora());
      struct.setSdtinformaciondelacitacosto(getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitacosto());
      if ( gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafecha_N == 0 )
      {
         struct.setSdtinformaciondelacitafecha(getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafecha());
      }
      struct.setSdtinformaciondelacitaclinica(getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaclinica());
      struct.setSdtinformaciondelacitasede(getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitasede());
      return struct ;
   }

   protected byte gxTv_SdtSDTInformacionDeLaCita_N ;
   protected byte gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafecha_N ;
   protected short gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaid ;
   protected short gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitacosto ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitatipoconsulta ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafecha ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitanombresdoctor ;
   protected String gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafotografiadoctor_gxi ;
   protected String gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaespecialidaddoctor ;
   protected String gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitahora ;
   protected String gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaclinica ;
   protected String gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitasede ;
   protected String gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafotografiadoctor ;
}

