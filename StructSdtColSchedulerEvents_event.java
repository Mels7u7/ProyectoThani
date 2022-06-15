package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSchedulerEvents.event", namespace ="")
public final  class StructSdtColSchedulerEvents_event implements Cloneable, java.io.Serializable
{
   public StructSdtColSchedulerEvents_event( )
   {
      this( -1, new ModelContext( StructSdtColSchedulerEvents_event.class ));
   }

   public StructSdtColSchedulerEvents_event( int remoteHandle ,
                                             ModelContext context )
   {
   }

   public  StructSdtColSchedulerEvents_event( java.util.Vector<StructSdtSchedulerEvents_event> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SchedulerEvents.event",namespace="")
   public java.util.Vector<StructSdtSchedulerEvents_event> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSchedulerEvents_event> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSchedulerEvents_event> item = new java.util.Vector<>();
}

