package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtRecetaMedica extends GxSilentTrnSdt implements Cloneable, java.io.Serializable
{
   public SdtRecetaMedica( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtRecetaMedica.class));
   }

   public SdtRecetaMedica( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle, context, "SdtRecetaMedica");
      initialize( remoteHandle) ;
   }

   public SdtRecetaMedica( int remoteHandle ,
                           StructSdtRecetaMedica struct )
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

   public void Load( short AV50RecetaMedicaId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Short.valueOf(AV50RecetaMedicaId)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"RecetaMedicaId", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "RecetaMedica");
      metadata.set("BT", "RecetaMedica");
      metadata.set("PK", "[ \"RecetaMedicaId\" ]");
      metadata.set("PKAssigned", "[ \"RecetaMedicaId\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CitaId\" ],\"FKMap\":[  ] },{ \"FK\":[ \"MedicamentoId\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "RecetaMedicaId") )
            {
               gxTv_SdtRecetaMedica_Recetamedicaid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaId") )
            {
               gxTv_SdtRecetaMedica_Citaid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MedicamentoId") )
            {
               gxTv_SdtRecetaMedica_Medicamentoid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MedicamentoCodigo") )
            {
               gxTv_SdtRecetaMedica_Medicamentocodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MedicamentoNombre") )
            {
               gxTv_SdtRecetaMedica_Medicamentonombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MedicamentoFormaFarm") )
            {
               gxTv_SdtRecetaMedica_Medicamentoformafarm = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RecetaMedicaConcentracion") )
            {
               gxTv_SdtRecetaMedica_Recetamedicaconcentracion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RecetaMedicaCantidad") )
            {
               gxTv_SdtRecetaMedica_Recetamedicacantidad = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RecetaMedicaAtencion") )
            {
               gxTv_SdtRecetaMedica_Recetamedicaatencion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RecetaMedicaArchivo") )
            {
               gxTv_SdtRecetaMedica_Recetamedicaarchivo=GXutil.blobFromBase64( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RecetaMedicaNombreArchivo") )
            {
               gxTv_SdtRecetaMedica_Recetamedicanombrearchivo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RecetaMedicaFlag") )
            {
               gxTv_SdtRecetaMedica_Recetamedicaflag = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RecetaIndicaciones") )
            {
               gxTv_SdtRecetaMedica_Recetaindicaciones = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RecetaArchivoTipo") )
            {
               gxTv_SdtRecetaMedica_Recetaarchivotipo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtRecetaMedica_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtRecetaMedica_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RecetaMedicaId_Z") )
            {
               gxTv_SdtRecetaMedica_Recetamedicaid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaId_Z") )
            {
               gxTv_SdtRecetaMedica_Citaid_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MedicamentoId_Z") )
            {
               gxTv_SdtRecetaMedica_Medicamentoid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MedicamentoCodigo_Z") )
            {
               gxTv_SdtRecetaMedica_Medicamentocodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MedicamentoNombre_Z") )
            {
               gxTv_SdtRecetaMedica_Medicamentonombre_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MedicamentoFormaFarm_Z") )
            {
               gxTv_SdtRecetaMedica_Medicamentoformafarm_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RecetaMedicaConcentracion_Z") )
            {
               gxTv_SdtRecetaMedica_Recetamedicaconcentracion_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RecetaMedicaCantidad_Z") )
            {
               gxTv_SdtRecetaMedica_Recetamedicacantidad_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RecetaMedicaAtencion_Z") )
            {
               gxTv_SdtRecetaMedica_Recetamedicaatencion_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RecetaMedicaNombreArchivo_Z") )
            {
               gxTv_SdtRecetaMedica_Recetamedicanombrearchivo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RecetaMedicaFlag_Z") )
            {
               gxTv_SdtRecetaMedica_Recetamedicaflag_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RecetaIndicaciones_Z") )
            {
               gxTv_SdtRecetaMedica_Recetaindicaciones_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RecetaArchivoTipo_Z") )
            {
               gxTv_SdtRecetaMedica_Recetaarchivotipo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MedicamentoId_N") )
            {
               gxTv_SdtRecetaMedica_Medicamentoid_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MedicamentoFormaFarm_N") )
            {
               gxTv_SdtRecetaMedica_Medicamentoformafarm_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RecetaMedicaConcentracion_N") )
            {
               gxTv_SdtRecetaMedica_Recetamedicaconcentracion_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RecetaMedicaCantidad_N") )
            {
               gxTv_SdtRecetaMedica_Recetamedicacantidad_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RecetaMedicaAtencion_N") )
            {
               gxTv_SdtRecetaMedica_Recetamedicaatencion_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RecetaMedicaArchivo_N") )
            {
               gxTv_SdtRecetaMedica_Recetamedicaarchivo_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RecetaMedicaNombreArchivo_N") )
            {
               gxTv_SdtRecetaMedica_Recetamedicanombrearchivo_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RecetaMedicaFlag_N") )
            {
               gxTv_SdtRecetaMedica_Recetamedicaflag_N = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "RecetaMedica" ;
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
      oWriter.writeElement("RecetaMedicaId", GXutil.trim( GXutil.str( gxTv_SdtRecetaMedica_Recetamedicaid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaId", GXutil.trim( GXutil.str( gxTv_SdtRecetaMedica_Citaid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("MedicamentoId", GXutil.trim( GXutil.str( gxTv_SdtRecetaMedica_Medicamentoid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("MedicamentoCodigo", GXutil.rtrim( gxTv_SdtRecetaMedica_Medicamentocodigo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("MedicamentoNombre", GXutil.rtrim( gxTv_SdtRecetaMedica_Medicamentonombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("MedicamentoFormaFarm", GXutil.rtrim( gxTv_SdtRecetaMedica_Medicamentoformafarm));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("RecetaMedicaConcentracion", GXutil.rtrim( gxTv_SdtRecetaMedica_Recetamedicaconcentracion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("RecetaMedicaCantidad", GXutil.trim( GXutil.str( gxTv_SdtRecetaMedica_Recetamedicacantidad, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("RecetaMedicaAtencion", GXutil.rtrim( gxTv_SdtRecetaMedica_Recetamedicaatencion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("RecetaMedicaArchivo", GXutil.blobToBase64( gxTv_SdtRecetaMedica_Recetamedicaarchivo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("RecetaMedicaNombreArchivo", GXutil.rtrim( gxTv_SdtRecetaMedica_Recetamedicanombrearchivo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("RecetaMedicaFlag", GXutil.trim( GXutil.str( gxTv_SdtRecetaMedica_Recetamedicaflag, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("RecetaIndicaciones", GXutil.rtrim( gxTv_SdtRecetaMedica_Recetaindicaciones));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("RecetaArchivoTipo", GXutil.rtrim( gxTv_SdtRecetaMedica_Recetaarchivotipo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", GXutil.rtrim( gxTv_SdtRecetaMedica_Mode));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtRecetaMedica_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("RecetaMedicaId_Z", GXutil.trim( GXutil.str( gxTv_SdtRecetaMedica_Recetamedicaid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("CitaId_Z", GXutil.trim( GXutil.str( gxTv_SdtRecetaMedica_Citaid_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("MedicamentoId_Z", GXutil.trim( GXutil.str( gxTv_SdtRecetaMedica_Medicamentoid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("MedicamentoCodigo_Z", GXutil.rtrim( gxTv_SdtRecetaMedica_Medicamentocodigo_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("MedicamentoNombre_Z", GXutil.rtrim( gxTv_SdtRecetaMedica_Medicamentonombre_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("MedicamentoFormaFarm_Z", GXutil.rtrim( gxTv_SdtRecetaMedica_Medicamentoformafarm_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("RecetaMedicaConcentracion_Z", GXutil.rtrim( gxTv_SdtRecetaMedica_Recetamedicaconcentracion_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("RecetaMedicaCantidad_Z", GXutil.trim( GXutil.str( gxTv_SdtRecetaMedica_Recetamedicacantidad_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("RecetaMedicaAtencion_Z", GXutil.rtrim( gxTv_SdtRecetaMedica_Recetamedicaatencion_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("RecetaMedicaNombreArchivo_Z", GXutil.rtrim( gxTv_SdtRecetaMedica_Recetamedicanombrearchivo_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("RecetaMedicaFlag_Z", GXutil.trim( GXutil.str( gxTv_SdtRecetaMedica_Recetamedicaflag_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("RecetaIndicaciones_Z", GXutil.rtrim( gxTv_SdtRecetaMedica_Recetaindicaciones_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("RecetaArchivoTipo_Z", GXutil.rtrim( gxTv_SdtRecetaMedica_Recetaarchivotipo_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("MedicamentoId_N", GXutil.trim( GXutil.str( gxTv_SdtRecetaMedica_Medicamentoid_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("MedicamentoFormaFarm_N", GXutil.trim( GXutil.str( gxTv_SdtRecetaMedica_Medicamentoformafarm_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("RecetaMedicaConcentracion_N", GXutil.trim( GXutil.str( gxTv_SdtRecetaMedica_Recetamedicaconcentracion_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("RecetaMedicaCantidad_N", GXutil.trim( GXutil.str( gxTv_SdtRecetaMedica_Recetamedicacantidad_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("RecetaMedicaAtencion_N", GXutil.trim( GXutil.str( gxTv_SdtRecetaMedica_Recetamedicaatencion_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("RecetaMedicaArchivo_N", GXutil.trim( GXutil.str( gxTv_SdtRecetaMedica_Recetamedicaarchivo_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("RecetaMedicaNombreArchivo_N", GXutil.trim( GXutil.str( gxTv_SdtRecetaMedica_Recetamedicanombrearchivo_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("RecetaMedicaFlag_N", GXutil.trim( GXutil.str( gxTv_SdtRecetaMedica_Recetamedicaflag_N, 1, 0)));
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
      AddObjectProperty("RecetaMedicaId", gxTv_SdtRecetaMedica_Recetamedicaid, false, includeNonInitialized);
      AddObjectProperty("CitaId", gxTv_SdtRecetaMedica_Citaid, false, includeNonInitialized);
      AddObjectProperty("MedicamentoId", gxTv_SdtRecetaMedica_Medicamentoid, false, includeNonInitialized);
      AddObjectProperty("MedicamentoId_N", gxTv_SdtRecetaMedica_Medicamentoid_N, false, includeNonInitialized);
      AddObjectProperty("MedicamentoCodigo", gxTv_SdtRecetaMedica_Medicamentocodigo, false, includeNonInitialized);
      AddObjectProperty("MedicamentoNombre", gxTv_SdtRecetaMedica_Medicamentonombre, false, includeNonInitialized);
      AddObjectProperty("MedicamentoFormaFarm", gxTv_SdtRecetaMedica_Medicamentoformafarm, false, includeNonInitialized);
      AddObjectProperty("MedicamentoFormaFarm_N", gxTv_SdtRecetaMedica_Medicamentoformafarm_N, false, includeNonInitialized);
      AddObjectProperty("RecetaMedicaConcentracion", gxTv_SdtRecetaMedica_Recetamedicaconcentracion, false, includeNonInitialized);
      AddObjectProperty("RecetaMedicaConcentracion_N", gxTv_SdtRecetaMedica_Recetamedicaconcentracion_N, false, includeNonInitialized);
      AddObjectProperty("RecetaMedicaCantidad", gxTv_SdtRecetaMedica_Recetamedicacantidad, false, includeNonInitialized);
      AddObjectProperty("RecetaMedicaCantidad_N", gxTv_SdtRecetaMedica_Recetamedicacantidad_N, false, includeNonInitialized);
      AddObjectProperty("RecetaMedicaAtencion", gxTv_SdtRecetaMedica_Recetamedicaatencion, false, includeNonInitialized);
      AddObjectProperty("RecetaMedicaAtencion_N", gxTv_SdtRecetaMedica_Recetamedicaatencion_N, false, includeNonInitialized);
      AddObjectProperty("RecetaMedicaArchivo", gxTv_SdtRecetaMedica_Recetamedicaarchivo, false, includeNonInitialized);
      AddObjectProperty("RecetaMedicaArchivo_N", gxTv_SdtRecetaMedica_Recetamedicaarchivo_N, false, includeNonInitialized);
      AddObjectProperty("RecetaMedicaNombreArchivo", gxTv_SdtRecetaMedica_Recetamedicanombrearchivo, false, includeNonInitialized);
      AddObjectProperty("RecetaMedicaNombreArchivo_N", gxTv_SdtRecetaMedica_Recetamedicanombrearchivo_N, false, includeNonInitialized);
      AddObjectProperty("RecetaMedicaFlag", gxTv_SdtRecetaMedica_Recetamedicaflag, false, includeNonInitialized);
      AddObjectProperty("RecetaMedicaFlag_N", gxTv_SdtRecetaMedica_Recetamedicaflag_N, false, includeNonInitialized);
      AddObjectProperty("RecetaIndicaciones", gxTv_SdtRecetaMedica_Recetaindicaciones, false, includeNonInitialized);
      AddObjectProperty("RecetaArchivoTipo", gxTv_SdtRecetaMedica_Recetaarchivotipo, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtRecetaMedica_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtRecetaMedica_Initialized, false, includeNonInitialized);
         AddObjectProperty("RecetaMedicaId_Z", gxTv_SdtRecetaMedica_Recetamedicaid_Z, false, includeNonInitialized);
         AddObjectProperty("CitaId_Z", gxTv_SdtRecetaMedica_Citaid_Z, false, includeNonInitialized);
         AddObjectProperty("MedicamentoId_Z", gxTv_SdtRecetaMedica_Medicamentoid_Z, false, includeNonInitialized);
         AddObjectProperty("MedicamentoCodigo_Z", gxTv_SdtRecetaMedica_Medicamentocodigo_Z, false, includeNonInitialized);
         AddObjectProperty("MedicamentoNombre_Z", gxTv_SdtRecetaMedica_Medicamentonombre_Z, false, includeNonInitialized);
         AddObjectProperty("MedicamentoFormaFarm_Z", gxTv_SdtRecetaMedica_Medicamentoformafarm_Z, false, includeNonInitialized);
         AddObjectProperty("RecetaMedicaConcentracion_Z", gxTv_SdtRecetaMedica_Recetamedicaconcentracion_Z, false, includeNonInitialized);
         AddObjectProperty("RecetaMedicaCantidad_Z", gxTv_SdtRecetaMedica_Recetamedicacantidad_Z, false, includeNonInitialized);
         AddObjectProperty("RecetaMedicaAtencion_Z", gxTv_SdtRecetaMedica_Recetamedicaatencion_Z, false, includeNonInitialized);
         AddObjectProperty("RecetaMedicaNombreArchivo_Z", gxTv_SdtRecetaMedica_Recetamedicanombrearchivo_Z, false, includeNonInitialized);
         AddObjectProperty("RecetaMedicaFlag_Z", gxTv_SdtRecetaMedica_Recetamedicaflag_Z, false, includeNonInitialized);
         AddObjectProperty("RecetaIndicaciones_Z", gxTv_SdtRecetaMedica_Recetaindicaciones_Z, false, includeNonInitialized);
         AddObjectProperty("RecetaArchivoTipo_Z", gxTv_SdtRecetaMedica_Recetaarchivotipo_Z, false, includeNonInitialized);
         AddObjectProperty("MedicamentoId_N", gxTv_SdtRecetaMedica_Medicamentoid_N, false, includeNonInitialized);
         AddObjectProperty("MedicamentoFormaFarm_N", gxTv_SdtRecetaMedica_Medicamentoformafarm_N, false, includeNonInitialized);
         AddObjectProperty("RecetaMedicaConcentracion_N", gxTv_SdtRecetaMedica_Recetamedicaconcentracion_N, false, includeNonInitialized);
         AddObjectProperty("RecetaMedicaCantidad_N", gxTv_SdtRecetaMedica_Recetamedicacantidad_N, false, includeNonInitialized);
         AddObjectProperty("RecetaMedicaAtencion_N", gxTv_SdtRecetaMedica_Recetamedicaatencion_N, false, includeNonInitialized);
         AddObjectProperty("RecetaMedicaArchivo_N", gxTv_SdtRecetaMedica_Recetamedicaarchivo_N, false, includeNonInitialized);
         AddObjectProperty("RecetaMedicaNombreArchivo_N", gxTv_SdtRecetaMedica_Recetamedicanombrearchivo_N, false, includeNonInitialized);
         AddObjectProperty("RecetaMedicaFlag_N", gxTv_SdtRecetaMedica_Recetamedicaflag_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.projectthani.SdtRecetaMedica sdt )
   {
      if ( sdt.IsDirty("RecetaMedicaId") )
      {
         gxTv_SdtRecetaMedica_N = (byte)(0) ;
         gxTv_SdtRecetaMedica_Recetamedicaid = sdt.getgxTv_SdtRecetaMedica_Recetamedicaid() ;
      }
      if ( sdt.IsDirty("CitaId") )
      {
         gxTv_SdtRecetaMedica_N = (byte)(0) ;
         gxTv_SdtRecetaMedica_Citaid = sdt.getgxTv_SdtRecetaMedica_Citaid() ;
      }
      if ( sdt.IsDirty("MedicamentoId") )
      {
         gxTv_SdtRecetaMedica_Medicamentoid_N = (byte)(0) ;
         gxTv_SdtRecetaMedica_N = (byte)(0) ;
         gxTv_SdtRecetaMedica_Medicamentoid = sdt.getgxTv_SdtRecetaMedica_Medicamentoid() ;
      }
      if ( sdt.IsDirty("MedicamentoCodigo") )
      {
         gxTv_SdtRecetaMedica_N = (byte)(0) ;
         gxTv_SdtRecetaMedica_Medicamentocodigo = sdt.getgxTv_SdtRecetaMedica_Medicamentocodigo() ;
      }
      if ( sdt.IsDirty("MedicamentoNombre") )
      {
         gxTv_SdtRecetaMedica_N = (byte)(0) ;
         gxTv_SdtRecetaMedica_Medicamentonombre = sdt.getgxTv_SdtRecetaMedica_Medicamentonombre() ;
      }
      if ( sdt.IsDirty("MedicamentoFormaFarm") )
      {
         gxTv_SdtRecetaMedica_Medicamentoformafarm_N = (byte)(0) ;
         gxTv_SdtRecetaMedica_N = (byte)(0) ;
         gxTv_SdtRecetaMedica_Medicamentoformafarm = sdt.getgxTv_SdtRecetaMedica_Medicamentoformafarm() ;
      }
      if ( sdt.IsDirty("RecetaMedicaConcentracion") )
      {
         gxTv_SdtRecetaMedica_Recetamedicaconcentracion_N = (byte)(0) ;
         gxTv_SdtRecetaMedica_N = (byte)(0) ;
         gxTv_SdtRecetaMedica_Recetamedicaconcentracion = sdt.getgxTv_SdtRecetaMedica_Recetamedicaconcentracion() ;
      }
      if ( sdt.IsDirty("RecetaMedicaCantidad") )
      {
         gxTv_SdtRecetaMedica_Recetamedicacantidad_N = (byte)(0) ;
         gxTv_SdtRecetaMedica_N = (byte)(0) ;
         gxTv_SdtRecetaMedica_Recetamedicacantidad = sdt.getgxTv_SdtRecetaMedica_Recetamedicacantidad() ;
      }
      if ( sdt.IsDirty("RecetaMedicaAtencion") )
      {
         gxTv_SdtRecetaMedica_Recetamedicaatencion_N = (byte)(0) ;
         gxTv_SdtRecetaMedica_N = (byte)(0) ;
         gxTv_SdtRecetaMedica_Recetamedicaatencion = sdt.getgxTv_SdtRecetaMedica_Recetamedicaatencion() ;
      }
      if ( sdt.IsDirty("RecetaMedicaArchivo") )
      {
         gxTv_SdtRecetaMedica_Recetamedicaarchivo_N = (byte)(0) ;
         gxTv_SdtRecetaMedica_N = (byte)(0) ;
         gxTv_SdtRecetaMedica_Recetamedicaarchivo = sdt.getgxTv_SdtRecetaMedica_Recetamedicaarchivo() ;
      }
      if ( sdt.IsDirty("RecetaMedicaNombreArchivo") )
      {
         gxTv_SdtRecetaMedica_Recetamedicanombrearchivo_N = (byte)(0) ;
         gxTv_SdtRecetaMedica_N = (byte)(0) ;
         gxTv_SdtRecetaMedica_Recetamedicanombrearchivo = sdt.getgxTv_SdtRecetaMedica_Recetamedicanombrearchivo() ;
      }
      if ( sdt.IsDirty("RecetaMedicaFlag") )
      {
         gxTv_SdtRecetaMedica_Recetamedicaflag_N = (byte)(0) ;
         gxTv_SdtRecetaMedica_N = (byte)(0) ;
         gxTv_SdtRecetaMedica_Recetamedicaflag = sdt.getgxTv_SdtRecetaMedica_Recetamedicaflag() ;
      }
      if ( sdt.IsDirty("RecetaIndicaciones") )
      {
         gxTv_SdtRecetaMedica_N = (byte)(0) ;
         gxTv_SdtRecetaMedica_Recetaindicaciones = sdt.getgxTv_SdtRecetaMedica_Recetaindicaciones() ;
      }
      if ( sdt.IsDirty("RecetaArchivoTipo") )
      {
         gxTv_SdtRecetaMedica_N = (byte)(0) ;
         gxTv_SdtRecetaMedica_Recetaarchivotipo = sdt.getgxTv_SdtRecetaMedica_Recetaarchivotipo() ;
      }
   }

   public short getgxTv_SdtRecetaMedica_Recetamedicaid( )
   {
      return gxTv_SdtRecetaMedica_Recetamedicaid ;
   }

   public void setgxTv_SdtRecetaMedica_Recetamedicaid( short value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      if ( gxTv_SdtRecetaMedica_Recetamedicaid != value )
      {
         gxTv_SdtRecetaMedica_Mode = "INS" ;
         this.setgxTv_SdtRecetaMedica_Recetamedicaid_Z_SetNull( );
         this.setgxTv_SdtRecetaMedica_Citaid_Z_SetNull( );
         this.setgxTv_SdtRecetaMedica_Medicamentoid_Z_SetNull( );
         this.setgxTv_SdtRecetaMedica_Medicamentocodigo_Z_SetNull( );
         this.setgxTv_SdtRecetaMedica_Medicamentonombre_Z_SetNull( );
         this.setgxTv_SdtRecetaMedica_Medicamentoformafarm_Z_SetNull( );
         this.setgxTv_SdtRecetaMedica_Recetamedicaconcentracion_Z_SetNull( );
         this.setgxTv_SdtRecetaMedica_Recetamedicacantidad_Z_SetNull( );
         this.setgxTv_SdtRecetaMedica_Recetamedicaatencion_Z_SetNull( );
         this.setgxTv_SdtRecetaMedica_Recetamedicanombrearchivo_Z_SetNull( );
         this.setgxTv_SdtRecetaMedica_Recetamedicaflag_Z_SetNull( );
         this.setgxTv_SdtRecetaMedica_Recetaindicaciones_Z_SetNull( );
         this.setgxTv_SdtRecetaMedica_Recetaarchivotipo_Z_SetNull( );
      }
      SetDirty("Recetamedicaid");
      gxTv_SdtRecetaMedica_Recetamedicaid = value ;
   }

   public int getgxTv_SdtRecetaMedica_Citaid( )
   {
      return gxTv_SdtRecetaMedica_Citaid ;
   }

   public void setgxTv_SdtRecetaMedica_Citaid( int value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      SetDirty("Citaid");
      gxTv_SdtRecetaMedica_Citaid = value ;
   }

   public short getgxTv_SdtRecetaMedica_Medicamentoid( )
   {
      return gxTv_SdtRecetaMedica_Medicamentoid ;
   }

   public void setgxTv_SdtRecetaMedica_Medicamentoid( short value )
   {
      gxTv_SdtRecetaMedica_Medicamentoid_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      SetDirty("Medicamentoid");
      gxTv_SdtRecetaMedica_Medicamentoid = value ;
   }

   public void setgxTv_SdtRecetaMedica_Medicamentoid_SetNull( )
   {
      gxTv_SdtRecetaMedica_Medicamentoid_N = (byte)(1) ;
      gxTv_SdtRecetaMedica_Medicamentoid = (short)(0) ;
   }

   public boolean getgxTv_SdtRecetaMedica_Medicamentoid_IsNull( )
   {
      return (gxTv_SdtRecetaMedica_Medicamentoid_N==1) ;
   }

   public String getgxTv_SdtRecetaMedica_Medicamentocodigo( )
   {
      return gxTv_SdtRecetaMedica_Medicamentocodigo ;
   }

   public void setgxTv_SdtRecetaMedica_Medicamentocodigo( String value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      SetDirty("Medicamentocodigo");
      gxTv_SdtRecetaMedica_Medicamentocodigo = value ;
   }

   public String getgxTv_SdtRecetaMedica_Medicamentonombre( )
   {
      return gxTv_SdtRecetaMedica_Medicamentonombre ;
   }

   public void setgxTv_SdtRecetaMedica_Medicamentonombre( String value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      SetDirty("Medicamentonombre");
      gxTv_SdtRecetaMedica_Medicamentonombre = value ;
   }

   public String getgxTv_SdtRecetaMedica_Medicamentoformafarm( )
   {
      return gxTv_SdtRecetaMedica_Medicamentoformafarm ;
   }

   public void setgxTv_SdtRecetaMedica_Medicamentoformafarm( String value )
   {
      gxTv_SdtRecetaMedica_Medicamentoformafarm_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      SetDirty("Medicamentoformafarm");
      gxTv_SdtRecetaMedica_Medicamentoformafarm = value ;
   }

   public void setgxTv_SdtRecetaMedica_Medicamentoformafarm_SetNull( )
   {
      gxTv_SdtRecetaMedica_Medicamentoformafarm_N = (byte)(1) ;
      gxTv_SdtRecetaMedica_Medicamentoformafarm = "" ;
   }

   public boolean getgxTv_SdtRecetaMedica_Medicamentoformafarm_IsNull( )
   {
      return (gxTv_SdtRecetaMedica_Medicamentoformafarm_N==1) ;
   }

   public String getgxTv_SdtRecetaMedica_Recetamedicaconcentracion( )
   {
      return gxTv_SdtRecetaMedica_Recetamedicaconcentracion ;
   }

   public void setgxTv_SdtRecetaMedica_Recetamedicaconcentracion( String value )
   {
      gxTv_SdtRecetaMedica_Recetamedicaconcentracion_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      SetDirty("Recetamedicaconcentracion");
      gxTv_SdtRecetaMedica_Recetamedicaconcentracion = value ;
   }

   public void setgxTv_SdtRecetaMedica_Recetamedicaconcentracion_SetNull( )
   {
      gxTv_SdtRecetaMedica_Recetamedicaconcentracion_N = (byte)(1) ;
      gxTv_SdtRecetaMedica_Recetamedicaconcentracion = "" ;
   }

   public boolean getgxTv_SdtRecetaMedica_Recetamedicaconcentracion_IsNull( )
   {
      return (gxTv_SdtRecetaMedica_Recetamedicaconcentracion_N==1) ;
   }

   public short getgxTv_SdtRecetaMedica_Recetamedicacantidad( )
   {
      return gxTv_SdtRecetaMedica_Recetamedicacantidad ;
   }

   public void setgxTv_SdtRecetaMedica_Recetamedicacantidad( short value )
   {
      gxTv_SdtRecetaMedica_Recetamedicacantidad_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      SetDirty("Recetamedicacantidad");
      gxTv_SdtRecetaMedica_Recetamedicacantidad = value ;
   }

   public void setgxTv_SdtRecetaMedica_Recetamedicacantidad_SetNull( )
   {
      gxTv_SdtRecetaMedica_Recetamedicacantidad_N = (byte)(1) ;
      gxTv_SdtRecetaMedica_Recetamedicacantidad = (short)(0) ;
   }

   public boolean getgxTv_SdtRecetaMedica_Recetamedicacantidad_IsNull( )
   {
      return (gxTv_SdtRecetaMedica_Recetamedicacantidad_N==1) ;
   }

   public String getgxTv_SdtRecetaMedica_Recetamedicaatencion( )
   {
      return gxTv_SdtRecetaMedica_Recetamedicaatencion ;
   }

   public void setgxTv_SdtRecetaMedica_Recetamedicaatencion( String value )
   {
      gxTv_SdtRecetaMedica_Recetamedicaatencion_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      SetDirty("Recetamedicaatencion");
      gxTv_SdtRecetaMedica_Recetamedicaatencion = value ;
   }

   public void setgxTv_SdtRecetaMedica_Recetamedicaatencion_SetNull( )
   {
      gxTv_SdtRecetaMedica_Recetamedicaatencion_N = (byte)(1) ;
      gxTv_SdtRecetaMedica_Recetamedicaatencion = "" ;
   }

   public boolean getgxTv_SdtRecetaMedica_Recetamedicaatencion_IsNull( )
   {
      return (gxTv_SdtRecetaMedica_Recetamedicaatencion_N==1) ;
   }

   @GxUpload
   public String getgxTv_SdtRecetaMedica_Recetamedicaarchivo( )
   {
      return gxTv_SdtRecetaMedica_Recetamedicaarchivo ;
   }

   public void setgxTv_SdtRecetaMedica_Recetamedicaarchivo( String value )
   {
      gxTv_SdtRecetaMedica_Recetamedicaarchivo_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      SetDirty("Recetamedicaarchivo");
      gxTv_SdtRecetaMedica_Recetamedicaarchivo = value ;
   }

   public void setgxTv_SdtRecetaMedica_Recetamedicaarchivo_SetBlob( String blob ,
                                                                    String fileName ,
                                                                    String fileType )
   {
      gxTv_SdtRecetaMedica_Recetamedicaarchivo = blob ;
      gxTv_SdtRecetaMedica_Recetamedicanombrearchivo = fileName ;
      gxTv_SdtRecetaMedica_Recetaarchivotipo = fileType ;
   }

   public void setgxTv_SdtRecetaMedica_Recetamedicaarchivo_SetNull( )
   {
      gxTv_SdtRecetaMedica_Recetamedicaarchivo_N = (byte)(1) ;
      gxTv_SdtRecetaMedica_Recetamedicaarchivo = "" ;
   }

   public boolean getgxTv_SdtRecetaMedica_Recetamedicaarchivo_IsNull( )
   {
      return (gxTv_SdtRecetaMedica_Recetamedicaarchivo_N==1) ;
   }

   public String getgxTv_SdtRecetaMedica_Recetamedicanombrearchivo( )
   {
      return gxTv_SdtRecetaMedica_Recetamedicanombrearchivo ;
   }

   public void setgxTv_SdtRecetaMedica_Recetamedicanombrearchivo( String value )
   {
      gxTv_SdtRecetaMedica_Recetamedicanombrearchivo_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      SetDirty("Recetamedicanombrearchivo");
      gxTv_SdtRecetaMedica_Recetamedicanombrearchivo = value ;
   }

   public void setgxTv_SdtRecetaMedica_Recetamedicanombrearchivo_SetNull( )
   {
      gxTv_SdtRecetaMedica_Recetamedicanombrearchivo_N = (byte)(1) ;
      gxTv_SdtRecetaMedica_Recetamedicanombrearchivo = "" ;
   }

   public boolean getgxTv_SdtRecetaMedica_Recetamedicanombrearchivo_IsNull( )
   {
      return (gxTv_SdtRecetaMedica_Recetamedicanombrearchivo_N==1) ;
   }

   public byte getgxTv_SdtRecetaMedica_Recetamedicaflag( )
   {
      return gxTv_SdtRecetaMedica_Recetamedicaflag ;
   }

   public void setgxTv_SdtRecetaMedica_Recetamedicaflag( byte value )
   {
      gxTv_SdtRecetaMedica_Recetamedicaflag_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      SetDirty("Recetamedicaflag");
      gxTv_SdtRecetaMedica_Recetamedicaflag = value ;
   }

   public void setgxTv_SdtRecetaMedica_Recetamedicaflag_SetNull( )
   {
      gxTv_SdtRecetaMedica_Recetamedicaflag_N = (byte)(1) ;
      gxTv_SdtRecetaMedica_Recetamedicaflag = (byte)(0) ;
   }

   public boolean getgxTv_SdtRecetaMedica_Recetamedicaflag_IsNull( )
   {
      return (gxTv_SdtRecetaMedica_Recetamedicaflag_N==1) ;
   }

   public String getgxTv_SdtRecetaMedica_Recetaindicaciones( )
   {
      return gxTv_SdtRecetaMedica_Recetaindicaciones ;
   }

   public void setgxTv_SdtRecetaMedica_Recetaindicaciones( String value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      SetDirty("Recetaindicaciones");
      gxTv_SdtRecetaMedica_Recetaindicaciones = value ;
   }

   public String getgxTv_SdtRecetaMedica_Recetaarchivotipo( )
   {
      return gxTv_SdtRecetaMedica_Recetaarchivotipo ;
   }

   public void setgxTv_SdtRecetaMedica_Recetaarchivotipo( String value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      SetDirty("Recetaarchivotipo");
      gxTv_SdtRecetaMedica_Recetaarchivotipo = value ;
   }

   public String getgxTv_SdtRecetaMedica_Mode( )
   {
      return gxTv_SdtRecetaMedica_Mode ;
   }

   public void setgxTv_SdtRecetaMedica_Mode( String value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtRecetaMedica_Mode = value ;
   }

   public void setgxTv_SdtRecetaMedica_Mode_SetNull( )
   {
      gxTv_SdtRecetaMedica_Mode = "" ;
   }

   public boolean getgxTv_SdtRecetaMedica_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtRecetaMedica_Initialized( )
   {
      return gxTv_SdtRecetaMedica_Initialized ;
   }

   public void setgxTv_SdtRecetaMedica_Initialized( short value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtRecetaMedica_Initialized = value ;
   }

   public void setgxTv_SdtRecetaMedica_Initialized_SetNull( )
   {
      gxTv_SdtRecetaMedica_Initialized = (short)(0) ;
   }

   public boolean getgxTv_SdtRecetaMedica_Initialized_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtRecetaMedica_Recetamedicaid_Z( )
   {
      return gxTv_SdtRecetaMedica_Recetamedicaid_Z ;
   }

   public void setgxTv_SdtRecetaMedica_Recetamedicaid_Z( short value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      SetDirty("Recetamedicaid_Z");
      gxTv_SdtRecetaMedica_Recetamedicaid_Z = value ;
   }

   public void setgxTv_SdtRecetaMedica_Recetamedicaid_Z_SetNull( )
   {
      gxTv_SdtRecetaMedica_Recetamedicaid_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtRecetaMedica_Recetamedicaid_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtRecetaMedica_Citaid_Z( )
   {
      return gxTv_SdtRecetaMedica_Citaid_Z ;
   }

   public void setgxTv_SdtRecetaMedica_Citaid_Z( int value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      SetDirty("Citaid_Z");
      gxTv_SdtRecetaMedica_Citaid_Z = value ;
   }

   public void setgxTv_SdtRecetaMedica_Citaid_Z_SetNull( )
   {
      gxTv_SdtRecetaMedica_Citaid_Z = 0 ;
   }

   public boolean getgxTv_SdtRecetaMedica_Citaid_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtRecetaMedica_Medicamentoid_Z( )
   {
      return gxTv_SdtRecetaMedica_Medicamentoid_Z ;
   }

   public void setgxTv_SdtRecetaMedica_Medicamentoid_Z( short value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      SetDirty("Medicamentoid_Z");
      gxTv_SdtRecetaMedica_Medicamentoid_Z = value ;
   }

   public void setgxTv_SdtRecetaMedica_Medicamentoid_Z_SetNull( )
   {
      gxTv_SdtRecetaMedica_Medicamentoid_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtRecetaMedica_Medicamentoid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtRecetaMedica_Medicamentocodigo_Z( )
   {
      return gxTv_SdtRecetaMedica_Medicamentocodigo_Z ;
   }

   public void setgxTv_SdtRecetaMedica_Medicamentocodigo_Z( String value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      SetDirty("Medicamentocodigo_Z");
      gxTv_SdtRecetaMedica_Medicamentocodigo_Z = value ;
   }

   public void setgxTv_SdtRecetaMedica_Medicamentocodigo_Z_SetNull( )
   {
      gxTv_SdtRecetaMedica_Medicamentocodigo_Z = "" ;
   }

   public boolean getgxTv_SdtRecetaMedica_Medicamentocodigo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtRecetaMedica_Medicamentonombre_Z( )
   {
      return gxTv_SdtRecetaMedica_Medicamentonombre_Z ;
   }

   public void setgxTv_SdtRecetaMedica_Medicamentonombre_Z( String value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      SetDirty("Medicamentonombre_Z");
      gxTv_SdtRecetaMedica_Medicamentonombre_Z = value ;
   }

   public void setgxTv_SdtRecetaMedica_Medicamentonombre_Z_SetNull( )
   {
      gxTv_SdtRecetaMedica_Medicamentonombre_Z = "" ;
   }

   public boolean getgxTv_SdtRecetaMedica_Medicamentonombre_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtRecetaMedica_Medicamentoformafarm_Z( )
   {
      return gxTv_SdtRecetaMedica_Medicamentoformafarm_Z ;
   }

   public void setgxTv_SdtRecetaMedica_Medicamentoformafarm_Z( String value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      SetDirty("Medicamentoformafarm_Z");
      gxTv_SdtRecetaMedica_Medicamentoformafarm_Z = value ;
   }

   public void setgxTv_SdtRecetaMedica_Medicamentoformafarm_Z_SetNull( )
   {
      gxTv_SdtRecetaMedica_Medicamentoformafarm_Z = "" ;
   }

   public boolean getgxTv_SdtRecetaMedica_Medicamentoformafarm_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtRecetaMedica_Recetamedicaconcentracion_Z( )
   {
      return gxTv_SdtRecetaMedica_Recetamedicaconcentracion_Z ;
   }

   public void setgxTv_SdtRecetaMedica_Recetamedicaconcentracion_Z( String value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      SetDirty("Recetamedicaconcentracion_Z");
      gxTv_SdtRecetaMedica_Recetamedicaconcentracion_Z = value ;
   }

   public void setgxTv_SdtRecetaMedica_Recetamedicaconcentracion_Z_SetNull( )
   {
      gxTv_SdtRecetaMedica_Recetamedicaconcentracion_Z = "" ;
   }

   public boolean getgxTv_SdtRecetaMedica_Recetamedicaconcentracion_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtRecetaMedica_Recetamedicacantidad_Z( )
   {
      return gxTv_SdtRecetaMedica_Recetamedicacantidad_Z ;
   }

   public void setgxTv_SdtRecetaMedica_Recetamedicacantidad_Z( short value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      SetDirty("Recetamedicacantidad_Z");
      gxTv_SdtRecetaMedica_Recetamedicacantidad_Z = value ;
   }

   public void setgxTv_SdtRecetaMedica_Recetamedicacantidad_Z_SetNull( )
   {
      gxTv_SdtRecetaMedica_Recetamedicacantidad_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtRecetaMedica_Recetamedicacantidad_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtRecetaMedica_Recetamedicaatencion_Z( )
   {
      return gxTv_SdtRecetaMedica_Recetamedicaatencion_Z ;
   }

   public void setgxTv_SdtRecetaMedica_Recetamedicaatencion_Z( String value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      SetDirty("Recetamedicaatencion_Z");
      gxTv_SdtRecetaMedica_Recetamedicaatencion_Z = value ;
   }

   public void setgxTv_SdtRecetaMedica_Recetamedicaatencion_Z_SetNull( )
   {
      gxTv_SdtRecetaMedica_Recetamedicaatencion_Z = "" ;
   }

   public boolean getgxTv_SdtRecetaMedica_Recetamedicaatencion_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtRecetaMedica_Recetamedicanombrearchivo_Z( )
   {
      return gxTv_SdtRecetaMedica_Recetamedicanombrearchivo_Z ;
   }

   public void setgxTv_SdtRecetaMedica_Recetamedicanombrearchivo_Z( String value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      SetDirty("Recetamedicanombrearchivo_Z");
      gxTv_SdtRecetaMedica_Recetamedicanombrearchivo_Z = value ;
   }

   public void setgxTv_SdtRecetaMedica_Recetamedicanombrearchivo_Z_SetNull( )
   {
      gxTv_SdtRecetaMedica_Recetamedicanombrearchivo_Z = "" ;
   }

   public boolean getgxTv_SdtRecetaMedica_Recetamedicanombrearchivo_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtRecetaMedica_Recetamedicaflag_Z( )
   {
      return gxTv_SdtRecetaMedica_Recetamedicaflag_Z ;
   }

   public void setgxTv_SdtRecetaMedica_Recetamedicaflag_Z( byte value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      SetDirty("Recetamedicaflag_Z");
      gxTv_SdtRecetaMedica_Recetamedicaflag_Z = value ;
   }

   public void setgxTv_SdtRecetaMedica_Recetamedicaflag_Z_SetNull( )
   {
      gxTv_SdtRecetaMedica_Recetamedicaflag_Z = (byte)(0) ;
   }

   public boolean getgxTv_SdtRecetaMedica_Recetamedicaflag_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtRecetaMedica_Recetaindicaciones_Z( )
   {
      return gxTv_SdtRecetaMedica_Recetaindicaciones_Z ;
   }

   public void setgxTv_SdtRecetaMedica_Recetaindicaciones_Z( String value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      SetDirty("Recetaindicaciones_Z");
      gxTv_SdtRecetaMedica_Recetaindicaciones_Z = value ;
   }

   public void setgxTv_SdtRecetaMedica_Recetaindicaciones_Z_SetNull( )
   {
      gxTv_SdtRecetaMedica_Recetaindicaciones_Z = "" ;
   }

   public boolean getgxTv_SdtRecetaMedica_Recetaindicaciones_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtRecetaMedica_Recetaarchivotipo_Z( )
   {
      return gxTv_SdtRecetaMedica_Recetaarchivotipo_Z ;
   }

   public void setgxTv_SdtRecetaMedica_Recetaarchivotipo_Z( String value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      SetDirty("Recetaarchivotipo_Z");
      gxTv_SdtRecetaMedica_Recetaarchivotipo_Z = value ;
   }

   public void setgxTv_SdtRecetaMedica_Recetaarchivotipo_Z_SetNull( )
   {
      gxTv_SdtRecetaMedica_Recetaarchivotipo_Z = "" ;
   }

   public boolean getgxTv_SdtRecetaMedica_Recetaarchivotipo_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtRecetaMedica_Medicamentoid_N( )
   {
      return gxTv_SdtRecetaMedica_Medicamentoid_N ;
   }

   public void setgxTv_SdtRecetaMedica_Medicamentoid_N( byte value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      SetDirty("Medicamentoid_N");
      gxTv_SdtRecetaMedica_Medicamentoid_N = value ;
   }

   public void setgxTv_SdtRecetaMedica_Medicamentoid_N_SetNull( )
   {
      gxTv_SdtRecetaMedica_Medicamentoid_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtRecetaMedica_Medicamentoid_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtRecetaMedica_Medicamentoformafarm_N( )
   {
      return gxTv_SdtRecetaMedica_Medicamentoformafarm_N ;
   }

   public void setgxTv_SdtRecetaMedica_Medicamentoformafarm_N( byte value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      SetDirty("Medicamentoformafarm_N");
      gxTv_SdtRecetaMedica_Medicamentoformafarm_N = value ;
   }

   public void setgxTv_SdtRecetaMedica_Medicamentoformafarm_N_SetNull( )
   {
      gxTv_SdtRecetaMedica_Medicamentoformafarm_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtRecetaMedica_Medicamentoformafarm_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtRecetaMedica_Recetamedicaconcentracion_N( )
   {
      return gxTv_SdtRecetaMedica_Recetamedicaconcentracion_N ;
   }

   public void setgxTv_SdtRecetaMedica_Recetamedicaconcentracion_N( byte value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      SetDirty("Recetamedicaconcentracion_N");
      gxTv_SdtRecetaMedica_Recetamedicaconcentracion_N = value ;
   }

   public void setgxTv_SdtRecetaMedica_Recetamedicaconcentracion_N_SetNull( )
   {
      gxTv_SdtRecetaMedica_Recetamedicaconcentracion_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtRecetaMedica_Recetamedicaconcentracion_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtRecetaMedica_Recetamedicacantidad_N( )
   {
      return gxTv_SdtRecetaMedica_Recetamedicacantidad_N ;
   }

   public void setgxTv_SdtRecetaMedica_Recetamedicacantidad_N( byte value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      SetDirty("Recetamedicacantidad_N");
      gxTv_SdtRecetaMedica_Recetamedicacantidad_N = value ;
   }

   public void setgxTv_SdtRecetaMedica_Recetamedicacantidad_N_SetNull( )
   {
      gxTv_SdtRecetaMedica_Recetamedicacantidad_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtRecetaMedica_Recetamedicacantidad_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtRecetaMedica_Recetamedicaatencion_N( )
   {
      return gxTv_SdtRecetaMedica_Recetamedicaatencion_N ;
   }

   public void setgxTv_SdtRecetaMedica_Recetamedicaatencion_N( byte value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      SetDirty("Recetamedicaatencion_N");
      gxTv_SdtRecetaMedica_Recetamedicaatencion_N = value ;
   }

   public void setgxTv_SdtRecetaMedica_Recetamedicaatencion_N_SetNull( )
   {
      gxTv_SdtRecetaMedica_Recetamedicaatencion_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtRecetaMedica_Recetamedicaatencion_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtRecetaMedica_Recetamedicaarchivo_N( )
   {
      return gxTv_SdtRecetaMedica_Recetamedicaarchivo_N ;
   }

   public void setgxTv_SdtRecetaMedica_Recetamedicaarchivo_N( byte value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      SetDirty("Recetamedicaarchivo_N");
      gxTv_SdtRecetaMedica_Recetamedicaarchivo_N = value ;
   }

   public void setgxTv_SdtRecetaMedica_Recetamedicaarchivo_N_SetNull( )
   {
      gxTv_SdtRecetaMedica_Recetamedicaarchivo_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtRecetaMedica_Recetamedicaarchivo_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtRecetaMedica_Recetamedicanombrearchivo_N( )
   {
      return gxTv_SdtRecetaMedica_Recetamedicanombrearchivo_N ;
   }

   public void setgxTv_SdtRecetaMedica_Recetamedicanombrearchivo_N( byte value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      SetDirty("Recetamedicanombrearchivo_N");
      gxTv_SdtRecetaMedica_Recetamedicanombrearchivo_N = value ;
   }

   public void setgxTv_SdtRecetaMedica_Recetamedicanombrearchivo_N_SetNull( )
   {
      gxTv_SdtRecetaMedica_Recetamedicanombrearchivo_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtRecetaMedica_Recetamedicanombrearchivo_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtRecetaMedica_Recetamedicaflag_N( )
   {
      return gxTv_SdtRecetaMedica_Recetamedicaflag_N ;
   }

   public void setgxTv_SdtRecetaMedica_Recetamedicaflag_N( byte value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      SetDirty("Recetamedicaflag_N");
      gxTv_SdtRecetaMedica_Recetamedicaflag_N = value ;
   }

   public void setgxTv_SdtRecetaMedica_Recetamedicaflag_N_SetNull( )
   {
      gxTv_SdtRecetaMedica_Recetamedicaflag_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtRecetaMedica_Recetamedicaflag_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.projectthani.recetamedica_bc obj;
      obj = new com.projectthani.recetamedica_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtRecetaMedica_N = (byte)(1) ;
      gxTv_SdtRecetaMedica_Medicamentocodigo = "" ;
      gxTv_SdtRecetaMedica_Medicamentonombre = "" ;
      gxTv_SdtRecetaMedica_Medicamentoformafarm = "" ;
      gxTv_SdtRecetaMedica_Recetamedicaconcentracion = "" ;
      gxTv_SdtRecetaMedica_Recetamedicaatencion = "" ;
      gxTv_SdtRecetaMedica_Recetamedicaarchivo = "" ;
      gxTv_SdtRecetaMedica_Recetamedicanombrearchivo = "" ;
      gxTv_SdtRecetaMedica_Recetaindicaciones = "" ;
      gxTv_SdtRecetaMedica_Recetaarchivotipo = "" ;
      gxTv_SdtRecetaMedica_Mode = "" ;
      gxTv_SdtRecetaMedica_Medicamentocodigo_Z = "" ;
      gxTv_SdtRecetaMedica_Medicamentonombre_Z = "" ;
      gxTv_SdtRecetaMedica_Medicamentoformafarm_Z = "" ;
      gxTv_SdtRecetaMedica_Recetamedicaconcentracion_Z = "" ;
      gxTv_SdtRecetaMedica_Recetamedicaatencion_Z = "" ;
      gxTv_SdtRecetaMedica_Recetamedicanombrearchivo_Z = "" ;
      gxTv_SdtRecetaMedica_Recetaindicaciones_Z = "" ;
      gxTv_SdtRecetaMedica_Recetaarchivotipo_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtRecetaMedica_N ;
   }

   public com.projectthani.SdtRecetaMedica Clone( )
   {
      com.projectthani.SdtRecetaMedica sdt;
      com.projectthani.recetamedica_bc obj;
      sdt = (com.projectthani.SdtRecetaMedica)(clone()) ;
      obj = (com.projectthani.recetamedica_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.projectthani.StructSdtRecetaMedica struct )
   {
      setgxTv_SdtRecetaMedica_Recetamedicaid(struct.getRecetamedicaid());
      setgxTv_SdtRecetaMedica_Citaid(struct.getCitaid());
      setgxTv_SdtRecetaMedica_Medicamentoid(struct.getMedicamentoid());
      setgxTv_SdtRecetaMedica_Medicamentocodigo(struct.getMedicamentocodigo());
      setgxTv_SdtRecetaMedica_Medicamentonombre(struct.getMedicamentonombre());
      setgxTv_SdtRecetaMedica_Medicamentoformafarm(struct.getMedicamentoformafarm());
      setgxTv_SdtRecetaMedica_Recetamedicaconcentracion(struct.getRecetamedicaconcentracion());
      setgxTv_SdtRecetaMedica_Recetamedicacantidad(struct.getRecetamedicacantidad());
      setgxTv_SdtRecetaMedica_Recetamedicaatencion(struct.getRecetamedicaatencion());
      setgxTv_SdtRecetaMedica_Recetamedicaarchivo(struct.getRecetamedicaarchivo());
      setgxTv_SdtRecetaMedica_Recetamedicanombrearchivo(struct.getRecetamedicanombrearchivo());
      setgxTv_SdtRecetaMedica_Recetamedicaflag(struct.getRecetamedicaflag());
      setgxTv_SdtRecetaMedica_Recetaindicaciones(struct.getRecetaindicaciones());
      setgxTv_SdtRecetaMedica_Recetaarchivotipo(struct.getRecetaarchivotipo());
      setgxTv_SdtRecetaMedica_Mode(struct.getMode());
      setgxTv_SdtRecetaMedica_Initialized(struct.getInitialized());
      setgxTv_SdtRecetaMedica_Recetamedicaid_Z(struct.getRecetamedicaid_Z());
      setgxTv_SdtRecetaMedica_Citaid_Z(struct.getCitaid_Z());
      setgxTv_SdtRecetaMedica_Medicamentoid_Z(struct.getMedicamentoid_Z());
      setgxTv_SdtRecetaMedica_Medicamentocodigo_Z(struct.getMedicamentocodigo_Z());
      setgxTv_SdtRecetaMedica_Medicamentonombre_Z(struct.getMedicamentonombre_Z());
      setgxTv_SdtRecetaMedica_Medicamentoformafarm_Z(struct.getMedicamentoformafarm_Z());
      setgxTv_SdtRecetaMedica_Recetamedicaconcentracion_Z(struct.getRecetamedicaconcentracion_Z());
      setgxTv_SdtRecetaMedica_Recetamedicacantidad_Z(struct.getRecetamedicacantidad_Z());
      setgxTv_SdtRecetaMedica_Recetamedicaatencion_Z(struct.getRecetamedicaatencion_Z());
      setgxTv_SdtRecetaMedica_Recetamedicanombrearchivo_Z(struct.getRecetamedicanombrearchivo_Z());
      setgxTv_SdtRecetaMedica_Recetamedicaflag_Z(struct.getRecetamedicaflag_Z());
      setgxTv_SdtRecetaMedica_Recetaindicaciones_Z(struct.getRecetaindicaciones_Z());
      setgxTv_SdtRecetaMedica_Recetaarchivotipo_Z(struct.getRecetaarchivotipo_Z());
      setgxTv_SdtRecetaMedica_Medicamentoid_N(struct.getMedicamentoid_N());
      setgxTv_SdtRecetaMedica_Medicamentoformafarm_N(struct.getMedicamentoformafarm_N());
      setgxTv_SdtRecetaMedica_Recetamedicaconcentracion_N(struct.getRecetamedicaconcentracion_N());
      setgxTv_SdtRecetaMedica_Recetamedicacantidad_N(struct.getRecetamedicacantidad_N());
      setgxTv_SdtRecetaMedica_Recetamedicaatencion_N(struct.getRecetamedicaatencion_N());
      setgxTv_SdtRecetaMedica_Recetamedicaarchivo_N(struct.getRecetamedicaarchivo_N());
      setgxTv_SdtRecetaMedica_Recetamedicanombrearchivo_N(struct.getRecetamedicanombrearchivo_N());
      setgxTv_SdtRecetaMedica_Recetamedicaflag_N(struct.getRecetamedicaflag_N());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtRecetaMedica getStruct( )
   {
      com.projectthani.StructSdtRecetaMedica struct = new com.projectthani.StructSdtRecetaMedica ();
      struct.setRecetamedicaid(getgxTv_SdtRecetaMedica_Recetamedicaid());
      struct.setCitaid(getgxTv_SdtRecetaMedica_Citaid());
      struct.setMedicamentoid(getgxTv_SdtRecetaMedica_Medicamentoid());
      struct.setMedicamentocodigo(getgxTv_SdtRecetaMedica_Medicamentocodigo());
      struct.setMedicamentonombre(getgxTv_SdtRecetaMedica_Medicamentonombre());
      struct.setMedicamentoformafarm(getgxTv_SdtRecetaMedica_Medicamentoformafarm());
      struct.setRecetamedicaconcentracion(getgxTv_SdtRecetaMedica_Recetamedicaconcentracion());
      struct.setRecetamedicacantidad(getgxTv_SdtRecetaMedica_Recetamedicacantidad());
      struct.setRecetamedicaatencion(getgxTv_SdtRecetaMedica_Recetamedicaatencion());
      struct.setRecetamedicaarchivo(getgxTv_SdtRecetaMedica_Recetamedicaarchivo());
      struct.setRecetamedicanombrearchivo(getgxTv_SdtRecetaMedica_Recetamedicanombrearchivo());
      struct.setRecetamedicaflag(getgxTv_SdtRecetaMedica_Recetamedicaflag());
      struct.setRecetaindicaciones(getgxTv_SdtRecetaMedica_Recetaindicaciones());
      struct.setRecetaarchivotipo(getgxTv_SdtRecetaMedica_Recetaarchivotipo());
      struct.setMode(getgxTv_SdtRecetaMedica_Mode());
      struct.setInitialized(getgxTv_SdtRecetaMedica_Initialized());
      struct.setRecetamedicaid_Z(getgxTv_SdtRecetaMedica_Recetamedicaid_Z());
      struct.setCitaid_Z(getgxTv_SdtRecetaMedica_Citaid_Z());
      struct.setMedicamentoid_Z(getgxTv_SdtRecetaMedica_Medicamentoid_Z());
      struct.setMedicamentocodigo_Z(getgxTv_SdtRecetaMedica_Medicamentocodigo_Z());
      struct.setMedicamentonombre_Z(getgxTv_SdtRecetaMedica_Medicamentonombre_Z());
      struct.setMedicamentoformafarm_Z(getgxTv_SdtRecetaMedica_Medicamentoformafarm_Z());
      struct.setRecetamedicaconcentracion_Z(getgxTv_SdtRecetaMedica_Recetamedicaconcentracion_Z());
      struct.setRecetamedicacantidad_Z(getgxTv_SdtRecetaMedica_Recetamedicacantidad_Z());
      struct.setRecetamedicaatencion_Z(getgxTv_SdtRecetaMedica_Recetamedicaatencion_Z());
      struct.setRecetamedicanombrearchivo_Z(getgxTv_SdtRecetaMedica_Recetamedicanombrearchivo_Z());
      struct.setRecetamedicaflag_Z(getgxTv_SdtRecetaMedica_Recetamedicaflag_Z());
      struct.setRecetaindicaciones_Z(getgxTv_SdtRecetaMedica_Recetaindicaciones_Z());
      struct.setRecetaarchivotipo_Z(getgxTv_SdtRecetaMedica_Recetaarchivotipo_Z());
      struct.setMedicamentoid_N(getgxTv_SdtRecetaMedica_Medicamentoid_N());
      struct.setMedicamentoformafarm_N(getgxTv_SdtRecetaMedica_Medicamentoformafarm_N());
      struct.setRecetamedicaconcentracion_N(getgxTv_SdtRecetaMedica_Recetamedicaconcentracion_N());
      struct.setRecetamedicacantidad_N(getgxTv_SdtRecetaMedica_Recetamedicacantidad_N());
      struct.setRecetamedicaatencion_N(getgxTv_SdtRecetaMedica_Recetamedicaatencion_N());
      struct.setRecetamedicaarchivo_N(getgxTv_SdtRecetaMedica_Recetamedicaarchivo_N());
      struct.setRecetamedicanombrearchivo_N(getgxTv_SdtRecetaMedica_Recetamedicanombrearchivo_N());
      struct.setRecetamedicaflag_N(getgxTv_SdtRecetaMedica_Recetamedicaflag_N());
      return struct ;
   }

   private byte gxTv_SdtRecetaMedica_N ;
   private byte gxTv_SdtRecetaMedica_Recetamedicaflag ;
   private byte gxTv_SdtRecetaMedica_Recetamedicaflag_Z ;
   private byte gxTv_SdtRecetaMedica_Medicamentoid_N ;
   private byte gxTv_SdtRecetaMedica_Medicamentoformafarm_N ;
   private byte gxTv_SdtRecetaMedica_Recetamedicaconcentracion_N ;
   private byte gxTv_SdtRecetaMedica_Recetamedicacantidad_N ;
   private byte gxTv_SdtRecetaMedica_Recetamedicaatencion_N ;
   private byte gxTv_SdtRecetaMedica_Recetamedicaarchivo_N ;
   private byte gxTv_SdtRecetaMedica_Recetamedicanombrearchivo_N ;
   private byte gxTv_SdtRecetaMedica_Recetamedicaflag_N ;
   private short gxTv_SdtRecetaMedica_Recetamedicaid ;
   private short gxTv_SdtRecetaMedica_Medicamentoid ;
   private short gxTv_SdtRecetaMedica_Recetamedicacantidad ;
   private short gxTv_SdtRecetaMedica_Initialized ;
   private short gxTv_SdtRecetaMedica_Recetamedicaid_Z ;
   private short gxTv_SdtRecetaMedica_Medicamentoid_Z ;
   private short gxTv_SdtRecetaMedica_Recetamedicacantidad_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtRecetaMedica_Citaid ;
   private int gxTv_SdtRecetaMedica_Citaid_Z ;
   private String gxTv_SdtRecetaMedica_Mode ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtRecetaMedica_Recetamedicaarchivo ;
   private String gxTv_SdtRecetaMedica_Medicamentocodigo ;
   private String gxTv_SdtRecetaMedica_Medicamentonombre ;
   private String gxTv_SdtRecetaMedica_Medicamentoformafarm ;
   private String gxTv_SdtRecetaMedica_Recetamedicaconcentracion ;
   private String gxTv_SdtRecetaMedica_Recetamedicaatencion ;
   private String gxTv_SdtRecetaMedica_Recetamedicanombrearchivo ;
   private String gxTv_SdtRecetaMedica_Recetaindicaciones ;
   private String gxTv_SdtRecetaMedica_Recetaarchivotipo ;
   private String gxTv_SdtRecetaMedica_Medicamentocodigo_Z ;
   private String gxTv_SdtRecetaMedica_Medicamentonombre_Z ;
   private String gxTv_SdtRecetaMedica_Medicamentoformafarm_Z ;
   private String gxTv_SdtRecetaMedica_Recetamedicaconcentracion_Z ;
   private String gxTv_SdtRecetaMedica_Recetamedicaatencion_Z ;
   private String gxTv_SdtRecetaMedica_Recetamedicanombrearchivo_Z ;
   private String gxTv_SdtRecetaMedica_Recetaindicaciones_Z ;
   private String gxTv_SdtRecetaMedica_Recetaarchivotipo_Z ;
}

