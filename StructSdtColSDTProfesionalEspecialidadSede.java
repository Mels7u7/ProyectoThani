package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTProfesionalEspecialidadSede", namespace ="ProjectThani")
public final  class StructSdtColSDTProfesionalEspecialidadSede implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTProfesionalEspecialidadSede( )
   {
      this( -1, new ModelContext( StructSdtColSDTProfesionalEspecialidadSede.class ));
   }

   public StructSdtColSDTProfesionalEspecialidadSede( int remoteHandle ,
                                                      ModelContext context )
   {
   }

   public  StructSdtColSDTProfesionalEspecialidadSede( java.util.Vector<StructSdtSDTProfesionalEspecialidadSede> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTProfesionalEspecialidadSede",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTProfesionalEspecialidadSede> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTProfesionalEspecialidadSede> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTProfesionalEspecialidadSede> item = new java.util.Vector<>();
}

