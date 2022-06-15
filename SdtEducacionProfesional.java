package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtEducacionProfesional extends GxSilentTrnSdt implements Cloneable, java.io.Serializable
{
   public SdtEducacionProfesional( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtEducacionProfesional.class));
   }

   public SdtEducacionProfesional( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle, context, "SdtEducacionProfesional");
      initialize( remoteHandle) ;
   }

   public SdtEducacionProfesional( int remoteHandle ,
                                   StructSdtEducacionProfesional struct )
   {
      this(remoteHandle);
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

   public void Load( int AV59EducacionProfesionalId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV59EducacionProfesionalId)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"EducacionProfesionalId", int.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "EducacionProfesional");
      metadata.set("BT", "EducacionProfesional");
      metadata.set("PK", "[ \"EducacionProfesionalId\" ]");
      metadata.set("PKAssigned", "[ \"EducacionProfesionalId\" ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "EducacionProfesionalId") )
            {
               gxTv_SdtEducacionProfesional_Educacionprofesionalid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalId") )
            {
               gxTv_SdtEducacionProfesional_Profesionalid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EducacionProfesionalNombreInstitucion") )
            {
               gxTv_SdtEducacionProfesional_Educacionprofesionalnombreinstitucion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EducacionProfesionalPais") )
            {
               gxTv_SdtEducacionProfesional_Educacionprofesionalpais = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EducacionProfesionalDesde") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtEducacionProfesional_Educacionprofesionaldesde = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtEducacionProfesional_Educacionprofesionaldesde = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EducacionProfesionalHasta") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtEducacionProfesional_Educacionprofesionalhasta = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtEducacionProfesional_Educacionprofesionalhasta = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtEducacionProfesional_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtEducacionProfesional_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EducacionProfesionalId_Z") )
            {
               gxTv_SdtEducacionProfesional_Educacionprofesionalid_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalId_Z") )
            {
               gxTv_SdtEducacionProfesional_Profesionalid_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EducacionProfesionalNombreInstitucion_Z") )
            {
               gxTv_SdtEducacionProfesional_Educacionprofesionalnombreinstitucion_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EducacionProfesionalPais_Z") )
            {
               gxTv_SdtEducacionProfesional_Educacionprofesionalpais_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EducacionProfesionalDesde_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtEducacionProfesional_Educacionprofesionaldesde_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtEducacionProfesional_Educacionprofesionaldesde_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EducacionProfesionalHasta_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtEducacionProfesional_Educacionprofesionalhasta_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtEducacionProfesional_Educacionprofesionalhasta_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
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
         sName = "EducacionProfesional" ;
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
      oWriter.writeElement("EducacionProfesionalId", GXutil.trim( GXutil.str( gxTv_SdtEducacionProfesional_Educacionprofesionalid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalId", GXutil.trim( GXutil.str( gxTv_SdtEducacionProfesional_Profesionalid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("EducacionProfesionalNombreInstitucion", GXutil.rtrim( gxTv_SdtEducacionProfesional_Educacionprofesionalnombreinstitucion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("EducacionProfesionalPais", GXutil.rtrim( gxTv_SdtEducacionProfesional_Educacionprofesionalpais));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtEducacionProfesional_Educacionprofesionaldesde), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtEducacionProfesional_Educacionprofesionaldesde), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtEducacionProfesional_Educacionprofesionaldesde), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("EducacionProfesionalDesde", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtEducacionProfesional_Educacionprofesionalhasta), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtEducacionProfesional_Educacionprofesionalhasta), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtEducacionProfesional_Educacionprofesionalhasta), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("EducacionProfesionalHasta", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", GXutil.rtrim( gxTv_SdtEducacionProfesional_Mode));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtEducacionProfesional_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("EducacionProfesionalId_Z", GXutil.trim( GXutil.str( gxTv_SdtEducacionProfesional_Educacionprofesionalid_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ProfesionalId_Z", GXutil.trim( GXutil.str( gxTv_SdtEducacionProfesional_Profesionalid_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("EducacionProfesionalNombreInstitucion_Z", GXutil.rtrim( gxTv_SdtEducacionProfesional_Educacionprofesionalnombreinstitucion_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("EducacionProfesionalPais_Z", GXutil.rtrim( gxTv_SdtEducacionProfesional_Educacionprofesionalpais_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtEducacionProfesional_Educacionprofesionaldesde_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtEducacionProfesional_Educacionprofesionaldesde_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtEducacionProfesional_Educacionprofesionaldesde_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("EducacionProfesionalDesde_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtEducacionProfesional_Educacionprofesionalhasta_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtEducacionProfesional_Educacionprofesionalhasta_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtEducacionProfesional_Educacionprofesionalhasta_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("EducacionProfesionalHasta_Z", sDateCnv);
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
      AddObjectProperty("EducacionProfesionalId", gxTv_SdtEducacionProfesional_Educacionprofesionalid, false, includeNonInitialized);
      AddObjectProperty("ProfesionalId", gxTv_SdtEducacionProfesional_Profesionalid, false, includeNonInitialized);
      AddObjectProperty("EducacionProfesionalNombreInstitucion", gxTv_SdtEducacionProfesional_Educacionprofesionalnombreinstitucion, false, includeNonInitialized);
      AddObjectProperty("EducacionProfesionalPais", gxTv_SdtEducacionProfesional_Educacionprofesionalpais, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtEducacionProfesional_Educacionprofesionaldesde), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtEducacionProfesional_Educacionprofesionaldesde), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtEducacionProfesional_Educacionprofesionaldesde), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("EducacionProfesionalDesde", sDateCnv, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtEducacionProfesional_Educacionprofesionalhasta), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtEducacionProfesional_Educacionprofesionalhasta), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtEducacionProfesional_Educacionprofesionalhasta), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("EducacionProfesionalHasta", sDateCnv, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtEducacionProfesional_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtEducacionProfesional_Initialized, false, includeNonInitialized);
         AddObjectProperty("EducacionProfesionalId_Z", gxTv_SdtEducacionProfesional_Educacionprofesionalid_Z, false, includeNonInitialized);
         AddObjectProperty("ProfesionalId_Z", gxTv_SdtEducacionProfesional_Profesionalid_Z, false, includeNonInitialized);
         AddObjectProperty("EducacionProfesionalNombreInstitucion_Z", gxTv_SdtEducacionProfesional_Educacionprofesionalnombreinstitucion_Z, false, includeNonInitialized);
         AddObjectProperty("EducacionProfesionalPais_Z", gxTv_SdtEducacionProfesional_Educacionprofesionalpais_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtEducacionProfesional_Educacionprofesionaldesde_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtEducacionProfesional_Educacionprofesionaldesde_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtEducacionProfesional_Educacionprofesionaldesde_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("EducacionProfesionalDesde_Z", sDateCnv, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtEducacionProfesional_Educacionprofesionalhasta_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtEducacionProfesional_Educacionprofesionalhasta_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtEducacionProfesional_Educacionprofesionalhasta_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("EducacionProfesionalHasta_Z", sDateCnv, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.projectthani.SdtEducacionProfesional sdt )
   {
      if ( sdt.IsDirty("EducacionProfesionalId") )
      {
         gxTv_SdtEducacionProfesional_N = (byte)(0) ;
         gxTv_SdtEducacionProfesional_Educacionprofesionalid = sdt.getgxTv_SdtEducacionProfesional_Educacionprofesionalid() ;
      }
      if ( sdt.IsDirty("ProfesionalId") )
      {
         gxTv_SdtEducacionProfesional_N = (byte)(0) ;
         gxTv_SdtEducacionProfesional_Profesionalid = sdt.getgxTv_SdtEducacionProfesional_Profesionalid() ;
      }
      if ( sdt.IsDirty("EducacionProfesionalNombreInstitucion") )
      {
         gxTv_SdtEducacionProfesional_N = (byte)(0) ;
         gxTv_SdtEducacionProfesional_Educacionprofesionalnombreinstitucion = sdt.getgxTv_SdtEducacionProfesional_Educacionprofesionalnombreinstitucion() ;
      }
      if ( sdt.IsDirty("EducacionProfesionalPais") )
      {
         gxTv_SdtEducacionProfesional_N = (byte)(0) ;
         gxTv_SdtEducacionProfesional_Educacionprofesionalpais = sdt.getgxTv_SdtEducacionProfesional_Educacionprofesionalpais() ;
      }
      if ( sdt.IsDirty("EducacionProfesionalDesde") )
      {
         gxTv_SdtEducacionProfesional_N = (byte)(0) ;
         gxTv_SdtEducacionProfesional_Educacionprofesionaldesde = sdt.getgxTv_SdtEducacionProfesional_Educacionprofesionaldesde() ;
      }
      if ( sdt.IsDirty("EducacionProfesionalHasta") )
      {
         gxTv_SdtEducacionProfesional_N = (byte)(0) ;
         gxTv_SdtEducacionProfesional_Educacionprofesionalhasta = sdt.getgxTv_SdtEducacionProfesional_Educacionprofesionalhasta() ;
      }
   }

   public int getgxTv_SdtEducacionProfesional_Educacionprofesionalid( )
   {
      return gxTv_SdtEducacionProfesional_Educacionprofesionalid ;
   }

   public void setgxTv_SdtEducacionProfesional_Educacionprofesionalid( int value )
   {
      gxTv_SdtEducacionProfesional_N = (byte)(0) ;
      if ( gxTv_SdtEducacionProfesional_Educacionprofesionalid != value )
      {
         gxTv_SdtEducacionProfesional_Mode = "INS" ;
         this.setgxTv_SdtEducacionProfesional_Educacionprofesionalid_Z_SetNull( );
         this.setgxTv_SdtEducacionProfesional_Profesionalid_Z_SetNull( );
         this.setgxTv_SdtEducacionProfesional_Educacionprofesionalnombreinstitucion_Z_SetNull( );
         this.setgxTv_SdtEducacionProfesional_Educacionprofesionalpais_Z_SetNull( );
         this.setgxTv_SdtEducacionProfesional_Educacionprofesionaldesde_Z_SetNull( );
         this.setgxTv_SdtEducacionProfesional_Educacionprofesionalhasta_Z_SetNull( );
      }
      SetDirty("Educacionprofesionalid");
      gxTv_SdtEducacionProfesional_Educacionprofesionalid = value ;
   }

   public int getgxTv_SdtEducacionProfesional_Profesionalid( )
   {
      return gxTv_SdtEducacionProfesional_Profesionalid ;
   }

   public void setgxTv_SdtEducacionProfesional_Profesionalid( int value )
   {
      gxTv_SdtEducacionProfesional_N = (byte)(0) ;
      SetDirty("Profesionalid");
      gxTv_SdtEducacionProfesional_Profesionalid = value ;
   }

   public String getgxTv_SdtEducacionProfesional_Educacionprofesionalnombreinstitucion( )
   {
      return gxTv_SdtEducacionProfesional_Educacionprofesionalnombreinstitucion ;
   }

   public void setgxTv_SdtEducacionProfesional_Educacionprofesionalnombreinstitucion( String value )
   {
      gxTv_SdtEducacionProfesional_N = (byte)(0) ;
      SetDirty("Educacionprofesionalnombreinstitucion");
      gxTv_SdtEducacionProfesional_Educacionprofesionalnombreinstitucion = value ;
   }

   public String getgxTv_SdtEducacionProfesional_Educacionprofesionalpais( )
   {
      return gxTv_SdtEducacionProfesional_Educacionprofesionalpais ;
   }

   public void setgxTv_SdtEducacionProfesional_Educacionprofesionalpais( String value )
   {
      gxTv_SdtEducacionProfesional_N = (byte)(0) ;
      SetDirty("Educacionprofesionalpais");
      gxTv_SdtEducacionProfesional_Educacionprofesionalpais = value ;
   }

   public java.util.Date getgxTv_SdtEducacionProfesional_Educacionprofesionaldesde( )
   {
      return gxTv_SdtEducacionProfesional_Educacionprofesionaldesde ;
   }

   public void setgxTv_SdtEducacionProfesional_Educacionprofesionaldesde( java.util.Date value )
   {
      gxTv_SdtEducacionProfesional_N = (byte)(0) ;
      SetDirty("Educacionprofesionaldesde");
      gxTv_SdtEducacionProfesional_Educacionprofesionaldesde = value ;
   }

   public java.util.Date getgxTv_SdtEducacionProfesional_Educacionprofesionalhasta( )
   {
      return gxTv_SdtEducacionProfesional_Educacionprofesionalhasta ;
   }

   public void setgxTv_SdtEducacionProfesional_Educacionprofesionalhasta( java.util.Date value )
   {
      gxTv_SdtEducacionProfesional_N = (byte)(0) ;
      SetDirty("Educacionprofesionalhasta");
      gxTv_SdtEducacionProfesional_Educacionprofesionalhasta = value ;
   }

   public String getgxTv_SdtEducacionProfesional_Mode( )
   {
      return gxTv_SdtEducacionProfesional_Mode ;
   }

   public void setgxTv_SdtEducacionProfesional_Mode( String value )
   {
      gxTv_SdtEducacionProfesional_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtEducacionProfesional_Mode = value ;
   }

   public void setgxTv_SdtEducacionProfesional_Mode_SetNull( )
   {
      gxTv_SdtEducacionProfesional_Mode = "" ;
   }

   public boolean getgxTv_SdtEducacionProfesional_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEducacionProfesional_Initialized( )
   {
      return gxTv_SdtEducacionProfesional_Initialized ;
   }

   public void setgxTv_SdtEducacionProfesional_Initialized( short value )
   {
      gxTv_SdtEducacionProfesional_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtEducacionProfesional_Initialized = value ;
   }

   public void setgxTv_SdtEducacionProfesional_Initialized_SetNull( )
   {
      gxTv_SdtEducacionProfesional_Initialized = (short)(0) ;
   }

   public boolean getgxTv_SdtEducacionProfesional_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtEducacionProfesional_Educacionprofesionalid_Z( )
   {
      return gxTv_SdtEducacionProfesional_Educacionprofesionalid_Z ;
   }

   public void setgxTv_SdtEducacionProfesional_Educacionprofesionalid_Z( int value )
   {
      gxTv_SdtEducacionProfesional_N = (byte)(0) ;
      SetDirty("Educacionprofesionalid_Z");
      gxTv_SdtEducacionProfesional_Educacionprofesionalid_Z = value ;
   }

   public void setgxTv_SdtEducacionProfesional_Educacionprofesionalid_Z_SetNull( )
   {
      gxTv_SdtEducacionProfesional_Educacionprofesionalid_Z = 0 ;
   }

   public boolean getgxTv_SdtEducacionProfesional_Educacionprofesionalid_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtEducacionProfesional_Profesionalid_Z( )
   {
      return gxTv_SdtEducacionProfesional_Profesionalid_Z ;
   }

   public void setgxTv_SdtEducacionProfesional_Profesionalid_Z( int value )
   {
      gxTv_SdtEducacionProfesional_N = (byte)(0) ;
      SetDirty("Profesionalid_Z");
      gxTv_SdtEducacionProfesional_Profesionalid_Z = value ;
   }

   public void setgxTv_SdtEducacionProfesional_Profesionalid_Z_SetNull( )
   {
      gxTv_SdtEducacionProfesional_Profesionalid_Z = 0 ;
   }

   public boolean getgxTv_SdtEducacionProfesional_Profesionalid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEducacionProfesional_Educacionprofesionalnombreinstitucion_Z( )
   {
      return gxTv_SdtEducacionProfesional_Educacionprofesionalnombreinstitucion_Z ;
   }

   public void setgxTv_SdtEducacionProfesional_Educacionprofesionalnombreinstitucion_Z( String value )
   {
      gxTv_SdtEducacionProfesional_N = (byte)(0) ;
      SetDirty("Educacionprofesionalnombreinstitucion_Z");
      gxTv_SdtEducacionProfesional_Educacionprofesionalnombreinstitucion_Z = value ;
   }

   public void setgxTv_SdtEducacionProfesional_Educacionprofesionalnombreinstitucion_Z_SetNull( )
   {
      gxTv_SdtEducacionProfesional_Educacionprofesionalnombreinstitucion_Z = "" ;
   }

   public boolean getgxTv_SdtEducacionProfesional_Educacionprofesionalnombreinstitucion_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEducacionProfesional_Educacionprofesionalpais_Z( )
   {
      return gxTv_SdtEducacionProfesional_Educacionprofesionalpais_Z ;
   }

   public void setgxTv_SdtEducacionProfesional_Educacionprofesionalpais_Z( String value )
   {
      gxTv_SdtEducacionProfesional_N = (byte)(0) ;
      SetDirty("Educacionprofesionalpais_Z");
      gxTv_SdtEducacionProfesional_Educacionprofesionalpais_Z = value ;
   }

   public void setgxTv_SdtEducacionProfesional_Educacionprofesionalpais_Z_SetNull( )
   {
      gxTv_SdtEducacionProfesional_Educacionprofesionalpais_Z = "" ;
   }

   public boolean getgxTv_SdtEducacionProfesional_Educacionprofesionalpais_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtEducacionProfesional_Educacionprofesionaldesde_Z( )
   {
      return gxTv_SdtEducacionProfesional_Educacionprofesionaldesde_Z ;
   }

   public void setgxTv_SdtEducacionProfesional_Educacionprofesionaldesde_Z( java.util.Date value )
   {
      gxTv_SdtEducacionProfesional_N = (byte)(0) ;
      SetDirty("Educacionprofesionaldesde_Z");
      gxTv_SdtEducacionProfesional_Educacionprofesionaldesde_Z = value ;
   }

   public void setgxTv_SdtEducacionProfesional_Educacionprofesionaldesde_Z_SetNull( )
   {
      gxTv_SdtEducacionProfesional_Educacionprofesionaldesde_Z = GXutil.nullDate() ;
   }

   public boolean getgxTv_SdtEducacionProfesional_Educacionprofesionaldesde_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtEducacionProfesional_Educacionprofesionalhasta_Z( )
   {
      return gxTv_SdtEducacionProfesional_Educacionprofesionalhasta_Z ;
   }

   public void setgxTv_SdtEducacionProfesional_Educacionprofesionalhasta_Z( java.util.Date value )
   {
      gxTv_SdtEducacionProfesional_N = (byte)(0) ;
      SetDirty("Educacionprofesionalhasta_Z");
      gxTv_SdtEducacionProfesional_Educacionprofesionalhasta_Z = value ;
   }

   public void setgxTv_SdtEducacionProfesional_Educacionprofesionalhasta_Z_SetNull( )
   {
      gxTv_SdtEducacionProfesional_Educacionprofesionalhasta_Z = GXutil.nullDate() ;
   }

   public boolean getgxTv_SdtEducacionProfesional_Educacionprofesionalhasta_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.projectthani.educacionprofesional_bc obj;
      obj = new com.projectthani.educacionprofesional_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtEducacionProfesional_N = (byte)(1) ;
      gxTv_SdtEducacionProfesional_Educacionprofesionalnombreinstitucion = "" ;
      gxTv_SdtEducacionProfesional_Educacionprofesionalpais = "" ;
      gxTv_SdtEducacionProfesional_Educacionprofesionaldesde = GXutil.nullDate() ;
      gxTv_SdtEducacionProfesional_Educacionprofesionalhasta = GXutil.nullDate() ;
      gxTv_SdtEducacionProfesional_Mode = "" ;
      gxTv_SdtEducacionProfesional_Educacionprofesionalnombreinstitucion_Z = "" ;
      gxTv_SdtEducacionProfesional_Educacionprofesionalpais_Z = "" ;
      gxTv_SdtEducacionProfesional_Educacionprofesionaldesde_Z = GXutil.nullDate() ;
      gxTv_SdtEducacionProfesional_Educacionprofesionalhasta_Z = GXutil.nullDate() ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtEducacionProfesional_N ;
   }

   public com.projectthani.SdtEducacionProfesional Clone( )
   {
      com.projectthani.SdtEducacionProfesional sdt;
      com.projectthani.educacionprofesional_bc obj;
      sdt = (com.projectthani.SdtEducacionProfesional)(clone()) ;
      obj = (com.projectthani.educacionprofesional_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.projectthani.StructSdtEducacionProfesional struct )
   {
      setgxTv_SdtEducacionProfesional_Educacionprofesionalid(struct.getEducacionprofesionalid());
      setgxTv_SdtEducacionProfesional_Profesionalid(struct.getProfesionalid());
      setgxTv_SdtEducacionProfesional_Educacionprofesionalnombreinstitucion(struct.getEducacionprofesionalnombreinstitucion());
      setgxTv_SdtEducacionProfesional_Educacionprofesionalpais(struct.getEducacionprofesionalpais());
      setgxTv_SdtEducacionProfesional_Educacionprofesionaldesde(struct.getEducacionprofesionaldesde());
      setgxTv_SdtEducacionProfesional_Educacionprofesionalhasta(struct.getEducacionprofesionalhasta());
      setgxTv_SdtEducacionProfesional_Mode(struct.getMode());
      setgxTv_SdtEducacionProfesional_Initialized(struct.getInitialized());
      setgxTv_SdtEducacionProfesional_Educacionprofesionalid_Z(struct.getEducacionprofesionalid_Z());
      setgxTv_SdtEducacionProfesional_Profesionalid_Z(struct.getProfesionalid_Z());
      setgxTv_SdtEducacionProfesional_Educacionprofesionalnombreinstitucion_Z(struct.getEducacionprofesionalnombreinstitucion_Z());
      setgxTv_SdtEducacionProfesional_Educacionprofesionalpais_Z(struct.getEducacionprofesionalpais_Z());
      setgxTv_SdtEducacionProfesional_Educacionprofesionaldesde_Z(struct.getEducacionprofesionaldesde_Z());
      setgxTv_SdtEducacionProfesional_Educacionprofesionalhasta_Z(struct.getEducacionprofesionalhasta_Z());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtEducacionProfesional getStruct( )
   {
      com.projectthani.StructSdtEducacionProfesional struct = new com.projectthani.StructSdtEducacionProfesional ();
      struct.setEducacionprofesionalid(getgxTv_SdtEducacionProfesional_Educacionprofesionalid());
      struct.setProfesionalid(getgxTv_SdtEducacionProfesional_Profesionalid());
      struct.setEducacionprofesionalnombreinstitucion(getgxTv_SdtEducacionProfesional_Educacionprofesionalnombreinstitucion());
      struct.setEducacionprofesionalpais(getgxTv_SdtEducacionProfesional_Educacionprofesionalpais());
      struct.setEducacionprofesionaldesde(getgxTv_SdtEducacionProfesional_Educacionprofesionaldesde());
      struct.setEducacionprofesionalhasta(getgxTv_SdtEducacionProfesional_Educacionprofesionalhasta());
      struct.setMode(getgxTv_SdtEducacionProfesional_Mode());
      struct.setInitialized(getgxTv_SdtEducacionProfesional_Initialized());
      struct.setEducacionprofesionalid_Z(getgxTv_SdtEducacionProfesional_Educacionprofesionalid_Z());
      struct.setProfesionalid_Z(getgxTv_SdtEducacionProfesional_Profesionalid_Z());
      struct.setEducacionprofesionalnombreinstitucion_Z(getgxTv_SdtEducacionProfesional_Educacionprofesionalnombreinstitucion_Z());
      struct.setEducacionprofesionalpais_Z(getgxTv_SdtEducacionProfesional_Educacionprofesionalpais_Z());
      struct.setEducacionprofesionaldesde_Z(getgxTv_SdtEducacionProfesional_Educacionprofesionaldesde_Z());
      struct.setEducacionprofesionalhasta_Z(getgxTv_SdtEducacionProfesional_Educacionprofesionalhasta_Z());
      return struct ;
   }

   private byte gxTv_SdtEducacionProfesional_N ;
   private short gxTv_SdtEducacionProfesional_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtEducacionProfesional_Educacionprofesionalid ;
   private int gxTv_SdtEducacionProfesional_Profesionalid ;
   private int gxTv_SdtEducacionProfesional_Educacionprofesionalid_Z ;
   private int gxTv_SdtEducacionProfesional_Profesionalid_Z ;
   private String gxTv_SdtEducacionProfesional_Mode ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_SdtEducacionProfesional_Educacionprofesionaldesde ;
   private java.util.Date gxTv_SdtEducacionProfesional_Educacionprofesionalhasta ;
   private java.util.Date gxTv_SdtEducacionProfesional_Educacionprofesionaldesde_Z ;
   private java.util.Date gxTv_SdtEducacionProfesional_Educacionprofesionalhasta_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtEducacionProfesional_Educacionprofesionalnombreinstitucion ;
   private String gxTv_SdtEducacionProfesional_Educacionprofesionalpais ;
   private String gxTv_SdtEducacionProfesional_Educacionprofesionalnombreinstitucion_Z ;
   private String gxTv_SdtEducacionProfesional_Educacionprofesionalpais_Z ;
}

