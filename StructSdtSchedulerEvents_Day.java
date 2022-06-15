package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSchedulerEvents_Day implements Cloneable, java.io.Serializable
{
   public StructSdtSchedulerEvents_Day( )
   {
      this( -1, new ModelContext( StructSdtSchedulerEvents_Day.class ));
   }

   public StructSdtSchedulerEvents_Day( int remoteHandle ,
                                        ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtSchedulerEvents_Day_Date = cal.getTime() ;
      gxTv_SdtSchedulerEvents_Day_Color = "" ;
      gxTv_SdtSchedulerEvents_Day_Date_N = (byte)(1) ;
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

   public java.util.Date getDate( )
   {
      return gxTv_SdtSchedulerEvents_Day_Date ;
   }

   public void setDate( java.util.Date value )
   {
      gxTv_SdtSchedulerEvents_Day_Date_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_Day_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_Day_Date = value ;
   }

   public String getColor( )
   {
      return gxTv_SdtSchedulerEvents_Day_Color ;
   }

   public void setColor( String value )
   {
      gxTv_SdtSchedulerEvents_Day_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_Day_Color = value ;
   }

   protected byte gxTv_SdtSchedulerEvents_Day_Date_N ;
   protected byte gxTv_SdtSchedulerEvents_Day_N ;
   protected String gxTv_SdtSchedulerEvents_Day_Color ;
   protected java.util.Date gxTv_SdtSchedulerEvents_Day_Date ;
}

