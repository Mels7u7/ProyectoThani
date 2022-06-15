package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColQueryViewerElements.Element.Filter", namespace ="ProjectThani")
public final  class StructSdtColQueryViewerElements_Element_Filter implements Cloneable, java.io.Serializable
{
   public StructSdtColQueryViewerElements_Element_Filter( )
   {
      this( -1, new ModelContext( StructSdtColQueryViewerElements_Element_Filter.class ));
   }

   public StructSdtColQueryViewerElements_Element_Filter( int remoteHandle ,
                                                          ModelContext context )
   {
   }

   public  StructSdtColQueryViewerElements_Element_Filter( java.util.Vector<StructSdtQueryViewerElements_Element_Filter> value )
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

   @javax.xml.bind.annotation.XmlElement(name="QueryViewerElements.Element.Filter",namespace="ProjectThani")
   public java.util.Vector<StructSdtQueryViewerElements_Element_Filter> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtQueryViewerElements_Element_Filter> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtQueryViewerElements_Element_Filter> item = new java.util.Vector<>();
}

