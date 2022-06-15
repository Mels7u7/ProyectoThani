package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColProfesional.Premios", namespace ="ProjectThani")
public final  class StructSdtColProfesional_Premios implements Cloneable, java.io.Serializable
{
   public StructSdtColProfesional_Premios( )
   {
      this( -1, new ModelContext( StructSdtColProfesional_Premios.class ));
   }

   public StructSdtColProfesional_Premios( int remoteHandle ,
                                           ModelContext context )
   {
   }

   public  StructSdtColProfesional_Premios( java.util.Vector<StructSdtProfesional_Premios> value )
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

   @javax.xml.bind.annotation.XmlElement(name="Profesional.Premios",namespace="ProjectThani")
   public java.util.Vector<StructSdtProfesional_Premios> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtProfesional_Premios> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtProfesional_Premios> item = new java.util.Vector<>();
}

