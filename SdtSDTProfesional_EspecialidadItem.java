package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTProfesional_EspecialidadItem extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTProfesional_EspecialidadItem( )
   {
      this(  new ModelContext(SdtSDTProfesional_EspecialidadItem.class));
   }

   public SdtSDTProfesional_EspecialidadItem( ModelContext context )
   {
      super( context, "SdtSDTProfesional_EspecialidadItem");
   }

   public SdtSDTProfesional_EspecialidadItem( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTProfesional_EspecialidadItem");
   }

   public SdtSDTProfesional_EspecialidadItem( StructSdtSDTProfesional_EspecialidadItem struct )
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
               gxTv_SdtSDTProfesional_EspecialidadItem_Especialidadid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EspecialidadCodigo") )
            {
               gxTv_SdtSDTProfesional_EspecialidadItem_Especialidadcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EspecialidadNombre") )
            {
               gxTv_SdtSDTProfesional_EspecialidadItem_Especialidadnombre = oReader.getValue() ;
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
         sName = "SDTProfesional.EspecialidadItem" ;
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
      oWriter.writeElement("EspecialidadId", GXutil.trim( GXutil.str( gxTv_SdtSDTProfesional_EspecialidadItem_Especialidadid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("EspecialidadCodigo", GXutil.rtrim( gxTv_SdtSDTProfesional_EspecialidadItem_Especialidadcodigo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("EspecialidadNombre", GXutil.rtrim( gxTv_SdtSDTProfesional_EspecialidadItem_Especialidadnombre));
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
      AddObjectProperty("EspecialidadId", gxTv_SdtSDTProfesional_EspecialidadItem_Especialidadid, false, false);
      AddObjectProperty("EspecialidadCodigo", gxTv_SdtSDTProfesional_EspecialidadItem_Especialidadcodigo, false, false);
      AddObjectProperty("EspecialidadNombre", gxTv_SdtSDTProfesional_EspecialidadItem_Especialidadnombre, false, false);
   }

   public short getgxTv_SdtSDTProfesional_EspecialidadItem_Especialidadid( )
   {
      return gxTv_SdtSDTProfesional_EspecialidadItem_Especialidadid ;
   }

   public void setgxTv_SdtSDTProfesional_EspecialidadItem_Especialidadid( short value )
   {
      gxTv_SdtSDTProfesional_EspecialidadItem_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_EspecialidadItem_Especialidadid = value ;
   }

   public String getgxTv_SdtSDTProfesional_EspecialidadItem_Especialidadcodigo( )
   {
      return gxTv_SdtSDTProfesional_EspecialidadItem_Especialidadcodigo ;
   }

   public void setgxTv_SdtSDTProfesional_EspecialidadItem_Especialidadcodigo( String value )
   {
      gxTv_SdtSDTProfesional_EspecialidadItem_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_EspecialidadItem_Especialidadcodigo = value ;
   }

   public String getgxTv_SdtSDTProfesional_EspecialidadItem_Especialidadnombre( )
   {
      return gxTv_SdtSDTProfesional_EspecialidadItem_Especialidadnombre ;
   }

   public void setgxTv_SdtSDTProfesional_EspecialidadItem_Especialidadnombre( String value )
   {
      gxTv_SdtSDTProfesional_EspecialidadItem_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_EspecialidadItem_Especialidadnombre = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTProfesional_EspecialidadItem_N = (byte)(1) ;
      gxTv_SdtSDTProfesional_EspecialidadItem_Especialidadcodigo = "" ;
      gxTv_SdtSDTProfesional_EspecialidadItem_Especialidadnombre = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTProfesional_EspecialidadItem_N ;
   }

   public com.projectthani.SdtSDTProfesional_EspecialidadItem Clone( )
   {
      return (com.projectthani.SdtSDTProfesional_EspecialidadItem)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTProfesional_EspecialidadItem struct )
   {
      setgxTv_SdtSDTProfesional_EspecialidadItem_Especialidadid(struct.getEspecialidadid());
      setgxTv_SdtSDTProfesional_EspecialidadItem_Especialidadcodigo(struct.getEspecialidadcodigo());
      setgxTv_SdtSDTProfesional_EspecialidadItem_Especialidadnombre(struct.getEspecialidadnombre());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTProfesional_EspecialidadItem getStruct( )
   {
      com.projectthani.StructSdtSDTProfesional_EspecialidadItem struct = new com.projectthani.StructSdtSDTProfesional_EspecialidadItem ();
      struct.setEspecialidadid(getgxTv_SdtSDTProfesional_EspecialidadItem_Especialidadid());
      struct.setEspecialidadcodigo(getgxTv_SdtSDTProfesional_EspecialidadItem_Especialidadcodigo());
      struct.setEspecialidadnombre(getgxTv_SdtSDTProfesional_EspecialidadItem_Especialidadnombre());
      return struct ;
   }

   protected byte gxTv_SdtSDTProfesional_EspecialidadItem_N ;
   protected short gxTv_SdtSDTProfesional_EspecialidadItem_Especialidadid ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTProfesional_EspecialidadItem_Especialidadcodigo ;
   protected String gxTv_SdtSDTProfesional_EspecialidadItem_Especialidadnombre ;
}

