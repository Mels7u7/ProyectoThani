package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColQueryViewerItemDoubleClickData", namespace ="ProjectThani")
public final  class StructSdtColQueryViewerItemDoubleClickData implements Cloneable, java.io.Serializable
{
   public StructSdtColQueryViewerItemDoubleClickData( )
   {
      this( -1, new ModelContext( StructSdtColQueryViewerItemDoubleClickData.class ));
   }

   public StructSdtColQueryViewerItemDoubleClickData( int remoteHandle ,
                                                      ModelContext context )
   {
   }

   public  StructSdtColQueryViewerItemDoubleClickData( java.util.Vector<StructSdtQueryViewerItemDoubleClickData> value )
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

   @javax.xml.bind.annotation.XmlElement(name="QueryViewerItemDoubleClickData",namespace="ProjectThani")
   public java.util.Vector<StructSdtQueryViewerItemDoubleClickData> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtQueryViewerItemDoubleClickData> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtQueryViewerItemDoubleClickData> item = new java.util.Vector<>();
}

