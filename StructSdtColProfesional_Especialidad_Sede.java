package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColProfesional.Especialidad.Sede", namespace ="ProjectThani")
public final  class StructSdtColProfesional_Especialidad_Sede implements Cloneable, java.io.Serializable
{
   public StructSdtColProfesional_Especialidad_Sede( )
   {
      this( -1, new ModelContext( StructSdtColProfesional_Especialidad_Sede.class ));
   }

   public StructSdtColProfesional_Especialidad_Sede( int remoteHandle ,
                                                     ModelContext context )
   {
   }

   public  StructSdtColProfesional_Especialidad_Sede( java.util.Vector<StructSdtProfesional_Especialidad_Sede> value )
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

   @javax.xml.bind.annotation.XmlElement(name="Profesional.Especialidad.Sede",namespace="ProjectThani")
   public java.util.Vector<StructSdtProfesional_Especialidad_Sede> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtProfesional_Especialidad_Sede> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtProfesional_Especialidad_Sede> item = new java.util.Vector<>();
}

