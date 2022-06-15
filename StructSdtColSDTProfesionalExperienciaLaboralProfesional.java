package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTProfesionalExperienciaLaboralProfesional", namespace ="ProjectThani")
public final  class StructSdtColSDTProfesionalExperienciaLaboralProfesional implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTProfesionalExperienciaLaboralProfesional( )
   {
      this( -1, new ModelContext( StructSdtColSDTProfesionalExperienciaLaboralProfesional.class ));
   }

   public StructSdtColSDTProfesionalExperienciaLaboralProfesional( int remoteHandle ,
                                                                   ModelContext context )
   {
   }

   public  StructSdtColSDTProfesionalExperienciaLaboralProfesional( java.util.Vector<StructSdtSDTProfesionalExperienciaLaboralProfesional> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTProfesionalExperienciaLaboralProfesional",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTProfesionalExperienciaLaboralProfesional> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTProfesionalExperienciaLaboralProfesional> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTProfesionalExperienciaLaboralProfesional> item = new java.util.Vector<>();
}

