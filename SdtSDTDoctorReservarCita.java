package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTDoctorReservarCita extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTDoctorReservarCita( )
   {
      this(  new ModelContext(SdtSDTDoctorReservarCita.class));
   }

   public SdtSDTDoctorReservarCita( ModelContext context )
   {
      super( context, "SdtSDTDoctorReservarCita");
   }

   public SdtSDTDoctorReservarCita( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTDoctorReservarCita");
   }

   public SdtSDTDoctorReservarCita( StructSdtSDTDoctorReservarCita struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalNombreCompleto") )
            {
               gxTv_SdtSDTDoctorReservarCita_Profesionalnombrecompleto = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EspecialidadNombre") )
            {
               gxTv_SdtSDTDoctorReservarCita_Especialidadnombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalFoto") )
            {
               gxTv_SdtSDTDoctorReservarCita_Profesionalfoto = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalFoto_GXI") )
            {
               gxTv_SdtSDTDoctorReservarCita_Profesionalfoto_gxi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Calificacion") )
            {
               gxTv_SdtSDTDoctorReservarCita_Calificacion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProfesionalId") )
            {
               gxTv_SdtSDTDoctorReservarCita_Profesionalid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Direccion") )
            {
               gxTv_SdtSDTDoctorReservarCita_Direccion = oReader.getValue() ;
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
         sName = "SDTDoctorReservarCita" ;
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
      oWriter.writeElement("ProfesionalNombreCompleto", GXutil.rtrim( gxTv_SdtSDTDoctorReservarCita_Profesionalnombrecompleto));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("EspecialidadNombre", GXutil.rtrim( gxTv_SdtSDTDoctorReservarCita_Especialidadnombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalFoto", GXutil.rtrim( gxTv_SdtSDTDoctorReservarCita_Profesionalfoto));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalFoto_GXI", GXutil.rtrim( gxTv_SdtSDTDoctorReservarCita_Profesionalfoto_gxi));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Calificacion", GXutil.rtrim( gxTv_SdtSDTDoctorReservarCita_Calificacion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ProfesionalId", GXutil.trim( GXutil.str( gxTv_SdtSDTDoctorReservarCita_Profesionalid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Direccion", GXutil.rtrim( gxTv_SdtSDTDoctorReservarCita_Direccion));
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
      AddObjectProperty("ProfesionalNombreCompleto", gxTv_SdtSDTDoctorReservarCita_Profesionalnombrecompleto, false, false);
      AddObjectProperty("EspecialidadNombre", gxTv_SdtSDTDoctorReservarCita_Especialidadnombre, false, false);
      AddObjectProperty("ProfesionalFoto", gxTv_SdtSDTDoctorReservarCita_Profesionalfoto, false, false);
      AddObjectProperty("ProfesionalFoto_GXI", gxTv_SdtSDTDoctorReservarCita_Profesionalfoto_gxi, false, false);
      AddObjectProperty("Calificacion", gxTv_SdtSDTDoctorReservarCita_Calificacion, false, false);
      AddObjectProperty("ProfesionalId", gxTv_SdtSDTDoctorReservarCita_Profesionalid, false, false);
      AddObjectProperty("Direccion", gxTv_SdtSDTDoctorReservarCita_Direccion, false, false);
   }

   public String getgxTv_SdtSDTDoctorReservarCita_Profesionalnombrecompleto( )
   {
      return gxTv_SdtSDTDoctorReservarCita_Profesionalnombrecompleto ;
   }

   public void setgxTv_SdtSDTDoctorReservarCita_Profesionalnombrecompleto( String value )
   {
      gxTv_SdtSDTDoctorReservarCita_N = (byte)(0) ;
      gxTv_SdtSDTDoctorReservarCita_Profesionalnombrecompleto = value ;
   }

   public String getgxTv_SdtSDTDoctorReservarCita_Especialidadnombre( )
   {
      return gxTv_SdtSDTDoctorReservarCita_Especialidadnombre ;
   }

   public void setgxTv_SdtSDTDoctorReservarCita_Especialidadnombre( String value )
   {
      gxTv_SdtSDTDoctorReservarCita_N = (byte)(0) ;
      gxTv_SdtSDTDoctorReservarCita_Especialidadnombre = value ;
   }

   @GxUpload
   public String getgxTv_SdtSDTDoctorReservarCita_Profesionalfoto( )
   {
      return gxTv_SdtSDTDoctorReservarCita_Profesionalfoto ;
   }

   public void setgxTv_SdtSDTDoctorReservarCita_Profesionalfoto( String value )
   {
      gxTv_SdtSDTDoctorReservarCita_N = (byte)(0) ;
      gxTv_SdtSDTDoctorReservarCita_Profesionalfoto = value ;
   }

   public String getgxTv_SdtSDTDoctorReservarCita_Profesionalfoto_gxi( )
   {
      return gxTv_SdtSDTDoctorReservarCita_Profesionalfoto_gxi ;
   }

   public void setgxTv_SdtSDTDoctorReservarCita_Profesionalfoto_gxi( String value )
   {
      gxTv_SdtSDTDoctorReservarCita_N = (byte)(0) ;
      gxTv_SdtSDTDoctorReservarCita_Profesionalfoto_gxi = value ;
   }

   public String getgxTv_SdtSDTDoctorReservarCita_Calificacion( )
   {
      return gxTv_SdtSDTDoctorReservarCita_Calificacion ;
   }

   public void setgxTv_SdtSDTDoctorReservarCita_Calificacion( String value )
   {
      gxTv_SdtSDTDoctorReservarCita_N = (byte)(0) ;
      gxTv_SdtSDTDoctorReservarCita_Calificacion = value ;
   }

   public int getgxTv_SdtSDTDoctorReservarCita_Profesionalid( )
   {
      return gxTv_SdtSDTDoctorReservarCita_Profesionalid ;
   }

   public void setgxTv_SdtSDTDoctorReservarCita_Profesionalid( int value )
   {
      gxTv_SdtSDTDoctorReservarCita_N = (byte)(0) ;
      gxTv_SdtSDTDoctorReservarCita_Profesionalid = value ;
   }

   public String getgxTv_SdtSDTDoctorReservarCita_Direccion( )
   {
      return gxTv_SdtSDTDoctorReservarCita_Direccion ;
   }

   public void setgxTv_SdtSDTDoctorReservarCita_Direccion( String value )
   {
      gxTv_SdtSDTDoctorReservarCita_N = (byte)(0) ;
      gxTv_SdtSDTDoctorReservarCita_Direccion = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTDoctorReservarCita_Profesionalnombrecompleto = "" ;
      gxTv_SdtSDTDoctorReservarCita_N = (byte)(1) ;
      gxTv_SdtSDTDoctorReservarCita_Especialidadnombre = "" ;
      gxTv_SdtSDTDoctorReservarCita_Profesionalfoto = "" ;
      gxTv_SdtSDTDoctorReservarCita_Profesionalfoto_gxi = "" ;
      gxTv_SdtSDTDoctorReservarCita_Calificacion = "" ;
      gxTv_SdtSDTDoctorReservarCita_Direccion = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTDoctorReservarCita_N ;
   }

   public com.projectthani.SdtSDTDoctorReservarCita Clone( )
   {
      return (com.projectthani.SdtSDTDoctorReservarCita)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTDoctorReservarCita struct )
   {
      setgxTv_SdtSDTDoctorReservarCita_Profesionalnombrecompleto(struct.getProfesionalnombrecompleto());
      setgxTv_SdtSDTDoctorReservarCita_Especialidadnombre(struct.getEspecialidadnombre());
      setgxTv_SdtSDTDoctorReservarCita_Profesionalfoto(struct.getProfesionalfoto());
      setgxTv_SdtSDTDoctorReservarCita_Profesionalfoto_gxi(struct.getProfesionalfoto_gxi());
      setgxTv_SdtSDTDoctorReservarCita_Calificacion(struct.getCalificacion());
      setgxTv_SdtSDTDoctorReservarCita_Profesionalid(struct.getProfesionalid());
      setgxTv_SdtSDTDoctorReservarCita_Direccion(struct.getDireccion());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTDoctorReservarCita getStruct( )
   {
      com.projectthani.StructSdtSDTDoctorReservarCita struct = new com.projectthani.StructSdtSDTDoctorReservarCita ();
      struct.setProfesionalnombrecompleto(getgxTv_SdtSDTDoctorReservarCita_Profesionalnombrecompleto());
      struct.setEspecialidadnombre(getgxTv_SdtSDTDoctorReservarCita_Especialidadnombre());
      struct.setProfesionalfoto(getgxTv_SdtSDTDoctorReservarCita_Profesionalfoto());
      struct.setProfesionalfoto_gxi(getgxTv_SdtSDTDoctorReservarCita_Profesionalfoto_gxi());
      struct.setCalificacion(getgxTv_SdtSDTDoctorReservarCita_Calificacion());
      struct.setProfesionalid(getgxTv_SdtSDTDoctorReservarCita_Profesionalid());
      struct.setDireccion(getgxTv_SdtSDTDoctorReservarCita_Direccion());
      return struct ;
   }

   protected byte gxTv_SdtSDTDoctorReservarCita_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_SdtSDTDoctorReservarCita_Profesionalid ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTDoctorReservarCita_Calificacion ;
   protected String gxTv_SdtSDTDoctorReservarCita_Profesionalnombrecompleto ;
   protected String gxTv_SdtSDTDoctorReservarCita_Especialidadnombre ;
   protected String gxTv_SdtSDTDoctorReservarCita_Profesionalfoto_gxi ;
   protected String gxTv_SdtSDTDoctorReservarCita_Direccion ;
   protected String gxTv_SdtSDTDoctorReservarCita_Profesionalfoto ;
}

