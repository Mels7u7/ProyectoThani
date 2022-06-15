package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTIdPacientes extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTIdPacientes( )
   {
      this(  new ModelContext(SdtSDTIdPacientes.class));
   }

   public SdtSDTIdPacientes( ModelContext context )
   {
      super( context, "SdtSDTIdPacientes");
   }

   public SdtSDTIdPacientes( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTIdPacientes");
   }

   public SdtSDTIdPacientes( StructSdtSDTIdPacientes struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteId") )
            {
               gxTv_SdtSDTIdPacientes_Pacienteid = (int)(getnumericvalue(oReader.getValue())) ;
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
         sName = "SDTIdPacientes" ;
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
      oWriter.writeElement("PacienteId", GXutil.trim( GXutil.str( gxTv_SdtSDTIdPacientes_Pacienteid, 8, 0)));
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
      AddObjectProperty("PacienteId", gxTv_SdtSDTIdPacientes_Pacienteid, false, false);
   }

   public int getgxTv_SdtSDTIdPacientes_Pacienteid( )
   {
      return gxTv_SdtSDTIdPacientes_Pacienteid ;
   }

   public void setgxTv_SdtSDTIdPacientes_Pacienteid( int value )
   {
      gxTv_SdtSDTIdPacientes_N = (byte)(0) ;
      gxTv_SdtSDTIdPacientes_Pacienteid = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTIdPacientes_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTIdPacientes_N ;
   }

   public com.projectthani.SdtSDTIdPacientes Clone( )
   {
      return (com.projectthani.SdtSDTIdPacientes)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTIdPacientes struct )
   {
      setgxTv_SdtSDTIdPacientes_Pacienteid(struct.getPacienteid());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTIdPacientes getStruct( )
   {
      com.projectthani.StructSdtSDTIdPacientes struct = new com.projectthani.StructSdtSDTIdPacientes ();
      struct.setPacienteid(getgxTv_SdtSDTIdPacientes_Pacienteid());
      return struct ;
   }

   protected byte gxTv_SdtSDTIdPacientes_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_SdtSDTIdPacientes_Pacienteid ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}
