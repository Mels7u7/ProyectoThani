package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtComentarioProfesional extends GxSilentTrnSdt implements Cloneable, java.io.Serializable
{
   public SdtComentarioProfesional( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtComentarioProfesional.class));
   }

   public SdtComentarioProfesional( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle, context, "SdtComentarioProfesional");
      initialize( remoteHandle) ;
   }

   public SdtComentarioProfesional( int remoteHandle ,
                                    StructSdtComentarioProfesional struct )
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

   public void Load( int AV63ComentarioProfesionalId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV63ComentarioProfesionalId)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"ComentarioProfesionalId", int.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "ComentarioProfesional");
      metadata.set("BT", "ComentarioProfesional");
      metadata.set("PK", "[ \"ComentarioProfesionalId\" ]");
      metadata.set("PKAssigned", "[ \"ComentarioProfesionalId\" ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ComentarioProfesionalId") )
            {
               gxTv_SdtComentarioProfesional_Comentarioprofesionalid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGPacientePacienteId") )
            {
               gxTv_SdtComentarioProfesional_Sgpacientepacienteid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGProfesionalProfesionalId") )
            {
               gxTv_SdtComentarioProfesional_Sgprofesionalprofesionalid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ComentarioProfesionalCitaId") )
            {
               gxTv_SdtComentarioProfesional_Comentarioprofesionalcitaid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ComentarioProfesionalComentario") )
            {
               gxTv_SdtComentarioProfesional_Comentarioprofesionalcomentario = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ComentarioProfesionalFechaRegistro") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
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
               gxTv_SdtComentarioProfesional_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtComentarioProfesional_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ComentarioProfesionalId_Z") )
            {
               gxTv_SdtComentarioProfesional_Comentarioprofesionalid_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGPacientePacienteId_Z") )
            {
               gxTv_SdtComentarioProfesional_Sgpacientepacienteid_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGProfesionalProfesionalId_Z") )
            {
               gxTv_SdtComentarioProfesional_Sgprofesionalprofesionalid_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ComentarioProfesionalCitaId_Z") )
            {
               gxTv_SdtComentarioProfesional_Comentarioprofesionalcitaid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ComentarioProfesionalFechaRegistro_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
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
         sName = "ComentarioProfesional" ;
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
      oWriter.writeElement("ComentarioProfesionalId", GXutil.trim( GXutil.str( gxTv_SdtComentarioProfesional_Comentarioprofesionalid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGPacientePacienteId", GXutil.trim( GXutil.str( gxTv_SdtComentarioProfesional_Sgpacientepacienteid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGProfesionalProfesionalId", GXutil.trim( GXutil.str( gxTv_SdtComentarioProfesional_Sgprofesionalprofesionalid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ComentarioProfesionalCitaId", GXutil.trim( GXutil.str( gxTv_SdtComentarioProfesional_Comentarioprofesionalcitaid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ComentarioProfesionalComentario", GXutil.rtrim( gxTv_SdtComentarioProfesional_Comentarioprofesionalcomentario));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("ComentarioProfesionalFechaRegistro", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", GXutil.rtrim( gxTv_SdtComentarioProfesional_Mode));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtComentarioProfesional_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ComentarioProfesionalId_Z", GXutil.trim( GXutil.str( gxTv_SdtComentarioProfesional_Comentarioprofesionalid_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SGPacientePacienteId_Z", GXutil.trim( GXutil.str( gxTv_SdtComentarioProfesional_Sgpacientepacienteid_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SGProfesionalProfesionalId_Z", GXutil.trim( GXutil.str( gxTv_SdtComentarioProfesional_Sgprofesionalprofesionalid_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("ComentarioProfesionalCitaId_Z", GXutil.trim( GXutil.str( gxTv_SdtComentarioProfesional_Comentarioprofesionalcitaid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("ComentarioProfesionalFechaRegistro_Z", sDateCnv);
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
      AddObjectProperty("ComentarioProfesionalId", gxTv_SdtComentarioProfesional_Comentarioprofesionalid, false, includeNonInitialized);
      AddObjectProperty("SGPacientePacienteId", gxTv_SdtComentarioProfesional_Sgpacientepacienteid, false, includeNonInitialized);
      AddObjectProperty("SGProfesionalProfesionalId", gxTv_SdtComentarioProfesional_Sgprofesionalprofesionalid, false, includeNonInitialized);
      AddObjectProperty("ComentarioProfesionalCitaId", gxTv_SdtComentarioProfesional_Comentarioprofesionalcitaid, false, includeNonInitialized);
      AddObjectProperty("ComentarioProfesionalComentario", gxTv_SdtComentarioProfesional_Comentarioprofesionalcomentario, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("ComentarioProfesionalFechaRegistro", sDateCnv, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtComentarioProfesional_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtComentarioProfesional_Initialized, false, includeNonInitialized);
         AddObjectProperty("ComentarioProfesionalId_Z", gxTv_SdtComentarioProfesional_Comentarioprofesionalid_Z, false, includeNonInitialized);
         AddObjectProperty("SGPacientePacienteId_Z", gxTv_SdtComentarioProfesional_Sgpacientepacienteid_Z, false, includeNonInitialized);
         AddObjectProperty("SGProfesionalProfesionalId_Z", gxTv_SdtComentarioProfesional_Sgprofesionalprofesionalid_Z, false, includeNonInitialized);
         AddObjectProperty("ComentarioProfesionalCitaId_Z", gxTv_SdtComentarioProfesional_Comentarioprofesionalcitaid_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("ComentarioProfesionalFechaRegistro_Z", sDateCnv, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.projectthani.SdtComentarioProfesional sdt )
   {
      if ( sdt.IsDirty("ComentarioProfesionalId") )
      {
         gxTv_SdtComentarioProfesional_N = (byte)(0) ;
         gxTv_SdtComentarioProfesional_Comentarioprofesionalid = sdt.getgxTv_SdtComentarioProfesional_Comentarioprofesionalid() ;
      }
      if ( sdt.IsDirty("SGPacientePacienteId") )
      {
         gxTv_SdtComentarioProfesional_N = (byte)(0) ;
         gxTv_SdtComentarioProfesional_Sgpacientepacienteid = sdt.getgxTv_SdtComentarioProfesional_Sgpacientepacienteid() ;
      }
      if ( sdt.IsDirty("SGProfesionalProfesionalId") )
      {
         gxTv_SdtComentarioProfesional_N = (byte)(0) ;
         gxTv_SdtComentarioProfesional_Sgprofesionalprofesionalid = sdt.getgxTv_SdtComentarioProfesional_Sgprofesionalprofesionalid() ;
      }
      if ( sdt.IsDirty("ComentarioProfesionalCitaId") )
      {
         gxTv_SdtComentarioProfesional_N = (byte)(0) ;
         gxTv_SdtComentarioProfesional_Comentarioprofesionalcitaid = sdt.getgxTv_SdtComentarioProfesional_Comentarioprofesionalcitaid() ;
      }
      if ( sdt.IsDirty("ComentarioProfesionalComentario") )
      {
         gxTv_SdtComentarioProfesional_N = (byte)(0) ;
         gxTv_SdtComentarioProfesional_Comentarioprofesionalcomentario = sdt.getgxTv_SdtComentarioProfesional_Comentarioprofesionalcomentario() ;
      }
      if ( sdt.IsDirty("ComentarioProfesionalFechaRegistro") )
      {
         gxTv_SdtComentarioProfesional_N = (byte)(0) ;
         gxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro = sdt.getgxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro() ;
      }
   }

   public int getgxTv_SdtComentarioProfesional_Comentarioprofesionalid( )
   {
      return gxTv_SdtComentarioProfesional_Comentarioprofesionalid ;
   }

   public void setgxTv_SdtComentarioProfesional_Comentarioprofesionalid( int value )
   {
      gxTv_SdtComentarioProfesional_N = (byte)(0) ;
      if ( gxTv_SdtComentarioProfesional_Comentarioprofesionalid != value )
      {
         gxTv_SdtComentarioProfesional_Mode = "INS" ;
         this.setgxTv_SdtComentarioProfesional_Comentarioprofesionalid_Z_SetNull( );
         this.setgxTv_SdtComentarioProfesional_Sgpacientepacienteid_Z_SetNull( );
         this.setgxTv_SdtComentarioProfesional_Sgprofesionalprofesionalid_Z_SetNull( );
         this.setgxTv_SdtComentarioProfesional_Comentarioprofesionalcitaid_Z_SetNull( );
         this.setgxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro_Z_SetNull( );
      }
      SetDirty("Comentarioprofesionalid");
      gxTv_SdtComentarioProfesional_Comentarioprofesionalid = value ;
   }

   public int getgxTv_SdtComentarioProfesional_Sgpacientepacienteid( )
   {
      return gxTv_SdtComentarioProfesional_Sgpacientepacienteid ;
   }

   public void setgxTv_SdtComentarioProfesional_Sgpacientepacienteid( int value )
   {
      gxTv_SdtComentarioProfesional_N = (byte)(0) ;
      SetDirty("Sgpacientepacienteid");
      gxTv_SdtComentarioProfesional_Sgpacientepacienteid = value ;
   }

   public int getgxTv_SdtComentarioProfesional_Sgprofesionalprofesionalid( )
   {
      return gxTv_SdtComentarioProfesional_Sgprofesionalprofesionalid ;
   }

   public void setgxTv_SdtComentarioProfesional_Sgprofesionalprofesionalid( int value )
   {
      gxTv_SdtComentarioProfesional_N = (byte)(0) ;
      SetDirty("Sgprofesionalprofesionalid");
      gxTv_SdtComentarioProfesional_Sgprofesionalprofesionalid = value ;
   }

   public short getgxTv_SdtComentarioProfesional_Comentarioprofesionalcitaid( )
   {
      return gxTv_SdtComentarioProfesional_Comentarioprofesionalcitaid ;
   }

   public void setgxTv_SdtComentarioProfesional_Comentarioprofesionalcitaid( short value )
   {
      gxTv_SdtComentarioProfesional_N = (byte)(0) ;
      SetDirty("Comentarioprofesionalcitaid");
      gxTv_SdtComentarioProfesional_Comentarioprofesionalcitaid = value ;
   }

   public String getgxTv_SdtComentarioProfesional_Comentarioprofesionalcomentario( )
   {
      return gxTv_SdtComentarioProfesional_Comentarioprofesionalcomentario ;
   }

   public void setgxTv_SdtComentarioProfesional_Comentarioprofesionalcomentario( String value )
   {
      gxTv_SdtComentarioProfesional_N = (byte)(0) ;
      SetDirty("Comentarioprofesionalcomentario");
      gxTv_SdtComentarioProfesional_Comentarioprofesionalcomentario = value ;
   }

   public java.util.Date getgxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro( )
   {
      return gxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro ;
   }

   public void setgxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro( java.util.Date value )
   {
      gxTv_SdtComentarioProfesional_N = (byte)(0) ;
      SetDirty("Comentarioprofesionalfecharegistro");
      gxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro = value ;
   }

   public String getgxTv_SdtComentarioProfesional_Mode( )
   {
      return gxTv_SdtComentarioProfesional_Mode ;
   }

   public void setgxTv_SdtComentarioProfesional_Mode( String value )
   {
      gxTv_SdtComentarioProfesional_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtComentarioProfesional_Mode = value ;
   }

   public void setgxTv_SdtComentarioProfesional_Mode_SetNull( )
   {
      gxTv_SdtComentarioProfesional_Mode = "" ;
   }

   public boolean getgxTv_SdtComentarioProfesional_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtComentarioProfesional_Initialized( )
   {
      return gxTv_SdtComentarioProfesional_Initialized ;
   }

   public void setgxTv_SdtComentarioProfesional_Initialized( short value )
   {
      gxTv_SdtComentarioProfesional_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtComentarioProfesional_Initialized = value ;
   }

   public void setgxTv_SdtComentarioProfesional_Initialized_SetNull( )
   {
      gxTv_SdtComentarioProfesional_Initialized = (short)(0) ;
   }

   public boolean getgxTv_SdtComentarioProfesional_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtComentarioProfesional_Comentarioprofesionalid_Z( )
   {
      return gxTv_SdtComentarioProfesional_Comentarioprofesionalid_Z ;
   }

   public void setgxTv_SdtComentarioProfesional_Comentarioprofesionalid_Z( int value )
   {
      gxTv_SdtComentarioProfesional_N = (byte)(0) ;
      SetDirty("Comentarioprofesionalid_Z");
      gxTv_SdtComentarioProfesional_Comentarioprofesionalid_Z = value ;
   }

   public void setgxTv_SdtComentarioProfesional_Comentarioprofesionalid_Z_SetNull( )
   {
      gxTv_SdtComentarioProfesional_Comentarioprofesionalid_Z = 0 ;
   }

   public boolean getgxTv_SdtComentarioProfesional_Comentarioprofesionalid_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtComentarioProfesional_Sgpacientepacienteid_Z( )
   {
      return gxTv_SdtComentarioProfesional_Sgpacientepacienteid_Z ;
   }

   public void setgxTv_SdtComentarioProfesional_Sgpacientepacienteid_Z( int value )
   {
      gxTv_SdtComentarioProfesional_N = (byte)(0) ;
      SetDirty("Sgpacientepacienteid_Z");
      gxTv_SdtComentarioProfesional_Sgpacientepacienteid_Z = value ;
   }

   public void setgxTv_SdtComentarioProfesional_Sgpacientepacienteid_Z_SetNull( )
   {
      gxTv_SdtComentarioProfesional_Sgpacientepacienteid_Z = 0 ;
   }

   public boolean getgxTv_SdtComentarioProfesional_Sgpacientepacienteid_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtComentarioProfesional_Sgprofesionalprofesionalid_Z( )
   {
      return gxTv_SdtComentarioProfesional_Sgprofesionalprofesionalid_Z ;
   }

   public void setgxTv_SdtComentarioProfesional_Sgprofesionalprofesionalid_Z( int value )
   {
      gxTv_SdtComentarioProfesional_N = (byte)(0) ;
      SetDirty("Sgprofesionalprofesionalid_Z");
      gxTv_SdtComentarioProfesional_Sgprofesionalprofesionalid_Z = value ;
   }

   public void setgxTv_SdtComentarioProfesional_Sgprofesionalprofesionalid_Z_SetNull( )
   {
      gxTv_SdtComentarioProfesional_Sgprofesionalprofesionalid_Z = 0 ;
   }

   public boolean getgxTv_SdtComentarioProfesional_Sgprofesionalprofesionalid_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtComentarioProfesional_Comentarioprofesionalcitaid_Z( )
   {
      return gxTv_SdtComentarioProfesional_Comentarioprofesionalcitaid_Z ;
   }

   public void setgxTv_SdtComentarioProfesional_Comentarioprofesionalcitaid_Z( short value )
   {
      gxTv_SdtComentarioProfesional_N = (byte)(0) ;
      SetDirty("Comentarioprofesionalcitaid_Z");
      gxTv_SdtComentarioProfesional_Comentarioprofesionalcitaid_Z = value ;
   }

   public void setgxTv_SdtComentarioProfesional_Comentarioprofesionalcitaid_Z_SetNull( )
   {
      gxTv_SdtComentarioProfesional_Comentarioprofesionalcitaid_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtComentarioProfesional_Comentarioprofesionalcitaid_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro_Z( )
   {
      return gxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro_Z ;
   }

   public void setgxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro_Z( java.util.Date value )
   {
      gxTv_SdtComentarioProfesional_N = (byte)(0) ;
      SetDirty("Comentarioprofesionalfecharegistro_Z");
      gxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro_Z = value ;
   }

   public void setgxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro_Z_SetNull( )
   {
      gxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro_Z = GXutil.nullDate() ;
   }

   public boolean getgxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.projectthani.comentarioprofesional_bc obj;
      obj = new com.projectthani.comentarioprofesional_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtComentarioProfesional_N = (byte)(1) ;
      gxTv_SdtComentarioProfesional_Comentarioprofesionalcomentario = "" ;
      gxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro = GXutil.nullDate() ;
      gxTv_SdtComentarioProfesional_Mode = "" ;
      gxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro_Z = GXutil.nullDate() ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtComentarioProfesional_N ;
   }

   public com.projectthani.SdtComentarioProfesional Clone( )
   {
      com.projectthani.SdtComentarioProfesional sdt;
      com.projectthani.comentarioprofesional_bc obj;
      sdt = (com.projectthani.SdtComentarioProfesional)(clone()) ;
      obj = (com.projectthani.comentarioprofesional_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.projectthani.StructSdtComentarioProfesional struct )
   {
      setgxTv_SdtComentarioProfesional_Comentarioprofesionalid(struct.getComentarioprofesionalid());
      setgxTv_SdtComentarioProfesional_Sgpacientepacienteid(struct.getSgpacientepacienteid());
      setgxTv_SdtComentarioProfesional_Sgprofesionalprofesionalid(struct.getSgprofesionalprofesionalid());
      setgxTv_SdtComentarioProfesional_Comentarioprofesionalcitaid(struct.getComentarioprofesionalcitaid());
      setgxTv_SdtComentarioProfesional_Comentarioprofesionalcomentario(struct.getComentarioprofesionalcomentario());
      setgxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro(struct.getComentarioprofesionalfecharegistro());
      setgxTv_SdtComentarioProfesional_Mode(struct.getMode());
      setgxTv_SdtComentarioProfesional_Initialized(struct.getInitialized());
      setgxTv_SdtComentarioProfesional_Comentarioprofesionalid_Z(struct.getComentarioprofesionalid_Z());
      setgxTv_SdtComentarioProfesional_Sgpacientepacienteid_Z(struct.getSgpacientepacienteid_Z());
      setgxTv_SdtComentarioProfesional_Sgprofesionalprofesionalid_Z(struct.getSgprofesionalprofesionalid_Z());
      setgxTv_SdtComentarioProfesional_Comentarioprofesionalcitaid_Z(struct.getComentarioprofesionalcitaid_Z());
      setgxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro_Z(struct.getComentarioprofesionalfecharegistro_Z());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtComentarioProfesional getStruct( )
   {
      com.projectthani.StructSdtComentarioProfesional struct = new com.projectthani.StructSdtComentarioProfesional ();
      struct.setComentarioprofesionalid(getgxTv_SdtComentarioProfesional_Comentarioprofesionalid());
      struct.setSgpacientepacienteid(getgxTv_SdtComentarioProfesional_Sgpacientepacienteid());
      struct.setSgprofesionalprofesionalid(getgxTv_SdtComentarioProfesional_Sgprofesionalprofesionalid());
      struct.setComentarioprofesionalcitaid(getgxTv_SdtComentarioProfesional_Comentarioprofesionalcitaid());
      struct.setComentarioprofesionalcomentario(getgxTv_SdtComentarioProfesional_Comentarioprofesionalcomentario());
      struct.setComentarioprofesionalfecharegistro(getgxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro());
      struct.setMode(getgxTv_SdtComentarioProfesional_Mode());
      struct.setInitialized(getgxTv_SdtComentarioProfesional_Initialized());
      struct.setComentarioprofesionalid_Z(getgxTv_SdtComentarioProfesional_Comentarioprofesionalid_Z());
      struct.setSgpacientepacienteid_Z(getgxTv_SdtComentarioProfesional_Sgpacientepacienteid_Z());
      struct.setSgprofesionalprofesionalid_Z(getgxTv_SdtComentarioProfesional_Sgprofesionalprofesionalid_Z());
      struct.setComentarioprofesionalcitaid_Z(getgxTv_SdtComentarioProfesional_Comentarioprofesionalcitaid_Z());
      struct.setComentarioprofesionalfecharegistro_Z(getgxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro_Z());
      return struct ;
   }

   private byte gxTv_SdtComentarioProfesional_N ;
   private short gxTv_SdtComentarioProfesional_Comentarioprofesionalcitaid ;
   private short gxTv_SdtComentarioProfesional_Initialized ;
   private short gxTv_SdtComentarioProfesional_Comentarioprofesionalcitaid_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtComentarioProfesional_Comentarioprofesionalid ;
   private int gxTv_SdtComentarioProfesional_Sgpacientepacienteid ;
   private int gxTv_SdtComentarioProfesional_Sgprofesionalprofesionalid ;
   private int gxTv_SdtComentarioProfesional_Comentarioprofesionalid_Z ;
   private int gxTv_SdtComentarioProfesional_Sgpacientepacienteid_Z ;
   private int gxTv_SdtComentarioProfesional_Sgprofesionalprofesionalid_Z ;
   private String gxTv_SdtComentarioProfesional_Mode ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro ;
   private java.util.Date gxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtComentarioProfesional_Comentarioprofesionalcomentario ;
}

