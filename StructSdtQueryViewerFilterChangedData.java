package com.projectthani ;
import com.genexus.*;

public final  class StructSdtQueryViewerFilterChangedData implements Cloneable, java.io.Serializable
{
   public StructSdtQueryViewerFilterChangedData( )
   {
      this( -1, new ModelContext( StructSdtQueryViewerFilterChangedData.class ));
   }

   public StructSdtQueryViewerFilterChangedData( int remoteHandle ,
                                                 ModelContext context )
   {
      gxTv_SdtQueryViewerFilterChangedData_Name = "" ;
      gxTv_SdtQueryViewerFilterChangedData_Selectedvalues_N = (byte)(1) ;
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
      return gxTv_SdtQueryViewerFilterChangedData_Name ;
   }

   public void setName( String value )
   {
      gxTv_SdtQueryViewerFilterChangedData_N = (byte)(0) ;
      gxTv_SdtQueryViewerFilterChangedData_Name = value ;
   }

   public java.util.Vector getSelectedvalues( )
   {
      return gxTv_SdtQueryViewerFilterChangedData_Selectedvalues ;
   }

   public void setSelectedvalues( java.util.Vector value )
   {
      gxTv_SdtQueryViewerFilterChangedData_Selectedvalues_N = (byte)(0) ;
      gxTv_SdtQueryViewerFilterChangedData_N = (byte)(0) ;
      gxTv_SdtQueryViewerFilterChangedData_Selectedvalues = value ;
   }

   protected byte gxTv_SdtQueryViewerFilterChangedData_Selectedvalues_N ;
   protected byte gxTv_SdtQueryViewerFilterChangedData_N ;
   protected String gxTv_SdtQueryViewerFilterChangedData_Name ;
   protected java.util.Vector gxTv_SdtQueryViewerFilterChangedData_Selectedvalues=null ;
}

