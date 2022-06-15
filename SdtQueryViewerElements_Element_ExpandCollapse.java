package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtQueryViewerElements_Element_ExpandCollapse extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtQueryViewerElements_Element_ExpandCollapse( )
   {
      this(  new ModelContext(SdtQueryViewerElements_Element_ExpandCollapse.class));
   }

   public SdtQueryViewerElements_Element_ExpandCollapse( ModelContext context )
   {
      super( context, "SdtQueryViewerElements_Element_ExpandCollapse");
   }

   public SdtQueryViewerElements_Element_ExpandCollapse( int remoteHandle ,
                                                         ModelContext context )
   {
      super( remoteHandle, context, "SdtQueryViewerElements_Element_ExpandCollapse");
   }

   public SdtQueryViewerElements_Element_ExpandCollapse( StructSdtQueryViewerElements_Element_ExpandCollapse struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Type") )
            {
               gxTv_SdtQueryViewerElements_Element_ExpandCollapse_Type = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Values") )
            {
               if ( gxTv_SdtQueryViewerElements_Element_ExpandCollapse_Values == null )
               {
                  gxTv_SdtQueryViewerElements_Element_ExpandCollapse_Values = new GXSimpleCollection<String>(String.class, "internal", "");
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_SdtQueryViewerElements_Element_ExpandCollapse_Values.readxmlcollection(oReader, "Values", "Value") ;
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
         sName = "QueryViewerElements.Element.ExpandCollapse" ;
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
      oWriter.writeElement("Type", GXutil.rtrim( gxTv_SdtQueryViewerElements_Element_ExpandCollapse_Type));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( gxTv_SdtQueryViewerElements_Element_ExpandCollapse_Values != null )
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
         gxTv_SdtQueryViewerElements_Element_ExpandCollapse_Values.writexmlcollection(oWriter, "Values", sNameSpace1, "Value", sNameSpace1);
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
      AddObjectProperty("Type", gxTv_SdtQueryViewerElements_Element_ExpandCollapse_Type, false, false);
      if ( gxTv_SdtQueryViewerElements_Element_ExpandCollapse_Values != null )
      {
         AddObjectProperty("Values", gxTv_SdtQueryViewerElements_Element_ExpandCollapse_Values, false, false);
      }
   }

   public String getgxTv_SdtQueryViewerElements_Element_ExpandCollapse_Type( )
   {
      return gxTv_SdtQueryViewerElements_Element_ExpandCollapse_Type ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_ExpandCollapse_Type( String value )
   {
      gxTv_SdtQueryViewerElements_Element_ExpandCollapse_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_ExpandCollapse_Type = value ;
   }

   public GXSimpleCollection<String> getgxTv_SdtQueryViewerElements_Element_ExpandCollapse_Values( )
   {
      if ( gxTv_SdtQueryViewerElements_Element_ExpandCollapse_Values == null )
      {
         gxTv_SdtQueryViewerElements_Element_ExpandCollapse_Values = new GXSimpleCollection<String>(String.class, "internal", "");
      }
      gxTv_SdtQueryViewerElements_Element_ExpandCollapse_Values_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_ExpandCollapse_N = (byte)(0) ;
      return gxTv_SdtQueryViewerElements_Element_ExpandCollapse_Values ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_ExpandCollapse_Values( GXSimpleCollection<String> value )
   {
      gxTv_SdtQueryViewerElements_Element_ExpandCollapse_Values_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_ExpandCollapse_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_ExpandCollapse_Values = value ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_ExpandCollapse_Values_SetNull( )
   {
      gxTv_SdtQueryViewerElements_Element_ExpandCollapse_Values_N = (byte)(1) ;
      gxTv_SdtQueryViewerElements_Element_ExpandCollapse_Values = null ;
   }

   public boolean getgxTv_SdtQueryViewerElements_Element_ExpandCollapse_Values_IsNull( )
   {
      if ( gxTv_SdtQueryViewerElements_Element_ExpandCollapse_Values == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtQueryViewerElements_Element_ExpandCollapse_Values_N( )
   {
      return gxTv_SdtQueryViewerElements_Element_ExpandCollapse_Values_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtQueryViewerElements_Element_ExpandCollapse_Type = "" ;
      gxTv_SdtQueryViewerElements_Element_ExpandCollapse_N = (byte)(1) ;
      gxTv_SdtQueryViewerElements_Element_ExpandCollapse_Values_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtQueryViewerElements_Element_ExpandCollapse_N ;
   }

   public com.projectthani.SdtQueryViewerElements_Element_ExpandCollapse Clone( )
   {
      return (com.projectthani.SdtQueryViewerElements_Element_ExpandCollapse)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtQueryViewerElements_Element_ExpandCollapse struct )
   {
      setgxTv_SdtQueryViewerElements_Element_ExpandCollapse_Type(struct.getType());
      setgxTv_SdtQueryViewerElements_Element_ExpandCollapse_Values(new GXSimpleCollection<String>(String.class, "internal", "", struct.getValues()));
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtQueryViewerElements_Element_ExpandCollapse getStruct( )
   {
      com.projectthani.StructSdtQueryViewerElements_Element_ExpandCollapse struct = new com.projectthani.StructSdtQueryViewerElements_Element_ExpandCollapse ();
      struct.setType(getgxTv_SdtQueryViewerElements_Element_ExpandCollapse_Type());
      struct.setValues(getgxTv_SdtQueryViewerElements_Element_ExpandCollapse_Values().getStruct());
      return struct ;
   }

   protected byte gxTv_SdtQueryViewerElements_Element_ExpandCollapse_N ;
   protected byte gxTv_SdtQueryViewerElements_Element_ExpandCollapse_Values_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtQueryViewerElements_Element_ExpandCollapse_Type ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected GXSimpleCollection<String> gxTv_SdtQueryViewerElements_Element_ExpandCollapse_Values=null ;
}

