package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSchedulerEvents implements Cloneable, java.io.Serializable
{
   public StructSdtSchedulerEvents( )
   {
      this( -1, new ModelContext( StructSdtSchedulerEvents.class ));
   }

   public StructSdtSchedulerEvents( int remoteHandle ,
                                    ModelContext context )
   {
      gxTv_SdtSchedulerEvents_Items_N = (byte)(1) ;
      gxTv_SdtSchedulerEvents_Specialdays_N = (byte)(1) ;
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

   public java.util.Vector<com.projectthani.StructSdtSchedulerEvents_event> getItems( )
   {
      return gxTv_SdtSchedulerEvents_Items ;
   }

   public void setItems( java.util.Vector<com.projectthani.StructSdtSchedulerEvents_event> value )
   {
      gxTv_SdtSchedulerEvents_Items_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_Items = value ;
   }

   public java.util.Vector<com.projectthani.StructSdtSchedulerEvents_Day> getSpecialdays( )
   {
      return gxTv_SdtSchedulerEvents_Specialdays ;
   }

   public void setSpecialdays( java.util.Vector<com.projectthani.StructSdtSchedulerEvents_Day> value )
   {
      gxTv_SdtSchedulerEvents_Specialdays_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_N = (byte)(0) ;
      gxTv_SdtSchedulerEvents_Specialdays = value ;
   }

   protected byte gxTv_SdtSchedulerEvents_Items_N ;
   protected byte gxTv_SdtSchedulerEvents_Specialdays_N ;
   protected byte gxTv_SdtSchedulerEvents_N ;
   protected java.util.Vector<com.projectthani.StructSdtSchedulerEvents_event> gxTv_SdtSchedulerEvents_Items=null ;
   protected java.util.Vector<com.projectthani.StructSdtSchedulerEvents_Day> gxTv_SdtSchedulerEvents_Specialdays=null ;
}

