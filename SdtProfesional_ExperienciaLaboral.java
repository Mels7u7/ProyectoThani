package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtProfesional_ExperienciaLaboral extends GxSilentTrnSdt implements Cloneable, java.io.Serializable
{
   public SdtProfesional_ExperienciaLaboral( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtProfesional_ExperienciaLaboral.class));
   }

   public SdtProfesional_ExperienciaLaboral( int remoteHandle ,
                                             ModelContext context )
   {
      super( remoteHandle, context, "SdtProfesional_ExperienciaLaboral");
      initialize( remoteHandle) ;
   }

   public SdtProfesional_ExperienciaLaboral( int remoteHandle ,
                                             StructSdtProfesional_ExperienciaLaboral struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtProfesional_ExperienciaLaboral( )
   {
      super( new ModelContext(SdtProfesional_ExperienciaLaboral.class), "SdtProfesional_ExperienciaLaboral");
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
      return (Object[][])(new Object[][]{new Object[]{"ExperienciaLaboralId", java.util.UUID.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "ExperienciaLaboral");
      metadata.set("BT", "ProfesionalExperienciaLaboral");
      metadata.set("PK", "[ \"ExperienciaLaboralId\" ]");
      metadata.set("PKAssigned", "[ \"ExperienciaLaboralId\" ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ExperienciaLaboralId") )
            {
               gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid = GXutil.strToGuid(oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ExperienciaLaboralEmpresaNombre") )
            {
               gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralempresanombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ExperienciaLaboralDesde") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ExperienciaLaboralHasta") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
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
               gxTv_SdtProfesional_ExperienciaLaboral_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtProfesional_ExperienciaLaboral_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtProfesional_ExperienciaLaboral_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ExperienciaLaboralId_Z") )
            {
               gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid_Z = GXutil.strToGuid(oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ExperienciaLaboralEmpresaNombre_Z") )
            {
               gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralempresanombre_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ExperienciaLaboralDesde_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ExperienciaLaboralHasta_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
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
         sName = "Profesional.ExperienciaLaboral" ;
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
      oWriter.writeElement("ExperienciaLaboralId", GXutil.rtrim( gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid.toString()));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ExperienciaLaboralEmpresaNombre", GXutil.rtrim( gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralempresanombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("ExperienciaLaboralDesde", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("ExperienciaLaboralHasta", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", GXutil.rtrim( gxTv_SdtProfesional_ExperienciaLaboral_Mode));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtProfesional_ExperienciaLaboral_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtProfesional_ExperienciaLaboral_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ExperienciaLaboralId_Z", GXutil.rtrim( gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid_Z.toString()));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ExperienciaLaboralEmpresaNombre_Z", GXutil.rtrim( gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralempresanombre_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("ExperienciaLaboralDesde_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("ExperienciaLaboralHasta_Z", sDateCnv);
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
      AddObjectProperty("ExperienciaLaboralId", gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid, false, includeNonInitialized);
      AddObjectProperty("ExperienciaLaboralEmpresaNombre", gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralempresanombre, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("ExperienciaLaboralDesde", sDateCnv, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("ExperienciaLaboralHasta", sDateCnv, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtProfesional_ExperienciaLaboral_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtProfesional_ExperienciaLaboral_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtProfesional_ExperienciaLaboral_Initialized, false, includeNonInitialized);
         AddObjectProperty("ExperienciaLaboralId_Z", gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid_Z, false, includeNonInitialized);
         AddObjectProperty("ExperienciaLaboralEmpresaNombre_Z", gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralempresanombre_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("ExperienciaLaboralDesde_Z", sDateCnv, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("ExperienciaLaboralHasta_Z", sDateCnv, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.projectthani.SdtProfesional_ExperienciaLaboral sdt )
   {
      if ( sdt.IsDirty("ExperienciaLaboralId") )
      {
         gxTv_SdtProfesional_ExperienciaLaboral_N = (byte)(0) ;
         gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid = sdt.getgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid() ;
      }
      if ( sdt.IsDirty("ExperienciaLaboralEmpresaNombre") )
      {
         gxTv_SdtProfesional_ExperienciaLaboral_N = (byte)(0) ;
         gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralempresanombre = sdt.getgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralempresanombre() ;
      }
      if ( sdt.IsDirty("ExperienciaLaboralDesde") )
      {
         gxTv_SdtProfesional_ExperienciaLaboral_N = (byte)(0) ;
         gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde = sdt.getgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde() ;
      }
      if ( sdt.IsDirty("ExperienciaLaboralHasta") )
      {
         gxTv_SdtProfesional_ExperienciaLaboral_N = (byte)(0) ;
         gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta = sdt.getgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta() ;
      }
   }

   public java.util.UUID getgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid( )
   {
      return gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid ;
   }

   public void setgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid( java.util.UUID value )
   {
      gxTv_SdtProfesional_ExperienciaLaboral_N = (byte)(0) ;
      gxTv_SdtProfesional_ExperienciaLaboral_Modified = (short)(1) ;
      SetDirty("Experiencialaboralid");
      gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid = value ;
   }

   public String getgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralempresanombre( )
   {
      return gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralempresanombre ;
   }

   public void setgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralempresanombre( String value )
   {
      gxTv_SdtProfesional_ExperienciaLaboral_N = (byte)(0) ;
      gxTv_SdtProfesional_ExperienciaLaboral_Modified = (short)(1) ;
      SetDirty("Experiencialaboralempresanombre");
      gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralempresanombre = value ;
   }

   public java.util.Date getgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde( )
   {
      return gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde ;
   }

   public void setgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde( java.util.Date value )
   {
      gxTv_SdtProfesional_ExperienciaLaboral_N = (byte)(0) ;
      gxTv_SdtProfesional_ExperienciaLaboral_Modified = (short)(1) ;
      SetDirty("Experiencialaboraldesde");
      gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde = value ;
   }

   public java.util.Date getgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta( )
   {
      return gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta ;
   }

   public void setgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta( java.util.Date value )
   {
      gxTv_SdtProfesional_ExperienciaLaboral_N = (byte)(0) ;
      gxTv_SdtProfesional_ExperienciaLaboral_Modified = (short)(1) ;
      SetDirty("Experiencialaboralhasta");
      gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta = value ;
   }

   public String getgxTv_SdtProfesional_ExperienciaLaboral_Mode( )
   {
      return gxTv_SdtProfesional_ExperienciaLaboral_Mode ;
   }

   public void setgxTv_SdtProfesional_ExperienciaLaboral_Mode( String value )
   {
      gxTv_SdtProfesional_ExperienciaLaboral_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtProfesional_ExperienciaLaboral_Mode = value ;
   }

   public void setgxTv_SdtProfesional_ExperienciaLaboral_Mode_SetNull( )
   {
      gxTv_SdtProfesional_ExperienciaLaboral_Mode = "" ;
   }

   public boolean getgxTv_SdtProfesional_ExperienciaLaboral_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtProfesional_ExperienciaLaboral_Modified( )
   {
      return gxTv_SdtProfesional_ExperienciaLaboral_Modified ;
   }

   public void setgxTv_SdtProfesional_ExperienciaLaboral_Modified( short value )
   {
      gxTv_SdtProfesional_ExperienciaLaboral_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtProfesional_ExperienciaLaboral_Modified = value ;
   }

   public void setgxTv_SdtProfesional_ExperienciaLaboral_Modified_SetNull( )
   {
      gxTv_SdtProfesional_ExperienciaLaboral_Modified = (short)(0) ;
   }

   public boolean getgxTv_SdtProfesional_ExperienciaLaboral_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtProfesional_ExperienciaLaboral_Initialized( )
   {
      return gxTv_SdtProfesional_ExperienciaLaboral_Initialized ;
   }

   public void setgxTv_SdtProfesional_ExperienciaLaboral_Initialized( short value )
   {
      gxTv_SdtProfesional_ExperienciaLaboral_N = (byte)(0) ;
      gxTv_SdtProfesional_ExperienciaLaboral_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtProfesional_ExperienciaLaboral_Initialized = value ;
   }

   public void setgxTv_SdtProfesional_ExperienciaLaboral_Initialized_SetNull( )
   {
      gxTv_SdtProfesional_ExperienciaLaboral_Initialized = (short)(0) ;
   }

   public boolean getgxTv_SdtProfesional_ExperienciaLaboral_Initialized_IsNull( )
   {
      return false ;
   }

   public java.util.UUID getgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid_Z( )
   {
      return gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid_Z ;
   }

   public void setgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid_Z( java.util.UUID value )
   {
      gxTv_SdtProfesional_ExperienciaLaboral_N = (byte)(0) ;
      gxTv_SdtProfesional_ExperienciaLaboral_Modified = (short)(1) ;
      SetDirty("Experiencialaboralid_Z");
      gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid_Z = value ;
   }

   public void setgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid_Z_SetNull( )
   {
      gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid_Z = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
   }

   public boolean getgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralempresanombre_Z( )
   {
      return gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralempresanombre_Z ;
   }

   public void setgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralempresanombre_Z( String value )
   {
      gxTv_SdtProfesional_ExperienciaLaboral_N = (byte)(0) ;
      gxTv_SdtProfesional_ExperienciaLaboral_Modified = (short)(1) ;
      SetDirty("Experiencialaboralempresanombre_Z");
      gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralempresanombre_Z = value ;
   }

   public void setgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralempresanombre_Z_SetNull( )
   {
      gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralempresanombre_Z = "" ;
   }

   public boolean getgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralempresanombre_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde_Z( )
   {
      return gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde_Z ;
   }

   public void setgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde_Z( java.util.Date value )
   {
      gxTv_SdtProfesional_ExperienciaLaboral_N = (byte)(0) ;
      gxTv_SdtProfesional_ExperienciaLaboral_Modified = (short)(1) ;
      SetDirty("Experiencialaboraldesde_Z");
      gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde_Z = value ;
   }

   public void setgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde_Z_SetNull( )
   {
      gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde_Z = GXutil.nullDate() ;
   }

   public boolean getgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta_Z( )
   {
      return gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta_Z ;
   }

   public void setgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta_Z( java.util.Date value )
   {
      gxTv_SdtProfesional_ExperienciaLaboral_N = (byte)(0) ;
      gxTv_SdtProfesional_ExperienciaLaboral_Modified = (short)(1) ;
      SetDirty("Experiencialaboralhasta_Z");
      gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta_Z = value ;
   }

   public void setgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta_Z_SetNull( )
   {
      gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta_Z = GXutil.nullDate() ;
   }

   public boolean getgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      gxTv_SdtProfesional_ExperienciaLaboral_N = (byte)(1) ;
      gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralempresanombre = "" ;
      gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde = GXutil.nullDate() ;
      gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta = GXutil.nullDate() ;
      gxTv_SdtProfesional_ExperienciaLaboral_Mode = "" ;
      gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid_Z = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralempresanombre_Z = "" ;
      gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde_Z = GXutil.nullDate() ;
      gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta_Z = GXutil.nullDate() ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtProfesional_ExperienciaLaboral_N ;
   }

   public com.projectthani.SdtProfesional_ExperienciaLaboral Clone( )
   {
      return (com.projectthani.SdtProfesional_ExperienciaLaboral)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtProfesional_ExperienciaLaboral struct )
   {
      setgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid(struct.getExperiencialaboralid());
      setgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralempresanombre(struct.getExperiencialaboralempresanombre());
      setgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde(struct.getExperiencialaboraldesde());
      setgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta(struct.getExperiencialaboralhasta());
      setgxTv_SdtProfesional_ExperienciaLaboral_Mode(struct.getMode());
      setgxTv_SdtProfesional_ExperienciaLaboral_Modified(struct.getModified());
      setgxTv_SdtProfesional_ExperienciaLaboral_Initialized(struct.getInitialized());
      setgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid_Z(struct.getExperiencialaboralid_Z());
      setgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralempresanombre_Z(struct.getExperiencialaboralempresanombre_Z());
      setgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde_Z(struct.getExperiencialaboraldesde_Z());
      setgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta_Z(struct.getExperiencialaboralhasta_Z());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtProfesional_ExperienciaLaboral getStruct( )
   {
      com.projectthani.StructSdtProfesional_ExperienciaLaboral struct = new com.projectthani.StructSdtProfesional_ExperienciaLaboral ();
      struct.setExperiencialaboralid(getgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid());
      struct.setExperiencialaboralempresanombre(getgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralempresanombre());
      struct.setExperiencialaboraldesde(getgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde());
      struct.setExperiencialaboralhasta(getgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta());
      struct.setMode(getgxTv_SdtProfesional_ExperienciaLaboral_Mode());
      struct.setModified(getgxTv_SdtProfesional_ExperienciaLaboral_Modified());
      struct.setInitialized(getgxTv_SdtProfesional_ExperienciaLaboral_Initialized());
      struct.setExperiencialaboralid_Z(getgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid_Z());
      struct.setExperiencialaboralempresanombre_Z(getgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralempresanombre_Z());
      struct.setExperiencialaboraldesde_Z(getgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde_Z());
      struct.setExperiencialaboralhasta_Z(getgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta_Z());
      return struct ;
   }

   private byte gxTv_SdtProfesional_ExperienciaLaboral_N ;
   private short gxTv_SdtProfesional_ExperienciaLaboral_Modified ;
   private short gxTv_SdtProfesional_ExperienciaLaboral_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtProfesional_ExperienciaLaboral_Mode ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde ;
   private java.util.Date gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta ;
   private java.util.Date gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde_Z ;
   private java.util.Date gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralempresanombre ;
   private String gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralempresanombre_Z ;
   private java.util.UUID gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid ;
   private java.util.UUID gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid_Z ;
}

