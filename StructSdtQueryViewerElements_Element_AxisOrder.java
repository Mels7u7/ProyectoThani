package com.projectthani ;
import com.genexus.*;

public final  class StructSdtQueryViewerElements_Element_AxisOrder implements Cloneable, java.io.Serializable
{
   public StructSdtQueryViewerElements_Element_AxisOrder( )
   {
      this( -1, new ModelContext( StructSdtQueryViewerElements_Element_AxisOrder.class ));
   }

   public StructSdtQueryViewerElements_Element_AxisOrder( int remoteHandle ,
                                                          ModelContext context )
   {
      gxTv_SdtQueryViewerElements_Element_AxisOrder_Type = "" ;
      gxTv_SdtQueryViewerElements_Element_AxisOrder_Values_N = (byte)(1) ;
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

   public String getType( )
   {
      return gxTv_SdtQueryViewerElements_Element_AxisOrder_Type ;
   }

   public void setType( String value )
   {
      gxTv_SdtQueryViewerElements_Element_AxisOrder_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_AxisOrder_Type = value ;
   }

   public java.util.Vector getValues( )
   {
      return gxTv_SdtQueryViewerElements_Element_AxisOrder_Values ;
   }

   public void setValues( java.util.Vector value )
   {
      gxTv_SdtQueryViewerElements_Element_AxisOrder_Values_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_AxisOrder_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_AxisOrder_Values = value ;
   }

   protected byte gxTv_SdtQueryViewerElements_Element_AxisOrder_Values_N ;
   protected byte gxTv_SdtQueryViewerElements_Element_AxisOrder_N ;
   protected String gxTv_SdtQueryViewerElements_Element_AxisOrder_Type ;
   protected java.util.Vector gxTv_SdtQueryViewerElements_Element_AxisOrder_Values=null ;
}

