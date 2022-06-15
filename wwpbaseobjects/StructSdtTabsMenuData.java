package com.projectthani.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "TabsMenuData", namespace ="ProjectThani")
public final  class StructSdtTabsMenuData implements Cloneable, java.io.Serializable
{
   public StructSdtTabsMenuData( )
   {
      this( -1, new ModelContext( StructSdtTabsMenuData.class ));
   }

   public StructSdtTabsMenuData( int remoteHandle ,
                                 ModelContext context )
   {
   }

   public  StructSdtTabsMenuData( java.util.Vector<StructSdtTabsMenuData_TabsMenuDataItem> value )
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

   @javax.xml.bind.annotation.XmlElement(name="TabsMenuDataItem",namespace="ProjectThani")
   public java.util.Vector<StructSdtTabsMenuData_TabsMenuDataItem> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtTabsMenuData_TabsMenuDataItem> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtTabsMenuData_TabsMenuDataItem> item = new java.util.Vector<>();
}

