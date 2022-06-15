package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtMedicamento extends GxSilentTrnSdt implements Cloneable, java.io.Serializable
{
   public SdtMedicamento( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtMedicamento.class));
   }

   public SdtMedicamento( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle, context, "SdtMedicamento");
      initialize( remoteHandle) ;
   }

   public SdtMedicamento( int remoteHandle ,
                          StructSdtMedicamento struct )
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

   public void Load( short AV42MedicamentoId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Short.valueOf(AV42MedicamentoId)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"MedicamentoId", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Medicamento");
      metadata.set("BT", "Medicamento");
      metadata.set("PK", "[ \"MedicamentoId\" ]");
      metadata.set("PKAssigned", "[ \"MedicamentoId\" ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "MedicamentoId") )
            {
               gxTv_SdtMedicamento_Medicamentoid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MedicamentoCodigo") )
            {
               gxTv_SdtMedicamento_Medicamentocodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MedicamentoNombre") )
            {
               gxTv_SdtMedicamento_Medicamentonombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MedicamentoFormaFarm") )
            {
               gxTv_SdtMedicamento_Medicamentoformafarm = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtMedicamento_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtMedicamento_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MedicamentoId_Z") )
            {
               gxTv_SdtMedicamento_Medicamentoid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MedicamentoCodigo_Z") )
            {
               gxTv_SdtMedicamento_Medicamentocodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MedicamentoNombre_Z") )
            {
               gxTv_SdtMedicamento_Medicamentonombre_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MedicamentoFormaFarm_Z") )
            {
               gxTv_SdtMedicamento_Medicamentoformafarm_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MedicamentoId_N") )
            {
               gxTv_SdtMedicamento_Medicamentoid_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MedicamentoFormaFarm_N") )
            {
               gxTv_SdtMedicamento_Medicamentoformafarm_N = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "Medicamento" ;
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
      oWriter.writeElement("MedicamentoId", GXutil.trim( GXutil.str( gxTv_SdtMedicamento_Medicamentoid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("MedicamentoCodigo", GXutil.rtrim( gxTv_SdtMedicamento_Medicamentocodigo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("MedicamentoNombre", GXutil.rtrim( gxTv_SdtMedicamento_Medicamentonombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("MedicamentoFormaFarm", GXutil.rtrim( gxTv_SdtMedicamento_Medicamentoformafarm));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", GXutil.rtrim( gxTv_SdtMedicamento_Mode));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtMedicamento_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("MedicamentoId_Z", GXutil.trim( GXutil.str( gxTv_SdtMedicamento_Medicamentoid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("MedicamentoCodigo_Z", GXutil.rtrim( gxTv_SdtMedicamento_Medicamentocodigo_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("MedicamentoNombre_Z", GXutil.rtrim( gxTv_SdtMedicamento_Medicamentonombre_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("MedicamentoFormaFarm_Z", GXutil.rtrim( gxTv_SdtMedicamento_Medicamentoformafarm_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("MedicamentoId_N", GXutil.trim( GXutil.str( gxTv_SdtMedicamento_Medicamentoid_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("MedicamentoFormaFarm_N", GXutil.trim( GXutil.str( gxTv_SdtMedicamento_Medicamentoformafarm_N, 1, 0)));
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
      AddObjectProperty("MedicamentoId", gxTv_SdtMedicamento_Medicamentoid, false, includeNonInitialized);
      AddObjectProperty("MedicamentoId_N", gxTv_SdtMedicamento_Medicamentoid_N, false, includeNonInitialized);
      AddObjectProperty("MedicamentoCodigo", gxTv_SdtMedicamento_Medicamentocodigo, false, includeNonInitialized);
      AddObjectProperty("MedicamentoNombre", gxTv_SdtMedicamento_Medicamentonombre, false, includeNonInitialized);
      AddObjectProperty("MedicamentoFormaFarm", gxTv_SdtMedicamento_Medicamentoformafarm, false, includeNonInitialized);
      AddObjectProperty("MedicamentoFormaFarm_N", gxTv_SdtMedicamento_Medicamentoformafarm_N, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtMedicamento_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtMedicamento_Initialized, false, includeNonInitialized);
         AddObjectProperty("MedicamentoId_Z", gxTv_SdtMedicamento_Medicamentoid_Z, false, includeNonInitialized);
         AddObjectProperty("MedicamentoCodigo_Z", gxTv_SdtMedicamento_Medicamentocodigo_Z, false, includeNonInitialized);
         AddObjectProperty("MedicamentoNombre_Z", gxTv_SdtMedicamento_Medicamentonombre_Z, false, includeNonInitialized);
         AddObjectProperty("MedicamentoFormaFarm_Z", gxTv_SdtMedicamento_Medicamentoformafarm_Z, false, includeNonInitialized);
         AddObjectProperty("MedicamentoId_N", gxTv_SdtMedicamento_Medicamentoid_N, false, includeNonInitialized);
         AddObjectProperty("MedicamentoFormaFarm_N", gxTv_SdtMedicamento_Medicamentoformafarm_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.projectthani.SdtMedicamento sdt )
   {
      if ( sdt.IsDirty("MedicamentoId") )
      {
         gxTv_SdtMedicamento_N = (byte)(0) ;
         gxTv_SdtMedicamento_Medicamentoid = sdt.getgxTv_SdtMedicamento_Medicamentoid() ;
      }
      if ( sdt.IsDirty("MedicamentoCodigo") )
      {
         gxTv_SdtMedicamento_N = (byte)(0) ;
         gxTv_SdtMedicamento_Medicamentocodigo = sdt.getgxTv_SdtMedicamento_Medicamentocodigo() ;
      }
      if ( sdt.IsDirty("MedicamentoNombre") )
      {
         gxTv_SdtMedicamento_N = (byte)(0) ;
         gxTv_SdtMedicamento_Medicamentonombre = sdt.getgxTv_SdtMedicamento_Medicamentonombre() ;
      }
      if ( sdt.IsDirty("MedicamentoFormaFarm") )
      {
         gxTv_SdtMedicamento_Medicamentoformafarm_N = (byte)(0) ;
         gxTv_SdtMedicamento_N = (byte)(0) ;
         gxTv_SdtMedicamento_Medicamentoformafarm = sdt.getgxTv_SdtMedicamento_Medicamentoformafarm() ;
      }
   }

   public short getgxTv_SdtMedicamento_Medicamentoid( )
   {
      return gxTv_SdtMedicamento_Medicamentoid ;
   }

   public void setgxTv_SdtMedicamento_Medicamentoid( short value )
   {
      gxTv_SdtMedicamento_N = (byte)(0) ;
      if ( gxTv_SdtMedicamento_Medicamentoid != value )
      {
         gxTv_SdtMedicamento_Mode = "INS" ;
         this.setgxTv_SdtMedicamento_Medicamentoid_Z_SetNull( );
         this.setgxTv_SdtMedicamento_Medicamentocodigo_Z_SetNull( );
         this.setgxTv_SdtMedicamento_Medicamentonombre_Z_SetNull( );
         this.setgxTv_SdtMedicamento_Medicamentoformafarm_Z_SetNull( );
      }
      SetDirty("Medicamentoid");
      gxTv_SdtMedicamento_Medicamentoid = value ;
   }

   public String getgxTv_SdtMedicamento_Medicamentocodigo( )
   {
      return gxTv_SdtMedicamento_Medicamentocodigo ;
   }

   public void setgxTv_SdtMedicamento_Medicamentocodigo( String value )
   {
      gxTv_SdtMedicamento_N = (byte)(0) ;
      SetDirty("Medicamentocodigo");
      gxTv_SdtMedicamento_Medicamentocodigo = value ;
   }

   public String getgxTv_SdtMedicamento_Medicamentonombre( )
   {
      return gxTv_SdtMedicamento_Medicamentonombre ;
   }

   public void setgxTv_SdtMedicamento_Medicamentonombre( String value )
   {
      gxTv_SdtMedicamento_N = (byte)(0) ;
      SetDirty("Medicamentonombre");
      gxTv_SdtMedicamento_Medicamentonombre = value ;
   }

   public String getgxTv_SdtMedicamento_Medicamentoformafarm( )
   {
      return gxTv_SdtMedicamento_Medicamentoformafarm ;
   }

   public void setgxTv_SdtMedicamento_Medicamentoformafarm( String value )
   {
      gxTv_SdtMedicamento_Medicamentoformafarm_N = (byte)(0) ;
      gxTv_SdtMedicamento_N = (byte)(0) ;
      SetDirty("Medicamentoformafarm");
      gxTv_SdtMedicamento_Medicamentoformafarm = value ;
   }

   public void setgxTv_SdtMedicamento_Medicamentoformafarm_SetNull( )
   {
      gxTv_SdtMedicamento_Medicamentoformafarm_N = (byte)(1) ;
      gxTv_SdtMedicamento_Medicamentoformafarm = "" ;
   }

   public boolean getgxTv_SdtMedicamento_Medicamentoformafarm_IsNull( )
   {
      return (gxTv_SdtMedicamento_Medicamentoformafarm_N==1) ;
   }

   public String getgxTv_SdtMedicamento_Mode( )
   {
      return gxTv_SdtMedicamento_Mode ;
   }

   public void setgxTv_SdtMedicamento_Mode( String value )
   {
      gxTv_SdtMedicamento_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtMedicamento_Mode = value ;
   }

   public void setgxTv_SdtMedicamento_Mode_SetNull( )
   {
      gxTv_SdtMedicamento_Mode = "" ;
   }

   public boolean getgxTv_SdtMedicamento_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtMedicamento_Initialized( )
   {
      return gxTv_SdtMedicamento_Initialized ;
   }

   public void setgxTv_SdtMedicamento_Initialized( short value )
   {
      gxTv_SdtMedicamento_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtMedicamento_Initialized = value ;
   }

   public void setgxTv_SdtMedicamento_Initialized_SetNull( )
   {
      gxTv_SdtMedicamento_Initialized = (short)(0) ;
   }

   public boolean getgxTv_SdtMedicamento_Initialized_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtMedicamento_Medicamentoid_Z( )
   {
      return gxTv_SdtMedicamento_Medicamentoid_Z ;
   }

   public void setgxTv_SdtMedicamento_Medicamentoid_Z( short value )
   {
      gxTv_SdtMedicamento_N = (byte)(0) ;
      SetDirty("Medicamentoid_Z");
      gxTv_SdtMedicamento_Medicamentoid_Z = value ;
   }

   public void setgxTv_SdtMedicamento_Medicamentoid_Z_SetNull( )
   {
      gxTv_SdtMedicamento_Medicamentoid_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtMedicamento_Medicamentoid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtMedicamento_Medicamentocodigo_Z( )
   {
      return gxTv_SdtMedicamento_Medicamentocodigo_Z ;
   }

   public void setgxTv_SdtMedicamento_Medicamentocodigo_Z( String value )
   {
      gxTv_SdtMedicamento_N = (byte)(0) ;
      SetDirty("Medicamentocodigo_Z");
      gxTv_SdtMedicamento_Medicamentocodigo_Z = value ;
   }

   public void setgxTv_SdtMedicamento_Medicamentocodigo_Z_SetNull( )
   {
      gxTv_SdtMedicamento_Medicamentocodigo_Z = "" ;
   }

   public boolean getgxTv_SdtMedicamento_Medicamentocodigo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtMedicamento_Medicamentonombre_Z( )
   {
      return gxTv_SdtMedicamento_Medicamentonombre_Z ;
   }

   public void setgxTv_SdtMedicamento_Medicamentonombre_Z( String value )
   {
      gxTv_SdtMedicamento_N = (byte)(0) ;
      SetDirty("Medicamentonombre_Z");
      gxTv_SdtMedicamento_Medicamentonombre_Z = value ;
   }

   public void setgxTv_SdtMedicamento_Medicamentonombre_Z_SetNull( )
   {
      gxTv_SdtMedicamento_Medicamentonombre_Z = "" ;
   }

   public boolean getgxTv_SdtMedicamento_Medicamentonombre_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtMedicamento_Medicamentoformafarm_Z( )
   {
      return gxTv_SdtMedicamento_Medicamentoformafarm_Z ;
   }

   public void setgxTv_SdtMedicamento_Medicamentoformafarm_Z( String value )
   {
      gxTv_SdtMedicamento_N = (byte)(0) ;
      SetDirty("Medicamentoformafarm_Z");
      gxTv_SdtMedicamento_Medicamentoformafarm_Z = value ;
   }

   public void setgxTv_SdtMedicamento_Medicamentoformafarm_Z_SetNull( )
   {
      gxTv_SdtMedicamento_Medicamentoformafarm_Z = "" ;
   }

   public boolean getgxTv_SdtMedicamento_Medicamentoformafarm_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtMedicamento_Medicamentoid_N( )
   {
      return gxTv_SdtMedicamento_Medicamentoid_N ;
   }

   public void setgxTv_SdtMedicamento_Medicamentoid_N( byte value )
   {
      gxTv_SdtMedicamento_N = (byte)(0) ;
      SetDirty("Medicamentoid_N");
      gxTv_SdtMedicamento_Medicamentoid_N = value ;
   }

   public void setgxTv_SdtMedicamento_Medicamentoid_N_SetNull( )
   {
      gxTv_SdtMedicamento_Medicamentoid_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtMedicamento_Medicamentoid_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtMedicamento_Medicamentoformafarm_N( )
   {
      return gxTv_SdtMedicamento_Medicamentoformafarm_N ;
   }

   public void setgxTv_SdtMedicamento_Medicamentoformafarm_N( byte value )
   {
      gxTv_SdtMedicamento_N = (byte)(0) ;
      SetDirty("Medicamentoformafarm_N");
      gxTv_SdtMedicamento_Medicamentoformafarm_N = value ;
   }

   public void setgxTv_SdtMedicamento_Medicamentoformafarm_N_SetNull( )
   {
      gxTv_SdtMedicamento_Medicamentoformafarm_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtMedicamento_Medicamentoformafarm_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.projectthani.medicamento_bc obj;
      obj = new com.projectthani.medicamento_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtMedicamento_N = (byte)(1) ;
      gxTv_SdtMedicamento_Medicamentocodigo = "" ;
      gxTv_SdtMedicamento_Medicamentonombre = "" ;
      gxTv_SdtMedicamento_Medicamentoformafarm = "" ;
      gxTv_SdtMedicamento_Mode = "" ;
      gxTv_SdtMedicamento_Medicamentocodigo_Z = "" ;
      gxTv_SdtMedicamento_Medicamentonombre_Z = "" ;
      gxTv_SdtMedicamento_Medicamentoformafarm_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtMedicamento_N ;
   }

   public com.projectthani.SdtMedicamento Clone( )
   {
      com.projectthani.SdtMedicamento sdt;
      com.projectthani.medicamento_bc obj;
      sdt = (com.projectthani.SdtMedicamento)(clone()) ;
      obj = (com.projectthani.medicamento_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.projectthani.StructSdtMedicamento struct )
   {
      setgxTv_SdtMedicamento_Medicamentoid(struct.getMedicamentoid());
      setgxTv_SdtMedicamento_Medicamentocodigo(struct.getMedicamentocodigo());
      setgxTv_SdtMedicamento_Medicamentonombre(struct.getMedicamentonombre());
      setgxTv_SdtMedicamento_Medicamentoformafarm(struct.getMedicamentoformafarm());
      setgxTv_SdtMedicamento_Mode(struct.getMode());
      setgxTv_SdtMedicamento_Initialized(struct.getInitialized());
      setgxTv_SdtMedicamento_Medicamentoid_Z(struct.getMedicamentoid_Z());
      setgxTv_SdtMedicamento_Medicamentocodigo_Z(struct.getMedicamentocodigo_Z());
      setgxTv_SdtMedicamento_Medicamentonombre_Z(struct.getMedicamentonombre_Z());
      setgxTv_SdtMedicamento_Medicamentoformafarm_Z(struct.getMedicamentoformafarm_Z());
      setgxTv_SdtMedicamento_Medicamentoid_N(struct.getMedicamentoid_N());
      setgxTv_SdtMedicamento_Medicamentoformafarm_N(struct.getMedicamentoformafarm_N());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtMedicamento getStruct( )
   {
      com.projectthani.StructSdtMedicamento struct = new com.projectthani.StructSdtMedicamento ();
      struct.setMedicamentoid(getgxTv_SdtMedicamento_Medicamentoid());
      struct.setMedicamentocodigo(getgxTv_SdtMedicamento_Medicamentocodigo());
      struct.setMedicamentonombre(getgxTv_SdtMedicamento_Medicamentonombre());
      struct.setMedicamentoformafarm(getgxTv_SdtMedicamento_Medicamentoformafarm());
      struct.setMode(getgxTv_SdtMedicamento_Mode());
      struct.setInitialized(getgxTv_SdtMedicamento_Initialized());
      struct.setMedicamentoid_Z(getgxTv_SdtMedicamento_Medicamentoid_Z());
      struct.setMedicamentocodigo_Z(getgxTv_SdtMedicamento_Medicamentocodigo_Z());
      struct.setMedicamentonombre_Z(getgxTv_SdtMedicamento_Medicamentonombre_Z());
      struct.setMedicamentoformafarm_Z(getgxTv_SdtMedicamento_Medicamentoformafarm_Z());
      struct.setMedicamentoid_N(getgxTv_SdtMedicamento_Medicamentoid_N());
      struct.setMedicamentoformafarm_N(getgxTv_SdtMedicamento_Medicamentoformafarm_N());
      return struct ;
   }

   private byte gxTv_SdtMedicamento_N ;
   private byte gxTv_SdtMedicamento_Medicamentoid_N ;
   private byte gxTv_SdtMedicamento_Medicamentoformafarm_N ;
   private short gxTv_SdtMedicamento_Medicamentoid ;
   private short gxTv_SdtMedicamento_Initialized ;
   private short gxTv_SdtMedicamento_Medicamentoid_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtMedicamento_Mode ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtMedicamento_Medicamentocodigo ;
   private String gxTv_SdtMedicamento_Medicamentonombre ;
   private String gxTv_SdtMedicamento_Medicamentoformafarm ;
   private String gxTv_SdtMedicamento_Medicamentocodigo_Z ;
   private String gxTv_SdtMedicamento_Medicamentonombre_Z ;
   private String gxTv_SdtMedicamento_Medicamentoformafarm_Z ;
}

