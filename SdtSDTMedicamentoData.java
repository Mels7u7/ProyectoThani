package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTMedicamentoData extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTMedicamentoData( )
   {
      this(  new ModelContext(SdtSDTMedicamentoData.class));
   }

   public SdtSDTMedicamentoData( ModelContext context )
   {
      super( context, "SdtSDTMedicamentoData");
   }

   public SdtSDTMedicamentoData( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTMedicamentoData");
   }

   public SdtSDTMedicamentoData( StructSdtSDTMedicamentoData struct )
   {
      this();
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
               gxTv_SdtSDTMedicamentoData_Medicamentoid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MedicamentoCodigo") )
            {
               gxTv_SdtSDTMedicamentoData_Medicamentocodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MedicamentoNombre") )
            {
               gxTv_SdtSDTMedicamentoData_Medicamentonombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MedicamentoFormaFarm") )
            {
               gxTv_SdtSDTMedicamentoData_Medicamentoformafarm = oReader.getValue() ;
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
         sName = "SDTMedicamentoData" ;
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
      oWriter.writeElement("MedicamentoId", GXutil.trim( GXutil.str( gxTv_SdtSDTMedicamentoData_Medicamentoid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("MedicamentoCodigo", GXutil.rtrim( gxTv_SdtSDTMedicamentoData_Medicamentocodigo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("MedicamentoNombre", GXutil.rtrim( gxTv_SdtSDTMedicamentoData_Medicamentonombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("MedicamentoFormaFarm", GXutil.rtrim( gxTv_SdtSDTMedicamentoData_Medicamentoformafarm));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
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
      AddObjectProperty("MedicamentoId", gxTv_SdtSDTMedicamentoData_Medicamentoid, false, false);
      AddObjectProperty("MedicamentoCodigo", gxTv_SdtSDTMedicamentoData_Medicamentocodigo, false, false);
      AddObjectProperty("MedicamentoNombre", gxTv_SdtSDTMedicamentoData_Medicamentonombre, false, false);
      AddObjectProperty("MedicamentoFormaFarm", gxTv_SdtSDTMedicamentoData_Medicamentoformafarm, false, false);
   }

   public short getgxTv_SdtSDTMedicamentoData_Medicamentoid( )
   {
      return gxTv_SdtSDTMedicamentoData_Medicamentoid ;
   }

   public void setgxTv_SdtSDTMedicamentoData_Medicamentoid( short value )
   {
      gxTv_SdtSDTMedicamentoData_N = (byte)(0) ;
      gxTv_SdtSDTMedicamentoData_Medicamentoid = value ;
   }

   public String getgxTv_SdtSDTMedicamentoData_Medicamentocodigo( )
   {
      return gxTv_SdtSDTMedicamentoData_Medicamentocodigo ;
   }

   public void setgxTv_SdtSDTMedicamentoData_Medicamentocodigo( String value )
   {
      gxTv_SdtSDTMedicamentoData_N = (byte)(0) ;
      gxTv_SdtSDTMedicamentoData_Medicamentocodigo = value ;
   }

   public String getgxTv_SdtSDTMedicamentoData_Medicamentonombre( )
   {
      return gxTv_SdtSDTMedicamentoData_Medicamentonombre ;
   }

   public void setgxTv_SdtSDTMedicamentoData_Medicamentonombre( String value )
   {
      gxTv_SdtSDTMedicamentoData_N = (byte)(0) ;
      gxTv_SdtSDTMedicamentoData_Medicamentonombre = value ;
   }

   public String getgxTv_SdtSDTMedicamentoData_Medicamentoformafarm( )
   {
      return gxTv_SdtSDTMedicamentoData_Medicamentoformafarm ;
   }

   public void setgxTv_SdtSDTMedicamentoData_Medicamentoformafarm( String value )
   {
      gxTv_SdtSDTMedicamentoData_N = (byte)(0) ;
      gxTv_SdtSDTMedicamentoData_Medicamentoformafarm = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTMedicamentoData_N = (byte)(1) ;
      gxTv_SdtSDTMedicamentoData_Medicamentocodigo = "" ;
      gxTv_SdtSDTMedicamentoData_Medicamentonombre = "" ;
      gxTv_SdtSDTMedicamentoData_Medicamentoformafarm = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTMedicamentoData_N ;
   }

   public com.projectthani.SdtSDTMedicamentoData Clone( )
   {
      return (com.projectthani.SdtSDTMedicamentoData)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTMedicamentoData struct )
   {
      setgxTv_SdtSDTMedicamentoData_Medicamentoid(struct.getMedicamentoid());
      setgxTv_SdtSDTMedicamentoData_Medicamentocodigo(struct.getMedicamentocodigo());
      setgxTv_SdtSDTMedicamentoData_Medicamentonombre(struct.getMedicamentonombre());
      setgxTv_SdtSDTMedicamentoData_Medicamentoformafarm(struct.getMedicamentoformafarm());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTMedicamentoData getStruct( )
   {
      com.projectthani.StructSdtSDTMedicamentoData struct = new com.projectthani.StructSdtSDTMedicamentoData ();
      struct.setMedicamentoid(getgxTv_SdtSDTMedicamentoData_Medicamentoid());
      struct.setMedicamentocodigo(getgxTv_SdtSDTMedicamentoData_Medicamentocodigo());
      struct.setMedicamentonombre(getgxTv_SdtSDTMedicamentoData_Medicamentonombre());
      struct.setMedicamentoformafarm(getgxTv_SdtSDTMedicamentoData_Medicamentoformafarm());
      return struct ;
   }

   protected byte gxTv_SdtSDTMedicamentoData_N ;
   protected short gxTv_SdtSDTMedicamentoData_Medicamentoid ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTMedicamentoData_Medicamentocodigo ;
   protected String gxTv_SdtSDTMedicamentoData_Medicamentonombre ;
   protected String gxTv_SdtSDTMedicamentoData_Medicamentoformafarm ;
}

