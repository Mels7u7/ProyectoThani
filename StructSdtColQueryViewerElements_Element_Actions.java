package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColQueryViewerElements.Element.Actions", namespace ="ProjectThani")
public final  class StructSdtColQueryViewerElements_Element_Actions implements Cloneable, java.io.Serializable
{
   public StructSdtColQueryViewerElements_Element_Actions( )
   {
      this( -1, new ModelContext( StructSdtColQueryViewerElements_Element_Actions.class ));
   }

   public StructSdtColQueryViewerElements_Element_Actions( int remoteHandle ,
                                                           ModelContext context )
   {
   }

   public  StructSdtColQueryViewerElements_Element_Actions( java.util.Vector<StructSdtQueryViewerElements_Element_Actions> value )
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

   @javax.xml.bind.annotation.XmlElement(name="QueryViewerElements.Element.Actions",namespace="ProjectThani")
   public java.util.Vector<StructSdtQueryViewerElements_Element_Actions> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtQueryViewerElements_Element_Actions> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtQueryViewerElements_Element_Actions> item = new java.util.Vector<>();
}

