package com.projectthani.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtWWPTabOptions_TabOptionsItem implements Cloneable, java.io.Serializable
{
   public StructSdtWWPTabOptions_TabOptionsItem( )
   {
      this( -1, new ModelContext( StructSdtWWPTabOptions_TabOptionsItem.class ));
   }

   public StructSdtWWPTabOptions_TabOptionsItem( int remoteHandle ,
                                                 ModelContext context )
   {
      gxTv_SdtWWPTabOptions_TabOptionsItem_Code = "" ;
      gxTv_SdtWWPTabOptions_TabOptionsItem_Description = "" ;
      gxTv_SdtWWPTabOptions_TabOptionsItem_Link = "" ;
      gxTv_SdtWWPTabOptions_TabOptionsItem_Webcomponent = "" ;
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

   public String getCode( )
   {
      return gxTv_SdtWWPTabOptions_TabOptionsItem_Code ;
   }

   public void setCode( String value )
   {
      gxTv_SdtWWPTabOptions_TabOptionsItem_N = (byte)(0) ;
      gxTv_SdtWWPTabOptions_TabOptionsItem_Code = value ;
   }

   public String getDescription( )
   {
      return gxTv_SdtWWPTabOptions_TabOptionsItem_Description ;
   }

   public void setDescription( String value )
   {
      gxTv_SdtWWPTabOptions_TabOptionsItem_N = (byte)(0) ;
      gxTv_SdtWWPTabOptions_TabOptionsItem_Description = value ;
   }

   public String getLink( )
   {
      return gxTv_SdtWWPTabOptions_TabOptionsItem_Link ;
   }

   public void setLink( String value )
   {
      gxTv_SdtWWPTabOptions_TabOptionsItem_N = (byte)(0) ;
      gxTv_SdtWWPTabOptions_TabOptionsItem_Link = value ;
   }

   public String getWebcomponent( )
   {
      return gxTv_SdtWWPTabOptions_TabOptionsItem_Webcomponent ;
   }

   public void setWebcomponent( String value )
   {
      gxTv_SdtWWPTabOptions_TabOptionsItem_N = (byte)(0) ;
      gxTv_SdtWWPTabOptions_TabOptionsItem_Webcomponent = value ;
   }

   public byte getIncludeinpanel( )
   {
      return gxTv_SdtWWPTabOptions_TabOptionsItem_Includeinpanel ;
   }

   public void setIncludeinpanel( byte value )
   {
      gxTv_SdtWWPTabOptions_TabOptionsItem_N = (byte)(0) ;
      gxTv_SdtWWPTabOptions_TabOptionsItem_Includeinpanel = value ;
   }

   public boolean getCollapsedbydefault( )
   {
      return gxTv_SdtWWPTabOptions_TabOptionsItem_Collapsedbydefault ;
   }

   public void setCollapsedbydefault( boolean value )
   {
      gxTv_SdtWWPTabOptions_TabOptionsItem_N = (byte)(0) ;
      gxTv_SdtWWPTabOptions_TabOptionsItem_Collapsedbydefault = value ;
   }

   public boolean getCollapsable( )
   {
      return gxTv_SdtWWPTabOptions_TabOptionsItem_Collapsable ;
   }

   public void setCollapsable( boolean value )
   {
      gxTv_SdtWWPTabOptions_TabOptionsItem_N = (byte)(0) ;
      gxTv_SdtWWPTabOptions_TabOptionsItem_Collapsable = value ;
   }

   protected byte gxTv_SdtWWPTabOptions_TabOptionsItem_Includeinpanel ;
   protected byte gxTv_SdtWWPTabOptions_TabOptionsItem_N ;
   protected String gxTv_SdtWWPTabOptions_TabOptionsItem_Code ;
   protected boolean gxTv_SdtWWPTabOptions_TabOptionsItem_Collapsedbydefault ;
   protected boolean gxTv_SdtWWPTabOptions_TabOptionsItem_Collapsable ;
   protected String gxTv_SdtWWPTabOptions_TabOptionsItem_Description ;
   protected String gxTv_SdtWWPTabOptions_TabOptionsItem_Link ;
   protected String gxTv_SdtWWPTabOptions_TabOptionsItem_Webcomponent ;
}

