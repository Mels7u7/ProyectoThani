package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtQueryViewerItemDoubleClickData extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtQueryViewerItemDoubleClickData( )
   {
      this(  new ModelContext(SdtQueryViewerItemDoubleClickData.class));
   }

   public SdtQueryViewerItemDoubleClickData( ModelContext context )
   {
      super( context, "SdtQueryViewerItemDoubleClickData");
   }

   public SdtQueryViewerItemDoubleClickData( int remoteHandle ,
                                             ModelContext context )
   {
      super( remoteHandle, context, "SdtQueryViewerItemDoubleClickData");
   }

   public SdtQueryViewerItemDoubleClickData( StructSdtQueryViewerItemDoubleClickData struct )
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
               gxTv_SdtQueryViewerItemDoubleClickData_Name = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Type") )
            {
               gxTv_SdtQueryViewerItemDoubleClickData_Type = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Axis") )
            {
               gxTv_SdtQueryViewerItemDoubleClickData_Axis = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Value") )
            {
               gxTv_SdtQueryViewerItemDoubleClickData_Value = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Context") )
            {
               if ( gxTv_SdtQueryViewerItemDoubleClickData_Context == null )
               {
                  gxTv_SdtQueryViewerItemDoubleClickData_Context = new GXBaseCollection<com.projectthani.SdtQueryViewerItemDoubleClickData_Element>(com.projectthani.SdtQueryViewerItemDoubleClickData_Element.class, "QueryViewerItemDoubleClickData.Element", "ProjectThani", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_SdtQueryViewerItemDoubleClickData_Context.readxmlcollection(oReader, "Context", "Element") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Context") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Filters") )
            {
               if ( gxTv_SdtQueryViewerItemDoubleClickData_Filters == null )
               {
                  gxTv_SdtQueryViewerItemDoubleClickData_Filters = new GXBaseCollection<com.projectthani.SdtQueryViewerItemDoubleClickData_Filter>(com.projectthani.SdtQueryViewerItemDoubleClickData_Filter.class, "QueryViewerItemDoubleClickData.Filter", "ProjectThani", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_SdtQueryViewerItemDoubleClickData_Filters.readxmlcollection(oReader, "Filters", "Filter") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Filters") )
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
         sName = "QueryViewerItemDoubleClickData" ;
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
      oWriter.writeElement("Name", GXutil.rtrim( gxTv_SdtQueryViewerItemDoubleClickData_Name));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Type", GXutil.rtrim( gxTv_SdtQueryViewerItemDoubleClickData_Type));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Axis", GXutil.rtrim( gxTv_SdtQueryViewerItemDoubleClickData_Axis));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Value", GXutil.rtrim( gxTv_SdtQueryViewerItemDoubleClickData_Value));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( gxTv_SdtQueryViewerItemDoubleClickData_Context != null )
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
         gxTv_SdtQueryViewerItemDoubleClickData_Context.writexmlcollection(oWriter, "Context", sNameSpace1, "Element", sNameSpace1);
      }
      if ( gxTv_SdtQueryViewerItemDoubleClickData_Filters != null )
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
         gxTv_SdtQueryViewerItemDoubleClickData_Filters.writexmlcollection(oWriter, "Filters", sNameSpace1, "Filter", sNameSpace1);
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
      AddObjectProperty("Name", gxTv_SdtQueryViewerItemDoubleClickData_Name, false, false);
      AddObjectProperty("Type", gxTv_SdtQueryViewerItemDoubleClickData_Type, false, false);
      AddObjectProperty("Axis", gxTv_SdtQueryViewerItemDoubleClickData_Axis, false, false);
      AddObjectProperty("Value", gxTv_SdtQueryViewerItemDoubleClickData_Value, false, false);
      if ( gxTv_SdtQueryViewerItemDoubleClickData_Context != null )
      {
         AddObjectProperty("Context", gxTv_SdtQueryViewerItemDoubleClickData_Context, false, false);
      }
      if ( gxTv_SdtQueryViewerItemDoubleClickData_Filters != null )
      {
         AddObjectProperty("Filters", gxTv_SdtQueryViewerItemDoubleClickData_Filters, false, false);
      }
   }

   public String getgxTv_SdtQueryViewerItemDoubleClickData_Name( )
   {
      return gxTv_SdtQueryViewerItemDoubleClickData_Name ;
   }

   public void setgxTv_SdtQueryViewerItemDoubleClickData_Name( String value )
   {
      gxTv_SdtQueryViewerItemDoubleClickData_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemDoubleClickData_Name = value ;
   }

   public String getgxTv_SdtQueryViewerItemDoubleClickData_Type( )
   {
      return gxTv_SdtQueryViewerItemDoubleClickData_Type ;
   }

   public void setgxTv_SdtQueryViewerItemDoubleClickData_Type( String value )
   {
      gxTv_SdtQueryViewerItemDoubleClickData_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemDoubleClickData_Type = value ;
   }

   public String getgxTv_SdtQueryViewerItemDoubleClickData_Axis( )
   {
      return gxTv_SdtQueryViewerItemDoubleClickData_Axis ;
   }

   public void setgxTv_SdtQueryViewerItemDoubleClickData_Axis( String value )
   {
      gxTv_SdtQueryViewerItemDoubleClickData_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemDoubleClickData_Axis = value ;
   }

   public String getgxTv_SdtQueryViewerItemDoubleClickData_Value( )
   {
      return gxTv_SdtQueryViewerItemDoubleClickData_Value ;
   }

   public void setgxTv_SdtQueryViewerItemDoubleClickData_Value( String value )
   {
      gxTv_SdtQueryViewerItemDoubleClickData_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemDoubleClickData_Value = value ;
   }

   public GXBaseCollection<com.projectthani.SdtQueryViewerItemDoubleClickData_Element> getgxTv_SdtQueryViewerItemDoubleClickData_Context( )
   {
      if ( gxTv_SdtQueryViewerItemDoubleClickData_Context == null )
      {
         gxTv_SdtQueryViewerItemDoubleClickData_Context = new GXBaseCollection<com.projectthani.SdtQueryViewerItemDoubleClickData_Element>(com.projectthani.SdtQueryViewerItemDoubleClickData_Element.class, "QueryViewerItemDoubleClickData.Element", "ProjectThani", remoteHandle);
      }
      gxTv_SdtQueryViewerItemDoubleClickData_Context_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemDoubleClickData_N = (byte)(0) ;
      return gxTv_SdtQueryViewerItemDoubleClickData_Context ;
   }

   public void setgxTv_SdtQueryViewerItemDoubleClickData_Context( GXBaseCollection<com.projectthani.SdtQueryViewerItemDoubleClickData_Element> value )
   {
      gxTv_SdtQueryViewerItemDoubleClickData_Context_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemDoubleClickData_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemDoubleClickData_Context = value ;
   }

   public void setgxTv_SdtQueryViewerItemDoubleClickData_Context_SetNull( )
   {
      gxTv_SdtQueryViewerItemDoubleClickData_Context_N = (byte)(1) ;
      gxTv_SdtQueryViewerItemDoubleClickData_Context = null ;
   }

   public boolean getgxTv_SdtQueryViewerItemDoubleClickData_Context_IsNull( )
   {
      if ( gxTv_SdtQueryViewerItemDoubleClickData_Context == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtQueryViewerItemDoubleClickData_Context_N( )
   {
      return gxTv_SdtQueryViewerItemDoubleClickData_Context_N ;
   }

   public GXBaseCollection<com.projectthani.SdtQueryViewerItemDoubleClickData_Filter> getgxTv_SdtQueryViewerItemDoubleClickData_Filters( )
   {
      if ( gxTv_SdtQueryViewerItemDoubleClickData_Filters == null )
      {
         gxTv_SdtQueryViewerItemDoubleClickData_Filters = new GXBaseCollection<com.projectthani.SdtQueryViewerItemDoubleClickData_Filter>(com.projectthani.SdtQueryViewerItemDoubleClickData_Filter.class, "QueryViewerItemDoubleClickData.Filter", "ProjectThani", remoteHandle);
      }
      gxTv_SdtQueryViewerItemDoubleClickData_Filters_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemDoubleClickData_N = (byte)(0) ;
      return gxTv_SdtQueryViewerItemDoubleClickData_Filters ;
   }

   public void setgxTv_SdtQueryViewerItemDoubleClickData_Filters( GXBaseCollection<com.projectthani.SdtQueryViewerItemDoubleClickData_Filter> value )
   {
      gxTv_SdtQueryViewerItemDoubleClickData_Filters_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemDoubleClickData_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemDoubleClickData_Filters = value ;
   }

   public void setgxTv_SdtQueryViewerItemDoubleClickData_Filters_SetNull( )
   {
      gxTv_SdtQueryViewerItemDoubleClickData_Filters_N = (byte)(1) ;
      gxTv_SdtQueryViewerItemDoubleClickData_Filters = null ;
   }

   public boolean getgxTv_SdtQueryViewerItemDoubleClickData_Filters_IsNull( )
   {
      if ( gxTv_SdtQueryViewerItemDoubleClickData_Filters == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtQueryViewerItemDoubleClickData_Filters_N( )
   {
      return gxTv_SdtQueryViewerItemDoubleClickData_Filters_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtQueryViewerItemDoubleClickData_Name = "" ;
      gxTv_SdtQueryViewerItemDoubleClickData_N = (byte)(1) ;
      gxTv_SdtQueryViewerItemDoubleClickData_Type = "" ;
      gxTv_SdtQueryViewerItemDoubleClickData_Axis = "" ;
      gxTv_SdtQueryViewerItemDoubleClickData_Value = "" ;
      gxTv_SdtQueryViewerItemDoubleClickData_Context_N = (byte)(1) ;
      gxTv_SdtQueryViewerItemDoubleClickData_Filters_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtQueryViewerItemDoubleClickData_N ;
   }

   public com.projectthani.SdtQueryViewerItemDoubleClickData Clone( )
   {
      return (com.projectthani.SdtQueryViewerItemDoubleClickData)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtQueryViewerItemDoubleClickData struct )
   {
      setgxTv_SdtQueryViewerItemDoubleClickData_Name(struct.getName());
      setgxTv_SdtQueryViewerItemDoubleClickData_Type(struct.getType());
      setgxTv_SdtQueryViewerItemDoubleClickData_Axis(struct.getAxis());
      setgxTv_SdtQueryViewerItemDoubleClickData_Value(struct.getValue());
      GXBaseCollection<com.projectthani.SdtQueryViewerItemDoubleClickData_Element> gxTv_SdtQueryViewerItemDoubleClickData_Context_aux = new GXBaseCollection<com.projectthani.SdtQueryViewerItemDoubleClickData_Element>(com.projectthani.SdtQueryViewerItemDoubleClickData_Element.class, "QueryViewerItemDoubleClickData.Element", "ProjectThani", remoteHandle);
      Vector<com.projectthani.StructSdtQueryViewerItemDoubleClickData_Element> gxTv_SdtQueryViewerItemDoubleClickData_Context_aux1 = struct.getContext();
      if (gxTv_SdtQueryViewerItemDoubleClickData_Context_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtQueryViewerItemDoubleClickData_Context_aux1.size(); i++)
         {
            gxTv_SdtQueryViewerItemDoubleClickData_Context_aux.add(new com.projectthani.SdtQueryViewerItemDoubleClickData_Element(gxTv_SdtQueryViewerItemDoubleClickData_Context_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtQueryViewerItemDoubleClickData_Context(gxTv_SdtQueryViewerItemDoubleClickData_Context_aux);
      GXBaseCollection<com.projectthani.SdtQueryViewerItemDoubleClickData_Filter> gxTv_SdtQueryViewerItemDoubleClickData_Filters_aux = new GXBaseCollection<com.projectthani.SdtQueryViewerItemDoubleClickData_Filter>(com.projectthani.SdtQueryViewerItemDoubleClickData_Filter.class, "QueryViewerItemDoubleClickData.Filter", "ProjectThani", remoteHandle);
      Vector<com.projectthani.StructSdtQueryViewerItemDoubleClickData_Filter> gxTv_SdtQueryViewerItemDoubleClickData_Filters_aux1 = struct.getFilters();
      if (gxTv_SdtQueryViewerItemDoubleClickData_Filters_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtQueryViewerItemDoubleClickData_Filters_aux1.size(); i++)
         {
            gxTv_SdtQueryViewerItemDoubleClickData_Filters_aux.add(new com.projectthani.SdtQueryViewerItemDoubleClickData_Filter(gxTv_SdtQueryViewerItemDoubleClickData_Filters_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtQueryViewerItemDoubleClickData_Filters(gxTv_SdtQueryViewerItemDoubleClickData_Filters_aux);
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtQueryViewerItemDoubleClickData getStruct( )
   {
      com.projectthani.StructSdtQueryViewerItemDoubleClickData struct = new com.projectthani.StructSdtQueryViewerItemDoubleClickData ();
      struct.setName(getgxTv_SdtQueryViewerItemDoubleClickData_Name());
      struct.setType(getgxTv_SdtQueryViewerItemDoubleClickData_Type());
      struct.setAxis(getgxTv_SdtQueryViewerItemDoubleClickData_Axis());
      struct.setValue(getgxTv_SdtQueryViewerItemDoubleClickData_Value());
      struct.setContext(getgxTv_SdtQueryViewerItemDoubleClickData_Context().getStruct());
      struct.setFilters(getgxTv_SdtQueryViewerItemDoubleClickData_Filters().getStruct());
      return struct ;
   }

   protected byte gxTv_SdtQueryViewerItemDoubleClickData_N ;
   protected byte gxTv_SdtQueryViewerItemDoubleClickData_Context_N ;
   protected byte gxTv_SdtQueryViewerItemDoubleClickData_Filters_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtQueryViewerItemDoubleClickData_Name ;
   protected String gxTv_SdtQueryViewerItemDoubleClickData_Type ;
   protected String gxTv_SdtQueryViewerItemDoubleClickData_Axis ;
   protected String gxTv_SdtQueryViewerItemDoubleClickData_Value ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected GXBaseCollection<com.projectthani.SdtQueryViewerItemDoubleClickData_Element> gxTv_SdtQueryViewerItemDoubleClickData_Context_aux ;
   protected GXBaseCollection<com.projectthani.SdtQueryViewerItemDoubleClickData_Filter> gxTv_SdtQueryViewerItemDoubleClickData_Filters_aux ;
   protected GXBaseCollection<com.projectthani.SdtQueryViewerItemDoubleClickData_Element> gxTv_SdtQueryViewerItemDoubleClickData_Context=null ;
   protected GXBaseCollection<com.projectthani.SdtQueryViewerItemDoubleClickData_Filter> gxTv_SdtQueryViewerItemDoubleClickData_Filters=null ;
}

