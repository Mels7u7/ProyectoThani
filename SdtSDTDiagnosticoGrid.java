package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTDiagnosticoGrid extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTDiagnosticoGrid( )
   {
      this(  new ModelContext(SdtSDTDiagnosticoGrid.class));
   }

   public SdtSDTDiagnosticoGrid( ModelContext context )
   {
      super( context, "SdtSDTDiagnosticoGrid");
   }

   public SdtSDTDiagnosticoGrid( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTDiagnosticoGrid");
   }

   public SdtSDTDiagnosticoGrid( StructSdtSDTDiagnosticoGrid struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "DiagnosticoId") )
            {
               gxTv_SdtSDTDiagnosticoGrid_Diagnosticoid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DiagnosticoDescripcion") )
            {
               gxTv_SdtSDTDiagnosticoGrid_Diagnosticodescripcion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DiagnosticoCodigo") )
            {
               gxTv_SdtSDTDiagnosticoGrid_Diagnosticocodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DiagnosticoLongDesc") )
            {
               gxTv_SdtSDTDiagnosticoGrid_Diagnosticolongdesc = oReader.getValue() ;
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
         sName = "SDTDiagnosticoGrid" ;
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
      oWriter.writeElement("DiagnosticoId", GXutil.trim( GXutil.str( gxTv_SdtSDTDiagnosticoGrid_Diagnosticoid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("DiagnosticoDescripcion", GXutil.rtrim( gxTv_SdtSDTDiagnosticoGrid_Diagnosticodescripcion));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("DiagnosticoCodigo", GXutil.rtrim( gxTv_SdtSDTDiagnosticoGrid_Diagnosticocodigo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("DiagnosticoLongDesc", GXutil.rtrim( gxTv_SdtSDTDiagnosticoGrid_Diagnosticolongdesc));
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
      AddObjectProperty("DiagnosticoId", gxTv_SdtSDTDiagnosticoGrid_Diagnosticoid, false, false);
      AddObjectProperty("DiagnosticoDescripcion", gxTv_SdtSDTDiagnosticoGrid_Diagnosticodescripcion, false, false);
      AddObjectProperty("DiagnosticoCodigo", gxTv_SdtSDTDiagnosticoGrid_Diagnosticocodigo, false, false);
      AddObjectProperty("DiagnosticoLongDesc", gxTv_SdtSDTDiagnosticoGrid_Diagnosticolongdesc, false, false);
   }

   public int getgxTv_SdtSDTDiagnosticoGrid_Diagnosticoid( )
   {
      return gxTv_SdtSDTDiagnosticoGrid_Diagnosticoid ;
   }

   public void setgxTv_SdtSDTDiagnosticoGrid_Diagnosticoid( int value )
   {
      gxTv_SdtSDTDiagnosticoGrid_N = (byte)(0) ;
      gxTv_SdtSDTDiagnosticoGrid_Diagnosticoid = value ;
   }

   public String getgxTv_SdtSDTDiagnosticoGrid_Diagnosticodescripcion( )
   {
      return gxTv_SdtSDTDiagnosticoGrid_Diagnosticodescripcion ;
   }

   public void setgxTv_SdtSDTDiagnosticoGrid_Diagnosticodescripcion( String value )
   {
      gxTv_SdtSDTDiagnosticoGrid_N = (byte)(0) ;
      gxTv_SdtSDTDiagnosticoGrid_Diagnosticodescripcion = value ;
   }

   public String getgxTv_SdtSDTDiagnosticoGrid_Diagnosticocodigo( )
   {
      return gxTv_SdtSDTDiagnosticoGrid_Diagnosticocodigo ;
   }

   public void setgxTv_SdtSDTDiagnosticoGrid_Diagnosticocodigo( String value )
   {
      gxTv_SdtSDTDiagnosticoGrid_N = (byte)(0) ;
      gxTv_SdtSDTDiagnosticoGrid_Diagnosticocodigo = value ;
   }

   public String getgxTv_SdtSDTDiagnosticoGrid_Diagnosticolongdesc( )
   {
      return gxTv_SdtSDTDiagnosticoGrid_Diagnosticolongdesc ;
   }

   public void setgxTv_SdtSDTDiagnosticoGrid_Diagnosticolongdesc( String value )
   {
      gxTv_SdtSDTDiagnosticoGrid_N = (byte)(0) ;
      gxTv_SdtSDTDiagnosticoGrid_Diagnosticolongdesc = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTDiagnosticoGrid_N = (byte)(1) ;
      gxTv_SdtSDTDiagnosticoGrid_Diagnosticodescripcion = "" ;
      gxTv_SdtSDTDiagnosticoGrid_Diagnosticocodigo = "" ;
      gxTv_SdtSDTDiagnosticoGrid_Diagnosticolongdesc = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTDiagnosticoGrid_N ;
   }

   public com.projectthani.SdtSDTDiagnosticoGrid Clone( )
   {
      return (com.projectthani.SdtSDTDiagnosticoGrid)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTDiagnosticoGrid struct )
   {
      setgxTv_SdtSDTDiagnosticoGrid_Diagnosticoid(struct.getDiagnosticoid());
      setgxTv_SdtSDTDiagnosticoGrid_Diagnosticodescripcion(struct.getDiagnosticodescripcion());
      setgxTv_SdtSDTDiagnosticoGrid_Diagnosticocodigo(struct.getDiagnosticocodigo());
      setgxTv_SdtSDTDiagnosticoGrid_Diagnosticolongdesc(struct.getDiagnosticolongdesc());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTDiagnosticoGrid getStruct( )
   {
      com.projectthani.StructSdtSDTDiagnosticoGrid struct = new com.projectthani.StructSdtSDTDiagnosticoGrid ();
      struct.setDiagnosticoid(getgxTv_SdtSDTDiagnosticoGrid_Diagnosticoid());
      struct.setDiagnosticodescripcion(getgxTv_SdtSDTDiagnosticoGrid_Diagnosticodescripcion());
      struct.setDiagnosticocodigo(getgxTv_SdtSDTDiagnosticoGrid_Diagnosticocodigo());
      struct.setDiagnosticolongdesc(getgxTv_SdtSDTDiagnosticoGrid_Diagnosticolongdesc());
      return struct ;
   }

   protected byte gxTv_SdtSDTDiagnosticoGrid_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_SdtSDTDiagnosticoGrid_Diagnosticoid ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTDiagnosticoGrid_Diagnosticodescripcion ;
   protected String gxTv_SdtSDTDiagnosticoGrid_Diagnosticocodigo ;
   protected String gxTv_SdtSDTDiagnosticoGrid_Diagnosticolongdesc ;
}

