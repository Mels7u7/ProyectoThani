package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTProfesionalPremios extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTProfesionalPremios( )
   {
      this(  new ModelContext(SdtSDTProfesionalPremios.class));
   }

   public SdtSDTProfesionalPremios( ModelContext context )
   {
      super( context, "SdtSDTProfesionalPremios");
   }

   public SdtSDTProfesionalPremios( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTProfesionalPremios");
   }

   public SdtSDTProfesionalPremios( StructSdtSDTProfesionalPremios struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "PremiosId") )
            {
               gxTv_SdtSDTProfesionalPremios_Premiosid = GXutil.strToGuid(oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PremiosNombre") )
            {
               gxTv_SdtSDTProfesionalPremios_Premiosnombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PremiosFecha") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtSDTProfesionalPremios_Premiosfecha = GXutil.nullDate() ;
                  gxTv_SdtSDTProfesionalPremios_Premiosfecha_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtSDTProfesionalPremios_Premiosfecha_N = (byte)(0) ;
                  gxTv_SdtSDTProfesionalPremios_Premiosfecha = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PremiosDescripcion") )
            {
               gxTv_SdtSDTProfesionalPremios_Premiosdescripcion = oReader.getValue() ;
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
         sName = "SDTProfesionalPremios" ;
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
      oWriter.writeElement("PremiosId", GXutil.rtrim( gxTv_SdtSDTProfesionalPremios_Premiosid.toString()));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("PremiosNombre", GXutil.rtrim( gxTv_SdtSDTProfesionalPremios_Premiosnombre));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_SdtSDTProfesionalPremios_Premiosfecha)) && ( gxTv_SdtSDTProfesionalPremios_Premiosfecha_N == 1 ) )
      {
         oWriter.writeElement("PremiosFecha", "");
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTProfesionalPremios_Premiosfecha), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTProfesionalPremios_Premiosfecha), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTProfesionalPremios_Premiosfecha), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("PremiosFecha", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      oWriter.writeElement("PremiosDescripcion", GXutil.rtrim( gxTv_SdtSDTProfesionalPremios_Premiosdescripcion));
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
      AddObjectProperty("PremiosId", gxTv_SdtSDTProfesionalPremios_Premiosid, false, false);
      AddObjectProperty("PremiosNombre", gxTv_SdtSDTProfesionalPremios_Premiosnombre, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTProfesionalPremios_Premiosfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTProfesionalPremios_Premiosfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTProfesionalPremios_Premiosfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("PremiosFecha", sDateCnv, false, false);
      AddObjectProperty("PremiosDescripcion", gxTv_SdtSDTProfesionalPremios_Premiosdescripcion, false, false);
   }

   public java.util.UUID getgxTv_SdtSDTProfesionalPremios_Premiosid( )
   {
      return gxTv_SdtSDTProfesionalPremios_Premiosid ;
   }

   public void setgxTv_SdtSDTProfesionalPremios_Premiosid( java.util.UUID value )
   {
      gxTv_SdtSDTProfesionalPremios_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalPremios_Premiosid = value ;
   }

   public String getgxTv_SdtSDTProfesionalPremios_Premiosnombre( )
   {
      return gxTv_SdtSDTProfesionalPremios_Premiosnombre ;
   }

   public void setgxTv_SdtSDTProfesionalPremios_Premiosnombre( String value )
   {
      gxTv_SdtSDTProfesionalPremios_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalPremios_Premiosnombre = value ;
   }

   public java.util.Date getgxTv_SdtSDTProfesionalPremios_Premiosfecha( )
   {
      return gxTv_SdtSDTProfesionalPremios_Premiosfecha ;
   }

   public void setgxTv_SdtSDTProfesionalPremios_Premiosfecha( java.util.Date value )
   {
      gxTv_SdtSDTProfesionalPremios_Premiosfecha_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalPremios_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalPremios_Premiosfecha = value ;
   }

   public String getgxTv_SdtSDTProfesionalPremios_Premiosdescripcion( )
   {
      return gxTv_SdtSDTProfesionalPremios_Premiosdescripcion ;
   }

   public void setgxTv_SdtSDTProfesionalPremios_Premiosdescripcion( String value )
   {
      gxTv_SdtSDTProfesionalPremios_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalPremios_Premiosdescripcion = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTProfesionalPremios_Premiosid = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      gxTv_SdtSDTProfesionalPremios_N = (byte)(1) ;
      gxTv_SdtSDTProfesionalPremios_Premiosnombre = "" ;
      gxTv_SdtSDTProfesionalPremios_Premiosfecha = GXutil.nullDate() ;
      gxTv_SdtSDTProfesionalPremios_Premiosfecha_N = (byte)(1) ;
      gxTv_SdtSDTProfesionalPremios_Premiosdescripcion = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTProfesionalPremios_N ;
   }

   public com.projectthani.SdtSDTProfesionalPremios Clone( )
   {
      return (com.projectthani.SdtSDTProfesionalPremios)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTProfesionalPremios struct )
   {
      setgxTv_SdtSDTProfesionalPremios_Premiosid(struct.getPremiosid());
      setgxTv_SdtSDTProfesionalPremios_Premiosnombre(struct.getPremiosnombre());
      if ( struct.gxTv_SdtSDTProfesionalPremios_Premiosfecha_N == 0 )
      {
         setgxTv_SdtSDTProfesionalPremios_Premiosfecha(struct.getPremiosfecha());
      }
      setgxTv_SdtSDTProfesionalPremios_Premiosdescripcion(struct.getPremiosdescripcion());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTProfesionalPremios getStruct( )
   {
      com.projectthani.StructSdtSDTProfesionalPremios struct = new com.projectthani.StructSdtSDTProfesionalPremios ();
      struct.setPremiosid(getgxTv_SdtSDTProfesionalPremios_Premiosid());
      struct.setPremiosnombre(getgxTv_SdtSDTProfesionalPremios_Premiosnombre());
      if ( gxTv_SdtSDTProfesionalPremios_Premiosfecha_N == 0 )
      {
         struct.setPremiosfecha(getgxTv_SdtSDTProfesionalPremios_Premiosfecha());
      }
      struct.setPremiosdescripcion(getgxTv_SdtSDTProfesionalPremios_Premiosdescripcion());
      return struct ;
   }

   protected byte gxTv_SdtSDTProfesionalPremios_N ;
   protected byte gxTv_SdtSDTProfesionalPremios_Premiosfecha_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_SdtSDTProfesionalPremios_Premiosfecha ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTProfesionalPremios_Premiosdescripcion ;
   protected String gxTv_SdtSDTProfesionalPremios_Premiosnombre ;
   protected java.util.UUID gxTv_SdtSDTProfesionalPremios_Premiosid ;
}

