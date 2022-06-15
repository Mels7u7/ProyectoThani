package com.projectthani ;
import com.genexus.*;

public final  class StructSdtQueryViewerItemCollapseData implements Cloneable, java.io.Serializable
{
   public StructSdtQueryViewerItemCollapseData( )
   {
      this( -1, new ModelContext( StructSdtQueryViewerItemCollapseData.class ));
   }

   public StructSdtQueryViewerItemCollapseData( int remoteHandle ,
                                                ModelContext context )
   {
      gxTv_SdtQueryViewerItemCollapseData_Name = "" ;
      gxTv_SdtQueryViewerItemCollapseData_Value = "" ;
      gxTv_SdtQueryViewerItemCollapseData_Expandedvalues_N = (byte)(1) ;
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
      return gxTv_SdtQueryViewerItemCollapseData_Name ;
   }

   public void setName( String value )
   {
      gxTv_SdtQueryViewerItemCollapseData_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemCollapseData_Name = value ;
   }

   public String getValue( )
   {
      return gxTv_SdtQueryViewerItemCollapseData_Value ;
   }

   public void setValue( String value )
   {
      gxTv_SdtQueryViewerItemCollapseData_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemCollapseData_Value = value ;
   }

   public java.util.Vector getExpandedvalues( )
   {
      return gxTv_SdtQueryViewerItemCollapseData_Expandedvalues ;
   }

   public void setExpandedvalues( java.util.Vector value )
   {
      gxTv_SdtQueryViewerItemCollapseData_Expandedvalues_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemCollapseData_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemCollapseData_Expandedvalues = value ;
   }

   protected byte gxTv_SdtQueryViewerItemCollapseData_Expandedvalues_N ;
   protected byte gxTv_SdtQueryViewerItemCollapseData_N ;
   protected String gxTv_SdtQueryViewerItemCollapseData_Name ;
   protected String gxTv_SdtQueryViewerItemCollapseData_Value ;
   protected java.util.Vector gxTv_SdtQueryViewerItemCollapseData_Expandedvalues=null ;
}

