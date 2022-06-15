package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSchedulerEvents.Day", namespace ="")
public final  class StructSdtColSchedulerEvents_Day implements Cloneable, java.io.Serializable
{
   public StructSdtColSchedulerEvents_Day( )
   {
      this( -1, new ModelContext( StructSdtColSchedulerEvents_Day.class ));
   }

   public StructSdtColSchedulerEvents_Day( int remoteHandle ,
                                           ModelContext context )
   {
   }

   public  StructSdtColSchedulerEvents_Day( java.util.Vector<StructSdtSchedulerEvents_Day> value )
   {
      item = value;
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

   @javax.xml.bind.annotation.XmlElement(name="SchedulerEvents.Day",namespace="")
   public java.util.Vector<StructSdtSchedulerEvents_Day> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSchedulerEvents_Day> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSchedulerEvents_Day> item = new java.util.Vector<>();
}

