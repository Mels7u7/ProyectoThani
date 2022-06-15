package com.projectthani.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "HomeSampleData", namespace ="ProjectThani")
public final  class StructSdtHomeSampleData implements Cloneable, java.io.Serializable
{
   public StructSdtHomeSampleData( )
   {
      this( -1, new ModelContext( StructSdtHomeSampleData.class ));
   }

   public StructSdtHomeSampleData( int remoteHandle ,
                                   ModelContext context )
   {
   }

   public  StructSdtHomeSampleData( java.util.Vector<StructSdtHomeSampleData_HomeSampleDataItem> value )
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

   @javax.xml.bind.annotation.XmlElement(name="HomeSampleDataItem",namespace="ProjectThani")
   public java.util.Vector<StructSdtHomeSampleData_HomeSampleDataItem> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtHomeSampleData_HomeSampleDataItem> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtHomeSampleData_HomeSampleDataItem> item = new java.util.Vector<>();
}

