package com.projectthani.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtWWPGridState_DynamicFilter implements Cloneable, java.io.Serializable
{
   public StructSdtWWPGridState_DynamicFilter( )
   {
      this( -1, new ModelContext( StructSdtWWPGridState_DynamicFilter.class ));
   }

   public StructSdtWWPGridState_DynamicFilter( int remoteHandle ,
                                               ModelContext context )
   {
      gxTv_SdtWWPGridState_DynamicFilter_Selected = "" ;
      gxTv_SdtWWPGridState_DynamicFilter_Value = "" ;
      gxTv_SdtWWPGridState_DynamicFilter_Valueto = "" ;
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

   public String getSelected( )
   {
      return gxTv_SdtWWPGridState_DynamicFilter_Selected ;
   }

   public void setSelected( String value )
   {
      gxTv_SdtWWPGridState_DynamicFilter_N = (byte)(0) ;
      gxTv_SdtWWPGridState_DynamicFilter_Selected = value ;
   }

   public String getValue( )
   {
      return gxTv_SdtWWPGridState_DynamicFilter_Value ;
   }

   public void setValue( String value )
   {
      gxTv_SdtWWPGridState_DynamicFilter_N = (byte)(0) ;
      gxTv_SdtWWPGridState_DynamicFilter_Value = value ;
   }

   public short getOperator( )
   {
      return gxTv_SdtWWPGridState_DynamicFilter_Operator ;
   }

   public void setOperator( short value )
   {
      gxTv_SdtWWPGridState_DynamicFilter_N = (byte)(0) ;
      gxTv_SdtWWPGridState_DynamicFilter_Operator = value ;
   }

   public String getValueto( )
   {
      return gxTv_SdtWWPGridState_DynamicFilter_Valueto ;
   }

   public void setValueto( String value )
   {
      gxTv_SdtWWPGridState_DynamicFilter_N = (byte)(0) ;
      gxTv_SdtWWPGridState_DynamicFilter_Valueto = value ;
   }

   protected byte gxTv_SdtWWPGridState_DynamicFilter_N ;
   protected short gxTv_SdtWWPGridState_DynamicFilter_Operator ;
   protected String gxTv_SdtWWPGridState_DynamicFilter_Selected ;
   protected String gxTv_SdtWWPGridState_DynamicFilter_Value ;
   protected String gxTv_SdtWWPGridState_DynamicFilter_Valueto ;
}

