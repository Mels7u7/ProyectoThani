package com.projectthani.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtTabsMenuData_TabsMenuDataItem_SectionsItem implements Cloneable, java.io.Serializable
{
   public StructSdtTabsMenuData_TabsMenuDataItem_SectionsItem( )
   {
      this( -1, new ModelContext( StructSdtTabsMenuData_TabsMenuDataItem_SectionsItem.class ));
   }

   public StructSdtTabsMenuData_TabsMenuDataItem_SectionsItem( int remoteHandle ,
                                                               ModelContext context )
   {
      gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectiontitle = "" ;
      gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectiondescription = "" ;
      gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectionurl = "" ;
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

   public short getSectionid( )
   {
      return gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectionid ;
   }

   public void setSectionid( short value )
   {
      gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_N = (byte)(0) ;
      gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectionid = value ;
   }

   public String getSectiontitle( )
   {
      return gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectiontitle ;
   }

   public void setSectiontitle( String value )
   {
      gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_N = (byte)(0) ;
      gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectiontitle = value ;
   }

   public String getSectiondescription( )
   {
      return gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectiondescription ;
   }

   public void setSectiondescription( String value )
   {
      gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_N = (byte)(0) ;
      gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectiondescription = value ;
   }

   public String getSectionurl( )
   {
      return gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectionurl ;
   }

   public void setSectionurl( String value )
   {
      gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_N = (byte)(0) ;
      gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectionurl = value ;
   }

   protected byte gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_N ;
   protected short gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectionid ;
   protected String gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectiontitle ;
   protected String gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectiondescription ;
   protected String gxTv_SdtTabsMenuData_TabsMenuDataItem_SectionsItem_Sectionurl ;
}

