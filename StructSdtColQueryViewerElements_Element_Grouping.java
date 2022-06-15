package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColQueryViewerElements.Element.Grouping", namespace ="ProjectThani")
public final  class StructSdtColQueryViewerElements_Element_Grouping implements Cloneable, java.io.Serializable
{
   public StructSdtColQueryViewerElements_Element_Grouping( )
   {
      this( -1, new ModelContext( StructSdtColQueryViewerElements_Element_Grouping.class ));
   }

   public StructSdtColQueryViewerElements_Element_Grouping( int remoteHandle ,
                                                            ModelContext context )
   {
   }

   public  StructSdtColQueryViewerElements_Element_Grouping( java.util.Vector<StructSdtQueryViewerElements_Element_Grouping> value )
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

   @javax.xml.bind.annotation.XmlElement(name="QueryViewerElements.Element.Grouping",namespace="ProjectThani")
   public java.util.Vector<StructSdtQueryViewerElements_Element_Grouping> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtQueryViewerElements_Element_Grouping> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtQueryViewerElements_Element_Grouping> item = new java.util.Vector<>();
}

