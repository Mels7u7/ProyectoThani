package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtQueryViewerElements_Element_Format extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtQueryViewerElements_Element_Format( )
   {
      this(  new ModelContext(SdtQueryViewerElements_Element_Format.class));
   }

   public SdtQueryViewerElements_Element_Format( ModelContext context )
   {
      super( context, "SdtQueryViewerElements_Element_Format");
   }

   public SdtQueryViewerElements_Element_Format( int remoteHandle ,
                                                 ModelContext context )
   {
      super( remoteHandle, context, "SdtQueryViewerElements_Element_Format");
   }

   public SdtQueryViewerElements_Element_Format( StructSdtQueryViewerElements_Element_Format struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Picture") )
            {
               gxTv_SdtQueryViewerElements_Element_Format_Picture = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Subtotals") )
            {
               gxTv_SdtQueryViewerElements_Element_Format_Subtotals = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CanDragToPages") )
            {
               gxTv_SdtQueryViewerElements_Element_Format_Candragtopages = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Style") )
            {
               gxTv_SdtQueryViewerElements_Element_Format_Style = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TargetValue") )
            {
               gxTv_SdtQueryViewerElements_Element_Format_Targetvalue = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MaximumValue") )
            {
               gxTv_SdtQueryViewerElements_Element_Format_Maximumvalue = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ValuesStyles") )
            {
               if ( gxTv_SdtQueryViewerElements_Element_Format_Valuesstyles == null )
               {
                  gxTv_SdtQueryViewerElements_Element_Format_Valuesstyles = new GXBaseCollection<com.projectthani.SdtQueryViewerElements_Element_Format_ValueStyle>(com.projectthani.SdtQueryViewerElements_Element_Format_ValueStyle.class, "QueryViewerElements.Element.Format.ValueStyle", "ProjectThani", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_SdtQueryViewerElements_Element_Format_Valuesstyles.readxmlcollection(oReader, "ValuesStyles", "ValueStyle") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "ValuesStyles") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConditionalStyles") )
            {
               if ( gxTv_SdtQueryViewerElements_Element_Format_Conditionalstyles == null )
               {
                  gxTv_SdtQueryViewerElements_Element_Format_Conditionalstyles = new GXBaseCollection<com.projectthani.SdtQueryViewerElements_Element_Format_ConditionalStyle>(com.projectthani.SdtQueryViewerElements_Element_Format_ConditionalStyle.class, "QueryViewerElements.Element.Format.ConditionalStyle", "ProjectThani", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_SdtQueryViewerElements_Element_Format_Conditionalstyles.readxmlcollection(oReader, "ConditionalStyles", "ConditionalStyle") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "ConditionalStyles") )
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
         sName = "QueryViewerElements.Element.Format" ;
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
      oWriter.writeElement("Picture", GXutil.rtrim( gxTv_SdtQueryViewerElements_Element_Format_Picture));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Subtotals", GXutil.rtrim( gxTv_SdtQueryViewerElements_Element_Format_Subtotals));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("CanDragToPages", GXutil.rtrim( GXutil.booltostr( gxTv_SdtQueryViewerElements_Element_Format_Candragtopages)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("Style", GXutil.rtrim( gxTv_SdtQueryViewerElements_Element_Format_Style));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("TargetValue", GXutil.trim( GXutil.strNoRound( gxTv_SdtQueryViewerElements_Element_Format_Targetvalue, 18, 2)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("MaximumValue", GXutil.trim( GXutil.strNoRound( gxTv_SdtQueryViewerElements_Element_Format_Maximumvalue, 18, 2)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( gxTv_SdtQueryViewerElements_Element_Format_Valuesstyles != null )
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
         gxTv_SdtQueryViewerElements_Element_Format_Valuesstyles.writexmlcollection(oWriter, "ValuesStyles", sNameSpace1, "ValueStyle", sNameSpace1);
      }
      if ( gxTv_SdtQueryViewerElements_Element_Format_Conditionalstyles != null )
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
         gxTv_SdtQueryViewerElements_Element_Format_Conditionalstyles.writexmlcollection(oWriter, "ConditionalStyles", sNameSpace1, "ConditionalStyle", sNameSpace1);
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
      AddObjectProperty("Picture", gxTv_SdtQueryViewerElements_Element_Format_Picture, false, false);
      AddObjectProperty("Subtotals", gxTv_SdtQueryViewerElements_Element_Format_Subtotals, false, false);
      AddObjectProperty("CanDragToPages", gxTv_SdtQueryViewerElements_Element_Format_Candragtopages, false, false);
      AddObjectProperty("Style", gxTv_SdtQueryViewerElements_Element_Format_Style, false, false);
      AddObjectProperty("TargetValue", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtQueryViewerElements_Element_Format_Targetvalue, 18, 2)), false, false);
      AddObjectProperty("MaximumValue", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtQueryViewerElements_Element_Format_Maximumvalue, 18, 2)), false, false);
      if ( gxTv_SdtQueryViewerElements_Element_Format_Valuesstyles != null )
      {
         AddObjectProperty("ValuesStyles", gxTv_SdtQueryViewerElements_Element_Format_Valuesstyles, false, false);
      }
      if ( gxTv_SdtQueryViewerElements_Element_Format_Conditionalstyles != null )
      {
         AddObjectProperty("ConditionalStyles", gxTv_SdtQueryViewerElements_Element_Format_Conditionalstyles, false, false);
      }
   }

   public String getgxTv_SdtQueryViewerElements_Element_Format_Picture( )
   {
      return gxTv_SdtQueryViewerElements_Element_Format_Picture ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Format_Picture( String value )
   {
      gxTv_SdtQueryViewerElements_Element_Format_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Format_Picture = value ;
   }

   public String getgxTv_SdtQueryViewerElements_Element_Format_Subtotals( )
   {
      return gxTv_SdtQueryViewerElements_Element_Format_Subtotals ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Format_Subtotals( String value )
   {
      gxTv_SdtQueryViewerElements_Element_Format_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Format_Subtotals = value ;
   }

   public boolean getgxTv_SdtQueryViewerElements_Element_Format_Candragtopages( )
   {
      return gxTv_SdtQueryViewerElements_Element_Format_Candragtopages ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Format_Candragtopages( boolean value )
   {
      gxTv_SdtQueryViewerElements_Element_Format_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Format_Candragtopages = value ;
   }

   public String getgxTv_SdtQueryViewerElements_Element_Format_Style( )
   {
      return gxTv_SdtQueryViewerElements_Element_Format_Style ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Format_Style( String value )
   {
      gxTv_SdtQueryViewerElements_Element_Format_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Format_Style = value ;
   }

   public java.math.BigDecimal getgxTv_SdtQueryViewerElements_Element_Format_Targetvalue( )
   {
      return gxTv_SdtQueryViewerElements_Element_Format_Targetvalue ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Format_Targetvalue( java.math.BigDecimal value )
   {
      gxTv_SdtQueryViewerElements_Element_Format_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Format_Targetvalue = value ;
   }

   public java.math.BigDecimal getgxTv_SdtQueryViewerElements_Element_Format_Maximumvalue( )
   {
      return gxTv_SdtQueryViewerElements_Element_Format_Maximumvalue ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Format_Maximumvalue( java.math.BigDecimal value )
   {
      gxTv_SdtQueryViewerElements_Element_Format_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Format_Maximumvalue = value ;
   }

   public GXBaseCollection<com.projectthani.SdtQueryViewerElements_Element_Format_ValueStyle> getgxTv_SdtQueryViewerElements_Element_Format_Valuesstyles( )
   {
      if ( gxTv_SdtQueryViewerElements_Element_Format_Valuesstyles == null )
      {
         gxTv_SdtQueryViewerElements_Element_Format_Valuesstyles = new GXBaseCollection<com.projectthani.SdtQueryViewerElements_Element_Format_ValueStyle>(com.projectthani.SdtQueryViewerElements_Element_Format_ValueStyle.class, "QueryViewerElements.Element.Format.ValueStyle", "ProjectThani", remoteHandle);
      }
      gxTv_SdtQueryViewerElements_Element_Format_Valuesstyles_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Format_N = (byte)(0) ;
      return gxTv_SdtQueryViewerElements_Element_Format_Valuesstyles ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Format_Valuesstyles( GXBaseCollection<com.projectthani.SdtQueryViewerElements_Element_Format_ValueStyle> value )
   {
      gxTv_SdtQueryViewerElements_Element_Format_Valuesstyles_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Format_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Format_Valuesstyles = value ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Format_Valuesstyles_SetNull( )
   {
      gxTv_SdtQueryViewerElements_Element_Format_Valuesstyles_N = (byte)(1) ;
      gxTv_SdtQueryViewerElements_Element_Format_Valuesstyles = null ;
   }

   public boolean getgxTv_SdtQueryViewerElements_Element_Format_Valuesstyles_IsNull( )
   {
      if ( gxTv_SdtQueryViewerElements_Element_Format_Valuesstyles == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtQueryViewerElements_Element_Format_Valuesstyles_N( )
   {
      return gxTv_SdtQueryViewerElements_Element_Format_Valuesstyles_N ;
   }

   public GXBaseCollection<com.projectthani.SdtQueryViewerElements_Element_Format_ConditionalStyle> getgxTv_SdtQueryViewerElements_Element_Format_Conditionalstyles( )
   {
      if ( gxTv_SdtQueryViewerElements_Element_Format_Conditionalstyles == null )
      {
         gxTv_SdtQueryViewerElements_Element_Format_Conditionalstyles = new GXBaseCollection<com.projectthani.SdtQueryViewerElements_Element_Format_ConditionalStyle>(com.projectthani.SdtQueryViewerElements_Element_Format_ConditionalStyle.class, "QueryViewerElements.Element.Format.ConditionalStyle", "ProjectThani", remoteHandle);
      }
      gxTv_SdtQueryViewerElements_Element_Format_Conditionalstyles_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Format_N = (byte)(0) ;
      return gxTv_SdtQueryViewerElements_Element_Format_Conditionalstyles ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Format_Conditionalstyles( GXBaseCollection<com.projectthani.SdtQueryViewerElements_Element_Format_ConditionalStyle> value )
   {
      gxTv_SdtQueryViewerElements_Element_Format_Conditionalstyles_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Format_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Format_Conditionalstyles = value ;
   }

   public void setgxTv_SdtQueryViewerElements_Element_Format_Conditionalstyles_SetNull( )
   {
      gxTv_SdtQueryViewerElements_Element_Format_Conditionalstyles_N = (byte)(1) ;
      gxTv_SdtQueryViewerElements_Element_Format_Conditionalstyles = null ;
   }

   public boolean getgxTv_SdtQueryViewerElements_Element_Format_Conditionalstyles_IsNull( )
   {
      if ( gxTv_SdtQueryViewerElements_Element_Format_Conditionalstyles == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtQueryViewerElements_Element_Format_Conditionalstyles_N( )
   {
      return gxTv_SdtQueryViewerElements_Element_Format_Conditionalstyles_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtQueryViewerElements_Element_Format_Picture = "" ;
      gxTv_SdtQueryViewerElements_Element_Format_N = (byte)(1) ;
      gxTv_SdtQueryViewerElements_Element_Format_Subtotals = "" ;
      gxTv_SdtQueryViewerElements_Element_Format_Candragtopages = true ;
      gxTv_SdtQueryViewerElements_Element_Format_Style = "" ;
      gxTv_SdtQueryViewerElements_Element_Format_Targetvalue = DecimalUtil.ZERO ;
      gxTv_SdtQueryViewerElements_Element_Format_Maximumvalue = DecimalUtil.ZERO ;
      gxTv_SdtQueryViewerElements_Element_Format_Valuesstyles_N = (byte)(1) ;
      gxTv_SdtQueryViewerElements_Element_Format_Conditionalstyles_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtQueryViewerElements_Element_Format_N ;
   }

   public com.projectthani.SdtQueryViewerElements_Element_Format Clone( )
   {
      return (com.projectthani.SdtQueryViewerElements_Element_Format)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtQueryViewerElements_Element_Format struct )
   {
      setgxTv_SdtQueryViewerElements_Element_Format_Picture(struct.getPicture());
      setgxTv_SdtQueryViewerElements_Element_Format_Subtotals(struct.getSubtotals());
      setgxTv_SdtQueryViewerElements_Element_Format_Candragtopages(struct.getCandragtopages());
      setgxTv_SdtQueryViewerElements_Element_Format_Style(struct.getStyle());
      setgxTv_SdtQueryViewerElements_Element_Format_Targetvalue(struct.getTargetvalue());
      setgxTv_SdtQueryViewerElements_Element_Format_Maximumvalue(struct.getMaximumvalue());
      GXBaseCollection<com.projectthani.SdtQueryViewerElements_Element_Format_ValueStyle> gxTv_SdtQueryViewerElements_Element_Format_Valuesstyles_aux = new GXBaseCollection<com.projectthani.SdtQueryViewerElements_Element_Format_ValueStyle>(com.projectthani.SdtQueryViewerElements_Element_Format_ValueStyle.class, "QueryViewerElements.Element.Format.ValueStyle", "ProjectThani", remoteHandle);
      Vector<com.projectthani.StructSdtQueryViewerElements_Element_Format_ValueStyle> gxTv_SdtQueryViewerElements_Element_Format_Valuesstyles_aux1 = struct.getValuesstyles();
      if (gxTv_SdtQueryViewerElements_Element_Format_Valuesstyles_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtQueryViewerElements_Element_Format_Valuesstyles_aux1.size(); i++)
         {
            gxTv_SdtQueryViewerElements_Element_Format_Valuesstyles_aux.add(new com.projectthani.SdtQueryViewerElements_Element_Format_ValueStyle(gxTv_SdtQueryViewerElements_Element_Format_Valuesstyles_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtQueryViewerElements_Element_Format_Valuesstyles(gxTv_SdtQueryViewerElements_Element_Format_Valuesstyles_aux);
      GXBaseCollection<com.projectthani.SdtQueryViewerElements_Element_Format_ConditionalStyle> gxTv_SdtQueryViewerElements_Element_Format_Conditionalstyles_aux = new GXBaseCollection<com.projectthani.SdtQueryViewerElements_Element_Format_ConditionalStyle>(com.projectthani.SdtQueryViewerElements_Element_Format_ConditionalStyle.class, "QueryViewerElements.Element.Format.ConditionalStyle", "ProjectThani", remoteHandle);
      Vector<com.projectthani.StructSdtQueryViewerElements_Element_Format_ConditionalStyle> gxTv_SdtQueryViewerElements_Element_Format_Conditionalstyles_aux1 = struct.getConditionalstyles();
      if (gxTv_SdtQueryViewerElements_Element_Format_Conditionalstyles_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtQueryViewerElements_Element_Format_Conditionalstyles_aux1.size(); i++)
         {
            gxTv_SdtQueryViewerElements_Element_Format_Conditionalstyles_aux.add(new com.projectthani.SdtQueryViewerElements_Element_Format_ConditionalStyle(gxTv_SdtQueryViewerElements_Element_Format_Conditionalstyles_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtQueryViewerElements_Element_Format_Conditionalstyles(gxTv_SdtQueryViewerElements_Element_Format_Conditionalstyles_aux);
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtQueryViewerElements_Element_Format getStruct( )
   {
      com.projectthani.StructSdtQueryViewerElements_Element_Format struct = new com.projectthani.StructSdtQueryViewerElements_Element_Format ();
      struct.setPicture(getgxTv_SdtQueryViewerElements_Element_Format_Picture());
      struct.setSubtotals(getgxTv_SdtQueryViewerElements_Element_Format_Subtotals());
      struct.setCandragtopages(getgxTv_SdtQueryViewerElements_Element_Format_Candragtopages());
      struct.setStyle(getgxTv_SdtQueryViewerElements_Element_Format_Style());
      struct.setTargetvalue(getgxTv_SdtQueryViewerElements_Element_Format_Targetvalue());
      struct.setMaximumvalue(getgxTv_SdtQueryViewerElements_Element_Format_Maximumvalue());
      struct.setValuesstyles(getgxTv_SdtQueryViewerElements_Element_Format_Valuesstyles().getStruct());
      struct.setConditionalstyles(getgxTv_SdtQueryViewerElements_Element_Format_Conditionalstyles().getStruct());
      return struct ;
   }

   protected byte gxTv_SdtQueryViewerElements_Element_Format_N ;
   protected byte gxTv_SdtQueryViewerElements_Element_Format_Valuesstyles_N ;
   protected byte gxTv_SdtQueryViewerElements_Element_Format_Conditionalstyles_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_SdtQueryViewerElements_Element_Format_Targetvalue ;
   protected java.math.BigDecimal gxTv_SdtQueryViewerElements_Element_Format_Maximumvalue ;
   protected String gxTv_SdtQueryViewerElements_Element_Format_Picture ;
   protected String gxTv_SdtQueryViewerElements_Element_Format_Subtotals ;
   protected String gxTv_SdtQueryViewerElements_Element_Format_Style ;
   protected String sTagName ;
   protected boolean gxTv_SdtQueryViewerElements_Element_Format_Candragtopages ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected GXBaseCollection<com.projectthani.SdtQueryViewerElements_Element_Format_ValueStyle> gxTv_SdtQueryViewerElements_Element_Format_Valuesstyles_aux ;
   protected GXBaseCollection<com.projectthani.SdtQueryViewerElements_Element_Format_ConditionalStyle> gxTv_SdtQueryViewerElements_Element_Format_Conditionalstyles_aux ;
   protected GXBaseCollection<com.projectthani.SdtQueryViewerElements_Element_Format_ValueStyle> gxTv_SdtQueryViewerElements_Element_Format_Valuesstyles=null ;
   protected GXBaseCollection<com.projectthani.SdtQueryViewerElements_Element_Format_ConditionalStyle> gxTv_SdtQueryViewerElements_Element_Format_Conditionalstyles=null ;
}

