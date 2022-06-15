package com.projectthani ;
import com.genexus.*;

public final  class StructSdtQueryViewerElements_Element_Actions implements Cloneable, java.io.Serializable
{
   public StructSdtQueryViewerElements_Element_Actions( )
   {
      this( -1, new ModelContext( StructSdtQueryViewerElements_Element_Actions.class ));
   }

   public StructSdtQueryViewerElements_Element_Actions( int remoteHandle ,
                                                        ModelContext context )
   {
      gxTv_SdtQueryViewerElements_Element_Actions_Raiseitemclick = true ;
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

   public boolean getRaiseitemclick( )
   {
      return gxTv_SdtQueryViewerElements_Element_Actions_Raiseitemclick ;
   }

   public void setRaiseitemclick( boolean value )
   {
      gxTv_SdtQueryViewerElements_Element_Actions_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Actions_Raiseitemclick = value ;
   }

   protected byte gxTv_SdtQueryViewerElements_Element_Actions_N ;
   protected boolean gxTv_SdtQueryViewerElements_Element_Actions_Raiseitemclick ;
}

