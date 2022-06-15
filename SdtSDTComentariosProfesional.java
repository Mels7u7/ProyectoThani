package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTComentariosProfesional extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTComentariosProfesional( )
   {
      this(  new ModelContext(SdtSDTComentariosProfesional.class));
   }

   public SdtSDTComentariosProfesional( ModelContext context )
   {
      super( context, "SdtSDTComentariosProfesional");
   }

   public SdtSDTComentariosProfesional( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTComentariosProfesional");
   }

   public SdtSDTComentariosProfesional( StructSdtSDTComentariosProfesional struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ComentarioId") )
            {
               gxTv_SdtSDTComentariosProfesional_Comentarioid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteId") )
            {
               gxTv_SdtSDTComentariosProfesional_Pacienteid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalId") )
            {
               gxTv_SdtSDTComentariosProfesional_Profesionalid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CitaId") )
            {
               gxTv_SdtSDTComentariosProfesional_Citaid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Comentario") )
            {
               gxTv_SdtSDTComentariosProfesional_Comentario = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FechaRegistro") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtSDTComentariosProfesional_Fecharegistro = GXutil.nullDate() ;
                  gxTv_SdtSDTComentariosProfesional_Fecharegistro_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtSDTComentariosProfesional_Fecharegistro_N = (byte)(0) ;
                  gxTv_SdtSDTComentariosProfesional_Fecharegistro = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
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
         sName = "SDTComentariosProfesional" ;
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
      oWriter.writeElement("ComentarioId", GXutil.trim( GXutil.str( gxTv_SdtSDTComentariosProfesional_Comentarioid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PacienteId", GXutil.trim( GXutil.str( gxTv_SdtSDTComentariosProfesional_Pacienteid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalId", GXutil.trim( GXutil.str( gxTv_SdtSDTComentariosProfesional_Profesionalid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CitaId", GXutil.trim( GXutil.str( gxTv_SdtSDTComentariosProfesional_Citaid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Comentario", GXutil.rtrim( gxTv_SdtSDTComentariosProfesional_Comentario));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_SdtSDTComentariosProfesional_Fecharegistro)) && ( gxTv_SdtSDTComentariosProfesional_Fecharegistro_N == 1 ) )
      {
         oWriter.writeElement("FechaRegistro", "");
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTComentariosProfesional_Fecharegistro), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTComentariosProfesional_Fecharegistro), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTComentariosProfesional_Fecharegistro), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("FechaRegistro", sDateCnv);
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
      AddObjectProperty("ComentarioId", gxTv_SdtSDTComentariosProfesional_Comentarioid, false, false);
      AddObjectProperty("PacienteId", gxTv_SdtSDTComentariosProfesional_Pacienteid, false, false);
      AddObjectProperty("ProfesionalId", gxTv_SdtSDTComentariosProfesional_Profesionalid, false, false);
      AddObjectProperty("CitaId", gxTv_SdtSDTComentariosProfesional_Citaid, false, false);
      AddObjectProperty("Comentario", gxTv_SdtSDTComentariosProfesional_Comentario, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTComentariosProfesional_Fecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTComentariosProfesional_Fecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTComentariosProfesional_Fecharegistro), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("FechaRegistro", sDateCnv, false, false);
   }

   public int getgxTv_SdtSDTComentariosProfesional_Comentarioid( )
   {
      return gxTv_SdtSDTComentariosProfesional_Comentarioid ;
   }

   public void setgxTv_SdtSDTComentariosProfesional_Comentarioid( int value )
   {
      gxTv_SdtSDTComentariosProfesional_N = (byte)(0) ;
      gxTv_SdtSDTComentariosProfesional_Comentarioid = value ;
   }

   public int getgxTv_SdtSDTComentariosProfesional_Pacienteid( )
   {
      return gxTv_SdtSDTComentariosProfesional_Pacienteid ;
   }

   public void setgxTv_SdtSDTComentariosProfesional_Pacienteid( int value )
   {
      gxTv_SdtSDTComentariosProfesional_N = (byte)(0) ;
      gxTv_SdtSDTComentariosProfesional_Pacienteid = value ;
   }

   public int getgxTv_SdtSDTComentariosProfesional_Profesionalid( )
   {
      return gxTv_SdtSDTComentariosProfesional_Profesionalid ;
   }

   public void setgxTv_SdtSDTComentariosProfesional_Profesionalid( int value )
   {
      gxTv_SdtSDTComentariosProfesional_N = (byte)(0) ;
      gxTv_SdtSDTComentariosProfesional_Profesionalid = value ;
   }

   public int getgxTv_SdtSDTComentariosProfesional_Citaid( )
   {
      return gxTv_SdtSDTComentariosProfesional_Citaid ;
   }

   public void setgxTv_SdtSDTComentariosProfesional_Citaid( int value )
   {
      gxTv_SdtSDTComentariosProfesional_N = (byte)(0) ;
      gxTv_SdtSDTComentariosProfesional_Citaid = value ;
   }

   public String getgxTv_SdtSDTComentariosProfesional_Comentario( )
   {
      return gxTv_SdtSDTComentariosProfesional_Comentario ;
   }

   public void setgxTv_SdtSDTComentariosProfesional_Comentario( String value )
   {
      gxTv_SdtSDTComentariosProfesional_N = (byte)(0) ;
      gxTv_SdtSDTComentariosProfesional_Comentario = value ;
   }

   public java.util.Date getgxTv_SdtSDTComentariosProfesional_Fecharegistro( )
   {
      return gxTv_SdtSDTComentariosProfesional_Fecharegistro ;
   }

   public void setgxTv_SdtSDTComentariosProfesional_Fecharegistro( java.util.Date value )
   {
      gxTv_SdtSDTComentariosProfesional_Fecharegistro_N = (byte)(0) ;
      gxTv_SdtSDTComentariosProfesional_N = (byte)(0) ;
      gxTv_SdtSDTComentariosProfesional_Fecharegistro = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTComentariosProfesional_N = (byte)(1) ;
      gxTv_SdtSDTComentariosProfesional_Comentario = "" ;
      gxTv_SdtSDTComentariosProfesional_Fecharegistro = GXutil.nullDate() ;
      gxTv_SdtSDTComentariosProfesional_Fecharegistro_N = (byte)(1) ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTComentariosProfesional_N ;
   }

   public com.projectthani.SdtSDTComentariosProfesional Clone( )
   {
      return (com.projectthani.SdtSDTComentariosProfesional)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTComentariosProfesional struct )
   {
      setgxTv_SdtSDTComentariosProfesional_Comentarioid(struct.getComentarioid());
      setgxTv_SdtSDTComentariosProfesional_Pacienteid(struct.getPacienteid());
      setgxTv_SdtSDTComentariosProfesional_Profesionalid(struct.getProfesionalid());
      setgxTv_SdtSDTComentariosProfesional_Citaid(struct.getCitaid());
      setgxTv_SdtSDTComentariosProfesional_Comentario(struct.getComentario());
      if ( struct.gxTv_SdtSDTComentariosProfesional_Fecharegistro_N == 0 )
      {
         setgxTv_SdtSDTComentariosProfesional_Fecharegistro(struct.getFecharegistro());
      }
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTComentariosProfesional getStruct( )
   {
      com.projectthani.StructSdtSDTComentariosProfesional struct = new com.projectthani.StructSdtSDTComentariosProfesional ();
      struct.setComentarioid(getgxTv_SdtSDTComentariosProfesional_Comentarioid());
      struct.setPacienteid(getgxTv_SdtSDTComentariosProfesional_Pacienteid());
      struct.setProfesionalid(getgxTv_SdtSDTComentariosProfesional_Profesionalid());
      struct.setCitaid(getgxTv_SdtSDTComentariosProfesional_Citaid());
      struct.setComentario(getgxTv_SdtSDTComentariosProfesional_Comentario());
      if ( gxTv_SdtSDTComentariosProfesional_Fecharegistro_N == 0 )
      {
         struct.setFecharegistro(getgxTv_SdtSDTComentariosProfesional_Fecharegistro());
      }
      return struct ;
   }

   protected byte gxTv_SdtSDTComentariosProfesional_N ;
   protected byte gxTv_SdtSDTComentariosProfesional_Fecharegistro_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_SdtSDTComentariosProfesional_Comentarioid ;
   protected int gxTv_SdtSDTComentariosProfesional_Pacienteid ;
   protected int gxTv_SdtSDTComentariosProfesional_Profesionalid ;
   protected int gxTv_SdtSDTComentariosProfesional_Citaid ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_SdtSDTComentariosProfesional_Fecharegistro ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTComentariosProfesional_Comentario ;
}

