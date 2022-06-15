package com.projectthani ;
import com.genexus.*;

public final  class StructSdtQueryViewerElements_Element_Format_ConditionalStyle implements Cloneable, java.io.Serializable
{
   public StructSdtQueryViewerElements_Element_Format_ConditionalStyle( )
   {
      this( -1, new ModelContext( StructSdtQueryViewerElements_Element_Format_ConditionalStyle.class ));
   }

   public StructSdtQueryViewerElements_Element_Format_ConditionalStyle( int remoteHandle ,
                                                                        ModelContext context )
   {
      gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Operator = "" ;
      gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Value1 = "" ;
      gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Value2 = "" ;
      gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Styleorclass = "" ;
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

   public String getOperator( )
   {
      return gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Operator ;
   }

   public void setOperator( String value )
   {
      gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Operator = value ;
   }

   public String getValue1( )
   {
      return gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Value1 ;
   }

   public void setValue1( String value )
   {
      gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Value1 = value ;
   }

   public String getValue2( )
   {
      return gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Value2 ;
   }

   public void setValue2( String value )
   {
      gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Value2 = value ;
   }

   public String getStyleorclass( )
   {
      return gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Styleorclass ;
   }

   public void setStyleorclass( String value )
   {
      gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Styleorclass = value ;
   }

   protected byte gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_N ;
   protected String gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Operator ;
   protected String gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Value1 ;
   protected String gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Value2 ;
   protected String gxTv_SdtQueryViewerElements_Element_Format_ConditionalStyle_Styleorclass ;
}

