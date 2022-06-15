package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTResponseDni extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSDTResponseDni( )
   {
      this(  new ModelContext(SdtSDTResponseDni.class));
   }

   public SdtSDTResponseDni( ModelContext context )
   {
      super( context, "SdtSDTResponseDni");
   }

   public SdtSDTResponseDni( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTResponseDni");
   }

   public SdtSDTResponseDni( StructSdtSDTResponseDni struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "dni") )
            {
               gxTv_SdtSDTResponseDni_Dni = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "name") )
            {
               gxTv_SdtSDTResponseDni_Name = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "first_name") )
            {
               gxTv_SdtSDTResponseDni_First_name = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "last_name") )
            {
               gxTv_SdtSDTResponseDni_Last_name = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "nombres") )
            {
               gxTv_SdtSDTResponseDni_Nombres = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "apellido_paterno") )
            {
               gxTv_SdtSDTResponseDni_Apellido_paterno = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "apellido_materno") )
            {
               gxTv_SdtSDTResponseDni_Apellido_materno = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "fecha_nacimiento") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtSDTResponseDni_Fecha_nacimiento = GXutil.nullDate() ;
                  gxTv_SdtSDTResponseDni_Fecha_nacimiento_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtSDTResponseDni_Fecha_nacimiento_N = (byte)(0) ;
                  gxTv_SdtSDTResponseDni_Fecha_nacimiento = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "sexo") )
            {
               gxTv_SdtSDTResponseDni_Sexo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "cui") )
            {
               gxTv_SdtSDTResponseDni_Cui = oReader.getValue() ;
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
         sName = "SDTResponseDni" ;
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
      oWriter.writeElement("dni", GXutil.rtrim( gxTv_SdtSDTResponseDni_Dni));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("name", GXutil.rtrim( gxTv_SdtSDTResponseDni_Name));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("first_name", GXutil.rtrim( gxTv_SdtSDTResponseDni_First_name));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("last_name", GXutil.rtrim( gxTv_SdtSDTResponseDni_Last_name));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("nombres", GXutil.rtrim( gxTv_SdtSDTResponseDni_Nombres));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("apellido_paterno", GXutil.rtrim( gxTv_SdtSDTResponseDni_Apellido_paterno));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("apellido_materno", GXutil.rtrim( gxTv_SdtSDTResponseDni_Apellido_materno));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_SdtSDTResponseDni_Fecha_nacimiento)) && ( gxTv_SdtSDTResponseDni_Fecha_nacimiento_N == 1 ) )
      {
         oWriter.writeElement("fecha_nacimiento", "");
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTResponseDni_Fecha_nacimiento), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTResponseDni_Fecha_nacimiento), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTResponseDni_Fecha_nacimiento), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("fecha_nacimiento", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      oWriter.writeElement("sexo", GXutil.rtrim( gxTv_SdtSDTResponseDni_Sexo));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("cui", GXutil.rtrim( gxTv_SdtSDTResponseDni_Cui));
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
      AddObjectProperty("dni", gxTv_SdtSDTResponseDni_Dni, false, false);
      AddObjectProperty("name", gxTv_SdtSDTResponseDni_Name, false, false);
      AddObjectProperty("first_name", gxTv_SdtSDTResponseDni_First_name, false, false);
      AddObjectProperty("last_name", gxTv_SdtSDTResponseDni_Last_name, false, false);
      AddObjectProperty("nombres", gxTv_SdtSDTResponseDni_Nombres, false, false);
      AddObjectProperty("apellido_paterno", gxTv_SdtSDTResponseDni_Apellido_paterno, false, false);
      AddObjectProperty("apellido_materno", gxTv_SdtSDTResponseDni_Apellido_materno, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTResponseDni_Fecha_nacimiento), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTResponseDni_Fecha_nacimiento), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTResponseDni_Fecha_nacimiento), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("fecha_nacimiento", sDateCnv, false, false);
      AddObjectProperty("sexo", gxTv_SdtSDTResponseDni_Sexo, false, false);
      AddObjectProperty("cui", gxTv_SdtSDTResponseDni_Cui, false, false);
   }

   public String getgxTv_SdtSDTResponseDni_Dni( )
   {
      return gxTv_SdtSDTResponseDni_Dni ;
   }

   public void setgxTv_SdtSDTResponseDni_Dni( String value )
   {
      gxTv_SdtSDTResponseDni_N = (byte)(0) ;
      gxTv_SdtSDTResponseDni_Dni = value ;
   }

   public String getgxTv_SdtSDTResponseDni_Name( )
   {
      return gxTv_SdtSDTResponseDni_Name ;
   }

   public void setgxTv_SdtSDTResponseDni_Name( String value )
   {
      gxTv_SdtSDTResponseDni_N = (byte)(0) ;
      gxTv_SdtSDTResponseDni_Name = value ;
   }

   public String getgxTv_SdtSDTResponseDni_First_name( )
   {
      return gxTv_SdtSDTResponseDni_First_name ;
   }

   public void setgxTv_SdtSDTResponseDni_First_name( String value )
   {
      gxTv_SdtSDTResponseDni_N = (byte)(0) ;
      gxTv_SdtSDTResponseDni_First_name = value ;
   }

   public String getgxTv_SdtSDTResponseDni_Last_name( )
   {
      return gxTv_SdtSDTResponseDni_Last_name ;
   }

   public void setgxTv_SdtSDTResponseDni_Last_name( String value )
   {
      gxTv_SdtSDTResponseDni_N = (byte)(0) ;
      gxTv_SdtSDTResponseDni_Last_name = value ;
   }

   public String getgxTv_SdtSDTResponseDni_Nombres( )
   {
      return gxTv_SdtSDTResponseDni_Nombres ;
   }

   public void setgxTv_SdtSDTResponseDni_Nombres( String value )
   {
      gxTv_SdtSDTResponseDni_N = (byte)(0) ;
      gxTv_SdtSDTResponseDni_Nombres = value ;
   }

   public String getgxTv_SdtSDTResponseDni_Apellido_paterno( )
   {
      return gxTv_SdtSDTResponseDni_Apellido_paterno ;
   }

   public void setgxTv_SdtSDTResponseDni_Apellido_paterno( String value )
   {
      gxTv_SdtSDTResponseDni_N = (byte)(0) ;
      gxTv_SdtSDTResponseDni_Apellido_paterno = value ;
   }

   public String getgxTv_SdtSDTResponseDni_Apellido_materno( )
   {
      return gxTv_SdtSDTResponseDni_Apellido_materno ;
   }

   public void setgxTv_SdtSDTResponseDni_Apellido_materno( String value )
   {
      gxTv_SdtSDTResponseDni_N = (byte)(0) ;
      gxTv_SdtSDTResponseDni_Apellido_materno = value ;
   }

   public java.util.Date getgxTv_SdtSDTResponseDni_Fecha_nacimiento( )
   {
      return gxTv_SdtSDTResponseDni_Fecha_nacimiento ;
   }

   public void setgxTv_SdtSDTResponseDni_Fecha_nacimiento( java.util.Date value )
   {
      gxTv_SdtSDTResponseDni_Fecha_nacimiento_N = (byte)(0) ;
      gxTv_SdtSDTResponseDni_N = (byte)(0) ;
      gxTv_SdtSDTResponseDni_Fecha_nacimiento = value ;
   }

   public String getgxTv_SdtSDTResponseDni_Sexo( )
   {
      return gxTv_SdtSDTResponseDni_Sexo ;
   }

   public void setgxTv_SdtSDTResponseDni_Sexo( String value )
   {
      gxTv_SdtSDTResponseDni_N = (byte)(0) ;
      gxTv_SdtSDTResponseDni_Sexo = value ;
   }

   public String getgxTv_SdtSDTResponseDni_Cui( )
   {
      return gxTv_SdtSDTResponseDni_Cui ;
   }

   public void setgxTv_SdtSDTResponseDni_Cui( String value )
   {
      gxTv_SdtSDTResponseDni_N = (byte)(0) ;
      gxTv_SdtSDTResponseDni_Cui = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTResponseDni_Dni = "" ;
      gxTv_SdtSDTResponseDni_N = (byte)(1) ;
      gxTv_SdtSDTResponseDni_Name = "" ;
      gxTv_SdtSDTResponseDni_First_name = "" ;
      gxTv_SdtSDTResponseDni_Last_name = "" ;
      gxTv_SdtSDTResponseDni_Nombres = "" ;
      gxTv_SdtSDTResponseDni_Apellido_paterno = "" ;
      gxTv_SdtSDTResponseDni_Apellido_materno = "" ;
      gxTv_SdtSDTResponseDni_Fecha_nacimiento = GXutil.nullDate() ;
      gxTv_SdtSDTResponseDni_Fecha_nacimiento_N = (byte)(1) ;
      gxTv_SdtSDTResponseDni_Sexo = "" ;
      gxTv_SdtSDTResponseDni_Cui = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTResponseDni_N ;
   }

   public com.projectthani.SdtSDTResponseDni Clone( )
   {
      return (com.projectthani.SdtSDTResponseDni)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSDTResponseDni struct )
   {
      setgxTv_SdtSDTResponseDni_Dni(struct.getDni());
      setgxTv_SdtSDTResponseDni_Name(struct.getName());
      setgxTv_SdtSDTResponseDni_First_name(struct.getFirst_name());
      setgxTv_SdtSDTResponseDni_Last_name(struct.getLast_name());
      setgxTv_SdtSDTResponseDni_Nombres(struct.getNombres());
      setgxTv_SdtSDTResponseDni_Apellido_paterno(struct.getApellido_paterno());
      setgxTv_SdtSDTResponseDni_Apellido_materno(struct.getApellido_materno());
      if ( struct.gxTv_SdtSDTResponseDni_Fecha_nacimiento_N == 0 )
      {
         setgxTv_SdtSDTResponseDni_Fecha_nacimiento(struct.getFecha_nacimiento());
      }
      setgxTv_SdtSDTResponseDni_Sexo(struct.getSexo());
      setgxTv_SdtSDTResponseDni_Cui(struct.getCui());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSDTResponseDni getStruct( )
   {
      com.projectthani.StructSdtSDTResponseDni struct = new com.projectthani.StructSdtSDTResponseDni ();
      struct.setDni(getgxTv_SdtSDTResponseDni_Dni());
      struct.setName(getgxTv_SdtSDTResponseDni_Name());
      struct.setFirst_name(getgxTv_SdtSDTResponseDni_First_name());
      struct.setLast_name(getgxTv_SdtSDTResponseDni_Last_name());
      struct.setNombres(getgxTv_SdtSDTResponseDni_Nombres());
      struct.setApellido_paterno(getgxTv_SdtSDTResponseDni_Apellido_paterno());
      struct.setApellido_materno(getgxTv_SdtSDTResponseDni_Apellido_materno());
      if ( gxTv_SdtSDTResponseDni_Fecha_nacimiento_N == 0 )
      {
         struct.setFecha_nacimiento(getgxTv_SdtSDTResponseDni_Fecha_nacimiento());
      }
      struct.setSexo(getgxTv_SdtSDTResponseDni_Sexo());
      struct.setCui(getgxTv_SdtSDTResponseDni_Cui());
      return struct ;
   }

   protected byte gxTv_SdtSDTResponseDni_N ;
   protected byte gxTv_SdtSDTResponseDni_Fecha_nacimiento_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtSDTResponseDni_Sexo ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_SdtSDTResponseDni_Fecha_nacimiento ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTResponseDni_Dni ;
   protected String gxTv_SdtSDTResponseDni_Name ;
   protected String gxTv_SdtSDTResponseDni_First_name ;
   protected String gxTv_SdtSDTResponseDni_Last_name ;
   protected String gxTv_SdtSDTResponseDni_Nombres ;
   protected String gxTv_SdtSDTResponseDni_Apellido_paterno ;
   protected String gxTv_SdtSDTResponseDni_Apellido_materno ;
   protected String gxTv_SdtSDTResponseDni_Cui ;
}

