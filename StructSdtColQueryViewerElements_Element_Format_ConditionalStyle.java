package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColQueryViewerElements.Element.Format.ConditionalStyle", namespace ="ProjectThani")
public final  class StructSdtColQueryViewerElements_Element_Format_ConditionalStyle implements Cloneable, java.io.Serializable
{
   public StructSdtColQueryViewerElements_Element_Format_ConditionalStyle( )
   {
      this( -1, new ModelContext( StructSdtColQueryViewerElements_Element_Format_ConditionalStyle.class ));
   }

   public StructSdtColQueryViewerElements_Element_Format_ConditionalStyle( int remoteHandle ,
                                                                           ModelContext context )
   {
   }

   public  StructSdtColQueryViewerElements_Element_Format_ConditionalStyle( java.util.Vector<StructSdtQueryViewerElements_Element_Format_ConditionalStyle> value )
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

   @javax.xml.bind.annotation.XmlElement(name="QueryViewerElements.Element.Format.ConditionalStyle",namespace="ProjectThani")
   public java.util.Vector<StructSdtQueryViewerElements_Element_Format_ConditionalStyle> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtQueryViewerElements_Element_Format_ConditionalStyle> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtQueryViewerElements_Element_Format_ConditionalStyle> item = new java.util.Vector<>();
}

