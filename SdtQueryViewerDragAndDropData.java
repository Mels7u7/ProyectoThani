package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtQueryViewerDragAndDropData extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtQueryViewerDragAndDropData( )
   {
      this(  new ModelContext(SdtQueryViewerDragAndDropData.class));
   }

   public SdtQueryViewerDragAndDropData( ModelContext context )
   {
      super( context, "SdtQueryViewerDragAndDropData");
   }

   public SdtQueryViewerDragAndDropData( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle, context, "SdtQueryViewerDragAndDropData");
   }

   public SdtQueryViewerDragAndDropData( StructSdtQueryViewerDragAndDropData struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Name") )
            {
               gxTv_SdtQueryViewerDragAndDropData_Name = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Type") )
            {
               gxTv_SdtQueryViewerDragAndDropData_Type = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Axis") )
            {
               gxTv_SdtQueryViewerDragAndDropData_Axis = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Position") )
            {
               gxTv_SdtQueryViewerDragAndDropData_Position = (short)(getnumericvalue(oReader.getValue())) ;
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
         sName = "QueryViewerDragAndDropData" ;
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
      oWriter.writeElement("Name", GXutil.rtrim( gxTv_SdtQueryViewerDragAndDropData_Name));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Type", GXutil.rtrim( gxTv_SdtQueryViewerDragAndDropData_Type));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Axis", GXutil.rtrim( gxTv_SdtQueryViewerDragAndDropData_Axis));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Position", GXutil.trim( GXutil.str( gxTv_SdtQueryViewerDragAndDropData_Position, 4, 0)));
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
      AddObjectProperty("Name", gxTv_SdtQueryViewerDragAndDropData_Name, false, false);
      AddObjectProperty("Type", gxTv_SdtQueryViewerDragAndDropData_Type, false, false);
      AddObjectProperty("Axis", gxTv_SdtQueryViewerDragAndDropData_Axis, false, false);
      AddObjectProperty("Position", gxTv_SdtQueryViewerDragAndDropData_Position, false, false);
   }

   public String getgxTv_SdtQueryViewerDragAndDropData_Name( )
   {
      return gxTv_SdtQueryViewerDragAndDropData_Name ;
   }

   public void setgxTv_SdtQueryViewerDragAndDropData_Name( String value )
   {
      gxTv_SdtQueryViewerDragAndDropData_N = (byte)(0) ;
      gxTv_SdtQueryViewerDragAndDropData_Name = value ;
   }

   public String getgxTv_SdtQueryViewerDragAndDropData_Type( )
   {
      return gxTv_SdtQueryViewerDragAndDropData_Type ;
   }

   public void setgxTv_SdtQueryViewerDragAndDropData_Type( String value )
   {
      gxTv_SdtQueryViewerDragAndDropData_N = (byte)(0) ;
      gxTv_SdtQueryViewerDragAndDropData_Type = value ;
   }

   public String getgxTv_SdtQueryViewerDragAndDropData_Axis( )
   {
      return gxTv_SdtQueryViewerDragAndDropData_Axis ;
   }

   public void setgxTv_SdtQueryViewerDragAndDropData_Axis( String value )
   {
      gxTv_SdtQueryViewerDragAndDropData_N = (byte)(0) ;
      gxTv_SdtQueryViewerDragAndDropData_Axis = value ;
   }

   public short getgxTv_SdtQueryViewerDragAndDropData_Position( )
   {
      return gxTv_SdtQueryViewerDragAndDropData_Position ;
   }

   public void setgxTv_SdtQueryViewerDragAndDropData_Position( short value )
   {
      gxTv_SdtQueryViewerDragAndDropData_N = (byte)(0) ;
      gxTv_SdtQueryViewerDragAndDropData_Position = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtQueryViewerDragAndDropData_Name = "" ;
      gxTv_SdtQueryViewerDragAndDropData_N = (byte)(1) ;
      gxTv_SdtQueryViewerDragAndDropData_Type = "" ;
      gxTv_SdtQueryViewerDragAndDropData_Axis = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtQueryViewerDragAndDropData_N ;
   }

   public com.projectthani.SdtQueryViewerDragAndDropData Clone( )
   {
      return (com.projectthani.SdtQueryViewerDragAndDropData)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtQueryViewerDragAndDropData struct )
   {
      setgxTv_SdtQueryViewerDragAndDropData_Name(struct.getName());
      setgxTv_SdtQueryViewerDragAndDropData_Type(struct.getType());
      setgxTv_SdtQueryViewerDragAndDropData_Axis(struct.getAxis());
      setgxTv_SdtQueryViewerDragAndDropData_Position(struct.getPosition());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtQueryViewerDragAndDropData getStruct( )
   {
      com.projectthani.StructSdtQueryViewerDragAndDropData struct = new com.projectthani.StructSdtQueryViewerDragAndDropData ();
      struct.setName(getgxTv_SdtQueryViewerDragAndDropData_Name());
      struct.setType(getgxTv_SdtQueryViewerDragAndDropData_Type());
      struct.setAxis(getgxTv_SdtQueryViewerDragAndDropData_Axis());
      struct.setPosition(getgxTv_SdtQueryViewerDragAndDropData_Position());
      return struct ;
   }

   protected byte gxTv_SdtQueryViewerDragAndDropData_N ;
   protected short gxTv_SdtQueryViewerDragAndDropData_Position ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtQueryViewerDragAndDropData_Name ;
   protected String gxTv_SdtQueryViewerDragAndDropData_Type ;
   protected String gxTv_SdtQueryViewerDragAndDropData_Axis ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

