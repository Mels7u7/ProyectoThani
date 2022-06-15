package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColQueryViewerDragAndDropData", namespace ="ProjectThani")
public final  class StructSdtColQueryViewerDragAndDropData implements Cloneable, java.io.Serializable
{
   public StructSdtColQueryViewerDragAndDropData( )
   {
      this( -1, new ModelContext( StructSdtColQueryViewerDragAndDropData.class ));
   }

   public StructSdtColQueryViewerDragAndDropData( int remoteHandle ,
                                                  ModelContext context )
   {
   }

   public  StructSdtColQueryViewerDragAndDropData( java.util.Vector<StructSdtQueryViewerDragAndDropData> value )
   {
      item = value;
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

   @javax.xml.bind.annotation.XmlElement(name="QueryViewerDragAndDropData",namespace="ProjectThani")
   public java.util.Vector<StructSdtQueryViewerDragAndDropData> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtQueryViewerDragAndDropData> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtQueryViewerDragAndDropData> item = new java.util.Vector<>();
}

