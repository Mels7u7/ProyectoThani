package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTCuentaPorVerificarProfesional extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTCuentaPorVerificarProfesional( )
   {
      this(  new ModelContext(SdtSDTCuentaPorVerificarProfesional.class));
   }

   public SdtSDTCuentaPorVerificarProfesional( ModelContext context )
   {
      super( context, "SdtSDTCuentaPorVerificarProfesional");
   }

   public SdtSDTCuentaPorVerificarProfesional( int remoteHandle ,
                                               ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTCuentaPorVerificarProfesional");
   }

   public SdtSDTCuentaPorVerificarProfesional( StructSdtSDTCuentaPorVerificarProfesional struct )
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
               gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalTipoDocumento") )
            {
               gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionaltipodocumento = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalNroDocumento") )
            {
               gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalnrodocumento = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalApellidoPaterno") )
            {
               gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalapellidopaterno = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalApellidoMaterno") )
            {
               gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalapellidomaterno = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalNombres") )
            {
               gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalnombres = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalSexo") )
            {
               gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalsexo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalCOP") )
            {
               gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalcop = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalTelefono") )
            {
               gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionaltelefono = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalCorreo") )
            {
               gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalcorreo = oReader.getValue() ;
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
                  gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalfecharegistro = GXutil.nullDate() ;
                  gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalfecharegistro_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalfecharegistro_N = (byte)(0) ;
                  gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalfecharegistro = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalEstadoCuenta") )
            {
               gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestadocuenta = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalEstado") )
            {
               gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestado = oReader.getValue() ;
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
         sName = "SDTCuentaPorVerificarProfesional" ;
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
      oWriter.writeElement("ProfesionalId", GXutil.trim( GXutil.str( gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalTipoDocumento", GXutil.rtrim( gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionaltipodocumento));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalNroDocumento", GXutil.rtrim( gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalnrodocumento));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalApellidoPaterno", GXutil.rtrim( gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalapellidopaterno));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalApellidoMaterno", GXutil.rtrim( gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalapellidomaterno));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalNombres", GXutil.rtrim( gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalnombres));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalSexo", GXutil.rtrim( gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalsexo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalCOP", GXutil.rtrim( gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalcop));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalTelefono", GXutil.rtrim( gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionaltelefono));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalCorreo", GXutil.rtrim( gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalcorreo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalfecharegistro)) && ( gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalfecharegistro_N == 1 ) )
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
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalfecharegistro), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalfecharegistro), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalfecharegistro), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("ProfesionalFechaRegistro", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      oWriter.writeElement("ProfesionalEstadoCuenta", GXutil.rtrim( gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestadocuenta));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalEstado", GXutil.rtrim( gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestado));
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
      AddObjectProperty("ProfesionalId", gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalid, false, false);
      AddObjectProperty("ProfesionalTipoDocumento", gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionaltipodocumento, false, false);
      AddObjectProperty("ProfesionalNroDocumento", gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalnrodocumento, false, false);
      AddObjectProperty("ProfesionalApellidoPaterno", gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalapellidopaterno, false, false);
      AddObjectProperty("ProfesionalApellidoMaterno", gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalapellidomaterno, false, false);
      AddObjectProperty("ProfesionalNombres", gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalnombres, false, false);
      AddObjectProperty("ProfesionalSexo", gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalsexo, false, false);
      AddObjectProperty("ProfesionalCOP", gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalcop, false, false);
      AddObjectProperty("ProfesionalTelefono", gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionaltelefono, false, false);
      AddObjectProperty("ProfesionalCorreo", gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalcorreo, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalfecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalfecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalfecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("ProfesionalFechaRegistro", sDateCnv, false, false);
      AddObjectProperty("ProfesionalEstadoCuenta", gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestadocuenta, false, false);
      AddObjectProperty("ProfesionalEstado", gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestado, false, false);
   }

   public int getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalid( )
   {
      return gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalid ;
   }

   public void setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalid( int value )
   {
      gxTv_SdtSDTCuentaPorVerificarProfesional_N = (byte)(0) ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalid = value ;
   }

   public String getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionaltipodocumento( )
   {
      return gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionaltipodocumento ;
   }

   public void setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionaltipodocumento( String value )
   {
      gxTv_SdtSDTCuentaPorVerificarProfesional_N = (byte)(0) ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionaltipodocumento = value ;
   }

   public String getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalnrodocumento( )
   {
      return gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalnrodocumento ;
   }

   public void setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalnrodocumento( String value )
   {
      gxTv_SdtSDTCuentaPorVerificarProfesional_N = (byte)(0) ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalnrodocumento = value ;
   }

   public String getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalapellidopaterno( )
   {
      return gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalapellidopaterno ;
   }

   public void setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalapellidopaterno( String value )
   {
      gxTv_SdtSDTCuentaPorVerificarProfesional_N = (byte)(0) ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalapellidopaterno = value ;
   }

   public String getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalapellidomaterno( )
   {
      return gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalapellidomaterno ;
   }

   public void setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalapellidomaterno( String value )
   {
      gxTv_SdtSDTCuentaPorVerificarProfesional_N = (byte)(0) ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalapellidomaterno = value ;
   }

   public String getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalnombres( )
   {
      return gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalnombres ;
   }

   public void setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalnombres( String value )
   {
      gxTv_SdtSDTCuentaPorVerificarProfesional_N = (byte)(0) ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalnombres = value ;
   }

   public String getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalsexo( )
   {
      return gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalsexo ;
   }

   public void setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalsexo( String value )
   {
      gxTv_SdtSDTCuentaPorVerificarProfesional_N = (byte)(0) ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalsexo = value ;
   }

   public String getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalcop( )
   {
      return gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalcop ;
   }

   public void setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalcop( String value )
   {
      gxTv_SdtSDTCuentaPorVerificarProfesional_N = (byte)(0) ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalcop = value ;
   }

   public String getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionaltelefono( )
   {
      return gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionaltelefono ;
   }

   public void setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionaltelefono( String value )
   {
      gxTv_SdtSDTCuentaPorVerificarProfesional_N = (byte)(0) ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionaltelefono = value ;
   }

   public String getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalcorreo( )
   {
      return gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalcorreo ;
   }

   public void setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalcorreo( String value )
   {
      gxTv_SdtSDTCuentaPorVerificarProfesional_N = (byte)(0) ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalcorreo = value ;
   }

   public java.util.Date getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalfecharegistro( )
   {
      return gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalfecharegistro ;
   }

   public void setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalfecharegistro( java.util.Date value )
   {
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalfecharegistro_N = (byte)(0) ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_N = (byte)(0) ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalfecharegistro = value ;
   }

   public String getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestadocuenta( )
   {
      return gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestadocuenta ;
   }

   public void setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestadocuenta( String value )
   {
      gxTv_SdtSDTCuentaPorVerificarProfesional_N = (byte)(0) ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestadocuenta = value ;
   }

   public String getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestado( )
   {
      return gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestado ;
   }

   public void setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestado( String value )
   {
      gxTv_SdtSDTCuentaPorVerificarProfesional_N = (byte)(0) ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestado = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTCuentaPorVerificarProfesional_N = (byte)(1) ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionaltipodocumento = "" ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalnrodocumento = "" ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalapellidopaterno = "" ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalapellidomaterno = "" ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalnombres = "" ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalsexo = "" ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalcop = "" ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionaltelefono = "" ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalcorreo = "" ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalfecharegistro = GXutil.nullDate() ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalfecharegistro_N = (byte)(1) ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestadocuenta = "" ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestado = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTCuentaPorVerificarProfesional_N ;
   }

   public com.projectthani.SdtSDTCuentaPorVerificarProfesional Clone( )
   {
      return (com.projectthani.SdtSDTCuentaPorVerificarProfesional)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTCuentaPorVerificarProfesional struct )
   {
      setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalid(struct.getProfesionalid());
      setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionaltipodocumento(struct.getProfesionaltipodocumento());
      setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalnrodocumento(struct.getProfesionalnrodocumento());
      setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalapellidopaterno(struct.getProfesionalapellidopaterno());
      setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalapellidomaterno(struct.getProfesionalapellidomaterno());
      setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalnombres(struct.getProfesionalnombres());
      setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalsexo(struct.getProfesionalsexo());
      setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalcop(struct.getProfesionalcop());
      setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionaltelefono(struct.getProfesionaltelefono());
      setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalcorreo(struct.getProfesionalcorreo());
      if ( struct.gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalfecharegistro_N == 0 )
      {
         setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalfecharegistro(struct.getProfesionalfecharegistro());
      }
      setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestadocuenta(struct.getProfesionalestadocuenta());
      setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestado(struct.getProfesionalestado());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTCuentaPorVerificarProfesional getStruct( )
   {
      com.projectthani.StructSdtSDTCuentaPorVerificarProfesional struct = new com.projectthani.StructSdtSDTCuentaPorVerificarProfesional ();
      struct.setProfesionalid(getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalid());
      struct.setProfesionaltipodocumento(getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionaltipodocumento());
      struct.setProfesionalnrodocumento(getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalnrodocumento());
      struct.setProfesionalapellidopaterno(getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalapellidopaterno());
      struct.setProfesionalapellidomaterno(getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalapellidomaterno());
      struct.setProfesionalnombres(getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalnombres());
      struct.setProfesionalsexo(getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalsexo());
      struct.setProfesionalcop(getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalcop());
      struct.setProfesionaltelefono(getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionaltelefono());
      struct.setProfesionalcorreo(getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalcorreo());
      if ( gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalfecharegistro_N == 0 )
      {
         struct.setProfesionalfecharegistro(getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalfecharegistro());
      }
      struct.setProfesionalestadocuenta(getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestadocuenta());
      struct.setProfesionalestado(getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestado());
      return struct ;
   }

   protected byte gxTv_SdtSDTCuentaPorVerificarProfesional_N ;
   protected byte gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalfecharegistro_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalid ;
   protected String gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionaltipodocumento ;
   protected String gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalsexo ;
   protected String gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionaltelefono ;
   protected String gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestadocuenta ;
   protected String gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestado ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalfecharegistro ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalnrodocumento ;
   protected String gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalapellidopaterno ;
   protected String gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalapellidomaterno ;
   protected String gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalnombres ;
   protected String gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalcop ;
   protected String gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalcorreo ;
}

