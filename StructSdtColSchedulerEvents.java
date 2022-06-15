package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSchedulerEvents", namespace ="")
public final  class StructSdtColSchedulerEvents implements Cloneable, java.io.Serializable
{
   public StructSdtColSchedulerEvents( )
   {
      this( -1, new ModelContext( StructSdtColSchedulerEvents.class ));
   }

   public StructSdtColSchedulerEvents( int remoteHandle ,
                                       ModelContext context )
   {
   }

   public  StructSdtColSchedulerEvents( java.util.Vector<StructSdtSchedulerEvents> value )
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

   @javax.xml.bind.annotation.XmlElement(name="data",namespace="")
   public java.util.Vector<StructSdtSchedulerEvents> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSchedulerEvents> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSchedulerEvents> item = new java.util.Vector<>();
}

