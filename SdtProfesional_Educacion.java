package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtProfesional_Educacion extends GxSilentTrnSdt implements Cloneable, java.io.Serializable
{
   public SdtProfesional_Educacion( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtProfesional_Educacion.class));
   }

   public SdtProfesional_Educacion( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle, context, "SdtProfesional_Educacion");
      initialize( remoteHandle) ;
   }

   public SdtProfesional_Educacion( int remoteHandle ,
                                    StructSdtProfesional_Educacion struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtProfesional_Educacion( )
   {
      super( new ModelContext(SdtProfesional_Educacion.class), "SdtProfesional_Educacion");
      initialize( ) ;
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"EducacionId", java.util.UUID.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Educacion");
      metadata.set("BT", "ProfesionalEducacion");
      metadata.set("PK", "[ \"EducacionId\" ]");
      metadata.set("PKAssigned", "[ \"EducacionId\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"ProfesionalId\" ],\"FKMap\":[  ] } ]");
      metadata.set("AllowInsert", "True");
      metadata.set("AllowUpdate", "True");
      metadata.set("AllowDelete", "True");
      return metadata ;
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "EducacionId") )
            {
               gxTv_SdtProfesional_Educacion_Educacionid = GXutil.strToGuid(oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EducacionNombreInstitucion") )
            {
               gxTv_SdtProfesional_Educacion_Educacionnombreinstitucion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EducacionDesde") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtProfesional_Educacion_Educaciondesde = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtProfesional_Educacion_Educaciondesde = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EducacionHasta") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtProfesional_Educacion_Educacionhasta = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtProfesional_Educacion_Educacionhasta = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EducacionPaisDescripcion") )
            {
               gxTv_SdtProfesional_Educacion_Educacionpaisdescripcion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtProfesional_Educacion_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtProfesional_Educacion_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtProfesional_Educacion_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EducacionId_Z") )
            {
               gxTv_SdtProfesional_Educacion_Educacionid_Z = GXutil.strToGuid(oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EducacionNombreInstitucion_Z") )
            {
               gxTv_SdtProfesional_Educacion_Educacionnombreinstitucion_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EducacionDesde_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtProfesional_Educacion_Educaciondesde_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtProfesional_Educacion_Educaciondesde_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EducacionHasta_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtProfesional_Educacion_Educacionhasta_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtProfesional_Educacion_Educacionhasta_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EducacionPaisDescripcion_Z") )
            {
               gxTv_SdtProfesional_Educacion_Educacionpaisdescripcion_Z = oReader.getValue() ;
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
         sName = "Profesional.Educacion" ;
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
      oWriter.writeElement("EducacionId", GXutil.rtrim( gxTv_SdtProfesional_Educacion_Educacionid.toString()));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("EducacionNombreInstitucion", GXutil.rtrim( gxTv_SdtProfesional_Educacion_Educacionnombreinstitucion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtProfesional_Educacion_Educaciondesde), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtProfesional_Educacion_Educaciondesde), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtProfesional_Educacion_Educaciondesde), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("EducacionDesde", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtProfesional_Educacion_Educacionhasta), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtProfesional_Educacion_Educacionhasta), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtProfesional_Educacion_Educacionhasta), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("EducacionHasta", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("EducacionPaisDescripcion", GXutil.rtrim( gxTv_SdtProfesional_Educacion_Educacionpaisdescripcion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", GXutil.rtrim( gxTv_SdtProfesional_Educacion_Mode));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtProfesional_Educacion_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtProfesional_Educacion_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("EducacionId_Z", GXutil.rtrim( gxTv_SdtProfesional_Educacion_Educacionid_Z.toString()));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("EducacionNombreInstitucion_Z", GXutil.rtrim( gxTv_SdtProfesional_Educacion_Educacionnombreinstitucion_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtProfesional_Educacion_Educaciondesde_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtProfesional_Educacion_Educaciondesde_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtProfesional_Educacion_Educaciondesde_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("EducacionDesde_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtProfesional_Educacion_Educacionhasta_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtProfesional_Educacion_Educacionhasta_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtProfesional_Educacion_Educacionhasta_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("EducacionHasta_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("EducacionPaisDescripcion_Z", GXutil.rtrim( gxTv_SdtProfesional_Educacion_Educacionpaisdescripcion_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
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
      AddObjectProperty("EducacionId", gxTv_SdtProfesional_Educacion_Educacionid, false, includeNonInitialized);
      AddObjectProperty("EducacionNombreInstitucion", gxTv_SdtProfesional_Educacion_Educacionnombreinstitucion, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtProfesional_Educacion_Educaciondesde), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtProfesional_Educacion_Educaciondesde), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtProfesional_Educacion_Educaciondesde), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("EducacionDesde", sDateCnv, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtProfesional_Educacion_Educacionhasta), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtProfesional_Educacion_Educacionhasta), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtProfesional_Educacion_Educacionhasta), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("EducacionHasta", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("EducacionPaisDescripcion", gxTv_SdtProfesional_Educacion_Educacionpaisdescripcion, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtProfesional_Educacion_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtProfesional_Educacion_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtProfesional_Educacion_Initialized, false, includeNonInitialized);
         AddObjectProperty("EducacionId_Z", gxTv_SdtProfesional_Educacion_Educacionid_Z, false, includeNonInitialized);
         AddObjectProperty("EducacionNombreInstitucion_Z", gxTv_SdtProfesional_Educacion_Educacionnombreinstitucion_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtProfesional_Educacion_Educaciondesde_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtProfesional_Educacion_Educaciondesde_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtProfesional_Educacion_Educaciondesde_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("EducacionDesde_Z", sDateCnv, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtProfesional_Educacion_Educacionhasta_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtProfesional_Educacion_Educacionhasta_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtProfesional_Educacion_Educacionhasta_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("EducacionHasta_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("EducacionPaisDescripcion_Z", gxTv_SdtProfesional_Educacion_Educacionpaisdescripcion_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.projectthani.SdtProfesional_Educacion sdt )
   {
      if ( sdt.IsDirty("EducacionId") )
      {
         gxTv_SdtProfesional_Educacion_N = (byte)(0) ;
         gxTv_SdtProfesional_Educacion_Educacionid = sdt.getgxTv_SdtProfesional_Educacion_Educacionid() ;
      }
      if ( sdt.IsDirty("EducacionNombreInstitucion") )
      {
         gxTv_SdtProfesional_Educacion_N = (byte)(0) ;
         gxTv_SdtProfesional_Educacion_Educacionnombreinstitucion = sdt.getgxTv_SdtProfesional_Educacion_Educacionnombreinstitucion() ;
      }
      if ( sdt.IsDirty("EducacionDesde") )
      {
         gxTv_SdtProfesional_Educacion_N = (byte)(0) ;
         gxTv_SdtProfesional_Educacion_Educaciondesde = sdt.getgxTv_SdtProfesional_Educacion_Educaciondesde() ;
      }
      if ( sdt.IsDirty("EducacionHasta") )
      {
         gxTv_SdtProfesional_Educacion_N = (byte)(0) ;
         gxTv_SdtProfesional_Educacion_Educacionhasta = sdt.getgxTv_SdtProfesional_Educacion_Educacionhasta() ;
      }
      if ( sdt.IsDirty("EducacionPaisDescripcion") )
      {
         gxTv_SdtProfesional_Educacion_N = (byte)(0) ;
         gxTv_SdtProfesional_Educacion_Educacionpaisdescripcion = sdt.getgxTv_SdtProfesional_Educacion_Educacionpaisdescripcion() ;
      }
   }

   public java.util.UUID getgxTv_SdtProfesional_Educacion_Educacionid( )
   {
      return gxTv_SdtProfesional_Educacion_Educacionid ;
   }

   public void setgxTv_SdtProfesional_Educacion_Educacionid( java.util.UUID value )
   {
      gxTv_SdtProfesional_Educacion_N = (byte)(0) ;
      gxTv_SdtProfesional_Educacion_Modified = (short)(1) ;
      SetDirty("Educacionid");
      gxTv_SdtProfesional_Educacion_Educacionid = value ;
   }

   public String getgxTv_SdtProfesional_Educacion_Educacionnombreinstitucion( )
   {
      return gxTv_SdtProfesional_Educacion_Educacionnombreinstitucion ;
   }

   public void setgxTv_SdtProfesional_Educacion_Educacionnombreinstitucion( String value )
   {
      gxTv_SdtProfesional_Educacion_N = (byte)(0) ;
      gxTv_SdtProfesional_Educacion_Modified = (short)(1) ;
      SetDirty("Educacionnombreinstitucion");
      gxTv_SdtProfesional_Educacion_Educacionnombreinstitucion = value ;
   }

   public java.util.Date getgxTv_SdtProfesional_Educacion_Educaciondesde( )
   {
      return gxTv_SdtProfesional_Educacion_Educaciondesde ;
   }

   public void setgxTv_SdtProfesional_Educacion_Educaciondesde( java.util.Date value )
   {
      gxTv_SdtProfesional_Educacion_N = (byte)(0) ;
      gxTv_SdtProfesional_Educacion_Modified = (short)(1) ;
      SetDirty("Educaciondesde");
      gxTv_SdtProfesional_Educacion_Educaciondesde = value ;
   }

   public java.util.Date getgxTv_SdtProfesional_Educacion_Educacionhasta( )
   {
      return gxTv_SdtProfesional_Educacion_Educacionhasta ;
   }

   public void setgxTv_SdtProfesional_Educacion_Educacionhasta( java.util.Date value )
   {
      gxTv_SdtProfesional_Educacion_N = (byte)(0) ;
      gxTv_SdtProfesional_Educacion_Modified = (short)(1) ;
      SetDirty("Educacionhasta");
      gxTv_SdtProfesional_Educacion_Educacionhasta = value ;
   }

   public String getgxTv_SdtProfesional_Educacion_Educacionpaisdescripcion( )
   {
      return gxTv_SdtProfesional_Educacion_Educacionpaisdescripcion ;
   }

   public void setgxTv_SdtProfesional_Educacion_Educacionpaisdescripcion( String value )
   {
      gxTv_SdtProfesional_Educacion_N = (byte)(0) ;
      gxTv_SdtProfesional_Educacion_Modified = (short)(1) ;
      SetDirty("Educacionpaisdescripcion");
      gxTv_SdtProfesional_Educacion_Educacionpaisdescripcion = value ;
   }

   public String getgxTv_SdtProfesional_Educacion_Mode( )
   {
      return gxTv_SdtProfesional_Educacion_Mode ;
   }

   public void setgxTv_SdtProfesional_Educacion_Mode( String value )
   {
      gxTv_SdtProfesional_Educacion_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtProfesional_Educacion_Mode = value ;
   }

   public void setgxTv_SdtProfesional_Educacion_Mode_SetNull( )
   {
      gxTv_SdtProfesional_Educacion_Mode = "" ;
   }

   public boolean getgxTv_SdtProfesional_Educacion_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtProfesional_Educacion_Modified( )
   {
      return gxTv_SdtProfesional_Educacion_Modified ;
   }

   public void setgxTv_SdtProfesional_Educacion_Modified( short value )
   {
      gxTv_SdtProfesional_Educacion_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtProfesional_Educacion_Modified = value ;
   }

   public void setgxTv_SdtProfesional_Educacion_Modified_SetNull( )
   {
      gxTv_SdtProfesional_Educacion_Modified = (short)(0) ;
   }

   public boolean getgxTv_SdtProfesional_Educacion_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtProfesional_Educacion_Initialized( )
   {
      return gxTv_SdtProfesional_Educacion_Initialized ;
   }

   public void setgxTv_SdtProfesional_Educacion_Initialized( short value )
   {
      gxTv_SdtProfesional_Educacion_N = (byte)(0) ;
      gxTv_SdtProfesional_Educacion_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtProfesional_Educacion_Initialized = value ;
   }

   public void setgxTv_SdtProfesional_Educacion_Initialized_SetNull( )
   {
      gxTv_SdtProfesional_Educacion_Initialized = (short)(0) ;
   }

   public boolean getgxTv_SdtProfesional_Educacion_Initialized_IsNull( )
   {
      return false ;
   }

   public java.util.UUID getgxTv_SdtProfesional_Educacion_Educacionid_Z( )
   {
      return gxTv_SdtProfesional_Educacion_Educacionid_Z ;
   }

   public void setgxTv_SdtProfesional_Educacion_Educacionid_Z( java.util.UUID value )
   {
      gxTv_SdtProfesional_Educacion_N = (byte)(0) ;
      gxTv_SdtProfesional_Educacion_Modified = (short)(1) ;
      SetDirty("Educacionid_Z");
      gxTv_SdtProfesional_Educacion_Educacionid_Z = value ;
   }

   public void setgxTv_SdtProfesional_Educacion_Educacionid_Z_SetNull( )
   {
      gxTv_SdtProfesional_Educacion_Educacionid_Z = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
   }

   public boolean getgxTv_SdtProfesional_Educacion_Educacionid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtProfesional_Educacion_Educacionnombreinstitucion_Z( )
   {
      return gxTv_SdtProfesional_Educacion_Educacionnombreinstitucion_Z ;
   }

   public void setgxTv_SdtProfesional_Educacion_Educacionnombreinstitucion_Z( String value )
   {
      gxTv_SdtProfesional_Educacion_N = (byte)(0) ;
      gxTv_SdtProfesional_Educacion_Modified = (short)(1) ;
      SetDirty("Educacionnombreinstitucion_Z");
      gxTv_SdtProfesional_Educacion_Educacionnombreinstitucion_Z = value ;
   }

   public void setgxTv_SdtProfesional_Educacion_Educacionnombreinstitucion_Z_SetNull( )
   {
      gxTv_SdtProfesional_Educacion_Educacionnombreinstitucion_Z = "" ;
   }

   public boolean getgxTv_SdtProfesional_Educacion_Educacionnombreinstitucion_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtProfesional_Educacion_Educaciondesde_Z( )
   {
      return gxTv_SdtProfesional_Educacion_Educaciondesde_Z ;
   }

   public void setgxTv_SdtProfesional_Educacion_Educaciondesde_Z( java.util.Date value )
   {
      gxTv_SdtProfesional_Educacion_N = (byte)(0) ;
      gxTv_SdtProfesional_Educacion_Modified = (short)(1) ;
      SetDirty("Educaciondesde_Z");
      gxTv_SdtProfesional_Educacion_Educaciondesde_Z = value ;
   }

   public void setgxTv_SdtProfesional_Educacion_Educaciondesde_Z_SetNull( )
   {
      gxTv_SdtProfesional_Educacion_Educaciondesde_Z = GXutil.nullDate() ;
   }

   public boolean getgxTv_SdtProfesional_Educacion_Educaciondesde_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtProfesional_Educacion_Educacionhasta_Z( )
   {
      return gxTv_SdtProfesional_Educacion_Educacionhasta_Z ;
   }

   public void setgxTv_SdtProfesional_Educacion_Educacionhasta_Z( java.util.Date value )
   {
      gxTv_SdtProfesional_Educacion_N = (byte)(0) ;
      gxTv_SdtProfesional_Educacion_Modified = (short)(1) ;
      SetDirty("Educacionhasta_Z");
      gxTv_SdtProfesional_Educacion_Educacionhasta_Z = value ;
   }

   public void setgxTv_SdtProfesional_Educacion_Educacionhasta_Z_SetNull( )
   {
      gxTv_SdtProfesional_Educacion_Educacionhasta_Z = GXutil.nullDate() ;
   }

   public boolean getgxTv_SdtProfesional_Educacion_Educacionhasta_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtProfesional_Educacion_Educacionpaisdescripcion_Z( )
   {
      return gxTv_SdtProfesional_Educacion_Educacionpaisdescripcion_Z ;
   }

   public void setgxTv_SdtProfesional_Educacion_Educacionpaisdescripcion_Z( String value )
   {
      gxTv_SdtProfesional_Educacion_N = (byte)(0) ;
      gxTv_SdtProfesional_Educacion_Modified = (short)(1) ;
      SetDirty("Educacionpaisdescripcion_Z");
      gxTv_SdtProfesional_Educacion_Educacionpaisdescripcion_Z = value ;
   }

   public void setgxTv_SdtProfesional_Educacion_Educacionpaisdescripcion_Z_SetNull( )
   {
      gxTv_SdtProfesional_Educacion_Educacionpaisdescripcion_Z = "" ;
   }

   public boolean getgxTv_SdtProfesional_Educacion_Educacionpaisdescripcion_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtProfesional_Educacion_Educacionid = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      gxTv_SdtProfesional_Educacion_N = (byte)(1) ;
      gxTv_SdtProfesional_Educacion_Educacionnombreinstitucion = "" ;
      gxTv_SdtProfesional_Educacion_Educaciondesde = GXutil.nullDate() ;
      gxTv_SdtProfesional_Educacion_Educacionhasta = GXutil.nullDate() ;
      gxTv_SdtProfesional_Educacion_Educacionpaisdescripcion = "" ;
      gxTv_SdtProfesional_Educacion_Mode = "" ;
      gxTv_SdtProfesional_Educacion_Educacionid_Z = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      gxTv_SdtProfesional_Educacion_Educacionnombreinstitucion_Z = "" ;
      gxTv_SdtProfesional_Educacion_Educaciondesde_Z = GXutil.nullDate() ;
      gxTv_SdtProfesional_Educacion_Educacionhasta_Z = GXutil.nullDate() ;
      gxTv_SdtProfesional_Educacion_Educacionpaisdescripcion_Z = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtProfesional_Educacion_N ;
   }

   public com.projectthani.SdtProfesional_Educacion Clone( )
   {
      return (com.projectthani.SdtProfesional_Educacion)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtProfesional_Educacion struct )
   {
      setgxTv_SdtProfesional_Educacion_Educacionid(struct.getEducacionid());
      setgxTv_SdtProfesional_Educacion_Educacionnombreinstitucion(struct.getEducacionnombreinstitucion());
      setgxTv_SdtProfesional_Educacion_Educaciondesde(struct.getEducaciondesde());
      setgxTv_SdtProfesional_Educacion_Educacionhasta(struct.getEducacionhasta());
      setgxTv_SdtProfesional_Educacion_Educacionpaisdescripcion(struct.getEducacionpaisdescripcion());
      setgxTv_SdtProfesional_Educacion_Mode(struct.getMode());
      setgxTv_SdtProfesional_Educacion_Modified(struct.getModified());
      setgxTv_SdtProfesional_Educacion_Initialized(struct.getInitialized());
      setgxTv_SdtProfesional_Educacion_Educacionid_Z(struct.getEducacionid_Z());
      setgxTv_SdtProfesional_Educacion_Educacionnombreinstitucion_Z(struct.getEducacionnombreinstitucion_Z());
      setgxTv_SdtProfesional_Educacion_Educaciondesde_Z(struct.getEducaciondesde_Z());
      setgxTv_SdtProfesional_Educacion_Educacionhasta_Z(struct.getEducacionhasta_Z());
      setgxTv_SdtProfesional_Educacion_Educacionpaisdescripcion_Z(struct.getEducacionpaisdescripcion_Z());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtProfesional_Educacion getStruct( )
   {
      com.projectthani.StructSdtProfesional_Educacion struct = new com.projectthani.StructSdtProfesional_Educacion ();
      struct.setEducacionid(getgxTv_SdtProfesional_Educacion_Educacionid());
      struct.setEducacionnombreinstitucion(getgxTv_SdtProfesional_Educacion_Educacionnombreinstitucion());
      struct.setEducaciondesde(getgxTv_SdtProfesional_Educacion_Educaciondesde());
      struct.setEducacionhasta(getgxTv_SdtProfesional_Educacion_Educacionhasta());
      struct.setEducacionpaisdescripcion(getgxTv_SdtProfesional_Educacion_Educacionpaisdescripcion());
      struct.setMode(getgxTv_SdtProfesional_Educacion_Mode());
      struct.setModified(getgxTv_SdtProfesional_Educacion_Modified());
      struct.setInitialized(getgxTv_SdtProfesional_Educacion_Initialized());
      struct.setEducacionid_Z(getgxTv_SdtProfesional_Educacion_Educacionid_Z());
      struct.setEducacionnombreinstitucion_Z(getgxTv_SdtProfesional_Educacion_Educacionnombreinstitucion_Z());
      struct.setEducaciondesde_Z(getgxTv_SdtProfesional_Educacion_Educaciondesde_Z());
      struct.setEducacionhasta_Z(getgxTv_SdtProfesional_Educacion_Educacionhasta_Z());
      struct.setEducacionpaisdescripcion_Z(getgxTv_SdtProfesional_Educacion_Educacionpaisdescripcion_Z());
      return struct ;
   }

   private byte gxTv_SdtProfesional_Educacion_N ;
   private short gxTv_SdtProfesional_Educacion_Modified ;
   private short gxTv_SdtProfesional_Educacion_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtProfesional_Educacion_Mode ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_SdtProfesional_Educacion_Educaciondesde ;
   private java.util.Date gxTv_SdtProfesional_Educacion_Educacionhasta ;
   private java.util.Date gxTv_SdtProfesional_Educacion_Educaciondesde_Z ;
   private java.util.Date gxTv_SdtProfesional_Educacion_Educacionhasta_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtProfesional_Educacion_Educacionnombreinstitucion ;
   private String gxTv_SdtProfesional_Educacion_Educacionpaisdescripcion ;
   private String gxTv_SdtProfesional_Educacion_Educacionnombreinstitucion_Z ;
   private String gxTv_SdtProfesional_Educacion_Educacionpaisdescripcion_Z ;
   private java.util.UUID gxTv_SdtProfesional_Educacion_Educacionid ;
   private java.util.UUID gxTv_SdtProfesional_Educacion_Educacionid_Z ;
}

