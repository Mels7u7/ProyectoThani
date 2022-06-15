package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColProfesional", namespace ="ProjectThani")
public final  class StructSdtColProfesional implements Cloneable, java.io.Serializable
{
   public StructSdtColProfesional( )
   {
      this( -1, new ModelContext( StructSdtColProfesional.class ));
   }

   public StructSdtColProfesional( int remoteHandle ,
                                   ModelContext context )
   {
   }

   public  StructSdtColProfesional( java.util.Vector<StructSdtProfesional> value )
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

   @javax.xml.bind.annotation.XmlElement(name="Profesional",namespace="ProjectThani")
   public java.util.Vector<StructSdtProfesional> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtProfesional> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtProfesional> item = new java.util.Vector<>();
}

