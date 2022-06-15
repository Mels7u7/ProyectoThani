package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTProfesionalExperienciaLaboralProfesional extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTProfesionalExperienciaLaboralProfesional( )
   {
      this(  new ModelContext(SdtSDTProfesionalExperienciaLaboralProfesional.class));
   }

   public SdtSDTProfesionalExperienciaLaboralProfesional( ModelContext context )
   {
      super( context, "SdtSDTProfesionalExperienciaLaboralProfesional");
   }

   public SdtSDTProfesionalExperienciaLaboralProfesional( int remoteHandle ,
                                                          ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTProfesionalExperienciaLaboralProfesional");
   }

   public SdtSDTProfesionalExperienciaLaboralProfesional( StructSdtSDTProfesionalExperienciaLaboralProfesional struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Id") )
            {
               gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Id = GXutil.strToGuid(oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "NombreEmpresa") )
            {
               gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Nombreempresa = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Desde") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Desde = GXutil.nullDate() ;
                  gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Desde_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Desde_N = (byte)(0) ;
                  gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Desde = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Hasta") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Hasta = GXutil.nullDate() ;
                  gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Hasta_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Hasta_N = (byte)(0) ;
                  gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Hasta = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
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
         sName = "SDTProfesionalExperienciaLaboralProfesional" ;
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
      oWriter.writeElement("Id", GXutil.rtrim( gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Id.toString()));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("NombreEmpresa", GXutil.rtrim( gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Nombreempresa));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Desde)) && ( gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Desde_N == 1 ) )
      {
         oWriter.writeElement("Desde", "");
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Desde), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Desde), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Desde), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("Desde", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Hasta)) && ( gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Hasta_N == 1 ) )
      {
         oWriter.writeElement("Hasta", "");
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Hasta), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Hasta), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Hasta), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("Hasta", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      oWriter.writeEndElement();
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
      AddObjectProperty("Id", gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Id, false, false);
      AddObjectProperty("NombreEmpresa", gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Nombreempresa, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Desde), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Desde), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Desde), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("Desde", sDateCnv, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Hasta), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Hasta), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Hasta), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("Hasta", sDateCnv, false, false);
   }

   public java.util.UUID getgxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Id( )
   {
      return gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Id ;
   }

   public void setgxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Id( java.util.UUID value )
   {
      gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Id = value ;
   }

   public String getgxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Nombreempresa( )
   {
      return gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Nombreempresa ;
   }

   public void setgxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Nombreempresa( String value )
   {
      gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Nombreempresa = value ;
   }

   public java.util.Date getgxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Desde( )
   {
      return gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Desde ;
   }

   public void setgxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Desde( java.util.Date value )
   {
      gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Desde_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Desde = value ;
   }

   public java.util.Date getgxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Hasta( )
   {
      return gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Hasta ;
   }

   public void setgxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Hasta( java.util.Date value )
   {
      gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Hasta_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Hasta = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Id = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_N = (byte)(1) ;
      gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Nombreempresa = "" ;
      gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Desde = GXutil.nullDate() ;
      gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Desde_N = (byte)(1) ;
      gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Hasta = GXutil.nullDate() ;
      gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Hasta_N = (byte)(1) ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_N ;
   }

   public com.projectthani.SdtSDTProfesionalExperienciaLaboralProfesional Clone( )
   {
      return (com.projectthani.SdtSDTProfesionalExperienciaLaboralProfesional)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTProfesionalExperienciaLaboralProfesional struct )
   {
      setgxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Id(struct.getId());
      setgxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Nombreempresa(struct.getNombreempresa());
      if ( struct.gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Desde_N == 0 )
      {
         setgxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Desde(struct.getDesde());
      }
      if ( struct.gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Hasta_N == 0 )
      {
         setgxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Hasta(struct.getHasta());
      }
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTProfesionalExperienciaLaboralProfesional getStruct( )
   {
      com.projectthani.StructSdtSDTProfesionalExperienciaLaboralProfesional struct = new com.projectthani.StructSdtSDTProfesionalExperienciaLaboralProfesional ();
      struct.setId(getgxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Id());
      struct.setNombreempresa(getgxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Nombreempresa());
      if ( gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Desde_N == 0 )
      {
         struct.setDesde(getgxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Desde());
      }
      if ( gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Hasta_N == 0 )
      {
         struct.setHasta(getgxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Hasta());
      }
      return struct ;
   }

   protected byte gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_N ;
   protected byte gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Desde_N ;
   protected byte gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Hasta_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Desde ;
   protected java.util.Date gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Hasta ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Nombreempresa ;
   protected java.util.UUID gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Id ;
}

