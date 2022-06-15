package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtQueryViewerElements_Element extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtQueryViewerElements_Element( )
   {
      this(  new ModelContext(SdtQueryViewerElements_Element.class));
   }

   public SdtQueryViewerElements_Element( ModelContext context )
   {
      super( context, "SdtQueryViewerElements_Element");
   }

   public SdtQueryViewerElements_Element( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle, context, "SdtQueryViewerElements_Element");
   }

   public SdtQueryViewerElements_Element( StructSdtQueryViewerElements_Element struct )
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
               gxTv_SdtQueryViewerElements_Element_Name = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Title") )
            {
               gxTv_SdtQueryViewerElements_Element_Title = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Visible") )
            {
               gxTv_SdtQueryViewerElements_Element_Visible = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Type") )
            {
               gxTv_SdtQueryViewerElements_Element_Type = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Axis") )
            {
               gxTv_SdtQueryViewerElements_Element_Axis = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Aggregation") )
            {
               gxTv_SdtQueryViewerElements_Element_Aggregation = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DataField") )
            {
               gxTv_SdtQueryViewerElements_Element_Datafield = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Filter") )
            {
               if ( gxTv_SdtQueryViewerElements_Element_Filter == null )
               {
                  gxTv_SdtQueryViewerElements_Element_Filter = new com.projectthani.SdtQueryViewerElements_Element_Filter(remoteHandle, context);
               }
               GXSoapError = gxTv_SdtQueryViewerElements_Element_Filter.readxml(oReader, "Filter") ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ExpandCollapse") )
            {
               if ( gxTv_SdtQueryViewerElements_Element_Expandcollapse == null )
               {
                  gxTv_SdtQueryViewerElements_Element_Expandcollapse = new com.projectthani.SdtQueryViewerElements_Element_ExpandCollapse(remoteHandle, context);
               }
               GXSoapError = gxTv_SdtQueryViewerElements_Element_Expandcollapse.readxml(oReader, "ExpandCollapse") ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AxisOrder") )
            {
               if ( gxTv_SdtQueryViewerElements_Element_Axisorder == null )
               {
                  gxTv_SdtQueryViewerElements_Element_Axisorder = new com.projectthani.SdtQueryViewerElements_Element_AxisOrder(remoteHandle, context);
               }
               GXSoapError = gxTv_SdtQueryViewerElements_Element_Axisorder.readxml(oReader, "AxisOrder") ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Format") )
            {
               if ( gxTv_SdtQueryViewerElements_Element_Format == null )
               {
                  gxTv_SdtQueryViewerElements_Element_Format = new com.projectthani.SdtQueryViewerElements_Element_Format(remoteHandle, context);
               }
               GXSoapError = gxTv_SdtQueryViewerElements_Element_Format.readxml(oReader, "Format") ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Grouping") )
            {
               if ( gxTv_SdtQueryViewerElements_Element_Grouping == null )
               {
                  gxTv_SdtQueryViewerElements_Element_Grouping = new com.projectthani.SdtQueryViewerElements_Element_Grouping(remoteHandle, context);
               }
               GXSoapError = gxTv_SdtQueryViewerElements_Element_Grouping.readxml(oReader, "Grouping") ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Actions") )
            {
               if ( gxTv_SdtQueryViewerElements_Element_Actions == null )
               {
                  gxTv_SdtQueryViewerElements_Element_Actions = new com.projectthani.SdtQueryViewerElements_Element_Actions(remoteHandle, context);
               }
               GXSoapError = gxTv_SdtQueryViewerElements_Element_Actions.readxml(oReader, "Actions") ;
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
         sName = "QueryViewerElements.Element" ;
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
      oWriter.writeElement("Name", GXutil.rtrim( gxTv_SdtQueryViewerElements_Element_Name));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Title", GXutil.rtrim( gxTv_SdtQueryViewerElements_Element_Title));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Visible", GXutil.rtrim( gxTv_SdtQueryViewerElements_Element_Visible));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Type", GXutil.rtrim( gxTv_SdtQueryViewerElements_Element_Type));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Axis", GXutil.rtrim( gxTv_SdtQueryViewerElements_Element_Axis));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Aggregation", GXutil.rtrim( gxTv_SdtQueryViewerElements_Element_Aggregation));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("DataField", GXutil.rtrim( gxTv_SdtQueryViewerElements_Element_Datafield));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( gxTv_SdtQueryViewerElements_Element_Filter != null )
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
         gxTv_SdtQueryViewerElements_Element_Filter.writexml(oWriter, "Filter", sNameSpace1);
      }
      if ( gxTv_SdtQueryViewerElements_Element_Expandcollapse != null )
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
         gxTv_SdtQueryViewerElements_Element_Expandcollapse.writexml(oWriter, "ExpandCollapse", sNameSpace1);
      }
      if ( gxTv_SdtQueryViewerElements_Element_Axisorder != null )
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
         gxTv_SdtQueryViewerElements_Element_Axisorder.writexml(oWriter, "AxisOrder", sNameSpace1);
      }
      if ( gxTv_SdtQueryViewerElements_Element_Format != null )
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
         gxTv_SdtQueryViewerElements_Element_Format.writexml(oWriter, "Format", sNameSpace1);
      }
      if ( gxTv_SdtQueryViewerElements_Element_Grouping != null )
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
         gxTv_SdtQueryViewerElements_Element_Grouping.writexml(oWriter, "Grouping", sNameSpace1);
      }
      if ( gxTv_SdtQueryViewerElements_Element_Actions != null )
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
         gxTv_SdtQueryViewerElements_Element_Actions.writexml(oWriter, "Actions", sNameSpace1);
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
      AddObjectProperty("Name", gxTv_SdtQueryViewerElements_Element_Name, false, false);
      AddObjectProperty("Title", gxTv_SdtQueryViewerElements_Element_Title, false, false);
      AddObjectProperty("Visible", gxTv_SdtQueryViewerElements_Element_Visible, false, false);
      AddObjectProperty("Type", gxTv_SdtQueryViewerElements_Element_Type, false, false);
      AddObjectProperty("Axis", gxTv_SdtQueryViewerElements_Element_Axis, false, false);
      AddObjectProperty("Aggregation", gxTv_SdtQueryViewerElements_Element_Aggregation, false, false);
      AddObjectProperty("DataField", gxTv_SdtQueryViewerElements_Element_Datafield, false, false);
      if ( gxTv_SdtQueryViewerElements_Element_Filter != null )
      {
         AddObjectProperty("Filter", gxTv_SdtQueryViewerElements_Element_Filter, false, false);
      }
      if ( gxTv_SdtQueryViewerElements_Element_Expandcollapse != null )
      {
         AddObjectProperty("ExpandCollapse", gxTv_SdtQueryViewerElements_Element_Expandcollapse, false, false);
      }
      if ( gxTv_SdtQueryViewerElements_Element_Axisorder != null )
      {
         AddObjectProperty("AxisOrder", gxTv_SdtQueryViewerElements_Element_Axisorder, false, false);
      }
      if ( gxTv_SdtQueryViewerElements_Element_Format != null )
      {
         AddObjectProperty("Format", gxTv_SdtQueryViewerElements_Element_Format, false, false);
      }
      if ( gxTv_SdtQueryViewerElements_Element_Grouping != null )
      {
         AddObjectProperty("Grouping", gxTv_SdtQueryViewerElements_Element_Grouping, false, false);
      }
      if ( gxTv_SdtQueryViewerElements_Element_Actions != null )
      {
         AddObjectProperty("Actions", gxTv_SdtQueryViewerElements_Element_Actions, false, false);
      }
   }

   public String getgxTv_SdtQueryViewerElements_Element_Name( )
   {
      return gxTv_SdtQueryViewerElements_Element_Name ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Name( String value )
   {
      gxTv_SdtQueryViewerElements_Element_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Name = value ;
   }

   public String getgxTv_SdtQueryViewerElements_Element_Title( )
   {
      return gxTv_SdtQueryViewerElements_Element_Title ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Title( String value )
   {
      gxTv_SdtQueryViewerElements_Element_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Title = value ;
   }

   public String getgxTv_SdtQueryViewerElements_Element_Visible( )
   {
      return gxTv_SdtQueryViewerElements_Element_Visible ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Visible( String value )
   {
      gxTv_SdtQueryViewerElements_Element_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Visible = value ;
   }

   public String getgxTv_SdtQueryViewerElements_Element_Type( )
   {
      return gxTv_SdtQueryViewerElements_Element_Type ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Type( String value )
   {
      gxTv_SdtQueryViewerElements_Element_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Type = value ;
   }

   public String getgxTv_SdtQueryViewerElements_Element_Axis( )
   {
      return gxTv_SdtQueryViewerElements_Element_Axis ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Axis( String value )
   {
      gxTv_SdtQueryViewerElements_Element_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Axis = value ;
   }

   public String getgxTv_SdtQueryViewerElements_Element_Aggregation( )
   {
      return gxTv_SdtQueryViewerElements_Element_Aggregation ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Aggregation( String value )
   {
      gxTv_SdtQueryViewerElements_Element_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Aggregation = value ;
   }

   public String getgxTv_SdtQueryViewerElements_Element_Datafield( )
   {
      return gxTv_SdtQueryViewerElements_Element_Datafield ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Datafield( String value )
   {
      gxTv_SdtQueryViewerElements_Element_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Datafield = value ;
   }

   public com.projectthani.SdtQueryViewerElements_Element_Filter getgxTv_SdtQueryViewerElements_Element_Filter( )
   {
      if ( gxTv_SdtQueryViewerElements_Element_Filter == null )
      {
         gxTv_SdtQueryViewerElements_Element_Filter = new com.projectthani.SdtQueryViewerElements_Element_Filter(remoteHandle, context);
      }
      gxTv_SdtQueryViewerElements_Element_Filter_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_N = (byte)(0) ;
      return gxTv_SdtQueryViewerElements_Element_Filter ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Filter( com.projectthani.SdtQueryViewerElements_Element_Filter value )
   {
      gxTv_SdtQueryViewerElements_Element_Filter_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Filter = value;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Filter_SetNull( )
   {
      gxTv_SdtQueryViewerElements_Element_Filter_N = (byte)(1) ;
      gxTv_SdtQueryViewerElements_Element_Filter = (com.projectthani.SdtQueryViewerElements_Element_Filter)null;
   }

   public boolean getgxTv_SdtQueryViewerElements_Element_Filter_IsNull( )
   {
      if ( gxTv_SdtQueryViewerElements_Element_Filter == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtQueryViewerElements_Element_Filter_N( )
   {
      return gxTv_SdtQueryViewerElements_Element_Filter_N ;
   }

   public com.projectthani.SdtQueryViewerElements_Element_ExpandCollapse getgxTv_SdtQueryViewerElements_Element_Expandcollapse( )
   {
      if ( gxTv_SdtQueryViewerElements_Element_Expandcollapse == null )
      {
         gxTv_SdtQueryViewerElements_Element_Expandcollapse = new com.projectthani.SdtQueryViewerElements_Element_ExpandCollapse(remoteHandle, context);
      }
      gxTv_SdtQueryViewerElements_Element_Expandcollapse_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_N = (byte)(0) ;
      return gxTv_SdtQueryViewerElements_Element_Expandcollapse ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Expandcollapse( com.projectthani.SdtQueryViewerElements_Element_ExpandCollapse value )
   {
      gxTv_SdtQueryViewerElements_Element_Expandcollapse_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Expandcollapse = value;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Expandcollapse_SetNull( )
   {
      gxTv_SdtQueryViewerElements_Element_Expandcollapse_N = (byte)(1) ;
      gxTv_SdtQueryViewerElements_Element_Expandcollapse = (com.projectthani.SdtQueryViewerElements_Element_ExpandCollapse)null;
   }

   public boolean getgxTv_SdtQueryViewerElements_Element_Expandcollapse_IsNull( )
   {
      if ( gxTv_SdtQueryViewerElements_Element_Expandcollapse == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtQueryViewerElements_Element_Expandcollapse_N( )
   {
      return gxTv_SdtQueryViewerElements_Element_Expandcollapse_N ;
   }

   public com.projectthani.SdtQueryViewerElements_Element_AxisOrder getgxTv_SdtQueryViewerElements_Element_Axisorder( )
   {
      if ( gxTv_SdtQueryViewerElements_Element_Axisorder == null )
      {
         gxTv_SdtQueryViewerElements_Element_Axisorder = new com.projectthani.SdtQueryViewerElements_Element_AxisOrder(remoteHandle, context);
      }
      gxTv_SdtQueryViewerElements_Element_Axisorder_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_N = (byte)(0) ;
      return gxTv_SdtQueryViewerElements_Element_Axisorder ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Axisorder( com.projectthani.SdtQueryViewerElements_Element_AxisOrder value )
   {
      gxTv_SdtQueryViewerElements_Element_Axisorder_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Axisorder = value;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Axisorder_SetNull( )
   {
      gxTv_SdtQueryViewerElements_Element_Axisorder_N = (byte)(1) ;
      gxTv_SdtQueryViewerElements_Element_Axisorder = (com.projectthani.SdtQueryViewerElements_Element_AxisOrder)null;
   }

   public boolean getgxTv_SdtQueryViewerElements_Element_Axisorder_IsNull( )
   {
      if ( gxTv_SdtQueryViewerElements_Element_Axisorder == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtQueryViewerElements_Element_Axisorder_N( )
   {
      return gxTv_SdtQueryViewerElements_Element_Axisorder_N ;
   }

   public com.projectthani.SdtQueryViewerElements_Element_Format getgxTv_SdtQueryViewerElements_Element_Format( )
   {
      if ( gxTv_SdtQueryViewerElements_Element_Format == null )
      {
         gxTv_SdtQueryViewerElements_Element_Format = new com.projectthani.SdtQueryViewerElements_Element_Format(remoteHandle, context);
      }
      gxTv_SdtQueryViewerElements_Element_Format_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_N = (byte)(0) ;
      return gxTv_SdtQueryViewerElements_Element_Format ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Format( com.projectthani.SdtQueryViewerElements_Element_Format value )
   {
      gxTv_SdtQueryViewerElements_Element_Format_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Format = value;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Format_SetNull( )
   {
      gxTv_SdtQueryViewerElements_Element_Format_N = (byte)(1) ;
      gxTv_SdtQueryViewerElements_Element_Format = (com.projectthani.SdtQueryViewerElements_Element_Format)null;
   }

   public boolean getgxTv_SdtQueryViewerElements_Element_Format_IsNull( )
   {
      if ( gxTv_SdtQueryViewerElements_Element_Format == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtQueryViewerElements_Element_Format_N( )
   {
      return gxTv_SdtQueryViewerElements_Element_Format_N ;
   }

   public com.projectthani.SdtQueryViewerElements_Element_Grouping getgxTv_SdtQueryViewerElements_Element_Grouping( )
   {
      if ( gxTv_SdtQueryViewerElements_Element_Grouping == null )
      {
         gxTv_SdtQueryViewerElements_Element_Grouping = new com.projectthani.SdtQueryViewerElements_Element_Grouping(remoteHandle, context);
      }
      gxTv_SdtQueryViewerElements_Element_Grouping_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_N = (byte)(0) ;
      return gxTv_SdtQueryViewerElements_Element_Grouping ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Grouping( com.projectthani.SdtQueryViewerElements_Element_Grouping value )
   {
      gxTv_SdtQueryViewerElements_Element_Grouping_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Grouping = value;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Grouping_SetNull( )
   {
      gxTv_SdtQueryViewerElements_Element_Grouping_N = (byte)(1) ;
      gxTv_SdtQueryViewerElements_Element_Grouping = (com.projectthani.SdtQueryViewerElements_Element_Grouping)null;
   }

   public boolean getgxTv_SdtQueryViewerElements_Element_Grouping_IsNull( )
   {
      if ( gxTv_SdtQueryViewerElements_Element_Grouping == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtQueryViewerElements_Element_Grouping_N( )
   {
      return gxTv_SdtQueryViewerElements_Element_Grouping_N ;
   }

   public com.projectthani.SdtQueryViewerElements_Element_Actions getgxTv_SdtQueryViewerElements_Element_Actions( )
   {
      if ( gxTv_SdtQueryViewerElements_Element_Actions == null )
      {
         gxTv_SdtQueryViewerElements_Element_Actions = new com.projectthani.SdtQueryViewerElements_Element_Actions(remoteHandle, context);
      }
      gxTv_SdtQueryViewerElements_Element_Actions_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_N = (byte)(0) ;
      return gxTv_SdtQueryViewerElements_Element_Actions ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Actions( com.projectthani.SdtQueryViewerElements_Element_Actions value )
   {
      gxTv_SdtQueryViewerElements_Element_Actions_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Actions = value;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Actions_SetNull( )
   {
      gxTv_SdtQueryViewerElements_Element_Actions_N = (byte)(1) ;
      gxTv_SdtQueryViewerElements_Element_Actions = (com.projectthani.SdtQueryViewerElements_Element_Actions)null;
   }

   public boolean getgxTv_SdtQueryViewerElements_Element_Actions_IsNull( )
   {
      if ( gxTv_SdtQueryViewerElements_Element_Actions == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtQueryViewerElements_Element_Actions_N( )
   {
      return gxTv_SdtQueryViewerElements_Element_Actions_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtQueryViewerElements_Element_Name = "" ;
      gxTv_SdtQueryViewerElements_Element_N = (byte)(1) ;
      gxTv_SdtQueryViewerElements_Element_Title = "" ;
      gxTv_SdtQueryViewerElements_Element_Visible = "" ;
      gxTv_SdtQueryViewerElements_Element_Type = "" ;
      gxTv_SdtQueryViewerElements_Element_Axis = "" ;
      gxTv_SdtQueryViewerElements_Element_Aggregation = "" ;
      gxTv_SdtQueryViewerElements_Element_Datafield = "" ;
      gxTv_SdtQueryViewerElements_Element_Filter_N = (byte)(1) ;
      gxTv_SdtQueryViewerElements_Element_Expandcollapse_N = (byte)(1) ;
      gxTv_SdtQueryViewerElements_Element_Axisorder_N = (byte)(1) ;
      gxTv_SdtQueryViewerElements_Element_Format_N = (byte)(1) ;
      gxTv_SdtQueryViewerElements_Element_Grouping_N = (byte)(1) ;
      gxTv_SdtQueryViewerElements_Element_Actions_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtQueryViewerElements_Element_N ;
   }

   public com.projectthani.SdtQueryViewerElements_Element Clone( )
   {
      return (com.projectthani.SdtQueryViewerElements_Element)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtQueryViewerElements_Element struct )
   {
      setgxTv_SdtQueryViewerElements_Element_Name(struct.getName());
      setgxTv_SdtQueryViewerElements_Element_Title(struct.getTitle());
      setgxTv_SdtQueryViewerElements_Element_Visible(struct.getVisible());
      setgxTv_SdtQueryViewerElements_Element_Type(struct.getType());
      setgxTv_SdtQueryViewerElements_Element_Axis(struct.getAxis());
      setgxTv_SdtQueryViewerElements_Element_Aggregation(struct.getAggregation());
      setgxTv_SdtQueryViewerElements_Element_Datafield(struct.getDatafield());
      setgxTv_SdtQueryViewerElements_Element_Filter(new com.projectthani.SdtQueryViewerElements_Element_Filter(struct.getFilter()));
      setgxTv_SdtQueryViewerElements_Element_Expandcollapse(new com.projectthani.SdtQueryViewerElements_Element_ExpandCollapse(struct.getExpandcollapse()));
      setgxTv_SdtQueryViewerElements_Element_Axisorder(new com.projectthani.SdtQueryViewerElements_Element_AxisOrder(struct.getAxisorder()));
      setgxTv_SdtQueryViewerElements_Element_Format(new com.projectthani.SdtQueryViewerElements_Element_Format(struct.getFormat()));
      setgxTv_SdtQueryViewerElements_Element_Grouping(new com.projectthani.SdtQueryViewerElements_Element_Grouping(struct.getGrouping()));
      setgxTv_SdtQueryViewerElements_Element_Actions(new com.projectthani.SdtQueryViewerElements_Element_Actions(struct.getActions()));
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtQueryViewerElements_Element getStruct( )
   {
      com.projectthani.StructSdtQueryViewerElements_Element struct = new com.projectthani.StructSdtQueryViewerElements_Element ();
      struct.setName(getgxTv_SdtQueryViewerElements_Element_Name());
      struct.setTitle(getgxTv_SdtQueryViewerElements_Element_Title());
      struct.setVisible(getgxTv_SdtQueryViewerElements_Element_Visible());
      struct.setType(getgxTv_SdtQueryViewerElements_Element_Type());
      struct.setAxis(getgxTv_SdtQueryViewerElements_Element_Axis());
      struct.setAggregation(getgxTv_SdtQueryViewerElements_Element_Aggregation());
      struct.setDatafield(getgxTv_SdtQueryViewerElements_Element_Datafield());
      struct.setFilter(getgxTv_SdtQueryViewerElements_Element_Filter().getStruct());
      struct.setExpandcollapse(getgxTv_SdtQueryViewerElements_Element_Expandcollapse().getStruct());
      struct.setAxisorder(getgxTv_SdtQueryViewerElements_Element_Axisorder().getStruct());
      struct.setFormat(getgxTv_SdtQueryViewerElements_Element_Format().getStruct());
      struct.setGrouping(getgxTv_SdtQueryViewerElements_Element_Grouping().getStruct());
      struct.setActions(getgxTv_SdtQueryViewerElements_Element_Actions().getStruct());
      return struct ;
   }

   protected byte gxTv_SdtQueryViewerElements_Element_N ;
   protected byte gxTv_SdtQueryViewerElements_Element_Filter_N ;
   protected byte gxTv_SdtQueryViewerElements_Element_Expandcollapse_N ;
   protected byte gxTv_SdtQueryViewerElements_Element_Axisorder_N ;
   protected byte gxTv_SdtQueryViewerElements_Element_Format_N ;
   protected byte gxTv_SdtQueryViewerElements_Element_Grouping_N ;
   protected byte gxTv_SdtQueryViewerElements_Element_Actions_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtQueryViewerElements_Element_Name ;
   protected String gxTv_SdtQueryViewerElements_Element_Title ;
   protected String gxTv_SdtQueryViewerElements_Element_Visible ;
   protected String gxTv_SdtQueryViewerElements_Element_Type ;
   protected String gxTv_SdtQueryViewerElements_Element_Axis ;
   protected String gxTv_SdtQueryViewerElements_Element_Aggregation ;
   protected String gxTv_SdtQueryViewerElements_Element_Datafield ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected com.projectthani.SdtQueryViewerElements_Element_Filter gxTv_SdtQueryViewerElements_Element_Filter=null ;
   protected com.projectthani.SdtQueryViewerElements_Element_ExpandCollapse gxTv_SdtQueryViewerElements_Element_Expandcollapse=null ;
   protected com.projectthani.SdtQueryViewerElements_Element_AxisOrder gxTv_SdtQueryViewerElements_Element_Axisorder=null ;
   protected com.projectthani.SdtQueryViewerElements_Element_Format gxTv_SdtQueryViewerElements_Element_Format=null ;
   protected com.projectthani.SdtQueryViewerElements_Element_Grouping gxTv_SdtQueryViewerElements_Element_Grouping=null ;
   protected com.projectthani.SdtQueryViewerElements_Element_Actions gxTv_SdtQueryViewerElements_Element_Actions=null ;
}

