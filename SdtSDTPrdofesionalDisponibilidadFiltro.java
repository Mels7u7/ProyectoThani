package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTPrdofesionalDisponibilidadFiltro extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTPrdofesionalDisponibilidadFiltro( )
   {
      this(  new ModelContext(SdtSDTPrdofesionalDisponibilidadFiltro.class));
   }

   public SdtSDTPrdofesionalDisponibilidadFiltro( ModelContext context )
   {
      super( context, "SdtSDTPrdofesionalDisponibilidadFiltro");
   }

   public SdtSDTPrdofesionalDisponibilidadFiltro( int remoteHandle ,
                                                  ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTPrdofesionalDisponibilidadFiltro");
   }

   public SdtSDTPrdofesionalDisponibilidadFiltro( StructSdtSDTPrdofesionalDisponibilidadFiltro struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "DisponibilidadId") )
            {
               gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Disponibilidadid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalId") )
            {
               gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Profesionalid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Especialidad") )
            {
               gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Especialidad = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TipoCita") )
            {
               gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Tipocita = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FechaCita") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Fechacita = GXutil.nullDate() ;
                  gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Fechacita_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Fechacita_N = (byte)(0) ;
                  gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Fechacita = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CostoCita") )
            {
               gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Costocita = oReader.getValue() ;
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
         sName = "SDTPrdofesionalDisponibilidadFiltro" ;
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
      oWriter.writeElement("DisponibilidadId", GXutil.trim( GXutil.str( gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Disponibilidadid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalId", GXutil.trim( GXutil.str( gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Profesionalid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Especialidad", GXutil.rtrim( gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Especialidad));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("TipoCita", GXutil.rtrim( gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Tipocita));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Fechacita)) && ( gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Fechacita_N == 1 ) )
      {
         oWriter.writeElement("FechaCita", "");
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Fechacita), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Fechacita), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Fechacita), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("FechaCita", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      oWriter.writeElement("CostoCita", GXutil.rtrim( gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Costocita));
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
      AddObjectProperty("DisponibilidadId", gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Disponibilidadid, false, false);
      AddObjectProperty("ProfesionalId", gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Profesionalid, false, false);
      AddObjectProperty("Especialidad", gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Especialidad, false, false);
      AddObjectProperty("TipoCita", gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Tipocita, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Fechacita), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Fechacita), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Fechacita), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("FechaCita", sDateCnv, false, false);
      AddObjectProperty("CostoCita", gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Costocita, false, false);
   }

   public int getgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Disponibilidadid( )
   {
      return gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Disponibilidadid ;
   }

   public void setgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Disponibilidadid( int value )
   {
      gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_N = (byte)(0) ;
      gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Disponibilidadid = value ;
   }

   public int getgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Profesionalid( )
   {
      return gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Profesionalid ;
   }

   public void setgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Profesionalid( int value )
   {
      gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_N = (byte)(0) ;
      gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Profesionalid = value ;
   }

   public String getgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Especialidad( )
   {
      return gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Especialidad ;
   }

   public void setgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Especialidad( String value )
   {
      gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_N = (byte)(0) ;
      gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Especialidad = value ;
   }

   public String getgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Tipocita( )
   {
      return gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Tipocita ;
   }

   public void setgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Tipocita( String value )
   {
      gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_N = (byte)(0) ;
      gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Tipocita = value ;
   }

   public java.util.Date getgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Fechacita( )
   {
      return gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Fechacita ;
   }

   public void setgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Fechacita( java.util.Date value )
   {
      gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Fechacita_N = (byte)(0) ;
      gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_N = (byte)(0) ;
      gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Fechacita = value ;
   }

   public String getgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Costocita( )
   {
      return gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Costocita ;
   }

   public void setgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Costocita( String value )
   {
      gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_N = (byte)(0) ;
      gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Costocita = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_N = (byte)(1) ;
      gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Especialidad = "" ;
      gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Tipocita = "" ;
      gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Fechacita = GXutil.nullDate() ;
      gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Fechacita_N = (byte)(1) ;
      gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Costocita = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_N ;
   }

   public com.projectthani.SdtSDTPrdofesionalDisponibilidadFiltro Clone( )
   {
      return (com.projectthani.SdtSDTPrdofesionalDisponibilidadFiltro)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTPrdofesionalDisponibilidadFiltro struct )
   {
      setgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Disponibilidadid(struct.getDisponibilidadid());
      setgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Profesionalid(struct.getProfesionalid());
      setgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Especialidad(struct.getEspecialidad());
      setgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Tipocita(struct.getTipocita());
      if ( struct.gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Fechacita_N == 0 )
      {
         setgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Fechacita(struct.getFechacita());
      }
      setgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Costocita(struct.getCostocita());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTPrdofesionalDisponibilidadFiltro getStruct( )
   {
      com.projectthani.StructSdtSDTPrdofesionalDisponibilidadFiltro struct = new com.projectthani.StructSdtSDTPrdofesionalDisponibilidadFiltro ();
      struct.setDisponibilidadid(getgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Disponibilidadid());
      struct.setProfesionalid(getgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Profesionalid());
      struct.setEspecialidad(getgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Especialidad());
      struct.setTipocita(getgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Tipocita());
      if ( gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Fechacita_N == 0 )
      {
         struct.setFechacita(getgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Fechacita());
      }
      struct.setCostocita(getgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Costocita());
      return struct ;
   }

   protected byte gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_N ;
   protected byte gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Fechacita_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Disponibilidadid ;
   protected int gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Profesionalid ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Fechacita ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Especialidad ;
   protected String gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Tipocita ;
   protected String gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Costocita ;
}

