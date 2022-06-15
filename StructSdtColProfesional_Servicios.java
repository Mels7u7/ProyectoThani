package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColProfesional.Servicios", namespace ="ProjectThani")
public final  class StructSdtColProfesional_Servicios implements Cloneable, java.io.Serializable
{
   public StructSdtColProfesional_Servicios( )
   {
      this( -1, new ModelContext( StructSdtColProfesional_Servicios.class ));
   }

   public StructSdtColProfesional_Servicios( int remoteHandle ,
                                             ModelContext context )
   {
   }

   public  StructSdtColProfesional_Servicios( java.util.Vector<StructSdtProfesional_Servicios> value )
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

   @javax.xml.bind.annotation.XmlElement(name="Profesional.Servicios",namespace="ProjectThani")
   public java.util.Vector<StructSdtProfesional_Servicios> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtProfesional_Servicios> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtProfesional_Servicios> item = new java.util.Vector<>();
}

