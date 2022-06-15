package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColProfesional.ExperienciaLaboral", namespace ="ProjectThani")
public final  class StructSdtColProfesional_ExperienciaLaboral implements Cloneable, java.io.Serializable
{
   public StructSdtColProfesional_ExperienciaLaboral( )
   {
      this( -1, new ModelContext( StructSdtColProfesional_ExperienciaLaboral.class ));
   }

   public StructSdtColProfesional_ExperienciaLaboral( int remoteHandle ,
                                                      ModelContext context )
   {
   }

   public  StructSdtColProfesional_ExperienciaLaboral( java.util.Vector<StructSdtProfesional_ExperienciaLaboral> value )
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

   @javax.xml.bind.annotation.XmlElement(name="Profesional.ExperienciaLaboral",namespace="ProjectThani")
   public java.util.Vector<StructSdtProfesional_ExperienciaLaboral> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtProfesional_ExperienciaLaboral> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtProfesional_ExperienciaLaboral> item = new java.util.Vector<>();
}

