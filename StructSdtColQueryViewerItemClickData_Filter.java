package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColQueryViewerItemClickData.Filter", namespace ="ProjectThani")
public final  class StructSdtColQueryViewerItemClickData_Filter implements Cloneable, java.io.Serializable
{
   public StructSdtColQueryViewerItemClickData_Filter( )
   {
      this( -1, new ModelContext( StructSdtColQueryViewerItemClickData_Filter.class ));
   }

   public StructSdtColQueryViewerItemClickData_Filter( int remoteHandle ,
                                                       ModelContext context )
   {
   }

   public  StructSdtColQueryViewerItemClickData_Filter( java.util.Vector<StructSdtQueryViewerItemClickData_Filter> value )
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

   @javax.xml.bind.annotation.XmlElement(name="QueryViewerItemClickData.Filter",namespace="ProjectThani")
   public java.util.Vector<StructSdtQueryViewerItemClickData_Filter> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtQueryViewerItemClickData_Filter> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtQueryViewerItemClickData_Filter> item = new java.util.Vector<>();
}

