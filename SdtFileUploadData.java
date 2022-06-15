package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtFileUploadData extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtFileUploadData( )
   {
      this(  new ModelContext(SdtFileUploadData.class));
   }

   public SdtFileUploadData( ModelContext context )
   {
      super( context, "SdtFileUploadData");
   }

   public SdtFileUploadData( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle, context, "SdtFileUploadData");
   }

   public SdtFileUploadData( StructSdtFileUploadData struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "FullName") )
            {
               gxTv_SdtFileUploadData_Fullname = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Name") )
            {
               gxTv_SdtFileUploadData_Name = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Extension") )
            {
               gxTv_SdtFileUploadData_Extension = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Size") )
            {
               gxTv_SdtFileUploadData_Size = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "File") )
            {
               gxTv_SdtFileUploadData_File=GXutil.blobFromBase64( oReader.getValue()) ;
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
         sName = "FileUploadData" ;
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
      oWriter.writeElement("FullName", GXutil.rtrim( gxTv_SdtFileUploadData_Fullname));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Name", GXutil.rtrim( gxTv_SdtFileUploadData_Name));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Extension", GXutil.rtrim( gxTv_SdtFileUploadData_Extension));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Size", GXutil.trim( GXutil.str( gxTv_SdtFileUploadData_Size, 10, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("File", GXutil.blobToBase64( gxTv_SdtFileUploadData_File));
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
      AddObjectProperty("FullName", gxTv_SdtFileUploadData_Fullname, false, false);
      AddObjectProperty("Name", gxTv_SdtFileUploadData_Name, false, false);
      AddObjectProperty("Extension", gxTv_SdtFileUploadData_Extension, false, false);
      AddObjectProperty("Size", gxTv_SdtFileUploadData_Size, false, false);
      AddObjectProperty("File", gxTv_SdtFileUploadData_File, false, false);
   }

   public String getgxTv_SdtFileUploadData_Fullname( )
   {
      return gxTv_SdtFileUploadData_Fullname ;
   }

   public void setgxTv_SdtFileUploadData_Fullname( String value )
   {
      gxTv_SdtFileUploadData_N = (byte)(0) ;
      gxTv_SdtFileUploadData_Fullname = value ;
   }

   public String getgxTv_SdtFileUploadData_Name( )
   {
      return gxTv_SdtFileUploadData_Name ;
   }

   public void setgxTv_SdtFileUploadData_Name( String value )
   {
      gxTv_SdtFileUploadData_N = (byte)(0) ;
      gxTv_SdtFileUploadData_Name = value ;
   }

   public String getgxTv_SdtFileUploadData_Extension( )
   {
      return gxTv_SdtFileUploadData_Extension ;
   }

   public void setgxTv_SdtFileUploadData_Extension( String value )
   {
      gxTv_SdtFileUploadData_N = (byte)(0) ;
      gxTv_SdtFileUploadData_Extension = value ;
   }

   public long getgxTv_SdtFileUploadData_Size( )
   {
      return gxTv_SdtFileUploadData_Size ;
   }

   public void setgxTv_SdtFileUploadData_Size( long value )
   {
      gxTv_SdtFileUploadData_N = (byte)(0) ;
      gxTv_SdtFileUploadData_Size = value ;
   }

   @GxUpload
   public String getgxTv_SdtFileUploadData_File( )
   {
      return gxTv_SdtFileUploadData_File ;
   }

   public void setgxTv_SdtFileUploadData_File( String value )
   {
      gxTv_SdtFileUploadData_N = (byte)(0) ;
      gxTv_SdtFileUploadData_File = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtFileUploadData_Fullname = "" ;
      gxTv_SdtFileUploadData_N = (byte)(1) ;
      gxTv_SdtFileUploadData_Name = "" ;
      gxTv_SdtFileUploadData_Extension = "" ;
      gxTv_SdtFileUploadData_File = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtFileUploadData_N ;
   }

   public com.projectthani.SdtFileUploadData Clone( )
   {
      return (com.projectthani.SdtFileUploadData)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtFileUploadData struct )
   {
      setgxTv_SdtFileUploadData_Fullname(struct.getFullname());
      setgxTv_SdtFileUploadData_Name(struct.getName());
      setgxTv_SdtFileUploadData_Extension(struct.getExtension());
      setgxTv_SdtFileUploadData_Size(struct.getSize());
      setgxTv_SdtFileUploadData_File(struct.getFile());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtFileUploadData getStruct( )
   {
      com.projectthani.StructSdtFileUploadData struct = new com.projectthani.StructSdtFileUploadData ();
      struct.setFullname(getgxTv_SdtFileUploadData_Fullname());
      struct.setName(getgxTv_SdtFileUploadData_Name());
      struct.setExtension(getgxTv_SdtFileUploadData_Extension());
      struct.setSize(getgxTv_SdtFileUploadData_Size());
      struct.setFile(getgxTv_SdtFileUploadData_File());
      return struct ;
   }

   protected byte gxTv_SdtFileUploadData_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected long gxTv_SdtFileUploadData_Size ;
   protected String gxTv_SdtFileUploadData_Fullname ;
   protected String gxTv_SdtFileUploadData_Name ;
   protected String gxTv_SdtFileUploadData_Extension ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtFileUploadData_File ;
}

