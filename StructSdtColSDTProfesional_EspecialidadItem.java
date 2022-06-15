package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTProfesional.EspecialidadItem", namespace ="ProjectThani")
public final  class StructSdtColSDTProfesional_EspecialidadItem implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTProfesional_EspecialidadItem( )
   {
      this( -1, new ModelContext( StructSdtColSDTProfesional_EspecialidadItem.class ));
   }

   public StructSdtColSDTProfesional_EspecialidadItem( int remoteHandle ,
                                                       ModelContext context )
   {
   }

   public  StructSdtColSDTProfesional_EspecialidadItem( java.util.Vector<StructSdtSDTProfesional_EspecialidadItem> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTProfesional.EspecialidadItem",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTProfesional_EspecialidadItem> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTProfesional_EspecialidadItem> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTProfesional_EspecialidadItem> item = new java.util.Vector<>();
}

