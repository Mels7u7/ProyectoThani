package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTEspecialidad extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTEspecialidad( )
   {
      this(  new ModelContext(SdtSDTEspecialidad.class));
   }

   public SdtSDTEspecialidad( ModelContext context )
   {
      super( context, "SdtSDTEspecialidad");
   }

   public SdtSDTEspecialidad( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTEspecialidad");
   }

   public SdtSDTEspecialidad( StructSdtSDTEspecialidad struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "EspecialidadId") )
            {
               gxTv_SdtSDTEspecialidad_Especialidadid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EspecialidadNombre") )
            {
               gxTv_SdtSDTEspecialidad_Especialidadnombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EspecialidadCodigo") )
            {
               gxTv_SdtSDTEspecialidad_Especialidadcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EspecialidadCheck") )
            {
               gxTv_SdtSDTEspecialidad_Especialidadcheck = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
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
         sName = "SDTEspecialidad" ;
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
      oWriter.writeElement("EspecialidadId", GXutil.trim( GXutil.str( gxTv_SdtSDTEspecialidad_Especialidadid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("EspecialidadNombre", GXutil.rtrim( gxTv_SdtSDTEspecialidad_Especialidadnombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("EspecialidadCodigo", GXutil.rtrim( gxTv_SdtSDTEspecialidad_Especialidadcodigo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("EspecialidadCheck", GXutil.rtrim( GXutil.booltostr( gxTv_SdtSDTEspecialidad_Especialidadcheck)));
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
      AddObjectProperty("EspecialidadId", gxTv_SdtSDTEspecialidad_Especialidadid, false, false);
      AddObjectProperty("EspecialidadNombre", gxTv_SdtSDTEspecialidad_Especialidadnombre, false, false);
      AddObjectProperty("EspecialidadCodigo", gxTv_SdtSDTEspecialidad_Especialidadcodigo, false, false);
      AddObjectProperty("EspecialidadCheck", gxTv_SdtSDTEspecialidad_Especialidadcheck, false, false);
   }

   public short getgxTv_SdtSDTEspecialidad_Especialidadid( )
   {
      return gxTv_SdtSDTEspecialidad_Especialidadid ;
   }

   public void setgxTv_SdtSDTEspecialidad_Especialidadid( short value )
   {
      gxTv_SdtSDTEspecialidad_N = (byte)(0) ;
      gxTv_SdtSDTEspecialidad_Especialidadid = value ;
   }

   public String getgxTv_SdtSDTEspecialidad_Especialidadnombre( )
   {
      return gxTv_SdtSDTEspecialidad_Especialidadnombre ;
   }

   public void setgxTv_SdtSDTEspecialidad_Especialidadnombre( String value )
   {
      gxTv_SdtSDTEspecialidad_N = (byte)(0) ;
      gxTv_SdtSDTEspecialidad_Especialidadnombre = value ;
   }

   public String getgxTv_SdtSDTEspecialidad_Especialidadcodigo( )
   {
      return gxTv_SdtSDTEspecialidad_Especialidadcodigo ;
   }

   public void setgxTv_SdtSDTEspecialidad_Especialidadcodigo( String value )
   {
      gxTv_SdtSDTEspecialidad_N = (byte)(0) ;
      gxTv_SdtSDTEspecialidad_Especialidadcodigo = value ;
   }

   public boolean getgxTv_SdtSDTEspecialidad_Especialidadcheck( )
   {
      return gxTv_SdtSDTEspecialidad_Especialidadcheck ;
   }

   public void setgxTv_SdtSDTEspecialidad_Especialidadcheck( boolean value )
   {
      gxTv_SdtSDTEspecialidad_N = (byte)(0) ;
      gxTv_SdtSDTEspecialidad_Especialidadcheck = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTEspecialidad_N = (byte)(1) ;
      gxTv_SdtSDTEspecialidad_Especialidadnombre = "" ;
      gxTv_SdtSDTEspecialidad_Especialidadcodigo = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTEspecialidad_N ;
   }

   public com.projectthani.SdtSDTEspecialidad Clone( )
   {
      return (com.projectthani.SdtSDTEspecialidad)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTEspecialidad struct )
   {
      setgxTv_SdtSDTEspecialidad_Especialidadid(struct.getEspecialidadid());
      setgxTv_SdtSDTEspecialidad_Especialidadnombre(struct.getEspecialidadnombre());
      setgxTv_SdtSDTEspecialidad_Especialidadcodigo(struct.getEspecialidadcodigo());
      setgxTv_SdtSDTEspecialidad_Especialidadcheck(struct.getEspecialidadcheck());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTEspecialidad getStruct( )
   {
      com.projectthani.StructSdtSDTEspecialidad struct = new com.projectthani.StructSdtSDTEspecialidad ();
      struct.setEspecialidadid(getgxTv_SdtSDTEspecialidad_Especialidadid());
      struct.setEspecialidadnombre(getgxTv_SdtSDTEspecialidad_Especialidadnombre());
      struct.setEspecialidadcodigo(getgxTv_SdtSDTEspecialidad_Especialidadcodigo());
      struct.setEspecialidadcheck(getgxTv_SdtSDTEspecialidad_Especialidadcheck());
      return struct ;
   }

   protected byte gxTv_SdtSDTEspecialidad_N ;
   protected short gxTv_SdtSDTEspecialidad_Especialidadid ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean gxTv_SdtSDTEspecialidad_Especialidadcheck ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTEspecialidad_Especialidadnombre ;
   protected String gxTv_SdtSDTEspecialidad_Especialidadcodigo ;
}

