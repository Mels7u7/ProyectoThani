package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtConfComision extends GxSilentTrnSdt implements Cloneable, java.io.Serializable
{
   public SdtConfComision( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtConfComision.class));
   }

   public SdtConfComision( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle, context, "SdtConfComision");
      initialize( remoteHandle) ;
   }

   public SdtConfComision( int remoteHandle ,
                           StructSdtConfComision struct )
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

   public void Load( short AV29ConfComisionId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Short.valueOf(AV29ConfComisionId)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"ConfComisionId", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "ConfComision");
      metadata.set("BT", "ConfComision");
      metadata.set("PK", "[ \"ConfComisionId\" ]");
      metadata.set("PKAssigned", "[ \"ConfComisionId\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"ProfesionalId\",\"EspecialidadId\" ],\"FKMap\":[  ] },{ \"FK\":[ \"SedeId\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConfComisionId") )
            {
               gxTv_SdtConfComision_Confcomisionid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalId") )
            {
               gxTv_SdtConfComision_Profesionalid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EspecialidadId") )
            {
               gxTv_SdtConfComision_Especialidadid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SedeId") )
            {
               gxTv_SdtConfComision_Sedeid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FechaDesde") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtConfComision_Fechadesde = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtConfComision_Fechadesde = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FechaHasta") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtConfComision_Fechahasta = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtConfComision_Fechahasta = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Porcentaje") )
            {
               gxTv_SdtConfComision_Porcentaje = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Estado") )
            {
               gxTv_SdtConfComision_Estado = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtConfComision_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtConfComision_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConfComisionId_Z") )
            {
               gxTv_SdtConfComision_Confcomisionid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalId_Z") )
            {
               gxTv_SdtConfComision_Profesionalid_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EspecialidadId_Z") )
            {
               gxTv_SdtConfComision_Especialidadid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SedeId_Z") )
            {
               gxTv_SdtConfComision_Sedeid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FechaDesde_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtConfComision_Fechadesde_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtConfComision_Fechadesde_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FechaHasta_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtConfComision_Fechahasta_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtConfComision_Fechahasta_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Porcentaje_Z") )
            {
               gxTv_SdtConfComision_Porcentaje_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Estado_Z") )
            {
               gxTv_SdtConfComision_Estado_Z = oReader.getValue() ;
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
         sName = "ConfComision" ;
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
      oWriter.writeElement("ConfComisionId", GXutil.trim( GXutil.str( gxTv_SdtConfComision_Confcomisionid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalId", GXutil.trim( GXutil.str( gxTv_SdtConfComision_Profesionalid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("EspecialidadId", GXutil.trim( GXutil.str( gxTv_SdtConfComision_Especialidadid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SedeId", GXutil.trim( GXutil.str( gxTv_SdtConfComision_Sedeid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtConfComision_Fechadesde), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtConfComision_Fechadesde), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtConfComision_Fechadesde), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("FechaDesde", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtConfComision_Fechahasta), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtConfComision_Fechahasta), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtConfComision_Fechahasta), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("FechaHasta", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Porcentaje", GXutil.trim( GXutil.str( gxTv_SdtConfComision_Porcentaje, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Estado", GXutil.rtrim( gxTv_SdtConfComision_Estado));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", GXutil.rtrim( gxTv_SdtConfComision_Mode));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtConfComision_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ConfComisionId_Z", GXutil.trim( GXutil.str( gxTv_SdtConfComision_Confcomisionid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ProfesionalId_Z", GXutil.trim( GXutil.str( gxTv_SdtConfComision_Profesionalid_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("EspecialidadId_Z", GXutil.trim( GXutil.str( gxTv_SdtConfComision_Especialidadid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SedeId_Z", GXutil.trim( GXutil.str( gxTv_SdtConfComision_Sedeid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtConfComision_Fechadesde_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtConfComision_Fechadesde_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtConfComision_Fechadesde_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("FechaDesde_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtConfComision_Fechahasta_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtConfComision_Fechahasta_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtConfComision_Fechahasta_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("FechaHasta_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Porcentaje_Z", GXutil.trim( GXutil.str( gxTv_SdtConfComision_Porcentaje_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Estado_Z", GXutil.rtrim( gxTv_SdtConfComision_Estado_Z));
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
      AddObjectProperty("ConfComisionId", gxTv_SdtConfComision_Confcomisionid, false, includeNonInitialized);
      AddObjectProperty("ProfesionalId", gxTv_SdtConfComision_Profesionalid, false, includeNonInitialized);
      AddObjectProperty("EspecialidadId", gxTv_SdtConfComision_Especialidadid, false, includeNonInitialized);
      AddObjectProperty("SedeId", gxTv_SdtConfComision_Sedeid, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtConfComision_Fechadesde), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtConfComision_Fechadesde), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtConfComision_Fechadesde), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("FechaDesde", sDateCnv, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtConfComision_Fechahasta), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtConfComision_Fechahasta), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtConfComision_Fechahasta), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("FechaHasta", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("Porcentaje", gxTv_SdtConfComision_Porcentaje, false, includeNonInitialized);
      AddObjectProperty("Estado", gxTv_SdtConfComision_Estado, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtConfComision_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtConfComision_Initialized, false, includeNonInitialized);
         AddObjectProperty("ConfComisionId_Z", gxTv_SdtConfComision_Confcomisionid_Z, false, includeNonInitialized);
         AddObjectProperty("ProfesionalId_Z", gxTv_SdtConfComision_Profesionalid_Z, false, includeNonInitialized);
         AddObjectProperty("EspecialidadId_Z", gxTv_SdtConfComision_Especialidadid_Z, false, includeNonInitialized);
         AddObjectProperty("SedeId_Z", gxTv_SdtConfComision_Sedeid_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtConfComision_Fechadesde_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtConfComision_Fechadesde_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtConfComision_Fechadesde_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("FechaDesde_Z", sDateCnv, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtConfComision_Fechahasta_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtConfComision_Fechahasta_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtConfComision_Fechahasta_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("FechaHasta_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("Porcentaje_Z", gxTv_SdtConfComision_Porcentaje_Z, false, includeNonInitialized);
         AddObjectProperty("Estado_Z", gxTv_SdtConfComision_Estado_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.projectthani.SdtConfComision sdt )
   {
      if ( sdt.IsDirty("ConfComisionId") )
      {
         gxTv_SdtConfComision_N = (byte)(0) ;
         gxTv_SdtConfComision_Confcomisionid = sdt.getgxTv_SdtConfComision_Confcomisionid() ;
      }
      if ( sdt.IsDirty("ProfesionalId") )
      {
         gxTv_SdtConfComision_N = (byte)(0) ;
         gxTv_SdtConfComision_Profesionalid = sdt.getgxTv_SdtConfComision_Profesionalid() ;
      }
      if ( sdt.IsDirty("EspecialidadId") )
      {
         gxTv_SdtConfComision_N = (byte)(0) ;
         gxTv_SdtConfComision_Especialidadid = sdt.getgxTv_SdtConfComision_Especialidadid() ;
      }
      if ( sdt.IsDirty("SedeId") )
      {
         gxTv_SdtConfComision_N = (byte)(0) ;
         gxTv_SdtConfComision_Sedeid = sdt.getgxTv_SdtConfComision_Sedeid() ;
      }
      if ( sdt.IsDirty("FechaDesde") )
      {
         gxTv_SdtConfComision_N = (byte)(0) ;
         gxTv_SdtConfComision_Fechadesde = sdt.getgxTv_SdtConfComision_Fechadesde() ;
      }
      if ( sdt.IsDirty("FechaHasta") )
      {
         gxTv_SdtConfComision_N = (byte)(0) ;
         gxTv_SdtConfComision_Fechahasta = sdt.getgxTv_SdtConfComision_Fechahasta() ;
      }
      if ( sdt.IsDirty("Porcentaje") )
      {
         gxTv_SdtConfComision_N = (byte)(0) ;
         gxTv_SdtConfComision_Porcentaje = sdt.getgxTv_SdtConfComision_Porcentaje() ;
      }
      if ( sdt.IsDirty("Estado") )
      {
         gxTv_SdtConfComision_N = (byte)(0) ;
         gxTv_SdtConfComision_Estado = sdt.getgxTv_SdtConfComision_Estado() ;
      }
   }

   public short getgxTv_SdtConfComision_Confcomisionid( )
   {
      return gxTv_SdtConfComision_Confcomisionid ;
   }

   public void setgxTv_SdtConfComision_Confcomisionid( short value )
   {
      gxTv_SdtConfComision_N = (byte)(0) ;
      if ( gxTv_SdtConfComision_Confcomisionid != value )
      {
         gxTv_SdtConfComision_Mode = "INS" ;
         this.setgxTv_SdtConfComision_Confcomisionid_Z_SetNull( );
         this.setgxTv_SdtConfComision_Profesionalid_Z_SetNull( );
         this.setgxTv_SdtConfComision_Especialidadid_Z_SetNull( );
         this.setgxTv_SdtConfComision_Sedeid_Z_SetNull( );
         this.setgxTv_SdtConfComision_Fechadesde_Z_SetNull( );
         this.setgxTv_SdtConfComision_Fechahasta_Z_SetNull( );
         this.setgxTv_SdtConfComision_Porcentaje_Z_SetNull( );
         this.setgxTv_SdtConfComision_Estado_Z_SetNull( );
      }
      SetDirty("Confcomisionid");
      gxTv_SdtConfComision_Confcomisionid = value ;
   }

   public int getgxTv_SdtConfComision_Profesionalid( )
   {
      return gxTv_SdtConfComision_Profesionalid ;
   }

   public void setgxTv_SdtConfComision_Profesionalid( int value )
   {
      gxTv_SdtConfComision_N = (byte)(0) ;
      SetDirty("Profesionalid");
      gxTv_SdtConfComision_Profesionalid = value ;
   }

   public short getgxTv_SdtConfComision_Especialidadid( )
   {
      return gxTv_SdtConfComision_Especialidadid ;
   }

   public void setgxTv_SdtConfComision_Especialidadid( short value )
   {
      gxTv_SdtConfComision_N = (byte)(0) ;
      SetDirty("Especialidadid");
      gxTv_SdtConfComision_Especialidadid = value ;
   }

   public short getgxTv_SdtConfComision_Sedeid( )
   {
      return gxTv_SdtConfComision_Sedeid ;
   }

   public void setgxTv_SdtConfComision_Sedeid( short value )
   {
      gxTv_SdtConfComision_N = (byte)(0) ;
      SetDirty("Sedeid");
      gxTv_SdtConfComision_Sedeid = value ;
   }

   public java.util.Date getgxTv_SdtConfComision_Fechadesde( )
   {
      return gxTv_SdtConfComision_Fechadesde ;
   }

   public void setgxTv_SdtConfComision_Fechadesde( java.util.Date value )
   {
      gxTv_SdtConfComision_N = (byte)(0) ;
      SetDirty("Fechadesde");
      gxTv_SdtConfComision_Fechadesde = value ;
   }

   public java.util.Date getgxTv_SdtConfComision_Fechahasta( )
   {
      return gxTv_SdtConfComision_Fechahasta ;
   }

   public void setgxTv_SdtConfComision_Fechahasta( java.util.Date value )
   {
      gxTv_SdtConfComision_N = (byte)(0) ;
      SetDirty("Fechahasta");
      gxTv_SdtConfComision_Fechahasta = value ;
   }

   public short getgxTv_SdtConfComision_Porcentaje( )
   {
      return gxTv_SdtConfComision_Porcentaje ;
   }

   public void setgxTv_SdtConfComision_Porcentaje( short value )
   {
      gxTv_SdtConfComision_N = (byte)(0) ;
      SetDirty("Porcentaje");
      gxTv_SdtConfComision_Porcentaje = value ;
   }

   public String getgxTv_SdtConfComision_Estado( )
   {
      return gxTv_SdtConfComision_Estado ;
   }

   public void setgxTv_SdtConfComision_Estado( String value )
   {
      gxTv_SdtConfComision_N = (byte)(0) ;
      SetDirty("Estado");
      gxTv_SdtConfComision_Estado = value ;
   }

   public String getgxTv_SdtConfComision_Mode( )
   {
      return gxTv_SdtConfComision_Mode ;
   }

   public void setgxTv_SdtConfComision_Mode( String value )
   {
      gxTv_SdtConfComision_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtConfComision_Mode = value ;
   }

   public void setgxTv_SdtConfComision_Mode_SetNull( )
   {
      gxTv_SdtConfComision_Mode = "" ;
   }

   public boolean getgxTv_SdtConfComision_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtConfComision_Initialized( )
   {
      return gxTv_SdtConfComision_Initialized ;
   }

   public void setgxTv_SdtConfComision_Initialized( short value )
   {
      gxTv_SdtConfComision_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtConfComision_Initialized = value ;
   }

   public void setgxTv_SdtConfComision_Initialized_SetNull( )
   {
      gxTv_SdtConfComision_Initialized = (short)(0) ;
   }

   public boolean getgxTv_SdtConfComision_Initialized_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtConfComision_Confcomisionid_Z( )
   {
      return gxTv_SdtConfComision_Confcomisionid_Z ;
   }

   public void setgxTv_SdtConfComision_Confcomisionid_Z( short value )
   {
      gxTv_SdtConfComision_N = (byte)(0) ;
      SetDirty("Confcomisionid_Z");
      gxTv_SdtConfComision_Confcomisionid_Z = value ;
   }

   public void setgxTv_SdtConfComision_Confcomisionid_Z_SetNull( )
   {
      gxTv_SdtConfComision_Confcomisionid_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtConfComision_Confcomisionid_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtConfComision_Profesionalid_Z( )
   {
      return gxTv_SdtConfComision_Profesionalid_Z ;
   }

   public void setgxTv_SdtConfComision_Profesionalid_Z( int value )
   {
      gxTv_SdtConfComision_N = (byte)(0) ;
      SetDirty("Profesionalid_Z");
      gxTv_SdtConfComision_Profesionalid_Z = value ;
   }

   public void setgxTv_SdtConfComision_Profesionalid_Z_SetNull( )
   {
      gxTv_SdtConfComision_Profesionalid_Z = 0 ;
   }

   public boolean getgxTv_SdtConfComision_Profesionalid_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtConfComision_Especialidadid_Z( )
   {
      return gxTv_SdtConfComision_Especialidadid_Z ;
   }

   public void setgxTv_SdtConfComision_Especialidadid_Z( short value )
   {
      gxTv_SdtConfComision_N = (byte)(0) ;
      SetDirty("Especialidadid_Z");
      gxTv_SdtConfComision_Especialidadid_Z = value ;
   }

   public void setgxTv_SdtConfComision_Especialidadid_Z_SetNull( )
   {
      gxTv_SdtConfComision_Especialidadid_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtConfComision_Especialidadid_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtConfComision_Sedeid_Z( )
   {
      return gxTv_SdtConfComision_Sedeid_Z ;
   }

   public void setgxTv_SdtConfComision_Sedeid_Z( short value )
   {
      gxTv_SdtConfComision_N = (byte)(0) ;
      SetDirty("Sedeid_Z");
      gxTv_SdtConfComision_Sedeid_Z = value ;
   }

   public void setgxTv_SdtConfComision_Sedeid_Z_SetNull( )
   {
      gxTv_SdtConfComision_Sedeid_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtConfComision_Sedeid_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtConfComision_Fechadesde_Z( )
   {
      return gxTv_SdtConfComision_Fechadesde_Z ;
   }

   public void setgxTv_SdtConfComision_Fechadesde_Z( java.util.Date value )
   {
      gxTv_SdtConfComision_N = (byte)(0) ;
      SetDirty("Fechadesde_Z");
      gxTv_SdtConfComision_Fechadesde_Z = value ;
   }

   public void setgxTv_SdtConfComision_Fechadesde_Z_SetNull( )
   {
      gxTv_SdtConfComision_Fechadesde_Z = GXutil.nullDate() ;
   }

   public boolean getgxTv_SdtConfComision_Fechadesde_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtConfComision_Fechahasta_Z( )
   {
      return gxTv_SdtConfComision_Fechahasta_Z ;
   }

   public void setgxTv_SdtConfComision_Fechahasta_Z( java.util.Date value )
   {
      gxTv_SdtConfComision_N = (byte)(0) ;
      SetDirty("Fechahasta_Z");
      gxTv_SdtConfComision_Fechahasta_Z = value ;
   }

   public void setgxTv_SdtConfComision_Fechahasta_Z_SetNull( )
   {
      gxTv_SdtConfComision_Fechahasta_Z = GXutil.nullDate() ;
   }

   public boolean getgxTv_SdtConfComision_Fechahasta_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtConfComision_Porcentaje_Z( )
   {
      return gxTv_SdtConfComision_Porcentaje_Z ;
   }

   public void setgxTv_SdtConfComision_Porcentaje_Z( short value )
   {
      gxTv_SdtConfComision_N = (byte)(0) ;
      SetDirty("Porcentaje_Z");
      gxTv_SdtConfComision_Porcentaje_Z = value ;
   }

   public void setgxTv_SdtConfComision_Porcentaje_Z_SetNull( )
   {
      gxTv_SdtConfComision_Porcentaje_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtConfComision_Porcentaje_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConfComision_Estado_Z( )
   {
      return gxTv_SdtConfComision_Estado_Z ;
   }

   public void setgxTv_SdtConfComision_Estado_Z( String value )
   {
      gxTv_SdtConfComision_N = (byte)(0) ;
      SetDirty("Estado_Z");
      gxTv_SdtConfComision_Estado_Z = value ;
   }

   public void setgxTv_SdtConfComision_Estado_Z_SetNull( )
   {
      gxTv_SdtConfComision_Estado_Z = "" ;
   }

   public boolean getgxTv_SdtConfComision_Estado_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.projectthani.confcomision_bc obj;
      obj = new com.projectthani.confcomision_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtConfComision_N = (byte)(1) ;
      gxTv_SdtConfComision_Fechadesde = GXutil.nullDate() ;
      gxTv_SdtConfComision_Fechahasta = GXutil.nullDate() ;
      gxTv_SdtConfComision_Estado = "" ;
      gxTv_SdtConfComision_Mode = "" ;
      gxTv_SdtConfComision_Fechadesde_Z = GXutil.nullDate() ;
      gxTv_SdtConfComision_Fechahasta_Z = GXutil.nullDate() ;
      gxTv_SdtConfComision_Estado_Z = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtConfComision_N ;
   }

   public com.projectthani.SdtConfComision Clone( )
   {
      com.projectthani.SdtConfComision sdt;
      com.projectthani.confcomision_bc obj;
      sdt = (com.projectthani.SdtConfComision)(clone()) ;
      obj = (com.projectthani.confcomision_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.projectthani.StructSdtConfComision struct )
   {
      setgxTv_SdtConfComision_Confcomisionid(struct.getConfcomisionid());
      setgxTv_SdtConfComision_Profesionalid(struct.getProfesionalid());
      setgxTv_SdtConfComision_Especialidadid(struct.getEspecialidadid());
      setgxTv_SdtConfComision_Sedeid(struct.getSedeid());
      setgxTv_SdtConfComision_Fechadesde(struct.getFechadesde());
      setgxTv_SdtConfComision_Fechahasta(struct.getFechahasta());
      setgxTv_SdtConfComision_Porcentaje(struct.getPorcentaje());
      setgxTv_SdtConfComision_Estado(struct.getEstado());
      setgxTv_SdtConfComision_Mode(struct.getMode());
      setgxTv_SdtConfComision_Initialized(struct.getInitialized());
      setgxTv_SdtConfComision_Confcomisionid_Z(struct.getConfcomisionid_Z());
      setgxTv_SdtConfComision_Profesionalid_Z(struct.getProfesionalid_Z());
      setgxTv_SdtConfComision_Especialidadid_Z(struct.getEspecialidadid_Z());
      setgxTv_SdtConfComision_Sedeid_Z(struct.getSedeid_Z());
      setgxTv_SdtConfComision_Fechadesde_Z(struct.getFechadesde_Z());
      setgxTv_SdtConfComision_Fechahasta_Z(struct.getFechahasta_Z());
      setgxTv_SdtConfComision_Porcentaje_Z(struct.getPorcentaje_Z());
      setgxTv_SdtConfComision_Estado_Z(struct.getEstado_Z());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtConfComision getStruct( )
   {
      com.projectthani.StructSdtConfComision struct = new com.projectthani.StructSdtConfComision ();
      struct.setConfcomisionid(getgxTv_SdtConfComision_Confcomisionid());
      struct.setProfesionalid(getgxTv_SdtConfComision_Profesionalid());
      struct.setEspecialidadid(getgxTv_SdtConfComision_Especialidadid());
      struct.setSedeid(getgxTv_SdtConfComision_Sedeid());
      struct.setFechadesde(getgxTv_SdtConfComision_Fechadesde());
      struct.setFechahasta(getgxTv_SdtConfComision_Fechahasta());
      struct.setPorcentaje(getgxTv_SdtConfComision_Porcentaje());
      struct.setEstado(getgxTv_SdtConfComision_Estado());
      struct.setMode(getgxTv_SdtConfComision_Mode());
      struct.setInitialized(getgxTv_SdtConfComision_Initialized());
      struct.setConfcomisionid_Z(getgxTv_SdtConfComision_Confcomisionid_Z());
      struct.setProfesionalid_Z(getgxTv_SdtConfComision_Profesionalid_Z());
      struct.setEspecialidadid_Z(getgxTv_SdtConfComision_Especialidadid_Z());
      struct.setSedeid_Z(getgxTv_SdtConfComision_Sedeid_Z());
      struct.setFechadesde_Z(getgxTv_SdtConfComision_Fechadesde_Z());
      struct.setFechahasta_Z(getgxTv_SdtConfComision_Fechahasta_Z());
      struct.setPorcentaje_Z(getgxTv_SdtConfComision_Porcentaje_Z());
      struct.setEstado_Z(getgxTv_SdtConfComision_Estado_Z());
      return struct ;
   }

   private byte gxTv_SdtConfComision_N ;
   private short gxTv_SdtConfComision_Confcomisionid ;
   private short gxTv_SdtConfComision_Especialidadid ;
   private short gxTv_SdtConfComision_Sedeid ;
   private short gxTv_SdtConfComision_Porcentaje ;
   private short gxTv_SdtConfComision_Initialized ;
   private short gxTv_SdtConfComision_Confcomisionid_Z ;
   private short gxTv_SdtConfComision_Especialidadid_Z ;
   private short gxTv_SdtConfComision_Sedeid_Z ;
   private short gxTv_SdtConfComision_Porcentaje_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtConfComision_Profesionalid ;
   private int gxTv_SdtConfComision_Profesionalid_Z ;
   private String gxTv_SdtConfComision_Estado ;
   private String gxTv_SdtConfComision_Mode ;
   private String gxTv_SdtConfComision_Estado_Z ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_SdtConfComision_Fechadesde ;
   private java.util.Date gxTv_SdtConfComision_Fechahasta ;
   private java.util.Date gxTv_SdtConfComision_Fechadesde_Z ;
   private java.util.Date gxTv_SdtConfComision_Fechahasta_Z ;
   private boolean readElement ;
   private boolean formatError ;
}

