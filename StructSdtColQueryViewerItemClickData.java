package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColQueryViewerItemClickData", namespace ="ProjectThani")
public final  class StructSdtColQueryViewerItemClickData implements Cloneable, java.io.Serializable
{
   public StructSdtColQueryViewerItemClickData( )
   {
      this( -1, new ModelContext( StructSdtColQueryViewerItemClickData.class ));
   }

   public StructSdtColQueryViewerItemClickData( int remoteHandle ,
                                                ModelContext context )
   {
   }

   public  StructSdtColQueryViewerItemClickData( java.util.Vector<StructSdtQueryViewerItemClickData> value )
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

   @javax.xml.bind.annotation.XmlElement(name="QueryViewerItemClickData",namespace="ProjectThani")
   public java.util.Vector<StructSdtQueryViewerItemClickData> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtQueryViewerItemClickData> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtQueryViewerItemClickData> item = new java.util.Vector<>();
}

