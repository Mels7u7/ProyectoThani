package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTMedicamentoGridItem extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTMedicamentoGridItem( )
   {
      this(  new ModelContext(SdtSDTMedicamentoGridItem.class));
   }

   public SdtSDTMedicamentoGridItem( ModelContext context )
   {
      super( context, "SdtSDTMedicamentoGridItem");
   }

   public SdtSDTMedicamentoGridItem( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTMedicamentoGridItem");
   }

   public SdtSDTMedicamentoGridItem( StructSdtSDTMedicamentoGridItem struct )
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
               gxTv_SdtSDTMedicamentoGridItem_Medicamentoid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MedicamentoNombre") )
            {
               gxTv_SdtSDTMedicamentoGridItem_Medicamentonombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MedicamentoCantidad") )
            {
               gxTv_SdtSDTMedicamentoGridItem_Medicamentocantidad = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MedicamentoIndicaciones") )
            {
               gxTv_SdtSDTMedicamentoGridItem_Medicamentoindicaciones = oReader.getValue() ;
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
         sName = "SDTMedicamentoGridItem" ;
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
      oWriter.writeElement("MedicamentoId", GXutil.trim( GXutil.str( gxTv_SdtSDTMedicamentoGridItem_Medicamentoid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("MedicamentoNombre", GXutil.rtrim( gxTv_SdtSDTMedicamentoGridItem_Medicamentonombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("MedicamentoCantidad", GXutil.trim( GXutil.str( gxTv_SdtSDTMedicamentoGridItem_Medicamentocantidad, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("MedicamentoIndicaciones", GXutil.rtrim( gxTv_SdtSDTMedicamentoGridItem_Medicamentoindicaciones));
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
      AddObjectProperty("MedicamentoId", gxTv_SdtSDTMedicamentoGridItem_Medicamentoid, false, false);
      AddObjectProperty("MedicamentoNombre", gxTv_SdtSDTMedicamentoGridItem_Medicamentonombre, false, false);
      AddObjectProperty("MedicamentoCantidad", gxTv_SdtSDTMedicamentoGridItem_Medicamentocantidad, false, false);
      AddObjectProperty("MedicamentoIndicaciones", gxTv_SdtSDTMedicamentoGridItem_Medicamentoindicaciones, false, false);
   }

   public short getgxTv_SdtSDTMedicamentoGridItem_Medicamentoid( )
   {
      return gxTv_SdtSDTMedicamentoGridItem_Medicamentoid ;
   }

   public void setgxTv_SdtSDTMedicamentoGridItem_Medicamentoid( short value )
   {
      gxTv_SdtSDTMedicamentoGridItem_N = (byte)(0) ;
      gxTv_SdtSDTMedicamentoGridItem_Medicamentoid = value ;
   }

   public String getgxTv_SdtSDTMedicamentoGridItem_Medicamentonombre( )
   {
      return gxTv_SdtSDTMedicamentoGridItem_Medicamentonombre ;
   }

   public void setgxTv_SdtSDTMedicamentoGridItem_Medicamentonombre( String value )
   {
      gxTv_SdtSDTMedicamentoGridItem_N = (byte)(0) ;
      gxTv_SdtSDTMedicamentoGridItem_Medicamentonombre = value ;
   }

   public short getgxTv_SdtSDTMedicamentoGridItem_Medicamentocantidad( )
   {
      return gxTv_SdtSDTMedicamentoGridItem_Medicamentocantidad ;
   }

   public void setgxTv_SdtSDTMedicamentoGridItem_Medicamentocantidad( short value )
   {
      gxTv_SdtSDTMedicamentoGridItem_N = (byte)(0) ;
      gxTv_SdtSDTMedicamentoGridItem_Medicamentocantidad = value ;
   }

   public String getgxTv_SdtSDTMedicamentoGridItem_Medicamentoindicaciones( )
   {
      return gxTv_SdtSDTMedicamentoGridItem_Medicamentoindicaciones ;
   }

   public void setgxTv_SdtSDTMedicamentoGridItem_Medicamentoindicaciones( String value )
   {
      gxTv_SdtSDTMedicamentoGridItem_N = (byte)(0) ;
      gxTv_SdtSDTMedicamentoGridItem_Medicamentoindicaciones = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTMedicamentoGridItem_N = (byte)(1) ;
      gxTv_SdtSDTMedicamentoGridItem_Medicamentonombre = "" ;
      gxTv_SdtSDTMedicamentoGridItem_Medicamentoindicaciones = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTMedicamentoGridItem_N ;
   }

   public com.projectthani.SdtSDTMedicamentoGridItem Clone( )
   {
      return (com.projectthani.SdtSDTMedicamentoGridItem)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTMedicamentoGridItem struct )
   {
      setgxTv_SdtSDTMedicamentoGridItem_Medicamentoid(struct.getMedicamentoid());
      setgxTv_SdtSDTMedicamentoGridItem_Medicamentonombre(struct.getMedicamentonombre());
      setgxTv_SdtSDTMedicamentoGridItem_Medicamentocantidad(struct.getMedicamentocantidad());
      setgxTv_SdtSDTMedicamentoGridItem_Medicamentoindicaciones(struct.getMedicamentoindicaciones());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTMedicamentoGridItem getStruct( )
   {
      com.projectthani.StructSdtSDTMedicamentoGridItem struct = new com.projectthani.StructSdtSDTMedicamentoGridItem ();
      struct.setMedicamentoid(getgxTv_SdtSDTMedicamentoGridItem_Medicamentoid());
      struct.setMedicamentonombre(getgxTv_SdtSDTMedicamentoGridItem_Medicamentonombre());
      struct.setMedicamentocantidad(getgxTv_SdtSDTMedicamentoGridItem_Medicamentocantidad());
      struct.setMedicamentoindicaciones(getgxTv_SdtSDTMedicamentoGridItem_Medicamentoindicaciones());
      return struct ;
   }

   protected byte gxTv_SdtSDTMedicamentoGridItem_N ;
   protected short gxTv_SdtSDTMedicamentoGridItem_Medicamentoid ;
   protected short gxTv_SdtSDTMedicamentoGridItem_Medicamentocantidad ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTMedicamentoGridItem_Medicamentonombre ;
   protected String gxTv_SdtSDTMedicamentoGridItem_Medicamentoindicaciones ;
}

