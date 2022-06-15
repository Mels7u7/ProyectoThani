package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColProfesional.Educacion", namespace ="ProjectThani")
public final  class StructSdtColProfesional_Educacion implements Cloneable, java.io.Serializable
{
   public StructSdtColProfesional_Educacion( )
   {
      this( -1, new ModelContext( StructSdtColProfesional_Educacion.class ));
   }

   public StructSdtColProfesional_Educacion( int remoteHandle ,
                                             ModelContext context )
   {
   }

   public  StructSdtColProfesional_Educacion( java.util.Vector<StructSdtProfesional_Educacion> value )
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

   @javax.xml.bind.annotation.XmlElement(name="Profesional.Educacion",namespace="ProjectThani")
   public java.util.Vector<StructSdtProfesional_Educacion> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtProfesional_Educacion> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtProfesional_Educacion> item = new java.util.Vector<>();
}

