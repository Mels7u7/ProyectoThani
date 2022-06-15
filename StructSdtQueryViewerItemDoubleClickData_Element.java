package com.projectthani ;
import com.genexus.*;

public final  class StructSdtQueryViewerItemDoubleClickData_Element implements Cloneable, java.io.Serializable
{
   public StructSdtQueryViewerItemDoubleClickData_Element( )
   {
      this( -1, new ModelContext( StructSdtQueryViewerItemDoubleClickData_Element.class ));
   }

   public StructSdtQueryViewerItemDoubleClickData_Element( int remoteHandle ,
                                                           ModelContext context )
   {
      gxTv_SdtQueryViewerItemDoubleClickData_Element_Name = "" ;
      gxTv_SdtQueryViewerItemDoubleClickData_Element_Values_N = (byte)(1) ;
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
      return gxTv_SdtQueryViewerItemDoubleClickData_Element_Name ;
   }

   public void setName( String value )
   {
      gxTv_SdtQueryViewerItemDoubleClickData_Element_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemDoubleClickData_Element_Name = value ;
   }

   public java.util.Vector getValues( )
   {
      return gxTv_SdtQueryViewerItemDoubleClickData_Element_Values ;
   }

   public void setValues( java.util.Vector value )
   {
      gxTv_SdtQueryViewerItemDoubleClickData_Element_Values_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemDoubleClickData_Element_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemDoubleClickData_Element_Values = value ;
   }

   protected byte gxTv_SdtQueryViewerItemDoubleClickData_Element_Values_N ;
   protected byte gxTv_SdtQueryViewerItemDoubleClickData_Element_N ;
   protected String gxTv_SdtQueryViewerItemDoubleClickData_Element_Name ;
   protected java.util.Vector gxTv_SdtQueryViewerItemDoubleClickData_Element_Values=null ;
}

