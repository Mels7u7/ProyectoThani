package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSchedulerEvents_event implements Cloneable, java.io.Serializable
{
   public StructSdtSchedulerEvents_event( )
   {
      this( -1, new ModelContext( StructSdtSchedulerEvents_event.class ));
   }

   public StructSdtSchedulerEvents_event( int remoteHandle ,
                                          ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtSchedulerEvents_event_Id = "" ;
      gxTv_SdtSchedulerEvents_event_Name = "" ;
      gxTv_SdtSchedulerEvents_event_Notes = "" ;
      gxTv_SdtSchedulerEvents_event_Link = "" ;
      gxTv_SdtSchedulerEvents_event_Starttime = cal.getTime() ;
      gxTv_SdtSchedulerEvents_event_Endtime = cal.getTime() ;
      gxTv_SdtSchedulerEvents_event_Additionalinformation = "" ;
      gxTv_SdtSchedulerEvents_event_Color = "" ;
      gxTv_SdtSchedulerEvents_event_Backgroundcolor = "" ;
      gxTv_SdtSchedulerEvents_event_Nameweekview = "" ;
      gxTv_SdtSchedulerEvents_event_Namemonthview = "" ;
      gxTv_SdtSchedulerEvents_event_Namedayview = "" ;
      gxTv_SdtSchedulerEvents_event_Tooltip = "" ;
      gxTv_SdtSchedulerEvents_event_Starttime_N = (byte)(1) ;
      gxTv_SdtSchedulerEvents_event_Endtime_N = (byte)(1) ;
      gxTv_SdtSchedulerEvents_event_Color_N = (byte)(1) ;
      gxTv_SdtSchedulerEvents_event_Backgroundcolor_N = (byte)(1) ;
      gxTv_SdtSchedulerEvents_event_Nameweekview_N = (byte)(1) ;
      gxTv_SdtSchedulerEvents_event_Namemonthview_N = (byte)(1) ;
      gxTv_SdtSchedulerEvents_event_Namedayview_N = (byte)(1) ;
      gxTv_SdtSchedulerEvents_event_Tooltip_N = (byte)(1) ;
   }

   public Object clone()
   {
      Object cloned = null;
      try
      {
         cloned = super.clone();
      }catch (CloneNotSupportedException e){ ; }
      return cloned;
   }

   public String getId( )
   {
      return gxTv_SdtSchedulerEvents_event_Id ;
   }

   public void setId( String value )
   {
      gxTv_SdtSchedulerEvents_event_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_event_Id = value ;
   }

   public String getName( )
   {
      return gxTv_SdtSchedulerEvents_event_Name ;
   }

   public void setName( String value )
   {
      gxTv_SdtSchedulerEvents_event_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_event_Name = value ;
   }

   public String getNotes( )
   {
      return gxTv_SdtSchedulerEvents_event_Notes ;
   }

   public void setNotes( String value )
   {
      gxTv_SdtSchedulerEvents_event_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_event_Notes = value ;
   }

   public String getLink( )
   {
      return gxTv_SdtSchedulerEvents_event_Link ;
   }

   public void setLink( String value )
   {
      gxTv_SdtSchedulerEvents_event_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_event_Link = value ;
   }

   public java.util.Date getStarttime( )
   {
      return gxTv_SdtSchedulerEvents_event_Starttime ;
   }

   public void setStarttime( java.util.Date value )
   {
      gxTv_SdtSchedulerEvents_event_Starttime_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_event_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_event_Starttime = value ;
   }

   public java.util.Date getEndtime( )
   {
      return gxTv_SdtSchedulerEvents_event_Endtime ;
   }

   public void setEndtime( java.util.Date value )
   {
      gxTv_SdtSchedulerEvents_event_Endtime_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_event_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_event_Endtime = value ;
   }

   public String getAdditionalinformation( )
   {
      return gxTv_SdtSchedulerEvents_event_Additionalinformation ;
   }

   public void setAdditionalinformation( String value )
   {
      gxTv_SdtSchedulerEvents_event_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_event_Additionalinformation = value ;
   }

   public String getColor( )
   {
      return gxTv_SdtSchedulerEvents_event_Color ;
   }

   public void setColor( String value )
   {
      gxTv_SdtSchedulerEvents_event_Color_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_event_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_event_Color = value ;
   }

   public String getBackgroundcolor( )
   {
      return gxTv_SdtSchedulerEvents_event_Backgroundcolor ;
   }

   public void setBackgroundcolor( String value )
   {
      gxTv_SdtSchedulerEvents_event_Backgroundcolor_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_event_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_event_Backgroundcolor = value ;
   }

   public String getNameweekview( )
   {
      return gxTv_SdtSchedulerEvents_event_Nameweekview ;
   }

   public void setNameweekview( String value )
   {
      gxTv_SdtSchedulerEvents_event_Nameweekview_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_event_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_event_Nameweekview = value ;
   }

   public String getNamemonthview( )
   {
      return gxTv_SdtSchedulerEvents_event_Namemonthview ;
   }

   public void setNamemonthview( String value )
   {
      gxTv_SdtSchedulerEvents_event_Namemonthview_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_event_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_event_Namemonthview = value ;
   }

   public String getNamedayview( )
   {
      return gxTv_SdtSchedulerEvents_event_Namedayview ;
   }

   public void setNamedayview( String value )
   {
      gxTv_SdtSchedulerEvents_event_Namedayview_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_event_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_event_Namedayview = value ;
   }

   public String getTooltip( )
   {
      return gxTv_SdtSchedulerEvents_event_Tooltip ;
   }

   public void setTooltip( String value )
   {
      gxTv_SdtSchedulerEvents_event_Tooltip_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_event_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_event_Tooltip = value ;
   }

   protected byte gxTv_SdtSchedulerEvents_event_Starttime_N ;
   protected byte gxTv_SdtSchedulerEvents_event_Endtime_N ;
   protected byte gxTv_SdtSchedulerEvents_event_Color_N ;
   protected byte gxTv_SdtSchedulerEvents_event_Backgroundcolor_N ;
   protected byte gxTv_SdtSchedulerEvents_event_Nameweekview_N ;
   protected byte gxTv_SdtSchedulerEvents_event_Namemonthview_N ;
   protected byte gxTv_SdtSchedulerEvents_event_Namedayview_N ;
   protected byte gxTv_SdtSchedulerEvents_event_Tooltip_N ;
   protected byte gxTv_SdtSchedulerEvents_event_N ;
   protected String gxTv_SdtSchedulerEvents_event_Id ;
   protected String gxTv_SdtSchedulerEvents_event_Name ;
   protected String gxTv_SdtSchedulerEvents_event_Notes ;
   protected String gxTv_SdtSchedulerEvents_event_Link ;
   protected String gxTv_SdtSchedulerEvents_event_Additionalinformation ;
   protected String gxTv_SdtSchedulerEvents_event_Color ;
   protected String gxTv_SdtSchedulerEvents_event_Backgroundcolor ;
   protected String gxTv_SdtSchedulerEvents_event_Nameweekview ;
   protected String gxTv_SdtSchedulerEvents_event_Namemonthview ;
   protected String gxTv_SdtSchedulerEvents_event_Namedayview ;
   protected String gxTv_SdtSchedulerEvents_event_Tooltip ;
   protected java.util.Date gxTv_SdtSchedulerEvents_event_Starttime ;
   protected java.util.Date gxTv_SdtSchedulerEvents_event_Endtime ;
}

