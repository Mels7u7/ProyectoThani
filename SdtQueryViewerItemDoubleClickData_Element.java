package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtQueryViewerItemDoubleClickData_Element extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtQueryViewerItemDoubleClickData_Element( )
   {
      this(  new ModelContext(SdtQueryViewerItemDoubleClickData_Element.class));
   }

   public SdtQueryViewerItemDoubleClickData_Element( ModelContext context )
   {
      super( context, "SdtQueryViewerItemDoubleClickData_Element");
   }

   public SdtQueryViewerItemDoubleClickData_Element( int remoteHandle ,
                                                     ModelContext context )
   {
      super( remoteHandle, context, "SdtQueryViewerItemDoubleClickData_Element");
   }

   public SdtQueryViewerItemDoubleClickData_Element( StructSdtQueryViewerItemDoubleClickData_Element struct )
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
               gxTv_SdtQueryViewerItemDoubleClickData_Element_Name = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Values") )
            {
               if ( gxTv_SdtQueryViewerItemDoubleClickData_Element_Values == null )
               {
                  gxTv_SdtQueryViewerItemDoubleClickData_Element_Values = new GXSimpleCollection<String>(String.class, "internal", "");
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_SdtQueryViewerItemDoubleClickData_Element_Values.readxmlcollection(oReader, "Values", "Item") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Values") )
               {
                  GXSoapError = oReader.read() ;
               }
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
         sName = "QueryViewerItemDoubleClickData.Element" ;
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
      oWriter.writeElement("Name", GXutil.rtrim( gxTv_SdtQueryViewerItemDoubleClickData_Element_Name));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( gxTv_SdtQueryViewerItemDoubleClickData_Element_Values != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "ProjectThani" ;
         }
         else
         {
            sNameSpace1 = "ProjectThani" ;
         }
         gxTv_SdtQueryViewerItemDoubleClickData_Element_Values.writexmlcollection(oWriter, "Values", sNameSpace1, "Item", sNameSpace1);
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
      AddObjectProperty("Name", gxTv_SdtQueryViewerItemDoubleClickData_Element_Name, false, false);
      if ( gxTv_SdtQueryViewerItemDoubleClickData_Element_Values != null )
      {
         AddObjectProperty("Values", gxTv_SdtQueryViewerItemDoubleClickData_Element_Values, false, false);
      }
   }

   public String getgxTv_SdtQueryViewerItemDoubleClickData_Element_Name( )
   {
      return gxTv_SdtQueryViewerItemDoubleClickData_Element_Name ;
   }

   public void setgxTv_SdtQueryViewerItemDoubleClickData_Element_Name( String value )
   {
      gxTv_SdtQueryViewerItemDoubleClickData_Element_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemDoubleClickData_Element_Name = value ;
   }

   public GXSimpleCollection<String> getgxTv_SdtQueryViewerItemDoubleClickData_Element_Values( )
   {
      if ( gxTv_SdtQueryViewerItemDoubleClickData_Element_Values == null )
      {
         gxTv_SdtQueryViewerItemDoubleClickData_Element_Values = new GXSimpleCollection<String>(String.class, "internal", "");
      }
      gxTv_SdtQueryViewerItemDoubleClickData_Element_Values_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemDoubleClickData_Element_N = (byte)(0) ;
      return gxTv_SdtQueryViewerItemDoubleClickData_Element_Values ;
   }

   public void setgxTv_SdtQueryViewerItemDoubleClickData_Element_Values( GXSimpleCollection<String> value )
   {
      gxTv_SdtQueryViewerItemDoubleClickData_Element_Values_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemDoubleClickData_Element_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemDoubleClickData_Element_Values = value ;
   }

   public void setgxTv_SdtQueryViewerItemDoubleClickData_Element_Values_SetNull( )
   {
      gxTv_SdtQueryViewerItemDoubleClickData_Element_Values_N = (byte)(1) ;
      gxTv_SdtQueryViewerItemDoubleClickData_Element_Values = null ;
   }

   public boolean getgxTv_SdtQueryViewerItemDoubleClickData_Element_Values_IsNull( )
   {
      if ( gxTv_SdtQueryViewerItemDoubleClickData_Element_Values == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtQueryViewerItemDoubleClickData_Element_Values_N( )
   {
      return gxTv_SdtQueryViewerItemDoubleClickData_Element_Values_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtQueryViewerItemDoubleClickData_Element_Name = "" ;
      gxTv_SdtQueryViewerItemDoubleClickData_Element_N = (byte)(1) ;
      gxTv_SdtQueryViewerItemDoubleClickData_Element_Values_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtQueryViewerItemDoubleClickData_Element_N ;
   }

   public com.projectthani.SdtQueryViewerItemDoubleClickData_Element Clone( )
   {
      return (com.projectthani.SdtQueryViewerItemDoubleClickData_Element)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtQueryViewerItemDoubleClickData_Element struct )
   {
      setgxTv_SdtQueryViewerItemDoubleClickData_Element_Name(struct.getName());
      setgxTv_SdtQueryViewerItemDoubleClickData_Element_Values(new GXSimpleCollection<String>(String.class, "internal", "", struct.getValues()));
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtQueryViewerItemDoubleClickData_Element getStruct( )
   {
      com.projectthani.StructSdtQueryViewerItemDoubleClickData_Element struct = new com.projectthani.StructSdtQueryViewerItemDoubleClickData_Element ();
      struct.setName(getgxTv_SdtQueryViewerItemDoubleClickData_Element_Name());
      struct.setValues(getgxTv_SdtQueryViewerItemDoubleClickData_Element_Values().getStruct());
      return struct ;
   }

   protected byte gxTv_SdtQueryViewerItemDoubleClickData_Element_N ;
   protected byte gxTv_SdtQueryViewerItemDoubleClickData_Element_Values_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtQueryViewerItemDoubleClickData_Element_Name ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected GXSimpleCollection<String> gxTv_SdtQueryViewerItemDoubleClickData_Element_Values=null ;
}

