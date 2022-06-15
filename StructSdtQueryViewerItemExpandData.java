package com.projectthani ;
import com.genexus.*;

public final  class StructSdtQueryViewerItemExpandData implements Cloneable, java.io.Serializable
{
   public StructSdtQueryViewerItemExpandData( )
   {
      this( -1, new ModelContext( StructSdtQueryViewerItemExpandData.class ));
   }

   public StructSdtQueryViewerItemExpandData( int remoteHandle ,
                                              ModelContext context )
   {
      gxTv_SdtQueryViewerItemExpandData_Name = "" ;
      gxTv_SdtQueryViewerItemExpandData_Value = "" ;
      gxTv_SdtQueryViewerItemExpandData_Expandedvalues_N = (byte)(1) ;
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
      return gxTv_SdtQueryViewerItemExpandData_Name ;
   }

   public void setName( String value )
   {
      gxTv_SdtQueryViewerItemExpandData_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemExpandData_Name = value ;
   }

   public String getValue( )
   {
      return gxTv_SdtQueryViewerItemExpandData_Value ;
   }

   public void setValue( String value )
   {
      gxTv_SdtQueryViewerItemExpandData_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemExpandData_Value = value ;
   }

   public java.util.Vector getExpandedvalues( )
   {
      return gxTv_SdtQueryViewerItemExpandData_Expandedvalues ;
   }

   public void setExpandedvalues( java.util.Vector value )
   {
      gxTv_SdtQueryViewerItemExpandData_Expandedvalues_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemExpandData_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemExpandData_Expandedvalues = value ;
   }

   protected byte gxTv_SdtQueryViewerItemExpandData_Expandedvalues_N ;
   protected byte gxTv_SdtQueryViewerItemExpandData_N ;
   protected String gxTv_SdtQueryViewerItemExpandData_Name ;
   protected String gxTv_SdtQueryViewerItemExpandData_Value ;
   protected java.util.Vector gxTv_SdtQueryViewerItemExpandData_Expandedvalues=null ;
}

