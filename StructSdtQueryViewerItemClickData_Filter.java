package com.projectthani ;
import com.genexus.*;

public final  class StructSdtQueryViewerItemClickData_Filter implements Cloneable, java.io.Serializable
{
   public StructSdtQueryViewerItemClickData_Filter( )
   {
      this( -1, new ModelContext( StructSdtQueryViewerItemClickData_Filter.class ));
   }

   public StructSdtQueryViewerItemClickData_Filter( int remoteHandle ,
                                                    ModelContext context )
   {
      gxTv_SdtQueryViewerItemClickData_Filter_Name = "" ;
      gxTv_SdtQueryViewerItemClickData_Filter_Values_N = (byte)(1) ;
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
      return gxTv_SdtQueryViewerItemClickData_Filter_Name ;
   }

   public void setName( String value )
   {
      gxTv_SdtQueryViewerItemClickData_Filter_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemClickData_Filter_Name = value ;
   }

   public java.util.Vector getValues( )
   {
      return gxTv_SdtQueryViewerItemClickData_Filter_Values ;
   }

   public void setValues( java.util.Vector value )
   {
      gxTv_SdtQueryViewerItemClickData_Filter_Values_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemClickData_Filter_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemClickData_Filter_Values = value ;
   }

   protected byte gxTv_SdtQueryViewerItemClickData_Filter_Values_N ;
   protected byte gxTv_SdtQueryViewerItemClickData_Filter_N ;
   protected String gxTv_SdtQueryViewerItemClickData_Filter_Name ;
   protected java.util.Vector gxTv_SdtQueryViewerItemClickData_Filter_Values=null ;
}

