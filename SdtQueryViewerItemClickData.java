package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtQueryViewerItemClickData extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtQueryViewerItemClickData( )
   {
      this(  new ModelContext(SdtQueryViewerItemClickData.class));
   }

   public SdtQueryViewerItemClickData( ModelContext context )
   {
      super( context, "SdtQueryViewerItemClickData");
   }

   public SdtQueryViewerItemClickData( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle, context, "SdtQueryViewerItemClickData");
   }

   public SdtQueryViewerItemClickData( StructSdtQueryViewerItemClickData struct )
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
               gxTv_SdtQueryViewerItemClickData_Name = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Type") )
            {
               gxTv_SdtQueryViewerItemClickData_Type = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Axis") )
            {
               gxTv_SdtQueryViewerItemClickData_Axis = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Value") )
            {
               gxTv_SdtQueryViewerItemClickData_Value = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Selected") )
            {
               gxTv_SdtQueryViewerItemClickData_Selected = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Context") )
            {
               if ( gxTv_SdtQueryViewerItemClickData_Context == null )
               {
                  gxTv_SdtQueryViewerItemClickData_Context = new GXBaseCollection<com.projectthani.SdtQueryViewerItemClickData_Element>(com.projectthani.SdtQueryViewerItemClickData_Element.class, "QueryViewerItemClickData.Element", "ProjectThani", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_SdtQueryViewerItemClickData_Context.readxmlcollection(oReader, "Context", "Element") ;
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
               if ( gxTv_SdtQueryViewerItemClickData_Filters == null )
               {
                  gxTv_SdtQueryViewerItemClickData_Filters = new GXBaseCollection<com.projectthani.SdtQueryViewerItemClickData_Filter>(com.projectthani.SdtQueryViewerItemClickData_Filter.class, "QueryViewerItemClickData.Filter", "ProjectThani", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_SdtQueryViewerItemClickData_Filters.readxmlcollection(oReader, "Filters", "Filter") ;
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
         sName = "QueryViewerItemClickData" ;
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
      oWriter.writeElement("Name", GXutil.rtrim( gxTv_SdtQueryViewerItemClickData_Name));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Type", GXutil.rtrim( gxTv_SdtQueryViewerItemClickData_Type));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Axis", GXutil.rtrim( gxTv_SdtQueryViewerItemClickData_Axis));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Value", GXutil.rtrim( gxTv_SdtQueryViewerItemClickData_Value));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Selected", GXutil.rtrim( GXutil.booltostr( gxTv_SdtQueryViewerItemClickData_Selected)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( gxTv_SdtQueryViewerItemClickData_Context != null )
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
         gxTv_SdtQueryViewerItemClickData_Context.writexmlcollection(oWriter, "Context", sNameSpace1, "Element", sNameSpace1);
      }
      if ( gxTv_SdtQueryViewerItemClickData_Filters != null )
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
         gxTv_SdtQueryViewerItemClickData_Filters.writexmlcollection(oWriter, "Filters", sNameSpace1, "Filter", sNameSpace1);
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
      AddObjectProperty("Name", gxTv_SdtQueryViewerItemClickData_Name, false, false);
      AddObjectProperty("Type", gxTv_SdtQueryViewerItemClickData_Type, false, false);
      AddObjectProperty("Axis", gxTv_SdtQueryViewerItemClickData_Axis, false, false);
      AddObjectProperty("Value", gxTv_SdtQueryViewerItemClickData_Value, false, false);
      AddObjectProperty("Selected", gxTv_SdtQueryViewerItemClickData_Selected, false, false);
      if ( gxTv_SdtQueryViewerItemClickData_Context != null )
      {
         AddObjectProperty("Context", gxTv_SdtQueryViewerItemClickData_Context, false, false);
      }
      if ( gxTv_SdtQueryViewerItemClickData_Filters != null )
      {
         AddObjectProperty("Filters", gxTv_SdtQueryViewerItemClickData_Filters, false, false);
      }
   }

   public String getgxTv_SdtQueryViewerItemClickData_Name( )
   {
      return gxTv_SdtQueryViewerItemClickData_Name ;
   }

   public void setgxTv_SdtQueryViewerItemClickData_Name( String value )
   {
      gxTv_SdtQueryViewerItemClickData_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemClickData_Name = value ;
   }

   public String getgxTv_SdtQueryViewerItemClickData_Type( )
   {
      return gxTv_SdtQueryViewerItemClickData_Type ;
   }

   public void setgxTv_SdtQueryViewerItemClickData_Type( String value )
   {
      gxTv_SdtQueryViewerItemClickData_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemClickData_Type = value ;
   }

   public String getgxTv_SdtQueryViewerItemClickData_Axis( )
   {
      return gxTv_SdtQueryViewerItemClickData_Axis ;
   }

   public void setgxTv_SdtQueryViewerItemClickData_Axis( String value )
   {
      gxTv_SdtQueryViewerItemClickData_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemClickData_Axis = value ;
   }

   public String getgxTv_SdtQueryViewerItemClickData_Value( )
   {
      return gxTv_SdtQueryViewerItemClickData_Value ;
   }

   public void setgxTv_SdtQueryViewerItemClickData_Value( String value )
   {
      gxTv_SdtQueryViewerItemClickData_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemClickData_Value = value ;
   }

   public boolean getgxTv_SdtQueryViewerItemClickData_Selected( )
   {
      return gxTv_SdtQueryViewerItemClickData_Selected ;
   }

   public void setgxTv_SdtQueryViewerItemClickData_Selected( boolean value )
   {
      gxTv_SdtQueryViewerItemClickData_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemClickData_Selected = value ;
   }

   public GXBaseCollection<com.projectthani.SdtQueryViewerItemClickData_Element> getgxTv_SdtQueryViewerItemClickData_Context( )
   {
      if ( gxTv_SdtQueryViewerItemClickData_Context == null )
      {
         gxTv_SdtQueryViewerItemClickData_Context = new GXBaseCollection<com.projectthani.SdtQueryViewerItemClickData_Element>(com.projectthani.SdtQueryViewerItemClickData_Element.class, "QueryViewerItemClickData.Element", "ProjectThani", remoteHandle);
      }
      gxTv_SdtQueryViewerItemClickData_Context_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemClickData_N = (byte)(0) ;
      return gxTv_SdtQueryViewerItemClickData_Context ;
   }

   public void setgxTv_SdtQueryViewerItemClickData_Context( GXBaseCollection<com.projectthani.SdtQueryViewerItemClickData_Element> value )
   {
      gxTv_SdtQueryViewerItemClickData_Context_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemClickData_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemClickData_Context = value ;
   }

   public void setgxTv_SdtQueryViewerItemClickData_Context_SetNull( )
   {
      gxTv_SdtQueryViewerItemClickData_Context_N = (byte)(1) ;
      gxTv_SdtQueryViewerItemClickData_Context = null ;
   }

   public boolean getgxTv_SdtQueryViewerItemClickData_Context_IsNull( )
   {
      if ( gxTv_SdtQueryViewerItemClickData_Context == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtQueryViewerItemClickData_Context_N( )
   {
      return gxTv_SdtQueryViewerItemClickData_Context_N ;
   }

   public GXBaseCollection<com.projectthani.SdtQueryViewerItemClickData_Filter> getgxTv_SdtQueryViewerItemClickData_Filters( )
   {
      if ( gxTv_SdtQueryViewerItemClickData_Filters == null )
      {
         gxTv_SdtQueryViewerItemClickData_Filters = new GXBaseCollection<com.projectthani.SdtQueryViewerItemClickData_Filter>(com.projectthani.SdtQueryViewerItemClickData_Filter.class, "QueryViewerItemClickData.Filter", "ProjectThani", remoteHandle);
      }
      gxTv_SdtQueryViewerItemClickData_Filters_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemClickData_N = (byte)(0) ;
      return gxTv_SdtQueryViewerItemClickData_Filters ;
   }

   public void setgxTv_SdtQueryViewerItemClickData_Filters( GXBaseCollection<com.projectthani.SdtQueryViewerItemClickData_Filter> value )
   {
      gxTv_SdtQueryViewerItemClickData_Filters_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemClickData_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemClickData_Filters = value ;
   }

   public void setgxTv_SdtQueryViewerItemClickData_Filters_SetNull( )
   {
      gxTv_SdtQueryViewerItemClickData_Filters_N = (byte)(1) ;
      gxTv_SdtQueryViewerItemClickData_Filters = null ;
   }

   public boolean getgxTv_SdtQueryViewerItemClickData_Filters_IsNull( )
   {
      if ( gxTv_SdtQueryViewerItemClickData_Filters == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtQueryViewerItemClickData_Filters_N( )
   {
      return gxTv_SdtQueryViewerItemClickData_Filters_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtQueryViewerItemClickData_Name = "" ;
      gxTv_SdtQueryViewerItemClickData_N = (byte)(1) ;
      gxTv_SdtQueryViewerItemClickData_Type = "" ;
      gxTv_SdtQueryViewerItemClickData_Axis = "" ;
      gxTv_SdtQueryViewerItemClickData_Value = "" ;
      gxTv_SdtQueryViewerItemClickData_Context_N = (byte)(1) ;
      gxTv_SdtQueryViewerItemClickData_Filters_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtQueryViewerItemClickData_N ;
   }

   public com.projectthani.SdtQueryViewerItemClickData Clone( )
   {
      return (com.projectthani.SdtQueryViewerItemClickData)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtQueryViewerItemClickData struct )
   {
      setgxTv_SdtQueryViewerItemClickData_Name(struct.getName());
      setgxTv_SdtQueryViewerItemClickData_Type(struct.getType());
      setgxTv_SdtQueryViewerItemClickData_Axis(struct.getAxis());
      setgxTv_SdtQueryViewerItemClickData_Value(struct.getValue());
      setgxTv_SdtQueryViewerItemClickData_Selected(struct.getSelected());
      GXBaseCollection<com.projectthani.SdtQueryViewerItemClickData_Element> gxTv_SdtQueryViewerItemClickData_Context_aux = new GXBaseCollection<com.projectthani.SdtQueryViewerItemClickData_Element>(com.projectthani.SdtQueryViewerItemClickData_Element.class, "QueryViewerItemClickData.Element", "ProjectThani", remoteHandle);
      Vector<com.projectthani.StructSdtQueryViewerItemClickData_Element> gxTv_SdtQueryViewerItemClickData_Context_aux1 = struct.getContext();
      if (gxTv_SdtQueryViewerItemClickData_Context_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtQueryViewerItemClickData_Context_aux1.size(); i++)
         {
            gxTv_SdtQueryViewerItemClickData_Context_aux.add(new com.projectthani.SdtQueryViewerItemClickData_Element(gxTv_SdtQueryViewerItemClickData_Context_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtQueryViewerItemClickData_Context(gxTv_SdtQueryViewerItemClickData_Context_aux);
      GXBaseCollection<com.projectthani.SdtQueryViewerItemClickData_Filter> gxTv_SdtQueryViewerItemClickData_Filters_aux = new GXBaseCollection<com.projectthani.SdtQueryViewerItemClickData_Filter>(com.projectthani.SdtQueryViewerItemClickData_Filter.class, "QueryViewerItemClickData.Filter", "ProjectThani", remoteHandle);
      Vector<com.projectthani.StructSdtQueryViewerItemClickData_Filter> gxTv_SdtQueryViewerItemClickData_Filters_aux1 = struct.getFilters();
      if (gxTv_SdtQueryViewerItemClickData_Filters_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtQueryViewerItemClickData_Filters_aux1.size(); i++)
         {
            gxTv_SdtQueryViewerItemClickData_Filters_aux.add(new com.projectthani.SdtQueryViewerItemClickData_Filter(gxTv_SdtQueryViewerItemClickData_Filters_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtQueryViewerItemClickData_Filters(gxTv_SdtQueryViewerItemClickData_Filters_aux);
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtQueryViewerItemClickData getStruct( )
   {
      com.projectthani.StructSdtQueryViewerItemClickData struct = new com.projectthani.StructSdtQueryViewerItemClickData ();
      struct.setName(getgxTv_SdtQueryViewerItemClickData_Name());
      struct.setType(getgxTv_SdtQueryViewerItemClickData_Type());
      struct.setAxis(getgxTv_SdtQueryViewerItemClickData_Axis());
      struct.setValue(getgxTv_SdtQueryViewerItemClickData_Value());
      struct.setSelected(getgxTv_SdtQueryViewerItemClickData_Selected());
      struct.setContext(getgxTv_SdtQueryViewerItemClickData_Context().getStruct());
      struct.setFilters(getgxTv_SdtQueryViewerItemClickData_Filters().getStruct());
      return struct ;
   }

   protected byte gxTv_SdtQueryViewerItemClickData_N ;
   protected byte gxTv_SdtQueryViewerItemClickData_Context_N ;
   protected byte gxTv_SdtQueryViewerItemClickData_Filters_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtQueryViewerItemClickData_Name ;
   protected String gxTv_SdtQueryViewerItemClickData_Type ;
   protected String gxTv_SdtQueryViewerItemClickData_Axis ;
   protected String gxTv_SdtQueryViewerItemClickData_Value ;
   protected String sTagName ;
   protected boolean gxTv_SdtQueryViewerItemClickData_Selected ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected GXBaseCollection<com.projectthani.SdtQueryViewerItemClickData_Element> gxTv_SdtQueryViewerItemClickData_Context_aux ;
   protected GXBaseCollection<com.projectthani.SdtQueryViewerItemClickData_Filter> gxTv_SdtQueryViewerItemClickData_Filters_aux ;
   protected GXBaseCollection<com.projectthani.SdtQueryViewerItemClickData_Element> gxTv_SdtQueryViewerItemClickData_Context=null ;
   protected GXBaseCollection<com.projectthani.SdtQueryViewerItemClickData_Filter> gxTv_SdtQueryViewerItemClickData_Filters=null ;
}

