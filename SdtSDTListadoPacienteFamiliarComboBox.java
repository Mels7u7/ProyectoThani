package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTListadoPacienteFamiliarComboBox extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTListadoPacienteFamiliarComboBox( )
   {
      this(  new ModelContext(SdtSDTListadoPacienteFamiliarComboBox.class));
   }

   public SdtSDTListadoPacienteFamiliarComboBox( ModelContext context )
   {
      super( context, "SdtSDTListadoPacienteFamiliarComboBox");
   }

   public SdtSDTListadoPacienteFamiliarComboBox( int remoteHandle ,
                                                 ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTListadoPacienteFamiliarComboBox");
   }

   public SdtSDTListadoPacienteFamiliarComboBox( StructSdtSDTListadoPacienteFamiliarComboBox struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "PacienteFamiliarId") )
            {
               gxTv_SdtSDTListadoPacienteFamiliarComboBox_Pacientefamiliarid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "NombresApellidos") )
            {
               gxTv_SdtSDTListadoPacienteFamiliarComboBox_Nombresapellidos = oReader.getValue() ;
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
         sName = "SDTListadoPacienteFamiliarComboBox" ;
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
      oWriter.writeElement("PacienteFamiliarId", GXutil.trim( GXutil.str( gxTv_SdtSDTListadoPacienteFamiliarComboBox_Pacientefamiliarid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("NombresApellidos", GXutil.rtrim( gxTv_SdtSDTListadoPacienteFamiliarComboBox_Nombresapellidos));
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
      AddObjectProperty("PacienteFamiliarId", gxTv_SdtSDTListadoPacienteFamiliarComboBox_Pacientefamiliarid, false, false);
      AddObjectProperty("NombresApellidos", gxTv_SdtSDTListadoPacienteFamiliarComboBox_Nombresapellidos, false, false);
   }

   public int getgxTv_SdtSDTListadoPacienteFamiliarComboBox_Pacientefamiliarid( )
   {
      return gxTv_SdtSDTListadoPacienteFamiliarComboBox_Pacientefamiliarid ;
   }

   public void setgxTv_SdtSDTListadoPacienteFamiliarComboBox_Pacientefamiliarid( int value )
   {
      gxTv_SdtSDTListadoPacienteFamiliarComboBox_N = (byte)(0) ;
      gxTv_SdtSDTListadoPacienteFamiliarComboBox_Pacientefamiliarid = value ;
   }

   public String getgxTv_SdtSDTListadoPacienteFamiliarComboBox_Nombresapellidos( )
   {
      return gxTv_SdtSDTListadoPacienteFamiliarComboBox_Nombresapellidos ;
   }

   public void setgxTv_SdtSDTListadoPacienteFamiliarComboBox_Nombresapellidos( String value )
   {
      gxTv_SdtSDTListadoPacienteFamiliarComboBox_N = (byte)(0) ;
      gxTv_SdtSDTListadoPacienteFamiliarComboBox_Nombresapellidos = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTListadoPacienteFamiliarComboBox_N = (byte)(1) ;
      gxTv_SdtSDTListadoPacienteFamiliarComboBox_Nombresapellidos = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTListadoPacienteFamiliarComboBox_N ;
   }

   public com.projectthani.SdtSDTListadoPacienteFamiliarComboBox Clone( )
   {
      return (com.projectthani.SdtSDTListadoPacienteFamiliarComboBox)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTListadoPacienteFamiliarComboBox struct )
   {
      setgxTv_SdtSDTListadoPacienteFamiliarComboBox_Pacientefamiliarid(struct.getPacientefamiliarid());
      setgxTv_SdtSDTListadoPacienteFamiliarComboBox_Nombresapellidos(struct.getNombresapellidos());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTListadoPacienteFamiliarComboBox getStruct( )
   {
      com.projectthani.StructSdtSDTListadoPacienteFamiliarComboBox struct = new com.projectthani.StructSdtSDTListadoPacienteFamiliarComboBox ();
      struct.setPacientefamiliarid(getgxTv_SdtSDTListadoPacienteFamiliarComboBox_Pacientefamiliarid());
      struct.setNombresapellidos(getgxTv_SdtSDTListadoPacienteFamiliarComboBox_Nombresapellidos());
      return struct ;
   }

   protected byte gxTv_SdtSDTListadoPacienteFamiliarComboBox_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_SdtSDTListadoPacienteFamiliarComboBox_Pacientefamiliarid ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTListadoPacienteFamiliarComboBox_Nombresapellidos ;
}

