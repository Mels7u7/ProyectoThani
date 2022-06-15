package com.projectthani.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtTabsMenuData_TabsMenuDataItem implements Cloneable, java.io.Serializable
{
   public StructSdtTabsMenuData_TabsMenuDataItem( )
   {
      this( -1, new ModelContext( StructSdtTabsMenuData_TabsMenuDataItem.class ));
   }

   public StructSdtTabsMenuData_TabsMenuDataItem( int remoteHandle ,
                                                  ModelContext context )
   {
      gxTv_SdtTabsMenuData_TabsMenuDataItem_Menutitle = "" ;
      gxTv_SdtTabsMenuData_TabsMenuDataItem_Menudescription = "" ;
      gxTv_SdtTabsMenuData_TabsMenuDataItem_Menuurl = "" ;
      gxTv_SdtTabsMenuData_TabsMenuDataItem_Sections_N = (byte)(1) ;
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

   public short getMenuid( )
   {
      return gxTv_SdtTabsMenuData_TabsMenuDataItem_Menuid ;
   }

   public void setMenuid( short value )
   {
      gxTv_SdtTabsMenuData_TabsMenuDataItem_N = (byte)(0) ;
      gxTv_SdtTabsMenuData_TabsMenuDataItem_Menuid = value ;
   }

   public String getMenutitle( )
   {
      return gxTv_SdtTabsMenuData_TabsMenuDataItem_Menutitle ;
   }

   public void setMenutitle( String value )
   {
      gxTv_SdtTabsMenuData_TabsMenuDataItem_N = (byte)(0) ;
      gxTv_SdtTabsMenuData_TabsMenuDataItem_Menutitle = value ;
   }

   public String getMenudescription( )
   {
      return gxTv_SdtTabsMenuData_TabsMenuDataItem_Menudescription ;
   }

   public void setMenudescription( String value )
   {
      gxTv_SdtTabsMenuData_TabsMenuDataItem_N = (byte)(0) ;
      gxTv_SdtTabsMenuData_TabsMenuDataItem_Menudescription = value ;
   }

   public String getMenuurl( )
   {
      return gxTv_SdtTabsMenuData_TabsMenuDataItem_Menuurl ;
   }

   public void setMenuurl( String value )
   {
      gxTv_SdtTabsMenuData_TabsMenuDataItem_N = (byte)(0) ;
      gxTv_SdtTabsMenuData_TabsMenuDataItem_Menuurl = value ;
   }

   public java.util.Vector<com.projectthani.wwpbaseobjects.StructSdtTabsMenuData_TabsMenuDataItem_SectionsItem> getSections( )
   {
      return gxTv_SdtTabsMenuData_TabsMenuDataItem_Sections ;
   }

   public void setSections( java.util.Vector<com.projectthani.wwpbaseobjects.StructSdtTabsMenuData_TabsMenuDataItem_SectionsItem> value )
   {
      gxTv_SdtTabsMenuData_TabsMenuDataItem_Sections_N = (byte)(0) ;
      gxTv_SdtTabsMenuData_TabsMenuDataItem_N = (byte)(0) ;
      gxTv_SdtTabsMenuData_TabsMenuDataItem_Sections = value ;
   }

   protected byte gxTv_SdtTabsMenuData_TabsMenuDataItem_Sections_N ;
   protected byte gxTv_SdtTabsMenuData_TabsMenuDataItem_N ;
   protected short gxTv_SdtTabsMenuData_TabsMenuDataItem_Menuid ;
   protected String gxTv_SdtTabsMenuData_TabsMenuDataItem_Menutitle ;
   protected String gxTv_SdtTabsMenuData_TabsMenuDataItem_Menudescription ;
   protected String gxTv_SdtTabsMenuData_TabsMenuDataItem_Menuurl ;
   protected java.util.Vector<com.projectthani.wwpbaseobjects.StructSdtTabsMenuData_TabsMenuDataItem_SectionsItem> gxTv_SdtTabsMenuData_TabsMenuDataItem_Sections=null ;
}

