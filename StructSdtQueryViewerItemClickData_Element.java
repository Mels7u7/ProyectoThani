package com.projectthani ;
import com.genexus.*;

public final  class StructSdtQueryViewerItemClickData_Element implements Cloneable, java.io.Serializable
{
   public StructSdtQueryViewerItemClickData_Element( )
   {
      this( -1, new ModelContext( StructSdtQueryViewerItemClickData_Element.class ));
   }

   public StructSdtQueryViewerItemClickData_Element( int remoteHandle ,
                                                     ModelContext context )
   {
      gxTv_SdtQueryViewerItemClickData_Element_Name = "" ;
      gxTv_SdtQueryViewerItemClickData_Element_Values_N = (byte)(1) ;
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
      return gxTv_SdtQueryViewerItemClickData_Element_Name ;
   }

   public void setName( String value )
   {
      gxTv_SdtQueryViewerItemClickData_Element_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemClickData_Element_Name = value ;
   }

   public java.util.Vector getValues( )
   {
      return gxTv_SdtQueryViewerItemClickData_Element_Values ;
   }

   public void setValues( java.util.Vector value )
   {
      gxTv_SdtQueryViewerItemClickData_Element_Values_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemClickData_Element_N = (byte)(0) ;
      gxTv_SdtQueryViewerItemClickData_Element_Values = value ;
   }

   protected byte gxTv_SdtQueryViewerItemClickData_Element_Values_N ;
   protected byte gxTv_SdtQueryViewerItemClickData_Element_N ;
   protected String gxTv_SdtQueryViewerItemClickData_Element_Name ;
   protected java.util.Vector gxTv_SdtQueryViewerItemClickData_Element_Values=null ;
}

