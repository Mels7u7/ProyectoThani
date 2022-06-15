package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColProfesional.Especialidad", namespace ="ProjectThani")
public final  class StructSdtColProfesional_Especialidad implements Cloneable, java.io.Serializable
{
   public StructSdtColProfesional_Especialidad( )
   {
      this( -1, new ModelContext( StructSdtColProfesional_Especialidad.class ));
   }

   public StructSdtColProfesional_Especialidad( int remoteHandle ,
                                                ModelContext context )
   {
   }

   public  StructSdtColProfesional_Especialidad( java.util.Vector<StructSdtProfesional_Especialidad> value )
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

   @javax.xml.bind.annotation.XmlElement(name="Profesional.Especialidad",namespace="ProjectThani")
   public java.util.Vector<StructSdtProfesional_Especialidad> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtProfesional_Especialidad> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtProfesional_Especialidad> item = new java.util.Vector<>();
}

