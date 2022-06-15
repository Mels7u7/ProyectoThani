package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColQueryViewerElements.Element.Analytics", namespace ="ProjectThani")
public final  class StructSdtColQueryViewerElements_Element_Analytics implements Cloneable, java.io.Serializable
{
   public StructSdtColQueryViewerElements_Element_Analytics( )
   {
      this( -1, new ModelContext( StructSdtColQueryViewerElements_Element_Analytics.class ));
   }

   public StructSdtColQueryViewerElements_Element_Analytics( int remoteHandle ,
                                                             ModelContext context )
   {
   }

   public  StructSdtColQueryViewerElements_Element_Analytics( java.util.Vector<StructSdtQueryViewerElements_Element_Analytics> value )
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

   @javax.xml.bind.annotation.XmlElement(name="QueryViewerElements.Element.Analytics",namespace="ProjectThani")
   public java.util.Vector<StructSdtQueryViewerElements_Element_Analytics> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtQueryViewerElements_Element_Analytics> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtQueryViewerElements_Element_Analytics> item = new java.util.Vector<>();
}

