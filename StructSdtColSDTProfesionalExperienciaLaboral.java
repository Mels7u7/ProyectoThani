package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTProfesionalExperienciaLaboral", namespace ="ProjectThani")
public final  class StructSdtColSDTProfesionalExperienciaLaboral implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTProfesionalExperienciaLaboral( )
   {
      this( -1, new ModelContext( StructSdtColSDTProfesionalExperienciaLaboral.class ));
   }

   public StructSdtColSDTProfesionalExperienciaLaboral( int remoteHandle ,
                                                        ModelContext context )
   {
   }

   public  StructSdtColSDTProfesionalExperienciaLaboral( java.util.Vector<StructSdtSDTProfesionalExperienciaLaboral> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTProfesionalExperienciaLaboral",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTProfesionalExperienciaLaboral> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTProfesionalExperienciaLaboral> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTProfesionalExperienciaLaboral> item = new java.util.Vector<>();
}

