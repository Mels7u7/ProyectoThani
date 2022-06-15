package com.projectthani ;
import com.genexus.*;

public final  class StructSdtQueryViewerItemDoubleClickData_Filter implements Cloneable, java.io.Serializable
{
   public StructSdtQueryViewerItemDoubleClickData_Filter( )
   {
      this( -1, new ModelContext( StructSdtQueryViewerItemDoubleClickData_Filter.class ));
   }

   public StructSdtQueryViewerItemDoubleClickData_Filter( int remoteHandle ,
                                                          ModelContext context )
   {
      gxTv_SdtQueryViewerItemDoubleClickData_Filter_Name = "" ;
      gxTv_SdtQueryViewerItemDoubleClickData_Filter_Values_N = (byte)(1) ;
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

   public String getName( )
   {
      return gxTv_SdtQueryViewerItemDoubleClickData_Filter_Name ;
   }

   public void setName( String value )
   {
      gxTv_SdtQueryViewerItemDoubleClickData_Filter_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemDoubleClickData_Filter_Name = value ;
   }

   public java.util.Vector getValues( )
   {
      return gxTv_SdtQueryViewerItemDoubleClickData_Filter_Values ;
   }

   public void setValues( java.util.Vector value )
   {
      gxTv_SdtQueryViewerItemDoubleClickData_Filter_Values_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemDoubleClickData_Filter_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemDoubleClickData_Filter_Values = value ;
   }

   protected byte gxTv_SdtQueryViewerItemDoubleClickData_Filter_Values_N ;
   protected byte gxTv_SdtQueryViewerItemDoubleClickData_Filter_N ;
   protected String gxTv_SdtQueryViewerItemDoubleClickData_Filter_Name ;
   protected java.util.Vector gxTv_SdtQueryViewerItemDoubleClickData_Filter_Values=null ;
}

