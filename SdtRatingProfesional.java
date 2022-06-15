package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtRatingProfesional extends GxSilentTrnSdt implements Cloneable, java.io.Serializable
{
   public SdtRatingProfesional( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtRatingProfesional.class));
   }

   public SdtRatingProfesional( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle, context, "SdtRatingProfesional");
      initialize( remoteHandle) ;
   }

   public SdtRatingProfesional( int remoteHandle ,
                                StructSdtRatingProfesional struct )
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

   public void Load( int AV60RatingProfesionalId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV60RatingProfesionalId)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"RatingProfesionalId", int.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "RatingProfesional");
      metadata.set("BT", "RatingProfesional");
      metadata.set("PK", "[ \"RatingProfesionalId\" ]");
      metadata.set("PKAssigned", "[ \"RatingProfesionalId\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"PacienteId\" ],\"FKMap\":[ \"SGPacientePacienteId-PacienteId\" ] },{ \"FK\":[ \"ProfesionalId\" ],\"FKMap\":[ \"SGProfesionalProfesionalId-ProfesionalId\" ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "RatingProfesionalId") )
            {
               gxTv_SdtRatingProfesional_Ratingprofesionalid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGProfesionalProfesionalId") )
            {
               gxTv_SdtRatingProfesional_Sgprofesionalprofesionalid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGPacientePacienteId") )
            {
               gxTv_SdtRatingProfesional_Sgpacientepacienteid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RatingProfesionalCitaId") )
            {
               gxTv_SdtRatingProfesional_Ratingprofesionalcitaid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RatingProfesionalRating") )
            {
               gxTv_SdtRatingProfesional_Ratingprofesionalrating = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RatingProfesionalFechaRegistro") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
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
               gxTv_SdtRatingProfesional_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtRatingProfesional_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RatingProfesionalId_Z") )
            {
               gxTv_SdtRatingProfesional_Ratingprofesionalid_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGProfesionalProfesionalId_Z") )
            {
               gxTv_SdtRatingProfesional_Sgprofesionalprofesionalid_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGPacientePacienteId_Z") )
            {
               gxTv_SdtRatingProfesional_Sgpacientepacienteid_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RatingProfesionalCitaId_Z") )
            {
               gxTv_SdtRatingProfesional_Ratingprofesionalcitaid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RatingProfesionalRating_Z") )
            {
               gxTv_SdtRatingProfesional_Ratingprofesionalrating_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RatingProfesionalFechaRegistro_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
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
         sName = "RatingProfesional" ;
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
      oWriter.writeElement("RatingProfesionalId", GXutil.trim( GXutil.str( gxTv_SdtRatingProfesional_Ratingprofesionalid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGProfesionalProfesionalId", GXutil.trim( GXutil.str( gxTv_SdtRatingProfesional_Sgprofesionalprofesionalid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGPacientePacienteId", GXutil.trim( GXutil.str( gxTv_SdtRatingProfesional_Sgpacientepacienteid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("RatingProfesionalCitaId", GXutil.trim( GXutil.str( gxTv_SdtRatingProfesional_Ratingprofesionalcitaid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("RatingProfesionalRating", GXutil.trim( GXutil.str( gxTv_SdtRatingProfesional_Ratingprofesionalrating, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("RatingProfesionalFechaRegistro", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", GXutil.rtrim( gxTv_SdtRatingProfesional_Mode));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtRatingProfesional_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("RatingProfesionalId_Z", GXutil.trim( GXutil.str( gxTv_SdtRatingProfesional_Ratingprofesionalid_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SGProfesionalProfesionalId_Z", GXutil.trim( GXutil.str( gxTv_SdtRatingProfesional_Sgprofesionalprofesionalid_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SGPacientePacienteId_Z", GXutil.trim( GXutil.str( gxTv_SdtRatingProfesional_Sgpacientepacienteid_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("RatingProfesionalCitaId_Z", GXutil.trim( GXutil.str( gxTv_SdtRatingProfesional_Ratingprofesionalcitaid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("RatingProfesionalRating_Z", GXutil.trim( GXutil.str( gxTv_SdtRatingProfesional_Ratingprofesionalrating_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("RatingProfesionalFechaRegistro_Z", sDateCnv);
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
      AddObjectProperty("RatingProfesionalId", gxTv_SdtRatingProfesional_Ratingprofesionalid, false, includeNonInitialized);
      AddObjectProperty("SGProfesionalProfesionalId", gxTv_SdtRatingProfesional_Sgprofesionalprofesionalid, false, includeNonInitialized);
      AddObjectProperty("SGPacientePacienteId", gxTv_SdtRatingProfesional_Sgpacientepacienteid, false, includeNonInitialized);
      AddObjectProperty("RatingProfesionalCitaId", gxTv_SdtRatingProfesional_Ratingprofesionalcitaid, false, includeNonInitialized);
      AddObjectProperty("RatingProfesionalRating", gxTv_SdtRatingProfesional_Ratingprofesionalrating, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("RatingProfesionalFechaRegistro", sDateCnv, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtRatingProfesional_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtRatingProfesional_Initialized, false, includeNonInitialized);
         AddObjectProperty("RatingProfesionalId_Z", gxTv_SdtRatingProfesional_Ratingprofesionalid_Z, false, includeNonInitialized);
         AddObjectProperty("SGProfesionalProfesionalId_Z", gxTv_SdtRatingProfesional_Sgprofesionalprofesionalid_Z, false, includeNonInitialized);
         AddObjectProperty("SGPacientePacienteId_Z", gxTv_SdtRatingProfesional_Sgpacientepacienteid_Z, false, includeNonInitialized);
         AddObjectProperty("RatingProfesionalCitaId_Z", gxTv_SdtRatingProfesional_Ratingprofesionalcitaid_Z, false, includeNonInitialized);
         AddObjectProperty("RatingProfesionalRating_Z", gxTv_SdtRatingProfesional_Ratingprofesionalrating_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("RatingProfesionalFechaRegistro_Z", sDateCnv, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.projectthani.SdtRatingProfesional sdt )
   {
      if ( sdt.IsDirty("RatingProfesionalId") )
      {
         gxTv_SdtRatingProfesional_N = (byte)(0) ;
         gxTv_SdtRatingProfesional_Ratingprofesionalid = sdt.getgxTv_SdtRatingProfesional_Ratingprofesionalid() ;
      }
      if ( sdt.IsDirty("SGProfesionalProfesionalId") )
      {
         gxTv_SdtRatingProfesional_N = (byte)(0) ;
         gxTv_SdtRatingProfesional_Sgprofesionalprofesionalid = sdt.getgxTv_SdtRatingProfesional_Sgprofesionalprofesionalid() ;
      }
      if ( sdt.IsDirty("SGPacientePacienteId") )
      {
         gxTv_SdtRatingProfesional_N = (byte)(0) ;
         gxTv_SdtRatingProfesional_Sgpacientepacienteid = sdt.getgxTv_SdtRatingProfesional_Sgpacientepacienteid() ;
      }
      if ( sdt.IsDirty("RatingProfesionalCitaId") )
      {
         gxTv_SdtRatingProfesional_N = (byte)(0) ;
         gxTv_SdtRatingProfesional_Ratingprofesionalcitaid = sdt.getgxTv_SdtRatingProfesional_Ratingprofesionalcitaid() ;
      }
      if ( sdt.IsDirty("RatingProfesionalRating") )
      {
         gxTv_SdtRatingProfesional_N = (byte)(0) ;
         gxTv_SdtRatingProfesional_Ratingprofesionalrating = sdt.getgxTv_SdtRatingProfesional_Ratingprofesionalrating() ;
      }
      if ( sdt.IsDirty("RatingProfesionalFechaRegistro") )
      {
         gxTv_SdtRatingProfesional_N = (byte)(0) ;
         gxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro = sdt.getgxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro() ;
      }
   }

   public int getgxTv_SdtRatingProfesional_Ratingprofesionalid( )
   {
      return gxTv_SdtRatingProfesional_Ratingprofesionalid ;
   }

   public void setgxTv_SdtRatingProfesional_Ratingprofesionalid( int value )
   {
      gxTv_SdtRatingProfesional_N = (byte)(0) ;
      if ( gxTv_SdtRatingProfesional_Ratingprofesionalid != value )
      {
         gxTv_SdtRatingProfesional_Mode = "INS" ;
         this.setgxTv_SdtRatingProfesional_Ratingprofesionalid_Z_SetNull( );
         this.setgxTv_SdtRatingProfesional_Sgprofesionalprofesionalid_Z_SetNull( );
         this.setgxTv_SdtRatingProfesional_Sgpacientepacienteid_Z_SetNull( );
         this.setgxTv_SdtRatingProfesional_Ratingprofesionalcitaid_Z_SetNull( );
         this.setgxTv_SdtRatingProfesional_Ratingprofesionalrating_Z_SetNull( );
         this.setgxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro_Z_SetNull( );
      }
      SetDirty("Ratingprofesionalid");
      gxTv_SdtRatingProfesional_Ratingprofesionalid = value ;
   }

   public int getgxTv_SdtRatingProfesional_Sgprofesionalprofesionalid( )
   {
      return gxTv_SdtRatingProfesional_Sgprofesionalprofesionalid ;
   }

   public void setgxTv_SdtRatingProfesional_Sgprofesionalprofesionalid( int value )
   {
      gxTv_SdtRatingProfesional_N = (byte)(0) ;
      SetDirty("Sgprofesionalprofesionalid");
      gxTv_SdtRatingProfesional_Sgprofesionalprofesionalid = value ;
   }

   public int getgxTv_SdtRatingProfesional_Sgpacientepacienteid( )
   {
      return gxTv_SdtRatingProfesional_Sgpacientepacienteid ;
   }

   public void setgxTv_SdtRatingProfesional_Sgpacientepacienteid( int value )
   {
      gxTv_SdtRatingProfesional_N = (byte)(0) ;
      SetDirty("Sgpacientepacienteid");
      gxTv_SdtRatingProfesional_Sgpacientepacienteid = value ;
   }

   public short getgxTv_SdtRatingProfesional_Ratingprofesionalcitaid( )
   {
      return gxTv_SdtRatingProfesional_Ratingprofesionalcitaid ;
   }

   public void setgxTv_SdtRatingProfesional_Ratingprofesionalcitaid( short value )
   {
      gxTv_SdtRatingProfesional_N = (byte)(0) ;
      SetDirty("Ratingprofesionalcitaid");
      gxTv_SdtRatingProfesional_Ratingprofesionalcitaid = value ;
   }

   public short getgxTv_SdtRatingProfesional_Ratingprofesionalrating( )
   {
      return gxTv_SdtRatingProfesional_Ratingprofesionalrating ;
   }

   public void setgxTv_SdtRatingProfesional_Ratingprofesionalrating( short value )
   {
      gxTv_SdtRatingProfesional_N = (byte)(0) ;
      SetDirty("Ratingprofesionalrating");
      gxTv_SdtRatingProfesional_Ratingprofesionalrating = value ;
   }

   public java.util.Date getgxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro( )
   {
      return gxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro ;
   }

   public void setgxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro( java.util.Date value )
   {
      gxTv_SdtRatingProfesional_N = (byte)(0) ;
      SetDirty("Ratingprofesionalfecharegistro");
      gxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro = value ;
   }

   public String getgxTv_SdtRatingProfesional_Mode( )
   {
      return gxTv_SdtRatingProfesional_Mode ;
   }

   public void setgxTv_SdtRatingProfesional_Mode( String value )
   {
      gxTv_SdtRatingProfesional_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtRatingProfesional_Mode = value ;
   }

   public void setgxTv_SdtRatingProfesional_Mode_SetNull( )
   {
      gxTv_SdtRatingProfesional_Mode = "" ;
   }

   public boolean getgxTv_SdtRatingProfesional_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtRatingProfesional_Initialized( )
   {
      return gxTv_SdtRatingProfesional_Initialized ;
   }

   public void setgxTv_SdtRatingProfesional_Initialized( short value )
   {
      gxTv_SdtRatingProfesional_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtRatingProfesional_Initialized = value ;
   }

   public void setgxTv_SdtRatingProfesional_Initialized_SetNull( )
   {
      gxTv_SdtRatingProfesional_Initialized = (short)(0) ;
   }

   public boolean getgxTv_SdtRatingProfesional_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtRatingProfesional_Ratingprofesionalid_Z( )
   {
      return gxTv_SdtRatingProfesional_Ratingprofesionalid_Z ;
   }

   public void setgxTv_SdtRatingProfesional_Ratingprofesionalid_Z( int value )
   {
      gxTv_SdtRatingProfesional_N = (byte)(0) ;
      SetDirty("Ratingprofesionalid_Z");
      gxTv_SdtRatingProfesional_Ratingprofesionalid_Z = value ;
   }

   public void setgxTv_SdtRatingProfesional_Ratingprofesionalid_Z_SetNull( )
   {
      gxTv_SdtRatingProfesional_Ratingprofesionalid_Z = 0 ;
   }

   public boolean getgxTv_SdtRatingProfesional_Ratingprofesionalid_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtRatingProfesional_Sgprofesionalprofesionalid_Z( )
   {
      return gxTv_SdtRatingProfesional_Sgprofesionalprofesionalid_Z ;
   }

   public void setgxTv_SdtRatingProfesional_Sgprofesionalprofesionalid_Z( int value )
   {
      gxTv_SdtRatingProfesional_N = (byte)(0) ;
      SetDirty("Sgprofesionalprofesionalid_Z");
      gxTv_SdtRatingProfesional_Sgprofesionalprofesionalid_Z = value ;
   }

   public void setgxTv_SdtRatingProfesional_Sgprofesionalprofesionalid_Z_SetNull( )
   {
      gxTv_SdtRatingProfesional_Sgprofesionalprofesionalid_Z = 0 ;
   }

   public boolean getgxTv_SdtRatingProfesional_Sgprofesionalprofesionalid_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtRatingProfesional_Sgpacientepacienteid_Z( )
   {
      return gxTv_SdtRatingProfesional_Sgpacientepacienteid_Z ;
   }

   public void setgxTv_SdtRatingProfesional_Sgpacientepacienteid_Z( int value )
   {
      gxTv_SdtRatingProfesional_N = (byte)(0) ;
      SetDirty("Sgpacientepacienteid_Z");
      gxTv_SdtRatingProfesional_Sgpacientepacienteid_Z = value ;
   }

   public void setgxTv_SdtRatingProfesional_Sgpacientepacienteid_Z_SetNull( )
   {
      gxTv_SdtRatingProfesional_Sgpacientepacienteid_Z = 0 ;
   }

   public boolean getgxTv_SdtRatingProfesional_Sgpacientepacienteid_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtRatingProfesional_Ratingprofesionalcitaid_Z( )
   {
      return gxTv_SdtRatingProfesional_Ratingprofesionalcitaid_Z ;
   }

   public void setgxTv_SdtRatingProfesional_Ratingprofesionalcitaid_Z( short value )
   {
      gxTv_SdtRatingProfesional_N = (byte)(0) ;
      SetDirty("Ratingprofesionalcitaid_Z");
      gxTv_SdtRatingProfesional_Ratingprofesionalcitaid_Z = value ;
   }

   public void setgxTv_SdtRatingProfesional_Ratingprofesionalcitaid_Z_SetNull( )
   {
      gxTv_SdtRatingProfesional_Ratingprofesionalcitaid_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtRatingProfesional_Ratingprofesionalcitaid_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtRatingProfesional_Ratingprofesionalrating_Z( )
   {
      return gxTv_SdtRatingProfesional_Ratingprofesionalrating_Z ;
   }

   public void setgxTv_SdtRatingProfesional_Ratingprofesionalrating_Z( short value )
   {
      gxTv_SdtRatingProfesional_N = (byte)(0) ;
      SetDirty("Ratingprofesionalrating_Z");
      gxTv_SdtRatingProfesional_Ratingprofesionalrating_Z = value ;
   }

   public void setgxTv_SdtRatingProfesional_Ratingprofesionalrating_Z_SetNull( )
   {
      gxTv_SdtRatingProfesional_Ratingprofesionalrating_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtRatingProfesional_Ratingprofesionalrating_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro_Z( )
   {
      return gxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro_Z ;
   }

   public void setgxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro_Z( java.util.Date value )
   {
      gxTv_SdtRatingProfesional_N = (byte)(0) ;
      SetDirty("Ratingprofesionalfecharegistro_Z");
      gxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro_Z = value ;
   }

   public void setgxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro_Z_SetNull( )
   {
      gxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro_Z = GXutil.nullDate() ;
   }

   public boolean getgxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.projectthani.ratingprofesional_bc obj;
      obj = new com.projectthani.ratingprofesional_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtRatingProfesional_N = (byte)(1) ;
      gxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro = GXutil.nullDate() ;
      gxTv_SdtRatingProfesional_Mode = "" ;
      gxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro_Z = GXutil.nullDate() ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtRatingProfesional_N ;
   }

   public com.projectthani.SdtRatingProfesional Clone( )
   {
      com.projectthani.SdtRatingProfesional sdt;
      com.projectthani.ratingprofesional_bc obj;
      sdt = (com.projectthani.SdtRatingProfesional)(clone()) ;
      obj = (com.projectthani.ratingprofesional_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.projectthani.StructSdtRatingProfesional struct )
   {
      setgxTv_SdtRatingProfesional_Ratingprofesionalid(struct.getRatingprofesionalid());
      setgxTv_SdtRatingProfesional_Sgprofesionalprofesionalid(struct.getSgprofesionalprofesionalid());
      setgxTv_SdtRatingProfesional_Sgpacientepacienteid(struct.getSgpacientepacienteid());
      setgxTv_SdtRatingProfesional_Ratingprofesionalcitaid(struct.getRatingprofesionalcitaid());
      setgxTv_SdtRatingProfesional_Ratingprofesionalrating(struct.getRatingprofesionalrating());
      setgxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro(struct.getRatingprofesionalfecharegistro());
      setgxTv_SdtRatingProfesional_Mode(struct.getMode());
      setgxTv_SdtRatingProfesional_Initialized(struct.getInitialized());
      setgxTv_SdtRatingProfesional_Ratingprofesionalid_Z(struct.getRatingprofesionalid_Z());
      setgxTv_SdtRatingProfesional_Sgprofesionalprofesionalid_Z(struct.getSgprofesionalprofesionalid_Z());
      setgxTv_SdtRatingProfesional_Sgpacientepacienteid_Z(struct.getSgpacientepacienteid_Z());
      setgxTv_SdtRatingProfesional_Ratingprofesionalcitaid_Z(struct.getRatingprofesionalcitaid_Z());
      setgxTv_SdtRatingProfesional_Ratingprofesionalrating_Z(struct.getRatingprofesionalrating_Z());
      setgxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro_Z(struct.getRatingprofesionalfecharegistro_Z());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtRatingProfesional getStruct( )
   {
      com.projectthani.StructSdtRatingProfesional struct = new com.projectthani.StructSdtRatingProfesional ();
      struct.setRatingprofesionalid(getgxTv_SdtRatingProfesional_Ratingprofesionalid());
      struct.setSgprofesionalprofesionalid(getgxTv_SdtRatingProfesional_Sgprofesionalprofesionalid());
      struct.setSgpacientepacienteid(getgxTv_SdtRatingProfesional_Sgpacientepacienteid());
      struct.setRatingprofesionalcitaid(getgxTv_SdtRatingProfesional_Ratingprofesionalcitaid());
      struct.setRatingprofesionalrating(getgxTv_SdtRatingProfesional_Ratingprofesionalrating());
      struct.setRatingprofesionalfecharegistro(getgxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro());
      struct.setMode(getgxTv_SdtRatingProfesional_Mode());
      struct.setInitialized(getgxTv_SdtRatingProfesional_Initialized());
      struct.setRatingprofesionalid_Z(getgxTv_SdtRatingProfesional_Ratingprofesionalid_Z());
      struct.setSgprofesionalprofesionalid_Z(getgxTv_SdtRatingProfesional_Sgprofesionalprofesionalid_Z());
      struct.setSgpacientepacienteid_Z(getgxTv_SdtRatingProfesional_Sgpacientepacienteid_Z());
      struct.setRatingprofesionalcitaid_Z(getgxTv_SdtRatingProfesional_Ratingprofesionalcitaid_Z());
      struct.setRatingprofesionalrating_Z(getgxTv_SdtRatingProfesional_Ratingprofesionalrating_Z());
      struct.setRatingprofesionalfecharegistro_Z(getgxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro_Z());
      return struct ;
   }

   private byte gxTv_SdtRatingProfesional_N ;
   private short gxTv_SdtRatingProfesional_Ratingprofesionalcitaid ;
   private short gxTv_SdtRatingProfesional_Ratingprofesionalrating ;
   private short gxTv_SdtRatingProfesional_Initialized ;
   private short gxTv_SdtRatingProfesional_Ratingprofesionalcitaid_Z ;
   private short gxTv_SdtRatingProfesional_Ratingprofesionalrating_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtRatingProfesional_Ratingprofesionalid ;
   private int gxTv_SdtRatingProfesional_Sgprofesionalprofesionalid ;
   private int gxTv_SdtRatingProfesional_Sgpacientepacienteid ;
   private int gxTv_SdtRatingProfesional_Ratingprofesionalid_Z ;
   private int gxTv_SdtRatingProfesional_Sgprofesionalprofesionalid_Z ;
   private int gxTv_SdtRatingProfesional_Sgpacientepacienteid_Z ;
   private String gxTv_SdtRatingProfesional_Mode ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro ;
   private java.util.Date gxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro_Z ;
   private boolean readElement ;
   private boolean formatError ;
}

