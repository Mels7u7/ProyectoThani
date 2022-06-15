package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "QueryViewerElements", namespace ="ProjectThani")
public final  class StructSdtQueryViewerElements implements Cloneable, java.io.Serializable
{
   public StructSdtQueryViewerElements( )
   {
      this( -1, new ModelContext( StructSdtQueryViewerElements.class ));
   }

   public StructSdtQueryViewerElements( int remoteHandle ,
                                        ModelContext context )
   {
   }

   public  StructSdtQueryViewerElements( java.util.Vector<StructSdtQueryViewerElements_Element> value )
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

   @javax.xml.bind.annotation.XmlElement(name="Element",namespace="ProjectThani")
   public java.util.Vector<StructSdtQueryViewerElements_Element> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtQueryViewerElements_Element> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtQueryViewerElements_Element> item = new java.util.Vector<>();
}

