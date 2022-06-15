package com.projectthani ;
import com.genexus.*;

public final  class StructSdtQueryViewerItemDoubleClickData implements Cloneable, java.io.Serializable
{
   public StructSdtQueryViewerItemDoubleClickData( )
   {
      this( -1, new ModelContext( StructSdtQueryViewerItemDoubleClickData.class ));
   }

   public StructSdtQueryViewerItemDoubleClickData( int remoteHandle ,
                                                   ModelContext context )
   {
      gxTv_SdtQueryViewerItemDoubleClickData_Name = "" ;
      gxTv_SdtQueryViewerItemDoubleClickData_Type = "" ;
      gxTv_SdtQueryViewerItemDoubleClickData_Axis = "" ;
      gxTv_SdtQueryViewerItemDoubleClickData_Value = "" ;
      gxTv_SdtQueryViewerItemDoubleClickData_Context_N = (byte)(1) ;
      gxTv_SdtQueryViewerItemDoubleClickData_Filters_N = (byte)(1) ;
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
      return gxTv_SdtQueryViewerItemDoubleClickData_Name ;
   }

   public void setName( String value )
   {
      gxTv_SdtQueryViewerItemDoubleClickData_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemDoubleClickData_Name = value ;
   }

   public String getType( )
   {
      return gxTv_SdtQueryViewerItemDoubleClickData_Type ;
   }

   public void setType( String value )
   {
      gxTv_SdtQueryViewerItemDoubleClickData_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemDoubleClickData_Type = value ;
   }

   public String getAxis( )
   {
      return gxTv_SdtQueryViewerItemDoubleClickData_Axis ;
   }

   public void setAxis( String value )
   {
      gxTv_SdtQueryViewerItemDoubleClickData_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemDoubleClickData_Axis = value ;
   }

   public String getValue( )
   {
      return gxTv_SdtQueryViewerItemDoubleClickData_Value ;
   }

   public void setValue( String value )
   {
      gxTv_SdtQueryViewerItemDoubleClickData_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemDoubleClickData_Value = value ;
   }

   public java.util.Vector<com.projectthani.StructSdtQueryViewerItemDoubleClickData_Element> getContext( )
   {
      return gxTv_SdtQueryViewerItemDoubleClickData_Context ;
   }

   public void setContext( java.util.Vector<com.projectthani.StructSdtQueryViewerItemDoubleClickData_Element> value )
   {
      gxTv_SdtQueryViewerItemDoubleClickData_Context_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemDoubleClickData_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemDoubleClickData_Context = value ;
   }

   public java.util.Vector<com.projectthani.StructSdtQueryViewerItemDoubleClickData_Filter> getFilters( )
   {
      return gxTv_SdtQueryViewerItemDoubleClickData_Filters ;
   }

   public void setFilters( java.util.Vector<com.projectthani.StructSdtQueryViewerItemDoubleClickData_Filter> value )
   {
      gxTv_SdtQueryViewerItemDoubleClickData_Filters_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemDoubleClickData_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemDoubleClickData_Filters = value ;
   }

   protected byte gxTv_SdtQueryViewerItemDoubleClickData_Context_N ;
   protected byte gxTv_SdtQueryViewerItemDoubleClickData_Filters_N ;
   protected byte gxTv_SdtQueryViewerItemDoubleClickData_N ;
   protected String gxTv_SdtQueryViewerItemDoubleClickData_Name ;
   protected String gxTv_SdtQueryViewerItemDoubleClickData_Type ;
   protected String gxTv_SdtQueryViewerItemDoubleClickData_Axis ;
   protected String gxTv_SdtQueryViewerItemDoubleClickData_Value ;
   protected java.util.Vector<com.projectthani.StructSdtQueryViewerItemDoubleClickData_Element> gxTv_SdtQueryViewerItemDoubleClickData_Context=null ;
   protected java.util.Vector<com.projectthani.StructSdtQueryViewerItemDoubleClickData_Filter> gxTv_SdtQueryViewerItemDoubleClickData_Filters=null ;
}

