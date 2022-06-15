package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTMenu implements Cloneable, java.io.Serializable
{
   public StructSdtSDTMenu( )
   {
      this( -1, new ModelContext( StructSdtSDTMenu.class ));
   }

   public StructSdtSDTMenu( int remoteHandle ,
                            ModelContext context )
   {
      gxTv_SdtSDTMenu_Menutexto = "" ;
      gxTv_SdtSDTMenu_Menulink = "" ;
      gxTv_SdtSDTMenu_Submenus_N = (byte)(1) ;
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
      return gxTv_SdtSDTMenu_Menutexto ;
   }

   public void setMenutexto( String value )
   {
      gxTv_SdtSDTMenu_N = (byte)(0) ;
      gxTv_SdtSDTMenu_Menutexto = value ;
   }

   public String getMenulink( )
   {
      return gxTv_SdtSDTMenu_Menulink ;
   }

   public void setMenulink( String value )
   {
      gxTv_SdtSDTMenu_N = (byte)(0) ;
      gxTv_SdtSDTMenu_Menulink = value ;
   }

   public java.util.Vector<com.projectthani.StructSdtSDTMenu_SubMenusItem> getSubmenus( )
   {
      return gxTv_SdtSDTMenu_Submenus ;
   }

   public void setSubmenus( java.util.Vector<com.projectthani.StructSdtSDTMenu_SubMenusItem> value )
   {
      gxTv_SdtSDTMenu_Submenus_N = (byte)(0) ;
      gxTv_SdtSDTMenu_N = (byte)(0) ;
      gxTv_SdtSDTMenu_Submenus = value ;
   }

   protected byte gxTv_SdtSDTMenu_Submenus_N ;
   protected byte gxTv_SdtSDTMenu_N ;
   protected String gxTv_SdtSDTMenu_Menutexto ;
   protected String gxTv_SdtSDTMenu_Menulink ;
   protected java.util.Vector<com.projectthani.StructSdtSDTMenu_SubMenusItem> gxTv_SdtSDTMenu_Submenus=null ;
}

