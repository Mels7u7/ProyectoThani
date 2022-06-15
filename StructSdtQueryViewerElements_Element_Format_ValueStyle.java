package com.projectthani ;
import com.genexus.*;

public final  class StructSdtQueryViewerElements_Element_Format_ValueStyle implements Cloneable, java.io.Serializable
{
   public StructSdtQueryViewerElements_Element_Format_ValueStyle( )
   {
      this( -1, new ModelContext( StructSdtQueryViewerElements_Element_Format_ValueStyle.class ));
   }

   public StructSdtQueryViewerElements_Element_Format_ValueStyle( int remoteHandle ,
                                                                  ModelContext context )
   {
      gxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Value = "" ;
      gxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Styleorclass = "" ;
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

   public String getValue( )
   {
      return gxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Value ;
   }

   public void setValue( String value )
   {
      gxTv_SdtQueryViewerElements_Element_Format_ValueStyle_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Value = value ;
   }

   public String getStyleorclass( )
   {
      return gxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Styleorclass ;
   }

   public void setStyleorclass( String value )
   {
      gxTv_SdtQueryViewerElements_Element_Format_ValueStyle_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Styleorclass = value ;
   }

   public boolean getApplytoroworcolumn( )
   {
      return gxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Applytoroworcolumn ;
   }

   public void setApplytoroworcolumn( boolean value )
   {
      gxTv_SdtQueryViewerElements_Element_Format_ValueStyle_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Applytoroworcolumn = value ;
   }

   protected byte gxTv_SdtQueryViewerElements_Element_Format_ValueStyle_N ;
   protected String gxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Value ;
   protected String gxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Styleorclass ;
   protected boolean gxTv_SdtQueryViewerElements_Element_Format_ValueStyle_Applytoroworcolumn ;
}

