package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTSede extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTSede( )
   {
      this(  new ModelContext(SdtSDTSede.class));
   }

   public SdtSDTSede( ModelContext context )
   {
      super( context, "SdtSDTSede");
   }

   public SdtSDTSede( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTSede");
   }

   public SdtSDTSede( StructSdtSDTSede struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGEspecialidadSedeId") )
            {
               gxTv_SdtSDTSede_Sgespecialidadsedeid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGEspecialidadSedeNombre") )
            {
               gxTv_SdtSDTSede_Sgespecialidadsedenombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGEspecialidadSedeClinicaid") )
            {
               gxTv_SdtSDTSede_Sgespecialidadsedeclinicaid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SGEspecialidadSedeClinicaNombre") )
            {
               gxTv_SdtSDTSede_Sgespecialidadsedeclinicanombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SedeFullName") )
            {
               gxTv_SdtSDTSede_Sedefullname = oReader.getValue() ;
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
         sName = "SDTSede" ;
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
      oWriter.writeElement("SGEspecialidadSedeId", GXutil.trim( GXutil.str( gxTv_SdtSDTSede_Sgespecialidadsedeid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGEspecialidadSedeNombre", GXutil.rtrim( gxTv_SdtSDTSede_Sgespecialidadsedenombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGEspecialidadSedeClinicaid", GXutil.trim( GXutil.str( gxTv_SdtSDTSede_Sgespecialidadsedeclinicaid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SGEspecialidadSedeClinicaNombre", GXutil.rtrim( gxTv_SdtSDTSede_Sgespecialidadsedeclinicanombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SedeFullName", GXutil.rtrim( gxTv_SdtSDTSede_Sedefullname));
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
      AddObjectProperty("SGEspecialidadSedeId", gxTv_SdtSDTSede_Sgespecialidadsedeid, false, false);
      AddObjectProperty("SGEspecialidadSedeNombre", gxTv_SdtSDTSede_Sgespecialidadsedenombre, false, false);
      AddObjectProperty("SGEspecialidadSedeClinicaid", gxTv_SdtSDTSede_Sgespecialidadsedeclinicaid, false, false);
      AddObjectProperty("SGEspecialidadSedeClinicaNombre", gxTv_SdtSDTSede_Sgespecialidadsedeclinicanombre, false, false);
      AddObjectProperty("SedeFullName", gxTv_SdtSDTSede_Sedefullname, false, false);
   }

   public short getgxTv_SdtSDTSede_Sgespecialidadsedeid( )
   {
      return gxTv_SdtSDTSede_Sgespecialidadsedeid ;
   }

   public void setgxTv_SdtSDTSede_Sgespecialidadsedeid( short value )
   {
      gxTv_SdtSDTSede_N = (byte)(0) ;
      gxTv_SdtSDTSede_Sgespecialidadsedeid = value ;
   }

   public String getgxTv_SdtSDTSede_Sgespecialidadsedenombre( )
   {
      return gxTv_SdtSDTSede_Sgespecialidadsedenombre ;
   }

   public void setgxTv_SdtSDTSede_Sgespecialidadsedenombre( String value )
   {
      gxTv_SdtSDTSede_N = (byte)(0) ;
      gxTv_SdtSDTSede_Sgespecialidadsedenombre = value ;
   }

   public short getgxTv_SdtSDTSede_Sgespecialidadsedeclinicaid( )
   {
      return gxTv_SdtSDTSede_Sgespecialidadsedeclinicaid ;
   }

   public void setgxTv_SdtSDTSede_Sgespecialidadsedeclinicaid( short value )
   {
      gxTv_SdtSDTSede_N = (byte)(0) ;
      gxTv_SdtSDTSede_Sgespecialidadsedeclinicaid = value ;
   }

   public String getgxTv_SdtSDTSede_Sgespecialidadsedeclinicanombre( )
   {
      return gxTv_SdtSDTSede_Sgespecialidadsedeclinicanombre ;
   }

   public void setgxTv_SdtSDTSede_Sgespecialidadsedeclinicanombre( String value )
   {
      gxTv_SdtSDTSede_N = (byte)(0) ;
      gxTv_SdtSDTSede_Sgespecialidadsedeclinicanombre = value ;
   }

   public String getgxTv_SdtSDTSede_Sedefullname( )
   {
      return gxTv_SdtSDTSede_Sedefullname ;
   }

   public void setgxTv_SdtSDTSede_Sedefullname( String value )
   {
      gxTv_SdtSDTSede_N = (byte)(0) ;
      gxTv_SdtSDTSede_Sedefullname = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTSede_N = (byte)(1) ;
      gxTv_SdtSDTSede_Sgespecialidadsedenombre = "" ;
      gxTv_SdtSDTSede_Sgespecialidadsedeclinicanombre = "" ;
      gxTv_SdtSDTSede_Sedefullname = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTSede_N ;
   }

   public com.projectthani.SdtSDTSede Clone( )
   {
      return (com.projectthani.SdtSDTSede)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTSede struct )
   {
      setgxTv_SdtSDTSede_Sgespecialidadsedeid(struct.getSgespecialidadsedeid());
      setgxTv_SdtSDTSede_Sgespecialidadsedenombre(struct.getSgespecialidadsedenombre());
      setgxTv_SdtSDTSede_Sgespecialidadsedeclinicaid(struct.getSgespecialidadsedeclinicaid());
      setgxTv_SdtSDTSede_Sgespecialidadsedeclinicanombre(struct.getSgespecialidadsedeclinicanombre());
      setgxTv_SdtSDTSede_Sedefullname(struct.getSedefullname());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTSede getStruct( )
   {
      com.projectthani.StructSdtSDTSede struct = new com.projectthani.StructSdtSDTSede ();
      struct.setSgespecialidadsedeid(getgxTv_SdtSDTSede_Sgespecialidadsedeid());
      struct.setSgespecialidadsedenombre(getgxTv_SdtSDTSede_Sgespecialidadsedenombre());
      struct.setSgespecialidadsedeclinicaid(getgxTv_SdtSDTSede_Sgespecialidadsedeclinicaid());
      struct.setSgespecialidadsedeclinicanombre(getgxTv_SdtSDTSede_Sgespecialidadsedeclinicanombre());
      struct.setSedefullname(getgxTv_SdtSDTSede_Sedefullname());
      return struct ;
   }

   protected byte gxTv_SdtSDTSede_N ;
   protected short gxTv_SdtSDTSede_Sgespecialidadsedeid ;
   protected short gxTv_SdtSDTSede_Sgespecialidadsedeclinicaid ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTSede_Sgespecialidadsedenombre ;
   protected String gxTv_SdtSDTSede_Sgespecialidadsedeclinicanombre ;
   protected String gxTv_SdtSDTSede_Sedefullname ;
}

