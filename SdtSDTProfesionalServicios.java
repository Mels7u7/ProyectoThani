package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTProfesionalServicios extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTProfesionalServicios( )
   {
      this(  new ModelContext(SdtSDTProfesionalServicios.class));
   }

   public SdtSDTProfesionalServicios( ModelContext context )
   {
      super( context, "SdtSDTProfesionalServicios");
   }

   public SdtSDTProfesionalServicios( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTProfesionalServicios");
   }

   public SdtSDTProfesionalServicios( StructSdtSDTProfesionalServicios struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ServiciosId") )
            {
               gxTv_SdtSDTProfesionalServicios_Serviciosid = GXutil.strToGuid(oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ServiciosNombre") )
            {
               gxTv_SdtSDTProfesionalServicios_Serviciosnombre = oReader.getValue() ;
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
         sName = "SDTProfesionalServicios" ;
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
      oWriter.writeElement("ServiciosId", GXutil.rtrim( gxTv_SdtSDTProfesionalServicios_Serviciosid.toString()));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("ServiciosNombre", GXutil.rtrim( gxTv_SdtSDTProfesionalServicios_Serviciosnombre));
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
      AddObjectProperty("ServiciosId", gxTv_SdtSDTProfesionalServicios_Serviciosid, false, false);
      AddObjectProperty("ServiciosNombre", gxTv_SdtSDTProfesionalServicios_Serviciosnombre, false, false);
   }

   public java.util.UUID getgxTv_SdtSDTProfesionalServicios_Serviciosid( )
   {
      return gxTv_SdtSDTProfesionalServicios_Serviciosid ;
   }

   public void setgxTv_SdtSDTProfesionalServicios_Serviciosid( java.util.UUID value )
   {
      gxTv_SdtSDTProfesionalServicios_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalServicios_Serviciosid = value ;
   }

   public String getgxTv_SdtSDTProfesionalServicios_Serviciosnombre( )
   {
      return gxTv_SdtSDTProfesionalServicios_Serviciosnombre ;
   }

   public void setgxTv_SdtSDTProfesionalServicios_Serviciosnombre( String value )
   {
      gxTv_SdtSDTProfesionalServicios_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalServicios_Serviciosnombre = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTProfesionalServicios_Serviciosid = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      gxTv_SdtSDTProfesionalServicios_N = (byte)(1) ;
      gxTv_SdtSDTProfesionalServicios_Serviciosnombre = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTProfesionalServicios_N ;
   }

   public com.projectthani.SdtSDTProfesionalServicios Clone( )
   {
      return (com.projectthani.SdtSDTProfesionalServicios)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTProfesionalServicios struct )
   {
      setgxTv_SdtSDTProfesionalServicios_Serviciosid(struct.getServiciosid());
      setgxTv_SdtSDTProfesionalServicios_Serviciosnombre(struct.getServiciosnombre());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTProfesionalServicios getStruct( )
   {
      com.projectthani.StructSdtSDTProfesionalServicios struct = new com.projectthani.StructSdtSDTProfesionalServicios ();
      struct.setServiciosid(getgxTv_SdtSDTProfesionalServicios_Serviciosid());
      struct.setServiciosnombre(getgxTv_SdtSDTProfesionalServicios_Serviciosnombre());
      return struct ;
   }

   protected byte gxTv_SdtSDTProfesionalServicios_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTProfesionalServicios_Serviciosnombre ;
   protected java.util.UUID gxTv_SdtSDTProfesionalServicios_Serviciosid ;
}

