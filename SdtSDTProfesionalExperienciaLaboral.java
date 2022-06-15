package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTProfesionalExperienciaLaboral extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTProfesionalExperienciaLaboral( )
   {
      this(  new ModelContext(SdtSDTProfesionalExperienciaLaboral.class));
   }

   public SdtSDTProfesionalExperienciaLaboral( ModelContext context )
   {
      super( context, "SdtSDTProfesionalExperienciaLaboral");
   }

   public SdtSDTProfesionalExperienciaLaboral( int remoteHandle ,
                                               ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTProfesionalExperienciaLaboral");
   }

   public SdtSDTProfesionalExperienciaLaboral( StructSdtSDTProfesionalExperienciaLaboral struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ExperienciaLaboralId") )
            {
               gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralid = GXutil.strToGuid(oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ExperienciaLaboralEmpresaNombre") )
            {
               gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralempresanombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ExperienciaLaboralDesde") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboraldesde = GXutil.nullDate() ;
                  gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboraldesde_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboraldesde_N = (byte)(0) ;
                  gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboraldesde = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ExperienciaLaboralHasta") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralhasta = GXutil.nullDate() ;
                  gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralhasta_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralhasta_N = (byte)(0) ;
                  gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralhasta = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
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
         sName = "SDTProfesionalExperienciaLaboral" ;
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
      oWriter.writeElement("ExperienciaLaboralId", GXutil.rtrim( gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralid.toString()));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ExperienciaLaboralEmpresaNombre", GXutil.rtrim( gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralempresanombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboraldesde)) && ( gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboraldesde_N == 1 ) )
      {
         oWriter.writeElement("ExperienciaLaboralDesde", "");
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboraldesde), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboraldesde), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboraldesde), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("ExperienciaLaboralDesde", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralhasta)) && ( gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralhasta_N == 1 ) )
      {
         oWriter.writeElement("ExperienciaLaboralHasta", "");
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralhasta), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralhasta), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralhasta), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("ExperienciaLaboralHasta", sDateCnv);
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
      AddObjectProperty("ExperienciaLaboralId", gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralid, false, false);
      AddObjectProperty("ExperienciaLaboralEmpresaNombre", gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralempresanombre, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboraldesde), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboraldesde), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboraldesde), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("ExperienciaLaboralDesde", sDateCnv, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralhasta), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralhasta), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralhasta), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("ExperienciaLaboralHasta", sDateCnv, false, false);
   }

   public java.util.UUID getgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralid( )
   {
      return gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralid ;
   }

   public void setgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralid( java.util.UUID value )
   {
      gxTv_SdtSDTProfesionalExperienciaLaboral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralid = value ;
   }

   public String getgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralempresanombre( )
   {
      return gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralempresanombre ;
   }

   public void setgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralempresanombre( String value )
   {
      gxTv_SdtSDTProfesionalExperienciaLaboral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralempresanombre = value ;
   }

   public java.util.Date getgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboraldesde( )
   {
      return gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboraldesde ;
   }

   public void setgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboraldesde( java.util.Date value )
   {
      gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboraldesde_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalExperienciaLaboral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboraldesde = value ;
   }

   public java.util.Date getgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralhasta( )
   {
      return gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralhasta ;
   }

   public void setgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralhasta( java.util.Date value )
   {
      gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralhasta_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalExperienciaLaboral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralhasta = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralid = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      gxTv_SdtSDTProfesionalExperienciaLaboral_N = (byte)(1) ;
      gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralempresanombre = "" ;
      gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboraldesde = GXutil.nullDate() ;
      gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboraldesde_N = (byte)(1) ;
      gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralhasta = GXutil.nullDate() ;
      gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralhasta_N = (byte)(1) ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTProfesionalExperienciaLaboral_N ;
   }

   public com.projectthani.SdtSDTProfesionalExperienciaLaboral Clone( )
   {
      return (com.projectthani.SdtSDTProfesionalExperienciaLaboral)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTProfesionalExperienciaLaboral struct )
   {
      setgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralid(struct.getExperiencialaboralid());
      setgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralempresanombre(struct.getExperiencialaboralempresanombre());
      if ( struct.gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboraldesde_N == 0 )
      {
         setgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboraldesde(struct.getExperiencialaboraldesde());
      }
      if ( struct.gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralhasta_N == 0 )
      {
         setgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralhasta(struct.getExperiencialaboralhasta());
      }
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTProfesionalExperienciaLaboral getStruct( )
   {
      com.projectthani.StructSdtSDTProfesionalExperienciaLaboral struct = new com.projectthani.StructSdtSDTProfesionalExperienciaLaboral ();
      struct.setExperiencialaboralid(getgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralid());
      struct.setExperiencialaboralempresanombre(getgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralempresanombre());
      if ( gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboraldesde_N == 0 )
      {
         struct.setExperiencialaboraldesde(getgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboraldesde());
      }
      if ( gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralhasta_N == 0 )
      {
         struct.setExperiencialaboralhasta(getgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralhasta());
      }
      return struct ;
   }

   protected byte gxTv_SdtSDTProfesionalExperienciaLaboral_N ;
   protected byte gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboraldesde_N ;
   protected byte gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralhasta_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboraldesde ;
   protected java.util.Date gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralhasta ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralempresanombre ;
   protected java.util.UUID gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralid ;
}

