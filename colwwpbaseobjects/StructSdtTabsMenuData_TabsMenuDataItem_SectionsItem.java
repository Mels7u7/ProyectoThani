package com.projectthani.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "TabsMenuData.TabsMenuDataItem.SectionsItem", namespace ="ProjectThani")
public final  class StructSdtTabsMenuData_TabsMenuDataItem_SectionsItem implements Cloneable, java.io.Serializable
{
   public StructSdtTabsMenuData_TabsMenuDataItem_SectionsItem( )
   {
      this( -1, new ModelContext( StructSdtTabsMenuData_TabsMenuDataItem_SectionsItem.class ));
   }

   public StructSdtTabsMenuData_TabsMenuDataItem_SectionsItem( int remoteHandle ,
                                                               ModelContext context )
   {
   }

   public  StructSdtTabsMenuData_TabsMenuDataItem_SectionsItem( java.util.Vector<StructSdtTabsMenuData_TabsMenuDataItem_SectionsItem> value )
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

   @javax.xml.bind.annotation.XmlElement(name="TabsMenuData.TabsMenuDataItem.SectionsItem",namespace="ProjectThani")
   public java.util.Vector<StructSdtTabsMenuData_TabsMenuDataItem_SectionsItem> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtTabsMenuData_TabsMenuDataItem_SectionsItem> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtTabsMenuData_TabsMenuDataItem_SectionsItem> item = new java.util.Vector<>();
}

