package com.projectthani.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "WWP_SDTNotificationsDataSample", namespace ="ProjectThani")
public final  class StructSdtWWP_SDTNotificationsDataSample implements Cloneable, java.io.Serializable
{
   public StructSdtWWP_SDTNotificationsDataSample( )
   {
      this( -1, new ModelContext( StructSdtWWP_SDTNotificationsDataSample.class ));
   }

   public StructSdtWWP_SDTNotificationsDataSample( int remoteHandle ,
                                                   ModelContext context )
   {
   }

   public  StructSdtWWP_SDTNotificationsDataSample( java.util.Vector<StructSdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem> value )
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

   @javax.xml.bind.annotation.XmlElement(name="WWP_SDTNotificationsDataSampleItem",namespace="ProjectThani")
   public java.util.Vector<StructSdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem> item = new java.util.Vector<>();
}

