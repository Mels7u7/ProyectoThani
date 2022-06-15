package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColQueryViewerElements.Element.ExpandCollapse", namespace ="ProjectThani")
public final  class StructSdtColQueryViewerElements_Element_ExpandCollapse implements Cloneable, java.io.Serializable
{
   public StructSdtColQueryViewerElements_Element_ExpandCollapse( )
   {
      this( -1, new ModelContext( StructSdtColQueryViewerElements_Element_ExpandCollapse.class ));
   }

   public StructSdtColQueryViewerElements_Element_ExpandCollapse( int remoteHandle ,
                                                                  ModelContext context )
   {
   }

   public  StructSdtColQueryViewerElements_Element_ExpandCollapse( java.util.Vector<StructSdtQueryViewerElements_Element_ExpandCollapse> value )
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

   @javax.xml.bind.annotation.XmlElement(name="QueryViewerElements.Element.ExpandCollapse",namespace="ProjectThani")
   public java.util.Vector<StructSdtQueryViewerElements_Element_ExpandCollapse> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtQueryViewerElements_Element_ExpandCollapse> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtQueryViewerElements_Element_ExpandCollapse> item = new java.util.Vector<>();
}

