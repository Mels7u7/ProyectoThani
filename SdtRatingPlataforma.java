package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtRatingPlataforma extends GxSilentTrnSdt implements Cloneable, java.io.Serializable
{
   public SdtRatingPlataforma( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtRatingPlataforma.class));
   }

   public SdtRatingPlataforma( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle, context, "SdtRatingPlataforma");
      initialize( remoteHandle) ;
   }

   public SdtRatingPlataforma( int remoteHandle ,
                               StructSdtRatingPlataforma struct )
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

   public void Load( int AV398RatingPlataformaId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV398RatingPlataformaId)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"RatingPlataformaId", int.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "RatingPlataforma");
      metadata.set("BT", "RatingPlataforma");
      metadata.set("PK", "[ \"RatingPlataformaId\" ]");
      metadata.set("PKAssigned", "[ \"RatingPlataformaId\" ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "RatingPlataformaId") )
            {
               gxTv_SdtRatingPlataforma_Ratingplataformaid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGPacientePacienteId") )
            {
               gxTv_SdtRatingPlataforma_Sgpacientepacienteid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RatingPlataformaCitaId") )
            {
               gxTv_SdtRatingPlataforma_Ratingplataformacitaid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RatingPlataformaRating") )
            {
               gxTv_SdtRatingPlataforma_Ratingplataformarating = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RatingPlataformaFechaRegistro") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtRatingPlataforma_Ratingplataformafecharegistro = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtRatingPlataforma_Ratingplataformafecharegistro = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
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
               gxTv_SdtRatingPlataforma_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtRatingPlataforma_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RatingPlataformaId_Z") )
            {
               gxTv_SdtRatingPlataforma_Ratingplataformaid_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGPacientePacienteId_Z") )
            {
               gxTv_SdtRatingPlataforma_Sgpacientepacienteid_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RatingPlataformaCitaId_Z") )
            {
               gxTv_SdtRatingPlataforma_Ratingplataformacitaid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RatingPlataformaRating_Z") )
            {
               gxTv_SdtRatingPlataforma_Ratingplataformarating_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RatingPlataformaFechaRegistro_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtRatingPlataforma_Ratingplataformafecharegistro_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtRatingPlataforma_Ratingplataformafecharegistro_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
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
         sName = "RatingPlataforma" ;
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
      oWriter.writeElement("RatingPlataformaId", GXutil.trim( GXutil.str( gxTv_SdtRatingPlataforma_Ratingplataformaid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGPacientePacienteId", GXutil.trim( GXutil.str( gxTv_SdtRatingPlataforma_Sgpacientepacienteid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("RatingPlataformaCitaId", GXutil.trim( GXutil.str( gxTv_SdtRatingPlataforma_Ratingplataformacitaid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("RatingPlataformaRating", GXutil.trim( GXutil.str( gxTv_SdtRatingPlataforma_Ratingplataformarating, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtRatingPlataforma_Ratingplataformafecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtRatingPlataforma_Ratingplataformafecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtRatingPlataforma_Ratingplataformafecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("RatingPlataformaFechaRegistro", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", GXutil.rtrim( gxTv_SdtRatingPlataforma_Mode));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtRatingPlataforma_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("RatingPlataformaId_Z", GXutil.trim( GXutil.str( gxTv_SdtRatingPlataforma_Ratingplataformaid_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SGPacientePacienteId_Z", GXutil.trim( GXutil.str( gxTv_SdtRatingPlataforma_Sgpacientepacienteid_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("RatingPlataformaCitaId_Z", GXutil.trim( GXutil.str( gxTv_SdtRatingPlataforma_Ratingplataformacitaid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("RatingPlataformaRating_Z", GXutil.trim( GXutil.str( gxTv_SdtRatingPlataforma_Ratingplataformarating_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtRatingPlataforma_Ratingplataformafecharegistro_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtRatingPlataforma_Ratingplataformafecharegistro_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtRatingPlataforma_Ratingplataformafecharegistro_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("RatingPlataformaFechaRegistro_Z", sDateCnv);
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
      AddObjectProperty("RatingPlataformaId", gxTv_SdtRatingPlataforma_Ratingplataformaid, false, includeNonInitialized);
      AddObjectProperty("SGPacientePacienteId", gxTv_SdtRatingPlataforma_Sgpacientepacienteid, false, includeNonInitialized);
      AddObjectProperty("RatingPlataformaCitaId", gxTv_SdtRatingPlataforma_Ratingplataformacitaid, false, includeNonInitialized);
      AddObjectProperty("RatingPlataformaRating", gxTv_SdtRatingPlataforma_Ratingplataformarating, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtRatingPlataforma_Ratingplataformafecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtRatingPlataforma_Ratingplataformafecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtRatingPlataforma_Ratingplataformafecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("RatingPlataformaFechaRegistro", sDateCnv, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtRatingPlataforma_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtRatingPlataforma_Initialized, false, includeNonInitialized);
         AddObjectProperty("RatingPlataformaId_Z", gxTv_SdtRatingPlataforma_Ratingplataformaid_Z, false, includeNonInitialized);
         AddObjectProperty("SGPacientePacienteId_Z", gxTv_SdtRatingPlataforma_Sgpacientepacienteid_Z, false, includeNonInitialized);
         AddObjectProperty("RatingPlataformaCitaId_Z", gxTv_SdtRatingPlataforma_Ratingplataformacitaid_Z, false, includeNonInitialized);
         AddObjectProperty("RatingPlataformaRating_Z", gxTv_SdtRatingPlataforma_Ratingplataformarating_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtRatingPlataforma_Ratingplataformafecharegistro_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtRatingPlataforma_Ratingplataformafecharegistro_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtRatingPlataforma_Ratingplataformafecharegistro_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("RatingPlataformaFechaRegistro_Z", sDateCnv, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.projectthani.SdtRatingPlataforma sdt )
   {
      if ( sdt.IsDirty("RatingPlataformaId") )
      {
         gxTv_SdtRatingPlataforma_N = (byte)(0) ;
         gxTv_SdtRatingPlataforma_Ratingplataformaid = sdt.getgxTv_SdtRatingPlataforma_Ratingplataformaid() ;
      }
      if ( sdt.IsDirty("SGPacientePacienteId") )
      {
         gxTv_SdtRatingPlataforma_N = (byte)(0) ;
         gxTv_SdtRatingPlataforma_Sgpacientepacienteid = sdt.getgxTv_SdtRatingPlataforma_Sgpacientepacienteid() ;
      }
      if ( sdt.IsDirty("RatingPlataformaCitaId") )
      {
         gxTv_SdtRatingPlataforma_N = (byte)(0) ;
         gxTv_SdtRatingPlataforma_Ratingplataformacitaid = sdt.getgxTv_SdtRatingPlataforma_Ratingplataformacitaid() ;
      }
      if ( sdt.IsDirty("RatingPlataformaRating") )
      {
         gxTv_SdtRatingPlataforma_N = (byte)(0) ;
         gxTv_SdtRatingPlataforma_Ratingplataformarating = sdt.getgxTv_SdtRatingPlataforma_Ratingplataformarating() ;
      }
      if ( sdt.IsDirty("RatingPlataformaFechaRegistro") )
      {
         gxTv_SdtRatingPlataforma_N = (byte)(0) ;
         gxTv_SdtRatingPlataforma_Ratingplataformafecharegistro = sdt.getgxTv_SdtRatingPlataforma_Ratingplataformafecharegistro() ;
      }
   }

   public int getgxTv_SdtRatingPlataforma_Ratingplataformaid( )
   {
      return gxTv_SdtRatingPlataforma_Ratingplataformaid ;
   }

   public void setgxTv_SdtRatingPlataforma_Ratingplataformaid( int value )
   {
      gxTv_SdtRatingPlataforma_N = (byte)(0) ;
      if ( gxTv_SdtRatingPlataforma_Ratingplataformaid != value )
      {
         gxTv_SdtRatingPlataforma_Mode = "INS" ;
         this.setgxTv_SdtRatingPlataforma_Ratingplataformaid_Z_SetNull( );
         this.setgxTv_SdtRatingPlataforma_Sgpacientepacienteid_Z_SetNull( );
         this.setgxTv_SdtRatingPlataforma_Ratingplataformacitaid_Z_SetNull( );
         this.setgxTv_SdtRatingPlataforma_Ratingplataformarating_Z_SetNull( );
         this.setgxTv_SdtRatingPlataforma_Ratingplataformafecharegistro_Z_SetNull( );
      }
      SetDirty("Ratingplataformaid");
      gxTv_SdtRatingPlataforma_Ratingplataformaid = value ;
   }

   public int getgxTv_SdtRatingPlataforma_Sgpacientepacienteid( )
   {
      return gxTv_SdtRatingPlataforma_Sgpacientepacienteid ;
   }

   public void setgxTv_SdtRatingPlataforma_Sgpacientepacienteid( int value )
   {
      gxTv_SdtRatingPlataforma_N = (byte)(0) ;
      SetDirty("Sgpacientepacienteid");
      gxTv_SdtRatingPlataforma_Sgpacientepacienteid = value ;
   }

   public short getgxTv_SdtRatingPlataforma_Ratingplataformacitaid( )
   {
      return gxTv_SdtRatingPlataforma_Ratingplataformacitaid ;
   }

   public void setgxTv_SdtRatingPlataforma_Ratingplataformacitaid( short value )
   {
      gxTv_SdtRatingPlataforma_N = (byte)(0) ;
      SetDirty("Ratingplataformacitaid");
      gxTv_SdtRatingPlataforma_Ratingplataformacitaid = value ;
   }

   public short getgxTv_SdtRatingPlataforma_Ratingplataformarating( )
   {
      return gxTv_SdtRatingPlataforma_Ratingplataformarating ;
   }

   public void setgxTv_SdtRatingPlataforma_Ratingplataformarating( short value )
   {
      gxTv_SdtRatingPlataforma_N = (byte)(0) ;
      SetDirty("Ratingplataformarating");
      gxTv_SdtRatingPlataforma_Ratingplataformarating = value ;
   }

   public java.util.Date getgxTv_SdtRatingPlataforma_Ratingplataformafecharegistro( )
   {
      return gxTv_SdtRatingPlataforma_Ratingplataformafecharegistro ;
   }

   public void setgxTv_SdtRatingPlataforma_Ratingplataformafecharegistro( java.util.Date value )
   {
      gxTv_SdtRatingPlataforma_N = (byte)(0) ;
      SetDirty("Ratingplataformafecharegistro");
      gxTv_SdtRatingPlataforma_Ratingplataformafecharegistro = value ;
   }

   public String getgxTv_SdtRatingPlataforma_Mode( )
   {
      return gxTv_SdtRatingPlataforma_Mode ;
   }

   public void setgxTv_SdtRatingPlataforma_Mode( String value )
   {
      gxTv_SdtRatingPlataforma_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtRatingPlataforma_Mode = value ;
   }

   public void setgxTv_SdtRatingPlataforma_Mode_SetNull( )
   {
      gxTv_SdtRatingPlataforma_Mode = "" ;
   }

   public boolean getgxTv_SdtRatingPlataforma_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtRatingPlataforma_Initialized( )
   {
      return gxTv_SdtRatingPlataforma_Initialized ;
   }

   public void setgxTv_SdtRatingPlataforma_Initialized( short value )
   {
      gxTv_SdtRatingPlataforma_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtRatingPlataforma_Initialized = value ;
   }

   public void setgxTv_SdtRatingPlataforma_Initialized_SetNull( )
   {
      gxTv_SdtRatingPlataforma_Initialized = (short)(0) ;
   }

   public boolean getgxTv_SdtRatingPlataforma_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtRatingPlataforma_Ratingplataformaid_Z( )
   {
      return gxTv_SdtRatingPlataforma_Ratingplataformaid_Z ;
   }

   public void setgxTv_SdtRatingPlataforma_Ratingplataformaid_Z( int value )
   {
      gxTv_SdtRatingPlataforma_N = (byte)(0) ;
      SetDirty("Ratingplataformaid_Z");
      gxTv_SdtRatingPlataforma_Ratingplataformaid_Z = value ;
   }

   public void setgxTv_SdtRatingPlataforma_Ratingplataformaid_Z_SetNull( )
   {
      gxTv_SdtRatingPlataforma_Ratingplataformaid_Z = 0 ;
   }

   public boolean getgxTv_SdtRatingPlataforma_Ratingplataformaid_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtRatingPlataforma_Sgpacientepacienteid_Z( )
   {
      return gxTv_SdtRatingPlataforma_Sgpacientepacienteid_Z ;
   }

   public void setgxTv_SdtRatingPlataforma_Sgpacientepacienteid_Z( int value )
   {
      gxTv_SdtRatingPlataforma_N = (byte)(0) ;
      SetDirty("Sgpacientepacienteid_Z");
      gxTv_SdtRatingPlataforma_Sgpacientepacienteid_Z = value ;
   }

   public void setgxTv_SdtRatingPlataforma_Sgpacientepacienteid_Z_SetNull( )
   {
      gxTv_SdtRatingPlataforma_Sgpacientepacienteid_Z = 0 ;
   }

   public boolean getgxTv_SdtRatingPlataforma_Sgpacientepacienteid_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtRatingPlataforma_Ratingplataformacitaid_Z( )
   {
      return gxTv_SdtRatingPlataforma_Ratingplataformacitaid_Z ;
   }

   public void setgxTv_SdtRatingPlataforma_Ratingplataformacitaid_Z( short value )
   {
      gxTv_SdtRatingPlataforma_N = (byte)(0) ;
      SetDirty("Ratingplataformacitaid_Z");
      gxTv_SdtRatingPlataforma_Ratingplataformacitaid_Z = value ;
   }

   public void setgxTv_SdtRatingPlataforma_Ratingplataformacitaid_Z_SetNull( )
   {
      gxTv_SdtRatingPlataforma_Ratingplataformacitaid_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtRatingPlataforma_Ratingplataformacitaid_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtRatingPlataforma_Ratingplataformarating_Z( )
   {
      return gxTv_SdtRatingPlataforma_Ratingplataformarating_Z ;
   }

   public void setgxTv_SdtRatingPlataforma_Ratingplataformarating_Z( short value )
   {
      gxTv_SdtRatingPlataforma_N = (byte)(0) ;
      SetDirty("Ratingplataformarating_Z");
      gxTv_SdtRatingPlataforma_Ratingplataformarating_Z = value ;
   }

   public void setgxTv_SdtRatingPlataforma_Ratingplataformarating_Z_SetNull( )
   {
      gxTv_SdtRatingPlataforma_Ratingplataformarating_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtRatingPlataforma_Ratingplataformarating_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtRatingPlataforma_Ratingplataformafecharegistro_Z( )
   {
      return gxTv_SdtRatingPlataforma_Ratingplataformafecharegistro_Z ;
   }

   public void setgxTv_SdtRatingPlataforma_Ratingplataformafecharegistro_Z( java.util.Date value )
   {
      gxTv_SdtRatingPlataforma_N = (byte)(0) ;
      SetDirty("Ratingplataformafecharegistro_Z");
      gxTv_SdtRatingPlataforma_Ratingplataformafecharegistro_Z = value ;
   }

   public void setgxTv_SdtRatingPlataforma_Ratingplataformafecharegistro_Z_SetNull( )
   {
      gxTv_SdtRatingPlataforma_Ratingplataformafecharegistro_Z = GXutil.nullDate() ;
   }

   public boolean getgxTv_SdtRatingPlataforma_Ratingplataformafecharegistro_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.projectthani.ratingplataforma_bc obj;
      obj = new com.projectthani.ratingplataforma_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtRatingPlataforma_N = (byte)(1) ;
      gxTv_SdtRatingPlataforma_Ratingplataformafecharegistro = GXutil.nullDate() ;
      gxTv_SdtRatingPlataforma_Mode = "" ;
      gxTv_SdtRatingPlataforma_Ratingplataformafecharegistro_Z = GXutil.nullDate() ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtRatingPlataforma_N ;
   }

   public com.projectthani.SdtRatingPlataforma Clone( )
   {
      com.projectthani.SdtRatingPlataforma sdt;
      com.projectthani.ratingplataforma_bc obj;
      sdt = (com.projectthani.SdtRatingPlataforma)(clone()) ;
      obj = (com.projectthani.ratingplataforma_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.projectthani.StructSdtRatingPlataforma struct )
   {
      setgxTv_SdtRatingPlataforma_Ratingplataformaid(struct.getRatingplataformaid());
      setgxTv_SdtRatingPlataforma_Sgpacientepacienteid(struct.getSgpacientepacienteid());
      setgxTv_SdtRatingPlataforma_Ratingplataformacitaid(struct.getRatingplataformacitaid());
      setgxTv_SdtRatingPlataforma_Ratingplataformarating(struct.getRatingplataformarating());
      setgxTv_SdtRatingPlataforma_Ratingplataformafecharegistro(struct.getRatingplataformafecharegistro());
      setgxTv_SdtRatingPlataforma_Mode(struct.getMode());
      setgxTv_SdtRatingPlataforma_Initialized(struct.getInitialized());
      setgxTv_SdtRatingPlataforma_Ratingplataformaid_Z(struct.getRatingplataformaid_Z());
      setgxTv_SdtRatingPlataforma_Sgpacientepacienteid_Z(struct.getSgpacientepacienteid_Z());
      setgxTv_SdtRatingPlataforma_Ratingplataformacitaid_Z(struct.getRatingplataformacitaid_Z());
      setgxTv_SdtRatingPlataforma_Ratingplataformarating_Z(struct.getRatingplataformarating_Z());
      setgxTv_SdtRatingPlataforma_Ratingplataformafecharegistro_Z(struct.getRatingplataformafecharegistro_Z());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtRatingPlataforma getStruct( )
   {
      com.projectthani.StructSdtRatingPlataforma struct = new com.projectthani.StructSdtRatingPlataforma ();
      struct.setRatingplataformaid(getgxTv_SdtRatingPlataforma_Ratingplataformaid());
      struct.setSgpacientepacienteid(getgxTv_SdtRatingPlataforma_Sgpacientepacienteid());
      struct.setRatingplataformacitaid(getgxTv_SdtRatingPlataforma_Ratingplataformacitaid());
      struct.setRatingplataformarating(getgxTv_SdtRatingPlataforma_Ratingplataformarating());
      struct.setRatingplataformafecharegistro(getgxTv_SdtRatingPlataforma_Ratingplataformafecharegistro());
      struct.setMode(getgxTv_SdtRatingPlataforma_Mode());
      struct.setInitialized(getgxTv_SdtRatingPlataforma_Initialized());
      struct.setRatingplataformaid_Z(getgxTv_SdtRatingPlataforma_Ratingplataformaid_Z());
      struct.setSgpacientepacienteid_Z(getgxTv_SdtRatingPlataforma_Sgpacientepacienteid_Z());
      struct.setRatingplataformacitaid_Z(getgxTv_SdtRatingPlataforma_Ratingplataformacitaid_Z());
      struct.setRatingplataformarating_Z(getgxTv_SdtRatingPlataforma_Ratingplataformarating_Z());
      struct.setRatingplataformafecharegistro_Z(getgxTv_SdtRatingPlataforma_Ratingplataformafecharegistro_Z());
      return struct ;
   }

   private byte gxTv_SdtRatingPlataforma_N ;
   private short gxTv_SdtRatingPlataforma_Ratingplataformacitaid ;
   private short gxTv_SdtRatingPlataforma_Ratingplataformarating ;
   private short gxTv_SdtRatingPlataforma_Initialized ;
   private short gxTv_SdtRatingPlataforma_Ratingplataformacitaid_Z ;
   private short gxTv_SdtRatingPlataforma_Ratingplataformarating_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtRatingPlataforma_Ratingplataformaid ;
   private int gxTv_SdtRatingPlataforma_Sgpacientepacienteid ;
   private int gxTv_SdtRatingPlataforma_Ratingplataformaid_Z ;
   private int gxTv_SdtRatingPlataforma_Sgpacientepacienteid_Z ;
   private String gxTv_SdtRatingPlataforma_Mode ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_SdtRatingPlataforma_Ratingplataformafecharegistro ;
   private java.util.Date gxTv_SdtRatingPlataforma_Ratingplataformafecharegistro_Z ;
   private boolean readElement ;
   private boolean formatError ;
}

