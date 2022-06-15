package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTProfesionalEducacionPerfil extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTProfesionalEducacionPerfil( )
   {
      this(  new ModelContext(SdtSDTProfesionalEducacionPerfil.class));
   }

   public SdtSDTProfesionalEducacionPerfil( ModelContext context )
   {
      super( context, "SdtSDTProfesionalEducacionPerfil");
   }

   public SdtSDTProfesionalEducacionPerfil( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTProfesionalEducacionPerfil");
   }

   public SdtSDTProfesionalEducacionPerfil( StructSdtSDTProfesionalEducacionPerfil struct )
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
               gxTv_SdtSDTProfesionalEducacionPerfil_Id = GXutil.strToGuid(oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "NombreInstitucion") )
            {
               gxTv_SdtSDTProfesionalEducacionPerfil_Nombreinstitucion = oReader.getValue() ;
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
                  gxTv_SdtSDTProfesionalEducacionPerfil_Desde = GXutil.nullDate() ;
                  gxTv_SdtSDTProfesionalEducacionPerfil_Desde_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtSDTProfesionalEducacionPerfil_Desde_N = (byte)(0) ;
                  gxTv_SdtSDTProfesionalEducacionPerfil_Desde = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
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
                  gxTv_SdtSDTProfesionalEducacionPerfil_Hasta = GXutil.nullDate() ;
                  gxTv_SdtSDTProfesionalEducacionPerfil_Hasta_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtSDTProfesionalEducacionPerfil_Hasta_N = (byte)(0) ;
                  gxTv_SdtSDTProfesionalEducacionPerfil_Hasta = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaisNombre") )
            {
               gxTv_SdtSDTProfesionalEducacionPerfil_Paisnombre = oReader.getValue() ;
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
         sName = "SDTProfesionalEducacionPerfil" ;
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
      oWriter.writeElement("Id", GXutil.rtrim( gxTv_SdtSDTProfesionalEducacionPerfil_Id.toString()));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("NombreInstitucion", GXutil.rtrim( gxTv_SdtSDTProfesionalEducacionPerfil_Nombreinstitucion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_SdtSDTProfesionalEducacionPerfil_Desde)) && ( gxTv_SdtSDTProfesionalEducacionPerfil_Desde_N == 1 ) )
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
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTProfesionalEducacionPerfil_Desde), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTProfesionalEducacionPerfil_Desde), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTProfesionalEducacionPerfil_Desde), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("Desde", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_SdtSDTProfesionalEducacionPerfil_Hasta)) && ( gxTv_SdtSDTProfesionalEducacionPerfil_Hasta_N == 1 ) )
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
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTProfesionalEducacionPerfil_Hasta), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTProfesionalEducacionPerfil_Hasta), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTProfesionalEducacionPerfil_Hasta), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("Hasta", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      oWriter.writeElement("PaisNombre", GXutil.rtrim( gxTv_SdtSDTProfesionalEducacionPerfil_Paisnombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
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
      AddObjectProperty("Id", gxTv_SdtSDTProfesionalEducacionPerfil_Id, false, false);
      AddObjectProperty("NombreInstitucion", gxTv_SdtSDTProfesionalEducacionPerfil_Nombreinstitucion, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTProfesionalEducacionPerfil_Desde), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTProfesionalEducacionPerfil_Desde), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTProfesionalEducacionPerfil_Desde), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("Desde", sDateCnv, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTProfesionalEducacionPerfil_Hasta), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTProfesionalEducacionPerfil_Hasta), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTProfesionalEducacionPerfil_Hasta), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("Hasta", sDateCnv, false, false);
      AddObjectProperty("PaisNombre", gxTv_SdtSDTProfesionalEducacionPerfil_Paisnombre, false, false);
   }

   public java.util.UUID getgxTv_SdtSDTProfesionalEducacionPerfil_Id( )
   {
      return gxTv_SdtSDTProfesionalEducacionPerfil_Id ;
   }

   public void setgxTv_SdtSDTProfesionalEducacionPerfil_Id( java.util.UUID value )
   {
      gxTv_SdtSDTProfesionalEducacionPerfil_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEducacionPerfil_Id = value ;
   }

   public String getgxTv_SdtSDTProfesionalEducacionPerfil_Nombreinstitucion( )
   {
      return gxTv_SdtSDTProfesionalEducacionPerfil_Nombreinstitucion ;
   }

   public void setgxTv_SdtSDTProfesionalEducacionPerfil_Nombreinstitucion( String value )
   {
      gxTv_SdtSDTProfesionalEducacionPerfil_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEducacionPerfil_Nombreinstitucion = value ;
   }

   public java.util.Date getgxTv_SdtSDTProfesionalEducacionPerfil_Desde( )
   {
      return gxTv_SdtSDTProfesionalEducacionPerfil_Desde ;
   }

   public void setgxTv_SdtSDTProfesionalEducacionPerfil_Desde( java.util.Date value )
   {
      gxTv_SdtSDTProfesionalEducacionPerfil_Desde_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEducacionPerfil_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEducacionPerfil_Desde = value ;
   }

   public java.util.Date getgxTv_SdtSDTProfesionalEducacionPerfil_Hasta( )
   {
      return gxTv_SdtSDTProfesionalEducacionPerfil_Hasta ;
   }

   public void setgxTv_SdtSDTProfesionalEducacionPerfil_Hasta( java.util.Date value )
   {
      gxTv_SdtSDTProfesionalEducacionPerfil_Hasta_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEducacionPerfil_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEducacionPerfil_Hasta = value ;
   }

   public String getgxTv_SdtSDTProfesionalEducacionPerfil_Paisnombre( )
   {
      return gxTv_SdtSDTProfesionalEducacionPerfil_Paisnombre ;
   }

   public void setgxTv_SdtSDTProfesionalEducacionPerfil_Paisnombre( String value )
   {
      gxTv_SdtSDTProfesionalEducacionPerfil_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEducacionPerfil_Paisnombre = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTProfesionalEducacionPerfil_Id = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      gxTv_SdtSDTProfesionalEducacionPerfil_N = (byte)(1) ;
      gxTv_SdtSDTProfesionalEducacionPerfil_Nombreinstitucion = "" ;
      gxTv_SdtSDTProfesionalEducacionPerfil_Desde = GXutil.nullDate() ;
      gxTv_SdtSDTProfesionalEducacionPerfil_Desde_N = (byte)(1) ;
      gxTv_SdtSDTProfesionalEducacionPerfil_Hasta = GXutil.nullDate() ;
      gxTv_SdtSDTProfesionalEducacionPerfil_Hasta_N = (byte)(1) ;
      gxTv_SdtSDTProfesionalEducacionPerfil_Paisnombre = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTProfesionalEducacionPerfil_N ;
   }

   public com.projectthani.SdtSDTProfesionalEducacionPerfil Clone( )
   {
      return (com.projectthani.SdtSDTProfesionalEducacionPerfil)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTProfesionalEducacionPerfil struct )
   {
      setgxTv_SdtSDTProfesionalEducacionPerfil_Id(struct.getId());
      setgxTv_SdtSDTProfesionalEducacionPerfil_Nombreinstitucion(struct.getNombreinstitucion());
      if ( struct.gxTv_SdtSDTProfesionalEducacionPerfil_Desde_N == 0 )
      {
         setgxTv_SdtSDTProfesionalEducacionPerfil_Desde(struct.getDesde());
      }
      if ( struct.gxTv_SdtSDTProfesionalEducacionPerfil_Hasta_N == 0 )
      {
         setgxTv_SdtSDTProfesionalEducacionPerfil_Hasta(struct.getHasta());
      }
      setgxTv_SdtSDTProfesionalEducacionPerfil_Paisnombre(struct.getPaisnombre());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTProfesionalEducacionPerfil getStruct( )
   {
      com.projectthani.StructSdtSDTProfesionalEducacionPerfil struct = new com.projectthani.StructSdtSDTProfesionalEducacionPerfil ();
      struct.setId(getgxTv_SdtSDTProfesionalEducacionPerfil_Id());
      struct.setNombreinstitucion(getgxTv_SdtSDTProfesionalEducacionPerfil_Nombreinstitucion());
      if ( gxTv_SdtSDTProfesionalEducacionPerfil_Desde_N == 0 )
      {
         struct.setDesde(getgxTv_SdtSDTProfesionalEducacionPerfil_Desde());
      }
      if ( gxTv_SdtSDTProfesionalEducacionPerfil_Hasta_N == 0 )
      {
         struct.setHasta(getgxTv_SdtSDTProfesionalEducacionPerfil_Hasta());
      }
      struct.setPaisnombre(getgxTv_SdtSDTProfesionalEducacionPerfil_Paisnombre());
      return struct ;
   }

   protected byte gxTv_SdtSDTProfesionalEducacionPerfil_N ;
   protected byte gxTv_SdtSDTProfesionalEducacionPerfil_Desde_N ;
   protected byte gxTv_SdtSDTProfesionalEducacionPerfil_Hasta_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_SdtSDTProfesionalEducacionPerfil_Desde ;
   protected java.util.Date gxTv_SdtSDTProfesionalEducacionPerfil_Hasta ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTProfesionalEducacionPerfil_Nombreinstitucion ;
   protected String gxTv_SdtSDTProfesionalEducacionPerfil_Paisnombre ;
   protected java.util.UUID gxTv_SdtSDTProfesionalEducacionPerfil_Id ;
}

