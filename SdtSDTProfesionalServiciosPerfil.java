package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTProfesionalServiciosPerfil extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTProfesionalServiciosPerfil( )
   {
      this(  new ModelContext(SdtSDTProfesionalServiciosPerfil.class));
   }

   public SdtSDTProfesionalServiciosPerfil( ModelContext context )
   {
      super( context, "SdtSDTProfesionalServiciosPerfil");
   }

   public SdtSDTProfesionalServiciosPerfil( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTProfesionalServiciosPerfil");
   }

   public SdtSDTProfesionalServiciosPerfil( StructSdtSDTProfesionalServiciosPerfil struct )
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
               gxTv_SdtSDTProfesionalServiciosPerfil_Id = GXutil.strToGuid(oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "NombreServicio") )
            {
               gxTv_SdtSDTProfesionalServiciosPerfil_Nombreservicio = oReader.getValue() ;
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
         sName = "SDTProfesionalServiciosPerfil" ;
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
      oWriter.writeElement("Id", GXutil.rtrim( gxTv_SdtSDTProfesionalServiciosPerfil_Id.toString()));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("NombreServicio", GXutil.rtrim( gxTv_SdtSDTProfesionalServiciosPerfil_Nombreservicio));
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
      AddObjectProperty("Id", gxTv_SdtSDTProfesionalServiciosPerfil_Id, false, false);
      AddObjectProperty("NombreServicio", gxTv_SdtSDTProfesionalServiciosPerfil_Nombreservicio, false, false);
   }

   public java.util.UUID getgxTv_SdtSDTProfesionalServiciosPerfil_Id( )
   {
      return gxTv_SdtSDTProfesionalServiciosPerfil_Id ;
   }

   public void setgxTv_SdtSDTProfesionalServiciosPerfil_Id( java.util.UUID value )
   {
      gxTv_SdtSDTProfesionalServiciosPerfil_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalServiciosPerfil_Id = value ;
   }

   public String getgxTv_SdtSDTProfesionalServiciosPerfil_Nombreservicio( )
   {
      return gxTv_SdtSDTProfesionalServiciosPerfil_Nombreservicio ;
   }

   public void setgxTv_SdtSDTProfesionalServiciosPerfil_Nombreservicio( String value )
   {
      gxTv_SdtSDTProfesionalServiciosPerfil_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalServiciosPerfil_Nombreservicio = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTProfesionalServiciosPerfil_Id = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      gxTv_SdtSDTProfesionalServiciosPerfil_N = (byte)(1) ;
      gxTv_SdtSDTProfesionalServiciosPerfil_Nombreservicio = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTProfesionalServiciosPerfil_N ;
   }

   public com.projectthani.SdtSDTProfesionalServiciosPerfil Clone( )
   {
      return (com.projectthani.SdtSDTProfesionalServiciosPerfil)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTProfesionalServiciosPerfil struct )
   {
      setgxTv_SdtSDTProfesionalServiciosPerfil_Id(struct.getId());
      setgxTv_SdtSDTProfesionalServiciosPerfil_Nombreservicio(struct.getNombreservicio());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTProfesionalServiciosPerfil getStruct( )
   {
      com.projectthani.StructSdtSDTProfesionalServiciosPerfil struct = new com.projectthani.StructSdtSDTProfesionalServiciosPerfil ();
      struct.setId(getgxTv_SdtSDTProfesionalServiciosPerfil_Id());
      struct.setNombreservicio(getgxTv_SdtSDTProfesionalServiciosPerfil_Nombreservicio());
      return struct ;
   }

   protected byte gxTv_SdtSDTProfesionalServiciosPerfil_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTProfesionalServiciosPerfil_Nombreservicio ;
   protected java.util.UUID gxTv_SdtSDTProfesionalServiciosPerfil_Id ;
}

