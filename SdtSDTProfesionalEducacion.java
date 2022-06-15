package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTProfesionalEducacion extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTProfesionalEducacion( )
   {
      this(  new ModelContext(SdtSDTProfesionalEducacion.class));
   }

   public SdtSDTProfesionalEducacion( ModelContext context )
   {
      super( context, "SdtSDTProfesionalEducacion");
   }

   public SdtSDTProfesionalEducacion( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTProfesionalEducacion");
   }

   public SdtSDTProfesionalEducacion( StructSdtSDTProfesionalEducacion struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "EducacionId") )
            {
               gxTv_SdtSDTProfesionalEducacion_Educacionid = GXutil.strToGuid(oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EducacionNombreInstitucion") )
            {
               gxTv_SdtSDTProfesionalEducacion_Educacionnombreinstitucion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EducacionDesde") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtSDTProfesionalEducacion_Educaciondesde = GXutil.nullDate() ;
                  gxTv_SdtSDTProfesionalEducacion_Educaciondesde_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtSDTProfesionalEducacion_Educaciondesde_N = (byte)(0) ;
                  gxTv_SdtSDTProfesionalEducacion_Educaciondesde = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EducacionHasta") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtSDTProfesionalEducacion_Educacionhasta = GXutil.nullDate() ;
                  gxTv_SdtSDTProfesionalEducacion_Educacionhasta_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtSDTProfesionalEducacion_Educacionhasta_N = (byte)(0) ;
                  gxTv_SdtSDTProfesionalEducacion_Educacionhasta = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EducacionPaisDescripcion") )
            {
               gxTv_SdtSDTProfesionalEducacion_Educacionpaisdescripcion = oReader.getValue() ;
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
         sName = "SDTProfesionalEducacion" ;
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
      oWriter.writeElement("EducacionId", GXutil.rtrim( gxTv_SdtSDTProfesionalEducacion_Educacionid.toString()));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("EducacionNombreInstitucion", GXutil.rtrim( gxTv_SdtSDTProfesionalEducacion_Educacionnombreinstitucion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_SdtSDTProfesionalEducacion_Educaciondesde)) && ( gxTv_SdtSDTProfesionalEducacion_Educaciondesde_N == 1 ) )
      {
         oWriter.writeElement("EducacionDesde", "");
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTProfesionalEducacion_Educaciondesde), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTProfesionalEducacion_Educaciondesde), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTProfesionalEducacion_Educaciondesde), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("EducacionDesde", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_SdtSDTProfesionalEducacion_Educacionhasta)) && ( gxTv_SdtSDTProfesionalEducacion_Educacionhasta_N == 1 ) )
      {
         oWriter.writeElement("EducacionHasta", "");
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTProfesionalEducacion_Educacionhasta), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTProfesionalEducacion_Educacionhasta), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTProfesionalEducacion_Educacionhasta), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("EducacionHasta", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      oWriter.writeElement("EducacionPaisDescripcion", GXutil.rtrim( gxTv_SdtSDTProfesionalEducacion_Educacionpaisdescripcion));
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
      AddObjectProperty("EducacionId", gxTv_SdtSDTProfesionalEducacion_Educacionid, false, false);
      AddObjectProperty("EducacionNombreInstitucion", gxTv_SdtSDTProfesionalEducacion_Educacionnombreinstitucion, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTProfesionalEducacion_Educaciondesde), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTProfesionalEducacion_Educaciondesde), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTProfesionalEducacion_Educaciondesde), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("EducacionDesde", sDateCnv, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTProfesionalEducacion_Educacionhasta), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTProfesionalEducacion_Educacionhasta), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTProfesionalEducacion_Educacionhasta), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("EducacionHasta", sDateCnv, false, false);
      AddObjectProperty("EducacionPaisDescripcion", gxTv_SdtSDTProfesionalEducacion_Educacionpaisdescripcion, false, false);
   }

   public java.util.UUID getgxTv_SdtSDTProfesionalEducacion_Educacionid( )
   {
      return gxTv_SdtSDTProfesionalEducacion_Educacionid ;
   }

   public void setgxTv_SdtSDTProfesionalEducacion_Educacionid( java.util.UUID value )
   {
      gxTv_SdtSDTProfesionalEducacion_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEducacion_Educacionid = value ;
   }

   public String getgxTv_SdtSDTProfesionalEducacion_Educacionnombreinstitucion( )
   {
      return gxTv_SdtSDTProfesionalEducacion_Educacionnombreinstitucion ;
   }

   public void setgxTv_SdtSDTProfesionalEducacion_Educacionnombreinstitucion( String value )
   {
      gxTv_SdtSDTProfesionalEducacion_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEducacion_Educacionnombreinstitucion = value ;
   }

   public java.util.Date getgxTv_SdtSDTProfesionalEducacion_Educaciondesde( )
   {
      return gxTv_SdtSDTProfesionalEducacion_Educaciondesde ;
   }

   public void setgxTv_SdtSDTProfesionalEducacion_Educaciondesde( java.util.Date value )
   {
      gxTv_SdtSDTProfesionalEducacion_Educaciondesde_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEducacion_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEducacion_Educaciondesde = value ;
   }

   public java.util.Date getgxTv_SdtSDTProfesionalEducacion_Educacionhasta( )
   {
      return gxTv_SdtSDTProfesionalEducacion_Educacionhasta ;
   }

   public void setgxTv_SdtSDTProfesionalEducacion_Educacionhasta( java.util.Date value )
   {
      gxTv_SdtSDTProfesionalEducacion_Educacionhasta_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEducacion_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEducacion_Educacionhasta = value ;
   }

   public String getgxTv_SdtSDTProfesionalEducacion_Educacionpaisdescripcion( )
   {
      return gxTv_SdtSDTProfesionalEducacion_Educacionpaisdescripcion ;
   }

   public void setgxTv_SdtSDTProfesionalEducacion_Educacionpaisdescripcion( String value )
   {
      gxTv_SdtSDTProfesionalEducacion_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEducacion_Educacionpaisdescripcion = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTProfesionalEducacion_Educacionid = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      gxTv_SdtSDTProfesionalEducacion_N = (byte)(1) ;
      gxTv_SdtSDTProfesionalEducacion_Educacionnombreinstitucion = "" ;
      gxTv_SdtSDTProfesionalEducacion_Educaciondesde = GXutil.nullDate() ;
      gxTv_SdtSDTProfesionalEducacion_Educaciondesde_N = (byte)(1) ;
      gxTv_SdtSDTProfesionalEducacion_Educacionhasta = GXutil.nullDate() ;
      gxTv_SdtSDTProfesionalEducacion_Educacionhasta_N = (byte)(1) ;
      gxTv_SdtSDTProfesionalEducacion_Educacionpaisdescripcion = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTProfesionalEducacion_N ;
   }

   public com.projectthani.SdtSDTProfesionalEducacion Clone( )
   {
      return (com.projectthani.SdtSDTProfesionalEducacion)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTProfesionalEducacion struct )
   {
      setgxTv_SdtSDTProfesionalEducacion_Educacionid(struct.getEducacionid());
      setgxTv_SdtSDTProfesionalEducacion_Educacionnombreinstitucion(struct.getEducacionnombreinstitucion());
      if ( struct.gxTv_SdtSDTProfesionalEducacion_Educaciondesde_N == 0 )
      {
         setgxTv_SdtSDTProfesionalEducacion_Educaciondesde(struct.getEducaciondesde());
      }
      if ( struct.gxTv_SdtSDTProfesionalEducacion_Educacionhasta_N == 0 )
      {
         setgxTv_SdtSDTProfesionalEducacion_Educacionhasta(struct.getEducacionhasta());
      }
      setgxTv_SdtSDTProfesionalEducacion_Educacionpaisdescripcion(struct.getEducacionpaisdescripcion());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTProfesionalEducacion getStruct( )
   {
      com.projectthani.StructSdtSDTProfesionalEducacion struct = new com.projectthani.StructSdtSDTProfesionalEducacion ();
      struct.setEducacionid(getgxTv_SdtSDTProfesionalEducacion_Educacionid());
      struct.setEducacionnombreinstitucion(getgxTv_SdtSDTProfesionalEducacion_Educacionnombreinstitucion());
      if ( gxTv_SdtSDTProfesionalEducacion_Educaciondesde_N == 0 )
      {
         struct.setEducaciondesde(getgxTv_SdtSDTProfesionalEducacion_Educaciondesde());
      }
      if ( gxTv_SdtSDTProfesionalEducacion_Educacionhasta_N == 0 )
      {
         struct.setEducacionhasta(getgxTv_SdtSDTProfesionalEducacion_Educacionhasta());
      }
      struct.setEducacionpaisdescripcion(getgxTv_SdtSDTProfesionalEducacion_Educacionpaisdescripcion());
      return struct ;
   }

   protected byte gxTv_SdtSDTProfesionalEducacion_N ;
   protected byte gxTv_SdtSDTProfesionalEducacion_Educaciondesde_N ;
   protected byte gxTv_SdtSDTProfesionalEducacion_Educacionhasta_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_SdtSDTProfesionalEducacion_Educaciondesde ;
   protected java.util.Date gxTv_SdtSDTProfesionalEducacion_Educacionhasta ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTProfesionalEducacion_Educacionnombreinstitucion ;
   protected String gxTv_SdtSDTProfesionalEducacion_Educacionpaisdescripcion ;
   protected java.util.UUID gxTv_SdtSDTProfesionalEducacion_Educacionid ;
}

