package com.projectthani ;
import com.genexus.*;

public final  class StructSdtQueryViewerDragAndDropData implements Cloneable, java.io.Serializable
{
   public StructSdtQueryViewerDragAndDropData( )
   {
      this( -1, new ModelContext( StructSdtQueryViewerDragAndDropData.class ));
   }

   public StructSdtQueryViewerDragAndDropData( int remoteHandle ,
                                               ModelContext context )
   {
      gxTv_SdtQueryViewerDragAndDropData_Name = "" ;
      gxTv_SdtQueryViewerDragAndDropData_Type = "" ;
      gxTv_SdtQueryViewerDragAndDropData_Axis = "" ;
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
      return gxTv_SdtQueryViewerDragAndDropData_Name ;
   }

   public void setName( String value )
   {
      gxTv_SdtQueryViewerDragAndDropData_N = (byte)(0) ;
      gxTv_SdtQueryViewerDragAndDropData_Name = value ;
   }

   public String getType( )
   {
      return gxTv_SdtQueryViewerDragAndDropData_Type ;
   }

   public void setType( String value )
   {
      gxTv_SdtQueryViewerDragAndDropData_N = (byte)(0) ;
      gxTv_SdtQueryViewerDragAndDropData_Type = value ;
   }

   public String getAxis( )
   {
      return gxTv_SdtQueryViewerDragAndDropData_Axis ;
   }

   public void setAxis( String value )
   {
      gxTv_SdtQueryViewerDragAndDropData_N = (byte)(0) ;
      gxTv_SdtQueryViewerDragAndDropData_Axis = value ;
   }

   public short getPosition( )
   {
      return gxTv_SdtQueryViewerDragAndDropData_Position ;
   }

   public void setPosition( short value )
   {
      gxTv_SdtQueryViewerDragAndDropData_N = (byte)(0) ;
      gxTv_SdtQueryViewerDragAndDropData_Position = value ;
   }

   protected byte gxTv_SdtQueryViewerDragAndDropData_N ;
   protected short gxTv_SdtQueryViewerDragAndDropData_Position ;
   protected String gxTv_SdtQueryViewerDragAndDropData_Name ;
   protected String gxTv_SdtQueryViewerDragAndDropData_Type ;
   protected String gxTv_SdtQueryViewerDragAndDropData_Axis ;
}

