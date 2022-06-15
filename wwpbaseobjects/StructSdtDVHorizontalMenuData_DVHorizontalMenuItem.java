package com.projectthani.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtDVHorizontalMenuData_DVHorizontalMenuItem implements Cloneable, java.io.Serializable
{
   public StructSdtDVHorizontalMenuData_DVHorizontalMenuItem( )
   {
      this( -1, new ModelContext( StructSdtDVHorizontalMenuData_DVHorizontalMenuItem.class ));
   }

   public StructSdtDVHorizontalMenuData_DVHorizontalMenuItem( int remoteHandle ,
                                                              ModelContext context )
   {
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Code = "" ;
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Title = "" ;
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Url = "" ;
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Linktarget = "" ;
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Image = "" ;
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Description = "" ;
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Subitems_N = (byte)(1) ;
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
      return gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Code ;
   }

   public void setCode( String value )
   {
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_N = (byte)(0) ;
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Code = value ;
   }

   public String getTitle( )
   {
      return gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Title ;
   }

   public void setTitle( String value )
   {
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_N = (byte)(0) ;
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Title = value ;
   }

   public String getUrl( )
   {
      return gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Url ;
   }

   public void setUrl( String value )
   {
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_N = (byte)(0) ;
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Url = value ;
   }

   public String getLinktarget( )
   {
      return gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Linktarget ;
   }

   public void setLinktarget( String value )
   {
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_N = (byte)(0) ;
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Linktarget = value ;
   }

   public String getImage( )
   {
      return gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Image ;
   }

   public void setImage( String value )
   {
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_N = (byte)(0) ;
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Image = value ;
   }

   public String getDescription( )
   {
      return gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Description ;
   }

   public void setDescription( String value )
   {
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_N = (byte)(0) ;
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Description = value ;
   }

   public short getIndex( )
   {
      return gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Index ;
   }

   public void setIndex( short value )
   {
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_N = (byte)(0) ;
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Index = value ;
   }

   public java.util.Vector<com.projectthani.wwpbaseobjects.StructSdtDVHorizontalMenuData_DVHorizontalMenuItem> getSubitems( )
   {
      return gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Subitems ;
   }

   public void setSubitems( java.util.Vector<com.projectthani.wwpbaseobjects.StructSdtDVHorizontalMenuData_DVHorizontalMenuItem> value )
   {
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Subitems_N = (byte)(0) ;
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_N = (byte)(0) ;
      gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Subitems = value ;
   }

   protected byte gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Subitems_N ;
   protected byte gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_N ;
   protected short gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Index ;
   protected String gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Code ;
   protected String gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Title ;
   protected String gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Url ;
   protected String gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Linktarget ;
   protected String gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Image ;
   protected String gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Description ;
   protected java.util.Vector<com.projectthani.wwpbaseobjects.StructSdtDVHorizontalMenuData_DVHorizontalMenuItem> gxTv_SdtDVHorizontalMenuData_DVHorizontalMenuItem_Subitems=null ;
}

