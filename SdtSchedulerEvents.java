package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSchedulerEvents extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtSchedulerEvents( )
   {
      this(  new ModelContext(SdtSchedulerEvents.class));
   }

   public SdtSchedulerEvents( ModelContext context )
   {
      super( context, "SdtSchedulerEvents");
   }

   public SdtSchedulerEvents( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle, context, "SdtSchedulerEvents");
   }

   public SdtSchedulerEvents( StructSdtSchedulerEvents struct )
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
         if ( gxTv_SdtSchedulerEvents_Items != null )
         {
            gxTv_SdtSchedulerEvents_Items.clearCollection();
         }
         if ( gxTv_SdtSchedulerEvents_Specialdays != null )
         {
            gxTv_SdtSchedulerEvents_Specialdays.clearCollection();
         }
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp(oReader.getLocalName(), "event") == 0 )
            {
               if ( gxTv_SdtSchedulerEvents_Items == null )
               {
                  gxTv_SdtSchedulerEvents_Items = new GXBaseCollection<com.projectthani.SdtSchedulerEvents_event>(com.projectthani.SdtSchedulerEvents_event.class, "SchedulerEvents.event", "", remoteHandle);
               }
               GXSoapError = gxTv_SdtSchedulerEvents_Items.readxmlcollection(oReader, "", "event") ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
            }
            if ( GXutil.strcmp(oReader.getLocalName(), "Day") == 0 )
            {
               if ( gxTv_SdtSchedulerEvents_Specialdays == null )
               {
                  gxTv_SdtSchedulerEvents_Specialdays = new GXBaseCollection<com.projectthani.SdtSchedulerEvents_Day>(com.projectthani.SdtSchedulerEvents_Day.class, "SchedulerEvents.Day", "", remoteHandle);
               }
               GXSoapError = gxTv_SdtSchedulerEvents_Specialdays.readxmlcollection(oReader, "", "Day") ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
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
         sName = "data" ;
      }
      if ( (GXutil.strcmp("", sNameSpace)==0) )
      {
         sNameSpace = "" ;
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
      if ( gxTv_SdtSchedulerEvents_Items != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "" ;
         }
         else
         {
            sNameSpace1 = "" ;
         }
         gxTv_SdtSchedulerEvents_Items.writexmlcollection(oWriter, "", sNameSpace1, "event", sNameSpace1);
      }
      if ( gxTv_SdtSchedulerEvents_Specialdays != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "" ;
         }
         else
         {
            sNameSpace1 = "" ;
         }
         gxTv_SdtSchedulerEvents_Specialdays.writexmlcollection(oWriter, "", sNameSpace1, "Day", sNameSpace1);
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
      if ( gxTv_SdtSchedulerEvents_Items != null )
      {
         AddObjectProperty("Items", gxTv_SdtSchedulerEvents_Items, false, false);
      }
      if ( gxTv_SdtSchedulerEvents_Specialdays != null )
      {
         AddObjectProperty("SpecialDays", gxTv_SdtSchedulerEvents_Specialdays, false, false);
      }
   }

   public GXBaseCollection<com.projectthani.SdtSchedulerEvents_event> getgxTv_SdtSchedulerEvents_Items( )
   {
      if ( gxTv_SdtSchedulerEvents_Items == null )
      {
         gxTv_SdtSchedulerEvents_Items = new GXBaseCollection<com.projectthani.SdtSchedulerEvents_event>(com.projectthani.SdtSchedulerEvents_event.class, "SchedulerEvents.event", "", remoteHandle);
      }
      gxTv_SdtSchedulerEvents_Items_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_N = (byte)(0) ;
      return gxTv_SdtSchedulerEvents_Items ;
   }

   public void setgxTv_SdtSchedulerEvents_Items( GXBaseCollection<com.projectthani.SdtSchedulerEvents_event> value )
   {
      gxTv_SdtSchedulerEvents_Items_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_Items = value ;
   }

   public void setgxTv_SdtSchedulerEvents_Items_SetNull( )
   {
      gxTv_SdtSchedulerEvents_Items_N = (byte)(1) ;
      gxTv_SdtSchedulerEvents_Items = null ;
   }

   public boolean getgxTv_SdtSchedulerEvents_Items_IsNull( )
   {
      if ( gxTv_SdtSchedulerEvents_Items == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtSchedulerEvents_Items_N( )
   {
      return gxTv_SdtSchedulerEvents_Items_N ;
   }

   public GXBaseCollection<com.projectthani.SdtSchedulerEvents_Day> getgxTv_SdtSchedulerEvents_Specialdays( )
   {
      if ( gxTv_SdtSchedulerEvents_Specialdays == null )
      {
         gxTv_SdtSchedulerEvents_Specialdays = new GXBaseCollection<com.projectthani.SdtSchedulerEvents_Day>(com.projectthani.SdtSchedulerEvents_Day.class, "SchedulerEvents.Day", "", remoteHandle);
      }
      gxTv_SdtSchedulerEvents_Specialdays_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_N = (byte)(0) ;
      return gxTv_SdtSchedulerEvents_Specialdays ;
   }

   public void setgxTv_SdtSchedulerEvents_Specialdays( GXBaseCollection<com.projectthani.SdtSchedulerEvents_Day> value )
   {
      gxTv_SdtSchedulerEvents_Specialdays_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_Specialdays = value ;
   }

   public void setgxTv_SdtSchedulerEvents_Specialdays_SetNull( )
   {
      gxTv_SdtSchedulerEvents_Specialdays_N = (byte)(1) ;
      gxTv_SdtSchedulerEvents_Specialdays = null ;
   }

   public boolean getgxTv_SdtSchedulerEvents_Specialdays_IsNull( )
   {
      if ( gxTv_SdtSchedulerEvents_Specialdays == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtSchedulerEvents_Specialdays_N( )
   {
      return gxTv_SdtSchedulerEvents_Specialdays_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSchedulerEvents_Items_N = (byte)(1) ;
      gxTv_SdtSchedulerEvents_N = (byte)(1) ;
      gxTv_SdtSchedulerEvents_Specialdays_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSchedulerEvents_N ;
   }

   public com.projectthani.SdtSchedulerEvents Clone( )
   {
      return (com.projectthani.SdtSchedulerEvents)(clone()) ;
   }

   public void setStruct( com.projectthani.StructSdtSchedulerEvents struct )
   {
      GXBaseCollection<com.projectthani.SdtSchedulerEvents_event> gxTv_SdtSchedulerEvents_Items_aux = new GXBaseCollection<com.projectthani.SdtSchedulerEvents_event>(com.projectthani.SdtSchedulerEvents_event.class, "SchedulerEvents.event", "", remoteHandle);
      Vector<com.projectthani.StructSdtSchedulerEvents_event> gxTv_SdtSchedulerEvents_Items_aux1 = struct.getItems();
      if (gxTv_SdtSchedulerEvents_Items_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtSchedulerEvents_Items_aux1.size(); i++)
         {
            gxTv_SdtSchedulerEvents_Items_aux.add(new com.projectthani.SdtSchedulerEvents_event(gxTv_SdtSchedulerEvents_Items_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtSchedulerEvents_Items(gxTv_SdtSchedulerEvents_Items_aux);
      GXBaseCollection<com.projectthani.SdtSchedulerEvents_Day> gxTv_SdtSchedulerEvents_Specialdays_aux = new GXBaseCollection<com.projectthani.SdtSchedulerEvents_Day>(com.projectthani.SdtSchedulerEvents_Day.class, "SchedulerEvents.Day", "", remoteHandle);
      Vector<com.projectthani.StructSdtSchedulerEvents_Day> gxTv_SdtSchedulerEvents_Specialdays_aux1 = struct.getSpecialdays();
      if (gxTv_SdtSchedulerEvents_Specialdays_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtSchedulerEvents_Specialdays_aux1.size(); i++)
         {
            gxTv_SdtSchedulerEvents_Specialdays_aux.add(new com.projectthani.SdtSchedulerEvents_Day(gxTv_SdtSchedulerEvents_Specialdays_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtSchedulerEvents_Specialdays(gxTv_SdtSchedulerEvents_Specialdays_aux);
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.StructSdtSchedulerEvents getStruct( )
   {
      com.projectthani.StructSdtSchedulerEvents struct = new com.projectthani.StructSdtSchedulerEvents ();
      struct.setItems(getgxTv_SdtSchedulerEvents_Items().getStruct());
      struct.setSpecialdays(getgxTv_SdtSchedulerEvents_Specialdays().getStruct());
      return struct ;
   }

   protected byte gxTv_SdtSchedulerEvents_Items_N ;
   protected byte gxTv_SdtSchedulerEvents_N ;
   protected byte gxTv_SdtSchedulerEvents_Specialdays_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected GXBaseCollection<com.projectthani.SdtSchedulerEvents_event> gxTv_SdtSchedulerEvents_Items_aux ;
   protected GXBaseCollection<com.projectthani.SdtSchedulerEvents_Day> gxTv_SdtSchedulerEvents_Specialdays_aux ;
   protected GXBaseCollection<com.projectthani.SdtSchedulerEvents_event> gxTv_SdtSchedulerEvents_Items=null ;
   protected GXBaseCollection<com.projectthani.SdtSchedulerEvents_Day> gxTv_SdtSchedulerEvents_Specialdays=null ;
}

