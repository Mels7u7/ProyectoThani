package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColQueryViewerItemClickData.Element", namespace ="ProjectThani")
public final  class StructSdtColQueryViewerItemClickData_Element implements Cloneable, java.io.Serializable
{
   public StructSdtColQueryViewerItemClickData_Element( )
   {
      this( -1, new ModelContext( StructSdtColQueryViewerItemClickData_Element.class ));
   }

   public StructSdtColQueryViewerItemClickData_Element( int remoteHandle ,
                                                        ModelContext context )
   {
   }

   public  StructSdtColQueryViewerItemClickData_Element( java.util.Vector<StructSdtQueryViewerItemClickData_Element> value )
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

   @javax.xml.bind.annotation.XmlElement(name="QueryViewerItemClickData.Element",namespace="ProjectThani")
   public java.util.Vector<StructSdtQueryViewerItemClickData_Element> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtQueryViewerItemClickData_Element> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtQueryViewerItemClickData_Element> item = new java.util.Vector<>();
}

