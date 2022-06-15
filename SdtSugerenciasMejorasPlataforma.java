package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSugerenciasMejorasPlataforma extends GxSilentTrnSdt implements Cloneable, java.io.Serializable
{
   public SdtSugerenciasMejorasPlataforma( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtSugerenciasMejorasPlataforma.class));
   }

   public SdtSugerenciasMejorasPlataforma( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle, context, "SdtSugerenciasMejorasPlataforma");
      initialize( remoteHandle) ;
   }

   public SdtSugerenciasMejorasPlataforma( int remoteHandle ,
                                           StructSdtSugerenciasMejorasPlataforma struct )
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

   public void Load( int AV397SugerenciasMejorasPlataformaId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV397SugerenciasMejorasPlataformaId)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"SugerenciasMejorasPlataformaId", int.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "SugerenciasMejorasPlataforma");
      metadata.set("BT", "SugerenciasMejorasPlataforma");
      metadata.set("PK", "[ \"SugerenciasMejorasPlataformaId\" ]");
      metadata.set("PKAssigned", "[ \"SugerenciasMejorasPlataformaId\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"PacienteId\" ],\"FKMap\":[ \"SGPacientePacienteId-PacienteId\" ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "SugerenciasMejorasPlataformaId") )
            {
               gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGPacientePacienteId") )
            {
               gxTv_SdtSugerenciasMejorasPlataforma_Sgpacientepacienteid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SugerenciasMejorasPlataformaCitaId") )
            {
               gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformacitaid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SugerenciasMejorasPlataformaOp") )
            {
               gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaop = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SugerenciasMejorasPlataformaMej") )
            {
               gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformamej = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SugerenciasMejorasPlataformaFecRegistro") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
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
               gxTv_SdtSugerenciasMejorasPlataforma_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtSugerenciasMejorasPlataforma_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SugerenciasMejorasPlataformaId_Z") )
            {
               gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaid_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGPacientePacienteId_Z") )
            {
               gxTv_SdtSugerenciasMejorasPlataforma_Sgpacientepacienteid_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SugerenciasMejorasPlataformaCitaId_Z") )
            {
               gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformacitaid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SugerenciasMejorasPlataformaFecRegistro_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
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
         sName = "SugerenciasMejorasPlataforma" ;
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
      oWriter.writeElement("SugerenciasMejorasPlataformaId", GXutil.trim( GXutil.str( gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGPacientePacienteId", GXutil.trim( GXutil.str( gxTv_SdtSugerenciasMejorasPlataforma_Sgpacientepacienteid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SugerenciasMejorasPlataformaCitaId", GXutil.trim( GXutil.str( gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformacitaid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SugerenciasMejorasPlataformaOp", GXutil.rtrim( gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaop));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SugerenciasMejorasPlataformaMej", GXutil.rtrim( gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformamej));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("SugerenciasMejorasPlataformaFecRegistro", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", GXutil.rtrim( gxTv_SdtSugerenciasMejorasPlataforma_Mode));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtSugerenciasMejorasPlataforma_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SugerenciasMejorasPlataformaId_Z", GXutil.trim( GXutil.str( gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaid_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SGPacientePacienteId_Z", GXutil.trim( GXutil.str( gxTv_SdtSugerenciasMejorasPlataforma_Sgpacientepacienteid_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SugerenciasMejorasPlataformaCitaId_Z", GXutil.trim( GXutil.str( gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformacitaid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("SugerenciasMejorasPlataformaFecRegistro_Z", sDateCnv);
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
      AddObjectProperty("SugerenciasMejorasPlataformaId", gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaid, false, includeNonInitialized);
      AddObjectProperty("SGPacientePacienteId", gxTv_SdtSugerenciasMejorasPlataforma_Sgpacientepacienteid, false, includeNonInitialized);
      AddObjectProperty("SugerenciasMejorasPlataformaCitaId", gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformacitaid, false, includeNonInitialized);
      AddObjectProperty("SugerenciasMejorasPlataformaOp", gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaop, false, includeNonInitialized);
      AddObjectProperty("SugerenciasMejorasPlataformaMej", gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformamej, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("SugerenciasMejorasPlataformaFecRegistro", sDateCnv, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtSugerenciasMejorasPlataforma_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtSugerenciasMejorasPlataforma_Initialized, false, includeNonInitialized);
         AddObjectProperty("SugerenciasMejorasPlataformaId_Z", gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaid_Z, false, includeNonInitialized);
         AddObjectProperty("SGPacientePacienteId_Z", gxTv_SdtSugerenciasMejorasPlataforma_Sgpacientepacienteid_Z, false, includeNonInitialized);
         AddObjectProperty("SugerenciasMejorasPlataformaCitaId_Z", gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformacitaid_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("SugerenciasMejorasPlataformaFecRegistro_Z", sDateCnv, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.projectthani.SdtSugerenciasMejorasPlataforma sdt )
   {
      if ( sdt.IsDirty("SugerenciasMejorasPlataformaId") )
      {
         gxTv_SdtSugerenciasMejorasPlataforma_N = (byte)(0) ;
         gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaid = sdt.getgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaid() ;
      }
      if ( sdt.IsDirty("SGPacientePacienteId") )
      {
         gxTv_SdtSugerenciasMejorasPlataforma_N = (byte)(0) ;
         gxTv_SdtSugerenciasMejorasPlataforma_Sgpacientepacienteid = sdt.getgxTv_SdtSugerenciasMejorasPlataforma_Sgpacientepacienteid() ;
      }
      if ( sdt.IsDirty("SugerenciasMejorasPlataformaCitaId") )
      {
         gxTv_SdtSugerenciasMejorasPlataforma_N = (byte)(0) ;
         gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformacitaid = sdt.getgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformacitaid() ;
      }
      if ( sdt.IsDirty("SugerenciasMejorasPlataformaOp") )
      {
         gxTv_SdtSugerenciasMejorasPlataforma_N = (byte)(0) ;
         gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaop = sdt.getgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaop() ;
      }
      if ( sdt.IsDirty("SugerenciasMejorasPlataformaMej") )
      {
         gxTv_SdtSugerenciasMejorasPlataforma_N = (byte)(0) ;
         gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformamej = sdt.getgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformamej() ;
      }
      if ( sdt.IsDirty("SugerenciasMejorasPlataformaFecRegistro") )
      {
         gxTv_SdtSugerenciasMejorasPlataforma_N = (byte)(0) ;
         gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro = sdt.getgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro() ;
      }
   }

   public int getgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaid( )
   {
      return gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaid ;
   }

   public void setgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaid( int value )
   {
      gxTv_SdtSugerenciasMejorasPlataforma_N = (byte)(0) ;
      if ( gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaid != value )
      {
         gxTv_SdtSugerenciasMejorasPlataforma_Mode = "INS" ;
         this.setgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaid_Z_SetNull( );
         this.setgxTv_SdtSugerenciasMejorasPlataforma_Sgpacientepacienteid_Z_SetNull( );
         this.setgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformacitaid_Z_SetNull( );
         this.setgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro_Z_SetNull( );
      }
      SetDirty("Sugerenciasmejorasplataformaid");
      gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaid = value ;
   }

   public int getgxTv_SdtSugerenciasMejorasPlataforma_Sgpacientepacienteid( )
   {
      return gxTv_SdtSugerenciasMejorasPlataforma_Sgpacientepacienteid ;
   }

   public void setgxTv_SdtSugerenciasMejorasPlataforma_Sgpacientepacienteid( int value )
   {
      gxTv_SdtSugerenciasMejorasPlataforma_N = (byte)(0) ;
      SetDirty("Sgpacientepacienteid");
      gxTv_SdtSugerenciasMejorasPlataforma_Sgpacientepacienteid = value ;
   }

   public short getgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformacitaid( )
   {
      return gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformacitaid ;
   }

   public void setgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformacitaid( short value )
   {
      gxTv_SdtSugerenciasMejorasPlataforma_N = (byte)(0) ;
      SetDirty("Sugerenciasmejorasplataformacitaid");
      gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformacitaid = value ;
   }

   public String getgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaop( )
   {
      return gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaop ;
   }

   public void setgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaop( String value )
   {
      gxTv_SdtSugerenciasMejorasPlataforma_N = (byte)(0) ;
      SetDirty("Sugerenciasmejorasplataformaop");
      gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaop = value ;
   }

   public String getgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformamej( )
   {
      return gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformamej ;
   }

   public void setgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformamej( String value )
   {
      gxTv_SdtSugerenciasMejorasPlataforma_N = (byte)(0) ;
      SetDirty("Sugerenciasmejorasplataformamej");
      gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformamej = value ;
   }

   public java.util.Date getgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro( )
   {
      return gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro ;
   }

   public void setgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro( java.util.Date value )
   {
      gxTv_SdtSugerenciasMejorasPlataforma_N = (byte)(0) ;
      SetDirty("Sugerenciasmejorasplataformafecregistro");
      gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro = value ;
   }

   public String getgxTv_SdtSugerenciasMejorasPlataforma_Mode( )
   {
      return gxTv_SdtSugerenciasMejorasPlataforma_Mode ;
   }

   public void setgxTv_SdtSugerenciasMejorasPlataforma_Mode( String value )
   {
      gxTv_SdtSugerenciasMejorasPlataforma_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtSugerenciasMejorasPlataforma_Mode = value ;
   }

   public void setgxTv_SdtSugerenciasMejorasPlataforma_Mode_SetNull( )
   {
      gxTv_SdtSugerenciasMejorasPlataforma_Mode = "" ;
   }

   public boolean getgxTv_SdtSugerenciasMejorasPlataforma_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtSugerenciasMejorasPlataforma_Initialized( )
   {
      return gxTv_SdtSugerenciasMejorasPlataforma_Initialized ;
   }

   public void setgxTv_SdtSugerenciasMejorasPlataforma_Initialized( short value )
   {
      gxTv_SdtSugerenciasMejorasPlataforma_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtSugerenciasMejorasPlataforma_Initialized = value ;
   }

   public void setgxTv_SdtSugerenciasMejorasPlataforma_Initialized_SetNull( )
   {
      gxTv_SdtSugerenciasMejorasPlataforma_Initialized = (short)(0) ;
   }

   public boolean getgxTv_SdtSugerenciasMejorasPlataforma_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaid_Z( )
   {
      return gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaid_Z ;
   }

   public void setgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaid_Z( int value )
   {
      gxTv_SdtSugerenciasMejorasPlataforma_N = (byte)(0) ;
      SetDirty("Sugerenciasmejorasplataformaid_Z");
      gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaid_Z = value ;
   }

   public void setgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaid_Z_SetNull( )
   {
      gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaid_Z = 0 ;
   }

   public boolean getgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaid_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtSugerenciasMejorasPlataforma_Sgpacientepacienteid_Z( )
   {
      return gxTv_SdtSugerenciasMejorasPlataforma_Sgpacientepacienteid_Z ;
   }

   public void setgxTv_SdtSugerenciasMejorasPlataforma_Sgpacientepacienteid_Z( int value )
   {
      gxTv_SdtSugerenciasMejorasPlataforma_N = (byte)(0) ;
      SetDirty("Sgpacientepacienteid_Z");
      gxTv_SdtSugerenciasMejorasPlataforma_Sgpacientepacienteid_Z = value ;
   }

   public void setgxTv_SdtSugerenciasMejorasPlataforma_Sgpacientepacienteid_Z_SetNull( )
   {
      gxTv_SdtSugerenciasMejorasPlataforma_Sgpacientepacienteid_Z = 0 ;
   }

   public boolean getgxTv_SdtSugerenciasMejorasPlataforma_Sgpacientepacienteid_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformacitaid_Z( )
   {
      return gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformacitaid_Z ;
   }

   public void setgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformacitaid_Z( short value )
   {
      gxTv_SdtSugerenciasMejorasPlataforma_N = (byte)(0) ;
      SetDirty("Sugerenciasmejorasplataformacitaid_Z");
      gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformacitaid_Z = value ;
   }

   public void setgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformacitaid_Z_SetNull( )
   {
      gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformacitaid_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformacitaid_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro_Z( )
   {
      return gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro_Z ;
   }

   public void setgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro_Z( java.util.Date value )
   {
      gxTv_SdtSugerenciasMejorasPlataforma_N = (byte)(0) ;
      SetDirty("Sugerenciasmejorasplataformafecregistro_Z");
      gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro_Z = value ;
   }

   public void setgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro_Z_SetNull( )
   {
      gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro_Z = GXutil.nullDate() ;
   }

   public boolean getgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.projectthani.sugerenciasmejorasplataforma_bc obj;
      obj = new com.projectthani.sugerenciasmejorasplataforma_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtSugerenciasMejorasPlataforma_N = (byte)(1) ;
      gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaop = "" ;
      gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformamej = "" ;
      gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro = GXutil.nullDate() ;
      gxTv_SdtSugerenciasMejorasPlataforma_Mode = "" ;
      gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro_Z = GXutil.nullDate() ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSugerenciasMejorasPlataforma_N ;
   }

   public com.projectthani.SdtSugerenciasMejorasPlataforma Clone( )
   {
      com.projectthani.SdtSugerenciasMejorasPlataforma sdt;
      com.projectthani.sugerenciasmejorasplataforma_bc obj;
      sdt = (com.projectthani.SdtSugerenciasMejorasPlataforma)(clone()) ;
      obj = (com.projectthani.sugerenciasmejorasplataforma_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.projectthani.StructSdtSugerenciasMejorasPlataforma struct )
   {
      setgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaid(struct.getSugerenciasmejorasplataformaid());
      setgxTv_SdtSugerenciasMejorasPlataforma_Sgpacientepacienteid(struct.getSgpacientepacienteid());
      setgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformacitaid(struct.getSugerenciasmejorasplataformacitaid());
      setgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaop(struct.getSugerenciasmejorasplataformaop());
      setgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformamej(struct.getSugerenciasmejorasplataformamej());
      setgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro(struct.getSugerenciasmejorasplataformafecregistro());
      setgxTv_SdtSugerenciasMejorasPlataforma_Mode(struct.getMode());
      setgxTv_SdtSugerenciasMejorasPlataforma_Initialized(struct.getInitialized());
      setgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaid_Z(struct.getSugerenciasmejorasplataformaid_Z());
      setgxTv_SdtSugerenciasMejorasPlataforma_Sgpacientepacienteid_Z(struct.getSgpacientepacienteid_Z());
      setgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformacitaid_Z(struct.getSugerenciasmejorasplataformacitaid_Z());
      setgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro_Z(struct.getSugerenciasmejorasplataformafecregistro_Z());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSugerenciasMejorasPlataforma getStruct( )
   {
      com.projectthani.StructSdtSugerenciasMejorasPlataforma struct = new com.projectthani.StructSdtSugerenciasMejorasPlataforma ();
      struct.setSugerenciasmejorasplataformaid(getgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaid());
      struct.setSgpacientepacienteid(getgxTv_SdtSugerenciasMejorasPlataforma_Sgpacientepacienteid());
      struct.setSugerenciasmejorasplataformacitaid(getgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformacitaid());
      struct.setSugerenciasmejorasplataformaop(getgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaop());
      struct.setSugerenciasmejorasplataformamej(getgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformamej());
      struct.setSugerenciasmejorasplataformafecregistro(getgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro());
      struct.setMode(getgxTv_SdtSugerenciasMejorasPlataforma_Mode());
      struct.setInitialized(getgxTv_SdtSugerenciasMejorasPlataforma_Initialized());
      struct.setSugerenciasmejorasplataformaid_Z(getgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaid_Z());
      struct.setSgpacientepacienteid_Z(getgxTv_SdtSugerenciasMejorasPlataforma_Sgpacientepacienteid_Z());
      struct.setSugerenciasmejorasplataformacitaid_Z(getgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformacitaid_Z());
      struct.setSugerenciasmejorasplataformafecregistro_Z(getgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro_Z());
      return struct ;
   }

   private byte gxTv_SdtSugerenciasMejorasPlataforma_N ;
   private short gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformacitaid ;
   private short gxTv_SdtSugerenciasMejorasPlataforma_Initialized ;
   private short gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformacitaid_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaid ;
   private int gxTv_SdtSugerenciasMejorasPlataforma_Sgpacientepacienteid ;
   private int gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaid_Z ;
   private int gxTv_SdtSugerenciasMejorasPlataforma_Sgpacientepacienteid_Z ;
   private String gxTv_SdtSugerenciasMejorasPlataforma_Mode ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro ;
   private java.util.Date gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaop ;
   private String gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformamej ;
}

