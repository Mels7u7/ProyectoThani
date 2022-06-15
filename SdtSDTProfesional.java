package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTProfesional extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTProfesional( )
   {
      this(  new ModelContext(SdtSDTProfesional.class));
   }

   public SdtSDTProfesional( ModelContext context )
   {
      super( context, "SdtSDTProfesional");
   }

   public SdtSDTProfesional( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTProfesional");
   }

   public SdtSDTProfesional( StructSdtSDTProfesional struct )
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
               gxTv_SdtSDTProfesional_Profesionalid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalTipoDocumento") )
            {
               gxTv_SdtSDTProfesional_Profesionaltipodocumento = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalNroDocumento") )
            {
               gxTv_SdtSDTProfesional_Profesionalnrodocumento = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalApellidoPaterno") )
            {
               gxTv_SdtSDTProfesional_Profesionalapellidopaterno = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalApellidoMaterno") )
            {
               gxTv_SdtSDTProfesional_Profesionalapellidomaterno = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalNombres") )
            {
               gxTv_SdtSDTProfesional_Profesionalnombres = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalFullName") )
            {
               gxTv_SdtSDTProfesional_Profesionalfullname = oReader.getValue() ;
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
                  gxTv_SdtSDTProfesional_Profesionalfechanacimiento = GXutil.nullDate() ;
                  gxTv_SdtSDTProfesional_Profesionalfechanacimiento_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtSDTProfesional_Profesionalfechanacimiento_N = (byte)(0) ;
                  gxTv_SdtSDTProfesional_Profesionalfechanacimiento = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalCorreo") )
            {
               gxTv_SdtSDTProfesional_Profesionalcorreo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalCOP") )
            {
               gxTv_SdtSDTProfesional_Profesionalcop = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalColorDisponible") )
            {
               gxTv_SdtSDTProfesional_Profesionalcolordisponible = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalColorCita") )
            {
               gxTv_SdtSDTProfesional_Profesionalcolorcita = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalTiempoCita") )
            {
               gxTv_SdtSDTProfesional_Profesionaltiempocita = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalEstado") )
            {
               gxTv_SdtSDTProfesional_Profesionalestado = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalFoto") )
            {
               gxTv_SdtSDTProfesional_Profesionalfoto = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalFoto_GXI") )
            {
               gxTv_SdtSDTProfesional_Profesionalfoto_gxi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Especialidad") )
            {
               if ( gxTv_SdtSDTProfesional_Especialidad == null )
               {
                  gxTv_SdtSDTProfesional_Especialidad = new GXBaseCollection<com.projectthani.SdtSDTProfesional_EspecialidadItem>(com.projectthani.SdtSDTProfesional_EspecialidadItem.class, "SDTProfesional.EspecialidadItem", "ProjectThani", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_SdtSDTProfesional_Especialidad.readxmlcollection(oReader, "Especialidad", "EspecialidadItem") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Especialidad") )
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
         sName = "SDTProfesional" ;
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
      oWriter.writeElement("ProfesionalId", GXutil.trim( GXutil.str( gxTv_SdtSDTProfesional_Profesionalid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalTipoDocumento", GXutil.rtrim( gxTv_SdtSDTProfesional_Profesionaltipodocumento));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalNroDocumento", GXutil.rtrim( gxTv_SdtSDTProfesional_Profesionalnrodocumento));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalApellidoPaterno", GXutil.rtrim( gxTv_SdtSDTProfesional_Profesionalapellidopaterno));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalApellidoMaterno", GXutil.rtrim( gxTv_SdtSDTProfesional_Profesionalapellidomaterno));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalNombres", GXutil.rtrim( gxTv_SdtSDTProfesional_Profesionalnombres));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalFullName", GXutil.rtrim( gxTv_SdtSDTProfesional_Profesionalfullname));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_SdtSDTProfesional_Profesionalfechanacimiento)) && ( gxTv_SdtSDTProfesional_Profesionalfechanacimiento_N == 1 ) )
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
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTProfesional_Profesionalfechanacimiento), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTProfesional_Profesionalfechanacimiento), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTProfesional_Profesionalfechanacimiento), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("ProfesionalFechaNacimiento", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      oWriter.writeElement("ProfesionalCorreo", GXutil.rtrim( gxTv_SdtSDTProfesional_Profesionalcorreo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalCOP", GXutil.rtrim( gxTv_SdtSDTProfesional_Profesionalcop));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalColorDisponible", GXutil.rtrim( gxTv_SdtSDTProfesional_Profesionalcolordisponible));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalColorCita", GXutil.rtrim( gxTv_SdtSDTProfesional_Profesionalcolorcita));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalTiempoCita", GXutil.trim( GXutil.str( gxTv_SdtSDTProfesional_Profesionaltiempocita, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalEstado", GXutil.rtrim( gxTv_SdtSDTProfesional_Profesionalestado));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalFoto", GXutil.rtrim( gxTv_SdtSDTProfesional_Profesionalfoto));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalFoto_GXI", GXutil.rtrim( gxTv_SdtSDTProfesional_Profesionalfoto_gxi));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( gxTv_SdtSDTProfesional_Especialidad != null )
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
         gxTv_SdtSDTProfesional_Especialidad.writexmlcollection(oWriter, "Especialidad", sNameSpace1, "EspecialidadItem", sNameSpace1);
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
      AddObjectProperty("ProfesionalId", gxTv_SdtSDTProfesional_Profesionalid, false, false);
      AddObjectProperty("ProfesionalTipoDocumento", gxTv_SdtSDTProfesional_Profesionaltipodocumento, false, false);
      AddObjectProperty("ProfesionalNroDocumento", gxTv_SdtSDTProfesional_Profesionalnrodocumento, false, false);
      AddObjectProperty("ProfesionalApellidoPaterno", gxTv_SdtSDTProfesional_Profesionalapellidopaterno, false, false);
      AddObjectProperty("ProfesionalApellidoMaterno", gxTv_SdtSDTProfesional_Profesionalapellidomaterno, false, false);
      AddObjectProperty("ProfesionalNombres", gxTv_SdtSDTProfesional_Profesionalnombres, false, false);
      AddObjectProperty("ProfesionalFullName", gxTv_SdtSDTProfesional_Profesionalfullname, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTProfesional_Profesionalfechanacimiento), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTProfesional_Profesionalfechanacimiento), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTProfesional_Profesionalfechanacimiento), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("ProfesionalFechaNacimiento", sDateCnv, false, false);
      AddObjectProperty("ProfesionalCorreo", gxTv_SdtSDTProfesional_Profesionalcorreo, false, false);
      AddObjectProperty("ProfesionalCOP", gxTv_SdtSDTProfesional_Profesionalcop, false, false);
      AddObjectProperty("ProfesionalColorDisponible", gxTv_SdtSDTProfesional_Profesionalcolordisponible, false, false);
      AddObjectProperty("ProfesionalColorCita", gxTv_SdtSDTProfesional_Profesionalcolorcita, false, false);
      AddObjectProperty("ProfesionalTiempoCita", gxTv_SdtSDTProfesional_Profesionaltiempocita, false, false);
      AddObjectProperty("ProfesionalEstado", gxTv_SdtSDTProfesional_Profesionalestado, false, false);
      AddObjectProperty("ProfesionalFoto", gxTv_SdtSDTProfesional_Profesionalfoto, false, false);
      AddObjectProperty("ProfesionalFoto_GXI", gxTv_SdtSDTProfesional_Profesionalfoto_gxi, false, false);
      if ( gxTv_SdtSDTProfesional_Especialidad != null )
      {
         AddObjectProperty("Especialidad", gxTv_SdtSDTProfesional_Especialidad, false, false);
      }
   }

   public int getgxTv_SdtSDTProfesional_Profesionalid( )
   {
      return gxTv_SdtSDTProfesional_Profesionalid ;
   }

   public void setgxTv_SdtSDTProfesional_Profesionalid( int value )
   {
      gxTv_SdtSDTProfesional_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_Profesionalid = value ;
   }

   public String getgxTv_SdtSDTProfesional_Profesionaltipodocumento( )
   {
      return gxTv_SdtSDTProfesional_Profesionaltipodocumento ;
   }

   public void setgxTv_SdtSDTProfesional_Profesionaltipodocumento( String value )
   {
      gxTv_SdtSDTProfesional_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_Profesionaltipodocumento = value ;
   }

   public String getgxTv_SdtSDTProfesional_Profesionalnrodocumento( )
   {
      return gxTv_SdtSDTProfesional_Profesionalnrodocumento ;
   }

   public void setgxTv_SdtSDTProfesional_Profesionalnrodocumento( String value )
   {
      gxTv_SdtSDTProfesional_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_Profesionalnrodocumento = value ;
   }

   public String getgxTv_SdtSDTProfesional_Profesionalapellidopaterno( )
   {
      return gxTv_SdtSDTProfesional_Profesionalapellidopaterno ;
   }

   public void setgxTv_SdtSDTProfesional_Profesionalapellidopaterno( String value )
   {
      gxTv_SdtSDTProfesional_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_Profesionalapellidopaterno = value ;
   }

   public String getgxTv_SdtSDTProfesional_Profesionalapellidomaterno( )
   {
      return gxTv_SdtSDTProfesional_Profesionalapellidomaterno ;
   }

   public void setgxTv_SdtSDTProfesional_Profesionalapellidomaterno( String value )
   {
      gxTv_SdtSDTProfesional_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_Profesionalapellidomaterno = value ;
   }

   public String getgxTv_SdtSDTProfesional_Profesionalnombres( )
   {
      return gxTv_SdtSDTProfesional_Profesionalnombres ;
   }

   public void setgxTv_SdtSDTProfesional_Profesionalnombres( String value )
   {
      gxTv_SdtSDTProfesional_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_Profesionalnombres = value ;
   }

   public String getgxTv_SdtSDTProfesional_Profesionalfullname( )
   {
      return gxTv_SdtSDTProfesional_Profesionalfullname ;
   }

   public void setgxTv_SdtSDTProfesional_Profesionalfullname( String value )
   {
      gxTv_SdtSDTProfesional_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_Profesionalfullname = value ;
   }

   public java.util.Date getgxTv_SdtSDTProfesional_Profesionalfechanacimiento( )
   {
      return gxTv_SdtSDTProfesional_Profesionalfechanacimiento ;
   }

   public void setgxTv_SdtSDTProfesional_Profesionalfechanacimiento( java.util.Date value )
   {
      gxTv_SdtSDTProfesional_Profesionalfechanacimiento_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_Profesionalfechanacimiento = value ;
   }

   public String getgxTv_SdtSDTProfesional_Profesionalcorreo( )
   {
      return gxTv_SdtSDTProfesional_Profesionalcorreo ;
   }

   public void setgxTv_SdtSDTProfesional_Profesionalcorreo( String value )
   {
      gxTv_SdtSDTProfesional_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_Profesionalcorreo = value ;
   }

   public String getgxTv_SdtSDTProfesional_Profesionalcop( )
   {
      return gxTv_SdtSDTProfesional_Profesionalcop ;
   }

   public void setgxTv_SdtSDTProfesional_Profesionalcop( String value )
   {
      gxTv_SdtSDTProfesional_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_Profesionalcop = value ;
   }

   public String getgxTv_SdtSDTProfesional_Profesionalcolordisponible( )
   {
      return gxTv_SdtSDTProfesional_Profesionalcolordisponible ;
   }

   public void setgxTv_SdtSDTProfesional_Profesionalcolordisponible( String value )
   {
      gxTv_SdtSDTProfesional_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_Profesionalcolordisponible = value ;
   }

   public String getgxTv_SdtSDTProfesional_Profesionalcolorcita( )
   {
      return gxTv_SdtSDTProfesional_Profesionalcolorcita ;
   }

   public void setgxTv_SdtSDTProfesional_Profesionalcolorcita( String value )
   {
      gxTv_SdtSDTProfesional_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_Profesionalcolorcita = value ;
   }

   public byte getgxTv_SdtSDTProfesional_Profesionaltiempocita( )
   {
      return gxTv_SdtSDTProfesional_Profesionaltiempocita ;
   }

   public void setgxTv_SdtSDTProfesional_Profesionaltiempocita( byte value )
   {
      gxTv_SdtSDTProfesional_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_Profesionaltiempocita = value ;
   }

   public String getgxTv_SdtSDTProfesional_Profesionalestado( )
   {
      return gxTv_SdtSDTProfesional_Profesionalestado ;
   }

   public void setgxTv_SdtSDTProfesional_Profesionalestado( String value )
   {
      gxTv_SdtSDTProfesional_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_Profesionalestado = value ;
   }

   @GxUpload
   public String getgxTv_SdtSDTProfesional_Profesionalfoto( )
   {
      return gxTv_SdtSDTProfesional_Profesionalfoto ;
   }

   public void setgxTv_SdtSDTProfesional_Profesionalfoto( String value )
   {
      gxTv_SdtSDTProfesional_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_Profesionalfoto = value ;
   }

   public String getgxTv_SdtSDTProfesional_Profesionalfoto_gxi( )
   {
      return gxTv_SdtSDTProfesional_Profesionalfoto_gxi ;
   }

   public void setgxTv_SdtSDTProfesional_Profesionalfoto_gxi( String value )
   {
      gxTv_SdtSDTProfesional_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_Profesionalfoto_gxi = value ;
   }

   public GXBaseCollection<com.projectthani.SdtSDTProfesional_EspecialidadItem> getgxTv_SdtSDTProfesional_Especialidad( )
   {
      if ( gxTv_SdtSDTProfesional_Especialidad == null )
      {
         gxTv_SdtSDTProfesional_Especialidad = new GXBaseCollection<com.projectthani.SdtSDTProfesional_EspecialidadItem>(com.projectthani.SdtSDTProfesional_EspecialidadItem.class, "SDTProfesional.EspecialidadItem", "ProjectThani", remoteHandle);
      }
      gxTv_SdtSDTProfesional_Especialidad_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_N = (byte)(0) ;
      return gxTv_SdtSDTProfesional_Especialidad ;
   }

   public void setgxTv_SdtSDTProfesional_Especialidad( GXBaseCollection<com.projectthani.SdtSDTProfesional_EspecialidadItem> value )
   {
      gxTv_SdtSDTProfesional_Especialidad_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_Especialidad = value ;
   }

   public void setgxTv_SdtSDTProfesional_Especialidad_SetNull( )
   {
      gxTv_SdtSDTProfesional_Especialidad_N = (byte)(1) ;
      gxTv_SdtSDTProfesional_Especialidad = null ;
   }

   public boolean getgxTv_SdtSDTProfesional_Especialidad_IsNull( )
   {
      if ( gxTv_SdtSDTProfesional_Especialidad == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtSDTProfesional_Especialidad_N( )
   {
      return gxTv_SdtSDTProfesional_Especialidad_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTProfesional_N = (byte)(1) ;
      gxTv_SdtSDTProfesional_Profesionaltipodocumento = "" ;
      gxTv_SdtSDTProfesional_Profesionalnrodocumento = "" ;
      gxTv_SdtSDTProfesional_Profesionalapellidopaterno = "" ;
      gxTv_SdtSDTProfesional_Profesionalapellidomaterno = "" ;
      gxTv_SdtSDTProfesional_Profesionalnombres = "" ;
      gxTv_SdtSDTProfesional_Profesionalfullname = "" ;
      gxTv_SdtSDTProfesional_Profesionalfechanacimiento = GXutil.nullDate() ;
      gxTv_SdtSDTProfesional_Profesionalfechanacimiento_N = (byte)(1) ;
      gxTv_SdtSDTProfesional_Profesionalcorreo = "" ;
      gxTv_SdtSDTProfesional_Profesionalcop = "" ;
      gxTv_SdtSDTProfesional_Profesionalcolordisponible = "" ;
      gxTv_SdtSDTProfesional_Profesionalcolorcita = "" ;
      gxTv_SdtSDTProfesional_Profesionaltiempocita = (byte)(30) ;
      gxTv_SdtSDTProfesional_Profesionalestado = "" ;
      gxTv_SdtSDTProfesional_Profesionalfoto = "" ;
      gxTv_SdtSDTProfesional_Profesionalfoto_gxi = "" ;
      gxTv_SdtSDTProfesional_Especialidad_N = (byte)(1) ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTProfesional_N ;
   }

   public com.projectthani.SdtSDTProfesional Clone( )
   {
      return (com.projectthani.SdtSDTProfesional)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTProfesional struct )
   {
      setgxTv_SdtSDTProfesional_Profesionalid(struct.getProfesionalid());
      setgxTv_SdtSDTProfesional_Profesionaltipodocumento(struct.getProfesionaltipodocumento());
      setgxTv_SdtSDTProfesional_Profesionalnrodocumento(struct.getProfesionalnrodocumento());
      setgxTv_SdtSDTProfesional_Profesionalapellidopaterno(struct.getProfesionalapellidopaterno());
      setgxTv_SdtSDTProfesional_Profesionalapellidomaterno(struct.getProfesionalapellidomaterno());
      setgxTv_SdtSDTProfesional_Profesionalnombres(struct.getProfesionalnombres());
      setgxTv_SdtSDTProfesional_Profesionalfullname(struct.getProfesionalfullname());
      if ( struct.gxTv_SdtSDTProfesional_Profesionalfechanacimiento_N == 0 )
      {
         setgxTv_SdtSDTProfesional_Profesionalfechanacimiento(struct.getProfesionalfechanacimiento());
      }
      setgxTv_SdtSDTProfesional_Profesionalcorreo(struct.getProfesionalcorreo());
      setgxTv_SdtSDTProfesional_Profesionalcop(struct.getProfesionalcop());
      setgxTv_SdtSDTProfesional_Profesionalcolordisponible(struct.getProfesionalcolordisponible());
      setgxTv_SdtSDTProfesional_Profesionalcolorcita(struct.getProfesionalcolorcita());
      setgxTv_SdtSDTProfesional_Profesionaltiempocita(struct.getProfesionaltiempocita());
      setgxTv_SdtSDTProfesional_Profesionalestado(struct.getProfesionalestado());
      setgxTv_SdtSDTProfesional_Profesionalfoto(struct.getProfesionalfoto());
      setgxTv_SdtSDTProfesional_Profesionalfoto_gxi(struct.getProfesionalfoto_gxi());
      GXBaseCollection<com.projectthani.SdtSDTProfesional_EspecialidadItem> gxTv_SdtSDTProfesional_Especialidad_aux = new GXBaseCollection<com.projectthani.SdtSDTProfesional_EspecialidadItem>(com.projectthani.SdtSDTProfesional_EspecialidadItem.class, "SDTProfesional.EspecialidadItem", "ProjectThani", remoteHandle);
      Vector<com.projectthani.StructSdtSDTProfesional_EspecialidadItem> gxTv_SdtSDTProfesional_Especialidad_aux1 = struct.getEspecialidad();
      if (gxTv_SdtSDTProfesional_Especialidad_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtSDTProfesional_Especialidad_aux1.size(); i++)
         {
            gxTv_SdtSDTProfesional_Especialidad_aux.add(new com.projectthani.SdtSDTProfesional_EspecialidadItem(gxTv_SdtSDTProfesional_Especialidad_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtSDTProfesional_Especialidad(gxTv_SdtSDTProfesional_Especialidad_aux);
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTProfesional getStruct( )
   {
      com.projectthani.StructSdtSDTProfesional struct = new com.projectthani.StructSdtSDTProfesional ();
      struct.setProfesionalid(getgxTv_SdtSDTProfesional_Profesionalid());
      struct.setProfesionaltipodocumento(getgxTv_SdtSDTProfesional_Profesionaltipodocumento());
      struct.setProfesionalnrodocumento(getgxTv_SdtSDTProfesional_Profesionalnrodocumento());
      struct.setProfesionalapellidopaterno(getgxTv_SdtSDTProfesional_Profesionalapellidopaterno());
      struct.setProfesionalapellidomaterno(getgxTv_SdtSDTProfesional_Profesionalapellidomaterno());
      struct.setProfesionalnombres(getgxTv_SdtSDTProfesional_Profesionalnombres());
      struct.setProfesionalfullname(getgxTv_SdtSDTProfesional_Profesionalfullname());
      if ( gxTv_SdtSDTProfesional_Profesionalfechanacimiento_N == 0 )
      {
         struct.setProfesionalfechanacimiento(getgxTv_SdtSDTProfesional_Profesionalfechanacimiento());
      }
      struct.setProfesionalcorreo(getgxTv_SdtSDTProfesional_Profesionalcorreo());
      struct.setProfesionalcop(getgxTv_SdtSDTProfesional_Profesionalcop());
      struct.setProfesionalcolordisponible(getgxTv_SdtSDTProfesional_Profesionalcolordisponible());
      struct.setProfesionalcolorcita(getgxTv_SdtSDTProfesional_Profesionalcolorcita());
      struct.setProfesionaltiempocita(getgxTv_SdtSDTProfesional_Profesionaltiempocita());
      struct.setProfesionalestado(getgxTv_SdtSDTProfesional_Profesionalestado());
      struct.setProfesionalfoto(getgxTv_SdtSDTProfesional_Profesionalfoto());
      struct.setProfesionalfoto_gxi(getgxTv_SdtSDTProfesional_Profesionalfoto_gxi());
      struct.setEspecialidad(getgxTv_SdtSDTProfesional_Especialidad().getStruct());
      return struct ;
   }

   protected byte gxTv_SdtSDTProfesional_N ;
   protected byte gxTv_SdtSDTProfesional_Profesionalfechanacimiento_N ;
   protected byte gxTv_SdtSDTProfesional_Profesionaltiempocita ;
   protected byte gxTv_SdtSDTProfesional_Especialidad_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_SdtSDTProfesional_Profesionalid ;
   protected String gxTv_SdtSDTProfesional_Profesionaltipodocumento ;
   protected String gxTv_SdtSDTProfesional_Profesionalcolordisponible ;
   protected String gxTv_SdtSDTProfesional_Profesionalcolorcita ;
   protected String gxTv_SdtSDTProfesional_Profesionalestado ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_SdtSDTProfesional_Profesionalfechanacimiento ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTProfesional_Profesionalnrodocumento ;
   protected String gxTv_SdtSDTProfesional_Profesionalapellidopaterno ;
   protected String gxTv_SdtSDTProfesional_Profesionalapellidomaterno ;
   protected String gxTv_SdtSDTProfesional_Profesionalnombres ;
   protected String gxTv_SdtSDTProfesional_Profesionalfullname ;
   protected String gxTv_SdtSDTProfesional_Profesionalcorreo ;
   protected String gxTv_SdtSDTProfesional_Profesionalcop ;
   protected String gxTv_SdtSDTProfesional_Profesionalfoto_gxi ;
   protected String gxTv_SdtSDTProfesional_Profesionalfoto ;
   protected GXBaseCollection<com.projectthani.SdtSDTProfesional_EspecialidadItem> gxTv_SdtSDTProfesional_Especialidad_aux ;
   protected GXBaseCollection<com.projectthani.SdtSDTProfesional_EspecialidadItem> gxTv_SdtSDTProfesional_Especialidad=null ;
}

