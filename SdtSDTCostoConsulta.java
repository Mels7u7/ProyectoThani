package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTCostoConsulta extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTCostoConsulta( )
   {
      this(  new ModelContext(SdtSDTCostoConsulta.class));
   }

   public SdtSDTCostoConsulta( ModelContext context )
   {
      super( context, "SdtSDTCostoConsulta");
   }

   public SdtSDTCostoConsulta( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTCostoConsulta");
   }

   public SdtSDTCostoConsulta( StructSdtSDTCostoConsulta struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalId") )
            {
               gxTv_SdtSDTCostoConsulta_Profesionalid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CostoConsulta") )
            {
               gxTv_SdtSDTCostoConsulta_Costoconsulta = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "sedeId") )
            {
               gxTv_SdtSDTCostoConsulta_Sedeid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EspecialidadId") )
            {
               gxTv_SdtSDTCostoConsulta_Especialidadid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SedeTipoConsulta") )
            {
               gxTv_SdtSDTCostoConsulta_Sedetipoconsulta = oReader.getValue() ;
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
         sName = "SDTCostoConsulta" ;
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
      oWriter.writeElement("ProfesionalId", GXutil.trim( GXutil.str( gxTv_SdtSDTCostoConsulta_Profesionalid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CostoConsulta", GXutil.trim( GXutil.strNoRound( gxTv_SdtSDTCostoConsulta_Costoconsulta, 6, 2)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("sedeId", GXutil.trim( GXutil.str( gxTv_SdtSDTCostoConsulta_Sedeid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("EspecialidadId", GXutil.trim( GXutil.str( gxTv_SdtSDTCostoConsulta_Especialidadid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SedeTipoConsulta", GXutil.rtrim( gxTv_SdtSDTCostoConsulta_Sedetipoconsulta));
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
      AddObjectProperty("ProfesionalId", gxTv_SdtSDTCostoConsulta_Profesionalid, false, false);
      AddObjectProperty("CostoConsulta", gxTv_SdtSDTCostoConsulta_Costoconsulta, false, false);
      AddObjectProperty("sedeId", gxTv_SdtSDTCostoConsulta_Sedeid, false, false);
      AddObjectProperty("EspecialidadId", gxTv_SdtSDTCostoConsulta_Especialidadid, false, false);
      AddObjectProperty("SedeTipoConsulta", gxTv_SdtSDTCostoConsulta_Sedetipoconsulta, false, false);
   }

   public int getgxTv_SdtSDTCostoConsulta_Profesionalid( )
   {
      return gxTv_SdtSDTCostoConsulta_Profesionalid ;
   }

   public void setgxTv_SdtSDTCostoConsulta_Profesionalid( int value )
   {
      gxTv_SdtSDTCostoConsulta_N = (byte)(0) ;
      gxTv_SdtSDTCostoConsulta_Profesionalid = value ;
   }

   public java.math.BigDecimal getgxTv_SdtSDTCostoConsulta_Costoconsulta( )
   {
      return gxTv_SdtSDTCostoConsulta_Costoconsulta ;
   }

   public void setgxTv_SdtSDTCostoConsulta_Costoconsulta( java.math.BigDecimal value )
   {
      gxTv_SdtSDTCostoConsulta_N = (byte)(0) ;
      gxTv_SdtSDTCostoConsulta_Costoconsulta = value ;
   }

   public short getgxTv_SdtSDTCostoConsulta_Sedeid( )
   {
      return gxTv_SdtSDTCostoConsulta_Sedeid ;
   }

   public void setgxTv_SdtSDTCostoConsulta_Sedeid( short value )
   {
      gxTv_SdtSDTCostoConsulta_N = (byte)(0) ;
      gxTv_SdtSDTCostoConsulta_Sedeid = value ;
   }

   public short getgxTv_SdtSDTCostoConsulta_Especialidadid( )
   {
      return gxTv_SdtSDTCostoConsulta_Especialidadid ;
   }

   public void setgxTv_SdtSDTCostoConsulta_Especialidadid( short value )
   {
      gxTv_SdtSDTCostoConsulta_N = (byte)(0) ;
      gxTv_SdtSDTCostoConsulta_Especialidadid = value ;
   }

   public String getgxTv_SdtSDTCostoConsulta_Sedetipoconsulta( )
   {
      return gxTv_SdtSDTCostoConsulta_Sedetipoconsulta ;
   }

   public void setgxTv_SdtSDTCostoConsulta_Sedetipoconsulta( String value )
   {
      gxTv_SdtSDTCostoConsulta_N = (byte)(0) ;
      gxTv_SdtSDTCostoConsulta_Sedetipoconsulta = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTCostoConsulta_N = (byte)(1) ;
      gxTv_SdtSDTCostoConsulta_Costoconsulta = DecimalUtil.stringToDec("0.00") ;
      gxTv_SdtSDTCostoConsulta_Sedetipoconsulta = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTCostoConsulta_N ;
   }

   public com.projectthani.SdtSDTCostoConsulta Clone( )
   {
      return (com.projectthani.SdtSDTCostoConsulta)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTCostoConsulta struct )
   {
      setgxTv_SdtSDTCostoConsulta_Profesionalid(struct.getProfesionalid());
      setgxTv_SdtSDTCostoConsulta_Costoconsulta(struct.getCostoconsulta());
      setgxTv_SdtSDTCostoConsulta_Sedeid(struct.getSedeid());
      setgxTv_SdtSDTCostoConsulta_Especialidadid(struct.getEspecialidadid());
      setgxTv_SdtSDTCostoConsulta_Sedetipoconsulta(struct.getSedetipoconsulta());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTCostoConsulta getStruct( )
   {
      com.projectthani.StructSdtSDTCostoConsulta struct = new com.projectthani.StructSdtSDTCostoConsulta ();
      struct.setProfesionalid(getgxTv_SdtSDTCostoConsulta_Profesionalid());
      struct.setCostoconsulta(getgxTv_SdtSDTCostoConsulta_Costoconsulta());
      struct.setSedeid(getgxTv_SdtSDTCostoConsulta_Sedeid());
      struct.setEspecialidadid(getgxTv_SdtSDTCostoConsulta_Especialidadid());
      struct.setSedetipoconsulta(getgxTv_SdtSDTCostoConsulta_Sedetipoconsulta());
      return struct ;
   }

   protected byte gxTv_SdtSDTCostoConsulta_N ;
   protected short gxTv_SdtSDTCostoConsulta_Sedeid ;
   protected short gxTv_SdtSDTCostoConsulta_Especialidadid ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_SdtSDTCostoConsulta_Profesionalid ;
   protected java.math.BigDecimal gxTv_SdtSDTCostoConsulta_Costoconsulta ;
   protected String gxTv_SdtSDTCostoConsulta_Sedetipoconsulta ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

