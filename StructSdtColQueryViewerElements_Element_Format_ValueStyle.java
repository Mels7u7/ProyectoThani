package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColQueryViewerElements.Element.Format.ValueStyle", namespace ="ProjectThani")
public final  class StructSdtColQueryViewerElements_Element_Format_ValueStyle implements Cloneable, java.io.Serializable
{
   public StructSdtColQueryViewerElements_Element_Format_ValueStyle( )
   {
      this( -1, new ModelContext( StructSdtColQueryViewerElements_Element_Format_ValueStyle.class ));
   }

   public StructSdtColQueryViewerElements_Element_Format_ValueStyle( int remoteHandle ,
                                                                     ModelContext context )
   {
   }

   public  StructSdtColQueryViewerElements_Element_Format_ValueStyle( java.util.Vector<StructSdtQueryViewerElements_Element_Format_ValueStyle> value )
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

   @javax.xml.bind.annotation.XmlElement(name="QueryViewerElements.Element.Format.ValueStyle",namespace="ProjectThani")
   public java.util.Vector<StructSdtQueryViewerElements_Element_Format_ValueStyle> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtQueryViewerElements_Element_Format_ValueStyle> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtQueryViewerElements_Element_Format_ValueStyle> item = new java.util.Vector<>();
}

