package com.projectthani ;
import com.genexus.*;

public final  class StructSdtQueryViewerItemClickData implements Cloneable, java.io.Serializable
{
   public StructSdtQueryViewerItemClickData( )
   {
      this( -1, new ModelContext( StructSdtQueryViewerItemClickData.class ));
   }

   public StructSdtQueryViewerItemClickData( int remoteHandle ,
                                             ModelContext context )
   {
      gxTv_SdtQueryViewerItemClickData_Name = "" ;
      gxTv_SdtQueryViewerItemClickData_Type = "" ;
      gxTv_SdtQueryViewerItemClickData_Axis = "" ;
      gxTv_SdtQueryViewerItemClickData_Value = "" ;
      gxTv_SdtQueryViewerItemClickData_Context_N = (byte)(1) ;
      gxTv_SdtQueryViewerItemClickData_Filters_N = (byte)(1) ;
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
      return gxTv_SdtQueryViewerItemClickData_Name ;
   }

   public void setName( String value )
   {
      gxTv_SdtQueryViewerItemClickData_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemClickData_Name = value ;
   }

   public String getType( )
   {
      return gxTv_SdtQueryViewerItemClickData_Type ;
   }

   public void setType( String value )
   {
      gxTv_SdtQueryViewerItemClickData_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemClickData_Type = value ;
   }

   public String getAxis( )
   {
      return gxTv_SdtQueryViewerItemClickData_Axis ;
   }

   public void setAxis( String value )
   {
      gxTv_SdtQueryViewerItemClickData_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemClickData_Axis = value ;
   }

   public String getValue( )
   {
      return gxTv_SdtQueryViewerItemClickData_Value ;
   }

   public void setValue( String value )
   {
      gxTv_SdtQueryViewerItemClickData_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemClickData_Value = value ;
   }

   public boolean getSelected( )
   {
      return gxTv_SdtQueryViewerItemClickData_Selected ;
   }

   public void setSelected( boolean value )
   {
      gxTv_SdtQueryViewerItemClickData_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemClickData_Selected = value ;
   }

   public java.util.Vector<com.projectthani.StructSdtQueryViewerItemClickData_Element> getContext( )
   {
      return gxTv_SdtQueryViewerItemClickData_Context ;
   }

   public void setContext( java.util.Vector<com.projectthani.StructSdtQueryViewerItemClickData_Element> value )
   {
      gxTv_SdtQueryViewerItemClickData_Context_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemClickData_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemClickData_Context = value ;
   }

   public java.util.Vector<com.projectthani.StructSdtQueryViewerItemClickData_Filter> getFilters( )
   {
      return gxTv_SdtQueryViewerItemClickData_Filters ;
   }

   public void setFilters( java.util.Vector<com.projectthani.StructSdtQueryViewerItemClickData_Filter> value )
   {
      gxTv_SdtQueryViewerItemClickData_Filters_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemClickData_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemClickData_Filters = value ;
   }

   protected byte gxTv_SdtQueryViewerItemClickData_Context_N ;
   protected byte gxTv_SdtQueryViewerItemClickData_Filters_N ;
   protected byte gxTv_SdtQueryViewerItemClickData_N ;
   protected String gxTv_SdtQueryViewerItemClickData_Name ;
   protected String gxTv_SdtQueryViewerItemClickData_Type ;
   protected String gxTv_SdtQueryViewerItemClickData_Axis ;
   protected String gxTv_SdtQueryViewerItemClickData_Value ;
   protected boolean gxTv_SdtQueryViewerItemClickData_Selected ;
   protected java.util.Vector<com.projectthani.StructSdtQueryViewerItemClickData_Element> gxTv_SdtQueryViewerItemClickData_Context=null ;
   protected java.util.Vector<com.projectthani.StructSdtQueryViewerItemClickData_Filter> gxTv_SdtQueryViewerItemClickData_Filters=null ;
}

