package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColQueryViewerItemExpandData", namespace ="ProjectThani")
public final  class StructSdtColQueryViewerItemExpandData implements Cloneable, java.io.Serializable
{
   public StructSdtColQueryViewerItemExpandData( )
   {
      this( -1, new ModelContext( StructSdtColQueryViewerItemExpandData.class ));
   }

   public StructSdtColQueryViewerItemExpandData( int remoteHandle ,
                                                 ModelContext context )
   {
   }

   public  StructSdtColQueryViewerItemExpandData( java.util.Vector<StructSdtQueryViewerItemExpandData> value )
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

   @javax.xml.bind.annotation.XmlElement(name="QueryViewerItemExpandData",namespace="ProjectThani")
   public java.util.Vector<StructSdtQueryViewerItemExpandData> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtQueryViewerItemExpandData> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtQueryViewerItemExpandData> item = new java.util.Vector<>();
}

