package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTCountPaciente extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTCountPaciente( )
   {
      this(  new ModelContext(SdtSDTCountPaciente.class));
   }

   public SdtSDTCountPaciente( ModelContext context )
   {
      super( context, "SdtSDTCountPaciente");
   }

   public SdtSDTCountPaciente( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTCountPaciente");
   }

   public SdtSDTCountPaciente( StructSdtSDTCountPaciente struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "id") )
            {
               gxTv_SdtSDTCountPaciente_Id = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "idDis") )
            {
               gxTv_SdtSDTCountPaciente_Iddis = (short)(getnumericvalue(oReader.getValue())) ;
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
         sName = "SDTCountPaciente" ;
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
      oWriter.writeElement("id", GXutil.trim( GXutil.str( gxTv_SdtSDTCountPaciente_Id, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("idDis", GXutil.trim( GXutil.str( gxTv_SdtSDTCountPaciente_Iddis, 4, 0)));
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
      AddObjectProperty("id", gxTv_SdtSDTCountPaciente_Id, false, false);
      AddObjectProperty("idDis", gxTv_SdtSDTCountPaciente_Iddis, false, false);
   }

   public int getgxTv_SdtSDTCountPaciente_Id( )
   {
      return gxTv_SdtSDTCountPaciente_Id ;
   }

   public void setgxTv_SdtSDTCountPaciente_Id( int value )
   {
      gxTv_SdtSDTCountPaciente_N = (byte)(0) ;
      gxTv_SdtSDTCountPaciente_Id = value ;
   }

   public short getgxTv_SdtSDTCountPaciente_Iddis( )
   {
      return gxTv_SdtSDTCountPaciente_Iddis ;
   }

   public void setgxTv_SdtSDTCountPaciente_Iddis( short value )
   {
      gxTv_SdtSDTCountPaciente_N = (byte)(0) ;
      gxTv_SdtSDTCountPaciente_Iddis = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTCountPaciente_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTCountPaciente_N ;
   }

   public com.projectthani.SdtSDTCountPaciente Clone( )
   {
      return (com.projectthani.SdtSDTCountPaciente)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTCountPaciente struct )
   {
      setgxTv_SdtSDTCountPaciente_Id(struct.getId());
      setgxTv_SdtSDTCountPaciente_Iddis(struct.getIddis());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTCountPaciente getStruct( )
   {
      com.projectthani.StructSdtSDTCountPaciente struct = new com.projectthani.StructSdtSDTCountPaciente ();
      struct.setId(getgxTv_SdtSDTCountPaciente_Id());
      struct.setIddis(getgxTv_SdtSDTCountPaciente_Iddis());
      return struct ;
   }

   protected byte gxTv_SdtSDTCountPaciente_N ;
   protected short gxTv_SdtSDTCountPaciente_Iddis ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_SdtSDTCountPaciente_Id ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

