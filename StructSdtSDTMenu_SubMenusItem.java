package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTMenu_SubMenusItem implements Cloneable, java.io.Serializable
{
   public StructSdtSDTMenu_SubMenusItem( )
   {
      this( -1, new ModelContext( StructSdtSDTMenu_SubMenusItem.class ));
   }

   public StructSdtSDTMenu_SubMenusItem( int remoteHandle ,
                                         ModelContext context )
   {
      gxTv_SdtSDTMenu_SubMenusItem_Menutexto = "" ;
      gxTv_SdtSDTMenu_SubMenusItem_Menulink = "" ;
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

   public String getMenutexto( )
   {
      return gxTv_SdtSDTMenu_SubMenusItem_Menutexto ;
   }

   public void setMenutexto( String value )
   {
      gxTv_SdtSDTMenu_SubMenusItem_N = (byte)(0) ;
      gxTv_SdtSDTMenu_SubMenusItem_Menutexto = value ;
   }

   public String getMenulink( )
   {
      return gxTv_SdtSDTMenu_SubMenusItem_Menulink ;
   }

   public void setMenulink( String value )
   {
      gxTv_SdtSDTMenu_SubMenusItem_N = (byte)(0) ;
      gxTv_SdtSDTMenu_SubMenusItem_Menulink = value ;
   }

   protected byte gxTv_SdtSDTMenu_SubMenusItem_N ;
   protected String gxTv_SdtSDTMenu_SubMenusItem_Menutexto ;
   protected String gxTv_SdtSDTMenu_SubMenusItem_Menulink ;
}

