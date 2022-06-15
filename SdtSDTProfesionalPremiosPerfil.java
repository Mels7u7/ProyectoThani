package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTProfesionalPremiosPerfil extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTProfesionalPremiosPerfil( )
   {
      this(  new ModelContext(SdtSDTProfesionalPremiosPerfil.class));
   }

   public SdtSDTProfesionalPremiosPerfil( ModelContext context )
   {
      super( context, "SdtSDTProfesionalPremiosPerfil");
   }

   public SdtSDTProfesionalPremiosPerfil( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTProfesionalPremiosPerfil");
   }

   public SdtSDTProfesionalPremiosPerfil( StructSdtSDTProfesionalPremiosPerfil struct )
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
               gxTv_SdtSDTProfesionalPremiosPerfil_Id = GXutil.strToGuid(oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Nombre") )
            {
               gxTv_SdtSDTProfesionalPremiosPerfil_Nombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Descripcion") )
            {
               gxTv_SdtSDTProfesionalPremiosPerfil_Descripcion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Fecha") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtSDTProfesionalPremiosPerfil_Fecha = GXutil.nullDate() ;
                  gxTv_SdtSDTProfesionalPremiosPerfil_Fecha_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtSDTProfesionalPremiosPerfil_Fecha_N = (byte)(0) ;
                  gxTv_SdtSDTProfesionalPremiosPerfil_Fecha = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
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
         sName = "SDTProfesionalPremiosPerfil" ;
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
      oWriter.writeElement("Id", GXutil.rtrim( gxTv_SdtSDTProfesionalPremiosPerfil_Id.toString()));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Nombre", GXutil.rtrim( gxTv_SdtSDTProfesionalPremiosPerfil_Nombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Descripcion", GXutil.rtrim( gxTv_SdtSDTProfesionalPremiosPerfil_Descripcion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_SdtSDTProfesionalPremiosPerfil_Fecha)) && ( gxTv_SdtSDTProfesionalPremiosPerfil_Fecha_N == 1 ) )
      {
         oWriter.writeElement("Fecha", "");
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTProfesionalPremiosPerfil_Fecha), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTProfesionalPremiosPerfil_Fecha), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTProfesionalPremiosPerfil_Fecha), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("Fecha", sDateCnv);
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
      AddObjectProperty("Id", gxTv_SdtSDTProfesionalPremiosPerfil_Id, false, false);
      AddObjectProperty("Nombre", gxTv_SdtSDTProfesionalPremiosPerfil_Nombre, false, false);
      AddObjectProperty("Descripcion", gxTv_SdtSDTProfesionalPremiosPerfil_Descripcion, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTProfesionalPremiosPerfil_Fecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTProfesionalPremiosPerfil_Fecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTProfesionalPremiosPerfil_Fecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("Fecha", sDateCnv, false, false);
   }

   public java.util.UUID getgxTv_SdtSDTProfesionalPremiosPerfil_Id( )
   {
      return gxTv_SdtSDTProfesionalPremiosPerfil_Id ;
   }

   public void setgxTv_SdtSDTProfesionalPremiosPerfil_Id( java.util.UUID value )
   {
      gxTv_SdtSDTProfesionalPremiosPerfil_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalPremiosPerfil_Id = value ;
   }

   public String getgxTv_SdtSDTProfesionalPremiosPerfil_Nombre( )
   {
      return gxTv_SdtSDTProfesionalPremiosPerfil_Nombre ;
   }

   public void setgxTv_SdtSDTProfesionalPremiosPerfil_Nombre( String value )
   {
      gxTv_SdtSDTProfesionalPremiosPerfil_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalPremiosPerfil_Nombre = value ;
   }

   public String getgxTv_SdtSDTProfesionalPremiosPerfil_Descripcion( )
   {
      return gxTv_SdtSDTProfesionalPremiosPerfil_Descripcion ;
   }

   public void setgxTv_SdtSDTProfesionalPremiosPerfil_Descripcion( String value )
   {
      gxTv_SdtSDTProfesionalPremiosPerfil_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalPremiosPerfil_Descripcion = value ;
   }

   public java.util.Date getgxTv_SdtSDTProfesionalPremiosPerfil_Fecha( )
   {
      return gxTv_SdtSDTProfesionalPremiosPerfil_Fecha ;
   }

   public void setgxTv_SdtSDTProfesionalPremiosPerfil_Fecha( java.util.Date value )
   {
      gxTv_SdtSDTProfesionalPremiosPerfil_Fecha_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalPremiosPerfil_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalPremiosPerfil_Fecha = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTProfesionalPremiosPerfil_Id = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      gxTv_SdtSDTProfesionalPremiosPerfil_N = (byte)(1) ;
      gxTv_SdtSDTProfesionalPremiosPerfil_Nombre = "" ;
      gxTv_SdtSDTProfesionalPremiosPerfil_Descripcion = "" ;
      gxTv_SdtSDTProfesionalPremiosPerfil_Fecha = GXutil.nullDate() ;
      gxTv_SdtSDTProfesionalPremiosPerfil_Fecha_N = (byte)(1) ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTProfesionalPremiosPerfil_N ;
   }

   public com.projectthani.SdtSDTProfesionalPremiosPerfil Clone( )
   {
      return (com.projectthani.SdtSDTProfesionalPremiosPerfil)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTProfesionalPremiosPerfil struct )
   {
      setgxTv_SdtSDTProfesionalPremiosPerfil_Id(struct.getId());
      setgxTv_SdtSDTProfesionalPremiosPerfil_Nombre(struct.getNombre());
      setgxTv_SdtSDTProfesionalPremiosPerfil_Descripcion(struct.getDescripcion());
      if ( struct.gxTv_SdtSDTProfesionalPremiosPerfil_Fecha_N == 0 )
      {
         setgxTv_SdtSDTProfesionalPremiosPerfil_Fecha(struct.getFecha());
      }
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTProfesionalPremiosPerfil getStruct( )
   {
      com.projectthani.StructSdtSDTProfesionalPremiosPerfil struct = new com.projectthani.StructSdtSDTProfesionalPremiosPerfil ();
      struct.setId(getgxTv_SdtSDTProfesionalPremiosPerfil_Id());
      struct.setNombre(getgxTv_SdtSDTProfesionalPremiosPerfil_Nombre());
      struct.setDescripcion(getgxTv_SdtSDTProfesionalPremiosPerfil_Descripcion());
      if ( gxTv_SdtSDTProfesionalPremiosPerfil_Fecha_N == 0 )
      {
         struct.setFecha(getgxTv_SdtSDTProfesionalPremiosPerfil_Fecha());
      }
      return struct ;
   }

   protected byte gxTv_SdtSDTProfesionalPremiosPerfil_N ;
   protected byte gxTv_SdtSDTProfesionalPremiosPerfil_Fecha_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_SdtSDTProfesionalPremiosPerfil_Fecha ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTProfesionalPremiosPerfil_Descripcion ;
   protected String gxTv_SdtSDTProfesionalPremiosPerfil_Nombre ;
   protected java.util.UUID gxTv_SdtSDTProfesionalPremiosPerfil_Id ;
}

