package com.projectthani ;
import com.genexus.*;

public final  class StructSdtQueryViewerParameters_Parameter implements Cloneable, java.io.Serializable
{
   public StructSdtQueryViewerParameters_Parameter( )
   {
      this( -1, new ModelContext( StructSdtQueryViewerParameters_Parameter.class ));
   }

   public StructSdtQueryViewerParameters_Parameter( int remoteHandle ,
                                                    ModelContext context )
   {
      gxTv_SdtQueryViewerParameters_Parameter_Name = "" ;
      gxTv_SdtQueryViewerParameters_Parameter_Value = "" ;
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
      return gxTv_SdtQueryViewerParameters_Parameter_Name ;
   }

   public void setName( String value )
   {
      gxTv_SdtQueryViewerParameters_Parameter_N = (byte)(0) ;
      gxTv_SdtQueryViewerParameters_Parameter_Name = value ;
   }

   public String getValue( )
   {
      return gxTv_SdtQueryViewerParameters_Parameter_Value ;
   }

   public void setValue( String value )
   {
      gxTv_SdtQueryViewerParameters_Parameter_N = (byte)(0) ;
      gxTv_SdtQueryViewerParameters_Parameter_Value = value ;
   }

   protected byte gxTv_SdtQueryViewerParameters_Parameter_N ;
   protected String gxTv_SdtQueryViewerParameters_Parameter_Name ;
   protected String gxTv_SdtQueryViewerParameters_Parameter_Value ;
}

