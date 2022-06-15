package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtPacienteFamiliar extends GxSilentTrnSdt implements Cloneable, java.io.Serializable
{
   public SdtPacienteFamiliar( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtPacienteFamiliar.class));
   }

   public SdtPacienteFamiliar( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle, context, "SdtPacienteFamiliar");
      initialize( remoteHandle) ;
   }

   public SdtPacienteFamiliar( int remoteHandle ,
                               StructSdtPacienteFamiliar struct )
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

   public void Load( int AV45PacienteFamiliarId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV45PacienteFamiliarId)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"PacienteFamiliarId", int.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "PacienteFamiliar");
      metadata.set("BT", "PacienteFamiliar");
      metadata.set("PK", "[ \"PacienteFamiliarId\" ]");
      metadata.set("PKAssigned", "[ \"PacienteFamiliarId\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"PacienteId\" ],\"FKMap\":[  ] },{ \"FK\":[ \"PacienteId\" ],\"FKMap\":[ \"SGPacienteHijoPacienteId-PacienteId\" ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteFamiliarId") )
            {
               gxTv_SdtPacienteFamiliar_Pacientefamiliarid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteId") )
            {
               gxTv_SdtPacienteFamiliar_Pacienteid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGPacienteHijoPacienteId") )
            {
               gxTv_SdtPacienteFamiliar_Sgpacientehijopacienteid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGPacienteHijoNombres") )
            {
               gxTv_SdtPacienteFamiliar_Sgpacientehijonombres = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGPacienteHijoApellidoPaterno") )
            {
               gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidopaterno = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGPacienteHijoApellidoMaterno") )
            {
               gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidomaterno = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteFamiliarParentesco") )
            {
               gxTv_SdtPacienteFamiliar_Pacientefamiliarparentesco = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteFamiliarEstado") )
            {
               gxTv_SdtPacienteFamiliar_Pacientefamiliarestado = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtPacienteFamiliar_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtPacienteFamiliar_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteFamiliarId_Z") )
            {
               gxTv_SdtPacienteFamiliar_Pacientefamiliarid_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteId_Z") )
            {
               gxTv_SdtPacienteFamiliar_Pacienteid_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGPacienteHijoPacienteId_Z") )
            {
               gxTv_SdtPacienteFamiliar_Sgpacientehijopacienteid_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGPacienteHijoNombres_Z") )
            {
               gxTv_SdtPacienteFamiliar_Sgpacientehijonombres_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGPacienteHijoApellidoPaterno_Z") )
            {
               gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidopaterno_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGPacienteHijoApellidoMaterno_Z") )
            {
               gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidomaterno_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteFamiliarParentesco_Z") )
            {
               gxTv_SdtPacienteFamiliar_Pacientefamiliarparentesco_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteFamiliarEstado_Z") )
            {
               gxTv_SdtPacienteFamiliar_Pacientefamiliarestado_Z = oReader.getValue() ;
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
         sName = "PacienteFamiliar" ;
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
      oWriter.writeElement("PacienteFamiliarId", GXutil.trim( GXutil.str( gxTv_SdtPacienteFamiliar_Pacientefamiliarid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteId", GXutil.trim( GXutil.str( gxTv_SdtPacienteFamiliar_Pacienteid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGPacienteHijoPacienteId", GXutil.trim( GXutil.str( gxTv_SdtPacienteFamiliar_Sgpacientehijopacienteid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGPacienteHijoNombres", GXutil.rtrim( gxTv_SdtPacienteFamiliar_Sgpacientehijonombres));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGPacienteHijoApellidoPaterno", GXutil.rtrim( gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidopaterno));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGPacienteHijoApellidoMaterno", GXutil.rtrim( gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidomaterno));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteFamiliarParentesco", GXutil.rtrim( gxTv_SdtPacienteFamiliar_Pacientefamiliarparentesco));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteFamiliarEstado", GXutil.rtrim( gxTv_SdtPacienteFamiliar_Pacientefamiliarestado));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", GXutil.rtrim( gxTv_SdtPacienteFamiliar_Mode));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtPacienteFamiliar_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PacienteFamiliarId_Z", GXutil.trim( GXutil.str( gxTv_SdtPacienteFamiliar_Pacientefamiliarid_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PacienteId_Z", GXutil.trim( GXutil.str( gxTv_SdtPacienteFamiliar_Pacienteid_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SGPacienteHijoPacienteId_Z", GXutil.trim( GXutil.str( gxTv_SdtPacienteFamiliar_Sgpacientehijopacienteid_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SGPacienteHijoNombres_Z", GXutil.rtrim( gxTv_SdtPacienteFamiliar_Sgpacientehijonombres_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SGPacienteHijoApellidoPaterno_Z", GXutil.rtrim( gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidopaterno_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SGPacienteHijoApellidoMaterno_Z", GXutil.rtrim( gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidomaterno_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PacienteFamiliarParentesco_Z", GXutil.rtrim( gxTv_SdtPacienteFamiliar_Pacientefamiliarparentesco_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("PacienteFamiliarEstado_Z", GXutil.rtrim( gxTv_SdtPacienteFamiliar_Pacientefamiliarestado_Z));
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
      AddObjectProperty("PacienteFamiliarId", gxTv_SdtPacienteFamiliar_Pacientefamiliarid, false, includeNonInitialized);
      AddObjectProperty("PacienteId", gxTv_SdtPacienteFamiliar_Pacienteid, false, includeNonInitialized);
      AddObjectProperty("SGPacienteHijoPacienteId", gxTv_SdtPacienteFamiliar_Sgpacientehijopacienteid, false, includeNonInitialized);
      AddObjectProperty("SGPacienteHijoNombres", gxTv_SdtPacienteFamiliar_Sgpacientehijonombres, false, includeNonInitialized);
      AddObjectProperty("SGPacienteHijoApellidoPaterno", gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidopaterno, false, includeNonInitialized);
      AddObjectProperty("SGPacienteHijoApellidoMaterno", gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidomaterno, false, includeNonInitialized);
      AddObjectProperty("PacienteFamiliarParentesco", gxTv_SdtPacienteFamiliar_Pacientefamiliarparentesco, false, includeNonInitialized);
      AddObjectProperty("PacienteFamiliarEstado", gxTv_SdtPacienteFamiliar_Pacientefamiliarestado, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtPacienteFamiliar_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtPacienteFamiliar_Initialized, false, includeNonInitialized);
         AddObjectProperty("PacienteFamiliarId_Z", gxTv_SdtPacienteFamiliar_Pacientefamiliarid_Z, false, includeNonInitialized);
         AddObjectProperty("PacienteId_Z", gxTv_SdtPacienteFamiliar_Pacienteid_Z, false, includeNonInitialized);
         AddObjectProperty("SGPacienteHijoPacienteId_Z", gxTv_SdtPacienteFamiliar_Sgpacientehijopacienteid_Z, false, includeNonInitialized);
         AddObjectProperty("SGPacienteHijoNombres_Z", gxTv_SdtPacienteFamiliar_Sgpacientehijonombres_Z, false, includeNonInitialized);
         AddObjectProperty("SGPacienteHijoApellidoPaterno_Z", gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidopaterno_Z, false, includeNonInitialized);
         AddObjectProperty("SGPacienteHijoApellidoMaterno_Z", gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidomaterno_Z, false, includeNonInitialized);
         AddObjectProperty("PacienteFamiliarParentesco_Z", gxTv_SdtPacienteFamiliar_Pacientefamiliarparentesco_Z, false, includeNonInitialized);
         AddObjectProperty("PacienteFamiliarEstado_Z", gxTv_SdtPacienteFamiliar_Pacientefamiliarestado_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.projectthani.SdtPacienteFamiliar sdt )
   {
      if ( sdt.IsDirty("PacienteFamiliarId") )
      {
         gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
         gxTv_SdtPacienteFamiliar_Pacientefamiliarid = sdt.getgxTv_SdtPacienteFamiliar_Pacientefamiliarid() ;
      }
      if ( sdt.IsDirty("PacienteId") )
      {
         gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
         gxTv_SdtPacienteFamiliar_Pacienteid = sdt.getgxTv_SdtPacienteFamiliar_Pacienteid() ;
      }
      if ( sdt.IsDirty("SGPacienteHijoPacienteId") )
      {
         gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
         gxTv_SdtPacienteFamiliar_Sgpacientehijopacienteid = sdt.getgxTv_SdtPacienteFamiliar_Sgpacientehijopacienteid() ;
      }
      if ( sdt.IsDirty("SGPacienteHijoNombres") )
      {
         gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
         gxTv_SdtPacienteFamiliar_Sgpacientehijonombres = sdt.getgxTv_SdtPacienteFamiliar_Sgpacientehijonombres() ;
      }
      if ( sdt.IsDirty("SGPacienteHijoApellidoPaterno") )
      {
         gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
         gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidopaterno = sdt.getgxTv_SdtPacienteFamiliar_Sgpacientehijoapellidopaterno() ;
      }
      if ( sdt.IsDirty("SGPacienteHijoApellidoMaterno") )
      {
         gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
         gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidomaterno = sdt.getgxTv_SdtPacienteFamiliar_Sgpacientehijoapellidomaterno() ;
      }
      if ( sdt.IsDirty("PacienteFamiliarParentesco") )
      {
         gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
         gxTv_SdtPacienteFamiliar_Pacientefamiliarparentesco = sdt.getgxTv_SdtPacienteFamiliar_Pacientefamiliarparentesco() ;
      }
      if ( sdt.IsDirty("PacienteFamiliarEstado") )
      {
         gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
         gxTv_SdtPacienteFamiliar_Pacientefamiliarestado = sdt.getgxTv_SdtPacienteFamiliar_Pacientefamiliarestado() ;
      }
   }

   public int getgxTv_SdtPacienteFamiliar_Pacientefamiliarid( )
   {
      return gxTv_SdtPacienteFamiliar_Pacientefamiliarid ;
   }

   public void setgxTv_SdtPacienteFamiliar_Pacientefamiliarid( int value )
   {
      gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
      if ( gxTv_SdtPacienteFamiliar_Pacientefamiliarid != value )
      {
         gxTv_SdtPacienteFamiliar_Mode = "INS" ;
         this.setgxTv_SdtPacienteFamiliar_Pacientefamiliarid_Z_SetNull( );
         this.setgxTv_SdtPacienteFamiliar_Pacienteid_Z_SetNull( );
         this.setgxTv_SdtPacienteFamiliar_Sgpacientehijopacienteid_Z_SetNull( );
         this.setgxTv_SdtPacienteFamiliar_Sgpacientehijonombres_Z_SetNull( );
         this.setgxTv_SdtPacienteFamiliar_Sgpacientehijoapellidopaterno_Z_SetNull( );
         this.setgxTv_SdtPacienteFamiliar_Sgpacientehijoapellidomaterno_Z_SetNull( );
         this.setgxTv_SdtPacienteFamiliar_Pacientefamiliarparentesco_Z_SetNull( );
         this.setgxTv_SdtPacienteFamiliar_Pacientefamiliarestado_Z_SetNull( );
      }
      SetDirty("Pacientefamiliarid");
      gxTv_SdtPacienteFamiliar_Pacientefamiliarid = value ;
   }

   public int getgxTv_SdtPacienteFamiliar_Pacienteid( )
   {
      return gxTv_SdtPacienteFamiliar_Pacienteid ;
   }

   public void setgxTv_SdtPacienteFamiliar_Pacienteid( int value )
   {
      gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
      SetDirty("Pacienteid");
      gxTv_SdtPacienteFamiliar_Pacienteid = value ;
   }

   public int getgxTv_SdtPacienteFamiliar_Sgpacientehijopacienteid( )
   {
      return gxTv_SdtPacienteFamiliar_Sgpacientehijopacienteid ;
   }

   public void setgxTv_SdtPacienteFamiliar_Sgpacientehijopacienteid( int value )
   {
      gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
      SetDirty("Sgpacientehijopacienteid");
      gxTv_SdtPacienteFamiliar_Sgpacientehijopacienteid = value ;
   }

   public String getgxTv_SdtPacienteFamiliar_Sgpacientehijonombres( )
   {
      return gxTv_SdtPacienteFamiliar_Sgpacientehijonombres ;
   }

   public void setgxTv_SdtPacienteFamiliar_Sgpacientehijonombres( String value )
   {
      gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
      SetDirty("Sgpacientehijonombres");
      gxTv_SdtPacienteFamiliar_Sgpacientehijonombres = value ;
   }

   public String getgxTv_SdtPacienteFamiliar_Sgpacientehijoapellidopaterno( )
   {
      return gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidopaterno ;
   }

   public void setgxTv_SdtPacienteFamiliar_Sgpacientehijoapellidopaterno( String value )
   {
      gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
      SetDirty("Sgpacientehijoapellidopaterno");
      gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidopaterno = value ;
   }

   public String getgxTv_SdtPacienteFamiliar_Sgpacientehijoapellidomaterno( )
   {
      return gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidomaterno ;
   }

   public void setgxTv_SdtPacienteFamiliar_Sgpacientehijoapellidomaterno( String value )
   {
      gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
      SetDirty("Sgpacientehijoapellidomaterno");
      gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidomaterno = value ;
   }

   public String getgxTv_SdtPacienteFamiliar_Pacientefamiliarparentesco( )
   {
      return gxTv_SdtPacienteFamiliar_Pacientefamiliarparentesco ;
   }

   public void setgxTv_SdtPacienteFamiliar_Pacientefamiliarparentesco( String value )
   {
      gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
      SetDirty("Pacientefamiliarparentesco");
      gxTv_SdtPacienteFamiliar_Pacientefamiliarparentesco = value ;
   }

   public String getgxTv_SdtPacienteFamiliar_Pacientefamiliarestado( )
   {
      return gxTv_SdtPacienteFamiliar_Pacientefamiliarestado ;
   }

   public void setgxTv_SdtPacienteFamiliar_Pacientefamiliarestado( String value )
   {
      gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
      SetDirty("Pacientefamiliarestado");
      gxTv_SdtPacienteFamiliar_Pacientefamiliarestado = value ;
   }

   public String getgxTv_SdtPacienteFamiliar_Mode( )
   {
      return gxTv_SdtPacienteFamiliar_Mode ;
   }

   public void setgxTv_SdtPacienteFamiliar_Mode( String value )
   {
      gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtPacienteFamiliar_Mode = value ;
   }

   public void setgxTv_SdtPacienteFamiliar_Mode_SetNull( )
   {
      gxTv_SdtPacienteFamiliar_Mode = "" ;
   }

   public boolean getgxTv_SdtPacienteFamiliar_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtPacienteFamiliar_Initialized( )
   {
      return gxTv_SdtPacienteFamiliar_Initialized ;
   }

   public void setgxTv_SdtPacienteFamiliar_Initialized( short value )
   {
      gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtPacienteFamiliar_Initialized = value ;
   }

   public void setgxTv_SdtPacienteFamiliar_Initialized_SetNull( )
   {
      gxTv_SdtPacienteFamiliar_Initialized = (short)(0) ;
   }

   public boolean getgxTv_SdtPacienteFamiliar_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtPacienteFamiliar_Pacientefamiliarid_Z( )
   {
      return gxTv_SdtPacienteFamiliar_Pacientefamiliarid_Z ;
   }

   public void setgxTv_SdtPacienteFamiliar_Pacientefamiliarid_Z( int value )
   {
      gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
      SetDirty("Pacientefamiliarid_Z");
      gxTv_SdtPacienteFamiliar_Pacientefamiliarid_Z = value ;
   }

   public void setgxTv_SdtPacienteFamiliar_Pacientefamiliarid_Z_SetNull( )
   {
      gxTv_SdtPacienteFamiliar_Pacientefamiliarid_Z = 0 ;
   }

   public boolean getgxTv_SdtPacienteFamiliar_Pacientefamiliarid_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtPacienteFamiliar_Pacienteid_Z( )
   {
      return gxTv_SdtPacienteFamiliar_Pacienteid_Z ;
   }

   public void setgxTv_SdtPacienteFamiliar_Pacienteid_Z( int value )
   {
      gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
      SetDirty("Pacienteid_Z");
      gxTv_SdtPacienteFamiliar_Pacienteid_Z = value ;
   }

   public void setgxTv_SdtPacienteFamiliar_Pacienteid_Z_SetNull( )
   {
      gxTv_SdtPacienteFamiliar_Pacienteid_Z = 0 ;
   }

   public boolean getgxTv_SdtPacienteFamiliar_Pacienteid_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtPacienteFamiliar_Sgpacientehijopacienteid_Z( )
   {
      return gxTv_SdtPacienteFamiliar_Sgpacientehijopacienteid_Z ;
   }

   public void setgxTv_SdtPacienteFamiliar_Sgpacientehijopacienteid_Z( int value )
   {
      gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
      SetDirty("Sgpacientehijopacienteid_Z");
      gxTv_SdtPacienteFamiliar_Sgpacientehijopacienteid_Z = value ;
   }

   public void setgxTv_SdtPacienteFamiliar_Sgpacientehijopacienteid_Z_SetNull( )
   {
      gxTv_SdtPacienteFamiliar_Sgpacientehijopacienteid_Z = 0 ;
   }

   public boolean getgxTv_SdtPacienteFamiliar_Sgpacientehijopacienteid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPacienteFamiliar_Sgpacientehijonombres_Z( )
   {
      return gxTv_SdtPacienteFamiliar_Sgpacientehijonombres_Z ;
   }

   public void setgxTv_SdtPacienteFamiliar_Sgpacientehijonombres_Z( String value )
   {
      gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
      SetDirty("Sgpacientehijonombres_Z");
      gxTv_SdtPacienteFamiliar_Sgpacientehijonombres_Z = value ;
   }

   public void setgxTv_SdtPacienteFamiliar_Sgpacientehijonombres_Z_SetNull( )
   {
      gxTv_SdtPacienteFamiliar_Sgpacientehijonombres_Z = "" ;
   }

   public boolean getgxTv_SdtPacienteFamiliar_Sgpacientehijonombres_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPacienteFamiliar_Sgpacientehijoapellidopaterno_Z( )
   {
      return gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidopaterno_Z ;
   }

   public void setgxTv_SdtPacienteFamiliar_Sgpacientehijoapellidopaterno_Z( String value )
   {
      gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
      SetDirty("Sgpacientehijoapellidopaterno_Z");
      gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidopaterno_Z = value ;
   }

   public void setgxTv_SdtPacienteFamiliar_Sgpacientehijoapellidopaterno_Z_SetNull( )
   {
      gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidopaterno_Z = "" ;
   }

   public boolean getgxTv_SdtPacienteFamiliar_Sgpacientehijoapellidopaterno_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPacienteFamiliar_Sgpacientehijoapellidomaterno_Z( )
   {
      return gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidomaterno_Z ;
   }

   public void setgxTv_SdtPacienteFamiliar_Sgpacientehijoapellidomaterno_Z( String value )
   {
      gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
      SetDirty("Sgpacientehijoapellidomaterno_Z");
      gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidomaterno_Z = value ;
   }

   public void setgxTv_SdtPacienteFamiliar_Sgpacientehijoapellidomaterno_Z_SetNull( )
   {
      gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidomaterno_Z = "" ;
   }

   public boolean getgxTv_SdtPacienteFamiliar_Sgpacientehijoapellidomaterno_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPacienteFamiliar_Pacientefamiliarparentesco_Z( )
   {
      return gxTv_SdtPacienteFamiliar_Pacientefamiliarparentesco_Z ;
   }

   public void setgxTv_SdtPacienteFamiliar_Pacientefamiliarparentesco_Z( String value )
   {
      gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
      SetDirty("Pacientefamiliarparentesco_Z");
      gxTv_SdtPacienteFamiliar_Pacientefamiliarparentesco_Z = value ;
   }

   public void setgxTv_SdtPacienteFamiliar_Pacientefamiliarparentesco_Z_SetNull( )
   {
      gxTv_SdtPacienteFamiliar_Pacientefamiliarparentesco_Z = "" ;
   }

   public boolean getgxTv_SdtPacienteFamiliar_Pacientefamiliarparentesco_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPacienteFamiliar_Pacientefamiliarestado_Z( )
   {
      return gxTv_SdtPacienteFamiliar_Pacientefamiliarestado_Z ;
   }

   public void setgxTv_SdtPacienteFamiliar_Pacientefamiliarestado_Z( String value )
   {
      gxTv_SdtPacienteFamiliar_N = (byte)(0) ;
      SetDirty("Pacientefamiliarestado_Z");
      gxTv_SdtPacienteFamiliar_Pacientefamiliarestado_Z = value ;
   }

   public void setgxTv_SdtPacienteFamiliar_Pacientefamiliarestado_Z_SetNull( )
   {
      gxTv_SdtPacienteFamiliar_Pacientefamiliarestado_Z = "" ;
   }

   public boolean getgxTv_SdtPacienteFamiliar_Pacientefamiliarestado_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.projectthani.pacientefamiliar_bc obj;
      obj = new com.projectthani.pacientefamiliar_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtPacienteFamiliar_N = (byte)(1) ;
      gxTv_SdtPacienteFamiliar_Sgpacientehijonombres = "" ;
      gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidopaterno = "" ;
      gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidomaterno = "" ;
      gxTv_SdtPacienteFamiliar_Pacientefamiliarparentesco = "" ;
      gxTv_SdtPacienteFamiliar_Pacientefamiliarestado = "" ;
      gxTv_SdtPacienteFamiliar_Mode = "" ;
      gxTv_SdtPacienteFamiliar_Sgpacientehijonombres_Z = "" ;
      gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidopaterno_Z = "" ;
      gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidomaterno_Z = "" ;
      gxTv_SdtPacienteFamiliar_Pacientefamiliarparentesco_Z = "" ;
      gxTv_SdtPacienteFamiliar_Pacientefamiliarestado_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtPacienteFamiliar_N ;
   }

   public com.projectthani.SdtPacienteFamiliar Clone( )
   {
      com.projectthani.SdtPacienteFamiliar sdt;
      com.projectthani.pacientefamiliar_bc obj;
      sdt = (com.projectthani.SdtPacienteFamiliar)(clone()) ;
      obj = (com.projectthani.pacientefamiliar_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.projectthani.StructSdtPacienteFamiliar struct )
   {
      setgxTv_SdtPacienteFamiliar_Pacientefamiliarid(struct.getPacientefamiliarid());
      setgxTv_SdtPacienteFamiliar_Pacienteid(struct.getPacienteid());
      setgxTv_SdtPacienteFamiliar_Sgpacientehijopacienteid(struct.getSgpacientehijopacienteid());
      setgxTv_SdtPacienteFamiliar_Sgpacientehijonombres(struct.getSgpacientehijonombres());
      setgxTv_SdtPacienteFamiliar_Sgpacientehijoapellidopaterno(struct.getSgpacientehijoapellidopaterno());
      setgxTv_SdtPacienteFamiliar_Sgpacientehijoapellidomaterno(struct.getSgpacientehijoapellidomaterno());
      setgxTv_SdtPacienteFamiliar_Pacientefamiliarparentesco(struct.getPacientefamiliarparentesco());
      setgxTv_SdtPacienteFamiliar_Pacientefamiliarestado(struct.getPacientefamiliarestado());
      setgxTv_SdtPacienteFamiliar_Mode(struct.getMode());
      setgxTv_SdtPacienteFamiliar_Initialized(struct.getInitialized());
      setgxTv_SdtPacienteFamiliar_Pacientefamiliarid_Z(struct.getPacientefamiliarid_Z());
      setgxTv_SdtPacienteFamiliar_Pacienteid_Z(struct.getPacienteid_Z());
      setgxTv_SdtPacienteFamiliar_Sgpacientehijopacienteid_Z(struct.getSgpacientehijopacienteid_Z());
      setgxTv_SdtPacienteFamiliar_Sgpacientehijonombres_Z(struct.getSgpacientehijonombres_Z());
      setgxTv_SdtPacienteFamiliar_Sgpacientehijoapellidopaterno_Z(struct.getSgpacientehijoapellidopaterno_Z());
      setgxTv_SdtPacienteFamiliar_Sgpacientehijoapellidomaterno_Z(struct.getSgpacientehijoapellidomaterno_Z());
      setgxTv_SdtPacienteFamiliar_Pacientefamiliarparentesco_Z(struct.getPacientefamiliarparentesco_Z());
      setgxTv_SdtPacienteFamiliar_Pacientefamiliarestado_Z(struct.getPacientefamiliarestado_Z());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtPacienteFamiliar getStruct( )
   {
      com.projectthani.StructSdtPacienteFamiliar struct = new com.projectthani.StructSdtPacienteFamiliar ();
      struct.setPacientefamiliarid(getgxTv_SdtPacienteFamiliar_Pacientefamiliarid());
      struct.setPacienteid(getgxTv_SdtPacienteFamiliar_Pacienteid());
      struct.setSgpacientehijopacienteid(getgxTv_SdtPacienteFamiliar_Sgpacientehijopacienteid());
      struct.setSgpacientehijonombres(getgxTv_SdtPacienteFamiliar_Sgpacientehijonombres());
      struct.setSgpacientehijoapellidopaterno(getgxTv_SdtPacienteFamiliar_Sgpacientehijoapellidopaterno());
      struct.setSgpacientehijoapellidomaterno(getgxTv_SdtPacienteFamiliar_Sgpacientehijoapellidomaterno());
      struct.setPacientefamiliarparentesco(getgxTv_SdtPacienteFamiliar_Pacientefamiliarparentesco());
      struct.setPacientefamiliarestado(getgxTv_SdtPacienteFamiliar_Pacientefamiliarestado());
      struct.setMode(getgxTv_SdtPacienteFamiliar_Mode());
      struct.setInitialized(getgxTv_SdtPacienteFamiliar_Initialized());
      struct.setPacientefamiliarid_Z(getgxTv_SdtPacienteFamiliar_Pacientefamiliarid_Z());
      struct.setPacienteid_Z(getgxTv_SdtPacienteFamiliar_Pacienteid_Z());
      struct.setSgpacientehijopacienteid_Z(getgxTv_SdtPacienteFamiliar_Sgpacientehijopacienteid_Z());
      struct.setSgpacientehijonombres_Z(getgxTv_SdtPacienteFamiliar_Sgpacientehijonombres_Z());
      struct.setSgpacientehijoapellidopaterno_Z(getgxTv_SdtPacienteFamiliar_Sgpacientehijoapellidopaterno_Z());
      struct.setSgpacientehijoapellidomaterno_Z(getgxTv_SdtPacienteFamiliar_Sgpacientehijoapellidomaterno_Z());
      struct.setPacientefamiliarparentesco_Z(getgxTv_SdtPacienteFamiliar_Pacientefamiliarparentesco_Z());
      struct.setPacientefamiliarestado_Z(getgxTv_SdtPacienteFamiliar_Pacientefamiliarestado_Z());
      return struct ;
   }

   private byte gxTv_SdtPacienteFamiliar_N ;
   private short gxTv_SdtPacienteFamiliar_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtPacienteFamiliar_Pacientefamiliarid ;
   private int gxTv_SdtPacienteFamiliar_Pacienteid ;
   private int gxTv_SdtPacienteFamiliar_Sgpacientehijopacienteid ;
   private int gxTv_SdtPacienteFamiliar_Pacientefamiliarid_Z ;
   private int gxTv_SdtPacienteFamiliar_Pacienteid_Z ;
   private int gxTv_SdtPacienteFamiliar_Sgpacientehijopacienteid_Z ;
   private String gxTv_SdtPacienteFamiliar_Pacientefamiliarparentesco ;
   private String gxTv_SdtPacienteFamiliar_Pacientefamiliarestado ;
   private String gxTv_SdtPacienteFamiliar_Mode ;
   private String gxTv_SdtPacienteFamiliar_Pacientefamiliarparentesco_Z ;
   private String gxTv_SdtPacienteFamiliar_Pacientefamiliarestado_Z ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtPacienteFamiliar_Sgpacientehijonombres ;
   private String gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidopaterno ;
   private String gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidomaterno ;
   private String gxTv_SdtPacienteFamiliar_Sgpacientehijonombres_Z ;
   private String gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidopaterno_Z ;
   private String gxTv_SdtPacienteFamiliar_Sgpacientehijoapellidomaterno_Z ;
}

